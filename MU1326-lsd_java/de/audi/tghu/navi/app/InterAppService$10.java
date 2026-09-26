/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class InterAppService$10
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ InterAppService this$0;

    InterAppService$10(InterAppService interAppService, NaviServiceListener naviServiceListener) {
        this.this$0 = interAppService;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSetDestination((byte)1);
    }
}

