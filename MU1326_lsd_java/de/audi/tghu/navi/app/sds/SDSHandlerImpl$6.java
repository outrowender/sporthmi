/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;

class SDSHandlerImpl$6
extends NotifySDSCommand {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$6(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener, byte by) {
        this.this$0 = sDSHandlerImpl;
        this.val$result = by;
        super(naviServiceListener);
    }

    @Override
    public void call() {
        this.feedbackNaviServiceListener.responseCheckRouteGuidance(this.val$result);
    }
}

