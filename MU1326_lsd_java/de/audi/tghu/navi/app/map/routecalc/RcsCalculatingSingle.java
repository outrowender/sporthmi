/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

class RcsCalculatingSingle
extends RcsCalculatingBase {
    RcsCalculatingSingle(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingSingle");
    }

    @Override
    public void abortRouteCalculation() {
        this.getLogger().log(-2137614336, "RcsCalculatingSingle#abortRouteCalculation()");
    }

    @Override
    protected void onFirstMatchFound() {
        this.getLogger().log(-2137614336, "RcsCalculatingSingle#onFirstMatchFound()");
        this.stateMachine.startRG(0, false);
        this.stateMachine.fireOnMatchFound();
        this.goTo(8);
    }

    @Override
    public void setSelectedRouteIndex(int n) {
        this.data.iRouteIndex = 0;
        if (n != 0) {
            this.getLogger().log(10000, "RcsCalculatingSingle#setSelectedRouteIndex( %1 ) - invalid route index");
            return;
        }
    }

    @Override
    public int getValue4Model() {
        return 1;
    }
}

