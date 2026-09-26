/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.StartupManager;
import de.esolutions.fw.util.commons.Buffer;

final class StartupSyncer {
    private final StartupManager startupManager;
    private final LogChannel logStartup;
    private final long timeout;
    private long timeleft;
    private final String name;
    private volatile boolean waiting;
    private volatile boolean triggered;

    StartupSyncer(StartupManager startupManager, String string, long l, LogChannel logChannel) {
        this.startupManager = startupManager;
        this.name = string;
        this.timeleft = this.timeout = l <= 0L ? 1L : l;
        this.logStartup = logChannel;
    }

    private long getMonotonicTime() {
        return this.startupManager.getFramework().getMonotonicTime();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("StartupSyncer(name=").append(this.name);
        buffer.append(",timeout=").append(this.timeout);
        buffer.append(",timeleft=").append(this.timeleft);
        if (this.waiting) {
            buffer.append(",waiting");
        }
        if (this.triggered) {
            buffer.append(",triggered");
        }
        buffer.append(")");
        return buffer.toString();
    }

    synchronized void setupWait() {
        this.waiting = true;
        this.timeleft = this.timeout;
    }

    synchronized boolean isTriggered() {
        return this.triggered;
    }

    synchronized boolean isWaiting() {
        return this.waiting;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void waitForTrigger() {
        this.logStartup.log(1078071040, "StartupSyncer[%1]: waitForTrigger()", (Object)this.name);
        StartupSyncer startupSyncer = this;
        synchronized (startupSyncer) {
            if (this.waiting) {
                if (!this.triggered && this.timeleft > 0L) {
                    long l = this.getMonotonicTime();
                    try {
                        super.wait(this.timeleft);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                    this.timeleft -= this.getMonotonicTime() - l;
                }
                if (this.timeleft <= 0L) {
                    this.waiting = false;
                }
                String string = this.triggered ? "was triggered" : (this.timeleft <= 0L ? "timed out" : "wake up to early");
                this.logStartup.log(1078071040, "StartupSyncer[%1]: %2", (Object)this.name, (Object)string);
            } else {
                this.logStartup.log(-2137614336, "StartupSyncer[%1]: no waiting initialized!", (Object)this.name);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void trigger() {
        this.logStartup.log(1078071040, "StartupSyncer[%1]: trigger()", (Object)this.name);
        StartupSyncer startupSyncer = this;
        synchronized (startupSyncer) {
            this.triggered = true;
            if (this.waiting) {
                super.notifyAll();
                this.waiting = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void cancel() {
        this.logStartup.log(1078071040, "StartupSyncer[%1]: cancel()", (Object)this.name);
        StartupSyncer startupSyncer = this;
        synchronized (startupSyncer) {
            if (this.waiting) {
                super.notifyAll();
                this.waiting = false;
            }
        }
    }
}

