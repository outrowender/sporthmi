/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.sds.SDSDetourHandlerImpl;

class SDSDetourHandlerImpl$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ boolean val$blockDone;
    private final /* synthetic */ SDSDetourHandlerImpl this$0;

    SDSDetourHandlerImpl$1(SDSDetourHandlerImpl sDSDetourHandlerImpl, NaviServiceListener naviServiceListener, boolean bl) {
        this.this$0 = sDSDetourHandlerImpl;
        this.val$blockDone = bl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseBlockRoute(this.val$blockDone ? (byte)0 : 1);
    }
}

