/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import org.dsi.ifc.navigation.Route;

class RcsCalculatingFurtherAlternative
extends RcsCalculatingBase {
    RcsCalculatingFurtherAlternative(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingFurtherAlternative");
    }

    @Override
    public void enter() {
    }

    @Override
    protected void onFirstMatchFound() {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternative#onFirstMatchFound( )");
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.getLogger().log(14808325, "RcsCalculatingFurtherAlternative#updateRgActive( %1 )", bl);
        if (!bl) {
            this.goTo(0);
        }
    }

    @Override
    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternative#startRouteCalculation() - prepare:%1, wait:%2", bl, bl2);
        if (n == 3 && bl2 && !this.getStateMachine().isSingleRoute()) {
            this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternative#startRouteCalculation( ) - update route options");
            this.getData().currentRoute = route;
        } else {
            this.getLogger().log(10000, "RcsCalculatingFurtherAlternative#startRouteCalculation() - invalid parameters: numOfAlternatives = %3, waitForAlternativRoutes = %1, isSingleRoute = %2", (Object)Boolean.toString(bl2), (Object)Boolean.toString(this.getStateMachine().isSingleRoute()), (long)n);
        }
        if (bl) {
            this.stateMachine.prepareMap(n, bl3);
        }
    }

    @Override
    protected void onAllMatched(int n) {
        this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternative#onAllMatched( )");
        this.getStateMachine().fireOnAllMatchFound(n);
    }

    @Override
    public void setSelectedRouteIndex(int n) {
        if (0 <= n && n <= 2) {
            this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternative#setSelectedRouteIndex( %1 )", (long)n);
            this.data.iRouteIndex = n;
        } else {
            this.getLogger().log(-2137614336, "RcsCalculatingFurtherAlternative#setSelectedRouteIndex( %1 ) - invalid route index", (long)n);
        }
    }

    @Override
    public int getValue4Model() {
        return 3;
    }

    @Override
    public void cancel() {
        this.getStateMachine().startRG(0);
        this.getStateMachine().naviMap.switchToAShownContext();
    }
}

