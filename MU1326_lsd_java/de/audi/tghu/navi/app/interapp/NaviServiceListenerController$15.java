/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$15
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$resultCode;
    private final /* synthetic */ boolean val$syncNeeded;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$15(NaviServiceListenerController naviServiceListenerController, byte by, boolean bl) {
        this.this$0 = naviServiceListenerController;
        this.val$resultCode = by;
        this.val$syncNeeded = bl;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSynchronizeSpeechCountryWithCurrentLDResult(this.val$resultCode, this.val$syncNeeded);
    }
}

