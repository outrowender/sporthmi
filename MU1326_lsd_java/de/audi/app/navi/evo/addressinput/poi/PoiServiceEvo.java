/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo;
import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.app.navi.evo.addressinput.poi.details.MapPoiStackHMIListener;
import de.audi.app.navi.evo.addressinput.poi.details.MapPoiStackModelAccess;
import de.audi.app.navi.evo.addressinput.poi.details.PoiStackDetailsRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningHMIListener;
import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningModelAccess;
import de.audi.app.navi.evo.addressinput.poi.fuelwarning.PoiFuelWarningServiceEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.POIHistoryRowBuilder;
import de.audi.app.navi.evo.addressinput.poi.personal.PersonalPoiHMIListener;
import de.audi.app.navi.evo.addressinput.poi.personal.PersonalPoiModelAccess;
import de.audi.app.navi.evo.addressinput.poi.poiwarning.PoiWarningModelAccessEvo;
import de.audi.app.navi.evo.addressinput.poi.preferredstations.EvoPreferredStationsHMIListener;
import de.audi.app.navi.evo.addressinput.poi.preferredstations.EvoPreferredStationsModelAccess;
import de.audi.app.navi.evo.addressinput.poi.searcharea.PoiSearchAreaHmiListener;
import de.audi.app.navi.evo.addressinput.poi.searcharea.PoiSearchAreaModelAccess;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiDiagnosisUI;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSDSHandler;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.PoiDSIHandler;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IPoiFuelWarningService;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningSetup;
import de.audi.tghu.navi.app.addressinput.poi.personal.PersonalPoiHandler;
import de.audi.tghu.navi.app.addressinput.poi.preferredstations.PreferredStationsHandler;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequenceNAR;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiByStackSequence;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.car.IVehicleStatesObserver;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningHmiListener;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningManager;
import de.audi.tghu.navi.app.popup.PopupsHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.NavLocation;

public class PoiServiceEvo
implements IPoiService,
IVehicleStatesObserver,
IPoiDiagnosisUI {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private final NavigationEnv env;
    private final IconHandler iconHandler;
    private final ICommandListFactory commandListFactory;
    private final FuelWarningHMIListener fuelWarningHMIListener;
    private final MapPoiStackHMIListener mapPoiStackHMIListener;
    private final PoiFuelWarningServiceEvo poiFuelWarningService;
    private final PersonalPoiHandler personalPOIHandler;
    private final PoiWarningManager poiWarningManager;
    protected final IPoiSDSHandler poiSDSHandler;
    private final IVehicle vehicle;
    private final PoiSearchArea poiSearchArea;
    private final PoiSearchAreaSequence poiSearchAreaSequence;
    private final PoiManager poiManager;
    private final LogChannel logChannel;
    private final IDetailsScreen detailsScreen;

    public PoiServiceEvo(NavigationEnv navigationEnv, NaviInterface naviInterface, ICommandListFactory iCommandListFactory, IVehicle iVehicle, IconHandler iconHandler, ISDSController iSDSController, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, PopupsHandler popupsHandler, IPreviewMap iPreviewMap, IDestinationHandler iDestinationHandler, CityHistory cityHistory, IRouteManager iRouteManager, ICarKombiService iCarKombiService, PoiDSIHandler poiDSIHandler, OperationManager operationManager, IAddressInputForm iAddressInputForm, INaviAudioHandler iNaviAudioHandler, INaviFavoriteHandler iNaviFavoriteHandler, ITelService iTelService, MapInterface mapInterface, ADBInterAppService aDBInterAppService, NaviADBHandler naviADBHandler, HomeAddressHandler homeAddressHandler, SpellerStack spellerStack, IRRDListener iRRDListener, IDetailsScreen iDetailsScreen) {
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.iconHandler = iconHandler;
        this.commandListFactory = iCommandListFactory;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.poiSearchArea = navigationEnv.getPoiSearchArea();
        this.detailsScreen = iDetailsScreen;
        PoiSearchAreaModelAccess poiSearchAreaModelAccess = new PoiSearchAreaModelAccess(navigationEnv, cityHistory, new POIHistoryRowBuilder(), null);
        this.poiSearchAreaSequence = Util.isHURegionNAR() ? new PoiSearchAreaSequenceNAR(poiSearchAreaModelAccess, spellerStack, this.poiSearchArea, iCommandListFactory, iVehicle, navigationEnv, cityHistory, iRouteManager, iAddressInputForm, iPreviewMap) : new PoiSearchAreaSequence(poiSearchAreaModelAccess, spellerStack, this.poiSearchArea, iCommandListFactory, iVehicle, navigationEnv, cityHistory, iRouteManager, iAddressInputForm, iPreviewMap);
        PoiWorkFlowManager poiWorkFlowManager = new PoiWorkFlowManager(iVehicle, iCommandListFactory, spellerStack, iconHandler, navigationEnv.getInputModeManager(), homeAddressHandler, iRouteManager, aDBInterAppService, this.poiSearchAreaSequence);
        this.poiManager = new PoiManager(navigationEnv, iCommandListFactory, iconHandler, this.poiSearchArea, spellerStack, poiWorkFlowManager, iRouteManager, iVehicle, iStartGuidanceToDestinationSequence, iPreviewMap, iNaviFavoriteHandler, naviADBHandler, mapInterface, iTelService, iRRDListener, this.poiSearchAreaSequence, iDetailsScreen);
        poiWorkFlowManager.setPoiManager(this.poiManager);
        poiDSIHandler.setPoiManager(this.poiManager);
        new PoiSearchAreaHmiListener(navigationEnv, this.poiSearchAreaSequence, iRouteManager, this.poiManager, iAddressInputForm);
        poiDSIHandler.setPoiSearchAreaHandler(this.poiSearchAreaSequence);
        this.poiSDSHandler = new PoiSDSHandlerEvo(navigationEnv, iconHandler, iCommandListFactory, this.poiSearchArea, iDestinationHandler, iRouteManager, poiSearchAreaModelAccess, this.poiManager, spellerStack, iDetailsScreen);
        FuelWarningModelAccess fuelWarningModelAccess = new FuelWarningModelAccess(navigationEnv);
        PoiFuelWarningSetup poiFuelWarningSetup = new PoiFuelWarningSetup(navigationEnv);
        this.poiFuelWarningService = new PoiFuelWarningServiceEvo(navigationEnv, iCarKombiService, fuelWarningModelAccess, iRouteManager, poiFuelWarningSetup, iCommandListFactory, iVehicle, operationManager, iDetailsScreen);
        this.fuelWarningHMIListener = new FuelWarningHMIListener(navigationEnv, this.poiFuelWarningService, poiFuelWarningSetup, fuelWarningModelAccess, iconHandler, iStartGuidanceToDestinationSequence, iRouteManager, iVehicle, iPreviewMap, iCommandListFactory);
        popupsHandler.addHandler(this.fuelWarningHMIListener);
        this.mapPoiStackHMIListener = new MapPoiStackHMIListener(navigationEnv, iconHandler, iDestinationHandler, iPreviewMap, iCommandListFactory);
        this.personalPOIHandler = new PersonalPoiHandler(navigationEnv.getLogChannel(), naviInterface.getPOICategoryManager(), iCommandListFactory, new PersonalPoiModelAccess(navigationEnv), iconHandler, navigationEnv);
        new PersonalPoiHMIListener(navigationEnv, navigationEnv.getLogChannel(), this.personalPOIHandler);
        poiDSIHandler.setPersonalPoiHandler(this.personalPOIHandler);
        if (Util.isPreferredGasStationsPresent(navigationEnv.getFramework())) {
            EvoPreferredStationsModelAccess evoPreferredStationsModelAccess = new EvoPreferredStationsModelAccess(navigationEnv, iconHandler);
            PreferredStationsHandler preferredStationsHandler = new PreferredStationsHandler(iCommandListFactory, evoPreferredStationsModelAccess);
            new EvoPreferredStationsHMIListener(navigationEnv, preferredStationsHandler);
        }
        this.poiWarningManager = new PoiWarningManager(navigationEnv, new PoiWarningModelAccessEvo(navigationEnv, iconHandler), iCommandListFactory, iNaviAudioHandler, iVehicle, iconHandler, mapInterface);
        new PoiWarningHmiListener(navigationEnv, this.poiWarningManager);
        naviInterface.getPOICategoryManager().registerObserver(this.poiWarningManager);
    }

    public void startPoiStackSequence(NavLocation navLocation) {
        PoiByStackSequence poiByStackSequence = new PoiByStackSequence(new MapPoiStackModelAccess(this.env, this.mapPoiStackHMIListener, new PoiStackDetailsRowBuilder(this.iconHandler), 401114), this.commandListFactory, this.env, navLocation, this.detailsScreen);
        this.mapPoiStackHMIListener.setStackSequence(poiByStackSequence);
        poiByStackSequence.start();
    }

    public void onFullyOperable() {
        this.poiFuelWarningService.checkPendingEvents();
    }

    public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider iVehicleStatesEventsProvider) {
        iVehicleStatesEventsProvider.registerListener(this);
    }

    public IPoiSDSHandler getPoiSDSHandler() {
        return this.poiSDSHandler;
    }

    public CommandList getParkingNearDestinationSequenceWithDistanceFromCCP(final NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#getParkingNearDestinationSequenceWithDistanceFromCCP - destination=%2", (Object)this.CLASS_NAME, (Object)navLocation);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getParkingNearDestinationSequenceWithDistanceFromCCP - Setting Search Area").toString()){

            public void execute() {
                this.dsiResponseContainer.setSelectedLocation(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        return this.poiManager.handlePoiSelectionEvent(commandList, 1204);
    }

    public CommandList getParkingNearDestinationSequenceWithDistanceFromDestination(final NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#getParkingNearDestinationSequenceWithDistanceFromDestination - destination=%2", (Object)this.CLASS_NAME, (Object)navLocation);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("PoiServiceEvo#getParkingNearDestinationSequenceWithDistanceFromDestination - Setting Search Area"){

            public void execute() {
                this.dsiResponseContainer.setSelectedLocation(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        return this.poiManager.handlePoiSelectionEvent(commandList, 1204);
    }

    public CommandList getParkingAlongTheRouteSequence() {
        this.logChannel.log(10000000, "%1#getParkingAlongTheRouteSequence - destination=%2", (Object)this.CLASS_NAME, (Object)this.vehicle.getVehicleLocation());
        this.poiSearchArea.setSearchContext(1);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#getParkingAlongTheRouteSequence - Setting Search Area").toString()){

            public void execute() {
                this.dsiResponseContainer.setSelectedLocation(PoiServiceEvo.this.vehicle.getVehicleLocation());
                this.getCommandList().commandFinished();
            }
        });
        return this.poiManager.handlePoiSelectionEvent(commandList, 1205);
    }

    public void startParkingNearDestination(NavLocation navLocation) {
        this.getParkingNearDestinationSequenceWithDistanceFromDestination(navLocation).execute(new StringBuffer().append(this.CLASS_NAME).append("#startParkingNearDestination").toString());
    }

    public void enterPoiMainScreen(boolean bl, boolean bl2) {
        this.poiManager.startPoiMainScreen(bl, bl2);
    }

    public void updateTankInfo(TankInfo tankInfo) {
        this.poiFuelWarningService.updateTankInfo(tankInfo);
    }

    public void updateDisplayDayNightDesign(boolean bl) {
    }

    public void updateVehicleStandstill(boolean bl) {
    }

    public void updateESPData() {
    }

    public void destPOIHKReturn(int n, int n2) {
        this.logChannel.log(10000000, "%1#destPOIHKReturn, removeHandler: %2", (Object)this.CLASS_NAME, (long)n2);
        this.poiManager.destPOIHKReturn(n, n2);
    }

    public void navFuelFeatureActive(int n, int n2) {
        if (n2 == 0) {
            this.fuelWarningHMIListener.fuelFeatureLeft();
        } else {
            this.fuelWarningHMIListener.fuelFeatureEntered();
        }
    }

    public void deletePersonalPOIDataBases() {
        this.personalPOIHandler.deletePersonalPOIDataBases();
    }

    public PoiWarningManager getPoiWarningManager() {
        return this.poiWarningManager;
    }

    public IPoiFuelWarningService getPoiFuelWarningService() {
        return this.poiFuelWarningService;
    }

    public void startPoiWithSearchContextAlongRoute() {
        this.startPoiWithSearchContext(1, null, true);
    }

    public void startPoiWithSearchContextLocationVicinity() {
        this.startPoiWithSearchContext(0, null, true);
    }

    public void startPoiWithSearchContext(int n, NavLocation navLocation, boolean bl) {
        this.startPoiWithSearchContext(n, navLocation, bl, false);
    }

    public void startPoiWithSearchContext(int n, NavLocation navLocation, boolean bl, boolean bl2) {
        this.poiSearchAreaSequence.updateSearchArea(n, navLocation);
        this.enterPoiMainScreen(bl, bl2);
    }

    public void startPoiHybridSearch(int n, NavLocation navLocation, boolean bl) {
        this.logChannel.log(10000000, "PoiServiceEvo#startPoiHybridSearch - searchContext=%1, location=%2, resetSpellerStack=%3", (Object)new StringBuffer().append(n).append("").toString(), (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Boolean.toString(bl));
        this.poiSearchAreaSequence.updateSearchArea(n, navLocation);
        this.poiManager.executePoiSelectionEvent(this.commandListFactory.createCommandList(), 11);
    }

    public synchronized void cleanup() {
        if (this.poiWarningManager != null) {
            this.poiWarningManager.cleanup();
        }
        if (this.poiFuelWarningService != null) {
            this.poiFuelWarningService.cleanUp();
        }
    }

    public void setRouteGuidanceStartedByUser(boolean bl) {
        this.poiManager.setRouteGuidanceStartedByUser(bl);
    }

    public void showPoiDetailScreen(NavLocation navLocation) {
        this.logChannel.log(10000000, "%1#showPoiDetailScreen", (Object)this.CLASS_NAME);
        this.poiManager.showPoiDetailScreen(navLocation);
    }

    public boolean isFuelWarningActive() {
        return this.poiFuelWarningService.isFuelWarningActive();
    }

    public void setFuelWarningActive(boolean bl) {
    }

    public void onDisclaimerAccepted() {
    }

    public void resetSearchContext() {
        this.poiManager.resetPoiSearchArea();
    }
}

