/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.hierarchiclist.via;

import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.util.RouteHelper;

public class ViaRouteUtil {
    public static boolean isRoutePreparedForVia(Route route) {
        return route != null && route.getRoutelist().length == 1;
    }

    public static Route constructViaRoute(Route route, NavLocation navLocation) {
        Route route2 = RouteUtil.cloneRoute(route, null);
        RouteHelper.addDestinationAtPosition(route2, new RouteDestination(navLocation, route2.getRoutelist()[0].getRouteOptions(), 2), 0);
        return route2;
    }

    public static boolean isViaRoute(Route route) {
        return route != null && route.getRoutelist() != null && (route.getRoutelist().length == 2 && route.getRoutelist()[0] != null && route.getRoutelist()[1] != null && route.getRoutelist()[0].getDestinationType() == 2 && route.getRoutelist()[1].getDestinationType() == 1 || ViaRouteUtil.isViaRouteAfterPassedStopover(route));
    }

    private static boolean isViaRouteAfterPassedStopover(Route route) {
        return route != null && route.getRoutelist() != null && route.getRoutelist().length == 3 && route.getRoutelist()[0] != null && route.getRoutelist()[1] != null && route.getRoutelist()[2] != null && route.getRoutelist()[0].getDestinationType() == 1 && route.getRoutelist()[1].getDestinationType() == 2 && route.getRoutelist()[2].getDestinationType() == 1;
    }

    public static boolean isViaPoint(Route route, int n) {
        if (n >= 0 && n < route.getRoutelist().length) {
            return route != null && route.getRoutelist()[n].getDestinationType() == 2;
        }
        return false;
    }

    public static void removeViaFromRoute(Route route) {
        if (route != null && route.getRoutelist() != null) {
            int n = 0;
            while (n < route.getRoutelist().length) {
                if (ViaRouteUtil.isViaPoint(route, n)) {
                    RouteHelper.deleteDestinationAtPosition(route, n);
                    long l = route.getIndexOfCurrentDestination();
                    if (l <= (long)n) continue;
                    route.setIndexOfCurrentDestination(l - 1L);
                    continue;
                }
                ++n;
            }
        }
    }

    public static Route filterViaFromRoute(Route route) {
        Route route2 = RouteUtil.cloneRoute(route, null);
        ViaRouteUtil.removeViaFromRoute(route2);
        return route2;
    }
}

