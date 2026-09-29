/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequenceEvo;
import org.dsi.ifc.global.NavSegmentID;

class StartGuidanceDependentSequenceEvo$1
extends NavCommand {
    private final /* synthetic */ NavSegmentID val$segmentID;
    private final /* synthetic */ StartGuidanceDependentSequenceEvo this$0;

    StartGuidanceDependentSequenceEvo$1(StartGuidanceDependentSequenceEvo startGuidanceDependentSequenceEvo, String string, NavSegmentID navSegmentID) {
        this.this$0 = startGuidanceDependentSequenceEvo;
        this.val$segmentID = navSegmentID;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.destinationHandler.setSegmentID(this.val$segmentID);
        if (this.dsiResponseContainer.isEtcDemoMode()) {
            this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode is active");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode not active, start Route Guidance");
            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceBySegmendIDSequence(this.val$segmentID, true));
        }
    }
}

