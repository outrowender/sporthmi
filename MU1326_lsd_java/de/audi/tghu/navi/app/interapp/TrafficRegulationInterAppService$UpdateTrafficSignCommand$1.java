/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$UpdateTrafficSignCommand;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class TrafficRegulationInterAppService$UpdateTrafficSignCommand$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ TrafficRegulationInterAppService$UpdateTrafficSignCommand this$1;

    TrafficRegulationInterAppService$UpdateTrafficSignCommand$1(TrafficRegulationInterAppService$UpdateTrafficSignCommand trafficRegulationInterAppService$UpdateTrafficSignCommand, NaviServiceListener naviServiceListener) {
        this.this$1 = trafficRegulationInterAppService$UpdateTrafficSignCommand;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        try {
            naviServiceListener.responseCurrentSpeedLimit((byte)3, 0, (byte)-1);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1#fireTimer - listener has thrown an exception=%2", (Object)this.CLASS_NAME, (Throwable)exception);
        }
    }
}

