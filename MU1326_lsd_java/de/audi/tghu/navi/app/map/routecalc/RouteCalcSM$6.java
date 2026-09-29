/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$IRouteCalcEnv;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

class RouteCalcSM$6
extends SimpleButtonListener {
    private final /* synthetic */ IRouteCalculator$IRouteCalcEnv val$rcEnv;
    private final /* synthetic */ RouteCalcSM this$0;

    RouteCalcSM$6(RouteCalcSM routeCalcSM, IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
        this.this$0 = routeCalcSM;
        this.val$rcEnv = iRouteCalculator$IRouteCalcEnv;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogger().log(-2137614336, "RouteCalcSM#<IgnoreBetterRouteListener>#keyPressed()");
        this.this$0.isPopupDefinitiveBetterIgnored = true;
        this.val$rcEnv.getViews().getSemidynRGView().hidePopupSemidynBetterMain();
    }
}

