/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.LastmodeHandler;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.StartupState$WaitForAudio;
import de.audi.atip.startup.StartupSyncer;
import java.util.ArrayList;
import java.util.List;

class StartupState {
    static final int LASTMODE_UNDEFINED;
    private static final String START_AUDIO_BEFORE_PHONE;
    private static final boolean START_AUDIO_BEFORE_PHONE_FLAG;
    private final LogChannel logStartup;
    private final StartupManager startup;
    private final LastmodeHandler lastmodeHandler;
    private volatile int lastmodeAudio = -1;
    private volatile int lastmodeApp = -1;
    private volatile int persistentLastmodeApp = -1;
    private volatile boolean audioStarted = false;
    private final List lastmodeAudioQueue = new ArrayList(10);
    private final List lastmodeAppQueue = new ArrayList(10);
    private final StartupSyncer syncAudio;
    private final int terminalID;
    private volatile boolean isLastmodeAudioReached = false;
    private volatile boolean isLastmodeAppReached = false;

    StartupState(LastmodeHandler lastmodeHandler, LogChannel logChannel, int n) {
        this.lastmodeHandler = lastmodeHandler;
        this.startup = lastmodeHandler.getStartupManager();
        this.logStartup = logChannel;
        this.terminalID = n > -1 ? n : -2;
        this.syncAudio = new StartupSyncer(this.startup, "AudioAvailable", this.startup.getAudioTimeout(), logChannel);
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    boolean isLastmodeAudioReached() {
        return this.isLastmodeAudioReached;
    }

    void setLastmodeAudioReached() {
        this.isLastmodeAudioReached = true;
    }

    boolean isLastmodeAppReached() {
        return this.isLastmodeAppReached;
    }

    void setLastmodeAppReached() {
        this.isLastmodeAppReached = true;
    }

    private boolean isLastmodeAudioStarted() {
        return this.audioStarted;
    }

    void setLastmodeAudioStarted(boolean bl) {
        this.audioStarted = bl;
    }

    int getLastmodeAudio() {
        return this.lastmodeAudio;
    }

    void setLastmodeAudio(int n) {
        this.lastmodeAudio = n;
    }

    StartupSyncer getSyncAudio() {
        return this.syncAudio;
    }

    void triggerFirstAudio() {
        this.logStartup.log(1078071040, "StartupState.triggerFirstAudio()");
        this.getSyncAudio().trigger();
    }

    int getLastmode() {
        return this.lastmodeApp;
    }

    int getPersistentLastmode() {
        return this.persistentLastmodeApp;
    }

    synchronized void initLastmode(int n) {
        if (this.lastmodeApp == -1) {
            this.setLastmode(n, false);
            this.persistentLastmodeApp = this.lastmodeApp;
        }
    }

    synchronized void setLastmode(int n, boolean bl) {
        ChoiceModelApp choiceModelApp = this.startup.getInitialApplication();
        if (choiceModelApp != null) {
            choiceModelApp.setValue(n);
        }
        if (this.lastmodeApp != n && this.lastmodeHandler.isValidLastmode(n)) {
            this.lastmodeApp = n;
            if (bl) {
                this.persistentLastmodeApp = n;
            }
            if (this.lastmodeHandler.isValidAudioLastmode(n)) {
                this.setLastmodeAudio(n);
                this.lastmodeHandler.setAudioFocusApp(this.terminalID, n, false);
            }
            if (bl && this.lastmodeHandler.isPersistentLastmode(n) && !this.startup.isRebootToDownload()) {
                this.lastmodeHandler.writePersistentLastMode();
            }
        }
    }

    List getLastmodeAudioQueue() {
        return this.lastmodeAudioQueue;
    }

    List getLastmodeAppQueue() {
        return this.lastmodeAppQueue;
    }

    private boolean checkLastmodeAudioStart() {
        boolean bl;
        if (this.logStartup.isDebug()) {
            this.logStartup.log(-2137614336, "StartupState.checkLastmodeAudioStart()");
            this.logStartup.log(-2137614336, "    startMediaBeforePhone: %1", START_AUDIO_BEFORE_PHONE_FLAG);
            this.logStartup.log(-2137614336, "    getLastmodeAudio(): %1", (long)this.getLastmodeAudio());
            this.logStartup.log(-2137614336, "    getLastmode(): %1", (long)this.getLastmode());
        }
        boolean bl2 = bl = START_AUDIO_BEFORE_PHONE_FLAG || this.getLastmode() != 4;
        if (!bl) {
            this.logStartup.log(-1601830656, "StartupState: skip start of Audio lastmode!");
        }
        return bl;
    }

    private boolean mustWaitForMU(int n) {
        return this.startup.getAppStateManager().mustWaitForMU(n);
    }

    protected void enqueueLastmodeAudio() {
        this.logStartup.log(-2137614336, "StartupState.enqueueLastmodeAudio()");
        this.getLastmodeAudioQueue().clear();
        ComponentState componentState = this.startup.getComponentState(this.getLastmodeAudio());
        if (componentState != null) {
            if (this.checkLastmodeAudioStart() && !this.mustWaitForMU(componentState.getDomainId())) {
                this.logStartup.log(-2137614336, "StartupState: enqueue start audio of %1", (Object)componentState.getComponentName());
                componentState.enqueueStartAudio(this.getLastmodeAudioQueue());
            }
            this.getSyncAudio().setupWait();
        }
        this.startup.enqueue(this.getLastmodeAudioQueue(), this.lastmodeHandler.getLastmodeAudioReached(this.getLastmodeAudio(), this.getTerminalID()));
    }

    protected void enqueueLastmodeApp() {
        this.enqueueLastmodeApp(false);
    }

    void enqueueLastmodeApp(boolean bl) {
        ComponentState componentState;
        this.logStartup.log(-2137614336, "StartupState.enqueueLastmodeApp( %1 )!", (Object)(bl ? "waitForAudio" : "do not wait for Audio"));
        this.getLastmodeAppQueue().clear();
        if (bl && this.isLastmodeAudioStarted()) {
            this.startup.enqueue(this.getLastmodeAppQueue(), new StartupState$WaitForAudio(this, null));
        }
        if (this.lastmodeHandler.isValidLastmode(this.getLastmode()) && (componentState = this.startup.getComponentState(this.getLastmode())) != null && !this.mustWaitForMU(componentState.getDomainId())) {
            this.logStartup.log(-2137614336, "StartupState: enqueue start of %1", (Object)componentState.getComponentName());
            componentState.enqueueStartLastmode(this.getLastmodeAppQueue());
            this.startup.enqueue(this.getLastmodeAppQueue(), this.lastmodeHandler.getLastmodeAppReached(this.getLastmode(), this.getTerminalID()));
        }
    }

    boolean activateLastmodeApp(int n) {
        this.logStartup.log(-1601830656, "StartupState: activateLastmodeApp(%1, %2)", (long)n, (long)this.terminalID);
        if (this.isLastmodeAppReached()) {
            this.logStartup.log(-1601830656, "StartupState: activateLastmodeApp(%1, %2) is called more than once!", (long)n, (long)this.terminalID);
            return false;
        }
        List list = this.getLastmodeAppQueue();
        if (!list.isEmpty()) {
            this.logStartup.log(-1601830656, "StartupState: cancel activateLastmodeApp due to another enqueued lastmode change!");
            return false;
        }
        this.setLastmode(n, false);
        this.setLastmodeAppReached();
        String string = this.startup.getAppStateManager().getComponentNameByLastmodeAppId(n);
        if (null == string) {
            string = Integer.toString(n);
        }
        this.startup.logStartupEvent(this.logStartup, 1078071040, new StringBuffer().append("StartupState#activatedLastmodeApp(").append(string).append(") - Lastmode application is active!").toString());
        return true;
    }

    public boolean activateLastmodeAudio(int n) {
        this.logStartup.log(-1601830656, "StartupState: activateLastmodeAudio(%1)", (long)n);
        if (this.isLastmodeAudioReached()) {
            this.logStartup.log(-1601830656, "StartupState: activateLastmodeAudio() is called more than once!");
            return false;
        }
        List list = this.getLastmodeAudioQueue();
        if (!list.isEmpty()) {
            this.logStartup.log(-1601830656, "StartupState: cancel activateLastmodeAudio due to another enqueued lastmode change!");
            return false;
        }
        this.lastmodeHandler.setAudioFocusApp(this.terminalID, n, true);
        this.setLastmodeAudioReached();
        String string = this.startup.getAppStateManager().getComponentNameByLastmodeAppId(n);
        if (null == string) {
            string = Integer.toString(n);
        }
        this.startup.logStartupEvent(this.logStartup, 1078071040, new StringBuffer().append("StartupState#activatedLastmodeAudio(").append(string).append(") - Lastmode Audio is active!").toString());
        return true;
    }

    static /* synthetic */ StartupManager access$100(StartupState startupState) {
        return startupState.startup;
    }

    static /* synthetic */ boolean access$200(StartupState startupState) {
        return startupState.isLastmodeAudioStarted();
    }

    static /* synthetic */ LogChannel access$300(StartupState startupState) {
        return startupState.logStartup;
    }

    static {
        START_AUDIO_BEFORE_PHONE_FLAG = Boolean.getBoolean("StartAudioBeforePhone");
    }
}

