/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.AbstractSpeaker;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.SDSSpeaker;
import de.audi.tghu.tts.SessionSpeaker;
import de.audi.tghu.tts.SimplifiedSessionSpeaker;
import de.audi.tghu.tts.SingleSpeaker;
import de.audi.tghu.tts.TTSInitialization;
import de.audi.tghu.tts.TTSOperable;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.DSITTSListener;

public class TTSProviderServiceImpl
implements I18NTarget {
    private LogChannel logCh;
    private TTSSessionBasedService touchpadTTSService;
    private TTSSessionBasedService touchpadVolumeMenuTTSService;
    private TTSSingleSpeakService tmcOnRouteRoadUrgentTTSService;
    private TTSSingleSpeakService tmcOnRouteRoadUrgentNoTelTTSService;
    private TTSSessionBasedService tmcListTTSService;
    private TTSSessionBasedService tmcDetailViewTTSService;
    private TTSSingleSpeakService adbTTSService;
    private TTSSessionBasedService remoteHMITTSService;
    private TTSSessionBasedService messagingTTSService;
    private TTSSDSService sdsTTSService;
    private TTSSingleSpeakService dsrcWarningTTSService;
    private TTSSingleSpeakService dsrcInfoTTSService;
    private TTSSingleSpeakService dsrcMessageTTSService;
    private TTSSingleSpeakService etcWarningTTSService;
    private TTSSingleSpeakService etcInfoTTSService;
    private TTSSessionBasedService wirelessChargingVolumeMenuTTSService;
    private TTSSingleSpeakService wirelessChargingTTSService;
    private TTSSessionBasedService etcVolumeMenuTTSService;
    private DSITTSCaller dsiTTSCallerInst0;
    private DSITTSCaller dsiTTSCallerInst1;
    private final TTSOperable observer;
    private final IFrameworkAccess frameworkAccess;

    public TTSProviderServiceImpl(IFrameworkAccess iFrameworkAccess, TTSOperable tTSOperable) {
        this.frameworkAccess = iFrameworkAccess;
        this.observer = tTSOperable;
        this.logCh = iFrameworkAccess.getLogChannel("Fw.TTS");
        this.logCh.log(-2137614336, "[TTSProviderServiceImpl#ctor] Called.");
        this.dsiTTSCallerInst0 = new DSITTSCaller(iFrameworkAccess, tTSOperable);
        this.dsiTTSCallerInst0.setInstance(0);
        boolean bl = iFrameworkAccess.getSysConst(4263) == 1;
        this.touchpadTTSService = new SessionSpeaker(false, iFrameworkAccess.getLogChannel("Fw.TTS.Touchpad"), this.dsiTTSCallerInst0, this.getTouchPadAudioConnection(), 23);
        this.touchpadVolumeMenuTTSService = new SessionSpeaker(false, iFrameworkAccess.getLogChannel("App.Tone.Main"), this.dsiTTSCallerInst0, 132, 24);
        this.tmcDetailViewTTSService = new SessionSpeaker(false, iFrameworkAccess.getLogChannel("Fw.TTS.TMCDetailView"), this.dsiTTSCallerInst0, 114, 21);
        this.tmcListTTSService = new SessionSpeaker(false, iFrameworkAccess.getLogChannel("Fw.TTS.TMCList"), this.dsiTTSCallerInst0, 114, 22);
        this.sdsTTSService = new SDSSpeaker(iFrameworkAccess.getLogChannel("Fw.TTS.SDS"), this.dsiTTSCallerInst0, 1);
        if (this.frameworkAccess.getSysConst(523) == 1) {
            this.dsiTTSCallerInst1 = new DSITTSCaller(iFrameworkAccess, tTSOperable);
            this.dsiTTSCallerInst1.setInstance(1);
        }
        DSITTSCaller dSITTSCaller = this.getNaviDSRTTSInstance();
        this.tmcOnRouteRoadUrgentTTSService = new SingleSpeaker(iFrameworkAccess.getLogChannel("Fw.TTS.TMCOnRouteRoadUrgent"), dSITTSCaller, 118, 31);
        this.tmcOnRouteRoadUrgentNoTelTTSService = new SingleSpeaker(iFrameworkAccess.getLogChannel("Fw.TTS.TMCOnRouteRoadUrgentNoTel"), dSITTSCaller, 119, 32);
        int n = iFrameworkAccess.getSysConst(523) == 1 ? 125 : 114;
        this.adbTTSService = new SingleSpeaker(iFrameworkAccess.getLogChannel("Fw.TTS.ADB"), this.dsiTTSCallerInst0, n, 25);
        this.remoteHMITTSService = new SessionSpeaker(bl, iFrameworkAccess.getLogChannel("Fw.TTS.RemoteHMI"), this.dsiTTSCallerInst0, 127, 26);
        this.messagingTTSService = new SessionSpeaker(bl, iFrameworkAccess.getLogChannel("Fw.TTS.Messaging"), this.dsiTTSCallerInst0, 126, 27);
        this.wirelessChargingTTSService = new SingleSpeaker(iFrameworkAccess.getLogChannel("Fw.TTS.Wireless"), this.dsiTTSCallerInst0, 142, 29);
        this.wirelessChargingVolumeMenuTTSService = new SessionSpeaker(false, iFrameworkAccess.getLogChannel("Fw.TTS.WirelessMenu"), this.dsiTTSCallerInst0, 143, 28);
        if (iFrameworkAccess.isAsia()) {
            this.createNavAsiaServices();
        }
    }

    private void createNavAsiaServices() {
        this.dsrcWarningTTSService = new SimplifiedSessionSpeaker(this.frameworkAccess.getLogChannel("Fw.TTS.DSRC.Info"), this.dsiTTSCallerInst0, 138, 33);
        this.dsrcInfoTTSService = new SimplifiedSessionSpeaker(this.frameworkAccess.getLogChannel("Fw.TTS.DSRC.Info"), this.dsiTTSCallerInst0, 115, 34);
        this.etcInfoTTSService = new SimplifiedSessionSpeaker(this.frameworkAccess.getLogChannel("Fw.TTS.ETC.Info"), this.dsiTTSCallerInst0, 115, 35);
        this.etcWarningTTSService = new SimplifiedSessionSpeaker(this.frameworkAccess.getLogChannel("Fw.TTS.ETC.Info"), this.dsiTTSCallerInst0, 138, 36);
        this.dsrcMessageTTSService = new SimplifiedSessionSpeaker(this.frameworkAccess.getLogChannel("Fw.TTS.DSRC.Info"), this.dsiTTSCallerInst0, 140, 37);
        this.etcVolumeMenuTTSService = new SessionSpeaker(false, this.frameworkAccess.getLogChannel("Fw.TTS.ETCVolume"), this.dsiTTSCallerInst0, 139, 38);
    }

    public HMIAudioService addAudioService(HMIAudioService hMIAudioService, Integer n) {
        this.logCh.log(1078071040, "[TTSProviderServiceImpl#setAudioDSI] client:%2 %1", (Object)hMIAudioService, (Object)n);
        TTSInitialization tTSInitialization = null;
        if (HMIAudioService.CLIENT_TTS_TOUCHPAD.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(0);
        } else if (HMIAudioService.CLIENT_TTS_TOUCHPAD_VOLUMEMENU.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(1);
        } else if (HMIAudioService.CLIENT_TTS_OL.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(2);
        } else if (HMIAudioService.CLIENT_TTS_REMOTE_HMI.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(7);
        } else if (HMIAudioService.CLIENT_TTS_MESSAGING.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(8);
        } else if (HMIAudioService.CLIENT_TTS_WIRELESS_CHARGING_VOLUMEMENU.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(16);
        } else if (HMIAudioService.CLIENT_TTS_ETC_VOLUMEMENU.equals(n)) {
            tTSInitialization = this.getTTSSessionBasedInitializationObject(17);
        } else if (HMIAudioService.CLIENT_TTS_ADB.equals(n)) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(6);
        } else if (HMIAudioService.CLIENT_TTS_WIRELESS_CHARGING.equals(n)) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(15);
        } else if (HMIAudioService.CLIENT_TTS_DV.equals(n) && !this.frameworkAccess.isAsia()) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(3);
        } else if (HMIAudioService.CLIENT_TTS_DV.equals(n) && this.frameworkAccess.isAsia()) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(12);
        } else if (HMIAudioService.TTS_DSRC_LOW.equals(n) && this.frameworkAccess.isAsia()) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(11);
            TTSInitialization tTSInitialization2 = this.getTTSSingleSpeakInitializationObject(14);
            if (tTSInitialization == null || tTSInitialization2 == null) {
                return null;
            }
            tTSInitialization2.setAudioService(hMIAudioService);
        } else if (HMIAudioService.TTS_DSRC_HIGH.equals(n) && this.frameworkAccess.isAsia()) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(10);
            TTSInitialization tTSInitialization3 = this.getTTSSingleSpeakInitializationObject(13);
            if (tTSInitialization == null || tTSInitialization3 == null) {
                return null;
            }
            tTSInitialization3.setAudioService(hMIAudioService);
        } else if (HMIAudioService.CLIENT_TTS_URR.equals(n)) {
            tTSInitialization = this.getTTSSingleSpeakInitializationObject(4);
            TTSInitialization tTSInitialization4 = this.getTTSSingleSpeakInitializationObject(9);
            if (tTSInitialization == null || tTSInitialization4 == null) {
                return null;
            }
            tTSInitialization4.setAudioService(hMIAudioService);
        }
        if (tTSInitialization == null) {
            return null;
        }
        tTSInitialization.setAudioService(hMIAudioService);
        return hMIAudioService;
    }

    @Override
    public void setLanguage(Language language) {
        this.logCh.log(-2137614336, "[TTSProviderServiceImpl#setLanguage] Called, name: %1", (Object)language);
        this.observer.stopTTSServices();
        this.dsiTTSCallerInst0.setLanguage(language, null);
        if (this.dsiTTSCallerInst1 != null) {
            this.dsiTTSCallerInst1.setLanguage(language, null);
        }
    }

    public void setTTSInstance0(DSITTS dSITTS) {
        this.logCh.log(-2137614336, "[TTSProviderServiceImpl#setTTSInstance0] %1", (Object)dSITTS);
        this.dsiTTSCallerInst0.setTTSDSI(dSITTS);
        this.logCh.log(-2137614336, "[TTSProviderServiceImpl#setTTSInstance0] Initialize TTS INSTANCE 0.");
        this.getSDSTTSServiceImpl().init();
    }

    public void setTTSInstance1(DSITTS dSITTS) {
        this.logCh.log(-2137614336, "[TTSProviderServiceImpl#setTTSInstance1] %1", (Object)dSITTS);
        this.dsiTTSCallerInst1.setTTSDSI(dSITTS);
        this.logCh.log(-2137614336, "[TTSProviderServiceImpl#setTTSInstance1] Initialize TTS INSTANCE 1");
        this.getTTSSingleSpeakInitializationObject(4).init();
    }

    DSITTSListener getDSITTSListenerInst0() {
        return this.dsiTTSCallerInst0;
    }

    DSITTSListener getDSITTSListenerInst1() {
        return this.dsiTTSCallerInst1;
    }

    public TTSSingleSpeakService getTTSSingleSpeakService(int n) {
        TTSSingleSpeakService tTSSingleSpeakService;
        switch (n) {
            case 4: {
                tTSSingleSpeakService = this.tmcOnRouteRoadUrgentTTSService;
                break;
            }
            case 9: {
                tTSSingleSpeakService = this.tmcOnRouteRoadUrgentNoTelTTSService;
                break;
            }
            case 6: {
                tTSSingleSpeakService = this.adbTTSService;
                break;
            }
            case 10: {
                tTSSingleSpeakService = this.dsrcWarningTTSService;
                break;
            }
            case 11: {
                tTSSingleSpeakService = this.dsrcInfoTTSService;
                break;
            }
            case 12: {
                tTSSingleSpeakService = this.dsrcMessageTTSService;
                break;
            }
            case 13: {
                tTSSingleSpeakService = this.etcWarningTTSService;
                break;
            }
            case 14: {
                tTSSingleSpeakService = this.etcInfoTTSService;
                break;
            }
            case 15: {
                tTSSingleSpeakService = this.wirelessChargingTTSService;
                break;
            }
            default: {
                this.logCh.log(-1601830656, "TTSProviderServiceImpl#getTTSSingleSpeakService: no TTS-Service found for clientID %1", (long)n);
                tTSSingleSpeakService = null;
            }
        }
        return tTSSingleSpeakService;
    }

    TTSInitialization getTTSSingleSpeakInitializationObject(int n) {
        return (TTSInitialization)((Object)this.getTTSSingleSpeakService(n));
    }

    public TTSSessionBasedService getTTSSessionBasedService(int n) {
        TTSSessionBasedService tTSSessionBasedService;
        switch (n) {
            case 0: {
                tTSSessionBasedService = this.touchpadTTSService;
                break;
            }
            case 1: {
                tTSSessionBasedService = this.touchpadVolumeMenuTTSService;
                break;
            }
            case 3: {
                tTSSessionBasedService = this.tmcDetailViewTTSService;
                break;
            }
            case 2: {
                tTSSessionBasedService = this.tmcListTTSService;
                break;
            }
            case 8: {
                tTSSessionBasedService = this.messagingTTSService;
                break;
            }
            case 7: {
                tTSSessionBasedService = this.remoteHMITTSService;
                break;
            }
            case 16: {
                tTSSessionBasedService = this.wirelessChargingVolumeMenuTTSService;
                break;
            }
            case 17: {
                tTSSessionBasedService = this.etcVolumeMenuTTSService;
                break;
            }
            default: {
                this.logCh.log(-1601830656, "TTSProviderServiceImpl#getTTSSessionBasedService: no TTS-Service found for clientID %1", (long)n);
                tTSSessionBasedService = null;
            }
        }
        return tTSSessionBasedService;
    }

    TTSInitialization getTTSSessionBasedInitializationObject(int n) {
        return (TTSInitialization)((Object)this.getTTSSessionBasedService(n));
    }

    public TTSSDSService getTTSSDSService(int n) {
        return this.sdsTTSService;
    }

    private TTSInitialization getSDSTTSServiceImpl() {
        return (TTSInitialization)((Object)this.sdsTTSService);
    }

    private TTSService getTTSService(int n) {
        TTSService tTSService = null;
        switch (n) {
            case 6: {
                tTSService = this.adbTTSService;
                break;
            }
            case 8: {
                tTSService = this.messagingTTSService;
                break;
            }
            case 7: {
                tTSService = this.remoteHMITTSService;
                break;
            }
            case 5: {
                tTSService = this.sdsTTSService;
                break;
            }
            case 3: {
                tTSService = this.tmcDetailViewTTSService;
                break;
            }
            case 2: {
                tTSService = this.tmcListTTSService;
                break;
            }
            case 4: {
                tTSService = this.tmcOnRouteRoadUrgentTTSService;
                break;
            }
            case 9: {
                tTSService = this.tmcOnRouteRoadUrgentNoTelTTSService;
                break;
            }
            case 0: {
                tTSService = this.touchpadTTSService;
                break;
            }
            case 1: {
                tTSService = this.touchpadVolumeMenuTTSService;
                break;
            }
            case 10: {
                tTSService = this.dsrcWarningTTSService;
                break;
            }
            case 11: {
                tTSService = this.dsrcInfoTTSService;
                break;
            }
            case 12: {
                tTSService = this.dsrcMessageTTSService;
                break;
            }
            case 13: {
                tTSService = this.etcWarningTTSService;
                break;
            }
            case 14: {
                tTSService = this.etcInfoTTSService;
                break;
            }
            case 16: {
                tTSService = this.wirelessChargingVolumeMenuTTSService;
                break;
            }
            case 15: {
                tTSService = this.wirelessChargingTTSService;
                break;
            }
            case 17: {
                tTSService = this.etcVolumeMenuTTSService;
                break;
            }
            default: {
                this.logCh.log(-1601830656, "[TTSProviderServiceImpl#getTTSService] unknown clientID : %1 ", (long)n);
            }
        }
        return tTSService;
    }

    public void registerListener(TTSListener tTSListener, int n) {
        AbstractSpeaker abstractSpeaker = (AbstractSpeaker)((Object)this.getTTSService(n));
        if (abstractSpeaker != null) {
            this.logCh.log(1078071040, "[TTSProviderServiceImpl#registerListener] clientID : %2 %1", (Object)tTSListener, (long)n);
            abstractSpeaker.setTTSListener(tTSListener);
        }
    }

    private DSITTSCaller getNaviDSRTTSInstance() {
        if (this.frameworkAccess.getSysConst(523) == 1) {
            return this.dsiTTSCallerInst1;
        }
        return this.dsiTTSCallerInst0;
    }

    private int getTouchPadAudioConnection() {
        if (this.frameworkAccess.getSysConst(4168) == 7) {
            return 122;
        }
        return 129;
    }

    public void setSDSService(SDSService sDSService) {
        if (sDSService == null) {
            return;
        }
        sDSService.registerStatusListener((ISDSServiceStatusListener)((Object)this.messagingTTSService));
        sDSService.registerStatusListener((ISDSServiceStatusListener)((Object)this.remoteHMITTSService));
    }
}

