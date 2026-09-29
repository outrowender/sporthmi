/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$7;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class RouteGuidanceInterAppService$7$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ RouteGuidanceInterAppService$7 this$1;

    RouteGuidanceInterAppService$7$1(RouteGuidanceInterAppService$7 routeGuidanceInterAppService$7, NaviServiceListener naviServiceListener) {
        this.this$1 = routeGuidanceInterAppService$7;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseStartRouteGuidance((byte)0);
    }
}

