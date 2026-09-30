/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerDispatcher;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

final class TimerJobQueue
extends JobQueue {
    private final LogChannel log;
    boolean isQueueChangedExternal = false;

    private Job lookupPayload(Object object) {
        Iterator iterator = this.getJobs().iterator();
        while (iterator.hasNext()) {
            Job job = (Job)iterator.next();
            if (job.getPayload() != object) continue;
            return job;
        }
        return null;
    }

    public TimerJobQueue(final LogChannel logChannel, ITimeSource iTimeSource) throws UnsupportedOperationException {
        super(iTimeSource);
        this.log = logChannel;
        this.initFilterChain(new BaseJobFilter(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void enqueue(Job job, int n) {
                Object object = job.getPayload();
                if (object instanceof Timer) {
                    long l = TimerDispatcher.getMonotonicTime();
                    TimerJobQueue timerJobQueue = TimerJobQueue.this;
                    synchronized (timerJobQueue) {
                        Timer timer = (Timer)object;
                        if (null != timer.getParent()) {
                            Job job2 = TimerJobQueue.this.lookupPayload(timer);
                            if (TimerJobQueue.this == timer.getParent() && job2 != null) {
                                if (logChannel != null) {
                                    logChannel.log(100000, "timer %1 already enqueued, re-enque timer", (Object)timer);
                                }
                                TimerJobQueue.this.getJobs().remove(job2);
                            } else {
                                throw new UnsupportedOperationException(new StringBuffer().append("can not start already running timer! ").append(job).toString());
                            }
                        }
                        job.setPosted(l);
                        long l2 = l + timer.getDelay();
                        timer.setDue(l2);
                        timer.setParent(TimerJobQueue.this);
                        List list = TimerJobQueue.this.getJobs();
                        int n2 = list.size();
                        boolean bl = false;
                        for (int i2 = 0; i2 < n2; ++i2) {
                            Job job3 = (Job)list.get(i2);
                            Timer timer2 = (Timer)job3.getPayload();
                            if (timer2.getDue() <= l2) continue;
                            list.add(i2, job);
                            bl = true;
                            break;
                        }
                        if (!bl) {
                            list.add(job);
                        }
                        TimerJobQueue.this.isQueueChangedExternal = true;
                        TimerJobQueue.this.notifyAll();
                    }
                } else {
                    throw new IllegalArgumentException("can't add non timer jobs!");
                }
            }

            public String toString() {
                return "Timer: TimerEnqueueJobFilter";
            }
        });
    }

    public synchronized Job getNextJob() {
        long l;
        Timer timer;
        Job job;
        while (true) {
            if (this.getJobs().isEmpty()) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
                continue;
            }
            job = (Job)this.getJobs().get(0);
            timer = (Timer)job.getPayload();
            l = timer.getDue() - TimerDispatcher.getMonotonicTime();
            if (l <= 0L) break;
            try {
                if (this.log != null && !this.isQueueChangedExternal) {
                    this.log.log(10000000, "%1 in queue %2 was triggered to early %3ms", (Object)timer, (Object)this, l);
                }
                this.wait(l);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
        this.isQueueChangedExternal = false;
        if (this.log != null) {
            this.log.log(10000000, "%1 waiting %2ms", (Object)this, -l);
        }
        job = (Job)this.getJobs().remove(0);
        timer = (Timer)job.getPayload();
        timer.setParent(null);
        if (!timer.isSingleShot()) {
            this.enqueue(job);
        }
        return job;
    }

    synchronized boolean cancelJob(Timer timer) {
        Job job;
        if (this.log != null) {
            this.log.log(10000000, "cancelTimer %1 in queue %2", (Object)timer, (Object)this);
        }
        if ((job = this.lookupPayload(timer)) != null) {
            this.getJobs().remove(job);
            this.isQueueChangedExternal = true;
            timer.setParent(null);
            this.notifyAll();
            return true;
        }
        if (this.log != null) {
            this.log.log(10000000, "cancelTimer %1 in queue %2 failed, job not exists!", (Object)timer, (Object)this);
        }
        return false;
    }

    synchronized void dumpQueue(PrintStream printStream, long l) {
        List list = this.getJobs();
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Timer timer = (Timer)((Job)list.get(i2)).getPayload();
            printStream.println(new StringBuffer().append("at ").append(timer.getDue()).append(" in ").append(timer.getDue() - l).append(" trigger: ").append(timer).toString());
        }
    }
}

