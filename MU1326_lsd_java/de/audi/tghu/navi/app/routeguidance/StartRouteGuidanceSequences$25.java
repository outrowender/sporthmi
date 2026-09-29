/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$25
extends NavCommand {
    private final /* synthetic */ RouteOptions[] val$usedRouteOptions;
    private final /* synthetic */ Route val$destinationsRoute;
    private final /* synthetic */ NavLocation val$currentLocation;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$25(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, RouteOptions[] routeOptionsArray, Route route, NavLocation navLocation) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$usedRouteOptions = routeOptionsArray;
        this.val$destinationsRoute = route;
        this.val$currentLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "StartRouteGuidanceSequences#startRG()");
        this.env.getChoiceModel(170).setValue(0);
        this.getCommandList().commandFinishedWithPostSequence(this.this$0.createStartGuidanceToRouteCommandList(true, this.val$usedRouteOptions, this.val$destinationsRoute, this.this$0.commandListFactory, true, null, this.val$currentLocation));
    }
}

