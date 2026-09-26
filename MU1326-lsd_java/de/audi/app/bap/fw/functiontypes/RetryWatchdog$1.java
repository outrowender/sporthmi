/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.RetryWatchdog;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class RetryWatchdog$1
implements TimerListener {
    private final /* synthetic */ RetryWatchdog this$0;

    RetryWatchdog$1(RetryWatchdog retryWatchdog) {
        this.this$0 = retryWatchdog;
    }

    @Override
    public void fireTimer(Timer timer) {
        RetryWatchdog.access$000(this.this$0);
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

