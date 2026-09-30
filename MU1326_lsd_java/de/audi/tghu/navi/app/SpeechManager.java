/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.interapp.audio.IAnnouncementStateListener;
import de.audi.atip.interapp.audio.IAnnouncementStateService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGSetRouteGuidanceMode;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class SpeechManager
implements ChoiceListener,
ButtonListener,
IAnnouncementStateService {
    private final NavigationEnv env;
    private final FunctionCounter fc;
    private final ICommandListFactory commandListFactory;
    private LogChannel logChannel;
    private GuidanceModeSettingsListener settingsListener;
    private List announcementStateListenerList;
    private static final int GUIDANCE_MODE_INIT = -1;
    public static final int GUIDANCE_SPEECH_MODE_COMPLETE = 0;
    public static final int GUIDANCE_SPEECH_MODE_COMPACT = 1;
    public static final int GUIDANCE_SPEECH_MODE_TRAFFIC = 2;
    public static final int GUIDANCE_SPEECH_MODE_OFF = 3;
    private static final int HIDE_SPEECH_MODE_TRAFFIC = 11;
    private int lastmode = -1;

    public SpeechManager(NavigationEnv navigationEnv, FunctionCounter functionCounter, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.fc = functionCounter;
        this.commandListFactory = iCommandListFactory;
        this.logChannel = navigationEnv.getLogChannel();
        this.logChannel.log(10000000, "SpeechManager#SetupListener() ");
        this.announcementStateListenerList = new LinkedList();
        this.setListeners();
    }

    public static boolean isAnnouncementOnCallValid(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    public static boolean isGuidanceModeValid(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    public static int getDefaultAnnouncementOnCall() {
        return 0;
    }

    public static int getDefaultGuidanceMode() {
        return 1;
    }

    private void setListeners() {
        this.env.getChoiceModel(555).setChoiceListener(this);
        if (!Util.isTrafficPresent(this.env.getFramework()) || Util.isHURegionAsia()) {
            this.env.getChoiceModel(555).addHint(11);
        }
        this.env.getChoiceModel(3829).setChoiceListener(this);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.itemSelected(n, n2, n3, n4, true);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelected(int n, int n2, int n3, int n4, boolean bl) {
        this.logChannel.log(10000000, "SpeechManager#itemSelected( %1, %2 ) ", (long)n, (long)n2);
        CommandList commandList = null;
        switch (n) {
            case 555: {
                this.fc.incCounter(25);
                this.env.getChoiceModel(555).setValue(n2);
                if (bl) {
                    this.saveState();
                }
                int n5 = this.getGuidanceMode();
                commandList = this.buildGuidanceModeCommandList(n5);
                commandList.execute("SpeechManager.itemSelected.NAVI_TONE_ANNOUNCEMENT_SETUP_CHOICE");
                break;
            }
            case 3829: {
                this.env.getChoiceModel(3829).setValue(n2);
                if (!bl) break;
                this.saveState();
                break;
            }
            default: {
                this.logChannel.log(10000, "SpeechManager#itemSelected() - unknown model id: %1! ", (long)n);
            }
        }
    }

    public boolean toggleGuidanceMode() {
        int n;
        this.logChannel.log(10000000, "SpeechManager#toggleGuidanceMode()");
        int n2 = this.getGuidanceMode();
        if (n2 == 3) {
            n = this.lastmode != 3 && this.lastmode != -1 ? this.lastmode : 1;
        } else {
            n = 3;
            this.lastmode = n2;
        }
        this.logChannel.log(10000000, "SpeechManager#toggleGuidanceMode() - %1 -> %2", (long)n2, (long)n);
        this.setGuidanceMode(n, true);
        CommandList commandList = this.buildGuidanceModeCommandList(n);
        commandList.execute("SpeechManager#toggleGuidanceMode");
        return n != 3;
    }

    public void setGuidanceMode(int n, boolean bl) {
        this.env.getLogChannel().log(10000000, "SpeechManager#setGuidanceMode( %1 ) ", (long)n);
        int n2 = this.env.getChoiceModel(555).getValue();
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 0: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            default: {
                this.env.getLogChannel().log(10000000, "SpeechManager#setGuidanceMode() - guidance mode %1 not supported for high ", (long)n);
            }
        }
        this.env.getChoiceModel(555).setValue(n2);
        if (bl) {
            this.saveState();
        }
    }

    public void addAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener) {
        if (!this.announcementStateListenerList.contains(iAnnouncementStateListener)) {
            this.announcementStateListenerList.add(iAnnouncementStateListener);
        }
    }

    public void removeAnnouncementStateListener(IAnnouncementStateListener iAnnouncementStateListener) {
        if (this.announcementStateListenerList.contains(iAnnouncementStateListener)) {
            this.announcementStateListenerList.remove(iAnnouncementStateListener);
        }
    }

    public int getGuidanceMode() {
        int n;
        int n2 = this.env.getChoiceModel(555).getValue();
        switch (n2) {
            case 0: {
                n = 1;
                break;
            }
            case 1: {
                n = 0;
                break;
            }
            case 2: {
                n = 2;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    public boolean announcementOnCall() {
        return this.env.getChoiceModel(3829).getValue() == 0;
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void resetSettings() {
        int n = this.env.getFramework().isFrontMU() ? 0 : 5;
        int n2 = SpeechManager.getDefaultGuidanceMode();
        this.setGuidanceMode(n2, false);
        this.lastmode = n2;
        CommandList commandList = this.buildGuidanceModeCommandList(n2);
        commandList.execute("SpeechManager#resetSettings");
        if (Util.isPorsche(this.env.getFramework())) {
            this.itemSelected(3829, 1, 0, n, false);
        } else {
            this.itemSelected(3829, SpeechManager.getDefaultAnnouncementOnCall(), 0, n, false);
        }
        this.saveState();
    }

    void saveState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.setGuidanceMode(this.getGuidanceMode());
            state.setAnnouncementOnCall(this.env.getChoiceModel(3829).getValue());
            state.setGuidanceLastMode(this.lastmode);
            state.serializeAndWrite();
        } else {
            this.logChannel.log(10000, "Setup#saveState() - no storage manager available!!! ");
        }
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            State state = new State(iStorageAccess, this.logChannel);
            state.readAndDeserialize();
            int n = state.getGuidanceMode();
            int n2 = state.getGuidanceLastMode();
            int n3 = state.getAnnouncementOnCall();
            if (!SpeechManager.isGuidanceModeValid(n)) {
                n = SpeechManager.getDefaultGuidanceMode();
            }
            if (!SpeechManager.isGuidanceModeValid(n2)) {
                n2 = SpeechManager.getDefaultGuidanceMode();
            }
            if (!SpeechManager.isAnnouncementOnCallValid(n3)) {
                n3 = SpeechManager.getDefaultAnnouncementOnCall();
            }
            if (!Util.isTrafficPresent(this.env.getFramework()) || Util.isHURegionAsia()) {
                if (n == 2) {
                    n = SpeechManager.getDefaultGuidanceMode();
                }
                if (n2 == 2) {
                    n2 = SpeechManager.getDefaultGuidanceMode();
                }
            }
            this.setGuidanceMode(n, false);
            this.env.getChoiceModel(3829).setValue(n3);
            this.lastmode = n2;
        } else {
            this.logChannel.log(10000, "Setup#loadState() - no storage manager available!!! ");
        }
    }

    public void triggerStorageFlush(boolean bl) {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (bl) {
            iStorageAccess.enterSetupScreen();
        } else {
            iStorageAccess.exitSetupScreen();
        }
    }

    public void registerSettingsListener(GuidanceModeSettingsListener guidanceModeSettingsListener) {
        if (this.settingsListener != null) {
            this.logChannel.log(10000, "SpeechManager#registerSettingsListener() - listener already registered, will be overwritten!");
        }
        this.settingsListener = guidanceModeSettingsListener;
    }

    public CommandList buildGuidanceModeCommandList(final int n) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RGSetRouteGuidanceMode(n));
        commandList.add(new NavCommand("notifyGuidanceModeListener"){

            public void execute() {
                this.logger.log(10000000, "SpeechManager#notifyListener( %1 )", (long)n);
                if (SpeechManager.this.settingsListener != null) {
                    SpeechManager.this.settingsListener.updateGuidanceMode(n);
                }
                if (SpeechManager.this.announcementStateListenerList.size() != 0) {
                    int n2 = 20;
                    switch (n) {
                        case 1: {
                            n2 = 20;
                            break;
                        }
                        case 0: {
                            n2 = 21;
                            break;
                        }
                        case 2: {
                            n2 = 22;
                            break;
                        }
                        case 3: {
                            n2 = 23;
                            break;
                        }
                        default: {
                            n2 = 20;
                        }
                    }
                    for (int i2 = 0; i2 < SpeechManager.this.announcementStateListenerList.size(); ++i2) {
                        IAnnouncementStateListener iAnnouncementStateListener = (IAnnouncementStateListener)SpeechManager.this.announcementStateListenerList.get(i2);
                        iAnnouncementStateListener.updateAnnouncementState(n2, 1);
                    }
                }
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void setAnnouncementState(int n) {
        this.logChannel.log(10000, "SpeechManager#setAnnouncementState(%1)", (long)n);
        int n2 = -1;
        switch (n) {
            case 20: {
                n2 = 1;
                break;
            }
            case 21: {
                n2 = 0;
                break;
            }
            case 22: {
                n2 = 2;
                break;
            }
            case 23: {
                n2 = 3;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        if (n2 != -1) {
            this.setGuidanceMode(n2, true);
            CommandList commandList = this.buildGuidanceModeCommandList(n2);
            commandList.execute("SpeechManager.setAnnouncementState.NAVI_TONE_ANNOUNCEMENT_SETUP");
        }
    }

    public static class State
    extends PersistentState {
        public static final int VERSION = 2;
        public static final int KEY = 841;
        private int guidanceMode;
        private int announcementOnCall;
        private int guidanceLastMode;

        public State(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 2, 1004, 841, logChannel);
        }

        protected void initWithDefaultValues() {
            this.guidanceMode = SpeechManager.getDefaultGuidanceMode();
            this.guidanceLastMode = SpeechManager.getDefaultGuidanceMode();
            this.announcementOnCall = SpeechManager.getDefaultAnnouncementOnCall();
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.guidanceMode = iStorageAccess.getInt(1004, 300, SpeechManager.getDefaultGuidanceMode());
            this.announcementOnCall = iStorageAccess.getInt(1004, 310, SpeechManager.getDefaultAnnouncementOnCall());
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.guidanceMode);
            dataOutputStream.writeInt(this.announcementOnCall);
            dataOutputStream.writeInt(this.guidanceLastMode);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.guidanceMode = dataInputStream.readInt();
            this.announcementOnCall = dataInputStream.readInt();
            this.guidanceLastMode = dataInputStream.readInt();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.getLogChannel().log(10000000, "SetupListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.guidanceMode = dataInputStream.readInt();
                    this.announcementOnCall = dataInputStream.readInt();
                }
                if (n > 1) {
                    this.guidanceLastMode = dataInputStream.readInt();
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "SetupListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public int getGuidanceMode() {
            return this.guidanceMode;
        }

        public void setGuidanceMode(int n) {
            this.guidanceMode = n;
        }

        public int getAnnouncementOnCall() {
            return this.announcementOnCall;
        }

        public void setAnnouncementOnCall(int n) {
            this.announcementOnCall = n;
        }

        public int getGuidanceLastMode() {
            return this.guidanceLastMode;
        }

        public void setGuidanceLastMode(int n) {
            this.guidanceLastMode = n;
        }
    }

    public static interface GuidanceModeSettingsListener {
        public void updateGuidanceMode(int var1);
    }
}

