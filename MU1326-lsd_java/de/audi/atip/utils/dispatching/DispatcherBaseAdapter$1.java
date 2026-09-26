/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.DispatcherBaseAdapter;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.esolutions.fw.util.commons.job.Job;

class DispatcherBaseAdapter$1
implements IDispatcher$ICancelable {
    private final /* synthetic */ Job val$job;
    private final /* synthetic */ DispatcherBaseAdapter this$0;

    DispatcherBaseAdapter$1(DispatcherBaseAdapter dispatcherBaseAdapter, Job job) {
        this.this$0 = dispatcherBaseAdapter;
        this.val$job = job;
    }

    @Override
    public void cancel() {
        this.val$job.cancel();
    }
}

