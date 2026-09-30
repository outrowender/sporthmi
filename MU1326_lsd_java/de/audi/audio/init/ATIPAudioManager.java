/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.audio.AudioDiagnosis
 */
package de.audi.audio.init;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.audio.ATIPAudioService;
import de.audi.atip.interapp.audio.ATIPAudioServiceListener;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.audio.ATIPMediaRouterServiceListener;
import de.audi.atip.interapp.audio.TIJPVolumeServiceListener;
import de.audi.atip.interapp.audio.VolumeOnOffPressListener;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone;
import de.audi.atip.interapp.def.NullNaviService;
import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.interapp.def.NullSDSService;
import de.audi.atip.interapp.def.NullTelServiceAudio;
import de.audi.atip.interapp.def.NullTerminalModeAudioService;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.atip.interapp.phone.ITelMuteMicService;
import de.audi.atip.interapp.phone.ITelServiceAudio;
import de.audi.atip.interapp.terminalmode.ITerminalModeAudioService;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.atip.util.osgi.NullDSIAudioManagement;
import de.audi.atip.util.osgi.NullDSISound;
import de.audi.audio.ATIPAudioServiceImpl;
import de.audi.audio.AudioEnv;
import de.audi.audio.CombiServiceHandler;
import de.audi.audio.DumpAudioProvider;
import de.audi.audio.InterAppHandler;
import de.audi.audio.context.AudioDrawerContextImpl;
import de.audi.audio.dsi.DSIAudioListenerImpl;
import de.audi.audio.dsi.DSIMediaRouterListenerImpl;
import de.audi.audio.dsi.DSISoundListenerImpl;
import de.audi.audio.earlysound.ReadinessSound;
import de.audi.audio.init.DSISoundNotifications;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.audio.services.ATIPMediaRouterServiceImpl;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.services.EntertainmentAudioService;
import de.audi.audio.services.NullDSIMediaRouter;
import de.audi.audio.services.ToneAudioService;
import de.audi.audio.sse.NullDSISSE;
import de.audi.audio.sse.SSEHandler;
import de.audi.audio.volume.OnOffVolumeRange;
import de.audi.audio.volume.StatusbarMuteIcon;
import de.audi.audio.volume.UserMuteRestorer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.mib.swdiagnosis.audio.AudioDiagnosis;
import org.dsi.ifc.audio.DSIAudioManagement;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaRouter;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.dsi.ifc.sse.DSISSE;
import org.dsi.ifc.sse.DSISSEListener;

public class ATIPAudioManager {
    private final BaseAudioService[] clients = new BaseAudioService[34];
    final DSISoundDisposer dsiSoundDisposer;
    final DSIAudioDisposer dsiAudioDisposer;
    final DSIMediaRouterDisposer dsiMediaRouterDisposer;
    private final InterAppHandler interAppHandler;
    private final DSIAudioListenerImpl dsiAudioListener;
    private final AudioEnv env;
    private final DSISoundListenerImpl dsiSoundListener;
    private final OnOffVolumeRange.Controller controller;
    private final CombiServiceHandler combiHandler;
    private final ATIPAudioService atipAudioService;
    private final DSISoundNotifications dsiSoundNotifications;
    private final UserMuteRestorer userMuteRestorer;
    private final ReadinessSound readinessSound;
    private final AudioDrawerContext audioDrawerContext;
    private final SSEHandler sseHandler;
    private final ILastmodeHandler audioFocusManager;
    private final ATIPMediaRouterService mediaRouterService;
    private final DSIMediaRouterListenerImpl dsiMediaRouterListener;

    ATIPAudioManager(AudioEnv audioEnv) {
        audioEnv.lcMain.log(100000000, "[ATIPAudioManager.new] Before initialization");
        this.dsiAudioDisposer = new DSIAudioDisposer();
        this.dsiSoundDisposer = new DSISoundDisposer();
        this.dsiMediaRouterDisposer = new DSIMediaRouterDisposer();
        this.env = audioEnv;
        this.interAppHandler = new InterAppHandler(audioEnv);
        ChoiceModelApp choiceModelApp = audioEnv.getChoiceModel(0, 4628);
        ChoiceModelApp choiceModelApp2 = audioEnv.getChoiceModel(0, 4079);
        BaseAudioService baseAudioService = new BaseAudioService(audioEnv, "INTERNAL");
        this.userMuteRestorer = new UserMuteRestorer(audioEnv, baseAudioService);
        this.readinessSound = new ReadinessSound(audioEnv.lcMain, audioEnv, baseAudioService);
        this.audioDrawerContext = new AudioDrawerContextImpl(audioEnv);
        this.dsiAudioListener = new DSIAudioListenerImpl(audioEnv, this.interAppHandler, this.userMuteRestorer);
        this.dsiSoundListener = new DSISoundListenerImpl(audioEnv, baseAudioService, choiceModelApp, choiceModelApp2);
        this.dsiSoundNotifications = new DSISoundNotifications(audioEnv.lcDSI, this.dsiSoundListener);
        this.sseHandler = new SSEHandler(audioEnv);
        this.audioFocusManager = audioEnv.framework.getLastmodeHandler();
        this.audioFocusManager.initAudioFocusManagement();
        this.clients[0] = new EntertainmentAudioService(audioEnv, "TUNER");
        this.clients[1] = new EntertainmentAudioService(audioEnv, "MEDIA");
        this.clients[25] = new EntertainmentAudioService(audioEnv, "TV");
        this.clients[27] = new EntertainmentAudioService(audioEnv, "SDIS");
        this.clients[2] = new EntertainmentAudioService(audioEnv, "POWER");
        this.clients[5] = new EntertainmentAudioService(audioEnv, "PHONE");
        this.clients[24] = new EntertainmentAudioService(audioEnv, "PHONE_RT");
        this.clients[16] = new EntertainmentAudioService(audioEnv, "BT");
        this.clients[6] = new ToneAudioService(audioEnv, "TONE");
        this.clients[3] = new BaseAudioService(audioEnv, "TIM");
        this.clients[4] = new BaseAudioService(audioEnv, "SWDL");
        this.clients[7] = new BaseAudioService(audioEnv, "CAR");
        this.clients[8] = new BaseAudioService(audioEnv, "INFO");
        this.clients[10] = new BaseAudioService(audioEnv, "TTS_DV");
        this.clients[9] = new BaseAudioService(audioEnv, "TTS_OL");
        this.clients[11] = new BaseAudioService(audioEnv, "TTS_TIM");
        this.clients[12] = new BaseAudioService(audioEnv, "TTS_URR");
        this.clients[13] = new BaseAudioService(audioEnv, "TTS_CAR");
        this.clients[22] = new BaseAudioService(audioEnv, "TTS_DSRC_LOW");
        this.clients[23] = new BaseAudioService(audioEnv, "TTS_DSRC_HIGH");
        this.clients[19] = new BaseAudioService(audioEnv, "TTS_ADB");
        this.clients[20] = new BaseAudioService(audioEnv, "TTS_MESSAGING");
        this.clients[21] = new BaseAudioService(audioEnv, "TTS_REMOTE_HMI");
        this.clients[14] = new BaseAudioService(audioEnv, "NAVI");
        this.clients[15] = new BaseAudioService(audioEnv, "SDS");
        this.clients[17] = new BaseAudioService(audioEnv, "TOUCHPAD");
        this.clients[18] = new BaseAudioService(audioEnv, "TOUCHPAD_VOL");
        this.clients[26] = new BaseAudioService(audioEnv, "STARTUP");
        this.clients[28] = new BaseAudioService(audioEnv, "ECALL");
        this.clients[29] = new BaseAudioService(audioEnv, "WC_REMINDER");
        this.clients[30] = new BaseAudioService(audioEnv, "WC_VOL");
        this.clients[31] = new BaseAudioService(audioEnv, "ETC_VOL");
        this.clients[32] = new BaseAudioService(audioEnv, "EXLAP");
        this.clients[33] = new BaseAudioService(audioEnv, "HEARTBEAT");
        this.combiHandler = new CombiServiceHandler(audioEnv, baseAudioService);
        this.controller = new OnOffVolumeRange.Controller(audioEnv, this.interAppHandler, this.combiHandler);
        this.atipAudioService = new ATIPAudioServiceImpl(audioEnv, this.controller);
        this.mediaRouterService = new ATIPMediaRouterServiceImpl(audioEnv);
        this.dsiMediaRouterListener = new DSIMediaRouterListenerImpl(audioEnv);
        ISoundListener[] iSoundListenerArray = new ISoundListener[]{this.controller.getRange((int)0).soundListener, this.controller.getRange((int)3).soundListener, this.controller.getRange((int)4).soundListener, this.combiHandler.soundListener, this.readinessSound.getSoundListener()};
        this.dsiSoundListener.setListeners(iSoundListenerArray);
        this.dsiAudioListener.registerAudioService(baseAudioService);
        audioEnv.getErrorMgr().registerDumpInfoProvider(DumpAudioProvider.INSTANCE);
        audioEnv.lcMain.log(100000000, "[ATIPAudioManager.new] After initialization");
    }

    void registerListener(HMIAudioServiceListener hMIAudioServiceListener, int n) {
        this.dsiAudioListener.register(hMIAudioServiceListener, n, this.clients[n].name);
    }

    void deregisterHMIAudioServiceListener(int n, HMIAudioServiceListener hMIAudioServiceListener) {
        this.dsiAudioListener.deregisterHMIAudioServiceListener(n, hMIAudioServiceListener);
    }

    HMIAudioService getAudioService(int n) {
        if (n < 0 || n >= this.clients.length) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal audio client ID ").append(n).toString());
        }
        return this.clients[n];
    }

    Object register(Object object) {
        if (object instanceof IAudioFocusClient) {
            this.audioFocusManager.registerAudioClient((IAudioFocusClient)object);
            return object;
        }
        if (object instanceof DSISSE) {
            this.sseHandler.setDSISSE((DSISSE)object);
            this.clients[5].setService(object);
            return object;
        }
        if (object instanceof ATIPMediaRouterServiceListener) {
            this.dsiMediaRouterListener.addATIPMediaRouterServiceListener((ATIPMediaRouterServiceListener)object);
            return object;
        }
        if (object instanceof TunerService) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof ITelServiceAudio) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof ITerminalModeAudioService) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof SDSService) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof NaviService) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof TIJPVolumeServiceListener) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof ITelMuteMicService) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof ATIPAudioServiceListener) {
            this.interAppHandler.register((ATIPAudioServiceListener)object);
            return object;
        }
        if (object instanceof CombiBAPServiceTone) {
            this.combiHandler.register((CombiBAPServiceTone)object);
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            BaseAudioService baseAudioService = new BaseAudioService(this.env, "DIAG");
            AudioDiagnosis audioDiagnosis = new AudioDiagnosis(this, (HMIAudioService)baseAudioService, this.dsiAudioListener, this.dsiSoundListener);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)audioDiagnosis);
            return object;
        }
        if (object instanceof VolumeOnOffPressListener) {
            this.controller.getRange(0).setService(object);
            return object;
        }
        if (object instanceof WavePlayer) {
            WavePlayer wavePlayer = (WavePlayer)object;
            this.readinessSound.setService(wavePlayer.getRingTonePlayer());
            return object;
        }
        this.env.lcMain.log(100000, "[ATIPAudioManager.register] Unsupported service '%1' registered!", object);
        return null;
    }

    void deregister(Object object) {
        if (object instanceof IAudioFocusClient) {
            this.audioFocusManager.deregisterAudioClient((IAudioFocusClient)object);
        } else if (object instanceof DSISSE) {
            this.sseHandler.setDSISSE(new NullDSISSE(this.env.lcDSI));
            this.clients[5].setService(new NullDSISSE(this.env.lcDSI));
        } else if (object instanceof ATIPMediaRouterServiceListener) {
            this.dsiMediaRouterListener.removeATIPMediaRouterServiceListener((ATIPMediaRouterServiceListener)object);
        } else if (object instanceof CombiBAPServiceTone) {
            this.getCombiHandler().deregister();
        } else if (object instanceof NaviService) {
            this.controller.getRange(0).setService(new NullNaviService(this.env.lcMain));
        } else if (object instanceof ITelServiceAudio) {
            this.controller.getRange(0).setService(new NullTelServiceAudio(this.env.lcMain));
        } else if (object instanceof ITerminalModeAudioService) {
            this.controller.getRange(0).setService(new NullTerminalModeAudioService(this.env.lcMain));
        } else if (object instanceof SDSService) {
            this.controller.getRange(0).setService(new NullSDSService(this.env.lcMain));
        } else if (object instanceof TunerService) {
            this.controller.getRange(0).setService(new NullTunerService(this.env.lcMain));
        } else if (object instanceof ATIPAudioServiceListener) {
            this.interAppHandler.deregister();
        } else if (object instanceof VolumeOnOffPressListener) {
            this.controller.getRange(0).unregisterService(object);
        } else if (object instanceof WavePlayer) {
            this.readinessSound.setService(new NullRingTonePlayer(this.env.lcMain));
        } else {
            this.env.lcMain.log(100000, "[ATIPAudioManager.deregister] Unsupported service '%1' deregistered!", object);
        }
    }

    DSISSEListener getDSISSEListener() {
        return this.sseHandler.dsiListener;
    }

    DSISoundListener getDSISoundListener() {
        return this.dsiSoundListener;
    }

    public ATIPMediaRouterService getMediaRouterService() {
        return this.mediaRouterService;
    }

    public DSIMediaRouterListenerImpl getDsiMediaRouterListener() {
        return this.dsiMediaRouterListener;
    }

    DSIAudioListenerImpl getAudioHandler() {
        return this.dsiAudioListener;
    }

    DSIPowerManagementListener getPowerHandler() {
        return this.dsiAudioListener;
    }

    ReadinessSound getReadinessSound() {
        return this.readinessSound;
    }

    CombiServiceHandler getCombiHandler() {
        return this.combiHandler;
    }

    ATIPAudioService getAtipAudioService() {
        return this.atipAudioService;
    }

    AudioDrawerContext getAudioDrawerContext() {
        return this.audioDrawerContext;
    }

    IAudioFocusManager getAudioFocusManager() {
        return this.audioFocusManager;
    }

    OnOffVolumeRange.Controller getController() {
        return this.controller;
    }

    final class DSIAudioDisposer {
        DSIAudioDisposer() {
        }

        void addDSI(DSIAudioManagement dSIAudioManagement) {
            ((ATIPAudioManager)ATIPAudioManager.this).env.lcMain.log(1000000, "[DSIAudioDisposer.addDSI] %1", (Object)dSIAudioManagement);
            this.setDSI(dSIAudioManagement);
            ATIPAudioManager.this.dsiAudioListener.register(ATIPAudioManager.this.controller);
            ATIPAudioManager.this.dsiAudioListener.setInternalListeners(new IAudioListener[]{new StatusbarMuteIcon(ATIPAudioManager.this.env), ATIPAudioManager.this.dsiSoundNotifications, ATIPAudioManager.this.userMuteRestorer, ATIPAudioManager.this.controller.getRange(0), ATIPAudioManager.this.controller.getRange(3), ATIPAudioManager.this.controller.getRange(4), ATIPAudioManager.this.combiHandler, ATIPAudioManager.this.readinessSound.getAudioListener(), ((ATIPAudioManager)ATIPAudioManager.this).sseHandler.audioListener});
        }

        void removeDSI() {
            ((ATIPAudioManager)ATIPAudioManager.this).env.lcMain.log(1000000, "[DSIAudioDisposer.removeDSI]");
            this.setDSI(new NullDSIAudioManagement(((ATIPAudioManager)ATIPAudioManager.this).env.lcDSI));
        }

        private void setDSI(DSIAudioManagement dSIAudioManagement) {
            ATIPAudioManager.this.env.setDSIAudo(dSIAudioManagement);
            ATIPAudioManager.this.controller.getRange(0).setService(dSIAudioManagement);
        }

        void setNotifications(DSIAudioManagement dSIAudioManagement) {
            int[] nArray = new int[]{1, 2, 3};
            ((ATIPAudioManager)ATIPAudioManager.this).env.lcMain.log(1000000, "[DSIAudioDisposer.setNotifications] %1: %2", (Object)dSIAudioManagement, (Object)nArray);
            dSIAudioManagement.setNotification(nArray, (DSIListener)ATIPAudioManager.this.dsiAudioListener);
        }
    }

    final class DSISoundDisposer {
        DSISoundDisposer() {
        }

        void addDSI(DSISound dSISound) {
            ((ATIPAudioManager)ATIPAudioManager.this).env.lcMain.log(1000000, "[DSISoundDisposer.addDSI] %1", (Object)dSISound);
            this.setDSI(dSISound);
            ATIPAudioManager.this.dsiSoundNotifications.addDSI(dSISound);
            dSISound.getMenuVolumeRange(82, 1);
        }

        void removeDSI() {
            ((ATIPAudioManager)ATIPAudioManager.this).env.lcMain.log(1000000, "[DSISoundDisposer.removeDSI]");
            this.setDSI(new NullDSISound(((ATIPAudioManager)ATIPAudioManager.this).env.lcDSI));
        }

        private void setDSI(DSISound dSISound) {
            ATIPAudioManager.this.controller.getRange(0).setService(dSISound);
        }
    }

    final class DSIMediaRouterDisposer {
        DSIMediaRouterDisposer() {
        }

        void addDSI(DSIMediaRouter dSIMediaRouter) {
            ((ATIPAudioManager)ATIPAudioManager.this).env.lcDSI.log(1000000, "[DSIMediaRouterDisposer.addDSI] %1", (Object)dSIMediaRouter);
            int[] nArray = new int[]{2};
            dSIMediaRouter.setNotification(nArray, (DSIListener)ATIPAudioManager.this.dsiMediaRouterListener);
            ATIPAudioManager.this.mediaRouterService.setDSIMediaRouter(dSIMediaRouter);
        }

        void removeDSI() {
            ATIPAudioManager.this.mediaRouterService.setDSIMediaRouter(new NullDSIMediaRouter(((ATIPAudioManager)ATIPAudioManager.this).env.lcDSI));
        }
    }
}

