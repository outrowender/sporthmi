/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$8
extends NavCommand {
    private final /* synthetic */ RouteOptions[] val$usedRouteOptions;
    private final /* synthetic */ int val$numberOfRoutes;
    private final /* synthetic */ boolean val$prepareMap;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$8(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, RouteOptions[] routeOptionsArray, int n, boolean bl) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$usedRouteOptions = routeOptionsArray;
        this.val$numberOfRoutes = n;
        this.val$prepareMap = bl;
        super(string);
    }

    @Override
    public void execute() {
        Route route = this.navigation.getRouteManager().getRoute();
        Route route2 = RouteUtil.cloneRoute(route, this.val$usedRouteOptions);
        this.navigation.getMapInterface().startRouteCalculation(route2, this.val$numberOfRoutes, this.val$prepareMap, this.this$0.isAlternativeRouteEnabled(), false);
        this.getCommandList().commandFinished();
    }
}

