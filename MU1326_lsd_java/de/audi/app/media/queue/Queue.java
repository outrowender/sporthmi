/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.queue;

import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.queue.IQueueCommand;
import de.audi.app.media.queue.IQueueExecutionContext;
import de.audi.app.media.queue.IQueueInterceptor;
import de.audi.app.media.queue.IQueueJob;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Queue
implements IDiagnosisDataProvider {
    private static final String LOGCLASS = "Queue";
    private static final int NO_FIXED_SIZE = -1;
    private final String queueName;
    private final LogChannel logChannel;
    final LinkedList queue = new LinkedList();
    private final Object mutex = new Object();
    private final int fixedSize;
    private IQueueJob currentRunningJob;
    private final LinkedList interceptorList = new LinkedList();

    public Queue(LogChannel logChannel, String string) {
        this(logChannel, string, -1);
    }

    public Queue(LogChannel logChannel, String string, int n) {
        this.logChannel = logChannel;
        this.queueName = string;
        this.fixedSize = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        this.logChannel.log(1000000, "[%1.reset] [%2]", (Object)LOGCLASS, (Object)this.queueName);
        Object object = this.mutex;
        synchronized (object) {
            this.queue.clear();
            this.currentRunningJob = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeQueuedJobs() {
        this.logChannel.log(1000000, "[%1.removeQueuedJobs] [%2]", (Object)LOGCLASS, (Object)this.queueName);
        Object object = this.mutex;
        synchronized (object) {
            this.queue.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addInterceptor(IQueueInterceptor iQueueInterceptor) {
        this.logChannel.log(1000000, "[%1.addInterceptor] [%2] '%3'.", (Object)LOGCLASS, (Object)this.queueName, (Object)iQueueInterceptor);
        if (iQueueInterceptor == null) {
            throw new IllegalArgumentException();
        }
        Object object = this.mutex;
        synchronized (object) {
            this.interceptorList.add(iQueueInterceptor);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enqueueExclusive(IQueueJob iQueueJob) {
        if (iQueueJob == null) {
            this.logChannel.log(100000, "[Queue.enqueueExclusive] [%1] called with NULL", (Object)this.queueName);
            return;
        }
        this.logChannel.log(1000000, "[Queue.enqueueExclusive] [%1] called with %2", (Object)this.queueName, (Object)iQueueJob);
        Object object = this.mutex;
        synchronized (object) {
            this.abort(new Class[]{iQueueJob.getClass()});
            this.enqueue(iQueueJob);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enqueue(IQueueJob iQueueJob) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentRunningJob == null) {
                this.currentRunningJob = iQueueJob;
                this.logChannel.log(1000000, "[%1.enqueue] [%2] Start '%3' ('%4').", (Object)LOGCLASS, (Object)this.queueName, (Object)iQueueJob.getName(), (Object)iQueueJob);
                bl = true;
            } else {
                this.logChannel.log(1000000, "[%1.enqueue] [%2] Queue '%3' ('%4').", (Object)LOGCLASS, (Object)this.queueName, (Object)iQueueJob.getName(), (Object)iQueueJob);
                Iterator iterator = this.interceptorList.iterator();
                while (iterator.hasNext()) {
                    IQueueInterceptor iQueueInterceptor = (IQueueInterceptor)iterator.next();
                    iQueueInterceptor.execute(iQueueJob, this.queue);
                }
                if (this.fixedSize == -1) {
                    this.queue.add(iQueueJob);
                } else {
                    if (this.queue.size() == this.fixedSize) {
                        this.logChannel.log(1000000, "[%1.enqueue] [%2] Replace last job '%3'.", (Object)LOGCLASS, (Object)this.queueName, (Object)((IQueueJob)this.queue.getLast()).getName());
                        this.queue.removeLast();
                    }
                    this.queue.add(iQueueJob);
                }
            }
        }
        if (bl) {
            this.currentRunningJob.start(new QueueExecutionContextImpl(this));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void jobFinished() {
        Object object = this.mutex;
        synchronized (object) {
            IQueueJob iQueueJob;
            this.logChannel.log(1000000, "[%1.jobFinished] [%2] '%3'.", (Object)LOGCLASS, (Object)this.queueName, (Object)(null == this.currentRunningJob ? "No running job." : this.currentRunningJob.getName()));
            if (this.queue.isEmpty()) {
                this.currentRunningJob = null;
                return;
            }
            this.currentRunningJob = iQueueJob = (IQueueJob)this.queue.removeFirst();
            this.logChannel.log(1000000, "[%1.jobFinished] [%2] Start '%3' ('%4').", (Object)LOGCLASS, (Object)this.queueName, (Object)this.currentRunningJob.getName(), (Object)this.currentRunningJob);
        }
        this.currentRunningJob.start(new QueueExecutionContextImpl(this));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IQueueJob getRunningJob() {
        Object object = this.mutex;
        synchronized (object) {
            return this.currentRunningJob;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isRunning(IQueueJob iQueueJob) {
        Object object = this.mutex;
        synchronized (object) {
            return this.currentRunningJob == iQueueJob;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void executeQueueCommand(IQueueCommand iQueueCommand) {
        Object object = this.mutex;
        synchronized (object) {
            iQueueCommand.execute(this.currentRunningJob, this.queue);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abort() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.currentRunningJob == null) {
                this.logChannel.log(1000000, "[%1.abort] [%2] No running job.", (Object)LOGCLASS, (Object)this.queueName);
                return;
            }
            this.logChannel.log(1000000, "[%1.abort] [%2] Abort running job", (Object)LOGCLASS, (Object)this.queueName);
            this.currentRunningJob.abort(true);
            this.currentRunningJob = null;
            if (this.queue.isEmpty()) {
                return;
            }
            this.logChannel.log(1000000, "[%1.abort] [%2] Abort all queued jobs", (Object)LOGCLASS, (Object)this.queueName);
            Iterator iterator = this.queue.iterator();
            while (iterator.hasNext()) {
                ((IQueueJob)iterator.next()).abort(false);
            }
            this.queue.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void abort(Class[] classArray) {
        Object object = this.mutex;
        synchronized (object) {
            IQueueJob iQueueJob;
            if (classArray == null || classArray.length == 0) {
                this.logChannel.log(1000000, "[%1.abort] [%2] empty or NULL filter", (Object)LOGCLASS, (Object)this.queueName);
                return;
            }
            if (this.currentRunningJob == null) {
                this.logChannel.log(1000000, "[%1.abort] [%2] No running job.", (Object)LOGCLASS, (Object)this.queueName);
                return;
            }
            List list = Arrays.asList(classArray);
            if (list.contains(this.currentRunningJob.getClass())) {
                this.logChannel.log(1000000, "[%1.abort] [%2] Abort running job with class %2", (Object)LOGCLASS, (Object)this.queueName, (Object)this.currentRunningJob.getClass());
                this.currentRunningJob.abort(true);
                this.currentRunningJob = null;
            }
            if (this.queue.isEmpty()) {
                return;
            }
            this.logChannel.log(1000000, "[%1.abort] [%2] Abort all queued jobs for filter %3", (Object)LOGCLASS, (Object)this.queueName, (Object)String.valueOf(classArray));
            Iterator iterator = this.queue.iterator();
            while (iterator.hasNext()) {
                iQueueJob = (IQueueJob)iterator.next();
                if (!list.contains(iQueueJob.getClass())) continue;
                iQueueJob.abort(false);
            }
            for (int i2 = this.queue.size() - 1; i2 >= 0; --i2) {
                iQueueJob = (IQueueJob)this.queue.get(i2);
                if (!list.contains(iQueueJob.getClass())) continue;
                this.queue.remove(iQueueJob);
            }
            if (this.currentRunningJob == null && !this.queue.isEmpty()) {
                this.jobFinished();
            }
        }
    }

    public String getDiagKey() {
        return this.queueName;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getDiagValue() {
        LinkedList linkedList;
        IQueueJob iQueueJob;
        Object object = this.mutex;
        synchronized (object) {
            iQueueJob = this.currentRunningJob;
            linkedList = new LinkedList(this.queue);
        }
        object = new Buffer();
        ((Buffer)object).append("Running Job: ");
        ((Buffer)object).append(iQueueJob != null ? iQueueJob.toString() : "no running job");
        ((Buffer)object).append("\nWaiting Jobs: ");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            IQueueJob iQueueJob2 = (IQueueJob)iterator.next();
            ((Buffer)object).append(iQueueJob2.toString());
            ((Buffer)object).append("\n              ");
        }
        return ((Buffer)object).toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean contains(Class clazz) {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.queue.size(); ++i2) {
                if (this.queue.get(i2).getClass() != clazz) continue;
                return true;
            }
        }
        return false;
    }

    private class QueueExecutionContextImpl
    implements IQueueExecutionContext {
        private final Queue queue;

        public QueueExecutionContextImpl(Queue queue2) {
            this.queue = queue2;
        }

        public void jobFinished() {
            this.queue.jobFinished();
        }
    }
}

