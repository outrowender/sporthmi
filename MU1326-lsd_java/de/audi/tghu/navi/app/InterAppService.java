/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.IWordPredictionCallback;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$IRRDCallback;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.InterAppService$1;
import de.audi.tghu.navi.app.InterAppService$10;
import de.audi.tghu.navi.app.InterAppService$11;
import de.audi.tghu.navi.app.InterAppService$12;
import de.audi.tghu.navi.app.InterAppService$13;
import de.audi.tghu.navi.app.InterAppService$2;
import de.audi.tghu.navi.app.InterAppService$3;
import de.audi.tghu.navi.app.InterAppService$4;
import de.audi.tghu.navi.app.InterAppService$5;
import de.audi.tghu.navi.app.InterAppService$6;
import de.audi.tghu.navi.app.InterAppService$7;
import de.audi.tghu.navi.app.InterAppService$8;
import de.audi.tghu.navi.app.InterAppService$9;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSDSHandler;
import de.audi.tghu.navi.app.addressinput.sds.IAddressInputSDSForm;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIService;
import de.audi.tghu.navi.app.command.CheckTryBestMatchResultCommand;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.LITryBestMatchCommand;
import de.audi.tghu.navi.app.command.PoiGetXt9LDBsCommand;
import de.audi.tghu.navi.app.command.RGSetRouteGuidanceMode;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.poi.RRDStartCalculationForPositionCommand;
import de.audi.tghu.navi.app.command.poi.RRDStopCalculationCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager;
import de.audi.tghu.navi.app.interapp.IRouteGuidanceInterAppService;
import de.audi.tghu.navi.app.interapp.RouteCriteriaInterAppService;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService;
import de.audi.tghu.navi.app.map.handler.LGIInterAppServiceHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.operatorcall.INaviOperatorCallService;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.sds.ISDSDetourHandler;
import de.audi.tghu.navi.app.sds.SDSHandler;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;
import de.audi.tghu.navi.app.sds.SUIHandler;
import de.audi.tghu.navi.app.tr.TrafficRegulationService;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.startup.DisclaimerHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcMessage;

public class InterAppService
implements NaviService {
    private final NavigationEnv env;
    private Navigation navigation;
    private LogChannel logChannel = null;
    private SDSHandlerImpl sdsHandler = null;
    private NaviOnlineService naviOnlineService = null;
    private ITpegPOIService tpegPOIService = null;
    private NaviService$IRRDCallback rrdCallbackListener = null;
    private final ISDSController sdsController;
    private final TrafficRegulationInterAppService trafficRegulationInterAppService;
    private final IRouteGuidanceInterAppService routeGuidanceInterAppService;
    private final RouteCriteriaInterAppService routeCriteriaInterAppService;
    private final SUIHandler suiHandler;
    private final NaviServiceListener naviServiceListener;
    private final IPoiSDSHandler poiSDSHandler;
    private final IAddressInputSDSForm addressInputSDSForm;
    private final ISDSDetourHandler sdsDetourHandler;
    private final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private final INavigationInputModeManager inputModeManager;
    private final ICommandListFactory commandListFactory;
    private final GeoCoordInputManager geoCoordInputManager;
    private final AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexHandler;
    private final DisclaimerHandler disclaimerHandler;
    private final INaviOperatorCallService operatorCallService;
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$InterAppService == null ? (class$de$audi$tghu$navi$app$InterAppService = InterAppService.class$("de.audi.tghu.navi.app.InterAppService")) : class$de$audi$tghu$navi$app$InterAppService);
    private Route lastRoute;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$InterAppService;

    public InterAppService(NavigationEnv navigationEnv, Navigation navigation, ICommandListFactory iCommandListFactory, ISDSController iSDSController, TrafficRegulationService trafficRegulationService, SUIHandler sUIHandler, NaviServiceListener naviServiceListener, IPoiSDSHandler iPoiSDSHandler, IAddressInputSDSForm iAddressInputSDSForm, IRouteGuidanceInterAppService iRouteGuidanceInterAppService, RouteCriteriaInterAppService routeCriteriaInterAppService, ISDSDetourHandler iSDSDetourHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, GeoCoordInputManager geoCoordInputManager, AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexCommandListCreator, DisclaimerHandler disclaimerHandler, INaviOperatorCallService iNaviOperatorCallService) {
        this.sdsController = iSDSController;
        this.env = navigationEnv;
        this.navigation = navigation;
        this.suiHandler = sUIHandler;
        this.naviServiceListener = naviServiceListener;
        this.poiSDSHandler = iPoiSDSHandler;
        this.addressInputSDSForm = iAddressInputSDSForm;
        this.routeGuidanceInterAppService = iRouteGuidanceInterAppService;
        this.routeCriteriaInterAppService = routeCriteriaInterAppService;
        this.sdsDetourHandler = iSDSDetourHandler;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.commandListFactory = iCommandListFactory;
        this.geoCoordInputManager = geoCoordInputManager;
        this.addSelectedDestinationAtIndexHandler = addSelectedDestinationAtIndexCommandListCreator;
        this.disclaimerHandler = disclaimerHandler;
        this.operatorCallService = iNaviOperatorCallService;
        this.logChannel = navigationEnv.getLogChannel("App.Navi.Interapp");
        this.trafficRegulationInterAppService = new TrafficRegulationInterAppService(trafficRegulationService, this.logChannel, iCommandListFactory, navigationEnv);
    }

    public void cleanUp() {
        this.rrdCallbackListener = null;
        this.navigation = null;
    }

    @Override
    public int computeRelativeDirection(int n, int n2) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "InterAppService#computeRelativeDirection()");
        }
        PosPosition posPosition = this.navigation.getVehicle().getFrontUnitPosition();
        int n3 = 0;
        if (posPosition != null) {
            int n4 = Util.computeAbsoluteDirection(posPosition, n, n2);
            int n5 = this.navigation.getVehicle().getHeading(posPosition);
            n3 = Util.convertRotatingDirection(n4, n5);
        } else {
            this.logChannel.log(10000, "InterAppService#computeRelativeDirection() - vehiclePosition is null! ");
        }
        return n3;
    }

    @Override
    public int computeRelativeAirDistance(int n, int n2) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "InterAppService#computeRelativeAirDistance()");
        }
        PosPosition posPosition = this.navigation.getVehicle().getFrontUnitPosition();
        int n3 = 0;
        if (posPosition != null) {
            n3 = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), n, n2);
        } else {
            this.logChannel.log(10000, "InterAppService#computeRelativeAirDistance() - vehiclePosition is null! ");
        }
        return n3;
    }

    @Override
    public void calculateRRDForNavArray(NavLocation[] navLocationArray, NaviService$IRRDCallback naviService$IRRDCallback) {
        this.logChannel.log(1078071040, "%1#calculateRRDForNavArray() received array of navLocations with length = %2, callbackisNotNull = %3", (Object)CLASS_NAME, (Object)String.valueOf(navLocationArray.length), (Object)String.valueOf(naviService$IRRDCallback != null));
        this.calculateRRDForNavLocationWgs84Array(Util.navLocationsToWgs84(navLocationArray), naviService$IRRDCallback);
    }

    @Override
    public void calculateRRDForNavLocationWgs84Array(NavLocationWgs84[] navLocationWgs84Array, NaviService$IRRDCallback naviService$IRRDCallback) {
        this.logChannel.log(1078071040, "%1#calculateRRDForNavLocationWgs84Array() received array of navLocations with length = %2, callbackisNotNull = %3", (Object)CLASS_NAME, (Object)String.valueOf(navLocationWgs84Array.length), (Object)String.valueOf(naviService$IRRDCallback != null));
        this.rrdCallbackListener = naviService$IRRDCallback;
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDStopCalculationCommand());
        commandList.add(new RRDStartCalculationForPositionCommand(navLocationWgs84Array));
        commandList.execute("InterAppService#calculateRRDForNavLocationWgs84Array");
    }

    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.logChannel.log(1078071040, "%1#updateRrdCalculationInfo() with %2 elements of RrdCalculationInfo-array", (Object)CLASS_NAME, (long)rrdCalculationInfoArray.length);
        if (this.rrdCallbackListener != null) {
            this.rrdCallbackListener.updateRrdItems(rrdCalculationInfoArray);
        } else if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#updateRrdCalculationInfo() - no rrdCallbackListener registered cant provide updateinfo", (Object)CLASS_NAME);
        }
    }

    @Override
    public void stopRRDCalculation() {
        this.logChannel.log(1078071040, "%1#stopRRDCalculation() - create commandList to stop RRD", (Object)CLASS_NAME);
        this.rrdCallbackListener = null;
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDStopCalculationCommand());
        commandList.execute("InterAppService#stopRRDCalculation");
    }

    @Override
    public void setMOSTFrameVisible(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#setMOSTFrameVisible()");
        this.navigation.getClusterService().setMOSTFrameVisible(bl);
    }

    @Override
    public void setAnnouncementRepeatMode(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#setAnnouncementRepeatMode( %1 )", bl);
        this.navigation.getAudioStateMachine().setAutoRepeatMode(bl);
    }

    @Override
    public void abortActiveAnnouncement() {
        this.logChannel.log(1078071040, "InterAppService#abortActiveAnnouncement()");
        this.navigation.getAudioStateMachine().audioTrigger(false);
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#setTrailerStatus()");
        this.routeCriteriaInterAppService.setTrailer(bl);
    }

    @Override
    public byte getOperationState() {
        byte by;
        this.logChannel.log(1078071040, "InterAppService#getOperationState()");
        int n = this.env.getContainer().getNavstateOfOperation();
        boolean bl = this.navigation.getOperationManager().isFullyOperable();
        switch (n) {
            case 5: {
                by = bl ? (byte)0 : 1;
                break;
            }
            case 3: {
                by = 2;
                break;
            }
            default: {
                by = 1;
            }
        }
        this.logChannel.log(1078071040, "%1#getOperationState() - lookup in NaviService.OPERATION_STATE_* = %2", (Object)CLASS_NAME, (long)by);
        return by;
    }

    @Override
    public boolean getRgActiveStatus() {
        this.logChannel.log(1078071040, "InterAppService#getRgActiveStatus()");
        return this.routeGuidanceInterAppService.getRgActiveStatus();
    }

    @Override
    public boolean isEtcDemoMode() {
        this.logChannel.log(1078071040, "InterAppService#isEtcDemoMode()");
        return this.routeGuidanceInterAppService.isEtcDemoMode();
    }

    @Override
    public boolean isDieselPrimaryEngineType() {
        this.logChannel.log(1078071040, "InterAppService#isDieselPrimaryEngineType()");
        if (null == this.navigation.carKombiService) {
            return false;
        }
        switch (this.navigation.carKombiService.getEngineTypePrimary()) {
            case 6: {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isHomeAvailable() {
        boolean bl = this.navigation.getHomeAddressHandler().isHomeAddressAvailable();
        this.logChannel.log(1078071040, "%2#isHomeAvailable() result=%1", bl, (Object)CLASS_NAME);
        return bl;
    }

    @Override
    public boolean isOfficeAvailable() {
        boolean bl = this.navigation.getOfficeAddressHandler().isHomeAddressAvailable();
        this.logChannel.log(1078071040, "%2#isOfficeAvailable() result=%1", bl, (Object)CLASS_NAME);
        return bl;
    }

    @Override
    public byte selectHomeAddressForRouteGuidance() {
        this.logChannel.log(1078071040, "%1#selectHomeAddressForRouteGuidance()", (Object)CLASS_NAME);
        if (this.isHomeAvailable()) {
            this.sdsHandler.showIntelliDestinationInDetailScreen(this.navigation.getHomeAddressHandler().getCurrentHomeAddress(), 0);
            return 0;
        }
        return 1;
    }

    @Override
    public byte selectOfficeAddressForRouteGuidance() {
        this.logChannel.log(1078071040, "InterAppService#selectOfficeAddressForRouteGuidance()");
        if (this.isOfficeAvailable()) {
            this.sdsHandler.showIntelliDestinationInDetailScreen(this.navigation.getOfficeAddressHandler().getCurrentHomeAddress(), 1);
            return 0;
        }
        return 1;
    }

    @Override
    public byte setHomeAddress() {
        this.logChannel.log(1078071040, "InterAppService#setHomeAddress()");
        this.navigation.getHomeAddressHandler().onCreateEditHomeAddress(this.env.getContainer().getLiCurrentLD());
        return this.navigation.getHomeAddressHandler().isHomeAddressAvailable() ? (byte)0 : 1;
    }

    @Override
    public byte setOfficeAddress() {
        this.logChannel.log(1078071040, "InterAppService#setOfficeAddress()");
        this.navigation.getOfficeAddressHandler().onCreateEditHomeAddress(this.env.getContainer().getLiCurrentLD());
        return this.navigation.getOfficeAddressHandler().isHomeAddressAvailable() ? (byte)0 : 1;
    }

    @Override
    public boolean isLastDestAvailable() {
        this.logChannel.log(1078071040, "InterAppService#isFavoritesAvailable()");
        return false;
    }

    @Override
    public String getCurrentCountryCode() {
        this.logChannel.log(1078071040, "InterAppService#getCurrentCountryCode()");
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        NavLocation navLocation2 = this.getCurrentCarPosition();
        boolean bl = this.checkIfCountryCodeAvailable(navLocation);
        boolean bl2 = this.checkIfCountryCodeAvailable(navLocation2);
        if (!bl && !bl2) {
            this.logChannel.log(10000, "InterAppService#getCurrentCountryCode() - both liCurrentLD and CCP have not location with country code, return NULL");
            return null;
        }
        if (this.env.getFramework().isEu() || this.env.getFramework().isRdw()) {
            if (bl2) {
                this.logChannel.log(1078071040, "InterAppService#getCurrentCountryCode() - returning CCP country code '%1'", (Object)navLocation2.getCountryAbbreviation());
                return navLocation2.getCountryAbbreviation();
            }
            this.logChannel.log(1078071040, "InterAppService#getCurrentCountryCode() - returning AIF country code '%1'", (Object)navLocation.getCountryAbbreviation());
            return navLocation.getCountryAbbreviation();
        }
        if (bl) {
            this.logChannel.log(1078071040, "InterAppService#getCurrentCountryCode() - returning AIF country code '%1'", (Object)navLocation.getCountryAbbreviation());
            return navLocation.getCountryAbbreviation();
        }
        this.logChannel.log(1078071040, "InterAppService#getCurrentCountryCode() - returning CCP country code '%1'", (Object)navLocation2.getCountryAbbreviation());
        return navLocation2.getCountryAbbreviation();
    }

    @Override
    public String getAIFCountryCode() {
        this.logChannel.log(1078071040, "InterAppService#getAIFCountryCode()");
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        boolean bl = this.checkIfCountryCodeAvailable(navLocation);
        if (bl) {
            this.logChannel.log(1078071040, "InterAppService#getAIFCountryCode() - returning AIF country code '%1'", (Object)navLocation.getCountryAbbreviation());
            return navLocation.getCountryAbbreviation();
        }
        this.logChannel.log(10000, "InterAppService#getAIFCountryCode() - liCurrentLD has no location with country code, return NULL");
        return null;
    }

    private boolean checkIfCountryCodeAvailable(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "InterAppService#checkIfCountryCodeAvailable() - NavLocation is NULL");
            return false;
        }
        if (Util.isEmpty(navLocation.getCountryAbbreviation())) {
            this.logChannel.log(10000, "InterAppService#checkIfCountryCodeAvailable() - countryAbbreviation is empty, NavLocation=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
            return false;
        }
        return true;
    }

    @Override
    public void setGuidanceMode(byte by) {
        this.logChannel.log(1078071040, "InterAppService#setGuidanceMode(%1)", (long)by);
        this.sdsHandler.setGuidanceMode(by);
    }

    @Override
    public void setRouteOptionDynamic(int n) {
        this.logChannel.log(1078071040, "InterAppService#setRouteOptionDynamic(%1)", (long)n);
        this.routeCriteriaInterAppService.setRouteOptionDynamic(n, this.naviServiceListener);
    }

    @Override
    public void synchronizeSpeechCountryWithCurrentLD() {
        this.logChannel.log(1078071040, "InterAppService#synchronizeSpeechCountryWithCurrentLD()");
        this.addressInputSDSForm.synchronizeSpeechCountryWithCurrentLD(this.naviServiceListener);
    }

    @Override
    public void startDestinationInput(int n) {
        this.logChannel.log(1078071040, "InterAppService#startDestinationInput( %1 ) --> will set NAV_RESET_INPUT_MODE_CHOICE to NAV_RESET_INPUT_MODE_CHOICE_SDS (1)", (long)n);
        this.env.getChoiceModel(170).setValue(1);
        this.inputModeManager.setSdsDestinationType(n);
        if (n == 10 && this.poiSDSHandler != null) {
            this.poiSDSHandler.startDestinationInput(this.naviServiceListener);
        } else {
            this.addressInputSDSForm.startDestinationInput(n, this.naviServiceListener);
        }
    }

    @Override
    public void startDestinationInputWithCurrentLD(int n) {
        this.logChannel.log(1078071040, "InterAppService#startDestinationInputWithCurrentLD( %1 ) --> will set NAV_RESET_INPUT_MODE_CHOICE to NAV_RESET_INPUT_MODE_CHOICE_SDS (1)", (long)n);
        this.env.getChoiceModel(170).setValue(1);
        this.inputModeManager.setSdsDestinationType(n);
        if (n == 10 && this.poiSDSHandler != null) {
            this.logChannel.log(-1601830656, "InterAppService#startDestinationInputWithCurrentLD --> should not be used for POI input");
            this.poiSDSHandler.startDestinationInput(this.naviServiceListener);
        } else {
            this.addressInputSDSForm.startDestinationInputWithCurrentLD(n, this.naviServiceListener);
        }
    }

    @Override
    public void nextDestinationInput(int n) {
        this.logChannel.log(1078071040, "InterAppService#nextDestinationInput( %1 ) ", (long)n);
        this.addressInputSDSForm.nextDestinationInput(n);
    }

    @Override
    public void triggerAddressInputReturn(int n) {
        this.logChannel.log(1078071040, "InterAppService#triggerAddressInputReturn( %1 )", (long)n);
        this.addressInputSDSForm.triggerAddressInputReturn(n, this.naviServiceListener);
    }

    @Override
    public void triggerAddressInputReturn(int n, int n2) {
        this.logChannel.log(1078071040, "InterAppService#triggerAddressInputReturn( %1 , %2)", (long)n, (long)n2);
        this.addressInputSDSForm.triggerAddressInputReturn(n, n2, this.naviServiceListener);
    }

    @Override
    public void startPoiSearchByName() {
        this.logChannel.log(1078071040, "InterAppService#startPoiSearchByName()");
        this.poiSDSHandler.startPoiSearchByName(this.naviServiceListener);
    }

    @Override
    public void checkRouteGuidance() {
        this.logChannel.log(1078071040, "InterAppService#checkRouteGuidance() - ");
        this.sdsHandler.checkRouteGuidance();
    }

    @Override
    public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1078071040, "InterAppService#fillNaviPickList()");
        return this.sdsHandler.fillNaviPickList(sDSListEntryArray);
    }

    @Override
    public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1078071040, "InterAppService#fillNaviFavoritePickList()");
        return this.sdsHandler.fillNaviFavoritePickList(sDSListEntryArray);
    }

    @Override
    public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1078071040, "InterAppService#fillLastDestinationPickList()");
        return this.sdsHandler.fillLastDestinationPickList(sDSListEntryArray);
    }

    @Override
    public void setCountry(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setCountry( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setCountry(string, string2, this.naviServiceListener);
    }

    @Override
    public void setState(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setState( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setState(string, string2, this.naviServiceListener);
    }

    @Override
    public void setCountryAndState(String string, String string2, String string3, String string4) {
        this.logChannel.log(1078071040, "InterAppService#setCountryAndState( %1, %2, %3, %4 )", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        this.addressInputSDSForm.setCountryAndState(string, string2, string3, string4, this.naviServiceListener);
    }

    @Override
    public void setCity(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setCity( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setCity(string, string2, this.naviServiceListener);
    }

    @Override
    public void setStreet(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setStreet( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setStreet(string, string2, this.naviServiceListener);
    }

    @Override
    public void setJunction(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setJunction( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setJunction(string, string2, this.naviServiceListener);
    }

    @Override
    public void setHouseNumber(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setHouseNumber( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setHouseNumber(string, string2, this.naviServiceListener);
    }

    @Override
    public void setHouseNumberByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#setHouseNumberById( %1 )", (long)n);
        this.addressInputSDSForm.setHouseNumberByIndex(n, this.naviServiceListener);
    }

    @Override
    public void setCenter() {
        this.logChannel.log(1078071040, "InterAppService#setCenter()");
        this.addressInputSDSForm.setCenter(this.naviServiceListener);
    }

    @Override
    public void setZIPCode(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setZIPCode( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setZIPCode(string, string2, this.naviServiceListener);
    }

    @Override
    public void setProvince(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setProvince( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setProvince(string, string2, this.naviServiceListener);
    }

    @Override
    public void setPrefecture(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setPrefecture( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setPrefecture(string, string2, this.naviServiceListener);
    }

    @Override
    public void setPlacename(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setPlacename( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setPlacename(string, string2, this.naviServiceListener);
    }

    @Override
    public void setWard(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setWard( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setWard(string, string2, this.naviServiceListener);
    }

    @Override
    public void setChome(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setChome( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setChome(string, string2, this.naviServiceListener);
    }

    @Override
    public void setSubmunicipaltownOrStreet(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setSubmunicipaltownOrStreet( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setSubmunicipalTownOrStreet(string, string2, this.naviServiceListener);
    }

    @Override
    public void setVillageAndStreet(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setVillageAndStreet( %1, %2 )", (Object)string, (Object)string2);
        this.addressInputSDSForm.setVillageAndStreet(string, string2, this.naviServiceListener);
    }

    @Override
    public void updateDetailScreenInfo() {
        this.logChannel.log(1078071040, "InterAppService#updateDetailScreenInfo()");
        this.addressInputSDSForm.updateDetailScreenInfo(this.naviServiceListener);
    }

    @Override
    public void setOneShotData(Map map) {
        this.logChannel.log(1078071040, "InterAppService#setOneShotData( %1 )", (Object)map);
        this.addressInputSDSForm.setOneShotData(map, this.naviServiceListener);
    }

    @Override
    public void querySpelledCityResultList(String string) {
        this.logChannel.log(1078071040, "InterAppService#querySpelledCityResultList()");
        this.addressInputSDSForm.querySpelledCityResultList(string, this.naviServiceListener);
    }

    @Override
    public void querySpelledStreetResultList(String string) {
        this.logChannel.log(1078071040, "InterAppService#querySpelledStreetResultList()");
        this.addressInputSDSForm.querySpelledStreetResultList(string, this.naviServiceListener);
    }

    @Override
    public void selectSpelledCityName(boolean bl, Object object) {
        this.logChannel.log(1078071040, "InterAppService#selectSpelledCityName()");
        this.addressInputSDSForm.selectSpelledCityName(bl, object, this.naviServiceListener);
    }

    @Override
    public void selectSpelledStreetName(boolean bl, Object object) {
        this.logChannel.log(1078071040, "InterAppService#selectSpelledStreetName()");
        this.addressInputSDSForm.selectSpelledStreetName(bl, object, this.naviServiceListener);
    }

    @Override
    public void querySpelledStreetResultList2(String string) {
        this.logChannel.log(1078071040, "InterAppService#querySpelledStreetResultList2()");
        this.addressInputSDSForm.querySpelledStreetResultList2(string, this.naviServiceListener);
    }

    @Override
    public void selectSpelledStreetName2(boolean bl, Object object) {
        this.logChannel.log(1078071040, "InterAppService#selectSpelledStreetName2( %1 )", bl);
        this.addressInputSDSForm.selectSpelledStreetName2(bl, object, this.naviServiceListener);
    }

    @Override
    public void validateSpelledStreetName(String string) {
        this.logChannel.log(1078071040, "InterAppService#validateSpelledStreetName( %1 )", (Object)string);
        this.addressInputSDSForm.validateSpelledStreetName(string, this.naviServiceListener);
    }

    @Override
    public void queryCityListLength() {
        this.logChannel.log(1078071040, "InterAppService#queryCityListLength()");
        this.addressInputSDSForm.queryCityListLength(this.naviServiceListener);
    }

    @Override
    public void queryZIPCodeListLength() {
        this.logChannel.log(1078071040, "InterAppService#queryZIPCodeListLength()");
        this.addressInputSDSForm.queryZIPCodeListLength(this.naviServiceListener);
    }

    @Override
    public void queryHouseNrListLength() {
        this.logChannel.log(1078071040, "InterAppService#queryHouseNrListLength()");
        this.addressInputSDSForm.queryHouseNrListLength(this.naviServiceListener);
    }

    @Override
    public void queryStreetListLength() {
        this.logChannel.log(1078071040, "InterAppService#queryStreetListLength()");
        this.addressInputSDSForm.queryStreetListLength(this.naviServiceListener);
    }

    @Override
    public void queryIntersectionListLength() {
        this.logChannel.log(1078071040, "InterAppService#queryIntersectionListLength()");
        this.addressInputSDSForm.queryIntersectionListLength(this.naviServiceListener);
    }

    @Override
    public void reduceRouteToFinalDestination() {
        this.logChannel.log(1078071040, "InterAppService#reduceRouteToFinalDestination()");
        this.sdsHandler.reduceRouteToFinalDestination();
    }

    @Override
    public boolean isRouteGuidancePossible() {
        this.logChannel.log(1078071040, "InterAppService#isRouteGuidancePossible()");
        return this.sdsHandler.isRouteGuidancePossible();
    }

    @Override
    public byte freezeDynamicLists() {
        this.logChannel.log(1078071040, "InterAppService#freezeDynamicLists()");
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        this.logChannel.log(1078071040, "InterAppService#unfreezeDynamicLists()");
        return 0;
    }

    @Override
    public boolean isDestTypeAvailable(int n) {
        boolean bl;
        this.logChannel.log(1078071040, "InterAppService#isDestTypeAvailable( %1 )", (long)n);
        switch (n) {
            case 4: {
                bl = this.env.getContainer().selectionCriterionAvailable(16);
                break;
            }
            case 1: {
                bl = this.env.getContainer().selectionCriterionAvailable(2);
                break;
            }
            case 0: {
                bl = true;
                break;
            }
            case 3: {
                bl = this.env.getContainer().selectionCriterionAvailable(5) || this.env.getContainer().selectionCriterionAvailable(136) || this.env.getContainer().selectionCriterionAvailable(154);
                break;
            }
            case 5: {
                bl = this.env.getContainer().selectionCriterionAvailable(4);
                break;
            }
            case 2: {
                bl = this.env.getContainer().selectionCriterionAvailable(3);
                break;
            }
            case 6: {
                bl = this.env.getContainer().selectionCriterionAvailable(6);
                break;
            }
            case 7: {
                bl = this.env.getContainer().selectionCriterionAvailable(138);
                break;
            }
            case 8: {
                bl = this.env.getContainer().selectionCriterionAvailable(2);
                break;
            }
            case 11: {
                bl = this.env.getContainer().selectionCriterionAvailable(150);
                break;
            }
            case 12: {
                bl = this.env.getContainer().selectionCriterionAvailable(147);
                break;
            }
            case 13: {
                bl = this.env.getContainer().selectionCriterionAvailable(144);
                break;
            }
            case 14: {
                bl = this.env.getContainer().selectionCriterionAvailable(152) && this.env.getContainer().refinementCriterionAvailable(152);
                break;
            }
            case 15: {
                bl = this.env.getContainer().selectionCriterionAvailable(151);
                break;
            }
            case 17: 
            case 18: {
                bl = this.env.getContainer().selectionCriterionAvailable(138);
                break;
            }
            case 19: {
                bl = true;
                break;
            }
            case 20: {
                bl = true;
                break;
            }
            default: {
                this.logChannel.log(10000, "InterAppService#isDestTypeAvailable() unknown destination type: %1", (long)n);
                bl = false;
            }
        }
        this.logChannel.log(1078071040, "InterAppService#isDestTypeAvailable() result: %1", bl);
        return bl;
    }

    @Override
    public boolean isDestTypeSet(int n) {
        boolean bl;
        this.logChannel.log(1078071040, "InterAppService#isDestTypeSet( %1 )", (long)n);
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        if (navLocation == null) {
            this.logChannel.log(10000, "InterAppService#isDestTypeSet() liCurrentLD is null");
            return false;
        }
        switch (n) {
            case 4: {
                bl = !Util.isEmpty(navLocation.getTowncenter());
                break;
            }
            case 1: {
                bl = !Util.isEmpty(navLocation.getTown());
                break;
            }
            case 0: {
                bl = !Util.isEmpty(navLocation.getCountry());
                break;
            }
            case 3: {
                bl = !Util.isEmpty(navLocation.getHousenumber());
                break;
            }
            case 5: {
                bl = !Util.isEmpty(navLocation.getJunction());
                break;
            }
            case 2: {
                bl = !Util.isEmpty(navLocation.getStreet());
                break;
            }
            case 6: {
                bl = !Util.isEmpty(navLocation.getZipCode());
                break;
            }
            case 7: {
                bl = !Util.isEmpty(iMyLocationAccessor.getState());
                break;
            }
            case 8: {
                bl = false;
                break;
            }
            case 9: {
                bl = false;
                break;
            }
            case 10: {
                bl = false;
                break;
            }
            case 11: {
                bl = !Util.isEmpty(iMyLocationAccessor.getSubmunicipalTown()) || !Util.isEmpty(iMyLocationAccessor.getStreet());
                break;
            }
            case 12: {
                bl = !Util.isEmpty(iMyLocationAccessor.getPlaceName());
                break;
            }
            case 13: {
                bl = !Util.isEmpty(iMyLocationAccessor.getChome());
                break;
            }
            case 14: {
                bl = !Util.isEmpty(iMyLocationAccessor.getWard());
                break;
            }
            case 15: {
                bl = !Util.isEmpty(iMyLocationAccessor.getVillage());
                break;
            }
            case 16: {
                bl = !Util.isEmpty(iMyLocationAccessor.getPhonenumber());
                break;
            }
            case 17: {
                bl = !Util.isEmpty(iMyLocationAccessor.getState());
                break;
            }
            case 18: {
                bl = !Util.isEmpty(iMyLocationAccessor.getState());
                break;
            }
            case 19: {
                bl = this.env.getContainer().getSelectedLocation() != null;
                break;
            }
            case 20: {
                bl = true;
                break;
            }
            default: {
                this.logChannel.log(10000, "InterAppService#isDestTypeSet() unknown destination type: %1", (long)n);
                bl = false;
            }
        }
        this.logChannel.log(1078071040, "InterAppService#isDestTypeSet() result: %1", bl);
        return bl;
    }

    @Override
    public byte setPOISearchArea(byte by) {
        this.logChannel.log(1078071040, "InterAppService#setPOISearchArea()");
        return this.poiSDSHandler.setPOISearchArea(by);
    }

    @Override
    public void triggerPOIReturn() {
        this.logChannel.log(1078071040, "InterAppService#triggerPOIReturn()");
        this.poiSDSHandler.triggerPOIReturn(this.naviServiceListener);
    }

    @Override
    public void selectTopPOI(int n) {
        this.logChannel.log(1078071040, "InterAppService#selectTopPOI( %1)", (long)n);
        this.poiSDSHandler.selectNaturalPoi(n, this.naviServiceListener);
    }

    @Override
    public void blockRoute(int n) {
        this.logChannel.log(1078071040, "InterAppService#blockRoute()");
        this.sdsDetourHandler.blockRoute(n, this.naviServiceListener);
    }

    @Override
    public void unblockRoute() {
        this.logChannel.log(1078071040, "InterAppService#unblockRoute()");
        this.sdsDetourHandler.unblockRoute(this.naviServiceListener);
    }

    @Override
    public void setLocation(byte[] byArray) {
        this.logChannel.log(1078071040, "InterAppService#setLocation()");
        this.getSDSHandler().storeNavigateToDestination(this.streamToLocation(byArray));
    }

    @Override
    public void setLocation(NavLocation navLocation) {
        this.logChannel.log(1078071040, "InterAppService#setLocation() with navLocation=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.getSDSHandler().storeNavigateToDestination(navLocation);
    }

    @Override
    public void setLocation(OperatorCallResult operatorCallResult) {
        this.logChannel.log(1078071040, "InterAppService#setLocation() with operatorCallResult");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new InterAppService$1(this, "Transform location", operatorCallResult));
        commandList.add(new InterAppService$2(this, "InterAppService#setLocation(OperatorCallResult) storeNavigateToDestination"));
        commandList.execute("InterAppService#setLocation() with operatorCallResult");
    }

    @Override
    public void notifyAbort() {
        this.logChannel.log(1078071040, "InterAppService#notifyAbort()");
        this.sdsController.notifyAbort();
    }

    public void alternativeRoutesScreenEntered() {
        this.logChannel.log(1078071040, "InterAppService#alternativeRoutesScreenEntered()");
        this.sdsHandler.alternativeRoutesScreenEntered();
    }

    public NavLocation streamToLocation(byte[] byArray) {
        this.logChannel.log(1078071040, "InterAppService#streamToLocation()");
        return this.navigation.getLocationSerializer().streamToLocation(byArray);
    }

    public void registerNaviSDSHandler(SDSHandlerImpl sDSHandlerImpl) {
        this.logChannel.log(1078071040, "InterAppService#registerNaviSDSHandler() handler is not null = %1", (Object)sDSHandlerImpl);
        this.sdsHandler = sDSHandlerImpl;
    }

    public void registerNaviTpegPoiService(ITpegPOIService iTpegPOIService) {
        this.logChannel.log(1078071040, "InterAppService#registerNaviTpegPoiService() tpedPOIService is not null = %1", iTpegPOIService != null);
        this.tpegPOIService = iTpegPOIService;
    }

    public SDSHandler getSDSHandler() {
        return this.sdsHandler;
    }

    @Override
    public NaviService$NaviInfoDetails getAddressDetails(byte by) {
        this.logChannel.log(1078071040, "InterAppService#getAddressDetails(%1)", (long)by);
        return this.sdsHandler.getAddressDetails(by);
    }

    @Override
    public NaviService$NaviInfoDetails getNaviInfo(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#getNaviInfo(%1)", bl);
        return this.sdsHandler.getNaviInfo(bl);
    }

    public void registerNaviOnlineService(NaviOnlineService naviOnlineService) {
        this.logChannel.log(1078071040, "InterAppService#registerNaviOnlineService()");
        this.naviOnlineService = naviOnlineService;
    }

    @Override
    public NaviOnlineService getNaviOnlineService() {
        return this.naviOnlineService;
    }

    @Override
    public void requestPostCodeFormat() {
        this.logChannel.log(1078071040, "InterAppService#requestPostCodeFormat()");
        this.sdsHandler.requestPostCodeFormat();
    }

    @Override
    public void flushPOIPicklistModelGroup() {
        this.logChannel.log(1078071040, "InterAppService#flushPOIPicklistModelGroup()");
        this.sdsHandler.flushPOIPickListGroup();
    }

    @Override
    public void switchToSemidynamicRouteGuidance() {
        this.logChannel.log(1078071040, "InterAppService#switchToSemidynamicRouteGuidance()");
        this.navigation.getMapInterface().switchToSemidynamicRouteSelection();
    }

    @Override
    public boolean hasBetterRoute() {
        this.logChannel.log(1078071040, "InterAppService#hasBetterRoute()");
        return this.navigation.getMapInterface().hasBetterRoute();
    }

    @Override
    public int getSavingTime() {
        this.logChannel.log(1078071040, "InterAppService#getSavingTime()");
        return this.navigation.getMapInterface().getSavingTime();
    }

    @Override
    public long getTrafficDelayOnCurrentRoute() {
        this.logChannel.log(1078071040, "InterAppService#getTrafficDelayOnCurrentRoute()");
        return this.navigation.getMapInterface().getTrafficDelayOnCurrentRoute();
    }

    @Override
    public void selectRoute(byte by, boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#selectRoute( index = %2, start = %1)", bl, (long)by);
        this.navigation.getMapInterface().selectRoute(by == 0 ? 0 : 1, bl);
    }

    @Override
    public NaviService$POISDSListEntry getPOIEntryDetails(int n, byte by) {
        this.logChannel.log(1078071040, "InterAppService#getPOIEntryDetails()");
        return this.poiSDSHandler.getPOIEntryDetails(n, by);
    }

    @Override
    public byte fillPOIPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1078071040, "InterAppService#fillPOIPickList( %1 )", (Object)sDSListEntryArray);
        return this.poiSDSHandler.fillPOIPickList(sDSListEntryArray);
    }

    @Override
    public void selectPOI(int n) {
        this.logChannel.log(1078071040, "InterAppService#selectPOI( %1 )", (long)n);
        this.poiSDSHandler.selectPOI(n, this.naviServiceListener);
    }

    @Override
    public void selectPOIbyListIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#selectPOIbyListIndex( %1 )", (long)n);
        this.poiSDSHandler.selectPOIbyListIndex(n, this.naviServiceListener);
    }

    @Override
    public void requestCurrentSpeedLimit() {
        this.logChannel.log(1078071040, "InterAppService#requestCurrentSpeedLimit()");
        this.trafficRegulationInterAppService.requestCurrentSpeedLimit(this.naviServiceListener);
    }

    @Override
    public byte fillNaviSUIList(NaviService$NaviSUIDetails[] naviService$NaviSUIDetailsArray) {
        this.logChannel.log(1078071040, "InterAppService#fillNaviSUIList()");
        return this.suiHandler.fillNaviSUIList(naviService$NaviSUIDetailsArray);
    }

    @Override
    public void stopRouteGuidance() {
        this.logChannel.log(1078071040, "InterAppService#stopRouteGuidance()");
        this.routeGuidanceInterAppService.stopRouteGuidance(this.naviServiceListener);
    }

    @Override
    public void startRouteGuidance(byte by, boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#startRouteGuidance( %1 , %2)", (Object)String.valueOf(by), (Object)String.valueOf(bl));
        if (by == 0) {
            this.logChannel.log(-2137614336, "InterAppService#startRouteGuidance( ) - address input mode NONE, attempt to restart RG.");
            this.routeGuidanceInterAppService.restartRouteGuidance(this.naviServiceListener);
        } else {
            IDestinationHandler iDestinationHandler = this.routeGuidanceInterAppService.getDestinationHandler();
            NavLocation navLocation = this.sdsHandler.getEnteredLocation(by);
            this.logChannel.log(-2137614336, "InterAppService#startRouteGuidance() loc=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
            iDestinationHandler.setLocation(navLocation);
            this.routeGuidanceInterAppService.startRouteGuidance(this.naviServiceListener, bl);
        }
    }

    @Override
    public void startRouteGuidance(int n, int n2) {
        this.logChannel.log(1078071040, "InterAppService#startRouteGuidance( %1, %2 )", (long)n, (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        NavLocation navLocation = Util.getLocationFromGeoPos(n, n2);
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        commandList.add(new InterAppService$3(this, "InterAppService#startRouteGuidanceCommand"));
        commandList.execute("InterAppService#startRouteGuidance");
    }

    @Override
    public void startRouteGuidance(boolean bl, NavLocation navLocation) {
        this.logChannel.log(1078071040, "InterAppService#startRouteGuidance( isRGForced=%2, navLoc=%1 )", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)String.valueOf(bl));
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        commandList.add(new InterAppService$4(this, "InterAppService#startRouteGuidanceCommand forced.", bl));
        commandList.execute("InterAppService#startRouteGuidance(navLoc)");
    }

    @Override
    public void insertAsStopover(byte by, int n, boolean bl, boolean bl2) {
        this.logChannel.log(1078071040, "InterAppService#insertAsStopover( sdsAddressInputMode: %1, position: %2 )", (long)by, (long)n);
        if (this.sdsHandler == null || this.addSelectedDestinationAtIndexHandler == null) {
            this.logChannel.log(10000, "InterAppService#insertAsStopover( sdsAddressInputMode: %1, position: %2 )", (long)by, (long)n);
            return;
        }
        NavLocation navLocation = this.sdsHandler.getEnteredLocation(by);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new InterAppService$5(this, this.naviServiceListener));
        commandList.setErrorCommand(new InterAppService$6(this, this.naviServiceListener));
        this.addSelectedDestinationAtIndexHandler.addAsStopOver(navLocation, n, bl, bl2, commandList);
    }

    @Override
    public void insertAsStopover(NavLocation navLocation, int n, boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#insertAsStopover( navLoc: %1, position: %2 )", (Object)navLocation, (long)n);
        this.addSelectedDestinationAtIndexHandler.addAsStopOver(navLocation, n, bl, false, null);
    }

    @Override
    public void calculateAlternativeRoutes() {
        this.logChannel.log(1078071040, "InterAppService#calculateAlternativeRoutes()");
        try {
            this.navigation.getMapManager().calculateAlternativeRoutes(false);
            if (!Util.isPorscheGen2(this.env.getFramework()) && !Util.isPorscheHigh(this.env.getFramework())) {
                this.naviServiceListener.responseCalculateAlternativeRoutes((byte)0);
            }
        }
        catch (Exception exception) {
            this.naviServiceListener.responseCalculateAlternativeRoutes((byte)1);
        }
    }

    @Override
    public void addSelectedDestinationAtIndex(int n, boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#addSelectedDestinationAtIndex( %2 , %1)", bl, (long)n);
        this.routeGuidanceInterAppService.addSelectedDestinationAtIndex(n, bl, this.naviServiceListener);
    }

    @Override
    public void diagStartDemoRouteGuidance(int[] nArray) {
        this.logChannel.log(1078071040, "InterAppService#diagStartDemoRouteGuidance() - params = %1", (Object)nArray);
        NavLocation navLocation = null;
        NavLocation navLocation2 = null;
        int n = 3;
        if (nArray != null && nArray.length > 0) {
            n = this.translateParamToGuidanceMode(nArray[0]);
        }
        if (Util.isHURegionNAR()) {
            navLocation = Util.getLocationFromGeoPos(-552015189, -1187039464);
            navLocation2 = Util.getLocationFromGeoPos(-1557138776, 1679678746);
        } else if (Util.isHURegionRdW()) {
            navLocation = Util.getLocationFromGeoPos(-1803030509, 1334468077);
            navLocation2 = Util.getLocationFromGeoPos(-1331425002, 720749802);
        } else {
            navLocation = Util.getLocationFromGeoPos(580926216, 653736482);
            navLocation2 = Util.getLocationFromGeoPos(-15656185, 1796609318);
        }
        this.navigation.getMapInterface().setMapType(2);
        CommandList commandList = this.navigation.getCommandListFactory().createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        if (this.env.getContainer().isRgActive()) {
            commandList.add(this.navigation.getRouteManager().getStopRouteGuidanceSequence());
        }
        commandList.add(new InterAppService$7(this, "InterAppService#diagStartDemoRouteGuidance - TurnDemoModeOnWithStartLocation"));
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation2));
        commandList.add(new RGSetRouteGuidanceMode(n));
        commandList.add(new InterAppService$8(this, "InterAppService#diagStartDemoRouteGuidance - StartGuidanceWithTransformedDestination"));
        commandList.execute("InterAppService#diagStartDemoRouteGuidance");
    }

    private int translateParamToGuidanceMode(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
        }
        return 3;
    }

    @Override
    public void diagStopRouteGuidance() {
        this.logChannel.log(1078071040, "InterAppService#diagStopRouteGuidance()");
        CommandList commandList = this.navigation.getCommandListFactory().createCommandList();
        commandList.add(new RGStopGuidanceCommand());
        commandList.execute("InterAppService#diagStopRouteGuidance");
    }

    @Override
    public void setVisibleKombiMapOrStreetView(boolean bl) {
    }

    @Override
    public void setDestination(AdbEntry adbEntry, int n) {
        String string = adbEntry.getCombinedName();
        this.logChannel.log(1078071040, "InterAppService#setDestination - entry <%1>; adrIndex <%2>", (Object)adbEntry, (long)n);
        this.setInputMode(1);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LITryBestMatchCommand(adbEntry, (short)n));
        commandList.add(new CheckTryBestMatchResultCommand());
        commandList.add(new InterAppService$9(this, this.naviServiceListener, string));
        commandList.setErrorCommand(new InterAppService$10(this, this.naviServiceListener));
        commandList.execute("InterAppService#setDestination");
    }

    @Override
    public void setDestination(String string, String string2) {
        this.logChannel.log(1078071040, "InterAppService#setDestination - latitude <%1>; longitude <%2>", (Object)string, (Object)string2);
        NavLocation navLocation = Util.getLocationFromGeoPos(Util.degreeStringToWgs84(string2), Util.degreeStringToWgs84(string));
        this.sdsHandler.storeDestination(navLocation, true, false);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        commandList.add(new InterAppService$11(this, this.naviServiceListener));
        commandList.setErrorCommand(new InterAppService$12(this, this.naviServiceListener));
        commandList.execute("InterAppService#setDestination(lat, long)");
    }

    private void setInputMode(int n) {
        this.logChannel.log(1078071040, "InterAppService#setInputMode( %1 )", (long)n);
        this.inputModeManager.setInputMode(n, this.env);
    }

    @Override
    public void setLastDestinationById(long l) {
        this.logChannel.log(1078071040, "InterAppService#setLastDestinationById(%1)", l);
        this.sdsHandler.setLastDestinationByIndex(l);
    }

    @Override
    public void setLastDestinationByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#setLastDestinationByIndex(%1)", (long)n);
        this.sdsHandler.setLastDestinationByIndex(n);
    }

    @Override
    public void setFavoriteDestinationByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#setFavoriteDestinationByIndex(%1)", (long)n);
        this.sdsHandler.setFavoriteDestinationByListIndex(n);
    }

    @Override
    public void setFavoriteDestinationById(long l) {
        this.logChannel.log(1078071040, "InterAppService#setFavoriteDestinationById(%1)", l);
        this.sdsHandler.setFavoriteDestinationByUniqueId(l);
    }

    @Override
    public void setIntelliDestinationByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#setIntelliDestinationByIndex(%1)", (long)n);
        this.sdsHandler.setIntelliDestinationByIndex(n);
    }

    @Override
    public void selectAlternativeRoute(byte by) {
        this.logChannel.log(1078071040, "InterAppService#selectAlternativeRoute(%1)", (long)by);
        boolean bl = this.navigation.getMapInterface().sdsSelectAlternativeRoute(by);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new InterAppService$13(this, this.naviServiceListener, bl));
        commandList.execute("InterAppService#selectAlternativeRoute()");
    }

    @Override
    public void dialDetailsNumber() {
        this.logChannel.log(1078071040, "InterAppService#dialDetailsNumber()");
        this.sdsHandler.dialDetailsNumber();
    }

    @Override
    public String getPoiName(NavLocation navLocation) {
        return LocationFormatter.formatPOIName(navLocation);
    }

    @Override
    public NavLocation getCurrentNavLocation() {
        this.logChannel.log(1078071040, "InterAppService#getCurrentNavLocation() - Location: %1", (Object)LocationFormatter.formatLocationShort(this.env.getContainer().getLiCurrentLD()));
        return this.env.getContainer().getLiCurrentLD();
    }

    @Override
    public NavLocation getCurrentPoiSearchAreaLocation() {
        this.logChannel.log(1078071040, "InterAppService#getCurrentPoiSearchAreaLocation() - Location: %1", (Object)LocationFormatter.formatLocationShort(this.poiSDSHandler.getPoiSearchAreaLocation()));
        return this.poiSDSHandler.getPoiSearchAreaLocation();
    }

    @Override
    public NaviService$NaviInfoDetails getFormattedPoiSearchAreaLocation() {
        return this.sdsHandler.getFormattedPoiSearchAreaLocation(this.poiSDSHandler.getPoiSearchAreaLocation());
    }

    @Override
    public NavLocation getCurrentCarPosition() {
        return this.navigation.getVehicle().getVehicleLocationDescription();
    }

    @Override
    public int getCurrentCarHeading() {
        PosPosition posPosition = this.navigation.getVehicle().getFrontUnitPosition();
        int n = this.navigation.getVehicle().getHeading(posPosition);
        return n;
    }

    @Override
    public NavLocation getLastDestination() {
        this.logChannel.log(1078071040, "InterAppService#getLastDestination()");
        if (this.env.getContainer().isRgActive()) {
            return RouteUtil.getFinalDestination(this.navigation.getRouteManager().getRoute());
        }
        return null;
    }

    @Override
    public void startGeoCoordinateInput() {
        this.logChannel.log(1078071040, "InterAppService#startGeoCoordinateInput()");
        if (this.geoCoordInputManager != null) {
            this.geoCoordInputManager.enterWithCCPAsCoordinates();
        }
    }

    @Override
    public void disclaimerAccept() {
        this.logChannel.log(1078071040, "InterAppService#disclaimerAccept()");
        if (this.disclaimerHandler != null) {
            this.disclaimerHandler.acceptDisclaimer();
        }
    }

    @Override
    public byte sdsEnterRubberband() {
        this.logChannel.log(1078071040, "InterAppService#sdsEnterRubberband()");
        try {
            if (this.navigation.getMapManager().getMapInterface().enterRubberband(true)) {
                return 0;
            }
            return 1;
        }
        catch (Exception exception) {
            this.logChannel.log(-1601830656, "InterAppService#sdsEnterRubberband() - %1", (Throwable)exception);
            return 1;
        }
    }

    @Override
    public byte setSdsRouteInfo(int n) {
        this.logChannel.log(1078071040, "InterAppService#setSdsRouteInfo(%1)", (long)n);
        try {
            this.navigation.getMapManager().getMapInterface().setAdditionalInfos(n);
            return 0;
        }
        catch (Exception exception) {
            this.logChannel.log(-1601830656, "InterAppService#setSdsRouteInfo() - %1", (Throwable)exception);
            return 1;
        }
    }

    @Override
    public void setRouteProfile(int n) {
        this.logChannel.log(1078071040, "InterAppService#setRouteProfile( %1 )", (long)n);
        this.routeCriteriaInterAppService.setRouteProfile(n);
    }

    public void updateRgCurrentRoute(Route route) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "InterAppService#updateRgCurrentRoute() lastRoute=%1, rgCurrentRoute=%2", (Object)this.lastRoute, (Object)route);
        }
        if (route == null || this.lastRoute == null) {
            this.lastRoute = route;
            return;
        }
        if (route.getIndexOfCurrentDestination() != 0L && RouteUtil.getRouteLength(this.lastRoute) > 0 && route.getIndexOfCurrentDestination() > this.lastRoute.getIndexOfCurrentDestination()) {
            NavLocation navLocation = this.lastRoute.routelist[(int)this.lastRoute.getIndexOfCurrentDestination()].routeLocation;
            String string = LocationFormatter.getOnlinePoiID(navLocation);
            this.logChannel.log(-2137614336, "InterAppService#updateRgCurrentRoute() reachedDestination=%1, onlinePoiID=%2", (Object)navLocation, (Object)string);
            if (this.getNaviOnlineService() != null && this.getNaviOnlineService().getListener() != null) {
                this.getNaviOnlineService().getListener().indicateRouteGuidanceFinished(navLocation, string);
            }
        }
        this.lastRoute = route;
    }

    public void updateRgActive(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "InterAppService#updateRgActive() %1", bl);
        }
        if (!bl) {
            this.lastRoute = null;
        }
    }

    @Override
    public boolean isCruiseMode() {
        this.logChannel.log(1078071040, "InterAppService#isCruiseMode");
        return this.navigation.getMapManager().getCruiseModeHandler().isInCruiseMode();
    }

    @Override
    public void enterMapCode() {
        this.logChannel.log(1078071040, "InterAppService#enterMapCode");
        this.addressInputSDSForm.enterMapCode(this.naviServiceListener);
    }

    @Override
    public void inputMapCode(String string) {
        this.logChannel.log(1078071040, "InterAppService#inputMapCode( %1 )", (Object)string);
        this.addressInputSDSForm.inputMapCode(string, this.naviServiceListener);
    }

    @Override
    public void deleteLastMapCodeInput() {
        this.logChannel.log(1078071040, "InterAppService#deleteLastMapCodeInput");
        this.addressInputSDSForm.deleteLastMapCodeInput(this.naviServiceListener);
    }

    @Override
    public void triggerMapCodeReturn() {
        this.logChannel.log(1078071040, "InterAppService#triggerMapCodeReturn");
        this.addressInputSDSForm.triggerMapCodeReturn(this.naviServiceListener);
    }

    @Override
    public void clearMapCode() {
        this.logChannel.log(1078071040, "InterAppService#clearMapCode");
        this.addressInputSDSForm.clearMapCode(this.naviServiceListener);
    }

    @Override
    public void disambiguateMapCode() {
        this.logChannel.log(1078071040, "InterAppService#disambiguateMapCode");
        this.addressInputSDSForm.disambiguateMapCode(this.naviServiceListener);
    }

    @Override
    public void selectDisambiguatedMapCodeByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#selectDisambiguatedMapCodeByIndex( %1 )", (long)n);
        this.addressInputSDSForm.selectDisambiguatedMapCodeByIndex(n, this.naviServiceListener);
    }

    @Override
    public boolean isCurrentMapCodeNavigable() {
        this.logChannel.log(1078071040, "InterAppService#isCurrentMapCodeNavigable");
        return this.addressInputSDSForm.isCurrentMapCodeNavigable();
    }

    @Override
    public String getLastValidMapCodeBlock() {
        this.logChannel.log(1078071040, "InterAppService#getLastValidMapCodeBlock");
        return this.addressInputSDSForm.getLastValidMapCodeBlock();
    }

    @Override
    public String getCurrentMapCode() {
        this.logChannel.log(1078071040, "InterAppService#getCurrentMapCode");
        return this.addressInputSDSForm.getCurrentMapCode();
    }

    @Override
    public boolean isFurtherMapCodeInputPossible() {
        this.logChannel.log(1078071040, "InterAppService#isFurtherMapCodeInputPossible");
        return this.addressInputSDSForm.isFurtherMapCodeInputPossible();
    }

    @Override
    public void enterTelephoneNumber() {
        this.logChannel.log(1078071040, "InterAppService#enterTelephoneNumber");
        this.addressInputSDSForm.enterTelephoneNumber(this.naviServiceListener);
    }

    @Override
    public void inputTelephoneNumber(String string) {
        this.logChannel.log(1078071040, "InterAppService#inputTelephoneNumber( %1 )", (Object)string);
        this.addressInputSDSForm.inputTelephoneNumber(string, this.naviServiceListener);
    }

    @Override
    public void deleteLastTelephoneNumberInput() {
        this.logChannel.log(1078071040, "InterAppService#deleteLastTelephoneNumberInput");
        this.addressInputSDSForm.deleteLastTelephoneNumberInput(this.naviServiceListener);
    }

    @Override
    public void clearTelephoneNumber() {
        this.logChannel.log(1078071040, "InterAppService#clearTelephoneNumber");
        this.addressInputSDSForm.clearTelephoneNumber(this.naviServiceListener);
    }

    @Override
    public void selectTelephoneNumberByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#selectTelephoneNumberByIndex( %1 )", (long)n);
        this.addressInputSDSForm.selectTelephoneNumberByIndex(n, this.naviServiceListener);
    }

    @Override
    public String getLastValidTelephoneNumberBlock() {
        this.logChannel.log(1078071040, "InterAppService#getLastValidTelephoneNumberBlock");
        return this.addressInputSDSForm.getLastValidTelephoneNumberBlock();
    }

    @Override
    public String getCurrentTelephoneNumber() {
        this.logChannel.log(1078071040, "InterAppService#getCurrentTelephoneNumber");
        return this.addressInputSDSForm.getCurrentTelephoneNumber();
    }

    @Override
    public boolean isFurtherTelephonenumberInputPossible() {
        this.logChannel.log(1078071040, "InterAppService#isFurtherTelephonenumberInputPossible");
        return this.addressInputSDSForm.isFurtherTelephonenumberInputPossible();
    }

    @Override
    public void startTpegPOI() {
        this.logChannel.log(1078071040, "InterAppService#startTpegPOI");
        this.addressInputSDSForm.startTpegPOI(this.naviServiceListener);
    }

    @Override
    public void getTpegPOIResultsByCategoryIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#getTpegPOIResultsByCategoryIndex -- index = %1", (long)n);
        this.addressInputSDSForm.getTpegPOIResultsByCategoryIndex(n, this.naviServiceListener);
    }

    @Override
    public void selectTpegPOIResultByIndex(int n) {
        this.logChannel.log(1078071040, "InterAppService#selectTpegPOIResultByIndex -- index = %1", (long)n);
        this.addressInputSDSForm.selectTpegPOIResultByIndex(n, this.naviServiceListener);
    }

    @Override
    public void triggerTpegPoiReturn() {
        this.logChannel.log(1078071040, "InterAppService#triggerTpegPoiReturn()");
        this.tpegPOIService.destTpegPOIHKReturn(0, 0);
    }

    @Override
    public void destOptShowInMap(NavLocation navLocation, boolean bl, boolean bl2) {
        this.logChannel.log(1078071040, "InterAppService#destOptShowInMap( %2, %1 )", bl, (Object)navLocation);
        this.navigation.getMapInterface().destOptShowInMap(navLocation, bl, bl2);
    }

    @Override
    public void destOptShowInMap(NavLocationWgs84 navLocationWgs84, boolean bl, boolean bl2) {
        this.logChannel.log(1078071040, "InterAppService#destOptShowInMap( %2, %1 )", bl, (Object)navLocationWgs84);
        NavLocation navLocation = Util.getLocationFromGeoPos(navLocationWgs84.getLongitude(), navLocationWgs84.getLatitude());
        this.destOptShowInMap(navLocation, bl, bl2);
    }

    @Override
    public void sendOperatorCallResult(OperatorCallResult operatorCallResult, int n) {
        this.logChannel.log(1078071040, "InterAppService#sendOperatorCallResult - id=%2 operatorCallResult=%1", (Object)operatorCallResult, (long)n);
        if (this.operatorCallService != null) {
            this.operatorCallService.receiveEvent(operatorCallResult, n);
        } else {
            this.logChannel.log(10000, "InterAppService#sendOperatorCallResult - operatorCallService is null!");
        }
    }

    public IStartGuidanceToDestinationSequence getStartGuidanceToDestinationSequence() {
        return this.startGuidanceToDestinationSequence;
    }

    @Override
    public int startTrufflesSearch(String string, String[] stringArray) {
        this.logChannel.log(1078071040, "InterAppService#startTrufflesSearch( %1, %2 )", (Object)string, (Object)stringArray);
        return this.sdsHandler.startTrufflesSearch(string, stringArray);
    }

    @Override
    public void cancelSDSTrufflesSearch(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#cancelSDSTrufflesSearch(%1)", bl);
        this.sdsHandler.cancelSDSTrufflesSearch(bl);
    }

    @Override
    public boolean isTrufflesConflictmodeAvailable() {
        boolean bl = this.sdsHandler.isTrufflesConflictmodeAvailable();
        this.logChannel.log(1078071040, "InterAppService#isTrufflesConflictmodeAvailable() available=%1 ", bl);
        return bl;
    }

    @Override
    public int triggerTrufflesConflictmode(String string, String[] stringArray) {
        this.logChannel.log(1078071040, "InterAppService#triggerTrufflesConflictmode( %1, %2 )", (Object)string, (Object)stringArray);
        return this.sdsHandler.triggerTrufflesConflictmode(string, stringArray);
    }

    @Override
    public void saveAsFavorite(byte by, String string, boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#saveAsFavorite(%1,%2)", (Object)Byte.toString(by), (Object)string);
        NavLocation navLocation = this.sdsHandler.getEnteredLocation(by);
        String string2 = string;
        if (string.length() == 0) {
            string2 = AddressFormatter.formatOneLine(navLocation, this.env).getFirstLineAsText();
        }
        this.navigation.getNaviFavoriteHandler().saveAsFavorite(navLocation, string2, bl);
    }

    @Override
    public void saveAsFavorite(NavLocation navLocation, boolean bl) {
        String string = AddressFormatter.formatOneLine(navLocation, this.env).getFirstLineAsText();
        this.logChannel.log(1078071040, "InterAppService#saveAsFavorite(navLocTitle=%2, onlySuggestion=%1)", bl, (Object)string);
        this.navigation.getNaviFavoriteHandler().saveAsFavorite(navLocation, string, bl);
    }

    @Override
    public void saveAsFavorite(NavLocationWgs84 navLocationWgs84, String string, boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#saveAsFavorite(navLocTitle=%2, onlySuggestion=%1)", bl, (Object)string);
        this.navigation.getNaviFavoriteHandler().saveAsFavorite(Util.wgs84ToNavLocation(navLocationWgs84), string, bl);
    }

    @Override
    public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
        this.logChannel.log(1078071040, "InterAppService#setOperatorCallResultLocation( %1 )", (Object)navLocationWgs84);
        this.navigation.getMapInterface().setOperatorCallResultLocation(navLocationWgs84);
    }

    @Override
    public void getDatabaseNamesForWordPrediction(IWordPredictionCallback iWordPredictionCallback) {
        this.logChannel.log(1078071040, "%1#getDatabaseNamesForWordPrediction - wordPrediction=%2", (Object)CLASS_NAME, (Object)iWordPredictionCallback);
        if (iWordPredictionCallback.getMode() == 0) {
            String string = Util.isHURegionTW() ? Util.getLocationAccessor(this.navigation.getVehicle().getVehicleLocationDescription()).getCountry() : Util.getLocationAccessor(this.navigation.getVehicle().getVehicleLocationDescription()).getState();
            iWordPredictionCallback.databaseNamesAvailableCallback(new String[]{string});
        } else if (iWordPredictionCallback.getMode() == 1) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new PoiGetXt9LDBsCommand(iWordPredictionCallback));
            commandList.execute(new StringBuffer().append(CLASS_NAME).append("#getDatabaseNamesForWordPrediction").toString());
        } else {
            this.logChannel.log(10000, "%1#getDatabaseNamesForWordPrediction - unknown mode = %2. Unable to load string(s) for database, returning empty array.", (Object)CLASS_NAME, (long)iWordPredictionCallback.getMode());
            iWordPredictionCallback.databaseNamesAvailableCallback(new String[0]);
        }
    }

    @Override
    public void indicateVICSEmergencyPopupShown(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#indicateVICSEmergencyPopupShown(%1)", bl);
        this.navigation.getMapInterface().indicateVICSEmergencyPopupShown(bl);
    }

    @Override
    public void setOnlineTraffic(boolean bl) {
        this.logChannel.log(1078071040, "InterAppService#setOnlineTraffic( %1 )", bl);
        this.navigation.getOnlineTrafficHandler().setOnlineTraffic(bl);
    }

    @Override
    public String getAdditionalNameFromNavLocation(NavLocation navLocation) {
        return Util.getAdditionalNameFromNavLocation(navLocation);
    }

    @Override
    public NaviMsgDetails requestCurrentNaviDataforMessage() {
        TripHandler$TripData tripHandler$TripData = this.navigation.getRouteManager().getTripDataAuto();
        NavLocation navLocation = RouteUtil.getFinalDestination(this.navigation.getRouteManager().getFilteredRoute());
        NavLocation navLocation2 = this.env.getContainer().getSoPosPositionDescription();
        if (navLocation == null || !this.env.getContainer().isRgActive()) {
            return new NaviMsgDetails(AddressFormatter.formatOneLine(navLocation2, this.env).getFirstLineAsText(), navLocation2.latitude, navLocation2.longitude);
        }
        return new NaviMsgDetails(AddressFormatter.formatOneLine(navLocation2, this.env).getFirstLineAsText(), navLocation2.latitude, navLocation2.longitude, AddressFormatter.formatOneLine(navLocation, this.env).getFirstLineAsText(), navLocation.latitude, navLocation.longitude, tripHandler$TripData.distanceToFinalDestination, tripHandler$TripData.etaToFinalDestination);
    }

    @Override
    public void setFavoriteContext(int n) {
        this.navigation.getNaviFavoriteHandler().setFavoritesContext(n);
    }

    @Override
    public RenderingInfoProvider getRenderingInfoProvider() {
        return this.navigation.getIconHandler().getRenderingInfoProvider();
    }

    @Override
    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
        Buffer buffer = new Buffer("LocalHazardInformation");
        Util.appendObjectArray(buffer, localHazardInformationArray);
        this.logChannel.log(1078071040, "InterAppService#updateLocalHazardInformation( %1 )", (Object)buffer);
        LGIInterAppServiceHandler lGIInterAppServiceHandler = this.navigation.getLGIInterAppServiceHandler();
        if (lGIInterAppServiceHandler != null) {
            lGIInterAppServiceHandler.updateLocalHazardInformation(localHazardInformationArray);
        }
    }

    @Override
    public void showPoiDetailsPopup() {
        NavLocation navLocation = this.getCurrentNavLocation();
        this.env.getLogChannel().log(-2137614336, "InterAppService#showPoiDetailsPopup() - NavLocation: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.navigation.getMapInterface().showLocFromDest(navLocation, 1);
    }

    @Override
    public void savePreviewLocation(NavLocation navLocation) {
        this.env.getContainer().setPreviewLocation(navLocation);
    }

    @Override
    public void savePreviewTmcMsg(TmcMessage tmcMessage) {
        this.savePreviewLocation(null);
        this.env.getContainer().setPreviewTmc(tmcMessage);
    }

    @Override
    public void fillToolTipInformationContainerByNavLocation(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logChannel.log(1078071040, "InterAppService#fillToolTipInformationContainerByNavLocation location=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
        PreviewMapUtils.fillToolTipInformationContainerByNavLocation(this.env, navLocation, null, guiTooltipInformationContainer);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IStartGuidanceToDestinationSequence access$000(InterAppService interAppService) {
        return interAppService.startGuidanceToDestinationSequence;
    }

    static /* synthetic */ SDSHandlerImpl access$100(InterAppService interAppService) {
        return interAppService.sdsHandler;
    }
}

