/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LiGetSpellableCharactersCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.sds.SDSHandler;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$1;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$10;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$11;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$12;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$13;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$14;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$15;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$16;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$17;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$2;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$3;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$4;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$5;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$6;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$7;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$8;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl$9;
import de.audi.tghu.navi.app.sds.SDSNaviPicklistRowCreator;
import de.audi.tghu.navi.app.search.ILastDestHandler;
import de.audi.tghu.navi.app.search.IntelliDestAccess;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public class SDSHandlerImpl
implements SDSHandler {
    public static final long VDE_FINISH_INPUT_COMMAND_TIMEOUT;
    protected final NavigationEnv env;
    protected final FunctionCounter fc;
    protected Navigation navigation = null;
    protected LogChannel logChannel = null;
    protected final NaviServiceListener naviServiceListener;
    private final ICommandListFactory commandListFactory;
    private ILastDestHandler lastDestHandler;
    private final BaseListModelApp vdePickListModel;
    private int destinationContext = 0;
    private boolean inNavDestForm = false;
    private boolean inNavDestFormMainScreen = false;
    protected NavLocation navigateToDestination;
    private final Monitor stopMonitor;
    protected NavLocation lastDestination;
    protected NavLocation favoriteDestination;
    private INaviFavoriteHandler naviFavoriteHandler;
    protected final GuiModelAccessDetailsNavi detailsModelAccess;
    private IntelliDestAccess intelliDestAccess;
    protected NavLocation intelliDestination;
    private final IDestinationHandler detailsHandler;
    private final ITelService telService;
    private final HomeAddressHandler homeAddressHandler;
    private final HomeAddressHandler officeAddressHandler;

    public SDSHandlerImpl(NavigationEnv navigationEnv, FunctionCounter functionCounter, Navigation navigation, LogChannel logChannel, NaviServiceListener naviServiceListener, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, IntelliDestAccess intelliDestAccess, IDestinationHandler iDestinationHandler, ITelService iTelService, HomeAddressHandler homeAddressHandler, HomeAddressHandler homeAddressHandler2) {
        this.env = navigationEnv;
        this.fc = functionCounter;
        this.navigation = navigation;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
        this.naviServiceListener = naviServiceListener;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.detailsModelAccess = guiModelAccessDetailsNavi;
        this.intelliDestAccess = intelliDestAccess;
        this.detailsHandler = iDestinationHandler;
        this.telService = iTelService;
        this.homeAddressHandler = homeAddressHandler;
        this.officeAddressHandler = homeAddressHandler2;
        this.vdePickListModel = navigationEnv.getBaseListModel(3869);
        this.stopMonitor = new Monitor(logChannel);
    }

    public void cleanUp() {
        this.navigation = null;
    }

    protected CommandList createNaviSDSCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.addMonitor(this.stopMonitor);
        return commandList;
    }

    public NavLocation getEnteredLocation(byte by) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#getEnteredLocation() - inputMode: %1", (long)by);
        NavLocation navLocation = null;
        switch (by) {
            case 1: 
            case 6: {
                navLocation = this.env.getContainer().getLiCurrentLD();
                break;
            }
            case 2: {
                navLocation = this.getLastDestination();
                break;
            }
            case 3: {
                navLocation = this.getFavorite();
                break;
            }
            case 4: {
                navLocation = this.getNavigateToDestination();
                break;
            }
            case 5: {
                navLocation = this.homeAddressHandler.getCurrentHomeAddress();
                break;
            }
            case 9: {
                navLocation = this.officeAddressHandler.getCurrentHomeAddress();
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                navLocation = this.getIntelliDestination();
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#getEnteredLocation() - SDS address input is currently not active!");
            }
        }
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#getEnteredLocation() - no location found for input mode %1 !", (long)by);
            if (this.inNavDestForm) {
                this.logChannel.log(-1601830656, "getEnteredLocation: NDF entered, trying to use current location!");
                navLocation = this.env.getContainer().getLiCurrentLD();
            }
            if (navLocation == null) {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#getEnteredLocation() - creating dummy location!");
                navLocation = new NavLocation();
            }
        }
        return navLocation;
    }

    private NavLocation getDestinationContextLocation() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#getDestinationContextLocation() - destination context: %1", (long)this.destinationContext);
        NavLocation navLocation = null;
        switch (this.destinationContext) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                navLocation = this.navigation.getNaviMapConnector().getMapDestination();
                break;
            }
            case 3: {
                navLocation = this.env.getContainer().getLiCurrentLD();
                break;
            }
            case 7: {
                break;
            }
            case 11: {
                navLocation = this.navigation.getPicNavInterfaceHandler().getNaviPicNavService() != null ? this.navigation.getPicNavInterfaceHandler().getNaviPicNavService().getDetailedLocation() : null;
                break;
            }
            case 10: {
                break;
            }
            default: {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#getDestinationContextLocation() - destination context %1 not (yet) supported!", (long)this.destinationContext);
            }
        }
        if (navLocation == null) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#getDestinationContextLocation() - no location found for destination context %1 !", (long)this.destinationContext);
            if (this.inNavDestForm) {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#getDestinationContextLocation() - NDF entered, trying to use current location!");
                navLocation = this.env.getContainer().getLiCurrentLD();
            }
            if (navLocation == null) {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#getDestinationContextLocation() - creating dummy location!");
                navLocation = new NavLocation();
            }
        }
        return navLocation;
    }

    @Override
    public void alternativeRoutesScreenEntered() {
    }

    @Override
    public boolean isProcessingActive() {
        return this.stopMonitor.isActive();
    }

    @Override
    public void setGuidanceMode(byte by) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#setGuidanceMode( %1 )", (long)by);
        int n = 3;
        switch (by) {
            case 2: {
                n = 2;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
            case 0: {
                n = 0;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            default: {
                this.logChannel.log(10000, "SDSHandlerImpl#setGuidanceMode() - value %1 is unknown, guidance is disabled!", (long)by);
            }
        }
        this.navigation.getSpeechManager().setGuidanceMode(n, true);
        CommandList commandList = this.navigation.getSpeechManager().buildGuidanceModeCommandList(n);
        commandList.execute("SDSHandlerImpl#setGuidanceMode");
    }

    private void finishDestinationInputAsync(boolean bl, byte by) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#finishDestinationInputAsync( %1, %2 )", bl, (long)by);
        if (!bl) {
            this.stopMonitor.stopMonitoredLists("SDS: finish destination input unsuccessful!");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SDSHandlerImpl$1(this, this.naviServiceListener, bl));
        commandList.setErrorCommand(new SDSHandlerImpl$2(this, this.naviServiceListener));
        commandList.execute("SDSHandlerImpl#finishDestinationInputAsync()");
    }

    @Override
    public void checkRouteGuidance() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#checkRouteGuidance() - destination context: %1", (long)this.destinationContext);
        CommandList commandList = this.createNaviSDSCommandList();
        if (this.destinationContext != 0 && this.destinationContext != 9) {
            NavLocation navLocation = this.getDestinationContextLocation();
            if (navLocation != null && navLocation.isPositionValid()) {
                commandList.add(new SDSHandlerImpl$3(this, this.naviServiceListener));
            } else {
                commandList.add(new SDSHandlerImpl$4(this, this.naviServiceListener));
            }
            commandList.setErrorCommand(new SDSHandlerImpl$5(this, this.naviServiceListener));
        } else {
            int n = RouteUtil.getRouteLength(this.navigation.getRouteManager().getFilteredRoute());
            byte by = n == 0 ? (byte)1 : (n > 1 ? (byte)2 : 0);
            commandList.add(new SDSHandlerImpl$6(this, this.naviServiceListener, by));
        }
        commandList.execute("SDSHandlerImpl#checkRouteGuidance()");
    }

    @Override
    public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#fillNaviPickList(): Resetting list by selecting line 0!");
        BaseListModelApp baseListModelApp = this.vdePickListModel.getEmptyCopy();
        if (sDSListEntryArray == null) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#fillNaviPickList(): No entries available, clearing list!");
            this.vdePickListModel.update(baseListModelApp);
            return 1;
        }
        int n = sDSListEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#fillNaviPickList(): Empty entry #%1!", (long)i2);
                continue;
            }
            baseListModelApp.append(SDSNaviPicklistRowCreator.createNaviPickList(sDSListEntry, i2));
        }
        this.vdePickListModel.update(baseListModelApp);
        return 0;
    }

    @Override
    public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#fillNaviFavoritePickList(): Resetting list by selecting line 0!");
        BaseListModelApp baseListModelApp = this.vdePickListModel.getEmptyCopy();
        if (sDSListEntryArray == null) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#fillNaviFavoritePickList(): No entries available, clearing list!");
            this.vdePickListModel.update(baseListModelApp);
            return 1;
        }
        int n = sDSListEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#fillNaviFavoritePickList(): Empty entry #%1!", (long)i2);
                continue;
            }
            baseListModelApp.append(SDSNaviPicklistRowCreator.createNaviFavoritePickList(sDSListEntry, i2, this.naviFavoriteHandler));
        }
        this.vdePickListModel.update(baseListModelApp);
        return 0;
    }

    @Override
    public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#fillLastDestinationPickList()");
        BaseListModelApp baseListModelApp = this.vdePickListModel.getEmptyCopy();
        if (sDSListEntryArray == null) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#fillLastDestinationPickList(): No entries available, clearing list!");
            this.vdePickListModel.update(baseListModelApp);
            return 1;
        }
        for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) {
                this.logChannel.log(-1601830656, "SDSHandlerImpl#fillLastDestinationPickList(): Empty entry #%1!", (long)i2);
                continue;
            }
            baseListModelApp.append(SDSNaviPicklistRowCreator.createLastDestinationPickList(sDSListEntry, i2, this.lastDestHandler, this.env));
        }
        this.vdePickListModel.update(baseListModelApp);
        return 0;
    }

    public void setState(String string, String string2) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#setCountry( %1, %2 )", (Object)string, (Object)string2);
    }

    @Override
    public void requestPostCodeFormat() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#requestPostCodeFormat()");
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new LiGetSpellableCharactersCommand(navLocation, 6));
        commandList.add(new SDSHandlerImpl$7(this, this.naviServiceListener));
        commandList.setErrorCommand(new SDSHandlerImpl$8(this, this.naviServiceListener));
        commandList.execute("SDSHandlerImpl#requestPostCodeFormat()");
    }

    @Override
    public void reduceRouteToFinalDestination() {
        this.naviServiceListener.responseReduceRouteToFinalDestination((byte)1);
    }

    @Override
    public void triggerPOIReturn() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#triggerPOIReturn()");
    }

    @Override
    public void storeNavigateToDestination(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#storeNavigateToDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.storeDestination(navLocation, true, false);
        if (this.naviServiceListener == null) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#storeNavigateToDestination() - navi service listener not available!");
        } else {
            this.naviServiceListener.responseSetLocation(navLocation == null ? (byte)1 : 0);
        }
    }

    public void storeDestination(NavLocation navLocation, boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#storeDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.navigateToDestination = navLocation;
        if (this.detailsModelAccess != null && bl) {
            this.detailsModelAccess.onUpdateLocation(navLocation);
        }
    }

    public NavLocation getLastDestination() {
        return this.lastDestination;
    }

    public void storeLastDestination(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "SDSHandlerImpl#storeLastDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.lastDestination = navLocation;
        if (this.detailsModelAccess != null) {
            this.detailsModelAccess.onUpdateLocation(navLocation);
        }
    }

    public NavLocation getFavorite() {
        return this.favoriteDestination;
    }

    public void showIntelliDestinationInDetailScreen(NavLocation navLocation, int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "SDSHandlerImpl#storeIntelliDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.intelliDestination = navLocation;
        if (this.detailsModelAccess != null) {
            this.detailsModelAccess.onUpdateLocation(navLocation);
        }
    }

    public NavLocation getIntelliDestination() {
        return this.intelliDestination;
    }

    public void storeFavoriteDestination(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "SDSHandlerImpl#storeFavoriteDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.favoriteDestination = navLocation;
        if (this.detailsModelAccess != null) {
            this.detailsModelAccess.onUpdateLocation(navLocation);
        }
    }

    @Override
    public NavLocation getNavigateToDestination() {
        return this.navigateToDestination;
    }

    @Override
    public NaviService$NaviInfoDetails getAddressDetails(byte by) {
        NaviService$NaviInfoDetails naviService$NaviInfoDetails = new NaviService$NaviInfoDetails();
        NavLocation navLocation = this.getEnteredLocation(by);
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        naviService$NaviInfoDetails.country = navLocation.getCountry();
        naviService$NaviInfoDetails.countryAbbreviation = navLocation.getCountryAbbreviation();
        naviService$NaviInfoDetails.state = iMyLocationAccessor.getState();
        naviService$NaviInfoDetails.stateAbbreviation = iMyLocationAccessor.getStateAbbreviation();
        naviService$NaviInfoDetails.city = navLocation.getTown();
        naviService$NaviInfoDetails.street = navLocation.getStreet();
        naviService$NaviInfoDetails.houseNumber = navLocation.getHousenumber();
        if (Util.isHURegionAsia()) {
            if (!naviService$NaviInfoDetails.city.equals(iMyLocationAccessor.getTownRefinement())) {
                naviService$NaviInfoDetails.city = iMyLocationAccessor.getTownRefinement().concat(naviService$NaviInfoDetails.city);
            }
            naviService$NaviInfoDetails.provinceOrPrefecture = iMyLocationAccessor.getState();
            naviService$NaviInfoDetails.placeName = iMyLocationAccessor.getPlaceName();
            naviService$NaviInfoDetails.chome = iMyLocationAccessor.getChome();
            naviService$NaviInfoDetails.ward = iMyLocationAccessor.getWard();
        }
        return naviService$NaviInfoDetails;
    }

    @Override
    public void enterNavDestForm() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#enterNavDestForm()");
        this.inNavDestForm = true;
    }

    @Override
    public void exitNavDestForm() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#exitNavDestForm()");
        this.inNavDestForm = false;
    }

    @Override
    public boolean isInNavDestForm() {
        return this.inNavDestForm;
    }

    @Override
    public void enterNavDestFormMainScreen() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#enterNavDestFormMainScreen()");
        this.inNavDestFormMainScreen = true;
    }

    @Override
    public void exitNavDestFormMainScreen() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#exitNavDestFormMainScreen()");
        this.inNavDestFormMainScreen = false;
    }

    @Override
    public boolean isInNavDestFormMainScreen() {
        return this.inNavDestFormMainScreen;
    }

    @Override
    public NaviService$NaviInfoDetails getNaviInfo(boolean bl) {
        return this.getNaviInfo(bl, true);
    }

    public NaviService$NaviInfoDetails getNaviInfo(boolean bl, boolean bl2) {
        Object object;
        this.logChannel.log(-2137614336, "SDSHandlerImpl#getNaviInfo( %1 , %2 )", bl, bl2);
        TripHandler$TripData tripHandler$TripData = this.navigation.getRouteManager().getTripDataAuto();
        Route route = this.navigation.getRouteManager().getFilteredRoute();
        Object object2 = this.navigation.getVehicle().getVehicleCountryLocation();
        float f2 = 0.0f;
        int n = 0;
        DateMetric dateMetric = null;
        if (bl) {
            if (tripHandler$TripData != null && route != null && (object = RouteUtil.getCurrentDestination(route)) != null && ((NavLocation)object).isPositionValid()) {
                object2 = object;
                if (bl2) {
                    dateMetric = new DateMetric(new Date(tripHandler$TripData.etaToNextDestination), 1);
                    Util.formatDistance(tripHandler$TripData.distanceToNextDestination, 1);
                } else {
                    dateMetric = new DateMetric(new Date(tripHandler$TripData.etaToFinalDestination), 1);
                    Util.formatDistance(tripHandler$TripData.distanceToFinalDestination, 1);
                }
                f2 = Util.getFormattedDistance();
                int n2 = Util.getFormattedUnit();
                switch (n2) {
                    case 0: {
                        n = 0;
                        break;
                    }
                    case 5: {
                        n = 1;
                        break;
                    }
                    case 1: 
                    case 2: {
                        n = 2;
                        break;
                    }
                    case 4: {
                        n = 3;
                        break;
                    }
                    case 3: {
                        n = 4;
                        break;
                    }
                    default: {
                        this.logChannel.log(-1601830656, "SDSHandlerImpl#getNaviInfo() - unknown distance unit type %1 !", (long)n2);
                    }
                }
            }
        } else {
            object2 = this.getDestinationContextLocation();
        }
        object = this.convertNavLocationToDestinationInfo((NavLocation)object2);
        ((NaviService$NaviInfoDetails)object).distance = f2;
        ((NaviService$NaviInfoDetails)object).distanceUnit = n;
        ((NaviService$NaviInfoDetails)object).time = dateMetric;
        return object;
    }

    public NaviService$NaviInfoDetails convertNavLocationToDestinationInfo(NavLocation navLocation) {
        NaviService$NaviInfoDetails naviService$NaviInfoDetails = new NaviService$NaviInfoDetails();
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        naviService$NaviInfoDetails.countryAbbreviation = LocationFormatter.formatCountryAbbreviation(navLocation);
        naviService$NaviInfoDetails.city = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
        naviService$NaviInfoDetails.state = iMyLocationAccessor.getState();
        naviService$NaviInfoDetails.stateAbbreviation = iMyLocationAccessor.getStateAbbreviation();
        naviService$NaviInfoDetails.street = LocationFormatter.formatStreet(navLocation);
        naviService$NaviInfoDetails.houseNumber = LocationFormatter.formatHousenumber(navLocation);
        naviService$NaviInfoDetails.poiName = LocationFormatter.formatPOIName(navLocation);
        if (Util.isHURegionAsia()) {
            naviService$NaviInfoDetails.provinceOrPrefecture = iMyLocationAccessor.getState();
            naviService$NaviInfoDetails.placeName = iMyLocationAccessor.getPlaceName();
        }
        return naviService$NaviInfoDetails;
    }

    public NaviService$NaviInfoDetails getFormattedPoiSearchAreaLocation(NavLocation navLocation) {
        return this.convertNavLocationToDestinationInfo(navLocation);
    }

    @Override
    public void setDestinationContext(int n) {
        this.destinationContext = n;
    }

    @Override
    public void flushPOIPickListGroup() {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#flushPOIPickListGroup");
    }

    @Override
    public void setLastDestinationByIndex(long l) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#setLastDestinationByIndex()");
        NavLocation navLocation = this.lastDestHandler.getLastDestNavLocation(l);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new SDSHandlerImpl$9(this, this.naviServiceListener, navLocation));
        commandList.setErrorCommand(new SDSHandlerImpl$10(this, this.naviServiceListener));
        commandList.execute("SDSHandlerImpl#setLastDestinationByIndex()");
    }

    @Override
    public void setFavoriteDestinationByListIndex(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "SDSHandlerImpl#setFavoriteDestinationByIndex(%1)", (long)n);
        }
        NavLocation navLocation = this.naviFavoriteHandler.getFavoriteNavLocationByListIndex(n);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new SDSHandlerImpl$11(this, this.naviServiceListener, navLocation));
        commandList.setErrorCommand(new SDSHandlerImpl$12(this, this.naviServiceListener));
        commandList.execute("SDSHandlerImpl#setFavoriteDestinationByIndex()");
    }

    @Override
    public void setFavoriteDestinationByUniqueId(long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "SDSHandlerImpl#setFavoriteDestinationByIndex(%1)", l);
        }
        NavLocation navLocation = this.naviFavoriteHandler.getFavoriteNavLocationByUniqueId(l);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new SDSHandlerImpl$13(this, this.naviServiceListener, navLocation));
        commandList.setErrorCommand(new SDSHandlerImpl$14(this, this.naviServiceListener));
        commandList.execute("SDSHandlerImpl#setFavoriteDestinationByIndex()");
    }

    public void setLastDestHandler(ILastDestHandler iLastDestHandler) {
        this.lastDestHandler = iLastDestHandler;
    }

    public void setIntelliDestinationByIndex(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "SDSHandlerImpl#setIntelliDestByIndex(%1)", (long)n);
        }
        NavLocation navLocation = this.intelliDestAccess.getNavLocationByIndex(n);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new SDSHandlerImpl$15(this, this.naviServiceListener, navLocation));
        commandList.setErrorCommand(new SDSHandlerImpl$16(this, this.naviServiceListener));
        commandList.execute("SDSHandlerImpl#setIntelliDestByIndex()");
    }

    @Override
    public void dialDetailsNumber() {
        if (Util.isEmpty(this.detailsHandler.getNumber())) {
            this.logChannel.log(-1601830656, "SDSHandlerImpl#keyTyped Phone number is empty");
            this.naviServiceListener.responseDialDetailsNumber((byte)3);
            return;
        }
        this.telService.dialNumber(this.detailsHandler.getNumber(), new SDSHandlerImpl$17(this), true);
    }

    public int startTrufflesSearch(String string, String[] stringArray) {
        return this.intelliDestAccess.startTrufflesSearch(string, stringArray);
    }

    public void cancelSDSTrufflesSearch(boolean bl) {
        this.intelliDestAccess.cancelSDSTrufflesSearch(bl);
    }

    public boolean isTrufflesConflictmodeAvailable() {
        return this.intelliDestAccess.isTrufflesConflictmodeAvailable();
    }

    public int triggerTrufflesConflictmode(String string, String[] stringArray) {
        return this.intelliDestAccess.triggerTrufflesConflictmode(string, stringArray);
    }

    protected boolean isRouteNavigable() {
        this.logChannel.log(1078071040, "SDSHandlerImpl#isRouteNavigable()");
        Route route = this.navigation.getRouteManager().getRoute();
        return RouteUtil.isRouteNavigable(route);
    }

    protected boolean isDestStartAvailable() {
        this.logChannel.log(1078071040, "SDSHandlerImpl#isDestStartAvailable()");
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        return navLocation != null && Util.getLocationAccessor(navLocation).isNavigable();
    }

    public boolean isRouteGuidancePossible() {
        boolean bl = this.isInNavDestForm() ? this.isDestStartAvailable() : this.isRouteNavigable();
        this.logChannel.log(1078071040, "SDSHandlerImpl#isRouteGuidancePossible() possible=%1", bl);
        return bl;
    }

    static /* synthetic */ ILastDestHandler access$000(SDSHandlerImpl sDSHandlerImpl) {
        return sDSHandlerImpl.lastDestHandler;
    }
}

