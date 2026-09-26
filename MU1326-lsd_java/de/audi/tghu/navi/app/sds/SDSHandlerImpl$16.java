/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;

class SDSHandlerImpl$16
extends NotifySDSCommand {
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$16(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener) {
        this.this$0 = sDSHandlerImpl;
        super(naviServiceListener);
    }

    @Override
    public void call() {
        this.feedbackNaviServiceListener.responseIntelliDestination((byte)1);
    }
}

