/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RcsCalculatingAlternativeNew
extends RcsCalculatingBase {
    RcsCalculatingAlternativeNew(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingAlternativeNew");
    }

    protected void onFirstMatchFound() {
        this.getLogger().log(10000000, "RcsCalculatingAlternativeNew#onFirstMatchFound()");
        this.stateMachine.startRG(0, false);
        this.stateMachine.fireOnMatchFound();
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.getLogger().log(100000000, "RcsCalculatingAlternativeNew#updateRgActive( %1 )", bl);
        if (!bl) {
            this.goTo(0);
        }
    }

    protected void onAllMatched(int n) {
        this.getLogger().log(10000000, "RcsCalculatingAlternativeNew#onAllMatched( )");
        this.getStateMachine().fireOnAllMatchFound(n);
    }

    public void setSelectedRouteIndex(int n) {
        if (0 <= n && n <= 2) {
            this.getLogger().log(10000000, "RcsCalculatingAlternativeNew#setSelectedRouteIndex( %1 )", (long)n);
            this.data.iRouteIndex = n;
        } else {
            this.getLogger().log(10000000, "RcsCalculatingAlternativeNew#setSelectedRouteIndex( %1 ) - invalid route index", (long)n);
        }
    }

    public int getValue4Model() {
        return 2;
    }
}

