/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.SimpleButtonListener;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

class RouteCalcSM$7
extends SimpleButtonListener {
    private final /* synthetic */ NavigationEnv val$env;
    private final /* synthetic */ RouteCalcSM this$0;

    RouteCalcSM$7(RouteCalcSM routeCalcSM, NavigationEnv navigationEnv) {
        this.this$0 = routeCalcSM;
        this.val$env = navigationEnv;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogger().log(-2137614336, "RouteCalcSM#<SwitchToSemidynListener>#keyPressed()");
        this.val$env.fireModelEvent(n, n3);
        this.this$0.switchToSemidynamic(n);
    }
}

