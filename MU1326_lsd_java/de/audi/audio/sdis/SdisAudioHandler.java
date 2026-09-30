/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.DefaultHMIAudioServiceListener;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IBluetoothA2LSService;
import de.audi.atip.interapp.audio.AtipAudioSdisService;
import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.interapp.def.NullBluetoothA2LSService;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.def.NullSDISRangeListener;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.media.IMediaServiceListener;
import de.audi.atip.interapp.media.MediaSlotInfo;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.AudioContextController;
import de.audi.audio.sdis.AudioContextControllerImpl;
import de.audi.audio.sdis.AudioContextListener;
import de.audi.audio.sdis.ISdisCommandFactory;
import de.audi.audio.sdis.SdisDSISoundListener;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.cmd.SdisCmdStreamRegister;
import de.audi.audio.sdis.cmd.SdisCmdStreamRequestConf;
import de.audi.audio.sdis.cmd.SdisCmdStreamStart;
import de.audi.audio.sdis.cmd.SdisCmdStreamStop;
import de.audi.audio.sdis.cmd.SdisCmdWaitForAudible;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.audi.audio.sdis.ifc.SdisAudioService;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.Map;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouterListener;

public class SdisAudioHandler {
    private final int AUDIO_CONTEXT_MEDIA;
    private static final int AUDIBLE_STATE_UNDEFINED = -1;
    private final AudioEnv env;
    public final SdisAudioService sdisAudioService;
    final HMIAudioServiceListener audioListener = new AudioListener();
    final DSIMediaRouterListener dsiMediaRouterListener = new DSIMediaRouterListenerImpl();
    final DSISoundListener dsiSoundListener;
    final SdisAudioListener sdisAudioListener;
    final SdisMediaServiceListenerImpl sdisMediaServiceListener;
    private final CommandListManager clManager;
    private final AudioContextController audioContextController;
    private final boolean isQCUnit;
    private volatile int activeMediaSource;
    public HMIAudioService hmiAudioService;
    private AudioDrawerContext audioDrawerContext;
    private final ISdisCommandFactory commandFactory;
    volatile boolean a2lsRequestPending;
    private VolumeLockState volumeLockStateMedia;
    private VolumeLockState volumeLockStateTv;
    private VolumeLockState volumeLockStateRadio;
    private volatile AudioRoute currentAudioRoute;
    private SDISRangeListener rangeListener;
    private volatile int audibleState = -1;
    private int currentAudioContext;
    IMediaService mediaService;

    public SdisAudioHandler(AudioEnv audioEnv, ISdisCommandFactory iSdisCommandFactory, SdisAudioListener sdisAudioListener) {
        this.AUDIO_CONTEXT_MEDIA = 3;
        this.env = audioEnv;
        this.isQCUnit = "FMQ".equals(audioEnv.framework.getSysConstManager().getVariantInfo().getHeadUnit());
        SDSIAudioServiceImpl sDSIAudioServiceImpl = new SDSIAudioServiceImpl();
        this.sdisAudioService = sDSIAudioServiceImpl;
        this.audioContextController = new AudioContextControllerImpl(audioEnv.lcSDIS, this.isQCUnit);
        this.audioContextController.addAudioContextListener(sDSIAudioServiceImpl);
        this.sdisAudioListener = sdisAudioListener;
        this.commandFactory = iSdisCommandFactory;
        this.hmiAudioService = new NullHMIAudioService(audioEnv.lcSDIS);
        this.dsiSoundListener = new SdisDSISoundListener(audioEnv, sdisAudioListener);
        this.sdisMediaServiceListener = new SdisMediaServiceListenerImpl();
        this.audioDrawerContext = new NullAudioDrawerContext(audioEnv.lcSDIS);
        this.rangeListener = new NullSDISRangeListener(audioEnv.lcSDIS);
        this.volumeLockStateMedia = new VolumeLockState(3, 0);
        this.volumeLockStateTv = new VolumeLockState(4, 0);
        this.volumeLockStateRadio = new VolumeLockState(2, 0);
        this.currentAudioRoute = new AudioRoute();
        this.currentAudioContext = 0;
        this.clManager = new CommandListManager("SDIS_Audio", audioEnv.framework, audioEnv.lcSDIS, null, null);
        this.clManager.start();
    }

    void setAudioService(HMIAudioService hMIAudioService) {
        this.env.lcSDIS.log(1000000, "[SdisAudioHandler.setAudioService] %1", (Object)hMIAudioService);
        this.hmiAudioService = hMIAudioService;
    }

    public void setAudioDrawerContext(AudioDrawerContext audioDrawerContext) {
        this.env.lcSDIS.log(1000000, "[SdisAudioHandler.setAudioDrawerContext] %1", (Object)audioDrawerContext);
        this.audioDrawerContext = audioDrawerContext;
    }

    public void setDSISound(DSISound dSISound) {
        this.env.lcSDIS.log(1000000, "[SdisAudioHandler.setDSISound] %1", (Object)dSISound);
        int[] nArray = new int[]{26, 24};
        dSISound.setNotification(nArray, (DSIListener)this.dsiSoundListener);
    }

    public void setRangeListener(SDISRangeListener sDISRangeListener) {
        this.env.lcSDIS.log(1000000, "[SdisAudioHandler.setOnOffVolumeRange] %1", (Object)sDISRangeListener);
        this.rangeListener = sDISRangeListener;
    }

    public void executeDiagCmd(Command command) {
        CommandList commandList = new CommandList(this.clManager);
        commandList.add(command);
        commandList.execute("SdisAudioDiag");
    }

    private void updateVolumeLockState(int n) {
        int n2 = this.audioContextController.getAudioContext();
        VolumeLockState volumeLockState = this.getLockStateForAudioContext(n);
        this.env.lcSDIS.log(10000000, "[SdisAudioHandler.updateVolumeLockState] lockState: %1, audioContext for lockstate: %2, currentAudioContext: %3 ", (long)volumeLockState.getState(), (long)volumeLockState.getAudioContext(), (long)n2);
        if (n2 == n) {
            this.sdisAudioListener.updateVolumeLockState(volumeLockState);
        } else {
            this.env.lcSDIS.log(10000000, "[SdisAudioHandler.updateVolumeLockState] do not send updateVolumeLockState audioContext not active");
        }
    }

    private VolumeLockState getLockStateForAudioContext(int n) {
        switch (n) {
            case 3: {
                return this.volumeLockStateMedia;
            }
            case 4: {
                return this.volumeLockStateTv;
            }
            case 2: {
                return this.volumeLockStateRadio;
            }
        }
        this.env.lcSDIS.log(10000000, "[SdisAudioHandler.getLockStateForAudioContext] NO lockstate for audioContext: %1", (long)n);
        return new VolumeLockState();
    }

    public void setLockState(VolumeLockState volumeLockState, boolean bl) {
        int n = bl ? 1 : 0;
        volumeLockState.setState(n);
    }

    public boolean hasLockStateChanged(VolumeLockState volumeLockState, boolean bl) {
        int n;
        int n2 = n = bl ? 1 : 0;
        return n != volumeLockState.getState();
    }

    boolean isAudible() {
        return this.audibleState == 0 && !this.isAnnouncementRequested();
    }

    boolean isAnnouncementRequested() {
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.PHONE_CALL, 3) || this.hasAtleastOneConnectionMatchingState(AudioConnection.PHONE_RINGING, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.CONNECTED_GATEWAY_CONNS, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.NAVI, 3) || this.hasAtleastOneConnectionMatchingState(AudioConnection.TMC_CONNS, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.ETC, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.TA_PTY31, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.SDS, 3) || this.hasConnectionMatchingState(150, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.VOLUME_MENU_CONNECTIONS, 3)) {
            return true;
        }
        if (this.hasAtleastOneConnectionMatchingState(AudioConnection.READOUT_CONTACT_CONNS, 3)) {
            return true;
        }
        return this.hasConnectionMatchingState(126, 3);
    }

    boolean hasAtleastOneConnectionMatchingState(int[] nArray, int n) {
        if (nArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!this.hasConnectionMatchingState(nArray[i2], n)) continue;
            return true;
        }
        return false;
    }

    boolean hasConnectionMatchingState(int n, int n2) {
        int n3 = this.hmiAudioService.getStatus(n);
        this.env.lcSDIS.log(10000000, "[SdisAudioHandler.hasConnectionMatchingState] connection: %1, currentState: %2", (long)n, (long)n3);
        return n2 == n3;
    }

    private Command getActiveCommand() {
        CommandList commandList = this.clManager.getActiveCommandList();
        if (commandList != null) {
            return commandList.getActiveCommand();
        }
        return null;
    }

    class AudioListener
    extends DefaultHMIAudioServiceListener
    implements IAudioSdisListener {
        AudioListener() {
        }

        public void errorConnection(int n, int n2, int n3) {
            Command command;
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.errorConnection] connection: %1, hmiTerminal: %2, errroCode: %3", (long)n, (long)n2, (long)n3);
            if (this.isRearAudioTerminal(n2) && (command = SdisAudioHandler.this.getActiveCommand()) instanceof SdisCmdWaitForAudible) {
                command.getCommandList().commandAborted("Connection error");
            }
            if (n == 308) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.errorConnection] disableA2LS");
                SdisAudioHandler.this.sdisAudioService.disableA2LSFromHU();
            }
        }

        public void updateAMAvailable(boolean bl) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.updateAMAvailable] available: %1", bl);
            if (!bl) {
                int n = SdisAudioHandler.this.currentAudioContext;
                SdisAudioHandler.this.sdisAudioService.setAudioContext(0);
                SdisAudioHandler.this.currentAudioContext = n;
            } else {
                SdisAudioHandler.this.sdisAudioService.setAudioContext(SdisAudioHandler.this.currentAudioContext);
            }
        }

        public void stopConnection(int n, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.stopConnection] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
            if (this.isRearAudioTerminal(n2)) {
                this.finishWaitCommand(n);
            } else {
                if (n == 308) {
                    this.finishWaitCommand(n);
                }
                if (n == 308 && SdisAudioHandler.this.audioContextController.getAudioContext() == 1) {
                    ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.stopConnection] disableA2LS");
                    SdisAudioHandler.this.sdisAudioService.disableA2LSFromHU();
                }
            }
        }

        public void pauseConnection(int n, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.pauseConnection] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
            if (this.isRearAudioTerminal(n2) || n == 308) {
                this.finishWaitCommand(n);
            }
        }

        public void startConnection(int n, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.startConnection] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
            if (this.isRearAudioTerminal(n2) || n == 308) {
                this.finishWaitCommand(n);
            } else {
                if (AudioConnection.contains(AudioConnection.MUTE_SDIS_CONNECTIONS, n)) {
                    SdisAudioHandler.this.sdisAudioService.disableA2LSFromHU();
                }
                if (n == 8) {
                    SdisAudioHandler.this.sdisAudioListener.updateVolume(0);
                }
            }
        }

        public void fadedIn(int n, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.fadedIn] connection: %1, hmiTerminal: %2", (long)n, (long)n2);
            if (this.isRearAudioTerminal(n2) || n == 308) {
                this.finishWaitCommand(n);
            }
        }

        public void updateVolumeLock(int n, int n2, boolean bl) {
            VolumeLockState volumeLockState = new VolumeLockState(0, 0);
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.updateVolumeLock] volumeLockActive: %1, connection: %2", bl, (long)n);
            if (AudioConnection.contains(AudioConnection.ENT_RADIO_CONNS, n)) {
                volumeLockState = SdisAudioHandler.this.getLockStateForAudioContext(AudioContextController.AUDIO_CONTEXT_RADIO);
            } else if (n == 27 || n == 307) {
                volumeLockState = SdisAudioHandler.this.getLockStateForAudioContext(AudioContextController.AUDIO_CONTEXT_TV);
            } else if (AudioConnection.contains(AudioConnection.ENT_MEDIA_CONNS, n) || AudioConnection.contains(AudioConnection.SDIS_ENT_CONNECTIONS, n)) {
                volumeLockState = SdisAudioHandler.this.getLockStateForAudioContext(AudioContextController.AUDIO_CONTEXT_MEDIA);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.updateVolumeLock] invalid volume lock connection: %1", (long)n);
                return;
            }
            if (SdisAudioHandler.this.hasLockStateChanged(volumeLockState, bl)) {
                SdisAudioHandler.this.setLockState(volumeLockState, bl);
                SdisAudioHandler.this.updateVolumeLockState(volumeLockState.getAudioContext());
            }
        }

        private void finishWaitCommand(int n) {
            Command command = SdisAudioHandler.this.getActiveCommand();
            if (command instanceof SdisCmdWaitForAudible) {
                ((SdisCmdWaitForAudible)command).finishCmd(n);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.finishWaitCommand] active command is not SdisCmdWaitForAudible -> %1. do not finish", (Object)(command != null ? command.getName() : "null"));
            }
        }

        private boolean isRearAudioTerminal(int n) {
            return n != 0;
        }

        private void updateAudibleState(int n) {
            int n2 = this.getAudibleReason(n);
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.updateAudibleState]  newAudibleState: %1 audibleState: %2", (long)n2, (long)SdisAudioHandler.this.audibleState);
            if (this.hasAudibleStateChanged(n2)) {
                SdisAudioHandler.this.audibleState = n2;
                SdisAudioHandler.this.sdisAudioListener.updateAudibleState(SdisAudioHandler.this.audibleState);
            }
        }

        private int getAudibleReason(int n) {
            int n2 = SdisAudioHandler.this.audibleState;
            if (AudioConnection.isSdisSoundSourceEntertainment(n)) {
                n2 = 0;
            }
            if (3 == n) {
                n2 = 32;
            }
            if (AudioConnection.contains(AudioConnection.MUTE_SDIS_CONNECTIONS, n)) {
                n2 = 0x100000;
            }
            if (AudioConnection.isSdisSoundSourcePhone(n)) {
                n2 = 2;
            }
            if (AudioConnection.isSdisSoundSourceNavigation(n)) {
                n2 = 1;
            }
            if (AudioConnection.contains(AudioConnection.TA_PTY31, n)) {
                n2 = 8;
            }
            if (AudioConnection.isSdisSoundSourceSds(n)) {
                n2 = 4;
            }
            if (AudioConnection.contains(AudioConnection.VOLUME_MENU_CONNECTIONS, n) || AudioConnection.contains(AudioConnection.READOUT_CONTACT_CONNS, n) || n == 126) {
                n2 = 0x100000;
            }
            String string = SdisLabels.getAudibleState(n2);
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.getAudibleReason]  reason: %1 connection: %2", (Object)string, (long)n);
            return n2;
        }

        boolean hasAudibleStateChanged(int n) {
            return SdisAudioHandler.this.audibleState != n;
        }

        public void updateActiveConnection(int n, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.updateActiveConnection] AC:%1, HT:%2", (long)n, (long)n2);
            if (n2 == 0) {
                this.updateAudibleState(n);
            }
        }

        public void updateActiveEntertainmentConnection(int n, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.AudioListener.updateActiveEntertainmentConnection] AC:%1, HT:%2", (long)n, (long)n2);
        }
    }

    private class SDSIAudioServiceImpl
    implements SdisAudioService,
    AtipAudioSdisService,
    IAudioFocusClient,
    ButtonListener,
    AudioContextListener {
        private static final int NO_MODEL_ID = -1;
        volatile boolean a2lsActive;
        private volatile int frontAudioFocus;
        private ASIHMISyncAudioReply reply;
        private IBluetoothA2LSService bluetoothA2lsService;
        private final int RESULTCODE_A2LS_DUPLICATE_REQUEST;
        private static final int SETTING_A2LS_BLOCKED = 1;
        private static final int SETTING_A2LS_ALLOWED = 0;
        private static final int ACTIVE_HMI_APP_TUNER = 1;
        private static final int ACTIVE_HMI_APP_MEDIA = 2;
        private static final int A2LS_ACTIVE = 1;
        private static final int A2LS_INACTIVE = 0;
        private ChoiceModelApp a2lsPopupTriggerModel;
        private ChoiceModelApp tunerMediaActiveModel;
        private ChoiceModelApp a2lsActiveModel;
        private static final int HIDE_A2LS_ACTIVE_POPUP = 0;
        private static final int SHOW_A2LS_ACTIVE_POPUP = 1;
        private volatile boolean mediaTunerAreaEntered;
        private volatile boolean mediaTunerAreaLeftAfterStartup;

        public SDSIAudioServiceImpl() {
            this.RESULTCODE_A2LS_DUPLICATE_REQUEST = 6;
            this.a2lsPopupTriggerModel = SdisAudioHandler.this.env.getChoiceModel(0, 4242);
            this.tunerMediaActiveModel = SdisAudioHandler.this.env.getChoiceModel(0, 138);
            SdisAudioHandler.this.env.getButtonModel(4243).setButtonListener(this);
            this.a2lsActiveModel = SdisAudioHandler.this.env.getChoiceModel(0, 4515);
            this.bluetoothA2lsService = new NullBluetoothA2LSService(((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS);
        }

        public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            SdisAudioHandler.this.audioContextController.setAudioContext(n, aSIHMISyncAudioReply);
            if (SdisAudioHandler.this.mediaService != null && n == 4) {
                SdisAudioHandler.this.mediaService.activateSource(7, 0);
            }
        }

        public void setBluetoothService(IBluetoothA2LSService iBluetoothA2LSService) {
            this.bluetoothA2lsService = iBluetoothA2LSService;
        }

        public void setAudioContext(int n) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.setAudioContext] %1", (Object)SdisLabels.getContext(n));
            CommandList commandList = new CommandList(SdisAudioHandler.this.clManager);
            commandList.add(SdisAudioHandler.this.commandFactory.cmdReleaseSdisAudioConnections());
            if (n != 1) {
                commandList.add(SdisAudioHandler.this.commandFactory.cmdReleaseA2LS());
            }
            commandList.add(SdisAudioHandler.this.commandFactory.cmdSendInChange(n));
            switch (n) {
                case 3: {
                    this.disableA2LS();
                    SdisAudioHandler.this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                    this.a2lsActiveModel.setValue(0);
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioFocus(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioRouteMedia(SdisAudioHandler.this.currentAudioRoute));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(false));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestConf(n, SdisAudioHandler.this.activeMediaSource));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendReady(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendLockState(SdisAudioHandler.this.volumeLockStateMedia));
                    break;
                }
                case 2: {
                    this.disableA2LS();
                    SdisAudioHandler.this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                    this.a2lsActiveModel.setValue(0);
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioFocus(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioRouteMedia(SdisAudioHandler.this.currentAudioRoute));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdWaitUntilRadioAudible());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(false));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestConf(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendReady(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendLockState(SdisAudioHandler.this.volumeLockStateRadio));
                    break;
                }
                case 4: {
                    this.disableA2LS();
                    SdisAudioHandler.this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                    this.a2lsActiveModel.setValue(0);
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioFocus(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioRouteMedia(SdisAudioHandler.this.currentAudioRoute));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdWaitUntilTVAudible());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(false));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestConf(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendReady(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendLockState(SdisAudioHandler.this.volumeLockStateTv));
                    break;
                }
                case 1: {
                    SdisAudioHandler.this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
                    this.a2lsActiveModel.setValue(1);
                    this.bluetoothA2lsService.updateA2LSActive(true);
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioFocus(0));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(false));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestConf(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioRouteA2LS());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestA2LS());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdDemute());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdWaitUntilA2LSAudible());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdResponseEnableA2LS(this.reply));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendA2LSReady(n));
                    break;
                }
                case 0: {
                    this.disableA2LS();
                    SdisAudioHandler.this.audioDrawerContext.setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                    this.a2lsActiveModel.setValue(0);
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioFocus(n));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(true));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdReleaseA2LS());
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioRouteMedia(SdisAudioHandler.this.currentAudioRoute));
                    commandList.add(SdisAudioHandler.this.commandFactory.cmdSendReady(n));
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("Unknown audio context ").append(n).toString());
                }
            }
            SdisAudioHandler.this.currentAudioContext = n;
            commandList.execute("SdisAudioHandler.setAudioContext");
        }

        public void triggerA2LSStealing(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(1000000, "[SdisAudioHandler.triggerA2LSStealing]");
            CommandList commandList = new CommandList(SdisAudioHandler.this.clManager);
            int n = 1;
            commandList.add(SdisAudioHandler.this.commandFactory.cmdSendInChange(n));
            commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(true));
            commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestConf(n));
            commandList.add(SdisAudioHandler.this.commandFactory.cmdAudioRouteA2LS());
            commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
            commandList.add(SdisAudioHandler.this.commandFactory.cmdDemute());
            commandList.add(SdisAudioHandler.this.commandFactory.cmdWaitUntilA2LSAudible());
            commandList.add(SdisAudioHandler.this.commandFactory.cmdResponseEnableA2LS(aSIHMISyncAudioReply));
            commandList.add(SdisAudioHandler.this.commandFactory.cmdSendA2LSReady(n));
            SdisAudioHandler.this.currentAudioContext = n;
            commandList.execute("SdisAudioHandler.triggerA2LSStealing");
        }

        public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.unjoinActiveAudioContext] reply:%1 ", (Object)aSIHMISyncAudioReply);
            SdisAudioHandler.this.audioContextController.unjoinActiveAudioContext(aSIHMISyncAudioReply);
        }

        public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.joinActiveAudioContext] reply:%1 ", (Object)aSIHMISyncAudioReply);
            SdisAudioHandler.this.audioContextController.joinActiveAudioContext(aSIHMISyncAudioReply);
        }

        public void updateAudioContext(int n) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateAudioContext] audioContext: %1", (long)n);
            this.setAudioContext(n);
        }

        public void updateA2LSStateDeclined(A2LSState a2LSState) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateA2LSStateDeclined] requesting: %1, current: %2", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
            SdisAudioHandler.this.sdisAudioListener.updateA2LSState(a2LSState);
            SdisAudioHandler.this.a2lsRequestPending = false;
        }

        public void updateA2LSStateAccepted(A2LSState a2LSState) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateA2LSStateAccepted] requesting: %1, current: %2", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
            SdisAudioHandler.this.a2lsRequestPending = false;
            SdisAudioHandler.this.sdisAudioListener.updateA2LSState(a2LSState);
        }

        public void updateA2LSStatePending(A2LSState a2LSState) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateA2LSStatePending] requesting: %1, current: %2 send updateAudioContext to sdis", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
            SdisAudioHandler.this.a2lsRequestPending = true;
            SdisAudioHandler.this.sdisAudioListener.updateAudioContext(new AudioState(SdisAudioHandler.this.audioContextController.getAudioContext(), 2));
            SdisAudioHandler.this.sdisAudioListener.updateA2LSState(a2LSState);
        }

        public void updateA2LSStateDisabled(A2LSState a2LSState) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateA2LSStateDisabled] requesting: %1, current: %2", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
            SdisAudioHandler.this.sdisAudioListener.updateA2LSState(a2LSState);
            this.disableA2LS();
        }

        public void updateAudioFocus(int n, int n2) {
            SdisAudioHandler.this.a2lsRequestPending = false;
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateAudioFocus] HT:%1, appId:%2", (long)n, (long)n2);
            if (n == 0) {
                this.frontAudioFocus = n2;
                switch (this.frontAudioFocus) {
                    case 2: {
                        SdisAudioHandler.this.sdisAudioListener.updateFrontAudioContext(new AudioState(3, 1));
                        break;
                    }
                    case 1: {
                        SdisAudioHandler.this.sdisAudioListener.updateFrontAudioContext(new AudioState(2, 1));
                        break;
                    }
                    case 38: {
                        SdisAudioHandler.this.sdisAudioListener.updateFrontAudioContext(new AudioState(4, 1));
                        break;
                    }
                    case 43: 
                    case 48: {
                        SdisAudioHandler.this.sdisAudioListener.updateFrontAudioContext(new AudioState(0, 1));
                        break;
                    }
                    default: {
                        ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.updateAudioFocus] nothing to do!");
                    }
                }
            }
        }

        public void mediaTunerAreaEntered() {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SDSIAudioServiceImpl.mediaTunerAreaEntered]");
            this.mediaTunerAreaEntered = true;
            this.updateA2LSPopup();
        }

        public void mediaTunerAreaLeft() {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SDSIAudioServiceImpl.mediaTunerAreaLeft]");
            this.mediaTunerAreaEntered = false;
            this.mediaTunerAreaLeftAfterStartup = true;
            this.updateA2LSPopup();
        }

        public synchronized void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.enableA2LS] %1", (Object)string);
            try {
                if (this.isA2LSRequestPending() && !SdisAudioHandler.this.isQCUnit) {
                    ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.enableA2LS] a2ls request already running from differen sdis, drop this request");
                    ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.enableA2LS] responseEnableA2LS reply: %1, resultcode: %2", (Object)aSIHMISyncAudioReply, 6L);
                    aSIHMISyncAudioReply.responseEnableA2LS(6);
                    return;
                }
                int n = SdisAudioHandler.this.env.getChoiceModel(0, 4385).getValue();
                if (this.isA2LSReconnect(string)) {
                    n = 0;
                    string = string.substring(0, string.lastIndexOf(95));
                }
                switch (n) {
                    case 1: {
                        ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.enableA2LS] a2ls settings: %1", (long)n);
                        break;
                    }
                    case 0: {
                        SdisAudioHandler.this.a2lsRequestPending = true;
                        this.a2lsActive = true;
                        this.reply = aSIHMISyncAudioReply;
                        this.updateA2LSPopup();
                        SdisAudioHandler.this.audioContextController.enableA2LS(string, aSIHMISyncAudioReply);
                        break;
                    }
                    default: {
                        ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.enableA2LS] responseEnableA2LS reply: %1, resultcode: %2", (Object)aSIHMISyncAudioReply, 1L);
                        aSIHMISyncAudioReply.responseEnableA2LS(1);
                        break;
                    }
                }
            }
            catch (MethodException methodException) {
                methodException.printStackTrace();
            }
        }

        private boolean isA2LSReconnect(String string) {
            if (string == null) {
                return false;
            }
            return string.endsWith("RECONNECT");
        }

        private boolean isA2LSRequestPending() {
            return SdisAudioHandler.this.a2lsRequestPending;
        }

        public void disableA2LSFromSDIS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            SdisAudioHandler.this.audioContextController.disableA2LS(aSIHMISyncAudioReply);
        }

        public void disableA2LSFromHU() {
            SdisAudioHandler.this.audioContextController.disableA2LS();
        }

        private void disableA2LS() {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.disableA2LS]");
            this.a2lsActive = false;
            SdisAudioHandler.this.a2lsRequestPending = false;
            this.bluetoothA2lsService.updateA2LSActive(false);
            this.updateA2LSPopup();
        }

        private void updateA2LSPopup() {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.SDSIAudioServiceImpl.updateA2LSPopup] mediaTunerAreaEntered:%1, a2lsActive:%2", this.mediaTunerAreaEntered, this.a2lsActive);
            if (this.checkMediaTunerArea() && this.a2lsActive) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.SDSIAudioServiceImpl.updateA2LSPopup] show popup");
                this.a2lsPopupTriggerModel.setValue(1);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.SDSIAudioServiceImpl.updateA2LSPopup] hide popup");
                this.a2lsPopupTriggerModel.setValue(0);
            }
        }

        private boolean checkMediaTunerArea() {
            int n = this.tunerMediaActiveModel.getValue();
            boolean bl = this.mediaTunerAreaEntered || !this.mediaTunerAreaLeftAfterStartup && (n == 1 || n == 2);
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "<- [SdisAudioHandler.SDSIAudioServiceImpl.checkMediaTunerArea] mediaTunerAreaActive: %1 activeApplication:%2", bl, (long)n);
            return bl;
        }

        public void keyPressed(int n, int n2, int n3) {
        }

        public void keyReleased(int n, int n2, int n3) {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (n == 4243) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.keyTyped] disableA2LS");
                this.disableA2LSFromHU();
            }
        }

        public void keyLongTyped(int n, int n2, int n3) {
        }

        public void setVolume(int n) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.setVolume] volume:%1", (long)n);
            if (SdisAudioHandler.this.isAudible()) {
                SdisAudioHandler.this.rangeListener.changeVolume(n);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.setVolume] sdis is not audible discard setVolume");
            }
        }

        public void increaseVolume(int n) {
            if (SdisAudioHandler.this.isAudible()) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.increaseVolume] steps:%1", (long)n);
                SdisAudioHandler.this.rangeListener.increment(-1, n, 1);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.increaseVolume] sdis is not audible discard increaseVolume reason: %1", (long)SdisAudioHandler.this.audibleState);
            }
        }

        public void decreaseVolume(int n) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.decreaseVolume] steps:%1", (long)n);
            SdisAudioHandler.this.rangeListener.decrement(-1, n, 1);
        }

        public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            boolean bl = true;
            if (n == 2) {
                bl = this.frontAudioFocus != 1;
            } else if (n == 3) {
                bl = this.frontAudioFocus != 2;
            } else if (n == 4) {
                bl = this.frontAudioFocus != 38;
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(100000, "[SDISAudioHandler.forceFrontAudioContext] unhandled context:%1", (long)n);
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.forceFrontAudioContext] context:%1 frontAudioFocus:%2 demute:%3", (long)n, (long)this.frontAudioFocus, bl);
            CommandList commandList = new CommandList(SdisAudioHandler.this.clManager);
            commandList.add(SdisAudioHandler.this.commandFactory.cmdFrontAudioFocus(n));
            commandList.add(SdisAudioHandler.this.commandFactory.cmdFrontLastMode(n));
            if (bl) {
                commandList.add(SdisAudioHandler.this.commandFactory.cmdDemute());
            }
            commandList.execute("SDISAudioHandler.forceFrontAudioContext");
        }

        public void registerReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            SdisAudioHandler.this.audioContextController.setAudioContext(0, aSIHMISyncAudioReply);
        }

        public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
            SdisAudioHandler.this.audioContextController.setAudioContext(0, aSIHMISyncAudioReply);
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SDISAudioHandler.removeReplyProxy] proxy:%1", (Object)aSIHMISyncAudioReply);
            SdisAudioHandler.this.audioContextController.removeReplyProxy(aSIHMISyncAudioReply);
        }
    }

    private class DSIMediaRouterListenerImpl
    implements DSIMediaRouterListener {
        private DSIMediaRouterListenerImpl() {
        }

        public void asyncException(int n, String string, int n2) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[DSIMediaRouterListenerImpl.asyncException] errorMsg:%1 errorCode:%2 requestType:%3", (Object)string, (long)n, (long)n2);
        }

        public void responseConfiguration(int n, int n2) {
            if (n2 == 0) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[DSIMediaRouterListenerImpl.responseConfiguration] clientID:%1 result:OK(%2)", (long)n, (long)n2);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(100000, "[DSIMediaRouterListenerImpl.responseConfiguration] clientID:%1 result:NOK(%2)", (long)n, (long)n2);
            }
            Command command = SdisAudioHandler.this.getActiveCommand();
            if (command instanceof SdisCmdStreamRequestConf) {
                ((SdisCmdStreamRequestConf)command).responseConfiguration(n, n2);
            }
        }

        public void responseClientStatus(int n, int n2) {
            int n3;
            String string;
            switch (n2) {
                case 4: {
                    string = "DEREGISTRATION_FAILED";
                    n3 = 100000;
                    break;
                }
                case 3: {
                    string = "DEREGISTRATION_SUCCESS";
                    n3 = 10000000;
                    break;
                }
                case 2: {
                    string = "REGISTRATION_FAILED";
                    n3 = 100000;
                    break;
                }
                case 1: {
                    string = "REGISTRATION_SUCCESS";
                    n3 = 10000000;
                    break;
                }
                default: {
                    string = "UNKNOWN";
                    n3 = 100000;
                }
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(n3, "[DSIMediaRouterListenerImpl.responseClientStatus] clientID:%3 status:%1(%2)", (Object)string, (long)n2, (long)n);
            Command command = SdisAudioHandler.this.getActiveCommand();
            if (command instanceof SdisCmdStreamRegister) {
                ((SdisCmdStreamRegister)command).responseClientStatus(n, n2);
            }
        }

        public void updateStreamingStatus(int n, int n2, int n3) {
            int n4;
            String string;
            if (n3 != 1) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(1000000, "[DSIMediaRouterListenerImpl.updateStreamingStatus] INVALID clientID:%1 status:%2 valid:%3", (long)n, (long)n2, (long)n3);
                return;
            }
            switch (n2) {
                case 1: {
                    string = "STARTED";
                    n4 = 10000000;
                    break;
                }
                case 2: {
                    string = "STOPPED";
                    n4 = 10000000;
                    break;
                }
                case 3: {
                    string = "STOPPED_WITH_ERROR";
                    n4 = 100000;
                    break;
                }
                default: {
                    string = "UNKNOWN";
                    n4 = 100000;
                }
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(n4, "[DSIMediaRouterListenerImpl.updateStreamingStatus] clientID:%3 status:%1(%2)", (Object)string, (long)n2, (long)n);
            Command command = SdisAudioHandler.this.getActiveCommand();
            if (command instanceof SdisCmdStreamStart) {
                ((SdisCmdStreamStart)command).updateStreamingStatus(n, n2);
            } else if (command instanceof SdisCmdStreamStop) {
                ((SdisCmdStreamStop)command).updateStreamingStatus(n, n2);
            }
        }

        public void updateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
            if (n != 1 || audioRouteArray == null) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(1000000, "[DSIMediaRouterListenerImpl.updateActiveAudioRoutes] INVALID valid:%1", (long)n);
                return;
            }
            for (int i2 = 0; i2 < audioRouteArray.length; ++i2) {
                AudioRoute audioRoute = audioRouteArray[i2];
                if (audioRoute == null || audioRoute.routingOutput != 1) continue;
                ((SdisAudioHandler)SdisAudioHandler.this).currentAudioRoute.routingInput = audioRoute.routingInput;
                break;
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[DSIMediaRouterListenerImpl.updateActiveAudioRoutes] currentAudioRoute:%1", (Object)SdisAudioHandler.this.currentAudioRoute);
        }
    }

    private class SdisMediaServiceListenerImpl
    implements IMediaServiceListener {
        private SdisMediaServiceListenerImpl() {
        }

        public int getTerminalID() {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.getTerminalID]");
            return 0;
        }

        public void sourceAvailable(int n, boolean bl) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.sourceAvailable] sourceID: %1", (long)n);
        }

        public void sourceListChanged(Map map) {
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.sourceListChanged] do nothing");
        }

        public void updateActiveSource(MediaSlotInfo mediaSlotInfo, boolean bl) {
            if (mediaSlotInfo.getSourceType() == 4 || mediaSlotInfo.getSourceType() == 7) {
                if (mediaSlotInfo.getType() == 1) {
                    SdisAudioHandler.this.activeMediaSource = 2;
                } else {
                    SdisAudioHandler.this.activeMediaSource = 1;
                }
            } else {
                SdisAudioHandler.this.activeMediaSource = 0;
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] slotInfo: %1 restart: %2", (Object)mediaSlotInfo, (Object)String.valueOf(bl));
            if (SdisAudioHandler.this.audioContextController.getAudioContext() != 3 && SdisAudioHandler.this.audioContextController.getAudioContext() != 4) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] audioContext: %1 is not media or TV", (long)SdisAudioHandler.this.audioContextController.getAudioContext());
                return;
            }
            int n = mediaSlotInfo.getSourceType() == 7 || mediaSlotInfo.getSourceType() == 8 ? 4 : 3;
            if (SdisAudioHandler.this.audioContextController.getAudioContext() != n) {
                SdisAudioHandler.this.audioContextController.setAudioContext(n, null);
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] current audioContext: %1, mediaSource %2, new audioContext %3", (long)SdisAudioHandler.this.audioContextController.getAudioContext(), (long)SdisAudioHandler.this.activeMediaSource, (long)n);
            CommandList commandList = new CommandList(SdisAudioHandler.this.clManager);
            commandList.add(SdisAudioHandler.this.commandFactory.cmdStopStreaming(true));
            if (bl) {
                commandList.add(SdisAudioHandler.this.commandFactory.cmdRequestConf(n, SdisAudioHandler.this.activeMediaSource));
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] added conf");
                commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
                commandList.add(SdisAudioHandler.this.commandFactory.cmdSendReady(n));
            }
            commandList.add(SdisAudioHandler.this.commandFactory.cmdSendLockState(SdisAudioHandler.this.volumeLockStateMedia));
            CommandList commandList2 = SdisAudioHandler.this.clManager.getActiveCommandList();
            if (commandList2 != null && commandList2.hasActiveCommand()) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] add to active cl");
                commandList2.add(commandList);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updateActiveSource] execute cl");
                commandList.execute("SdisMediaServiceListenerImpl.updateActiveSource");
            }
        }

        public void updatePlaybackState(int n) {
            if (SdisAudioHandler.this.audioContextController.getAudioContext() != 3 || n != 1) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] playbackState: %1, audiocontext:%2 do nothing ", (long)n, (long)SdisAudioHandler.this.audioContextController.getAudioContext());
                return;
            }
            ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] playbackState: %1", (long)n);
            CommandList commandList = new CommandList(SdisAudioHandler.this.clManager);
            commandList.add(SdisAudioHandler.this.commandFactory.cmdStartStreaming());
            commandList.add(SdisAudioHandler.this.commandFactory.cmdSendReady(SdisAudioHandler.this.audioContextController.getAudioContext()));
            CommandList commandList2 = SdisAudioHandler.this.clManager.getActiveCommandList();
            if (commandList2 != null && commandList2.hasActiveCommand()) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] finish active cl");
                commandList2.add(commandList);
            } else {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.updatePlaybackState] execute cl");
                commandList.execute("SdisMediaServiceListenerImpl.updatePlaybackState");
            }
        }

        public void sourceDeactivated() {
            if (SdisAudioHandler.this.audioContextController.getAudioContext() != 3 && SdisAudioHandler.this.audioContextController.getAudioContext() != 4) {
                ((SdisAudioHandler)SdisAudioHandler.this).env.lcSDIS.log(10000000, "[SdisAudioHandler.SdisMediaServiceListenerImpl.sourceDeactivated] audioContext: %1 is not media or TV", (long)SdisAudioHandler.this.audioContextController.getAudioContext());
                return;
            }
            CommandList commandList = new CommandList(SdisAudioHandler.this.clManager);
            Command command = SdisAudioHandler.this.commandFactory.cmdStopStreaming(true);
            commandList.add(command);
            command.execute();
        }
    }
}

