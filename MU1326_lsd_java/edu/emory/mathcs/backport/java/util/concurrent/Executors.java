/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.AbstractExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutionException;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledFuture;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;

public class Executors {
    public static ExecutorService newFixedThreadPool(int n) {
        return new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newFixedThreadPool(int n, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(), threadFactory);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(), threadFactory));
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int n) {
        return new ScheduledThreadPoolExecutor(n);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int n, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(n, threadFactory);
    }

    public static ExecutorService unconfigurableExecutorService(ExecutorService executorService) {
        if (executorService == null) {
            throw new NullPointerException();
        }
        return new DelegatedExecutorService(executorService);
    }

    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            throw new NullPointerException();
        }
        return new DelegatedScheduledExecutorService(scheduledExecutorService);
    }

    public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    public static ThreadFactory privilegedThreadFactory() {
        return new PrivilegedThreadFactory();
    }

    public static Callable callable(Runnable runnable, Object object) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        return new RunnableAdapter(runnable, object);
    }

    public static Callable callable(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        return new RunnableAdapter(runnable, null);
    }

    public static Callable callable(final PrivilegedAction privilegedAction) {
        if (privilegedAction == null) {
            throw new NullPointerException();
        }
        return new Callable(){

            public Object call() {
                return privilegedAction.run();
            }
        };
    }

    public static Callable callable(final PrivilegedExceptionAction privilegedExceptionAction) {
        if (privilegedExceptionAction == null) {
            throw new NullPointerException();
        }
        return new Callable(){

            public Object call() throws Exception {
                return privilegedExceptionAction.run();
            }
        };
    }

    public static Callable privilegedCallable(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new PrivilegedCallable(callable);
    }

    public static Callable privilegedCallableUsingCurrentClassLoader(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new PrivilegedCallableUsingCurrentClassLoader(callable);
    }

    private Executors() {
    }

    static final class RunnableAdapter
    implements Callable {
        final Runnable task;
        final Object result;

        RunnableAdapter(Runnable runnable, Object object) {
            this.task = runnable;
            this.result = object;
        }

        public Object call() {
            this.task.run();
            return this.result;
        }
    }

    static final class PrivilegedCallable
    implements Callable {
        private final AccessControlContext acc;
        private final Callable task;
        private Object result;
        private Exception exception;

        PrivilegedCallable(Callable callable) {
            this.task = callable;
            this.acc = AccessController.getContext();
        }

        public Object call() throws Exception {
            AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    try {
                        result = task.call();
                    }
                    catch (Exception exception) {
                        exception = exception;
                    }
                    return null;
                }
            }, this.acc);
            if (this.exception != null) {
                throw this.exception;
            }
            return this.result;
        }
    }

    static class DefaultThreadFactory
    implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static class PrivilegedThreadFactory
    extends DefaultThreadFactory {
        private final ClassLoader ccl = Thread.currentThread().getContextClassLoader();
        private final AccessControlContext acc = AccessController.getContext();

        PrivilegedThreadFactory() {
            this.acc.checkPermission(new RuntimePermission("setContextClassLoader"));
        }

        public Thread newThread(final Runnable runnable) {
            return super.newThread(new Runnable(){

                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction(){

                        public Object run() {
                            Thread.currentThread().setContextClassLoader(ccl);
                            runnable.run();
                            return null;
                        }
                    }, acc);
                }
            });
        }
    }

    static class DelegatedExecutorService
    extends AbstractExecutorService {
        private final ExecutorService e;

        DelegatedExecutorService(ExecutorService executorService) {
            this.e = executorService;
        }

        public void execute(Runnable runnable) {
            this.e.execute(runnable);
        }

        public void shutdown() {
            this.e.shutdown();
        }

        public List shutdownNow() {
            return this.e.shutdownNow();
        }

        public boolean isShutdown() {
            return this.e.isShutdown();
        }

        public boolean isTerminated() {
            return this.e.isTerminated();
        }

        public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
            return this.e.awaitTermination(l, timeUnit);
        }

        public Future submit(Runnable runnable) {
            return this.e.submit(runnable);
        }

        public Future submit(Callable callable) {
            return this.e.submit(callable);
        }

        public Future submit(Runnable runnable, Object object) {
            return this.e.submit(runnable, object);
        }

        public List invokeAll(Collection collection) throws InterruptedException {
            return this.e.invokeAll(collection);
        }

        public List invokeAll(Collection collection, long l, TimeUnit timeUnit) throws InterruptedException {
            return this.e.invokeAll(collection, l, timeUnit);
        }

        public Object invokeAny(Collection collection) throws InterruptedException, ExecutionException {
            return this.e.invokeAny(collection);
        }

        public Object invokeAny(Collection collection, long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.e.invokeAny(collection, l, timeUnit);
        }
    }

    static class DelegatedScheduledExecutorService
    extends DelegatedExecutorService
    implements ScheduledExecutorService {
        private final ScheduledExecutorService e;

        DelegatedScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.e = scheduledExecutorService;
        }

        public ScheduledFuture schedule(Runnable runnable, long l, TimeUnit timeUnit) {
            return this.e.schedule(runnable, l, timeUnit);
        }

        public ScheduledFuture schedule(Callable callable, long l, TimeUnit timeUnit) {
            return this.e.schedule(callable, l, timeUnit);
        }

        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
            return this.e.scheduleAtFixedRate(runnable, l, l2, timeUnit);
        }

        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l, long l2, TimeUnit timeUnit) {
            return this.e.scheduleWithFixedDelay(runnable, l, l2, timeUnit);
        }
    }

    static class FinalizableDelegatedExecutorService
    extends DelegatedExecutorService {
        FinalizableDelegatedExecutorService(ExecutorService executorService) {
            super(executorService);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    static final class PrivilegedCallableUsingCurrentClassLoader
    implements Callable {
        private final ClassLoader ccl;
        private final AccessControlContext acc;
        private final Callable task;
        private Object result;
        private Exception exception;

        PrivilegedCallableUsingCurrentClassLoader(Callable callable) {
            this.task = callable;
            this.ccl = Thread.currentThread().getContextClassLoader();
            this.acc = AccessController.getContext();
            this.acc.checkPermission(new RuntimePermission("getContextClassLoader"));
            this.acc.checkPermission(new RuntimePermission("setContextClassLoader"));
        }

        public Object call() throws Exception {
            AccessController.doPrivileged(new PrivilegedAction(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public Object run() {
                    ClassLoader classLoader = null;
                    Thread thread = Thread.currentThread();
                    try {
                        ClassLoader classLoader2 = thread.getContextClassLoader();
                        if (ccl != classLoader2) {
                            thread.setContextClassLoader(ccl);
                            classLoader = classLoader2;
                        }
                        result = task.call();
                        if (classLoader != null) {
                            thread.setContextClassLoader(classLoader);
                        }
                    }
                    catch (Exception exception) {
                        exception = exception;
                    }
                    finally {
                        if (classLoader != null) {
                            thread.setContextClassLoader(classLoader);
                        }
                    }
                    return null;
                }
            }, this.acc);
            if (this.exception != null) {
                throw this.exception;
            }
            return this.result;
        }
    }
}

