/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.util.RouteHelper;

class StartRouteGuidanceSequences$3
extends NavCommand {
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ int val$destinationIndex;
    private final /* synthetic */ ISDSController val$sdsController;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$3(StartRouteGuidanceSequences startRouteGuidanceSequences, NavLocation navLocation, int n, ISDSController iSDSController) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$destination = navLocation;
        this.val$destinationIndex = n;
        this.val$sdsController = iSDSController;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createAddStopOverToActiveRouteCommandList#execute()");
        Route route = this.navigation.getRouteManager().getRoute();
        RouteOptions[] routeOptionsArray = Util.alternativeRoutesWithStopOverAreDisabled(this.env.getFramework()) ? RouteUtil.getOptionsOfFinalDestination(route) : this.this$0.getConfiguredRouteOptions();
        Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
        route2 = RouteUtil.deletePassedDestinationsFromRoute(route2, this.this$0.logChannel);
        route2 = RouteUtil.cloneRoute(RouteUtil.deleteAllViaPoint(route2, this.this$0.logChannel), routeOptionsArray);
        RouteHelper.addDestinationAtPosition(route2, new RouteDestination(this.val$destination, routeOptionsArray, 1), this.val$destinationIndex);
        this.getCommandList().commandFinishedWithPostSequence(this.this$0.createStartGuidanceToRouteCommandList(routeOptionsArray, route2, this.this$0.commandListFactory, true, this.val$sdsController, this.val$destination));
    }
}

