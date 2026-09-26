/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceModelAccess;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequenceEvo$1;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequenceEvo$2;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public class StartGuidanceDependentSequenceEvo
extends StartGuidanceDependentSequence {
    public StartGuidanceDependentSequenceEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IStartGuidanceModelAccess iStartGuidanceModelAccess, IDestinationHandler iDestinationHandler) {
        super(navigationEnv, iCommandListFactory, iStartGuidanceModelAccess, iDestinationHandler);
    }

    @Override
    protected boolean isUserInteractionNeeded(DSIResponseContainer dSIResponseContainer) {
        int n = this.env.getChoiceModel(136578560).getValue();
        return n == 0 && dSIResponseContainer.isRgActive() || dSIResponseContainer.isEtcDemoMode();
    }

    @Override
    public CommandList getStartSequence(NavSegmentID navSegmentID) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StartGuidanceDependentSequenceEvo$1(this, "StartGuidanceDependentSequenceEvo depends on DemoMode state", navSegmentID));
        return commandList;
    }

    @Override
    public CommandList getStartSequence(Route route) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StartGuidanceDependentSequenceEvo$2(this, "StartGuidanceDependentSequenceEvo depends on DemoMode state", route));
        return commandList;
    }
}

