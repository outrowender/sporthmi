/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.HMIEventDispatcher;
import de.audi.tghu.fwhmi.HMIEventDispatcher$1;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;

class HMIEventDispatcher$SleepInterceptor
extends BaseInterceptor
implements IInterceptor {
    private boolean queueWasEmpty = true;
    private final /* synthetic */ HMIEventDispatcher this$0;

    private HMIEventDispatcher$SleepInterceptor(HMIEventDispatcher hMIEventDispatcher) {
        this.this$0 = hMIEventDispatcher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Job job) {
        if (this.queueWasEmpty) {
            HMIEventDispatcher.access$500(this.this$0);
        }
        try {
            super.execute(job);
            this.this$0.doCheckedSleepingInternal();
        }
        catch (Throwable throwable) {
            this.this$0.doCheckedSleepingInternal();
            this.queueWasEmpty = HMIEventDispatcher.access$600(this.this$0).getQueue().length() == 0;
            throw throwable;
        }
        this.queueWasEmpty = HMIEventDispatcher.access$600(this.this$0).getQueue().length() == 0;
    }

    /* synthetic */ HMIEventDispatcher$SleepInterceptor(HMIEventDispatcher hMIEventDispatcher, HMIEventDispatcher$1 hMIEventDispatcher$1) {
        this(hMIEventDispatcher);
    }
}

