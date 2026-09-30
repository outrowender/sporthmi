/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.locks;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.FIFOWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.locks.CondVar;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

class FIFOCondVar
extends CondVar
implements Condition,
Serializable {
    private static final WaitQueue.QueuedSync sync = new WaitQueue.QueuedSync(){

        public boolean recheck(WaitQueue.WaitNode waitNode) {
            return false;
        }

        public void takeOver(WaitQueue.WaitNode waitNode) {
        }
    };
    private final WaitQueue wq = new FIFOWaitQueue();

    FIFOCondVar(CondVar.ExclusiveLock exclusiveLock) {
        super(exclusiveLock);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void awaitUninterruptibly() {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        WaitQueue.WaitNode waitNode = new WaitQueue.WaitNode();
        this.wq.insert(waitNode);
        for (int i2 = n; i2 > 0; --i2) {
            this.lock.unlock();
        }
        try {
            waitNode.doWaitUninterruptibly(sync);
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
    public void await() throws InterruptedException {
        int n = this.lock.getHoldCount();
        if (n == 0) {
            throw new IllegalMonitorStateException();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        WaitQueue.WaitNode waitNode = new WaitQueue.WaitNode();
        this.wq.insert(waitNode);
        for (int i2 = n; i2 > 0; --i2) {
            this.lock.unlock();
        }
        try {
            waitNode.doWait(sync);
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
        WaitQueue.WaitNode waitNode = new WaitQueue.WaitNode();
        this.wq.insert(waitNode);
        boolean bl = false;
        for (int i2 = n; i2 > 0; --i2) {
            this.lock.unlock();
        }
        try {
            bl = waitNode.doTimedWait(sync, l2);
        }
        finally {
            for (int i3 = n; i3 > 0; --i3) {
                this.lock.lock();
            }
        }
        return bl;
    }

    public boolean awaitUntil(Date date) throws InterruptedException {
        if (date == null) {
            throw new NullPointerException();
        }
        long l = date.getTime();
        long l2 = System.currentTimeMillis();
        long l3 = l - l2;
        return this.await(l3, TimeUnit.MILLISECONDS);
    }

    public void signal() {
        WaitQueue.WaitNode waitNode;
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        do {
            if ((waitNode = this.wq.extract()) != null) continue;
            return;
        } while (!waitNode.signal(sync));
    }

    public void signalAll() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        WaitQueue.WaitNode waitNode;
        while ((waitNode = this.wq.extract()) != null) {
            waitNode.signal(sync);
        }
        return;
    }

    protected boolean hasWaiters() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.wq.hasNodes();
    }

    protected int getWaitQueueLength() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.wq.getLength();
    }

    protected Collection getWaitingThreads() {
        if (!this.lock.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        return this.wq.getWaitingThreads();
    }
}

