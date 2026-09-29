/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

public class LSDWatchdog
implements Runnable {
    private static final boolean DEBUG;
    private final String name;
    private boolean active = true;
    private Object lock = new Object();
    private long alarmTimeout = Long.MAX_VALUE;
    private String alarmMsg = null;
    private Runnable alarmHandler = null;

    public LSDWatchdog(String string) {
        this.name = string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        long l;
        this.cancelAlarm();
        Object object = this.lock;
        synchronized (object) {
            l = this.alarmTimeout - System.currentTimeMillis();
        }
        while (this.active) {
            object = this.lock;
            synchronized (object) {
                try {
                    this.lock.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                l = this.alarmTimeout - System.currentTimeMillis();
                if (this.alarmMsg != null && l <= 0L) {
                    System.err.println(new StringBuffer().append(this.name).append(" WatchDog Alarm: ").append(this.alarmMsg).toString());
                    if (this.alarmHandler != null) {
                        this.alarmHandler.run();
                    }
                    this.cancelAlarm();
                    l = this.alarmTimeout - System.currentTimeMillis();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stop() {
        this.active = false;
        Object object = this.lock;
        synchronized (object) {
            this.lock.notifyAll();
        }
    }

    public void setAlarm(long l, String string, Runnable runnable) {
    }

    public void cancelAlarm() {
    }

    public static void startWatchdog(LSDWatchdog lSDWatchdog) {
    }
}

