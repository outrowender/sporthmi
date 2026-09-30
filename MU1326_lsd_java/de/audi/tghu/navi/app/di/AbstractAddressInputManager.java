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
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.country.UpdateDestinationCountryCodeCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LoadLocationFromPersistenceToCommandList;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.SetVehicleCountryLocationCommandListCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import de.audi.tghu.navi.app.li.sc.SpellerContextManager;
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
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
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

    protected abstract void initListeners();

    public CommandList handleAddressInputEvent(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#handleAddressInputEvent with ID=%2", (Object)this.CLASS_NAME, (long)n);
        return this.workFlowManager.handleWorkFlow(commandList, n);
    }

    public void executeAddressInputEvent(CommandList commandList, int n) {
        this.logChannel.log(10000000, "%1#executeAddressInputEvent with ID=%2", (Object)this.CLASS_NAME, (long)n);
        this.handleAddressInputEvent(commandList, n).execute(new StringBuffer().append(this.CLASS_NAME).append("#executeAddressInputEvent - eventId=").append(n).toString());
    }

    public void start() {
        this.start(null);
    }

    public void startForOnline() {
        this.startForOnline(this.commandListFactory.createCommandList());
    }

    public void startForOnline(CommandList commandList) {
        this.executeAddressInputEvent(commandList, this.getStartForOnlineEventId());
    }

    public void startForRemoteHMI() {
        this.startForRemoteHMI(this.commandListFactory.createCommandList());
    }

    public void startForRemoteHMI(CommandList commandList) {
        this.executeAddressInputEvent(commandList, this.getStartForRemoteHMIEventId());
    }

    public abstract void start(NavLocation var1);

    protected void addStripLocationForCcpCommands(CommandList commandList, int n) {
        NavLocation navLocation = this.vehicle.getVehicleLocationDescription();
        this.logChannel.log(10000000, "%1#addStripLocationForCcpCommands - CCP=%2, destinationType=%3", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        commandList.add(new LIStripLocationCommand(navLocation, n));
        commandList.add(new NavCommand("Change mapping of LIStripLocationResult"){

            public void execute() {
                this.getCommandList().put("startMainScreenNavLocation", this.getCommandList().get("STRIPPED_LOCATION"));
                this.getCommandList().commandFinished();
            }
        });
    }

    public NavLocation getBackupLocation() {
        this.logChannel.log(10000000, "%1#getBackupLocation() - backup location location is: %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.backupLocation));
        if (this.backupLocation == null) {
            this.logChannel.log(10000000, "%1#getBackupLocation() - backup location is null, trying to load persisted location", (Object)this.CLASS_NAME);
            NavLocation navLocation = this.getPersistedBackupLocation();
            if (navLocation != null && !Util.isEmpty(navLocation.country) && navLocation.isPositionValid()) {
                this.logChannel.log(10000000, "%1#getBackupLocation() - loaded persisted location!", (Object)this.CLASS_NAME);
                this.backupLocation = navLocation;
            }
        }
        return this.backupLocation;
    }

    public void setBackupLocation(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#setBackupLocation() - INPUTMODE IS %2", (Object)this.CLASS_NAME, (long)this.inputModeManager.getInputMode());
        if (navLocation != null && navLocation.isPositionValid() && this.inputModeManager.getInputMode() == 0) {
            this.logChannel.log(10000000, "%2#setBackupLocation() - Backup location set to: %1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
            this.backupLocation = navLocation;
        }
    }

    public NavLocation getPersistedBackupLocation() {
        this.logChannel.log(10000000, "%1#getPersistedBackupLocation()", (Object)this.CLASS_NAME);
        byte[] byArray = this.localPersistNavLocationHelper.loadPersistentState();
        if (byArray == null || byArray.length == 0) {
            return null;
        }
        NavLocation navLocation = this.locationSerializer.streamToLocation(byArray);
        return navLocation;
    }

    public void invalidateBackupLocation() {
        this.logChannel.log(10000000, "%1#invalidateBackupLocation()", (Object)this.CLASS_NAME);
        this.backupLocation = new NavLocation();
    }

    public void persistBackupLocation(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#persistBackupLocation for navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LocationToStreamCommand(navLocation));
        commandList.add(new NavCommand("SaveBackupLocationCommand"){

            public void execute() {
                AbstractAddressInputManager.this.localPersistNavLocationHelper.savePersistentState((byte[])this.getCommandList().get("LOCATION_STREAM"));
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("AbstractAddressInputManager#SaveBackupLocationCommandList");
    }

    public NavLocation getInitialLocation() {
        Route route;
        NavLocation navLocation;
        this.logChannel.log(10000000, "%1#getInitialLocation()", (Object)this.CLASS_NAME);
        if (this.inputModeManager.getInputMode() == 1 || this.inputModeManager.getInputMode() == 6 || this.inputModeManager.getInputMode() == 5 || this.inputModeManager.getInputMode() == 4) {
            this.logChannel.log(10000000, "%1#getInitialLocation() returning vehicleCountryLocation", (Object)this.CLASS_NAME);
            return this.vehicle.getVehicleCountryLocation();
        }
        NavLocation navLocation2 = this.getBackupLocation();
        if (navLocation2 != null && !Util.isEmpty(navLocation2.country)) {
            this.logChannel.log(10000000, "%1#getInitialLocation() returning  backupLocation", (Object)this.CLASS_NAME);
            return navLocation2;
        }
        if (this.routeManager != null && this.routeManager.getRoute() != null && (navLocation = RouteUtil.getFinalDestination(route = this.routeManager.getRoute())) != null) {
            this.logChannel.log(10000000, "%2#getInitialLocation() returning FinalDestiantion from Route = %1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
            return navLocation;
        }
        this.logChannel.log(10000000, "%2#getInitialLocation() returning Vehicle CountryLocation = %1", (Object)LocationFormatter.formatLocationShort(this.vehicle.getVehicleCountryLocation()), (Object)this.CLASS_NAME);
        return this.vehicle.getVehicleCountryLocation();
    }

    public void setPoiService(IPoiService iPoiService) {
        this.poiService = iPoiService;
    }

    public IPoiService getPoiService() {
        return this.poiService;
    }

    public CommandList abortAddressInput(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(".abortAddressInput.restore").toString()){

                public void execute() {
                    CommandList commandList = null;
                    if (!AbstractAddressInputManager.this.spellerStack.isEmpty()) {
                        commandList = AbstractAddressInputManager.this.commandListFactory.createCommandList();
                        SpellerStack.StackElement stackElement = AbstractAddressInputManager.this.getFirstStackElement();
                        commandList.add(new LIRestoreStateCommand(stackElement));
                    }
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            });
        }
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(".abortAddressInput.reset").toString()){

            public void execute() {
                AbstractAddressInputManager.this.spellerStack.reset();
                SpellerContextManager.reset();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        return commandList;
    }

    private SpellerStack.StackElement getFirstStackElement() {
        SpellerStack.StackElement stackElement = this.spellerStack.peekFirstStackElement();
        if (stackElement == null) {
            this.logChannel.log(10000, "%1#getFirstStackElement() - speller stack is empty! ", (Object)this.CLASS_NAME);
            return null;
        }
        return stackElement;
    }

    public CommandList acceptGivenInput(final AddressInputHandler addressInputHandler, final NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(".acceptGivenInput").toString()){

            public void execute() {
                CommandList commandList = AbstractAddressInputManager.this.commandListFactory.createCommandList();
                commandList.add(AbstractAddressInputManager.this.abortAddressInput(false));
                if (addressInputHandler != null) {
                    commandList.add(addressInputHandler.handleCompleteLocation(navLocation, AbstractAddressInputManager.this.logChannel));
                }
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public void addAddressToFavorites(NavLocation navLocation) {
        this.naviFavoriteHandler.addToFavorites(navLocation);
    }

    public CommandList getStartParkingNearDestination(NavLocation navLocation) {
        CommandList commandList;
        this.logChannel.log(10000000, "%1#getStartParkingNearDestination(), and destination validity is: %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(navLocation.isPositionValid()));
        if (this.poiService != null) {
            commandList = this.poiService.getParkingNearDestinationSequenceWithDistanceFromDestination(navLocation);
        } else {
            this.logChannel.log(100000, "%1#getStartParkingNearDestination *** POISERVICE IS NULL - CAN'T START PARKING NEAR DESTINATION, returning empty command list. ***", (Object)this.CLASS_NAME);
            commandList = this.commandListFactory.createCommandList();
        }
        return commandList;
    }

    public void startPoiNearDestination(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#startPoiNearDestination - location=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.poiService.startPoiWithSearchContext(4, navLocation, false, true);
    }

    public void onNewNaviServiceListener() {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (Util.isHURegionAsia()) {
            commandList.add(new NavCommand("Update destination country code"){

                public void execute() {
                    NavLocation navLocation = Vehicle.getInstance().getVehicleLocationDescription();
                    this.navigation.getNavObserverRegistry().countryUpdated(navLocation.getCountry(), navLocation.getCountryAbbreviation());
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("onNewNaviServiceListener").toString());
            return;
        }
        if (this.backupLocation == null) {
            commandList.add(new NavCommand("Get the persisted BackupLocation"){

                public void execute() {
                    byte[] byArray = AbstractAddressInputManager.this.localPersistNavLocationHelper.loadPersistentState();
                    this.getCommandList().commandFinishedWithPostCommand(new StreamToLocationCommand(byArray));
                }
            });
        }
        commandList.add(new NavCommand("set the initial LD for SDS "){

            public void execute() {
                if (this.dsiResponseContainer.getLiCurrentLD() == null) {
                    if (!this.dsiResponseContainer.isLiIsSpellerActive()) {
                        if (AbstractAddressInputManager.this.backupLocation == null) {
                            AbstractAddressInputManager.this.backupLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
                            if (AbstractAddressInputManager.this.backupLocation != null && !Util.isEmpty(AbstractAddressInputManager.this.backupLocation.country)) {
                                LISetCurrentLDCommand lISetCurrentLDCommand = new LISetCurrentLDCommand(AbstractAddressInputManager.this.backupLocation);
                                this.getCommandList().commandFinishedWithPostCommand(lISetCurrentLDCommand);
                            } else {
                                AbstractAddressInputManager.this.backupLocation = AbstractAddressInputManager.this.vehicle.getVehicleCountryLocation();
                                LISetCurrentLDCommand lISetCurrentLDCommand = new LISetCurrentLDCommand(AbstractAddressInputManager.this.backupLocation);
                                this.getCommandList().commandFinishedWithPostCommand(lISetCurrentLDCommand);
                            }
                        } else {
                            LISetCurrentLDCommand lISetCurrentLDCommand = new LISetCurrentLDCommand(AbstractAddressInputManager.this.backupLocation);
                            this.getCommandList().commandFinishedWithPostCommand(lISetCurrentLDCommand);
                        }
                    } else {
                        this.logger.log(1000000, "%1#execute() - speller currently active, do no set currentLD for onNewNaviServiceListener()", (Object)this.CLASS_NAME);
                        this.getCommandList().commandFinished();
                    }
                } else {
                    if (AbstractAddressInputManager.this.backupLocation == null) {
                        AbstractAddressInputManager.this.backupLocation = this.dsiResponseContainer.getLiCurrentLD();
                    }
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new UpdateDestinationCountryCodeCommand());
        commandList.add(new LoadLocationFromPersistenceToCommandList(989, "LOCATION_STREAM"));
        commandList.add(new NavCommand("Check if Persisted Last VehicleCountryLocation is available"){

            public void execute() {
                Object object = this.getCommandList().get("LOCATION_STREAM");
                if (!(object instanceof byte[]) || ((byte[])object).length == 0) {
                    this.logger.log(100000, "%1#execute() - object is null or not instance of byte[] or has no length", (Object)this.CLASS_NAME);
                    this.getCommandList().commandFinished();
                } else {
                    CommandList commandList = AbstractAddressInputManager.this.commandListFactory.createCommandList();
                    commandList.add(new StreamToLocationCommand("LOCATION_STREAM"));
                    commandList.add(new SetVehicleCountryLocationCommandListCommand("STREAMED_LOCATION"));
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#onNewNaviServiceListener").toString());
    }

    public void resetMemorySettings() {
        this.logChannel.log(10000000, "%1#resetMemorySettings()", (Object)this.CLASS_NAME);
        this.cityHistory.prepareDeleteLastStateCityAndStreetHistory().execute(new StringBuffer().append(this.CLASS_NAME).append("#resetMemorySettings()").toString());
        this.invalidateBackupLocation();
        this.persistBackupLocation(this.backupLocation);
    }

    public void startStreetInputSequenceWithFollowupJunction(boolean bl) {
    }

    public void startStoringNavLocationOnAdbEntry(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#startStoringNavLocationOnAdbEntry for navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.adbHandler.startStoringAddress(navLocation);
    }

    public int getActiveSpellerContextId() {
        if (this.spellerStack != null && this.spellerStack.getActiveSC() != null) {
            return this.spellerStack.getActiveSC().getContextID();
        }
        return -2;
    }

    protected void enterSearchAreaFromPoiContext() {
        this.logChannel.log(10000000, "%1#enterSearchAreaFromPoiContext()", (Object)this.CLASS_NAME);
        AddressInputUtil.setNewSearchAreaContextChoiceValue(this.env, 0);
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 0);
    }

    protected void enterSearchAreaFromOnlinePoiContext() {
        this.logChannel.log(10000000, "%1#enterSearchAreaFromOnlinePoiContext()", (Object)this.CLASS_NAME);
        AddressInputUtil.setNewSearchAreaContextChoiceValue(this.env, 1);
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 0);
    }

    protected void enterSearchAreaFromRemoteHmi() {
        this.logChannel.log(10000000, "%1#enterSearchAreaFromRemoteHmi()", (Object)this.CLASS_NAME);
        AddressInputUtil.setNewSearchAreaContextChoiceValue(this.env, 2);
        AddressInputUtil.setNewSearchAreaContextChoiceStatus(this.env, 0);
    }
}

