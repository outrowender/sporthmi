/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.sds.SDSDetourHandlerImpl;

class SDSDetourHandlerImpl$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ SDSDetourHandlerImpl this$0;

    SDSDetourHandlerImpl$2(SDSDetourHandlerImpl sDSDetourHandlerImpl, NaviServiceListener naviServiceListener) {
        this.this$0 = sDSDetourHandlerImpl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseUnblockRoute((byte)0);
    }
}

