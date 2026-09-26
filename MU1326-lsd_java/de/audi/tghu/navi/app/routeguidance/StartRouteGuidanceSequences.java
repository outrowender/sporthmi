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
import de.audi.tghu.navi.app.command.via.RgStopRubberBandCommand;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.routeguidance.AlternativeRoutesHandler;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.OffroadRouteOptionsStateManager;
import de.audi.tghu.navi.app.routeguidance.RouteGuidanceListenerController;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$1;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$10;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$11;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$12;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$13;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$14;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$15;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$16;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$17;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$18;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$19;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$2;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$20;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$21;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$22;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$23;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$24;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$25;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$3;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$4;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$5;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$6;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$7;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$8;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences$9;
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
    private static final int REL_STOPOVERARRAY_INDEX_BEFORE_DESTINATON;
    private static final int OFFROAD_TRACE_ACTIVE;
    public static String TRANSFORMED_INSERT_POS;
    private static final int ONLY_ONE_ROUTE;
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
        this.env.getChoiceModel(-400751104).setValue(n);
    }

    protected RouteOptions[] getConfiguredRouteOptions() {
        RouteOptions[] routeOptionsArray = this.routeCriteriaManager.getRouteCriteria().getRouteOptions(!this.isAlternativeRouteEnabled());
        if (this.isAlternativeRouteEnabled()) {
            return routeOptionsArray;
        }
        return new RouteOptions[]{routeOptionsArray[0]};
    }

    protected CommandList getStartGuidance(NavLocation navLocation, ISDSController iSDSController, int n, boolean bl) {
        this.logChannel.log(-2137614336, "StartRouteGuidanceSequences#getStartGuidance() - destination index - %2, replace - %1 ", bl, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StartRouteGuidanceSequences$1(this, navLocation, iSDSController, n, bl));
        return commandList;
    }

    public void calculateAlternativeRoutes(int n, Route route) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(Util.isHURegionAsia() ? new RGStopGuidanceCommand() : null);
        commandList.add(new StartRouteGuidanceSequences$2(this, "StartRouteGuidanceSequences#EvaluateGuidanceActive", route, n));
        commandList.execute("StartRouteGuidanceSequences#calculateAlternativeRoutes");
    }

    protected CommandList createStartGuidanceToOffroadDestinationCommandList(NavLocation navLocation, int n) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToOffroadDestinationCommandList( %1 )", (Object)navLocation);
        RouteOptions[] routeOptionsArray = this.getRouteOptionsForOffroad(n);
        Route route = this.getOffroadRouteFromNavLocation(navLocation, n);
        CommandList commandList = this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, this.commandListFactory, true, null, navLocation);
        return commandList;
    }

    protected CommandList createStartGuidanceToSingleDestinationCommandList(NavLocation navLocation, ISDSController iSDSController) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToSingleDestinationCommandList( %1 )", (Object)navLocation);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        Route route = new Route();
        RouteHelper.addDestinationAtPosition(route, new RouteDestination(navLocation, routeOptionsArray, 1), 0);
        CommandList commandList = this.createStartGuidanceToRouteCommandList(routeOptionsArray, route, this.commandListFactory, true, iSDSController, navLocation);
        return commandList;
    }

    protected CommandList createStartGuidanceToSingleDestinationFromKombiCommandList(NavLocation navLocation, ISDSController iSDSController) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToSingleDestinationCommandList( %1 )", (Object)navLocation);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        Route route = new Route();
        RouteHelper.addDestinationAtPosition(route, new RouteDestination(navLocation, routeOptionsArray, 1), 0);
        CommandList commandList = this.createStartGuidanceToRouteFromKombiCommandList(false, routeOptionsArray, route, this.commandListFactory, true, iSDSController, navLocation, false);
        return commandList;
    }

    protected CommandList createAddStopOverToActiveRouteCommandList(NavLocation navLocation, int n, ISDSController iSDSController) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StartRouteGuidanceSequences$3(this, navLocation, n, iSDSController));
        return commandList;
    }

    protected CommandList createReplaceDestinationOfActiveRouteCommandList(NavLocation navLocation, int n, ISDSController iSDSController) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#createReplaceDestinationOfActiveRouteCommandList( %1, %2 )", (Object)navLocation, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StartRouteGuidanceSequences$4(this, navLocation, n, iSDSController));
        return commandList;
    }

    protected CommandList getRestartGuidanceToRouteCommandList(Route route, boolean bl, ISDSController iSDSController) {
        return this.getRestartGuidanceToRouteCommandList(route, bl, iSDSController, false);
    }

    protected CommandList getRestartGuidanceToRouteCommandList(Route route, boolean bl, ISDSController iSDSController, boolean bl2) {
        RouteOptions[] routeOptionsArray = null;
        if (route.getRouteID() == 0) {
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
        this.logChannel.log(1078071040, "[RouteGuidance] StartRouteGuidanceSequences#resumeRouteGuidance(%1, %2)", bl);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        CommandList commandList = this.createStartGuidanceToRouteCommandList(true, routeOptionsArray, route, this.commandListFactory, bl, iSDSController, null);
        commandList.execute("StartRouteGuidanceSequences#resumeRouteGuidance");
    }

    protected void resumeRouteGuidanceToOffroad(Route route, boolean bl, ISDSController iSDSController) {
        this.logChannel.log(1078071040, "[RouteGuidance] StartRouteGuidanceSequences#resumeRouteGuidanceToOffroad(%1, %2)", bl);
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

    protected CommandList createStartGuidanceToRouteCommandList(boolean bl, RouteOptions[] routeOptionsArray, Route route, ICommandListFactory iCommandListFactory, boolean bl2, ISDSController iSDSController, NavLocation navLocation, boolean bl3) {
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
        this.logChannel.log(1078071040, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList() :\n%1", (Object)buffer.toString());
        n = bl && this.env.getContainer().isRouteResumePossible() ? 1 : 0;
        int n2 = n != 0 ? 0 : routeOptionsArray.length;
        CommandList commandList = iCommandListFactory.createCommandList();
        this.doRouteBriefing(commandList, route);
        if (this.env.getChoiceModel(-1122236928).getValue() == 1 && this.env.getChoiceModel(52561408).getValue() == 1) {
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
        commandList.add(new StartRouteGuidanceSequences$5(this, "CheckRouteConsistency"));
        commandList.add(new StartRouteGuidanceSequences$6(this, "NotifyListenersAboutDestination", route, navLocation));
        if (MapEnv.waitForReadyBeforeEnterMap(this.env) && n2 != 0) {
            commandList.add(new StartRouteGuidanceSequences$7(this, routeOptionsArray, bl3, navLocation, bl2, n2));
        } else {
            commandList.add(new StartRouteGuidanceSequences$8(this, "StartRouteGuidanceSequences#prepareMap", routeOptionsArray, n2, bl2));
        }
        commandList.add(new StartRouteGuidanceSequences$9(this, "StartRouteGuidanceSequences#PrepMapStartCalculation", routeOptionsArray, n2));
        if (this.env.getFramework().isAsia()) {
            commandList.add(new TriggerErrorDumpCommand());
        }
        commandList.add(new StartRouteGuidanceSequences$10(this, "StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList set NAV_RESET_INPUT_MODE_CHOICE to navi"));
        commandList.setErrorCommand(new StartRouteGuidanceSequences$11(this, "ErrorHandling"));
        return commandList;
    }

    protected CommandList createStartGuidanceToRouteFromKombiCommandList(boolean bl, RouteOptions[] routeOptionsArray, Route route, ICommandListFactory iCommandListFactory, boolean bl2, ISDSController iSDSController, NavLocation navLocation, boolean bl3) {
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
        this.logChannel.log(1078071040, "[RouteGuidance] StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList() :\n%1", (Object)buffer.toString());
        n = bl && this.env.getContainer().isRouteResumePossible() ? 1 : 0;
        int n2 = n != 0 ? 0 : routeOptionsArray.length;
        CommandList commandList = iCommandListFactory.createCommandList();
        this.doRouteBriefing(commandList, route);
        if (this.env.getChoiceModel(-1122236928).getValue() == 1 && this.env.getChoiceModel(52561408).getValue() == 1) {
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
        commandList.add(new StartRouteGuidanceSequences$12(this, "CheckRouteConsistency"));
        commandList.add(new StartRouteGuidanceSequences$13(this, "NotifyListenersAboutDestination", route, navLocation));
        if (MapEnv.waitForReadyBeforeEnterMap(this.env) && n2 != 0) {
            commandList.add(new StartRouteGuidanceSequences$14(this, routeOptionsArray, bl3, navLocation, bl2, n2));
        } else {
            commandList.add(new StartRouteGuidanceSequences$15(this, "StartRouteGuidanceSequences#prepareMap", routeOptionsArray, n2, bl2));
        }
        commandList.add(new StartRouteGuidanceSequences$16(this, "StartRouteGuidanceSequences#PrepMapStartCalculation", routeOptionsArray, n2));
        if (this.env.getFramework().isAsia()) {
            commandList.add(new TriggerErrorDumpCommand());
        }
        commandList.add(new StartRouteGuidanceSequences$17(this, "StartRouteGuidanceSequences#createStartGuidanceToRouteCommandList set NAV_RESET_INPUT_MODE_CHOICE to navi"));
        commandList.setErrorCommand(new StartRouteGuidanceSequences$18(this, "ErrorHandling"));
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

    protected void startGuidanceToCalculatedRoute(int n, Route route) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#startGuidanceToCalculatedRoute( %1 )", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.env.getFramework().isAsia()) {
            commandList.add(new StoreStartingTimeCommand());
        }
        commandList.add(new StartRouteGuidanceSequences$19(this, "StartRouteGuidanceSequences#PersistCorrectRouteOptions", n, route));
        commandList.add(new RGStartGuidanceCalculatedRoute(n));
        commandList.add(new StartRouteGuidanceSequences$20(this, "StartRouteGuidanceSequences#CheckCalculatedRouteMatchesRouteCriteria", n));
        commandList.add(new StartRouteGuidanceSequences$21(this, "StartRouteGuidanceSequences#SaveCurrentRouteIndex", n));
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

    public CommandList getSetRouteOptionsCommandList(RouteOptions routeOptions, Route route) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#getSetRouteOptionsCommandList( %1 )", (Object)routeOptions);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new StartRouteGuidanceSequences$22(this));
        commandList.add(new StartRouteGuidanceSequences$23(this, "StartRouteGuidanceSequences#PersistCorrectRouteOptions", routeOptions, route));
        commandList.add(new RGSetRouteOptionsCommand(routeOptions));
        commandList.add(new StartRouteGuidanceSequences$24(this, "StartRouteGuidanceSequences#SaveCurrentRouteIndex"));
        return commandList;
    }

    public CommandList getInsertAsStopOverCommandList(Route route, NavLocation navLocation, int n, boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#getInsertAsStopOverCommandList( route: %1, currentLocation: %2, insertPosition: %3 )", (Object)RouteUtil.formatRouteShort(route), (Object)navLocation, (long)n);
        this.logChannel.log(-2137614336, "[RouteGuidance] StartRouteGuidanceSequences#getInsertAsStopOverCommandList( restartGuidance: %1 )", bl);
        n = this.transformInsertPosition(route, n);
        RouteOptions[] routeOptionsArray = this.getConfiguredRouteOptions();
        Route route2 = RouteUtil.cloneRoute(route, routeOptionsArray);
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
            commandList.add(new StartRouteGuidanceSequences$25(this, "startRG", routeOptionsArray, route2, navLocation));
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

    @Override
    public void start(BundleContext bundleContext) {
        this.routeGuidanceListener.start(bundleContext);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.routeGuidanceListener.stop(bundleContext);
    }

    public Route getOffroadRouteFromNavLocation(NavLocation navLocation, int n) {
        RouteOptions[] routeOptionsArray = this.getRouteOptionsForOffroad(n);
        Route route = new Route();
        route.setRouteID(0);
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

    static {
        TRANSFORMED_INSERT_POS = "TRANSFORMED_INSERT_POS";
    }
}

