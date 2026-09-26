/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.routeguidance.commands.RgCalculate1stRouteAndPostponeRemainingCommand;
import de.audi.tghu.navi.app.routeguidance.commands.RgCalculateRouteCommand;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$9
extends NavCommand {
    private final /* synthetic */ RouteOptions[] val$usedRouteOptions;
    private final /* synthetic */ int val$numberOfRoutes;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$9(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, RouteOptions[] routeOptionsArray, int n) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$usedRouteOptions = routeOptionsArray;
        this.val$numberOfRoutes = n;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList#execute()");
        Route route = this.navigation.getRouteManager().getRoute();
        Route route2 = RouteUtil.cloneRoute(route, this.val$usedRouteOptions);
        this.navigation.getDemoModeManager().setDemoModeRoute(route2);
        if (this.val$numberOfRoutes == 3 && MapEnv.useRgCalculate1stRouteAndPostponeRemaining()) {
            this.getCommandList().commandFinishedWithPostCommand(new RgCalculate1stRouteAndPostponeRemainingCommand(route2, this.val$numberOfRoutes, false));
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new RgCalculateRouteCommand(route2, this.val$numberOfRoutes));
        }
    }
}

