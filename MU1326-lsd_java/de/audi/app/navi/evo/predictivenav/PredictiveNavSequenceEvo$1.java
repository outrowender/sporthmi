/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.PredictiveNavSequenceEvo;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavSegmentID;

class PredictiveNavSequenceEvo$1
extends NavCommand {
    private final /* synthetic */ NavSegmentID val$segmentID;
    private final /* synthetic */ PredictiveNavSequenceEvo this$0;

    PredictiveNavSequenceEvo$1(PredictiveNavSequenceEvo predictiveNavSequenceEvo, String string, NavSegmentID navSegmentID) {
        this.this$0 = predictiveNavSequenceEvo;
        this.val$segmentID = navSegmentID;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(this.val$segmentID));
    }
}

