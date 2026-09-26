/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$32
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ int val$speedLimit;
    private final /* synthetic */ byte val$speedUnit;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$32(NaviServiceListenerController naviServiceListenerController, byte by, int n, byte by2) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$speedLimit = n;
        this.val$speedUnit = by2;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseCurrentSpeedLimit(this.val$result, this.val$speedLimit, this.val$speedUnit);
    }
}

