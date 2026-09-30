/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid.clock;

import org.apache.commons.id.uuid.clock.Clock;
import org.apache.commons.id.uuid.clock.OverClockedException;

public final class ThreadClockImpl
extends Thread
implements Clock {
    public static final long DEFAULT_THREAD_LIFE = 200L;
    private static long threadLife = 200L;
    private static ThreadClockImpl worker = null;
    private static long currentTimeMillis;
    private static long expires;
    private long lastTimeMs = 0L;
    private int generatedThisInterval;
    private static short sysInterval;
    static /* synthetic */ Class class$org$apache$commons$id$uuid$clock$ThreadClockImpl;
    static /* synthetic */ Class class$org$apache$commons$id$uuid$clock$SystemClockImpl;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ThreadClockImpl() {
        if (worker == null) {
            Class clazz = class$org$apache$commons$id$uuid$clock$ThreadClockImpl == null ? (class$org$apache$commons$id$uuid$clock$ThreadClockImpl = ThreadClockImpl.class$("org.apache.commons.id.uuid.clock.ThreadClockImpl")) : class$org$apache$commons$id$uuid$clock$ThreadClockImpl;
            synchronized (clazz) {
                worker = new ThreadClockImpl(true);
            }
        }
    }

    private ThreadClockImpl(boolean bl) {
        this.setDaemon(true);
        this.setPriority(10);
        currentTimeMillis = System.currentTimeMillis();
        this.generatedThisInterval = 0;
        this.start();
    }

    public static long getThreadLife() {
        return threadLife;
    }

    public static void setThreadLife(long l) {
        threadLife = l;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            while (--expires >= 0L) {
                ThreadClockImpl.sleep(sysInterval);
                Class clazz = class$org$apache$commons$id$uuid$clock$ThreadClockImpl == null ? ThreadClockImpl.class$("org.apache.commons.id.uuid.clock.ThreadClockImpl") : class$org$apache$commons$id$uuid$clock$ThreadClockImpl;
                synchronized (clazz) {
                    currentTimeMillis += (long)sysInterval;
                }
            }
            return;
        }
        catch (InterruptedException interruptedException) {
            System.out.println("Clock thread interrupted");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private synchronized long getTimeSynchronized() throws OverClockedException {
        long l = 0L;
        Class clazz = class$org$apache$commons$id$uuid$clock$ThreadClockImpl == null ? (class$org$apache$commons$id$uuid$clock$ThreadClockImpl = ThreadClockImpl.class$("org.apache.commons.id.uuid.clock.ThreadClockImpl")) : class$org$apache$commons$id$uuid$clock$ThreadClockImpl;
        synchronized (clazz) {
            l = currentTimeMillis;
        }
        if (l != this.lastTimeMs) {
            this.generatedThisInterval = 0;
            this.lastTimeMs = l;
        }
        if ((long)(this.generatedThisInterval + 1) >= 10000L * (long)sysInterval) {
            throw new OverClockedException();
        }
        return (l + 12219292800000L) * 10000L + (long)this.generatedThisInterval++;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long getUUIDTime() throws OverClockedException {
        if (!worker.isAlive()) {
            Class clazz = class$org$apache$commons$id$uuid$clock$SystemClockImpl == null ? (class$org$apache$commons$id$uuid$clock$SystemClockImpl = ThreadClockImpl.class$("org.apache.commons.id.uuid.clock.SystemClockImpl")) : class$org$apache$commons$id$uuid$clock$SystemClockImpl;
            synchronized (clazz) {
                currentTimeMillis = System.currentTimeMillis();
                worker.start();
            }
            this.generatedThisInterval = 0;
        }
        return this.getTimeSynchronized();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    static {
        expires = threadLife;
        sysInterval = 1;
        if (System.getProperty("os.name").indexOf("Windows") != -1) {
            sysInterval = (short)10;
        }
    }
}

