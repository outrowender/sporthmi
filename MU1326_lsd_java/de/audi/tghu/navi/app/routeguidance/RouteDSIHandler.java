/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.routeguidance.RouteManager;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;

public class RouteDSIHandler {
    private final RouteManager routeManager;

    public RouteDSIHandler(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    public void updateRmPersistentRoute(Route route) {
        this.routeManager.updateRmPersistentRoute(route);
    }

    public void updateRgActive(boolean bl) {
        this.routeManager.updateRgActive(bl);
    }

    public void rgNotPossible(int n) {
        this.routeManager.rgNotPossible(n);
    }

    public void updateRgCurrentRoute(Route route) {
        this.routeManager.updateRgCurrentRoute(route);
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.routeManager.updateRgInfoForNextDestination(rgInfoForNextDestination);
    }

    public void updateRgTurnList(TurnListElement[] turnListElementArray) {
        this.routeManager.updateRgTurnList(turnListElementArray);
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.routeManager.updateRgDestinationInfo(navRouteListDataArray);
    }
}

