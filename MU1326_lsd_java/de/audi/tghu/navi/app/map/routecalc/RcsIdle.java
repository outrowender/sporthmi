/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import org.dsi.ifc.navigation.Route;

class RcsIdle
extends RcsBase {
    RcsIdle(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsIdle");
    }

    public void enter() {
        this.stateMachine.resetIgnoreBetterRouteFlags();
        this.data.iBetterRouteState = 1;
        this.getStateMachine().setWaitForAvailableRoute(true);
    }

    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        this.getLogger().log(10000000, "RcsIdle#startRouteCalculation() - numOfAlt = %1", (long)n);
        if (this.isOffroadTour(route)) {
            this.getData().currentRoute = route;
            if (n == 1) {
                this.goTo(12);
            }
            if (bl) {
                this.stateMachine.prepareMap(n, bl3);
            }
            this.data.sCalculatedRoutesValid = false;
            for (int i2 = 0; i2 < this.data.sAvailableRoutesValid.length; ++i2) {
                this.data.sMatchingRoutesFound[i2] = 0;
            }
        } else {
            int n2;
            this.getData().currentRoute = route;
            this.data.sCalculatedRoutesValid = false;
            for (n2 = 0; n2 < this.data.sAvailableRoutesValid.length; ++n2) {
                this.data.sAvailableRoutesValid[n2] = false;
                this.data.sMatchingRoutesFound[n2] = 0;
            }
            if (n == 0) {
                this.goTo(1);
            } else if (n == 1 && this.getStateMachine().isSingleRoute()) {
                this.goTo(1);
            } else if (n == 3 && !this.getStateMachine().isSingleRoute()) {
                if (MapEnv.useRgCalculate1stRouteAndPostponeRemaining()) {
                    this.goTo(5);
                } else {
                    this.goTo(4);
                }
            } else {
                this.getLogger().log(10000, "RcsIdle#startRouteCalculation() - invalid parameters: numOfAlternatives = %3, waitForAlternativRoutes = %1, isSingleRoute = %2", (Object)Boolean.toString(bl2), (Object)Boolean.toString(this.getStateMachine().isSingleRoute()), (long)n);
                return;
            }
            n2 = n > 1 || !this.getStateMachine().isSingleRoute() ? 1 : 0;
            this.getLogger().log(1000000, "RcsIdle#startRouteCalculation() - prepare map, switch to context %1", n2 != 0 ? 5L : 33L);
            if (bl) {
                this.stateMachine.prepareMap(n, bl3);
            }
        }
    }

    private boolean isOffroadTour(Route route) {
        return route != null && route.routelist.length > 0 && route.routelist[0] != null && route.routelist[0].getRouteOptions() != null && route.routelist[0].routeOptions[0].getRouteType() == 4;
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (bl) {
            if (this.getStateMachine().getLastState() == 3) {
                this.goTo(7);
            } else {
                this.getLogger().log(100000000, "RcsIdle#updateRgActive( true ) - RG has been started via PNAV -> Switch to STATE_RG_ACTIVATED");
                this.goTo(7);
            }
        }
    }

    public void updateRgRouteCalculationState(int n) {
        if (n == 3) {
            this.getLogger().log(10000000, "RcsIdle#updateRgRouteCalculationState( %1 ) - ignore", (long)n);
        }
        super.updateRgRouteCalculationState(n);
    }

    public int getValue4Model() {
        return 0;
    }
}

