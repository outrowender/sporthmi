/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.util.List;

public class TimedJobQueue
extends JobQueue {
    public TimedJobQueue(ITimeSource iTimeSource) throws UnsupportedOperationException {
        super(iTimeSource, null);
        this.initFilterChain(new BaseJobFilter(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void enqueue(Job job, int n) {
                long l = TimedJobQueue.this.getTimeSource().getCurrentTime();
                job.setPosted(l);
                TimedJobQueue timedJobQueue = TimedJobQueue.this;
                synchronized (timedJobQueue) {
                    List list = TimedJobQueue.this.getJobs();
                    boolean bl = false;
                    for (int i2 = 0; i2 < list.size(); ++i2) {
                        Job job2 = TimedJobQueue.this.getJob(i2);
                        if (job2.getDue() <= job.getDue()) continue;
                        list.add(i2, job);
                        bl = true;
                        break;
                    }
                    if (!bl) {
                        list.add(job);
                    }
                    TimedJobQueue.this.notifyAll();
                }
            }

            public String toString() {
                return "TimedJobQueue: EnqueueFilter";
            }
        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public synchronized Job getNextJob() {
        while (true) {
            this.waitForNextJob();
            if (this.isDead() || this.isWakeup()) {
                this.clearWakeup();
                return this.getNullJob();
            }
            Job job = this.getJob(0);
            if (job.isCanceled()) return this.removeFirstJob();
            long l = job.getDue() - this.getTimeSource().getCurrentTime();
            if (l > 0L) {
                try {
                    this.wait(l);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                continue;
            }
            if (!this.isSuspended()) return this.removeFirstJob();
        }
    }

    public synchronized int getDueJobs() {
        long l = this.getTimeSource().getCurrentTime();
        for (int i2 = 0; i2 < this.length(); ++i2) {
            if (this.getJob(i2).getDue() <= l) continue;
            return i2;
        }
        return this.length();
    }
}

