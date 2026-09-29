/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.MixedListRow$IRouteInfoEnv;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

class RouteInfoHandler$1
implements MixedListRow$IRouteInfoEnv {
    private final /* synthetic */ IconHandler val$iconHandler;
    private final /* synthetic */ NavigationEnv val$env;
    private final /* synthetic */ RouteInfoHandler this$0;

    RouteInfoHandler$1(RouteInfoHandler routeInfoHandler, IconHandler iconHandler, NavigationEnv navigationEnv) {
        this.this$0 = routeInfoHandler;
        this.val$iconHandler = iconHandler;
        this.val$env = navigationEnv;
    }

    @Override
    public RoadClassSpeedInfo[] getSpeedInfo() {
        return this.this$0.getNaviInterface().getTrafficRegulationService().getCountrySpeedInfo();
    }

    @Override
    public int getSpeedUnitForCountry(String string) {
        return RouteInfoHandler.access$000(this.this$0).findSpeedUnitForCountry(string, this.getSpeedInfo());
    }

    @Override
    public IconHandler getIconHandler() {
        return this.val$iconHandler;
    }

    @Override
    public int getRouteLength() {
        return RouteUtil.getRouteLength(this.this$0.getNaviInterface().getRoute());
    }

    @Override
    public NavLocation getCurrentDestination() {
        return RouteUtil.getCurrentDestination(this.this$0.getNaviInterface().getRoute());
    }

    @Override
    public String getTranslatedText(int n) {
        String string = MapUtils.getDefaultTraslatedText(n);
        return this.val$env.getTranslatedText(n, string);
    }

    @Override
    public String formatDistStr(long l) {
        long l2 = RouteInfoHandler.access$100((RouteInfoHandler)this.this$0).mDistCarToFinalDest - RouteInfoHandler.access$000(this.this$0).computeDistToFinalDest(l, RouteInfoHandler.access$100((RouteInfoHandler)this.this$0).indexOfCurrentDestination, RouteInfoHandler.access$100(this.this$0));
        return RouteInfoHandler.access$000(this.this$0).formatDistString(l2);
    }

    @Override
    public String getDestName(int n) {
        return RouteInfoHandler.access$200(this.this$0, n);
    }

    @Override
    public DateMetric getRTTMetric() {
        return RouteInfoHandler.access$300(this.this$0);
    }

    @Override
    public NavigationEnv getNavigationEnv() {
        return this.val$env;
    }

    @Override
    public RouteInfoHelper getHelper() {
        return RouteInfoHandler.access$000(this.this$0);
    }

    @Override
    public NavLocation getLocationOfDestination(int n) {
        Route route = this.this$0.getNaviInterface().getRoute();
        if (route != null && route.getRoutelist() != null && n < route.getRoutelist().length && route.getRoutelist()[n] != null) {
            return route.getRoutelist()[n].getRouteLocation();
        }
        this.this$0.getLogger().log(-1601830656, "RouteInfoHandler#getLocationOfDestination() is null!");
        return null;
    }
}

