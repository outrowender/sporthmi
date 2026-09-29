/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$1;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$2;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$3;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$4;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$5;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$UpdateModelAccessCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public class StartGuidanceDependentSequence
implements IStartGuidanceToDestinationSequence {
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final IStartGuidanceModelAccess modelAccess;
    protected final IDestinationHandler destinationHandler;

    public StartGuidanceDependentSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IStartGuidanceModelAccess iStartGuidanceModelAccess, IDestinationHandler iDestinationHandler) {
        this.env = navigationEnv;
        this.modelAccess = iStartGuidanceModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.destinationHandler = iDestinationHandler;
    }

    @Override
    public void start(ILocationHandler iLocationHandler, NavLocation navLocation) {
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#start( %1, %2 )", (Object)iLocationHandler, (Object)navLocation);
        CommandList commandList = this.getStartSequence(iLocationHandler, navLocation);
        if (commandList != null) {
            commandList.execute("[RouteGuidance]StartGuidanceDependentSequence#start()");
        }
    }

    @Override
    public void start(NavLocation navLocation) {
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#start( %1 )", (Object)navLocation);
        this.start(null, navLocation);
    }

    @Override
    public void start(NavSegmentID navSegmentID) {
        this.getStartSequence(navSegmentID).execute("StartGuidanceDependentSequence#start(NavSegmentID)");
    }

    @Override
    public CommandList getStartSequence(NavSegmentID navSegmentID) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new StartGuidanceDependentSequence$1(this, "StartGuidanceSequence", navSegmentID));
        return commandList;
    }

    @Override
    public void start(Route route) {
        this.getStartSequence(route).execute("StartGuidanceDependentSequence#start(Route)");
    }

    @Override
    public CommandList getStartSequence(Route route) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new StartGuidanceDependentSequence$2(this, "StartGuidanceSequence depends on DemoMode state", route));
        return commandList;
    }

    @Override
    public CommandList getStartSequence(ILocationHandler iLocationHandler, NavLocation navLocation, boolean bl, boolean bl2) {
        return this.getStartSequenceForceStart(iLocationHandler, navLocation, bl2, bl);
    }

    @Override
    public CommandList getStartSequence(ILocationHandler iLocationHandler, NavLocation navLocation) {
        return this.getStartSequence(iLocationHandler, navLocation, true, false);
    }

    @Override
    public CommandList getStartSequence(NavLocation navLocation) {
        return this.getStartSequence(null, navLocation);
    }

    @Override
    public void start(NavLocation navLocation, boolean bl) {
        this.getStartSequence(navLocation, bl).execute("StartGuidanceDependentSequence#start(NavLocation, boolean)");
    }

    @Override
    public CommandList getStartSequence(NavLocation navLocation, boolean bl) {
        return this.getStartSequenceForceStart(null, navLocation, bl, true);
    }

    @Override
    public CommandList getStartSequenceForKombi(NavLocation navLocation, boolean bl) {
        NavLocation navLocation2 = navLocation;
        this.destinationHandler.setLocation(navLocation2);
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#getStartSequenceForKombi( %2, %1 )", true, (Object)navLocation2);
        CommandList commandList = this.commandListFactory.createCommandList(0);
        commandList.add(new StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand(this, navLocation2, false, null));
        commandList.add(new StartGuidanceDependentSequence$UpdateModelAccessCommand(this, navLocation2, null));
        commandList.add(new StartGuidanceDependentSequence$3(this, "StartGuidanceSequence depends on current options", bl, navLocation2, navLocation));
        return commandList;
    }

    private CommandList getStartSequenceForceStart(ILocationHandler iLocationHandler, NavLocation navLocation, boolean bl, boolean bl2) {
        NavLocation navLocation2 = iLocationHandler != null ? iLocationHandler.handleLocation(navLocation) : navLocation;
        this.destinationHandler.setLocation(navLocation2);
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#getStartSequence( %2, %1 )", bl2, (Object)navLocation2);
        CommandList commandList = this.commandListFactory.createCommandList(0);
        commandList.add(new StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand(this, navLocation2, false, null));
        commandList.add(new StartGuidanceDependentSequence$UpdateModelAccessCommand(this, navLocation2, null));
        commandList.add(new StartGuidanceDependentSequence$4(this, "StartGuidanceSequence depends on current options", bl, navLocation2, navLocation, bl2));
        return commandList;
    }

    @Override
    public CommandList getOffroadStartSequence(NavLocation navLocation, boolean bl, int n) {
        this.env.getChoiceModel(170).setValue(0);
        this.env.getLogChannel().log(-2137614336, "[RouteGuidance] StartGuidanceDependentSequence#getOffroadStartSequence( destination, forceStart, dsiNavRouteOptTrail )");
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand(this, navLocation, true, null));
        commandList.add(new StartGuidanceDependentSequence$UpdateModelAccessCommand(this, navLocation, null));
        commandList.add(new StartGuidanceDependentSequence$5(this, "StartGuidanceSequence depends on current options", bl, navLocation, n));
        return commandList;
    }

    protected boolean isUserInteractionNeeded(DSIResponseContainer dSIResponseContainer) {
        return false;
    }

    @Override
    public void startOffroad(NavLocation navLocation, boolean bl, int n) {
        this.getOffroadStartSequence(navLocation, bl, n).execute("StartGuidanceDependentSequence#startOffroad(NavLocation, boolean, int)");
    }
}

