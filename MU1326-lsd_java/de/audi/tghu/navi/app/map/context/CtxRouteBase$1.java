/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.context.CtxRouteBase;

class CtxRouteBase$1
extends DefaultTimerListener {
    private final /* synthetic */ CtxRouteBase this$0;

    CtxRouteBase$1(CtxRouteBase ctxRouteBase) {
        this.this$0 = ctxRouteBase;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.this$0.refreshSidebarData();
    }
}

