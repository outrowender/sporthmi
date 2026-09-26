/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.map.context.CtxTrafficNoticeMap;

class CtxTrafficNoticeMap$1
extends DefaultTimerListener {
    private final /* synthetic */ CtxTrafficNoticeMap this$0;

    CtxTrafficNoticeMap$1(CtxTrafficNoticeMap ctxTrafficNoticeMap) {
        this.this$0 = ctxTrafficNoticeMap;
    }

    @Override
    public synchronized void fireTimer(Timer timer) {
        CtxTrafficNoticeMap.access$000(this.this$0).log(-2137614336, "CtxTrafficNoticeMap.Timer#fireTimer()");
        this.this$0.switchBackToShownContext();
    }
}

