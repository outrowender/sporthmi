/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.StatisticData;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.PrintStream;

public class StatisticInterceptor
extends BaseInterceptor
implements IInterceptor {
    private final String name;
    private final DispatcherBase dispatcher;
    private final ITimeSource timeSource;
    private final IJobLogger log;
    private final long sampleInterval;
    private final long started;
    private final StatisticData[] history;
    private int historyStart = 0;
    private long processedJobs = 0L;
    private long totalProcessing = 0L;
    private long totalLatency = 0L;
    protected long lastSample = 0L;
    protected long lastNrJobs = 0L;
    protected long lastTimeProcessing = 0L;
    protected long lastTimeLatency = 0L;
    protected long currentDelay = 0L;
    protected long currentJobRate = 0L;
    protected long currentJobLoad = 0L;
    protected long averageLatency = 0L;

    public StatisticInterceptor(DispatcherBase dispatcherBase, IJobLogger iJobLogger, int n, int n2) {
        this.dispatcher = dispatcherBase;
        this.name = dispatcherBase.getName();
        this.timeSource = dispatcherBase.getTimeSource();
        this.log = iJobLogger;
        this.lastSample = this.started = this.timeSource.getCurrentTime();
        this.sampleInterval = (long)n > 1000L ? (long)n : 1000L;
        this.history = n2 > 0 ? new StatisticData[n2] : null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execute(Job job) {
        try {
            this.currentDelay = this.timeSource.getCurrentTime() - job.getDue();
            super.execute(job);
        }
        finally {
            this.totalProcessing += job.getNeeded();
            this.totalLatency += job.getLatency();
            ++this.processedJobs;
            if (this.timeSource.getCurrentTime() - this.lastSample > this.sampleInterval) {
                this.sample();
            }
        }
    }

    public long getProcessedJobs() {
        return this.processedJobs;
    }

    public long getTimeProcessing() {
        return this.totalProcessing;
    }

    public long getTimeLatency() {
        return this.totalLatency;
    }

    public long getRunningTime() {
        return this.timeSource.getCurrentTime() - this.started;
    }

    public long getCurrentDelay() {
        return this.currentDelay;
    }

    private void keepSample() {
        if (this.history != null) {
            this.history[this.historyStart] = this.dispatcher.getStatistics();
            ++this.historyStart;
            if (this.historyStart >= this.history.length) {
                this.historyStart = 0;
            }
        }
    }

    public void sample() {
        long l = this.timeSource.getCurrentTime();
        long l2 = l - this.lastSample;
        long l3 = this.processedJobs - this.lastNrJobs;
        if (l2 > 0L) {
            this.currentJobRate = l3 * 1000L / l2;
            this.currentJobLoad = (this.totalProcessing - this.lastTimeProcessing) * 100L / l2;
            long l4 = this.averageLatency = l3 > 0L ? (this.totalLatency - this.lastTimeLatency) / l3 : 0L;
            if (this.log != null) {
                this.log.log(10000000, "%1 - processing: %2/s, load: %3%%", (Object)this.name, (int)this.currentJobRate, (int)this.currentJobLoad);
                this.log.log(10000000, "%1 - average latency: %2ms", (Object)this.name, (int)this.averageLatency);
            }
            this.lastSample = l;
            this.lastNrJobs = this.processedJobs;
            this.lastTimeProcessing = this.totalProcessing;
            this.lastTimeLatency = this.totalLatency;
            this.keepSample();
        }
    }

    public long getLoad() {
        long l = this.getRunningTime();
        return l > 0L ? 100L * this.totalProcessing / l : 0L;
    }

    public long getCurrentJobRate() {
        return this.currentJobRate;
    }

    public long getCurrentJobLoad() {
        return this.currentJobLoad;
    }

    public void logStatistics() {
        if (this.log != null) {
            long l = this.timeSource.getCurrentTime() - this.started;
            long l2 = this.processedJobs > 0L ? this.totalProcessing / this.processedJobs : 0L;
            long l3 = l > 0L ? 100L * this.totalProcessing / l : 0L;
            long l4 = this.processedJobs > 0L ? this.totalLatency / this.processedJobs : 0L;
            this.log.log(1000000, "%1: Latency: total: %2ms, avg: %3ms", (Object)this.name, (int)this.totalLatency, (int)l4);
            this.log.log(1000000, "%1: Processing: total: %2ms, avg: %3ms", (Object)this.name, (int)this.totalProcessing, (int)l2);
            this.log.log(1000000, "%1: Total jobs: %2, load: %3%%", (Object)this.name, (int)this.processedJobs, (int)l3);
        }
    }

    public void dump(PrintStream printStream) {
        if (printStream != null) {
            long l = this.timeSource.getCurrentTime() - this.started;
            long l2 = this.processedJobs > 0L ? this.totalProcessing / this.processedJobs : 0L;
            long l3 = this.processedJobs > 0L ? this.totalLatency / this.processedJobs : 0L;
            long l4 = l > 0L ? 100L * this.totalProcessing / l : 0L;
            printStream.println("Statistic(" + this.name + "):");
            printStream.println("  total running time: " + l + "ms");
            printStream.println("  jobs processed: " + this.processedJobs);
            printStream.println("  processing time: total: " + this.totalProcessing + "ms avg. per job: " + l2 + "ms");
            printStream.println("  latency time:    total: " + this.totalLatency + "ms avg. per job: " + l3 + "ms");
            printStream.println("  load: " + l4 + "%");
            printStream.println();
            if (this.history != null) {
                int n;
                printStream.println("  Statistic History:");
                for (n = this.historyStart; n < this.history.length; ++n) {
                    if (this.history[n] == null) continue;
                    this.history[n].dump(printStream, "    ");
                }
                for (n = 0; n < this.historyStart; ++n) {
                    if (this.history[n] == null) continue;
                    this.history[n].dump(printStream, " ");
                }
            }
            super.dump(printStream);
        }
    }
}

