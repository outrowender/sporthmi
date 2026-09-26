/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.country.UpdateDestinationCountryCodeCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LoadLocationFromPersistenceToCommandList;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$1;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$2;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$3;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$4;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$5;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$6;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$7;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$8;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager$9;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public abstract class AbstractAddressInputManager
implements IAddressInputManager {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final IAddressInputWorkFlowManager workFlowManager;
    protected final LogChannel logChannel;
    protected final SpellerStack spellerStack;
    protected final IPreviewMap previewMap;
    protected final IStartGuidanceToDestinationSequence startRouteGuidanceSequence;
    protected final IVehicle vehicle;
    protected final INavigationInputModeManager inputModeManager;
    protected final LocationSerializer locationSerializer;
    protected final LocalPersistNavLocationHelper localPersistNavLocationHelper;
    protected final CityHistory cityHistory;
    protected final IRouteManager routeManager;
    protected IPoiService poiService;
    protected NavLocation backupLocation;
    protected final NaviADBHandler adbHandler;
    protected final INaviFavoriteHandler naviFavoriteHandler;
    protected final AsyncNavLocationExtractor asyncLiValueListNavLocationExctractor;
    protected final AsyncNavLocationExtractor asyncLiCityStateStreetHistoryListNavLocationExtractor;
    protected final ADBInterAppService adbInterAppService;
    protected final HomeAddressHandler homeAddressHandler;
    protected final MapInterface mapInterface;
    protected final IAddressInputFormModelAccessHelper modelAccessHelper;
    protected final HomeAddressHandler officeAddressHandler;
    protected final Monitor addressInputCommandListMonitor;

    public AbstractAddressInputManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.officeAddressHandler = homeAddressHandler2;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.spellerStack = spellerStack;
        this.previewMap = iPreviewMap;
        this.startRouteGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.workFlowManager = iAddressInputWorkFlowManager;
        this.vehicle = iVehicle;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.locationSerializer = locationSerializer;
        this.localPersistNavLocationHelper = new LocalPersistNavLocationHelper(navigationEnv, 930);
        this.routeManager = iRouteManager;
        this.cityHistory = cityHistory;
        this.adbHandler = naviADBHandler;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.asyncLiValueListNavLocationExctractor = asyncNavLocationExtractor;
        this.asyncLiCityStateStreetHistoryListNavLocationExtractor = asyncNavLocationExtractor2;
        this.adbInterAppService = aDBInterAppService;
        this.homeAddressHandler = homeAddressHandler;
        this.mapInterface = mapInterface;
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
        this.addressInputCommandListMonitor = new Monitor(this.logChannel);
        this.initListeners();
    }

    protected abstract void initListeners() {
    }

    @Override
    public CommandList handleAddressInputEvent(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#handleAddressInputEvent with ID=%2", (Object)this.CLASS_NAME, (long)n);
        return this.workFlowManager.handleWorkFlow(commandList, n);
    }

    @Override
    public void executeAddressInputEvent(CommandList commandList, int n) {
        this.logChannel.log(-2137614336, "%1#executeAddressInputEvent with ID=%2", (Object)this.CLASS_NAME, (long)n);
        this.handleAddressInputEvent(commandList, n).execute(new StringBuffer().append(this.CLASS_NAME).append("#executeAddressInputEvent - eventId=").append(n).toString());
    }

    @Override
    public void start() {
        this.start(null);
    }

    @Override
    public void startForOnline() {
        this.startForOnline(this.commandListFactory.createCommandList());
    }

    @Override
    public void startForOnline(CommandList commandList) {
        this.executeAddressInputEvent(commandList, this.getStartForOnlineEventId());
    }

    @Override
    public void startForRemoteHMI() {
        this.startForRemoteHMI(this.commandListFactory.createCommandList());
    }

    public void startForRemoteHMI(CommandList commandList) {
        this.executeAddressInputEvent(commandList, this.getStartForRemoteHMIEventId());
    }

    @Override
    public abstract void start(NavLocation navLocation) {
    }

    protected void addStripLocationForCcpCommands(CommandList commandList, int n) {
        NavLocation navLocation = this.vehicle.getVehicleLocationDescription();
        this.logChannel.log(-2137614336, "%1#addStripLocationForCcpCommands - CCP=%2, destinationType=%3", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        commandList.add(new LIStripLocationCommand(navLocation, n));
        commandList.add(new AbstractAddressInputManager$1(this, "Change mapping of LIStripLocationResult"));
    }

    @Override
    public NavLocation getBackupLocation() {
        this.logChannel.log(-2137614336, "%1#getBackupLocation() - backup location location is: %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.backupLocation));
        if (this.backupLocation == null) {
            this.logChannel.log(-2137614336, "%1#getBackupLocation() - backup location is null, trying to load persisted location", (Object)this.CLASS_NAME);
            NavLocation navLocation = this.getPersistedBackupLocation();
            if (navLocation != null && !Util.isEmpty(navLocation.country) && navLocation.isPositionValid()) {
                this.logChannel.log(-2137614336, "%1#getBackupLocation() - loaded persisted location!", (Object)this.CLASS_NAME);
                this.backupLocation = navLocation;
            }
        }
        return this.backupLocation;
    }

    @Override
    public void setBackupLocation(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#setBackupLocation() - INPUTMODE IS %2", (Object)this.CLASS_NAME, (long)this.inputModeManager.getInputMode());
        if (navLocation != null && navLocation.isPositionValid() && this.inputModeManager.getInputMode() == 0) {
            this.logChannel.log(-2137614336, "%2#setBackupLocation() - Backup location set to: %1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
            this.backupLocation = navLocation;
        }
    }

    @Override
    public NavLocation getPersistedBackupLocation() {
        this.logChannel.log(-2137614336, "%1#getPersistedBackupLocation()", (Object)this.CLASS_NAME);
        byte[] byArray = this.localPersistNavLocationHelper.loadPersistentState();
        if (byArray == null || byArray.length == 0) {
            return null;
        }
        NavLocation navLocation = this.locationSerializer.streamToLocation(byArray);
        return navLocation;
    }

    @Override
    public void invalidateBackupLocation() {
        this.logChannel.log(-2137614336, "%1#invalidateBackupLocation()", (Object)this.CLASS_NAME);
        this.backupLocation = new NavLocation();
    }

    @Override
    public void persistBackupLocation(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#persistBackupLocation for navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new AbstractAddressInputManager$2(this, "SaveBackupLocationCommand"));
        commandList.execute("AbstractAddressInputManager#SaveBackupLocationCommandList");
    }

    @Override
    public NavLocation getInitialLocation() {
        Route route;
        NavLocation navLocation;
        this.logChannel.log(-2137614336, "%1#getInitialLocation()", (Object)this.CLASS_NAME);
        if (this.inputModeManager.getInputMode() == 1 || this.inputModeManager.getInputMode() == 6 || this.inputModeManager.getInputMode() == 5 || this.inputModeManager.getInputMode() == 4) {
            this.logChannel.log(-2137614336, "%1#getInitialLocation() returning vehicleCountryLocation", (Object)this.CLASS_NAME);
            return this.vehicle.getVehicleCountryLocation();
        }
        NavLocation navLocation2 = this.getBackupLocation();
        if (navLocation2 != null && !Util.isEmpty(navLocation2.country)) {
            this.logChannel.log(-2137614336, "%1#getInitialLocation() returning  backupLocation", (Object)this.CLASS_NAME);
            return navLocation2;
        }
        if (this.routeManager != null && this.routeManager.getRoute() != null && (navLocation = RouteUtil.getFinalDestination(route = this.routeManager.getRoute())) != null) {
            this.logChannel.log(-2137614336, "%2#getInitialLocation() returning FinalDestiantion from Route = %1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
            return navLocation;
        }
        this.logChannel.log(-2137614336, "%2#getInitialLocation() returning Vehicle CountryLocation = %1", (Object)LocationFormatter.formatLocationShort(this.vehicle.getVehicleCountryLocation()), (Object)this.CLASS_NAME);
        return this.vehicle.getVehicleCountryLocation();
    }

    @Override
    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }

    @Override
    public IPoiService getPoiService() {
        return this.poiService;
    }

    @Override
    public CommandList abortAddressInput(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new AbstractAddressInputManager$3(this, new StringBuffer().append(this.CLASS_NAME).append(".abortAddressInput.restore").toString()));
        }
        commandList.add(new AbstractAddressInputManager$4(this, new StringBuffer().append(this.CLASS_NAME).append(".abortAddressInput.reset").toString()));
        commandList.add(new LISPCancelSpellerCommand());
        return commandList;
    }

    private SpellerStack$StackElement getFirstStackElement() {
        SpellerStack$StackElement spellerStack$StackElement = this.spellerStack.peekFirstStackElement();
        if (spellerStack$StackElement == null) {
            this.logChannel.log(10000, "%1#getFirstStackElement() - speller stack is empty! ", (Object)this.CLASS_NAME);
            return null;
        }
        return spellerStack$StackElement;
    }

    @Override
    public CommandList acceptGivenInput(AddressInputHandler addressInputHandler, NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AbstractAddressInputManager$5(this, new StringBuffer().append(this.CLASS_NAME).append(".acceptGivenInput").toString(), addressInputHandler, navLocation));
        return commandList;
    }

    @Override
    public void addAddressToFavorites(NavLocation navLocation) {
        this.naviFavoriteHandler.addToFavorites(navLocation);
    }

    @Override
    public CommandList getStartParkingNearDestination(NavLocation navLocation) {
        CommandList commandList;
        this.logChannel.log(-2137614336, "%1#getStartParkingNearDestination(), and destination validity is: %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(navLocation.isPositionValid()));
        if (this.poiService != null) {
            commandList = this.poiService.getParkingNearDestinationSequenceWithDistanceFromDestination(navLocation);
        } else {
            this.logChannel.log(-1601830656, "%1#getStartParkingNearDestination *** POISERVICE IS NULL - CAN'T START PARKING NEAR DESTINATION, returning empty command list. ***", (Object)this.CLASS_NAME);
            commandList = this.commandListFactory.createCommandList();
        }
        return commandList;
    }

    @Override
    public void startPoiNearDestination(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#startPoiNearDestination - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.poiService.startPoiWithSearchContext(4, navLocation, false, true);
    }

    @Override
    public void onNewNaviServiceListener() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (Util.isHURegionAsia()) {
            commandList.add(new AbstractAddressInputManager$6(this, "Update destination country code"));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("onNewNaviServiceListener").toString());
            return;
        }
        if (this.backupLocation == null) {
            commandList.add(new AbstractAddressInputManager$7(this, "Get the persisted BackupLocation"));
        }
        commandList.add(new AbstractAddressInputManager$8(this, "set the initial LD for SDS "));
        commandList.add(new UpdateDestinationCountryCodeCommand());
        commandList.add(new LoadLocationFromPersistenceToCommandList(989, "LOCATION_STREAM"));
        commandList.add(new AbstractAddressInputManager$9(this, "Check if Persisted Last VehicleCountryLocation is available"));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#onNewNaviServiceListener").toString());
    }

    @Override
    public void resetMemorySettings() {
        this.logChannel.log(-2137614336, "%1#resetMemorySettings()", (Object)this.CLASS_NAME);
        this.cityHistory.prepareDeleteLastStateCityAndStreetHistory().execute(new StringBuffer().append(this.CLASS_NAME).append("#resetMemorySettings()").toString());
        this.invalidateBackupLocation();
        this.persistBackupLocation(this.backupLocation);
    }

    @Override
    public void startStreetInputSequenceWithFollowupJunction(boolean bl) {
    }

    @Override
    public void startStoringNavLocationOnAdbEntry(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#startStoringNavLocationOnAdbEntry for navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.adbHandler.startStoringAddress(navLocation);
    }

    @Override
    public int getActiveSpellerContextId() {
        if (this.spellerStack != null && this.spellerStack.getActiveSC() != null) {
            return this.spellerStack.getActiveSC().getContextID();
        }
        return -2;
    }

    protected void enterSearchAreaFromPoiContext() {
        this.logChannel.log(-2137614336, "%1#enterSearchAreaFromPoiContext()", (Object)this.CLASS_NAME);
        AddressInputUtil.setNewSearchAreaContextChoiceValue(this.env, 0);
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 0);
    }

    protected void enterSearchAreaFromOnlinePoiContext() {
        this.logChannel.log(-2137614336, "%1#enterSearchAreaFromOnlinePoiContext()", (Object)this.CLASS_NAME);
        AddressInputUtil.setNewSearchAreaContextChoiceValue(this.env, 1);
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 0);
    }

    protected void enterSearchAreaFromRemoteHmi() {
        this.logChannel.log(-2137614336, "%1#enterSearchAreaFromRemoteHmi()", (Object)this.CLASS_NAME);
        AddressInputUtil.setNewSearchAreaContextChoiceValue(this.env, 2);
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 0);
    }

    static /* synthetic */ SpellerStack$StackElement access$000(AbstractAddressInputManager abstractAddressInputManager) {
        return abstractAddressInputManager.getFirstStackElement();
    }
}

