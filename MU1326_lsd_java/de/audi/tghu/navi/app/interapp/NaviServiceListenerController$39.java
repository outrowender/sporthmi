/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$39
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ boolean val$delay;
    private final /* synthetic */ DateMetric val$delayTime;
    private final /* synthetic */ int val$tmcEventsOnRoute;
    private final /* synthetic */ long val$distanceToNextEvent;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$39(NaviServiceListenerController naviServiceListenerController, boolean bl, DateMetric dateMetric, int n, long l, int n2) {
        this.this$0 = naviServiceListenerController;
        this.val$delay = bl;
        this.val$delayTime = dateMetric;
        this.val$tmcEventsOnRoute = n;
        this.val$distanceToNextEvent = l;
        this.val$validFlag = n2;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateTrafficSituation(this.val$delay, this.val$delayTime, this.val$tmcEventsOnRoute, this.val$distanceToNextEvent, this.val$validFlag);
    }
}

