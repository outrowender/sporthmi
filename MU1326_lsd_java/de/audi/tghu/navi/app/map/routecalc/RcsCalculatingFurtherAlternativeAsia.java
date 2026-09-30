/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Route;

public class RcsCalculatingFurtherAlternativeAsia
extends RcsCalculatingBase {
    RcsCalculatingFurtherAlternativeAsia(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingFurtherAlternativeAsia");
    }

    public void enter() {
        this.getStateMachine().resetIgnoreBetterRouteFlags();
        this.getData().iBetterRouteState = 1;
        CalculatedRouteListElement[] calculatedRouteListElementArray = new CalculatedRouteListElement[3];
        for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
            calculatedRouteListElementArray[i2] = new CalculatedRouteListElement();
        }
        this.getStateMachine().getEnv().getContainer().setCalculatedRoutes(calculatedRouteListElementArray);
        this.getStateMachine().updateRgCalculatedRoutes(calculatedRouteListElementArray);
        this.getStateMachine().setWaitForAvailableRoute(true);
    }

    protected void onFirstMatchFound() {
        this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#onFirstMatchFound()");
        this.getStateMachine().fireOnMatchFound();
    }

    protected void onAllMatched(int n) {
        this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#onAllMatched( %1 )", (long)n);
        this.getStateMachine().fireOnAllMatchFound(n);
    }

    public void setSelectedRouteIndex(int n) {
        if (0 <= n && n <= 2) {
            this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#setSelectedRouteIndex( %1 )", (long)n);
            this.getData().iRouteIndex = n;
        } else {
            this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#setSelectedRouteIndex( %1 ) - invalid route index", (long)n);
        }
    }

    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#startRouteCalculation()");
        this.getData().currentRoute = route;
        this.getData().sCalculatedRoutesValid = false;
        for (int i2 = 0; i2 < this.getData().sAvailableRoutesValid.length; ++i2) {
            this.getData().sAvailableRoutesValid[i2] = false;
            this.getData().sMatchingRoutesFound[i2] = 0;
        }
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (this.getLogger().isDebug2() && bl) {
            this.getLogger().log(100000000, "RcsCalculatingFurtherAlternativeAsia#updateRgActive( %1 ) - User has selected a route before all routes were calculated", bl);
        }
    }

    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (this.getLogger().isDebug() && n == 2) {
            boolean bl = true;
            for (int i2 = 0; i2 < 3; ++i2) {
                bl = bl && this.getData().sMatchingRoutesFound[i2] > 1;
            }
            if (bl) {
                this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#onMatchFound() - found all the 3 routes");
            }
        }
    }

    public int getValue4Model() {
        return 3;
    }

    public void cancel() {
        this.getLogger().log(10000000, "RcsCalculatingFurtherAlternativeAsia#cancel() - restore previous route");
        this.getStateMachine().abortRouteCalculation(false);
        this.getStateMachine().goTo(0);
        this.getStateMachine().onStartRouteCalculation(true, true, null);
        this.getStateMachine().naviMap.getNaviInterface().getRouteManager().restartRouteGuidance(false, false);
    }
}

