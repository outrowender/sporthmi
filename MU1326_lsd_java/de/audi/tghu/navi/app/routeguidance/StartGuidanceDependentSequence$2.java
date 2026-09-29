/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import org.dsi.ifc.navigation.Route;

class StartGuidanceDependentSequence$2
extends NavCommand {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ StartGuidanceDependentSequence this$0;

    StartGuidanceDependentSequence$2(StartGuidanceDependentSequence startGuidanceDependentSequence, String string, Route route) {
        this.this$0 = startGuidanceDependentSequence;
        this.val$route = route;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.destinationHandler.setRoute(this.val$route);
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceByRouteSequence(this.val$route));
    }
}

