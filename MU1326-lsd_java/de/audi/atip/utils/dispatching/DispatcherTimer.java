/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.DispatcherTimer$1;
import de.audi.atip.utils.dispatching.DispatcherTimer$2;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.audi.atip.utils.dispatching.ITimer;
import de.audi.atip.utils.dispatching.ITimerListener;

public class DispatcherTimer
implements ITimer {
    private final ITimerListener listener;
    private final long delay;
    private final String name;
    private final boolean singleshot;
    private final IDispatcher dispatcher;
    private volatile IDispatcher$ICancelable delayedJob;

    public DispatcherTimer(IDispatcher iDispatcher, String string, int n, boolean bl, ITimerListener iTimerListener) {
        Preconditions.checkArgument((n > 0 ? 1 : 0) != 0, (Object)"delay must be a positive number");
        Preconditions.checkArgument((string != null && string.length() > 0 ? 1 : 0) != 0, (Object)"name must be a non-empty string");
        this.listener = (ITimerListener)Preconditions.checkNotNull((Object)iTimerListener);
        this.name = (String)Preconditions.checkNotNull((Object)string);
        this.dispatcher = (IDispatcher)Preconditions.checkNotNull((Object)iDispatcher);
        this.delay = n;
        this.singleshot = bl;
    }

    @Override
    public void start() {
        this.rescheduleDelayedJob();
    }

    @Override
    public void restart() {
        this.rescheduleDelayedJob();
    }

    @Override
    public boolean cancel() {
        boolean bl = this.cancelJob();
        if (bl) {
            this.dispatcher.execute(new DispatcherTimer$1(this));
        }
        return bl;
    }

    private void rescheduleDelayedJob() {
        this.cancelJob();
        this.delayedJob = this.dispatcher.execute(new DispatcherTimer$2(this), this.delay);
    }

    private boolean cancelJob() {
        if (this.delayedJob != null) {
            this.delayedJob.cancel();
            this.delayedJob = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean isRunning() {
        return this.delayedJob != null;
    }

    public String toString() {
        return new StringBuffer().append("DispatcherTimer [delay=").append(this.delay).append(", name=").append(this.name).append(", singleshot=").append(this.singleshot).append(", isRunning()=").append(this.isRunning()).append("]").toString();
    }

    static /* synthetic */ ITimerListener access$000(DispatcherTimer dispatcherTimer) {
        return dispatcherTimer.listener;
    }

    static /* synthetic */ String access$100(DispatcherTimer dispatcherTimer) {
        return dispatcherTimer.name;
    }

    static /* synthetic */ long access$200(DispatcherTimer dispatcherTimer) {
        return dispatcherTimer.delay;
    }

    static /* synthetic */ IDispatcher$ICancelable access$302(DispatcherTimer dispatcherTimer, IDispatcher$ICancelable iDispatcher$ICancelable) {
        dispatcherTimer.delayedJob = iDispatcher$ICancelable;
        return dispatcherTimer.delayedJob;
    }

    static /* synthetic */ boolean access$400(DispatcherTimer dispatcherTimer) {
        return dispatcherTimer.singleshot;
    }

    static /* synthetic */ void access$500(DispatcherTimer dispatcherTimer) {
        dispatcherTimer.rescheduleDelayedJob();
    }
}

