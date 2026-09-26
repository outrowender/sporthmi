/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.atip.utils.dispatching.ITimerListener;
import de.audi.atip.utils.dispatching.TimerAdapter;

class TimerAdapter$ListenerAdapter
implements TimerListener {
    private ITimerListener listener;
    private final /* synthetic */ TimerAdapter this$0;

    TimerAdapter$ListenerAdapter(TimerAdapter timerAdapter, ITimerListener iTimerListener) {
        this.this$0 = timerAdapter;
        this.listener = iTimerListener;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.listener.fireTimer();
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.listener.cancelTimer();
    }
}

