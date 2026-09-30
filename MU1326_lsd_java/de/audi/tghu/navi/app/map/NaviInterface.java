/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.atip.interapp.navtmc.TMCService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.UpdateDestinationCountryCodeCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.call.INavCall;
import de.audi.tghu.navi.app.car.AEAService;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.cluster.KOMOService;
import de.audi.tghu.navi.app.command.ETCSetDemoModeSpeed;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGStartGuidanceCalculatedRouteByUID;
import de.audi.tghu.navi.app.command.TriggerEventAudioMessageCommand;
import de.audi.tghu.navi.app.command.poi.CalcRRDAndSendToCallBackCommand;
import de.audi.tghu.navi.app.command.poi.RRDStopCalculationCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.gpximport.GpxHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.command.MonitorCalcRealRoadDistance;
import de.audi.tghu.navi.app.map.minimap.ITrafficMiniMap;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficHandler;
import de.audi.tghu.navi.app.poi.POICategoryManager;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.commands.RgStopRouteCalculation;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.tmc.TmcMessage;

public class NaviInterface
implements INaviInterface {
    private LogChannel mLogChannel;
    protected final NavigationEnv env;
    protected Navigation navigation;
    private final ISDSController sdsController;
    private final ICommandListFactory commandListFactory;
    private IDetailsScreen detailsScreen;
    private INaviFavoriteHandler naviFavoriteHandler;
    protected final SpellerStack spellerStack;
    private final INavigationInputModeManager inputModeManager;
    private boolean sdsDialogEndedActionsNecessary = false;
    private MonitorCalcRealRoadDistance rrdMonitor;
    protected IAddressInputFormModelAccessHelper addressInputFormModelAccessHelper;
    protected boolean featureToBeLocked = false;

    public NaviInterface(NavigationEnv navigationEnv, LogChannel logChannel, Navigation navigation, ISDSController iSDSController, ICommandListFactory iCommandListFactory) {
        this.navigation = navigation;
        this.sdsController = iSDSController;
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.spellerStack = SpellerStack.getInstance();
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.mLogChannel = logChannel;
        this.featureToBeLocked = navigationEnv.getChoiceModel(5583).getValue() == 1;
    }

    public void cleanUp() {
        this.navigation = null;
    }

    Navigation getNavigation() {
        return this.navigation;
    }

    public void setDetailsScreen(IDetailsScreen iDetailsScreen) {
        this.detailsScreen = iDetailsScreen;
    }

    public void setFavoriteHandler(INaviFavoriteHandler iNaviFavoriteHandler) {
        this.naviFavoriteHandler = iNaviFavoriteHandler;
    }

    public void mapReady(boolean bl) {
        this.mLogChannel.log(10000000, "NaviInterface#mapReady( %1 )", bl);
        this.navigation.getOperationManager().setMapReady(bl);
    }

    public void mapInitialized(boolean bl) {
        this.mLogChannel.log(10000000, "NaviInterface#mapInitialized( %1 )", bl);
        this.navigation.getOperationManager().setMapInitialized(bl);
    }

    public void updateMapFreeze(boolean bl) {
        this.mLogChannel.log(10000000, "NaviInterface#updateMapFreeze(%1) navigation: %2, navimapConnector: %3", bl, (Object)this.navigation, (Object)this.navigation.getNaviMapConnector());
        this.navigation.getNaviMapConnector().setMapFreeze(bl);
    }

    public IViewSizeChangeHandler getViewSizeChangeHandler() {
        return this.navigation.getViewSizeChangeHandler();
    }

    public AEAService getAeaService() {
        return this.navigation.getAeaService();
    }

    public void alternativeRoutesScreenEntered() {
        this.mLogChannel.log(10000000, "NaviInterface#alternativeRoutesScreenEntered()");
        this.navigation.getInterAppService().alternativeRoutesScreenEntered();
    }

    public void alternativeRoutesChangedToSingleRG() {
        this.mLogChannel.log(10000000, "NaviInterface#alternativeRoutesChangedToSingleRG()");
    }

    public void startGuidanceCalculatedRoute(int n) {
        this.mLogChannel.log(10000000, "NaviInterface#startGuidanceCalculatedRoute(): route #%1", (long)n);
        this.navigation.getRouteManager().startGuidanceToCalculatedRoute(n);
    }

    public CommandList startGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        this.mLogChannel.log(10000000, "NaviInterface#startGuidanceCalculatedRouteByUID( %1 )", (Object)navSegmentID);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RGStartGuidanceCalculatedRouteByUID(navSegmentID, false, this.getRouteManager().getModelAccess()));
        return commandList;
    }

    public void abortSDSSession() {
        this.mLogChannel.log(10000000, "NaviInterface#abortSDSSession(): NOP!");
        this.sdsController.abortSDSSession(true);
    }

    public CalculatedRouteListElement[] getCalculatedRoutes() {
        this.mLogChannel.log(10000000, "NaviInterface#getCalculatedRoutes()");
        return this.env.getContainer().getCalculatedRoutes();
    }

    public int getRouteListLength() {
        return RouteUtil.getRouteLength(this.navigation.getRouteManager().getFilteredRoute());
    }

    public int getIndexOfCurrentDestination() {
        Route route = this.navigation.getRouteManager().getFilteredRoute();
        return RouteUtil.getIndexOfCurrentDestination(route);
    }

    public void addressbookMapActive(boolean bl) {
        this.mLogChannel.log(10000000, "NaviInterface#addressbookMapActive(%1)", bl);
        if (this.navigation.getNaviADBHandler() != null) {
            this.navigation.getNaviADBHandler().mapActive(bl);
        }
    }

    public void requestTmcMessage(int n) {
        this.mLogChannel.log(10000000, "NaviInterface#requestTmcMessage() msgId=%1", (long)n);
        this.navigation.getTmcOnRouteService().getTmcMessage(n);
    }

    public void requestOnlineResultFlagDetails(final int n, OnlinePOIResultList onlinePOIResultList, final AbstractMap abstractMap) {
        if (onlinePOIResultList == null) {
            this.mLogChannel.log(10000, "NaviInterface#requestOnlineResultFlagDetails( %1 ): result list is null => return", (long)n);
            return;
        }
        this.mLogChannel.log(1000000, "NaviInterface#requestOnlineResultFlagDetails( %1 )", (long)n);
        CommandList commandList = onlinePOIResultList.resolveEntry(n, this.commandListFactory);
        if (commandList == null) {
            this.mLogChannel.log(10000, "NaviInterface#requestOnlineResultFlagDetails( %1 ): command list is null => return", (long)n);
            return;
        }
        commandList.add(new NavCommand("NaviInterface#requestOnlineResultFlagDetails"){

            public void execute() {
                this.logger.log(10000000, "NaviInterface#requestOnlineResultFlagDetails#execute()");
                abstractMap.getMapInterface().updateOnlineResultFlagDetails(n);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviInterface#requestOnlineResultFlagDetails");
    }

    public void stopRouteGuidance() {
        this.navigation.getRouteManager().stopRouteGuidance();
    }

    public boolean isOffroad() {
        Route route = this.navigation.getRouteManager().getRoute();
        int n = RouteUtil.getRouteID(route);
        if (n == 1) {
            int n2 = RouteUtil.getCurrentDestinationType(route, this.mLogChannel);
            return n2 == 128;
        }
        if (n == 2) {
            int n3 = RouteUtil.getCurrentDestinationType(route, this.mLogChannel);
            return n3 == 1;
        }
        return false;
    }

    public POICategoryManager getPOICategoryManager() {
        return this.navigation.getPoiCategoryManager();
    }

    public void setDemoModeSpeed(long l) {
        this.mLogChannel.log(10000000, "NaviInterface#setDemoModeSpeed() - speed: %1", l);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new ETCSetDemoModeSpeed(l));
        commandList.execute("NaviInterface#setDemoModeSpeed.COMMAND_DEMO_MODE_SPEED");
    }

    public boolean isDemoModeActive() {
        return this.env.getContainer().isEtcDemoMode();
    }

    public KOMOService getKOMOService() {
        return this.navigation.getClusterService().getKomoService();
    }

    public void updateTMCMapFreeze(boolean bl) {
        this.navigation.getTmcGateway().updateTMCMapActive(!bl);
    }

    public CountryInfo[] getCountryInfo() {
        this.mLogChannel.log(10000000, "NaviInterface#getCountryInfo()");
        return this.env.getContainer().getCountryInfo();
    }

    public TrafficRegulationService getTrafficRegulationService() {
        this.mLogChannel.log(10000000, "NaviInterface#getTrafficRegulationService()");
        return this.navigation.getTrafficRegulationService();
    }

    public IFrameworkAccess getFramework() {
        return this.env.getFramework();
    }

    public void resetEditInputMode() {
        this.mLogChannel.log(10000000, "NaviInterface#resetEditInputMode()");
    }

    public INaviAudioHandler getNaviAudioHandler() {
        return this.navigation.getNaviAudioHandler();
    }

    public DSINavigationManager getDSINavigationManager() {
        return this.navigation.getDsiNavigationManager();
    }

    public TMCService getTMCGateWay() {
        return this.getNavigation().getTmcGateway();
    }

    public void startPoiStackSequence(final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(54)));
        commandList.add(new NavCommand(){

            public void execute() {
                NaviInterface.this.detailsScreen.enterDetailsScreen(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviInterface#startPoiStackSequence");
        this.navigation.getPoiService().startPoiStackSequence(navLocation);
    }

    public void startDestinationDetails(final NavLocation navLocation) {
        if (this.detailsScreen == null) {
            this.mLogChannel.log(100000, "No details screen handler is registered.");
            return;
        }
        ICommandListFactory iCommandListFactory = this.navigation.getCommandListFactory();
        CommandList commandList = iCommandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                NaviInterface.this.detailsScreen.enterDetailsScreen(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviInterface#startDestinationDetails");
    }

    public void startDestinationDetailsTMC(final TmcMessage tmcMessage) {
        if (this.detailsScreen == null) {
            this.mLogChannel.log(100000, "No details screen handler is registered.");
            return;
        }
        ICommandListFactory iCommandListFactory = this.navigation.getCommandListFactory();
        CommandList commandList = iCommandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                NaviInterface.this.detailsScreen.enterDetailsScreenTmc(tmcMessage);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviInterface#startDestinationDetailsTmc");
    }

    public PreviewMapCallback getDetailsScreen() {
        return this.detailsScreen instanceof PreviewMapCallback ? (PreviewMapCallback)((Object)this.detailsScreen) : null;
    }

    public void googleEarthUpdateStatusCompleted(int n, boolean bl) {
        if (this.navigation != null && this.navigation.getClusterService() != null) {
            this.navigation.getClusterService().updateOnlineNavigationState();
        }
    }

    public void setOperationTaskCompleted(int n) {
        this.navigation.getOperationManager().taskCompleted(n);
    }

    public IVehicle getVehicle() {
        return this.navigation.getVehicle();
    }

    public void resetDetour() {
        this.navigation.getSimpleDetourHandler().resetDetour();
    }

    public Route getRoute() {
        return this.navigation.getRouteManager().getRoute();
    }

    public IRouteManager getRouteManager() {
        return this.navigation.getRouteManager();
    }

    public NaviOnlineService getNaviOnlineService() {
        return this.navigation.getInterAppService().getNaviOnlineService();
    }

    public int getNavigationMode() {
        return this.navigation.getNavigationModeManager().getNavigationMode();
    }

    public void setNavigationMode(int n) {
        this.navigation.setNavigationMode(n);
    }

    public void showMapDestination(NavLocation navLocation, String string) {
        this.navigation.getNaviMapConnector().showMapDestination(navLocation, string);
    }

    public void executeCallDiscardOld(INavCall iNavCall, String string) {
        this.navigation.getCommandListCallManager().executeCallDiscardOld(iNavCall, string);
    }

    public int getConfiguredTimeMode() {
        return this.navigation.getGeneralSetupListener().getTimeMode();
    }

    public void updateKombiMapReady(boolean bl) {
        this.navigation.getClusterService().updateKombiMapReady(bl);
    }

    public OperationManager getOperationManager() {
        return this.navigation.getOperationManager();
    }

    public NavLocation streamToLocation(byte[] byArray) {
        this.mLogChannel.log(10000000, "InterAppService#streamToLocation(): stream: %1", (Object)byArray);
        return this.navigation.getLocationSerializer().streamToLocation(byArray);
    }

    public byte[] locationToStream(NavLocation navLocation) {
        this.mLogChannel.log(10000000, "InterAppService#locationToStream(): location: %1", (Object)navLocation);
        return this.navigation.getLocationSerializer().locationToStream(navLocation);
    }

    public INavigationInputModeManager getInputModeManager() {
        return this.env.getInputModeManager();
    }

    public ClusterService getClusterService() {
        return this.navigation.getClusterService();
    }

    public void calculateAlternativeRoutes() {
        this.mLogChannel.log(10000000, "NaviInterface#calculateAlternativeRoutes()");
        this.navigation.getRouteManager().calculateAlternativeRoutes();
    }

    public CommandList createCommandList() {
        return this.commandListFactory.createCommandList(1);
    }

    public IFavorite[] getFavorites() {
        if (null != this.naviFavoriteHandler) {
            return this.naviFavoriteHandler.getFavorites();
        }
        return new IFavorite[0];
    }

    public void stopRouteCalculation() {
        CommandList commandList = this.createCommandList();
        commandList.add(new RgStopRouteCalculation());
        commandList.execute("NaviInterface#stopRouteCalculation()");
    }

    public HomeAddressHandler getHomeAddressHandler() {
        return this.navigation.getHomeAddressHandler();
    }

    public void updateInfoForNextTmcEvent(long l, TmcMessage tmcMessage) {
        this.mLogChannel.log(100000000, "NaviInterface#updateInfoForNextTmcEvent( %1 )", l);
        this.navigation.getNaviServiceListenerController().updateInfoForNextTmcEvent(l, tmcMessage);
    }

    public void updateDelayOnCurrentRoute(long l) {
        this.navigation.getNaviServiceListenerController().updateDelayOnCurrentRoute(l);
    }

    public void stopRrdMonitor() {
        this.mLogChannel.log(10000000, "NaviInterface#stopRrdMonitor() - monitor = %1", (Object)this.rrdMonitor);
        MonitorCalcRealRoadDistance monitorCalcRealRoadDistance = this.rrdMonitor;
        this.rrdMonitor = null;
        if (monitorCalcRealRoadDistance != null) {
            monitorCalcRealRoadDistance.stopMonitoredLists("rrdCalculation not longer needed");
        }
    }

    public void calculateRealRouteDistanceTo(NavLocationWgs84 navLocationWgs84, INotifyWhenRealRouteCalulcationisDone iNotifyWhenRealRouteCalulcationisDone) {
        MonitorCalcRealRoadDistance monitorCalcRealRoadDistance = this.rrdMonitor;
        if (monitorCalcRealRoadDistance != null && monitorCalcRealRoadDistance.equalsNavLocation(navLocationWgs84)) {
            this.mLogChannel.log(10000000, "NaviInterface#calculateRealRouteDistanceTo() - monitor = %1 already running", (Object)this.rrdMonitor);
        }
        this.stopRrdMonitor();
        this.rrdMonitor = new MonitorCalcRealRoadDistance(this.env.getLogChannel(), navLocationWgs84);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (monitorCalcRealRoadDistance != null) {
            commandList.add(new RRDStopCalculationCommand());
        }
        commandList.addMonitor(this.rrdMonitor);
        final CalcRRDAndSendToCallBackCommand calcRRDAndSendToCallBackCommand = new CalcRRDAndSendToCallBackCommand(navLocationWgs84, iNotifyWhenRealRouteCalulcationisDone);
        commandList.add(calcRRDAndSendToCallBackCommand);
        commandList.add(new NavCommand("Reset rrdMonitor"){

            public void execute() {
                NaviInterface.this.rrdMonitor = null;
                this.getCommandList().commandFinished();
            }
        });
        commandList.setErrorCommand(new NavCommand("Error command for resetting the RRDCalculationFlag"){

            public void execute() {
                calcRRDAndSendToCallBackCommand.resetRRDCalculationFlag();
            }
        });
        commandList.execute("NaviInterface#calcRRD");
    }

    public void sdsDialogStarted() {
        this.env.getLogChannel().log(100000000, "NaviInterface#sdsDialogStarted");
        this.inputModeManager.setSdsActiveStatus(true);
        this.sdsDialogEndedActionsNecessary = true;
    }

    public void sdsSessionAborted() {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(100000000, "NaviInterface#sdsSessionAborted");
        }
        this.inputModeManager.setSdsActiveStatus(false);
    }

    public void sdsDialogAborting() {
        this.env.getLogChannel().log(10000000, "NaviInterface#sdsDialogAborting - sdsDialogEndedActionsNecessary=%1", this.sdsDialogEndedActionsNecessary);
        this.inputModeManager.setSdsActiveStatus(false);
        CommandList commandList = this.getSdsDialogEndedRestoreCommandList();
        if (commandList.size() > 0) {
            commandList.execute("NaviInterface#sdsDialogAborting");
        }
    }

    public void sdsDialogEnded() {
        this.env.getLogChannel().log(10000000, "NaviInterface#sdsDialogEnded - sdsDialogEndedActionsNecessary=%1", this.sdsDialogEndedActionsNecessary);
        this.inputModeManager.setSdsActiveStatus(false);
        CommandList commandList = this.getSdsDialogEndedRestoreCommandList();
        if (this.spellerStack.isActiveSpellerContextIDEqual(116)) {
            commandList.add(new LIRestoreStateCommand(this.spellerStack.pop().spellerData));
        }
        commandList.execute("NaviInterface#sdsDialogEnded");
    }

    private synchronized CommandList getSdsDialogEndedRestoreCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.sdsDialogEndedActionsNecessary) {
            this.sdsDialogEndedActionsNecessary = false;
            if (this.spellerStack.containsContextID(8) && (this.spellerStack.getActiveSC().getContextID() == 111 || this.spellerStack.getActiveSC().getContextID() == 4)) {
                this.env.getLogChannel().log(10000000, "NaviInterface#sdsDialogAborting - CTX_POI_MAIN_SCREEN was found on the speller stack.");
                this.sdsDialogCTXPOIHandling(commandList);
            } else {
                this.env.getLogChannel().log(1000000, "NaviInterface#sdsDialogAborting - no POI related contexts were found on the spellerstack. Trying other contexts.");
                if (this.spellerStack.isActiveSpellerContextIDEqual(116)) {
                    commandList.add(new LIRestoreStateCommand(this.spellerStack.pop().spellerData));
                } else if (this.spellerStack.isActiveSpellerContextIDEqual(112)) {
                    commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.addressInputFormModelAccessHelper));
                }
            }
            commandList.add(new UpdateDestinationCountryCodeCommand(Vehicle.getInstance().getVehicleLocationDescription()));
        }
        return commandList;
    }

    public void sdsDialogCTXPOIHandling(CommandList commandList) {
        SpellerStack.StackElement stackElement = null;
        SpellerStack.StackElement stackElement2 = null;
        do {
            if (stackElement == null) continue;
            stackElement2 = stackElement;
        } while ((stackElement = this.spellerStack.pop()) != null && stackElement.sc.getContextID() != 8);
        commandList.add(new LIRestoreStateCommand(stackElement2.spellerData));
    }

    public IRouteCriteria getRouteCriteria() {
        return this.navigation.getRouteCriteriaManager().getRouteCriteria();
    }

    public void triggerEventAudioMessage(int n) {
        this.env.getLogChannel().log(100000000, "NaviInterface#triggerEventAudioMessage, soundID is(%1)", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new TriggerEventAudioMessageCommand(n));
        commandList.execute("NaviInterface#triggerEventAudioMessage(int soundID)");
    }

    public void triggerUpdateRcci() {
        this.env.getLogChannel().log(100000000, "NaviInterface#triggerUpdateRcci()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("triggerUpdateRcci"){

            public void execute() {
                this.getDSINavigation().rgTriggerRCCIUpdate();
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviInterface#triggerUpdateRcci()");
    }

    public void afaRepeat(final int n) {
        this.env.getLogChannel().log(10000000, "NaviInterface#afaRepeat( %1 )", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("afaRepeat"){

            public void execute() {
                this.getDSINavigation().afaRepeat(n);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("NaviInterface#afaRepeat()");
    }

    public ITrafficMiniMap getTrafficMiniMap() {
        this.env.getLogChannel().log(100000000, "NaviInterface#getTrafficMiniMap()");
        return this.navigation.getTrafficMiniMap();
    }

    public OnlineTrafficHandler getOnlineTrafficHandler() {
        return this.navigation.getOnlineTrafficHandler();
    }

    public void setAddressInputFormModelAccessHelper(IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.addressInputFormModelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    public GpxHandler getGpxHandler() {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(100000000, "NaviInterface#getGpxHandler()");
        }
        return this.navigation.getGpxHandler();
    }

    public void sendCalculatateAltRoutesResult(byte by) {
        this.getNavigation().getNaviServiceListenerController().responseCalculateAlternativeRoutes(by);
    }

    public NavLocation getCurrentPoiProximityWarningLocation() {
        return this.getNavigation().getPoiService().getPoiWarningManager().getCurrentPoiProximityWarningLocation();
    }

    public void hideCurrentPoiProximityWarningAfterSelection() {
        this.getNavigation().getPoiService().getPoiWarningManager().hideCurrentPoiWarningAfterSelection();
    }

    public void focusSelenaRoutes(boolean bl) {
        this.getNavigation().getPredictiveNavController().focusSelenaRoutes(bl);
    }

    public boolean isFeatureToBeLocked() {
        return this.featureToBeLocked;
    }

    public void setFeatureToBeLocked(boolean bl) {
        this.featureToBeLocked = bl;
    }

    public static interface INotifyWhenRealRouteCalulcationisDone {
        public void update(int var1, long var2);

        public void resetRRDCalculationFlag();
    }
}

