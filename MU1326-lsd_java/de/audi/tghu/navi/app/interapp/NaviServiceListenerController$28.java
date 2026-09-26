/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$28
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ boolean val$isNumeric;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$28(NaviServiceListenerController naviServiceListenerController, byte by, boolean bl) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$isNumeric = bl;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responsePostCodeFormat(this.val$result, this.val$isNumeric);
    }
}

