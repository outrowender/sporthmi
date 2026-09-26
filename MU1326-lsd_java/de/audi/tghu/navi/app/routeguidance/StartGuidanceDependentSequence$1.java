/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import org.dsi.ifc.global.NavSegmentID;

class StartGuidanceDependentSequence$1
extends NavCommand {
    private final /* synthetic */ NavSegmentID val$segmentID;
    private final /* synthetic */ StartGuidanceDependentSequence this$0;

    StartGuidanceDependentSequence$1(StartGuidanceDependentSequence startGuidanceDependentSequence, String string, NavSegmentID navSegmentID) {
        this.this$0 = startGuidanceDependentSequence;
        this.val$segmentID = navSegmentID;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand1#execute()");
        this.this$0.destinationHandler.setSegmentID(this.val$segmentID);
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceBySegmendIDSequence(this.val$segmentID, true));
    }
}

