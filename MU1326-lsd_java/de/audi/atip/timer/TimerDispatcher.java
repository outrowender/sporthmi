/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.TimerDispatcher$NullTimer;
import de.audi.atip.timer.TimerDispatcher$TimerInfoProvider;
import de.audi.atip.timer.TimerDispatcher$TimerRunInterceptor;
import de.audi.atip.timer.TimerJobQueue;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public final class TimerDispatcher {
    private static IFrameworkAccess framework = null;
    private static TimerDispatcher[] dispatchers = new TimerDispatcher[11];
    static LogChannel defaultLog = null;
    private LogChannel log = null;
    private final DispatcherBase dispatcher;
    private final TimerJobQueue queue;
    private final String name;

    public static final void init(IFrameworkAccess iFrameworkAccess) {
        framework = iFrameworkAccess;
        iFrameworkAccess.getErrorMgr().registerDumpInfoProvider(new TimerDispatcher$TimerInfoProvider(null));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static TimerDispatcher getForPriority(int n) {
        TimerDispatcher timerDispatcher = null;
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException();
        }
        TimerDispatcher[] timerDispatcherArray = dispatchers;
        synchronized (dispatchers) {
            timerDispatcher = dispatchers[n];
            if (timerDispatcher == null) {
                TimerDispatcher.dispatchers[n] = timerDispatcher = new TimerDispatcher(n);
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return timerDispatcher;
        }
    }

    public static void setLog(LogChannel logChannel) {
        defaultLog = logChannel;
    }

    public static long getMonotonicTime() {
        return framework.getMonotonicTime();
    }

    static synchronized void dumpAll(PrintStream printStream, long l) {
        for (int i2 = 0; i2 < dispatchers.length; ++i2) {
            TimerDispatcher timerDispatcher = dispatchers[i2];
            if (timerDispatcher == null) continue;
            printStream.println();
            printStream.println(timerDispatcher);
            timerDispatcher.getQueue().dumpQueue(printStream, l);
        }
    }

    private TimerDispatcher(int n) {
        this.name = new StringBuffer().append("TimerDispatcher-").append(n).toString();
        this.log = defaultLog;
        if (this.log != null) {
            this.log.log(-2137614336, "%1 new", (Object)this);
        }
        this.queue = new TimerJobQueue(this.log, framework.getMonotonicTimeSource());
        this.dispatcher = framework.getDispatcherManager().createDispatcher(this.name, new JobLogger(this.log), this.queue, new TimerDispatcher$TimerRunInterceptor(null), new Job(new TimerDispatcher$NullTimer()));
        this.dispatcher.setPriority(n);
        this.dispatcher.start();
    }

    protected TimerJobQueue getQueue() {
        return this.queue;
    }

    public String toString() {
        return this.name;
    }

    static /* synthetic */ IFrameworkAccess access$100() {
        return framework;
    }
}

