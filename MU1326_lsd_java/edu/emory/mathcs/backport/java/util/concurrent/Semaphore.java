/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.FIFOWaitQueue;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.WaitQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;

public class Semaphore
implements Serializable {
    private static final long serialVersionUID = -3222578661600680210L;
    private final Sync sync;

    public Semaphore(int n) {
        this.sync = new NonfairSync(n);
    }

    public Semaphore(int n, boolean bl) {
        this.sync = bl ? new FairSync(n) : new NonfairSync(n);
    }

    public void acquire() throws InterruptedException {
        this.sync.acquire(1);
    }

    public void acquireUninterruptibly() {
        this.sync.acquireUninterruptibly(1);
    }

    public boolean tryAcquire() {
        return this.sync.attempt(1);
    }

    public boolean tryAcquire(long l, TimeUnit timeUnit) throws InterruptedException {
        return this.sync.attempt(1, timeUnit.toNanos(l));
    }

    public void release() {
        this.sync.release(1);
    }

    public void acquire(int n) throws InterruptedException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.acquire(n);
    }

    public void acquireUninterruptibly(int n) {
        this.sync.acquireUninterruptibly(n);
    }

    public boolean tryAcquire(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        return this.sync.attempt(n);
    }

    public boolean tryAcquire(int n, long l, TimeUnit timeUnit) throws InterruptedException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        return this.sync.attempt(n, timeUnit.toNanos(l));
    }

    public void release(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.release(n);
    }

    public int availablePermits() {
        return this.sync.getPermits();
    }

    public int drainPermits() {
        return this.sync.drain();
    }

    protected void reducePermits(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.sync.reduce(n);
    }

    public boolean isFair() {
        return this.sync instanceof FairSync;
    }

    public final boolean hasQueuedThreads() {
        return this.sync.hasQueuedThreads();
    }

    public final int getQueueLength() {
        return this.sync.getQueueLength();
    }

    protected Collection getQueuedThreads() {
        return this.sync.getQueuedThreads();
    }

    public String toString() {
        return super.toString() + "[Permits = " + this.sync.getPermits() + "]";
    }

    static abstract class Sync
    implements Serializable {
        private static final long serialVersionUID = 1192457210091910933L;
        int permits_;

        protected Sync(int n) {
            this.permits_ = n;
        }

        abstract void acquireUninterruptibly(int var1);

        abstract void acquire(int var1) throws InterruptedException;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean attempt(int n) {
            Sync sync = this;
            synchronized (sync) {
                if (this.permits_ >= n) {
                    this.permits_ -= n;
                    return true;
                }
                return false;
            }
        }

        abstract boolean attempt(int var1, long var2) throws InterruptedException;

        abstract void release(int var1);

        public synchronized int getPermits() {
            return this.permits_;
        }

        public synchronized int drain() {
            int n = this.permits_;
            this.permits_ = 0;
            return n;
        }

        public synchronized void reduce(int n) {
            this.permits_ -= n;
        }

        abstract boolean hasQueuedThreads();

        abstract int getQueueLength();

        abstract Collection getQueuedThreads();
    }

    static final class FairSync
    extends Sync
    implements WaitQueue.QueuedSync {
        private static final long serialVersionUID = 2014338818796000944L;
        private transient WaitQueue wq_ = new FIFOWaitQueue();

        FairSync(int n) {
            super(n);
        }

        public void acquireUninterruptibly(int n) {
            if (this.precheck(n)) {
                return;
            }
            Node node = new Node(n);
            node.doWaitUninterruptibly(this);
        }

        public void acquire(int n) throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.precheck(n)) {
                return;
            }
            Node node = new Node(n);
            node.doWait(this);
        }

        public boolean attempt(int n, long l) throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.precheck(n)) {
                return true;
            }
            if (l <= 0L) {
                return false;
            }
            Node node = new Node(n);
            return node.doTimedWait(this, l);
        }

        protected synchronized boolean precheck(int n) {
            boolean bl;
            boolean bl2 = bl = this.permits_ >= n;
            if (bl) {
                this.permits_ -= n;
            }
            return bl;
        }

        public synchronized boolean recheck(WaitQueue.WaitNode waitNode) {
            boolean bl;
            Node node = (Node)waitNode;
            boolean bl2 = bl = this.permits_ >= node.requests;
            if (bl) {
                this.permits_ -= node.requests;
            } else {
                this.wq_.insert(waitNode);
            }
            return bl;
        }

        public void takeOver(WaitQueue.WaitNode waitNode) {
        }

        protected synchronized Node getSignallee(int n) {
            Node node = (Node)this.wq_.extract();
            this.permits_ += n;
            if (node == null) {
                return null;
            }
            if (node.requests > this.permits_) {
                this.wq_.putBack(node);
                return null;
            }
            this.permits_ -= node.requests;
            return node;
        }

        public void release(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Negative argument");
            }
            Node node;
            while ((node = this.getSignallee(n)) != null) {
                if (node.signal(this)) {
                    return;
                }
                n = node.requests;
            }
            return;
        }

        public synchronized boolean hasQueuedThreads() {
            return this.wq_.hasNodes();
        }

        public synchronized int getQueueLength() {
            return this.wq_.getLength();
        }

        public synchronized Collection getQueuedThreads() {
            return this.wq_.getWaitingThreads();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            FairSync fairSync = this;
            synchronized (fairSync) {
                this.wq_ = new FIFOWaitQueue();
            }
        }

        static final class Node
        extends WaitQueue.WaitNode {
            final int requests;

            Node(int n) {
                this.requests = n;
            }
        }
    }

    static final class NonfairSync
    extends Sync {
        private static final long serialVersionUID = -2694183684443567898L;

        protected NonfairSync(int n) {
            super(n);
        }

        private static void checkAgainstMultiacquire(int n) {
            if (n != 1) {
                throw new UnsupportedOperationException("Atomic multi-acquire supported only in FAIR semaphores");
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void acquireUninterruptibly(int n) {
            if (n == 0) {
                return;
            }
            NonfairSync.checkAgainstMultiacquire(n);
            NonfairSync nonfairSync = this;
            synchronized (nonfairSync) {
                if (this.permits_ > 0) {
                    --this.permits_;
                    return;
                }
                boolean bl = Thread.interrupted();
                try {
                    do {
                        try {
                            this.wait();
                        }
                        catch (InterruptedException interruptedException) {
                            bl = true;
                        }
                    } while (this.permits_ <= 0);
                    --this.permits_;
                    return;
                }
                finally {
                    if (bl) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void acquire(int n) throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (n == 0) {
                return;
            }
            NonfairSync.checkAgainstMultiacquire(n);
            NonfairSync nonfairSync = this;
            synchronized (nonfairSync) {
                while (this.permits_ <= 0) {
                    try {
                        this.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        this.notify();
                        throw interruptedException;
                    }
                }
                --this.permits_;
            }
        }

        public boolean attempt(int n, long l) throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (n == 0) {
                return true;
            }
            NonfairSync.checkAgainstMultiacquire(n);
            NonfairSync nonfairSync = this;
            synchronized (nonfairSync) {
                if (this.permits_ > 0) {
                    --this.permits_;
                    return true;
                }
                if (l <= 0L) {
                    return false;
                }
                try {
                    long l2 = Utils.nanoTime() + l;
                    do {
                        TimeUnit.NANOSECONDS.timedWait(this, l);
                        if (this.permits_ <= 0) continue;
                        --this.permits_;
                        return true;
                    } while ((l = l2 - Utils.nanoTime()) > 0L);
                    return false;
                }
                catch (InterruptedException interruptedException) {
                    this.notify();
                    throw interruptedException;
                }
            }
        }

        public synchronized void release(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Negative argument");
            }
            this.permits_ += n;
            for (int i2 = 0; i2 < n; ++i2) {
                this.notify();
            }
        }

        public boolean hasQueuedThreads() {
            throw new UnsupportedOperationException("Use FAIR version");
        }

        public int getQueueLength() {
            throw new UnsupportedOperationException("Use FAIR version");
        }

        public Collection getQueuedThreads() {
            throw new UnsupportedOperationException("Use FAIR version");
        }
    }
}

