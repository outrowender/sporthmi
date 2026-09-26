/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

class RouteCalcSM$4
extends DefaultTimerListener {
    private final /* synthetic */ RouteCalcSM this$0;

    RouteCalcSM$4(RouteCalcSM routeCalcSM) {
        this.this$0 = routeCalcSM;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.getLogger().log(-1601830656, "RouteCalcSM#abortCalculationTimer#fireTimer() - route calculation timeout");
        this.this$0.abortRouteCalculation(false);
    }
}

