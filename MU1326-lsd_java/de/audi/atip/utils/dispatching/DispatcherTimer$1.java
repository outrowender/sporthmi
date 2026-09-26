/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.DispatcherTimer;
import de.esolutions.fw.util.commons.Buffer;

class DispatcherTimer$1
implements Runnable {
    private final String tag;
    private final /* synthetic */ DispatcherTimer this$0;

    DispatcherTimer$1(DispatcherTimer dispatcherTimer) {
        this.this$0 = dispatcherTimer;
        this.tag = new Buffer().append("DispatcherTimer[").append(DispatcherTimer.access$100(this.this$0)).append("]").append(DispatcherTimer.access$000(this.this$0)).append(".cancelTimer()").toString();
    }

    @Override
    public void run() {
        DispatcherTimer.access$000(this.this$0).cancelTimer();
    }

    public String toString() {
        return this.tag;
    }
}

