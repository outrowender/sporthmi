/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerDispatcher;
import de.audi.atip.timer.TimerJobQueue$1;
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

    public TimerJobQueue(LogChannel logChannel, ITimeSource iTimeSource) {
        super(iTimeSource);
        this.log = logChannel;
        this.initFilterChain(new TimerJobQueue$1(this, logChannel));
    }

    @Override
    public synchronized Job getNextJob() {
        long l;
        Timer timer;
        Job job;
        while (true) {
            if (this.getJobs().isEmpty()) {
                try {
                    super.wait();
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
                    this.log.log(-2137614336, "%1 in queue %2 was triggered to early %3ms", (Object)timer, (Object)this, l);
                }
                super.wait(l);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
        this.isQueueChangedExternal = false;
        if (this.log != null) {
            this.log.log(-2137614336, "%1 waiting %2ms", (Object)this, -l);
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
            this.log.log(-2137614336, "cancelTimer %1 in queue %2", (Object)timer, (Object)this);
        }
        if ((job = this.lookupPayload(timer)) != null) {
            this.getJobs().remove(job);
            this.isQueueChangedExternal = true;
            timer.setParent(null);
            super.notifyAll();
            return true;
        }
        if (this.log != null) {
            this.log.log(-2137614336, "cancelTimer %1 in queue %2 failed, job not exists!", (Object)timer, (Object)this);
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

    static /* synthetic */ Job access$000(TimerJobQueue timerJobQueue, Object object) {
        return timerJobQueue.lookupPayload(object);
    }

    static /* synthetic */ List access$100(TimerJobQueue timerJobQueue) {
        return timerJobQueue.getJobs();
    }

    static /* synthetic */ List access$200(TimerJobQueue timerJobQueue) {
        return timerJobQueue.getJobs();
    }
}

