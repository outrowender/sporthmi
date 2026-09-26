/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.tone.ToneDiag
 */
package de.audi.tone.app.init;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.PhoneService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.audio.ATIPAudioService;
import de.audi.atip.interapp.audio.ATIPAudioServiceListener;
import de.audi.atip.interapp.audio.AmplifierListener;
import de.audi.atip.interapp.audio.AtipAudioSdisService;
import de.audi.atip.interapp.audio.IAnnouncementStateService;
import de.audi.atip.interapp.audio.IAudioSdisListener;
import de.audi.atip.interapp.audio.ISoundHandlerListener;
import de.audi.atip.interapp.audio.ToneServiceListener;
import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.interapp.media.IMediaFilePlayerService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.variant.IGUIVariantProvider;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tone.app.ATIPAudioServiceListenerImpl;
import de.audi.tone.app.AmplifierProvider;
import de.audi.tone.app.AmplifierVariant;
import de.audi.tone.app.InputGainOffsetHandler;
import de.audi.tone.app.RSEWizardSwitcher;
import de.audi.tone.app.Showroom;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.ToneHMIApplication;
import de.audi.tone.app.ToneVirtualButtonHandler;
import de.audi.tone.app.ap.ActionProxyListener;
import de.audi.tone.app.dsi.AudioServiceHandler;
import de.audi.tone.app.dsi.DSISoundHandler;
import de.audi.tone.app.dsi.DSISoundListenerImpl;
import de.audi.tone.app.dsi.HMIAudioManagementListenerImpl;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.init.ToneAppCommon$AtipSdisActionProxyListener;
import de.audi.tone.app.msg.AudioFactoryReset;
import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.msg.Heartbeat;
import de.audi.tone.app.msg.MsgListenerDistributor;
import de.audi.tone.app.msg.TouchSound;
import de.audi.tone.app.msg.WirelessChargingReminder;
import de.audi.tone.app.sound.SoundFocus;
import de.audi.tone.app.sound.SoundHandler;
import de.audi.tone.app.sound.SoundSource;
import de.audi.tone.app.sound.ThreeDMode;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.mib.swdiagnosis.tone.ToneDiag;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.base.DSIListener;

public class ToneAppCommon {
    protected final ToneEnv env;
    protected final AudioServiceHandler audioService;
    protected final SoundHandler sound;
    protected final DSISoundListenerImpl dsiSoundListener;
    protected IDSISoundHandler dsiSound;
    protected VolumeRangeManager volMenuManager;
    protected final ToneVirtualButtonHandler toneVirtualButtonHandler;
    protected final ToneAppCommon$AtipSdisActionProxyListener atipSdisActioProxyListener;
    protected ThreeDMode threeDMode;
    protected ATIPAudioServiceListener atipAudioListener;
    private final HMIApplication hmiApplication;
    protected final HMIAudioManagementListenerImpl audioListener;
    private final MsgListenerDistributor messageListener;
    private final Heartbeat heartbeat;
    private final TouchSound touchSound;
    private final WirelessChargingReminder wirelessChargingReminder;
    private final AmplifierVariant amplifier;
    protected SoundFocus soundSets;
    private final AmplifierProvider amplifierProvider;

    protected ToneAppCommon(IFrameworkAccess iFrameworkAccess, IGUIVariantProvider iGUIVariantProvider) {
        this.env = new ToneEnv(iFrameworkAccess, iGUIVariantProvider);
        this.env.lcMain.log(14808325, "[ToneApp.new] Before initialization");
        this.hmiApplication = new ToneHMIApplication(this.env);
        this.audioService = new AudioServiceHandler(this.env);
        this.audioListener = new HMIAudioManagementListenerImpl(this.env);
        this.amplifier = new AmplifierVariant(this.env);
        this.amplifierProvider = new AmplifierProvider(this.env);
        this.dsiSound = new DSISoundHandler(this.env, this.audioService, this.amplifier);
        this.sound = new SoundHandler(this.dsiSound, this.env);
        this.dsiSoundListener = new DSISoundListenerImpl(this.env, this.sound);
        this.atipSdisActioProxyListener = new ToneAppCommon$AtipSdisActionProxyListener(this, 0);
        this.toneVirtualButtonHandler = new ToneVirtualButtonHandler(this.env);
        AudioFactoryReset audioFactoryReset = new AudioFactoryReset(this.env.lcMain, this.dsiSound);
        this.heartbeat = new Heartbeat(this.env.lcMain, this.audioService, this.env);
        this.touchSound = new TouchSound(this.env);
        this.wirelessChargingReminder = new WirelessChargingReminder(this.env);
        DefaultMsgListener[] defaultMsgListenerArray = new DefaultMsgListener[]{audioFactoryReset, this.heartbeat.audioMsgListener, this.touchSound.audioMsgListener, this.wirelessChargingReminder};
        this.messageListener = new MsgListenerDistributor(this.env.lcMain, defaultMsgListenerArray);
        this.env.lcMain.log(14808325, "[ToneApp.new] After initialization");
    }

    public void init() {
        this.volMenuManager.createVolumeMenus();
        this.atipAudioListener = new ATIPAudioServiceListenerImpl(this.env, this.volMenuManager, this.sound);
        this.wirelessChargingReminder.init();
        Showroom showroom = new Showroom(this.env);
        RSEWizardSwitcher rSEWizardSwitcher = new RSEWizardSwitcher(this.env);
        this.soundSets = new SoundFocus(this.env, this.dsiSound);
        this.threeDMode = new ThreeDMode(this.env, this.dsiSound);
        SoundSource soundSource = new SoundSource(this.env);
        this.dsiSoundListener.addAppListener(showroom);
        this.dsiSoundListener.addAppListener(this.volMenuManager);
        this.dsiSoundListener.addAppListener(rSEWizardSwitcher);
        this.dsiSoundListener.addAppListener(this.soundSets);
        this.dsiSoundListener.addAppListener(this.threeDMode);
        this.dsiSoundListener.addAppListener(this.amplifier);
        this.dsiSoundListener.addAppListener(this.amplifierProvider);
        this.dsiSoundListener.addAppListener(this.heartbeat.appAudioListener);
        this.audioListener.addAppListener(showroom);
        this.audioListener.addAppListener(this.volMenuManager);
        this.audioListener.addAppListener(this.heartbeat.appAudioListener);
        this.audioListener.addAppListener(soundSource);
    }

    Object setService(Object object) {
        this.env.lcMain.log(-2137614336, "[ToneApp.setService] %1", object);
        if (object instanceof HMIAudioService) {
            this.audioService.registerService((HMIAudioService)object);
            return object;
        }
        if (object instanceof DSISound) {
            DSISound dSISound = (DSISound)object;
            this.dsiSound.registerDSI(dSISound);
            return object;
        }
        if (object instanceof SDSService) {
            this.volMenuManager.registerService(2, object);
            return object;
        }
        if (object instanceof PhoneService) {
            this.volMenuManager.registerService(3, object);
            return object;
        }
        if (object instanceof IViewSizeManager) {
            IViewSizeManager iViewSizeManager = (IViewSizeManager)object;
            iViewSizeManager.addViewSizeListener(this.volMenuManager);
            return object;
        }
        if (object instanceof WavePlayer) {
            WavePlayer wavePlayer = (WavePlayer)object;
            this.volMenuManager.registerService(3, wavePlayer);
            this.volMenuManager.registerService(7, wavePlayer.getSystemTonePlayer());
            this.volMenuManager.registerService(8, wavePlayer.getRingTonePlayer());
            this.heartbeat.setService(wavePlayer.getRingTonePlayer());
            this.touchSound.setService(wavePlayer.getSystemTonePlayer());
            return object;
        }
        if (object instanceof NaviService) {
            this.volMenuManager.registerService(0, object);
            this.volMenuManager.registerService(4, object);
            return object;
        }
        if (object instanceof ToneServiceListener) {
            this.volMenuManager.registerService(5, object);
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            ToneDiag toneDiag = new ToneDiag(this.env, this.audioService, this.dsiSoundListener, this.volMenuManager, this.amplifier, this.dsiSound);
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)toneDiag);
            return object;
        }
        if (object instanceof ATIPAudioService) {
            this.volMenuManager.register((ATIPAudioService)object);
            return object;
        }
        if (object instanceof IMediaFilePlayerService) {
            this.volMenuManager.registerService(3, object);
            return object;
        }
        if (object instanceof AtipAudioSdisService) {
            this.atipSdisActioProxyListener.registerService(object);
            return object;
        }
        if (object instanceof ISoundHandlerListener) {
            this.dsiSoundListener.setSdisSoundHandlerListener((ISoundHandlerListener)object);
            return object;
        }
        if (object instanceof IAudioSdisListener) {
            this.atipAudioListener.addAudioSdisListener((IAudioSdisListener)object);
            return object;
        }
        if (object instanceof AmplifierListener) {
            this.amplifierProvider.registerService((AmplifierListener)object);
            return object;
        }
        return null;
    }

    Object setService(Object object, Object object2) {
        if (object instanceof TTSService) {
            if (TTSService.CLIENT_ID_TOUCHPAD_VOLUME_MENU.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] touchpad vol: service: %1 ", object);
                this.volMenuManager.registerService(6, object);
                return object;
            }
            if (TTSService.CLIENT_ID_WIRELESS_CHARGING_VOLUME_MENU.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] wireless charging vol: service: %1 ", object);
                this.volMenuManager.registerService(11, object);
                return object;
            }
            if (TTSService.CLIENT_ID_WIRELESS_CHARGING.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] wireless charging : service: %1 ", object);
                this.wirelessChargingReminder.registerService(object);
                return object;
            }
            if (TTSService.CLIENT_ID_ETC_VOLUME_MENU.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] info announcement (ETC) : service: %1 ", object);
                this.volMenuManager.registerService(12, object);
                return object;
            }
        } else if (object instanceof IAnnouncementStateService) {
            if (IAnnouncementStateService.TA.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] Traffic announcement volume : service: %1 ", object);
                this.volMenuManager.registerService(1, object);
                return object;
            }
            if (IAnnouncementStateService.NAVI.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] Traffic guidance volume : service: %1 ", object);
                this.volMenuManager.registerService(0, object);
                return object;
            }
            if (IAnnouncementStateService.PHONE_RINGTONE.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.addingService] Ringtone volume : service: %1 ", object);
                this.volMenuManager.registerService(3, object);
                return object;
            }
            return null;
        }
        return this.setService(object);
    }

    void setNotifications(DSISound dSISound) {
        this.env.lcMain.log(-2137614336, "[ToneApp.setNotifications] %1", (Object)dSISound);
        dSISound.setNotification(this.dsiSoundListener.getNotifications(), (DSIListener)this.dsiSoundListener);
    }

    protected void removeService(Object object) {
        if (object instanceof HMIAudioService) {
            this.audioService.deregisterAudioService();
        } else if (object instanceof DSISound) {
            this.dsiSound.deregisterDSISound();
        } else if (object instanceof SDSService) {
            this.volMenuManager.deregisterService(2, object);
        } else if (object instanceof PhoneService) {
            this.volMenuManager.deregisterService(3, object);
        } else if (object instanceof WavePlayer) {
            WavePlayer wavePlayer = (WavePlayer)object;
            this.volMenuManager.deregisterService(3, wavePlayer);
            this.volMenuManager.deregisterService(7, wavePlayer.getSystemTonePlayer());
            this.volMenuManager.deregisterService(8, wavePlayer.getRingTonePlayer());
            this.heartbeat.setService(new NullRingTonePlayer(this.env.lcMain));
            this.touchSound.setService(new NullSystemTonePlayer(this.env.lcMain));
        } else if (object instanceof NaviService) {
            this.volMenuManager.deregisterService(0, object);
        } else if (object instanceof TTSService) {
            this.volMenuManager.deregisterService(6, object);
            this.volMenuManager.deregisterService(11, object);
            this.wirelessChargingReminder.deregisterService(object);
            this.env.getChoiceModel(1396838144).setValue(0);
        } else if (object instanceof AtipAudioSdisService) {
            this.atipSdisActioProxyListener.deregisterService(object);
        } else if (object instanceof ISoundHandlerListener) {
            this.dsiSoundListener.removeSdisSoundHandlerListener();
        } else if (object instanceof IAudioSdisListener) {
            this.atipAudioListener.removeAudioSdisListener((IAudioSdisListener)object);
        } else if (object instanceof AmplifierListener) {
            this.amplifierProvider.deregisterService((AmplifierListener)object);
        }
    }

    void removeService(Object object, Object object2) {
        if (object instanceof IAnnouncementStateService) {
            if (IAnnouncementStateService.TA.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.removeService] Traffic announcement volume : service: %1 ", object);
                this.volMenuManager.deregisterService(1, object);
            } else if (IAnnouncementStateService.NAVI.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.removeService] Traffic guidance volume : service: %1 ", object);
                this.volMenuManager.deregisterService(0, object);
            } else if (IAnnouncementStateService.PHONE_RINGTONE.equals(object2)) {
                this.env.lcMain.log(-2137614336, "[ToneActivator.removeService] Ringtone volume : service: %1 ", object);
                this.volMenuManager.deregisterService(3, object);
            }
        }
    }

    protected void initInputGainOffsetHandler(HMIAudioService hMIAudioService) {
        InputGainOffsetHandler inputGainOffsetHandler = new InputGainOffsetHandler(this.env, this.dsiSound);
        this.dsiSoundListener.addAppListener(inputGainOffsetHandler);
        this.audioListener.addAppListener(inputGainOffsetHandler);
        inputGainOffsetHandler.init(hMIAudioService, 0);
    }

    MsgListener getMessageListener() {
        return this.messageListener;
    }

    public VolumeRangeManager getVolumeRangeManager() {
        return this.volMenuManager;
    }

    DSISoundListener getDSISoundListener() {
        return this.dsiSoundListener;
    }

    HMIApplication getHMIApplication() {
        return this.hmiApplication;
    }

    ATIPAudioServiceListener getATIPAudioListener() {
        return this.atipAudioListener;
    }

    HMIAudioServiceListener getHMIAudioServiceListener() {
        return this.audioListener;
    }

    void setToneReady(boolean bl) {
        this.env.lcMain.log(-2137614336, "[ToneApp.setToneReady] %1", bl);
        this.env.getChoiceModel(1279397632).setValue(bl ? 1 : 0);
    }

    protected final ActionProxyListener[] getCommonActionProxyListeners() {
        return new ActionProxyListener[]{this.audioService.actionProxyListener, this.sound.actionProxyListener, this.atipSdisActioProxyListener};
    }

    protected final ActionProxyListener[] merge(ActionProxyListener[] actionProxyListenerArray, ActionProxyListener[] actionProxyListenerArray2) {
        ActionProxyListener[] actionProxyListenerArray3 = actionProxyListenerArray == null ? new ActionProxyListener[]{} : actionProxyListenerArray;
        ActionProxyListener[] actionProxyListenerArray4 = actionProxyListenerArray2 == null ? new ActionProxyListener[]{} : actionProxyListenerArray2;
        ActionProxyListener[] actionProxyListenerArray5 = new ActionProxyListener[actionProxyListenerArray3.length + actionProxyListenerArray4.length];
        System.arraycopy((Object)actionProxyListenerArray3, 0, (Object)actionProxyListenerArray5, 0, actionProxyListenerArray3.length);
        System.arraycopy((Object)actionProxyListenerArray4, 0, (Object)actionProxyListenerArray5, actionProxyListenerArray3.length, actionProxyListenerArray4.length);
        return actionProxyListenerArray5;
    }

    public WirelessChargingReminder getWirelessChargingReminder() {
        return this.wirelessChargingReminder;
    }

    public Heartbeat getHeartbeat() {
        return this.heartbeat;
    }
}

