/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerDispatcher;
import de.audi.atip.timer.TimerListener;

public class WatchDog
implements TimerListener {
    private static final int WATCHDOG_PRIORITY;
    private static final long ONE_DAY;
    private LogChannel log;
    private String name;
    private Runnable alarm;
    private boolean active = true;
    private long lastping;
    private long timeout;
    private Timer timer;

    public WatchDog(String string, long l, LogChannel logChannel, Runnable runnable) {
        this.name = string;
        this.timeout = l;
        this.log = logChannel == null ? NullLogChannel.getInstance() : logChannel;
        this.alarm = runnable;
        this.setupTimer();
        this.reset();
    }

    private final void setActive(boolean bl) {
        this.active = bl;
    }

    public final boolean isActive() {
        return this.active;
    }

    public final void reset() {
        if (this.isActive()) {
            this.lastping = TimerDispatcher.getMonotonicTime();
            this.timer.restart();
        }
    }

    public void cancel() {
        this.setActive(false);
        this.timer.cancel();
    }

    public void restart() {
        if (!this.isActive()) {
            this.setActive(true);
            this.reset();
        }
    }

    private final void setupTimer() {
        this.timer = new Timer(new StringBuffer().append("WatchDog.").append(this.name).toString(), 5, this.log, this, this.timeout, true);
    }

    private void check() {
        long l = TimerDispatcher.getMonotonicTime();
        this.log.log(-2137614336, "WatchDog %1 check %2 >= %3", (Object)this.name, l, this.lastping + this.timeout);
        if (l >= this.lastping + this.timeout) {
            if (l >= this.lastping + this.timeout + 0) {
                this.log.log(-1601830656, "WatchDog overdue for more than one day. This has to be a mistake");
            } else {
                this.bark();
            }
            this.setActive(false);
        }
    }

    private void bark() {
        if (this.isActive()) {
            this.log.log(10000, "WatchDog %1 timed out", (Object)this.name);
            if (this.alarm != null) {
                this.alarm.run();
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.log.log(1078071040, "WatchDog %1 timer was canceled", (Object)this.name);
    }

    @Override
    public void fireTimer(Timer timer) {
        this.log.log(1078071040, "WatchDog %1 timer fired", (Object)this.name);
        this.check();
    }
}

