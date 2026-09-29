/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.tuner.app.AppTuner;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.rsdb.RadioDataListenerImpl;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.itunes.ITunesTaggingDSI;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.sdars.DSISDARSTuner;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TunerActivatorBase
extends AbstractActivator
implements ServiceTrackerCustomizer {
    private boolean trackerInitialized = false;
    private ServiceTracker tracker;
    private ServiceTracker trackerGracenoteSrv;
    private ServiceTracker trackerTimeUnits;
    private ServiceRegistration sregGracenoteService = null;
    private Logger logger;
    protected AppTuner appTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIUnifiedTuner;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTuner;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSSeek;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncement;
    static /* synthetic */ Class class$de$audi$tghu$waveplayer$WavePlayer;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerServiceListener;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$tuner$ifc$IRadioInterappListener;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingService;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioData;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTagging;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusClient;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$diag$IDiagnosisApp;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetDefinitionHandler;
    static /* synthetic */ Class class$de$audi$atip$preset$IAppPresetExecutionHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelStateListener;
    static /* synthetic */ Class class$de$audi$tuner$ifc$IRadioInterappService;
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IHistoryListService;
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IHistoryVetoService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncementListener;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIUnifiedTunerListener;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTunerListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSSeekListener;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioDataListener;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTaggingListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$tuner$app$AppTuner;
    static /* synthetic */ Class class$de$audi$atip$interapp$AMFMTunerService;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IGracenoteService;
    static /* synthetic */ Class class$de$audi$atip$interapp$radio$IGracenoteServiceListener;

    public void start(BundleContext bundleContext, ITunerVariantExt iTunerVariantExt) {
        super.start(bundleContext);
        Utilities.init(this.framework, this.framework.getSysApp().getDiagnosisCOD());
        this.logger = new Logger(this.framework);
        this.appTuner = new AppTuner(this.logger, this.framework, iTunerVariantExt);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.tracker.close();
        if (this.trackerGracenoteSrv != null) {
            this.trackerGracenoteSrv.close();
            this.trackerGracenoteSrv = null;
        }
        if (this.trackerTimeUnits != null) {
            this.trackerTimeUnits.close();
            this.trackerTimeUnits = null;
        }
        if (this.sregGracenoteService != null) {
            this.sregGracenoteService.unregister();
            this.sregGracenoteService = null;
        }
        this.appTuner = null;
        TunerProxyManager.getInstance().shutdown();
        super.stop(bundleContext);
    }

    private void initTracker() {
        if (this.trackerInitialized) {
            return;
        }
        ArrayList arrayList = new ArrayList(20);
        arrayList.add((class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner).getName());
        arrayList.add((class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner).getName());
        arrayList.add((class$org$dsi$ifc$radio$DSIUnifiedTuner == null ? (class$org$dsi$ifc$radio$DSIUnifiedTuner = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIUnifiedTuner")) : class$org$dsi$ifc$radio$DSIUnifiedTuner).getName());
        arrayList.add((class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = TunerActivatorBase.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName());
        arrayList.add((class$org$dsi$ifc$sdars$DSISDARSSeek == null ? (class$org$dsi$ifc$sdars$DSISDARSSeek = TunerActivatorBase.class$("org.dsi.ifc.sdars.DSISDARSSeek")) : class$org$dsi$ifc$sdars$DSISDARSSeek).getName());
        arrayList.add((class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = TunerActivatorBase.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement).getName());
        arrayList.add((class$de$audi$tghu$waveplayer$WavePlayer == null ? (class$de$audi$tghu$waveplayer$WavePlayer = TunerActivatorBase.class$("de.audi.tghu.waveplayer.WavePlayer")) : class$de$audi$tghu$waveplayer$WavePlayer).getName());
        arrayList.add((class$de$audi$atip$interapp$TunerServiceListener == null ? (class$de$audi$atip$interapp$TunerServiceListener = TunerActivatorBase.class$("de.audi.atip.interapp.TunerServiceListener")) : class$de$audi$atip$interapp$TunerServiceListener).getName());
        arrayList.add((class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = TunerActivatorBase.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName());
        arrayList.add((class$de$audi$tuner$ifc$IRadioInterappListener == null ? (class$de$audi$tuner$ifc$IRadioInterappListener = TunerActivatorBase.class$("de.audi.tuner.ifc.IRadioInterappListener")) : class$de$audi$tuner$ifc$IRadioInterappListener).getName());
        arrayList.add((class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = TunerActivatorBase.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName());
        arrayList.add((class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = TunerActivatorBase.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager).getName());
        arrayList.add((class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = TunerActivatorBase.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext).getName());
        arrayList.add((class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = TunerActivatorBase.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName());
        arrayList.add((class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = TunerActivatorBase.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName());
        arrayList.add((class$de$audi$atip$interapp$IMessagingService == null ? (class$de$audi$atip$interapp$IMessagingService = TunerActivatorBase.class$("de.audi.atip.interapp.IMessagingService")) : class$de$audi$atip$interapp$IMessagingService).getName());
        if (Utilities.getDatabaseRegion() > 0) {
            arrayList.add((class$org$dsi$ifc$radiodata$DSIRadioData == null ? (class$org$dsi$ifc$radiodata$DSIRadioData = TunerActivatorBase.class$("org.dsi.ifc.radiodata.DSIRadioData")) : class$org$dsi$ifc$radiodata$DSIRadioData).getName());
        }
        if (Utilities.isNARBuild()) {
            arrayList.add((class$org$dsi$ifc$media$DSIRadioTagging == null ? (class$org$dsi$ifc$media$DSIRadioTagging = TunerActivatorBase.class$("org.dsi.ifc.media.DSIRadioTagging")) : class$org$dsi$ifc$media$DSIRadioTagging).getName());
        }
        if (Utilities.isGraceNoteLocal() || Utilities.isGraceNoteOnline()) {
            arrayList.add((class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = TunerActivatorBase.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName());
        }
        this.tracker = new ServiceTracker(this.bundleContext, (String[])arrayList.toArray(new String[arrayList.size()]), (ServiceTrackerCustomizer)this);
        this.tracker.open();
        this.trackerInitialized = true;
    }

    protected void doStartAll() {
        HistoryTuner historyTuner;
        this.registerI18NListener();
        this.initTracker();
        this.registerHMIApplication();
        this.registerAudioListener();
        this.registerFrameworkService(class$de$audi$atip$audio$IAudioFocusClient == null ? (class$de$audi$atip$audio$IAudioFocusClient = TunerActivatorBase.class$("de.audi.atip.audio.IAudioFocusClient")) : class$de$audi$atip$audio$IAudioFocusClient, this.appTuner.getAudioFocusClient(), null);
        this.registerFrameworkService(class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = TunerActivatorBase.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener, this.appTuner.getPowerEventListener(), null);
        this.registerFrameworkService(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = TunerActivatorBase.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener, this.appTuner.getMessageListener(), null);
        this.registerFrameworkService(class$de$audi$atip$diag$IDiagnosisApp == null ? (class$de$audi$atip$diag$IDiagnosisApp = TunerActivatorBase.class$("de.audi.atip.diag.IDiagnosisApp")) : class$de$audi$atip$diag$IDiagnosisApp, this.appTuner.getDiagnosisApplication(), null);
        this.registerTuners();
        this.registerAnnouncementDSI();
        this.registerRadioDataDSI();
        if (Utilities.isGraceNoteLocal() || Utilities.isGraceNoteOnline()) {
            this.registerGracenoteDSI();
        }
        this.registerFrameworkService(class$de$audi$atip$preset$IAppPresetDefinitionHandler == null ? (class$de$audi$atip$preset$IAppPresetDefinitionHandler = TunerActivatorBase.class$("de.audi.atip.preset.IAppPresetDefinitionHandler")) : class$de$audi$atip$preset$IAppPresetDefinitionHandler, this.appTuner.getRadioPresetHandler(), null);
        this.registerFrameworkService(class$de$audi$atip$preset$IAppPresetExecutionHandler == null ? (class$de$audi$atip$preset$IAppPresetExecutionHandler = TunerActivatorBase.class$("de.audi.atip.preset.IAppPresetExecutionHandler")) : class$de$audi$atip$preset$IAppPresetExecutionHandler, this.appTuner.getRadioPresetHandler(), null);
        if (Utilities.getFramework().getSysConst(4347) == 1) {
            this.registerSdarsSeekDSI();
        }
        this.registerFrameworkService(class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = TunerActivatorBase.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService, this.appTuner.getTunerService(), null);
        if (Utilities.getFramework().getKombiProtocol() == 2) {
            this.registerFrameworkService(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener = TunerActivatorBase.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTunerListener, this.appTuner.getCombiTunerListener(), null);
        }
        this.registerFrameworkService(class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = TunerActivatorBase.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener, this.appTuner.getScanHandler(), null);
        this.registerFrameworkService(class$de$audi$tuner$ifc$IRadioInterappService == null ? (class$de$audi$tuner$ifc$IRadioInterappService = TunerActivatorBase.class$("de.audi.tuner.ifc.IRadioInterappService")) : class$de$audi$tuner$ifc$IRadioInterappService, this.appTuner.getTabletService().tabletRequest, null);
        this.appTuner.initFull();
        if (Utilities.isJapan()) {
            this.registerAMFMService();
        }
        if ((historyTuner = this.appTuner.getHistory()) != null) {
            this.registerFrameworkService(class$de$audi$atip$interapp$radio$IHistoryListService == null ? (class$de$audi$atip$interapp$radio$IHistoryListService = TunerActivatorBase.class$("de.audi.atip.interapp.radio.IHistoryListService")) : class$de$audi$atip$interapp$radio$IHistoryListService, historyTuner.historyListService, null);
            this.registerFrameworkService(class$de$audi$atip$interapp$radio$IHistoryVetoService == null ? (class$de$audi$atip$interapp$radio$IHistoryVetoService = TunerActivatorBase.class$("de.audi.atip.interapp.radio.IHistoryVetoService")) : class$de$audi$atip$interapp$radio$IHistoryVetoService, historyTuner.historyVetoService, null);
        }
        this.registerTaggingDSI();
        this.appTuner.initTagging();
        this.registerFrameworkService(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener = TunerActivatorBase.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContextListener, this.appTuner.getAudioDrawerStateTracker(), null);
    }

    private void registerTuners() {
        switch (this.appTuner.startupBand) {
            case 5: {
                this.registerDabDSI();
                this.registerUniDSI();
                this.registerSdarsDSI();
                this.registerAmFmDSI();
                break;
            }
            case 11: {
                this.registerUniDSI();
                this.registerAmFmDSI();
                this.registerDabDSI();
                this.registerSdarsDSI();
                break;
            }
            case 7: {
                this.registerSdarsDSI();
                this.registerAmFmDSI();
                this.registerDabDSI();
                this.registerUniDSI();
                break;
            }
            default: {
                this.registerAmFmDSI();
                this.registerDabDSI();
                this.registerUniDSI();
                this.registerSdarsDSI();
            }
        }
    }

    private void registerAnnouncementDSI() {
        this.registerDSIListener(class$org$dsi$ifc$radio$DSITunerAnnouncementListener == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncementListener = TunerActivatorBase.class$("org.dsi.ifc.radio.DSITunerAnnouncementListener")) : class$org$dsi$ifc$radio$DSITunerAnnouncementListener, this.appTuner.getAnnouncementHandler(), 0);
        this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerAnnouncementDSI] startDSIService(DSITunerAnnouncement)");
        this.framework.startDSIService((class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = TunerActivatorBase.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement).getName(), 0);
        this.framework.getStartupMgr().logStartupEvent("[RADIO] startDSIService(DSITunerAnnouncement)");
    }

    private void registerAmFmDSI() {
        this.registerDSIListener(class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener, this.appTuner.dsiAMFMTunerListener, 0);
        if (!TunerProxyManager.getInstance().getAmFmTuner().isDsiFound()) {
            this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerAmFmDSI] startDSIService(DSIAMFMTuner)");
            this.framework.startDSIService((class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner).getName(), 0);
            this.framework.getStartupMgr().logStartupEvent("[RADIO] startDSIService(DSIAMFMTuner)");
        }
    }

    private void registerDabDSI() {
        if (Utilities.isDABPresent()) {
            this.registerDSIListener(class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener, this.appTuner.dsiDABTunerListener, 0);
            if (!TunerProxyManager.getInstance().getDABTuner().isDsiFound()) {
                this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerDabDSI] startDSIService(DSIDABTuner)");
                this.framework.startDSIService((class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner).getName(), 0);
                this.framework.getStartupMgr().logStartupEvent("[RADIO] startDSIService(DSIDABTuner)");
            }
        }
    }

    private void registerUniDSI() {
        if (TunerProxyManager.getInstance().getUnifiedTuner() instanceof UnifiedTuner) {
            this.registerDSIListener(class$org$dsi$ifc$radio$DSIUnifiedTunerListener == null ? (class$org$dsi$ifc$radio$DSIUnifiedTunerListener = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIUnifiedTunerListener")) : class$org$dsi$ifc$radio$DSIUnifiedTunerListener, this.appTuner.dsiUniTunerListener, 0);
            if (!TunerProxyManager.getInstance().getUnifiedTuner().isDsiFound()) {
                this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerUniDSI] startDSIService(DSIUnifiedTuner)");
                this.framework.startDSIService((class$org$dsi$ifc$radio$DSIUnifiedTuner == null ? (class$org$dsi$ifc$radio$DSIUnifiedTuner = TunerActivatorBase.class$("org.dsi.ifc.radio.DSIUnifiedTuner")) : class$org$dsi$ifc$radio$DSIUnifiedTuner).getName(), 0);
                this.framework.getStartupMgr().logStartupEvent("[RADIO] startDSIService(DSIUnifiedTuner)");
            }
        }
    }

    private void registerSdarsDSI() {
        if (Utilities.isSDARSPresent()) {
            this.registerDSIListener(class$org$dsi$ifc$sdars$DSISDARSTunerListener == null ? (class$org$dsi$ifc$sdars$DSISDARSTunerListener = TunerActivatorBase.class$("org.dsi.ifc.sdars.DSISDARSTunerListener")) : class$org$dsi$ifc$sdars$DSISDARSTunerListener, this.appTuner.dsiSDARSTunerListener, 0);
            if (!TunerProxyManager.getInstance().getSDARSTuner().isDsiFound()) {
                this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerSdarsDSI] startDSIService(DSISDARSTuner)");
                this.framework.startDSIService((class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = TunerActivatorBase.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName(), 0);
            }
        }
    }

    private void registerGracenoteDSI() {
        this.registerDSIListener(class$org$dsi$ifc$media$DSIMetadataServiceListener == null ? (class$org$dsi$ifc$media$DSIMetadataServiceListener = TunerActivatorBase.class$("org.dsi.ifc.media.DSIMetadataServiceListener")) : class$org$dsi$ifc$media$DSIMetadataServiceListener, this.appTuner.gracenote.gracenoteListener, 0);
        if (!this.appTuner.gracenote.isDsiFound()) {
            this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerGracenoteDSI] startDSIService(DSIMetadataService)");
            this.framework.startDSIService((class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = TunerActivatorBase.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName(), 0);
        }
    }

    private void registerSdarsSeekDSI() {
        ISDARSTuner iSDARSTuner = TunerProxyManager.getInstance().getSDARSTuner();
        if (iSDARSTuner instanceof SDARSTuner) {
            this.registerDSIListener(class$org$dsi$ifc$sdars$DSISDARSSeekListener == null ? (class$org$dsi$ifc$sdars$DSISDARSSeekListener = TunerActivatorBase.class$("org.dsi.ifc.sdars.DSISDARSSeekListener")) : class$org$dsi$ifc$sdars$DSISDARSSeekListener, iSDARSTuner.getSeekListener(), 0);
            if (!((SDARSTuner)iSDARSTuner).isDsiSeekFound()) {
                this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerSdarsSeekDSI] startDSIService(DSISDARSSeek)");
                this.framework.startDSIService((class$org$dsi$ifc$sdars$DSISDARSSeek == null ? (class$org$dsi$ifc$sdars$DSISDARSSeek = TunerActivatorBase.class$("org.dsi.ifc.sdars.DSISDARSSeek")) : class$org$dsi$ifc$sdars$DSISDARSSeek).getName(), 0);
            }
        }
    }

    private void registerRadioDataDSI() {
        if (Utilities.getDatabaseRegion() > 0) {
            RadioDataListenerImpl radioDataListenerImpl = this.appTuner.getRadioDataListener();
            if (radioDataListenerImpl != null) {
                this.registerDSIListener(class$org$dsi$ifc$radiodata$DSIRadioDataListener == null ? (class$org$dsi$ifc$radiodata$DSIRadioDataListener = TunerActivatorBase.class$("org.dsi.ifc.radiodata.DSIRadioDataListener")) : class$org$dsi$ifc$radiodata$DSIRadioDataListener, radioDataListenerImpl, 0);
                if (!this.appTuner.getRadioDataDsi().isDsiFound()) {
                    this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerRadioDataDSI] startDSIService(DSIRadioData)");
                    this.framework.startDSIService((class$org$dsi$ifc$radiodata$DSIRadioData == null ? (class$org$dsi$ifc$radiodata$DSIRadioData = TunerActivatorBase.class$("org.dsi.ifc.radiodata.DSIRadioData")) : class$org$dsi$ifc$radiodata$DSIRadioData).getName(), 0);
                }
            }
        } else {
            this.logger.startup.log(1078071040, "[TunerActivatorBase.registerRadioDataDSI] not starting DSIRAdioData: region:%1", (long)Utilities.getDatabaseRegion());
        }
    }

    private void registerTaggingDSI() {
        ITunesTaggingDSI iTunesTaggingDSI;
        if (Utilities.isNARBuild() && (iTunesTaggingDSI = this.appTuner.getTagging()) != null) {
            this.registerDSIListener(class$org$dsi$ifc$media$DSIRadioTaggingListener == null ? (class$org$dsi$ifc$media$DSIRadioTaggingListener = TunerActivatorBase.class$("org.dsi.ifc.media.DSIRadioTaggingListener")) : class$org$dsi$ifc$media$DSIRadioTaggingListener, iTunesTaggingDSI, 0);
            if (!iTunesTaggingDSI.isDsiFound()) {
                this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerTaggingDSI] startDSIService(DSIRadioTagging)");
                this.framework.startDSIService((class$org$dsi$ifc$media$DSIRadioTagging == null ? (class$org$dsi$ifc$media$DSIRadioTagging = TunerActivatorBase.class$("org.dsi.ifc.media.DSIRadioTagging")) : class$org$dsi$ifc$media$DSIRadioTagging).getName(), 0);
            }
        }
    }

    private void registerHMIApplication() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("moduleID", new Integer(1));
        this.registerFrameworkService(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = TunerActivatorBase.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication, this.appTuner.getHMIApplication(), hashtable);
    }

    private void registerAudioListener() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_RADIO);
        this.registerFrameworkService(class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = TunerActivatorBase.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener, this.appTuner.audioListener, hashtable);
    }

    private void registerI18NListener() {
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_HMI");
        ((Dictionary)hashtable).put("NOTIFY_BY_REGISTRATION_STRATEGY", "UPDATE_AFTER_REGISTRATION");
        this.registerService((class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = TunerActivatorBase.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName(), (Object)this.appTuner.getLangMngr().i18NListener, (Dictionary)hashtable);
    }

    private void registerAMFMService() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", (class$de$audi$tuner$app$AppTuner == null ? (class$de$audi$tuner$app$AppTuner = TunerActivatorBase.class$("de.audi.tuner.app.AppTuner")) : class$de$audi$tuner$app$AppTuner).getName());
        this.registerFrameworkService(class$de$audi$atip$interapp$AMFMTunerService == null ? (class$de$audi$atip$interapp$AMFMTunerService = TunerActivatorBase.class$("de.audi.atip.interapp.AMFMTunerService")) : class$de$audi$atip$interapp$AMFMTunerService, ((AMFMTuner)TunerProxyManager.getInstance().getAmFmTuner()).getJpTunerListener(), hashtable);
    }

    protected void registerFrameworkService(Class clazz, Object object, Dictionary dictionary) {
        String string = clazz.getName();
        this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerFrameworkService] ( %1 ) ", (Object)string);
        this.registerService(string, object, dictionary);
    }

    protected void registerDSIListener(Class clazz, DSIListener dSIListener, int n) {
        String string = clazz.getName();
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", string);
        hashtable.put("DEVICE_INSTANCE", new Integer(n));
        this.logger.startup.log(-2137614336, "[TunerActivatorBase.registerDSIListener] (%1, %2, %3) ", (Object)string, (Object)dSIListener, (long)n);
        this.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = TunerActivatorBase.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)dSIListener, (Dictionary)hashtable);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.logger.startup.log(14808325, "[TunerActivatorBase.addingService] ( %1 ) ", (Object)serviceReference);
        Object object = this.bundleContext.getService(serviceReference);
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        if (object instanceof HMIAudioService) {
            if (HMIAudioService.CLIENT_RADIO.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
                return this.appTuner.addService(object, object2, object3);
            }
        } else {
            if (object instanceof DSICarTimeUnitsLanguage) {
                DSICarTimeUnitsLanguage dSICarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)object;
                DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = this.appTuner.getDSICarTimeUnitsLanguageListener();
                if (dSICarTimeUnitsLanguageListener != null) {
                    dSICarTimeUnitsLanguage.setNotification(3, (DSIListener)dSICarTimeUnitsLanguageListener);
                }
                return object;
            }
            if (object instanceof DSIDABTuner || object instanceof DSISDARSTuner) {
                if (Utilities.isHigh()) {
                    DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = this.appTuner.getDSICarTimeUnitsLanguageListener();
                    this.registerDSIListener(class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = TunerActivatorBase.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener, dSICarTimeUnitsLanguageListener, 0);
                    if (this.trackerTimeUnits == null) {
                        this.trackerTimeUnits = new ServiceTracker(this.bundleContext, (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = TunerActivatorBase.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName(), (ServiceTrackerCustomizer)this);
                        this.trackerTimeUnits.open();
                    }
                }
                return this.appTuner.addService(object, object2, object3);
            }
            Object object4 = this.appTuner.addService(object, object2, object3);
            if ((class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = TunerActivatorBase.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName().equals(object2)) {
                this.sregGracenoteService = this.getBundleContext().registerService((class$de$audi$atip$interapp$radio$IGracenoteService == null ? (class$de$audi$atip$interapp$radio$IGracenoteService = TunerActivatorBase.class$("de.audi.atip.interapp.radio.IGracenoteService")) : class$de$audi$atip$interapp$radio$IGracenoteService).getName(), (Object)this.appTuner.gracenote.mediaListener, null);
                if (this.trackerGracenoteSrv == null) {
                    this.trackerGracenoteSrv = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$radio$IGracenoteServiceListener == null ? (class$de$audi$atip$interapp$radio$IGracenoteServiceListener = TunerActivatorBase.class$("de.audi.atip.interapp.radio.IGracenoteServiceListener")) : class$de$audi$atip$interapp$radio$IGracenoteServiceListener).getName(), (ServiceTrackerCustomizer)this);
                    this.trackerGracenoteSrv.open();
                }
            }
            if (object4 != null) {
                return object4;
            }
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        Object object2 = serviceReference.getProperty("DEVICE_NAME");
        Object object3 = serviceReference.getProperty("DEVICE_INSTANCE");
        this.bundleContext.ungetService(serviceReference);
        this.appTuner.removeService(object, object2, object3);
        if ((class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = TunerActivatorBase.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName().equals(object2)) {
            this.sregGracenoteService.unregister();
            this.sregGracenoteService = null;
        }
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

