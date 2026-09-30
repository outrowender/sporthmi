/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.MonoTimerTask;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import java.util.Date;

public class MonoTimer {
    private static long timerId;
    private final TimerImpl impl;

    private static synchronized long nextId() {
        return timerId++;
    }

    public MonoTimer(String string, boolean bl) {
        if (string == null) {
            throw new NullPointerException("name == null");
        }
        this.impl = new TimerImpl(string, bl);
    }

    public MonoTimer(String string) {
        this(string, false);
    }

    public MonoTimer(boolean bl) {
        this("MonoTimer-" + MonoTimer.nextId(), bl);
    }

    public MonoTimer() {
        this(false);
    }

    public void cancel() {
        this.impl.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int purge() {
        TimerImpl timerImpl = this.impl;
        synchronized (timerImpl) {
            return this.impl.purge();
        }
    }

    public void schedule(MonoTimerTask monoTimerTask, Date date) {
        if (date.getTime() < 0L) {
            throw new IllegalArgumentException("when < 0: " + date.getTime());
        }
        long l = date.getTime() - TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
        this.scheduleImpl(monoTimerTask, l < 0L ? 0L : l, -1L, false);
    }

    public void schedule(MonoTimerTask monoTimerTask, long l) {
        if (l < 0L) {
            throw new IllegalArgumentException("delay < 0: " + l);
        }
        this.scheduleImpl(monoTimerTask, l, -1L, false);
    }

    public void schedule(MonoTimerTask monoTimerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(monoTimerTask, l, l2, false);
    }

    public void schedule(MonoTimerTask monoTimerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
        this.scheduleImpl(monoTimerTask, l2 < 0L ? 0L : l2, l, false);
    }

    public void scheduleAtFixedRate(MonoTimerTask monoTimerTask, long l, long l2) {
        if (l < 0L || l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        this.scheduleImpl(monoTimerTask, l, l2, true);
    }

    public void scheduleAtFixedRate(MonoTimerTask monoTimerTask, Date date, long l) {
        if (l <= 0L || date.getTime() < 0L) {
            throw new IllegalArgumentException();
        }
        long l2 = date.getTime() - TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
        this.scheduleImpl(monoTimerTask, l2, l, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void scheduleImpl(MonoTimerTask monoTimerTask, long l, long l2, boolean bl) {
        TimerImpl timerImpl = this.impl;
        synchronized (timerImpl) {
            if (this.impl.cancelled) {
                throw new IllegalStateException("Timer was canceled");
            }
            long l3 = l + TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
            if (l3 < 0L) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + l3);
            }
            Object object = monoTimerTask.lock;
            synchronized (object) {
                if (monoTimerTask.isScheduled()) {
                    throw new IllegalStateException("TimerTask is scheduled already");
                }
                if (monoTimerTask.cancelled) {
                    throw new IllegalStateException("TimerTask is canceled");
                }
                monoTimerTask.when = l3;
                monoTimerTask.period = l2;
                monoTimerTask.fixedRate = bl;
            }
            this.impl.insertTask(monoTimerTask);
        }
    }

    private static final class TimerImpl
    extends Thread {
        private boolean cancelled;
        private boolean finished;
        private TimerHeap tasks = new TimerHeap();

        TimerImpl(String string, boolean bl) {
            this.setName(string);
            this.setDaemon(bl);
            this.start();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            while (true) {
                MonoTimerTask monoTimerTask;
                TimerImpl timerImpl = this;
                synchronized (timerImpl) {
                    long l;
                    if (this.cancelled) {
                        return;
                    }
                    if (this.tasks.isEmpty()) {
                        if (this.finished) {
                            return;
                        }
                        try {
                            this.wait();
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        continue;
                    }
                    long l2 = TimeSourceProvider.getMonotonicTimeSource().getCurrentTime();
                    monoTimerTask = this.tasks.minimum();
                    Object object = monoTimerTask.lock;
                    synchronized (object) {
                        if (monoTimerTask.cancelled) {
                            this.tasks.delete(0);
                            continue;
                        }
                        l = monoTimerTask.when - l2;
                    }
                    if (l > 0L) {
                        try {
                            this.wait(l);
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        continue;
                    }
                    object = monoTimerTask.lock;
                    synchronized (object) {
                        int n = 0;
                        if (this.tasks.minimum().when != monoTimerTask.when) {
                            n = this.tasks.getTask(monoTimerTask);
                        }
                        if (monoTimerTask.cancelled) {
                            this.tasks.delete(this.tasks.getTask(monoTimerTask));
                            continue;
                        }
                        monoTimerTask.setScheduledTime(monoTimerTask.when);
                        this.tasks.delete(n);
                        if (monoTimerTask.period >= 0L) {
                            monoTimerTask.when = monoTimerTask.fixedRate ? (monoTimerTask.when += monoTimerTask.period) : TimeSourceProvider.getMonotonicTimeSource().getCurrentTime() + monoTimerTask.period;
                            this.insertTask(monoTimerTask);
                        } else {
                            monoTimerTask.when = 0L;
                        }
                    }
                }
                boolean bl = false;
                try {
                    monoTimerTask.run();
                    bl = true;
                    continue;
                }
                finally {
                    if (bl) continue;
                    TimerImpl timerImpl2 = this;
                    synchronized (timerImpl2) {
                        this.cancelled = true;
                    }
                    continue;
                }
                break;
            }
        }

        private void insertTask(MonoTimerTask monoTimerTask) {
            this.tasks.insert(monoTimerTask);
            this.notify();
        }

        public synchronized void cancel() {
            this.cancelled = true;
            this.tasks.reset();
            this.notify();
        }

        public int purge() {
            if (this.tasks.isEmpty()) {
                return 0;
            }
            this.tasks.deletedCancelledNumber = 0;
            this.tasks.deleteIfCancelled();
            return this.tasks.deletedCancelledNumber;
        }

        private static final class TimerHeap {
            private int DEFAULT_HEAP_SIZE = 256;
            private MonoTimerTask[] timers = new MonoTimerTask[this.DEFAULT_HEAP_SIZE];
            private int size = 0;
            private int deletedCancelledNumber = 0;

            private TimerHeap() {
            }

            public MonoTimerTask minimum() {
                return this.timers[0];
            }

            public boolean isEmpty() {
                return this.size == 0;
            }

            public void insert(MonoTimerTask monoTimerTask) {
                if (this.timers.length == this.size) {
                    MonoTimerTask[] monoTimerTaskArray = new MonoTimerTask[this.size * 2];
                    System.arraycopy((Object)this.timers, 0, (Object)monoTimerTaskArray, 0, this.size);
                    this.timers = monoTimerTaskArray;
                }
                this.timers[this.size++] = monoTimerTask;
                this.upHeap();
            }

            public void delete(int n) {
                if (n >= 0 && n < this.size) {
                    this.timers[n] = this.timers[--this.size];
                    this.timers[this.size] = null;
                    this.downHeap(n);
                }
            }

            private void upHeap() {
                int n = this.size - 1;
                int n2 = (n - 1) / 2;
                while (this.timers[n].when < this.timers[n2].when) {
                    MonoTimerTask monoTimerTask = this.timers[n];
                    this.timers[n] = this.timers[n2];
                    this.timers[n2] = monoTimerTask;
                    n = n2;
                    n2 = (n - 1) / 2;
                }
            }

            private void downHeap(int n) {
                int n2 = n;
                int n3 = 2 * n2 + 1;
                while (n3 < this.size && this.size > 0) {
                    if (n3 + 1 < this.size && this.timers[n3 + 1].when < this.timers[n3].when) {
                        ++n3;
                    }
                    if (this.timers[n2].when < this.timers[n3].when) break;
                    MonoTimerTask monoTimerTask = this.timers[n2];
                    this.timers[n2] = this.timers[n3];
                    this.timers[n3] = monoTimerTask;
                    n2 = n3;
                    n3 = 2 * n2 + 1;
                }
            }

            public void reset() {
                this.timers = new MonoTimerTask[this.DEFAULT_HEAP_SIZE];
                this.size = 0;
            }

            public void deleteIfCancelled() {
                for (int i2 = 0; i2 < this.size; ++i2) {
                    if (!this.timers[i2].cancelled) continue;
                    ++this.deletedCancelledNumber;
                    this.delete(i2);
                    --i2;
                }
            }

            private int getTask(MonoTimerTask monoTimerTask) {
                for (int i2 = 0; i2 < this.timers.length; ++i2) {
                    if (this.timers[i2] != monoTimerTask) continue;
                    return i2;
                }
                return -1;
            }
        }
    }
}

