/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController$IUpdateOperation;

class RouteGuidanceListenerController$2
implements RouteGuidanceListenerController$IUpdateOperation {
    private final /* synthetic */ RouteGuidanceListenerController this$0;

    RouteGuidanceListenerController$2(RouteGuidanceListenerController routeGuidanceListenerController) {
        this.this$0 = routeGuidanceListenerController;
    }

    @Override
    public void update(IRouteGuidanceListener iRouteGuidanceListener) {
        iRouteGuidanceListener.cancelStartRouteCalculation();
    }
}

