/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.TrafficRegulationInterAppService$UpdateTrafficSignCommand;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class TrafficRegulationInterAppService$UpdateTrafficSignCommand$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ int val$currentSpeedLimit;
    private final /* synthetic */ byte val$currentSpeedLimitUnit;
    private final /* synthetic */ TrafficRegulationInterAppService$UpdateTrafficSignCommand this$1;

    TrafficRegulationInterAppService$UpdateTrafficSignCommand$2(TrafficRegulationInterAppService$UpdateTrafficSignCommand trafficRegulationInterAppService$UpdateTrafficSignCommand, NaviServiceListener naviServiceListener, byte by, int n, byte by2) {
        this.this$1 = trafficRegulationInterAppService$UpdateTrafficSignCommand;
        this.val$result = by;
        this.val$currentSpeedLimit = n;
        this.val$currentSpeedLimitUnit = by2;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseCurrentSpeedLimit(this.val$result, this.val$currentSpeedLimit, this.val$currentSpeedLimitUnit);
    }
}

