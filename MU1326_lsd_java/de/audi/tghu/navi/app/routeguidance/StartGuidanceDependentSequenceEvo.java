/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceModelAccess;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public class StartGuidanceDependentSequenceEvo
extends StartGuidanceDependentSequence {
    public StartGuidanceDependentSequenceEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IStartGuidanceModelAccess iStartGuidanceModelAccess, IDestinationHandler iDestinationHandler) {
        super(navigationEnv, iCommandListFactory, iStartGuidanceModelAccess, iDestinationHandler);
    }

    protected boolean isUserInteractionNeeded(DSIResponseContainer dSIResponseContainer) {
        int n = this.env.getChoiceModel(402440).getValue();
        return n == 0 && dSIResponseContainer.isRgActive() || dSIResponseContainer.isEtcDemoMode();
    }

    public CommandList getStartSequence(final NavSegmentID navSegmentID) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("StartGuidanceDependentSequenceEvo depends on DemoMode state"){

            public void execute() {
                StartGuidanceDependentSequenceEvo.this.destinationHandler.setSegmentID(navSegmentID);
                if (this.dsiResponseContainer.isEtcDemoMode()) {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode is active");
                    this.getCommandList().commandFinished();
                } else {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode not active, start Route Guidance");
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceBySegmendIDSequence(navSegmentID, true));
                }
            }
        });
        return commandList;
    }

    public CommandList getStartSequence(final Route route) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("StartGuidanceDependentSequenceEvo depends on DemoMode state"){

            public void execute() {
                StartGuidanceDependentSequenceEvo.this.destinationHandler.setRoute(route);
                if (this.dsiResponseContainer.isEtcDemoMode()) {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode is active");
                    this.getCommandList().commandFinished();
                } else {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequenceEvo#NavCommand1#execute() - DemoMode not active, start Route Guidance");
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceByRouteSequence(route));
                }
            }
        });
        return commandList;
    }
}

