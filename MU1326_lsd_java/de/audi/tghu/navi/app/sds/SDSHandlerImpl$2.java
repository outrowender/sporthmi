/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;

class SDSHandlerImpl$2
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$2(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener) {
        this.this$0 = sDSHandlerImpl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseFinishDestinationInput((byte)1, (byte)1);
    }
}

