/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.navi.app.map.context.CtxScrollOnRoute;

final class CtxScrollOnRoute$InfoTimer
implements TimerListener {
    private final Timer mTimer;
    private final /* synthetic */ CtxScrollOnRoute this$0;

    CtxScrollOnRoute$InfoTimer(CtxScrollOnRoute ctxScrollOnRoute, String string, long l) {
        this.this$0 = ctxScrollOnRoute;
        this.mTimer = new Timer(string, l, true, this);
    }

    private void restart() {
        CtxScrollOnRoute.access$000(this.this$0).log(-2137614336, "CtxScrollOnRoute#InfoTimer#restart() - restart %1", (Object)this.mTimer.getName());
        this.mTimer.restart();
    }

    private void cancel() {
        CtxScrollOnRoute.access$100(this.this$0).log(-2137614336, "CtxScrollOnRoute#InfoTimer#cancel() - cancel %1", (Object)this.mTimer.getName());
        this.mTimer.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        CtxScrollOnRoute.access$200(this.this$0).log(-2137614336, "CtxScrollOnRoute#InfoTimer#fireTimer() - %1 fired", (Object)timer.getName());
        if (timer.getName().equals("infoTimer")) {
            this.this$0.requestInfoForPosition(true);
        } else if (timer.getName().equals("ccpChangeTimer") || timer.getName().equals("ddsChangeTimer")) {
            this.this$0.requestIdOfSelectedSegment();
        } else {
            CtxScrollOnRoute.access$300(this.this$0).log(-1601830656, "CtxScrollOnRoute#InfoTimer#fireTimer() - unknown timer: %1", (Object)timer.getName());
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    public boolean isRunning() {
        return this.mTimer.isRunning();
    }

    static /* synthetic */ void access$400(CtxScrollOnRoute$InfoTimer ctxScrollOnRoute$InfoTimer) {
        ctxScrollOnRoute$InfoTimer.cancel();
    }

    static /* synthetic */ void access$500(CtxScrollOnRoute$InfoTimer ctxScrollOnRoute$InfoTimer) {
        ctxScrollOnRoute$InfoTimer.restart();
    }
}

