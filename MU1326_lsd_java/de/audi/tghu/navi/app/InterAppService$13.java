/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class InterAppService$13
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ InterAppService this$0;

    InterAppService$13(InterAppService interAppService, NaviServiceListener naviServiceListener, boolean bl) {
        this.this$0 = interAppService;
        this.val$result = bl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSelectAlternativeRoute(this.val$result ? (byte)0 : 3);
    }
}

