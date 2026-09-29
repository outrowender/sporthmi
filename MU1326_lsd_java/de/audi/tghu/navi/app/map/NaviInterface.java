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
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.NaviInterface$1;
import de.audi.tghu.navi.app.map.NaviInterface$2;
import de.audi.tghu.navi.app.map.NaviInterface$3;
import de.audi.tghu.navi.app.map.NaviInterface$4;
import de.audi.tghu.navi.app.map.NaviInterface$5;
import de.audi.tghu.navi.app.map.NaviInterface$6;
import de.audi.tghu.navi.app.map.NaviInterface$7;
import de.audi.tghu.navi.app.map.NaviInterface$8;
import de.audi.tghu.navi.app.map.NaviInterface$INotifyWhenRealRouteCalulcationisDone;
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

    @Override
    public void mapReady(boolean bl) {
        this.mLogChannel.log(-2137614336, "NaviInterface#mapReady( %1 )", bl);
        this.navigation.getOperationManager().setMapReady(bl);
    }

    @Override
    public void mapInitialized(boolean bl) {
        this.mLogChannel.log(-2137614336, "NaviInterface#mapInitialized( %1 )", bl);
        this.navigation.getOperationManager().setMapInitialized(bl);
    }

    @Override
    public void updateMapFreeze(boolean bl) {
        this.mLogChannel.log(-2137614336, "NaviInterface#updateMapFreeze(%1) navigation: %2, navimapConnector: %3", bl, (Object)this.navigation, (Object)this.navigation.getNaviMapConnector());
        this.navigation.getNaviMapConnector().setMapFreeze(bl);
    }

    @Override
    public IViewSizeChangeHandler getViewSizeChangeHandler() {
        return this.navigation.getViewSizeChangeHandler();
    }

    @Override
    public AEAService getAeaService() {
        return this.navigation.getAeaService();
    }

    @Override
    public void alternativeRoutesScreenEntered() {
        this.mLogChannel.log(-2137614336, "NaviInterface#alternativeRoutesScreenEntered()");
        this.navigation.getInterAppService().alternativeRoutesScreenEntered();
    }

    @Override
    public void alternativeRoutesChangedToSingleRG() {
        this.mLogChannel.log(-2137614336, "NaviInterface#alternativeRoutesChangedToSingleRG()");
    }

    @Override
    public void startGuidanceCalculatedRoute(int n) {
        this.mLogChannel.log(-2137614336, "NaviInterface#startGuidanceCalculatedRoute(): route #%1", (long)n);
        this.navigation.getRouteManager().startGuidanceToCalculatedRoute(n);
    }

    @Override
    public CommandList startGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        this.mLogChannel.log(-2137614336, "NaviInterface#startGuidanceCalculatedRouteByUID( %1 )", (Object)navSegmentID);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RGStartGuidanceCalculatedRouteByUID(navSegmentID, false, this.getRouteManager().getModelAccess()));
        return commandList;
    }

    @Override
    public void abortSDSSession() {
        this.mLogChannel.log(-2137614336, "NaviInterface#abortSDSSession(): NOP!");
        this.sdsController.abortSDSSession(true);
    }

    @Override
    public CalculatedRouteListElement[] getCalculatedRoutes() {
        this.mLogChannel.log(-2137614336, "NaviInterface#getCalculatedRoutes()");
        return this.env.getContainer().getCalculatedRoutes();
    }

    @Override
    public int getRouteListLength() {
        return RouteUtil.getRouteLength(this.navigation.getRouteManager().getFilteredRoute());
    }

    @Override
    public int getIndexOfCurrentDestination() {
        Route route = this.navigation.getRouteManager().getFilteredRoute();
        return RouteUtil.getIndexOfCurrentDestination(route);
    }

    @Override
    public void addressbookMapActive(boolean bl) {
        this.mLogChannel.log(-2137614336, "NaviInterface#addressbookMapActive(%1)", bl);
        if (this.navigation.getNaviADBHandler() != null) {
            this.navigation.getNaviADBHandler().mapActive(bl);
        }
    }

    @Override
    public void requestTmcMessage(int n) {
        this.mLogChannel.log(-2137614336, "NaviInterface#requestTmcMessage() msgId=%1", (long)n);
        this.navigation.getTmcOnRouteService().getTmcMessage(n);
    }

    @Override
    public void requestOnlineResultFlagDetails(int n, OnlinePOIResultList onlinePOIResultList, AbstractMap abstractMap) {
        if (onlinePOIResultList == null) {
            this.mLogChannel.log(10000, "NaviInterface#requestOnlineResultFlagDetails( %1 ): result list is null => return", (long)n);
            return;
        }
        this.mLogChannel.log(1078071040, "NaviInterface#requestOnlineResultFlagDetails( %1 )", (long)n);
        CommandList commandList = onlinePOIResultList.resolveEntry(n, this.commandListFactory);
        if (commandList == null) {
            this.mLogChannel.log(10000, "NaviInterface#requestOnlineResultFlagDetails( %1 ): command list is null => return", (long)n);
            return;
        }
        commandList.add(new NaviInterface$1(this, "NaviInterface#requestOnlineResultFlagDetails", abstractMap, n));
        commandList.execute("NaviInterface#requestOnlineResultFlagDetails");
    }

    @Override
    public void stopRouteGuidance() {
        this.navigation.getRouteManager().stopRouteGuidance();
    }

    @Override
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

    @Override
    public POICategoryManager getPOICategoryManager() {
        return this.navigation.getPoiCategoryManager();
    }

    @Override
    public void setDemoModeSpeed(long l) {
        this.mLogChannel.log(-2137614336, "NaviInterface#setDemoModeSpeed() - speed: %1", l);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new ETCSetDemoModeSpeed(l));
        commandList.execute("NaviInterface#setDemoModeSpeed.COMMAND_DEMO_MODE_SPEED");
    }

    @Override
    public boolean isDemoModeActive() {
        return this.env.getContainer().isEtcDemoMode();
    }

    @Override
    public KOMOService getKOMOService() {
        return this.navigation.getClusterService().getKomoService();
    }

    @Override
    public void updateTMCMapFreeze(boolean bl) {
        this.navigation.getTmcGateway().updateTMCMapActive(!bl);
    }

    @Override
    public CountryInfo[] getCountryInfo() {
        this.mLogChannel.log(-2137614336, "NaviInterface#getCountryInfo()");
        return this.env.getContainer().getCountryInfo();
    }

    @Override
    public TrafficRegulationService getTrafficRegulationService() {
        this.mLogChannel.log(-2137614336, "NaviInterface#getTrafficRegulationService()");
        return this.navigation.getTrafficRegulationService();
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.env.getFramework();
    }

    @Override
    public void resetEditInputMode() {
        this.mLogChannel.log(-2137614336, "NaviInterface#resetEditInputMode()");
    }

    @Override
    public INaviAudioHandler getNaviAudioHandler() {
        return this.navigation.getNaviAudioHandler();
    }

    @Override
    public DSINavigationManager getDSINavigationManager() {
        return this.navigation.getDsiNavigationManager();
    }

    @Override
    public TMCService getTMCGateWay() {
        return this.getNavigation().getTmcGateway();
    }

    @Override
    public void startPoiStackSequence(NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(54)));
        commandList.add(new NaviInterface$2(this, navLocation));
        commandList.execute("NaviInterface#startPoiStackSequence");
        this.navigation.getPoiService().startPoiStackSequence(navLocation);
    }

    @Override
    public void startDestinationDetails(NavLocation navLocation) {
        if (this.detailsScreen == null) {
            this.mLogChannel.log(-1601830656, "No details screen handler is registered.");
            return;
        }
        ICommandListFactory iCommandListFactory = this.navigation.getCommandListFactory();
        CommandList commandList = iCommandListFactory.createCommandList();
        commandList.add(new NaviInterface$3(this, navLocation));
        commandList.execute("NaviInterface#startDestinationDetails");
    }

    @Override
    public void startDestinationDetailsTMC(TmcMessage tmcMessage) {
        if (this.detailsScreen == null) {
            this.mLogChannel.log(-1601830656, "No details screen handler is registered.");
            return;
        }
        ICommandListFactory iCommandListFactory = this.navigation.getCommandListFactory();
        CommandList commandList = iCommandListFactory.createCommandList();
        commandList.add(new NaviInterface$4(this, tmcMessage));
        commandList.execute("NaviInterface#startDestinationDetailsTmc");
    }

    @Override
    public PreviewMapCallback getDetailsScreen() {
        return this.detailsScreen instanceof PreviewMapCallback ? (PreviewMapCallback)((Object)this.detailsScreen) : null;
    }

    @Override
    public void googleEarthUpdateStatusCompleted(int n, boolean bl) {
        if (this.navigation != null && this.navigation.getClusterService() != null) {
            this.navigation.getClusterService().updateOnlineNavigationState();
        }
    }

    @Override
    public void setOperationTaskCompleted(int n) {
        this.navigation.getOperationManager().taskCompleted(n);
    }

    @Override
    public IVehicle getVehicle() {
        return this.navigation.getVehicle();
    }

    @Override
    public void resetDetour() {
        this.navigation.getSimpleDetourHandler().resetDetour();
    }

    @Override
    public Route getRoute() {
        return this.navigation.getRouteManager().getRoute();
    }

    @Override
    public IRouteManager getRouteManager() {
        return this.navigation.getRouteManager();
    }

    @Override
    public NaviOnlineService getNaviOnlineService() {
        return this.navigation.getInterAppService().getNaviOnlineService();
    }

    @Override
    public int getNavigationMode() {
        return this.navigation.getNavigationModeManager().getNavigationMode();
    }

    @Override
    public void setNavigationMode(int n) {
        this.navigation.setNavigationMode(n);
    }

    @Override
    public void showMapDestination(NavLocation navLocation, String string) {
        this.navigation.getNaviMapConnector().showMapDestination(navLocation, string);
    }

    @Override
    public void executeCallDiscardOld(INavCall iNavCall, String string) {
        this.navigation.getCommandListCallManager().executeCallDiscardOld(iNavCall, string);
    }

    @Override
    public int getConfiguredTimeMode() {
        return this.navigation.getGeneralSetupListener().getTimeMode();
    }

    @Override
    public void updateKombiMapReady(boolean bl) {
        this.navigation.getClusterService().updateKombiMapReady(bl);
    }

    @Override
    public OperationManager getOperationManager() {
        return this.navigation.getOperationManager();
    }

    @Override
    public NavLocation streamToLocation(byte[] byArray) {
        this.mLogChannel.log(-2137614336, "InterAppService#streamToLocation(): stream: %1", (Object)byArray);
        return this.navigation.getLocationSerializer().streamToLocation(byArray);
    }

    public byte[] locationToStream(NavLocation navLocation) {
        this.mLogChannel.log(-2137614336, "InterAppService#locationToStream(): location: %1", (Object)navLocation);
        return this.navigation.getLocationSerializer().locationToStream(navLocation);
    }

    @Override
    public INavigationInputModeManager getInputModeManager() {
        return this.env.getInputModeManager();
    }

    @Override
    public ClusterService getClusterService() {
        return this.navigation.getClusterService();
    }

    @Override
    public void calculateAlternativeRoutes() {
        this.mLogChannel.log(-2137614336, "NaviInterface#calculateAlternativeRoutes()");
        this.navigation.getRouteManager().calculateAlternativeRoutes();
    }

    @Override
    public CommandList createCommandList() {
        return this.commandListFactory.createCommandList(1);
    }

    @Override
    public IFavorite[] getFavorites() {
        if (null != this.naviFavoriteHandler) {
            return this.naviFavoriteHandler.getFavorites();
        }
        return new IFavorite[0];
    }

    @Override
    public void stopRouteCalculation() {
        CommandList commandList = this.createCommandList();
        commandList.add(new RgStopRouteCalculation());
        commandList.execute("NaviInterface#stopRouteCalculation()");
    }

    @Override
    public HomeAddressHandler getHomeAddressHandler() {
        return this.navigation.getHomeAddressHandler();
    }

    @Override
    public void updateInfoForNextTmcEvent(long l, TmcMessage tmcMessage) {
        this.mLogChannel.log(14808325, "NaviInterface#updateInfoForNextTmcEvent( %1 )", l);
        this.navigation.getNaviServiceListenerController().updateInfoForNextTmcEvent(l, tmcMessage);
    }

    @Override
    public void updateDelayOnCurrentRoute(long l) {
        this.navigation.getNaviServiceListenerController().updateDelayOnCurrentRoute(l);
    }

    @Override
    public void stopRrdMonitor() {
        this.mLogChannel.log(-2137614336, "NaviInterface#stopRrdMonitor() - monitor = %1", (Object)this.rrdMonitor);
        MonitorCalcRealRoadDistance monitorCalcRealRoadDistance = this.rrdMonitor;
        this.rrdMonitor = null;
        if (monitorCalcRealRoadDistance != null) {
            monitorCalcRealRoadDistance.stopMonitoredLists("rrdCalculation not longer needed");
        }
    }

    @Override
    public void calculateRealRouteDistanceTo(NavLocationWgs84 navLocationWgs84, INotifyWhenRealRouteCalulcationisDone iNotifyWhenRealRouteCalulcationisDone) {
        MonitorCalcRealRoadDistance monitorCalcRealRoadDistance = this.rrdMonitor;
        if (monitorCalcRealRoadDistance != null && monitorCalcRealRoadDistance.equalsNavLocation(navLocationWgs84)) {
            this.mLogChannel.log(-2137614336, "NaviInterface#calculateRealRouteDistanceTo() - monitor = %1 already running", (Object)this.rrdMonitor);
        }
        this.stopRrdMonitor();
        this.rrdMonitor = new MonitorCalcRealRoadDistance(this.env.getLogChannel(), navLocationWgs84);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (monitorCalcRealRoadDistance != null) {
            commandList.add(new RRDStopCalculationCommand());
        }
        commandList.addMonitor(this.rrdMonitor);
        CalcRRDAndSendToCallBackCommand calcRRDAndSendToCallBackCommand = new CalcRRDAndSendToCallBackCommand(navLocationWgs84, iNotifyWhenRealRouteCalulcationisDone);
        commandList.add(calcRRDAndSendToCallBackCommand);
        commandList.add(new NaviInterface$5(this, "Reset rrdMonitor"));
        commandList.setErrorCommand(new NaviInterface$6(this, "Error command for resetting the RRDCalculationFlag", calcRRDAndSendToCallBackCommand));
        commandList.execute("NaviInterface#calcRRD");
    }

    @Override
    public void sdsDialogStarted() {
        this.env.getLogChannel().log(14808325, "NaviInterface#sdsDialogStarted");
        this.inputModeManager.setSdsActiveStatus(true);
        this.sdsDialogEndedActionsNecessary = true;
    }

    @Override
    public void sdsSessionAborted() {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(14808325, "NaviInterface#sdsSessionAborted");
        }
        this.inputModeManager.setSdsActiveStatus(false);
    }

    @Override
    public void sdsDialogAborting() {
        this.env.getLogChannel().log(-2137614336, "NaviInterface#sdsDialogAborting - sdsDialogEndedActionsNecessary=%1", this.sdsDialogEndedActionsNecessary);
        this.inputModeManager.setSdsActiveStatus(false);
        CommandList commandList = this.getSdsDialogEndedRestoreCommandList();
        if (commandList.size() > 0) {
            commandList.execute("NaviInterface#sdsDialogAborting");
        }
    }

    @Override
    public void sdsDialogEnded() {
        this.env.getLogChannel().log(-2137614336, "NaviInterface#sdsDialogEnded - sdsDialogEndedActionsNecessary=%1", this.sdsDialogEndedActionsNecessary);
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
                this.env.getLogChannel().log(-2137614336, "NaviInterface#sdsDialogAborting - CTX_POI_MAIN_SCREEN was found on the speller stack.");
                this.sdsDialogCTXPOIHandling(commandList);
            } else {
                this.env.getLogChannel().log(1078071040, "NaviInterface#sdsDialogAborting - no POI related contexts were found on the spellerstack. Trying other contexts.");
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
        SpellerStack$StackElement spellerStack$StackElement = null;
        SpellerStack$StackElement spellerStack$StackElement2 = null;
        do {
            if (spellerStack$StackElement == null) continue;
            spellerStack$StackElement2 = spellerStack$StackElement;
        } while ((spellerStack$StackElement = this.spellerStack.pop()) != null && spellerStack$StackElement.sc.getContextID() != 8);
        commandList.add(new LIRestoreStateCommand(spellerStack$StackElement2.spellerData));
    }

    @Override
    public IRouteCriteria getRouteCriteria() {
        return this.navigation.getRouteCriteriaManager().getRouteCriteria();
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        this.env.getLogChannel().log(14808325, "NaviInterface#triggerEventAudioMessage, soundID is(%1)", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new TriggerEventAudioMessageCommand(n));
        commandList.execute("NaviInterface#triggerEventAudioMessage(int soundID)");
    }

    @Override
    public void triggerUpdateRcci() {
        this.env.getLogChannel().log(14808325, "NaviInterface#triggerUpdateRcci()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NaviInterface$7(this, "triggerUpdateRcci"));
        commandList.execute("NaviInterface#triggerUpdateRcci()");
    }

    @Override
    public void afaRepeat(int n) {
        this.env.getLogChannel().log(-2137614336, "NaviInterface#afaRepeat( %1 )", (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NaviInterface$8(this, "afaRepeat", n));
        commandList.execute("NaviInterface#afaRepeat()");
    }

    @Override
    public ITrafficMiniMap getTrafficMiniMap() {
        this.env.getLogChannel().log(14808325, "NaviInterface#getTrafficMiniMap()");
        return this.navigation.getTrafficMiniMap();
    }

    @Override
    public OnlineTrafficHandler getOnlineTrafficHandler() {
        return this.navigation.getOnlineTrafficHandler();
    }

    @Override
    public void setAddressInputFormModelAccessHelper(IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.addressInputFormModelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    public GpxHandler getGpxHandler() {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(14808325, "NaviInterface#getGpxHandler()");
        }
        return this.navigation.getGpxHandler();
    }

    @Override
    public void sendCalculatateAltRoutesResult(byte by) {
        this.getNavigation().getNaviServiceListenerController().responseCalculateAlternativeRoutes(by);
    }

    @Override
    public NavLocation getCurrentPoiProximityWarningLocation() {
        return this.getNavigation().getPoiService().getPoiWarningManager().getCurrentPoiProximityWarningLocation();
    }

    @Override
    public void hideCurrentPoiProximityWarningAfterSelection() {
        this.getNavigation().getPoiService().getPoiWarningManager().hideCurrentPoiWarningAfterSelection();
    }

    @Override
    public void focusSelenaRoutes(boolean bl) {
        this.getNavigation().getPredictiveNavController().focusSelenaRoutes(bl);
    }

    @Override
    public boolean isFeatureToBeLocked() {
        return this.featureToBeLocked;
    }

    @Override
    public void setFeatureToBeLocked(boolean bl) {
        this.featureToBeLocked = bl;
    }

    static /* synthetic */ IDetailsScreen access$000(NaviInterface naviInterface) {
        return naviInterface.detailsScreen;
    }

    static /* synthetic */ MonitorCalcRealRoadDistance access$102(NaviInterface naviInterface, MonitorCalcRealRoadDistance monitorCalcRealRoadDistance) {
        naviInterface.rrdMonitor = monitorCalcRealRoadDistance;
        return naviInterface.rrdMonitor;
    }
}

