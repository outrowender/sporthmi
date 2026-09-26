/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.DispatcherTimer;
import de.esolutions.fw.util.commons.Buffer;

class DispatcherTimer$2
implements Runnable {
    private final String tag;
    private final /* synthetic */ DispatcherTimer this$0;

    DispatcherTimer$2(DispatcherTimer dispatcherTimer) {
        this.this$0 = dispatcherTimer;
        this.tag = new Buffer().append("DispatcherTimer[").append(DispatcherTimer.access$100(this.this$0)).append(" in ").append(DispatcherTimer.access$200(this.this$0)).append(" ms]").append(DispatcherTimer.access$000(this.this$0)).append(".fireTimer()").toString();
    }

    @Override
    public void run() {
        DispatcherTimer.access$302(this.this$0, null);
        DispatcherTimer.access$000(this.this$0).fireTimer();
        if (!DispatcherTimer.access$400(this.this$0)) {
            DispatcherTimer.access$500(this.this$0);
        }
    }

    public String toString() {
        return this.tag;
    }
}

