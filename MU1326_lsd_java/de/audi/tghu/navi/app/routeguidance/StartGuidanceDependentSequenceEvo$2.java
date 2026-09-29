/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequenceEvo;
import org.dsi.ifc.navigation.Route;

class StartGuidanceDependentSequenceEvo$2
extends NavCommand {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ StartGuidanceDependentSequenceEvo this$0;

    StartGuidanceDependentSequenceEvo$2(StartGuidanceDependentSequenceEvo startGuidanceDependentSequenceEvo, String string, Route route) {
        this.this$0 = startGuidanceDependentSequenceEvo;
        this.val$route = route;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.destinationHandler.setRoute(this.val$route);
        if (this.dsiResponseContainer.isEtcDemoMode()) {
            this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode is active");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode not active, start Route Guidance");
            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceByRouteSequence(this.val$route));
        }
    }
}

