/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$IRouteCalcEnv;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

class RouteCalcSM$3
extends DefaultTimerListener {
    private final /* synthetic */ IRouteCalculator$IRouteCalcEnv val$rcEnv;
    private final /* synthetic */ RouteCalcSM this$0;

    RouteCalcSM$3(RouteCalcSM routeCalcSM, IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
        this.this$0 = routeCalcSM;
        this.val$rcEnv = iRouteCalculator$IRouteCalcEnv;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.val$rcEnv.getViews().getSemidynRGView().showShortInfo();
    }
}

