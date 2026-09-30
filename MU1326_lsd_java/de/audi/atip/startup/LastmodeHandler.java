/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.start.ILastmodeStorage;
import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.ILastmodeHandlerExtended;
import de.audi.atip.startup.LastmodeStorage;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupState;
import de.audi.atip.startup.StartupSyncer;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Arrays;

public class LastmodeHandler
implements ILastmodeHandlerExtended,
IAudioFocusManager {
    protected static final int[] FRONT_MU_TERMINAL_IDS = new int[]{0};
    private static final int[] REAR_SEAT_TERMINAL_IDS = new int[]{3, 4, 5};
    private LastmodeStorage lastmodeStorage;
    private final StartupManager startupManager;
    private DispatcherBase startupChangeDispatcher = null;
    protected final LogChannel logChannel;
    protected final StartupState[] startupTerminalStates;
    protected final int[] availableTerminalIDs;
    private IAudioFocusClient[] clients = new IAudioFocusClient[0];
    private int[] audioFocusApps = new int[8];
    private boolean isAudioManagementInitialized = false;
    private final Object mutexClientTracking = new Object();
    public LogChannel lcAudioDSI;
    private HMIAudioService audioService;
    private final int terminalID;

    LastmodeHandler(StartupManager startupManager, LogChannel logChannel) {
        this.startupManager = startupManager;
        this.logChannel = logChannel;
        this.availableTerminalIDs = startupManager.getFramework().isFrontMU() ? FRONT_MU_TERMINAL_IDS : REAR_SEAT_TERMINAL_IDS;
        this.startupTerminalStates = new StartupState[8];
        this.lcAudioDSI = startupManager.getFramework().getLogChannel("Fw.Audio.DSI");
        Arrays.fill(this.audioFocusApps, 0);
        this.terminalID = this.getStartupManager().getFramework().isFrontMU() ? 0 : 5;
    }

    public void start() {
        this.startupChangeDispatcher = this.getStartupManager().getFramework().getDispatcherManager().createDispatcher("StartupChange", new JobLogger(this.logChannel));
    }

    public void stop() {
        this.startupChangeDispatcher.stop();
        this.getStartupManager().getFramework().getDispatcherManager().destroyDispatcher(this.startupChangeDispatcher.getDispatcherName());
    }

    private StartupState getStartupTerminalState(int n) {
        if (n < this.availableTerminalIDs.length) {
            if (-2 == n || -1 == n) {
                n = this.availableTerminalIDs[0];
                this.logChannel.log(100000, "LastmodeHandler.getStartupState(UNDEFUNED | ALL), the terminal %1 will be used", (long)this.availableTerminalIDs[0]);
            }
            if (this.startupTerminalStates[n] == null) {
                this.startupTerminalStates[n] = new StartupState(this, this.logChannel, n);
            }
            return this.startupTerminalStates[n];
        }
        this.logChannel.log(10000, "Incorrect terminal ID: %1, terminal ID %2 will be used...", (long)n, (long)this.availableTerminalIDs[0]);
        return this.getStartupTerminalState(this.availableTerminalIDs[0]);
    }

    StartupManager getStartupManager() {
        return this.startupManager;
    }

    DispatcherBase getStartupChangeDispatcher() {
        return this.startupChangeDispatcher;
    }

    public void initLastmodeStorage(boolean bl) {
        this.lastmodeStorage = new LastmodeStorage(this.getStartupManager().getFwServices(), this.logChannel, bl);
    }

    public ILastmodeStorage getLastmodeStorage() {
        return this.lastmodeStorage;
    }

    public void initQueues() {
        this.enqueueLastmodeAudio(-1);
        this.enqueueLastmodeApp(-1);
    }

    public int getLastmode(int n) {
        return this.getStartupTerminalState(n).getLastmode();
    }

    public int getPersistentLastmode(int n) {
        return this.getStartupTerminalState(n).getPersistentLastmode();
    }

    public synchronized int getLastmodeAudio(int n) {
        return this.getStartupTerminalState(n).getLastmodeAudio();
    }

    public boolean isValidLastmode(int n) {
        return this.startupManager.getAppStateManager().isLastmodeApplication(n);
    }

    private boolean isEntertainmentLastMode(int n) {
        return n == 45;
    }

    public boolean isValidLastmode(KeyEvent keyEvent) {
        return this.isValidLastmode(this.startupManager.getAppStateManager().convertKeyToLastmode(keyEvent.getKeyCode()));
    }

    boolean isPersistentLastmode(int n) {
        return !this.isLastmodeTransient(n);
    }

    public boolean isValidAudioLastmode(int n) {
        return this.startupManager.getAppStateManager().isLastmodeAudioApplication(n) || n == 1 || n == 2;
    }

    public boolean isLastmodeAudioReached(int n) {
        return this.getStartupTerminalState(n).isLastmodeAudioReached();
    }

    public void restoreLastmode() {
        this.logChannel.log(1000000, "LastmodeHandler.restoreLastmode()");
        this.getStartupManager().setNavEnabled(this.lastmodeStorage.isNavEnabled(), false);
        this.logChannel.log(1000000, "LastmodeStorage: read from persistence: Lastmode=%1, Lastmode Audio=%2", (long)this.lastmodeStorage.getLastmode(), (long)this.lastmodeStorage.getLastmodeAudio());
        LastmodeData lastmodeData = this.checkAndRepairLastMode(this.lastmodeStorage.getLastmode(), this.lastmodeStorage.getLastmodeAudio());
        this.initLastmode(this.terminalID, lastmodeData.getLastMode());
        this.setLastmodeAudio(this.terminalID, lastmodeData.getLastModeAudio());
        this.logChannel.log(1000000, "LastmodeStorage: correted lastmode: Lastmode=%1, Lastmode Audio=%2", (long)lastmodeData.getLastMode(), (long)lastmodeData.getLastModeAudio());
        this.startupChangeDispatcher.start();
    }

    public void storeNavEnabled(boolean bl) {
        this.lastmodeStorage.setNavEnabled(bl);
        this.writePersistentLastMode();
    }

    public void initPersistentData() {
        this.lastmodeStorage.initPersistentData();
    }

    public void writePersistentLastMode() {
        if (this.lastmodeStorage != null) {
            LastmodeData lastmodeData = this.checkAndRepairLastMode(this.getPersistentLastmode(this.terminalID), this.getLastmodeAudio(this.terminalID));
            this.lastmodeStorage.setLastmode(lastmodeData.getLastMode());
            this.lastmodeStorage.setLastmodeAudio(lastmodeData.getLastModeAudio());
            this.lastmodeStorage.serializeAndWrite();
        } else {
            this.logChannel.log(1000000, "LastmodeHandler.writePersistentLastMode(): the persistence is not yet available!");
        }
    }

    private void enqueueLastmodeApp(int n, boolean bl) {
        this.getStartupTerminalState(n).enqueueLastmodeApp(bl);
    }

    public void initLastmodeAudioQueues() {
        for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
            this.startupManager.getStartupQueue().addQueue(this.getStartupTerminalState(this.availableTerminalIDs[i2]).getLastmodeAudioQueue(), new StringBuffer().append("Lastmode Audio, Terminal: ").append(this.availableTerminalIDs[i2]).toString());
        }
    }

    public void initLastmodeAppQueues() {
        for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
            this.startupManager.getStartupQueue().addQueue(this.getStartupTerminalState(this.availableTerminalIDs[i2]).getLastmodeAppQueue(), new StringBuffer().append("Lastmode App, Terminal: ").append(this.availableTerminalIDs[i2]).toString());
        }
    }

    private StartupSyncer getSyncAudio(int n) {
        return this.getStartupTerminalState(n).getSyncAudio();
    }

    private boolean isLastmodeAppReached(int n) {
        return this.getStartupTerminalState(n).isLastmodeAppReached();
    }

    void initLastmode(int n, int n2) {
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#initLastmode(").append(n).append(", ").append(n2).append(")").toString());
        this.getStartupTerminalState(n).initLastmode(n2);
    }

    public void triggerFirstAudio(int n) {
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#triggerFirstAudio(").append(n).append(")").toString());
        this.getStartupTerminalState(n).triggerFirstAudio();
    }

    private boolean isLastmodeTransient(int n) {
        ComponentState componentState = this.startupManager.getAppStateManager().getComponentState(n);
        if (componentState != null) {
            return componentState.isLastmodeTransient();
        }
        return false;
    }

    public void setLastmode(int n, int n2, boolean bl) {
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#setLastmode(").append(n).append(", ").append(n2).append(" ,").append(bl).append(")").toString());
        this.getStartupTerminalState(n).setLastmode(n2, bl && !this.isLastmodeTransient(n2));
    }

    public void setLastmodeForAllTerminals(boolean bl) {
        this.setLastmodeForAllTerminals(this.getLastmode(-2), bl);
    }

    private void setLastmodeForAllTerminals(int n, boolean bl) {
        for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
            this.setLastmode(this.availableTerminalIDs[i2], n, bl);
        }
    }

    public synchronized void setLastmodeAudio(int n, int n2) {
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#setLastmodeAudio(").append(n).append(", ").append(n2).append(")").toString());
        if (n == -1) {
            for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
                this.setLastmodeAudio(this.availableTerminalIDs[i2], n2);
            }
        } else if (this.isAudioManagementInitialized) {
            this.setAudioFocusApp(n, n2, true);
        } else {
            this.getStartupTerminalState(n).setLastmodeAudio(n2);
        }
    }

    public void setLastmodeAudioStarted(int n, boolean bl) {
        if (n == -1) {
            for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
                this.getStartupTerminalState(this.availableTerminalIDs[i2]).setLastmodeAudioStarted(bl);
            }
        } else {
            this.getStartupTerminalState(n).setLastmodeAudioStarted(bl);
        }
    }

    private void enqueueLastmodeAudio(int n) {
        if (n == -1) {
            for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
                this.getStartupTerminalState(this.availableTerminalIDs[i2]).enqueueLastmodeAudio();
            }
        } else {
            this.getStartupTerminalState(n).enqueueLastmodeAudio();
        }
    }

    private void enqueueLastmodeApp(int n) {
        if (n == -1) {
            for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
                this.getStartupTerminalState(this.availableTerminalIDs[i2]).enqueueLastmodeApp();
            }
        } else {
            this.getStartupTerminalState(n).enqueueLastmodeApp();
        }
    }

    public boolean activateLastmodeApp(int n, int n2) {
        if (n2 == -1 || n2 == -2) {
            this.logChannel.log(10000, "LastmodeHandler:activateLastmodeApp(%1, %2) - terminalID must not be ALL or UNDEFINED!", (long)n, (long)n2);
            return false;
        }
        this.startupManager.logStartupEvent(this.logChannel, 100000, new StringBuffer().append("LastmodeHandler#activateLastmodeApp(").append(n).append(", ").append(n2).append(")").toString());
        return this.getStartupTerminalState(n2).activateLastmodeApp(n);
    }

    public boolean checkLastmodeChange(KeyEvent keyEvent) {
        boolean bl = false;
        int n = keyEvent.getTerminalID();
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#checkLastmodeChange(").append(keyEvent).append(")").toString());
        if (this.startupManager.isRebootToDownload()) {
            this.startupManager.logStartupEvent(this.logChannel, 1000000, "LastmodeHandler#checkLastmodeChange() - SWDL is active, ignore lastmode change!");
            return false;
        }
        int n2 = this.startupManager.getAppStateManager().convertKeyToLastmode(keyEvent.getKeyCode());
        int n3 = this.getLastmode(n);
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#checkLastmodeChange() - Lastmode changed to ").append(n2).toString());
        if (n3 != n2) {
            if (!this.isLastmodeAudioReached(n)) {
                bl = false;
            } else if (!this.isLastmodeAppReached(n)) {
                this.logChannel.log(1000000, "LastmodeHandler: lastmode app changed to %1, before %2 was completely restored!", (long)n2, (long)this.getLastmode(n));
                bl = this.startupManager.isSMRunning();
            } else {
                this.logChannel.log(1000000, "LastmodeHandler: change to %1, after %2 was restored!", (long)n2, (long)n3);
                bl = true;
            }
            this.enqueueLastmodeChange(n, n2);
        } else {
            this.logChannel.log(1000000, "LastmodeHandler: skip enqueueLastModeChange, because the Lastmode is the same!");
            bl = true;
        }
        return bl;
    }

    public void enqueueLastmodeChange(final int n, final int n2) {
        this.startupManager.logStartupEvent(this.logChannel, 1000000, new StringBuffer().append("LastmodeHandler#enqueueLastmodeChange(").append(n).append(", ").append(n2).append(")").toString());
        if (this.startupManager.isRebootToDownload()) {
            this.logChannel.log(1000000, "LastmodeHandler: ignore lastmode change when SWDL is active!");
            return;
        }
        this.startupChangeDispatcher.execute(new Runnable(){

            public String toString() {
                Buffer buffer = new Buffer(32);
                buffer.append("enqueueLastmodeChange(").append(n2).append(')');
                return buffer.toString();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void run() {
                int n4 = n2;
                if (LastmodeHandler.this.isEntertainmentLastMode(n2)) {
                    LastmodeHandler.this.logChannel.log(1000000, "LastmodeHandler: process ENTERTAINMENT lastmode");
                    n4 = LastmodeHandler.this.getLastmodeAudio(n);
                    if (-1 == n4) {
                        LastmodeHandler.this.logChannel.log(10000, "LastmodeHandler#enqueueLastmodeChange: the last mode audio isn't defined yet!");
                        n4 = 1;
                    }
                }
                if (LastmodeHandler.this.isValidLastmode(n4)) {
                    try {
                        LastmodeHandler.this.logChannel.log(10000000, "LastmodeHandler: freezeQueues! ");
                        LastmodeHandler.this.startupManager.getStartupDispatcher().suspend();
                        if (LastmodeHandler.this.getLastmode(n) != n4) {
                            int n22 = LastmodeHandler.this.getLastmodeAudio(n);
                            if (!LastmodeHandler.this.isLastmodeAudioReached(n)) {
                                if (LastmodeHandler.this.isValidAudioLastmode(n4) && n4 != n22) {
                                    LastmodeHandler.this.logChannel.log(1000000, "LastmodeHandler: lastmode audio changed to %1, before %2 was completely restored!", (long)n4, (long)n22);
                                    LastmodeHandler.this.setLastmodeAudio(n, n4);
                                    LastmodeHandler.this.enqueueLastmodeAudio(n);
                                }
                                LastmodeHandler.this.setLastmode(n, n4, true);
                                LastmodeHandler.this.enqueueLastmodeApp(n);
                                return;
                            }
                            if (!LastmodeHandler.this.isLastmodeAppReached(n)) {
                                boolean bl;
                                LastmodeHandler.this.logChannel.log(1000000, "LastmodeHandler: lastmode app changed to %1, before %2 was completely restored!", (long)n4, (long)LastmodeHandler.this.getLastmode(n));
                                LastmodeHandler.this.setLastmode(n, n4, true);
                                boolean bl2 = bl = n22 != LastmodeHandler.this.getLastmodeAudio(n);
                                if (bl) {
                                    LastmodeHandler.this.requestEntertainmentMute(n);
                                }
                                LastmodeHandler.this.getSyncAudio(n).cancel();
                                LastmodeHandler.this.enqueueLastmodeApp(n, false);
                                LastmodeHandler.this.startupManager.getSyncNav().cancel();
                                LastmodeHandler.this.startupManager.getSyncSDS().cancel();
                                LastmodeHandler.this.logChannel.log(1000000, "LastmodeHandler: lastmode app change enqueued!");
                                return;
                            }
                            LastmodeHandler.this.logChannel.log(1000000, "LastmodeHandler: change to %1, after %2 was restored!", (long)n4, (long)LastmodeHandler.this.getLastmode(n));
                            LastmodeHandler.this.setLastmode(n, n4, true);
                            ComponentState componentState = LastmodeHandler.this.startupManager.getComponentState(n4);
                            if (componentState == null || componentState.isStarted() || LastmodeHandler.this.startupManager.getAppStateManager().mustWaitForMU(componentState.getDomainId())) return;
                            int n3 = n;
                            if (n == -1) {
                                n3 = LastmodeHandler.this.availableTerminalIDs[0];
                            }
                            if (n22 != n4 && LastmodeHandler.this.isValidAudioLastmode(n4)) {
                                LastmodeHandler.this.requestEntertainmentMute(n3);
                            }
                            componentState.enqueueStartFull(LastmodeHandler.this.getStartupTerminalState(n3).getLastmodeAppQueue(), true);
                            LastmodeHandler.this.startupManager.getSyncNav().cancel();
                            LastmodeHandler.this.startupManager.getSyncSDS().cancel();
                            return;
                        }
                        LastmodeHandler.this.logChannel.log(1000000, "LastmodeHandler: skip enqueueLastModeChange, because the Lastmode is the same!");
                        return;
                    }
                    finally {
                        LastmodeHandler.this.startupManager.getStartupDispatcher().resume();
                        LastmodeHandler.this.logChannel.log(10000000, "LastmodeHandler: unfreezeQueues! ");
                    }
                } else {
                    LastmodeHandler.this.logChannel.log(10000, "LastmodeHandler.enqueueLastmodeChange(): %1 is not a valid LastMode!", (long)n4);
                }
            }
        });
    }

    private void requestEntertainmentMute(int n) {
        if (this.isAudioManagementInitialized) {
            this.logChannel.log(1000000, "LastmodeHandler.requestMute(%1): request MUTE of entertainment audio", (long)n);
            this.audioService.requestConnection(9, n);
        } else {
            this.logChannel.log(1000000, "LastmodeHandler.requestMute(%1): the MUTE action is not avaliable because the audio management is not initialized", (long)n);
        }
    }

    public boolean activateLastmodeAudio(int n, int n2) {
        this.logChannel.log(100000, "LastmodeHandler: activateLastmodeAudio(%1)", (long)n);
        if (n2 == -1 || n2 == -2) {
            this.logChannel.log(10000, "activateLastmodeAudio(%1, %2) - terminalID must not be ALL or UNDEFINED!", (long)n, (long)n2);
            return false;
        }
        return this.getStartupTerminalState(n2).activateLastmodeAudio(n);
    }

    Runnable getLastmodeAudioReached(int n, int n2) {
        return new LastmodeAudioReached(n, n2);
    }

    Runnable getLastmodeAppReached(int n, int n2) {
        return new LastmodeAppReached(n, n2);
    }

    synchronized void setAudioFocusApp(int n, int n2, boolean bl) {
        if (this.isAudioManagementInitialized) {
            if (this.isValidAudioLastmode(n2) && !this.startupManager.isRebootToDownload()) {
                this.logChannel.log(1000000, "LastmodeHandler: set audio focus( terminalId %1, appId %2 )", (long)n, (long)n2);
                this.distributeActiveAudioApp(n, n2);
                this.getStartupTerminalState(n).setLastmodeAudio(n2);
                if (bl && n == (this.startupManager.getFramework().isFrontMU() ? 0 : 5)) {
                    this.writePersistentLastMode();
                }
            } else if (2 == n) {
                this.distributeActiveAudioApp(n, n2);
            }
        } else {
            this.logChannel.log(100000, "LastmodeHandler: skip set audio focus( terminalId %1, appId %2 ), AudioFocusManager not available!", (long)n, (long)n2);
        }
    }

    private LastmodeData checkAndRepairLastMode(int n, int n2) {
        this.logChannel.log(10000000, "LastmodeHandler::checkAndRepairLastMode(lastMode:%1,lastModeAudio:%2)", (long)n, (long)n2);
        int n3 = n;
        int n4 = n2;
        if (!this.isValidLastmode(n)) {
            n = 1;
            this.logChannel.log(10000, "LastmodeHandler::checkAndRepairLastMode(lastMode:%1,lastModeAudio:%2):lastMode is not valid lastmode! Use default %3", (Object)new Integer(n3), (Object)new Integer(n4), (Object)new Integer(n), (Object)new Exception("ShowCallStack"));
        }
        if (!this.isValidAudioLastmode(n2)) {
            n2 = 1;
            this.logChannel.log(10000, "LastmodeHandler::checkAndRepairLastMode(lastMode:%1,lastModeAudio:%2):lastModeAudio is not valid audio lastmode! Use default %3", (Object)new Integer(n3), (Object)new Integer(n4), (Object)new Integer(n2), (Object)new Exception("ShowCallStack"));
        }
        if (this.isValidAudioLastmode(n) && n != n2) {
            n2 = n;
            this.logChannel.log(10000, "LastmodeHandler::checkAndRepairLastMode(lastMode:%1,lastModeAudio:%2):lastmode and lasmodeAudio are inconsistent! Use %3 as the audio lastmode", (Object)new Integer(n3), (Object)new Integer(n4), (Object)new Integer(n2), (Object)new Exception("ShowCallStack"));
        }
        return new LastmodeData(n, n2);
    }

    public void setHMIAudioService(HMIAudioService hMIAudioService) {
        this.audioService = hMIAudioService;
    }

    public void initAudioFocusManagement() {
        this.isAudioManagementInitialized = true;
        for (int i2 = 0; i2 < this.availableTerminalIDs.length; ++i2) {
            this.setAudioFocusApp(this.availableTerminalIDs[i2], this.getLastmodeAudio(this.availableTerminalIDs[i2]), false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerAudioClient(IAudioFocusClient iAudioFocusClient) {
        this.lcAudioDSI.log(1000000, "[AudioFocusManager.register] %1", (Object)iAudioFocusClient);
        final IAudioFocusClient iAudioFocusClient2 = iAudioFocusClient;
        if (iAudioFocusClient == null) {
            return;
        }
        final int[] nArray = new int[8];
        Object object = this.mutexClientTracking;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.clients));
            arrayList.add(iAudioFocusClient);
            this.clients = (IAudioFocusClient[])arrayList.toArray(new IAudioFocusClient[arrayList.size()]);
            System.arraycopy((Object)this.audioFocusApps, 0, (Object)nArray, 0, this.audioFocusApps.length);
            this.getStartupManager().postRunnableEvent(new RunnableEvent(true, new Runnable(){
                int activeAudioAppOnTerminal;
                int terminalId;

                public void run() {
                    try {
                        for (int i2 = 0; i2 < 8; ++i2) {
                            this.terminalId = i2;
                            this.activeAudioAppOnTerminal = nArray[i2];
                            if (this.activeAudioAppOnTerminal == 0) continue;
                            iAudioFocusClient2.updateAudioFocus(i2, this.activeAudioAppOnTerminal);
                        }
                    }
                    catch (Exception exception) {
                        LastmodeHandler.this.lcAudioDSI.log(10000, "[LastmodeHandler.registerAudioClient] appId:%1 Failed calling  on terminal %2", (long)this.activeAudioAppOnTerminal, (long)this.terminalId);
                        LastmodeHandler.this.lcAudioDSI.log(10000, "[LastmodeHandler.registerAudioClient]", (Throwable)exception);
                    }
                }

                public String toString() {
                    return new Buffer("UpdateAudioFocusRunnable:").append(" terminalID=").append(this.terminalId).append(" appId=").append(this.activeAudioAppOnTerminal).append(')').toString();
                }
            }));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deregisterAudioClient(IAudioFocusClient iAudioFocusClient) {
        this.lcAudioDSI.log(1000000, "[AudioFocusManager.deregister] %1", (Object)iAudioFocusClient);
        if (iAudioFocusClient == null) {
            return;
        }
        Object object = this.mutexClientTracking;
        synchronized (object) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.clients));
            arrayList.remove(iAudioFocusClient);
            this.clients = (IAudioFocusClient[])arrayList.toArray(new IAudioFocusClient[arrayList.size()]);
        }
    }

    public void setActiveAudioApp(int n, int n2) {
        this.setLastmodeAudio(n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void distributeActiveAudioApp(final int n, final int n2) {
        this.lcAudioDSI.log(10000000, "[LastmodeHandler.setActiveAudioApp] appId=%1 terminal=%2", (long)n2, (long)n);
        if (n >= 0 && n < 8) {
            Object object = this.mutexClientTracking;
            synchronized (object) {
                if (this.audioFocusApps[n] == n2) {
                    this.lcAudioDSI.log(10000000, "[LastmodeHandler.setActiveAudioApp] appId=%1 already has audio focus, ignore!", (long)n2);
                    return;
                }
                final IAudioFocusClient[] iAudioFocusClientArray = new IAudioFocusClient[this.clients.length];
                System.arraycopy((Object)this.clients, 0, (Object)iAudioFocusClientArray, 0, this.clients.length);
                this.audioFocusApps[n] = n2;
                if (n == 0) {
                    ComponentState componentState = this.startupManager.getAppStateManager().getComponentState(n2);
                    int n3 = 0;
                    if (componentState != null && (n3 = componentState.getAudioContextID()) < 0) {
                        n3 = 0;
                        this.lcAudioDSI.log(10000, "[LastmodeHandler.setActiveAudioApp] audio context constant is not defined for application '%1'!", (Object)(componentState != null ? componentState.getComponentName() : Integer.toString(n2)));
                    }
                    this.startupManager.getFramework().getHMIService().getChoiceModel(n, 11).setValue(n3);
                }
                this.getStartupManager().postRunnableEvent(new RunnableEvent(true, new Runnable(){

                    public void run() {
                        for (int i2 = 0; i2 < iAudioFocusClientArray.length; ++i2) {
                            try {
                                LastmodeHandler.this.lcAudioDSI.log(10000000, "[LastmodeHandler.setActiveAudioApp] update audio focus of %1 on terminal %2", (Object)iAudioFocusClientArray[i2], (long)n);
                                iAudioFocusClientArray[i2].updateAudioFocus(n, n2);
                                continue;
                            }
                            catch (Exception exception) {
                                LastmodeHandler.this.lcAudioDSI.log(10000, "[LastmodeHandler.setActiveAudioApp] appId:%2 Failed calling %1 on terminal %3", (Object)iAudioFocusClientArray[i2], (long)n2, (long)n);
                                LastmodeHandler.this.lcAudioDSI.log(10000, "[LastmodeHandler.setActiveAudioApp]", (Throwable)exception);
                            }
                        }
                    }

                    public String toString() {
                        return new Buffer("UpdateAudioFocusRunnable:").append(" terminalID=").append(n).append(" appId=").append(n2).append(')').toString();
                    }
                }));
            }
        } else {
            this.lcAudioDSI.log(10000, "[LastmodeHandler.setActiveAudioApp] unsupported terminalID: %1", (long)n);
        }
    }

    class LastmodeData {
        private int lastMode;
        private int lastModeAudio;

        public LastmodeData(int n, int n2) {
            this.lastMode = n;
            this.lastModeAudio = n2;
        }

        public int getLastMode() {
            return this.lastMode;
        }

        public int getLastModeAudio() {
            return this.lastModeAudio;
        }
    }

    private class LastmodeAppReached
    implements Runnable {
        private final int lmApp;
        private final int terminalID;

        private LastmodeAppReached(int n, int n2) {
            this.lmApp = n;
            this.terminalID = n2;
        }

        public final String toString() {
            return new Buffer(50).append("LastmodeAppReached: lastmode: ").append(this.lmApp).toString();
        }

        public final void run() {
            if (LastmodeHandler.this.activateLastmodeApp(this.lmApp, this.terminalID)) {
                LastmodeHandler.this.startupManager.logStartupEvent(LastmodeHandler.this.logChannel, 1000000, new StringBuffer().append("LastmodeAppReached#run(").append(this.lmApp).append(", ").append(this.terminalID).append(") - Lastmode App is active!").toString());
                LastmodeHandler.this.startupManager.switchToBackgroundPriority();
            }
        }
    }

    private class LastmodeAudioReached
    implements Runnable {
        private final int lmAudio;
        private final int terminalID;

        public final String toString() {
            return new StringBuffer().append("LastmodeAudioReached: lastmodeAudio: ").append(this.lmAudio).toString();
        }

        private LastmodeAudioReached(int n, int n2) {
            this.lmAudio = n;
            this.terminalID = n2;
        }

        public final void run() {
            LastmodeHandler.this.activateLastmodeAudio(this.lmAudio, this.terminalID);
        }
    }
}

