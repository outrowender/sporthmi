/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.HMIEventDispatcher;
import de.esolutions.fw.util.commons.job.BaseInterceptor;
import de.esolutions.fw.util.commons.job.Job;

class HMIEventDispatcher$3
extends BaseInterceptor {
    private final /* synthetic */ HMIEventDispatcher this$0;

    HMIEventDispatcher$3(HMIEventDispatcher hMIEventDispatcher) {
        this.this$0 = hMIEventDispatcher;
    }

    @Override
    public void execute(Job job) {
        super.execute(job);
        int n = (int)job.getNeeded();
        if (n > 200) {
            HMIEventDispatcher.access$400(this.this$0).log(-2137614336, "Slow Event [%1] needed %2ms", (Object)job, (long)n);
        }
    }
}

