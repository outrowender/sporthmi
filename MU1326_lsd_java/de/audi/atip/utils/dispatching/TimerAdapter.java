/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.ITimer;
import de.audi.atip.utils.dispatching.ITimerListener;
import de.audi.atip.utils.dispatching.TimerAdapter$ListenerAdapter;

public class TimerAdapter
implements ITimer {
    private final Timer timer;

    public TimerAdapter(String string, long l, boolean bl, ITimerListener iTimerListener) {
        this.timer = new Timer(string, l, bl, new TimerAdapter$ListenerAdapter(this, (ITimerListener)Preconditions.checkNotNull((Object)iTimerListener)));
    }

    public TimerAdapter(String string, int n, LogChannel logChannel, TimerListener timerListener, long l, boolean bl) {
        this.timer = new Timer(string, n, logChannel, timerListener, l, bl);
    }

    @Override
    public void start() {
        this.timer.start();
    }

    @Override
    public void restart() {
        this.timer.restart();
    }

    @Override
    public boolean cancel() {
        return this.timer.cancel();
    }

    @Override
    public boolean isRunning() {
        return this.timer.isRunning();
    }
}

