/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$20
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ byte val$status;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$20(NaviServiceListenerController naviServiceListenerController, byte by, byte by2) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$status = by2;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responsePrepareRouteGuidance(this.val$result, this.val$status);
    }
}

