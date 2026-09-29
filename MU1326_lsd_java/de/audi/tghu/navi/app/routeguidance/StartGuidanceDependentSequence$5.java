/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import org.dsi.ifc.global.NavLocation;

class StartGuidanceDependentSequence$5
extends NavCommand {
    private final /* synthetic */ boolean val$forceStart;
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ int val$dsiNavRouteOptTrail;
    private final /* synthetic */ StartGuidanceDependentSequence this$0;

    StartGuidanceDependentSequence$5(StartGuidanceDependentSequence startGuidanceDependentSequence, String string, boolean bl, NavLocation navLocation, int n) {
        this.this$0 = startGuidanceDependentSequence;
        this.val$forceStart = bl;
        this.val$destination = navLocation;
        this.val$dsiNavRouteOptTrail = n;
        super(string);
    }

    @Override
    public void execute() {
        if (this.this$0.isUserInteractionNeeded(this.dsiResponseContainer) && !this.val$forceStart) {
            this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - Route guidance is currently active, isRgActive: %1, isEtcDemoMode: %2", this.dsiResponseContainer.isRgActive(), this.dsiResponseContainer.isEtcDemoMode());
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - No Active Route guidance, start Route Guidance to destination.");
            boolean bl = true;
            this.navigation.getMapInterface().prepareStartRouteCalculation(bl, this.val$destination);
            SpellerStack.getInstance().reset();
            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartRouteGuidanceToOffroadDestinationSequence(this.val$destination, this.val$dsiNavRouteOptTrail));
        }
    }
}

