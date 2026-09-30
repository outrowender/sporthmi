/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.navi.MixedListNavDiag
 *  de.mib.swdiagnosis.navi.NavigationDiag
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.ADBRemoteHMIService;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.NaviMyAudiImport;
import de.audi.atip.interapp.audio.IAnnouncementStateService;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.IOperatorCallNaviService;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.interapp.picnav.IPicNavNaviService;
import de.audi.atip.job.JobLogger;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.AbstractNavigationActivator;
import de.audi.tghu.navi.app.AsiaDBPartialMapUpdateController;
import de.audi.tghu.navi.app.CarNavInterfaceImpl;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.DBIncompleteController;
import de.audi.tghu.navi.app.GeneralSetupListener;
import de.audi.tghu.navi.app.HKJokerHandler;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.INavigation;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.ManagementServices;
import de.audi.tghu.navi.app.NaviMapConnector;
import de.audi.tghu.navi.app.NaviPresetHandler;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.NavigationModeManager;
import de.audi.tghu.navi.app.NavigationStartup;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.PhoneGateway;
import de.audi.tghu.navi.app.PicNavInterfaceHandler;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.TMCGateway;
import de.audi.tghu.navi.app.TMCOnRouteService;
import de.audi.tghu.navi.app.UotaNavListenerImpl;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.PoiDSIHandler;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.appcore.NaviActionProxyImplCore;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateManager;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateSetupListener;
import de.audi.tghu.navi.app.audio.AudioStateMachine;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.audio.LastAnnouncementHandler;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.car.AEAService;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.car.NaviDSIGeneralVehicleStatesListener;
import de.audi.tghu.navi.app.car.kombi.ICarKombiEventsProvider;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.car.kombi.NaviCarKombiService;
import de.audi.tghu.navi.app.car.kombi.NaviDSICarKombiListener;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.ETCSetDemoMode;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.NavCommandListFactory;
import de.audi.tghu.navi.app.command.NavCommandListSupplier;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.ResetSMCommand;
import de.audi.tghu.navi.app.command.SetLanguageCommand;
import de.audi.tghu.navi.app.command.translate.TranslateAndPersistRoute;
import de.audi.tghu.navi.app.command.translate.TranslateVehicleCountryLocationCommand;
import de.audi.tghu.navi.app.demomode.IDemoModeHmiListener;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import de.audi.tghu.navi.app.di.mapcode.IMapcodeService;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorSequence;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.gal.GALHandler;
import de.audi.tghu.navi.app.gpximport.GpxHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.SemidynamicRouteGuidance;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NullViewSizeChangeHandler;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.map.handler.LGIInterAppServiceHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactoryImpl;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.memory.TourHandler;
import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import de.audi.tghu.navi.app.navobserver.NavObserverRegistry;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;
import de.audi.tghu.navi.app.operatorcall.INaviOperatorCallService;
import de.audi.tghu.navi.app.phone.ITelServiceController;
import de.audi.tghu.navi.app.phone.TelServiceController;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import de.audi.tghu.navi.app.popup.PopupsHandler;
import de.audi.tghu.navi.app.predictivenav.IPredictiveNavController;
import de.audi.tghu.navi.app.predictivenav.NullPredictiveNavController;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;
import de.audi.tghu.navi.app.rml.RMLDSIHandler;
import de.audi.tghu.navi.app.routeguidance.AlternativeRouteChoiceModelListener;
import de.audi.tghu.navi.app.routeguidance.AlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.AlternativeRouteStatePersitenceHelper;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.routeguidance.RouteDSIHandler;
import de.audi.tghu.navi.app.rp.Routeplan;
import de.audi.tghu.navi.app.rse.RSEManager;
import de.audi.tghu.navi.app.sdis.INaviTabletService;
import de.audi.tghu.navi.app.sdis.NaviTabletService;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.sds.SDSController;
import de.audi.tghu.navi.app.search.IntelliDestAccess;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import de.audi.tghu.navi.app.setup.RouteCriteriaSequence;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.MekkaCompassUpdater;
import de.audi.tghu.navi.app.util.NaviLocationAccessor;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.version.NavVersionInfoHandler;
import de.audi.tghu.navi.startup.StartupHMIListener;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.mib.swdiagnosis.navi.MixedListNavDiag;
import de.mib.swdiagnosis.navi.NavigationDiag;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.osgi.framework.BundleContext;

public class Navigation
implements INavigation,
PowerEventListener,
HMIApplication,
I18NTarget,
INaviComponent {
    public static final int MODULE_ID = 4;
    protected static Navigation instance = null;
    protected final NavigationEnv env;
    public NaviActionProxyImplCore navigationActionProxy;
    protected AbstractNavigationActivator activator;
    protected DispatcherBase dispatcher;
    protected InterAppService interAppService;
    protected NaviLocationAccessor naviLocationAccessor;
    protected OperationManager operationManager;
    protected NavigationStartup navigationStartup;
    protected CommandListCallManager commandListCallManager;
    protected DSINavigationManager dsiNavigationManager;
    protected IconHandler iconHandler;
    protected IRouteManager routeManager;
    protected RouteDSIHandler routeDSIHandler;
    protected IDemoModeHmiListener demoModeHmiListener;
    protected DemoModeManager demoModeManager;
    protected Routeplan routeplan;
    protected TourHandler tourHandler;
    protected SimpleDetourHandler simpleDetourHandler;
    protected POICategoryManager poiCategoryManager;
    protected AudioStateMachine audioStateMachine;
    protected LastAnnouncementHandler lastAnnouncementHandler;
    protected NavigationBrowser navigationBrowser;
    protected NaviMapConnector naviMapConnector;
    protected ManagementServices managementServices;
    protected HKJokerHandler hkJokerHandler;
    protected NavigationDiag navigationDiag;
    protected MixedListNavDiag mixedListDiag;
    protected IVehicle vehicle;
    protected CityHistory cityHistory;
    protected ClusterService clusterService;
    protected TrafficRegulationService trafficRegulationService;
    protected TMCOnRouteService tmcOnRouteService;
    protected CarNavInterfaceImpl carNavInterface;
    protected LGIInterAppServiceHandler lgiInterappServiceHandler;
    protected RSEManager rseManager;
    protected NaviADBHandler naviADBHandler;
    protected LocationSerializer locationSerializer;
    protected FunctionCounter functionCounter;
    protected PhoneGateway phoneGateway;
    protected TMCGateway tmcGateway;
    protected OnlineTrafficHandler onlineTrafficHandler;
    protected MapManager mapManager;
    protected INaviAudioHandler naviAudioHandler;
    protected IPicNavNaviService picNavNaviService;
    protected PicNavInterfaceHandler picNavInterfaceHandler;
    protected SemidynamicRouteGuidance semidynamicRouteGuidance;
    protected NaviDSICarKombiListener dsiCarKombiListener;
    protected NaviTabletService naviTabletService;
    protected NaviFavoriteHandler naviFavoriteHandler;
    protected SpeechManager speechManager;
    protected GeneralSetupListener generalSetupListener;
    protected ICommandListFactory commandListFactory;
    protected PoiDSIHandler poiDSIHandler;
    protected IPredictiveNavController predictiveNavController;
    protected static NavigationModeManager navigationModeManager;
    protected IAddressInputForm addressInputService;
    protected RouteCriteriaManager routeCriteriaManager;
    protected IStartGuidanceToDestinationSequence startGuidanceDependentSequence;
    protected ICarKombiService carKombiService;
    protected OnlineSearchController onlineSearchController;
    protected OnlineServiceProvider onlineServiceProvider;
    protected IOnlineDestinationService onlineDestinationService;
    protected HomeAddressHandler homeAddressHandler;
    protected HomeAddressHandler officeAddressHandler;
    protected NavVersionInfoHandler navVersionInfoHandler;
    protected IAlternativeRouteStateManager alternativeRouteState;
    protected AsiaWarningsStateManager asiaWarningsStateManager;
    protected AsiaWarningsStateSetupListener asiaWarningsStateSetupListener;
    protected final ISDSController sdsController;
    protected final NaviServiceListenerController naviServiceListenerController;
    protected final ITelServiceController telServiceController;
    protected IRRDListener rrdListener;
    protected IntelliDestAccess intelliDestAccess;
    protected ADBInterAppService adbInterAppService;
    protected NaviInterface naviInterface;
    protected RouteCriteriaSequence routeCriteriaSequence;
    protected UotaNavListenerImpl uotaNavListener;
    protected INavObserverRegistry navObserverRegistry;
    private ADBRemoteHMIService adbRemoteHMIService;
    protected ADBHMIAppService adbhmiAppService;
    private IViewSizeChangeHandler viewSizeChangeHandler;
    protected NaviPresetHandler presetHandler;
    private AEAService aeaService;
    private MekkaCompassUpdater mekkaCompassUpdater = null;
    protected INaviOperatorCallService naviOperatorCallService;
    protected IOperatorCallNaviService operatorCallOnlineService;
    protected GALHandler galHandler;
    protected ILocationDisambiguatorSequence locationDisambiguatorSequence = null;
    protected ILocationDisambiguatorPopupHandler locationDisambiguatonPopupHandler = null;
    protected IMapcodeService mapcodeService = null;
    protected NaviMyAudiImportImpl myAudiImporter;
    protected GpxHandler gpxHandler;
    protected MapSelectionHandlerFactory mapSelectionHandlerFactory;
    private static final int OPERATOR_CALL_NOT_AVAILABLE = 0;
    private static final int OPERATOR_CALL_AVAILABLE = 1;
    protected final PopupsHandler popupsHandler;
    protected IPoiService poiService;
    protected RMLDSIHandler rmlDsiHandler;
    protected DBIncompleteController dbIncompleteController;
    protected AsiaDBPartialMapUpdateController asiaDbPartialMapUpdateController;
    protected NavCommandListSupplier navCommandListSupplier;
    protected StartupHMIListener startupHMIListener;
    protected ITrafficMiniMap trafficMiniMap;
    protected INaviFormattingService naviFormattingService;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea;

    public ADBInterAppService getAdbInterAppService() {
        return this.adbInterAppService;
    }

    public OnlineServiceProvider getOnlineServiceProvider() {
        return this.onlineServiceProvider;
    }

    public IAlternativeRouteStateManager getAlternativeRouteState() {
        return this.alternativeRouteState;
    }

    public AsiaWarningsStateManager getAsiaWarningsState() {
        return this.asiaWarningsStateManager;
    }

    public AsiaWarningsStateSetupListener getAsiaWarningsStateSetupListener() {
        return this.asiaWarningsStateSetupListener;
    }

    public void setOnlineServiceProvider(OnlineServiceProvider onlineServiceProvider) {
        this.onlineServiceProvider = onlineServiceProvider;
    }

    public void setOperatorCallServiceProvider(IOperatorCallNaviService iOperatorCallNaviService) {
        this.operatorCallOnlineService = iOperatorCallNaviService;
        if (this.operatorCallOnlineService != null) {
            this.env.getChoiceModel(402034).setValue(1);
            if (this.naviOperatorCallService != null) {
                this.naviOperatorCallService.setOnlineOperatorCallService(this.operatorCallOnlineService);
            }
        } else {
            this.env.getChoiceModel(402034).setValue(0);
            this.env.getLogChannel().log(10000, "Navigation#setOperatorCallServiceProvider - received null!");
        }
    }

    public IPoiService getPoiService() {
        return this.poiService;
    }

    public DBIncompleteController getDbIncompleteController() {
        return this.dbIncompleteController;
    }

    public AsiaDBPartialMapUpdateController getAsiaDbPartialMapUpdateController() {
        return this.asiaDbPartialMapUpdateController;
    }

    protected Navigation(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        navigationModeManager = new NavigationModeManager();
        this.navObserverRegistry = new NavObserverRegistry();
        this.popupsHandler = new PopupsHandler(navigationEnv.getLogChannel());
        this.sdsController = new SDSController(navigationEnv.getSDSLogChannel());
        this.naviServiceListenerController = new NaviServiceListenerController(navigationEnv.getSDSLogChannel());
        this.telServiceController = new TelServiceController(navigationEnv.getLogChannel());
        this.poiDSIHandler = new PoiDSIHandler(navigationEnv);
    }

    public INavObserverRegistry getNavObserverRegistry() {
        return this.navObserverRegistry;
    }

    public NavigationEnv getEnv() {
        return this.env;
    }

    public void kombiEventsProviderAdded(ICarKombiEventsProvider iCarKombiEventsProvider) {
        this.carKombiService = new NaviCarKombiService(this.env.getLogChannel(), iCarKombiEventsProvider);
        if (this.navigationDiag != null) {
            this.navigationDiag.setCarKombiService((NaviCarKombiService)this.carKombiService);
        }
    }

    public void init(AbstractNavigationActivator abstractNavigationActivator, NavigationEnv navigationEnv) {
        navigationEnv.getLogChannel().log(10000000, "Navigation#initialize()");
        this.activator = abstractNavigationActivator;
        this.initSpellerStack(navigationEnv);
        this.initMinimal(navigationEnv);
        this.setModelDefaultValues(navigationEnv);
        this.viewSizeChangeHandler = new NullViewSizeChangeHandler();
        this.navCommandListSupplier = new NavCommandListSupplier(navigationEnv, this);
        this.commandListCallManager = new CommandListCallManager("NavCommandLists", navigationEnv.getFramework(), navigationEnv.getCommandListLogChannel(), this.navCommandListSupplier, navigationEnv.getChoiceModel(400346));
        this.commandListFactory = new NavCommandListFactory(this.commandListCallManager, navigationEnv, this);
        this.dsiNavigationManager = new DSINavigationManager(navigationEnv, this, this.commandListCallManager, this.commandListFactory, this.dispatcher);
        ((NavCommandListFactory)this.commandListFactory).setDsiNavigationManager(this.dsiNavigationManager);
        this.functionCounter = new FunctionCounter(navigationEnv);
        this.operationManager = new OperationManager(navigationEnv, this.dsiNavigationManager, this.commandListCallManager, abstractNavigationActivator, this.naviServiceListenerController.getNaviServiceListener(), this.commandListFactory, this);
        this.startupHMIListener = new StartupHMIListener(navigationEnv, this.operationManager);
        this.operationManager.setNavigationMainInitialized(false);
        this.operationManager.setNavigationRemoteInitialized(false);
        this.navigationStartup = new NavigationStartup(navigationEnv, this.commandListFactory, this.dsiNavigationManager, this.operationManager, this);
        this.cityHistory = new CityHistory(navigationEnv, this.commandListFactory);
        this.iconHandler = new IconHandler(navigationEnv);
        this.locationSerializer = new LocationSerializer(navigationEnv, this.commandListFactory);
        this.vehicle = this.createVehicleInstance(navigationEnv);
        this.poiCategoryManager = new POICategoryManager(navigationEnv, this.iconHandler, this.commandListFactory);
        this.initObservers();
        this.alternativeRouteState = this.createAlternativeRouteStateManager();
        this.uotaNavListener = new UotaNavListenerImpl(navigationEnv.getLogChannel());
        this.aeaService = new AEAService(navigationEnv);
        if (Util.isMekkaCompassAvailable(navigationEnv.getFramework())) {
            this.mekkaCompassUpdater = new MekkaCompassUpdater(navigationEnv, this.vehicle);
        }
        this.trafficMiniMap = AbstractTrafficMiniMap.NULL_TRAFFIC_MINI_MAP;
        this.predictiveNavController = new NullPredictiveNavController();
        navigationEnv.addService(class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController == null ? (class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController = Navigation.class$("de.audi.tghu.navi.app.predictivenav.IPredictiveNavController")) : class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController, this.getPredictiveNavController());
        navigationEnv.addService(class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea == null ? (class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea = Navigation.class$("de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea")) : class$de$audi$tghu$navi$app$addressinput$poi$searcharea$PoiSearchArea, new PoiSearchArea(navigationEnv.getPOILogChannel()));
        this.gpxHandler = new GpxHandler(navigationEnv, this.commandListFactory, this);
    }

    protected IVehicle createVehicleInstance(NavigationEnv navigationEnv) {
        return Vehicle.createInstance(navigationEnv, this.commandListFactory, this.navObserverRegistry);
    }

    private void setModelDefaultValues(NavigationEnv navigationEnv) {
        navigationEnv.getChoiceModel(5546).setValue(Util.isHURegionJP() ? 7 : 1);
    }

    protected IAlternativeRouteStateManager createAlternativeRouteStateManager() {
        AlternativeRouteStateManager alternativeRouteStateManager = new AlternativeRouteStateManager(this.env, 401134, new AlternativeRouteStatePersitenceHelper(this.env, 230));
        new AlternativeRouteChoiceModelListener(alternativeRouteStateManager, 401134, this.env);
        return alternativeRouteStateManager;
    }

    private void initObservers() {
        this.navObserverRegistry.addCountryUpdatedObserver(this.naviServiceListenerController);
    }

    public void initMinimal(NavigationEnv navigationEnv) {
        this.dispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher("NavigationJobs", new JobLogger(navigationEnv.getLogChannel()));
        this.dispatcher.start();
        navigationEnv.getLogChannel().log(10000000, "Navigation#initMinimal()");
        this.naviLocationAccessor = new NaviLocationAccessor(navigationEnv.getLogChannel());
    }

    public PoiDSIHandler getPoiDSIHandler() {
        return this.poiDSIHandler;
    }

    public synchronized RMLDSIHandler getRMLDSIHandler() {
        return this.rmlDsiHandler;
    }

    public GeneralSetupListener getGeneralSetupListener() {
        return this.generalSetupListener;
    }

    public static void createInstance(NavigationEnv navigationEnv) {
        if (instance == null) {
            instance = new Navigation(navigationEnv);
        }
    }

    public static Navigation getInstance() {
        return instance;
    }

    public synchronized void cleanup1() {
        if (instance != null && this.env != null) {
            this.env.getLogChannel().log(10000000, "Navigation#cleanup1()");
            this.commandListCallManager.destroy();
            if (this.getNaviADBHandler() != null) {
                this.getNaviADBHandler().destroy();
                this.naviADBHandler = null;
            }
            DispatcherBase dispatcherBase = this.getDispatcher();
            dispatcherBase.stop();
            this.env.getFramework().getDispatcherManager().destroyDispatcher(dispatcherBase.getDispatcherName());
            if (this.getTrafficRegulationService() != null) {
                this.getTrafficRegulationService().stop();
                this.trafficRegulationService = null;
            }
            if (this.demoModeHmiListener != null) {
                this.demoModeHmiListener.cleanup();
                this.demoModeHmiListener = null;
            }
            this.navCommandListSupplier.cleanUp();
            MapManager mapManager = this.mapManager;
            if (mapManager != null) {
                MapInterface mapInterface = this.getMapInterface();
                if (mapInterface != null) {
                    mapInterface.cleanup();
                }
                mapManager.cleanup();
                this.mapManager = null;
            }
            if (this.operationManager != null) {
                this.operationManager.cleanup();
                this.operationManager = null;
            }
            if (this.getPoiService() != null) {
                this.getPoiService().cleanup();
                this.poiService = null;
            }
            if (this.aeaService != null) {
                this.aeaService.cleanup();
                this.aeaService = null;
            }
            if (this.trafficMiniMap != null) {
                this.trafficMiniMap.cleanup();
                this.trafficMiniMap = null;
            }
            ((NavCommandListFactory)this.commandListFactory).cleanUp();
            if (this.clusterService != null) {
                this.clusterService.cleanup();
                this.clusterService = null;
            }
            if (this.vehicle != null) {
                this.vehicle.cleanUp();
                this.vehicle = null;
            }
            this.navigationDiag = null;
            this.mixedListDiag = null;
            this.commandListCallManager.cleanUp();
            this.commandListCallManager = null;
            this.navCommandListSupplier = null;
            this.commandListFactory = null;
            this.dsiNavigationManager.cleanUp();
            this.poiService = null;
            this.vehicle = null;
            this.mekkaCompassUpdater = null;
            mapManager = null;
            this.galHandler = null;
            this.myAudiImporter = null;
            this.addressInputService = null;
            this.predictiveNavController = null;
        }
    }

    public synchronized void cleanup2() {
        if (instance != null && this.env != null) {
            this.env.getLogChannel().log(10000000, "Navigation#cleanup2()");
            instance = null;
        }
        navigationModeManager = null;
    }

    private void initSpellerStack(NavigationEnv navigationEnv) {
        if (!SpellerStack.isInitialized()) {
            SpellerStack.init(navigationEnv);
            if (!SpellerStack.isInitialized()) {
                navigationEnv.getLogChannel().log(10000, "Navigation#initSpellerStack - SpellerStack was not created!");
                throw new IllegalStateException("Navigation#initSpellerStack - SpellerStack was not created!");
            }
        }
    }

    public void setNavigationMode(int n) {
        this.env.getLogChannel().log(10000000, "Navigation#setMode( %1 )", (long)n);
        if (n != navigationModeManager.getNavigationMode()) {
            navigationModeManager.setNavigationMode(n);
            this.dsiNavigationManager.setNavigationMode(n);
            this.getMapInterface().setEnableRouteCalcMode(this.getNavigationModeManager().getNavigationMode() == 0);
        }
    }

    public NavigationModeManager getNavigationModeManager() {
        return navigationModeManager;
    }

    public static boolean isRouteCalcMode() {
        return navigationModeManager.getNavigationMode() == 0;
    }

    public int getId() {
        return 4;
    }

    public ButtonModelApp getVirtualButton(int n) {
        this.env.getLogChannel().log(10000000, "Navigation#getVirtualButton() ");
        if (n == 12) {
            return this.env.getButtonModel(401239);
        }
        if (n == 13) {
            return this.hkJokerHandler.getJoker1Button();
        }
        return null;
    }

    public void popupVisible(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#popupVisible( %1 ) ", (long)n);
        this.popupsHandler.popupVisible(n, n2);
    }

    public void popupHidden(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#popupHidden( %1 ) ", (long)n);
        this.popupsHandler.popupHidden(n, n2);
    }

    public void popupRemoved(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#popupRemoved( %1 ) ", (long)n);
    }

    public void screenVisible(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#screenVisible( %1 ) ", (long)n);
        this.getMapInterface().screenVisible();
    }

    public void screenHidden(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#screenHidden( %1 ) ", (long)n);
        this.getMapInterface().screenHidden();
    }

    public void screenFadedOut(int n, int n2) {
        this.getMapInterface().getPreviewMap().onScreenFadedOut(n);
    }

    public void screenConnected(int n, int n2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setLanguage(Language language) {
        CommandList commandList;
        boolean bl;
        String string = language.getLanguageCode();
        this.env.getLogChannel().log(10000000, "Navigation#setLanguage( %1 ) ", (Object)string);
        try {
            TextUtil.updateTranslations(this.env);
            this.getMapInterface().setLanguage(string);
            this.onlineSearchController.setLanguage(language);
            this.refreshPositionDescription();
            bl = this.operationManager.isFullyOperable();
            commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new ResetSMCommand());
        }
        catch (Exception exception) {
            CommandList commandList2;
            boolean bl2;
            try {
                this.env.getLogChannel().log(10000000, "Navigation#setLanguage()", (Throwable)exception);
                bl2 = this.operationManager.isFullyOperable();
                commandList2 = this.commandListFactory.createCommandList(1);
                commandList2.add(new ResetSMCommand());
            }
            catch (Throwable throwable) {
                boolean bl3 = this.operationManager.isFullyOperable();
                CommandList commandList3 = this.commandListFactory.createCommandList(1);
                commandList3.add(new ResetSMCommand());
                if (bl3) {
                    commandList3.add(new LISPCancelSpellerCommand());
                    commandList3.add(new NavCommand(){

                        public void execute() {
                            this.env.getChoiceModel(170).setValue(0);
                            this.env.getChoiceModel(170).setValue(3);
                            this.getCommandList().commandFinished();
                        }
                    });
                    commandList3.add(new SetLanguageCommand(string));
                }
                commandList3.add(new NavCommand("notifyLanguageManager"){

                    public void execute() {
                        this.env.getFramework().getLanguageMgr().responseSetLanguage("LANG_COMPONENT_NAVI", true);
                        this.getCommandList().commandFinished();
                    }
                });
                if (bl3 && this.routeManager.getRoute() != null) {
                    commandList3.add(new TranslateAndPersistRoute(this.routeManager.getRoute()));
                }
                if (bl3) {
                    commandList3.add(new TranslateVehicleCountryLocationCommand());
                }
                commandList3.add(this.poiCategoryManager.languageChanged());
                commandList3.add(this.getIntelliDestAccess().getLastDestHandler().getLanguageChangedCommand());
                commandList3.execute("Navigation#setLanguage");
                throw throwable;
            }
            if (bl2) {
                commandList2.add(new LISPCancelSpellerCommand());
                commandList2.add(new /* invalid duplicate definition of identical inner class */);
                commandList2.add(new SetLanguageCommand(string));
            }
            commandList2.add(new /* invalid duplicate definition of identical inner class */);
            if (bl2 && this.routeManager.getRoute() != null) {
                commandList2.add(new TranslateAndPersistRoute(this.routeManager.getRoute()));
            }
            if (bl2) {
                commandList2.add(new TranslateVehicleCountryLocationCommand());
            }
            commandList2.add(this.poiCategoryManager.languageChanged());
            commandList2.add(this.getIntelliDestAccess().getLastDestHandler().getLanguageChangedCommand());
            commandList2.execute("Navigation#setLanguage");
        }
        if (bl) {
            commandList.add(new LISPCancelSpellerCommand());
            commandList.add(new /* invalid duplicate definition of identical inner class */);
            commandList.add(new SetLanguageCommand(string));
        }
        commandList.add(new /* invalid duplicate definition of identical inner class */);
        if (bl && this.routeManager.getRoute() != null) {
            commandList.add(new TranslateAndPersistRoute(this.routeManager.getRoute()));
        }
        if (bl) {
            commandList.add(new TranslateVehicleCountryLocationCommand());
        }
        commandList.add(this.poiCategoryManager.languageChanged());
        commandList.add(this.getIntelliDestAccess().getLastDestHandler().getLanguageChangedCommand());
        commandList.execute("Navigation#setLanguage");
    }

    public void updateNaviLanguage() {
        String string = this.env.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_NAVI").getLanguageCode();
        String string2 = this.env.getContainer().getLanguage();
        this.env.getLogChannel().log(10000000, "Navigation#updateNaviLanguage() - old language: %1, new language: %2", (Object)string2, (Object)string);
        if (!Util.isEmpty(string) && !string.equalsIgnoreCase(string2)) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPCancelSpellerCommand());
            commandList.add(new SetLanguageCommand(string));
            if (this.routeManager.getRoute() != null) {
                commandList.add(new TranslateAndPersistRoute(this.routeManager.getRoute()));
            }
            commandList.add(new TranslateVehicleCountryLocationCommand());
            commandList.add(this.poiCategoryManager.languageChanged());
            commandList.add(this.getIntelliDestAccess().getLastDestHandler().getLanguageChangedCommand());
            commandList.execute("Navigation#updateNaviLanguage");
        }
    }

    public void unitsChanged(boolean bl) {
        if (bl) {
            PosPosition posPosition;
            this.routeplan.unitsChanged();
            this.vehicle.unitsChanged();
            this.clusterService.unitsChanged(this.getRouteManager().getTripDataAuto());
            this.simpleDetourHandler.unitsChanged();
            if (this.getMapInterface() != null && (posPosition = this.env.getContainer().getSoPosPosition()) != null) {
                int n = posPosition.getHeight();
                this.getMapInterface().setHeight(n);
            }
            this.getMapInterface().unitsChanged();
        } else {
            this.routeplan.unitsChanged();
            this.clusterService.unitsChanged(this.getRouteManager().getTripDataAuto());
        }
    }

    public void resetSettings() {
        this.env.getLogChannel().log(1000000, "Navigation#resetSettings() ");
        try {
            if (this.speechManager != null) {
                this.speechManager.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.generalSetupListener != null) {
                this.generalSetupListener.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.asiaWarningsStateSetupListener != null) {
                this.asiaWarningsStateSetupListener.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.demoModeManager != null) {
                this.demoModeManager.setDemoModeState(false);
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.routeManager != null) {
                this.routeManager.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.clusterService != null && this.clusterService.getClusterInputListener() != null) {
                this.clusterService.getClusterInputListener().resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.onlineTrafficHandler != null) {
                this.onlineTrafficHandler.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.mapManager != null && this.mapManager.getMapInterface() != null) {
                this.mapManager.getMapInterface().resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.intelliDestAccess != null) {
                this.intelliDestAccess.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.onlineSearchController != null) {
                this.onlineSearchController.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.poiService != null && this.poiService.getPoiWarningManager() != null) {
                this.poiService.getPoiWarningManager().resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.poiService != null && this.poiService.getPoiFuelWarningService() != null) {
                this.poiService.getPoiFuelWarningService().resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.alternativeRouteState != null) {
                this.alternativeRouteState.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.routeCriteriaSequence != null) {
                this.routeCriteriaSequence.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.predictiveNavController != null) {
                this.predictiveNavController.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.trafficMiniMap != null) {
                this.trafficMiniMap.resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetSettings() - ERROR=%1 ", (Throwable)exception);
        }
    }

    public void resetMemorySettings() {
        this.env.getLogChannel().log(1000000, "Navigation#resetMemorySettings() ");
        try {
            if (this.poiService != null) {
                this.poiService.deletePersonalPOIDataBases();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.simpleDetourHandler != null) {
                this.simpleDetourHandler.deleteAllBlocks();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.homeAddressHandler != null) {
                this.homeAddressHandler.onDeleteHomeAddress();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.officeAddressHandler != null) {
                this.officeAddressHandler.onDeleteHomeAddress();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.naviFavoriteHandler != null) {
                this.naviFavoriteHandler.resetMemorySettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.addressInputService != null) {
                this.addressInputService.resetMemorySettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.tourHandler != null) {
                this.tourHandler.deleteAllTours();
                this.tourHandler.deleteAllPressTours();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.mapManager != null && this.mapManager.getMapInterface() != null) {
                this.mapManager.getMapInterface().resetMemory();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.mapManager != null && this.mapManager.getGoogleMapLicenseHandler() != null) {
                this.mapManager.getGoogleMapLicenseHandler().resetMemorySettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.onlineSearchController != null) {
                this.onlineSearchController.resetMemorySettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "NavigationEvo#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.intelliDestAccess != null && this.intelliDestAccess.getMainSearch() != null) {
                this.intelliDestAccess.getMainSearch().resetSettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "NavigationEvo#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.predictiveNavController != null) {
                this.predictiveNavController.resetMemorySettings();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "NavigationEvo#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
        try {
            if (this.mapManager != null) {
                this.mapManager.getSatelliteMapsMediator().deleteSatelliteCache();
            }
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "NavigationEvo#resetMemorySettings() - ERROR=%1 ", (Throwable)exception);
        }
    }

    public OperationManager getOperationManager() {
        return this.operationManager;
    }

    public DSIResponseContainer getDsiResponseContainer() {
        return this.env.getContainer();
    }

    public MapInterface getMapInterface() {
        MapManager mapManager = this.mapManager;
        if (mapManager != null) {
            return mapManager.getMapInterface();
        }
        return null;
    }

    public MapManager getMapManager() {
        return this.mapManager;
    }

    public NavigationStartup getNavigationStartup() {
        return this.navigationStartup;
    }

    public CommandListCallManager getCommandListCallManager() {
        return this.commandListCallManager;
    }

    public DSINavigationManager getDsiNavigationManager() {
        return this.dsiNavigationManager;
    }

    public InterAppService getInterAppService() {
        return this.interAppService;
    }

    public IPredictiveNavController getPredictiveNavController() {
        return this.predictiveNavController;
    }

    public DispatcherBase getDispatcher() {
        return this.dispatcher;
    }

    public IconHandler getIconHandler() {
        return this.iconHandler;
    }

    public DemoModeManager getDemoModeManager() {
        return this.demoModeManager;
    }

    public Routeplan getRouteplan() {
        return this.routeplan;
    }

    public TourHandler getTourHandler() {
        return this.tourHandler;
    }

    public SimpleDetourHandler getSimpleDetourHandler() {
        return this.simpleDetourHandler;
    }

    public POICategoryManager getPoiCategoryManager() {
        return this.poiCategoryManager;
    }

    public AudioStateMachine getAudioStateMachine() {
        return this.audioStateMachine;
    }

    public LastAnnouncementHandler getLastAnnouncementHandler() {
        return this.lastAnnouncementHandler;
    }

    public NavigationBrowser getNavigationBrowser() {
        return this.navigationBrowser;
    }

    public NaviMapConnector getNaviMapConnector() {
        return this.naviMapConnector;
    }

    public PicNavInterfaceHandler getPicNavInterfaceHandler() {
        return this.picNavInterfaceHandler;
    }

    public SemidynamicRouteGuidance getSemidynamicRouteGuidance() {
        return this.semidynamicRouteGuidance;
    }

    public OnlineTrafficHandler getOnlineTrafficHandler() {
        return this.onlineTrafficHandler;
    }

    public ManagementServices getManagementServices() {
        return this.managementServices;
    }

    public NavigationDiag getNavigationDiag() {
        if (this.navigationDiag == null) {
            this.navigationDiag = new NavigationDiag(this.env, this.functionCounter, this, this.managementServices, (NaviCarKombiService)this.carKombiService, this.commandListFactory);
        }
        return this.navigationDiag;
    }

    public MixedListNavDiag getMixedListDiag() {
        if (this.mixedListDiag == null) {
            this.mixedListDiag = new MixedListNavDiag(this);
        }
        return this.mixedListDiag;
    }

    public IVehicle getVehicle() {
        return this.vehicle;
    }

    public CityHistory getCityHistory() {
        return this.cityHistory;
    }

    public LocationSerializer getLocationSerializer() {
        return this.locationSerializer;
    }

    public FunctionCounter getFunctionCounter() {
        return this.functionCounter;
    }

    public NaviLocationAccessor getNaviLocationAccessor() {
        return this.naviLocationAccessor;
    }

    public IRouteManager getRouteManager() {
        return this.routeManager;
    }

    public RouteDSIHandler getRouteDSIHandler() {
        return this.routeDSIHandler;
    }

    public ClusterService getClusterService() {
        return this.clusterService;
    }

    public TrafficRegulationService getTrafficRegulationService() {
        return this.trafficRegulationService;
    }

    public TMCOnRouteService getTmcOnRouteService() {
        return this.tmcOnRouteService;
    }

    public CarNavInterfaceImpl getCarNavInterface() {
        return this.carNavInterface;
    }

    public LGIInterAppServiceHandler getLGIInterAppServiceHandler() {
        return this.lgiInterappServiceHandler;
    }

    public PhoneGateway getPhoneGateway() {
        return this.phoneGateway;
    }

    public TMCGateway getTmcGateway() {
        return this.tmcGateway;
    }

    public RSEManager getRSEManager() {
        return this.rseManager;
    }

    public NaviADBHandler getNaviADBHandler() {
        return this.naviADBHandler;
    }

    public NaviActionProxyImplCore getNavigationActionProxy() {
        return this.navigationActionProxy;
    }

    public INaviAudioHandler getNaviAudioHandler() {
        return this.naviAudioHandler;
    }

    public final INaviTabletService getNaviTabletService() {
        return this.naviTabletService;
    }

    public ICommandListFactory getCommandListFactory() {
        return this.commandListFactory;
    }

    public UotaNavListenerImpl getUotaNavListenerImpl() {
        return this.uotaNavListener;
    }

    public NaviFavoriteHandler getNaviFavoriteHandler() {
        return this.naviFavoriteHandler;
    }

    public IOnlineDestinationService getOnlineDestinationService() {
        return this.onlineDestinationService;
    }

    public void setOnlineDestinationService(IOnlineDestinationService iOnlineDestinationService) {
        this.onlineDestinationService = iOnlineDestinationService;
    }

    public NaviServiceListenerController getNaviServiceListenerController() {
        return this.naviServiceListenerController;
    }

    public IOperatorCallNaviService getOperatorCallNaviService() {
        return this.operatorCallOnlineService;
    }

    public INaviFormattingService getNaviFormattingService() {
        return this.naviFormattingService;
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#notifyPowerListenerOnEnterState( %1 ) ", (long)n);
        if (n == 2) {
            ((PowerEventListener)((Object)this.routeManager)).notifyPowerListenerOnEnterState(n, n2);
            this.tourHandler.notifyPowerListenerOnEnterState(n, n2);
        }
        this.clusterService.notifyPowerListenerOnEnterState(n, n2);
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
        this.env.getLogChannel().log(10000000, "Navigation#notifyPowerListenerOnExitState( %1 ) ", (long)n);
        if (n == 2) {
            this.getMapInterface().notifyPowerListenerOnExitState();
        }
        this.clusterService.notifyPowerListenerOnExitState(n, n2);
    }

    public void notifyPowerTriggerAction(int n, int n2) {
        this.clusterService.notifyPowerTriggerAction(n, n2);
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.env.getLogChannel().log(10000000, "Navigation#updateClampState() - clampS: %1, clamp15: %2, clampX: %3 ", bl, bl2, bl3);
        if (!bl2) {
            boolean bl5 = Boolean.getBoolean("demoModeIgnoreClamp");
            this.env.getLogChannel().log(10000000, "Navigation#updateClampState() - demoModeIgnoreClamp: %1 ", bl5);
            if (this.env.getContainer().isEtcDemoMode() && !bl5) {
                CommandList commandList = this.commandListFactory.createCommandList(1);
                commandList.add(new RGStopGuidanceCommand());
                commandList.add(new ETCSetDemoMode(false));
                commandList.execute("Navigation#updateClampState");
            }
        }
        this.clusterService.updateClampState(bl, bl2, bl3, bl4);
    }

    public void updateLockingState(boolean bl) {
        this.env.getLogChannel().log(10000000, "Navigation#updateLockingState( %1 )", (Object)(bl ? "LOCK" : "UNLOCK"));
        this.naviInterface.setFeatureToBeLocked(bl);
        this.mapManager.updateLockingState(bl);
        this.clusterService.getCombiBAPListener().updateLockingState(bl);
    }

    public void refreshPositionDescription() {
        this.vehicle.refreshPositionDescription();
        this.clusterService.updateCurrentStreet(this.vehicle.getStreet());
        this.carNavInterface.refreshPosPositionDescription();
    }

    public void refreshPosPosition(PosPosition posPosition) {
        PosPosition posPosition2;
        if (posPosition == null) {
            return;
        }
        this.vehicle.refreshPosPosition(posPosition);
        if (this.mekkaCompassUpdater != null) {
            this.mekkaCompassUpdater.onSoPosPositionUpdated();
        }
        if (this.getMapInterface() != null && (posPosition2 = this.env.getContainer().getSoPosPosition()) != null) {
            int n = posPosition2.getHeight();
            this.getMapInterface().setHeight(n);
        }
        this.clusterService.updateCurrentStreet(this.vehicle.getStreet());
        this.clusterService.updateAltitude(posPosition.getHeight());
        this.carNavInterface.refreshPosPosition();
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    public void updateRgActive(boolean bl) {
    }

    public SpeechManager getSpeechManager() {
        return this.speechManager;
    }

    public IAnnouncementStateService getAnnouncementStateService() {
        return this.speechManager;
    }

    public void setDSIOnline(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
    }

    public IAddressInputForm getAddressInputForm() {
        return this.addressInputService;
    }

    public DSIPoiOnlineSearchListener getDSIOnlineSearchListener() {
        return null;
    }

    public RouteCriteriaManager getRouteCriteriaManager() {
        return this.routeCriteriaManager;
    }

    public IStartGuidanceToDestinationSequence getStartGuidanceDependantSequence() {
        return this.startGuidanceDependentSequence;
    }

    public OnlineSearchController getOnlineSearchController() {
        return this.onlineSearchController;
    }

    public NaviDSICarKombiListener getDsiCarKombiListener() {
        return this.dsiCarKombiListener;
    }

    public NaviDSIGeneralVehicleStatesListener getDSIGeneralVehicleStatesListener() {
        return (NaviDSIGeneralVehicleStatesListener)this.activator.dsiGeneralVehicleStatesController.getDsiCarKombiEventsProvider();
    }

    public HomeAddressHandler getHomeAddressHandler() {
        return this.homeAddressHandler;
    }

    public HomeAddressHandler getOfficeAddressHandler() {
        return this.officeAddressHandler;
    }

    public NavVersionInfoHandler getNavVersionInfoHandler() {
        return this.navVersionInfoHandler;
    }

    protected MapSelectionHandlerFactory createMapSelectionHandlerFactory() {
        return new MapSelectionHandlerFactoryImpl(this.env);
    }

    protected MapSelectionHandlerFactory getMapSelectionHandlerFactory() {
        if (this.mapSelectionHandlerFactory == null) {
            this.mapSelectionHandlerFactory = this.createMapSelectionHandlerFactory();
        }
        return this.mapSelectionHandlerFactory;
    }

    public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider iVehicleStatesEventsProvider) {
        this.vehicle.vehicleStatesEventsProviderAdded(iVehicleStatesEventsProvider);
        this.getMapInterface().vehicleStatesEventsProviderAdded(iVehicleStatesEventsProvider);
        this.poiService.vehicleStatesEventsProviderAdded(iVehicleStatesEventsProvider);
    }

    public void start(BundleContext bundleContext) {
        try {
            this.sdsController.start(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#start sdsController: %1", (Throwable)exception);
        }
        try {
            this.naviServiceListenerController.start(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#start naviServiceListenerController: %1", (Throwable)exception);
        }
        try {
            this.telServiceController.start(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#start telServiceController: %1", (Throwable)exception);
        }
        try {
            this.routeManager.start(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#start routeManager: %1", (Throwable)exception);
        }
    }

    public void startDelayedDSIServices(BundleContext bundleContext) {
        try {
            this.predictiveNavController.start(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#startDelayedServices predictiveNavController: %1", (Throwable)exception);
        }
    }

    public void stop(BundleContext bundleContext) {
        try {
            this.sdsController.stop(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#stop sdsController: %1", (Throwable)exception);
        }
        try {
            this.naviServiceListenerController.stop(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#stop naviServiceListenerController: %1", (Throwable)exception);
        }
        try {
            this.telServiceController.stop(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#stop telServiceController: %1", (Throwable)exception);
        }
        try {
            this.routeManager.stop(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#stop routeManager: %1", (Throwable)exception);
        }
        try {
            this.naviFavoriteHandler.deinit();
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#stop naviFavoriteHandler: %1", (Throwable)exception);
        }
        try {
            this.predictiveNavController.stop(bundleContext);
        }
        catch (Exception exception) {
            this.env.getLogChannel().log(10000, "Navigation#stop predictiveNav: %1", (Throwable)exception);
        }
    }

    public IDemoModeHmiListener getDemoModeHmiListener() {
        return this.demoModeHmiListener;
    }

    public IRRDListener getRrdListener() {
        return this.rrdListener;
    }

    public ADBRemoteHMIService getAdbRemoteHMIService() {
        return this.adbRemoteHMIService;
    }

    public void setAdbRemoteHMIService(ADBRemoteHMIService aDBRemoteHMIService) {
        this.adbRemoteHMIService = aDBRemoteHMIService;
    }

    public void setAdbRhmiModelListener(ADBRemoteHMIService aDBRemoteHMIService, LocationSerializer locationSerializer, ADBInterAppService aDBInterAppService) {
    }

    public void setADBHMIAppService(ADBHMIAppService aDBHMIAppService) {
        this.adbhmiAppService = aDBHMIAppService;
    }

    public ADBHMIAppService getADBHMIAppService() {
        return this.adbhmiAppService;
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        if (this.viewSizeChangeHandler != null) {
            this.env.getLogChannel().log(10000000, "Navigation#setViewSizeManager()");
            this.viewSizeChangeHandler.setViewSizeManager(iViewSizeManager);
        } else {
            this.env.getLogChannel().log(10000000, "Navigation#setViewSizeManager() - viewSizeChangeHandler is null");
        }
    }

    public IViewSizeChangeHandler getViewSizeChangeHandler() {
        return this.viewSizeChangeHandler;
    }

    public AEAService getAeaService() {
        if (this.aeaService == null) {
            this.aeaService = new AEAService(this.env);
        }
        return this.aeaService;
    }

    public IntelliDestAccess getIntelliDestAccess() {
        return this.intelliDestAccess;
    }

    public void deleteAddress(int n) {
        if (0 == n) {
            this.homeAddressHandler.onDeleteHomeAddress();
        }
        if (1 == n) {
            this.officeAddressHandler.onDeleteHomeAddress();
        }
        if (2 == n) {
            this.homeAddressHandler.initHomeButtonState();
        }
        if (3 == n) {
            this.officeAddressHandler.initHomeButtonState();
        }
    }

    public NaviPresetHandler getPresetHandler() {
        return this.presetHandler;
    }

    public void deserializeAddresses() {
        if (this.homeAddressHandler != null) {
            this.homeAddressHandler.initHomeButtonState();
        }
        if (this.officeAddressHandler != null) {
            this.officeAddressHandler.initHomeButtonState();
        }
    }

    public GALHandler getGALHandler() {
        return this.galHandler;
    }

    public ITrafficMiniMap getTrafficMiniMap() {
        return this.trafficMiniMap;
    }

    public NaviMyAudiImport getMyAudiImporter() {
        return this.myAudiImporter;
    }

    public GpxHandler getGpxHandler() {
        return this.gpxHandler;
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

