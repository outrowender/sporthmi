/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.dsi.MVRequest;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.gui.ViewFactory;
import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

public interface IRouteCalculator {
    public static final int BETTER_ROUTE_INCONSISTENT = 0;
    public static final int BETTER_ROUTE_NONE = 1;
    public static final int BETTER_ROUTE_AVAILABLE = 2;
    public static final int BETTER_ROUTE_DEFINITIVE_BETTER = 3;
    public static final int BETTER_ROUTE_DUE_TO_BLOCKING = 4;
    public static final int BETTER_ROUTE_UPDATE_RCCI_SIDEBAR = 5;
    public static final int BETTER_ROUTE_NOT_RECOMMENDED = 6;
    public static final int BETTER_ROUTE_ANOTHER_AVAILABLE = 7;
    public static final int BETTER_ROUTE_ANOTHER_DEFINITIVE_BETTER = 8;
    public static final int BETTER_ROUTE_ANOTHER_DUE_TO_BLOCKING = 9;
    public static final int BETTER_ROUTE_SELECTED = 10;
    public static final String[] sBetterRoute = new String[]{"INCONSISTENT", "NONE", "AVAILABLE", "DEFINITIVE_BETTER", "DUE_TO_BLOCKING", "UPDATE_RCCI_SIDEBAR", "NOT_RECOMMENDED", "ANOTHER_AVAILABLE", "ANOTHER_DEFINITIVE_BETTER", "ANOTHER_DUE_TO_BLOCKING", "SELECTED"};
    public static final int STATE_IDLE = 0;
    public static final int STATE_CALCULATING_SINGLE = 1;
    public static final int STATE_CALCULATING_FURTHER_ALTERNATIVE = 2;
    public static final int STATE_CALCULATING_RUBBERBAND = 3;
    public static final int STATE_CALCULATING_ALTERNATIVE = 4;
    public static final int STATE_CALCULATING_ALTERNATIVE_NEW = 5;
    public static final int STATE_CALCULATING_BASE_ROUTE_AFTER_RUBBERBAND = 6;
    public static final int STATE_RG_ACTIVATED = 7;
    public static final int STATE_WAIT_FOR_ACTIVATION = 8;
    public static final int STATE_BETTER_ROUTE_AVAILABLE = 9;
    public static final int STATE_CALCULATING_FURTHER_ALTERNATIVE_ASIA = 10;
    public static final int STATE_RESTART_AFTER_ALT_ROUTES = 11;
    public static final int STATE_CALCULATING_SINGLE_OFFROAD = 12;
    public static final int STATE_COUNT = 13;
    public static final long THRESHOLD_DEFINITIVE_BETTER = 1800000L;

    public void cleanup();

    public void restartTimerIfCalculationStateIsReady();

    public void cancelTimer();

    public void updateAvailableRoutes(AvailableRoute[] var1, int var2);

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] var1);

    public boolean isMatchingRoutesFound();

    public boolean startRG(int var1);

    public boolean gotoRestartAfterAltRoutesCancelled(int var1);

    public void startRGByUID(NavSegmentID var1);

    public void startRouteCalculation(Route var1, int var2, boolean var3, boolean var4, boolean var5);

    public void enableTimer(boolean var1);

    public CalculatedRouteListElement[] getCalculatedRouteListElement();

    public void updateRgRouteCalculationState(int var1);

    public int getRgRouteCalculationState();

    public boolean isRouteCalculationNotIdle();

    public boolean isRouteCalculationActive();

    public boolean isCalculatingSingleRoute();

    public boolean isCalculatingAltRoutes();

    public void abortRouteCalculation(boolean var1);

    public void setSelectedRouteIndex(int var1);

    public int getSelectedRouteIndex();

    public void setRouteCalculationListener(RouteCalculationListener var1);

    public void removeRouteCalculationListener(RouteCalculationListener var1);

    public boolean isRubberbandReady();

    public Route getRoute();

    public NavLocation getDestination();

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation var1);

    public RgRouteCostChangeInformation getRgRCCI();

    public boolean isWaitingForAlternativRoutes();

    public void updateRgActive(boolean var1);

    public void updateRgInfoForNextDestination(RgInfoForNextDestination var1);

    public boolean isRgInfoForNexDestinationReceived();

    public boolean isRGAboutToBeStarted();

    public boolean isSingleRoute();

    public boolean isCalculatingRubberband();

    public void startRGByUID(int var1);

    public void onStartRouteCalculation(boolean var1, boolean var2, NavLocation var3);

    public void calculateAlternativeRoutes();

    public void switchToSemidynamic(int var1);

    public int getSemidynRouteState();

    public boolean isBetterRouteIgnored();

    public void reset();

    public boolean hasBetterRoute();

    public int getSavingTime();

    public void selectRoute(int var1, boolean var2);

    public void setWaitForAvailableRoute(boolean var1);

    public boolean getWaitForAvailableRoute();

    public int getCountOfMatchRoute(int var1);

    public boolean isCalculationFinished();

    public boolean isAutoStartRGAndSwitchEnabled();

    public long getTrafficDelayOnCurrentRoute();

    public void setCalcFurtherAltRoutes(boolean var1);

    public boolean isCalcFurtherAltRoutes();

    public RcciEvent getRcciEvent();

    public void updateRgDestinationInfo(NavRouteListData[] var1);

    public void setMapReadyCallback(WaitForMapReadyCommand var1);

    public void notifyMapUnfrozen();

    public void prepareRubberband(boolean var1, int var2);

    public void startRubberband(int var1);

    public void initRubberbandPoint(NavLocationWgs84 var1);

    public void startRubberbandRG();

    public void cancel();

    public NavLocationWgs84 getRubberbandPoint();

    public void setRubberbandPoint(NavLocationWgs84 var1);

    public int getRubberbandState();

    public boolean isBaseRouteReconstructable();

    public boolean isRubberbandActive();

    public void setRubberbandActive(boolean var1);

    public void rgStartRubberbandManipulationResult(int var1);

    public RouteOptions[] getRouteOptionsUsedForCalculation();

    public void setNewRouteVanished(boolean var1);

    public void setIsSingleRoute(boolean var1);

    public void updateRGCurrentRouteOptions(RouteOptions var1);

    public static interface RbbState {
        public static final int Idle = 0;
        public static final int Preparing = 1;
        public static final int Prepared = 2;
        public static final int Starting = 3;
        public static final int Started = 4;
        public static final int Dragging = 5;
        public static final int Dragged = 6;
        public static final int Confirmed = 7;
        public static final int Canceled = 8;
    }

    public static interface IRouteCalcEnv {
        public void onEvent(int var1);

        public void onFiredRGAutoStartTimer();

        public void switchToAShownContext();

        public ViewFactory getViews();

        public NavigationEnv getNavigationEnv();

        public INaviInterface getNaviInterface();

        public int getActiveContextIndex();

        public IContext getActiveContext();

        public Object getMutexSwitchToContext();

        public void switchToContext(int var1);

        public void switchToContext(int var1, SwitchContextEnum var2);

        public MapDataContainer getMapDataContainer();

        public void showRouteBriefing(int var1);

        public IEventBroker getMapEventDispatcher();

        public MVRequest getMVRequest();

        public IPreviewMap getPreviewMapHandler();

        public int getActiveNaviOrMapContext();

        public int getActiveTab();

        public int getLastSelectedRouteIndex();

        public boolean isInNavigation();

        public ISatelliteMapsManager getSatelliteManager();
    }

    public static interface RouteCalculationListener {
        public void onMatchFound();

        public void onAllMatchFound(int var1);

        public void onFailedCalculation();
    }
}

