/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;

class SDSHandlerImpl$1
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$1(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener, boolean bl) {
        this.this$0 = sDSHandlerImpl;
        this.val$success = bl;
        super(naviServiceListener);
    }

    @Override
    protected void call(NaviServiceListener naviServiceListener) {
        if (this.val$success) {
            byte by = this.env.getContainer().getLiCurrentLD().isPositionValid() ? (byte)0 : 1;
            naviServiceListener.responseFinishDestinationInput((byte)0, by);
        } else {
            naviServiceListener.responseFinishDestinationInput((byte)0, (byte)1);
        }
    }
}

