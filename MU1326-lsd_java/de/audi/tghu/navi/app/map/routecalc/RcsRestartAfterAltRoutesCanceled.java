/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RcsRestartAfterAltRoutesCanceled
extends RcsBase {
    private boolean rgActive;
    int lastSelectedIndex;
    boolean guidanceStarted = false;

    RcsRestartAfterAltRoutesCanceled(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsRestartAfterAltRoutesCanceled");
    }

    @Override
    public void enter() {
        this.lastSelectedIndex = this.getStateMachine().naviMap.getLastSelectedRouteIndex();
        this.getLogger().log(1078071040, "RcsRestartAfterAltRoutesCanceled#enter() lastSelectedIndex  %1", (long)this.lastSelectedIndex);
        this.match(this.getData().mCalculatedRouteListElement);
    }

    private final void match(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        if (this.isCalulatedRoutesValid(calculatedRouteListElementArray)) {
            this.getLogger().log(-2137614336, "RcsRestartAfterAltRoutesCanceled#match(): checking if any calculated route is matching any visible route");
            NavSegmentID navSegmentID = null;
            for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                CalculatedRouteListElement calculatedRouteListElement = calculatedRouteListElementArray[i2];
                if (calculatedRouteListElement != null && MapUtils.isCRLElementCalculated(calculatedRouteListElement)) {
                    navSegmentID = calculatedRouteListElementArray[i2].getSegmentIDList();
                    if (i2 == this.lastSelectedIndex) {
                        this.handleMatchFound();
                    }
                } else {
                    navSegmentID = null;
                }
                if (navSegmentID != null) continue;
                this.getLogger().log(-1601830656, "RcsRestartAfterAltRoutesCanceled#match(): no segment ID list found!");
                break;
            }
        } else {
            this.getLogger().log(-2137614336, "RcsRestartAfterAltRoutesCanceled#match() no available route");
        }
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (2 == n && !this.guidanceStarted) {
            this.getLogger().log(10000, "RcsRestartAfterAltRoutesCanceled#updateRgRouteCalculationState( ) - Recievded ROUTECALCULATIONSTATE_READY but guidance was not started");
            this.getStateMachine().goTo(0);
        }
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        super.updateRgCalculatedRoutes(calculatedRouteListElementArray);
        this.match(calculatedRouteListElementArray);
    }

    protected void checkFinish() {
        this.getLogger().log(1078071040, "RcsRestartAfterAltRoutesCanceled#checkFinish( ) - matchFound %1", this.rgActive);
        if (this.rgActive) {
            this.refocusAndgotoRGActivated();
        }
    }

    private void refocusAndgotoRGActivated() {
        int n = this.getStateMachine().naviMap.getActiveNaviOrMapContext();
        int n2 = this.getStateMachine().naviMap.getActiveTab();
        this.getLogger().log(-1601830656, "RcsRestartAfterAltRoutesCanceled#refocusAndgotoRGActivated( ) - activeTabs context %1 tab %2", (long)n, (long)n2);
        if ((n == 1 || n == 0) && n2 == 2) {
            this.getLogger().log(-1601830656, "RcsRestartAfterAltRoutesCanceled#refocusAndgotoRGActivated( ) - Refocus preview map");
            this.getStateMachine().naviMap.getPreviewMapHandler().setPreviewRoute(true, true, 6, null, null);
        } else if (n == 1 && n2 == 0) {
            this.getLogger().log(-1601830656, "RcsRestartAfterAltRoutesCanceled#refocusAndgotoRGActivated( ) - switch to a shown context");
            this.getStateMachine().naviMap.switchToAShownContext();
        }
        this.getStateMachine().goTo(7);
    }

    private void handleMatchFound() {
        this.getLogger().log(-1601830656, "RcsRestartAfterAltRoutesCanceled#handleMatchFound start guidance with index %1", (long)this.lastSelectedIndex);
        this.getStateMachine().dorestartAfterAltRoutesCancelled(this.lastSelectedIndex);
        this.guidanceStarted = true;
        this.checkFinish();
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.rgActive = bl;
        this.getLogger().log(-1601830656, "RcsRestartAfterAltRoutesCanceled#updateRgActive() %1", this.rgActive);
        this.checkFinish();
    }

    @Override
    public void exit() {
        this.rgActive = false;
        this.lastSelectedIndex = 0;
    }

    @Override
    public int getValue4Model() {
        return 7;
    }
}

