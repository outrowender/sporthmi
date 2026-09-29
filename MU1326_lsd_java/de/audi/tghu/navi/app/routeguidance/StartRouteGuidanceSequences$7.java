/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$7
extends WaitForMapReadyCommand {
    private final /* synthetic */ RouteOptions[] val$usedRouteOptions;
    private final /* synthetic */ boolean val$forceStart;
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ boolean val$prepareMap;
    private final /* synthetic */ int val$numberOfRoutes;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$7(StartRouteGuidanceSequences startRouteGuidanceSequences, RouteOptions[] routeOptionsArray, boolean bl, NavLocation navLocation, boolean bl2, int n) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$usedRouteOptions = routeOptionsArray;
        this.val$forceStart = bl;
        this.val$destination = navLocation;
        this.val$prepareMap = bl2;
        this.val$numberOfRoutes = n;
    }

    @Override
    public void execute() {
        super.execute();
        Route route = this.navigation.getRouteManager().getRoute();
        Route route2 = RouteUtil.cloneRoute(route, this.val$usedRouteOptions);
        if (route2 != null) {
            int n = RouteUtil.getRouteLength(route2);
            this.navigation.getMapInterface().prepareStartRouteCalculation(this.val$usedRouteOptions.length == 1 || this.val$forceStart, this.val$destination);
            if (this.val$forceStart) {
                this.this$0.logChannel.log(1078071040, "%1#createStartGuidanceToRouteCommandList - force start", (Object)this.CLASS_NAME);
                this.navigation.getMapInterface().startRouteCalculation(route2, 1, this.val$prepareMap, false, false);
            } else {
                this.this$0.logChannel.log(1078071040, "%1#createStartGuidanceToRouteCommandList - Normal route calculation depending on options. routeListLength=%2", (Object)this.CLASS_NAME, (long)n);
                this.navigation.getMapInterface().startRouteCalculation(route2, this.val$numberOfRoutes, this.val$prepareMap, this.this$0.isAlternativeRouteEnabled(), false);
            }
        } else {
            this.getCommandList().commandAborted(new StringBuffer().append(this.CLASS_NAME).append("#createStartGuidanceToRouteCommandList - guidanceRoute is null!").toString());
        }
    }
}

