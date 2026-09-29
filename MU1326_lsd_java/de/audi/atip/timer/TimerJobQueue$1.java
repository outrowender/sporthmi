/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerDispatcher;
import de.audi.atip.timer.TimerJobQueue;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.List;

class TimerJobQueue$1
extends BaseJobFilter {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ TimerJobQueue this$0;

    TimerJobQueue$1(TimerJobQueue timerJobQueue, LogChannel logChannel) {
        this.this$0 = timerJobQueue;
        this.val$log = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enqueue(Job job, int n) {
        Object object = job.getPayload();
        if (object instanceof Timer) {
            long l = TimerDispatcher.getMonotonicTime();
            TimerJobQueue timerJobQueue = this.this$0;
            synchronized (timerJobQueue) {
                Timer timer = (Timer)object;
                if (null != timer.getParent()) {
                    Job job2 = TimerJobQueue.access$000(this.this$0, timer);
                    if (this.this$0 == timer.getParent() && job2 != null) {
                        if (this.val$log != null) {
                            this.val$log.log(-1601830656, "timer %1 already enqueued, re-enque timer", (Object)timer);
                        }
                        TimerJobQueue.access$100(this.this$0).remove(job2);
                    } else {
                        throw new UnsupportedOperationException(new StringBuffer().append("can not start already running timer! ").append(job).toString());
                    }
                }
                job.setPosted(l);
                long l2 = l + timer.getDelay();
                timer.setDue(l2);
                timer.setParent(this.this$0);
                List list = TimerJobQueue.access$200(this.this$0);
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
                this.this$0.isQueueChangedExternal = true;
                super.notifyAll();
            }
        } else {
            throw new IllegalArgumentException("can't add non timer jobs!");
        }
    }

    public String toString() {
        return "Timer: TimerEnqueueJobFilter";
    }
}

