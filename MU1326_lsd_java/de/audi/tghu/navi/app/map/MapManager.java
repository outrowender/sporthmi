/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.interapp.IConnectivityNaviStateListener;
import de.audi.atip.interapp.MapServiceListener;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navtmc.TMCService;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INaviLogChannels;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IGUIFactory;
import de.audi.tghu.navi.app.map.IGoogleMapLicenseService;
import de.audi.tghu.navi.app.map.IMapContent;
import de.audi.tghu.navi.app.map.IMapFactory;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;
import de.audi.tghu.navi.app.map.IMapPropertyProvider;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI;
import de.audi.tghu.navi.app.map.ITENMIndication;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapTester;
import de.audi.tghu.navi.app.map.SatelliteMapsMediator;
import de.audi.tghu.navi.app.map.TENMIndication;
import de.audi.tghu.navi.app.map.context.ContextFactory;
import de.audi.tghu.navi.app.map.context.IContextFactory;
import de.audi.tghu.navi.app.map.context.SetupHandler;
import de.audi.tghu.navi.app.map.context.VirtualSetupHandler;
import de.audi.tghu.navi.app.map.dsi.AbstractRequester;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestGoogleCtrl;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.event.MapEventDispatcher;
import de.audi.tghu.navi.app.map.gui.GUIEventDispatcher;
import de.audi.tghu.navi.app.map.gui.SimpleChoiceListener;
import de.audi.tghu.navi.app.map.gui.ViewFactory;
import de.audi.tghu.navi.app.map.handler.CruiseModeHandler;
import de.audi.tghu.navi.app.map.handler.DSIStateChangeListener;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicenseHandler;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;
import de.audi.tghu.navi.app.map.handler.IDrawerStateHandler;
import de.audi.tghu.navi.app.map.handler.IMobilityHorizonHandler;
import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.handler.MapFlagUtils;
import de.audi.tghu.navi.app.map.handler.MobilityHorizonHandler;
import de.audi.tghu.navi.app.map.handler.NullMobilityHorizonHandler;
import de.audi.tghu.navi.app.map.handler.RouteInfoContextHandler;
import de.audi.tghu.navi.app.map.handler.TmcMapHandler;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.MapConfigFactory;
import de.audi.tghu.navi.app.map.instances.MapKombiFPK;
import de.audi.tghu.navi.app.map.instances.MapKombiMOST;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.map.instances.MinorMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.map.utils.MapArrayUtils;
import de.audi.tghu.navi.app.map.utils.MapContentListEmpty;
import de.audi.tghu.navi.app.online.ServiceListHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class MapManager
implements MapConsts,
INaviLogChannels,
DSIStateChangeListener,
IViewSizeListener,
IGoogleMapLicenseService {
    public static final int MAP_MAIN = 0;
    public static final int MAP_MINOR = 1;
    public static final int MAP_MOST = 2;
    public static final int MAP_FPK = 3;
    public static final int MAP_MAX = 4;
    protected final NavigationEnv env;
    protected final INaviInterface naviInterface;
    protected final AbstractMap[] maps = new AbstractMap[4];
    GUIEventDispatcher guiEventDispatcher;
    protected LogChannel sLogChannel;
    private final IRouteCalculator routeCalculationHandler;
    protected IRouteInfoContextHandler routeInfoContextHandler = null;
    private MVRequestControl[] requests = new MVRequestControl[5];
    private ISetupHandler setupMain;
    public ISetupHandler setupKombi;
    private VirtualSetupHandler setupMinor;
    private NavLocation[] routeDestinations;
    private final FunctionCounter functionCounter;
    protected MapInterface mapInterface;
    private IMapPartialPopupHandler partialPopupHandler;
    protected IPreviewMap previewMapHandler;
    protected MapTester tester;
    protected ViewFactory viewFactory;
    private IConnectivityNaviStateListener connectivityNaviStateListener;
    private MapServiceListener mapServiceListener;
    protected IMapPropertyProvider mapPropertyProvider;
    protected IContextFactory mCtxFactory;
    private GoogleMapLicenseHandler googleMapLicenseHandler;
    private WeatherLicenseHandler weatherLicenseHandler;
    private ServiceListHandler serviceListHandler;
    private ISDSController sdsController;
    protected final IDrawerStateHandler drawerStateHandler;
    private MapTmcService tmcMapHandler;
    private final IMobilityHorizonHandler mobilityHorizonHandler;
    private MapEventDispatcher mapEventDispatcher;
    private final ICruiseModeHandler cruiseModelHandler;
    private final ITENMIndication tenmIndication;
    private MapOptionValidator mapOptionValidator;
    protected DispatcherBase dispatcher;
    protected IMapPartialPopupHandler mapPartialPopup;
    private ICommandListFactory commandListFactory;
    protected MapSelectionHandlerFactory mapSelectionHandlerFactory;
    private final SatelliteMapsMediator satelliteMapsMediator;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;

    public MapManager(NavigationEnv navigationEnv, IconHandler iconHandler, INaviInterface iNaviInterface, FunctionCounter functionCounter, ISDSController iSDSController, IMapPropertyProvider iMapPropertyProvider, IMapFactory iMapFactory, IGUIFactory iGUIFactory, LocationSerializer locationSerializer, ICommandListFactory iCommandListFactory, ISetupHandler iSetupHandler, MapInterface mapInterface, MapOptionValidator mapOptionValidator, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        Object object;
        this.functionCounter = functionCounter;
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.setupMain = iSetupHandler;
        this.mapInterface = mapInterface;
        this.mapOptionValidator = mapOptionValidator;
        this.mapSelectionHandlerFactory = mapSelectionHandlerFactory;
        this.sLogChannel = navigationEnv.getLogChannel("App.Map.Main");
        Buffer buffer = new Buffer("isClusterMMI=").append(Util.isClusterMMI(navigationEnv.getFramework())).append(" (ScreenRes=").append(navigationEnv.getFramework().getScreenRes()).append("), KombiMode=").append(navigationEnv.getFramework().getSysConst(541)).append("(0=RGI, 1=MOST, 2=FPK)").append(", isHURegionNAR=").append(Util.isHURegionNAR());
        this.sLogChannel.log(1000000, "MapManager#MapManager() - %1", (Object)buffer.toString());
        this.mapPropertyProvider = iMapPropertyProvider;
        this.naviInterface = iNaviInterface;
        this.sdsController = iSDSController;
        MapArrayUtils.setLogChannel(navigationEnv.getLogChannel("App.Map.MapFlag"));
        MapFlagUtils.setLogChannel(navigationEnv.getLogChannel("App.Map.MapFlag"));
        this.guiEventDispatcher = iGUIFactory.createGUIEventDispatcher(navigationEnv, this);
        this.mapPartialPopup = this.createMapPartialPopupHandler();
        this.viewFactory = this.createViewFactory(navigationEnv);
        MapMain mapMain = iMapFactory.createMapMain(navigationEnv, this, MapConfigFactory.createMapConfig(0, navigationEnv), iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.maps[0] = mapMain;
        this.getMapEventDispatcher().addListener(mapMain);
        this.guiEventDispatcher.addListener(mapMain.getGuiInterface());
        this.routeInfoContextHandler = this.createRouteInfoContextHandler(navigationEnv, mapMain);
        this.routeCalculationHandler = this.createRouteCalculationHandler(navigationEnv, mapMain.getRouteCalcEnv());
        if (Util.isClusterMapAvailable(navigationEnv.getFramework())) {
            if (Util.isClusterMapFPK(navigationEnv.getFramework())) {
                this.sLogChannel.log(1000000, "MapManager#MapManager() - init with cluster FPK");
                this.maps[3] = this.initializeCombi(iconHandler, locationSerializer);
            } else if (Util.isClusterMapMOST(navigationEnv.getFramework())) {
                this.sLogChannel.log(1000000, "MapManager#MapManager() - init with cluster MOST");
                this.maps[2] = this.initializeCombiMOST(iconHandler, locationSerializer);
            }
        } else {
            object = Util.isClusterMapMOST(navigationEnv.getFramework()) ? "MOST (KDK only)" : (Util.isClusterRGI(navigationEnv.getFramework()) ? "RGI" : "MMI");
            this.sLogChannel.log(1000000, "MapManager#MapManager() - init with cluster %1", object);
        }
        if (Util.isMapInMapAvailable(navigationEnv.getFramework())) {
            this.sLogChannel.log(1000000, "MapManager#MapManager() - init with map-in-map");
            this.maps[1] = object = new MinorMap(navigationEnv, this, MapConfigFactory.createMapConfig(1, navigationEnv), iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
            this.routeInfoContextHandler.setMinorMap((MinorMap)object);
        }
        this.satelliteMapsMediator = this.createSatelliteMapsMediator(navigationEnv, iconHandler);
        mapMain.getSatellitemapsManager().setMediator(this.satelliteMapsMediator);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSatellitemapsManager().setMediator(this.satelliteMapsMediator);
        }
        this.initDSIs();
        this.initSetupHandlers();
        object = mapMain.getNaviInterface().getViewSizeChangeHandler();
        if ((Util.isClusterMMI(navigationEnv.getFramework()) || Util.isClusterMapFPK(navigationEnv.getFramework())) && object != null) {
            object.addViewSizeChangedListener(this);
        }
        mapInterface.setMapManager(this);
        this.previewMapHandler = this.initPreviewMapHandler(mapMain);
        if (Util.isGoogleEarthPresent(navigationEnv.getFramework())) {
            this.googleMapLicenseHandler = new GoogleMapLicenseHandler(navigationEnv, this, this.sLogChannel, mapMain.getSetup());
        }
        this.weatherLicenseHandler = this.initWeatherLicenseHandler();
        this.serviceListHandler = this.createServiceListHandler(navigationEnv);
        this.serviceListHandler.init();
        this.setPartialPopupHandler(mapMain.getGuiInterface().getPartialPopupHandler());
        this.drawerStateHandler = this.initDrawerStateHandler();
        this.mobilityHorizonHandler = this.initMobilityHorizonHandler();
        if (Util.isHURegionAsia()) {
            this.cruiseModelHandler = new CruiseModeHandler(navigationEnv, this.getMapMain());
            this.getMapEventDispatcher().addListener(this.cruiseModelHandler);
        } else {
            this.cruiseModelHandler = ICruiseModeHandler.NULL_CRUISE_MODE_HANDLER;
        }
        this.tenmIndication = this.createTENMIndication();
        this.dispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher("MapJobs", new JobLogger(navigationEnv.getLogChannel()));
        this.dispatcher.start();
        this.print();
    }

    protected SatelliteMapsMediator createSatelliteMapsMediator(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new SatelliteMapsMediator(navigationEnv, this, ISatelliteMapsGUI.NULL_GUI, iconHandler);
    }

    public GuiModelAccessForPreviewMapDetailScreen getMapDetailScreenModelAccess() {
        return null;
    }

    public IDestinationHandler getMapDetailDestinationHandler() {
        return null;
    }

    protected IRouteInfoContextHandler createRouteInfoContextHandler(NavigationEnv navigationEnv, MapMain mapMain) {
        return new RouteInfoContextHandler(this, mapMain, navigationEnv);
    }

    protected ViewFactory createViewFactory(NavigationEnv navigationEnv) {
        return new ViewFactory(navigationEnv, this.mapPropertyProvider, this.mapPartialPopup);
    }

    protected ITENMIndication createTENMIndication() {
        if (Util.isHURegionAsia()) {
            return new TENMIndication(this.env, this.getMapMain());
        }
        return ITENMIndication.NULL_TENM_INDICATION;
    }

    protected WeatherLicenseHandler initWeatherLicenseHandler() {
        IMapContent iMapContent = this.getMapMain().getMapContentHandler();
        IMapContent iMapContent2 = this.getMapKombi() != null ? this.getMapKombi().getMapContentHandler() : new MapContentListEmpty(this.sLogChannel);
        return new WeatherLicenseHandler(this.env, iMapContent, iMapContent2, this.commandListFactory, this.sLogChannel);
    }

    protected ServiceListHandler createServiceListHandler(NavigationEnv navigationEnv) {
        return new ServiceListHandler(navigationEnv);
    }

    protected RouteCalcSM createRouteCalculationHandler(NavigationEnv navigationEnv, IRouteCalculator.IRouteCalcEnv iRouteCalcEnv) {
        return new RouteCalcSM(navigationEnv, iRouteCalcEnv);
    }

    protected MapKombiFPK initializeCombi(IconHandler iconHandler, LocationSerializer locationSerializer) {
        return new MapKombiFPK(this.env, this, MapConfigFactory.createMapConfig(3, this.env), iconHandler, this.mapInterface, this.naviInterface, locationSerializer, this.mapSelectionHandlerFactory);
    }

    protected MapKombiMOST initializeCombiMOST(IconHandler iconHandler, LocationSerializer locationSerializer) {
        return new MapKombiMOST(this.env, this, MapConfigFactory.createMapConfig(2, this.env), iconHandler, this.mapInterface, this.naviInterface, locationSerializer, this.mapSelectionHandlerFactory);
    }

    protected abstract IPreviewMap initPreviewMapHandler(MapMain var1);

    protected IDrawerStateHandler initDrawerStateHandler() {
        return null;
    }

    protected IMobilityHorizonHandler initMobilityHorizonHandler() {
        if (Util.isRangeMapDisplayPresent(this.env.getFramework())) {
            return new MobilityHorizonHandler(this.env, this.getMapMain(), this.getLogChannel());
        }
        return new NullMobilityHorizonHandler(this.getLogChannel());
    }

    public FunctionCounter getFunctionCounter() {
        return this.functionCounter;
    }

    public final MapMain getMapMain() {
        return (MapMain)this.maps[0];
    }

    public final MapKombiFPK getMapKombiFPK() {
        return (MapKombiFPK)this.maps[3];
    }

    public final MapKombiMOST getMapKombiMOST() {
        return (MapKombiMOST)this.maps[2];
    }

    public final AbstractMap getMapKombi() {
        if (this.maps[3] != null) {
            return this.maps[3];
        }
        return this.maps[2];
    }

    public final MinorMap getMinorMap() {
        return (MinorMap)this.maps[1];
    }

    public LogChannel getLogChannel() {
        return this.sLogChannel;
    }

    public void cleanup() {
        int n;
        this.getRouteCalculationHandler().cleanup();
        this.getRouteInfoContextHandler().cleanup();
        AbstractMap[] abstractMapArray = this.maps;
        for (n = 0; n < abstractMapArray.length; ++n) {
            AbstractMap abstractMap = abstractMapArray[n];
            if (abstractMap == null) continue;
            abstractMap.cleanup();
            abstractMapArray[n] = null;
        }
        for (n = 0; n < this.requests.length; ++n) {
            this.requests[n] = null;
        }
        IPreviewMap iPreviewMap = this.getPreviewMapHandler();
        if (iPreviewMap != null) {
            iPreviewMap.cleanUp();
        }
        this.cruiseModelHandler.cleanup();
        this.tenmIndication.cleanup();
        this.dispatcher.stop();
        this.env.getFramework().getDispatcherManager().destroyDispatcher(this.dispatcher.getDispatcherName());
        this.satelliteMapsMediator.cleanUp();
    }

    public void setTopDestinations(AdbEntry[] adbEntryArray) {
        this.getMapMain().getMapDataContainer().sTopDestinations = adbEntryArray;
        if (this.getMapKombi() != null) {
            this.getMapKombi().getMapDataContainer().sTopDestinations = adbEntryArray;
        }
    }

    public void setHomeDestination(AdbEntry adbEntry) {
        this.getMapMain().getMapDataContainer().sHomeDestination = adbEntry;
        if (this.getMapKombi() != null) {
            this.getMapKombi().getMapDataContainer().sHomeDestination = adbEntry;
        }
    }

    public void setHomeAddress(NavLocation navLocation) {
        this.getMapMain().getMapDataContainer().sHomeAddress = navLocation;
        this.getMapMain().getMapFlagHandler().refresh(true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getMapDataContainer().sHomeAddress = navLocation;
            this.getMapKombi().getMapFlagHandler().refresh(true);
        }
        this.naviInterface.getClusterService().setHomeAddress(navLocation);
    }

    public void setOfficeAddress(NavLocation navLocation) {
        this.getMapMain().getMapDataContainer().sOfficeAddress = navLocation;
        this.getMapMain().getMapFlagHandler().refresh(true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getMapDataContainer().sOfficeAddress = navLocation;
            this.getMapKombi().getMapFlagHandler().refresh(true);
        }
    }

    public IRouteInfoContextHandler getRouteInfoContextHandler() {
        return this.routeInfoContextHandler;
    }

    public IContextFactory getContextFactory() {
        if (this.mCtxFactory == null) {
            this.mCtxFactory = new ContextFactory();
        }
        return this.mCtxFactory;
    }

    private final void initDSIs() {
        this.requests[0] = this.getMapMain().getMVRequest().getMVRequestStd();
        if (this.getMinorMap() != null) {
            this.requests[2] = this.getMinorMap().getMVRequest().getMVRequestStd();
        }
        this.requests[1] = this.getMapMain().getMVRequest().getMVRequestGoogleCtrl();
        if (this.getMapKombi() != null) {
            this.requests[3] = this.getMapKombi().getMVRequest().getMVRequestStd();
            this.requests[4] = this.getMapKombi().getMVRequest().getMVRequestGoogleCtrl();
        }
        for (int i2 = 0; i2 < this.requests.length; ++i2) {
            if (this.requests[i2] == null) continue;
            this.requests[i2].addDSIStateChangeListener(this);
        }
    }

    private final void initSetupHandlers() {
        this.setupKombi = null;
        this.setupMinor = new VirtualSetupHandler(this.env, this.setupMain, this.mapOptionValidator){

            public int getMapRepresentation() {
                return 0;
            }
        };
        this.getMapMain().setSetupHandler(this.setupMain);
        this.setupMain.bind(this.getMapMain());
        if (this.getMinorMap() != null) {
            this.getMinorMap().setSetupHandler(this.setupMinor);
            this.setupMinor.bind(this.getMinorMap());
        }
        if (this.getMapKombi() != null) {
            this.setupKombi = new SetupHandler(this.env, this.mapOptionValidator);
            this.getMapKombi().setSetupHandler(this.setupKombi);
            this.setupKombi.bind(this.getMapKombi());
        }
        this.env.getChoiceModel(401042).setChoiceListener(new SimpleChoiceListener(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                boolean bl = n2 != 1;
                try {
                    MapManager.this.getLogChannel().log(1000000, "MapManager# - panorama changed to %1 (0=MMI, 1=FPK)", (long)n2);
                    MapManager.this.getSetupMain().setPanorama(bl, true);
                    ISetupHandler iSetupHandler = MapManager.this.getSetupKombi();
                    if (MapManager.this.getMapKombi() != null && iSetupHandler != null) {
                        iSetupHandler.setPanorama(!bl, true);
                    }
                    MapManager.this.env.getChoiceModel(401042).setValue(n2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        this.getViews().getMapSetupView().addChoiceListener(new int[]{1, 2, 3, 4, 5, 6}, (ChoiceListener)this.setupMain);
        if (this.getMapKombi() != null) {
            this.getViews().getMapSetupView().addChoiceListener(new int[]{1, 3}, (ChoiceListener)this.setupKombi);
        }
    }

    public void setMode(int n) {
    }

    protected MVRequestControl getRequester(int n) {
        if (0 <= n && n < 5) {
            return this.requests[n];
        }
        return null;
    }

    public void setDSIMapControl(DSIMapViewerControl dSIMapViewerControl, int n) {
        if (0 <= n && n < 5 && this.requests[n] != null) {
            if ((n == 3 || n == 4) && this.getMapKombi() == null) {
                return;
            }
            this.requests[n].bind(dSIMapViewerControl);
        }
    }

    public void setDSIMapZoomEngine(DSIMapViewerZoomEngine dSIMapViewerZoomEngine, int n) {
        if (n == 0) {
            this.getMapMain().setDSIMapZoomEngine(dSIMapViewerZoomEngine);
        } else if (n == 1 && this.getMapKombi() != null) {
            this.getMapKombi().setDSIMapZoomEngine(dSIMapViewerZoomEngine);
        }
    }

    public void clearNotificationsMapCtrl(int n) {
        DSIListener dSIListener;
        if (this.requests[n] != null && (dSIListener = this.getDSIMapControlListener(n)) != null) {
            this.requests[n].clearNotification(dSIListener);
        }
    }

    public void clearNotificationsGoogleCtrl(int n) {
        DSIListener dSIListener;
        MVRequestControl mVRequestControl = n == 0 ? this.requests[1] : (n == 1 ? this.requests[4] : null);
        if (mVRequestControl != null && (dSIListener = this.getDSIMapViewerGoogleCtrlListener(n)) != null) {
            mVRequestControl.clearNotification(dSIListener);
        }
    }

    public void clearNotificationsAll() {
        for (int i2 = 0; i2 < this.requests.length; ++i2) {
            this.clearNotificationsMapCtrl(i2);
            this.clearNotificationsGoogleCtrl(i2);
        }
    }

    public DSIListener getDSIMapControlListener(int n) {
        if (0 <= n && n < 5 && this.requests[n] != null) {
            this.getLogChannel().log(10000000, "MapManager#getDSIMapControlListener( %1 )", (long)n);
            return this.requests[n].getMVResponseControl();
        }
        this.getLogChannel().log(10000, "MapManager#getDSIMapControlListener( %1 ) - ID %1 NOT FOUND", (long)n);
        return null;
    }

    public void setDSIMapViewerGoogleCtrl(DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl, int n) {
        if (n == 0 && this.requests[1] != null) {
            ((MVRequestGoogleCtrl)this.requests[1]).bind(dSIMapViewerGoogleCtrl);
        } else if (n == 1 && this.requests[4] != null) {
            ((MVRequestGoogleCtrl)this.requests[4]).bind(dSIMapViewerGoogleCtrl);
        }
    }

    public DSIListener getDSIMapViewerGoogleCtrlListener(int n) {
        if (n == 0 && this.requests[1] != null) {
            return ((MVRequestGoogleCtrl)this.requests[1]).getMVResponseGoogleCtrl();
        }
        if (n == 1 && this.requests[4] != null) {
            return ((MVRequestGoogleCtrl)this.requests[4]).getMVResponseGoogleCtrl();
        }
        this.getLogChannel().log(10000, "MapManager#getDSIMapViewerGoogleCtrlListener( %1 ) - not available", (long)n);
        return null;
    }

    public DSIListener getDSIZoomEngineListener(int n) {
        if (n == 0) {
            return this.getMapMain().getMVResponseZoomEngine();
        }
        if (n == 1 && this.getMapKombi() != null) {
            return this.getMapKombi().getMVResponseZoomEngine();
        }
        this.getLogChannel().log(10000, "MapManager#getDSIZoomEngineListener( %1 ) - not available", (long)n);
        return null;
    }

    public DSIListener getDSIListener(Class clazz) {
        if (clazz == (class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView == null ? (class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView = MapManager.class$("de.audi.tghu.navi.app.map.dsi.MVResponseManeuverView")) : class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView)) {
            return this.getMapMain().getMVResponseManeuverView();
        }
        return null;
    }

    public void setDSI(DSIBase dSIBase, Class clazz) {
        if (clazz == (class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = MapManager.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView)) {
            this.getMapMain().setDSIMapManeuverView((DSIMapViewerManeuverView)dSIBase);
        } else {
            this.getLogChannel().log(10000, "MapManager#setDSI() - %1 is unknown.", (Object)clazz.getName());
        }
    }

    public NavigationEnv getNavigationEnv() {
        return this.env;
    }

    public boolean isMapInMapOperable() {
        if (this.requests[2] != null) {
            return this.requests[2].isOperable();
        }
        return false;
    }

    public void onOperabilityChanged(AbstractRequester abstractRequester) {
        boolean bl = abstractRequester.isOperable();
        String string = bl ? "operable" : "inoperable";
        this.getLogChannel().log(1000000, "MapManager#onOperabilityChanged() - #%2 becomes %1.", (Object)string, (long)abstractRequester.getID());
        this.getLogChannel().log(1000000, "MapManager#onOperabilityChanged() - %1", (Object)this.getBindStatus());
        switch (abstractRequester.getID()) {
            case 0: {
                break;
            }
            case 2: {
                if (bl) break;
                this.getRouteInfoContextHandler().signalMapInMapInoperable();
                break;
            }
            case 1: {
                this.naviInterface.googleEarthUpdateStatusCompleted(1, bl);
                abstractRequester.getMap().getGuiInterface().refreshMapRepresentation();
                this.env.getChoiceModel(400389).setValue(bl ? 1 : 0);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
        }
    }

    public String getStartupState() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.maps[i2] == null) continue;
            buffer.append(this.maps[i2].getStartupState()).append(Formatter.LINE_SEPARATOR);
        }
        return buffer.toString();
    }

    public IRouteCalculator getRouteCalculationHandler() {
        return this.routeCalculationHandler;
    }

    public void updateRgActive(boolean bl) {
        this.getRouteCalculationHandler().updateRgActive(bl);
        AbstractMap[] abstractMapArray = this.getMapKombi() != null ? new AbstractMap[]{this.getMapMain(), this.getMapKombi()} : new AbstractMap[]{this.getMapMain()};
        for (int i2 = 0; i2 < abstractMapArray.length; ++i2) {
            try {
                AbstractMap abstractMap = abstractMapArray[i2];
                abstractMap.getActiveContext().updateRgActive(bl);
                if (!(abstractMap instanceof MapMain)) continue;
                ((MapMain)abstractMap).getRouteInfo().updateRgActive(bl);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                this.getLogChannel().log(10000, "MapManager#updateRgActive() - %1", (Object)exception.getMessage());
            }
        }
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.getRouteCalculationHandler().updateRgInfoForNextDestination(rgInfoForNextDestination);
        AbstractMap[] abstractMapArray = this.getMapKombi() != null ? new AbstractMap[]{this.getMapMain(), this.getMapKombi()} : new AbstractMap[]{this.getMapMain()};
        for (int i2 = 0; i2 < abstractMapArray.length; ++i2) {
            try {
                AbstractMap abstractMap = abstractMapArray[i2];
                abstractMap.getActiveContext().updateRgInfoForNextDestination(rgInfoForNextDestination);
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                this.getLogChannel().log(10000, "MapManager#updateRgActive() - %1", (Object)exception.getMessage());
            }
        }
    }

    protected String getBindStatus() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < 4; ++i2) {
            if (this.maps[i2] == null) continue;
            buffer.append(this.maps[i2].getName()).append("( ").append(this.maps[i2].getMVRequest()).append(" ) ");
        }
        return buffer.toString();
    }

    public final ISetupHandler getSetupMain() {
        return this.setupMain;
    }

    public final ISetupHandler getSetupKombi() {
        return this.setupKombi;
    }

    public void setMapColor(int n) {
        for (int i2 = 0; i2 < this.maps.length; ++i2) {
            ISetupHandler iSetupHandler;
            if (this.maps[i2] == null || (iSetupHandler = this.maps[i2].getSetup()) == null) continue;
            iSetupHandler.setOption(1, n, true);
        }
    }

    public void refreshMetricSystem() {
        for (int i2 = 0; i2 < this.maps.length; ++i2) {
            AbstractMap abstractMap = this.maps[i2];
            if (abstractMap == null) continue;
            abstractMap.getMVRequest().setMetricSystem(Util.getCurrentMetricsSystem(true));
            abstractMap.getMVRequest().setTemperatureScale(Util.getCurrentTemperatureScale());
        }
    }

    public void setNightDesign(int n) {
        this.env.getChoiceModel(169).setValue(n);
        for (int i2 = 0; i2 < this.maps.length; ++i2) {
            IContext iContext;
            if (this.maps[i2] == null || (iContext = this.maps[i2].getActiveContext()) == null) continue;
            iContext.setNightDesign(n);
        }
    }

    public void setCrossingView(int n) {
        this.getMapMain().getSetup().setCrossingView(n, true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setCrossingView(n, true);
        }
    }

    public void setOrientation(int n, int n2) {
        this.getMapMain().getSetup().setOrientation(n, true);
        this.getMapMain().getSetup().setMapType(n2, true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setOrientation(n, true);
            this.getMapKombi().getSetup().setMapType(n2, true);
        }
        this.getMapMain().getSetup().forceHiddenContextRefresh(true);
    }

    public void setOrientationOnMainUnit(int n, int n2) {
        this.getMapMain().getSetup().setOrientation(n, true);
        this.getMapMain().getSetup().setMapType(n2, true);
        this.getMapMain().getSetup().forceHiddenContextRefresh(true);
    }

    public void setOrientationOnCombi(int n, int n2) {
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setOrientation(n, true);
            this.getMapKombi().getSetup().setMapType(n2, true);
            this.getMapKombi().getSetup().forceHiddenContextRefresh(true);
        }
    }

    public void setMapType(int n) {
        this.getMapMain().getSetup().setMapType(n, true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setMapType(n, true);
        }
        this.getMapMain().getSetup().forceHiddenContextRefresh(true);
    }

    public void setMapRepresentation(int n) {
        this.setMapRepresentation(n, false);
    }

    public void setMapRepresentation(int n, boolean bl) {
        this.setMapRepresentation(n, bl, true);
    }

    public void setMapRepresentation(int n, boolean bl, boolean bl2) {
        int n2;
        if (n == 1 && Util.isLockFeatureNavMapAdvancedMapEnabled(this.env) && this.getNaviInterface().isFeatureToBeLocked()) {
            this.getLogChannel().log(100000, "MapManager#setMapRepresentation() - Switch to Google Earth is not allowed while driving!");
            return;
        }
        int n3 = this.getMapMain().getSetup().getMapRepresentation();
        this.getLogChannel().log(10000000, "MapManager#setMapRepresentation() - representationMode: %1, currentMapMainRepresentation: %2, persist: %3", (long)n, (long)n3, bl2);
        if (n == 1 && n != n3) {
            this.env.getChoiceModel(401554).setValue(0);
        }
        int n4 = n2 = Util.isTrafficMapAvailable(this.env.getFramework()) ? 2 : 0;
        if (!bl || n != n2 || this.getMapMain().getSetup().getMapRepresentation() != 3) {
            this.getMapMain().getSetup().setMapRepresentation(n, bl2);
        }
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setMapRepresentation(n, bl2);
        }
    }

    public void restoreBackupMapRepresentationForStandardMap() {
        int n = this.getMapMain().getSetup().getBackupMapRepresentation();
        int n2 = n == 2 ? 2 : (n == 3 ? 3 : 0);
        this.getLogChannel().log(10000000, "MapManager#restoreBackupMapRepresentationForStandardMap(): Restoring: %1", (long)n2);
        this.getMapMain().getSetup().setMapRepresentation(n2, true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setMapRepresentation(n2, true);
        }
    }

    public void setPoiVisible(int[] nArray, boolean[] blArray, boolean bl) {
        this.getMapMain().getSetup().setPoiVisible(nArray, blArray, true);
        if (this.getMapKombi() != null) {
            this.getMapKombi().getSetup().setPoiVisible(nArray, blArray, true);
        }
    }

    public NavLocation[] getRouteDestinations() {
        if (this.routeDestinations != null) {
            return this.routeDestinations;
        }
        return new NavLocation[0];
    }

    public MapInterface getMapInterface() {
        return this.mapInterface;
    }

    public INaviInterface getNaviInterface() {
        return this.naviInterface;
    }

    public boolean toggleDayNightView() {
        int n;
        int n2 = this.getSetupMain().getDayNightView();
        switch (n2) {
            case 0: {
                n = 1;
                break;
            }
            case 1: {
                n = 0;
                break;
            }
            default: {
                n = this.getMapMain().getDayNightView() ? 1 : 0;
            }
        }
        this.setMapColor(n);
        return n == 0;
    }

    public final void setPartialPopupHandler(IMapPartialPopupHandler iMapPartialPopupHandler) {
        this.partialPopupHandler = iMapPartialPopupHandler;
    }

    public IMapPartialPopupHandler getPartialPopupHandler() {
        return this.partialPopupHandler;
    }

    public IPreviewMap getPreviewMapHandler() {
        return this.previewMapHandler;
    }

    public GoogleMapLicenseHandler getGoogleMapLicenseHandler() {
        if (Util.isGoogleEarthPresent(this.env.getFramework())) {
            return this.googleMapLicenseHandler;
        }
        this.getLogChannel().log(100000, "MapManager#getGoogleMapLicsceHandler() - not available");
        return null;
    }

    public WeatherLicenseHandler getWeatherLicenseHandler() {
        return this.weatherLicenseHandler;
    }

    public ServiceListHandler getServiceListHandler() {
        return this.serviceListHandler;
    }

    public void calculateAlternativeRoutes(boolean bl) {
        this.getMapMain().calculateAlternativeRoutes(bl);
    }

    public GUIEventDispatcher getGUIEventDispatcher() {
        return this.guiEventDispatcher;
    }

    public ViewFactory getViews() {
        return this.viewFactory;
    }

    public void doGeneralTest(String string) {
        if (this.tester == null) {
            this.tester = new MapTester(this);
        }
        try {
            this.tester.execute(string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected AbstractMap[] getMaps() {
        return this.maps;
    }

    private void print() {
        for (int i2 = 0; i2 < 5; ++i2) {
            if (this.requests[i2] == null) continue;
            this.getLogChannel().log(1000000, "MapManager#print() - %1", (Object)this.requests[i2]);
        }
        this.getLogChannel().log(1000000, "MapManager#print() - %1", (Object)this.guiEventDispatcher);
    }

    public void viewSizeChanged(int n) {
        this.getLogChannel().log(1000000, "MapManager#viewSizeChanged( %1 )", (long)n);
        this.env.getChoiceModel(402521).setValue(n);
        try {
            if (Util.isClusterMMI(this.env.getFramework())) {
                this.getMapMain().viewSizeChanged(n);
            } else if (Util.isClusterMapFPK(this.env.getFramework())) {
                this.getMapKombiFPK().viewSizeChanged(n);
            } else {
                this.getLogChannel().log(100000, "MapManager#viewSizeChanged() - received invalid call!");
            }
        }
        catch (Exception exception) {
            this.getLogChannel().log(100000, "MapManager#viewSizeChanged() - was unable to invoke");
        }
    }

    public void setConnectivityNaviStateListener(IConnectivityNaviStateListener iConnectivityNaviStateListener) {
        this.getLogChannel().log(100000000, "MapManager#setConnectivityNaviStateListener( %1 )", (Object)iConnectivityNaviStateListener);
        this.connectivityNaviStateListener = iConnectivityNaviStateListener;
        if (iConnectivityNaviStateListener != null && this.getMapMain().getMapDataContainer().isInOnlineMap) {
            try {
                iConnectivityNaviStateListener.onlineMapEntered();
            }
            catch (Exception exception) {
                this.getLogChannel().log(10000, "MapManager#setConnectivityNaviStateListener() - ERROR=%1", (Throwable)exception);
            }
        }
    }

    public IConnectivityNaviStateListener getConnectivityNaviStateListener() {
        return this.connectivityNaviStateListener;
    }

    public void signalNaviNotOperable() {
        this.getLogChannel().log(10000000, "MapManager#signalNaviNotOperable()");
        for (int i2 = 0; i2 < this.maps.length; ++i2) {
            if (this.maps[i2] == null) continue;
            this.maps[i2].getActiveContext().signalNaviNotOperable();
        }
        this.getRouteCalculationHandler().reset();
        this.previewMapHandler.hidePreviewMap();
    }

    public void setMapServiceListener(MapServiceListener mapServiceListener) {
        this.getLogChannel().log(100000000, "MapManager#setMapServiceListener( %1 )", (Object)mapServiceListener);
        this.mapServiceListener = mapServiceListener;
    }

    public MapServiceListener getMapServiceListener() {
        return this.mapServiceListener;
    }

    public void toggleTimeMode(int n) {
    }

    public void showDestination() {
    }

    public void showCCP() {
    }

    public boolean isGoogleMapActive() {
        return this.mapInterface.isGoogleActive();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void disableGoogleMap() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            this.satelliteMapsMediator.resetEnterMapState();
            if (this.isGoogleMapActive()) {
                this.getLogChannel().log(10000000, "MapManager#disableGoogleMap() - Google map active - switch to STD map ");
                this.restoreBackupMapRepresentationForStandardMap();
            } else {
                this.getLogChannel().log(10000000, "MapManager#disableGoogleMap() - Google map not active - ignore ");
            }
        }
    }

    protected Object getMutexSwitchToContext() {
        return this;
    }

    public ISDSController getSdsController() {
        return this.sdsController;
    }

    public int getThreePlusOneMixedListID() {
        return 400477;
    }

    public int getSemiDynListID() {
        return 400451;
    }

    public void setEtaMode(int n) {
    }

    public void setRangeMapVisibility(int n) {
    }

    public void setSpeedAndFlow(int n) {
    }

    public void setLayerPOI(int n) {
    }

    public void setIntersectionZoom(int n) {
    }

    public void hkBackShowCCP() {
    }

    public IDrawerStateHandler getDrawerStateHandler() {
        return this.drawerStateHandler;
    }

    public MapTmcService getTmcMapHandler() {
        if (this.tmcMapHandler == null) {
            this.tmcMapHandler = new TmcMapHandler(this.env, this.getMapMain());
        }
        return this.tmcMapHandler;
    }

    public final IMobilityHorizonHandler getMobilityHorizonHandler() {
        return this.mobilityHorizonHandler;
    }

    public TMCService getTMCService() {
        return this.naviInterface.getTMCGateWay();
    }

    public ITrafficMiniMap getTrafficMiniMap() {
        return this.naviInterface.getTrafficMiniMap();
    }

    public IEventBroker getMapEventDispatcher() {
        if (this.mapEventDispatcher == null) {
            this.mapEventDispatcher = new MapEventDispatcher(this.env);
        }
        return this.mapEventDispatcher;
    }

    public ICruiseModeHandler getCruiseModeHandler() {
        return this.cruiseModelHandler;
    }

    public ITENMIndication getTENMIndication() {
        return this.tenmIndication;
    }

    public DispatcherBase getMapDispatcher() {
        return this.dispatcher;
    }

    public IRouteManager getRouteManager() {
        return this.naviInterface.getRouteManager();
    }

    public void test() {
        this.getLogChannel().log(1000000, "MapManager#test()");
    }

    protected abstract IMapPartialPopupHandler createMapPartialPopupHandler();

    public void stopRRD() {
    }

    public void setPreviewTrafficInfoTmcEvent(boolean bl) {
        this.setPreviewTrafficInfoTmcEvent(this.getMapMain().getMapDataContainer().mapToolTipTMCMessage, bl);
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, boolean bl) {
        int n = this.determinePreviewMapClientId();
        this.getPreviewMapHandler().setPreviewTrafficInfoTmcEvent(tmcMessage, n, bl);
    }

    public int determinePreviewMapClientId() {
        int n = this.getMapMain().getActiveContextIndex() == 39 && !this.getMapMain().getMapDataContainer().isInPredictiveaNavigation || this.getMapMain().getActiveContextIndex() == 5 ? 14 : (this.getMapMain().getActiveContextIndex() == 39 && this.getMapMain().getMapDataContainer().isInPredictiveaNavigation || this.getMapMain().getActiveContextIndex() == 38 ? 15 : 0);
        return n;
    }

    public void updateLockingState(boolean bl) {
        if (this.getMapMain() != null) {
            this.getMapMain().updateLockingState(bl);
        }
        if (this.getMapKombi() != null) {
            this.getMapKombi().updateLockingState(bl);
        }
    }

    public SatelliteMapsMediator getSatelliteMapsMediator() {
        return this.satelliteMapsMediator;
    }

    protected ICommandListFactory getCommandListFactory() {
        return this.commandListFactory;
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

