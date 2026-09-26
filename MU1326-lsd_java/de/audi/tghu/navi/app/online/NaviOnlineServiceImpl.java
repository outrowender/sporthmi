/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$MapStateService;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineMapOverlay;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineSearchAreaListener;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineServiceListener;
import de.audi.atip.interapp.NaviOnlineService$POIOnlineData;
import de.audi.atip.interapp.NaviOnlineService$RRDListener;
import de.audi.atip.interapp.NaviOnlineService$RrdData;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.ShowRemoteHMIResultsCommand;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.online.NaviOnlineServiceImpl$1;
import de.audi.tghu.navi.app.online.NaviOnlineServiceImpl$2;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public abstract class NaviOnlineServiceImpl
implements NaviOnlineService {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    private NaviOnlineService$NaviOnlineServiceListener listener = null;
    protected final IVehicle vehicle;
    private MapInterface mapInterface;
    private IRouteManager routeManager;
    private OperationManager operationManager;
    protected final ICommandListFactory commandListFactory;
    protected final INavigationInputModeManager inputModeManager;
    private NaviOnlineService$NaviOnlineSearchAreaListener searchAreaListener;
    protected NaviOnlineService$RRDListener rrdListener;
    private final IAddressInputForm addressInputForm;
    protected final IRRDListener naviRrdListener;
    protected final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private NaviOnlineService$MapStateService mapStateService;
    private AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexHandler;
    protected int[] latitudes;
    protected int[] longitudes;
    protected int[] distances;
    protected ArrayList rrdRequestList;
    protected ArrayList airDistanceList;
    protected Timer updateAirdistanceTimer;

    public NaviOnlineServiceImpl(NavigationEnv navigationEnv, LogChannel logChannel, IVehicle iVehicle, MapInterface mapInterface, IRouteManager iRouteManager, OperationManager operationManager, ICommandListFactory iCommandListFactory, IAddressInputForm iAddressInputForm, IRRDListener iRRDListener, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexCommandListCreator) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        this.vehicle = iVehicle;
        this.mapInterface = mapInterface;
        this.operationManager = operationManager;
        this.commandListFactory = iCommandListFactory;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.addressInputForm = iAddressInputForm;
        this.naviRrdListener = iRRDListener;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.addSelectedDestinationAtIndexHandler = addSelectedDestinationAtIndexCommandListCreator;
        logChannel.log(1078071040, "NaviOnlineServiceImpl#ctor()");
        if (operationManager == null || iVehicle == null || iRouteManager == null || mapInterface == null || iCommandListFactory == null) {
            throw new IllegalArgumentException("Parameter is null.");
        }
    }

    @Override
    public void setPOIViewportData(NaviOnlineService$POIOnlineData[] naviOnlineService$POIOnlineDataArray, int n, NavLocationWgs84 navLocationWgs84, ChoiceModelApp choiceModelApp) {
        Object object;
        this.logChannel.log(1078071040, "NaviOnlineServiceImpl#setPOIViewportData()");
        OnlinePOIResultList onlinePOIResultList = new OnlinePOIResultList(this.env.getLogChannel());
        if (naviOnlineService$POIOnlineDataArray != null && naviOnlineService$POIOnlineDataArray.length > 0) {
            object = new PoiOnlineSearchValuelistElement[naviOnlineService$POIOnlineDataArray.length];
            for (int i2 = 0; i2 < ((PoiOnlineSearchValuelistElement[])object).length; ++i2) {
                object[i2] = new PoiOnlineSearchValuelistElement();
                object[i2].longitude = naviOnlineService$POIOnlineDataArray[i2].longitude;
                ((PoiOnlineSearchValuelistElement)object[i2]).latitude = naviOnlineService$POIOnlineDataArray[i2].latitude;
                ((PoiOnlineSearchValuelistElement)object[i2]).city = naviOnlineService$POIOnlineDataArray[i2].city;
                ((PoiOnlineSearchValuelistElement)object[i2]).country = naviOnlineService$POIOnlineDataArray[i2].country;
                ((PoiOnlineSearchValuelistElement)object[i2]).phone = naviOnlineService$POIOnlineDataArray[i2].phoneNumber;
                ((PoiOnlineSearchValuelistElement)object[i2]).name = naviOnlineService$POIOnlineDataArray[i2].poiName;
                ((PoiOnlineSearchValuelistElement)object[i2]).street = new StringBuffer().append(((PoiOnlineSearchValuelistElement)object[i2]).street).append(" ").append(naviOnlineService$POIOnlineDataArray[i2].housenumber).toString();
                ((PoiOnlineSearchValuelistElement)object[i2]).postal = naviOnlineService$POIOnlineDataArray[i2].zipCode;
                ((PoiOnlineSearchValuelistElement)object[i2]).type = (byte)2;
                this.overrideVariantSpecificPOIViewportValues(naviOnlineService$POIOnlineDataArray, (PoiOnlineSearchValuelistElement[])object, i2);
            }
            onlinePOIResultList.updateResultList((PoiOnlineSearchValuelistElement[])object, null);
        }
        if (n != -1) {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#setPOIViewportData zoom level: %1", (long)n);
            onlinePOIResultList.setForcedZoomLevel(n);
        }
        if (navLocationWgs84 != null) {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#setPOIViewportData center position: %1 %2", (long)n);
            onlinePOIResultList.setForcedLocation(navLocationWgs84);
        }
        this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#setPOIViewportData enter online result map");
        object = this.commandListFactory.createCommandList();
        ((CommandList)object).add(new ShowRemoteHMIResultsCommand(new OnlinePOIResultList(this.env.getLogChannel(), onlinePOIResultList)));
        ((CommandList)object).add(new WaitForMapReadyCommand());
        ((CommandList)object).execute("NaviOnlineServiceImpl#setPOIViewportData()");
    }

    protected void overrideVariantSpecificPOIViewportValues(NaviOnlineService$POIOnlineData[] naviOnlineService$POIOnlineDataArray, PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray, int n) {
    }

    @Override
    public void setMapOverlays(int n, NaviOnlineService$NaviOnlineMapOverlay[] naviOnlineService$NaviOnlineMapOverlayArray, int n2, ChoiceModelApp choiceModelApp) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "NaviOnlineServiceImpl#setMapOverlays");
        }
        this.mapInterface.setWeatherOverlays(n, naviOnlineService$NaviOnlineMapOverlayArray, n2, choiceModelApp);
    }

    @Override
    public int getPOIIndexFromUserFlags() {
        return this.mapInterface.getPOIIndexFromUserFlags();
    }

    @Override
    public double[] getDataVehicleLocation() {
        NavLocation navLocation = this.vehicle.getVehicleLocation();
        return new double[]{NavigationUtilities.wgs84ToDegree(navLocation.getLongitude()), NavigationUtilities.wgs84ToDegree(navLocation.getLatitude())};
    }

    @Override
    public String getDataVIN() {
        return Util.getVIN(this.env);
    }

    @Override
    public String getDataDayNightView() {
        return this.mapInterface.getDayNightView() ? "day" : "night";
    }

    @Override
    public String getDataFallBackLanguage() {
        return Util.getFallBackLanguage();
    }

    @Override
    public String getDataCountryAbbreviation() {
        NavLocation navLocation = this.vehicle.getVehicleLocation();
        return navLocation.getCountryAbbreviation();
    }

    @Override
    public double[] getDataDestination() {
        if (this.routeManager != null) {
            Route route = this.routeManager.getRoute();
            NavLocation navLocation = RouteUtil.getCurrentDestination(route);
            if (navLocation != null) {
                return new double[]{NavigationUtilities.wgs84ToDegree(navLocation.getLongitude()), NavigationUtilities.wgs84ToDegree(navLocation.getLatitude())};
            }
            return new double[0];
        }
        return new double[0];
    }

    @Override
    public int getDataScreenWidth() {
        return Util.getScreenWidth(this.env);
    }

    @Override
    public int getDataScreenHeight() {
        return Util.getScreenHeight(this.env);
    }

    @Override
    public void setListener(NaviOnlineService$NaviOnlineServiceListener naviOnlineService$NaviOnlineServiceListener) {
        this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#setListener");
        this.listener = naviOnlineService$NaviOnlineServiceListener;
    }

    @Override
    public boolean getIsNaviFullyOperable() {
        boolean bl = this.operationManager.isFullyOperable();
        this.logChannel.log(1078071040, "NaviOnlineServiceImpl#getIsNaviFullyOperable: %1", (Object)Boolean.toString(bl));
        return bl;
    }

    public void sendRemoteHMIAppsUpdateToNaviAndMap(List list, String string) {
    }

    @Override
    public void sendMiniAppsDownloadError() {
    }

    @Override
    public void prepareAddressForm() {
        this.inputModeManager.setInputMode(4, this.env);
        this.addressInputForm.startForRemoteHMI();
    }

    @Override
    public void setSearchAreaListener(NaviOnlineService$NaviOnlineSearchAreaListener naviOnlineService$NaviOnlineSearchAreaListener) {
        this.searchAreaListener = naviOnlineService$NaviOnlineSearchAreaListener;
    }

    @Override
    public NaviOnlineService$NaviOnlineSearchAreaListener getSearchAreaListener() {
        return this.searchAreaListener;
    }

    @Override
    public void exitAD() {
        this.cancelTimer(this.updateAirdistanceTimer);
    }

    public void fireTimer(Timer timer) {
        if (timer == this.updateAirdistanceTimer) {
            this.calculateAD();
        }
    }

    public void cancelTimer(Timer timer) {
        if (timer == this.updateAirdistanceTimer) {
            this.updateAirdistanceTimer.cancel();
        }
    }

    @Override
    public void setRRDListener(NaviOnlineService$RRDListener naviOnlineService$RRDListener) {
        this.rrdListener = naviOnlineService$RRDListener;
    }

    @Override
    public NaviOnlineService$RRDListener getRRDListener() {
        return this.rrdListener;
    }

    @Override
    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        int n;
        if (this.rrdRequestList == null || rrdCalculationInfoArray == null) {
            this.logChannel.log(1078071040, "NaviOnlineServiceImpl#updateRRDDistances: rrdRequestList or distances is null.");
            return;
        }
        int n2 = n = this.rrdRequestList.size();
        if (n != rrdCalculationInfoArray.length) {
            this.logChannel.log(-1601830656, "NaviOnlineServiceImpl#updateRRDDistances: requestList.size != calculated list, using minimum of both to set RRD");
            n2 = Math.min(n, rrdCalculationInfoArray.length);
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = this.rrdRequestList.get(i2);
            if (i2 < rrdCalculationInfoArray.length && rrdCalculationInfoArray[i2] == null) {
                this.logChannel.log(-1601830656, "NaviOnlineServiceImpl#updateRRDDistances: distance[%1] is null or out of bounds.", (long)i2);
                continue;
            }
            if (object == null || !(object instanceof NaviOnlineService$RrdData)) continue;
            NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)object;
            String string = Util.formatDistance(rrdCalculationInfoArray[i2].getRrdInfo(), 1);
            this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#updateRRDDistances:distance %1", (Object)rrdCalculationInfoArray[i2]);
            naviOnlineService$RrdData.setRrdDistance(string);
        }
        if (this.rrdListener != null) {
            this.rrdListener.updateRrdItems(this.rrdRequestList);
        } else {
            this.logChannel.log(1078071040, "NaviOnlineServiceImpl#updateRRDDistances: rrdListener is null.");
        }
    }

    @Override
    public void updateDirectionAndAirDistance(int[] nArray, int[] nArray2) {
        if (this.rrdRequestList.size() != nArray.length) {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#updateDirectionAndAirDistance: Size of requested list and calculated list is not equal");
        } else {
            this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#updateDirectionAndAirDistance: requestList.size == calculated list");
            for (int i2 = 0; i2 < this.rrdRequestList.size(); ++i2) {
                Object object = this.rrdRequestList.get(i2);
                if (object == null || !(object instanceof NaviOnlineService$RrdData)) continue;
                NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)object;
                String string = Util.formatDistance(nArray[i2], 1);
                this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#updateDirectionAndAirDistance: distance %1, direction %2", (long)nArray[i2], (long)nArray2[i2]);
                naviOnlineService$RrdData.setAirDistance(string);
                naviOnlineService$RrdData.setAirDirection(new Integer(nArray2[i2]));
            }
        }
        this.rrdListener.updateRrdItems(this.rrdRequestList);
    }

    @Override
    public int[] getRequestedLatitudes() {
        return this.latitudes;
    }

    @Override
    public int[] getRequestedLongitudes() {
        return this.longitudes;
    }

    @Override
    public void triggerADRequest(ArrayList arrayList) {
        this.airDistanceList = arrayList;
        this.calculateAD();
        if (this.updateAirdistanceTimer.isRunning()) {
            this.updateAirdistanceTimer.cancel();
        }
        this.updateAirdistanceTimer.restart();
    }

    protected void calculateAD() {
        this.logChannel.log(1078071040, "NaviOnlineServiceImpl#requestARCalculation: Called");
        for (int i2 = 0; i2 < this.airDistanceList.size(); ++i2) {
            Object object = this.airDistanceList.get(i2);
            if (object == null || !(object instanceof NaviOnlineService$RrdData)) continue;
            NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)object;
            Integer n = naviOnlineService$RrdData.getLatitude();
            Integer n2 = naviOnlineService$RrdData.getLongitude();
            Integer n3 = naviOnlineService$RrdData.getRrdReferenceLatitude();
            Integer n4 = naviOnlineService$RrdData.getRrdReferenceLongitude();
            if (n3 == null && n4 == null) {
                double[] dArray = this.getDataVehicleLocation();
                n4 = new Integer(NavigationUtilities.degreeToWgs84(dArray[0]));
                n3 = new Integer(NavigationUtilities.degreeToWgs84(dArray[1]));
                this.logChannel.log(1078071040, "NaviOnlineServiceImpl#calculateAD: using car position because reference point coordinates are not set.");
            }
            this.logChannel.log(1078071040, "NaviOnlineServiceImpl#calculateAD: having lat %1, lon %2, referenceLat %3, referenceLon %4", (Object)n, (Object)n2, (Object)n3, (Object)n4);
            if (n != null && n2 != null && n3 != null && n4 != null) {
                int n5 = Util.computeAirDistance(n4, n3, n2, n);
                int n6 = Util.computeAbsoluteDirection(this.vehicle.getPosition(), n2, n);
                int n7 = Util.convertRotatingDirection(n6, this.vehicle.getPosition().directionAngle);
                String string = Util.formatDistance(n5, 1);
                this.logChannel.log(1078071040, "NaviOnlineServiceImpl#calculateAD: setting airDistance %1", (Object)string);
                this.logChannel.log(1078071040, "NaviOnlineServiceImpl#calculateAD: setting airDirection %1", (long)n7);
                naviOnlineService$RrdData.setAirDistance(string);
                naviOnlineService$RrdData.setAirDirection(new Integer(n7));
                continue;
            }
            this.logChannel.log(1078071040, "NaviOnlineServiceImpl#calculateAD: required fields are empty, aborting air Distance calculation");
        }
        this.rrdListener.updateRrdItems(this.airDistanceList);
    }

    @Override
    public synchronized void triggerRRDRequest(ArrayList arrayList) {
        this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#triggerRRDRequest: Called");
        this.rrdRequestList = arrayList;
        this.latitudes = new int[arrayList.size()];
        this.longitudes = new int[arrayList.size()];
        this.distances = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            Object object = arrayList.get(i2);
            if (object == null || !(object instanceof NaviOnlineService$RrdData)) continue;
            NaviOnlineService$RrdData naviOnlineService$RrdData = (NaviOnlineService$RrdData)object;
            Integer n = naviOnlineService$RrdData.getLatitude();
            Integer n2 = naviOnlineService$RrdData.getLongitude();
            if (n == null || n2 == null) continue;
            this.latitudes[i2] = n;
            this.longitudes[i2] = n2;
        }
        this.callRRDForListType(2);
    }

    @Override
    public void callRRDForListType(int n) {
        if (this.naviRrdListener != null) {
            this.naviRrdListener.enterRRD(n);
        }
    }

    @Override
    public void exitRRD() {
        if (this.naviRrdListener != null) {
            this.naviRrdListener.exitRRD(2);
        }
    }

    @Override
    public void startRouteGuidance(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, String string2) {
        this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#startRouteGuidance( %1 [lat: %2, long: %3])", (Object)string, (long)navLocationWgs84.getLatitude(), (long)navLocationWgs84.getLongitude());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocationWgs84));
        commandList.add(new NaviOnlineServiceImpl$1(this, "NaviOnlineServiceImpl#setDescriptionOnLocation", string, string2, choiceModelApp));
        commandList.execute("NaviOnlineServiceImpl#startRouteGuidance");
    }

    protected CommandList getStartSequence(NavLocation navLocation) {
        return this.startGuidanceToDestinationSequence.getStartSequence(navLocation);
    }

    @Override
    public void insertAsStopover(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, int n, boolean bl) {
        this.logChannel.log(-2137614336, "NaviOnlineServiceImpl#insertAsStopover( %1 [lat: %2, long: %3])", (Object)string, (long)navLocationWgs84.getLatitude(), (long)navLocationWgs84.getLongitude());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocationWgs84));
        commandList.add(new NaviOnlineServiceImpl$2(this, "NaviOnlineServiceImpl#setDescriptionOnLocationandAddAsStopover", string, choiceModelApp, n, bl));
        commandList.execute("NaviOnlineServiceImpl#insertAsStopOver");
    }

    @Override
    public void sendRemoteHMIAppsUpdateToNaviAndMap(List list) {
    }

    @Override
    public void swapModel(Object object, Object object2, Object object3, int n, int n2) {
    }

    @Override
    public NaviOnlineService$NaviOnlineServiceListener getListener() {
        return this.listener;
    }

    @Override
    public NaviOnlineService$MapStateService getMapStateService() {
        return this.mapStateService;
    }

    @Override
    public void setMapStateService(NaviOnlineService$MapStateService naviOnlineService$MapStateService) {
        this.mapStateService = naviOnlineService$MapStateService;
    }

    static /* synthetic */ AddSelectedDestinationAtIndexCommandListCreator access$000(NaviOnlineServiceImpl naviOnlineServiceImpl) {
        return naviOnlineServiceImpl.addSelectedDestinationAtIndexHandler;
    }
}

