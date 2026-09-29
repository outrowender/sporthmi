/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.interapp.audio.SDISRangeListener;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.atip.interapp.def.NullSDISRangeListener;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.AudioContextController;
import de.audi.audio.sdis.AudioContextControllerImpl;
import de.audi.audio.sdis.ISdisCommandFactory;
import de.audi.audio.sdis.SdisAudioHandler$AudioListener;
import de.audi.audio.sdis.SdisAudioHandler$DSIMediaRouterListenerImpl;
import de.audi.audio.sdis.SdisAudioHandler$SDSIAudioServiceImpl;
import de.audi.audio.sdis.SdisAudioHandler$SdisMediaServiceListenerImpl;
import de.audi.audio.sdis.SdisDSISoundListener;
import de.audi.audio.sdis.ifc.SdisAudioListener;
import de.audi.audio.sdis.ifc.SdisAudioService;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouterListener;

public class SdisAudioHandler {
    private final int AUDIO_CONTEXT_MEDIA;
    private static final int AUDIBLE_STATE_UNDEFINED;
    private final AudioEnv env;
    public final SdisAudioService sdisAudioService;
    final HMIAudioServiceListener audioListener = new SdisAudioHandler$AudioListener(this);
    final DSIMediaRouterListener dsiMediaRouterListener = new SdisAudioHandler$DSIMediaRouterListenerImpl(this, null);
    final DSISoundListener dsiSoundListener;
    final SdisAudioListener sdisAudioListener;
    final SdisAudioHandler$SdisMediaServiceListenerImpl sdisMediaServiceListener;
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
        SdisAudioHandler$SDSIAudioServiceImpl sdisAudioHandler$SDSIAudioServiceImpl = new SdisAudioHandler$SDSIAudioServiceImpl(this);
        this.sdisAudioService = sdisAudioHandler$SDSIAudioServiceImpl;
        this.audioContextController = new AudioContextControllerImpl(audioEnv.lcSDIS, this.isQCUnit);
        this.audioContextController.addAudioContextListener(sdisAudioHandler$SDSIAudioServiceImpl);
        this.sdisAudioListener = sdisAudioListener;
        this.commandFactory = iSdisCommandFactory;
        this.hmiAudioService = new NullHMIAudioService(audioEnv.lcSDIS);
        this.dsiSoundListener = new SdisDSISoundListener(audioEnv, sdisAudioListener);
        this.sdisMediaServiceListener = new SdisAudioHandler$SdisMediaServiceListenerImpl(this, null);
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
        this.env.lcSDIS.log(1078071040, "[SdisAudioHandler.setAudioService] %1", (Object)hMIAudioService);
        this.hmiAudioService = hMIAudioService;
    }

    public void setAudioDrawerContext(AudioDrawerContext audioDrawerContext) {
        this.env.lcSDIS.log(1078071040, "[SdisAudioHandler.setAudioDrawerContext] %1", (Object)audioDrawerContext);
        this.audioDrawerContext = audioDrawerContext;
    }

    public void setDSISound(DSISound dSISound) {
        this.env.lcSDIS.log(1078071040, "[SdisAudioHandler.setDSISound] %1", (Object)dSISound);
        int[] nArray = new int[]{26, 24};
        dSISound.setNotification(nArray, (DSIListener)this.dsiSoundListener);
    }

    public void setRangeListener(SDISRangeListener sDISRangeListener) {
        this.env.lcSDIS.log(1078071040, "[SdisAudioHandler.setOnOffVolumeRange] %1", (Object)sDISRangeListener);
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
        this.env.lcSDIS.log(-2137614336, "[SdisAudioHandler.updateVolumeLockState] lockState: %1, audioContext for lockstate: %2, currentAudioContext: %3 ", (long)volumeLockState.getState(), (long)volumeLockState.getAudioContext(), (long)n2);
        if (n2 == n) {
            this.sdisAudioListener.updateVolumeLockState(volumeLockState);
        } else {
            this.env.lcSDIS.log(-2137614336, "[SdisAudioHandler.updateVolumeLockState] do not send updateVolumeLockState audioContext not active");
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
        this.env.lcSDIS.log(-2137614336, "[SdisAudioHandler.getLockStateForAudioContext] NO lockstate for audioContext: %1", (long)n);
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
        this.env.lcSDIS.log(-2137614336, "[SdisAudioHandler.hasConnectionMatchingState] connection: %1, currentState: %2", (long)n, (long)n3);
        return n2 == n3;
    }

    private Command getActiveCommand() {
        CommandList commandList = this.clManager.getActiveCommandList();
        if (commandList != null) {
            return commandList.getActiveCommand();
        }
        return null;
    }

    static /* synthetic */ AudioEnv access$200(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.env;
    }

    static /* synthetic */ AudioContextController access$300(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.audioContextController;
    }

    static /* synthetic */ CommandListManager access$400(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.clManager;
    }

    static /* synthetic */ ISdisCommandFactory access$500(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.commandFactory;
    }

    static /* synthetic */ AudioDrawerContext access$600(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.audioDrawerContext;
    }

    static /* synthetic */ AudioRoute access$700(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.currentAudioRoute;
    }

    static /* synthetic */ int access$800(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.activeMediaSource;
    }

    static /* synthetic */ VolumeLockState access$900(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.volumeLockStateMedia;
    }

    static /* synthetic */ VolumeLockState access$1000(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.volumeLockStateRadio;
    }

    static /* synthetic */ VolumeLockState access$1100(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.volumeLockStateTv;
    }

    static /* synthetic */ int access$1202(SdisAudioHandler sdisAudioHandler, int n) {
        sdisAudioHandler.currentAudioContext = n;
        return sdisAudioHandler.currentAudioContext;
    }

    static /* synthetic */ boolean access$1300(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.isQCUnit;
    }

    static /* synthetic */ SDISRangeListener access$1400(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.rangeListener;
    }

    static /* synthetic */ int access$1500(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.audibleState;
    }

    static /* synthetic */ Command access$1600(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.getActiveCommand();
    }

    static /* synthetic */ int access$1200(SdisAudioHandler sdisAudioHandler) {
        return sdisAudioHandler.currentAudioContext;
    }

    static /* synthetic */ VolumeLockState access$1700(SdisAudioHandler sdisAudioHandler, int n) {
        return sdisAudioHandler.getLockStateForAudioContext(n);
    }

    static /* synthetic */ void access$1800(SdisAudioHandler sdisAudioHandler, int n) {
        sdisAudioHandler.updateVolumeLockState(n);
    }

    static /* synthetic */ int access$1502(SdisAudioHandler sdisAudioHandler, int n) {
        sdisAudioHandler.audibleState = n;
        return sdisAudioHandler.audibleState;
    }

    static /* synthetic */ int access$802(SdisAudioHandler sdisAudioHandler, int n) {
        sdisAudioHandler.activeMediaSource = n;
        return sdisAudioHandler.activeMediaSource;
    }
}

