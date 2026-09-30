/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IPersistenceHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGSetRouteOptionsCommand;
import de.audi.tghu.navi.app.command.RGStartGuidanceCalculatedRouteByUID;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaRouteUtil;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.presentationmode.DemoModeManager;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceStateModelAccess;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.RouteEventListener;
import de.audi.tghu.navi.app.routeguidance.RoutePersistenceController;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.util.RouteHelper;
import org.osgi.framework.BundleContext;

public abstract class RouteManager
implements IRouteManager,
PowerEventListener,
IPersistenceHandler {
    protected static final int NUMBER_OF_ALTERNATIVE_ROUTES = 3;
    protected final int maximumNumberOfDestinations;
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final ISDSController sdsController;
    protected StartRouteGuidanceSequences startRouteGuidanceHelper;
    protected final RouteCriteriaManager routeCriteriaManager;
    protected final IRouteGuidanceStateModelAccess modelAccess;
    protected final TripHandler tripHandler;
    protected final RoutePersistenceController routePersistenceController;
    protected final IAlternativeRouteStateManager alternativeRouteState;
    protected DemoModeManager demoModeManager;
    protected RouteEventListener routeEventListener;
    protected Route route;
    private boolean rgInfoForNextDestinationIsPending;
    private boolean updateRgCurrentRouteAndAllDestinationsReached = false;

    public RouteManager(NavigationEnv navigationEnv, int n, RouteCriteriaManager routeCriteriaManager, ICommandListFactory iCommandListFactory, IAlternativeRouteStateManager iAlternativeRouteStateManager, IRouteGuidanceStateModelAccess iRouteGuidanceStateModelAccess, OperationManager operationManager, ISDSController iSDSController, MapInterface mapInterface, ClusterService clusterService) {
        this.env = navigationEnv;
        this.alternativeRouteState = iAlternativeRouteStateManager;
        this.tripHandler = this.createTripHandler(navigationEnv, mapInterface, clusterService);
        this.maximumNumberOfDestinations = n;
        this.commandListFactory = iCommandListFactory;
        this.routeCriteriaManager = routeCriteriaManager;
        this.modelAccess = iRouteGuidanceStateModelAccess;
        this.sdsController = iSDSController;
        this.initStartRouteGuidanceSequences();
        this.routePersistenceController = new RoutePersistenceController(navigationEnv.getLogChannel(), navigationEnv, operationManager, iCommandListFactory);
        this.rgInfoForNextDestinationIsPending = false;
    }

    protected TripHandler createTripHandler(NavigationEnv navigationEnv, MapInterface mapInterface, ClusterService clusterService) {
        return new TripHandler(navigationEnv, this, mapInterface, clusterService);
    }

    protected void initStartRouteGuidanceSequences() {
        this.startRouteGuidanceHelper = new StartRouteGuidanceSequences(this.commandListFactory, this.env, this.routeCriteriaManager, this.alternativeRouteState);
    }

    public int getMaxNumberOfDestinations() {
        return this.maximumNumberOfDestinations;
    }

    public boolean canAddHardDestinations() {
        int n = RouteUtil.getRouteLength(this.route);
        return n < this.getMaxNumberOfDestinations();
    }

    public boolean canAddSoftDestinations() {
        return false;
    }

    public Route getRoute() {
        return this.route;
    }

    public void setTimeMode(int n) {
        this.tripHandler.setTimeMode(n);
    }

    public void toggleTimeMode(int n) {
        this.tripHandler.toggleTimeMode(n);
    }

    public void refreshTripData() {
        this.tripHandler.refreshTripData();
    }

    public Route getFilteredRoute() {
        return ViaRouteUtil.filterViaFromRoute(this.route);
    }

    public void resetSettings() {
        this.tripHandler.resetSettings();
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RmMakeRoutePersistentCommand(new Route()));
        commandList.execute("RouteManager#resetSettings");
    }

    public TripHandler.TripData getTripDataAuto() {
        return this.tripHandler.getTripDataAuto();
    }

    public void startGuidance(NavLocation navLocation, int n, boolean bl, boolean bl2) {
        CommandList commandList = this.getStartGuidance(navLocation, n, bl, bl2);
        commandList.execute("RouteManager#startGuidance");
    }

    public CommandList getStartGuidance(NavLocation navLocation, int n, boolean bl, boolean bl2) {
        this.env.getLogChannel().log(100000, "RouteManager#getStartGuidance() - abort SDS - %1", bl2);
        ISDSController iSDSController = bl2 ? this.sdsController : null;
        return this.startRouteGuidanceHelper.getStartGuidance(navLocation, iSDSController, n, bl);
    }

    public void startRouteGuidanceToOffroadDestination(NavLocation navLocation, int n) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#startRouteGuidanceToOffroadDestination( %1 )", (Object)navLocation);
        CommandList commandList = this.getStartRouteGuidanceToOffroadDestinationSequence(navLocation, n);
        commandList.execute("RouteManager#startRouteGuidanceToOffroadDestination");
    }

    public void startRouteGuidanceToSingleDestination(NavLocation navLocation) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#startRouteGuidanceToSingleDestination( %1 )", (Object)navLocation);
        CommandList commandList = this.getStartRouteGuidanceToSingleDestinationSequence(navLocation);
        commandList.execute("RouteManager#startRouteGuidanceToSingleDestination");
    }

    public CommandList getStartRouteGuidanceToOffroadDestinationSequence(NavLocation navLocation, int n) {
        return this.startRouteGuidanceHelper.createStartGuidanceToOffroadDestinationCommandList(navLocation, n);
    }

    public Route getOffroadRouteFromNavLocation(NavLocation navLocation, int n) {
        return this.startRouteGuidanceHelper.getOffroadRouteFromNavLocation(navLocation, n);
    }

    public CommandList getStartRouteGuidanceToSingleDestinationSequence(NavLocation navLocation) {
        return this.getStartRouteGuidanceToSingleDestinationSequence(navLocation, true);
    }

    public CommandList getStartRouteGuidanceToSingleDestinationSequence(NavLocation navLocation, boolean bl) {
        ISDSController iSDSController = bl ? this.sdsController : null;
        return this.startRouteGuidanceHelper.createStartGuidanceToSingleDestinationCommandList(navLocation, iSDSController);
    }

    public CommandList getStartRouteGuidanceToSingleDestinationSequenceFromKombi(NavLocation navLocation, boolean bl) {
        ISDSController iSDSController = bl ? this.sdsController : null;
        return this.startRouteGuidanceHelper.createStartGuidanceToSingleDestinationFromKombiCommandList(navLocation, iSDSController);
    }

    public void startGuidanceWithAddedStopOver(NavLocation navLocation, int n) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#startGuidanceWithAddedStopOver( %1 )", (long)n);
        if (RouteUtil.getNumberOfDestinations(this.getRoute(), 1) < 2) {
            CommandList commandList = this.getStartGuidanceWithAddedStopOverSequence(navLocation, n);
            commandList.execute("RouteManager#startGuidanceWithAddedStopOver");
        } else {
            this.startGuidanceWithReplacedDestination(navLocation, n);
        }
    }

    public CommandList getStartGuidanceWithAddedStopOverSequence(NavLocation navLocation, int n) {
        return this.startRouteGuidanceHelper.createAddStopOverToActiveRouteCommandList(navLocation, n, this.sdsController);
    }

    public void startGuidanceWithReplacedDestination(NavLocation navLocation, int n) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#startGuidanceWithReplacedDestination( %1, %2 )", (Object)navLocation, (long)n);
        CommandList commandList = this.getStartGuidanceWithReplacedDestinationSequence(navLocation, n);
        commandList.execute("[RouteGuidance]AddStopOverToActiveRouteSequence#start");
    }

    public CommandList getStartGuidanceWithReplacedDestinationSequence(NavLocation navLocation, int n) {
        return this.startRouteGuidanceHelper.createReplaceDestinationOfActiveRouteCommandList(navLocation, n, this.sdsController);
    }

    public void calculateAlternativeRoutes() {
        this.startRouteGuidanceHelper.calculateAlternativeRoutes(3, this.route);
    }

    public void startGuidanceToCalculatedRoute(int n) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#startGuidanceToCalculatedRoute( %1 )", (long)n);
        this.startRouteGuidanceHelper.startGuidanceToCalculatedRoute(n, this.route);
    }

    public void startGuidance() {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#startGuidance()");
        CommandList commandList = this.getStartGuidanceSequence();
        commandList.execute("RouteManager#startRouteGuidance");
    }

    public CommandList getStartGuidanceSequence() {
        return this.getStartGuidanceSequence(false);
    }

    public CommandList getStartGuidanceSequence(boolean bl) {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#getStartGuidanceSequence()");
        CommandList commandList = this.startRouteGuidanceHelper.getRestartGuidanceToRouteCommandList(this.route, true, this.sdsController, bl);
        return commandList;
    }

    public void stopRouteGuidance() {
        this.env.getLogChannel().log(10000000, "[RouteGuidance] RouteManager#stopGuidance()");
        CommandList commandList = this.getStopRouteGuidanceSequence();
        commandList.execute("RouteManager#stopRouteGuidance");
    }

    public CommandList getStopRouteGuidanceSequence() {
        return this.startRouteGuidanceHelper.getStopRouteGuidanceSequence();
    }

    public void restartRouteGuidance(boolean bl) {
        CommandList commandList = this.startRouteGuidanceHelper.getRestartGuidanceToRouteCommandList(this.route, bl, this.sdsController);
        commandList.execute("StartRouteGuidanceSequences#restartGuidanceToRoute");
    }

    public void restartRouteGuidance(boolean bl, boolean bl2) {
        CommandList commandList = this.startRouteGuidanceHelper.getRestartGuidanceToRouteCommandList(this.route, bl, bl2, this.sdsController, false);
        commandList.execute("StartRouteGuidanceSequences#restartGuidanceToRoute");
    }

    public void restartRouteGuidance(boolean bl, Route route) {
        CommandList commandList = this.getRestartRouteGuidanceCommandList(bl, route);
        commandList.execute("StartRouteGuidanceSequences#restartGuidanceToRoute");
    }

    public CommandList getRestartRouteGuidanceCommandList(boolean bl, Route route) {
        return this.startRouteGuidanceHelper.getRestartGuidanceToRouteCommandList(route, bl, this.sdsController);
    }

    public CommandList getRestartRouteGuidanceCommandList(boolean bl) {
        return this.startRouteGuidanceHelper.getRestartGuidanceToRouteCommandList(this.route, bl, this.sdsController);
    }

    public CommandList getRestartRouteGuidanceCommandList(boolean bl, boolean bl2) {
        ISDSController iSDSController = bl2 ? this.sdsController : null;
        return this.startRouteGuidanceHelper.getRestartGuidanceToRouteCommandList(this.route, bl, iSDSController);
    }

    public boolean resumeRouteGuidance() {
        return this.routePersistenceController.restartRouteGuidance(this.startRouteGuidanceHelper, this.route, this.sdsController);
    }

    public CommandList evaluateGuidanceStatus() {
        return this.routePersistenceController.evaluateGuidanceStatus(this.route);
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 2) {
            this.env.getLogChannel().log(10000000, "RouteManager#setPowerEvent(POWERSTATE_STANDBY) - store guidance status!");
            this.routePersistenceController.storeGuidanceStatus(true, this.route);
        }
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public void loadPersistence() {
        this.routePersistenceController.loadState();
    }

    public void resetPersistence() {
    }

    public void storePersistence() {
    }

    public void start(BundleContext bundleContext) throws Exception {
        this.startRouteGuidanceHelper.start(bundleContext);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        this.tripHandler.cleanup();
        this.startRouteGuidanceHelper.stop(bundleContext);
    }

    public void updateRmPersistentRoute(Route route) {
        this.env.getLogChannel().log(1000000, "RouteManager#setRoute( %1 )", (Object)RouteUtil.formatRouteShort(route));
        this.route = route;
        int n = RouteUtil.getRouteID(route);
        int n2 = n == 0 || n == 1000 ? 0 : 1;
        this.env.getChoiceModel(400573).setValue(n2);
        if (this.rgInfoForNextDestinationIsPending) {
            this.rgInfoForNextDestinationIsPending = false;
            this.tripHandler.refreshTripData();
        }
    }

    public void updateRgCurrentRoute(Route route) {
        this.env.getLogChannel().log(10000000, "RouteManager#updateRgCurrentRoute( %1 ) ", (Object)route);
        int n = RouteUtil.getRouteLength(route);
        if (n == 0) {
            this.env.getLogChannel().log(100000, "RouteManager#updateRgCurrentRoute() - invalid rgCurrentRoute!");
            return;
        }
        int n2 = RouteUtil.getIndexOfCurrentDestination(route);
        final int n3 = RouteUtil.getNumberOfRemainingDestinations(route, 1);
        boolean bl = this.updateRgCurrentRouteAndAllDestinationsReached = n2 >= n;
        if (this.updateRgCurrentRouteAndAllDestinationsReached) {
            this.env.getLogChannel().log(1000000, "RouteManager#updateRgCurrentRoute() - all destinations reached!");
            if (!this.env.getContainer().isRgActive()) {
                this.finalDestinationReachedAndRgFinished();
            }
            if (this.routeEventListener != null) {
                this.routeEventListener.onRouteTerminated();
            }
        } else {
            this.env.getLogChannel().log(1000000, "RouteManager#updateRgCurrentRoute() - persisting latest indexOfCurrentDestination: %1!", (long)n2);
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new NavCommand(){

                public void execute() {
                    RouteManager.this.modelAccess.updateActiveDestinations(n3);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.add(new RmMakeRoutePersistentCommand(route));
            commandList.execute("RouteManager#updateRgCurrentRoute()");
        }
    }

    public void rgNotPossible(int n) {
        this.modelAccess.updateActiveDestinations(0);
        this.modelAccess.setPredictiveRgRunning(false);
    }

    public void updateRgActive(boolean bl) {
        this.routePersistenceController.storeGuidanceStatus(false, this.route);
        if (this.updateRgCurrentRouteAndAllDestinationsReached && !bl) {
            this.finalDestinationReachedAndRgFinished();
        }
        this.modelAccess.updateRgActive(bl, this.route);
        if (!bl) {
            this.modelAccess.setPredictiveRgRunning(false);
        }
        this.tripHandler.updateRgActive(bl);
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.routePersistenceController.storeGuidanceStatus(false, this.route);
        if (this.isDestIndexMatching(rgInfoForNextDestination)) {
            this.tripHandler.refreshTripData();
        } else {
            this.env.getLogChannel().log(100000, "RouteManager#updateRgInfoForNextDestination() - destinationIndex missmatch!");
            this.rgInfoForNextDestinationIsPending = true;
        }
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        if (this.isDestIndexMatching()) {
            this.tripHandler.refreshTripData();
        }
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        if (this.isDestIndexMatching()) {
            this.tripHandler.refreshTripData();
        }
    }

    public void setDemoModeManager(DemoModeManager demoModeManager) {
        this.demoModeManager = demoModeManager;
    }

    private boolean isDestIndexMatching(RgInfoForNextDestination rgInfoForNextDestination) {
        return this.getRoute() != null && rgInfoForNextDestination != null && this.getRoute().getIndexOfCurrentDestination() == (long)rgInfoForNextDestination.getDestinationIndex();
    }

    public boolean isDestIndexMatching() {
        RgInfoForNextDestination rgInfoForNextDestination = this.env.getContainer().getRgInfoForNextDestination();
        return this.getRoute() != null && rgInfoForNextDestination != null && this.getRoute().getIndexOfCurrentDestination() == (long)rgInfoForNextDestination.getDestinationIndex();
    }

    private void finalDestinationReachedAndRgFinished() {
        if (this.demoModeManager != null) {
            this.demoModeManager.finalDestinationReached();
        }
        int n = RouteUtil.getRouteLength(this.route);
        if (RouteUtil.getRouteID(this.route) == 0 && n >= 2) {
            RouteDestination routeDestination = RouteHelper.getDestinationAtPosition(this.route, n - 1);
            Route route = new Route();
            RouteHelper.addDestinationAtPosition(route, routeDestination, 0);
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new RmMakeRoutePersistentCommand(route));
            commandList.execute("TravelGuide#checkFinalDestinationReached");
        }
    }

    public void setRouteOptions(RouteOptions routeOptions) {
        this.startRouteGuidanceHelper.getSetRouteOptionsCommandList(routeOptions, this.route);
    }

    public void insertAsStopOver(NavLocation navLocation, int n, boolean bl) {
        CommandList commandList = this.getInsertAsStopOverCommandList(navLocation, n, bl, false);
        commandList.execute("RouteManager#insertAsStopOver");
    }

    public CommandList getInsertAsStopOverCommandList(NavLocation navLocation, int n, boolean bl, boolean bl2) {
        this.createRbToolTip(false);
        return this.startRouteGuidanceHelper.getInsertAsStopOverCommandList(this.route, navLocation, n, bl, bl2);
    }

    protected void createRbToolTip(boolean bl) {
    }

    public CommandList getStartGuidanceByRouteSequence(Route route) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RmMakeRoutePersistentCommand(route));
        commandList.add(new NavCommand("StartRgWithRoute"){

            public void execute() {
                this.env.getLogChannel().log(10000000, "StartRgWithPressRoute#execute");
                this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceSequence(true));
            }
        });
        return commandList;
    }

    public CommandList getStartGuidanceBySegmendIDSequence(NavSegmentID navSegmentID, boolean bl) {
        CommandList commandList = this.getStopRouteGuidanceSequence();
        RouteOptions[] routeOptionsArray = this.routeCriteriaManager.getRouteCriteria().getRouteOptions(true);
        if (routeOptionsArray.length > 0) {
            commandList.add(new RGSetRouteOptionsCommand(routeOptionsArray[0]));
        } else {
            this.env.getLogChannel().log(100000, "RouteManager#getStartGuidanceBySegmendIDSequence routeOptions.length == 0 no options will be send!");
        }
        commandList.add(new RGStartGuidanceCalculatedRouteByUID(navSegmentID, bl, this.modelAccess));
        return commandList;
    }

    public IRouteGuidanceStateModelAccess getModelAccess() {
        return this.modelAccess;
    }

    public void setRouteEventListener(RouteEventListener routeEventListener) {
        this.routeEventListener = routeEventListener;
    }

    public int getLastSelectedRouteIndex() {
        return this.startRouteGuidanceHelper.alternativeRoutesHandler.getLastSelectedRouteIndex();
    }
}

