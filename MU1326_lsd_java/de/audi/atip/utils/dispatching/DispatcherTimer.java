/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.ITimer;
import de.audi.atip.utils.dispatching.ITimerListener;
import de.esolutions.fw.util.commons.Buffer;

public class DispatcherTimer
implements ITimer {
    private final ITimerListener listener;
    private final long delay;
    private final String name;
    private final boolean singleshot;
    private final IDispatcher dispatcher;
    private volatile IDispatcher.ICancelable delayedJob;

    public DispatcherTimer(IDispatcher iDispatcher, String string, int n, boolean bl, ITimerListener iTimerListener) {
        Preconditions.checkArgument(n > 0, "delay must be a positive number");
        Preconditions.checkArgument(string != null && string.length() > 0, "name must be a non-empty string");
        this.listener = Preconditions.checkNotNull(iTimerListener);
        this.name = Preconditions.checkNotNull(string);
        this.dispatcher = Preconditions.checkNotNull(iDispatcher);
        this.delay = n;
        this.singleshot = bl;
    }

    public void start() {
        this.rescheduleDelayedJob();
    }

    public void restart() {
        this.rescheduleDelayedJob();
    }

    public boolean cancel() {
        boolean bl = this.cancelJob();
        if (bl) {
            this.dispatcher.execute(new Runnable(){
                private final String tag;
                {
                    this.tag = new Buffer().append("DispatcherTimer[").append(DispatcherTimer.this.name).append("]").append(DispatcherTimer.this.listener).append(".cancelTimer()").toString();
                }

                public void run() {
                    DispatcherTimer.this.listener.cancelTimer();
                }

                public String toString() {
                    return this.tag;
                }
            });
        }
        return bl;
    }

    private void rescheduleDelayedJob() {
        this.cancelJob();
        this.delayedJob = this.dispatcher.execute(new Runnable(){
            private final String tag;
            {
                this.tag = new Buffer().append("DispatcherTimer[").append(DispatcherTimer.this.name).append(" in ").append(DispatcherTimer.this.delay).append(" ms]").append(DispatcherTimer.this.listener).append(".fireTimer()").toString();
            }

            public void run() {
                DispatcherTimer.this.delayedJob = null;
                DispatcherTimer.this.listener.fireTimer();
                if (!DispatcherTimer.this.singleshot) {
                    DispatcherTimer.this.rescheduleDelayedJob();
                }
            }

            public String toString() {
                return this.tag;
            }
        }, this.delay);
    }

    private boolean cancelJob() {
        if (this.delayedJob != null) {
            this.delayedJob.cancel();
            this.delayedJob = null;
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        return this.delayedJob != null;
    }

    public String toString() {
        return new StringBuffer().append("DispatcherTimer [delay=").append(this.delay).append(", name=").append(this.name).append(", singleshot=").append(this.singleshot).append(", isRunning()=").append(this.isRunning()).append("]").toString();
    }
}

