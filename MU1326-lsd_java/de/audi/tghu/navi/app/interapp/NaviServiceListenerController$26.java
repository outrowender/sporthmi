/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$26
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$26(NaviServiceListenerController naviServiceListenerController, byte by) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseBlockRoute(this.val$result);
    }
}

