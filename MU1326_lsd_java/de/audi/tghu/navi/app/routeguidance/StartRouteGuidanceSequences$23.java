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

class StartRouteGuidanceSequences$23
extends NavCommand {
    private final /* synthetic */ RouteOptions val$routeOptions;
    private final /* synthetic */ Route val$currentRoute;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$23(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, RouteOptions routeOptions, Route route) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$routeOptions = routeOptions;
        this.val$currentRoute = route;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#PersistCorrectRouteOptions#execute() - currentAlternativeRouteIndex: %1, new route index: %2 )", (long)this.this$0.alternativeRoutesHandler.getLastSelectedRouteIndex(), 0L);
        if (this.this$0.alternativeRoutesHandler.getLastSelectedRouteIndex() != 0) {
            RouteOptions[] routeOptionsArray = new RouteOptions[]{this.val$routeOptions};
            Route route = RouteUtil.cloneRoute(this.val$currentRoute, routeOptionsArray);
            this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(route));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

