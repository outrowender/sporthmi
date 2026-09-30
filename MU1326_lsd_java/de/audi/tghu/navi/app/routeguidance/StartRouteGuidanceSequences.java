/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.PredictiveNavigationSetActivationModeCommand;
import de.audi.tghu.navi.app.command.RGSetRouteOptionsCommand;
import de.audi.tghu.navi.app.command.RGStartGuidanceCalculatedRoute;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.ResetSpellerStackCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.command.StoreStartingTimeCommand;
import de.audi.tghu.navi.app.command.TrStopTraceRecording;
import de.audi.tghu.navi.app.command.TrStoreTrace;
import de.audi.tghu.navi.app.command.TriggerErrorDumpCommand;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.command.via.RgStopRubberBandCommand;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.routeguidance.AlternativeRoutesHandler;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.OffroadRouteOptionsStateManager;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController;
import de.audi.tghu.navi.app.routeguidance.commands.RgCalculate1stRouteAndPostponeRemainingCommand;
import de.audi.tghu.navi.app.routeguidance.commands.RgCalculateRouteCommand;
import de.audi.tghu.navi.app.routeguidance.commands.RgStopGuidanceGeneralCommand;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.util.RouteHelper;
import org.osgi.framework.BundleContext;

public class StartRouteGuidanceSequences
implements INaviComponent {
    private static final int REL_STOPOVERARRAY_INDEX_BEFORE_DESTINATON = 2;
    private static final int OFFROAD_TRACE_ACTIVE = 1;
    public static String TRANSFORMED_INSERT_POS = "TRANSFORMED_INSERT_POS";
    private static final int ONLY_ONE_ROUTE = 1;
    protected final ICommandListFactory commandListFactory;
    protected final NavigationEnv env;
    protected final RouteCriteriaManager routeCriteriaManager;
    protected final IAlternativeRouteStateManager alternativeRouteState;
    protected final RouteGuidanceListenerController routeGuidanceListener;
    protected final LogChannel logChannel;
    protected final AlternativeRoutesHandler alternativeRoutesHandler;

    public StartRouteGuidanceSequences(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, RouteCriteriaManager routeCriteriaManager, IAlternativeRouteStateManager iAlternativeRouteStateManager) {
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.routeCriteriaManager = routeCriteriaManager;
        this.alternativeRouteState = iAlternativeRouteStateManager;
        this.routeGuidanceListener = new RouteGuidanceListenerController(this.logChannel);
        this.alternativeRoutesHandler = new AlternativeRoutesHandler();
    }

    protected boolean isAlternativeRouteEnabled() {
        return this.alternativeRouteState.getAlternativeRouteState() == 1;
    }

    public void setSDSNavAlternativeRouteNumberChoiceModel(int n) {
        this.env.getChoiceModel(400872).setValue(n);
    }

    protected RouteOptions[] getConfiguredRouteOptions() {
        RouteOptions[] routeOptionsArray = this.routeCriteriaManager.getRouteCriteria().getRouteOptions(!this.isAlternativeRouteEnabled());
        if (this.isAlternativeRouteEnabled()) {
            return routeOptionsArray;
        }
        return new RouteOptions[]{routeOptionsArray[0]};
    }

    protected CommandList getStartGuidance(final NavLocation navLocation, final ISDSController iSDSController, final int n, final boolean bl) {
        this.logChannel.log(10000000, "StartRouteGuidanceSequences#getStartGuidance() - destination index - %2, replace - %1 ", bl, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                Route route = this.navigation.getRouteManager().getRoute();
                this.logger.log(10000000, "StartRouteGuidanceSequences#getStartGuidance() - current route - %2, destination to add - %1 ", (Object)navLocation, (Object)RouteUtil.formatRouteShort(route));
                int n5 = RouteUtil.getRouteLength(route);
                boolean bl2 = this.dsiResponseContainer.isRgActive();
                if (n5 <= 0 || !bl2) {
                    this.logger.log(10000000, "StartRouteGuidanceSequences#getStartGuidance() - current route - %2, rgActive - %1  - start to single destination.", bl2, (Object)RouteUtil.formatRouteShort(route));
                    this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createStartGuidanceToSingleDestinationCommandList(navLocation, iSDSController));
                    return;
                }
                if (n == -2) {
                    this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createStartGuidanceToSingleDestinationCommandList(navLocation, iSDSController));
                } else if (n == -1) {
                    int n2 = n5 - 1;
                    if (bl) {
                        this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createReplaceDestinationOfActiveRouteCommandList(navLocation, n2, iSDSController));
                    } else {
                        this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createAddStopOverToActiveRouteCommandList(navLocation, n5, iSDSController));
                    }
                } else if (bl) {
                    int n3 = n;
                    if (n >= n5) {
                        n3 = n5 - 1;
                    }
                    this.logger.log(10000000, "StartRouteGuidanceSequences#getStartGuidance() - replace destination %1 at index %2", (Object)navLocation, (long)n3);
                    this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createReplaceDestinationOfActiveRouteCommandList(navLocation, n3, iSDSController));
                } else {
                    int n4 = n;
                    if (n > n5) {
                        n4 = n5;
                    }
                    this.logger.log(10000000, "StartRouteGuidanceSequences#getStartGuidance() - add at destination %1 at index %2", (Object)navLocation, (long)n4);
                    this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createAddStopOverToActiveRouteCommandList(navLocation, n4, iSDSController));
                }
            }
        });
        return commandList;
    }

    public void calculateAlternativeRoutes(final int n, final Route route) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(Util.isHURegionAsia() ? new RGStopGuidanceCommand() : null);
        commandList.add(new NavCommand("StartRouteGuidanceSequences#EvaluateGuidanceActive"){

            public void execute() {
                if (!this.dsiResponseContainer.isRgActive() && !Util.isHURegionAsia()) {
                    this.logger.log(100000, "StartRouteGuidanceSequences#EvaluateGuidanceActive#execute() - abort, route guidance is not active!");
                    this.getCommandList().commandAborted("Route Guidance is not active");
                    return;
                }
                if (this.dsiResponseContainer.getRgRouteCalculationState() == 1) {
                    this.logger.log(100000, "StartRouteGuidanceSequences#EvaluateGuidanceActive#execute() - there is a currently active route calculation - do not proceed. ");
                    this.getCommandList().commandFinished();
                    return;
                }
                this.logger.log(10000000, "StartRouteGuidanceSequences#EvaluateGuidanceActive#execute() - prepare route for alternative calculation.");
                RouteOptions[] routeOptionsArray = StartRouteGuidanceSequences.this.routeCriteriaManager.getRouteCriteria().getRouteOptions(false);
                if (!Util.isHURegionAsia()) {
                    routeOptionsArray[0].setRouteType(8);
                }
                Route route2 = RouteUtil.deleteAllViaPoint(RouteUtil.cloneRoute(route, routeOptionsArray), StartRouteGuidanceSequences.this.logChannel);
                RouteDestination routeDestination = route2.getRoutelist()[0];
                if (routeDestination.routeOptions.length >= 2) {
                    routeDestination.routeOptions[1].cityMautList = (int[])(routeDestination.routeOptions[0].cityMautList == null ? new int[0] : null);
                }
                this.navigation.getMapInterface().startRouteCalculation(route2, n, true, true, false);
                this.getCommandList().commandFinishedWithPostCommand(new RgCalculateRouteCommand(route2, n));
            }
        });
        commandList.execute("StartRouteGuidanceSequences#calculateAlternativeRoutes");
    }

    protected CommandList createStartGuidanceToOffroadDestinationCommandList(NavLocation navLocation, int n) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToOffroadDestinationCommandList( %1 )", (Object)navLocation);
        RouteOptions[] routeOptionsArray = this.getRouteOptionsForOffroad(n);
        Route route = this.getOffroadRouteFromNavLocation(navLocation, n);
        CommandList commandList = this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, this.commandListFactory, true, null, navLocation);
        return commandList;
    }

    protected CommandList createStartGuidanceToSingleDestinationCommandList(NavLocation navLocation, ISDSController iSDSController) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToSingleDestinationCommandList( %1 )", (Object)navLocation);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        Route route = new Route();
        RouteHelper.addDestinationAtPosition(route, new RouteDestination(navLocation, routeOptionsArray, 1), 0);
        CommandList commandList = this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, this.commandListFactory, true, iSDSController, navLocation);
        return commandList;
    }

    protected CommandList createStartGuidanceToSingleDestinationFromKombiCommandList(NavLocation navLocation, ISDSController iSDSController) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToSingleDestinationCommandList( %1 )", (Object)navLocation);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        Route route = new Route();
        RouteHelper.addDestinationAtPosition(route, new RouteDestination(navLocation, routeOptionsArray, 1), 0);
        CommandList commandList = this.createStartGuidanceToRouteFromKombiCommandList(false, routeOptionsArray, route, this.commandListFactory, true, iSDSController, navLocation, false);
        return commandList;
    }

    protected CommandList createAddStopOverToActiveRouteCommandList(final NavLocation navLocation, final int n, final ISDSController iSDSController) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createAddStopOverToActiveRouteCommandList#execute()");
                Route route = this.navigation.getRouteManager().getRoute();
                RouteOptions[] routeOptionsArray = Util.alternativeRoutesWithStopOverAreDisabled(this.env.getFramework()) ? RouteUtil.getOptionsOfFinalDestination(route) : StartRouteGuidanceSequences.this.getConfiguredRouteOptions();
                Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                route2 = RouteUtil.deletePassedDestinationsFromRoute(route2, StartRouteGuidanceSequences.this.logChannel);
                route2 = RouteUtil.cloneRoute(RouteUtil.deleteAllViaPoint(route2, StartRouteGuidanceSequences.this.logChannel), routeOptionsArray);
                RouteHelper.addDestinationAtPosition(route2, new RouteDestination(navLocation, routeOptionsArray, 1), n);
                this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createStartGuidanceToRouteCommandList(routeOptionsArray, route2, StartRouteGuidanceSequences.this.commandListFactory, true, iSDSController, navLocation));
            }
        });
        return commandList;
    }

    protected CommandList createReplaceDestinationOfActiveRouteCommandList(final NavLocation navLocation, final int n, final ISDSController iSDSController) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createReplaceDestinationOfActiveRouteCommandList( %1, %2 )", (Object)navLocation, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createReplaceDestinationOfActiveRouteCommandList()#execute()");
                Route route = this.navigation.getRouteManager().getRoute();
                RouteOptions[] routeOptionsArray = Util.alternativeRoutesWithStopOverAreDisabled(this.env.getFramework()) ? RouteUtil.getOptionsOfFinalDestination(route) : StartRouteGuidanceSequences.this.getConfiguredRouteOptions();
                Route route2 = RouteUtil.cloneRoute(RouteUtil.deleteAllViaPoint(route, StartRouteGuidanceSequences.this.logChannel), routeOptionsArray);
                RouteHelper.replaceDestinationAtPosition(route2, new RouteDestination(navLocation, routeOptionsArray, 1), n);
                route2.setIndexOfCurrentDestination(0L);
                this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createStartGuidanceToRouteCommandList(routeOptionsArray, route2, StartRouteGuidanceSequences.this.commandListFactory, true, iSDSController, navLocation));
            }
        });
        return commandList;
    }

    protected CommandList getRestartGuidanceToRouteCommandList(Route route, boolean bl, ISDSController iSDSController) {
        return this.getRestartGuidanceToRouteCommandList(route, bl, iSDSController, false);
    }

    protected CommandList getRestartGuidanceToRouteCommandList(Route route, boolean bl, ISDSController iSDSController, boolean bl2) {
        RouteOptions[] routeOptionsArray = null;
        if (route.getRouteID() == 2L) {
            OffroadRouteOptionsStateManager offroadRouteOptionsStateManager = new OffroadRouteOptionsStateManager(this.env);
            int n = offroadRouteOptionsStateManager.loadLastPersistetDsiRouteOptionOffRoad();
            routeOptionsArray = this.getRouteOptionsForOffroad(n);
        } else {
            routeOptionsArray = this.getConfiguredRouteOptions();
        }
        return this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, this.commandListFactory, bl, iSDSController, null, bl2);
    }

    protected CommandList getRestartGuidanceToRouteCommandList(Route route, boolean bl, boolean bl2, ISDSController iSDSController, boolean bl3) {
        RouteOptions[] routeOptionsArray = !bl2 && (long)route.getRoutelist().length > route.getIndexOfCurrentDestination() ? route.getRoutelist()[(int)route.getIndexOfCurrentDestination()].getRouteOptions() : this.getConfiguredRouteOptions();
        return this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, this.commandListFactory, bl, iSDSController, null, bl3);
    }

    protected void resumeRouteGuidance(Route route, boolean bl, ISDSController iSDSController) {
        this.logChannel.log(1000000, "[RouteGuidance] StartRouteGuidanceSequences#resumeRouteGuidance(%1, %2)", bl);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        CommandList commandList = this.createStartGuidanceToRouteCommandList(true, routeOptionsArray, route, this.commandListFactory, bl, iSDSController, null);
        commandList.execute("StartRouteGuidanceSequences#resumeRouteGuidance");
    }

    protected void resumeRouteGuidanceToOffroad(Route route, boolean bl, ISDSController iSDSController) {
        this.logChannel.log(1000000, "[RouteGuidance] StartRouteGuidanceSequences#resumeRouteGuidanceToOffroad(%1, %2)", bl);
        OffroadRouteOptionsStateManager offroadRouteOptionsStateManager = new OffroadRouteOptionsStateManager(this.env);
        int n = offroadRouteOptionsStateManager.loadLastPersistetDsiRouteOptionOffRoad();
        RouteOptions[] routeOptionsArray = this.getRouteOptionsForOffroad(n);
        CommandList commandList = this.createStartGuidanceToRouteCommandList(true, routeOptionsArray, route, this.commandListFactory, bl, iSDSController, null);
        commandList.execute("StartRouteGuidanceSequences#resumeRouteGuidance");
    }

    protected CommandList createStartGuidanceToRouteCommandList(RouteOptions[] routeOptionsArray, Route route, ICommandListFactory iCommandListFactory, boolean bl, ISDSController iSDSController, NavLocation navLocation) {
        return this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, iCommandListFactory, bl, iSDSController, navLocation, false);
    }

    protected CommandList createStartGuidanceToRouteCommandList(RouteOptions[] routeOptionsArray, Route route, ICommandListFactory iCommandListFactory, boolean bl, ISDSController iSDSController, NavLocation navLocation, boolean bl2) {
        return this.createStartGuidanceToRouteCommandList(false, routeOptionsArray, route, iCommandListFactory, bl, iSDSController, navLocation, bl2);
    }

    protected CommandList createStartGuidanceToRouteCommandList(boolean bl, RouteOptions[] routeOptionsArray, Route route, ICommandListFactory iCommandListFactory, boolean bl2, ISDSController iSDSController, NavLocation navLocation) {
        return this.createStartGuidanceToRouteCommandList(bl, routeOptionsArray, route, iCommandListFactory, bl2, iSDSController, navLocation, false);
    }

    protected CommandList createStartGuidanceToRouteCommandList(boolean bl, final RouteOptions[] routeOptionsArray, final Route route, ICommandListFactory iCommandListFactory, final boolean bl2, ISDSController iSDSController, final NavLocation navLocation, final boolean bl3) {
        int n;
        Buffer buffer = new Buffer();
        buffer.append("resume : ").append(bl);
        buffer.append("\nforcestart : ").append(bl3);
        buffer.append("\nusedRouteOptions : ");
        for (n = 0; n < routeOptionsArray.length; ++n) {
            buffer.append("\n").append(routeOptionsArray[n]);
        }
        buffer.append("\ndestinationsRoute : ").append(route);
        buffer.append("\ndestination : ").append(navLocation);
        this.logChannel.log(1000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList() :\n%1", (Object)buffer.toString());
        n = bl && this.env.getContainer().isRouteResumePossible() ? 1 : 0;
        final int n2 = n != 0 ? 0 : routeOptionsArray.length;
        CommandList commandList = iCommandListFactory.createCommandList();
        this.doRouteBriefing(commandList, route);
        if (this.env.getChoiceModel(400573).getValue() == 1 && this.env.getChoiceModel(401923).getValue() == 1) {
            commandList.add(new TrStopTraceRecording());
            commandList.add(new TrStoreTrace(null));
        }
        commandList.add(new PredictiveNavigationSetActivationModeCommand(1));
        if (this.env.getFramework().isAsia()) {
            commandList.add(new StoreStartingTimeCommand());
        }
        commandList.add(this.getStopRouteGuidanceSequence());
        commandList.add(new RmMakeRoutePersistentCommand(route));
        commandList.add(this.getCommandAfterRoutePersisted());
        commandList.add(new ResetSpellerStackCommand());
        commandList.add(new NavCommand("CheckRouteConsistency"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList - CheckRouteConsistency#execute()");
                Route route = this.navigation.getRouteManager().getRoute();
                if (RouteUtil.getRouteLength(route) == 0) {
                    String string = "current on-road route is null!";
                    this.logger.log(100000, "[RouteGuidance] StartRouteGuidanceSequences#execute() - %1 ", (Object)string);
                    this.getCommandList().commandAborted(string);
                    return;
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("NotifyListenersAboutDestination"){

            public void execute() {
                StartRouteGuidanceSequences.this.routeGuidanceListener.routeGuidanceRequested(route, navLocation);
                this.getCommandList().commandFinished();
            }
        });
        if (MapEnv.waitForReadyBeforeEnterMap(this.env) && n2 != 0) {
            commandList.add(new WaitForMapReadyCommand(){

                public void execute() {
                    super.execute();
                    Route route = this.navigation.getRouteManager().getRoute();
                    Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                    if (route2 != null) {
                        int n = RouteUtil.getRouteLength(route2);
                        this.navigation.getMapInterface().prepareStartRouteCalculation(routeOptionsArray.length == 1 || bl3, navLocation);
                        if (bl3) {
                            StartRouteGuidanceSequences.this.logChannel.log(1000000, "%1#createStartGuidanceToRouteCommandList - force start", (Object)this.CLASS_NAME);
                            this.navigation.getMapInterface().startRouteCalculation(route2, 1, bl2, false, false);
                        } else {
                            StartRouteGuidanceSequences.this.logChannel.log(1000000, "%1#createStartGuidanceToRouteCommandList - Normal route calculation depending on options. routeListLength=%2", (Object)this.CLASS_NAME, (long)n);
                            this.navigation.getMapInterface().startRouteCalculation(route2, n2, bl2, StartRouteGuidanceSequences.this.isAlternativeRouteEnabled(), false);
                        }
                    } else {
                        this.getCommandList().commandAborted(new StringBuffer().append(this.CLASS_NAME).append("#createStartGuidanceToRouteCommandList - guidanceRoute is null!").toString());
                    }
                }
            });
        } else {
            commandList.add(new NavCommand("StartRouteGuidanceSequences#prepareMap"){

                public void execute() {
                    Route route = this.navigation.getRouteManager().getRoute();
                    Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                    this.navigation.getMapInterface().startRouteCalculation(route2, n2, bl2, StartRouteGuidanceSequences.this.isAlternativeRouteEnabled(), false);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new NavCommand("StartRouteGuidanceSequences#PrepMapStartCalculation"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList#execute()");
                Route route = this.navigation.getRouteManager().getRoute();
                Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                this.navigation.getDemoModeManager().setDemoModeRoute(route2);
                if (n2 == 3 && MapEnv.useRgCalculate1stRouteAndPostponeRemaining()) {
                    this.getCommandList().commandFinishedWithPostCommand(new RgCalculate1stRouteAndPostponeRemainingCommand(route2, n2, false));
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new RgCalculateRouteCommand(route2, n2));
                }
            }
        });
        if (this.env.getFramework().isAsia()) {
            commandList.add(new TriggerErrorDumpCommand());
        }
        commandList.add(new NavCommand("StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList set NAV_RESET_INPUT_MODE_CHOICE to navi"){

            public void execute() {
                this.env.getChoiceModel(170).setValue(0);
                this.getCommandList().commandFinished();
            }
        });
        commandList.setErrorCommand(new NavCommand("ErrorHandling"){

            public void execute() {
                this.navigation.getMapInterface().cancelStartRouteCalculation();
                StartRouteGuidanceSequences.this.routeGuidanceListener.cancelStartRouteCalculation();
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    protected CommandList createStartGuidanceToRouteFromKombiCommandList(boolean bl, final RouteOptions[] routeOptionsArray, final Route route, ICommandListFactory iCommandListFactory, final boolean bl2, ISDSController iSDSController, final NavLocation navLocation, final boolean bl3) {
        int n;
        Buffer buffer = new Buffer();
        buffer.append("resume : ").append(bl);
        buffer.append("\nforcestart : ").append(bl3);
        buffer.append("\nusedRouteOptions : ");
        for (n = 0; n < routeOptionsArray.length; ++n) {
            buffer.append("\n").append(routeOptionsArray[n]);
        }
        buffer.append("\ndestinationsRoute : ").append(route);
        buffer.append("\ndestination : ").append(navLocation);
        this.logChannel.log(1000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList() :\n%1", (Object)buffer.toString());
        n = bl && this.env.getContainer().isRouteResumePossible() ? 1 : 0;
        final int n2 = n != 0 ? 0 : routeOptionsArray.length;
        CommandList commandList = iCommandListFactory.createCommandList();
        this.doRouteBriefing(commandList, route);
        if (this.env.getChoiceModel(400573).getValue() == 1 && this.env.getChoiceModel(401923).getValue() == 1) {
            commandList.add(new TrStopTraceRecording());
            commandList.add(new TrStoreTrace(null));
        }
        commandList.add(new PredictiveNavigationSetActivationModeCommand(1));
        if (this.env.getFramework().isAsia()) {
            commandList.add(new StoreStartingTimeCommand());
        }
        commandList.add(this.getStopRouteGuidanceSequence());
        commandList.add(new RmMakeRoutePersistentCommand(route));
        commandList.add(this.getCommandAfterRoutePersisted());
        commandList.add(new ResetSpellerStackCommand());
        commandList.add(new NavCommand("CheckRouteConsistency"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList - CheckRouteConsistency#execute()");
                Route route = this.navigation.getRouteManager().getRoute();
                if (RouteUtil.getRouteLength(route) == 0) {
                    String string = "current on-road route is null!";
                    this.logger.log(100000, "[RouteGuidance] StartRouteGuidanceSequences#execute() - %1 ", (Object)string);
                    this.getCommandList().commandAborted(string);
                    return;
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("NotifyListenersAboutDestination"){

            public void execute() {
                StartRouteGuidanceSequences.this.routeGuidanceListener.routeGuidanceRequested(route, navLocation);
                this.getCommandList().commandFinished();
            }
        });
        if (MapEnv.waitForReadyBeforeEnterMap(this.env) && n2 != 0) {
            commandList.add(new WaitForMapReadyCommand(){

                public void execute() {
                    super.execute();
                    Route route = this.navigation.getRouteManager().getRoute();
                    Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                    if (route2 != null) {
                        int n = RouteUtil.getRouteLength(route2);
                        this.navigation.getMapInterface().prepareStartRouteCalculation(routeOptionsArray.length == 1 || bl3, navLocation);
                        if (bl3) {
                            StartRouteGuidanceSequences.this.logChannel.log(1000000, "%1#createStartGuidanceToRouteCommandList - force start", (Object)this.CLASS_NAME);
                            this.navigation.getMapInterface().startRouteCalculation(route2, 1, bl2, false, true);
                        } else {
                            StartRouteGuidanceSequences.this.logChannel.log(1000000, "%1#createStartGuidanceToRouteCommandList - Normal route calculation depending on options. routeListLength=%2", (Object)this.CLASS_NAME, (long)n);
                            this.navigation.getMapInterface().startRouteCalculation(route2, n2, bl2, StartRouteGuidanceSequences.this.isAlternativeRouteEnabled(), true);
                        }
                    } else {
                        this.getCommandList().commandAborted(new StringBuffer().append(this.CLASS_NAME).append("#createStartGuidanceToRouteCommandList - guidanceRoute is null!").toString());
                    }
                }
            });
        } else {
            commandList.add(new NavCommand("StartRouteGuidanceSequences#prepareMap"){

                public void execute() {
                    Route route = this.navigation.getRouteManager().getRoute();
                    Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                    this.navigation.getMapInterface().startRouteCalculation(route2, n2, bl2, StartRouteGuidanceSequences.this.isAlternativeRouteEnabled(), true);
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new NavCommand("StartRouteGuidanceSequences#PrepMapStartCalculation"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList#execute()");
                Route route = this.navigation.getRouteManager().getRoute();
                Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                this.navigation.getDemoModeManager().setDemoModeRoute(route2);
                if (n2 == 3 && MapEnv.useRgCalculate1stRouteAndPostponeRemaining()) {
                    this.getCommandList().commandFinishedWithPostCommand(new RgCalculate1stRouteAndPostponeRemainingCommand(route2, n2, false));
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new RgCalculateRouteCommand(route2, n2));
                }
            }
        });
        if (this.env.getFramework().isAsia()) {
            commandList.add(new TriggerErrorDumpCommand());
        }
        commandList.add(new NavCommand("StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList set NAV_RESET_INPUT_MODE_CHOICE to navi"){

            public void execute() {
                this.env.getChoiceModel(170).setValue(0);
                this.getCommandList().commandFinished();
            }
        });
        commandList.setErrorCommand(new NavCommand("ErrorHandling"){

            public void execute() {
                this.navigation.getMapInterface().cancelStartRouteCalculation();
                StartRouteGuidanceSequences.this.routeGuidanceListener.cancelStartRouteCalculation();
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    protected Command getCommandAfterRoutePersisted() {
        return null;
    }

    protected void doRouteBriefing(CommandList commandList, Route route) {
    }

    protected CommandList getStopRouteGuidanceSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RgStopRubberBandCommand(true));
        commandList.add(new RgStopGuidanceGeneralCommand());
        return commandList;
    }

    protected void startGuidanceToCalculatedRoute(final int n, final Route route) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#startGuidanceToCalculatedRoute( %1 )", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.env.getFramework().isAsia()) {
            commandList.add(new StoreStartingTimeCommand());
        }
        commandList.add(new NavCommand("StartRouteGuidanceSequences#PersistCorrectRouteOptions"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#PersistCorrectRouteOptions#execute() - currentAlternativeRouteIndex: %1, new route index: %2 )", (long)StartRouteGuidanceSequences.this.alternativeRoutesHandler.getLastSelectedRouteIndex(), (long)n);
                this.navigation.getMapInterface().setRouteCalculationToSingelRoute(true);
                if (StartRouteGuidanceSequences.this.alternativeRoutesHandler.getLastSelectedRouteIndex() != n) {
                    RouteOptions[] routeOptionsArray = StartRouteGuidanceSequences.this.routeCriteriaManager.getRouteCriteria().getRouteOptions(true);
                    RouteOptions[] routeOptionsArray2 = new RouteOptions[]{routeOptionsArray[n]};
                    Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray2);
                    this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(route2));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new RGStartGuidanceCalculatedRoute(n));
        commandList.add(new NavCommand("StartRouteGuidanceSequences#CheckCalculatedRouteMatchesRouteCriteria"){

            public void execute() {
                RouteOptions[] routeOptionsArray = StartRouteGuidanceSequences.this.routeCriteriaManager.getRouteCriteria().getRouteOptions(true);
                CalculatedRouteListElement[] calculatedRouteListElementArray = this.dsiResponseContainer.getCalculatedRoutes();
                if (calculatedRouteListElementArray.length > 0) {
                    StartRouteGuidanceSequences.this.checkCalculatedRouteMatchesRouteCriteria(routeOptionsArray[n], calculatedRouteListElementArray[0]);
                } else {
                    this.logger.log(100000, "[RouteGuidance] StartRouteGuidanceSequences#CheckCalculatedRouteMatchesRouteCriteria#execute() no calculated routes avalibale");
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("StartRouteGuidanceSequences#SaveCurrentRouteIndex"){

            public void execute() {
                StartRouteGuidanceSequences.this.alternativeRoutesHandler.setLastSelectedRouteIndex(n);
                this.getCommandList().commandFinished();
            }
        });
        if (this.env.getFramework().isAsia()) {
            commandList.add(new TriggerErrorDumpCommand());
        }
        commandList.execute("StartRouteGuidanceSequences#startGuidanceCalculatedRoute");
    }

    public void checkAndCalculateAlternativeRoutes(boolean bl, int n, Route route) {
        boolean bl2 = this.alternativeRoutesHandler.isExpectsAlternativeRoutesCalculation();
        this.alternativeRoutesHandler.setExpectsAlternativeRoutesCalculation(false);
        if (bl && bl2) {
            this.calculateAlternativeRoutes(n, route);
        }
    }

    public CommandList getSetRouteOptionsCommandList(final RouteOptions routeOptions, final Route route) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#getSetRouteOptionsCommandList( %1 )", (Object)routeOptions);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NavCommand(){

            public void execute() {
                if (!this.dsiResponseContainer.isRgActive()) {
                    this.getCommandList().commandAborted("no active rotue guidance, nothing to do.");
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new NavCommand("StartRouteGuidanceSequences#PersistCorrectRouteOptions"){

            public void execute() {
                this.logger.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#PersistCorrectRouteOptions#execute() - currentAlternativeRouteIndex: %1, new route index: %2 )", (long)StartRouteGuidanceSequences.this.alternativeRoutesHandler.getLastSelectedRouteIndex(), 0L);
                if (StartRouteGuidanceSequences.this.alternativeRoutesHandler.getLastSelectedRouteIndex() != 0) {
                    RouteOptions[] routeOptionsArray = new RouteOptions[]{routeOptions};
                    Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
                    this.getCommandList().commandFinishedWithPostCommand(new RmMakeRoutePersistentCommand(route2));
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new RGSetRouteOptionsCommand(routeOptions));
        commandList.add(new NavCommand("StartRouteGuidanceSequences#SaveCurrentRouteIndex"){

            public void execute() {
                StartRouteGuidanceSequences.this.alternativeRoutesHandler.setLastSelectedRouteIndex(0);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getInsertAsStopOverCommandList(Route route, final NavLocation navLocation, int n, boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#getInsertAsStopOverCommandList( route: %1, currentLocation: %2, insertPosition: %3 )", (Object)RouteUtil.formatRouteShort(route), (Object)navLocation, (long)n);
        this.logChannel.log(10000000, "[RouteGuidance] StartRouteGuidanceSequences#getInsertAsStopOverCommandList( restartGuidance: %1 )", bl);
        n = this.transformInsertPosition(route, n);
        final RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        final Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
        if (bl2) {
            RouteHelper.replaceDestinationAtPosition(route2, new RouteDestination(navLocation, routeOptionsArray, 1), n);
        } else {
            RouteHelper.addDestinationAtPosition(route2, new RouteDestination(navLocation, routeOptionsArray, 1), n);
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put(TRANSFORMED_INSERT_POS, new Integer(n));
        if (!bl) {
            if (this.env.getContainer().isRgActive()) {
                commandList.add(new RGStopGuidanceCommand());
            }
            commandList.add(new RmMakeRoutePersistentCommand(route2));
        }
        if (this.env.getContainer().isRgActive() && bl) {
            commandList.add(new NavCommand("startRG"){

                public void execute() {
                    this.logger.log(1000000, "StartRouteGuidanceSequences#startRG()");
                    this.env.getChoiceModel(170).setValue(0);
                    this.getCommandList().commandFinishedWithPostSequence(StartRouteGuidanceSequences.this.createStartGuidanceToRouteCommandList(true, routeOptionsArray, route2, StartRouteGuidanceSequences.this.commandListFactory, true, null, navLocation));
                }
            });
        }
        return commandList;
    }

    private int transformInsertPosition(Route route, int n) {
        int n2 = RouteUtil.getRouteLength(route);
        int n3 = RouteUtil.getIndexOfCurrentDestination(route);
        if (n <= -2) {
            n = Math.max(0, n2 - 2);
        } else if (n <= -1) {
            n = n3;
        } else if (n < n3) {
            n = n3;
        } else if (n > n2) {
            n = n2;
        }
        return n;
    }

    public void start(BundleContext bundleContext) throws Exception {
        this.routeGuidanceListener.start(bundleContext);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        this.routeGuidanceListener.stop(bundleContext);
    }

    public Route getOffroadRouteFromNavLocation(NavLocation navLocation, int n) {
        RouteOptions[] routeOptionsArray = this.getRouteOptionsForOffroad(n);
        Route route = new Route();
        route.setRouteID(2L);
        RouteHelper.addDestinationAtPosition(route, new RouteDestination(navLocation, routeOptionsArray, 128), 0);
        return route;
    }

    private RouteOptions[] getRouteOptionsForOffroad(int n) {
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        for (int i2 = 0; i2 < routeOptionsArray.length; ++i2) {
            routeOptionsArray[i2].setRouteType(4);
            routeOptionsArray[i2].setTrail(n);
        }
        return routeOptionsArray;
    }

    protected void checkCalculatedRouteMatchesRouteCriteria(RouteOptions routeOptions, CalculatedRouteListElement calculatedRouteListElement) {
    }
}

