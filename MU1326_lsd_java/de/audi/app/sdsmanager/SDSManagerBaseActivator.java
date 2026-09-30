/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sds.SDSManagerDiag
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.ISDSDispatcher;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSCommandListSupplier;
import de.audi.app.sdsmanager.SDSDispatcher;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.SpeechSMEventDispatcher;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.SDSServiceImpl;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.apps.system.SystemVBIHandlerActivationProxy;
import de.audi.app.sdsmanager.commands.CommandSpeechDSIInit;
import de.audi.app.sdsmanager.commands.CommandSpeechDSIReinit;
import de.audi.app.sdsmanager.commands.SDSCommandListFilter;
import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSPopupHelper;
import de.audi.app.sdsmanager.common.SDSStrategyAbstractFactory;
import de.audi.app.sdsmanager.dictation.DictationService;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionListener;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSListener;
import de.audi.app.sdsmanager.grammar.DynamicLists;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.grammar.SDSGrammarStateImpl;
import de.audi.app.sdsmanager.grammar.TTSASRImpl;
import de.audi.app.sdsmanager.nbest.NBestListStorage;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallNames;
import de.audi.app.sdsmanager.syscall.SystemCallNames;
import de.audi.app.sdsmanager.testsupport.SDSDebugHandler;
import de.audi.app.sdsmanager.testsupport.SDSSettingsHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SDSStatisticsHandler;
import de.audi.app.sdsmanager.testsupport.SDSValueGapHandlerNotificationBuilder;
import de.audi.app.sdsmanager.testsupport.SLMRulesMap;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.AppInfoKrService;
import de.audi.atip.interapp.IMessagingDictationService;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.ISdsConnectivityService;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.car.CarSDSService;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS;
import de.audi.atip.interapp.media.IMediaSDSService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.interapp.tts.TTSSDSService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.mib.swdiagnosis.sds.SDSManagerDiag;
import java.util.Dictionary;
import java.util.Hashtable;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class SDSManagerBaseActivator
extends AbstractActivator
implements ServiceTrackerCustomizer {
    protected static ISDSMapping mapping;
    private static volatile CommandListManager sysCallCmdListManager;
    private static volatile CommandListManager dsiCallCmdListManager;
    private static ISystemCallNames systemCallNames;
    protected LogChannel lc;
    protected AppSDSManager sdsManager;
    protected SDSHMIListener sdsHMIListener;
    protected SpeechRecognitionHandler speechRecHandler;
    protected SpeechRecognitionListener speechRecListener;
    protected MobileSpeechRecognitionHandler mobileSpeechRecHandler;
    private MobileSpeechRecognitionListener mobileSpeechRecListener;
    protected SpeechTTSHandler speechTTSHandler;
    private SpeechTTSListener speechTTSListener;
    protected SDSAudioHandler sdsAudioHandler;
    private ISystemVBIHandler systemVBIHandler;
    private SDSManagerDiag swDiagnosisManger;
    private ServiceTracker serviceTracker;
    protected SDSAdapter sdsAdapter;
    protected SDSAppFactory sdsAppFactory;
    private ITTSASR ttsASR;
    protected SDSTimeoutHandler timeout;
    private DictationService dictationService;
    private ServiceReference speechRecServiceReference;
    protected IDynamicLists dynamicHMILists;
    protected SDSGrammarStateImpl grammarState;
    protected ISDSPopupHelper popupHelper;
    protected NBestListStorage nBestStorage;
    protected ISDSDispatcher dispatcher;
    protected SDSStrategyAbstractFactory sdsAbstractFactory;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRec;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;
    static /* synthetic */ Class class$de$audi$atip$i18n$I18NTarget;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRecListener;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener;
    static /* synthetic */ Class class$de$audi$app$sdsmanager$common$SDSListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBSDSServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaSDSServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$MapServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$AppInfoKrServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$PhoneServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$OnlineServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingDictationServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingReadoutServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener;
    static /* synthetic */ Class class$de$audi$atip$statemachine$sds$TTSASR;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioServiceListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIModelBank;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$ADBSDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$MapService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviSDSPOIOnlineService;
    static /* synthetic */ Class class$de$audi$atip$interapp$media$IMediaSDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviService;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceSDS;
    static /* synthetic */ Class class$de$audi$atip$interapp$TunerService;
    static /* synthetic */ Class class$de$audi$atip$interapp$OnlineService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingDictationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingReadoutService;
    static /* synthetic */ Class class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService;
    static /* synthetic */ Class class$de$audi$atip$interapp$ISdsConnectivityService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService;
    static /* synthetic */ Class class$de$audi$atip$mmicombi$IViewSizeManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$car$CarSDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineDestinationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOperatorCallSDSService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$AppInfoKrService;

    void start(BundleContext bundleContext, ISDSMapping iSDSMapping) {
        super.start(bundleContext);
        SDSManagerBaseActivator.setMapping(iSDSMapping);
        Logger.initLogChannels(this.framework);
        this.lc = Logger.getMainLog();
        this.createApplications();
        this.registerSysCallAP(bundleContext);
        this.registerServices();
        this.initTrackers(bundleContext);
        this.framework.startDSIService((class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = SDSManagerBaseActivator.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec).getName(), 0);
        this.framework.startDSIService((class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition = SDSManagerBaseActivator.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognition")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition).getName(), 0);
        SDSStatisticsHandler.createSingletonInstance(bundleContext, "AppSDS-Statistics", this.createSLMRulesMap());
        SDSDebugHandler.createSingletonInstance(bundleContext, "AppSDS-Debug");
        SDSSettingsHandlerNotification.createSingletonInstance(bundleContext, "AppSDS-Settings");
        SDSValueGapHandlerNotificationBuilder.createSingletonInstances(bundleContext, this.sdsAdapter);
        this.lc.log(10000000, "SDSManagerBaseActivator#start: Done!");
    }

    protected abstract void registerSysCallAP(BundleContext var1);

    protected SDSHMIListener createSDSHMIListener(IFrameworkAccess iFrameworkAccess, AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, SpeechTTSHandler speechTTSHandler, IDynamicLists iDynamicLists, ISDSGrammarState iSDSGrammarState, ISDSPopupHelper iSDSPopupHelper, SDSAudioHandler sDSAudioHandler, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, SDSTimeoutHandler sDSTimeoutHandler, ISDSDispatcher iSDSDispatcher) {
        return new SDSHMIListener(iFrameworkAccess, appSDSManager, speechRecognitionHandler, speechTTSHandler, iDynamicLists, iSDSGrammarState, iSDSPopupHelper, sDSAudioHandler, mobileSpeechRecognitionHandler, iSDSDispatcher);
    }

    protected abstract SLMRulesMap createSLMRulesMap();

    protected void createApplications() {
        this.lc.log(10000000, "SDSManagerBaseActivator#createApplications: called");
        this.createPopupHelper();
        this.initCommandListManagers();
        this.dispatcher = new SDSDispatcher();
        this.mobileSpeechRecHandler = new MobileSpeechRecognitionHandler(this.popupHelper);
        this.speechRecHandler = this.createSpeechRecognitionHandler(this.framework);
        this.speechTTSHandler = new SpeechTTSHandler();
        this.sdsManager = new AppSDSManager(this.dispatcher, this.popupHelper, this.mobileSpeechRecHandler, this.speechTTSHandler);
        this.dynamicHMILists = this.createDynamicLists();
        this.sdsAudioHandler = new SDSAudioHandler(this.framework, this.sdsManager, this.mobileSpeechRecHandler);
        this.popupHelper.setAppSDSManager(this.sdsManager);
        this.popupHelper.setSDSAudioHandler(this.sdsAudioHandler);
        this.grammarState = new SDSGrammarStateImpl();
        this.timeout = this.createSDSTimeoutHandler(this.sdsManager, this.speechRecHandler, this.popupHelper);
        this.sdsHMIListener = this.createSDSHMIListener(this.framework, this.sdsManager, this.speechRecHandler, this.speechTTSHandler, this.dynamicHMILists, this.grammarState, this.popupHelper, this.sdsAudioHandler, this.mobileSpeechRecHandler, this.timeout, this.dispatcher);
        this.sdsManager.setSDSHMIListener(this.sdsHMIListener);
        this.mobileSpeechRecHandler.setSDSHMIListener(this.sdsHMIListener);
        this.speechTTSHandler.setSDSTimeoutHandler(this.timeout);
        this.mobileSpeechRecHandler.setSDSTimeoutHandler(this.timeout);
        this.sdsManager.setSDSTimeoutHandler(this.timeout);
        this.sdsAdapter = new SDSAdapter(this.framework, this.speechRecHandler, this.sdsManager, this.sdsHMIListener, this.sdsAudioHandler, this.dispatcher, this.timeout, new SpeechSMEventDispatcher(this.framework.getHMIService(), this.popupHelper, this.sdsManager));
        this.sdsManager.setSDSAdapter(this.sdsAdapter);
        this.sdsHMIListener.setSDSAdapter(this.sdsAdapter);
        this.sdsAudioHandler.setSDSAdapter(this.sdsAdapter);
        this.speechRecHandler.setSDSAdapter(this.sdsAdapter);
        this.speechTTSHandler.setSDSAdapter(this.sdsAdapter);
        this.timeout.setSDSAdapter(this.sdsAdapter);
        this.sdsHMIListener.registerSysAppListeners(this.framework);
        if (this.framework.getSysConst(523) != 0 && this.framework.getSysConst(549) == 1) {
            this.dictationService = new DictationService();
            this.dictationService.start(this.bundleContext, this.framework);
        }
        this.createNBestListStorage(this.framework, this.sdsAdapter);
        this.sdsAppFactory = this.createFactory(this.framework, this.speechRecHandler, this.speechTTSHandler, this.sdsManager, this.sdsHMIListener, this.sdsAudioHandler, this.dispatcher, this.nBestStorage, this.dynamicHMILists, this.sdsAdapter, this.timeout, this.popupHelper, this.mobileSpeechRecHandler, this.dictationService);
        this.sdsHMIListener.setFactory(this.sdsAppFactory);
        this.sdsAdapter.setFactory(this.sdsAppFactory);
        this.sdsManager.setFactory(this.sdsAppFactory);
        this.sdsAudioHandler.setSystemSDSHandler(this.sdsAppFactory.getSDSHandlerSystem());
        this.speechTTSListener = new SpeechTTSListener(this.speechTTSHandler, this.sdsAppFactory, this.sdsAdapter, this.timeout);
        this.speechRecListener = this.createSpeechRecognitionListener();
        this.ttsASR = new TTSASRImpl(this.speechRecHandler, this.speechTTSHandler, this.dynamicHMILists, this.nBestStorage, this.grammarState, this.sdsAdapter, this.sdsManager, this.framework.getHMIService());
        this.systemVBIHandler = new SystemVBIHandlerActivationProxy(this.sdsAdapter, this.sdsManager, this.sdsAppFactory.getSDSHandlerSystem(), this.speechTTSHandler, this.speechRecHandler, this.timeout, this.lc);
        this.sdsAppFactory.setSystemVBIHandler(this.systemVBIHandler);
        this.sdsAppFactory.getSDSHandlerSystem().setSystemVBIHandler(this.systemVBIHandler);
        this.speechTTSHandler.setSystemVBIHandler(this.systemVBIHandler);
        this.speechTTSListener.setSystemVBIHandler(this.systemVBIHandler);
        this.speechRecHandler.setSystemVBIHandler(this.systemVBIHandler);
        this.speechRecListener.registerSpeechRecognitionStateListener(this.systemVBIHandler);
        this.sdsAppFactory.setTTSASR(this.ttsASR);
        this.mobileSpeechRecListener = new MobileSpeechRecognitionListener(this.mobileSpeechRecHandler, this.sdsAppFactory.getTerminalModeSDSHandler());
        this.swDiagnosisManger = new SDSManagerDiag(this.sdsManager, this.sdsAdapter, this.sdsHMIListener, this.sdsAudioHandler, this.dispatcher, this.speechRecHandler, this.speechRecListener, this.speechTTSHandler, this.ttsASR, this.timeout, this, this.sdsAppFactory, this.dynamicHMILists, this.systemVBIHandler);
        this.setCommandListReferences();
        this.initCommandList();
        this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 1: SDS applications started.");
    }

    protected DynamicLists createDynamicLists() {
        return new DynamicLists();
    }

    protected SDSTimeoutHandler createSDSTimeoutHandler(AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, ISDSPopupHelper iSDSPopupHelper) {
        return new SDSTimeoutHandler(appSDSManager, speechRecognitionHandler, iSDSPopupHelper);
    }

    protected SDSAppFactory createFactory(IFrameworkAccess iFrameworkAccess, SpeechRecognitionHandler speechRecognitionHandler, SpeechTTSHandler speechTTSHandler, AppSDSManager appSDSManager, SDSHMIListener sDSHMIListener, SDSAudioHandler sDSAudioHandler, ISDSDispatcher iSDSDispatcher, NBestStorageAccess nBestStorageAccess, IDynamicLists iDynamicLists, SDSHandlerService sDSHandlerService, SDSTimeoutHandler sDSTimeoutHandler, ISDSPopupHelper iSDSPopupHelper, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, DictationService dictationService) {
        return new SDSAppFactory(iFrameworkAccess, speechRecognitionHandler, speechTTSHandler, appSDSManager, sDSHMIListener, sDSAudioHandler, iSDSDispatcher, nBestStorageAccess, iDynamicLists, sDSHandlerService, sDSTimeoutHandler, iSDSPopupHelper, mobileSpeechRecognitionHandler, dictationService);
    }

    protected void createPopupHelper() {
        this.popupHelper = new SDSPopupHelper(this.framework);
    }

    protected SpeechRecognitionHandler createSpeechRecognitionHandler(IFrameworkAccess iFrameworkAccess) {
        return new SpeechRecognitionHandler(iFrameworkAccess);
    }

    protected void createNBestListStorage(IFrameworkAccess iFrameworkAccess, SDSAdapter sDSAdapter) {
        this.nBestStorage = new NBestListStorage(iFrameworkAccess, sDSAdapter);
    }

    protected SpeechRecognitionListener createSpeechRecognitionListener() {
        return new SpeechRecognitionListener(this.framework, this.speechRecHandler, this.sdsManager, this.sdsAppFactory, this.sdsAdapter, this.timeout, this.createSDSStrategyAbstractFactory());
    }

    protected SDSServiceImpl createSDSServiceImpl(AppSDSManager appSDSManager, SDSHandlerService sDSHandlerService, HMIService hMIService, SpeechTTSHandler speechTTSHandler, SDSAppFactory sDSAppFactory, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler) {
        return new SDSServiceImpl(appSDSManager, sDSHandlerService, hMIService, speechTTSHandler, sDSAppFactory, mobileSpeechRecognitionHandler);
    }

    protected abstract SDSStrategyAbstractFactory createSDSStrategyAbstractFactory();

    protected void registerServices() {
        this.lc.log(10000000, "SDSManagerBaseActivator#registerServices: Registering HMIApplication and I18NTarget!");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "SDSManager");
        hashtable.put("moduleID", new Integer(14));
        hashtable.put("LANG_COMPONENT_TYPE", "LANG_COMPONENT_SDS");
        super.registerService(new String[]{(class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = SDSManagerBaseActivator.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), (class$de$audi$atip$i18n$I18NTarget == null ? (class$de$audi$atip$i18n$I18NTarget = SDSManagerBaseActivator.class$("de.audi.atip.i18n.I18NTarget")) : class$de$audi$atip$i18n$I18NTarget).getName()}, (Object)this.sdsHMIListener, (Dictionary)hashtable);
        this.lc.log(10000000, "SDSManagerBaseActivator#registerServices: Registering SDS service!");
        SDSServiceImpl sDSServiceImpl = this.createSDSServiceImpl(this.sdsManager, this.sdsAdapter, this.framework.getHMIService(), this.speechTTSHandler, this.sdsAppFactory, this.mobileSpeechRecHandler);
        super.registerService((class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (Object)sDSServiceImpl, (Dictionary)hashtable);
        if (sDSServiceImpl == null) {
            this.lc.log(10000000, "SDSManagerBaseActivator#createApplications: sdsService null!");
        } else if (this.speechRecHandler == null) {
            this.lc.log(10000000, "SDSManagerBaseActivator#createApplications: spech rec handler null!");
        } else {
            this.lc.log(10000000, "SDSManagerBaseActivator#createApplications: sr handler set!");
            sDSServiceImpl.setSpeechRecHandler(this.speechRecHandler);
        }
        this.lc.log(10000000, "SDSManagerBaseActivator#registerServices: Registering message listener and power event listener!");
        super.registerService(new String[]{(class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SDSManagerBaseActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = SDSManagerBaseActivator.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener).getName()}, (Object)this.sdsAdapter, (Dictionary)hashtable);
        this.lc.log(10000000, "SDSManagerBaseActivator#registerServices: Registering DSI (mobile) speech recognition listener!");
        super.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SDSManagerBaseActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.speechRecListener, (class$org$dsi$ifc$speechrec$DSISpeechRecListener == null ? (class$org$dsi$ifc$speechrec$DSISpeechRecListener = SDSManagerBaseActivator.class$("org.dsi.ifc.speechrec.DSISpeechRecListener")) : class$org$dsi$ifc$speechrec$DSISpeechRecListener).getName(), 0);
        super.registerDSIListener((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = SDSManagerBaseActivator.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), this.mobileSpeechRecListener, (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener = SDSManagerBaseActivator.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener).getName(), 0);
        this.lc.log(10000000, "SDSManagerBaseActivator#registerServices: Registering SDSListener service!");
        super.registerService((class$de$audi$app$sdsmanager$common$SDSListener == null ? (class$de$audi$app$sdsmanager$common$SDSListener = SDSManagerBaseActivator.class$("de.audi.app.sdsmanager.common.SDSListener")) : class$de$audi$app$sdsmanager$common$SDSListener).getName(), (Object)this.sdsAdapter, null);
        super.registerService((class$de$audi$atip$interapp$ADBSDSServiceListener == null ? (class$de$audi$atip$interapp$ADBSDSServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.ADBSDSServiceListener")) : class$de$audi$atip$interapp$ADBSDSServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerADB(), null);
        super.registerService((class$de$audi$atip$interapp$media$IMediaServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.media.IMediaServiceListener")) : class$de$audi$atip$interapp$media$IMediaServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerMedia(), null);
        super.registerService((class$de$audi$atip$interapp$media$IMediaSDSServiceListener == null ? (class$de$audi$atip$interapp$media$IMediaSDSServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.media.IMediaSDSServiceListener")) : class$de$audi$atip$interapp$media$IMediaSDSServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerMedia(), null);
        super.registerService((class$de$audi$atip$interapp$MapServiceListener == null ? (class$de$audi$atip$interapp$MapServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.MapServiceListener")) : class$de$audi$atip$interapp$MapServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerNavi(), null);
        super.registerService((class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerNavi().getNaviServiceListener(), null);
        super.registerService((class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener == null ? (class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener")) : class$de$audi$atip$interapp$NaviSDSPOIOnlineServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerNavi().getPOIOnlineServiceListener(), null);
        super.registerService((class$de$audi$atip$interapp$AppInfoKrServiceListener == null ? (class$de$audi$atip$interapp$AppInfoKrServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.AppInfoKrServiceListener")) : class$de$audi$atip$interapp$AppInfoKrServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerNavi(), null);
        super.registerService((class$de$audi$atip$interapp$PhoneServiceListener == null ? (class$de$audi$atip$interapp$PhoneServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.PhoneServiceListener")) : class$de$audi$atip$interapp$PhoneServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerPhone(), null);
        super.registerService((class$de$audi$atip$interapp$TunerServiceListener == null ? (class$de$audi$atip$interapp$TunerServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.TunerServiceListener")) : class$de$audi$atip$interapp$TunerServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerTuner(), null);
        super.registerService((class$de$audi$atip$interapp$OnlineServiceListener == null ? (class$de$audi$atip$interapp$OnlineServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.OnlineServiceListener")) : class$de$audi$atip$interapp$OnlineServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerRemoteHMI(), null);
        super.registerService((class$de$audi$atip$interapp$IMessagingDictationServiceListener == null ? (class$de$audi$atip$interapp$IMessagingDictationServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingDictationServiceListener")) : class$de$audi$atip$interapp$IMessagingDictationServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerMessageDictation(), null);
        super.registerService((class$de$audi$atip$interapp$IMessagingReadoutServiceListener == null ? (class$de$audi$atip$interapp$IMessagingReadoutServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingReadoutServiceListener")) : class$de$audi$atip$interapp$IMessagingReadoutServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerMessaging(), null);
        super.registerService((class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener == null ? (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener")) : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerMessaging(), null);
        super.registerService((class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener == null ? (class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineSDSMyAudiServiceListener")) : class$de$audi$atip$interapp$online$IOnlineSDSMyAudiServiceListener).getName(), (Object)this.sdsAppFactory.getSDSHandlerNavi().getNaviServiceListener(), null);
        super.registerService((class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener == null ? (class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener")) : class$de$audi$atip$interapp$terminalmode$ITerminalModeUpdateListener).getName(), (Object)this.sdsAppFactory.getTerminalModeSDSHandler(), null);
        this.lc.log(10000000, "SDSManagerBaseActivator#registerServices: Registering TTSASR service!");
        super.registerService((class$de$audi$atip$statemachine$sds$TTSASR == null ? (class$de$audi$atip$statemachine$sds$TTSASR = SDSManagerBaseActivator.class$("de.audi.atip.statemachine.sds.TTSASR")) : class$de$audi$atip$statemachine$sds$TTSASR).getName(), (Object)this.ttsASR, null);
        Hashtable hashtable2 = new Hashtable();
        hashtable2.put("AUDIO_CLIENT_ID", HMIAudioService.CLIENT_SDS);
        super.registerService((class$de$audi$atip$audio$HMIAudioServiceListener == null ? (class$de$audi$atip$audio$HMIAudioServiceListener = SDSManagerBaseActivator.class$("de.audi.atip.audio.HMIAudioServiceListener")) : class$de$audi$atip$audio$HMIAudioServiceListener).getName(), (Object)this.sdsAudioHandler, (Dictionary)hashtable2);
        Hashtable hashtable3 = new Hashtable();
        hashtable3.put("TTS_CLIENT_ID", TTSService.CLIENT_ID_SDS);
        hashtable3.put("ApplicationName", "SDS");
        super.registerService((class$de$audi$atip$interapp$tts$TTSListener == null ? (class$de$audi$atip$interapp$tts$TTSListener = SDSManagerBaseActivator.class$("de.audi.atip.interapp.tts.TTSListener")) : class$de$audi$atip$interapp$tts$TTSListener).getName(), (Object)this.speechTTSListener, (Dictionary)hashtable3);
        Hashtable hashtable4 = new Hashtable();
        SDSModelAccess.SDSModelBank sDSModelBank = this.sdsHMIListener.getModelAccess().getModels();
        hashtable4.put("ApplicationName", "SDSManager");
        hashtable4.put("moduleID", new Integer(sDSModelBank.getId()));
        super.registerService((class$de$audi$atip$hmi$HMIModelBank == null ? (class$de$audi$atip$hmi$HMIModelBank = SDSManagerBaseActivator.class$("de.audi.atip.hmi.HMIModelBank")) : class$de$audi$atip$hmi$HMIModelBank).getName(), (Object)sDSModelBank, (Dictionary)hashtable4);
    }

    private void initTrackers(BundleContext bundleContext) {
        this.serviceTracker = new ServiceTracker(bundleContext, this.getServiceArray(), (ServiceTrackerCustomizer)this);
        this.serviceTracker.open();
    }

    protected String[] getServiceArray() {
        return new String[]{(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS = SDSManagerBaseActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS).getName(), (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = SDSManagerBaseActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (class$org$dsi$ifc$speechrec$DSISpeechRec == null ? (class$org$dsi$ifc$speechrec$DSISpeechRec = SDSManagerBaseActivator.class$("org.dsi.ifc.speechrec.DSISpeechRec")) : class$org$dsi$ifc$speechrec$DSISpeechRec).getName(), (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition = SDSManagerBaseActivator.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognition")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition).getName(), (class$de$audi$atip$interapp$ADBSDSService == null ? (class$de$audi$atip$interapp$ADBSDSService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.ADBSDSService")) : class$de$audi$atip$interapp$ADBSDSService).getName(), (class$de$audi$atip$interapp$MapService == null ? (class$de$audi$atip$interapp$MapService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.MapService")) : class$de$audi$atip$interapp$MapService).getName(), (class$de$audi$atip$interapp$NaviSDSPOIOnlineService == null ? (class$de$audi$atip$interapp$NaviSDSPOIOnlineService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviSDSPOIOnlineService")) : class$de$audi$atip$interapp$NaviSDSPOIOnlineService).getName(), (class$de$audi$atip$interapp$media$IMediaSDSService == null ? (class$de$audi$atip$interapp$media$IMediaSDSService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.media.IMediaSDSService")) : class$de$audi$atip$interapp$media$IMediaSDSService).getName(), (class$de$audi$atip$interapp$NaviService == null ? (class$de$audi$atip$interapp$NaviService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviService")) : class$de$audi$atip$interapp$NaviService).getName(), (class$de$audi$atip$phone$ITelServiceSDS == null ? (class$de$audi$atip$phone$ITelServiceSDS = SDSManagerBaseActivator.class$("de.audi.atip.phone.ITelServiceSDS")) : class$de$audi$atip$phone$ITelServiceSDS).getName(), (class$de$audi$atip$interapp$TunerService == null ? (class$de$audi$atip$interapp$TunerService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.TunerService")) : class$de$audi$atip$interapp$TunerService).getName(), (class$de$audi$atip$interapp$OnlineService == null ? (class$de$audi$atip$interapp$OnlineService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.OnlineService")) : class$de$audi$atip$interapp$OnlineService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = SDSManagerBaseActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName(), (class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (class$de$audi$atip$interapp$IMessagingDictationService == null ? (class$de$audi$atip$interapp$IMessagingDictationService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingDictationService")) : class$de$audi$atip$interapp$IMessagingDictationService).getName(), (class$de$audi$atip$interapp$IMessagingReadoutService == null ? (class$de$audi$atip$interapp$IMessagingReadoutService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingReadoutService")) : class$de$audi$atip$interapp$IMessagingReadoutService).getName(), (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService == null ? (class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutService")) : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService).getName(), (class$de$audi$atip$interapp$ISdsConnectivityService == null ? (class$de$audi$atip$interapp$ISdsConnectivityService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.ISdsConnectivityService")) : class$de$audi$atip$interapp$ISdsConnectivityService).getName(), (class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService == null ? (class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineSDSMyAudiService")) : class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService).getName(), (class$de$audi$atip$mmicombi$IViewSizeManager == null ? (class$de$audi$atip$mmicombi$IViewSizeManager = SDSManagerBaseActivator.class$("de.audi.atip.mmicombi.IViewSizeManager")) : class$de$audi$atip$mmicombi$IViewSizeManager).getName(), (class$de$audi$atip$interapp$car$CarSDSService == null ? (class$de$audi$atip$interapp$car$CarSDSService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.car.CarSDSService")) : class$de$audi$atip$interapp$car$CarSDSService).getName(), (class$de$audi$atip$interapp$online$IOnlineDestinationService == null ? (class$de$audi$atip$interapp$online$IOnlineDestinationService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineDestinationService")) : class$de$audi$atip$interapp$online$IOnlineDestinationService).getName(), (class$de$audi$atip$interapp$online$IOperatorCallSDSService == null ? (class$de$audi$atip$interapp$online$IOperatorCallSDSService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOperatorCallSDSService")) : class$de$audi$atip$interapp$online$IOperatorCallSDSService).getName(), (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = SDSManagerBaseActivator.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext).getName(), (class$de$audi$atip$interapp$AppInfoKrService == null ? (class$de$audi$atip$interapp$AppInfoKrService = SDSManagerBaseActivator.class$("de.audi.atip.interapp.AppInfoKrService")) : class$de$audi$atip$interapp$AppInfoKrService).getName()};
    }

    public void stop(BundleContext bundleContext) {
        this.lc.log(10000000, "SDSManagerBaseActivator#stop: called");
        if (this.sdsAudioHandler != null) {
            this.sdsAudioHandler.stop();
        }
        if (this.sdsManager != null) {
            this.sdsManager.stop();
        }
        if (this.sdsAdapter != null) {
            this.sdsAdapter.stop();
        }
        if (this.sdsHMIListener != null) {
            this.sdsHMIListener.stop();
        }
        if (this.speechRecHandler != null) {
            this.speechRecHandler.stop();
        }
        if (this.speechRecListener != null) {
            this.speechRecListener.stop();
        }
        if (this.speechTTSHandler != null) {
            this.speechTTSHandler.stop();
        }
        if (this.speechTTSListener != null) {
            if (this.speechRecListener != null) {
                this.speechRecListener.unregisterSpeechRecognitionStateListener(this.systemVBIHandler);
            }
            this.speechTTSListener.stop();
        }
        if (this.dictationService != null) {
            this.dictationService.stop();
        }
        this.serviceTracker = super.closeTracker(this.serviceTracker);
        SDSStatisticsHandler.deinitSingletonInstance();
        SDSDebugHandler.deinitSingletonInstance();
        SDSSettingsHandlerNotification.deinitSingletonInstance();
        SDSValueGapHandlerNotificationBuilder.deinitSingletonInstances();
        super.stop(bundleContext);
    }

    protected Object addingServiceByName(ServiceReference serviceReference, Object object) {
        this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: sr=%1", (Object)serviceReference);
        for (String string : (String[])serviceReference.getProperty("objectClass")) {
            this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: className=%1!", (Object)string);
            if (string.equals((class$org$dsi$ifc$speechrec$DSISpeechRec == null ? SDSManagerBaseActivator.class$("org.dsi.ifc.speechrec.DSISpeechRec") : class$org$dsi$ifc$speechrec$DSISpeechRec).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding DSISpeechRec!");
                this.speechRecServiceReference = serviceReference;
                DSISpeechRec dSISpeechRec = (DSISpeechRec)object;
                this.speechRecListener.setDSI(dSISpeechRec);
                this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 2: Speech recognition DSI started.");
                this.startCommandListManagers();
                return dSISpeechRec;
            }
            if (string.equals((class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition == null ? SDSManagerBaseActivator.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognition") : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding DSIMobileSpeechRecognition!");
                DSIMobileSpeechRecognition dSIMobileSpeechRecognition = (DSIMobileSpeechRecognition)object;
                this.mobileSpeechRecListener.setDSI(dSIMobileSpeechRecognition);
                return dSIMobileSpeechRecognition;
            }
            if (string.equals((class$de$audi$atip$interapp$tts$TTSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.tts.TTSService") : class$de$audi$atip$interapp$tts$TTSService).getName())) {
                Object object2 = serviceReference.getProperty("TTS_CLIENT_ID");
                if (!TTSService.CLIENT_ID_SDS.equals(object2)) {
                    this.bundleContext.ungetService(serviceReference);
                    return null;
                }
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding TTS service!");
                TTSSDSService tTSSDSService = (TTSSDSService)object;
                this.speechTTSHandler.setTTSService(tTSSDSService);
                this.sdsAdapter.setTTSReady(true);
                this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 4: TTS service started.");
                return tTSSDSService;
            }
            if (string.equals((class$de$audi$atip$interapp$ADBSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.ADBSDSService") : class$de$audi$atip$interapp$ADBSDSService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding ADB service!");
                ADBSDSService aDBSDSService = (ADBSDSService)object;
                this.sdsAppFactory.getSDSHandlerADB().setADBService(aDBSDSService);
                this.sdsAppFactory.getSDSHandlerNavi().setADBService(aDBSDSService);
                return aDBSDSService;
            }
            if (string.equals((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS") : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding combi BAP SDS service!");
                CombiBAPServiceSDS combiBAPServiceSDS = (CombiBAPServiceSDS)object;
                this.sdsHMIListener.setCombiBAPServiceSDS(combiBAPServiceSDS);
                return combiBAPServiceSDS;
            }
            if (string.equals((class$de$audi$atip$interapp$MapService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.MapService") : class$de$audi$atip$interapp$MapService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding map service!");
                MapService mapService = (MapService)object;
                this.sdsAppFactory.getSDSHandlerNavi().setMapService(mapService);
                return mapService;
            }
            if (string.equals((class$de$audi$atip$interapp$media$IMediaSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.media.IMediaSDSService") : class$de$audi$atip$interapp$media$IMediaSDSService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding media SDS service!");
                IMediaSDSService iMediaSDSService = (IMediaSDSService)object;
                this.sdsAppFactory.getSDSHandlerMedia().setMediaSDSService(iMediaSDSService);
                return iMediaSDSService;
            }
            if (string.equals((class$de$audi$atip$interapp$NaviService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviService") : class$de$audi$atip$interapp$NaviService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding navi service!");
                NaviService naviService = (NaviService)object;
                this.sdsAppFactory.getSDSHandlerNavi().setNaviService(naviService);
                this.sdsAppFactory.getSDSHandlerADB().setNaviService(naviService);
                this.sdsHMIListener.setNaviService(naviService);
                return naviService;
            }
            if (string.equals((class$de$audi$atip$interapp$NaviSDSPOIOnlineService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviSDSPOIOnlineService") : class$de$audi$atip$interapp$NaviSDSPOIOnlineService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding navi SDS POI online service!");
                NaviSDSPOIOnlineService naviSDSPOIOnlineService = (NaviSDSPOIOnlineService)object;
                this.sdsAppFactory.getSDSHandlerNavi().setPOIOnlineService(naviSDSPOIOnlineService);
                return naviSDSPOIOnlineService;
            }
            if (string.equals((class$de$audi$atip$phone$ITelServiceSDS == null ? SDSManagerBaseActivator.class$("de.audi.atip.phone.ITelServiceSDS") : class$de$audi$atip$phone$ITelServiceSDS).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding phone service!");
                ITelServiceSDS iTelServiceSDS = (ITelServiceSDS)object;
                this.sdsAppFactory.getSDSHandlerPhone().setPhoneService(iTelServiceSDS);
                this.sdsAppFactory.getSDSHandlerMessageDictation().setPhoneService(iTelServiceSDS);
                return iTelServiceSDS;
            }
            if (string.equals((class$de$audi$atip$interapp$TunerService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.TunerService") : class$de$audi$atip$interapp$TunerService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding tuner service!");
                TunerService tunerService = (TunerService)object;
                this.sdsAppFactory.getSDSHandlerTuner().setTunerService(tunerService);
                return tunerService;
            }
            if (string.equals((class$de$audi$atip$interapp$OnlineService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.OnlineService") : class$de$audi$atip$interapp$OnlineService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding online service!");
                OnlineService onlineService = (OnlineService)object;
                this.sdsAppFactory.getSDSHandlerRemoteHMI().setOnlineService(onlineService);
                return onlineService;
            }
            if (string.equals((class$de$audi$atip$interapp$IMessagingDictationService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingDictationService") : class$de$audi$atip$interapp$IMessagingDictationService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding messaging service (dictate)!");
                IMessagingDictationService iMessagingDictationService = (IMessagingDictationService)object;
                this.sdsAppFactory.getSDSHandlerMessageDictation().setMessagingDictationService(iMessagingDictationService);
                return iMessagingDictationService;
            }
            if (string.equals((class$de$audi$atip$interapp$IMessagingReadoutService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingReadoutService") : class$de$audi$atip$interapp$IMessagingReadoutService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding messaging service (readout)!");
                IMessagingReadoutService iMessagingReadoutService = (IMessagingReadoutService)object;
                this.sdsAppFactory.getSDSHandlerMessaging().setMessagingReadoutService(iMessagingReadoutService);
                return iMessagingReadoutService;
            }
            if (string.equals((class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutService") : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding messaging service (multiple readout)!");
                IMultipleMessageReadoutService iMultipleMessageReadoutService = (IMultipleMessageReadoutService)object;
                this.sdsAppFactory.getSDSHandlerMessaging().setMultipleMessageReadoutService(iMultipleMessageReadoutService);
                return iMultipleMessageReadoutService;
            }
            if (string.equals((class$de$audi$atip$interapp$ISdsConnectivityService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.ISdsConnectivityService") : class$de$audi$atip$interapp$ISdsConnectivityService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding messaging service (readout)!");
                ISdsConnectivityService iSdsConnectivityService = (ISdsConnectivityService)object;
                this.sdsAppFactory.getSDSHandlerSystem().setConnectivityService(iSdsConnectivityService);
                return iSdsConnectivityService;
            }
            if (string.equals((class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineSDSMyAudiService") : class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding myAudi service!");
                IOnlineSDSMyAudiService iOnlineSDSMyAudiService = (IOnlineSDSMyAudiService)object;
                this.sdsAppFactory.getSDSHandlerNavi().setMyAudiService(iOnlineSDSMyAudiService);
                return iOnlineSDSMyAudiService;
            }
            if (string.equals((class$de$audi$atip$interapp$car$CarSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.car.CarSDSService") : class$de$audi$atip$interapp$car$CarSDSService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding remaining range listener to CarSDSService!");
                CarSDSService carSDSService = (CarSDSService)object;
                carSDSService.addRemainingRangeListener(this.sdsAppFactory.getSDSHandlerNavi());
                return carSDSService;
            }
            if (string.equals((class$de$audi$atip$interapp$online$IOnlineDestinationService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineDestinationService") : class$de$audi$atip$interapp$online$IOnlineDestinationService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding OnlineDestinationService!");
                IOnlineDestinationService iOnlineDestinationService = (IOnlineDestinationService)object;
                this.sdsAppFactory.getSDSHandlerNavi().setOnlineDestinationService(iOnlineDestinationService);
                return iOnlineDestinationService;
            }
            if (string.equals((class$de$audi$atip$interapp$online$IOperatorCallSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOperatorCallSDSService") : class$de$audi$atip$interapp$online$IOperatorCallSDSService).getName())) {
                this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding OperatorCallService");
                IOperatorCallSDSService iOperatorCallSDSService = (IOperatorCallSDSService)object;
                this.sdsAppFactory.getSDSHandlerNavi().setOperatorCallService(iOperatorCallSDSService);
                return iOperatorCallSDSService;
            }
            if (!string.equals((class$de$audi$atip$interapp$AppInfoKrService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.AppInfoKrService") : class$de$audi$atip$interapp$AppInfoKrService).getName())) continue;
            this.lc.log(10000000, "SDSManagerBaseActivator#addingServiceByName: Adding AppInfoKrService");
            AppInfoKrService appInfoKrService = (AppInfoKrService)object;
            this.sdsAppFactory.getSDSHandlerNavi().setAppInfoKrService(appInfoKrService);
            return appInfoKrService;
        }
        return null;
    }

    public Object addingService(ServiceReference serviceReference) {
        this.lc.log(10000000, "SDSManagerBaseActivator#addingService: sr=%1", (Object)serviceReference);
        Object object = super.getBundleContext().getService(serviceReference);
        if (object instanceof HMIAudioService) {
            if (!HMIAudioService.CLIENT_SDS.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
                this.bundleContext.ungetService(serviceReference);
                return null;
            }
            this.lc.log(10000000, "SDSManagerBaseActivator#addingService: Adding HMI audio service!");
            this.sdsAudioHandler.setAudioService((HMIAudioService)object);
            return object;
        }
        if (object instanceof AudioDrawerContext) {
            this.lc.log(10000000, "SDSManagerBaseActivator#addingService: Adding HMI audio drawer context service!");
            this.sdsAudioHandler.setAudioDrawerContextService((AudioDrawerContext)object);
            return object;
        }
        if (object instanceof SwDiagnosisManager) {
            this.lc.log(10000000, "SDSManagerBaseActivator#addingService: Adding SW diagnosis!");
            ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)this.swDiagnosisManger);
            return object;
        }
        if (object instanceof IViewSizeManager) {
            this.lc.log(10000000, "SDSManagerBaseActivator#addingService: Adding view size manager!");
            IViewSizeManager iViewSizeManager = (IViewSizeManager)object;
            iViewSizeManager.addViewSizeListener(this.sdsHMIListener);
            this.popupHelper.setViewSizeManager(iViewSizeManager);
            return object;
        }
        return this.addingServiceByName(serviceReference, object);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        this.lc.log(100000, "[SDSManagerBaseActivator#modifiedService] called => NOP!");
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] sr=%1, svc=%2 ", (Object)serviceReference, object);
        if (object instanceof HMIAudioService && HMIAudioService.CLIENT_SDS.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
            this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] AudioManagerInstance");
            this.sdsAudioHandler.unsetAudioService();
        } else if (object instanceof AudioDrawerContext) {
            this.sdsAudioHandler.unsetAudioDrawerContextService();
        } else if (object instanceof SwDiagnosisManager) {
            this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] Removing SwDiagnosisManager!");
            ((SwDiagnosisManager)object).removeDiagGateway((AbstractSwDiagnosis)this.swDiagnosisManger);
        } else if (object instanceof IViewSizeManager) {
            this.lc.log(10000000, "SDSManagerBaseActivator#removedService: Removing view size manager!");
            this.popupHelper.unsetViewSizeManager();
        } else {
            for (String string : (String[])serviceReference.getProperty("objectClass")) {
                if (string.equals((class$org$dsi$ifc$speechrec$DSISpeechRec == null ? SDSManagerBaseActivator.class$("org.dsi.ifc.speechrec.DSISpeechRec") : class$org$dsi$ifc$speechrec$DSISpeechRec).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] DSISpeechRec instance removed, unsetting DSI and aborting session!");
                    this.speechRecHandler.unsetDSISR();
                    this.sdsAppFactory.getSDSHandlerNavi().setSpeechDSIStatus(false);
                    this.sdsAdapter.setSDSReady(false);
                    this.sdsManager.abortSDSSession(false);
                    if (this.framework != null) {
                        this.initCommandListManagers();
                        this.setCommandListReferences();
                        this.reinitCommandList();
                        this.framework.startDSIService((class$org$dsi$ifc$speechrec$DSISpeechRec == null ? SDSManagerBaseActivator.class$("org.dsi.ifc.speechrec.DSISpeechRec") : class$org$dsi$ifc$speechrec$DSISpeechRec).getName(), 0);
                        this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] DSISpeechRec instance - FW done, calling ungetService!");
                        continue;
                    }
                    this.lc.log(100000, "[SDSManagerBaseActivator#removedService] DSISpeechRec instance - FW is null, NOT calling ungetService!");
                    return;
                }
                if (string.equals((class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition == null ? SDSManagerBaseActivator.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognition") : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] DSIMobileSpeechRecognition instanced removed!");
                    this.mobileSpeechRecHandler.unsetDSI();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$tts$TTSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.tts.TTSService") : class$de$audi$atip$interapp$tts$TTSService).getName())) {
                    Object object2 = serviceReference.getProperty("TTS_CLIENT_ID");
                    if (!TTSService.CLIENT_ID_SDS.equals(object2)) continue;
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] TTSService instance removed!");
                    this.speechTTSHandler.unsetTTSService();
                    this.sdsAdapter.setTTSReady(false);
                    this.sdsManager.abortSDSSession(true);
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$ADBSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.ADBSDSService") : class$de$audi$atip$interapp$ADBSDSService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] ADBSDSService instance removed!");
                    this.sdsAppFactory.getSDSHandlerADB().unsetADBService();
                    this.sdsAppFactory.getSDSHandlerNavi().unsetADBService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS") : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceSDS).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] CombiBAPServiceSDS instance removed!");
                    this.sdsHMIListener.setCombiBAPServiceSDS(null);
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$media$IMediaSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.media.IMediaSDSService") : class$de$audi$atip$interapp$media$IMediaSDSService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] MediaSDSService instance removed!");
                    this.sdsAppFactory.getSDSHandlerMedia().unsetMediaSDSService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$MapService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.MapService") : class$de$audi$atip$interapp$MapService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] MapService instance removed!");
                    this.sdsAppFactory.getSDSHandlerNavi().unsetMapService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$NaviSDSPOIOnlineService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviSDSPOIOnlineService") : class$de$audi$atip$interapp$NaviSDSPOIOnlineService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] NaviSDSPOIOnlineService instance removed!");
                    this.sdsAppFactory.getSDSHandlerNavi().unsetPOIOnlineService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$NaviService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.NaviService") : class$de$audi$atip$interapp$NaviService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] NaviService instance removed!");
                    this.sdsAppFactory.getSDSHandlerNavi().unsetNaviService();
                    this.sdsAppFactory.getSDSHandlerADB().unsetNaviService();
                    this.sdsHMIListener.unsetNaviService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$phone$ITelServiceSDS == null ? SDSManagerBaseActivator.class$("de.audi.atip.phone.ITelServiceSDS") : class$de$audi$atip$phone$ITelServiceSDS).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] PhoneService instance removed!");
                    this.sdsAppFactory.getSDSHandlerPhone().unsetPhoneService();
                    this.sdsAppFactory.getSDSHandlerMessageDictation().unsetPhoneService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$TunerService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.TunerService") : class$de$audi$atip$interapp$TunerService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] TunerService instance removed!");
                    this.sdsAppFactory.getSDSHandlerTuner().unsetTunerService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$OnlineService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.OnlineService") : class$de$audi$atip$interapp$OnlineService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] OnlineService instance removed!");
                    this.sdsAppFactory.getSDSHandlerRemoteHMI().unsetOnlineService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$IMessagingDictationService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingDictationService") : class$de$audi$atip$interapp$IMessagingDictationService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] IMessagingDictationService instance removed!");
                    this.sdsAppFactory.getSDSHandlerMessageDictation().unsetMessagingDictationService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$IMessagingReadoutService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.IMessagingReadoutService") : class$de$audi$atip$interapp$IMessagingReadoutService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] IMessagingReadoutService instance removed!");
                    this.sdsAppFactory.getSDSHandlerMessaging().unsetMessagingReadoutService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.messaging.IMultipleMessageReadoutService") : class$de$audi$atip$interapp$messaging$IMultipleMessageReadoutService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] IMultipleMessageReadoutService instance removed!");
                    this.sdsAppFactory.getSDSHandlerMessaging().unsetMultipleMessageReadoutService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineSDSMyAudiService") : class$de$audi$atip$interapp$online$IOnlineSDSMyAudiService).getName())) {
                    this.lc.log(10000000, "SDSManagerBaseActivator#removedService: IOnlineSDSMyAudiService instance removed!");
                    this.sdsAppFactory.getSDSHandlerNavi().unsetMyAudiService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$ISdsConnectivityService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.ISdsConnectivityService") : class$de$audi$atip$interapp$ISdsConnectivityService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] ISdsConnectivityService instance removed!");
                    this.sdsAppFactory.getSDSHandlerSystem().unsetConnectivityService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$online$IOnlineDestinationService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOnlineDestinationService") : class$de$audi$atip$interapp$online$IOnlineDestinationService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] IOnlineDestinationService instance removed!");
                    this.sdsAppFactory.getSDSHandlerNavi().unsetOnlineDestinationService();
                    continue;
                }
                if (string.equals((class$de$audi$atip$interapp$online$IOperatorCallSDSService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.online.IOperatorCallSDSService") : class$de$audi$atip$interapp$online$IOperatorCallSDSService).getName())) {
                    this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] IOperatorCallSDSService instance removed!");
                    this.sdsAppFactory.getSDSHandlerNavi().unsetOperatorCallService();
                    continue;
                }
                if (!string.equals((class$de$audi$atip$interapp$AppInfoKrService == null ? SDSManagerBaseActivator.class$("de.audi.atip.interapp.AppInfoKrService") : class$de$audi$atip$interapp$AppInfoKrService).getName())) continue;
                this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] AppInfoKrService instance removed!");
                this.sdsAppFactory.getSDSHandlerNavi().unsetAppInfoKrService();
            }
        }
        this.bundleContext.ungetService(serviceReference);
        this.lc.log(10000000, "[SDSManagerBaseActivator#removedService] Done.");
    }

    private void initCommandListManagers() {
        this.lc.log(10000000, "SDSManagerBaseActivator#initCommandListManagers: called");
        if (dsiCallCmdListManager != null) {
            dsiCallCmdListManager.abortExecution("SDS_DSI_CALLS_RECOVERY", null, false);
            dsiCallCmdListManager.destroy();
        }
        dsiCallCmdListManager = new CommandListManager("SDS_DSI_CALLS_CMD_LIST_MANAGER", this.framework, Logger.getCommandLog(), null, null);
        dsiCallCmdListManager.getQueue().addFilter(new SDSCommandListFilter(dsiCallCmdListManager.getQueue().getCommandLists()));
        if (sysCallCmdListManager != null) {
            sysCallCmdListManager.abortExecution("SDS_SYSCALLS_RECOVERY", null, false);
            sysCallCmdListManager.destroy();
        }
        SDSManagerBaseActivator.setSysCallCmdListManager(new CommandListManager("SDS_SYSCALLS_CMD_LIST_MANAGER", this.framework, Logger.getCommandLog(), new SDSCommandListSupplier(this.popupHelper, this.sdsAdapter), null));
    }

    private void startCommandListManagers() {
        this.lc.log(10000000, "SDSManagerBaseActivator#startCommandListManagers: called");
        dsiCallCmdListManager.start();
        SDSManagerBaseActivator.getSysCallCmdListManager().start();
    }

    private void setCommandListReferences() {
        this.lc.log(10000000, "SDSManagerBaseActivator#setCommandListReferences: called");
        this.sdsHMIListener.setCommandListManager(dsiCallCmdListManager);
        this.sdsAppFactory.setCommandListManager(dsiCallCmdListManager);
        this.speechRecListener.setCommandListManager(dsiCallCmdListManager);
        this.ttsASR.setCommandListManager(dsiCallCmdListManager);
    }

    private void initCommandList() {
        this.lc.log(10000000, "SDSManagerBaseActivator#initCommandList: called");
        CommandList commandList = new CommandList(dsiCallCmdListManager);
        commandList.add(new CommandSpeechDSIInit(Logger.getCommandLog(), this.speechRecHandler, this.framework, this.sdsAdapter, this.sdsAppFactory.getSDSHandlerNavi(), this.timeout));
        commandList.execute("INIT_SPEECH_DSI");
    }

    private void reinitCommandList() {
        Object object;
        this.lc.log(10000000, "[SDSManagerBaseActivator#reinitCommandList] called");
        if (this.lc.isDebug()) {
            object = this.framework.getLanguageMgr();
            Language language = object == null ? null : object.getCurrentLanguage("LANG_COMPONENT_SDS");
            String string = language != null ? language.getHmiCode() : "de_DE";
            this.lc.log(10000000, "[SDSManagerBaseActivator#reinitCommandList] sdsLanguageStr=%1", (Object)string);
        }
        if (dsiCallCmdListManager == null) {
            this.lc.log(10000, "[SDSManagerBaseActivator#reinitCommandList] No dsiCallCmdListManager available!");
            return;
        }
        object = new CommandList(dsiCallCmdListManager);
        ((CommandList)object).add(new CommandSpeechDSIReinit(Logger.getCommandLog(), this.speechRecHandler, this.framework, this.sdsAdapter, this.sdsAppFactory.getSDSHandlerNavi(), this.timeout, this.dynamicHMILists, this.grammarState));
        ((CommandList)object).execute("REINIT_SPEECH_DSI");
    }

    public ServiceReference getSpeechRecServiceReference() {
        return this.speechRecServiceReference;
    }

    public static ISDSMapping getMapping() {
        return mapping;
    }

    public static void setMapping(ISDSMapping iSDSMapping) {
        mapping = iSDSMapping;
    }

    public static CommandListManager getDSICallCmdListManager() {
        return dsiCallCmdListManager;
    }

    static void setDSICallCmdListManager(CommandListManager commandListManager) {
        dsiCallCmdListManager = commandListManager;
    }

    public static CommandListManager getSysCallCmdListManager() {
        return sysCallCmdListManager;
    }

    static void setSysCallCmdListManager(CommandListManager commandListManager) {
        sysCallCmdListManager = commandListManager;
    }

    public static ISystemCallNames getSystemCallNames() {
        return systemCallNames;
    }

    static void setSystemCallNames(ISystemCallNames iSystemCallNames) {
        systemCallNames = iSystemCallNames;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        systemCallNames = new SystemCallNames();
    }
}

