/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.ITimeOutHandler;
import de.esolutions.fw.util.commons.timeout.MonoTimer;
import de.esolutions.fw.util.commons.timeout.MonoTimerTask;

public class TimeOutTimer {
    private static Object timerLock = new Object();
    private static MonoTimer timer = null;
    private static int timerUsers = 0;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TimeOutTimer() {
        Object object = timerLock;
        synchronized (object) {
            if (timerUsers == 0) {
                timer = new MonoTimer();
            }
            ++timerUsers;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancel() {
        Object object = timerLock;
        synchronized (object) {
            if (--timerUsers == 0) {
                timer.cancel();
                timer = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TimeOutTask schedule(ITimeOutHandler iTimeOutHandler, long l) {
        TimeOutTask timeOutTask = new TimeOutTask(Thread.currentThread(), iTimeOutHandler);
        Object object = timerLock;
        synchronized (object) {
            if (timer != null) {
                timer.schedule((MonoTimerTask)timeOutTask, l);
            }
        }
        return timeOutTask;
    }

    public static class TimeOutTask
    extends MonoTimerTask {
        private final Thread thread;
        private final ITimeOutHandler handler;
        private boolean armed;

        public TimeOutTask(Thread thread, ITimeOutHandler iTimeOutHandler) {
            this.thread = thread;
            this.handler = iTimeOutHandler;
            this.armed = true;
        }

        public void disarm() {
            this.armed = false;
            this.cancel();
        }

        public void run() {
            if (this.armed) {
                this.handler.timeoutOccurred(this.thread);
            }
        }
    }
}

