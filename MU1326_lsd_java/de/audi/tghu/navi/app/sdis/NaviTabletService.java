/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sdis;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sdis.IHMISyncNaviReplies;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaRouteUtil;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sdis.INaviTabletService;
import de.audi.tghu.navi.app.sdis.INaviTabletServiceListener;
import de.audi.tghu.navi.app.sdis.NaviSDISStartGuidanceHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class NaviTabletService
implements INaviTabletService {
    public static final String NAVLOCATIONS_ARRAY = "NavLocationArray";
    protected final LogChannel logger;
    private final IRouteManager routeManager;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected ICommandListFactory commandListFactory;
    private INaviTabletServiceListener naviTabletServiceListener;
    protected final NavigationEnv env;
    protected NaviSDISStartGuidanceHandler startGuidanceHandler;
    private boolean rgInfoForNextDestinationIsPending = false;

    public NaviTabletService(LogChannel logChannel, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler) {
        this.commandListFactory = iCommandListFactory;
        this.routeManager = iRouteManager;
        this.logger = logChannel;
        this.env = navigationEnv;
        this.startGuidanceHandler = naviSDISStartGuidanceHandler;
        logChannel.log(10000000, this.CLASS_NAME + " initialized");
    }

    public boolean isReady() {
        return this.env.getChoiceModel(177).getValue() == 1;
    }

    public IHMISyncNaviReplies.LastDestination[] requestLastDestinationList() {
        this.logger.log(1000000, this.CLASS_NAME + "#requestLastDestinationList()");
        IHMISyncNaviReplies.LastDestination[] lastDestinationArray = null;
        if (this.routeManager == null) {
            this.logger.log(1000000, this.CLASS_NAME + "#requestLastDestinationList() -- Routemanager is null");
            return new IHMISyncNaviReplies.LastDestination[0];
        }
        if (this.routeManager.getFilteredRoute() == null) {
            this.logger.log(1000000, this.CLASS_NAME + "#requestLastDestinationList() -- Filtered Route is null");
            return new IHMISyncNaviReplies.LastDestination[0];
        }
        Route route = this.routeManager.getFilteredRoute();
        int n = RouteUtil.getRouteLength(route);
        if (n > 0) {
            lastDestinationArray = new IHMISyncNaviReplies.LastDestination[n];
            for (int i2 = 0; i2 < n; ++i2) {
                NavLocation navLocation = route.getRoutelist()[i2].getRouteLocation();
                lastDestinationArray[i2] = new IHMISyncNaviReplies.LastDestination();
                lastDestinationArray[i2].listPosition = i2;
                lastDestinationArray[i2].queryId = -1;
                lastDestinationArray[i2].name = AddressFormatter.formatOneLine(navLocation, this.env).getFirstLineAsText();
                lastDestinationArray[i2].latitude = NavigationUtilities.wgs84ToDegree(navLocation.getLatitude());
                lastDestinationArray[i2].longitude = NavigationUtilities.wgs84ToDegree(navLocation.getLongitude());
            }
        }
        return lastDestinationArray;
    }

    public void updateCarPosition(PosPosition posPosition) {
        if (this.naviTabletServiceListener != null) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, this.CLASS_NAME + "#updateCarPosition() - updatedCarPosition is called");
            }
            this.naviTabletServiceListener.updateCarPosition(posPosition);
        } else if (this.logger.isDebug2()) {
            this.logger.log(100000000, this.CLASS_NAME + "#updateCarPosition() - No naviTabletServiceListener available");
        }
    }

    public void updateRouteGuidanceActive(boolean bl) {
        if (this.naviTabletServiceListener != null) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, this.CLASS_NAME + "#updateRouteGuidanceActive( %1 ) - updateRouteGuidanceActive is called", bl);
            }
            this.naviTabletServiceListener.updateRouteGuidanceActive(bl);
        } else if (this.logger.isDebug2()) {
            this.logger.log(100000000, this.CLASS_NAME + "#updateRouteGuidanceActive() - No naviTabletServiceListener available");
        }
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, NavigationEnv navigationEnv) {
        if (navigationEnv.getContainer().isRgActive()) {
            this.forwardUpdateRgDestinationInfo(navRouteListDataArray, navigationEnv);
            if (this.rgInfoForNextDestinationIsPending) {
                this.rgInfoForNextDestinationIsPending = false;
                this.updateRgInfoForNextDestination(navigationEnv.getContainer().getRgInfoForNextDestination());
            }
        }
    }

    private void forwardUpdateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, NavigationEnv navigationEnv) {
        if (this.naviTabletServiceListener != null && navRouteListDataArray != null && navRouteListDataArray.length > 0) {
            this.logger.log(1000000, this.CLASS_NAME + "#updateRgDestinationInfo() - updateDestinationInfo is called");
            NavRouteListData[] navRouteListDataArray2 = this.clearNavRouteListDataFromSoftdestination(this.routeManager.getRoute(), navRouteListDataArray);
            if (navRouteListDataArray2.length == 0) {
                return;
            }
            Route route = this.routeManager.getFilteredRoute();
            NavLocation[] navLocationArray = new NavLocation[RouteUtil.getRouteLength(route)];
            for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
                navLocationArray[i2] = route.getRoutelist()[i2].getRouteLocation();
            }
            this.naviTabletServiceListener.updateDestinationInfo(navRouteListDataArray2, navLocationArray, navigationEnv);
        } else if (this.logger.isDebug2()) {
            this.logger.log(100000000, "%1#updateRgDestinationInfo() - No naviTabletServiceListener available or empty navRouteListData recieved (%2)", (Object)this.CLASS_NAME, (Object)(navRouteListDataArray == null ? "null" : Integer.toString(navRouteListDataArray.length)));
        }
    }

    private NavRouteListData[] clearNavRouteListDataFromSoftdestination(Route route, NavRouteListData[] navRouteListDataArray) {
        NavRouteListData[] navRouteListDataArray2;
        this.logger.log(10000000, "%1#clearNavRouteListDataFromSoftDestinations", (Object)this.CLASS_NAME);
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        if (routeDestinationArray.length != navRouteListDataArray.length) {
            this.logger.log(100000, "%1#clearNavRouteListDataFromSoftDestinations - length missmatch return original routelistdata", (Object)this.CLASS_NAME);
            navRouteListDataArray2 = new NavRouteListData[]{};
        } else {
            ArrayList arrayList = new ArrayList();
            int n = 0;
            int n2 = navRouteListDataArray.length > 0 ? navRouteListDataArray[0].startDistance : 0;
            for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                if (!ViaRouteUtil.isViaPoint(route, i2)) {
                    NavRouteListData navRouteListData = new NavRouteListData();
                    navRouteListData.remainingTravelTime = n == 0 ? navRouteListDataArray[i2].remainingTravelTime : n;
                    navRouteListData.endDistance = navRouteListDataArray[i2].endDistance;
                    navRouteListData.startDistance = n2;
                    arrayList.add(navRouteListData);
                    n = 0;
                    n2 = navRouteListDataArray[i2].endDistance;
                    continue;
                }
                if (n != 0) continue;
                n = navRouteListDataArray[i2].remainingTravelTime;
            }
            navRouteListDataArray2 = (NavRouteListData[])arrayList.toArray(new NavRouteListData[arrayList.size()]);
            this.logger.log(1000000, "NaviTabletService#clearNavRouteListDataFromSoftdestination() - clearedRouteListData.length: %1  clearedRouteListData: %2", (Object)("" + arrayList.size()), (Object)arrayList);
        }
        return navRouteListDataArray2;
    }

    public void startGuidanceToDestinations(NavLocation[] navLocationArray, NavCommand navCommand, NavCommand navCommand2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
            stringBuffer.append(" [").append(i2).append("]-Destination = ").append(LocationFormatter.formatLocationShort(navLocationArray[i2]));
        }
        this.env.getSdisLogChannel().log(10000000, this.CLASS_NAME + "#startGuidanceToDestinations Destinations: %1", (Object)stringBuffer.toString());
        this.startGuidanceHandler.prepareStartGuidance(navLocationArray, navCommand, navCommand2);
    }

    public void registerListener(INaviTabletServiceListener iNaviTabletServiceListener) {
        this.naviTabletServiceListener = iNaviTabletServiceListener;
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        int n;
        if (this.naviTabletServiceListener == null) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, this.CLASS_NAME + "#updateRgInfoForNextDestination() - No naviTabletServiceListener available");
            }
            return;
        }
        Route route = this.routeManager.getRoute();
        NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
        if (route == null || route.getRoutelist() == null || navRouteListDataArray == null || route.getRoutelist().length != navRouteListDataArray.length) {
            this.logger.log(100000, "%1#updateRgInfoForNextDestination() - Route length(%2) does not match NavRouteListData length(%3), queue update!", (Object)this.CLASS_NAME, (Object)Integer.toString(RouteUtil.getRouteLength(route)), (Object)(navRouteListDataArray == null ? "empty" : Integer.toString(navRouteListDataArray.length)));
            this.rgInfoForNextDestinationIsPending = true;
            return;
        }
        int n2 = rgInfoForNextDestination.destinationIndex;
        long l = rgInfoForNextDestination.distanceToNextDest;
        long l2 = rgInfoForNextDestination.timeToNextDest;
        for (n = n2; n < navRouteListDataArray.length && ViaRouteUtil.isViaPoint(this.routeManager.getRoute(), n); ++n) {
            l2 = navRouteListDataArray.length <= n + 2 ? (l2 += (long)(navRouteListDataArray[n + 1].remainingTravelTime / 1000)) : (l2 += (long)((navRouteListDataArray[n + 1].remainingTravelTime - navRouteListDataArray[n + 2].remainingTravelTime) / 1000));
            l = l + (long)navRouteListDataArray[n + 1].startDistance - (long)navRouteListDataArray[n + 1].endDistance;
        }
        n = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (ViaRouteUtil.isViaPoint(this.routeManager.getRoute(), i2)) continue;
            ++n;
        }
        RgInfoForNextDestination rgInfoForNextDestination2 = new RgInfoForNextDestination();
        rgInfoForNextDestination2.destinationIndex = n;
        rgInfoForNextDestination2.timeToNextDest = l2;
        rgInfoForNextDestination2.distanceToNextDest = l;
        this.naviTabletServiceListener.updateNextDestinationInfo(rgInfoForNextDestination2);
    }

    public CommandList getTransformCommandList(NavLocation[] navLocationArray) {
        CommandList commandList = this.commandListFactory.createCommandList();
        NavLocation[] navLocationArray2 = new NavLocation[navLocationArray.length];
        commandList.put(NAVLOCATIONS_ARRAY, navLocationArray2);
        for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
            final int n = i2;
            this.logger.log(10000000, this.CLASS_NAME + "#getTransformCommandList location to transform = %1", (Object)navLocationArray[i2]);
            commandList.add(new LIGetLocationDescriptionTransformCommand(navLocationArray[i2]));
            commandList.add(new NavCommand(this.CLASS_NAME + "#getTransformCommandList - Add transformed Location to NavLocation-Array"){

                public void execute() {
                    NavLocation[] navLocationArray = (NavLocation[])this.getCommandList().get(NaviTabletService.NAVLOCATIONS_ARRAY);
                    navLocationArray[n] = this.dsiResponseContainer.getTransformedLocation();
                    this.getCommandList().commandFinished();
                }
            });
        }
        return commandList;
    }

    public void routeChanged() {
        NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
        if (navRouteListDataArray != null && navRouteListDataArray.length != 0) {
            this.forwardUpdateRgDestinationInfo(navRouteListDataArray, this.env);
        }
    }

    public void registerService(AbstractActivator abstractActivator) {
    }
}

