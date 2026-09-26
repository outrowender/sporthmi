/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.error.IErrorManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.HMIEventDispatcher$HMIEventErrorHandler$1;
import de.esolutions.fw.util.commons.job.IBlockedJobHandler;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;

class HMIEventDispatcher$HMIEventErrorHandler
implements IBlockedJobHandler {
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final JobQueue queue;
    private Job blocker;

    HMIEventDispatcher$HMIEventErrorHandler(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, JobQueue jobQueue) {
        this.framework = iFrameworkAccess;
        this.log = logChannel;
        this.queue = jobQueue;
        this.blocker = null;
    }

    private final IFrameworkAccess getFramework() {
        return this.framework;
    }

    private final IErrorManager getErrorManager() {
        return this.getFramework().getErrorMgr();
    }

    @Override
    public void blocked(Job job, long l) {
        this.blocker = job;
        this.getErrorManager().handleError(null, new StringBuffer().append("ERR: event dispatch thread hanging, event = ").append(job).append(", queue size = ").append(this.queue.length()).toString(), 0, 3, 2, new HMIEventDispatcher$HMIEventErrorHandler$1(this, job));
    }

    @Override
    public void unblocked(Job job) {
        if (job == this.blocker) {
            this.blocker = null;
        }
    }

    @Override
    public void lengthExceeded(int n, int n2) {
        this.log.log(10000, "ERR: event queue size = %1", (long)this.queue.length());
        this.getErrorManager().handleError(null, new StringBuffer().append("ERR: event queue size = ").append(this.queue.length()).toString(), 0, 3, 2);
    }

    @Override
    public void lengthWarning(int n, int n2) {
    }

    static /* synthetic */ Job access$000(HMIEventDispatcher$HMIEventErrorHandler hMIEventDispatcher$HMIEventErrorHandler) {
        return hMIEventDispatcher$HMIEventErrorHandler.blocker;
    }

    static /* synthetic */ LogChannel access$100(HMIEventDispatcher$HMIEventErrorHandler hMIEventDispatcher$HMIEventErrorHandler) {
        return hMIEventDispatcher$HMIEventErrorHandler.log;
    }
}

