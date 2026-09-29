/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxRouteBase;
import de.audi.tghu.navi.app.map.context.CtxRouteBriefing$1;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$RouteCalculationListener;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class CtxRouteBriefing
extends CtxRouteBase
implements IRouteCalculator$RouteCalculationListener {
    protected Timer screenSwitchDelayer = new Timer("", 0, true, new CtxRouteBriefing$1(this));
    private static final int SCREEN_SWITCH_DELAY;
    private boolean largeViewRequested = false;

    public CtxRouteBriefing(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        this.getLogChannel().log(-2137614336, "CtxRouteBriefing#enter()");
        if (this.getMap().getLastVisibleCID() != 30) {
            super.enter();
        } else {
            Rect rect = this.getVisibleArea();
            IMapRequest iMapRequest = this.getMap().getMVRequest();
            iMapRequest.setHotPoint(new Point(rect.kordX + (rect.diffX >> 1), rect.kordY + (rect.diffY >> 1)));
            iMapRequest.showTMCMessages(this.getSetupTMCSymbols());
            this.refreshRouteOptions();
            this.switchMobilityHorizonAccordingToSetup();
            this.getMap().getMapManager().getPreviewMapHandler().resetEventVisibilities(true, true);
        }
        this.setVisibleArea();
        this.initViewPort();
        this.enterCheckReentryOfCtxRouteBriefing();
        this.getMap().getRouteCalculationHandler().setRouteCalculationListener(this);
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
        this.refreshPins();
    }

    private void enterCheckReentryOfCtxRouteBriefing() {
        this.checkReadyToInitiateScreenSwitch();
    }

    @Override
    public void exit() {
        super.exit();
        this.cancelScreenSwitchDelayer();
        this.getMap().getRouteCalculationHandler().removeRouteCalculationListener(this);
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
    }

    @Override
    public void switchToMap() {
        this.getLogChannel().log(-2137614336, "CtxRouteBriefing#switchToMap()");
        this.doSwitch();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doSwitch() {
        Object object = this.container.switchToMapMutex;
        synchronized (object) {
            if (this.naviMap.getRouteCalculationHandler().isMatchingRoutesFound()) {
                if (this.naviMap.getRouteCalculationHandler().isCalculatingAltRoutes() || this.naviMap.getRouteCalculationHandler().isWaitingForAlternativRoutes()) {
                    this.getLogChannel().log(1078071040, "CtxRouteBriefing#doSwitch(): match found, switching to alt routes");
                    this.naviMap.switchToContext(5);
                } else if (this.naviMap.getRouteCalculationHandler().isCalculatingRubberband()) {
                    this.getLogChannel().log(1078071040, "CtxRouteBriefing#doSwitch(): match found, switching to rubberband");
                    this.naviMap.switchToContext(34);
                } else {
                    this.getLogChannel().log(1078071040, "CtxRouteBriefing#doSwitch(): match found, switching to single route");
                    if (MapEnv.leaveRouteBriefingScreenAutomatically()) {
                        this.restartScreenSwitchDelayer();
                    } else {
                        this.getLogChannel().log(1078071040, "CtxRouteBriefing#doSwitch(): match found, but we stay at this context.");
                    }
                }
            } else {
                this.getLogChannel().log(1078071040, "CtxRouteBriefing#doSwitch(): TIMEOUT, switching to single route");
                this.naviMap.getRouteCalculationHandler().abortRouteCalculation(false);
            }
        }
    }

    @Override
    public void onMatchFound() {
        this.getLogChannel().log(-2137614336, "CtxRouteBriefing#onMatchFound()");
        this.restartScreenSwitchDelayer();
    }

    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
        if (availableRouteArray != null && availableRouteArray.length > 0) {
            this.getLogChannel().log(-2137614336, "CtxRouteBriefing#updateAvailableRoutes()");
            if (Util.isHURegionAsia()) {
                this.getMap().getMVRequest().setMode(10);
            } else {
                this.getMap().getMVRequest().setMode(6);
            }
        }
    }

    @Override
    protected int getMapMode() {
        return 2;
    }

    @Override
    protected void refreshSidebarData() {
    }

    @Override
    public void viewSizeChanged(int n) {
        if (n == 1) {
            this.getLogChannel().log(1078071040, "CtxRouteBriefing#viewSizeChanged( ) - view size changed, leave this context (don't wait available route) and start RG");
            this.leaveBriefingScreen();
        }
    }

    protected void leaveBriefingScreen() {
        this.getMap().getRouteCalculationHandler().setWaitForAvailableRoute(false);
        this.getMap().getRouteCalculationHandler().startRG(0);
        this.getMap().switchToAShownContext();
    }

    @Override
    public void onAllMatchFound(int n) {
        this.getLogChannel().log(14808325, "CtxRouteBriefing#onAllMatchFound( %1 )", (long)n);
        this.restartScreenSwitchDelayer();
    }

    @Override
    public void keyPressed(int n, int n2) {
        if (n == -904002048) {
            this.getLogChannel().log(1078071040, "CtxRouteBriefing#keyPressed( %1, %2 ) - HK_Back event", (long)n, (long)n2);
            this.onHKBackClicked();
        } else if (n == 1897989632) {
            this.getLogChannel().log(1078071040, "CtxRouteBriefing#keyPressed( %1, %2 ) - DDS_Enter event", (long)n, (long)n2);
            this.getGUI().fireModelEvent(n);
            this.onDDSClicked();
        } else {
            super.keyPressed(n, n2);
        }
    }

    @Override
    protected void onHKBackClicked() {
        this.getLogChannel().log(1078071040, "CtxRouteBriefing#onHKBackClicked()");
        this.getMap().getRouteCalculationHandler().abortRouteCalculation(false);
        this.getGUI().fireHKBackEvent();
    }

    public void checkReadyToInitiateScreenSwitch() {
        boolean bl = this.screenSwitchDelayer.isRunning();
        if (this.isReadyToInitiateScreenSwitch()) {
            if (!bl) {
                this.getLogChannel().log(1078071040, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() restartScreenSwitchDelayer");
                this.restartScreenSwitchDelayer();
            } else {
                this.getLogChannel().log(1078071040, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() screen switch delayer already running");
            }
        } else if (bl) {
            this.getLogChannel().log(1078071040, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() - not all conditions fulfilled and timer running - cancelScreenSwitchDelayer");
            this.cancelScreenSwitchDelayer();
        } else {
            this.getLogChannel().log(1078071040, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() - not all conditions fulfilled and timer not running");
        }
    }

    protected boolean isReadyToInitiateScreenSwitch() {
        return !this.getMap().getRouteCalculationHandler().isRouteCalculationActive() || this.getMap().getRouteCalculationHandler().isMatchingRoutesFound();
    }

    @Override
    protected void restartScreenSwitchDelayer() {
        this.getLogChannel().log(-2137614336, "CtxRouteBriefing#restartScreenSwitchDelayer()");
        this.screenSwitchDelayer.restart();
    }

    @Override
    protected void cancelScreenSwitchDelayer() {
        this.getLogChannel().log(-2137614336, "CtxRouteBriefing#cancelScreenSwitchDelayer()");
        this.screenSwitchDelayer.cancel();
    }

    @Override
    public void onFailedCalculation() {
        this.getLogChannel().log(-2137614336, "CtxRouteBriefing#onFailedCalculation()");
        this.restartScreenSwitchDelayer();
    }

    @Override
    protected void onDDSClicked() {
        this.getLogChannel().log(1078071040, "CtxRouteBriefing#onDDSClicked()");
        this.leaveBriefingScreen();
    }

    @Override
    public void incrementGesture(int n) {
    }

    @Override
    public void displayCurrentRoute() {
    }

    static /* synthetic */ LogChannel access$000(CtxRouteBriefing ctxRouteBriefing) {
        return ctxRouteBriefing.getLogChannel();
    }

    static /* synthetic */ AbstractMap access$100(CtxRouteBriefing ctxRouteBriefing) {
        return ctxRouteBriefing.getMap();
    }
}

