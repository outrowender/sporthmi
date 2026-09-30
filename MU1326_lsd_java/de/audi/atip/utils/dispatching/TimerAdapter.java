/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.ITimer;
import de.audi.atip.utils.dispatching.ITimerListener;

public class TimerAdapter
implements ITimer {
    private final Timer timer;

    public TimerAdapter(String string, long l, boolean bl, ITimerListener iTimerListener) {
        this.timer = new Timer(string, l, bl, new ListenerAdapter(Preconditions.checkNotNull(iTimerListener)));
    }

    public TimerAdapter(String string, int n, LogChannel logChannel, TimerListener timerListener, long l, boolean bl) {
        this.timer = new Timer(string, n, logChannel, timerListener, l, bl);
    }

    public void start() {
        this.timer.start();
    }

    public void restart() {
        this.timer.restart();
    }

    public boolean cancel() {
        return this.timer.cancel();
    }

    public boolean isRunning() {
        return this.timer.isRunning();
    }

    private class ListenerAdapter
    implements TimerListener {
        private ITimerListener listener;

        ListenerAdapter(ITimerListener iTimerListener) {
            this.listener = iTimerListener;
        }

        public void fireTimer(Timer timer) {
            this.listener.fireTimer();
        }

        public void cancelTimer(Timer timer) {
            this.listener.cancelTimer();
        }
    }
}

