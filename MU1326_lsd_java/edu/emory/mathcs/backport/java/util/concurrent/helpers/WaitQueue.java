/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.util.Collection;

public abstract class WaitQueue {
    public abstract void insert(WaitNode var1);

    public abstract WaitNode extract();

    public abstract void putBack(WaitNode var1);

    public abstract boolean hasNodes();

    public abstract int getLength();

    public abstract Collection getWaitingThreads();

    public abstract boolean isWaiting(Thread var1);

    public static class WaitNode {
        boolean waiting = true;
        WaitNode next = null;
        final Thread owner = Thread.currentThread();

        public Thread getOwner() {
            return this.owner;
        }

        public synchronized boolean signal(QueuedSync queuedSync) {
            boolean bl = this.waiting;
            if (bl) {
                this.waiting = false;
                this.notify();
                queuedSync.takeOver(this);
            }
            return bl;
        }

        public synchronized boolean doTimedWait(QueuedSync queuedSync, long l) throws InterruptedException {
            if (queuedSync.recheck(this) || !this.waiting) {
                return true;
            }
            if (l <= 0L) {
                this.waiting = false;
                return false;
            }
            long l2 = Utils.nanoTime() + l;
            try {
                do {
                    TimeUnit.NANOSECONDS.timedWait(this, l);
                    if (this.waiting) continue;
                    return true;
                } while ((l = l2 - Utils.nanoTime()) > 0L);
                this.waiting = false;
                return false;
            }
            catch (InterruptedException interruptedException) {
                if (this.waiting) {
                    this.waiting = false;
                    throw interruptedException;
                }
                Thread.currentThread().interrupt();
                return true;
            }
        }

        public synchronized void doWait(QueuedSync queuedSync) throws InterruptedException {
            if (!queuedSync.recheck(this)) {
                try {
                    while (this.waiting) {
                        this.wait();
                    }
                }
                catch (InterruptedException interruptedException) {
                    if (this.waiting) {
                        this.waiting = false;
                        throw interruptedException;
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public synchronized void doWaitUninterruptibly(QueuedSync queuedSync) {
            if (!queuedSync.recheck(this)) {
                boolean bl = Thread.interrupted();
                try {
                    while (this.waiting) {
                        try {
                            this.wait();
                        }
                        catch (InterruptedException interruptedException) {
                            bl = true;
                        }
                    }
                }
                finally {
                    if (bl) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static interface QueuedSync {
        public boolean recheck(WaitNode var1);

        public void takeOver(WaitNode var1);
    }
}

