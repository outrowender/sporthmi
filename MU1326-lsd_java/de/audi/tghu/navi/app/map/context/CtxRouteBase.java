/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IsViewSizeDepended;
import de.audi.tghu.navi.app.map.context.CTags$HasZoomArea;
import de.audi.tghu.navi.app.map.context.CtxRouteBase$1;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;

public abstract class CtxRouteBase
extends CtxShown
implements IsViewSizeDepended,
CTags$HasZoomArea {
    CtxRouteBase(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        if (this.container.sRefreshETATimer == null) {
            this.container.sRefreshETATimer = new Timer("RefreshETATimer", 0, false, new CtxRouteBase$1(this));
        }
    }

    @Override
    public synchronized void cleanup() {
        super.cleanup();
        this.getRefreshETATimer().cancel();
    }

    private Timer getRefreshETATimer() {
        return this.container.sRefreshETATimer;
    }

    @Override
    public void enter() {
        super.enter();
        this.shutdownAdditionalInfos();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        Rect rect = this.getVisibleArea();
        this.setHotPoint(rect.kordX + (rect.diffX >> 1), rect.kordY + (rect.diffY >> 1));
        this.getZoomHandler().setZoomArea(rect);
        iMapRequest.setViewType(0);
        iMapRequest.setMode(this.getMapMode());
        iMapRequest.setOrientation(2);
        this.initViewPort();
        this.displayCurrentRoute();
        this.refreshRouteOptions();
        this.refreshSidebarData();
        this.getRefreshETATimer().restart();
        this.getData().switchBackToCalculation = true;
    }

    @Override
    protected abstract int getMapMode() {
    }

    @Override
    public void exit() {
        super.exit();
        this.getRefreshETATimer().cancel();
    }

    @Override
    public void displayCurrentRoute() {
        int n = this.naviMap.getRouteCalculationHandler().getSelectedRouteIndex();
        this.naviMap.getMVRequest().rbSelectAlternativeRoute(n);
    }

    public void refreshRouteOptions() {
        int n = this.naviMap.getRouteCalculationHandler().getSelectedRouteIndex();
        try {
            Object object;
            CalculatedRouteListElement calculatedRouteListElement = null;
            CalculatedRouteListElement[] calculatedRouteListElementArray = this.getMap().getRouteCalculationHandler().getCalculatedRouteListElement();
            if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > n) {
                calculatedRouteListElement = calculatedRouteListElementArray[n];
            }
            int n2 = 2;
            RouteOptions routeOptions = null;
            if (this.getMap().getRouteCalculationHandler().getRoute() != null) {
                object = this.getMap().getRouteCalculationHandler().getRoute().getRoutelist();
                routeOptions = object[0].getRouteOptions()[n];
            } else {
                routeOptions = this.getMap().getNaviInterface().getRouteCriteria().getRouteOptions(true)[0];
            }
            object = new Buffer().append("dynamic=").append(routeOptions.dynamic);
            if (calculatedRouteListElement != null) {
                ((Buffer)object).append(", has ferry=").append(calculatedRouteListElement.hasFerry).append(", has cartrain=").append(calculatedRouteListElement.hasCarTrain).append(", has vignette=").append(calculatedRouteListElement.needsVignette).append(", has tollLength=").append(calculatedRouteListElement.tollLength).append(", has seasonalTimeDomain=").append(calculatedRouteListElement.isSeasonalRestricted).append(", has tollCostAmount = ").append(calculatedRouteListElement.tollCostAmount);
                if (calculatedRouteListElement.additionalRouteDataValues != null && calculatedRouteListElement.additionalRouteDataValues.length > 0) {
                    ((Buffer)object).append(", additionalRouteDataValues = [");
                    for (int i2 = 0; i2 < calculatedRouteListElement.additionalRouteDataValues.length; ++i2) {
                        ((Buffer)object).append(calculatedRouteListElement.additionalRouteDataValues[i2]);
                        if (i2 == calculatedRouteListElement.additionalRouteDataValues.length - 1) continue;
                        ((Buffer)object).append(", ");
                    }
                    ((Buffer)object).append(" ] ");
                }
            }
            ((Buffer)object).append(", motorways=").append(routeOptions.motorways).append(", timeDomain=").append(routeOptions.timeDomain);
            this.getLogChannel().log(-2137614336, "CtxRouteBase#refreshRouteOptions() - %1", (Object)((Buffer)object).toString());
            switch (routeOptions.dynamic) {
                case 6: {
                    n2 = 0;
                    break;
                }
                case 10: {
                    n2 = 1;
                    break;
                }
                case 7: {
                    n2 = 2;
                    break;
                }
                default: {
                    this.getLogChannel().log(-1601830656, "CtxRouteBase#refreshRouteOptions() - invalid dynamic : %1", (long)routeOptions.dynamic);
                    n2 = 2;
                }
            }
            this.getGUI().setRouteCriteriaIcons(n2, this.getMap().getNaviInterface().getAeaService().isActive(), calculatedRouteListElement != null ? calculatedRouteListElement.hasFerry : false, calculatedRouteListElement != null ? calculatedRouteListElement.hasCarTrain : false, routeOptions.motorways == 3, calculatedRouteListElement != null ? calculatedRouteListElement.needsVignette : false, calculatedRouteListElement != null ? calculatedRouteListElement.tollLength > 0L : false, routeOptions.timeDomain == 2, calculatedRouteListElement != null ? calculatedRouteListElement.isSeasonalRestricted : false, routeOptions.getHovCarPoolsLane() != 0);
            if (Util.isHURegionJP()) {
                this.getGUI().updateTollInfoJP(calculatedRouteListElement);
            }
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "CtxRouteBase#refreshRouteOptions() - no route option available. %1", (Throwable)exception);
        }
    }

    @Override
    public void refreshRoutes() {
        this.getLogChannel().log(-2137614336, "CtxRouteBase#refreshRoutes()");
        this.displayCurrentRoute();
        this.refreshSidebarData();
        this.refreshRouteOptions();
    }

    @Override
    public void initViewPort() {
        this.getLogChannel().log(-2137614336, "CtxRouteBase#initViewPort()");
        super.initViewPort();
        IRouteCalculator iRouteCalculator = this.getMap().getRouteCalculationHandler();
        if (iRouteCalculator.getRoute() != null && iRouteCalculator.getRoute().getRoutelist() != null) {
            this.initViewport(iRouteCalculator.getRoute().routelist);
        } else if (iRouteCalculator.getDestination() != null) {
            this.initViewport(iRouteCalculator.getDestination());
        }
    }

    protected abstract void refreshSidebarData() {
    }

    @Override
    public void enterMapScreen(int n) {
        this.getLogChannel().log(1078071040, "CtxRouteBase#enterMapScreen()");
    }

    @Override
    public void screenHidden() {
        super.screenHidden();
    }

    @Override
    public void screenVisible() {
        super.screenVisible();
        if (this.getMap().getRouteCalculationHandler().isCalculationFinished()) {
            // empty if block
        }
        if (!this.container.sRGActive && !this.getMap().getRouteCalculationHandler().isRouteCalculationActive()) {
            this.getLogChannel().log(-2137614336, "CtxRouteBase#screenVisible() - RG has been canceled through popop like SDS");
            this.getMap().switchToAShownContext();
        }
    }

    @Override
    public void viewSizeChanged(int n) {
        super.viewSizeChanged(n);
        if (n == 1) {
            this.getLogChannel().log(1078071040, "CtxRouteBase#viewSizeChanged( ) - switch to normal map");
            IRouteCalculator iRouteCalculator = this.getMap().getRouteCalculationHandler();
            if (iRouteCalculator.isCalcFurtherAltRoutes()) {
                iRouteCalculator.startRG(0);
            } else {
                boolean bl = iRouteCalculator.startRG(0);
                if (!bl) {
                    iRouteCalculator.setWaitForAvailableRoute(false);
                }
            }
            this.getData().switchBackToCalculation = false;
            this.getMap().switchToAShownContext();
            this.getMap().getNaviInterface().abortSDSSession();
        }
    }

    protected void initViewport(RouteDestination[] routeDestinationArray) {
        this.getLogChannel().log(-2137614336, "CtxRouteBase#initViewport() - use route list");
        PosPosition posPosition = this.getMap().getNaviInterface().getVehicle().getPosition();
        int n = posPosition.getLatitude();
        int n2 = posPosition.getLatitude();
        int n3 = posPosition.getLongitude();
        int n4 = posPosition.getLongitude();
        this.getLogChannel().log(-2137614336, "CtxRouteBase#initViewport() - [car] lat=%1, long=%2", (long)n, (long)n3);
        for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
            if (null == routeDestinationArray[i2].routeLocation) {
                this.getLogChannel().log(-2137614336, "CtxRouteBase#initViewport() - rds[%1].routeLocation is null", (long)i2);
                continue;
            }
            this.getLogChannel().log(-2137614336, "CtxRouteBase#initViewport() - [%1] lat=%2, long=%3", (long)i2, (long)routeDestinationArray[i2].routeLocation.latitude, (long)routeDestinationArray[i2].routeLocation.longitude);
            n = Math.min(n, routeDestinationArray[i2].routeLocation.latitude);
            n2 = Math.max(n2, routeDestinationArray[i2].routeLocation.latitude);
            n3 = Math.min(n3, routeDestinationArray[i2].routeLocation.longitude);
            n4 = Math.max(n4, routeDestinationArray[i2].routeLocation.longitude);
        }
        NavLocation navLocation = Util.getLocationFromGeoPos(n3, n);
        NavLocation navLocation2 = Util.getLocationFromGeoPos(n4, n2);
        this.naviMap.getMVRequest().setMapViewportByLD(navLocation2, navLocation, this.retrieveZoomListIndex(51266));
    }

    protected void initViewport(NavLocation navLocation) {
        this.getLogChannel().log(-2137614336, "CtxRouteBase#initViewport() - use single destination");
        PosPosition posPosition = this.getMap().getNaviInterface().getVehicle().getPosition();
        NavLocation navLocation2 = Util.getLocationFromGeoPos(posPosition.longitude, posPosition.latitude);
        this.naviMap.getMVRequest().setMapViewportByLD(navLocation2, navLocation, this.retrieveZoomListIndex(51266));
    }

    protected void restartScreenSwitchDelayer() {
        this.getLogChannel().log(-1601830656, "CtxRouteBase#restartScreenSwitchDelayer() - no timer");
    }

    protected void cancelScreenSwitchDelayer() {
        this.getLogChannel().log(-1601830656, "CtxRouteBase#cancelScreenSwitchDelayer() - no timer");
    }

    @Override
    protected void restore() {
    }

    @Override
    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
    }

    @Override
    public void updateRgActive(boolean bl) {
        if (!bl) {
            this.getLogChannel().log(-2137614336, "CtxRouteBase#updateRgActive( false )");
            this.getMap().switchToAShownContext();
        }
        super.updateRgActive(bl);
    }
}

