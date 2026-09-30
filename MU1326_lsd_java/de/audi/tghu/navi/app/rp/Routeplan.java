/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.rp.RouteplanUtilAudi;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.Route;

public class Routeplan {
    protected final NavigationEnv env;
    protected LogChannel mainLogChannel;
    protected LogChannel guidanceLogChannel;
    protected IRouteManager manager;
    protected RouteplanUtilAudi routeplanUtil;

    public Routeplan(NavigationEnv navigationEnv, IRouteManager iRouteManager, int n) {
        this.env = navigationEnv;
        this.mainLogChannel = navigationEnv.getLogChannel();
        this.guidanceLogChannel = navigationEnv.getGuidanceLogChannel();
        this.manager = iRouteManager;
        this.routeplanUtil = new RouteplanUtilAudi(navigationEnv, n);
    }

    public synchronized void unitsChanged() {
        this.mainLogChannel.log(10000000, "Routeplan#unitsChanged()");
        this.refreshTripData();
    }

    public void updateRgActive(boolean bl) {
        if (this.mainLogChannel.isDebug2()) {
            this.mainLogChannel.log(100000000, "Routeplan#updateRgActive( %1 )", bl);
        }
        this.refreshTripData();
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.refreshTripData();
    }

    protected synchronized void refreshTripData() {
        Route route;
        int n;
        Object var1_1 = null;
        if (var1_1 == null) {
            return;
        }
        boolean bl = this.env.getContainer().isRgActive();
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "RouteplanAudi#refreshTripData() - rgActive: %1, tripData: %2", bl, (Object)var1_1);
        }
        if ((n = RouteUtil.getRouteLength(route = this.manager.getFilteredRoute())) <= 0) {
            this.guidanceLogChannel.log(100000, "RouteplanAudi#refreshRouteData() - onRoadRoute length is 0!");
            return;
        }
        int n2 = RouteUtil.getIndexOfCurrentDestination(route);
        int n3 = var1_1.distanceToNextDestination;
        long l = var1_1.etaToNextDestination;
        boolean bl2 = true;
        boolean bl3 = true;
        NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
        for (int i2 = n2; i2 < n; ++i2) {
            if (bl) {
                if (i2 != n2) {
                    if (navRouteListDataArray != null && i2 < navRouteListDataArray.length) {
                        int n4 = navRouteListDataArray[i2].getRemainingTravelTime();
                        bl2 &= n4 >= 0;
                        int n5 = i2 + 1 < navRouteListDataArray.length ? navRouteListDataArray[i2 + 1].getRemainingTravelTime() : 0;
                        l += (long)(n4 - n5);
                        int n6 = navRouteListDataArray[i2].getEndDistance();
                        int n7 = navRouteListDataArray[i2].getStartDistance();
                        bl3 &= n7 >= 0 && n6 >= 0 && n7 >= n6;
                        n3 += n7 - n6;
                    } else {
                        this.guidanceLogChannel.log(100000, "RouteplanAudi#refreshRouteData() - rgDestinationInfo array too small!");
                        bl2 = false;
                        bl3 = false;
                    }
                } else {
                    bl2 &= var1_1.etaValid && l >= 0L;
                    bl3 &= n3 >= 0;
                }
            } else {
                bl2 = false;
                bl3 = false;
            }
            this.routeplanUtil.refreshRouteDestinationData(i2, bl, bl2, l, bl3, n3);
        }
    }

    public int getDistanceToFinalDestination() {
        Object var1_1 = null;
        if (var1_1 == null) {
            return 0;
        }
        Route route = this.manager.getRoute();
        int n = RouteUtil.getRouteLength(route);
        int n2 = 0;
        if (n > 0) {
            int n3 = RouteUtil.getIndexOfCurrentDestination(route);
            n2 = var1_1.distanceToNextDestination;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            for (int i2 = n3 + 1; i2 < n; ++i2) {
                if (navRouteListDataArray != null && i2 < navRouteListDataArray.length) {
                    int n4 = navRouteListDataArray[i2].getEndDistance();
                    int n5 = navRouteListDataArray[i2].getStartDistance();
                    n2 += n5 - n4;
                    continue;
                }
                this.guidanceLogChannel.log(100000, "RouteplanAudi#getDistanceToFinalDestination() - rgDestinationInfo array too small!");
            }
        }
        return n2;
    }

    public long getTimeToFinalDestination() {
        Object var1_1 = null;
        if (var1_1 == null) {
            return 0L;
        }
        Route route = this.manager.getRoute();
        int n = RouteUtil.getRouteLength(route);
        long l = 0L;
        if (n > 0) {
            int n2 = RouteUtil.getIndexOfCurrentDestination(route);
            l = var1_1.timeToNextDestination;
            NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
            int n3 = n2 + 1;
            if (navRouteListDataArray != null && n3 < navRouteListDataArray.length) {
                l += (long)(navRouteListDataArray[n3].getRemainingTravelTime() / 1000);
            }
        }
        return l;
    }

    public long getTMCDistanceToDestination() {
        int n = 0;
        n = this.getDistanceToFinalDestination();
        return n;
    }
}

