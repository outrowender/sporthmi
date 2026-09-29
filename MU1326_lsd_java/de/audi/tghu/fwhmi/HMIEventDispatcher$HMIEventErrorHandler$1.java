/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.error.ShutdownGuard;
import de.audi.tghu.fwhmi.HMIEventDispatcher$HMIEventErrorHandler;
import de.esolutions.fw.util.commons.job.Job;

class HMIEventDispatcher$HMIEventErrorHandler$1
implements ShutdownGuard {
    Object cause;
    private final /* synthetic */ Job val$job;
    private final /* synthetic */ HMIEventDispatcher$HMIEventErrorHandler this$0;

    HMIEventDispatcher$HMIEventErrorHandler$1(HMIEventDispatcher$HMIEventErrorHandler hMIEventDispatcher$HMIEventErrorHandler, Job job) {
        this.this$0 = hMIEventDispatcher$HMIEventErrorHandler;
        this.val$job = job;
        this.cause = this.val$job;
    }

    @Override
    public boolean queryShutdown() {
        HMIEventDispatcher$HMIEventErrorHandler.access$100(this.this$0).log(-1601830656, "queryShutdown: cause: %1, blocker", this.cause, (Object)HMIEventDispatcher$HMIEventErrorHandler.access$000(this.this$0));
        return this.cause == HMIEventDispatcher$HMIEventErrorHandler.access$000(this.this$0);
    }
}

