/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.app.navi.evo.AsiaDBPartialMapUpdateModelAccessEvo;
import de.audi.app.navi.evo.DBIncompleteModelAccess;
import de.audi.app.navi.evo.NaviPartialPopupListener;
import de.audi.app.navi.evo.NaviPresetHandlerEvo;
import de.audi.app.navi.evo.NavigationContextHmiListener;
import de.audi.app.navi.evo.actionproxy.NaviActionProxyImplEvo;
import de.audi.app.navi.evo.adb.NaviAdbAddToContactEvoHmiListener;
import de.audi.app.navi.evo.addressinput.poi.PoiServiceEvo;
import de.audi.app.navi.evo.addressinput.poi.models.GuiModelAccessDetailsLocationPoi;
import de.audi.app.navi.evo.addressinput.poi.rrd.RRDListener;
import de.audi.app.navi.evo.asia.AsiaDbPartialMapUpdateHMIListener;
import de.audi.app.navi.evo.asia.AsiaHMIListener;
import de.audi.app.navi.evo.countryinfo.EvoCountryInfoHandler;
import de.audi.app.navi.evo.details.DetailsHMIListener;
import de.audi.app.navi.evo.details.DetailsHMIListenerAsia;
import de.audi.app.navi.evo.di.AddressInputService;
import de.audi.app.navi.evo.di.LocationDisambiguatorPopupHandler;
import de.audi.app.navi.evo.geocoordinput.GeoCoordInputHmiListenerEvo;
import de.audi.app.navi.evo.guidance.EvoVehicleHmiListener;
import de.audi.app.navi.evo.guidance.EvoVehicleHmiListenerAsia;
import de.audi.app.navi.evo.guidance.EvoVehicleModelAccess;
import de.audi.app.navi.evo.guidance.SimpleDetourHMIListener;
import de.audi.app.navi.evo.guidance.SimpleDetourModelAccess;
import de.audi.app.navi.evo.map.MapFactoryEvo;
import de.audi.app.navi.evo.map.MapManagerEvo;
import de.audi.app.navi.evo.map.MapPropertyProviderEvo;
import de.audi.app.navi.evo.map.gui.GUIFactoryEvo;
import de.audi.app.navi.evo.map.listeners.ParkingAlongRouteMapListener;
import de.audi.app.navi.evo.map.listeners.ParkingAtCrosshairMapListener;
import de.audi.app.navi.evo.map.listeners.ParkingAtLocationMapListener;
import de.audi.app.navi.evo.map.listeners.ParkingInVincinityMapListener;
import de.audi.app.navi.evo.map.listeners.PoiAlongTheRouteMapListener;
import de.audi.app.navi.evo.map.listeners.PoiAtCrosshairMapListener;
import de.audi.app.navi.evo.map.listeners.PoiAtLocationMapListener;
import de.audi.app.navi.evo.map.listeners.PoiInVicinityMapListener;
import de.audi.app.navi.evo.map.minimap.EvoTrafficMiniMap;
import de.audi.app.navi.evo.mapcode.MapcodeServiceEvo;
import de.audi.app.navi.evo.navdb.OperationManagerSDCardPopupHandler;
import de.audi.app.navi.evo.online.GeoCoordinatesActiveDestinations;
import de.audi.app.navi.evo.online.GeoCoordinatesAdapter;
import de.audi.app.navi.evo.online.GeoCoordinatesParentChildAdapter;
import de.audi.app.navi.evo.online.NaviOnlineServiceImplEvo;
import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener;
import de.audi.app.navi.evo.online.RemoteHMIAppsDestinationListener;
import de.audi.app.navi.evo.online.RemoteHMIAppsMapListener;
import de.audi.app.navi.evo.online.myaudi.DestinationImportHandlerEvo;
import de.audi.app.navi.evo.phonenumber.IPhonenumberService;
import de.audi.app.navi.evo.phonenumber.PhonenumberService;
import de.audi.app.navi.evo.poi.online.OnlineSearchControllerEvo;
import de.audi.app.navi.evo.predictivenav.PredictiveNavControllerEvo;
import de.audi.app.navi.evo.presentationmode.DemoModeHmiListener;
import de.audi.app.navi.evo.presentationmode.DemoModeModelAccess;
import de.audi.app.navi.evo.rml.RMLListener;
import de.audi.app.navi.evo.rml.RMLModelAccess;
import de.audi.app.navi.evo.rml.RMLModelAccessAsia;
import de.audi.app.navi.evo.sdis.NaviSDISStartGuidanceHandlerEvo;
import de.audi.app.navi.evo.sdis.NaviTabletServiceEvo;
import de.audi.app.navi.evo.sds.GuiModelAccessDetailsSds;
import de.audi.app.navi.evo.sds.SUIListRowBuilder;
import de.audi.app.navi.evo.search.DestTransfereToNdfHandler;
import de.audi.app.navi.evo.search.IntelliDestController;
import de.audi.app.navi.evo.setup.RouteCriteriaHMIListener;
import de.audi.app.navi.evo.setup.RouteCriteriaModelAccess;
import de.audi.app.navi.evo.tpegpoi.TpegPOIService;
import de.audi.app.navi.evo.util.addressformatting.NaviFormattingServiceEvo;
import de.audi.app.navi.evo.version.EvoNavVersionInfoButtonListModelAccess;
import de.audi.app.navi.evo.version.EvoNavVersionInfoButtonListener;
import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
import de.audi.app.navi.favorite.NaviFavoriteHmiListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.ADBRemoteHMIService;
import de.audi.atip.interapp.def.NullViewSizeManager;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeManager;
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
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.ManagementServices;
import de.audi.tghu.navi.app.NaviMapConnector;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.PhoneGateway;
import de.audi.tghu.navi.app.PicNavInterfaceHandler;
import de.audi.tghu.navi.app.SpeechManager;
import de.audi.tghu.navi.app.TMCGateway;
import de.audi.tghu.navi.app.TMCOnRouteService;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.country.UpdateDestinationCountryCodeCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.sds.IAddressInputSDSForm;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIService;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateManager;
import de.audi.tghu.navi.app.asia.warning.AsiaWarningsStateSetupListener;
import de.audi.tghu.navi.app.audio.AudioStateMachine;
import de.audi.tghu.navi.app.audio.LastAnnouncementHandler;
import de.audi.tghu.navi.app.audio.NaviAudioHandler;
import de.audi.tghu.navi.app.audio.NaviNullAudioHandler;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.cluster.ViewSizeManagerCluster;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.SaveLocationToPersistenceCommand;
import de.audi.tghu.navi.app.countryinfo.CountryInfoHmiListener;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;
import de.audi.tghu.navi.app.details.DetailsDestionationHandler;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguatorPopupHandler;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.gal.GALHandler;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputHmiListener;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager;
import de.audi.tghu.navi.app.geocoordinput.GuiModelAccessInputGeoCoordinateImpl;
import de.audi.tghu.navi.app.guidance.FavLocationVehicleHandler;
import de.audi.tghu.navi.app.guidance.FavLocationVehicleHandlerAsia;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.SemidynamicRouteGuidance;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaModelListener;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerObserver;
import de.audi.tghu.navi.app.interapp.NullViewSizeChangeHandler;
import de.audi.tghu.navi.app.interapp.RouteCriteriaInterAppService;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService;
import de.audi.tghu.navi.app.interapp.ViewSizeChangeHandler;
import de.audi.tghu.navi.app.li.AddressInputWizard;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.map.context.SetupHandler;
import de.audi.tghu.navi.app.map.gui.MapPartialPopupEvoHandler;
import de.audi.tghu.navi.app.map.handler.LGIInterAppServiceHandler;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.map.settings.MapOptionValidatorEvoCN;
import de.audi.tghu.navi.app.map.settings.MapOptionValidatorEvoEU;
import de.audi.tghu.navi.app.map.settings.MapOptionValidatorEvoJP;
import de.audi.tghu.navi.app.map.settings.MapOptionValidatorEvoKR;
import de.audi.tghu.navi.app.map.settings.MapOptionValidatorEvoNAR;
import de.audi.tghu.navi.app.map.settings.MapOptionValidatorEvoTW;
import de.audi.tghu.navi.app.memory.TourHandler;
import de.audi.tghu.navi.app.memory.TourHandlerHmiListener;
import de.audi.tghu.navi.app.memory.TourHandlerModelAccess;
import de.audi.tghu.navi.app.navi.evo.navlocationextractor.NaviFavoriteEvoNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiCityStateStreetHistoryListAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallListener;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;
import de.audi.tghu.navi.app.rml.RMLDSIHandler;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.routeguidance.CoreRouteGuidanceHMIListener;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.routeguidance.RouteDSIHandler;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceStateModelAccessEvo;
import de.audi.tghu.navi.app.routeguidance.RouteManagerEvo;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequenceEvo;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceModelAccess;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceDependentHMIListener;
import de.audi.tghu.navi.app.rp.Routeplan;
import de.audi.tghu.navi.app.rse.RSEManager;
import de.audi.tghu.navi.app.sds.SDSDetourHandlerImpl;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;
import de.audi.tghu.navi.app.sds.SUIHandler;
import de.audi.tghu.navi.app.sds.SUIModelAccess;
import de.audi.tghu.navi.app.search.TryMatchLocationDataHmiWrapper;
import de.audi.tghu.navi.app.setup.RouteCriteriaEvoConfiguration;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import de.audi.tghu.navi.app.setup.RouteCriteriaSequence;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.version.NavVersionInfoHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.osgi.framework.BundleContext;

public class NavigationEvo
extends Navigation {
    private RemoteHMIAppsDestinationListener remoteHMIAppsDestinationListener;
    private RemoteHMIAppsMapListener remoteHMIAppsMapListener;
    private RouteCriteriaHMIListener routeCriteriaHMIListener;
    private RMLListener rmlListener;
    private DetailsHMIListener detailsHMIListener;
    private StartRouteGuidanceDependentHMIListener startRouteGuidanceDependentHMIListener;
    private GeoCoordInputHmiListener geoCoordInputHmiListener;
    private NavigationContextHmiListener contextHmiListener;
    private IViewSizeChangeHandler viewSizeChangeHandler;
    private SDSHandlerImpl sdsHandler;
    private NaviFavoriteHmiListener naviFavoriteHmiListener;
    private IAddressInputSDSForm addressInputSDSForm;
    private IPhonenumberService phonenumberService = null;
    private ITpegPOIService tpegPOIService = null;
    private NaviPartialPopupListener naviPartialPopupListener = null;
    private DestTransfereToNdfHandler destTransfereToNdfHandler;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController;

    private NavigationEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
        this.dbIncompleteController = new DBIncompleteController(new DBIncompleteModelAccess(navigationEnv), navigationEnv.getLogChannel(), navigationEnv);
    }

    public void init(AbstractNavigationActivator abstractNavigationActivator, NavigationEnv navigationEnv) {
        IViewSizeManager iViewSizeManager;
        super.init(abstractNavigationActivator, navigationEnv);
        MapOptionValidator mapOptionValidator = this.initMapOptionHandler();
        this.speechManager = new SpeechManager(navigationEnv, this.functionCounter, this.getCommandListFactory());
        this.naviInterface = new NaviInterface(navigationEnv, navigationEnv.getLogChannel(), this, this.sdsController, this.commandListFactory);
        this.viewSizeChangeHandler = Util.isClusterMMI(navigationEnv.getFramework()) || Util.isClusterMapFPK(navigationEnv.getFramework()) ? new ViewSizeChangeHandler(navigationEnv) : new NullViewSizeChangeHandler();
        this.mapManager = new MapManagerEvo(navigationEnv, this.iconHandler, this.naviInterface, this.functionCounter, this.sdsController, new MapPropertyProviderEvo(), new MapFactoryEvo(), new GUIFactoryEvo(), this.locationSerializer, this.commandListFactory, new SetupHandler(navigationEnv, mapOptionValidator), mapOptionValidator, this.getMapSelectionHandlerFactory());
        EvoVehicleModelAccess evoVehicleModelAccess = new EvoVehicleModelAccess(navigationEnv);
        this.vehicle.setModelAccess(evoVehicleModelAccess);
        if (Util.isPoiWarningPresent()) {
            this.naviAudioHandler = new NaviAudioHandler(navigationEnv);
            this.audioStateMachine = new AudioStateMachine(navigationEnv, this.dsiNavigationManager, this.naviAudioHandler, this.speechManager);
            ((NaviAudioHandler)this.naviAudioHandler).setAudioStateMachine(this.audioStateMachine);
        } else {
            this.naviAudioHandler = new NaviNullAudioHandler(navigationEnv);
            this.audioStateMachine = new AudioStateMachine(navigationEnv, this.dsiNavigationManager, this.naviAudioHandler, this.speechManager);
        }
        LogChannel logChannel = navigationEnv.getClusterLogChannel();
        if (Util.isClusterMapFPK(navigationEnv.getFramework())) {
            iViewSizeManager = new ViewSizeManagerCluster(navigationEnv, logChannel);
            this.setViewSizeManager(iViewSizeManager);
        } else {
            iViewSizeManager = new NullViewSizeManager(logChannel);
        }
        this.clusterService = new ClusterService(navigationEnv, this.speechManager, this.operationManager, this.audioStateMachine, this.mapManager, this.commandListFactory, iViewSizeManager, this.viewSizeChangeHandler);
        this.galHandler = new GALHandler(navigationEnv, this.clusterService);
        if (Util.isPictureNavPresent(navigationEnv.getFramework())) {
            navigationEnv.getChoiceModel(189).setValue(1);
        }
        this.initRouteCriteriaManager(navigationEnv, this.commandListFactory);
        this.initRouteAndDemoModeManager(navigationEnv, this.routeCriteriaManager, this.commandListFactory, this.alternativeRouteState, this.operationManager, this.mapManager.getMapInterface(), this.clusterService);
        this.initStartGuidanceDependentSequence(navigationEnv, this.commandListFactory, this.routeManager, this.alternativeRouteState, this.demoModeManager, this.mapManager.getMapInterface());
        this.routeplan = new Routeplan(navigationEnv, this.routeManager, this.routeManager.getMaxNumberOfDestinations());
        this.tourHandler = new TourHandler(navigationEnv, this.functionCounter, this.commandListFactory, this.getRouteCriteriaManager(), this.getMapInterface(), new TourHandlerModelAccess(navigationEnv, this.functionCounter, this.routeManager, null, this.mapManager.getMapInterface()), this.getNaviLocationAccessor(), this.routeManager);
        SimpleDetourModelAccess simpleDetourModelAccess = new SimpleDetourModelAccess(navigationEnv);
        this.simpleDetourHandler = new SimpleDetourHandler(navigationEnv.getLogChannel(), this.commandListFactory, simpleDetourModelAccess, this.operationManager, this.routeManager);
        new SimpleDetourHMIListener(navigationEnv, this.simpleDetourHandler);
        this.tmcGateway = new TMCGateway(navigationEnv);
        this.lastAnnouncementHandler = new LastAnnouncementHandler(navigationEnv, this.audioStateMachine, this.commandListFactory, this.mapManager.getMapInterface(), this.tmcGateway);
        this.navigationBrowser = new NavigationBrowser(navigationEnv);
        this.naviMapConnector = new NaviMapConnector(navigationEnv, this.navigationBrowser, this.getMapInterface());
        this.managementServices = new ManagementServices(navigationEnv, this, this.functionCounter);
        this.hkJokerHandler = new HKJokerHandler(navigationEnv, this, this.managementServices);
        this.onlineTrafficHandler = new OnlineTrafficHandler(navigationEnv, navigationEnv.getOnlineLogChannel());
        this.semidynamicRouteGuidance = new SemidynamicRouteGuidance(navigationEnv);
        this.trafficRegulationService = new TrafficRegulationService(navigationEnv, this.iconHandler);
        this.generalSetupListener = new GeneralSetupListener(navigationEnv, this.trafficRegulationService);
        this.carNavInterface = new CarNavInterfaceImpl(navigationEnv, this.vehicle);
        this.lgiInterappServiceHandler = new LGIInterAppServiceHandler(navigationEnv);
        this.phoneGateway = new PhoneGateway(navigationEnv);
        this.rseManager = RSEManager.createManager(navigationEnv);
        this.initHomeAddressHandler(navigationEnv, this.locationSerializer, this.startGuidanceDependentSequence, this.dispatcher);
        this.initVersionInfoHandler(navigationEnv);
        this.adbInterAppService = new ADBInterAppService(navigationEnv, this.dsiNavigationManager, this.commandListFactory, this.startGuidanceDependentSequence, this.locationSerializer, this.commandListCallManager, this.getMapInterface());
        this.naviFavoriteHandler = new NaviFavoriteHandlerEvo(navigationEnv, this.getLocationSerializer(), this.commandListFactory, this.getMapInterface().getPreviewMap(), this.homeAddressHandler, this.adbInterAppService, abstractNavigationActivator.getBundleContext(), this.naviServiceListenerController.getNaviServiceListener(), this.dispatcher, (CombiBAPListener)this.clusterService.getCombiBAPListener());
        this.naviInterface.setFavoriteHandler(this.naviFavoriteHandler);
        this.adbInterAppService.setFavoriteHandler(this.naviFavoriteHandler);
        new TourHandlerHmiListener(navigationEnv, this.functionCounter, this.commandListFactory, this.tourHandler, this.routeManager, this.getStartGuidanceDependantSequence(), this.naviFavoriteHandler);
        this.naviADBHandler = new NaviADBHandler(navigationEnv, this.iconHandler, this.sdsController, this.naviServiceListenerController.getNaviServiceListener(), this.adbInterAppService, this.locationSerializer, this.vehicle, this.commandListFactory);
        this.naviADBHandler.init();
        this.naviFavoriteHmiListener = new NaviFavoriteHmiListener(navigationEnv, (NaviFavoriteHandlerEvo)this.naviFavoriteHandler, this.getMapInterface(), this.homeAddressHandler, this.naviADBHandler, this.commandListFactory, this.telServiceController.getTelService());
        if (Util.isHURegionAsia()) {
            this.locationDisambiguatorSequence = new LocationDisambiguatorSequence(navigationEnv, this.startGuidanceDependentSequence, this.naviFavoriteHandler, this.naviADBHandler, this.homeAddressHandler, this.commandListFactory);
            this.locationDisambiguatonPopupHandler = new LocationDisambiguatorPopupHandler(navigationEnv, this.locationDisambiguatorSequence);
            this.detailsHMIListener = new DetailsHMIListenerAsia(navigationEnv, this.naviInterface, this.getMapInterface(), this.navigationBrowser, this.startGuidanceDependentSequence, this.iconHandler, this.telServiceController.getTelService(), this.locationDisambiguatorSequence, this.commandListFactory, this.locationDisambiguatonPopupHandler);
            FavLocationVehicleHandlerAsia favLocationVehicleHandlerAsia = new FavLocationVehicleHandlerAsia(navigationEnv, this.naviFavoriteHandler, this.vehicle, this.naviADBHandler, this.locationDisambiguatorSequence, this.locationDisambiguatonPopupHandler);
            new EvoVehicleHmiListenerAsia(navigationEnv, favLocationVehicleHandlerAsia);
        } else {
            this.detailsHMIListener = new DetailsHMIListener(navigationEnv, this.naviInterface, this.getMapInterface(), this.navigationBrowser, this.startGuidanceDependentSequence, this.iconHandler, this.telServiceController.getTelService(), this.commandListFactory);
            FavLocationVehicleHandler favLocationVehicleHandler = new FavLocationVehicleHandler(navigationEnv, this.naviFavoriteHandler, this.vehicle, this.naviADBHandler);
            new EvoVehicleHmiListener(navigationEnv, favLocationVehicleHandler);
        }
        this.detailsHMIListener.setDemoModeManager(this.demoModeManager);
        this.naviInterface.setDetailsScreen(this.detailsHMIListener);
        this.initAddressInput(navigationEnv, this.commandListFactory, this.vehicle, this.startGuidanceDependentSequence, this.homeAddressHandler, this.getMapInterface().getPreviewMap(), this.adbInterAppService, this.cityHistory, this.routeManager, this.locationSerializer, this.naviFavoriteHandler, this.naviADBHandler, SpellerStack.getInstance(), this.locationDisambiguatonPopupHandler);
        this.adbInterAppService.setAddressInputForm(this.addressInputService);
        this.semidynamicRouteGuidance.setHURegion(navigationEnv.getFramework().getSysConst(442));
        new NaviAdbAddToContactEvoHmiListener(navigationEnv, navigationEnv.getLogChannel(), this.naviADBHandler);
        new AddressInputWizard(navigationEnv, this.vehicle, this.commandListFactory, this.homeAddressHandler);
        NaviServiceListenerObserver naviServiceListenerObserver = new NaviServiceListenerObserver(navigationEnv.getLogChannel(), this.operationManager, this.addressInputService, this.naviFavoriteHandler, this.naviServiceListenerController);
        this.naviServiceListenerController.setTrackerUpdatesObserver(naviServiceListenerObserver);
        this.operationManager.setNaviServiceListenerObserver(naviServiceListenerObserver);
        this.setNavigationMode(navigationEnv.getFramework().isFrontMU() ? 0 : 1);
        NaviSDISStartGuidanceHandlerEvo naviSDISStartGuidanceHandlerEvo = new NaviSDISStartGuidanceHandlerEvo(navigationEnv.getSdisLogChannel(), navigationEnv, this.startGuidanceDependentSequence, this.routeCriteriaManager, this.routeManager, this.commandListFactory);
        this.naviTabletService = new NaviTabletServiceEvo(navigationEnv.getSdisLogChannel(), this.routeManager, this.commandListFactory, navigationEnv, naviSDISStartGuidanceHandlerEvo);
        this.initBrowserOnlineServices();
        this.tmcOnRouteService = new TMCOnRouteService(navigationEnv, this.getMapInterface(), this.clusterService, this.naviServiceListenerController);
        this.picNavInterfaceHandler = new PicNavInterfaceHandler(navigationEnv, this.startGuidanceDependentSequence, this.commandListFactory, this.routeplan, this.getMapInterface(), this.vehicle, this.naviMapConnector, this.routeManager, this.naviADBHandler, this.naviFavoriteHandler);
        EvoCountryInfoHandler evoCountryInfoHandler = new EvoCountryInfoHandler(navigationEnv, SpellerStack.getInstance(), this.getCommandListFactory(), this.iconHandler, this.vehicle, this.getMapInterface().getPreviewMap(), this.addressInputService.getModelAccessHelper());
        new CountryInfoHmiListener(navigationEnv, evoCountryInfoHandler, null);
        this.commandListCallManager.start();
        Util.logStartupEvent(navigationEnv.getFramework(), "NavigationEvo#initialize() - initialization finished");
        this.initRealRoadDistance(navigationEnv, this.commandListFactory, this.vehicle, this);
        this.poiService = new PoiServiceEvo(navigationEnv, this.naviInterface, this.commandListFactory, this.vehicle, this.iconHandler, this.sdsController, this.startGuidanceDependentSequence, this.popupsHandler, this.getMapInterface().getPreviewMap(), this.detailsHMIListener.getDestinationHandler(), this.cityHistory, this.routeManager, this.carKombiService, this.poiDSIHandler, this.operationManager, this.addressInputService, this.naviAudioHandler, this.naviFavoriteHandler, this.telServiceController.getTelService(), this.getMapInterface(), this.getAdbInterAppService(), this.naviADBHandler, this.homeAddressHandler, SpellerStack.getInstance(), this.rrdListener, this.detailsHMIListener);
        this.adbInterAppService.setPoiService(this.poiService);
        this.addressInputService.setPoiService(this.poiService);
        this.startRouteGuidanceDependentHMIListener.setPoiService(this.poiService);
        ((NaviFavoriteHandlerEvo)this.naviFavoriteHandler).setPoiService(this.poiService);
        if (this.locationDisambiguatorSequence != null) {
            this.locationDisambiguatorSequence.setPoiService(this.poiService);
        }
        this.destTransfereToNdfHandler = new DestTransfereToNdfHandler(this.startRouteGuidanceDependentHMIListener.getDestinationHandler(), this.addressInputService, navigationEnv.getLogChannel());
        this.initRightDrawerMapListeners();
        this.initOnlineSearch(navigationEnv, this.startGuidanceDependentSequence, this.navigationBrowser, this.naviADBHandler, this.addressInputService, this.homeAddressHandler);
        this.initRML(navigationEnv, this.iconHandler, this.commandListFactory, this.routeManager, evoCountryInfoHandler, this.detailsHMIListener.getDestinationHandler(), this.getMapInterface().getPreviewMap(), this.vehicle);
        try {
            this.initRemoteHMIAppsListener(navigationEnv, this.commandListFactory);
        }
        catch (Exception exception) {
            navigationEnv.getLogChannel().log(10000, "NavigationEvo#init() - initRemoteHMIAppsListener: ERROR=%1", (Throwable)exception);
        }
        SUIListRowBuilder sUIListRowBuilder = SUIListRowBuilder.createSUIListRowBuilderDistanceFromCCP(navigationEnv.getSDSLogChannel(), this.iconHandler, this.routeManager, navigationEnv, this.vehicle);
        SUIModelAccess sUIModelAccess = new SUIModelAccess(navigationEnv, sUIListRowBuilder);
        SUIHandler sUIHandler = new SUIHandler(sUIModelAccess, navigationEnv.getLogChannel());
        RouteGuidanceInterAppService routeGuidanceInterAppService = new RouteGuidanceInterAppService(navigationEnv, navigationEnv.getLogChannel(), this.startGuidanceDependentSequence, new DetailsDestionationHandler(), this.routeManager, this.commandListFactory, this.startRouteGuidanceDependentHMIListener, this.naviServiceListenerController.getNaviServiceListener(), this.mapManager);
        RouteCriteriaModelAccess routeCriteriaModelAccess = new RouteCriteriaModelAccess(navigationEnv);
        RouteCriteriaInterAppService routeCriteriaInterAppService = new RouteCriteriaInterAppService(this.routeCriteriaManager, navigationEnv.getLogChannel(), routeCriteriaModelAccess, this.routeCriteriaSequence, navigationEnv);
        SDSDetourHandlerImpl sDSDetourHandlerImpl = new SDSDetourHandlerImpl(this.vehicle, this.routeManager, this.simpleDetourHandler, navigationEnv.getSDSLogChannel(), this.commandListFactory);
        GuiModelAccessInputGeoCoordinateImpl guiModelAccessInputGeoCoordinateImpl = new GuiModelAccessInputGeoCoordinateImpl(navigationEnv);
        GeoCoordInputManager geoCoordInputManager = new GeoCoordInputManager(navigationEnv, this.commandListFactory, this.vehicle, guiModelAccessInputGeoCoordinateImpl, this.getMapInterface().getPreviewMap(), this.startGuidanceDependentSequence, this.adbInterAppService, this.getMapInterface(), this.getHomeAddressHandler());
        this.geoCoordInputHmiListener = new GeoCoordInputHmiListenerEvo(navigationEnv, geoCoordInputManager, this.naviFavoriteHandler, this.naviADBHandler, this.poiService);
        if (Util.isHURegionCN() || Util.isHURegionJP()) {
            this.naviOperatorCallService = new NaviOperatorCallService(navigationEnv, this.homeAddressHandler, this.naviFavoriteHandler, this.naviADBHandler, this.detailsHMIListener, this.getCommandListFactory());
            new NaviOperatorCallListener(navigationEnv, this.naviOperatorCallService);
        }
        this.interAppService = new InterAppService(navigationEnv, this, this.getCommandListFactory(), this.sdsController, this.trafficRegulationService, sUIHandler, this.naviServiceListenerController.getNaviServiceListener(), this.poiService.getPoiSDSHandler(), this.addressInputSDSForm, routeGuidanceInterAppService, routeCriteriaInterAppService, sDSDetourHandlerImpl, this.startGuidanceDependentSequence, geoCoordInputManager, null, null, this.naviOperatorCallService);
        this.interAppService.registerNaviOnlineService(new NaviOnlineServiceImplEvo(navigationEnv, navigationEnv.getLogChannel(), this.getVehicle(), this.getMapInterface(), this.routeManager, this.operationManager, this.commandListFactory, this.addressInputService, this.rrdListener, this.startGuidanceDependentSequence, this.remoteHMIAppsDestinationListener, this.remoteHMIAppsMapListener, this.startRouteGuidanceDependentHMIListener));
        SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor = new SearchResultAsyncNavLocationExtractor(this.commandListFactory, this.naviFavoriteHandler);
        this.initSearch(abstractNavigationActivator.getBundleContext(), navigationEnv, (OnlineSearchControllerEvo)this.onlineSearchController, this.homeAddressHandler, this.getVehicle(), this.getMapInterface().getPreviewMap(), this.naviADBHandler, this.adbInterAppService, this.routeManager, (CombiBAPListener)this.clusterService.getCombiBAPListener(), this.interAppService, this.iconHandler, this.poiService, this.addressInputService, this.dispatcher, searchResultAsyncNavLocationExtractor);
        ((RouteManagerEvo)this.routeManager).setSearchController(this.intelliDestAccess);
        this.sdsHandler = new SDSHandlerImpl(navigationEnv, this.getFunctionCounter(), this, navigationEnv.getSDSLogChannel(), this.naviServiceListenerController.getNaviServiceListener(), this.commandListFactory, this.naviFavoriteHandler, new GuiModelAccessDetailsSds(navigationEnv, this.iconHandler, this.detailsHMIListener.getDestinationHandler(), this.getMapInterface().getPreviewMap()), this.intelliDestAccess, this.detailsHMIListener.getDestinationHandler(), this.telServiceController.getTelService(), this.homeAddressHandler, this.officeAddressHandler);
        this.interAppService.registerNaviSDSHandler(this.sdsHandler);
        this.sdsHandler.setLastDestHandler(this.intelliDestAccess.getLastDestHandler());
        naviServiceListenerObserver.setLastDestHandler(this.intelliDestAccess.getLastDestHandler());
        this.operationManager.init(this.clusterService);
        new ViaModelListener(navigationEnv, this.iconHandler, this.commandListFactory, this.getMapInterface());
        this.myAudiImporter = new DestinationImportHandlerEvo(navigationEnv, this.telServiceController.getTelService(), this.commandListFactory, this.startGuidanceDependentSequence, this.getMapInterface().getPreviewMap(), this.dispatcher, this.homeAddressHandler, this.adbInterAppService);
        if (Util.isHURegionJP() || Util.isHURegionKR()) {
            this.phonenumberService = new PhonenumberService(navigationEnv, this.commandListFactory, SpellerStack.getInstance(), this.getMapInterface().getPreviewMap(), this.startGuidanceDependentSequence, this.homeAddressHandler);
            if (Util.isHURegionJP()) {
                this.mapcodeService = new MapcodeServiceEvo(navigationEnv, this.commandListFactory, SpellerStack.getInstance(), this.getMapInterface(), this.locationDisambiguatorSequence, this.locationDisambiguatonPopupHandler);
            }
            if (Util.isHURegionKR()) {
                this.tpegPOIService = new TpegPOIService(navigationEnv, this.commandListFactory, SpellerStack.getInstance(), this.getMapInterface(), this.startGuidanceDependentSequence, this.naviFavoriteHandler, this.poiService, this.detailsHMIListener, this.vehicle, this.iconHandler, this.routeManager, this.poiDSIHandler, this.naviADBHandler, this.telServiceController.getTelService(), this.homeAddressHandler);
                this.interAppService.registerNaviTpegPoiService(this.tpegPOIService);
            }
        }
        this.contextHmiListener = new NavigationContextHmiListener(navigationEnv, this.addressInputService, geoCoordInputManager, ((OnlineSearchControllerEvo)this.onlineSearchController).getOnlineSearchForm(), this.rmlListener, this.poiService, this.mapcodeService, this.phonenumberService, this.tpegPOIService, this.getOnlineDestinationService(), this.intelliDestAccess, this.myAudiImporter, this.getMapInterface());
        this.navigationActionProxy = new NaviActionProxyImplEvo(navigationEnv, this, this.poiService, this.routeCriteriaHMIListener, this.rmlListener, this.getMapInterface(), this.naviFavoriteHandler, this.intelliDestAccess, this.contextHmiListener, this.addressInputService, this.tpegPOIService, this.startRouteGuidanceDependentHMIListener.getDestinationHandler());
        this.mapManager.setPartialPopupHandler(new MapPartialPopupEvoHandler(navigationEnv));
        this.setLabelForRemoteHMI();
        if (Util.isPartialMapUpdateAvailable()) {
            new AsiaDbPartialMapUpdateHMIListener(navigationEnv, this.commandListFactory);
            this.asiaDbPartialMapUpdateController = new AsiaDBPartialMapUpdateController(new AsiaDBPartialMapUpdateModelAccessEvo(navigationEnv), navigationEnv.getLogChannel());
        }
        if (Util.isHURegionAsia()) {
            new AsiaHMIListener(navigationEnv, this.commandListFactory);
        }
        this.presetHandler = new NaviPresetHandlerEvo(navigationEnv, this.startGuidanceDependentSequence, this.commandListFactory, searchResultAsyncNavLocationExtractor, this.homeAddressHandler);
        if (Util.isNavDBOnSDCard(navigationEnv.getFramework())) {
            this.operationManager.setSDCardPartialPopuphandler(new OperationManagerSDCardPopupHandler(navigationEnv));
        }
        if (Util.isPredictiveNav(navigationEnv.getFramework())) {
            this.predictiveNavController = new PredictiveNavControllerEvo(navigationEnv, this.naviInterface, this.commandListFactory, abstractNavigationActivator.getBundleContext(), this.dispatcher, this.getMapInterface().getPreviewMap(), this.mapManager.getRouteCalculationHandler());
        }
        navigationEnv.addService(class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController == null ? (class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController = NavigationEvo.class$("de.audi.tghu.navi.app.predictivenav.IPredictiveNavController")) : class$de$audi$tghu$navi$app$predictivenav$IPredictiveNavController, this.getPredictiveNavController());
        if (Util.isTrafficMiniMapAvailable(navigationEnv.getFramework())) {
            this.trafficMiniMap = new EvoTrafficMiniMap(navigationEnv.getMapMainLogChannel(), navigationEnv.getFramework(), this.getMapManager().getCruiseModeHandler(), this.naviAudioHandler);
            this.trafficMiniMap.startDSI(abstractNavigationActivator.getBundleContext());
        }
        this.naviPartialPopupListener = new NaviPartialPopupListener(navigationEnv, this.mapManager, (CombiBAPListener)this.clusterService.getCombiBAPListener(), this.poiService, this.addressInputService, this.trafficMiniMap instanceof EvoTrafficMiniMap ? ((EvoTrafficMiniMap)this.trafficMiniMap).getView() : null);
        if (Util.isHURegionAsia()) {
            this.asiaWarningsStateManager = new AsiaWarningsStateManager(navigationEnv);
            this.asiaWarningsStateSetupListener = new AsiaWarningsStateSetupListener(navigationEnv, this.asiaWarningsStateManager, this);
        }
        this.naviFormattingService = new NaviFormattingServiceEvo(navigationEnv);
    }

    private void setLabelForRemoteHMI() {
        this.env.getLogChannel().log(1000000, "NavigatioEvo#setLabelForRemoteHMI: setting labels for RemoteHMI in right drawer of Map and Dest");
        String string = this.env.getTranslatedText(402503, "");
        this.env.getLabelModel(401026).setText(string);
        this.env.getLabelModel(401041).setText(string);
    }

    private void initRightDrawerMapListeners() {
        if (Util.isHURegionAsia()) {
            new PoiAlongTheRouteMapListener(this.env, this.poiService, this.getVehicle());
            new PoiAtCrosshairMapListener(this.env, this.poiService, this.getMapInterface());
            new PoiInVicinityMapListener(this.env, this.poiService, this.getVehicle());
            new PoiAtLocationMapListener(this.env, this.poiService, this.detailsHMIListener.getDestinationHandler());
        } else {
            ParkingInVincinityMapListener parkingInVincinityMapListener = new ParkingInVincinityMapListener(this.env, this.poiService, this.vehicle);
            this.env.getButtonModel(401411).setButtonListener(parkingInVincinityMapListener);
            ParkingAtCrosshairMapListener parkingAtCrosshairMapListener = new ParkingAtCrosshairMapListener(this.env, this.poiService, this.getMapInterface());
            this.env.getButtonModel(401412).setButtonListener(parkingAtCrosshairMapListener);
            ParkingAlongRouteMapListener parkingAlongRouteMapListener = new ParkingAlongRouteMapListener(this.env, this.poiService);
            this.env.getButtonModel(401413).setButtonListener(parkingAlongRouteMapListener);
            ParkingAtLocationMapListener parkingAtLocationMapListener = new ParkingAtLocationMapListener(this.poiService, this.detailsHMIListener.getDestinationHandler(), this.env);
            this.env.getButtonModel(402094).setButtonListener(parkingAtLocationMapListener);
        }
    }

    private void initRealRoadDistance(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, Navigation navigation) {
        this.rrdListener = new RRDListener(navigationEnv, iCommandListFactory, iVehicle, navigation);
    }

    private void initBrowserOnlineServices() {
    }

    private void initRouteAndDemoModeManager(NavigationEnv navigationEnv, RouteCriteriaManager routeCriteriaManager, ICommandListFactory iCommandListFactory, IAlternativeRouteStateManager iAlternativeRouteStateManager, OperationManager operationManager, MapInterface mapInterface, ClusterService clusterService) {
        RouteGuidanceStateModelAccessEvo routeGuidanceStateModelAccessEvo = new RouteGuidanceStateModelAccessEvo(navigationEnv);
        RouteManagerEvo routeManagerEvo = new RouteManagerEvo(navigationEnv, 2, routeCriteriaManager, iCommandListFactory, iAlternativeRouteStateManager, routeGuidanceStateModelAccessEvo, operationManager, this.sdsController, mapInterface, clusterService);
        this.routeDSIHandler = new RouteDSIHandler(routeManagerEvo);
        this.routeManager = routeManagerEvo;
        new CoreRouteGuidanceHMIListener(navigationEnv, navigationEnv.getLogChannel(), routeManagerEvo);
        this.initDemoMode(navigationEnv, iCommandListFactory, this.vehicle, this.routeManager);
        routeManagerEvo.setDemoModeManager(this.demoModeManager);
    }

    private void initRML(NavigationEnv navigationEnv, IconHandler iconHandler, ICommandListFactory iCommandListFactory, IRouteManager iRouteManager, ICountryInfoHandler iCountryInfoHandler, IDestinationHandler iDestinationHandler, IPreviewMap iPreviewMap, IVehicle iVehicle) {
        this.rmlDsiHandler = new RMLDSIHandler(navigationEnv);
        RMLModelAccess rMLModelAccess = Util.isHURegionAsia() ? new RMLModelAccessAsia(navigationEnv, 401115, 401110, 401132, iconHandler, iPreviewMap, iRouteManager, iVehicle) : new RMLModelAccess(navigationEnv, 401115, 401110, 401132, iconHandler, iPreviewMap, iRouteManager);
        GuiModelAccessDetailsLocationPoi guiModelAccessDetailsLocationPoi = new GuiModelAccessDetailsLocationPoi(navigationEnv, iconHandler, iDestinationHandler);
        RMLSequence rMLSequence = new RMLSequence(rMLModelAccess, iCommandListFactory, iRouteManager, iCountryInfoHandler, guiModelAccessDetailsLocationPoi, navigationEnv);
        this.rmlListener = new RMLListener(navigationEnv, 401110, 401125, 401111, rMLSequence, this.rmlDsiHandler, iPreviewMap);
    }

    private void initAddressInput(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, HomeAddressHandler homeAddressHandler, IPreviewMap iPreviewMap, ADBInterAppService aDBInterAppService, CityHistory cityHistory, IRouteManager iRouteManager, LocationSerializer locationSerializer, INaviFavoriteHandler iNaviFavoriteHandler, NaviADBHandler naviADBHandler, SpellerStack spellerStack, ILocationDisambiguatorPopupHandler iLocationDisambiguatorPopupHandler) {
        LiValueListAsyncNavLocationExtractor liValueListAsyncNavLocationExtractor = new LiValueListAsyncNavLocationExtractor(iCommandListFactory);
        LiCityStateStreetHistoryListAsyncNavLocationExtractor liCityStateStreetHistoryListAsyncNavLocationExtractor = new LiCityStateStreetHistoryListAsyncNavLocationExtractor(iCommandListFactory);
        this.addressInputService = new AddressInputService(navigationEnv, iCommandListFactory, spellerStack, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, liValueListAsyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, this.getMapInterface(), liCityStateStreetHistoryListAsyncNavLocationExtractor, this.detailsHMIListener, this.iconHandler, null, this.locationDisambiguatorSequence, iLocationDisambiguatorPopupHandler);
        this.addressInputSDSForm = this.addressInputService.getSDSAddressInputForm();
        this.naviInterface.setAddressInputFormModelAccessHelper(this.addressInputService.getModelAccessHelper());
    }

    private void initRemoteHMIAppsListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        this.remoteHMIAppsDestinationListener = new RemoteHMIAppsDestinationListener(navigationEnv, iCommandListFactory, this.onlineSearchController, this);
        LiValueListNavLocationExtractor liValueListNavLocationExtractor = new LiValueListNavLocationExtractor(iCommandListFactory);
        GeoCoordinatesAdapter geoCoordinatesAdapter = new GeoCoordinatesAdapter(liValueListNavLocationExtractor, navigationEnv);
        this.remoteHMIAppsDestinationListener.setGeoCoordinateForPois(geoCoordinatesAdapter);
        GeoCoordinatesParentChildAdapter geoCoordinatesParentChildAdapter = new GeoCoordinatesParentChildAdapter(liValueListNavLocationExtractor, navigationEnv);
        this.remoteHMIAppsDestinationListener.setGeoCoordinatesForParentPois(geoCoordinatesParentChildAdapter);
        LiValueListNavLocationExtractor liValueListNavLocationExtractor2 = new LiValueListNavLocationExtractor(iCommandListFactory);
        GeoCoordinatesAdapter geoCoordinatesAdapter2 = new GeoCoordinatesAdapter(liValueListNavLocationExtractor2, navigationEnv);
        this.remoteHMIAppsDestinationListener.setGeoCoordinateForAddressInputForm(geoCoordinatesAdapter2);
        SearchResultNavLocationExtractor searchResultNavLocationExtractor = new SearchResultNavLocationExtractor(iCommandListFactory, this.naviFavoriteHandler);
        this.remoteHMIAppsDestinationListener.setGeoCoordinateForIntelliDest(new GeoCoordinatesAdapter(searchResultNavLocationExtractor, navigationEnv));
        NaviFavoriteEvoNavLocationExtractor naviFavoriteEvoNavLocationExtractor = new NaviFavoriteEvoNavLocationExtractor(iCommandListFactory);
        this.remoteHMIAppsDestinationListener.setGeoCoordinateForFavorites(new GeoCoordinatesAdapter(naviFavoriteEvoNavLocationExtractor, navigationEnv));
        this.remoteHMIAppsMapListener = new RemoteHMIAppsMapListener(navigationEnv, this.getMapInterface());
        this.getMapInterface().addOnlineConnectionStateListener(this.remoteHMIAppsMapListener);
        this.remoteHMIAppsMapListener.configureModelsMiniApps(3, 48);
    }

    public RouteCriteriaHMIListener getRouteCriteriaHMIListener() {
        return this.routeCriteriaHMIListener;
    }

    private void initRouteCriteriaManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory) {
        RouteCriteriaModelAccess routeCriteriaModelAccess = new RouteCriteriaModelAccess(navigationEnv);
        this.routeCriteriaManager = new RouteCriteriaManager(navigationEnv, iCommandListFactory, new RouteCriteriaEvoConfiguration(), routeCriteriaModelAccess);
        this.routeCriteriaSequence = new RouteCriteriaSequence(navigationEnv, iCommandListFactory, this.routeCriteriaManager, routeCriteriaModelAccess);
        this.routeCriteriaHMIListener = new RouteCriteriaHMIListener(navigationEnv, iCommandListFactory, this.routeCriteriaSequence);
        this.routeCriteriaSequence.startSequence();
        this.routeCriteriaSequence.finishSequence();
    }

    private void initStartGuidanceDependentSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IStartGuidanceManager iStartGuidanceManager, IAlternativeRouteStateManager iAlternativeRouteStateManager, DemoModeManager demoModeManager, MapInterface mapInterface) {
        StartGuidanceModelAccess startGuidanceModelAccess = new StartGuidanceModelAccess(navigationEnv);
        this.startRouteGuidanceDependentHMIListener = new StartRouteGuidanceDependentHMIListener(navigationEnv, iStartGuidanceManager, demoModeManager, mapInterface, iAlternativeRouteStateManager, (CombiBAPListener)this.clusterService.getCombiBAPListener());
        this.startGuidanceDependentSequence = new StartGuidanceDependentSequenceEvo(navigationEnv, iCommandListFactory, startGuidanceModelAccess, this.startRouteGuidanceDependentHMIListener.getDestinationHandler());
    }

    private void initSearch(BundleContext bundleContext, NavigationEnv navigationEnv, OnlineSearchControllerEvo onlineSearchControllerEvo, HomeAddressHandler homeAddressHandler, IVehicle iVehicle, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, IStartGuidanceManager iStartGuidanceManager, CombiBAPListener combiBAPListener, InterAppService interAppService, IconHandler iconHandler, IPoiService iPoiService, IAddressInputForm iAddressInputForm, DispatcherBase dispatcherBase, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor) {
        this.intelliDestAccess = new IntelliDestController(bundleContext, navigationEnv, iVehicle, onlineSearchControllerEvo, homeAddressHandler, iPreviewMap, naviADBHandler, aDBInterAppService, iStartGuidanceManager, combiBAPListener, interAppService, iconHandler, this.commandListFactory, (NaviFavoriteHandlerEvo)this.naviFavoriteHandler, iPoiService, this.naviServiceListenerController.getNaviServiceListener(), iAddressInputForm, this.getMapInterface(), dispatcherBase, this.telServiceController.getTelService(), searchResultAsyncNavLocationExtractor, this.carKombiService, this.startRouteGuidanceDependentHMIListener.getDestinationHandler());
        this.remoteHMIAppsDestinationListener.setGeoCoordinateForActiveDestinations(new GeoCoordinatesActiveDestinations(((IntelliDestController)this.intelliDestAccess).getActiveDestinationsManager()));
        TryMatchLocationDataHmiWrapper.checkIfDSIHasChanged(navigationEnv.getSearchLogChannel());
    }

    private void initOnlineSearch(NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, NavigationBrowser navigationBrowser, NaviADBHandler naviADBHandler, IAddressInputForm iAddressInputForm, HomeAddressHandler homeAddressHandler) {
        this.onlineSearchController = new OnlineSearchControllerEvo(navigationEnv, this.getIconHandler(), navigationEnv.getOnlineLogChannel(), iStartGuidanceToDestinationSequence, this.sdsController, navigationBrowser, naviADBHandler, this.commandListFactory, iAddressInputForm);
        this.onlineSearchController.init(this.getMapInterface().getPreviewMap(), this.vehicle, this.telServiceController, this.routeManager, this.rrdListener, this.naviFavoriteHandler, this.poiService, homeAddressHandler);
    }

    private void initDemoMode(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, IStartGuidanceManager iStartGuidanceManager) {
        DemoModeModelAccess demoModeModelAccess = new DemoModeModelAccess(navigationEnv, 402566);
        this.demoModeManager = new DemoModeManager(navigationEnv, iCommandListFactory, iVehicle, demoModeModelAccess, iStartGuidanceManager);
        this.demoModeHmiListener = new DemoModeHmiListener(navigationEnv, this.demoModeManager, 402566, this.getMapInterface());
    }

    private void initHomeAddressHandler(NavigationEnv navigationEnv, LocationSerializer locationSerializer, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, DispatcherBase dispatcherBase) {
        this.homeAddressHandler = new HomeAddressHandler(navigationEnv, locationSerializer, iStartGuidanceToDestinationSequence, this.commandListFactory, this.getMapInterface(), navigationEnv.getLogChannel(), dispatcherBase);
    }

    private void initVersionInfoHandler(NavigationEnv navigationEnv) {
        EvoNavVersionInfoButtonListModelAccess evoNavVersionInfoButtonListModelAccess = new EvoNavVersionInfoButtonListModelAccess(navigationEnv, navigationEnv.getLogChannel());
        this.navVersionInfoHandler = new NavVersionInfoHandler(evoNavVersionInfoButtonListModelAccess, navigationEnv.getLogChannel());
        new EvoNavVersionInfoButtonListener(navigationEnv, this.navVersionInfoHandler, this.commandListFactory, navigationEnv.getLogChannel());
    }

    private MapOptionValidator initMapOptionHandler() {
        if (Util.isHURegionNAR()) {
            return new MapOptionValidatorEvoNAR(this.env.getFramework());
        }
        if (Util.isHURegionJP()) {
            return new MapOptionValidatorEvoJP(this.env.getFramework());
        }
        if (Util.isHURegionCN()) {
            return new MapOptionValidatorEvoCN(this.env.getFramework());
        }
        if (Util.isHURegionKR()) {
            return new MapOptionValidatorEvoKR(this.env.getFramework());
        }
        if (Util.isHURegionTW()) {
            return new MapOptionValidatorEvoTW(this.env.getFramework());
        }
        return new MapOptionValidatorEvoEU(this.env.getFramework());
    }

    public static void createInstance(NavigationEnv navigationEnv) {
        if (instance == null) {
            instance = new NavigationEvo(navigationEnv);
        }
    }

    public void startDestinationDetails(NavLocation navLocation) {
        this.detailsHMIListener.enterDetailsScreen(navLocation);
    }

    public static NavigationEvo getInstanceEvo() {
        return (NavigationEvo)instance;
    }

    public void resetSettings() {
        if (!this.operationManager.isFullyOperable()) {
            this.env.getLogChannel().log(100000, "NavigationEvo#resetSettings navigation nor fully operable, ignore call");
            return;
        }
        this.env.getLogChannel().log(1000000, "NavigationEvo#resetSettings() ");
        super.resetSettings();
    }

    public void resetMemorySettings() {
        if (!this.operationManager.isFullyOperable()) {
            this.env.getLogChannel().log(100000, "NavigationEvo#resetMemorySettings navigation nor fully operable, ignore call");
            return;
        }
        this.env.getLogChannel().log(1000000, "NavigatioEvo#resetMemorySettings() ");
        super.resetMemorySettings();
    }

    public IntelliDestController getSearchController() {
        return (IntelliDestController)this.intelliDestAccess;
    }

    public void setDSIOnline(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        this.onlineSearchController.setDSIOnline(dSIPoiOnlineSearch);
    }

    public DSIPoiOnlineSearchListener getDSIOnlineSearchListener() {
        return this.onlineSearchController.getDSIOnlineSearchListener();
    }

    public RemoteHMIAppsDestinationListener getRemoteHMIAppsDestinationListener() {
        return this.remoteHMIAppsDestinationListener;
    }

    public RemoteHMIAppsMapListener getRemoteHMIAppsMapListener() {
        return this.remoteHMIAppsMapListener;
    }

    public RemoteHMIAppsBaseListener getRemoteHMIAppsBaseListener() {
        return this.remoteHMIAppsDestinationListener;
    }

    public void setOnlineServiceProvider(OnlineServiceProvider onlineServiceProvider) {
        super.setOnlineServiceProvider(onlineServiceProvider);
        this.remoteHMIAppsDestinationListener.setOnlineServiceProvider(onlineServiceProvider);
        this.remoteHMIAppsMapListener.setOnlineServiceProvider(onlineServiceProvider);
    }

    public void setOnlineDestinationService(IOnlineDestinationService iOnlineDestinationService) {
        this.onlineDestinationService = iOnlineDestinationService;
        this.contextHmiListener.setOnlineDestinationService(iOnlineDestinationService);
    }

    public void setAdbRhmiModelListener(ADBRemoteHMIService aDBRemoteHMIService, LocationSerializer locationSerializer, ADBInterAppService aDBInterAppService) {
        this.env.getLogChannel().log(10000000, "NavigationEvo#setAdbRhmiModelListener() - Called");
        if (this.remoteHMIAppsDestinationListener == null) {
            this.env.getLogChannel().log(100000, "RemoteHMIAppsDestinationListener not available");
            return;
        }
        this.remoteHMIAppsDestinationListener.setADBModelListener(aDBRemoteHMIService, locationSerializer, aDBInterAppService);
    }

    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
        if (this.viewSizeChangeHandler != null) {
            this.env.getLogChannel().log(10000000, "NavigationEvo#setViewSizeManager()");
            this.viewSizeChangeHandler.setViewSizeManager(iViewSizeManager);
        } else {
            this.env.getLogChannel().log(10000000, "NavigationEvo#setViewSizeManager() - viewSizeChangeHandler is null");
        }
    }

    public void setLanguage(Language language) {
        this.env.getLogChannel().log(10000000, "NavigationEvo#setLanguage( %1 ) ", (Object)language.getLanguageCode());
        super.setLanguage(language);
        this.setLabelForRemoteHMI();
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401537);
        choiceModelApp.setStatus(3);
        choiceModelApp.setValue(0);
    }

    public IViewSizeChangeHandler getViewSizeChangeHandler() {
        return this.viewSizeChangeHandler;
    }

    public void setADBHMIAppService(ADBHMIAppService aDBHMIAppService) {
        super.setADBHMIAppService(aDBHMIAppService);
        this.myAudiImporter.setAdbHmiAppService(aDBHMIAppService);
    }

    public synchronized void cleanup1() {
        super.cleanup1();
        this.naviInterface.cleanUp();
        this.rrdListener.cleanUp();
        this.remoteHMIAppsDestinationListener.cleanUp();
        this.interAppService.cleanUp();
        this.sdsHandler.cleanUp();
        this.hkJokerHandler.cleanUp();
        this.managementServices.cleanUp();
        this.demoModeManager.cleanUp();
        this.startRouteGuidanceDependentHMIListener.cleanUp();
        ((NaviActionProxyImplEvo)this.navigationActionProxy).cleaunUp();
        this.startRouteGuidanceDependentHMIListener = null;
        this.startGuidanceDependentSequence = null;
        this.demoModeManager = null;
        this.naviInterface = null;
        this.sdsHandler = null;
        this.interAppService = null;
        this.rrdListener = null;
        this.remoteHMIAppsDestinationListener = null;
        this.naviInterface = null;
        this.managementServices = null;
        this.navigationActionProxy = null;
        this.naviTabletService = null;
        this.managementServices = null;
        this.operationManager = null;
    }

    public GeoCoordInputHmiListener getGeoCoordInputHmiListener() {
        return this.geoCoordInputHmiListener;
    }

    public NaviFavoriteHmiListener getNaviFavoriteHmiListener() {
        return this.naviFavoriteHmiListener;
    }

    public NaviPartialPopupListener getNaviPartialPopupListener() {
        return this.naviPartialPopupListener;
    }

    public ITrafficMiniMap getTrafficMiniMap() {
        return this.trafficMiniMap;
    }

    public void refreshPositionDescription() {
        final NavLocation navLocation = this.vehicle.getVehicleCountryLocation();
        super.refreshPositionDescription();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("NavigationEvo#refreshPositionDescription --> CheckIfUpdateIsNeeded"){

            public void execute() {
                NavLocation navLocation2 = NavigationEvo.this.vehicle.getVehicleLocationDescription();
                if (navLocation == null) {
                    this.oldLocationIsNull(navLocation2);
                } else if (navLocation2 == null) {
                    this.logger.log(10000000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#execute() - newLocation is null or has the same countryname (newLocation = %1)", (Object)LocationFormatter.formatLocationShort(navLocation2));
                    this.getCommandList().commandFinished();
                } else if (Util.isEmpty(navLocation2.country)) {
                    this.logger.log(10000000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#execute() - newLocation.country is empty! (newLocation = %1)", (Object)LocationFormatter.formatLocationShort(navLocation2));
                    this.getCommandList().commandFinished();
                } else if (navLocation2.country.equalsIgnoreCase(navLocation.country)) {
                    this.logger.log(10000000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#execute() - newLocation and oldlocation have the same countryname (country = %1)", (Object)navLocation2.country);
                    this.getCommandList().commandFinished();
                } else {
                    this.createUpdateCountryCodeCommandListAndFinish(navLocation2);
                }
            }

            private void oldLocationIsNull(NavLocation navLocation2) {
                if (navLocation2 == null) {
                    this.logger.log(10000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#oldLocationIsNull() - oldLocation AND newLocation are null!");
                    this.getCommandList().commandFinished();
                } else if (Util.isEmpty(navLocation2.country)) {
                    this.logger.log(10000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#oldLocationIsNull() - newLocation has no country! (newLocation = %1)", (Object)LocationFormatter.formatLocationShort(navLocation2));
                    this.getCommandList().commandFinished();
                } else {
                    this.logger.log(10000000, "NavigationEvo.refreshPositionDescription().new NavCommand() {...}#oldLocationIsNull - newLocation looks valid -> update!");
                    this.createUpdateCountryCodeCommandListAndFinish(navLocation2);
                }
            }

            private void createUpdateCountryCodeCommandListAndFinish(NavLocation navLocation2) {
                CommandList commandList = NavigationEvo.this.commandListFactory.createCommandList();
                commandList.add(new LocationToStreamCommand(navLocation2));
                commandList.add(new SaveLocationToPersistenceCommand(989, "LOCATION_STREAM"));
                if (!this.env.getInputModeManager().isSdsActive()) {
                    commandList.add(new UpdateDestinationCountryCodeCommand(navLocation2));
                }
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        commandList.execute("NavigationEvo#refreshPositionDescription");
    }

    public DestTransfereToNdfHandler getDestTransfereToNdfHandler() {
        return this.destTransfereToNdfHandler;
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

