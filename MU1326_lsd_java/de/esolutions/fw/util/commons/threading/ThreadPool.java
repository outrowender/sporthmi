/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.SystemTimeSource;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private static final String DEFAULT_NAME = "Default";
    private static final int MAX_THREADS_DEFAULT = 12;
    private static final int MIN_THREADS_DEFAULT = 0;
    private static final int JOBQUEUE_SIZE_DEFAULT = 10;
    private static final long LATENCY_DEFAULT = 60000L;
    private static final long MAX_WAIT_TIME_WARNING = 10000L;
    private static final boolean DEBUG = Boolean.getBoolean("ipl.commons.threadpool.debug");
    private static ThreadPool defaultPool = null;
    final ITimeSource timeSource;
    private final String name;
    private final int defPriority;
    private int max;
    private int min;
    private long latency;
    private int jobQueueSize = 1024;
    private long maxWaitTime = 10000L;
    private final List jobs;
    private int nthreads;
    private int nidle;
    private int nCreated = 0;
    private int statisticsMaxIdle = 0;
    private int statisticsMaxRun = 0;
    private int statisticsMaxWait = 0;
    private long statisticsMaxWaitTime = 0L;
    private long statisticsTotalWaitTime = 0L;
    private long statisticsTotalWaitCount = 0L;
    private long statisticsTotalRunCount = 0L;
    private long statisticsMaxExecutionTime = 0L;
    private long statisticsTotalExecutionTime = 0L;

    public static final synchronized ThreadPool getDefault() {
        if (defaultPool == null) {
            defaultPool = new ThreadPool(DEFAULT_NAME, new SystemTimeSource());
        }
        return defaultPool;
    }

    public static void debug(String string) {
        System.out.println(new StringBuffer().append("##### ThreadPool (DEBUG): ").append(string).toString());
    }

    public static void warn(String string) {
        System.out.println(new StringBuffer().append("##### ThreadPool (WARNING): ").append(string).toString());
    }

    public static void warn(String string, Throwable throwable) {
        System.out.println(new StringBuffer().append("##### ThreadPool (ERROR): ").append(string).append(", exeption:").append(throwable).toString());
        throwable.printStackTrace();
    }

    public ThreadPool(String string, ITimeSource iTimeSource, int n, int n2, int n3, int n4, long l) {
        this(string, iTimeSource, n, n2, n3, n4, l, 10000L);
    }

    public ThreadPool(String string, ITimeSource iTimeSource, int n, int n2, int n3, int n4, long l, long l2) {
        this.name = string;
        this.timeSource = iTimeSource;
        this.defPriority = n;
        this.jobQueueSize = n4;
        this.adjust(n2, n3, l, l2);
        this.jobs = new ArrayList(n4);
        this.nthreads = 0;
        this.nidle = 0;
        if (DEBUG) {
            ThreadPool.debug(new StringBuffer().append("Thread pool created: name=").append(string).append(", minThreads=").append(n3).append(", maxThreads=").append(n2).append(", queueSize=").append(n4).append(", latency=").append(l).toString());
        }
    }

    public ThreadPool(String string, ITimeSource iTimeSource) {
        this(string, iTimeSource, 5, 12, 0, 10, 60000L, 10000L);
    }

    public String toString() {
        return new StringBuffer().append("[name=").append(this.name).append(", threads=").append(this.getNrThreads()).append(", idle=").append(this.getNrIdle()).append(", jobs=").append(this.getNrWaiting()).append("]").toString();
    }

    public final synchronized int getNrWaiting() {
        return this.jobs.size();
    }

    public final int getNrThreads() {
        return this.nthreads;
    }

    public final synchronized int getNrIdle() {
        return this.nidle;
    }

    private final long getLatency() {
        return this.latency;
    }

    private final long getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public final synchronized void adjust(int n, int n2, long l) {
        this.adjust(n, n2, l, this.maxWaitTime);
    }

    public final synchronized void adjust(int n, int n2, long l, long l2) {
        if (n2 < 0 || n < 1 || n < n2 || l < 100L || l2 < 100L) {
            throw new IllegalArgumentException(new StringBuffer().append("Min: ").append(n2).append(" Max: ").append(n).append(" Latency: ").append(l).append(" MaxWaitTime: ").append(l2).toString());
        }
        this.max = n;
        this.min = n2;
        this.latency = l;
        this.maxWaitTime = l2;
    }

    final synchronized boolean check_waiting() {
        if (!this.jobs.isEmpty()) {
            JobListElement jobListElement = (JobListElement)this.jobs.get(0);
            long l = this.timeSource.getCurrentTime() - jobListElement.insertTime;
            if (l > this.getMaxWaitTime()) {
                this.printDelayWarning(jobListElement.job, l, " queued since ");
            }
        }
        return true;
    }

    public synchronized void execute(Runnable runnable) {
        if (DEBUG) {
            ThreadPool.debug(new StringBuffer().append("Execute job: pool=").append(this).toString());
        }
        this.check_waiting();
        if (this.nidle <= this.jobs.size() && this.nthreads < this.max) {
            this.startThread(runnable, this.defPriority);
        } else {
            this.jobs.add(new JobListElement(runnable, this.timeSource.getCurrentTime()));
            this.notifyAll();
            int n = this.jobs.size();
            if (n > this.jobQueueSize) {
                ThreadPool.warn(new StringBuffer().append("Job list overflow: ").append(n).toString());
            }
            if (n > this.statisticsMaxWait) {
                this.statisticsMaxWait = n;
            }
        }
    }

    public synchronized void execute(Runnable runnable, int n) {
        this.execute(new PriorizedRunnable(runnable, n));
    }

    private synchronized void nrThreads(int n) {
        this.nthreads += n;
        if (this.nthreads > this.statisticsMaxRun) {
            this.statisticsMaxRun = this.nthreads;
        }
    }

    private synchronized void idleThreads(int n) {
        this.nidle += n;
        if (this.nidle > this.statisticsMaxIdle) {
            this.statisticsMaxIdle = this.nidle;
        }
    }

    private synchronized boolean check_shutdown() {
        return this.nidle > this.min;
    }

    private synchronized Runnable getNextJob() {
        if (!this.jobs.isEmpty()) {
            JobListElement jobListElement = (JobListElement)this.jobs.remove(0);
            long l = this.timeSource.getCurrentTime() - jobListElement.insertTime;
            if (l > this.statisticsMaxWaitTime) {
                this.statisticsMaxWaitTime = l;
            }
            if (l > this.getMaxWaitTime()) {
                this.printDelayWarning(jobListElement.job, l, " started after waiting ");
            }
            this.statisticsTotalWaitTime += l;
            ++this.statisticsTotalWaitCount;
            return jobListElement.job;
        }
        return null;
    }

    private void startThread(Runnable runnable, int n) {
        if (DEBUG) {
            ThreadPool.debug(new StringBuffer().append("Start thread: pool=").append(this).toString());
        }
        DefaultRunnable defaultRunnable = new DefaultRunnable(this, runnable, n, this.nCreated++);
        new Thread(null, defaultRunnable, defaultRunnable.getBaseThreadName()).start();
        this.nrThreads(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void dump(PrintStream printStream) {
        long l = this.statisticsTotalWaitCount > 0L ? this.statisticsTotalWaitTime / this.statisticsTotalWaitCount : 0L;
        long l2 = this.statisticsTotalRunCount > 0L ? this.statisticsTotalExecutionTime / this.statisticsTotalRunCount : 0L;
        long l3 = 0L;
        ThreadPool threadPool = this;
        synchronized (threadPool) {
            if (!this.jobs.isEmpty()) {
                JobListElement jobListElement = (JobListElement)this.jobs.get(0);
                l3 = this.timeSource.getCurrentTime() - jobListElement.insertTime;
            }
        }
        printStream.println(new StringBuffer().append("[ ThreadPool: ").append(this.name).append(" ]").toString());
        printStream.println("Threads");
        printStream.println(new StringBuffer().append("  active           : current=").append(this.getNrThreads()).append(", max=").append(this.statisticsMaxRun).append(", limit=").append(this.max).toString());
        printStream.println(new StringBuffer().append("  idle             : current=").append(this.getNrIdle()).append(", max=").append(this.statisticsMaxIdle).append(", keepAlive=").append(this.min).toString());
        printStream.println(new StringBuffer().append("  statistics       : maxExecutionTime=").append(this.statisticsMaxExecutionTime).append(", avgExecutionTime=").append(l2).append(", totalExecutionTime=").append(this.statisticsTotalExecutionTime).append(", processedJobs=").append(this.statisticsTotalRunCount).toString());
        printStream.println(new StringBuffer().append("  default priority : ").append(this.defPriority).toString());
        printStream.println(new StringBuffer().append("  idle latency     : ").append(this.latency).toString());
        printStream.println("Queue");
        printStream.println(new StringBuffer().append("  jobs             : current=").append(this.getNrWaiting()).append(", max=").append(this.statisticsMaxWait).append(", limit=").append(this.jobQueueSize).toString());
        printStream.println(new StringBuffer().append("  statistics       : maxWaitTime=").append(this.statisticsMaxWaitTime).append(", avgWaitTime=").append(l).append(", totalWaitTime=").append(this.statisticsTotalWaitTime).append(", processedJobs=").append(this.statisticsTotalWaitCount).toString());
        printStream.println(new StringBuffer().append("  time limits      : warning=").append(this.getMaxWaitTime()).toString());
        printStream.println(new StringBuffer().append("  waitForExecution : current=").append(l3).toString());
        printStream.println("");
    }

    private final void printDelayWarning(Object object, long l, String string) {
        System.out.println("====================================================================");
        System.out.println(new StringBuffer().append("WARNING!!! Element ").append(object).append(string).append(l).append(" ms!").toString());
        this.dump(System.out);
        System.out.println("====================================================================");
    }

    static /* synthetic */ boolean access$200() {
        return DEBUG;
    }

    static /* synthetic */ long access$308(ThreadPool threadPool) {
        return threadPool.statisticsTotalRunCount++;
    }

    static /* synthetic */ long access$414(ThreadPool threadPool, long l) {
        return threadPool.statisticsTotalExecutionTime += l;
    }

    static /* synthetic */ long access$500(ThreadPool threadPool) {
        return threadPool.statisticsMaxExecutionTime;
    }

    static /* synthetic */ long access$502(ThreadPool threadPool, long l) {
        threadPool.statisticsMaxExecutionTime = l;
        return threadPool.statisticsMaxExecutionTime;
    }

    static /* synthetic */ Runnable access$600(ThreadPool threadPool) {
        return threadPool.getNextJob();
    }

    static /* synthetic */ void access$700(ThreadPool threadPool, int n) {
        threadPool.idleThreads(n);
    }

    static /* synthetic */ long access$800(ThreadPool threadPool) {
        return threadPool.getLatency();
    }

    static /* synthetic */ boolean access$900(ThreadPool threadPool) {
        return threadPool.check_shutdown();
    }

    static /* synthetic */ void access$1000(ThreadPool threadPool, int n) {
        threadPool.nrThreads(n);
    }

    private static class JobListElement {
        Runnable job;
        long insertTime;

        JobListElement(Runnable runnable, long l) {
            this.job = runnable;
            this.insertTime = l;
        }
    }

    private static class DefaultRunnable
    implements Runnable {
        private final ThreadPool pool;
        private Runnable job;
        private int priority;
        private final int nr;

        DefaultRunnable(ThreadPool threadPool, Runnable runnable, int n, int n2) {
            this.pool = threadPool;
            this.job = runnable;
            this.priority = n;
            this.nr = n2;
        }

        String getBaseThreadName() {
            return "fw[" + this.pool.name + ':' + this.nr + ']';
        }

        private void changeThreadName(Thread thread, boolean bl) {
            String string = "(idle)";
            if (bl) {
                thread.setName(this.getBaseThreadName() + string);
            } else {
                thread.setName(this.getBaseThreadName());
            }
        }

        /*
         * Exception decompiling
         */
        public void run() {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 28[WHILELOOP]
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
             *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
             *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
             *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:923)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
             *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
             *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
             *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
             *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
             *     at org.benf.cfr.reader.Main.main(Main.java:54)
             */
            throw new IllegalStateException("Decompilation failed");
        }
    }

    private static class PriorizedRunnable
    implements Runnable {
        private final Runnable job;
        private final int priority;

        private PriorizedRunnable(Runnable runnable, int n) {
            this.job = runnable;
            this.priority = n;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            int n = Thread.currentThread().getPriority();
            Thread.currentThread().setPriority(this.priority);
            try {
                this.job.run();
            }
            finally {
                Thread.currentThread().setPriority(n);
            }
        }
    }
}

