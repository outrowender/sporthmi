/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IConnectivityNaviStateListener;
import de.audi.atip.interapp.INaviConnectivityStateListener;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.MapServiceListener;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.car.IUpdateDisplayDayNightObserver;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.car.IVehicleStatesObserver;
import de.audi.tghu.navi.app.command.ResetSMCommand;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IOnlineConnectionStateListener;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.context.State;
import de.audi.tghu.navi.app.map.handler.IDrawerStateHandler;
import de.audi.tghu.navi.app.map.handler.IMobilityHorizonHandler;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.handler.WeatherLicenseHandler;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.map.instances.MinorMap;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.map.utils.ConstantUtils;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.sds.ISDSStateEventsProvider;
import de.audi.tghu.navi.app.sds.ISDSStateObserver;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.TmcMessage;

public class MapInterface
implements MapConsts,
MapService,
IUpdateDisplayDayNightObserver,
IVehicleStatesObserver,
ISDSStateObserver,
INaviConnectivityStateListener {
    private static final int RCCI_STATE_ENTERED = 2;
    private static final int ALT_ROUTES_STATE_ENTERED = 3;
    private static final int ALT_ROUTES_PREDICTIVE_NAV_STATE_ENTERED = 4;
    private LogChannel mLogChannel;
    private LogChannel mLogChannelGuidance;
    private MapMain naviMap;
    private NavigationEnv env;
    private MapManager mapManager;
    private final ICommandListFactory commandListFactory;
    private MapOptionValidator mapOptionValidator;
    private List connectionStateListeners;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverView;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView;

    public void cleanup() {
        this.mapManager.cleanup();
        this.clearNotificationsAll();
        this.connectionStateListeners.clear();
    }

    public MapInterface(NavigationEnv navigationEnv, ISDSStateEventsProvider iSDSStateEventsProvider, ICommandListFactory iCommandListFactory, MapOptionValidator mapOptionValidator) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.mapOptionValidator = mapOptionValidator;
        iSDSStateEventsProvider.registerListener(this);
        this.connectionStateListeners = new ArrayList();
    }

    void setMapManager(MapManager mapManager) {
        this.mapManager = mapManager;
        this.naviMap = this.mapManager.getMapMain();
        this.mLogChannel = this.mapManager.getLogChannel();
        this.mLogChannelGuidance = this.mapManager.getMapMain().getMapGuidanceLogChannel();
    }

    public void setDSIMapControl(DSIMapViewerControl dSIMapViewerControl, int n) {
        this.mLogChannel.log(10000000, "MapInterface#setDSIMapControl( %1, %2 )", (Object)dSIMapViewerControl, (long)n);
        this.mapManager.setDSIMapControl(dSIMapViewerControl, n);
    }

    public void setDSIMapZoomEngine(DSIMapViewerZoomEngine dSIMapViewerZoomEngine, int n) {
        this.mLogChannel.log(10000000, "MapInterface#setDSIMapZoomEngine( %1 ), instanceID (%2)", (Object)dSIMapViewerZoomEngine, (long)n);
        this.mapManager.setDSIMapZoomEngine(dSIMapViewerZoomEngine, n);
    }

    public void setDSIMapManeuverView(DSIMapViewerManeuverView dSIMapViewerManeuverView) {
        this.mLogChannel.log(10000000, "MapInterface#setDSIMapManeuverView( %1 )", (Object)dSIMapViewerManeuverView);
        this.mapManager.setDSI(dSIMapViewerManeuverView, class$org$dsi$ifc$map$DSIMapViewerManeuverView == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverView = MapInterface.class$("org.dsi.ifc.map.DSIMapViewerManeuverView")) : class$org$dsi$ifc$map$DSIMapViewerManeuverView);
    }

    public void setDSIMapGoogleCtrl(DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl, int n) {
        this.mLogChannel.log(10000000, "MapInterface#setDSIMapGoogleCtrl( %1, %2 )", (Object)dSIMapViewerGoogleCtrl, (long)n);
        this.mapManager.setDSIMapViewerGoogleCtrl(dSIMapViewerGoogleCtrl, n);
    }

    public DSIListener getDSIMapControlListener(int n) {
        this.mLogChannel.log(100000000, "MapInterface#getDSIMapControlListener( %1 )", (long)n);
        return this.mapManager.getDSIMapControlListener(n);
    }

    public DSIListener getDSIMapGoogleCtrlListener(int n) {
        this.mLogChannel.log(10000000, "MapInterface#getDSIMapGoogleCtrlListener()");
        return this.mapManager.getDSIMapViewerGoogleCtrlListener(n);
    }

    public DSIListener getDSIMapManeuverViewListener() {
        this.mLogChannel.log(10000000, "MapInterface#getDSIMapManeuverViewListener()");
        return this.mapManager.getDSIListener(class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView == null ? (class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView = MapInterface.class$("de.audi.tghu.navi.app.map.dsi.MVResponseManeuverView")) : class$de$audi$tghu$navi$app$map$dsi$MVResponseManeuverView);
    }

    public DSIListener getDSIMapZoomEngineListener(int n) {
        this.mLogChannel.log(10000000, "MapInterface#getDSIMapZoomEngineListener()");
        return this.mapManager.getDSIZoomEngineListener(n);
    }

    public void navigationEntered() {
        this.mLogChannel.log(10000000, "MapInterface#navigationEntered()");
        this.naviMap.getMapDataContainer().isInNavi = true;
    }

    public void navigationLeft() {
        this.mLogChannel.log(10000000, "MapInterface#navigationLeft()");
        this.naviMap.getMapDataContainer().isInNavi = false;
        this.naviMap.getShowTrigger(true);
        this.naviMap.switchToHiddenContext();
    }

    public void navigationEnteredFromMap() {
        this.mLogChannel.log(10000000, "MapInterface#navigationEnteredFromMap()");
        this.naviMap.forceContext(-1);
        this.abortRouteCalculation(false);
        this.naviMap.switchToAShownContext();
    }

    public void enterNavSetup() {
        this.mLogChannel.log(10000000, "MapInterface#enterNavSetup()");
        this.naviMap.getActiveContext().enterNavSetup();
    }

    public void exitNavSetup() {
        this.mLogChannel.log(10000000, "MapInterface#exitNavSetup()");
        this.naviMap.getActiveContext().exitNavSetup();
    }

    public void exitMapContentList() {
        this.mLogChannel.log(10000000, "MapInterface#exitMapContentList()");
        this.naviMap.getActiveContext().exitMapContentList();
    }

    public void enterMapScreen(int n) {
        if (!this.naviMap.getMapDataContainer().isInNavi) {
            this.mLogChannel.log(10000000, "MapInterface#enterMapScreen( ) - not in Navi, ignore");
            return;
        }
        this.mLogChannel.log(10000000, "MapInterface#enterMapScreen( %1 ) - trigger:%2", (long)n, (long)this.naviMap.getShowTrigger(false));
        try {
            this.naviMap.getMapDataContainer().isInMap = true;
            if (n == 2) {
                this.mLogChannel.log(1000000, "MapInterface#enterMapScreen() - force switch to RCCI map");
                this.naviMap.switchToContext(20, SwitchContextEnum.EnterMapScreen);
            } else if (n == 3 && this.naviMap.getActiveContextIndex() != 5 && !this.naviMap.getMapDataContainer().enterAltRoutesFromRightDrawer) {
                this.mLogChannel.log(1000000, "MapInterface#enterMapScreen() - change into Alternative Routes State - force switch to CtxAlternativeRoutes");
                this.naviMap.getMapManager().getRouteCalculationHandler().setCalcFurtherAltRoutes(true);
                this.naviMap.calculateAlternativeRoutes(true);
                this.naviMap.switchToContext(5, SwitchContextEnum.EnterMapScreen);
            } else if (n == 4) {
                this.mLogChannel.log(1000000, "MapInterface#enterMapScreen() - force switch to Selena map");
                this.naviMap.switchToContext(38, SwitchContextEnum.EnterMapScreen);
            } else {
                if (this.naviMap.getActiveContextIndex() == 28) {
                    this.naviMap.clearShowTrigger();
                }
                int n2 = this.naviMap.determineContext(this.naviMap.getShowTrigger(false));
                this.mLogChannel.log(1000000, "MapInterface#enterMapScreen() - determined context : %1", (long)n2);
                n2 = this.naviMap.getMapManager().getPreviewMapHandler().getMapContextCorrected(n2);
                if (n2 == 12 || MapUtils.isCtxPositionMap(n2)) {
                    this.naviMap.getMapManager().getPreviewMapHandler().previewMapFullScreenShowItemInMapWithToolTip();
                } else if (n2 == 13) {
                    this.naviMap.getMapManager().getPreviewMapHandler().previewMapFullScreenShowItemSelectedWithToolTipLast();
                }
                this.naviMap.switchToContext(n2, SwitchContextEnum.EnterMapScreen);
            }
            this.naviMap.getActiveContext().onEvent(100);
            this.env.getChoiceModel(401393).setValue(1);
            if (this.naviMap.getSatellitemapsManager().isSatelliteMapActive()) {
                this.onlineMapEntered();
            }
        }
        catch (Exception exception) {
            this.mLogChannel.log(10000, "MapInterface#enterMapScreen() - ERROR=%1", (Throwable)exception);
        }
    }

    public void enterMapScreenFromLeftDrawer() {
        this.mLogChannel.log(10000000, "MapInterface#enterMapScreenFromLeftDrawer()");
        this.naviMap.show(5);
    }

    public void clearNotificationsAll() {
        this.mapManager.clearNotificationsAll();
    }

    public void clearNotificationsMapCtrl(int n) {
        this.mapManager.clearNotificationsMapCtrl(n);
    }

    public void clearNotificationsGoogleCtrl(int n) {
        this.mapManager.clearNotificationsGoogleCtrl(n);
    }

    public void exitMapScreen() {
        this.env.getChoiceModel(401393).setValue(0);
        if (!this.naviMap.getMapDataContainer().isInNavi) {
            this.mLogChannel.log(10000000, "MapInterface#exitMapScreen( ) - not in Navi, ignore");
            return;
        }
        this.mLogChannel.log(10000000, "MapInterface#exitMapScreen()");
        if (Util.isPorsche(this.env.getFramework())) {
            this.naviMap.clearShowTrigger();
            this.mapManager.getTrafficMiniMap().hideTrafficMiniMap();
        }
        try {
            this.naviMap.getMapDataContainer().isInMap = false;
            this.naviMap.getActiveContext().exitMapScreen();
            IDrawerStateHandler iDrawerStateHandler = this.mapManager.getDrawerStateHandler();
            if (iDrawerStateHandler != null) {
                iDrawerStateHandler.onExitMapScreen();
            }
            if (this.naviMap.getMapDataContainer().isInOnlineMap) {
                this.naviMap.getMapDataContainer().isInOnlineMap = false;
                IConnectivityNaviStateListener iConnectivityNaviStateListener = this.mapManager.getConnectivityNaviStateListener();
                if (iConnectivityNaviStateListener != null) {
                    this.mLogChannel.log(100000000, "MapInterface#exitMapScreen() - inform connectivityNaviStateListener");
                    iConnectivityNaviStateListener.onlineMapLeft();
                }
            }
        }
        catch (Exception exception) {
            this.mLogChannel.log(10000, "MapInterface#exitMapScreen() - ERROR=%1", (Throwable)exception);
        }
    }

    public void enterMapMainScreen() {
        this.mLogChannel.log(10000000, "MapInterface#enterMapMainScreen( ) - active CID: %1, last visible CID: %2, last CtxShown: %3", (long)this.naviMap.getActiveContextIndex(), (long)this.naviMap.getLastVisibleCID(), (long)this.naviMap.getLastCtxShownID());
        this.naviMap.getMapDataContainer().setInMapMain(true);
        if (this.naviMap.getMapDataContainer().isInNavi) {
            int n = this.naviMap.getShowTrigger(true);
            int n2 = this.naviMap.determineContext(n);
            this.naviMap.switchToContext(n2);
        }
    }

    public void exitMapMainScreen() {
        this.naviMap.getMapDataContainer().setInMapMain(false);
        if (!this.naviMap.getMapDataContainer().isInMap || !this.naviMap.getMapDataContainer().isInNavi) {
            this.mLogChannel.log(10000000, "MapInterface#exitMapMainScreen() - not in map or navi, clear trigger");
            this.naviMap.clearShowTrigger();
        } else {
            this.mLogChannel.log(10000000, "MapInterface#exitMapMainScreen()");
        }
        if (this.mapManager.getTrafficMiniMap().isVisible() && !this.naviMap.getMapDataContainer().isInMap) {
            this.mLogChannel.log(10000000, "MapInterface#exitMapMainScreen() TMM visible - hide");
            this.mapManager.getTrafficMiniMap().hideTrafficMiniMap();
        }
    }

    public void enterMapBriefingScreen() {
        this.mLogChannel.log(10000000, "MapInterface#enterMapBriefingScreen()");
        if (!this.naviMap.getMapDataContainer().isInMap && this.naviMap.getRouteCalculationHandler().isRouteCalculationActive()) {
            this.mLogChannel.log(10000000, "MapInterface#enterMapBriefingScreen() - enter/entered from right drawer");
            this.naviMap.switchToContext(this.naviMap.getRouteCalculationHandler().isSingleRoute() ? 33 : 5);
        } else if (this.naviMap.getMapDataContainer().sRGActive) {
            this.naviMap.getGuiInterface().switchMapScreen(0);
        }
    }

    public void exitMapBriefingScreen() {
        this.mLogChannel.log(10000000, "MapInterface#exitMapBriefingScreen( )");
    }

    public void onlineMapEntered() {
        block5: {
            this.mLogChannel.log(10000000, "MapInterface#onlineMapEntered()");
            if (this.naviMap.getSetup().getMapRepresentation() == 1) {
                this.naviMap.getMapDataContainer().isInOnlineMap = true;
                try {
                    IConnectivityNaviStateListener iConnectivityNaviStateListener = this.mapManager.getConnectivityNaviStateListener();
                    if (iConnectivityNaviStateListener != null) {
                        this.mLogChannel.log(100000000, "MapInterface#onlineMapEntered() - inform connectivityNaviStateListener");
                        iConnectivityNaviStateListener.onlineMapEntered();
                        break block5;
                    }
                    this.mLogChannel.log(100000, "MapInterface#onlineMapEntered() - connectivityNaviStateListener is null!");
                }
                catch (Exception exception) {
                    this.mLogChannel.log(10000, "MapInterface#onlineMapEntered() - ERROR=%1", (Throwable)exception);
                }
            } else {
                this.mLogChannel.log(100000000, "MapInterface#onlineMapEntered() - no online map selected in setup - do nothing");
            }
        }
    }

    public void abortRouteCalculation(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#abortRouteCalculation()");
        this.mapManager.getRouteCalculationHandler().abortRouteCalculation(bl);
    }

    public void signalNaviNotOperable() {
        this.mLogChannel.log(10000000, "MapInterface#signalNaviNotOperable()");
        this.mapManager.signalNaviNotOperable();
    }

    public void screenHidden() {
        this.mLogChannel.log(10000000, "MapInterface#screenHidden()");
        this.naviMap.getActiveContext().screenHidden();
    }

    public void screenVisible() {
        this.mLogChannel.log(10000000, "MapInterface#screenVisible()");
        this.naviMap.getActiveContext().screenVisible();
    }

    public void previewMapEntered() {
        this.mLogChannel.log(10000000, "MapInterface#previewMapEntered()");
    }

    public void previewMapLeft() {
        this.mLogChannel.log(10000000, "MapInterface#previewMapLeft()");
        if (this.naviMap.getMapDataContainer().isInNavi || MapUtils.isHiddenContext(this.naviMap.getActiveContextIndex())) {
            int n = this.naviMap.determineContext(this.naviMap.getShowTrigger(false));
            this.mLogChannel.log(10000000, "MapInterface#previewMapLeft() - determined ctx : %1", (long)n);
            this.naviMap.switchToContext(n);
        }
    }

    public boolean toggleDayNightView() {
        this.mLogChannel.log(10000000, "MapInterface#toggleDayNightView");
        return this.mapManager.toggleDayNightView();
    }

    public int toggleAdditionalInfo() {
        int n;
        this.mLogChannel.log(10000000, "GUIInterface#toggleAdditionalInfo");
        int n2 = this.naviMap.getSetup().getAdditionalInfos();
        switch (n2) {
            case 3: {
                n = 0;
                break;
            }
            case 0: {
                if (Util.isHURegionNAR()) {
                    if (Util.isClusterMMI(this.env.getFramework())) {
                        n = 3;
                        break;
                    }
                    n = 1;
                    break;
                }
                if (Util.isMapInMapAvailable(this.env.getFramework())) {
                    n = 2;
                    break;
                }
                n = 3;
                break;
            }
            case 1: {
                if (Util.isMapInMapAvailable(this.env.getFramework())) {
                    n = 2;
                    break;
                }
                n = 3;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            default: {
                this.mLogChannel.log(1000000, "MapInterface#toggleAdditionalInfo() - additional infos set to OFF");
                n = 3;
            }
        }
        this.setAdditionalInfos(n);
        return n;
    }

    public void refreshMetricSystem() {
        this.mapManager.refreshMetricSystem();
    }

    public void crosshairEnterInMap(NavLocation navLocation) {
        this.mLogChannel.log(10000000, "MapInterface#crosshairEnterInMap( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.naviMap.getSetup().setSavedZoomListIndex(this.naviMap.getZoomHandler().getZoomListIndex(100.0f), false);
        this.naviMap.getActiveContext().setEnterInMapLocation(navLocation, false, false, null, false);
        this.naviMap.switchToContext(13);
    }

    public void showInMap(TmcMessage tmcMessage) {
        this.mLogChannel.log(10000000, "MapInterface#showInMap() - %1", (Object)tmcMessage);
    }

    public NavLocationWgs84 getMapPosition() {
        return this.naviMap.getMapPosition();
    }

    public MapTmcService getTMCMap() {
        this.mLogChannel.log(10000000, "MapInterface#getTMCMap()");
        return this.mapManager.getTmcMapHandler();
    }

    public ITrafficMiniMap getTMM() {
        return this.mapManager.getTrafficMiniMap();
    }

    public boolean isInAltRoutesSelection() {
        return this.naviMap.getActiveContextIndex() == 5;
    }

    public boolean isContextOnlineResult() {
        int n = this.naviMap.getActiveContextIndex();
        return n == 15 || n == 28 || n == 37;
    }

    public void switchToSemidynamicRouteSelection() {
        this.mLogChannel.log(10000000, "MapInterface#switchToSemidynamicRouteSelection()");
        this.naviMap.getRouteCalculationHandler().switchToSemidynamic(-1);
    }

    public boolean hasBetterRoute() {
        this.mLogChannel.log(10000000, "MapInterface#hasBetterRoute()");
        return this.naviMap.getRouteCalculationHandler().hasBetterRoute();
    }

    public int getSavingTime() {
        this.mLogChannel.log(10000000, "MapInterface#getSavingTime()");
        return this.naviMap.getRouteCalculationHandler().getSavingTime();
    }

    public long getTrafficDelayOnCurrentRoute() {
        this.mLogChannel.log(10000000, "MapInterface#getTrafficDelayOnCurrentRoute()");
        return this.naviMap.getRouteCalculationHandler().getTrafficDelayOnCurrentRoute();
    }

    public void selectRoute(int n, boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#selectRoute( %2, %1 )", bl, (long)n);
        this.naviMap.getRouteCalculationHandler().selectRoute(n, bl);
    }

    public boolean sdsSelectAlternativeRoute(int n) {
        this.mLogChannel.log(10000000, "MapInterface#sdsSelectAlternativeRoute( %1 )", (long)n);
        this.naviMap.getRouteCalculationHandler().setSelectedRouteIndex(n);
        boolean bl = this.naviMap.getRouteCalculationHandler().startRG(n);
        if (bl) {
            this.naviMap.switchToAShownContext();
        }
        return bl;
    }

    public void cancelRouteCalculationTimer() {
        this.mLogChannel.log(10000000, "MapInterface#cancelRouteCalculationTimer()");
        this.mapManager.getRouteCalculationHandler().cancelTimer();
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        try {
            if (calculatedRouteListElementArray == null || calculatedRouteListElementArray.length == 0) {
                this.mLogChannel.log(100000000, "MapInterface#updateRgCalculatedRoutes() - empty");
            } else {
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                    if (i2 > 0) {
                        buffer.append(", ");
                    }
                    buffer.append(ConstantUtils.CALCULATIONSTATE[calculatedRouteListElementArray[i2].getCalculationState()]);
                }
                this.mLogChannel.log(10000000, "MapInterface#updateRgCalculatedRoutes() - state = %1", (Object)buffer.toString());
            }
            this.mapManager.getRouteCalculationHandler().updateRgCalculatedRoutes(calculatedRouteListElementArray);
        }
        catch (Exception exception) {
            this.mLogChannel.log(100000, "MapInterface#updateRgCalculatedRoutes() - %1", (Throwable)exception);
        }
    }

    public void updateRgRouteCalculationState(int n) {
        this.mLogChannel.log(10000000, "MapInterface#updateRgRouteCalculationState( %1 )", (Object)ConstantUtils.ROUTECALCULATIONSTATE[n]);
        this.mapManager.getRouteCalculationHandler().updateRgRouteCalculationState(n);
    }

    public void switchToMap() {
        this.mLogChannel.log(10000000, "MapInterface#switchToMap()");
        this.naviMap.getActiveContext().switchToMap();
    }

    public void setTravelParameters(boolean bl, boolean bl2, long l, long l2, int n, int n2, long l3, long l4, int n3, int n4, int n5) {
        this.mLogChannelGuidance.log(100000000, "MapInterface#setTravelParameters( timeToNextDestination=%1, eta=%2, distance=%3 )", l, l2, (long)n);
        this.naviMap.getRouteInfo().setTravelParameters(bl, bl2, l, l2, n, n2, l3, l4, n3, n4, n5);
    }

    public void setHeight(int n) {
        this.naviMap.getGuiInterface().setHeight(n);
    }

    public void updateRgActive(boolean bl) {
        this.mLogChannel.log(100000000, "MapInterface#updateRgActive( %1 )", bl);
        this.mapManager.updateRgActive(bl);
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.mapManager.updateRgInfoForNextDestination(rgInfoForNextDestination);
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        this.mLogChannel.log(10000000, "MapInterface#rgStartGuidanceCalculatedRouteByUIDResult( %1, %2 )", (Object)navSegmentID, (long)n);
        this.naviMap.getActiveContext().rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
    }

    public void stopoverHasBeenPassed() {
        this.mLogChannel.log(10000000, "MapInterface#stopoverHasBeenPassed()");
        this.naviMap.getRouteInfo().refreshDestinationFlag();
        this.naviMap.getActiveContext().stopoverHasBeenPassed();
    }

    public void setTopDestination(AdbEntry[] adbEntryArray) {
        AdbEntry[] adbEntryArray2 = adbEntryArray == null ? new AdbEntry[]{} : adbEntryArray;
        this.mLogChannel.log(10000000, "MapInterface#setTopDestination( length=%1 )", (long)adbEntryArray2.length);
        this.mapManager.setTopDestinations(adbEntryArray2);
    }

    public void setHomeDestination(AdbEntry adbEntry) {
        if (adbEntry == null) {
            this.mLogChannel.log(10000000, "MapInterface#setHomeDestination( null ): clear home destination");
        } else {
            this.mLogChannel.log(10000000, "MapInterface#setHomeDestination( EntryId: %1 )", adbEntry.getEntryId());
        }
        this.mapManager.setHomeDestination(adbEntry);
    }

    public void setOnlineResultFlags(OnlinePOIResultList onlinePOIResultList) {
        this.mLogChannel.log(10000000, "MapInterface#setOnlineResultFlags( length = %1 )", (long)onlinePOIResultList.length());
        this.naviMap.getActiveContext().setOnlineResultFlags(onlinePOIResultList);
    }

    public void setRemoteHMIResultFlags(OnlinePOIResultList onlinePOIResultList) {
        this.mLogChannel.log(10000000, "MapInterface#setRemoteHMIResultFlags( length = %1 )", onlinePOIResultList == null ? 0L : (long)onlinePOIResultList.length());
        if (onlinePOIResultList != null && onlinePOIResultList.length() != 0) {
            this.naviMap.getActiveContext().setWeatherOverlaysData(0, null, 0);
        }
        this.naviMap.getActiveContext().setRemoteHMIResultFlags(onlinePOIResultList);
    }

    public void setWeatherOverlays(int n, NaviOnlineService.NaviOnlineMapOverlay[] naviOnlineMapOverlayArray, int n2, ChoiceModelApp choiceModelApp) {
        this.mLogChannel.log(10000000, "MapInterface#setWeatherOverlays() - setId: %1, data.length: %2, delayInMillisBetweenImages: %3", (long)n, (long)(naviOnlineMapOverlayArray == null ? 0 : naviOnlineMapOverlayArray.length), (long)n2);
        if (naviOnlineMapOverlayArray != null && naviOnlineMapOverlayArray.length != 0) {
            this.naviMap.getActiveContext().setRemoteHMIResultFlags(null);
        }
        this.naviMap.getActiveContext().setWeatherOverlaysData(n, naviOnlineMapOverlayArray, n2);
        this.naviMap.switchToContext(3);
        this.naviMap.switchToContext(28);
    }

    public void updateOnlineResultFlagDetails(int n) {
        this.naviMap.getActiveContext().updateOnlineResultFlagDetails(n);
    }

    public void updatePicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
        this.naviMap.getActiveContext().updatePicNavLocation(navLocation, resourceLocator);
    }

    public void updateXTRepresentation(NavLocation navLocation, String string) {
        this.naviMap.getActiveContext().updateXTRepresentation(navLocation, string);
    }

    public void enterOnlineResultMap() {
        this.mLogChannel.log(10000000, "MapInterface#enterOnlineResultMap()");
        this.naviMap.switchToContext(3);
        this.naviMap.show(2);
        this.naviMap.switchToContext(15);
    }

    public void enterOnlineResultMap(NavLocation navLocation) {
        this.mLogChannel.log(10000000, "MapInterface#enterOnlineResultMap() - single location");
        this.naviMap.switchToContext(3);
        this.naviMap.show(2);
        this.naviMap.getActiveContext().setEnterInMapLocation(navLocation, false, false, null, false);
        this.naviMap.switchToContext(15);
    }

    public void enterRemoteHMIResultMap() {
        this.mLogChannel.log(10000000, "MapInterface#enterRemoteHMIResultMap()");
        this.env.getChoiceModel(401393).setValue(1);
        this.naviMap.show(3);
        if (!Util.isPreviewMapPresent(this.env.getFramework())) {
            this.naviMap.switchToContext(3);
        }
        this.naviMap.switchToContext(28);
    }

    public void displayNightDesign(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#displayNightDesign( %1 )", bl);
        this.mapManager.setNightDesign(bl ? 1 : 0);
    }

    public void updateDistanceToNextManeuver(int n) {
        this.mLogChannelGuidance.log(100000000, "MapInterface#updateDistanceToNextManeuver( %1 )", (long)n);
        this.naviMap.getActiveContext().updateDistanceToNextManeuver(n);
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.mLogChannel.log(10000000, "MapInterface#updateRgRouteCostChangeInformation( %1 )", (Object)rgRouteCostChangeInformation);
        this.mapManager.getRouteCalculationHandler().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
    }

    public void updateTmcMessage(TmcMessage tmcMessage) {
        this.mLogChannel.log(10000000, "MapInterface#updateTmcMessage()");
        this.naviMap.getActiveContext().updateTmcMessage(tmcMessage);
    }

    public int setMapType(int n) {
        int n2 = this.naviMap.getMapType();
        this.mLogChannel.log(10000000, "MapInterface#setMapType() - type: %1, currentMapType: %2", (long)n, (long)n2);
        if (!this.mapOptionValidator.isMapTypeValid(n)) {
            return 1;
        }
        int n3 = this.naviMap.getMapRepresentation();
        if (n == 2 && n3 == 3) {
            return 2;
        }
        if (n != n2) {
            this.naviMap.switchToHiddenContext();
            this.naviMap.getSetup().setMapType(n, true);
            this.naviMap.switchToAShownContext();
        }
        return 0;
    }

    public void setMapColor(int n) {
        this.mLogChannel.log(10000000, "MapInterface#setMapColor( %1 )", (long)n);
        this.naviMap.getMapManager().setMapColor(n);
    }

    public void setAdditionalInfos(int n) {
        this.mLogChannel.log(10000000, "MapInterface#setAdditionalInfos( %1 )", (long)n);
        if (this.mapOptionValidator.isAdditionalInfosValid(n)) {
            this.naviMap.getSetup().setAdditionalInfos(n, true);
            this.naviMap.getActiveContext().freezeMapLevel1();
            this.naviMap.getActiveContext().initAdditionalInfos();
            this.naviMap.getActiveContext().unfreezeMapLevel1();
        } else {
            this.mLogChannel.log(10000, "MapInterface#setAdditionalInfos() - invalid parameter: %1", (long)n);
        }
    }

    public void setCrossingView(int n) {
        this.mLogChannel.log(10000000, "MapInterface#setCrossingView( %1 )", (long)n);
        this.naviMap.getSetup().setCrossingView(n, true);
        this.naviMap.getActiveContext().freezeMapLevel1();
        this.naviMap.getActiveContext().initAdditionalInfos();
        this.naviMap.getActiveContext().unfreezeMapLevel1();
    }

    public void setMapOrientation(int n) {
        this.mLogChannel.log(10000000, "MapInterface#setMapOrientation( %1 )", (long)n);
        this.naviMap.getSetup().setOrientation(n, true);
        this.naviMap.getActiveContext().freezeMapLevel1();
        if (!this.ignoreSetupOrientation()) {
            this.naviMap.getActiveContext().activateOrientationAccordingToSetup();
        }
        this.naviMap.getActiveContext().unfreezeMapLevel1();
    }

    public void setZoomLevel(float f2) {
        if (10000000 <= this.mLogChannel.getCurrentLogThreshold()) {
            this.mLogChannel.log(10000000, "MapInterface#setZoomLevel( %1 )", (Object)Float.toString(f2));
        }
        int n = this.naviMap.getZoomHandler().getZoomListIndex(f2 / 100.0f);
        this.naviMap.getActiveContext().sdsSetZoomLevel(n);
    }

    public void setIncrementalZoom(int n) {
        this.mLogChannel.log(10000000, "MapInterface#setIncrementalZoom( %1 )", (long)n);
        this.naviMap.getZoomHandler().sdsIncrement(n);
    }

    public void sdsDisplayCurrentRoute() {
        this.naviMap.getActiveContext().displayCurrentRoute();
    }

    public void setSDSDialogActive(boolean bl) {
        if (this.mapManager == null || this.mapManager.getMaps() == null) {
            this.mLogChannel.log(10000, "MapInterface#setSDSDialogActive() - map manager or maps is null!");
            return;
        }
        this.mLogChannel.log(10000000, "MapInterface#setSDSDialogActive( %1 )", bl);
        AbstractMap[] abstractMapArray = this.mapManager.getMaps();
        for (int i2 = 0; i2 < abstractMapArray.length; ++i2) {
            if (abstractMapArray[i2] == null || abstractMapArray[i2].getActiveContext() == null) continue;
            abstractMapArray[i2].getActiveContext().setSDSDialogActive(bl);
        }
    }

    public boolean is3DMapActive() {
        this.mLogChannel.log(10000000, "MapInterface#is3DMapActive()");
        int n = this.naviMap.getCurrentViewType();
        return n == 3 || n == 1;
    }

    public boolean isOverviewMapActive() {
        this.mLogChannel.log(10000000, "MapInterface: isOverviewMapActive()");
        int n = this.naviMap.getActiveContextIndex();
        return n == 10;
    }

    public boolean isDestinationMapActive() {
        this.mLogChannel.log(10000000, "MapInterface: isDestinationMapActive()");
        int n = this.naviMap.getActiveContextIndex();
        return n == 11;
    }

    public boolean ignoreSetupOrientation() {
        return this.naviMap.getActiveContextIndex() == 10 || this.isContextOnlineResult();
    }

    public boolean isGoogleActive() {
        boolean bl = this.naviMap.getSatellitemapsManager().isSatelliteMapActive();
        this.mLogChannel.log(100000000, "MapInterface: isGoogleActive() - result: %1", bl);
        return bl;
    }

    public boolean sdsSetMapRepresentation(int n) {
        int n2 = this.naviMap.getMapRepresentation();
        this.mLogChannel.log(10000000, "MapInterface#sdsSetMapRepresentation( %1 ) - currentMapRepresenation: %2", (long)n, (long)n2);
        if (!this.mapOptionValidator.isMapRepresentationValid(n)) {
            return false;
        }
        if (n2 != n) {
            this.setMapRepresentation(n);
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new ResetSMCommand());
            commandList.execute("MapInterface#sdsSetMapRepresentation");
        }
        return true;
    }

    public boolean sdsSetRouteInfo(boolean bl) {
        this.naviMap.getSetup().setAdditionalInfos(bl ? 0 : 3, true);
        return true;
    }

    public void setTrafficSettings(boolean bl, boolean bl2, boolean bl3, int n) {
        this.mLogChannel.log(1000000, "MapInterface#setTrafficSettings() - freeFlow: %1, congestions: %2, eventIcons: %3, map(0=main|1=both|2=kombi): %4", (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl3), (Object)Integer.toString(n));
        if (n <= 1) {
            this.setTrafficSettingsForMap(this.naviMap, bl, bl2, bl3);
        }
        if (n >= 1 && this.getKombiMap() != null) {
            this.setTrafficSettingsForMap(this.getKombiMap(), bl, bl2, bl3);
        }
    }

    private void setTrafficSettingsForMap(AbstractMap abstractMap, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        int n;
        boolean bl5;
        ISetupHandler iSetupHandler = abstractMap.getSetup();
        IContext iContext = abstractMap.getActiveContext();
        boolean bl6 = bl != iSetupHandler.getSpeedAndFlowFreeflow(0);
        boolean bl7 = bl2 != iSetupHandler.getSpeedAndFlowCongestions(0);
        boolean bl8 = bl5 = bl3 != iSetupHandler.getTMCSymbols(0);
        if (this.mLogChannel.isDebug2()) {
            this.mLogChannel.log(100000000, "MapInterface#setTrafficSettingsForMap() - changeFreeFlow: %1, changeCongestions: %2, changeEventIcons: %3", bl6, bl7, bl5);
        }
        if (Util.isHURegionAsia()) {
            n = bl || bl2 ? 4 : 0;
            boolean bl9 = bl4 = n != iSetupHandler.getProperty(5);
            if (bl4) {
                iSetupHandler.setProperty(5, n == 4 ? 0 : 4);
                iContext.setSpeedAndFlowRoadClass(n);
            }
        }
        if (Util.isUncrowdedRoadsCheckboxAvailable(this.env.getFramework())) {
            int n2 = n = bl != (iSetupHandler.getProperty(2) == 1) ? 1 : 0;
            if (n != 0) {
                iSetupHandler.setProperty(2, bl ? 1 : 0);
            }
        }
        if (bl6) {
            iSetupHandler.setSpeedAndFlowFreeflow(bl, true, 0);
            iContext.showSpeedAndFlowFreeflow(bl);
        }
        if (bl7) {
            iSetupHandler.setSpeedAndFlowCongestions(bl2, true, 0);
            iContext.showSpeedAndFlowCongestions(bl2);
        }
        if (bl5) {
            iSetupHandler.setOption(11, bl3, true);
            iContext.showTMC(bl3);
        }
        if (Util.isTrafficEventNoticeMapAvailable(this.env.getFramework()) && abstractMap.isMapMain()) {
            n = bl || bl2 || bl3 ? 1 : 0;
            boolean bl10 = bl4 = n != (iSetupHandler.getProperty(1) == 1 ? 1 : 0);
            if (bl4) {
                iSetupHandler.setProperty(1, n != 0 ? 1 : 0);
            }
        }
        abstractMap.getMapContentHandler().refresh();
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        this.mLogChannel.log(10000000, "MapInterface#updateRgTurnList( length=%1 )", turnListElementArray != null ? (long)turnListElementArray.length : 0L);
        this.naviMap.getRouteInfo().updateRgTurnList(turnListElementArray);
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.mLogChannel.log(10000000, "MapInterface#updateRgDestinationInfo( length = %1 )", navRouteListDataArray != null ? (long)navRouteListDataArray.length : 0L);
        this.naviMap.getRouteInfo().updateRgDestinationInfo(navRouteListDataArray);
        this.naviMap.getRouteCalculationHandler().updateRgDestinationInfo(navRouteListDataArray);
    }

    public void enableRouteInfoComplete(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#enableRouteInfoComplete( %1 )", bl);
        this.naviMap.getRouteInfo().enableRouteInfoComplete(bl);
    }

    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        this.mLogChannel.log(10000000, "MapInterface#updateRgPoiInfo( length=%1 )", navPoiInfoArray == null ? 0L : (long)navPoiInfoArray.length);
        this.naviMap.getRouteInfo().updateRgPoiInfo(navPoiInfoArray);
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        this.mLogChannel.log(10000000, "MapInterface#updateTmcMessagesAhead( length=%1 )", tmcMessageArray == null ? 0L : (long)tmcMessageArray.length);
        this.naviMap.getActiveContext().updateTmcMessagesAhead(tmcMessageArray);
        this.naviMap.getRouteInfo().updateTmcMessagesAhead(tmcMessageArray);
    }

    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.mapManager.getTENMIndication().indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
    }

    public void informTENMPopupPosition(int n, int n2, int n3, int n4, int n5) {
        this.naviMap.getActiveContext().informTENMPopupPosition(n2, n3, n4, n5);
    }

    public void setLanguage(String string) {
        this.mLogChannel.log(10000000, "MapInterface#setLanguage( %1 )", (Object)string);
        try {
            this.naviMap.getRouteInfo().setLanguage(string);
        }
        catch (Exception exception) {
            this.mLogChannel.log(10000, "MapInterface#setLanguage( %1 ) - ERROR=%2", (Object)string, (Throwable)exception);
        }
    }

    public void unitsChanged() {
        this.mLogChannel.log(10000000, "MapInterface#unitsChanged()");
        this.naviMap.getActiveContext().refreshDistanceToNextManeuver();
        this.naviMap.getRouteInfo().refreshDistAndRtt();
    }

    public void resetSettings() {
        ISetupHandler iSetupHandler;
        this.mLogChannel.log(10000000, "MapInterface#resetSettings()");
        AbstractMap abstractMap = this.getMap();
        ISetupHandler iSetupHandler2 = abstractMap.getSetup();
        State.StateData stateData = new State.StateDataMapMain(this.env.getFramework());
        iSetupHandler2.initFromStateData(stateData, true);
        this.resetMapSettings(abstractMap, iSetupHandler2);
        AbstractMap abstractMap2 = this.getKombiMap();
        ISetupHandler iSetupHandler3 = iSetupHandler = abstractMap2 != null ? abstractMap2.getSetup() : null;
        if (iSetupHandler != null) {
            stateData = new State.StateDataMapKombi(this.env.getFramework());
            iSetupHandler.initFromStateData(stateData, true);
            this.resetMapSettings(abstractMap2, iSetupHandler);
        }
    }

    private void resetMapSettings(AbstractMap abstractMap, ISetupHandler iSetupHandler) {
        iSetupHandler.resetSettings();
        abstractMap.getMVRequest().ehSetCategoryVisibilityToDefault(0);
        abstractMap.getMapDataContainer().fUserZoomLevel = 400.0f;
    }

    public void resetMemory() {
        boolean bl;
        this.mLogChannel.log(10000000, "MapInterface#resetMemory()");
        boolean bl2 = bl = this.env.getChoiceModel(93).getValue() == 1;
        if (!bl && this.naviMap.getSatellitemapsManager().isSatelliteMapActive() && this.naviMap.getSetup().getMapRepresentation() == 1) {
            this.mLogChannel.log(10000000, "MapInterface#resetMemory() - GE currently active, but no dataconnection (license check not possible) => change to STD map");
            this.mLogChannel.log(10000000, "MapInterface#resetMemory() - show popup: Google offline, data connection required");
            this.mapManager.getPartialPopupHandler().showPopupGoogleOfflineNoCache();
            this.mapManager.restoreBackupMapRepresentationForStandardMap();
        }
        this.mapManager.getSatelliteMapsMediator().resetEnterMapState();
    }

    public void setEnableRouteCalcMode(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#setEnableRouteCalcMode( %1 )", bl);
        if (!this.env.getFramework().isFrontMU()) {
            this.naviMap.forceContext(-1);
            this.naviMap.getMVRequest().setEnableRouteCalcMode(bl);
        } else {
            this.mLogChannel.log(100000, "MapInterface#setEnableRouteCalcMode() - not allowed on main unit!", bl);
        }
    }

    public void diagFreezeMap(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#freezeMap( %1 )", bl);
        this.naviMap.getMVRequest().viewFreeze(bl);
    }

    public String getStartupState() {
        return this.mapManager.getStartupState();
    }

    public boolean getDayNightView() {
        return this.naviMap.getDayNightView();
    }

    public void setOptMenuType(int n, boolean bl, boolean bl2, boolean bl3) {
        this.naviMap.getGuiInterface().setOptMenuType(n);
    }

    public void setMapRepresentation(int n) {
        this.mLogChannel.log(10000000, "MapInterface#setMapRepresentation( %1 )", (long)n);
        if (this.mapOptionValidator.isMapRepresentationValid(n)) {
            if (this.isGoogleTempDisabled() && n != 1) {
                this.setGoogleTempDisabled(false);
            }
            this.naviMap.getMapManager().setMapRepresentation(n);
        } else {
            this.mLogChannel.log(10000, "MapInterface#setMapRepresentation() - invalid mapRepresentation: %1", (long)n);
        }
    }

    public String diagGetConfigureFlagsStatus() {
        Buffer buffer = new Buffer();
        buffer.append("topDests").append("\n");
        MapPin[] mapPinArray = this.naviMap.getMapFlagHandler().getPins();
        if (mapPinArray != null) {
            for (int i2 = 0; i2 < mapPinArray.length; ++i2) {
                buffer.append("userFlags[").append(i2).append("] = ").append(mapPinArray[i2]).append("\n");
            }
        }
        buffer.append("mapFlagsStdMap").append("\n");
        MapFlag[] mapFlagArray = this.naviMap.getMVResponseControlStd().getMapPersonalDest();
        if (mapFlagArray != null) {
            for (int i3 = 0; i3 < mapFlagArray.length; ++i3) {
                buffer.append("mapFlagsStdMap[").append(i3).append("] = ").append(mapFlagArray[i3]).append("\n");
            }
        }
        buffer.append("mapFlagsGE").append("\n");
        MapFlag[] mapFlagArray2 = this.naviMap.getMVResponseGoogleCtrl().getMapPersonalDest();
        if (mapFlagArray2 != null) {
            for (int i4 = 0; i4 < mapFlagArray2.length; ++i4) {
                buffer.append("mapFlagsGE[").append(i4).append("] = ").append(mapFlagArray2[i4]).append("\n");
            }
        }
        return buffer.toString();
    }

    public int getPOIIndexFromUserFlags() {
        IContext iContext = this.naviMap.getActiveContext();
        if (iContext instanceof CtxFreeMap) {
            return ((CtxFreeMap)iContext).getPOIIndexFromUserFlags();
        }
        this.mLogChannel.log(100000, "MapInterface#getPOIIndexFromUserFlags() - the active context (id=%2) of %1 is not HasPosInfo", (Object)this.naviMap.getName(), (long)this.naviMap.getActiveContextIndex());
        return -1;
    }

    public AbstractMap getMap() {
        return this.naviMap;
    }

    public AbstractMap getKombiMap() {
        return this.mapManager.getMapKombi();
    }

    public void diagExceedsUpperThreshold(int n) {
        this.getMap().exceedsUpperThreshold(n);
        if (this.getKombiMap() != null) {
            this.getKombiMap().exceedsUpperThreshold(n);
        }
    }

    public void diagBelowLowerThreshold(int n) {
        this.getMap().belowLowerThreshold(n);
        if (this.getKombiMap() != null) {
            this.getKombiMap().belowLowerThreshold(n);
        }
    }

    public boolean isCarMoving() {
        boolean bl = false;
        if (this.getMap() != null) {
            bl = this.getMap().getMapDataContainer().carIsMoving;
        }
        if (this.mapManager != null && this.getKombiMap() != null) {
            bl |= this.getKombiMap().getMapDataContainer().carIsMoving;
        }
        return bl;
    }

    public void setCarMoving(boolean bl) {
        if (this.getMap() != null) {
            this.getMap().getMapDataContainer().carIsMoving = bl;
        }
        if (this.mapManager != null && this.getKombiMap() != null) {
            this.getKombiMap().getMapDataContainer().carIsMoving = bl;
        }
    }

    public boolean isGoogleTempDisabled() {
        boolean bl = false;
        if (this.getMap() != null) {
            bl = this.getMap().getMapDataContainer().googleTempDisabled;
        }
        if (this.mapManager != null && this.getKombiMap() != null) {
            bl |= this.getKombiMap().getMapDataContainer().googleTempDisabled;
        }
        this.mLogChannel.log(10000000, "MapInterface#isGoogleTempDisabled( %1 )", bl);
        return bl;
    }

    public void setGoogleTempDisabled(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#setGoogleTempDisabled( %1 )", bl);
        if (this.getMap() != null) {
            this.getMap().getMapDataContainer().googleTempDisabled = bl;
        }
        if (this.mapManager != null && this.getKombiMap() != null) {
            this.getKombiMap().getMapDataContainer().googleTempDisabled = bl;
        }
    }

    public void refreshMapContent() {
        if (this.getMap() != null) {
            this.getMap().getMapContentHandler().refresh();
        }
        if (this.mapManager != null && this.getKombiMap() != null) {
            this.getKombiMap().getMapContentHandler().refresh();
        }
    }

    public void showMapInMapPictureDest(int n, int n2) {
        this.mLogChannel.log(10000000, "MapInterface#showMapInMapPictureDest() - longitude: %1, latitude: %2", (long)n, (long)n2);
        if (this.mLogChannel.isDebug2() && this.naviMap.getMapDataContainer().sPicNavCarouselMapPosition != null) {
            this.mLogChannel.log(100000000, "MapInterface#showMapInMapPictureDest(): old position was: long: %2, lat: %1", (long)this.naviMap.getMapDataContainer().sPicNavCarouselMapPosition.getLatitude(), (long)this.naviMap.getMapDataContainer().sPicNavCarouselMapPosition.getLongitude());
        }
        this.naviMap.getMapDataContainer().sPicNavCarouselMapPosition = new NavLocationWgs84(n, n2);
        this.naviMap.switchToContext(27);
    }

    public void showPreviewMapP1(int n, int n2) {
        this.mLogChannel.log(10000000, "MapInterface#showPreviewMapP1() - longitude: %1, latitude: %2", (long)n, (long)n2);
        MinorMap minorMap = this.mapManager.getMinorMap();
        if (this.mLogChannel.isDebug2() && minorMap.getMapDataContainer().sPicNavCarouselMapPosition != null) {
            this.mLogChannel.log(100000000, "MapInterface#showPreviewMapP1(): old position was: long: %2, lat: %1", (long)minorMap.getMapDataContainer().sPicNavCarouselMapPosition.getLatitude(), (long)minorMap.getMapDataContainer().sPicNavCarouselMapPosition.getLongitude());
        }
        minorMap.getMapDataContainer().sPicNavCarouselMapPosition = new NavLocationWgs84(n, n2);
        minorMap.switchToContext(27);
    }

    public void showPictureNavLocationOnMap(NavLocation navLocation, int n, ResourceLocator resourceLocator, boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#showPictureNavLocationOnMap() - filterId: %2, location: %1", (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        this.naviMap.getSetup().setSavedZoomListIndex(this.naviMap.getZoomHandler().getZoomListIndex(100.0f), false);
        this.naviMap.getActiveContext().setPicNavMapLocation(navLocation, bl, n, resourceLocator);
        this.naviMap.switchToContext(26);
    }

    public void hideMapInMapPictureDest() {
        this.naviMap.hideMapInMapPictureDest();
    }

    public void viewSetVisible(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#viewSetVisible() - visible: %1", bl);
        this.naviMap.getMVRequest().viewSetVisible(bl);
    }

    public void diagForceRouteInfo(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#forceRouteInfo() - show: %1", bl);
        this.naviMap.getRouteInfo().forceRouteInfo(bl);
    }

    public void setIsInVia(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#setIsInVia( %1 )", bl);
        this.mapManager.getRouteCalculationHandler().enableTimer(!bl);
        this.naviMap.getActiveContext().setIsInVia(bl);
    }

    public void swapMaps() {
    }

    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        this.mLogChannel.log(1000000, "MapInterface#startRouteCalculation( -, num = %2, prepare = %1, wait = %3)", bl, (Object)new Integer(n), (Object)bl2);
        this.getPreviewMap().setPreviewMapNone(0);
        this.mapManager.getRouteCalculationHandler().startRouteCalculation(route, n, bl, bl2, bl3);
    }

    public void diagDoGeneralTest(String string) {
        try {
            this.mapManager.doGeneralTest(string);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public NavLocation getMapFocusedLocation() {
        this.mLogChannel.log(1000000, "MapInterface#getMapFocusedLocation() - %1", (Object)this.getMap().getMapDataContainer().sFocusedPosition);
        return this.getMap().getMapDataContainer().sFocusedPosition;
    }

    public void updateDisplayDayNightDesign(boolean bl) {
        this.displayNightDesign(bl);
    }

    public void showKombiMap(boolean bl) {
        boolean bl2;
        this.mLogChannel.log(1000000, "MapInterface#showKombiMap( %1 )", bl);
        if (!Util.isClusterMapAvailable(this.env.getFramework())) {
            this.mLogChannel.log(100000, "MapInterface#showKombiMap( ) - kombi map not available");
            return;
        }
        AbstractMap abstractMap = this.mapManager.getMapKombi();
        boolean bl3 = bl2 = abstractMap != null && abstractMap.isInitialized();
        if (bl2) {
            if (bl) {
                abstractMap.switchToAShownContext();
                if (this.naviMap.getSetup().getMapRepresentation() == 1 && !this.naviMap.getSatellitemapsManager().isSatelliteMapActive()) {
                    this.mLogChannel.log(10000000, "MapInterface#showKombiMap( ) - refresh active map style (try to switch to Sat Map map)");
                    this.mapManager.getSatelliteMapsMediator().refreshActiveMapStyle(false);
                }
            } else {
                abstractMap.switchToHiddenContext();
            }
        } else {
            this.mLogChannel.log(100000, "MapInterface#showKombiMap( %1 ) - initialized: %2 - Kombi map not present or not initialized!", bl, bl2);
        }
    }

    public void switchDisplayContextKombi(int n) {
        this.mLogChannel.log(1000000, "MapInterface#switchDisplayContextKombi( %1 )", (long)n);
        if (!Util.isClusterMapAvailable(this.env.getFramework()) && !Util.isClusterKDKAvailable(this.env.getFramework())) {
            this.mLogChannel.log(10000, "MapInterface#switchDisplayContextKombi() - Neither Kombi map nor KDK is present!");
            return;
        }
        AbstractMap abstractMap = this.mapManager.getMapKombi();
        switch (n) {
            case 9: {
                if (abstractMap != null) {
                    abstractMap.getActiveContext().switchDisplayContextKombi(9);
                    break;
                }
                this.naviMap.getActiveContext().switchDisplayContextKombi(9);
                break;
            }
            case 11: {
                if (abstractMap == null) break;
                abstractMap.getActiveContext().switchDisplayContextKombi(11);
                break;
            }
            case 10: 
            case 12: {
                if (abstractMap != null && abstractMap.isInitialized()) {
                    abstractMap.getActiveContext().switchDisplayContextKombi(n);
                    break;
                }
                if (Util.isClusterMapAvailable(this.env.getFramework())) {
                    this.mLogChannel.log(10000, "MapInterface#switchDisplayContextKombi() - Kombi map not initialized!");
                    break;
                }
                this.mLogChannel.log(100000, "MapInterface#switchDisplayContextKombi() - Kombi map not available!");
                break;
            }
            case 8: {
                if (abstractMap != null && abstractMap.isInitialized()) {
                    abstractMap.getActiveContext().switchDisplayContextKombi(8);
                    break;
                }
                if (Util.isClusterMapAvailable(this.env.getFramework())) {
                    this.mLogChannel.log(10000, "MapInterface#switchDisplayContextKombi() - Kombi map not initialized!");
                    break;
                }
                this.mLogChannel.log(100000, "MapInterface#switchDisplayContextKombi() - Kombi map not available!");
                break;
            }
            default: {
                this.mLogChannel.log(10000, "MapInterface#switchDisplayContextKombi() - Unknown context: %1!", (long)n);
            }
        }
    }

    public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider iVehicleStatesEventsProvider) {
        iVehicleStatesEventsProvider.registerListener(this);
    }

    public void updateTankInfo(TankInfo tankInfo) {
    }

    public void updateVehicleStandstill(boolean bl) {
    }

    public void updateESPData() {
    }

    public void sdsSessionAborted() {
        this.setSDSDialogActive(false);
        this.naviMap.getNaviInterface().sdsSessionAborted();
    }

    public void sdsDialogStarted() {
        this.setSDSDialogActive(true);
        this.naviMap.getNaviInterface().sdsDialogStarted();
    }

    public void sdsDialogAborting() {
        this.naviMap.getNaviInterface().sdsDialogAborting();
    }

    public void sdsDialogEnded() {
        this.setSDSDialogActive(false);
        this.naviMap.getNaviInterface().sdsDialogEnded();
    }

    public boolean toggleTMC() {
        this.mLogChannel.log(10000000, "MapInterface#toggleTMC()");
        return this.naviMap.getMapDataContainer().sMapContentList.toggleTMC();
    }

    public void destOptShowInMap(NavLocation navLocation) {
        this.destOptShowInMap(navLocation, false, false);
    }

    public void destOptShowInMap(NavLocation navLocation, boolean bl, boolean bl2) {
        this.destOptShowInMap(navLocation, bl, null, bl2);
    }

    public void destOptShowInMap(NavLocation navLocation, boolean bl, IFavorite iFavorite, boolean bl2) {
        this.mLogChannel.log(10000000, "MapInterface#destOptShowInMap( %1, %2, %3 )", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)bl, (Object)iFavorite);
        this.naviMap.show(1);
        this.naviMap.getActiveContext().setEnterInMapLocation(navLocation, false, bl, iFavorite, bl2);
        this.naviMap.forceSwitchToContext(13, SwitchContextEnum.ShowInMap);
    }

    public void destOptShowInMapPAG(NavLocation navLocation, boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#destOptShowInMapPAG( %1, %2 )", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)bl);
        if (navLocation != null) {
            this.naviMap.getActiveContext().setEnterInMapLocation(navLocation, false, bl, null, false);
        }
        this.naviMap.forceSwitchToContext(13, SwitchContextEnum.ShowInMap);
    }

    public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
        this.mLogChannel.log(10000000, "MapInterface#setLocationInMapForOperatorCall() - location: %1", (Object)navLocationWgs84);
        this.naviMap.getActiveContext().setOperatorCallResultLocation(navLocationWgs84);
    }

    public void enterOperatorCallMapScreen() {
        this.mLogChannel.log(10000000, "MapInterface#enterOperatorCallMapScreen()");
        this.env.getChoiceModel(401393).setValue(1);
        this.naviMap.show(8);
        this.naviMap.switchToContext(37);
    }

    public void exitOperatorCallMapScreen() {
        this.mLogChannel.log(10000000, "MapInterface#exitOperatorCallMapScreen()");
        this.naviMap.switchToContext(3);
    }

    public void setHomeAddress(NavLocation navLocation) {
        this.mLogChannel.log(10000000, "MapInterface#setHomeAddress( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.mapManager.setHomeAddress(navLocation);
    }

    public void setOfficeAddress(NavLocation navLocation) {
        this.mLogChannel.log(10000000, "MapInterface#setOfficeAddress( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.mapManager.setOfficeAddress(navLocation);
    }

    public boolean enterRubberband(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#enterRubberband( %1 )", bl);
        if (!Util.isRubberbandAvailable(this.env) || this.env.getChoiceModel(402312).getValue() == 1) {
            this.mLogChannel.log(100000, "MapInterface#enterRubberband() - Rubberband is not available");
            return false;
        }
        if (bl) {
            this.naviMap.switchToContext(34);
        }
        this.naviMap.show(4);
        return true;
    }

    public void clearLastContextCrosshair() {
        this.getMap().getCtxTimeline().clearIntention();
    }

    public void prepareStartRouteCalculation(boolean bl, NavLocation navLocation) {
        this.mLogChannel.log(10000000, "MapInterface#prepareStartRouteCalculation( isSingle = %1 )", bl);
        this.getPreviewMap().setPreviewMapNone(0);
        this.mapManager.getRouteCalculationHandler().onStartRouteCalculation(bl, true, navLocation);
        this.env.getChoiceModel(401582).setValue(0);
    }

    public void setRouteCalculationToSingelRoute(boolean bl) {
        this.mapManager.getRouteCalculationHandler().setIsSingleRoute(bl);
    }

    public void cancelStartRouteCalculation() {
        this.mLogChannel.log(10000000, "MapInterface#cancelStartRouteCalculation()");
        this.mapManager.getRouteCalculationHandler().cleanup();
        this.naviMap.switchToAShownContext();
    }

    public void setConnectivityNaviStateListener(IConnectivityNaviStateListener iConnectivityNaviStateListener) {
        this.mLogChannel.log(1000000, "MapInterface#setConnectivityNaviStateListener( %1 )", (Object)iConnectivityNaviStateListener);
        this.mapManager.setConnectivityNaviStateListener(iConnectivityNaviStateListener);
    }

    public void onlineStateChanged() {
        this.mLogChannel.log(1000000, "MapInterface#onlineStateChanged()");
        this.mapManager.getSatelliteMapsMediator().resetEnterMapState();
        this.env.getChoiceModel(401554).setValue(0);
        int n = this.env.getChoiceModel(401559).getValue();
        this.env.getChoiceModel(401559).setValue(n == 0 ? 1 : 0);
    }

    public void onlineErrorShown() {
        this.mLogChannel.log(1000000, "MapInterface#onlineErrorShown()");
        this.env.getChoiceModel(401554).setValue(1);
    }

    public void updateOnlineConnectionState(boolean bl) {
        this.mLogChannel.log(1000000, "MapInterface#updateOnlineConnectionState() - online: %1", bl);
        Iterator iterator = this.connectionStateListeners.iterator();
        while (iterator.hasNext()) {
            try {
                IOnlineConnectionStateListener iOnlineConnectionStateListener = (IOnlineConnectionStateListener)iterator.next();
                iOnlineConnectionStateListener.updateOnlineConnectionState(bl);
            }
            catch (Exception exception) {
                this.mLogChannel.log(1000000, "MapInterface#updateOnlineConnectionState() - ERROR=%1", (Throwable)exception);
            }
        }
        try {
            this.naviMap.getNaviInterface().getClusterService().updateOnlineConnectionState(bl);
        }
        catch (Exception exception) {
            this.mLogChannel.log(1000000, "MapInterface#updateOnlineConnectionState() - ERROR=%1", (Throwable)exception);
        }
    }

    public void addOnlineConnectionStateListener(IOnlineConnectionStateListener iOnlineConnectionStateListener) {
        this.connectionStateListeners.add(iOnlineConnectionStateListener);
    }

    public void setMapServiceListener(MapServiceListener mapServiceListener) {
        this.mLogChannel.log(1000000, "MapInterface#setMapServiceListener( %1 )", (Object)mapServiceListener);
        this.mapManager.setMapServiceListener(mapServiceListener);
    }

    public void setOnlineMapDataConnectionLicenseStatus(boolean bl, boolean bl2) {
        this.mLogChannel.log(1000000, "MapInterface#setOnlineMapDataConnectionLicenseStatus() - dataConnectionStatus: %1, licenseStatus: %2", bl, bl2);
        if (this.naviMap.getSetup().getMapRepresentation() != 1) {
            this.mLogChannel.log(10000000, "MapInterface#setOnlineMapDataConnectionLicenseStatus() - Google Earth not enabled in settings");
            return;
        }
        boolean bl3 = this.validateGELicenseState(bl2);
        this.mapManager.getSatelliteMapsMediator().onEnterOnlineMap(bl3);
        if (bl3) {
            this.onlineMapEntered();
        }
    }

    public boolean validateGELicenseState(boolean bl) {
        boolean bl2;
        int n = this.env.getChoiceModel(402127).getStatus();
        boolean bl3 = bl2 = bl && (n == 1 || n == 5 || n == 8);
        if (bl && !bl2) {
            this.mLogChannel.log(100000, "MapInterface#validateGELicenseState() - Google Earth license not valid! (geLicenseState: %1)", (long)n);
        }
        return bl2;
    }

    public void setGELicenseService(IOnlineService iOnlineService) {
        boolean bl = Util.isGoogleEarthPresent(this.env.getFramework());
        this.mLogChannel.log(1000000, "MapInterface#setGELicenseService() - google earth present: %1", bl);
        if (bl) {
            this.mapManager.getGoogleMapLicenseHandler().setService(iOnlineService);
        }
    }

    public void setWeatherLicenseService(IOnlineService iOnlineService) {
        this.mLogChannel.log(1000000, "MapInterface#setWeatherLicenseService() - service: %1", (Object)iOnlineService);
        this.mapManager.getWeatherLicenseHandler().setService(iOnlineService);
    }

    public WeatherLicenseHandler getWeatherLicenseHandler() {
        return this.mapManager.getWeatherLicenseHandler();
    }

    public void onShowInMapClicked(NavLocationWgs84 navLocationWgs84) {
        this.naviMap.show(1);
    }

    public void prepareRouteBriefingMap(WaitForMapReadyCommand waitForMapReadyCommand) {
        this.mLogChannel.log(10000000, "MapInterface#prepareRouteBriefingMap()");
        this.naviMap.getRouteCalculationHandler().setMapReadyCallback(waitForMapReadyCommand);
    }

    public void notify(int n) {
        this.mLogChannel.log(10000000, "MapInterface#notify( %1 )", (long)n);
    }

    public void setBackgroundMode(boolean bl, boolean bl2) {
        this.mLogChannel.log(10000000, "MapInterface#setBackgroundMode( backgroundMode = %1, onlyMainMap = %2 )", bl, bl2);
        if (bl2) {
            this.mapManager.getMapMain().getActiveContext().setBackgroundRenderingMode(bl);
        } else {
            AbstractMap[] abstractMapArray = this.mapManager.getMaps();
            for (int i2 = 0; i2 < abstractMapArray.length; ++i2) {
                if (abstractMapArray[i2] == null) continue;
                abstractMapArray[i2].getActiveContext().setBackgroundRenderingMode(bl);
            }
        }
    }

    public IPreviewMap getPreviewMap() {
        return this.mapManager.getPreviewMapHandler();
    }

    public void updateBapManeuverState(int n) {
        this.mLogChannel.log(10000000, "MapInterface#updateBapManeuverState( %1 )", (long)n);
        for (int i2 = 0; i2 < this.mapManager.getMaps().length; ++i2) {
            if (this.mapManager.getMaps()[i2] == null) continue;
            this.mapManager.getMaps()[i2].getActiveContext().updateBapManeuverState(n);
        }
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        this.mLogChannel.log(10000000, "MapInterface#updateBapManeuverDescriptor() - length=%1", bapManeuverDescriptorArray == null ? -1L : (long)bapManeuverDescriptorArray.length);
        for (int i2 = 0; i2 < this.mapManager.getMaps().length; ++i2) {
            if (this.mapManager.getMaps()[i2] == null) continue;
            this.mapManager.getMaps()[i2].getActiveContext().updateBapManeuverDescriptor(bapManeuverDescriptorArray);
        }
    }

    public IMobilityHorizonHandler getMobilityHorizonHandler() {
        return this.mapManager.getMobilityHorizonHandler();
    }

    public void notifyPowerListenerOnExitState() {
        this.mLogChannel.log(10000000, "MapInterface#notifyPowerListenerOnExitState()");
        this.mapManager.getMapMain().getActiveContext().setRangeMapDefaultZoomLevel();
    }

    public void hkBackPressed() {
        if (this.mapManager.getMapMain() != null) {
            this.mapManager.stopRRD();
            this.mapManager.getMapMain().getActiveContext().hkBackPressed();
        }
    }

    public void enterMapOptionsDrawer() {
        this.mLogChannel.log(10000000, "MapInterface#enterMapOptionsDrawer()");
    }

    public void exitMapOptionsDrawer() {
        this.mLogChannel.log(10000000, "MapInterface#exitMapOptionsDrawer()");
    }

    public void indicateVICSEmergencyPopupShown(boolean bl) {
        this.mLogChannel.log(10000000, "MapInterface#indicateVICSEmergencyPopupShown( %1 )", bl);
        this.naviMap.getMapDataContainer().vicsEmergencyPopupShown = bl;
    }

    public void showLocFromDest(NavLocation navLocation, int n) {
        this.mLogChannel.log(10000000, "MapInterface#showLocFromDest(%1)", (long)n);
        this.naviMap.showLocInMainMap(navLocation, n);
    }

    public void showTMCFromDest(TmcMessage tmcMessage) {
        this.mLogChannel.log(10000000, "MapInterface#showTMCFromDest(  )");
        this.naviMap.showTMCInMainMap(tmcMessage);
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

