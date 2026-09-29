/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.TimerDispatcher;
import de.audi.atip.timer.TimerJobQueue;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.Job;

public class Timer
implements Runnable {
    public static final int DEFAULT_PRIORITY;
    private String name;
    private LogChannel log;
    private long due;
    private long delay;
    private boolean singleshot = true;
    private int prio;
    private TimerListener receiver;
    TimerJobQueue parent = null;
    private Buffer debugInfo;

    public Timer(String string, int n, LogChannel logChannel, TimerListener timerListener, long l, boolean bl) {
        this.init(string, n, logChannel, timerListener, l, bl);
    }

    public Timer(String string, long l, boolean bl, TimerListener timerListener) {
        this.init(string, 5, TimerDispatcher.defaultLog, timerListener, l, bl);
    }

    private void init(String string, int n, LogChannel logChannel, TimerListener timerListener, long l, boolean bl) {
        this.log = logChannel;
        this.setName(string);
        this.setPriority(n);
        this.setTimerListener(timerListener);
        this.setDelay(l);
        this.singleshot = bl;
        this.parent = null;
    }

    public void start() {
        this.doStart();
    }

    public synchronized void restart() {
        this.doCancel();
        this.doStart();
    }

    public boolean cancel() {
        if (this.doCancel()) {
            this.receiver.cancelTimer(this);
            if (this.log != null) {
                this.log.log(-2137614336, "canceled %1", (Object)this);
            }
            return true;
        }
        return false;
    }

    public boolean isCanceled() {
        return null == this.parent;
    }

    public boolean isRunning() {
        return null != this.parent;
    }

    public long getDelay() {
        return this.delay;
    }

    public void setDelay(long l) {
        if (l <= 0L) {
            throw new IllegalArgumentException();
        }
        this.delay = l;
    }

    public void setTimerListener(TimerListener timerListener) {
        if (timerListener == null) {
            throw new IllegalArgumentException();
        }
        this.receiver = timerListener;
    }

    public TimerListener getTimerListener() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.name = string;
    }

    public void setPriority(int n) {
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException();
        }
        this.prio = n;
    }

    public int getPriority() {
        return this.prio;
    }

    @Override
    public void run() {
        block5: {
            if (null != this.log) {
                this.log.log(-2137614336, "%1 trigger event", (Object)this);
            }
            try {
                if (this.receiver != null) {
                    this.receiver.fireTimer(this);
                }
            }
            catch (Exception exception) {
                if (null == this.log) break block5;
                this.log.log(10000, "Exception:", (Throwable)exception);
            }
        }
        if (null != this.log) {
            this.log.log(-2137614336, "%1 finished", (Object)this);
        }
    }

    public void setDebugInfo(Buffer buffer) {
        this.debugInfo = buffer;
    }

    public String toString() {
        return this.name;
    }

    long getDue() {
        return this.due;
    }

    void setDue(long l) {
        if (l <= 0L) {
            throw new IllegalArgumentException();
        }
        this.due = l;
    }

    boolean isSingleShot() {
        return this.singleshot;
    }

    TimerJobQueue getParent() {
        return this.parent;
    }

    void setParent(TimerJobQueue timerJobQueue) {
        this.parent = timerJobQueue;
    }

    private void doStart() {
        TimerDispatcher timerDispatcher = TimerDispatcher.getForPriority(this.getPriority());
        timerDispatcher.getQueue().enqueue(new Job(this));
    }

    private boolean doCancel() {
        if (!this.isRunning()) {
            return false;
        }
        try {
            boolean bl = this.parent.cancelJob(this);
            return bl;
        }
        catch (NullPointerException nullPointerException) {
            if (this.log != null) {
                this.log.log(-2137614336, "cancelTimer %1 failed, canceled by other thread in parallel", (Object)this);
            }
            return false;
        }
    }
}

