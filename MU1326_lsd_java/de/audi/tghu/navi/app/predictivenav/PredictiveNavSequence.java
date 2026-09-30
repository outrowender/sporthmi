/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.predictivenav;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.PredictiveNavigationSetActivationModeCommand;
import org.dsi.ifc.global.NavSegmentID;

public class PredictiveNavSequence {
    protected ICommandListFactory commandListFactory;

    public PredictiveNavSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void startGuidanceBySegmendID(final NavSegmentID navSegmentID) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("enqueue the StartGuidanceDependantSequence for SeLeNa route"){

            public void execute() {
                this.navigation.getStartGuidanceDependantSequence().start(navSegmentID);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PredictiveNavSequence#startGuidanceBySegmendID");
    }

    public void updateOperationModePredictiveNav() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PredictiveNavigationSetActivationModeCommand(3));
        commandList.execute("PredictiveNavSequence#updateOperationModePredictiveNav");
    }

    public void activatePredictiveNav() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PredictiveNavigationSetActivationModeCommand(2));
        commandList.execute("PredictiveNavSequence#activatePredictiveNav");
    }

    public void deactivatePredictiveNav() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PredictiveNavigationSetActivationModeCommand(0));
        commandList.execute("PredictiveNavSequence#deactivatePredictiveNav");
    }
}

