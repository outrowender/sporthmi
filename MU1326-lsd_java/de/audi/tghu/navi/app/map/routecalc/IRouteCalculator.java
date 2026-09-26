/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$RouteCalculationListener;
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
    public static final int BETTER_ROUTE_INCONSISTENT;
    public static final int BETTER_ROUTE_NONE;
    public static final int BETTER_ROUTE_AVAILABLE;
    public static final int BETTER_ROUTE_DEFINITIVE_BETTER;
    public static final int BETTER_ROUTE_DUE_TO_BLOCKING;
    public static final int BETTER_ROUTE_UPDATE_RCCI_SIDEBAR;
    public static final int BETTER_ROUTE_NOT_RECOMMENDED;
    public static final int BETTER_ROUTE_ANOTHER_AVAILABLE;
    public static final int BETTER_ROUTE_ANOTHER_DEFINITIVE_BETTER;
    public static final int BETTER_ROUTE_ANOTHER_DUE_TO_BLOCKING;
    public static final int BETTER_ROUTE_SELECTED;
    public static final String[] sBetterRoute;
    public static final int STATE_IDLE;
    public static final int STATE_CALCULATING_SINGLE;
    public static final int STATE_CALCULATING_FURTHER_ALTERNATIVE;
    public static final int STATE_CALCULATING_RUBBERBAND;
    public static final int STATE_CALCULATING_ALTERNATIVE;
    public static final int STATE_CALCULATING_ALTERNATIVE_NEW;
    public static final int STATE_CALCULATING_BASE_ROUTE_AFTER_RUBBERBAND;
    public static final int STATE_RG_ACTIVATED;
    public static final int STATE_WAIT_FOR_ACTIVATION;
    public static final int STATE_BETTER_ROUTE_AVAILABLE;
    public static final int STATE_CALCULATING_FURTHER_ALTERNATIVE_ASIA;
    public static final int STATE_RESTART_AFTER_ALT_ROUTES;
    public static final int STATE_CALCULATING_SINGLE_OFFROAD;
    public static final int STATE_COUNT;
    public static final long THRESHOLD_DEFINITIVE_BETTER;

    default public void cleanup() {
    }

    default public void restartTimerIfCalculationStateIsReady() {
    }

    default public void cancelTimer() {
    }

    default public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
    }

    default public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    default public boolean isMatchingRoutesFound() {
    }

    default public boolean startRG(int n) {
    }

    default public boolean gotoRestartAfterAltRoutesCancelled(int n) {
    }

    default public void startRGByUID(NavSegmentID navSegmentID) {
    }

    default public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void enableTimer(boolean bl) {
    }

    default public CalculatedRouteListElement[] getCalculatedRouteListElement() {
    }

    default public void updateRgRouteCalculationState(int n) {
    }

    default public int getRgRouteCalculationState() {
    }

    default public boolean isRouteCalculationNotIdle() {
    }

    default public boolean isRouteCalculationActive() {
    }

    default public boolean isCalculatingSingleRoute() {
    }

    default public boolean isCalculatingAltRoutes() {
    }

    default public void abortRouteCalculation(boolean bl) {
    }

    default public void setSelectedRouteIndex(int n) {
    }

    default public int getSelectedRouteIndex() {
    }

    default public void setRouteCalculationListener(IRouteCalculator$RouteCalculationListener iRouteCalculator$RouteCalculationListener) {
    }

    default public void removeRouteCalculationListener(IRouteCalculator$RouteCalculationListener iRouteCalculator$RouteCalculationListener) {
    }

    default public boolean isRubberbandReady() {
    }

    default public Route getRoute() {
    }

    default public NavLocation getDestination() {
    }

    default public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    default public RgRouteCostChangeInformation getRgRCCI() {
    }

    default public boolean isWaitingForAlternativRoutes() {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    default public boolean isRgInfoForNexDestinationReceived() {
    }

    default public boolean isRGAboutToBeStarted() {
    }

    default public boolean isSingleRoute() {
    }

    default public boolean isCalculatingRubberband() {
    }

    default public void startRGByUID(int n) {
    }

    default public void onStartRouteCalculation(boolean bl, boolean bl2, NavLocation navLocation) {
    }

    default public void calculateAlternativeRoutes() {
    }

    default public void switchToSemidynamic(int n) {
    }

    default public int getSemidynRouteState() {
    }

    default public boolean isBetterRouteIgnored() {
    }

    default public void reset() {
    }

    default public boolean hasBetterRoute() {
    }

    default public int getSavingTime() {
    }

    default public void selectRoute(int n, boolean bl) {
    }

    default public void setWaitForAvailableRoute(boolean bl) {
    }

    default public boolean getWaitForAvailableRoute() {
    }

    default public int getCountOfMatchRoute(int n) {
    }

    default public boolean isCalculationFinished() {
    }

    default public boolean isAutoStartRGAndSwitchEnabled() {
    }

    default public long getTrafficDelayOnCurrentRoute() {
    }

    default public void setCalcFurtherAltRoutes(boolean bl) {
    }

    default public boolean isCalcFurtherAltRoutes() {
    }

    default public RcciEvent getRcciEvent() {
    }

    default public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    default public void setMapReadyCallback(WaitForMapReadyCommand waitForMapReadyCommand) {
    }

    default public void notifyMapUnfrozen() {
    }

    default public void prepareRubberband(boolean bl, int n) {
    }

    default public void startRubberband(int n) {
    }

    default public void initRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
    }

    default public void startRubberbandRG() {
    }

    default public void cancel() {
    }

    default public NavLocationWgs84 getRubberbandPoint() {
    }

    default public void setRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
    }

    default public int getRubberbandState() {
    }

    default public boolean isBaseRouteReconstructable() {
    }

    default public boolean isRubberbandActive() {
    }

    default public void setRubberbandActive(boolean bl) {
    }

    default public void rgStartRubberbandManipulationResult(int n) {
    }

    default public RouteOptions[] getRouteOptionsUsedForCalculation() {
    }

    default public void setNewRouteVanished(boolean bl) {
    }

    default public void setIsSingleRoute(boolean bl) {
    }

    default public void updateRGCurrentRouteOptions(RouteOptions routeOptions) {
    }

    static {
        sBetterRoute = new String[]{"INCONSISTENT", "NONE", "AVAILABLE", "DEFINITIVE_BETTER", "DUE_TO_BLOCKING", "UPDATE_RCCI_SIDEBAR", "NOT_RECOMMENDED", "ANOTHER_AVAILABLE", "ANOTHER_DEFINITIVE_BETTER", "ANOTHER_DUE_TO_BLOCKING", "SELECTED"};
    }
}

