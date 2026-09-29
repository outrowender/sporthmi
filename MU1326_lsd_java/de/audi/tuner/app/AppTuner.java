/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.tuner.TunerDiag
 */
package de.audi.tuner.app;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.TunerServiceListener;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner;
import de.audi.atip.interapp.radio.IGracenoteServiceListener;
import de.audi.atip.phone.ITelService;
import de.audi.atip.util.NowPlayingScreenController;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tuner.app.AppChangeHandler;
import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.BeepHandler;
import de.audi.tuner.app.DrawerFocusManager;
import de.audi.tuner.app.GlobalOptionsMngr;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.PsFreezeHandler;
import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.RadioPresetHandler;
import de.audi.tuner.app.ScanHandler;
import de.audi.tuner.app.TaggingOptionModelListener;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerDiagnosisApplication;
import de.audi.tuner.app.TunerHMIApplication;
import de.audi.tuner.app.TunerMessageListener;
import de.audi.tuner.app.TunerPowerEventListener;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.GUIHandlerAMFM;
import de.audi.tuner.app.amfm.PsFreezeDB;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.audiodrawer.AudioDrawerStateTracker;
import de.audi.tuner.app.cmd.RadioCmdManager;
import de.audi.tuner.app.cmd.RadioCmdManager$Builder;
import de.audi.tuner.app.cmd.amfm.DSIAMFMTunerCmdListener;
import de.audi.tuner.app.cmd.audio.HMIAudioServiceCmdListener;
import de.audi.tuner.app.cmd.dab.DSIDABTunerCmdListener;
import de.audi.tuner.app.cmd.sdars.DSISDARSTunerCmdListener;
import de.audi.tuner.app.cmd.uni.DSIUnifiedTunerCmdListener;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.combi.CombiBAPIdMapper;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.combi.CombiBAPServiceListenerImpl;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.IDabEpgHandler;
import de.audi.tuner.app.epg.dab.NullDabEpgHandler;
import de.audi.tuner.app.gracenote.RadioGracenote;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.misc.OptionsHandler;
import de.audi.tuner.app.rsdb.LogoDatabase;
import de.audi.tuner.app.rsdb.RadioDataDsi;
import de.audi.tuner.app.rsdb.RadioDataListenerImpl;
import de.audi.tuner.app.rse.TabletServiceHandler;
import de.audi.tuner.app.rse.TabletServiceImpl;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.IAMFMTuner;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IRadioInterappListener;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.SDARSTunerListener;
import de.audi.tuner.ifc.UnifiedTunerListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITunesTaggingDSI;
import de.audi.tuner.itunes.TaggingManager;
import de.audi.tuner.keys.KeyHandlerManager;
import de.audi.tuner.sds.TunerServiceHandler;
import de.audi.tuner.sds.TunerServiceImpl;
import de.audi.tuner.util.NullDSIAMFMTunerService;
import de.audi.tuner.util.NullDSIDABTunerService;
import de.audi.tuner.util.NullDSISDARSTunerService;
import de.audi.tuner.util.NullDSITunerAnnouncement;
import de.audi.tuner.util.NullDSIUnifiedTunerService;
import de.mib.swdiagnosis.tuner.TunerDiag;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.media.DSIMetadataService;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.DSITunerAnnouncement;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.sdars.DSISDARSTunerListener;

public final class AppTuner {
    private final AppChangeHandler appChangeHandler;
    private final TunerBasics basics;
    private final LanguageManager langMngr;
    private final TunerServiceHandler serviceHandler;
    private final CombiBAPServiceHandler combiHandler;
    private final CombiBAPServiceListenerImpl combiListener;
    private final BeepHandler beep;
    private final TunerHMIApplication hmiApplication;
    private final TunerPowerEventListener power;
    private final MemoryListHandler memory;
    private final TunerStorage storage;
    private final ScanHandler scanHandler;
    private final BandListHandler bandList;
    private final TunerMessageListener messageListener;
    private final TunerDiagnosisApplication diagnosisApp;
    private TunerDiag diag;
    private final TunerAudioMgmt audio;
    private final AudioFocusClient audioFocusClient;
    private final AnnouncementHandler announce;
    private final KeyHandlerManager keys;
    private final TunerServiceImpl tunerService;
    private final ITunesTaggingDSI taggingDSI;
    private final TaggingManager taggingMgr;
    private final IDabEpgHandler dabEpg;
    private final PsFreezeHandler psFreezeHandler;
    private final ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler;
    final DSIAMFMTunerListener dsiAMFMTunerListener;
    final DSIDABTunerListener dsiDABTunerListener;
    final DSIUnifiedTunerListener dsiUniTunerListener;
    final DSISDARSTunerListener dsiSDARSTunerListener;
    final HMIAudioServiceListener audioListener;
    final RadioGracenote gracenote;
    private final TabletServiceHandler tabletHandler;
    private final TabletServiceImpl tabletService;
    private final OptionsHandler optionsHandler;
    private final AudioDrawerStateTracker audioDrawerStateTracker;
    private final RadioMenuModelListener radioMenuModelListener;
    private final HistoryTuner historyTuner;
    private final RadioPresetHandler radioPresetHandler;
    private final PsFreezeDB psFreezeDB;
    private final RadiotextHyperlinkProcessor hyperlinkProcessor;
    final int startupBand;
    private final LogoDatabase logoDatabase;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIUnifiedTuner;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTuner;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSSeek;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncement;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTagging;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioData;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMetadataService;

    AppTuner(Logger logger, IFrameworkAccess iFrameworkAccess, ITunerVariantExt iTunerVariantExt) {
        AlertHandler alertHandler;
        Object object;
        this.basics = new TunerBasics(logger, iFrameworkAccess);
        this.scanHandler = new ScanHandler(this.basics, iTunerVariantExt);
        this.hyperlinkProcessor = new RadiotextHyperlinkProcessor(this.basics);
        this.langMngr = new LanguageManager(this.basics);
        this.hmiApplication = new TunerHMIApplication(this.basics, iTunerVariantExt);
        this.audio = new TunerAudioMgmt(this.basics, this.scanHandler);
        this.taggingMgr = new TaggingManager(this.basics);
        this.taggingDSI = new ITunesTaggingDSI(this.basics, this.taggingMgr, iTunerVariantExt);
        this.beep = new BeepHandler(logger, this.audio);
        this.storage = new TunerStorage(this.basics, iTunerVariantExt, this.audio);
        this.memory = new MemoryListHandler(this.basics, iTunerVariantExt, this.storage, this.scanHandler);
        this.hmiApplication.addListener(this.memory.hmiAppListener);
        this.langMngr.addLanguageChangedListener(this.memory.languageChangeListener);
        this.storage.init();
        this.psFreezeDB = new PsFreezeDB(this.basics, this.storage);
        this.announce = new AnnouncementHandler(this.basics, this.storage, this.audio, iTunerVariantExt, this.psFreezeDB);
        this.audio.setTunerAnnouncement(this.announce);
        this.clockTimeZoneOffsetHandler = new ClockTimeZoneOffsetHandler(logger.main);
        NowPlayingScreenController nowPlayingScreenController = new NowPlayingScreenController(iFrameworkAccess, logger.hmi);
        nowPlayingScreenController.init();
        this.power = new TunerPowerEventListener(this.basics, this.audio);
        this.bandList = new BandListHandler(this.basics, this.storage, this.memory, this.audio, this.announce);
        this.diagnosisApp = new TunerDiagnosisApplication(this.basics, this.bandList);
        this.diagnosisApp.addTunerDiagnosisSessionListener(this.announce.diagnosisListener);
        this.serviceHandler = new TunerServiceHandler(this.basics);
        CombiBAPIdMapper combiBAPIdMapper = new CombiBAPIdMapper();
        this.combiHandler = new CombiBAPServiceHandler(this.basics, combiBAPIdMapper, this.storage, iTunerVariantExt);
        this.appChangeHandler = new AppChangeHandler(this.basics, this.bandList, this.combiHandler, this.announce, this.audio);
        this.audioFocusClient = new AudioFocusClient(this.basics, this.appChangeHandler, this.audio);
        this.keys = new KeyHandlerManager(this.basics, this.bandList, this.audio, this.announce, this.memory, this.audioFocusClient, this.scanHandler);
        this.combiListener = new CombiBAPServiceListenerImpl(this.basics, this.combiHandler, this.memory, this.announce, this.audioFocusClient, combiBAPIdMapper, this.keys.getDefaultButtonHandler(), this.scanHandler, this.storage);
        this.scanHandler.addUpdateListener(this.combiHandler);
        SDARSStationDescriptions sDARSStationDescriptions = new SDARSStationDescriptions(this.basics);
        this.tabletHandler = new TabletServiceHandler(this.basics, this.storage, sDARSStationDescriptions);
        this.tabletService = new TabletServiceImpl(this.basics, this.tabletHandler, this.audioFocusClient);
        this.tunerService = new TunerServiceImpl(this.basics, this.announce, this.bandList, this.audioFocusClient);
        this.audioDrawerStateTracker = new AudioDrawerStateTracker(this.basics);
        this.basics.getModels().initializeModels();
        IUpdateListener[] iUpdateListenerArray = new IUpdateListener[]{this.serviceHandler, this.combiHandler, this.tabletHandler};
        this.logoDatabase = new LogoDatabase(this.basics, this.storage, this.langMngr);
        this.langMngr.addLanguageChangedListener(this.logoDatabase.languageChangeListener);
        this.logoDatabase.addListener(this.memory.databaseListener);
        this.messageListener = new TunerMessageListener(this.basics, this.audio, this.announce, this.taggingMgr, this.memory, nowPlayingScreenController, this.logoDatabase);
        TunerProxyManager.getInstance().init(this.basics, this.storage, this.bandList, this.keys, this.memory, this.audio, this.announce, this.basics.tunerJobQueue, iUpdateListenerArray, this.taggingMgr, iTunerVariantExt, this.langMngr, this.scanHandler, this.psFreezeDB, this.clockTimeZoneOffsetHandler, this.hyperlinkProcessor, sDARSStationDescriptions, this.audioDrawerStateTracker);
        this.initListeners();
        this.optionsHandler = new OptionsHandler(this.storage, this.basics);
        this.basics.getModels().getChoiceModel(-410582784).setStatus(0);
        this.startupBand = this.handleLastMode();
        IDABTuner iDABTuner = TunerProxyManager.getInstance().getDABTuner();
        iDABTuner.addUpdateListener(this.memory.updateListener);
        IUnifiedTuner iUnifiedTuner = TunerProxyManager.getInstance().getUnifiedTuner();
        IAMFMTuner iAMFMTuner = TunerProxyManager.getInstance().getAmFmTuner();
        ISDARSTuner iSDARSTuner = TunerProxyManager.getInstance().getSDARSTuner();
        this.tabletHandler.setPdtInfoHandler(iSDARSTuner.getPdtHandler());
        RadioCmdManager$Builder radioCmdManager$Builder = new RadioCmdManager$Builder(this.basics);
        radioCmdManager$Builder.setAudioService(this.audio);
        radioCmdManager$Builder.setAudioDefaultListener(this.audio);
        radioCmdManager$Builder.setAMFMTuner(iAMFMTuner);
        radioCmdManager$Builder.setAMFMDefaultListener((AMFMTunerListener)iAMFMTuner.getDSIUpManager());
        radioCmdManager$Builder.setDABTuner(iDABTuner);
        radioCmdManager$Builder.setDABDefaultListener((DABTunerListener)iDABTuner.getDSIUpManager());
        radioCmdManager$Builder.setUnifiedTuner(iUnifiedTuner);
        radioCmdManager$Builder.setUnifiedDefaultListener((UnifiedTunerListener)iUnifiedTuner.getDSIUpManager());
        radioCmdManager$Builder.setSDARSTuner(iSDARSTuner);
        radioCmdManager$Builder.setSDARSDefaultListener((SDARSTunerListener)iSDARSTuner.getDSIUpManager());
        RadioCmdManager radioCmdManager = new RadioCmdManager(radioCmdManager$Builder);
        this.audio.register(radioCmdManager);
        this.appChangeHandler.register(radioCmdManager);
        this.dsiAMFMTunerListener = new DSIAMFMTunerCmdListener(logger.amfmDSI, radioCmdManager);
        iAMFMTuner.setCmdManager(radioCmdManager);
        iAMFMTuner.register(this.dsiAMFMTunerListener);
        this.dsiDABTunerListener = new DSIDABTunerCmdListener(logger.dabDSI, radioCmdManager);
        iDABTuner.setCmdManager(radioCmdManager);
        iDABTuner.register(this.dsiDABTunerListener);
        this.dsiUniTunerListener = new DSIUnifiedTunerCmdListener(logger.uniDSI, radioCmdManager);
        iUnifiedTuner.setCmdManager(radioCmdManager);
        iUnifiedTuner.register(this.dsiUniTunerListener);
        this.dsiSDARSTunerListener = new DSISDARSTunerCmdListener(logger.sdarsDSI, radioCmdManager);
        iSDARSTuner.setCmdManager(radioCmdManager);
        iSDARSTuner.register(this.dsiSDARSTunerListener);
        this.audioListener = new HMIAudioServiceCmdListener(logger.audio, radioCmdManager);
        this.radioPresetHandler = new RadioPresetHandler(this.basics, this.audioFocusClient, iTunerVariantExt, this.memory);
        boolean bl = System.getProperty("radio.history.enabled", "false").equals("true");
        if (Utilities.isEvoHighMMIKombi() || bl) {
            this.historyTuner = new HistoryTuner(this.basics, iTunerVariantExt.getListRowFactory(), this.storage, this.scanHandler);
            this.historyTuner.init();
            iAMFMTuner.registerDsiUpDownListener(this.historyTuner.amfmDsiUpListener);
            iAMFMTuner.registerDsiUpDownListener(this.historyTuner.amfmDsiDownListener);
            iDABTuner.registerDsiUpDownListener(this.historyTuner.dabDsiUpListener);
            iDABTuner.registerDsiUpDownListener(this.historyTuner.dabDsiDownListener);
            iUnifiedTuner.registerDsiUpDownListener(this.historyTuner.uniDsiUpListener);
            iUnifiedTuner.registerDsiUpDownListener(this.historyTuner.uniDsiDownListener);
            iSDARSTuner.registerDsiUpDownListener(this.historyTuner.sdarsDsiUpListener);
            iSDARSTuner.registerDsiUpDownListener(this.historyTuner.sdarsDsiDownListener);
            this.audio.register(this.historyTuner.audioInfoListener);
            this.audioFocusClient.register(this.historyTuner.audioFocusListener);
            this.messageListener.addMessageListener(this.historyTuner.getMessageListener());
            this.bandList.addToBandList(13);
            this.logoDatabase.addListener(this.historyTuner.rsdbStatusListener);
            TunerProxyManager.getInstance().setHistoryTuner(this.historyTuner);
            this.langMngr.addLanguageChangedListener(this.historyTuner.getLanguageChangeListener());
            this.optionsHandler.addOptionListener(this.historyTuner.getOptionsListener());
        } else {
            this.historyTuner = null;
        }
        this.logoDatabase.addListener(iAMFMTuner.getDatabaseListener());
        this.logoDatabase.addListener(iUnifiedTuner.getDatabaseListener());
        this.logoDatabase.addListener(iDABTuner.getDatabaseListener());
        this.logoDatabase.addListener(TunerProxyManager.getInstance().rsdbStatusListener);
        this.scanHandler.register(this.memory, this.historyTuner);
        new TaggingOptionModelListener(this.basics, iAMFMTuner.getTagging(), iSDARSTuner.getTagging());
        this.audioFocusClient.register(this.scanHandler.audioFocusListener);
        this.psFreezeHandler = new PsFreezeHandler(this.basics, this.memory, this.historyTuner, this.psFreezeDB);
        if (!Utilities.isPGen1OrBentley()) {
            this.registerPrevNext(((GUIHandlerAMFM)TunerProxyManager.getInstance().getAmFmGUIHandler()).getAMStationList().getPrevNextHandler(), 4);
            this.registerPrevNext(((GUIHandlerAMFM)TunerProxyManager.getInstance().getAmFmGUIHandler()).getFMStationList().getPrevNextHandler(), 1);
            this.registerPrevNext(((GUIHandlerAMFM)TunerProxyManager.getInstance().getAmFmGUIHandler()).getTIStationList().getPrevNextHandler(), 10);
            this.registerPrevNext(iUnifiedTuner.getPrevNextHandler(), 11);
            this.registerPrevNext(this.memory.prevNextHandler, 12);
        }
        this.registerPrevNext(iDABTuner.getPrevNextHandler(), 5);
        if (this.historyTuner != null) {
            this.registerPrevNext(this.historyTuner.getPrevNextHandler(), 13);
        }
        this.registerPrevNext(iSDARSTuner.getPrevNextHandler(), 7);
        AlertHandler alertHandler2 = iSDARSTuner.getAlertHandler();
        if (alertHandler2 != null) {
            this.registerPrevNext(alertHandler2.prexNextListener, 8);
        }
        this.keys.getDefaultButtonHandler().register(this.scanHandler);
        int[] nArray = new int[]{310903040, -678952704, -695795456};
        this.radioMenuModelListener = new RadioMenuModelListener(this.basics, nArray);
        this.gracenote = new RadioGracenote(this.basics, this.storage);
        iDABTuner.register(this.gracenote);
        iAMFMTuner.register(this.gracenote);
        iUnifiedTuner.register(this.gracenote);
        iSDARSTuner.register(this.gracenote);
        this.messageListener.addMessageListener(this.gracenote.resetListener);
        iSDARSTuner.register(this.taggingMgr);
        iAMFMTuner.register(this.taggingMgr);
        this.messageListener.addMessageListener(new GlobalOptionsMngr((TunerBasics)this.basics, (TunerStorage)this.storage, (MemoryListHandler)this.memory, (HistoryTuner)this.historyTuner, (CombiBAPServiceHandler)this.combiHandler).messageListener);
        if (Utilities.isDABEPGPresent()) {
            int n;
            this.dabEpg = new DABEpgHandler(this.basics, iDABTuner, this.langMngr, iTunerVariantExt, this.clockTimeZoneOffsetHandler, this.scanHandler);
            object = this.dabEpg.getDabListeners();
            for (n = 0; n < ((RadioInfo[])object).length; ++n) {
                iDABTuner.registerDsiUpDownListener(object[n]);
            }
            object = this.dabEpg.getUniListeners();
            for (n = 0; n < ((RadioInfo[])object).length; ++n) {
                iUnifiedTuner.registerDsiUpDownListener(object[n]);
            }
        } else {
            this.dabEpg = new NullDabEpgHandler(logger.main);
        }
        this.power.register(this.announce.powerEventListener);
        this.power.register(this.basics.getStatus().powerEventListener);
        this.power.register(this.memory.powerEventListener);
        this.power.register(iAMFMTuner.getGUIHandler().getPoPowerStateListener());
        this.power.register(iDABTuner.getGUIHandler().getPoPowerStateListener());
        if (this.historyTuner != null) {
            this.power.register(this.historyTuner.getPowerEventListener());
        }
        object = new DrawerFocusManager(this.basics, this.scanHandler);
        this.memory.register((IDrawerFocusManager)object);
        TunerProxyManager.getInstance().getStationListHandler(1).register((IDrawerFocusManager)object);
        TunerProxyManager.getInstance().getStationListHandler(4).register((IDrawerFocusManager)object);
        TunerProxyManager.getInstance().getStationListHandler(5).register((IDrawerFocusManager)object);
        TunerProxyManager.getInstance().getStationListHandler(11).register((IDrawerFocusManager)object);
        TunerProxyManager.getInstance().getStationListHandler(7).register((IDrawerFocusManager)object);
        if (this.historyTuner != null) {
            this.historyTuner.register((IDrawerFocusManager)object);
        }
        if ((alertHandler = iSDARSTuner.getAlertHandler()) != null) {
            this.bandList.addUpdateListener(alertHandler.updateListener);
        }
        iAMFMTuner.registerDsiUpDownListener(this.tabletHandler.amfmDsiUpListener);
    }

    public void registerPrevNext(IPrevNext iPrevNext, int n) {
        this.keys.getDefaultButtonHandler().register(iPrevNext, n);
    }

    public void register(IStoreStationHandler iStoreStationHandler) {
        TunerProxyManager.getInstance().getAmFmGUIHandler().register(iStoreStationHandler);
        TunerProxyManager.getInstance().getDabGUIHandler().register(iStoreStationHandler);
        TunerProxyManager.getInstance().getSdarsGUIHandler().register(iStoreStationHandler);
    }

    public void register(ISearchBreak iSearchBreak, int n) {
        this.radioMenuModelListener.register(iSearchBreak, n);
        TunerProxyManager.getInstance().getSdarsStationListHandler().register(iSearchBreak, n);
        TunerProxyManager.getInstance().getStationListHandler(1).register(iSearchBreak, n);
        TunerProxyManager.getInstance().getStationListHandler(4).register(iSearchBreak, n);
    }

    public AudioFocusClient getAudioFocusClient() {
        return this.audioFocusClient;
    }

    public TunerAudioMgmt getTunerAudioMgmt() {
        return this.audio;
    }

    public IDabEpgHandler getDabEpgHandler() {
        return this.dabEpg;
    }

    public AudioDrawerStateTracker getAudioDrawerStateTracker() {
        return this.audioDrawerStateTracker;
    }

    Object addService(Object object, Object object2, Object object3) {
        this.basics.getLogger().startup.log(1078071040, "[AppTuner.addService] %1", object);
        boolean bl = false;
        if ((class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = AppTuner.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getAmFmTuner().setDeviceService((DSIBase)object);
            TunerProxyManager.getInstance().getAmFmTuner().init();
            bl = true;
        } else if ((class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = AppTuner.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getDABTuner().setDeviceService((DSIBase)object);
            TunerProxyManager.getInstance().getDABTuner().init();
            bl = true;
        } else if ((class$org$dsi$ifc$radio$DSIUnifiedTuner == null ? (class$org$dsi$ifc$radio$DSIUnifiedTuner = AppTuner.class$("org.dsi.ifc.radio.DSIUnifiedTuner")) : class$org$dsi$ifc$radio$DSIUnifiedTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getUnifiedTuner().setDeviceService((DSIBase)object);
            TunerProxyManager.getInstance().getUnifiedTuner().init();
            bl = true;
        } else if ((class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = AppTuner.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getSDARSTuner().setDeviceService((DSIBase)object);
            TunerProxyManager.getInstance().getSDARSTuner().init();
            bl = true;
        } else if ((class$org$dsi$ifc$sdars$DSISDARSSeek == null ? (class$org$dsi$ifc$sdars$DSISDARSSeek = AppTuner.class$("org.dsi.ifc.sdars.DSISDARSSeek")) : class$org$dsi$ifc$sdars$DSISDARSSeek).getName().equals(object2)) {
            TunerProxyManager.getInstance().getSDARSTuner().setDeviceService((DSIBase)object);
            TunerProxyManager.getInstance().getSDARSTuner().initSeek();
            bl = true;
        } else if ((class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = AppTuner.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement).getName().equals(object2)) {
            this.announce.setDeviceService((DSITunerAnnouncement)object);
            bl = true;
        } else if ((class$org$dsi$ifc$media$DSIRadioTagging == null ? (class$org$dsi$ifc$media$DSIRadioTagging = AppTuner.class$("org.dsi.ifc.media.DSIRadioTagging")) : class$org$dsi$ifc$media$DSIRadioTagging).getName().equals(object2)) {
            this.taggingDSI.setDeviceService((DSIRadioTagging)object);
            this.taggingDSI.init();
            bl = true;
        } else if ((class$org$dsi$ifc$radiodata$DSIRadioData == null ? (class$org$dsi$ifc$radiodata$DSIRadioData = AppTuner.class$("org.dsi.ifc.radiodata.DSIRadioData")) : class$org$dsi$ifc$radiodata$DSIRadioData).getName().equals(object2)) {
            this.logoDatabase.setDeviceService((DSIRadioData)object);
            this.logoDatabase.init();
            bl = true;
        } else if ((class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = AppTuner.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName().equals(object2)) {
            this.gracenote.setDeviceService((DSIMetadataService)object);
            this.gracenote.init();
            bl = true;
        } else if (object instanceof IGracenoteServiceListener) {
            this.gracenote.register((IGracenoteServiceListener)object);
            bl = true;
        } else if (object instanceof WavePlayer) {
            SystemTonePlayer systemTonePlayer = ((WavePlayer)object).getSystemTonePlayer();
            this.beep.registerSystemTonePlayer(systemTonePlayer);
            bl = true;
        } else if (object instanceof TunerServiceListener) {
            this.serviceHandler.addListener((TunerServiceListener)object);
            bl = true;
        } else if (object instanceof CombiBAPServiceTuner) {
            this.combiHandler.setCombiService((CombiBAPServiceTuner)object);
            bl = true;
        } else if (object instanceof IRadioInterappListener) {
            this.tabletHandler.register((IRadioInterappListener)object);
            bl = true;
        } else if (object instanceof HMIAudioService) {
            this.audio.setDeviceService((HMIAudioService)object);
            this.audio.init();
            bl = true;
        } else if (object instanceof ITelService) {
            TunerProxyManager.getInstance().getSDARSTuner().setPhoneService((ITelService)object);
            this.hyperlinkProcessor.register((ITelService)object);
            bl = true;
        } else if (object instanceof IAudioFocusManager) {
            this.audioFocusClient.register((IAudioFocusManager)object);
            bl = true;
        } else if (object instanceof AudioDrawerContext) {
            this.audioFocusClient.register((AudioDrawerContext)object);
            bl = true;
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.getDiagnosis());
            bl = true;
        } else if (object instanceof NaviService) {
            this.hyperlinkProcessor.register((NaviService)object);
            bl = true;
        } else if (object instanceof IMessagingService) {
            this.hyperlinkProcessor.register((IMessagingService)object);
            bl = true;
        }
        return bl ? object : null;
    }

    void removeService(Object object, Object object2, Object object3) {
        this.basics.getLogger().main.log(1078071040, "[AppTuner.removeService] %1 %2", object, object2);
        if ((class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = AppTuner.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getAmFmTuner().deinit();
            TunerProxyManager.getInstance().getAmFmTuner().setDeviceService(new NullDSIAMFMTunerService(this.basics.getLogger().amfmDSI));
            Utilities.getFramework().startDSIService((class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = AppTuner.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner).getName(), 0);
        } else if ((class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = AppTuner.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getDABTuner().deinit();
            TunerProxyManager.getInstance().getDABTuner().setDeviceService(new NullDSIDABTunerService(this.basics.getLogger().dabDSI));
            Utilities.getFramework().startDSIService((class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = AppTuner.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner).getName(), 0);
        } else if ((class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = AppTuner.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getSDARSTuner().deinit();
            TunerProxyManager.getInstance().getSDARSTuner().setDeviceService(new NullDSISDARSTunerService(this.basics.getLogger().sdarsDSI));
            Utilities.getFramework().startDSIService((class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = AppTuner.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName(), 0);
        } else if ((class$org$dsi$ifc$radio$DSIUnifiedTuner == null ? (class$org$dsi$ifc$radio$DSIUnifiedTuner = AppTuner.class$("org.dsi.ifc.radio.DSIUnifiedTuner")) : class$org$dsi$ifc$radio$DSIUnifiedTuner).getName().equals(object2)) {
            TunerProxyManager.getInstance().getUnifiedTuner().deinit();
            TunerProxyManager.getInstance().getUnifiedTuner().setDeviceService(new NullDSIUnifiedTunerService(this.basics.getLogger().uniDSI));
            Utilities.getFramework().startDSIService((class$org$dsi$ifc$radio$DSIUnifiedTuner == null ? (class$org$dsi$ifc$radio$DSIUnifiedTuner = AppTuner.class$("org.dsi.ifc.radio.DSIUnifiedTuner")) : class$org$dsi$ifc$radio$DSIUnifiedTuner).getName(), 0);
        } else if ((class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = AppTuner.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement).getName().equals(object2)) {
            this.announce.deinit();
            this.announce.setDeviceService(new NullDSITunerAnnouncement(this.basics.getLogger().announce));
            Utilities.getFramework().startDSIService((class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = AppTuner.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement).getName(), 0);
        } else if ((class$org$dsi$ifc$media$DSIMetadataService == null ? (class$org$dsi$ifc$media$DSIMetadataService = AppTuner.class$("org.dsi.ifc.media.DSIMetadataService")) : class$org$dsi$ifc$media$DSIMetadataService).getName().equals(object2)) {
            this.gracenote.setDeviceService(null);
        } else if (object instanceof IGracenoteServiceListener) {
            this.gracenote.register(null);
        } else if (object instanceof WavePlayer) {
            this.beep.registerSystemTonePlayer(null);
        } else if (object instanceof TunerServiceListener) {
            this.serviceHandler.removeListener((TunerServiceListener)object);
        } else if (object instanceof CombiBAPServiceTuner) {
            this.combiHandler.setCombiService(null);
        } else if (object instanceof IRadioInterappListener) {
            this.tabletHandler.register(null);
        } else if (object instanceof HMIAudioService) {
            this.audio.deinit();
            this.audio.setDeviceService(null);
        } else if (object instanceof SwDiagnosisManager) {
            ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)this.getDiagnosis());
        } else if (object instanceof IAudioFocusManager) {
            this.audioFocusClient.register((IAudioFocusManager)null);
        } else if (object instanceof AudioDrawerContext) {
            this.audioFocusClient.register((AudioDrawerContext)null);
        } else if (object instanceof ITelService) {
            TunerProxyManager.getInstance().getSDARSTuner().setPhoneService(null);
            this.hyperlinkProcessor.register((ITelService)null);
        } else if (object instanceof NaviService) {
            this.hyperlinkProcessor.register((NaviService)null);
        } else if (object instanceof IMessagingService) {
            this.hyperlinkProcessor.register((IMessagingService)null);
        }
    }

    private int handleLastMode() {
        int n = this.storage.loadLastMode()[1];
        int n2 = this.storage.loadLastMode()[0];
        this.audio.setLastMode(n);
        switch (n) {
            case 5: {
                if (Utilities.isDABPresent()) {
                    this.basics.getLogger().main.log(1078071040, "DABTuner present ");
                    this.basics.getModels().getChoiceModel(-595132160).setValue(5);
                    break;
                }
                this.basics.getLogger().main.log(1078071040, "DABTuner not present, changing to FM ");
                this.basics.getModels().getChoiceModel(-595132160).setValue(1);
                n = 1;
                break;
            }
            case 7: {
                if (Utilities.isSDARSPresent()) {
                    this.basics.getModels().getChoiceModel(-595132160).setValue(7);
                    break;
                }
                this.basics.getModels().getChoiceModel(-595132160).setValue(1);
                n = 1;
                break;
            }
            case 4: {
                this.basics.getModels().getChoiceModel(-595132160).setValue(4);
                break;
            }
            default: {
                this.basics.getModels().getChoiceModel(-595132160).setValue(1);
            }
        }
        this.basics.getModels().setActiveTuner(n);
        this.basics.getModels().getChoiceModel(-595132160).setValue(n2);
        this.basics.getModels().getChoiceModel(422).setValue(n);
        return n;
    }

    private void initListeners() {
        IAMFMTuner iAMFMTuner = TunerProxyManager.getInstance().getAmFmTuner();
        this.bandList.addUpdateListener(this.serviceHandler);
        this.bandList.addUpdateListener(this.combiHandler);
        this.bandList.addUpdateListener(this.tabletHandler);
        this.announce.addUpdateListener(this.combiHandler);
        this.messageListener.addMessageListener(TunerProxyManager.getInstance().getDabGUIHandler().getMessageListener());
        iAMFMTuner.registerDsiUpDownListener(this.combiHandler.dsiUpListener);
        this.audio.register(this.beep.audioInfoListener);
    }

    void initFull() {
        if (!this.basics.getStatus().isMemoryListInitialized()) {
            this.memory.initMemoryList(null);
        }
    }

    public TunerHMIApplication getHMIApplication() {
        return this.hmiApplication;
    }

    public TunerBasics getBasics() {
        return this.basics;
    }

    public BandListHandler getBandList() {
        return this.bandList;
    }

    public TunerMessageListener getMessageListener() {
        return this.messageListener;
    }

    public TunerDiag getDiagnosis() {
        if (this.diag == null) {
            this.diag = new TunerDiag(this.basics, this.keys, this.memory, this.announce, (TunerService)this.tunerService, this.taggingMgr, this.audioFocusClient, this);
        }
        return this.diag;
    }

    public MemoryListHandler getMemory() {
        return this.memory;
    }

    public TunerPowerEventListener getPowerEventListener() {
        return this.power;
    }

    public TunerDiagnosisApplication getDiagnosisApplication() {
        return this.diagnosisApp;
    }

    public AnnouncementHandler getAnnouncementHandler() {
        return this.announce;
    }

    public OptionsHandler getOptionsHandler() {
        return this.optionsHandler;
    }

    public TunerServiceHandler getTunerServiceHandler() {
        return this.serviceHandler;
    }

    public TunerService getTunerService() {
        return this.tunerService;
    }

    public CombiBAPServiceListenerImpl getCombiTunerListener() {
        return this.combiListener;
    }

    public CombiBAPServiceHandler getCombiServiceHandler() {
        return this.combiHandler;
    }

    public AppChangeHandler getAppChangeHandler() {
        return this.appChangeHandler;
    }

    public ITunesTaggingDSI getTagging() {
        return this.taggingDSI;
    }

    public TaggingManager getTaggingMgr() {
        return this.taggingMgr;
    }

    void initTagging() {
        if (this.taggingDSI != null && this.taggingMgr != null) {
            this.taggingMgr.init(this.taggingDSI);
        }
    }

    public TunerActionProxyListener[] getCoreActionProxyListeners() {
        int n;
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(this.basics.getStatus().actionProxyListener);
        arrayList.add(this.audioFocusClient.actionProxyListener);
        arrayList.add(this.announce.actionProxyListener);
        arrayList.add(this.memory.actionProxyListener);
        if (!Utilities.isPGen1OrBentley()) {
            arrayList.add(this.keys.getBandSelectKeyHandler().actionProxyListener);
        }
        arrayList.add(this.scanHandler.actionProxyListener);
        arrayList.add(this.combiHandler.actionProxyListener);
        TunerActionProxyListener[] tunerActionProxyListenerArray = TunerProxyManager.getInstance().getAmFmTuner().getActionProxyListeners();
        for (n = 0; n < tunerActionProxyListenerArray.length; ++n) {
            arrayList.add(tunerActionProxyListenerArray[n]);
        }
        arrayList.add(TunerProxyManager.getInstance().getDABTuner().getActionProxyListener());
        tunerActionProxyListenerArray = TunerProxyManager.getInstance().getSDARSTuner().getActionProxyListeners();
        for (n = 0; n < tunerActionProxyListenerArray.length; ++n) {
            arrayList.add(tunerActionProxyListenerArray[n]);
        }
        return (TunerActionProxyListener[])arrayList.toArray(new TunerActionProxyListener[arrayList.size()]);
    }

    public TabletServiceHandler getTabletServiceHandler() {
        return this.tabletHandler;
    }

    public TabletServiceImpl getTabletService() {
        return this.tabletService;
    }

    public void registerUpdateListener(IUpdateListener iUpdateListener) {
        ((GUIHandlerAMFM)TunerProxyManager.getInstance().getAmFmGUIHandler()).getAMStationList().addUpdateListener(iUpdateListener);
        ((GUIHandlerAMFM)TunerProxyManager.getInstance().getAmFmGUIHandler()).getFMStationList().addUpdateListener(iUpdateListener);
        TunerProxyManager.getInstance().getDabStationListHandler().addUpdateListener(iUpdateListener);
        TunerProxyManager.getInstance().getSdarsStationListHandler().addUpdateListener(iUpdateListener);
        TunerProxyManager.getInstance().getUniStationListHandler().addUpdateListener(iUpdateListener);
        this.memory.addUpdateListener(iUpdateListener);
        if (this.historyTuner != null) {
            this.historyTuner.addUpdateListener(iUpdateListener);
        }
        this.bandList.addUpdateListener(iUpdateListener);
        this.announce.addUpdateListener(iUpdateListener);
    }

    public TunerStorage getStorage() {
        return this.storage;
    }

    public ScanHandler getScanHandler() {
        return this.scanHandler;
    }

    public BeepHandler getBeepHandler() {
        return this.beep;
    }

    public LanguageManager getLangMngr() {
        return this.langMngr;
    }

    public RadioPresetHandler getRadioPresetHandler() {
        return this.radioPresetHandler;
    }

    public DSICarTimeUnitsLanguageListener getDSICarTimeUnitsLanguageListener() {
        return this.clockTimeZoneOffsetHandler.dsiListener;
    }

    public PsFreezeHandler getPsFreezeHandler() {
        return this.psFreezeHandler;
    }

    public HistoryTuner getHistory() {
        return this.historyTuner;
    }

    public KeyHandlerManager getKeyHandlerManager() {
        return this.keys;
    }

    public RadioDataListenerImpl getRadioDataListener() {
        return this.logoDatabase.getRadioDataListener();
    }

    public RadioDataDsi getRadioDataDsi() {
        return this.logoDatabase.getRadioDataDsi();
    }

    public LogoDatabase getLogoDB() {
        return this.logoDatabase;
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

