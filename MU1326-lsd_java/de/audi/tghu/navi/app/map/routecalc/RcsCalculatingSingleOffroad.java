/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingSingle;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RcsCalculatingSingleOffroad
extends RcsCalculatingSingle {
    RcsCalculatingSingleOffroad(RouteCalcSM routeCalcSM) {
        super(routeCalcSM);
    }

    @Override
    protected void onFirstMatchFound() {
        this.getLogger().log(-2137614336, "RcsCalculatingSingleOffroad#onFirstMatchFound()");
        this.stateMachine.startRG(0, false);
        this.stateMachine.fireOnMatchFound();
        for (int i2 = 0; i2 < this.data.sAvailableRoutesValid.length; ++i2) {
            this.data.sAvailableRoutesValid[i2] = false;
        }
        this.goTo(8);
    }
}

