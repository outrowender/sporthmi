/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;

class InterAppService$11
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ InterAppService this$0;

    InterAppService$11(InterAppService interAppService, NaviServiceListener naviServiceListener) {
        this.this$0 = interAppService;
        super(naviServiceListener);
    }

    @Override
    public void call(NaviServiceListener naviServiceListener) {
        InterAppService.access$100(this.this$0).storeDestination(this.dsiResponseContainer.getTransformedLocation(), false, false);
        naviServiceListener.responseSetDestination((byte)0);
        this.getCommandList().commandFinished();
    }
}

