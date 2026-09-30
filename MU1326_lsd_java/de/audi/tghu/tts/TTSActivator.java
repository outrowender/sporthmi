/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.TTSDiag
 */
package de.audi.tghu.tts;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.TTSInitialization;
import de.audi.tghu.tts.TTSOperable;
import de.audi.tghu.tts.TTSProviderServiceImpl;
import de.mib.swdiagnosis.TTSDiag;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.dsi.ifc.tts.DSITTS;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class TTSActivator
extends AbstractActivator
implements ServiceTrackerCustomizer,
TTSOperable {
    private LogChannel logCh;
    private ServiceTracker audioTracker;
    private ServiceTracker ttsTracker;
    private ServiceTracker ttsListenerTracker;
    private ServiceTracker diagnoseTracker;
    private ServiceTracker sdsTracker;
    private ServiceTracker volumeOnOffTracker;
    private ServiceRegistration sRegI18NTarget;
    private ServiceRegistration[] sRegTTSService = new ServiceRegistration[18];
    private List sRegHMIAudioService = new ArrayList(20);
    private List sRegVolumeOnOffPressList = new ArrayList(20);
    private ServiceRegistration sRegTTSListener;
    private ServiceRegistration sRegTTSListener1;
    private DSITTS ttsDSI0 = null;
    private DSITTS ttsDSI1 = null;
    private TTSProviderServiceImpl ttsProviderServiceImpl;
    private AbstractSwDiagnosis ttsDiagnose;
    private int ttsOperableCounter = 0;
    private int ttsresponseSetLanguageCounter = 0;
    private boolean alreadyRegistered = false;
    private boolean isAudioAvailable = false;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTS;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$VolumeOnOffPressListener;
    static /* synthetic */ Class class$de$audi$atip$base$IFrameworkAccess;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTSListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logCh = this.framework.getLogChannel("Fw.TTS");
        this.logCh.log(10000000, "[TTSActivator#start] called");
        this.ttsProviderServiceImpl = new TTSProviderServiceImpl(this.framework, this);
        this.registerTTSListener();
        this.registerHMIAudioServiceListeners();
        this.registerVolumeOffOnPressListeners();
        this.initTrackers();
        this.startTTSDSIs();
    }

    private void initTrackers() {
        this.logCh.log(10000000, "[TTSActivator#initTrackers] for HMIAudioServices, DSITTS and SwDiagnosis");
        this.audioTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = TTSActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)this);
        this.audioTracker.open();
        this.ttsTracker = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$tts$DSITTS == null ? (class$org$dsi$ifc$tts$DSITTS = TTSActivator.class$("org.dsi.ifc.tts.DSITTS")) : class$org$dsi$ifc$tts$DSITTS).getName(), (ServiceTrackerCustomizer)this);
        this.ttsTracker.open();
        this.diagnoseTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = TTSActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (ServiceTrackerCustomizer)this);
        this.diagnoseTracker.open();
        this.sdsTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = TTSActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)this);
        this.sdsTracker.open();
        this.volumeOnOffTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$audio$VolumeOnOffPressListener == null ? (class$de$audi$atip$interapp$audio$VolumeOnOffPressListener = TTSActivator.class$("de.audi.atip.interapp.audio.VolumeOnOffPressListener")) : class$de$audi$atip$interapp$audio$VolumeOnOffPressListener).getName(), (ServiceTrackerCustomizer)this);
        this.volumeOnOffTracker.open();
    }

    public void stop(BundleContext bundleContext) {
        this.logCh.log(10000000, "[TTSActivator#stop] called");
        this.unregisterServices();
        this.closeTracker();
        if (this.framework != null) {
            bundleContext.ungetService(bundleContext.getServiceReference((class$de$audi$atip$base$IFrameworkAccess == null ? (class$de$audi$atip$base$IFrameworkAccess = TTSActivator.class$("de.audi.atip.base.IFrameworkAccess")) : class$de$audi$atip$base$IFrameworkAccess).getName()));
            this.framework = null;
        }
        super.stop(bundleContext);
    }

    private void closeTracker() {
        this.logCh.log(10000000, "[TTSActivator#closeTracker] called");
        this.audioTracker = this.closeTracker(this.audioTracker);
        this.ttsTracker = this.closeTracker(this.ttsTracker);
        this.diagnoseTracker = this.closeTracker(this.diagnoseTracker);
        this.ttsListenerTracker = this.closeTracker(this.ttsListenerTracker);
        this.volumeOnOffTracker = this.closeTracker(this.volumeOnOffTracker);
    }

    private void unregisterServices() {
        this.logCh.log(10000000, "[TTSActivator#unregisterService] called");
        if (this.sRegTTSListener != null) {
            this.sRegTTSListener.unregister();
            this.sRegTTSListener = null;
        }
        if (this.sRegTTSListener1 != null) {
            this.sRegTTSListener1.unregister();
            this.sRegTTSListener1 = null;
        }
        if (this.sRegI18NTarget != null) {
            this.sRegI18NTarget.unregister();
            this.sRegI18NTarget = null;
        }
        this.unregisterTTSServices();
        this.unregisterHMIAudioServices();
        this.unregisterVolumeOnOffServices();
    }

    private void startTTSDSIs() {
        this.logCh.log(10000000, "[TTSActivator#startTTSDSIs] request start of TTS DSIs");
        this.framework.startDSIService((class$org$dsi$ifc$tts$DSITTS == null ? (class$org$dsi$ifc$tts$DSITTS = TTSActivator.class$("org.dsi.ifc.tts.DSITTS")) : class$org$dsi$ifc$tts$DSITTS).getName(), 0);
        if (this.framework.getSysConst(523) == 1) {
            this.framework.startDSIService((class$org$dsi$ifc$tts$DSITTS == null ? (class$org$dsi$ifc$tts$DSITTS = TTSActivator.class$("org.dsi.ifc.tts.DSITTS")) : class$org$dsi$ifc$tts$DSITTS).getName(), 1);
        }
    }

    private void registerTTSListener() {
        Hashtable hashtable;
        this.logCh.log(10000000, "[TTSActivator#registerTTSListener] register DSIListener and I18NTarget");
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("DEVICE_NAME", (class$org$dsi$ifc$tts$DSITTSListener == null ? (class$org$dsi$ifc$tts$DSITTSListener = TTSActivator.class$("org.dsi.ifc.tts.DSITTSListener")) : class$org$dsi$ifc$tts$DSITTSListener).getName());
        hashtable2.put("DEVICE_INSTANCE", new Integer(0));
        this.sRegTTSListener = this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TTSActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.ttsProviderServiceImpl.getDSITTSListenerInst0(), (Dictionary)hashtable2);
        if (this.framework.getSysConst(523) == 1) {
            hashtable = new Hashtable();
            hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$tts$DSITTSListener == null ? (class$org$dsi$ifc$tts$DSITTSListener = TTSActivator.class$("org.dsi.ifc.tts.DSITTSListener")) : class$org$dsi$ifc$tts$DSITTSListener).getName());
            hashtable.put("DEVICE_INSTANCE", new Integer(1));
            this.sRegTTSListener1 = this.bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TTSActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.ttsProviderServiceImpl.getDSITTSListenerInst1(), (Dictionary)hashtable);
        }
        hashtable = new Hashtable();
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_TTS");
        if (this.sRegI18NTarget == null) {
            this.sRegI18NTarget = this.bundleContext.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = TTSActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.ttsProviderServiceImpl, (Dictionary)hashtable);
        }
    }

    private void registerHMIAudioServiceListeners() {
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(0), HMIAudioService.CLIENT_TTS_TOUCHPAD);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(1), HMIAudioService.CLIENT_TTS_TOUCHPAD_VOLUMEMENU);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(3), HMIAudioService.CLIENT_TTS_DV);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(2), HMIAudioService.CLIENT_TTS_OL);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(4), HMIAudioService.CLIENT_TTS_URR);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(9), HMIAudioService.CLIENT_TTS_URR);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(6), HMIAudioService.CLIENT_TTS_ADB);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(7), HMIAudioService.CLIENT_TTS_REMOTE_HMI);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(8), HMIAudioService.CLIENT_TTS_MESSAGING);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(15), HMIAudioService.CLIENT_TTS_WIRELESS_CHARGING);
        this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(16), HMIAudioService.CLIENT_TTS_WIRELESS_CHARGING_VOLUMEMENU);
        if (this.framework.isAsia()) {
            this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(10), HMIAudioService.TTS_DSRC_LOW);
            this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(11), HMIAudioService.TTS_DSRC_HIGH);
            this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(12), HMIAudioService.CLIENT_TTS_DV);
            this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(14), HMIAudioService.TTS_DSRC_LOW);
            this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(13), HMIAudioService.TTS_DSRC_HIGH);
            this.registerHMIAudioServiceListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(17), HMIAudioService.CLIENT_TTS_ETC_VOLUMEMENU);
        }
    }

    private void registerVolumeOffOnPressListeners() {
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(0));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(1));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(3));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(2));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(4));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(9));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(6));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(7));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(8));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(15));
        this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(16));
        if (this.framework.isAsia()) {
            this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(10));
            this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(11));
            this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(12));
            this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(14));
            this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSingleSpeakInitializationObject(13));
            this.registerVolumeOnOffPressListener(this.ttsProviderServiceImpl.getTTSSessionBasedInitializationObject(17));
        }
    }

    private void registerHMIAudioServiceListener(TTSInitialization tTSInitialization, Integer n) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", n);
        this.logCh.log(10000000, "[TTSActivator#registerHMIAudioServiceListener] register HMIAudioServiceListener for AudioService under clientID=%1", (Object)n);
        this.sRegHMIAudioService.add(this.bundleContext.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = TTSActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)tTSInitialization.getAudioListener(), (Dictionary)hashtable));
    }

    private void registerVolumeOnOffPressListener(TTSInitialization tTSInitialization) {
        this.logCh.log(10000000, "[TTSActivator#registerVolumeOnOffPressListener] register VolumeOnOffPressListener for AudioService");
        this.sRegVolumeOnOffPressList.add(this.bundleContext.registerService((class$de$audi$atip$interapp$audio$VolumeOnOffPressListener == null ? (class$de$audi$atip$interapp$audio$VolumeOnOffPressListener = TTSActivator.class$("de.audi.atip.interapp.audio.VolumeOnOffPressListener")) : class$de$audi$atip$interapp$audio$VolumeOnOffPressListener).getName(), (Object)tTSInitialization.getVolumeOnOffPressListener(), (Dictionary)new Hashtable(0)));
    }

    public void registerAndTrackServices() {
        this.logCh.log(10000000, "[TTSActivator#registerAndTrackServices]");
        this.registerAndTrackTTSServices();
        this.framework.getStartupMgr().triggerTTSAvailable();
    }

    private void registerAndTrackTTSServices() {
        this.logCh.log(10000000, "[TTSActivator#registerAndTrackTTSServices]");
        this.registerTTSSDSService(TTSService.CLIENT_ID_SDS);
        String string = this.framework.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode();
        if (!("da_DK".equals(string) || "fi_FI".equals(string) || "sl_SI".equals(string) || "uk_UA".equals(string) || "ro_RO".equals(string) || "el_GR".equals(string) || "ms_MY".equals(string))) {
            this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_TOUCHPAD);
            this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_TOUCHPAD_VOLUME_MENU);
            this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_MESSAGING);
            this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_REMOTE_HMI);
            this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_WIRELESS_CHARGING_VOLUME_MENU);
            this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_WIRELESS_CHARGING);
            this.framework.getHMIService().getChoiceModel(5617).setValue(1);
        } else {
            this.framework.getHMIService().getChoiceModel(5617).setValue(0);
        }
        this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_TMC_LIST);
        this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_TMC_DETAIL_VIEW);
        this.registerTTSSessionBaseSpeakService(TTSService.CLIENT_ID_ETC_VOLUME_MENU);
        this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_ADB);
        this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT);
        this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_TMC_ONROAD_ONROUTE_URGENT_NO_TEL);
        if (this.framework.isAsia()) {
            this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_DSRC_WARNING);
            this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_DSRC_INFO);
            this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_DSRC_MESSAGE);
            this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_ETC_INFORMATION);
            this.registerTTSSingleSpeakService(TTSService.CLIENT_ID_ETC_WARNING);
        }
        this.logCh.log(10000000, "[TTSActivator#registerAndTrackTTSServices] registering of at most %1 TTSService done", 18L);
        this.ttsListenerTracker = this.closeTracker(this.ttsListenerTracker);
        this.ttsListenerTracker = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = TTSActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (ServiceTrackerCustomizer)this);
        this.ttsListenerTracker.open();
        this.logCh.log(10000000, "[TTSActivator#registerAndTrackTTSServices] tracking TTSListener done");
    }

    private void registerTTSSingleSpeakService(Integer n) {
        this.logCh.log(10000000, "[TTSActivator#registerTTSSingleSpeakService] client:%1", (Object)n);
        Hashtable hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", n);
        TTSSingleSpeakService tTSSingleSpeakService = this.ttsProviderServiceImpl.getTTSSingleSpeakService(n);
        this.sRegTTSService[n.intValue()] = this.bundleContext.registerService((class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = TTSActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (Object)tTSSingleSpeakService, (Dictionary)hashtable);
    }

    private void registerTTSSessionBaseSpeakService(Integer n) {
        this.logCh.log(10000000, "[TTSActivator#registerTTSSessionBaseSpeakService] client:%1", (Object)n);
        Hashtable hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", n);
        TTSSessionBasedService tTSSessionBasedService = this.ttsProviderServiceImpl.getTTSSessionBasedService(n);
        this.sRegTTSService[n.intValue()] = this.bundleContext.registerService((class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = TTSActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (Object)tTSSessionBasedService, (Dictionary)hashtable);
    }

    private void registerTTSSDSService(Integer n) {
        this.logCh.log(10000000, "[TTSActivator#registerTTSSDSService] client:%1", (Object)n);
        Hashtable hashtable = new Hashtable();
        hashtable.put("TTS_CLIENT_ID", n);
        TTSSDSService tTSSDSService = this.ttsProviderServiceImpl.getTTSSDSService(n);
        this.sRegTTSService[n.intValue()] = this.bundleContext.registerService((class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = TTSActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (Object)tTSSDSService, (Dictionary)hashtable);
    }

    private void unregisterTTSServices() {
        for (int i2 = 0; i2 < this.sRegTTSService.length; ++i2) {
            if (this.sRegTTSService[i2] == null) continue;
            this.logCh.log(10000000, "[TTSActivator#unregisterTTSServices] %1", (Object)this.sRegTTSService[i2]);
            this.sRegTTSService[i2].unregister();
            this.sRegTTSService[i2] = null;
        }
    }

    private void unregisterHMIAudioServices() {
        for (int i2 = this.sRegHMIAudioService.size(); i2 > 0; --i2) {
            ServiceRegistration serviceRegistration = (ServiceRegistration)this.sRegHMIAudioService.remove(i2 - 1);
            if (serviceRegistration == null) continue;
            this.logCh.log(10000000, "[TTSActivator#unregisterHMIAudioServices] %1", (Object)serviceRegistration);
            serviceRegistration.unregister();
        }
        this.sRegHMIAudioService.clear();
    }

    private void unregisterVolumeOnOffServices() {
        for (int i2 = this.sRegVolumeOnOffPressList.size(); i2 > 0; --i2) {
            ServiceRegistration serviceRegistration = (ServiceRegistration)this.sRegVolumeOnOffPressList.remove(i2 - 1);
            if (serviceRegistration == null) continue;
            this.logCh.log(10000000, "[TTSActivator#unregisterVolumeOnOffServices] %1", (Object)serviceRegistration);
            serviceRegistration.unregister();
        }
        this.sRegVolumeOnOffPressList.clear();
    }

    private void addTTSService(DSITTS dSITTS, int n) {
        if (n == 0) {
            this.logCh.log(10000000, "[TTSActivator#addTTSService] Instance 0 found");
            this.ttsDSI0 = dSITTS;
            this.ttsProviderServiceImpl.setTTSInstance0(this.ttsDSI0);
            this.checkAvailableDSI();
        } else if (n == 1) {
            this.logCh.log(10000000, "[TTSActivator#addTTSService] Instance 1 found");
            this.ttsDSI1 = dSITTS;
            this.ttsProviderServiceImpl.setTTSInstance1(this.ttsDSI1);
            this.checkAvailableDSI();
        } else {
            this.logCh.log(10000000, "[TTSActivator#addTTSService] Unknown INSTANCE '%1'", (long)n);
        }
    }

    private synchronized void checkAvailableDSI() {
        if (!this.isAudioAvailable()) {
            this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] Audio DSI is not available yet.");
            return;
        }
        this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] Audio DSI is available");
        if (this.framework.getSysConst(523) == 1) {
            if (this.ttsDSI0 == null || this.ttsDSI1 == null) {
                this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTS DSI #0 or #1 is not available yet.");
                return;
            }
            this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTS DSI #0 and #1 available");
            if (this.ttsOperableCounter >= 2 && this.ttsresponseSetLanguageCounter >= 2) {
                if (!this.isAlreadyRegistered()) {
                    this.logCh.log(1000000, "[TTSActivator#checkAvailableDSI] TTS DSI #0 and #1 are fully operable, register TTSServices");
                    this.registerAndTrackServices();
                    this.setAlreadyRegistered(true);
                } else {
                    this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTSServices already registered, do nothing.");
                }
            } else {
                this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] not ready: TTS Operable %1/2 ResponseSetLanuage %2/2", (long)this.ttsOperableCounter, (long)this.ttsresponseSetLanguageCounter);
            }
            return;
        }
        if (this.ttsDSI0 == null) {
            this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTS DSI #0 is not available yet.");
            return;
        }
        this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTS DSI #0 available.");
        if (this.ttsOperableCounter >= 1 && this.ttsresponseSetLanguageCounter >= 1) {
            if (!this.isAlreadyRegistered()) {
                this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTS DSI #0 is fully operable, register TTSServices");
                this.registerAndTrackServices();
                this.setAlreadyRegistered(true);
            } else {
                this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] TTSServices already registered, do nothing.");
            }
        } else {
            this.logCh.log(10000000, "[TTSActivator#checkAvailableDSI] not ready: TTS Operable %1/1 ResponseSetLanuage %2/1", (long)this.ttsOperableCounter, (long)this.ttsresponseSetLanguageCounter);
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getBundleContext().getService(serviceReference);
        this.logCh.log(10000000, "[TTSActivator#addingService] service : %1", object);
        if (object instanceof HMIAudioService) {
            Integer n;
            HMIAudioService hMIAudioService;
            if (this.isPropertyAvailable("AUDIO_CLIENT_ID", serviceReference) && (hMIAudioService = this.ttsProviderServiceImpl.addAudioService((HMIAudioService)object, n = (Integer)serviceReference.getProperty("AUDIO_CLIENT_ID"))) != null) {
                this.setAudioAvailable(true);
                this.checkAvailableDSI();
                return hMIAudioService;
            }
            this.getBundleContext().ungetService(serviceReference);
            return null;
        }
        if (object instanceof DSITTS) {
            if (this.isPropertyAvailable("DEVICE_INSTANCE", serviceReference)) {
                Integer n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
                if (n != null) {
                    this.addTTSService((DSITTS)object, n);
                } else {
                    this.logCh.log(10000000, "No INSTANCE of TTS DSI defined, do nothing!");
                }
            }
        } else if (object instanceof SwDiagnosisManager) {
            if (this.ttsDiagnose == null) {
                this.ttsDiagnose = new TTSDiag(this, this.framework);
            }
            ((SwDiagnosisManager)object).addDiagGateway(this.ttsDiagnose);
            this.getBundleContext().ungetService(serviceReference);
        } else if (object instanceof TTSListener) {
            if (this.isPropertyAvailable("TTS_CLIENT_ID", serviceReference)) {
                int n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
                this.ttsProviderServiceImpl.registerListener((TTSListener)object, n);
            }
        } else if (object instanceof SDSService) {
            this.ttsProviderServiceImpl.setSDSService((SDSService)object);
        } else {
            this.logCh.log(100000, "track unwanted service: %1", object);
            this.getBundleContext().ungetService(serviceReference);
            return null;
        }
        return object;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        this.logCh.log(10000000, "[TTSActivator#modifiedService] modified service : %1 [ignored]", object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removedService(ServiceReference serviceReference, Object object) {
        this.logCh.log(10000000, "[TTSActivator#removedService] removed service : %1", object);
        if (object instanceof HMIAudioService) {
            this.setAudioAvailable(false);
            Integer n = (Integer)serviceReference.getProperty("AUDIO_CLIENT_ID");
            this.ttsProviderServiceImpl.addAudioService(null, n);
        } else if (object instanceof DSITTS) {
            int n = (Integer)serviceReference.getProperty("DEVICE_INSTANCE");
            if (n == 0) {
                this.ttsDSI0 = null;
            } else if (n == 1) {
                this.ttsDSI1 = null;
            } else {
                this.logCh.log(10000000, "[TTSActivator#removedService] unknown DSITTS service instance : %1", (long)n);
                this.getBundleContext().ungetService(serviceReference);
                return;
            }
            TTSActivator tTSActivator = this;
            synchronized (tTSActivator) {
                --this.ttsOperableCounter;
            }
            this.setAlreadyRegistered(false);
            this.unregisterServices();
        } else if (object instanceof TTSListener) {
            Integer n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
            this.logCh.log(10000000, "[TTSActivator#removedService] TTSListener clientID : %1 - doing nothing", (Object)n);
        } else {
            this.logCh.log(10000000, "[TTSActivator#removedService] unknown service : %1", object);
        }
        this.getBundleContext().ungetService(serviceReference);
    }

    public synchronized void fullyOperable() {
        ++this.ttsOperableCounter;
        this.logCh.log(10000000, "[TTSActivator#fullyOperable] TTS operable counter: %1", (long)this.ttsOperableCounter);
        this.checkAvailableDSI();
    }

    public synchronized void responseSetLanguageComplete() {
        ++this.ttsresponseSetLanguageCounter;
        this.logCh.log(10000000, "[TTSActivator#responseSetLanguageComplete] TTS responseSetLanguage counter: %1", (long)this.ttsresponseSetLanguageCounter);
        this.checkAvailableDSI();
    }

    private synchronized boolean isAlreadyRegistered() {
        return this.alreadyRegistered;
    }

    private synchronized void setAlreadyRegistered(boolean bl) {
        this.alreadyRegistered = bl;
    }

    private synchronized boolean isAudioAvailable() {
        return this.isAudioAvailable;
    }

    private synchronized void setAudioAvailable(boolean bl) {
        this.isAudioAvailable = bl;
    }

    public void muDomainIsAvailable(int n, int n2) {
    }

    public TTSProviderServiceImpl getTtsProviderServiceImpl() {
        return this.ttsProviderServiceImpl;
    }

    public void stopTTSServices() {
        this.logCh.log(10000000, "[TTSActivator#stopTTSServices]");
        this.setTtsresponseSetLanguageCounter(0);
        this.setAlreadyRegistered(false);
        this.unregisterTTSServices();
    }

    public synchronized int getTtsresponseSetLanguageCounter() {
        return this.ttsresponseSetLanguageCounter;
    }

    public synchronized void setTtsresponseSetLanguageCounter(int n) {
        this.ttsresponseSetLanguageCounter = n;
    }

    private boolean isPropertyAvailable(String string, ServiceReference serviceReference) {
        return serviceReference.getProperty(string) != null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

