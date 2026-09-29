/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberbandTouchscreen;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RubberbandFactory {
    private NavigationEnv env;

    public RubberbandFactory(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public RcsBase getRcsCalculatingRubberband(RouteCalcSM routeCalcSM) {
        int n = this.env.getFramework().getSysConstManager().getSysConst(4431);
        if (n == 0) {
            return new RcsCalculatingRubberband(routeCalcSM);
        }
        if (n == 1) {
            return new RcsCalculatingRubberbandTouchscreen(routeCalcSM);
        }
        return new RcsCalculatingRubberband(routeCalcSM);
    }
}

