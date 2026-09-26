/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$19
extends NavCommand {
    private final /* synthetic */ int val$routeIndex;
    private final /* synthetic */ Route val$currentRoute;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$19(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, int n, Route route) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$routeIndex = n;
        this.val$currentRoute = route;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#PersistCorrectRouteOptions#execute() - currentAlternativeRouteIndex: %1, new route index: %2 )", (long)this.this$0.alternativeRoutesHandler.getLastSelectedRouteIndex(), (long)this.val$routeIndex);
        this.navigation.getMapInterface().setRouteCalculationToSingelRoute(true);
        if (this.this$0.alternativeRoutesHandler.getLastSelectedRouteIndex() != this.val$routeIndex) {
            RouteOptions[] routeOptionsArray = this.this$0.routeCriteriaManager.getRouteCriteria().getRouteOptions(true);
            RouteOptions[] routeOptionsArray2 = new RouteOptions[]{routeOptionsArray[this.val$routeIndex]};
            Route route = RouteUtil.cloneRoute(this.val$currentRoute, routeOptionsArray2);
            this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(route));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

