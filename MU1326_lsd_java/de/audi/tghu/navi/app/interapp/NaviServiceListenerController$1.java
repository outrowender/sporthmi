/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$1
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ boolean val$rgActive;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$1(NaviServiceListenerController naviServiceListenerController, boolean bl) {
        this.this$0 = naviServiceListenerController;
        this.val$rgActive = bl;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateRgActive(this.val$rgActive);
    }
}

