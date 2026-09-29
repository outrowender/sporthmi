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

    @Override
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

    @Override
    protected void onFirstMatchFound() {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#onFirstMatchFound()");
        this.getStateMachine().fireOnMatchFound();
    }

    @Override
    protected void onAllMatched(int n) {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#onAllMatched( %1 )", (long)n);
        this.getStateMachine().fireOnAllMatchFound(n);
    }

    @Override
    public void setSelectedRouteIndex(int n) {
        if (0 <= n && n <= 2) {
            this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#setSelectedRouteIndex( %1 )", (long)n);
            this.getData().iRouteIndex = n;
        } else {
            this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#setSelectedRouteIndex( %1 ) - invalid route index", (long)n);
        }
    }

    @Override
    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#startRouteCalculation()");
        this.getData().currentRoute = route;
        this.getData().sCalculatedRoutesValid = false;
        for (int i2 = 0; i2 < this.getData().sAvailableRoutesValid.length; ++i2) {
            this.getData().sAvailableRoutesValid[i2] = false;
            this.getData().sMatchingRoutesFound[i2] = 0;
        }
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (this.getLogger().isDebug2() && bl) {
            this.getLogger().log(14808325, "RcsCalculatingFurtherAlternativeAsia#updateRgActive( %1 ) - User has selected a route before all routes were calculated", bl);
        }
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (this.getLogger().isDebug() && n == 2) {
            boolean bl = true;
            for (int i2 = 0; i2 < 3; ++i2) {
                bl = bl && this.getData().sMatchingRoutesFound[i2] > 1;
            }
            if (bl) {
                this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#onMatchFound() - found all the 3 routes");
            }
        }
    }

    @Override
    public int getValue4Model() {
        return 3;
    }

    @Override
    public void cancel() {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternativeAsia#cancel() - restore previous route");
        this.getStateMachine().abortRouteCalculation(false);
        this.getStateMachine().goTo(0);
        this.getStateMachine().onStartRouteCalculation(true, true, null);
        this.getStateMachine().naviMap.getNaviInterface().getRouteManager().restartRouteGuidance(false, false);
    }
}

