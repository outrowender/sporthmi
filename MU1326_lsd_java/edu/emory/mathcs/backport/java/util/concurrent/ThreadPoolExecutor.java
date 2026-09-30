/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.AbstractExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.RejectedExecutionException;
import edu.emory.mathcs.backport.java.util.concurrent.RejectedExecutionHandler;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.locks.Condition;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ThreadPoolExecutor
extends AbstractExecutorService {
    private final AtomicInteger ctl = new AtomicInteger(ThreadPoolExecutor.ctlOf(-536870912, 0));
    private static final int COUNT_BITS = 29;
    private static final int CAPACITY = 0x1FFFFFFF;
    private static final int RUNNING = -536870912;
    private static final int SHUTDOWN = 0;
    private static final int STOP = 0x20000000;
    private static final int TIDYING = 0x40000000;
    private static final int TERMINATED = 0x60000000;
    private final BlockingQueue workQueue;
    private final ReentrantLock mainLock = new ReentrantLock();
    private final HashSet workers = new HashSet();
    private final Condition termination = this.mainLock.newCondition();
    private int largestPoolSize;
    private long completedTaskCount;
    private volatile ThreadFactory threadFactory;
    private volatile RejectedExecutionHandler handler;
    private volatile long keepAliveTime;
    private volatile boolean allowCoreThreadTimeOut;
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;
    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
    private static final boolean ONLY_ONE = true;

    private static int runStateOf(int n) {
        return n & 0xE0000000;
    }

    private static int workerCountOf(int n) {
        return n & 0x1FFFFFFF;
    }

    private static int ctlOf(int n, int n2) {
        return n | n2;
    }

    private static boolean runStateLessThan(int n, int n2) {
        return n < n2;
    }

    private static boolean runStateAtLeast(int n, int n2) {
        return n >= n2;
    }

    private static boolean isRunning(int n) {
        return n < 0;
    }

    private boolean compareAndIncrementWorkerCount(int n) {
        return this.ctl.compareAndSet(n, n + 1);
    }

    private boolean compareAndDecrementWorkerCount(int n) {
        return this.ctl.compareAndSet(n, n - 1);
    }

    private void decrementWorkerCount() {
        while (!this.compareAndDecrementWorkerCount(this.ctl.get())) {
        }
    }

    private void advanceRunState(int n) {
        int n2;
        while (!ThreadPoolExecutor.runStateAtLeast(n2 = this.ctl.get(), n) && !this.ctl.compareAndSet(n2, ThreadPoolExecutor.ctlOf(n, ThreadPoolExecutor.workerCountOf(n2)))) {
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void tryTerminate() {
        int n;
        while (!(ThreadPoolExecutor.isRunning(n = this.ctl.get()) || ThreadPoolExecutor.runStateAtLeast(n, 0x40000000) || ThreadPoolExecutor.runStateOf(n) == 0 && !this.workQueue.isEmpty())) {
            if (ThreadPoolExecutor.workerCountOf(n) != 0) {
                this.interruptIdleWorkers(true);
                return;
            }
            ReentrantLock reentrantLock = this.mainLock;
            reentrantLock.lock();
            try {
                if (!this.ctl.compareAndSet(n, ThreadPoolExecutor.ctlOf(0x40000000, 0))) continue;
                try {
                    this.terminated();
                }
                finally {
                    this.ctl.set(ThreadPoolExecutor.ctlOf(0x60000000, 0));
                    this.termination.signalAll();
                }
                return;
            }
            finally {
                reentrantLock.unlock();
                continue;
            }
            break;
        }
        return;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkShutdownAccess() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(shutdownPerm);
            ReentrantLock reentrantLock = this.mainLock;
            reentrantLock.lock();
            try {
                Iterator iterator = this.workers.iterator();
                while (iterator.hasNext()) {
                    Worker worker = (Worker)iterator.next();
                    securityManager.checkAccess(worker.thread);
                }
            }
            finally {
                reentrantLock.unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void interruptWorkers() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            Iterator iterator = this.workers.iterator();
            while (iterator.hasNext()) {
                Worker worker = (Worker)iterator.next();
                try {
                    worker.thread.interrupt();
                }
                catch (SecurityException securityException) {}
            }
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void interruptIdleWorkers(boolean bl) {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            Iterator iterator = this.workers.iterator();
            while (iterator.hasNext()) {
                Worker worker = (Worker)iterator.next();
                Thread thread = worker.thread;
                if (!thread.isInterrupted() && worker.tryLock()) {
                    try {
                        thread.interrupt();
                    }
                    catch (SecurityException securityException) {
                    }
                    finally {
                        worker.unlock();
                    }
                }
                if (!bl) continue;
                break;
            }
        }
        finally {
            reentrantLock.unlock();
        }
    }

    private void interruptIdleWorkers() {
        this.interruptIdleWorkers(false);
    }

    private void clearInterruptsForTaskRun() {
        if (ThreadPoolExecutor.runStateLessThan(this.ctl.get(), 0x20000000) && Thread.interrupted() && ThreadPoolExecutor.runStateAtLeast(this.ctl.get(), 0x20000000)) {
            Thread.currentThread().interrupt();
        }
    }

    final void reject(Runnable runnable) {
        this.handler.rejectedExecution(runnable, this);
    }

    void onShutdown() {
    }

    final boolean isRunningOrShutdown(boolean bl) {
        int n = ThreadPoolExecutor.runStateOf(this.ctl.get());
        return n == -536870912 || n == 0 && bl;
    }

    private List drainQueue() {
        BlockingQueue blockingQueue = this.workQueue;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            Runnable[] runnableArray = (Runnable[])blockingQueue.toArray(new Runnable[0]);
            for (int i2 = 0; i2 < runnableArray.length; ++i2) {
                Runnable runnable = runnableArray[i2];
                if (!blockingQueue.remove(runnable)) continue;
                arrayList.add(runnable);
            }
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean addWorker(Runnable runnable, boolean bl) {
        block4: while (true) {
            int n;
            int n2;
            if ((n2 = ThreadPoolExecutor.runStateOf(n = this.ctl.get())) >= 0 && (n2 != 0 || runnable != null || this.workQueue.isEmpty())) {
                return false;
            }
            do {
                int n3;
                if ((n3 = ThreadPoolExecutor.workerCountOf(n)) >= 0x1FFFFFFF || n3 >= (bl ? this.corePoolSize : this.maximumPoolSize)) {
                    return false;
                }
                if (this.compareAndIncrementWorkerCount(n)) break block4;
            } while (ThreadPoolExecutor.runStateOf(n = this.ctl.get()) == n2);
        }
        Worker worker = new Worker(runnable);
        Thread thread = worker.thread;
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            int n = this.ctl.get();
            int n4 = ThreadPoolExecutor.runStateOf(n);
            if (thread == null || n4 >= 0 && (n4 != 0 || runnable != null)) {
                this.decrementWorkerCount();
                this.tryTerminate();
                boolean bl2 = false;
                return bl2;
            }
            this.workers.add(worker);
            int n5 = this.workers.size();
            if (n5 > this.largestPoolSize) {
                this.largestPoolSize = n5;
            }
        }
        finally {
            reentrantLock.unlock();
        }
        thread.start();
        if (ThreadPoolExecutor.runStateOf(this.ctl.get()) == 0x20000000 && !thread.isInterrupted()) {
            thread.interrupt();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void processWorkerExit(Worker worker, boolean bl) {
        if (bl) {
            this.decrementWorkerCount();
        }
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            this.completedTaskCount += worker.completedTasks;
            this.workers.remove(worker);
        }
        finally {
            reentrantLock.unlock();
        }
        this.tryTerminate();
        int n = this.ctl.get();
        if (ThreadPoolExecutor.runStateLessThan(n, 0x20000000)) {
            if (!bl) {
                int n2;
                int n3 = n2 = this.allowCoreThreadTimeOut ? 0 : this.corePoolSize;
                if (n2 == 0 && !this.workQueue.isEmpty()) {
                    n2 = 1;
                }
                if (ThreadPoolExecutor.workerCountOf(n) >= n2) {
                    return;
                }
            }
            this.addWorker(null, false);
        }
    }

    private Runnable getTask() {
        boolean bl = false;
        while (true) {
            boolean bl2;
            block6: {
                int n;
                int n2;
                if ((n2 = ThreadPoolExecutor.runStateOf(n = this.ctl.get())) >= 0 && (n2 >= 0x20000000 || this.workQueue.isEmpty())) {
                    this.decrementWorkerCount();
                    return null;
                }
                do {
                    int n3 = ThreadPoolExecutor.workerCountOf(n);
                    boolean bl3 = bl2 = this.allowCoreThreadTimeOut || n3 > this.corePoolSize;
                    if (n3 <= this.maximumPoolSize && (!bl || !bl2)) break block6;
                    if (!this.compareAndDecrementWorkerCount(n)) continue;
                    return null;
                } while (ThreadPoolExecutor.runStateOf(n = this.ctl.get()) == n2);
                continue;
            }
            try {
                Runnable runnable;
                Runnable runnable2 = runnable = bl2 ? (Runnable)this.workQueue.poll(this.keepAliveTime, TimeUnit.NANOSECONDS) : (Runnable)this.workQueue.take();
                if (runnable != null) {
                    return runnable;
                }
                bl = true;
                continue;
            }
            catch (InterruptedException interruptedException) {
                bl = false;
                continue;
            }
            break;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void runWorker(Worker worker) {
        Runnable runnable = worker.firstTask;
        worker.firstTask = null;
        boolean bl = true;
        try {
            while (runnable != null || (runnable = this.getTask()) != null) {
                worker.lock();
                this.clearInterruptsForTaskRun();
                try {
                    this.beforeExecute(worker.thread, runnable);
                    Throwable throwable = null;
                    try {
                        runnable.run();
                    }
                    catch (RuntimeException runtimeException) {
                        throwable = runtimeException;
                        throw runtimeException;
                    }
                    catch (Error error) {
                        throwable = error;
                        throw error;
                    }
                    catch (Throwable throwable2) {
                        throwable = throwable2;
                        throw new Error(throwable2);
                    }
                    finally {
                        this.afterExecute(runnable, throwable);
                    }
                }
                finally {
                    runnable = null;
                    ++worker.completedTasks;
                    worker.unlock();
                }
            }
            bl = false;
        }
        finally {
            this.processWorkerExit(worker, bl);
        }
    }

    public ThreadPoolExecutor(int n, int n2, long l, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        this(n, n2, l, timeUnit, blockingQueue, Executors.defaultThreadFactory(), defaultHandler);
    }

    public ThreadPoolExecutor(int n, int n2, long l, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(n, n2, l, timeUnit, blockingQueue, threadFactory, defaultHandler);
    }

    public ThreadPoolExecutor(int n, int n2, long l, TimeUnit timeUnit, BlockingQueue blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        this(n, n2, l, timeUnit, blockingQueue, Executors.defaultThreadFactory(), rejectedExecutionHandler);
    }

    public ThreadPoolExecutor(int n, int n2, long l, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        if (n < 0 || n2 <= 0 || n2 < n || l < 0L) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw new NullPointerException();
        }
        this.corePoolSize = n;
        this.maximumPoolSize = n2;
        this.workQueue = blockingQueue;
        this.keepAliveTime = timeUnit.toNanos(l);
        this.threadFactory = threadFactory;
        this.handler = rejectedExecutionHandler;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        int n = this.ctl.get();
        if (ThreadPoolExecutor.workerCountOf(n) < this.corePoolSize) {
            if (this.addWorker(runnable, true)) {
                return;
            }
            n = this.ctl.get();
        }
        if (ThreadPoolExecutor.isRunning(n) && this.workQueue.offer(runnable)) {
            int n2 = this.ctl.get();
            if (!ThreadPoolExecutor.isRunning(n2) && this.remove(runnable)) {
                this.reject(runnable);
            } else if (ThreadPoolExecutor.workerCountOf(n2) == 0) {
                this.addWorker(null, false);
            }
        } else if (!this.addWorker(runnable, false)) {
            this.reject(runnable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void shutdown() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            this.checkShutdownAccess();
            this.advanceRunState(0);
            this.interruptIdleWorkers();
            this.onShutdown();
        }
        finally {
            reentrantLock.unlock();
        }
        this.tryTerminate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List shutdownNow() {
        List list;
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            this.checkShutdownAccess();
            this.advanceRunState(0x20000000);
            this.interruptWorkers();
            list = this.drainQueue();
        }
        finally {
            reentrantLock.unlock();
        }
        this.tryTerminate();
        return list;
    }

    public boolean isShutdown() {
        return !ThreadPoolExecutor.isRunning(this.ctl.get());
    }

    public boolean isTerminating() {
        int n = this.ctl.get();
        return !ThreadPoolExecutor.isRunning(n) && ThreadPoolExecutor.runStateLessThan(n, 0x60000000);
    }

    public boolean isTerminated() {
        return ThreadPoolExecutor.runStateAtLeast(this.ctl.get(), 0x60000000);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        long l2 = timeUnit.toNanos(l);
        long l3 = Utils.nanoTime() + l2;
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            if (ThreadPoolExecutor.runStateAtLeast(this.ctl.get(), 0x60000000)) {
                boolean bl = true;
                return bl;
            }
            while (l2 > 0L) {
                this.termination.await(l2, TimeUnit.NANOSECONDS);
                if (ThreadPoolExecutor.runStateAtLeast(this.ctl.get(), 0x60000000)) {
                    boolean bl = true;
                    return bl;
                }
                l2 = l3 - Utils.nanoTime();
            }
            boolean bl = false;
            return bl;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    protected void finalize() {
        this.shutdown();
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.threadFactory = threadFactory;
    }

    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        if (rejectedExecutionHandler == null) {
            throw new NullPointerException();
        }
        this.handler = rejectedExecutionHandler;
    }

    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.handler;
    }

    public void setCorePoolSize(int n) {
        block3: {
            int n2;
            block2: {
                if (n < 0) {
                    throw new IllegalArgumentException();
                }
                n2 = n - this.corePoolSize;
                this.corePoolSize = n;
                if (ThreadPoolExecutor.workerCountOf(this.ctl.get()) <= n) break block2;
                this.interruptIdleWorkers();
                break block3;
            }
            if (n2 <= 0) break block3;
            int n3 = Math.min(n2, this.workQueue.size());
            while (n3-- > 0 && this.addWorker(null, true) && !this.workQueue.isEmpty()) {
            }
        }
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public boolean prestartCoreThread() {
        return ThreadPoolExecutor.workerCountOf(this.ctl.get()) < this.corePoolSize && this.addWorker(null, true);
    }

    public int prestartAllCoreThreads() {
        int n = 0;
        while (this.addWorker(null, true)) {
            ++n;
        }
        return n;
    }

    public boolean allowsCoreThreadTimeOut() {
        return this.allowCoreThreadTimeOut;
    }

    public void allowCoreThreadTimeOut(boolean bl) {
        if (bl && this.keepAliveTime <= 0L) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        if (bl != this.allowCoreThreadTimeOut) {
            this.allowCoreThreadTimeOut = bl;
            if (bl) {
                this.interruptIdleWorkers();
            }
        }
    }

    public void setMaximumPoolSize(int n) {
        if (n <= 0 || n < this.corePoolSize) {
            throw new IllegalArgumentException();
        }
        this.maximumPoolSize = n;
        if (ThreadPoolExecutor.workerCountOf(this.ctl.get()) > n) {
            this.interruptIdleWorkers();
        }
    }

    public int getMaximumPoolSize() {
        return this.maximumPoolSize;
    }

    public void setKeepAliveTime(long l, TimeUnit timeUnit) {
        if (l < 0L) {
            throw new IllegalArgumentException();
        }
        if (l == 0L && this.allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        long l2 = timeUnit.toNanos(l);
        long l3 = l2 - this.keepAliveTime;
        this.keepAliveTime = l2;
        if (l3 < 0L) {
            this.interruptIdleWorkers();
        }
    }

    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.keepAliveTime, TimeUnit.NANOSECONDS);
    }

    public BlockingQueue getQueue() {
        return this.workQueue;
    }

    public boolean remove(Runnable runnable) {
        boolean bl = this.workQueue.remove(runnable);
        this.tryTerminate();
        return bl;
    }

    public void purge() {
        BlockingQueue blockingQueue = this.workQueue;
        try {
            Iterator iterator = blockingQueue.iterator();
            while (iterator.hasNext()) {
                Runnable runnable = (Runnable)iterator.next();
                if (!(runnable instanceof Future) || !((Future)((Object)runnable)).isCancelled()) continue;
                iterator.remove();
            }
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            Object[] objectArray = blockingQueue.toArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                Object object = objectArray[i2];
                if (!(object instanceof Future) || !((Future)object).isCancelled()) continue;
                blockingQueue.remove(object);
            }
        }
        this.tryTerminate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getPoolSize() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            int n = ThreadPoolExecutor.runStateAtLeast(this.ctl.get(), 0x40000000) ? 0 : this.workers.size();
            return n;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getActiveCount() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            int n = 0;
            Iterator iterator = this.workers.iterator();
            while (iterator.hasNext()) {
                Worker worker = (Worker)iterator.next();
                if (!worker.isLocked()) continue;
                ++n;
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
    public int getLargestPoolSize() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            int n = this.largestPoolSize;
            return n;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long getTaskCount() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            long l = this.completedTaskCount;
            Iterator iterator = this.workers.iterator();
            while (iterator.hasNext()) {
                Worker worker = (Worker)iterator.next();
                l += worker.completedTasks;
                if (!worker.isLocked()) continue;
                ++l;
            }
            long l2 = l + (long)this.workQueue.size();
            return l2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long getCompletedTaskCount() {
        ReentrantLock reentrantLock = this.mainLock;
        reentrantLock.lock();
        try {
            long l = this.completedTaskCount;
            Iterator iterator = this.workers.iterator();
            while (iterator.hasNext()) {
                Worker worker = (Worker)iterator.next();
                l += worker.completedTasks;
            }
            long l2 = l;
            return l2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    protected void beforeExecute(Thread thread, Runnable runnable) {
    }

    protected void afterExecute(Runnable runnable, Throwable throwable) {
    }

    protected void terminated() {
    }

    private final class Worker
    extends ReentrantLock
    implements Runnable {
        private static final long serialVersionUID = 6138294804551838833L;
        final Thread thread;
        Runnable firstTask;
        volatile long completedTasks;

        Worker(Runnable runnable) {
            this.firstTask = runnable;
            this.thread = ThreadPoolExecutor.this.getThreadFactory().newThread(this);
        }

        public void run() {
            ThreadPoolExecutor.this.runWorker(this);
        }
    }

    public static class AbortPolicy
    implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            throw new RejectedExecutionException();
        }
    }

    public static class DiscardPolicy
    implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    public static class CallerRunsPolicy
    implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (!threadPoolExecutor.isShutdown()) {
                runnable.run();
            }
        }
    }

    public static class DiscardOldestPolicy
    implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (!threadPoolExecutor.isShutdown()) {
                threadPoolExecutor.getQueue().poll();
                threadPoolExecutor.execute(runnable);
            }
        }
    }
}

