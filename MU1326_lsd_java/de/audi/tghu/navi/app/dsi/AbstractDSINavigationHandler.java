/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;

public abstract class AbstractDSINavigationHandler
implements IDSINavigationHandler {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected int dsiType;
    protected Navigation navigation;
    private String handlerName;

    public AbstractDSINavigationHandler(NavigationEnv navigationEnv, Navigation navigation, int n) {
        this.logChannel = navigationEnv.getDSILogChannel();
        this.env = navigationEnv;
        this.dsiType = n;
        this.navigation = navigation;
        this.handlerName = DSINavigationManager.dsiTypeToString(n);
    }

    public void cleanUp() {
        this.navigation = null;
    }

    protected abstract DSIResponseContainer getContainer() {
    }

    public void propagateDSIData() {
        this.logChannel.log(-2137614336, "AbstractDSINavigationHandler[%1]#triggerRSEData()", (Object)this.handlerName);
        this.updateDistanceToNextManeuver(this.getContainer().getDistanceToNextManeuver());
        this.updateRgActive(this.getContainer().isRgActive());
        this.updateRgDestinationInfo(this.getContainer().getRgDestinationInfo());
        this.updateRgInfoForNextDestination(this.getContainer().getRgInfoForNextDestination());
        this.updateRgPoiInfo(this.getContainer().getRgPoiInfo());
        this.updateRgTurnList(this.getContainer().getRgTurnList());
        this.updateRmPersistentRoute(this.getContainer().getRmPersistentRoute());
        this.updateSoPosPosition(this.getContainer().getSoPosPosition());
        this.updateSoPosPositionDescription(this.getContainer().getSoPosPositionDescription(), this.getContainer().getInProgressData());
    }

    public String toString() {
        return new Buffer().append(super.getClass().getName()).append('[').append(this.handlerName).append(']').toString();
    }

    @Override
    public void updateRgActive(boolean bl) {
        this.logChannel.log(1078071040, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 )", bl, (Object)this.handlerName);
        this.getContainer().setRgActive(bl);
        try {
            this.navigation.getNavigationStartup().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getRouteDSIHandler().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getPoiDSIHandler().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getOnlineSearchController().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getRouteplan().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getClusterService().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getMapInterface().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getSimpleDetourHandler().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getSemidynamicRouteGuidance().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getNaviTabletService().updateRouteGuidanceActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getTmcGateway().updateRouteCriteria(this.navigation.getRouteCriteriaManager().getRouteCriteria());
            this.navigation.getTmcGateway().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getNaviServiceListenerController().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            if (bl) {
                NavLocation navLocation = this.navigation.getRouteManager().getRoute().getRoutelist()[this.navigation.getRouteManager().getRoute().getRoutelist().length - 1].getRouteLocation();
                this.navigation.getUotaNavListenerImpl().startNewGuidance(navLocation.getLatitude(), navLocation.getLongitude(), true);
            } else {
                this.navigation.getUotaNavListenerImpl().cancelLastGuidance();
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getInterAppService().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getPredictiveNavController().updateRgActive();
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
        try {
            this.navigation.getTourHandler().updateRgActive(bl);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%2]#updateRgActive( %1 ) %3", bl, (Object)this.handlerName, (Object)exception);
        }
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "AbstractDSINavigationHandler[%1]#updateRgInfoForNextDestination( %2 )", (Object)this.handlerName, (Object)rgInfoForNextDestination);
        }
        if (rgInfoForNextDestination == null) {
            return;
        }
        RgInfoForNextDestination rgInfoForNextDestination2 = rgInfoForNextDestination;
        if (rgInfoForNextDestination2.getDistanceToNextDest() == 0) {
            rgInfoForNextDestination2.distanceToNextDest = 0L;
        }
        this.getContainer().setRgInfoForNextDestination(rgInfoForNextDestination2);
        this.navigation.getRouteDSIHandler().updateRgInfoForNextDestination(rgInfoForNextDestination);
        this.navigation.getClusterService().updateRgInfoForNextDestination(rgInfoForNextDestination2);
        this.navigation.getRMLDSIHandler().updateRgInfoForNextDestination(rgInfoForNextDestination);
        this.navigation.getNaviTabletService().updateRgInfoForNextDestination(rgInfoForNextDestination2);
        this.navigation.getTmcGateway().updateDistanceToFinalDestination(this.navigation.getRouteManager().getTripDataAuto().distanceToFinalDestination);
        this.navigation.updateRgInfoForNextDestination(rgInfoForNextDestination);
        this.navigation.getMapInterface().updateRgInfoForNextDestination(rgInfoForNextDestination);
    }

    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.logChannel.log(-2137614336, "AbstractDSINavigationHandler[%1]#updateRgDestinationInfo()", (Object)this.handlerName);
        this.getContainer().setRgDestinationInfo(navRouteListDataArray);
        this.navigation.getRouteplan().updateRgDestinationInfo(navRouteListDataArray);
        this.navigation.getMapInterface().updateRgDestinationInfo(navRouteListDataArray);
        this.navigation.getRouteDSIHandler().updateRgDestinationInfo(navRouteListDataArray);
        this.navigation.getTmcGateway().updateDistanceToFinalDestination(this.navigation.getRouteManager().getTripDataAuto().distanceToFinalDestination);
        this.navigation.getTmcGateway().updateRgDestinationInfo(navRouteListDataArray);
        try {
            this.navigation.getNaviTabletService().updateRgDestinationInfo(navRouteListDataArray, this.env);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler#updateRgDestinationInfo ArrayIndexOutOfBoundsException occured %1", (Throwable)arrayIndexOutOfBoundsException);
        }
    }

    @Override
    public void updateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
        this.logChannel.log(-2137614336, "AbstractDSINavigationHandler[%1]#updateDistanceToNextManeuver( %2 )", (Object)this.handlerName, (Object)distanceToNextManeuver);
        this.getContainer().setDistanceToNextManeuver(distanceToNextManeuver);
        this.navigation.getClusterService().updateDistanceToNextManeuver(distanceToNextManeuver);
        this.navigation.getMapInterface().updateDistanceToNextManeuver(distanceToNextManeuver.distance);
    }

    @Override
    public void updateRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        this.logChannel.log(-2137614336, "AbstractDSINavigationHandler[%1]#updateRgPoiInfo()", (Object)this.handlerName);
        this.getContainer().setRgPoiInfo(navPoiInfoArray);
        this.navigation.getMapInterface().updateRgPoiInfo(navPoiInfoArray);
    }

    @Override
    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        this.logChannel.log(-2137614336, "AbstractDSINavigationHandler[%1]#updateRgTurnList()", (Object)this.handlerName);
        this.getContainer().setRgTurnList(turnListElementArray);
        try {
            this.navigation.getMapInterface().updateRgTurnList(turnListElementArray);
            this.navigation.getRouteDSIHandler().updateRgTurnList(turnListElementArray);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "AbstractDSINavigationHandler[%1]#updateRgTurnList()", (Throwable)exception);
        }
    }

    @Override
    public void updateRmPersistentRoute(Route route) {
        this.logChannel.log(-2137614336, "AbstractDSINavigationHandler[%1]#updateRmPersistentRoute( %2 )", (Object)this.handlerName, (Object)RouteUtil.formatRouteShort(route));
        route = RouteUtil.validateRoute(this.env, route);
        this.getContainer().setRmPersistentRoute(route);
        this.navigation.getRouteDSIHandler().updateRmPersistentRoute(route);
        NavLocation navLocation = null;
        int n = 0;
        int n2 = 0;
        Route route2 = this.navigation.getRouteManager().getFilteredRoute();
        if (route2 != null) {
            navLocation = RouteUtil.getCurrentDestination(route2);
            int n3 = n = RouteUtil.getRouteLength(route2) - 1 >= 0 ? RouteUtil.getRouteLength(route2) - 1 : 0;
            if (n > 0) {
                n2 = RouteUtil.getIndexOfCurrentDestination(route2) < RouteUtil.getRouteLength(route2) - 1 ? RouteUtil.getIndexOfCurrentDestination(route2) + 1 : 255;
            }
        }
        this.navigation.getClusterService().updateDestinationInfo(navLocation, n, n2);
        this.navigation.getNaviTabletService().routeChanged();
    }

    @Override
    public void updateSoPosPosition(PosPosition posPosition) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "AbstractDSINavigationHandler#updateSoPosPosition( %1 )", (Object)posPosition);
        }
        this.getContainer().setSoPosPosition(posPosition);
        this.navigation.getOperationManager().updateSatellites(posPosition);
        this.navigation.getClusterService().updateSoPosPosition(posPosition);
        this.navigation.refreshPosPosition(posPosition);
        this.navigation.getNaviTabletService().updateCarPosition(posPosition);
    }

    @Override
    public void updateSoPosPositionDescription(NavLocation navLocation, boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "AbstractDSINavigationHandler[%1]#updateSoPosPositionDescription( %2 )", (Object)this.handlerName, (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.getContainer().setSoPosPositionDescription(navLocation);
        this.getContainer().setInProgressData(bl);
        this.navigation.refreshPositionDescription();
    }

    @Override
    public void updatePOIsEnteringProximityRange(NavLocation[] navLocationArray) {
        if (this.env.getPoiApproachWarningLogChannel().isDebug2()) {
            this.env.getPoiApproachWarningLogChannel().log(14808325, "AbstractDSINavigationHandler#updatePOIsEnteringProximityRange()");
        }
        try {
            this.navigation.getPoiService().getPoiWarningManager().poiEntersProximityRange(navLocationArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

