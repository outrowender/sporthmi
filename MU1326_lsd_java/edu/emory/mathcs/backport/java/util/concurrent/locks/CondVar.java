/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Lock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

class CondVar
implements Condition,
Serializable {
    protected final ExclusiveLock lock;

    CondVar(ExclusiveLock exclusiveLock) {
        this.lock = exclusiveLock;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void awaitUninterruptibly() {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        boolean bl = Thread.interrupted();
        try {
            CondVar condVar = this;
            synchronized (condVar) {
                for (int i2 = n; i2 > 0; --i2) {
                    this.lock.unlock();
                }
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    bl = true;
                }
            }
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
            if (bl) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void await() throws InterruptedException {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        try {
            CondVar condVar = this;
            synchronized (condVar) {
                for (int i2 = n; i2 > 0; --i2) {
                    this.lock.unlock();
                }
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    this.notify();
                    throw interruptedException;
                }
            }
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean await(long l, TimeUnit timeUnit) throws InterruptedException {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        long l2 = timeUnit.toNanos(l);
        boolean bl = false;
        try {
            CondVar condVar = this;
            synchronized (condVar) {
                for (int i2 = n; i2 > 0; --i2) {
                    this.lock.unlock();
                }
                try {
                    if (l2 > 0L) {
                        long l3 = Utils.nanoTime();
                        TimeUnit.NANOSECONDS.timedWait(this, l2);
                        bl = Utils.nanoTime() - l3 < l2;
                    }
                }
                catch (InterruptedException interruptedException) {
                    this.notify();
                    throw interruptedException;
                }
            }
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean awaitUntil(Date date) throws InterruptedException {
        if (date == null) {
            throw new NullPointerException();
        }
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        long l = date.getTime();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        boolean bl = false;
        try {
            CondVar condVar = this;
            synchronized (condVar) {
                for (int i2 = n; i2 > 0; --i2) {
                    this.lock.unlock();
                }
                try {
                    long l2 = System.currentTimeMillis();
                    long l3 = l - l2;
                    if (l3 > 0L) {
                        this.wait(l3);
                        bl = System.currentTimeMillis() - l2 < l3;
                    }
                }
                catch (InterruptedException interruptedException) {
                    this.notify();
                    throw interruptedException;
                }
            }
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
        return bl;
    }

    public synchronized void signal() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        this.notify();
    }

    public synchronized void signalAll() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        this.notifyAll();
    }

    protected ExclusiveLock getLock() {
        return this.lock;
    }

    protected boolean hasWaiters() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    protected int getWaitQueueLength() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    protected Collection getWaitingThreads() {
        throw new UnsupportedOperationException("Use FAIR version");
    }

    static interface ExclusiveLock
    extends Lock {
        public boolean isHeldByCurrentThread();

        public int getHoldCount();
    }
}

