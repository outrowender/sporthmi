/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class RouteGuidanceInterAppService$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ RouteGuidanceInterAppService this$0;

    RouteGuidanceInterAppService$2(RouteGuidanceInterAppService routeGuidanceInterAppService, NaviServiceListener naviServiceListener) {
        this.this$0 = routeGuidanceInterAppService;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseStopRouteGuidance((byte)1);
    }
}

