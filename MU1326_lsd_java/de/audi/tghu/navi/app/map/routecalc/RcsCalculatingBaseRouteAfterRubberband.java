/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RcsCalculatingBaseRouteAfterRubberband
extends RcsBase {
    RcsCalculatingBaseRouteAfterRubberband(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingBaseRouteAfterRubberband");
    }

    public void enter() {
        super.enter();
        this.getStateMachine().setIsRGAboutToBeStarted(true, true);
    }

    public void exit() {
        super.exit();
        this.getStateMachine().setIsRGAboutToBeStarted(false, true);
    }

    public boolean isMatchingRoutesFound() {
        return true;
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.getLogger().log(100000000, "RcsCalculatingBaseRouteAfterRubberband#updateRgActive( %1 )", bl);
        if (bl) {
            this.goTo(7);
            this.getStateMachine().fireEvent(212);
        } else {
            this.goTo(0);
            this.getStateMachine().fireEvent(202);
        }
    }

    public int getValue4Model() {
        return 5;
    }
}

