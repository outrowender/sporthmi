/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$1;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$IRouteInfoRenderer;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler$MixedData;
import org.dsi.ifc.tmc.TmcMessage;

class RouteInfoHandler$FirstTmcRenderer
implements RouteInfoHandler$IRouteInfoRenderer {
    private final /* synthetic */ RouteInfoHandler this$0;

    private RouteInfoHandler$FirstTmcRenderer(RouteInfoHandler routeInfoHandler) {
        this.this$0 = routeInfoHandler;
    }

    @Override
    public void render(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        MixedListItem mixedListItem = this.getFirstTMC(routeInfoHandler$MixedData);
        if (mixedListItem != null) {
            this.this$0.getNaviInterface().updateInfoForNextTmcEvent(mixedListItem.getDistanceToCar() >= 0L ? mixedListItem.getDistanceToCar() : 0L, (TmcMessage)mixedListItem.getEvent());
        }
    }

    private MixedListItem getFirstTMC(RouteInfoHandler$MixedData routeInfoHandler$MixedData) {
        for (int i2 = 0; i2 < routeInfoHandler$MixedData.size(); ++i2) {
            MixedListItem mixedListItem = routeInfoHandler$MixedData.getItem(i2);
            if (mixedListItem.getFormat() != 2 && mixedListItem.getFormat() != 18 && mixedListItem.getFormat() != 21 && mixedListItem.getFormat() != 22) continue;
            return mixedListItem;
        }
        return null;
    }

    /* synthetic */ RouteInfoHandler$FirstTmcRenderer(RouteInfoHandler routeInfoHandler, RouteInfoHandler$1 routeInfoHandler$1) {
        this(routeInfoHandler);
    }
}

