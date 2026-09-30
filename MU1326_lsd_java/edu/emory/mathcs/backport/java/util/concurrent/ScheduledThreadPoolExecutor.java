/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractQueue;
import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Delayed;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.FutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.RejectedExecutionHandler;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicLong;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ScheduledThreadPoolExecutor
extends ThreadPoolExecutor
implements ScheduledExecutorService {
    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    private volatile boolean executeExistingDelayedTasksAfterShutdown = true;
    private volatile boolean removeOnCancel = false;
    private static final AtomicLong sequencer = new AtomicLong(0L);

    final long now() {
        return Utils.nanoTime();
    }

    boolean canRunInCurrentRunState(boolean bl) {
        return this.isRunningOrShutdown(bl ? this.continueExistingPeriodicTasksAfterShutdown : this.executeExistingDelayedTasksAfterShutdown);
    }

    private void delayedExecute(RunnableScheduledFuture runnableScheduledFuture) {
        if (this.isShutdown()) {
            this.reject(runnableScheduledFuture);
        } else {
            super.getQueue().add(runnableScheduledFuture);
            if (this.isShutdown() && !this.canRunInCurrentRunState(runnableScheduledFuture.isPeriodic()) && this.remove(runnableScheduledFuture)) {
                runnableScheduledFuture.cancel(false);
            } else {
                this.prestartCoreThread();
            }
        }
    }

    void reExecutePeriodic(RunnableScheduledFuture runnableScheduledFuture) {
        if (this.canRunInCurrentRunState(true)) {
            super.getQueue().add(runnableScheduledFuture);
            if (!this.canRunInCurrentRunState(true) && this.remove(runnableScheduledFuture)) {
                runnableScheduledFuture.cancel(false);
            } else {
                this.prestartCoreThread();
            }
        }
    }

    void onShutdown() {
        BlockingQueue blockingQueue = super.getQueue();
        boolean bl = this.getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean bl2 = this.getContinueExistingPeriodicTasksAfterShutdownPolicy();
        if (!bl && !bl2) {
            blockingQueue.clear();
        } else {
            Object[] objectArray = blockingQueue.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                RunnableScheduledFuture runnableScheduledFuture;
                Object object = objectArray[i2];
                if (!(object instanceof RunnableScheduledFuture) || !(!(runnableScheduledFuture = (RunnableScheduledFuture)object).isPeriodic() ? !bl : !bl2) && !runnableScheduledFuture.isCancelled() || !blockingQueue.remove(runnableScheduledFuture)) continue;
                runnableScheduledFuture.cancel(false);
            }
        }
        this.tryTerminate();
    }

    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        return runnableScheduledFuture;
    }

    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        return runnableScheduledFuture;
    }

    public ScheduledThreadPoolExecutor(int n) {
        super(n, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, new DelayedWorkQueue());
    }

    public ScheduledThreadPoolExecutor(int n, ThreadFactory threadFactory) {
        super(n, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, (BlockingQueue)new DelayedWorkQueue(), threadFactory);
    }

    public ScheduledThreadPoolExecutor(int n, RejectedExecutionHandler rejectedExecutionHandler) {
        super(n, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, (BlockingQueue)new DelayedWorkQueue(), rejectedExecutionHandler);
    }

    public ScheduledThreadPoolExecutor(int n, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(n, Integer.MAX_VALUE, 0L, TimeUnit.NANOSECONDS, new DelayedWorkQueue(), threadFactory, rejectedExecutionHandler);
    }

    public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l2 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(runnable, (RunnableScheduledFuture)new ScheduledFutureTask(runnable, null, l2));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeUnit) {
        if (callable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l2 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(callable, (RunnableScheduledFuture)new ScheduledFutureTask(callable, l2));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l3 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(runnable, (RunnableScheduledFuture)new ScheduledFutureTask(runnable, null, l3, timeUnit.toNanos(l2)));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
        if (runnable == null || timeUnit == null) {
            throw new NullPointerException();
        }
        if (l2 <= 0L) {
            throw new IllegalArgumentException();
        }
        if (l < 0L) {
            l = 0L;
        }
        long l3 = this.now() + timeUnit.toNanos(l);
        RunnableScheduledFuture runnableScheduledFuture = this.decorateTask(runnable, (RunnableScheduledFuture)new ScheduledFutureTask(runnable, null, l3, timeUnit.toNanos(-l2)));
        this.delayedExecute(runnableScheduledFuture);
        return runnableScheduledFuture;
    }

    public void execute(Runnable runnable) {
        this.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Future submit(Runnable runnable) {
        return this.schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Future submit(Runnable runnable, Object object) {
        return this.schedule(Executors.callable(runnable, object), 0L, TimeUnit.NANOSECONDS);
    }

    public Future submit(Callable callable) {
        return this.schedule(callable, 0L, TimeUnit.NANOSECONDS);
    }

    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean bl) {
        this.continueExistingPeriodicTasksAfterShutdown = bl;
        if (!bl && this.isShutdown()) {
            this.onShutdown();
        }
    }

    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        return this.continueExistingPeriodicTasksAfterShutdown;
    }

    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean bl) {
        this.executeExistingDelayedTasksAfterShutdown = bl;
        if (!bl && this.isShutdown()) {
            this.onShutdown();
        }
    }

    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        return this.executeExistingDelayedTasksAfterShutdown;
    }

    public void setRemoveOnCancelPolicy(boolean bl) {
        this.removeOnCancel = bl;
    }

    public boolean getRemoveOnCancelPolicy() {
        return this.removeOnCancel;
    }

    public void shutdown() {
        super.shutdown();
    }

    public List shutdownNow() {
        return super.shutdownNow();
    }

    public BlockingQueue getQueue() {
        return super.getQueue();
    }

    static class DelayedWorkQueue
    extends AbstractQueue
    implements BlockingQueue {
        private static final int INITIAL_CAPACITY = 64;
        private transient RunnableScheduledFuture[] queue = new RunnableScheduledFuture[64];
        private final transient ReentrantLock lock = new ReentrantLock();
        private final transient Condition available = this.lock.newCondition();
        private int size = 0;

        DelayedWorkQueue() {
        }

        private void setIndex(Object object, int n) {
            if (object instanceof ScheduledFutureTask) {
                ((ScheduledFutureTask)object).heapIndex = n;
            }
        }

        private void siftUp(int n, RunnableScheduledFuture runnableScheduledFuture) {
            int n2;
            RunnableScheduledFuture runnableScheduledFuture2;
            while (n > 0 && runnableScheduledFuture.compareTo(runnableScheduledFuture2 = this.queue[n2 = n - 1 >>> 1]) < 0) {
                this.queue[n] = runnableScheduledFuture2;
                this.setIndex(runnableScheduledFuture2, n);
                n = n2;
            }
            this.queue[n] = runnableScheduledFuture;
            this.setIndex(runnableScheduledFuture, n);
        }

        private void siftDown(int n, RunnableScheduledFuture runnableScheduledFuture) {
            int n2 = this.size >>> 1;
            while (n < n2) {
                int n3 = (n << 1) + 1;
                RunnableScheduledFuture runnableScheduledFuture2 = this.queue[n3];
                int n4 = n3 + 1;
                if (n4 < this.size && runnableScheduledFuture2.compareTo(this.queue[n4]) > 0) {
                    n3 = n4;
                    runnableScheduledFuture2 = this.queue[n3];
                }
                if (runnableScheduledFuture.compareTo(runnableScheduledFuture2) <= 0) break;
                this.queue[n] = runnableScheduledFuture2;
                this.setIndex(runnableScheduledFuture2, n);
                n = n3;
            }
            this.queue[n] = runnableScheduledFuture;
            this.setIndex(runnableScheduledFuture, n);
        }

        private RunnableScheduledFuture finishPoll(RunnableScheduledFuture runnableScheduledFuture) {
            int n = --this.size;
            RunnableScheduledFuture runnableScheduledFuture2 = this.queue[n];
            this.queue[n] = null;
            if (n != 0) {
                this.siftDown(0, runnableScheduledFuture2);
                this.available.signalAll();
            }
            this.setIndex(runnableScheduledFuture, -1);
            return runnableScheduledFuture;
        }

        private void grow() {
            int n = this.queue.length;
            int n2 = n + (n >> 1);
            if (n2 < 0) {
                n2 = Integer.MAX_VALUE;
            }
            RunnableScheduledFuture[] runnableScheduledFutureArray = new RunnableScheduledFuture[n2];
            System.arraycopy((Object)this.queue, 0, (Object)runnableScheduledFutureArray, 0, this.queue.length);
            this.queue = runnableScheduledFutureArray;
        }

        private int indexOf(Object object) {
            if (object != null) {
                for (int i2 = 0; i2 < this.size; ++i2) {
                    if (!object.equals(this.queue[i2])) continue;
                    return i2;
                }
            }
            return -1;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean remove(Object object) {
            boolean bl;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int n = object instanceof ScheduledFutureTask ? ((ScheduledFutureTask)object).heapIndex : this.indexOf(object);
                bl = n >= 0 && n < this.size && this.queue[n] == object;
                if (bl) {
                    this.setIndex(object, -1);
                    int n2 = --this.size;
                    RunnableScheduledFuture runnableScheduledFuture = this.queue[n2];
                    this.queue[n2] = null;
                    if (n2 != n) {
                        this.siftDown(n, runnableScheduledFuture);
                        if (this.queue[n] == runnableScheduledFuture) {
                            this.siftUp(n, runnableScheduledFuture);
                        }
                    }
                }
            }
            finally {
                reentrantLock.unlock();
            }
            return bl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int size() {
            int n;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                n = this.size;
            }
            finally {
                reentrantLock.unlock();
            }
            return n;
        }

        public boolean isEmpty() {
            return this.size() == 0;
        }

        public int remainingCapacity() {
            return Integer.MAX_VALUE;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object peek() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                RunnableScheduledFuture runnableScheduledFuture = this.queue[0];
                return runnableScheduledFuture;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean offer(Object object) {
            if (object == null) {
                throw new NullPointerException();
            }
            RunnableScheduledFuture runnableScheduledFuture = (RunnableScheduledFuture)object;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                boolean bl;
                int n = this.size;
                if (n >= this.queue.length) {
                    this.grow();
                }
                this.size = n + 1;
                if (n == 0) {
                    bl = true;
                    this.queue[0] = runnableScheduledFuture;
                    this.setIndex(runnableScheduledFuture, 0);
                } else {
                    bl = runnableScheduledFuture.compareTo(this.queue[0]) < 0;
                    this.siftUp(n, runnableScheduledFuture);
                }
                if (bl) {
                    this.available.signalAll();
                }
            }
            finally {
                reentrantLock.unlock();
            }
            return true;
        }

        public void put(Object object) {
            this.offer(object);
        }

        public boolean add(Runnable runnable) {
            return this.offer(runnable);
        }

        public boolean offer(Object object, long l, TimeUnit timeUnit) {
            return this.offer(object);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object poll() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                RunnableScheduledFuture runnableScheduledFuture = this.queue[0];
                if (runnableScheduledFuture == null || runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS) > 0L) {
                    Object var3_3 = null;
                    return var3_3;
                }
                RunnableScheduledFuture runnableScheduledFuture2 = this.finishPoll(runnableScheduledFuture);
                return runnableScheduledFuture2;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                while (true) {
                    RunnableScheduledFuture runnableScheduledFuture;
                    if ((runnableScheduledFuture = this.queue[0]) == null) {
                        this.available.await();
                        continue;
                    }
                    long l = runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS);
                    if (l > 0L) {
                        this.available.await(l, TimeUnit.NANOSECONDS);
                        continue;
                    }
                    RunnableScheduledFuture runnableScheduledFuture2 = this.finishPoll(runnableScheduledFuture);
                    return runnableScheduledFuture2;
                }
            }
            finally {
                reentrantLock.unlock();
            }
        }

        public Object poll(long l, TimeUnit timeUnit) throws InterruptedException {
            long l2 = timeUnit.toNanos(l);
            long l3 = Utils.nanoTime() + l2;
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            try {
                while (true) {
                    RunnableScheduledFuture runnableScheduledFuture;
                    if ((runnableScheduledFuture = this.queue[0]) == null) {
                        if (l2 <= 0L) {
                            Object var10_8 = null;
                            return var10_8;
                        }
                        this.available.await(l2, TimeUnit.NANOSECONDS);
                        l2 = l3 - Utils.nanoTime();
                        continue;
                    }
                    long l4 = runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS);
                    if (l4 > 0L) {
                        if (l2 <= 0L) {
                            Object var12_9 = null;
                            return var12_9;
                        }
                        if (l4 > l2) {
                            l4 = l2;
                        }
                        this.available.await(l4, TimeUnit.NANOSECONDS);
                        l2 = l3 - Utils.nanoTime();
                        continue;
                    }
                    RunnableScheduledFuture runnableScheduledFuture2 = this.finishPoll(runnableScheduledFuture);
                    return runnableScheduledFuture2;
                }
            }
            finally {
                reentrantLock.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void clear() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                for (int i2 = 0; i2 < this.size; ++i2) {
                    RunnableScheduledFuture runnableScheduledFuture = this.queue[i2];
                    if (runnableScheduledFuture == null) continue;
                    this.queue[i2] = null;
                    this.setIndex(runnableScheduledFuture, -1);
                }
                this.size = 0;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        private RunnableScheduledFuture pollExpired() {
            RunnableScheduledFuture runnableScheduledFuture = this.queue[0];
            if (runnableScheduledFuture == null || runnableScheduledFuture.getDelay(TimeUnit.NANOSECONDS) > 0L) {
                return null;
            }
            this.setIndex(runnableScheduledFuture, -1);
            int n = --this.size;
            RunnableScheduledFuture runnableScheduledFuture2 = this.queue[n];
            this.queue[n] = null;
            if (n != 0) {
                this.siftDown(0, runnableScheduledFuture2);
            }
            return runnableScheduledFuture;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int drainTo(Collection collection) {
            if (collection == null) {
                throw new NullPointerException();
            }
            if (collection == this) {
                throw new IllegalArgumentException();
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                RunnableScheduledFuture runnableScheduledFuture;
                int n = 0;
                while ((runnableScheduledFuture = this.pollExpired()) != null) {
                    collection.add(runnableScheduledFuture);
                    ++n;
                }
                if (n > 0) {
                    this.available.signalAll();
                }
                int n2 = n;
                return n2;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int drainTo(Collection collection, int n) {
            if (collection == null) {
                throw new NullPointerException();
            }
            if (collection == this) {
                throw new IllegalArgumentException();
            }
            if (n <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                RunnableScheduledFuture runnableScheduledFuture;
                int n2;
                for (n2 = 0; n2 < n && (runnableScheduledFuture = this.pollExpired()) != null; ++n2) {
                    collection.add(runnableScheduledFuture);
                }
                if (n2 > 0) {
                    this.available.signalAll();
                }
                int n3 = n2;
                return n3;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object[] toArray() {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                Object[] objectArray = Arrays.copyOf(this.queue, this.size);
                return objectArray;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public Object[] toArray(Object[] objectArray) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (objectArray.length < this.size) {
                    Object[] objectArray2 = Arrays.copyOf(this.queue, this.size, objectArray.getClass());
                    return objectArray2;
                }
                System.arraycopy((Object)this.queue, 0, (Object)objectArray, 0, this.size);
                if (objectArray.length > this.size) {
                    objectArray[this.size] = null;
                }
                Object[] objectArray3 = objectArray;
                return objectArray3;
            }
            finally {
                reentrantLock.unlock();
            }
        }

        public Iterator iterator() {
            return new Itr(this.toArray());
        }

        private class Itr
        implements Iterator {
            final Object[] array;
            int cursor;
            int lastRet = -1;

            Itr(Object[] objectArray) {
                this.array = objectArray;
            }

            public boolean hasNext() {
                return this.cursor < this.array.length;
            }

            public Object next() {
                if (this.cursor >= this.array.length) {
                    throw new NoSuchElementException();
                }
                this.lastRet = this.cursor;
                return (Runnable)this.array[this.cursor++];
            }

            public void remove() {
                if (this.lastRet < 0) {
                    throw new IllegalStateException();
                }
                DelayedWorkQueue.this.remove(this.array[this.lastRet]);
                this.lastRet = -1;
            }
        }
    }

    private class ScheduledFutureTask
    extends FutureTask
    implements RunnableScheduledFuture {
        private final long sequenceNumber;
        private long time;
        private final long period;
        int heapIndex;

        ScheduledFutureTask(Runnable runnable, Object object, long l) {
            super(runnable, object);
            this.time = l;
            this.period = 0L;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        ScheduledFutureTask(Runnable runnable, Object object, long l, long l2) {
            super(runnable, object);
            this.time = l;
            this.period = l2;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        ScheduledFutureTask(Callable callable, long l) {
            super(callable);
            this.time = l;
            this.period = 0L;
            this.sequenceNumber = sequencer.getAndIncrement();
        }

        public long getDelay(TimeUnit timeUnit) {
            long l = timeUnit.convert(this.time - ScheduledThreadPoolExecutor.this.now(), TimeUnit.NANOSECONDS);
            return l;
        }

        public int compareTo(Object object) {
            Delayed delayed = (Delayed)object;
            if (delayed == this) {
                return 0;
            }
            if (delayed instanceof ScheduledFutureTask) {
                ScheduledFutureTask scheduledFutureTask = (ScheduledFutureTask)object;
                long l = this.time - scheduledFutureTask.time;
                if (l < 0L) {
                    return -1;
                }
                if (l > 0L) {
                    return 1;
                }
                if (this.sequenceNumber < scheduledFutureTask.sequenceNumber) {
                    return -1;
                }
                return 1;
            }
            long l = this.getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS);
            return l == 0L ? 0 : (l < 0L ? -1 : 1);
        }

        public boolean isPeriodic() {
            return this.period != 0L;
        }

        private void setNextRunTime() {
            long l = this.period;
            this.time = l > 0L ? (this.time += l) : ScheduledThreadPoolExecutor.this.now() - l;
        }

        public boolean cancel(boolean bl) {
            boolean bl2 = super.cancel(bl);
            if (bl2 && ScheduledThreadPoolExecutor.this.removeOnCancel && this.heapIndex >= 0) {
                ScheduledThreadPoolExecutor.this.remove(this);
            }
            return bl2;
        }

        public void run() {
            boolean bl = this.isPeriodic();
            if (!ScheduledThreadPoolExecutor.this.canRunInCurrentRunState(bl)) {
                this.cancel(false);
            } else if (!bl) {
                ScheduledFutureTask.super.run();
            } else if (ScheduledFutureTask.super.runAndReset()) {
                this.setNextRunTime();
                ScheduledThreadPoolExecutor.this.reExecutePeriodic(this);
            }
        }
    }
}

