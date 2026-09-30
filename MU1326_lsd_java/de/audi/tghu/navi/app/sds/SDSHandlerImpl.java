/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
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
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.sds.SDSHandler;
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
    public static final long VDE_FINISH_INPUT_COMMAND_TIMEOUT = 15000L;
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
        this.logChannel.log(10000000, "SDSHandlerImpl#getEnteredLocation() - inputMode: %1", (long)by);
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
                this.logChannel.log(100000, "SDSHandlerImpl#getEnteredLocation() - SDS address input is currently not active!");
            }
        }
        if (navLocation == null) {
            this.logChannel.log(100000, "SDSHandlerImpl#getEnteredLocation() - no location found for input mode %1 !", (long)by);
            if (this.inNavDestForm) {
                this.logChannel.log(100000, "getEnteredLocation: NDF entered, trying to use current location!");
                navLocation = this.env.getContainer().getLiCurrentLD();
            }
            if (navLocation == null) {
                this.logChannel.log(100000, "SDSHandlerImpl#getEnteredLocation() - creating dummy location!");
                navLocation = new NavLocation();
            }
        }
        return navLocation;
    }

    private NavLocation getDestinationContextLocation() {
        this.logChannel.log(10000000, "SDSHandlerImpl#getDestinationContextLocation() - destination context: %1", (long)this.destinationContext);
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
                this.logChannel.log(100000, "SDSHandlerImpl#getDestinationContextLocation() - destination context %1 not (yet) supported!", (long)this.destinationContext);
            }
        }
        if (navLocation == null) {
            this.logChannel.log(100000, "SDSHandlerImpl#getDestinationContextLocation() - no location found for destination context %1 !", (long)this.destinationContext);
            if (this.inNavDestForm) {
                this.logChannel.log(100000, "SDSHandlerImpl#getDestinationContextLocation() - NDF entered, trying to use current location!");
                navLocation = this.env.getContainer().getLiCurrentLD();
            }
            if (navLocation == null) {
                this.logChannel.log(100000, "SDSHandlerImpl#getDestinationContextLocation() - creating dummy location!");
                navLocation = new NavLocation();
            }
        }
        return navLocation;
    }

    public void alternativeRoutesScreenEntered() {
    }

    public boolean isProcessingActive() {
        return this.stopMonitor.isActive();
    }

    public void setGuidanceMode(byte by) {
        this.logChannel.log(10000000, "SDSHandlerImpl#setGuidanceMode( %1 )", (long)by);
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

    private void finishDestinationInputAsync(final boolean bl, byte by) {
        this.logChannel.log(10000000, "SDSHandlerImpl#finishDestinationInputAsync( %1, %2 )", bl, (long)by);
        if (!bl) {
            this.stopMonitor.stopMonitoredLists("SDS: finish destination input unsuccessful!");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NotifyNaviServiceListenerCommand(this.naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                if (bl) {
                    byte by = this.env.getContainer().getLiCurrentLD().isPositionValid() ? (byte)0 : 1;
                    naviServiceListener.responseFinishDestinationInput((byte)0, by);
                } else {
                    naviServiceListener.responseFinishDestinationInput((byte)0, (byte)1);
                }
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(this.naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseFinishDestinationInput((byte)1, (byte)1);
            }
        });
        commandList.execute("SDSHandlerImpl#finishDestinationInputAsync()");
    }

    public void checkRouteGuidance() {
        this.logChannel.log(10000000, "SDSHandlerImpl#checkRouteGuidance() - destination context: %1", (long)this.destinationContext);
        CommandList commandList = this.createNaviSDSCommandList();
        if (this.destinationContext != 0 && this.destinationContext != 9) {
            NavLocation navLocation = this.getDestinationContextLocation();
            if (navLocation != null && navLocation.isPositionValid()) {
                commandList.add(new NotifySDSCommand(this.naviServiceListener){

                    public void call() {
                        this.feedbackNaviServiceListener.responseCheckRouteGuidance((byte)0);
                    }
                });
            } else {
                commandList.add(new NotifySDSCommand(this.naviServiceListener){

                    public void call() {
                        this.feedbackNaviServiceListener.responseCheckRouteGuidance((byte)1);
                    }
                });
            }
            commandList.setErrorCommand(new NotifySDSCommand(this.naviServiceListener){

                public void call() {
                    this.feedbackNaviServiceListener.responseCheckRouteGuidance((byte)1);
                }
            });
        } else {
            int n = RouteUtil.getRouteLength(this.navigation.getRouteManager().getFilteredRoute());
            final byte by = n == 0 ? (byte)1 : (n > 1 ? (byte)2 : 0);
            commandList.add(new NotifySDSCommand(this.naviServiceListener){

                public void call() {
                    this.feedbackNaviServiceListener.responseCheckRouteGuidance(by);
                }
            });
        }
        commandList.execute("SDSHandlerImpl#checkRouteGuidance()");
    }

    public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(10000000, "SDSHandlerImpl#fillNaviPickList(): Resetting list by selecting line 0!");
        BaseListModelApp baseListModelApp = this.vdePickListModel.getEmptyCopy();
        if (sDSListEntryArray == null) {
            this.logChannel.log(100000, "SDSHandlerImpl#fillNaviPickList(): No entries available, clearing list!");
            this.vdePickListModel.update(baseListModelApp);
            return 1;
        }
        int n = sDSListEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) {
                this.logChannel.log(100000, "SDSHandlerImpl#fillNaviPickList(): Empty entry #%1!", (long)i2);
                continue;
            }
            baseListModelApp.append(SDSNaviPicklistRowCreator.createNaviPickList(sDSListEntry, i2));
        }
        this.vdePickListModel.update(baseListModelApp);
        return 0;
    }

    public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(10000000, "SDSHandlerImpl#fillNaviFavoritePickList(): Resetting list by selecting line 0!");
        BaseListModelApp baseListModelApp = this.vdePickListModel.getEmptyCopy();
        if (sDSListEntryArray == null) {
            this.logChannel.log(100000, "SDSHandlerImpl#fillNaviFavoritePickList(): No entries available, clearing list!");
            this.vdePickListModel.update(baseListModelApp);
            return 1;
        }
        int n = sDSListEntryArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) {
                this.logChannel.log(100000, "SDSHandlerImpl#fillNaviFavoritePickList(): Empty entry #%1!", (long)i2);
                continue;
            }
            baseListModelApp.append(SDSNaviPicklistRowCreator.createNaviFavoritePickList(sDSListEntry, i2, this.naviFavoriteHandler));
        }
        this.vdePickListModel.update(baseListModelApp);
        return 0;
    }

    public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(10000000, "SDSHandlerImpl#fillLastDestinationPickList()");
        BaseListModelApp baseListModelApp = this.vdePickListModel.getEmptyCopy();
        if (sDSListEntryArray == null) {
            this.logChannel.log(100000, "SDSHandlerImpl#fillLastDestinationPickList(): No entries available, clearing list!");
            this.vdePickListModel.update(baseListModelApp);
            return 1;
        }
        for (int i2 = 0; i2 < sDSListEntryArray.length; ++i2) {
            SDSListEntry sDSListEntry = sDSListEntryArray[i2];
            if (sDSListEntry == null) {
                this.logChannel.log(100000, "SDSHandlerImpl#fillLastDestinationPickList(): Empty entry #%1!", (long)i2);
                continue;
            }
            baseListModelApp.append(SDSNaviPicklistRowCreator.createLastDestinationPickList(sDSListEntry, i2, this.lastDestHandler, this.env));
        }
        this.vdePickListModel.update(baseListModelApp);
        return 0;
    }

    public void setState(String string, String string2) {
        this.logChannel.log(10000000, "SDSHandlerImpl#setCountry( %1, %2 )", (Object)string, (Object)string2);
    }

    public void requestPostCodeFormat() {
        this.logChannel.log(10000000, "SDSHandlerImpl#requestPostCodeFormat()");
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new LiGetSpellableCharactersCommand(navLocation, 6));
        commandList.add(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                String string = (String)this.getCommandList().get("SPELLABLE_CHARACTERS_RESULT");
                boolean bl = true;
                try {
                    Integer.parseInt(string);
                }
                catch (NumberFormatException numberFormatException) {
                    SDSHandlerImpl.this.logChannel.log(10000000, "SDSHandlerImpl#requestPostCodeFormat() - got alphanumeric result");
                    bl = false;
                }
                this.feedbackNaviServiceListener.responsePostCodeFormat((byte)0, bl);
            }
        });
        commandList.setErrorCommand(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                this.feedbackNaviServiceListener.responsePostCodeFormat((byte)1, false);
            }
        });
        commandList.execute("SDSHandlerImpl#requestPostCodeFormat()");
    }

    public void reduceRouteToFinalDestination() {
        this.naviServiceListener.responseReduceRouteToFinalDestination((byte)1);
    }

    public void triggerPOIReturn() {
        this.logChannel.log(10000000, "SDSHandlerImpl#triggerPOIReturn()");
    }

    public void storeNavigateToDestination(NavLocation navLocation) {
        this.logChannel.log(10000000, "SDSHandlerImpl#storeNavigateToDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.storeDestination(navLocation, true, false);
        if (this.naviServiceListener == null) {
            this.logChannel.log(100000, "SDSHandlerImpl#storeNavigateToDestination() - navi service listener not available!");
        } else {
            this.naviServiceListener.responseSetLocation(navLocation == null ? (byte)1 : 0);
        }
    }

    public void storeDestination(NavLocation navLocation, boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "SDSHandlerImpl#storeDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
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
            this.logChannel.log(100000000, "SDSHandlerImpl#storeLastDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
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
            this.logChannel.log(100000000, "SDSHandlerImpl#storeIntelliDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
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
            this.logChannel.log(100000000, "SDSHandlerImpl#storeFavoriteDestination( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.favoriteDestination = navLocation;
        if (this.detailsModelAccess != null) {
            this.detailsModelAccess.onUpdateLocation(navLocation);
        }
    }

    public NavLocation getNavigateToDestination() {
        return this.navigateToDestination;
    }

    public NaviService.NaviInfoDetails getAddressDetails(byte by) {
        NaviService.NaviInfoDetails naviInfoDetails = new NaviService.NaviInfoDetails();
        NavLocation navLocation = this.getEnteredLocation(by);
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        naviInfoDetails.country = navLocation.getCountry();
        naviInfoDetails.countryAbbreviation = navLocation.getCountryAbbreviation();
        naviInfoDetails.state = iMyLocationAccessor.getState();
        naviInfoDetails.stateAbbreviation = iMyLocationAccessor.getStateAbbreviation();
        naviInfoDetails.city = navLocation.getTown();
        naviInfoDetails.street = navLocation.getStreet();
        naviInfoDetails.houseNumber = navLocation.getHousenumber();
        if (Util.isHURegionAsia()) {
            if (!naviInfoDetails.city.equals(iMyLocationAccessor.getTownRefinement())) {
                naviInfoDetails.city = iMyLocationAccessor.getTownRefinement().concat(naviInfoDetails.city);
            }
            naviInfoDetails.provinceOrPrefecture = iMyLocationAccessor.getState();
            naviInfoDetails.placeName = iMyLocationAccessor.getPlaceName();
            naviInfoDetails.chome = iMyLocationAccessor.getChome();
            naviInfoDetails.ward = iMyLocationAccessor.getWard();
        }
        return naviInfoDetails;
    }

    public void enterNavDestForm() {
        this.logChannel.log(10000000, "SDSHandlerImpl#enterNavDestForm()");
        this.inNavDestForm = true;
    }

    public void exitNavDestForm() {
        this.logChannel.log(10000000, "SDSHandlerImpl#exitNavDestForm()");
        this.inNavDestForm = false;
    }

    public boolean isInNavDestForm() {
        return this.inNavDestForm;
    }

    public void enterNavDestFormMainScreen() {
        this.logChannel.log(10000000, "SDSHandlerImpl#enterNavDestFormMainScreen()");
        this.inNavDestFormMainScreen = true;
    }

    public void exitNavDestFormMainScreen() {
        this.logChannel.log(10000000, "SDSHandlerImpl#exitNavDestFormMainScreen()");
        this.inNavDestFormMainScreen = false;
    }

    public boolean isInNavDestFormMainScreen() {
        return this.inNavDestFormMainScreen;
    }

    public NaviService.NaviInfoDetails getNaviInfo(boolean bl) {
        return this.getNaviInfo(bl, true);
    }

    public NaviService.NaviInfoDetails getNaviInfo(boolean bl, boolean bl2) {
        Object object;
        this.logChannel.log(10000000, "SDSHandlerImpl#getNaviInfo( %1 , %2 )", bl, bl2);
        TripHandler.TripData tripData = this.navigation.getRouteManager().getTripDataAuto();
        Route route = this.navigation.getRouteManager().getFilteredRoute();
        Object object2 = this.navigation.getVehicle().getVehicleCountryLocation();
        float f2 = 0.0f;
        int n = 0;
        DateMetric dateMetric = null;
        if (bl) {
            if (tripData != null && route != null && (object = RouteUtil.getCurrentDestination(route)) != null && ((NavLocation)object).isPositionValid()) {
                object2 = object;
                if (bl2) {
                    dateMetric = new DateMetric(new Date(tripData.etaToNextDestination), 1);
                    Util.formatDistance(tripData.distanceToNextDestination, 1);
                } else {
                    dateMetric = new DateMetric(new Date(tripData.etaToFinalDestination), 1);
                    Util.formatDistance(tripData.distanceToFinalDestination, 1);
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
                        this.logChannel.log(100000, "SDSHandlerImpl#getNaviInfo() - unknown distance unit type %1 !", (long)n2);
                    }
                }
            }
        } else {
            object2 = this.getDestinationContextLocation();
        }
        object = this.convertNavLocationToDestinationInfo((NavLocation)object2);
        ((NaviService.NaviInfoDetails)object).distance = f2;
        ((NaviService.NaviInfoDetails)object).distanceUnit = n;
        ((NaviService.NaviInfoDetails)object).time = dateMetric;
        return object;
    }

    public NaviService.NaviInfoDetails convertNavLocationToDestinationInfo(NavLocation navLocation) {
        NaviService.NaviInfoDetails naviInfoDetails = new NaviService.NaviInfoDetails();
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        naviInfoDetails.countryAbbreviation = LocationFormatter.formatCountryAbbreviation(navLocation);
        naviInfoDetails.city = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
        naviInfoDetails.state = iMyLocationAccessor.getState();
        naviInfoDetails.stateAbbreviation = iMyLocationAccessor.getStateAbbreviation();
        naviInfoDetails.street = LocationFormatter.formatStreet(navLocation);
        naviInfoDetails.houseNumber = LocationFormatter.formatHousenumber(navLocation);
        naviInfoDetails.poiName = LocationFormatter.formatPOIName(navLocation);
        if (Util.isHURegionAsia()) {
            naviInfoDetails.provinceOrPrefecture = iMyLocationAccessor.getState();
            naviInfoDetails.placeName = iMyLocationAccessor.getPlaceName();
        }
        return naviInfoDetails;
    }

    public NaviService.NaviInfoDetails getFormattedPoiSearchAreaLocation(NavLocation navLocation) {
        return this.convertNavLocationToDestinationInfo(navLocation);
    }

    public void setDestinationContext(int n) {
        this.destinationContext = n;
    }

    public void flushPOIPickListGroup() {
        this.logChannel.log(10000000, "SDSHandlerImpl#flushPOIPickListGroup");
    }

    public void setLastDestinationByIndex(long l) {
        this.logChannel.log(10000000, "SDSHandlerImpl#setLastDestinationByIndex()");
        final NavLocation navLocation = this.lastDestHandler.getLastDestNavLocation(l);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                if (SDSHandlerImpl.this.lastDestHandler == null) {
                    SDSHandlerImpl.this.logChannel.log(1000000, "SDSHandlerImple#setLastDestinationByIndex lastDestHandler is null");
                    this.getCommandList().commandAborted("SDSHandlerImple#setLastDestinationByIndex lastDestHandler is null");
                }
                SDSHandlerImpl.this.storeLastDestination(navLocation);
                this.feedbackNaviServiceListener.responseSetLastDestination((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                this.feedbackNaviServiceListener.responseSetLastDestination((byte)1);
            }
        });
        commandList.execute("SDSHandlerImpl#setLastDestinationByIndex()");
    }

    public void setFavoriteDestinationByListIndex(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "SDSHandlerImpl#setFavoriteDestinationByIndex(%1)", (long)n);
        }
        final NavLocation navLocation = this.naviFavoriteHandler.getFavoriteNavLocationByListIndex(n);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                SDSHandlerImpl.this.storeFavoriteDestination(navLocation);
                this.feedbackNaviServiceListener.responseSetFavoriteDestination((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                this.feedbackNaviServiceListener.responseSetFavoriteDestination((byte)1);
            }
        });
        commandList.execute("SDSHandlerImpl#setFavoriteDestinationByIndex()");
    }

    public void setFavoriteDestinationByUniqueId(long l) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "SDSHandlerImpl#setFavoriteDestinationByIndex(%1)", l);
        }
        final NavLocation navLocation = this.naviFavoriteHandler.getFavoriteNavLocationByUniqueId(l);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                SDSHandlerImpl.this.storeFavoriteDestination(navLocation);
                this.feedbackNaviServiceListener.responseSetFavoriteDestination((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                this.feedbackNaviServiceListener.responseSetFavoriteDestination((byte)1);
            }
        });
        commandList.execute("SDSHandlerImpl#setFavoriteDestinationByIndex()");
    }

    public void setLastDestHandler(ILastDestHandler iLastDestHandler) {
        this.lastDestHandler = iLastDestHandler;
    }

    public void setIntelliDestinationByIndex(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "SDSHandlerImpl#setIntelliDestByIndex(%1)", (long)n);
        }
        final NavLocation navLocation = this.intelliDestAccess.getNavLocationByIndex(n);
        CommandList commandList = this.createNaviSDSCommandList();
        commandList.add(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                SDSHandlerImpl.this.showIntelliDestinationInDetailScreen(navLocation, 2);
                this.feedbackNaviServiceListener.responseIntelliDestination((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifySDSCommand(this.naviServiceListener){

            public void call() {
                this.feedbackNaviServiceListener.responseIntelliDestination((byte)1);
            }
        });
        commandList.execute("SDSHandlerImpl#setIntelliDestByIndex()");
    }

    public void dialDetailsNumber() {
        if (Util.isEmpty(this.detailsHandler.getNumber())) {
            this.logChannel.log(100000, "SDSHandlerImpl#keyTyped Phone number is empty");
            this.naviServiceListener.responseDialDetailsNumber((byte)3);
            return;
        }
        this.telService.dialNumber(this.detailsHandler.getNumber(), new ITelServiceListener(){

            public void dialNumberResponse(int n) {
                SDSHandlerImpl.this.logChannel.log(10000000, "SDSHandlerImplr#dialDetailsNumber( %1 )", (long)n);
                if (n == 0) {
                    SDSHandlerImpl.this.naviServiceListener.responseDialDetailsNumber((byte)0);
                } else {
                    SDSHandlerImpl.this.logChannel.log(10000, "SDSHandlerImpl#dialDetailsNumber( %1 ) - dial was not successful", (long)n);
                    SDSHandlerImpl.this.naviServiceListener.responseDialDetailsNumber((byte)1);
                }
            }
        }, true);
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
        this.logChannel.log(1000000, "SDSHandlerImpl#isRouteNavigable()");
        Route route = this.navigation.getRouteManager().getRoute();
        return RouteUtil.isRouteNavigable(route);
    }

    protected boolean isDestStartAvailable() {
        this.logChannel.log(1000000, "SDSHandlerImpl#isDestStartAvailable()");
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        return navLocation != null && Util.getLocationAccessor(navLocation).isNavigable();
    }

    public boolean isRouteGuidancePossible() {
        boolean bl = this.isInNavDestForm() ? this.isDestStartAvailable() : this.isRouteNavigable();
        this.logChannel.log(1000000, "SDSHandlerImpl#isRouteGuidancePossible() possible=%1", bl);
        return bl;
    }
}

