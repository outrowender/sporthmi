/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$1;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$IRouteInfoRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$MixedData;
import org.dsi.ifc.komoview.RouteInfoElement;

class RouteInfoHandler$KOMOFollowInfoRenderer
implements RouteInfoHandler$IRouteInfoRenderer {
    private final /* synthetic */ RouteInfoHandler this$0;

    private RouteInfoHandler$KOMOFollowInfoRenderer(RouteInfoHandler routeInfoHandler) {
        this.this$0 = routeInfoHandler;
    }

    @Override
    public void render(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        this.this$0.getLogger().log(14808325, "RouteInfoHandler<G24KOMORenderer>#render() - data length : %1", routeInfoHandler$MixedData != null ? (long)routeInfoHandler$MixedData.size() : -1L);
        RouteInfoElement routeInfoElement = RouteInfoHandler.access$900(this.this$0, new MixedListItem[]{RouteInfoHandler.getNextManeuver(routeInfoHandler$MixedData)})[0];
        this.this$0.getNaviInterface().getClusterService().updateNextManeuver(routeInfoElement);
    }

    /* synthetic */ RouteInfoHandler$KOMOFollowInfoRenderer(RouteInfoHandler routeInfoHandler, RouteInfoHandler$1 routeInfoHandler$1) {
        this(routeInfoHandler);
    }
}

