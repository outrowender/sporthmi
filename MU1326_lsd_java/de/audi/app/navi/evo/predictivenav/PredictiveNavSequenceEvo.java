/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.predictivenav;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.predictivenav.PredictiveNavSequence;
import org.dsi.ifc.global.NavSegmentID;

public class PredictiveNavSequenceEvo
extends PredictiveNavSequence {
    private boolean guidanceStarting = false;

    public PredictiveNavSequenceEvo(ICommandListFactory iCommandListFactory) {
        super(iCommandListFactory);
    }

    public void startGuidanceBySegmendID(final NavSegmentID navSegmentID) {
        this.guidanceStarting = true;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("enqueue the StartGuidanceDependantSequence for SeLeNa route"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(navSegmentID));
            }
        });
        commandList.add(new NavCommand("enqueue the StartGuidanceDependantSequence for SeLeNa route"){

            public void execute() {
                PredictiveNavSequenceEvo.this.guidanceStarting = false;
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PredictiveNavSequenceEvo#startGuidanceBySegmendID");
    }

    public boolean isGuidanceStarting() {
        return this.guidanceStarting;
    }
}

