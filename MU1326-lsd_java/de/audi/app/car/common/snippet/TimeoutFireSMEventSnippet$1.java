/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.snippet;

import de.audi.app.car.common.snippet.TimeoutFireSMEventSnippet;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class TimeoutFireSMEventSnippet$1
implements TimerListener {
    private final /* synthetic */ TimeoutFireSMEventSnippet this$0;

    TimeoutFireSMEventSnippet$1(TimeoutFireSMEventSnippet timeoutFireSMEventSnippet) {
        this.this$0 = timeoutFireSMEventSnippet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(TimeoutFireSMEventSnippet.access$000(this.this$0))) {
            Object object = TimeoutFireSMEventSnippet.access$100(this.this$0);
            synchronized (object) {
                TimeoutFireSMEventSnippet.access$400(this.this$0).fireSMEvent(TimeoutFireSMEventSnippet.access$200(this.this$0), TimeoutFireSMEventSnippet.access$300(this.this$0));
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

