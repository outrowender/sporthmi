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
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
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

    public void start(ILocationHandler iLocationHandler, NavLocation navLocation) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#start( %1, %2 )", (Object)iLocationHandler, (Object)navLocation);
        CommandList commandList = this.getStartSequence(iLocationHandler, navLocation);
        if (commandList != null) {
            commandList.execute("[RouteGuidance]StartGuidanceDependentSequence#start()");
        }
    }

    public void start(NavLocation navLocation) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#start( %1 )", (Object)navLocation);
        this.start(null, navLocation);
    }

    public void start(NavSegmentID navSegmentID) {
        this.getStartSequence(navSegmentID).execute("StartGuidanceDependentSequence#start(NavSegmentID)");
    }

    public CommandList getStartSequence(final NavSegmentID navSegmentID) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NavCommand("StartGuidanceSequence"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand1#execute()");
                StartGuidanceDependentSequence.this.destinationHandler.setSegmentID(navSegmentID);
                this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceBySegmendIDSequence(navSegmentID, true));
            }
        });
        return commandList;
    }

    public void start(Route route) {
        this.getStartSequence(route).execute("StartGuidanceDependentSequence#start(Route)");
    }

    public CommandList getStartSequence(final Route route) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NavCommand("StartGuidanceSequence depends on DemoMode state"){

            public void execute() {
                StartGuidanceDependentSequence.this.destinationHandler.setRoute(route);
                this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceByRouteSequence(route));
            }
        });
        return commandList;
    }

    public CommandList getStartSequence(ILocationHandler iLocationHandler, NavLocation navLocation, boolean bl, boolean bl2) {
        return this.getStartSequenceForceStart(iLocationHandler, navLocation, bl2, bl);
    }

    public CommandList getStartSequence(ILocationHandler iLocationHandler, NavLocation navLocation) {
        return this.getStartSequence(iLocationHandler, navLocation, true, false);
    }

    public CommandList getStartSequence(NavLocation navLocation) {
        return this.getStartSequence(null, navLocation);
    }

    public void start(NavLocation navLocation, boolean bl) {
        this.getStartSequence(navLocation, bl).execute("StartGuidanceDependentSequence#start(NavLocation, boolean)");
    }

    public CommandList getStartSequence(NavLocation navLocation, boolean bl) {
        return this.getStartSequenceForceStart(null, navLocation, bl, true);
    }

    public CommandList getStartSequenceForKombi(final NavLocation navLocation, final boolean bl) {
        final NavLocation navLocation2 = navLocation;
        this.destinationHandler.setLocation(navLocation2);
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#getStartSequenceForKombi( %2, %1 )", true, (Object)navLocation2);
        CommandList commandList = this.commandListFactory.createCommandList(0);
        commandList.add(new AbortWhenLocationInvalidCommand(navLocation2, false));
        commandList.add(new UpdateModelAccessCommand(navLocation2));
        commandList.add(new NavCommand("StartGuidanceSequence depends on current options"){

            public void execute() {
                if (StartGuidanceDependentSequence.this.isUserInteractionNeeded(this.dsiResponseContainer) && !bl) {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - Route guidance is currently active, isRgActive: %1, isEtcDemoMode: %2", this.dsiResponseContainer.isRgActive(), this.dsiResponseContainer.isEtcDemoMode());
                    this.getCommandList().commandFinished();
                } else {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - No Active Route guidance, start Route Guidance to destination.");
                    boolean bl2 = this.navigation.getAlternativeRouteState().getAlternativeRouteState() == 0;
                    this.navigation.getMapInterface().prepareStartRouteCalculation(bl2, navLocation2);
                    SpellerStack.getInstance().reset();
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartRouteGuidanceToSingleDestinationSequenceFromKombi(navLocation, true));
                }
            }
        });
        return commandList;
    }

    private CommandList getStartSequenceForceStart(ILocationHandler iLocationHandler, final NavLocation navLocation, final boolean bl, final boolean bl2) {
        final NavLocation navLocation2 = iLocationHandler != null ? iLocationHandler.handleLocation(navLocation) : navLocation;
        this.destinationHandler.setLocation(navLocation2);
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#getStartSequence( %2, %1 )", bl2, (Object)navLocation2);
        CommandList commandList = this.commandListFactory.createCommandList(0);
        commandList.add(new AbortWhenLocationInvalidCommand(navLocation2, false));
        commandList.add(new UpdateModelAccessCommand(navLocation2));
        commandList.add(new NavCommand("StartGuidanceSequence depends on current options"){

            public void execute() {
                if (StartGuidanceDependentSequence.this.isUserInteractionNeeded(this.dsiResponseContainer) && !bl) {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - Route guidance is currently active, isRgActive: %1, isEtcDemoMode: %2", this.dsiResponseContainer.isRgActive(), this.dsiResponseContainer.isEtcDemoMode());
                    this.getCommandList().commandFinished();
                } else {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - No Active Route guidance, start Route Guidance to destination.");
                    boolean bl3 = this.navigation.getAlternativeRouteState().getAlternativeRouteState() == 0;
                    this.navigation.getMapInterface().prepareStartRouteCalculation(bl3, navLocation2);
                    SpellerStack.getInstance().reset();
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartRouteGuidanceToSingleDestinationSequence(navLocation, bl2));
                }
            }
        });
        return commandList;
    }

    public CommandList getOffroadStartSequence(final NavLocation navLocation, final boolean bl, final int n) {
        this.env.getChoiceModel(170).setValue(0);
        this.env.getLogChannel().log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#getOffroadStartSequence( destination, forceStart, dsiNavRouteOptTrail )");
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new AbortWhenLocationInvalidCommand(navLocation, true));
        commandList.add(new UpdateModelAccessCommand(navLocation));
        commandList.add(new NavCommand("StartGuidanceSequence depends on current options"){

            public void execute() {
                if (StartGuidanceDependentSequence.this.isUserInteractionNeeded(this.dsiResponseContainer) && !bl) {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - Route guidance is currently active, isRgActive: %1, isEtcDemoMode: %2", this.dsiResponseContainer.isRgActive(), this.dsiResponseContainer.isEtcDemoMode());
                    this.getCommandList().commandFinished();
                } else {
                    this.logger.log(10000000, "[RouteGuidance] StartGuidanceDependentSequence#NavCommand2#execute() - No Active Route guidance, start Route Guidance to destination.");
                    boolean bl2 = true;
                    this.navigation.getMapInterface().prepareStartRouteCalculation(bl2, navLocation);
                    SpellerStack.getInstance().reset();
                    this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartRouteGuidanceToOffroadDestinationSequence(navLocation, n));
                }
            }
        });
        return commandList;
    }

    protected boolean isUserInteractionNeeded(DSIResponseContainer dSIResponseContainer) {
        return false;
    }

    public void startOffroad(NavLocation navLocation, boolean bl, int n) {
        this.getOffroadStartSequence(navLocation, bl, n).execute("StartGuidanceDependentSequence#startOffroad(NavLocation, boolean, int)");
    }

    private class UpdateModelAccessCommand
    extends NavCommand {
        private final NavLocation location;

        private UpdateModelAccessCommand(NavLocation navLocation) {
            super("StartGuidanceDependentSequence update model Access");
            this.location = navLocation;
        }

        public void execute() {
            if (this.location != null) {
                Route route = this.navigation.getRouteManager().getRoute();
                StartGuidanceDependentSequence.this.modelAccess.onStart(route, this.location, this.dsiResponseContainer.isRgActive());
            }
            this.getCommandList().commandFinished();
        }
    }

    private class AbortWhenLocationInvalidCommand
    extends NavCommand {
        private final NavLocation location;
        private boolean nullOnly;

        private AbortWhenLocationInvalidCommand(NavLocation navLocation, boolean bl) {
            super("StartGuidanceDependentSequence check if location is ok");
            this.location = navLocation;
            this.nullOnly = bl;
        }

        public void execute() {
            if (this.location == null) {
                this.getCommandList().commandAborted("StartGuidanceDependentSequence#AbortWhenInvalidCommand - The given NavLocation is null");
            } else if (!this.nullOnly && !this.location.isPositionValid()) {
                this.getCommandList().commandAborted("StartGuidanceDependentSequence#AbortWhenInvalidCommand - The given NavLocation is not valid");
            } else {
                this.getCommandList().commandFinished();
            }
        }
    }
}

