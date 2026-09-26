/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

class StartRouteGuidanceSequences$6
extends NavCommand {
    private final /* synthetic */ Route val$destinationsRoute;
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$6(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, Route route, NavLocation navLocation) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$destinationsRoute = route;
        this.val$destination = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.routeGuidanceListener.routeGuidanceRequested(this.val$destinationsRoute, this.val$destination);
        this.getCommandList().commandFinished();
    }
}

