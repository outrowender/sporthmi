/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxRouteBase;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class CtxRouteBriefing
extends CtxRouteBase
implements IRouteCalculator.RouteCalculationListener {
    protected Timer screenSwitchDelayer = new Timer("", 10000L, true, new DefaultTimerListener(){

        public void fireTimer(Timer timer) {
            CtxRouteBriefing.this.getLogChannel().log(1000000, "CtxRouteBriefing#screenSwitchDelayer#fireTimer() - start RG and switch to shown context");
            CtxRouteBriefing.this.getMap().switchToAShownContext();
        }
    });
    private static final int SCREEN_SWITCH_DELAY = 10000;
    private boolean largeViewRequested = false;

    public CtxRouteBriefing(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        this.getLogChannel().log(10000000, "CtxRouteBriefing#enter()");
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

    public void exit() {
        super.exit();
        this.cancelScreenSwitchDelayer();
        this.getMap().getRouteCalculationHandler().removeRouteCalculationListener(this);
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
    }

    public void switchToMap() {
        this.getLogChannel().log(10000000, "CtxRouteBriefing#switchToMap()");
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
                    this.getLogChannel().log(1000000, "CtxRouteBriefing#doSwitch(): match found, switching to alt routes");
                    this.naviMap.switchToContext(5);
                } else if (this.naviMap.getRouteCalculationHandler().isCalculatingRubberband()) {
                    this.getLogChannel().log(1000000, "CtxRouteBriefing#doSwitch(): match found, switching to rubberband");
                    this.naviMap.switchToContext(34);
                } else {
                    this.getLogChannel().log(1000000, "CtxRouteBriefing#doSwitch(): match found, switching to single route");
                    if (MapEnv.leaveRouteBriefingScreenAutomatically()) {
                        this.restartScreenSwitchDelayer();
                    } else {
                        this.getLogChannel().log(1000000, "CtxRouteBriefing#doSwitch(): match found, but we stay at this context.");
                    }
                }
            } else {
                this.getLogChannel().log(1000000, "CtxRouteBriefing#doSwitch(): TIMEOUT, switching to single route");
                this.naviMap.getRouteCalculationHandler().abortRouteCalculation(false);
            }
        }
    }

    public void onMatchFound() {
        this.getLogChannel().log(10000000, "CtxRouteBriefing#onMatchFound()");
        this.restartScreenSwitchDelayer();
    }

    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
        if (availableRouteArray != null && availableRouteArray.length > 0) {
            this.getLogChannel().log(10000000, "CtxRouteBriefing#updateAvailableRoutes()");
            if (Util.isHURegionAsia()) {
                this.getMap().getMVRequest().setMode(10);
            } else {
                this.getMap().getMVRequest().setMode(6);
            }
        }
    }

    protected int getMapMode() {
        return 2;
    }

    protected void refreshSidebarData() {
    }

    public void viewSizeChanged(int n) {
        if (n == 1) {
            this.getLogChannel().log(1000000, "CtxRouteBriefing#viewSizeChanged( ) - view size changed, leave this context (don't wait available route) and start RG");
            this.leaveBriefingScreen();
        }
    }

    protected void leaveBriefingScreen() {
        this.getMap().getRouteCalculationHandler().setWaitForAvailableRoute(false);
        this.getMap().getRouteCalculationHandler().startRG(0);
        this.getMap().switchToAShownContext();
    }

    public void onAllMatchFound(int n) {
        this.getLogChannel().log(100000000, "CtxRouteBriefing#onAllMatchFound( %1 )", (long)n);
        this.restartScreenSwitchDelayer();
    }

    public void keyPressed(int n, int n2) {
        if (n == 401098) {
            this.getLogChannel().log(1000000, "CtxRouteBriefing#keyPressed( %1, %2 ) - HK_Back event", (long)n, (long)n2);
            this.onHKBackClicked();
        } else if (n == 401777) {
            this.getLogChannel().log(1000000, "CtxRouteBriefing#keyPressed( %1, %2 ) - DDS_Enter event", (long)n, (long)n2);
            this.getGUI().fireModelEvent(n);
            this.onDDSClicked();
        } else {
            super.keyPressed(n, n2);
        }
    }

    protected void onHKBackClicked() {
        this.getLogChannel().log(1000000, "CtxRouteBriefing#onHKBackClicked()");
        this.getMap().getRouteCalculationHandler().abortRouteCalculation(false);
        this.getGUI().fireHKBackEvent();
    }

    public void checkReadyToInitiateScreenSwitch() {
        boolean bl = this.screenSwitchDelayer.isRunning();
        if (this.isReadyToInitiateScreenSwitch()) {
            if (!bl) {
                this.getLogChannel().log(1000000, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() restartScreenSwitchDelayer");
                this.restartScreenSwitchDelayer();
            } else {
                this.getLogChannel().log(1000000, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() screen switch delayer already running");
            }
        } else if (bl) {
            this.getLogChannel().log(1000000, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() - not all conditions fulfilled and timer running - cancelScreenSwitchDelayer");
            this.cancelScreenSwitchDelayer();
        } else {
            this.getLogChannel().log(1000000, "CtxRouteBriefingPCore#screenSwitchDelayer#checkReadyToInitiateScreenSwitch() - not all conditions fulfilled and timer not running");
        }
    }

    protected boolean isReadyToInitiateScreenSwitch() {
        return !this.getMap().getRouteCalculationHandler().isRouteCalculationActive() || this.getMap().getRouteCalculationHandler().isMatchingRoutesFound();
    }

    protected void restartScreenSwitchDelayer() {
        this.getLogChannel().log(10000000, "CtxRouteBriefing#restartScreenSwitchDelayer()");
        this.screenSwitchDelayer.restart();
    }

    protected void cancelScreenSwitchDelayer() {
        this.getLogChannel().log(10000000, "CtxRouteBriefing#cancelScreenSwitchDelayer()");
        this.screenSwitchDelayer.cancel();
    }

    public void onFailedCalculation() {
        this.getLogChannel().log(10000000, "CtxRouteBriefing#onFailedCalculation()");
        this.restartScreenSwitchDelayer();
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(1000000, "CtxRouteBriefing#onDDSClicked()");
        this.leaveBriefingScreen();
    }

    public void incrementGesture(int n) {
    }

    public void displayCurrentRoute() {
    }
}

