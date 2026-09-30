/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util.jobqueue;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.Logger;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class TunerJobQueue {
    private static final String TUNER_JOB_QUEUE_NAME = "TunerJobs";
    private final DispatcherBase dispatcher;
    private final LogChannel lc;

    public TunerJobQueue(Logger logger, IFrameworkAccess iFrameworkAccess) {
        this.lc = logger.jobs;
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher(TUNER_JOB_QUEUE_NAME, new JobLogger(this.lc));
        this.dispatcher.start();
    }

    public void enqueue(Runnable runnable) {
        this.lc.log(10000000, "[TunerJobQueue.enqueue] Queuing %1", (Object)runnable.toString());
        this.dispatcher.execute(runnable);
    }

    public boolean isJobQueueDispatchThread() {
        return this.dispatcher.isDispatchThread();
    }
}

