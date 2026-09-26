/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.app.navi.evo.predictivenav.PredictiveNavSequenceEvo$1;
import de.audi.app.navi.evo.predictivenav.PredictiveNavSequenceEvo$2;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavSequence;
import org.dsi.ifc.global.NavSegmentID;

public class PredictiveNavSequenceEvo
extends PredictiveNavSequence {
    private boolean guidanceStarting = false;

    public PredictiveNavSequenceEvo(ICommandListFactory iCommandListFactory) {
        super(iCommandListFactory);
    }

    @Override
    public void startGuidanceBySegmendID(NavSegmentID navSegmentID) {
        this.guidanceStarting = true;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PredictiveNavSequenceEvo$1(this, "enqueue the StartGuidanceDependantSequence for SeLeNa route", navSegmentID));
        commandList.add(new PredictiveNavSequenceEvo$2(this, "enqueue the StartGuidanceDependantSequence for SeLeNa route"));
        commandList.execute("PredictiveNavSequenceEvo#startGuidanceBySegmendID");
    }

    public boolean isGuidanceStarting() {
        return this.guidanceStarting;
    }

    static /* synthetic */ boolean access$002(PredictiveNavSequenceEvo predictiveNavSequenceEvo, boolean bl) {
        predictiveNavSequenceEvo.guidanceStarting = bl;
        return predictiveNavSequenceEvo.guidanceStarting;
    }
}

