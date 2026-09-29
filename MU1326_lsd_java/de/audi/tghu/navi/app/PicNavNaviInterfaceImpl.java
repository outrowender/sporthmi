/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.interapp.picnav.IPicNavNaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NaviMapConnector;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PicNavInterfaceHandler;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl$1;
import de.audi.tghu.navi.app.PicNavNaviInterfaceImpl$2;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.rp.Routeplan;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.MMIInternalData;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;

public class PicNavNaviInterfaceImpl
implements IPicNavNaviService {
    private static final String PICNAV_LOCATION_RL_ID;
    private static final String PICNAV_LOCATION_RL_URL;
    private static final String PICNAV_IMPLICIT_IMPORTED;
    private static final String PICNAV_TRUE;
    private static MMIInternalData tmpInternalData;
    private final LogChannel lc;
    private final PicNavInterfaceHandler picNavInterfaceHandler;
    private final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private final ICommandListFactory commandListFactory;
    private final Routeplan routePlan;
    private final MapInterface mapInterface;
    private final IVehicle vehicle;
    private final NaviMapConnector naviMapConnector;
    private final IRouteManager routeManager;
    private final NaviADBHandler naviADBHandler;
    private final NaviFavoriteHandler naviFavoriteHandler;

    public PicNavNaviInterfaceImpl(NavigationEnv navigationEnv, PicNavInterfaceHandler picNavInterfaceHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ICommandListFactory iCommandListFactory, Routeplan routeplan, MapInterface mapInterface, IVehicle iVehicle, NaviMapConnector naviMapConnector, IRouteManager iRouteManager, NaviADBHandler naviADBHandler, NaviFavoriteHandler naviFavoriteHandler) {
        this.lc = navigationEnv.getLogChannel();
        this.picNavInterfaceHandler = picNavInterfaceHandler;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.commandListFactory = iCommandListFactory;
        this.routePlan = routeplan;
        this.mapInterface = mapInterface;
        this.vehicle = iVehicle;
        this.naviMapConnector = naviMapConnector;
        this.routeManager = iRouteManager;
        this.naviADBHandler = naviADBHandler;
        this.naviFavoriteHandler = naviFavoriteHandler;
    }

    @Override
    public void initInterface(ListModelApp listModelApp, ListModelApp listModelApp2) {
    }

    public static void createPicNavLocationStatic(NavLocation navLocation, ResourceLocator resourceLocator) {
        tmpInternalData.init(navLocation);
        tmpInternalData.setValue("PicNavRLID", String.valueOf(resourceLocator.getId()));
        tmpInternalData.setValue("PicNavRLURL", resourceLocator.getUrl());
        tmpInternalData.setInLocation(navLocation);
    }

    public static void tagPicNavLocationAsImplicitStatic(NavLocation navLocation) {
        tmpInternalData.init(navLocation);
        tmpInternalData.setValue("PicNavImplicit", "Y");
        tmpInternalData.setInLocation(navLocation);
    }

    public static boolean isPicNavLocationStatic(NavLocation navLocation) {
        tmpInternalData.init(navLocation);
        return tmpInternalData.isKeyAvailable("PicNavRLID");
    }

    public static boolean isImplicitNavLocationStatic(NavLocation navLocation) {
        tmpInternalData.init(navLocation);
        return tmpInternalData.isKeyAvailable("PicNavImplicit");
    }

    public static ResourceLocator getPictureFromPicNavLocationStatic(NavLocation navLocation) {
        ResourceLocator resourceLocator = null;
        tmpInternalData.init(navLocation);
        if (tmpInternalData.isKeyAvailable("PicNavRLID")) {
            int n = Integer.parseInt(tmpInternalData.getValue("PicNavRLID"));
            String string = tmpInternalData.getValue("PicNavRLURL");
            resourceLocator = new ResourceLocator(n, string);
        }
        return resourceLocator;
    }

    @Override
    public void createPicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
        PicNavNaviInterfaceImpl.createPicNavLocationStatic(navLocation, resourceLocator);
    }

    @Override
    public void tagPicNavLocationAsImplicit(NavLocation navLocation) {
        PicNavNaviInterfaceImpl.tagPicNavLocationAsImplicitStatic(navLocation);
    }

    @Override
    public boolean isPicNavLocation(NavLocation navLocation) {
        return PicNavNaviInterfaceImpl.isPicNavLocationStatic(navLocation);
    }

    @Override
    public boolean isImplicitNavLocation(NavLocation navLocation) {
        return PicNavNaviInterfaceImpl.isImplicitNavLocationStatic(navLocation);
    }

    @Override
    public ResourceLocator getPictureFromPicNavLocation(NavLocation navLocation) {
        return PicNavNaviInterfaceImpl.getPictureFromPicNavLocationStatic(navLocation);
    }

    @Override
    public boolean isPositionValid(NavLocation navLocation) {
        return navLocation.isPositionValid();
    }

    @Override
    public String getStreetForPicNavLocation(NavLocation navLocation) {
        return LocationFormatter.formatStreet(navLocation);
    }

    @Override
    public String getCityForPicNavLocation(NavLocation navLocation) {
        return LocationFormatter.formatCityZipTextfield(navLocation);
    }

    @Override
    public String getCountryForPicNavLocation(NavLocation navLocation) {
        return LocationFormatter.formatCountry(navLocation);
    }

    @Override
    public void resolveLocation(String string, String string2, ResourceLocator resourceLocator) {
        this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#resolveLocation( %1, %2, %3 )", (Object)string, (Object)string2, (Object)resourceLocator);
        int n = Util.degreeStringToWgs84(string);
        int n2 = Util.degreeStringToWgs84(string2);
        NavLocation navLocation = Util.getLocationFromGeoPos(n, n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        commandList.add(new PicNavNaviInterfaceImpl$1(this, "ResolveLocation", resourceLocator));
        commandList.execute("PicNavNaviInterfaceImpl#resolveLocation");
    }

    @Override
    public void prepareStartRouteGuidance() {
        this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#prepareStartRouteGuidance()");
    }

    @Override
    public void startRouteGuidance(NavLocation navLocation, boolean bl) {
        this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#startRouteGuidance( %2, %1 )", bl, (Object)LocationFormatter.formatLocationShort(navLocation));
        if (navLocation != null && navLocation.isPositionValid()) {
            this.startGuidanceToDestinationSequence.start(navLocation);
        } else {
            this.lc.log(10000, "PicNavNaviInterfaceImpl#startRouteGuidance() - location is not valid!");
        }
    }

    @Override
    public void addAsStopOver(NavLocation navLocation) {
    }

    @Override
    public void showPictureMap(NavLocation navLocation) {
        if (navLocation == null) {
            this.lc.log(-1601830656, "PicNavNaviInterfaceImpl#showPictureMap() - location is null!");
        } else {
            int n = navLocation.getLongitude();
            int n2 = navLocation.getLatitude();
            this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#showPictureMap() - longitude: %1, latitude: %2", (long)n, (long)n2);
            this.mapInterface.showMapInMapPictureDest(n, n2);
        }
    }

    @Override
    public void hidePictureMap() {
        this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#hidePictureMap()");
        this.mapInterface.hideMapInMapPictureDest();
    }

    @Override
    public String getPicNavDistance(NavLocation navLocation) {
        NavLocation navLocation2 = this.vehicle.getVehicleLocation();
        int n = Util.computeAirDistance(navLocation2.getLongitude(), navLocation2.getLatitude(), navLocation.getLongitude(), navLocation.getLatitude());
        return Util.formatDistance(n, 1);
    }

    @Override
    public void showPictureNavLocationOnMap(NavLocation navLocation, int n, ResourceLocator resourceLocator, boolean bl) {
        if (navLocation == null || resourceLocator == null) {
            this.lc.log(-1601830656, "PicNavNaviInterfaceImpl#showPictureNavLocationOnMap() - location or locator is null!");
        } else {
            this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#showPictureNavLocationOnMap() - filterId: %2 location: %1", (Object)navLocation.toString(), (long)n);
            this.mapInterface.showPictureNavLocationOnMap(navLocation, n, resourceLocator, bl);
        }
    }

    @Override
    public void resetEditInputMode() {
        this.lc.log(-2137614336, "PicNavNaviInterfaceImpl#resetEditInputMode()");
    }

    @Override
    public void addToFavorites(NavLocation navLocation, String string) {
        this.naviFavoriteHandler.addToFavorites(navLocation, string);
    }

    @Override
    public boolean isMapFrozen() {
        boolean bl = this.naviMapConnector.isMapFrozen();
        if (bl) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new WaitForMapReadyCommand());
            commandList.add(new PicNavNaviInterfaceImpl$2(this, "forward unfreeze status"));
            commandList.execute("PicNavNaviInterfaceImpl#isMapFrozen");
        } else {
            this.picNavInterfaceHandler.mapUnfrozen();
        }
        return bl;
    }

    @Override
    public boolean isGoogleActive() {
        boolean bl = this.mapInterface.isGoogleActive();
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "PicNavNaviInterfaceImpl#isGoogleActive() - googleActive: %1", bl);
        }
        return bl;
    }

    @Override
    public NavLocation getCCP() {
        return this.vehicle.getVehicleLocation();
    }

    @Override
    public void handlePicNavCurrentState(NavLocation navLocation, LogChannel logChannel) {
    }

    @Override
    public void handlePicNavMapCurrentState(NavLocation navLocation, LogChannel logChannel) {
    }

    @Override
    public int computeAirDistanceToCCP(int n, int n2) {
        PosPosition posPosition = this.vehicle.getFrontUnitPosition();
        return Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), n, n2);
    }

    @Override
    public double[] getDistanceCoordinatesFromLocation(NavLocation navLocation, int n) {
        if (this.lc.isDebug2()) {
            this.lc.log(14808325, "PicNavNaviInterfaceImpl#getDistanceCoordinatesFromLocation() - distance: %1 ccp: %2", (long)n);
        }
        return Util.getDistanceCoordinatesFromLocation(navLocation, n);
    }

    @Override
    public NavLocation getFinalDestination() {
        Route route = this.routeManager.getRoute();
        return RouteUtil.getFinalDestination(route);
    }

    @Override
    public int getADBActiveProfile() {
        return this.naviADBHandler.getAdbStateHandler().getActiveProfile();
    }

    @Override
    public void startStoringAddress(NavLocation navLocation) {
        this.naviADBHandler.startStoringAddress(navLocation);
    }

    @Override
    public void parkingNearDestination(NavLocation navLocation) {
        this.naviFavoriteHandler.getPoiService().getParkingNearDestinationSequenceWithDistanceFromDestination(navLocation).execute("PicNavNaviInterfaceImpl#parkingNearDestionation");
    }

    @Override
    public void addToADB(NavLocation navLocation) {
        byte[] byArray = this.naviADBHandler.getADBInterAppService().resolveGeoCoords(navLocation.longitude, navLocation.latitude, "");
        NaviADBService$LocationInputHandler naviADBService$LocationInputHandler = this.naviADBHandler.getADBInterAppService().getCurrentLocationInputHandler();
        if (naviADBService$LocationInputHandler != null) {
            naviADBService$LocationInputHandler.updateLocation(byArray);
            this.naviADBHandler.getADBInterAppService().removeHandler();
        }
    }

    @Override
    public void enterPreviewMapScreen() {
        this.mapInterface.getMap().getMapManager().getPreviewMapHandler().previewMapScreenEntering(0, 0, 0, 0);
    }

    @Override
    public void showDestinationInMap(NavLocation navLocation) {
        this.mapInterface.destOptShowInMap(navLocation);
    }

    @Override
    public void focusPreviewMapOnSingleEvent(NavLocation navLocation) {
        try {
            this.mapInterface.getPreviewMap().setPreviewLocation(navLocation, 1, null, null);
        }
        catch (Exception exception) {
            this.lc.log(10000, "PicNavNaviInterfaceImpl#focusPreviewMapOnSingleEvent() - ERROR=%1", (Throwable)exception);
            exception.printStackTrace();
        }
    }

    @Override
    public void focusPreviewMapOnMultipleEvents(NavLocation[] navLocationArray) {
        try {
            this.mapInterface.getPreviewMap().setPreviewLocations(navLocationArray, 1, null, null);
        }
        catch (Exception exception) {
            this.lc.log(10000, "PicNavNaviInterfaceImpl#focusPreviewMapOnMultipleEvents() - ERROR=%1", (Throwable)exception);
            exception.printStackTrace();
        }
    }

    static /* synthetic */ PicNavInterfaceHandler access$000(PicNavNaviInterfaceImpl picNavNaviInterfaceImpl) {
        return picNavNaviInterfaceImpl.picNavInterfaceHandler;
    }

    static {
        tmpInternalData = new MMIInternalData();
    }
}

