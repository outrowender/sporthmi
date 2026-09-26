/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

class StartRouteGuidanceSequences$5
extends NavCommand {
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$5(StartRouteGuidanceSequences startRouteGuidanceSequences, String string) {
        this.this$0 = startRouteGuidanceSequences;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList - CheckRouteConsistency#execute()");
        Route route = this.navigation.getRouteManager().getRoute();
        if (RouteUtil.getRouteLength(route) == 0) {
            String string = "current on-road route is null!";
            this.logger.log(-1601830656, "[RouteGuidance] StartRouteGuidanceSequences#execute() - %1 ", (Object)string);
            this.getCommandList().commandAborted(string);
            return;
        }
        this.getCommandList().commandFinished();
    }
}

