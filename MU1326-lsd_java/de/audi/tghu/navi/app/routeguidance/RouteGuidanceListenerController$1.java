/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController$IUpdateOperation;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

class RouteGuidanceListenerController$1
implements RouteGuidanceListenerController$IUpdateOperation {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ NavLocation val$newDestination;
    private final /* synthetic */ RouteGuidanceListenerController this$0;

    RouteGuidanceListenerController$1(RouteGuidanceListenerController routeGuidanceListenerController, Route route, NavLocation navLocation) {
        this.this$0 = routeGuidanceListenerController;
        this.val$route = route;
        this.val$newDestination = navLocation;
    }

    @Override
    public void update(IRouteGuidanceListener iRouteGuidanceListener) {
        iRouteGuidanceListener.routeGuidanceRequested(this.val$route, this.val$newDestination);
    }
}

