/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$6
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ boolean val$operable;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$6(NaviServiceListenerController naviServiceListenerController, boolean bl) {
        this.this$0 = naviServiceListenerController;
        this.val$operable = bl;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateFullyOperableStateChanged(this.val$operable);
    }
}

