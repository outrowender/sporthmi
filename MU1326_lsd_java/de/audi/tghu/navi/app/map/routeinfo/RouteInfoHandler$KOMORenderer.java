/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$1;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$IRouteInfoRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$MixedData;

class RouteInfoHandler$KOMORenderer
implements RouteInfoHandler$IRouteInfoRenderer {
    private final /* synthetic */ RouteInfoHandler this$0;

    private RouteInfoHandler$KOMORenderer(RouteInfoHandler routeInfoHandler) {
        this.this$0 = routeInfoHandler;
    }

    @Override
    public void render(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        this.this$0.getLogger().log(14808325, "RouteInfoHandler<KOMORenderer>#render() - data length : %1", routeInfoHandler$MixedData != null ? (long)routeInfoHandler$MixedData.size() : -1L);
        if (routeInfoHandler$MixedData == null) {
            this.this$0.getLogger().log(10000, "RouteInfoHandler<KOMORenderer>#render() - data null");
            return;
        }
        MixedListItem[] mixedListItemArray = new MixedListItem[]{RouteInfoHandler.getNextElementToShow(routeInfoHandler$MixedData, this.this$0.getLogger()), RouteInfoHandler.getNextManeuver(routeInfoHandler$MixedData)};
        RouteInfoHandler.access$1002(this.this$0, RouteInfoHandler.access$900(this.this$0, mixedListItemArray));
        RouteInfoHandler.access$1100(this.this$0, RouteInfoHandler.access$1000(this.this$0));
    }

    /* synthetic */ RouteInfoHandler$KOMORenderer(RouteInfoHandler routeInfoHandler, RouteInfoHandler$1 routeInfoHandler$1) {
        this(routeInfoHandler);
    }
}

