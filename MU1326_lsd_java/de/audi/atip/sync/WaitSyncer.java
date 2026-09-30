/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sync;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sync.IWaitSyncer;
import de.esolutions.fw.util.commons.Buffer;

public class WaitSyncer
implements IWaitSyncer {
    private final IFrameworkAccess frameworkAccess;
    private final String name;
    private final long timeout;
    private final LogChannel log;
    private final Object monitor = new Object();
    private boolean waiting;
    private boolean triggered;
    private boolean canceled;

    public WaitSyncer(IFrameworkAccess iFrameworkAccess, String string, long l, LogChannel logChannel) {
        this.frameworkAccess = iFrameworkAccess;
        this.name = string;
        this.timeout = l <= 0L ? 1L : l;
        this.log = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isTriggered() {
        boolean bl;
        Object object = this.monitor;
        synchronized (object) {
            bl = this.triggered;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isWaiting() {
        boolean bl;
        Object object = this.monitor;
        synchronized (object) {
            bl = this.waiting;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void waitForTrigger() {
        this.log.log(1000000, "WaitSyncer[%1]: waitForTrigger()", (Object)this.name);
        Object object = this.monitor;
        synchronized (object) {
            if (!this.waiting) {
                this.waiting = true;
                long l = this.getMonotonicTime();
                if (!this.triggered && !this.canceled) {
                    try {
                        this.monitor.wait(this.timeout);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                }
                long l2 = this.getMonotonicTime() - l;
                Buffer buffer = new Buffer();
                if (this.triggered) {
                    buffer.append("triggered after ");
                    buffer.append(l2);
                    buffer.append(" ms");
                } else if (this.canceled) {
                    buffer.append("canceled after ");
                    buffer.append(l2);
                    buffer.append(" ms");
                } else if (l2 >= this.timeout) {
                    buffer.append("timed out after ");
                    buffer.append(l2);
                    buffer.append(" ms");
                } else {
                    buffer.append("unexpected finish after ");
                    buffer.append(l2);
                    buffer.append(" ms");
                }
                this.log.log(1000000, "WaitSyncer[%1]#waitForTrigger: %2", (Object)this.name, (Object)buffer);
            } else {
                this.log.log(10000000, "WaitSyncer[%1]#waitForTrigger: already waiting --> NOP!", (Object)this.name);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void trigger() {
        this.log.log(1000000, "WaitSyncer[%1]: trigger()", (Object)this.name);
        Object object = this.monitor;
        synchronized (object) {
            this.triggered = true;
            if (this.waiting) {
                this.monitor.notifyAll();
                this.waiting = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancel() {
        this.log.log(1000000, "WaitSyncer[%1]: cancel()", (Object)this.name);
        Object object = this.monitor;
        synchronized (object) {
            this.canceled = true;
            if (this.waiting) {
                this.monitor.notifyAll();
                this.waiting = false;
            }
        }
    }

    private long getMonotonicTime() {
        return this.frameworkAccess.getMonotonicTime();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Buffer buffer = new Buffer();
        Object object = this.monitor;
        synchronized (object) {
            buffer.append("WaitSyncer(name=").append(this.name);
            buffer.append(",timeout=").append(this.timeout);
            if (this.waiting) {
                buffer.append(",waiting");
            }
            if (this.triggered) {
                buffer.append(",triggered");
            }
            buffer.append(")");
        }
        return buffer.toString();
    }
}

