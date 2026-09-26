/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.routeguidance.commands.RgCalculateRouteCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$2
extends NavCommand {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ int val$numberOfAlternatives;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$2(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, Route route, int n) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$route = route;
        this.val$numberOfAlternatives = n;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.dsiResponseContainer.isRgActive() && !Util.isHURegionAsia()) {
            this.logger.log(-1601830656, "StartRouteGuidanceSequences#EvaluateGuidanceActive#execute() - abort, route guidance is not active!");
            this.getCommandList().commandAborted("Route Guidance is not active");
            return;
        }
        if (this.dsiResponseContainer.getRgRouteCalculationState() == 1) {
            this.logger.log(-1601830656, "StartRouteGuidanceSequences#EvaluateGuidanceActive#execute() - there is a currently active route calculation - do not proceed. ");
            this.getCommandList().commandFinished();
            return;
        }
        this.logger.log(-2137614336, "StartRouteGuidanceSequences#EvaluateGuidanceActive#execute() - prepare route for alternative calculation.");
        RouteOptions[] routeOptionsArray = this.this$0.routeCriteriaManager.getRouteCriteria().getRouteOptions(false);
        if (!Util.isHURegionAsia()) {
            routeOptionsArray[0].setRouteType(8);
        }
        Route route = RouteUtil.deleteAllViaPoint(RouteUtil.cloneRoute(this.val$route, routeOptionsArray), this.this$0.logChannel);
        RouteDestination routeDestination = route.getRoutelist()[0];
        if (routeDestination.routeOptions.length >= 2) {
            routeDestination.routeOptions[1].cityMautList = (int[])(routeDestination.routeOptions[0].cityMautList == null ? new int[0] : null);
        }
        this.navigation.getMapInterface().startRouteCalculation(route, this.val$numberOfAlternatives, true, true, false);
        this.getCommandList().commandFinishedWithPostCommand(new RgCalculateRouteCommand(route, this.val$numberOfAlternatives));
    }
}

