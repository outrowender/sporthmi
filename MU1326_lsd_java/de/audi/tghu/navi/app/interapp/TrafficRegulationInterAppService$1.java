/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class TrafficRegulationInterAppService$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ TrafficRegulationInterAppService this$0;

    TrafficRegulationInterAppService$1(TrafficRegulationInterAppService trafficRegulationInterAppService, NaviServiceListener naviServiceListener) {
        this.this$0 = trafficRegulationInterAppService;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseCurrentSpeedLimit((byte)1, 0, (byte)0);
    }
}

