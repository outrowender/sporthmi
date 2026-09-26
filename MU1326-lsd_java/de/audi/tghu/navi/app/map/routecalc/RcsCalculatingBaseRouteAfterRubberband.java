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

    @Override
    public void enter() {
        super.enter();
        this.getStateMachine().setIsRGAboutToBeStarted(true, true);
    }

    @Override
    public void exit() {
        super.exit();
        this.getStateMachine().setIsRGAboutToBeStarted(false, true);
    }

    @Override
    public boolean isMatchingRoutesFound() {
        return true;
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.getLogger().log(14808325, "RcsCalculatingBaseRouteAfterRubberband#updateRgActive( %1 )", bl);
        if (bl) {
            this.goTo(7);
            this.getStateMachine().fireEvent(212);
        } else {
            this.goTo(0);
            this.getStateMachine().fireEvent(202);
        }
    }

    @Override
    public int getValue4Model() {
        return 5;
    }
}

