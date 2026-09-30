/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RcsCalculatingAlternative
extends RcsCalculatingBase {
    RcsCalculatingAlternative(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingAlternative");
    }

    protected void onFirstMatchFound() {
        this.getLogger().log(10000000, "RcsCalculatingAlternative#onFirstMatchFound()");
        this.stateMachine.fireOnMatchFound();
    }

    public void setSelectedRouteIndex(int n) {
        if (0 <= n && n <= 2) {
            this.getLogger().log(10000000, "RcsCalculatingAlternative#setSelectedRouteIndex( %1 )", (long)n);
            this.data.iRouteIndex = n;
        } else {
            this.getLogger().log(10000000, "RcsCalculatingAlternative#setSelectedRouteIndex( %1 ) - invalid route index", (long)n);
        }
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (bl) {
            this.getLogger().log(100000000, "RcsCalculatingAlternative#updateRgActive( %1 ) - user has selected one, before all the 3 are calculated", bl);
        }
    }

    protected void onAllMatched(int n) {
        this.getLogger().log(10000000, "RcsCalculatingAlternative#onAllMatched( )");
        this.getStateMachine().fireOnAllMatchFound(n);
    }

    public int getValue4Model() {
        return 2;
    }
}

