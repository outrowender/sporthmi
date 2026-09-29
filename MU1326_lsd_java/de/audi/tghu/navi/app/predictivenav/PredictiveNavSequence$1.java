/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavSequence;
import org.dsi.ifc.global.NavSegmentID;

class PredictiveNavSequence$1
extends NavCommand {
    private final /* synthetic */ NavSegmentID val$segmentID;
    private final /* synthetic */ PredictiveNavSequence this$0;

    PredictiveNavSequence$1(PredictiveNavSequence predictiveNavSequence, String string, NavSegmentID navSegmentID) {
        this.this$0 = predictiveNavSequence;
        this.val$segmentID = navSegmentID;
        super(string);
    }

    @Override
    public void execute() {
        this.navigation.getStartGuidanceDependantSequence().start(this.val$segmentID);
        this.getCommandList().commandFinished();
    }
}

