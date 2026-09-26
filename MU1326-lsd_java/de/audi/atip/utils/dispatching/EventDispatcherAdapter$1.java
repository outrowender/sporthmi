/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.EventDispatcherAdapter;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.esolutions.fw.util.commons.job.Job;

class EventDispatcherAdapter$1
implements IDispatcher$ICancelable {
    private final /* synthetic */ Job val$postEvent;
    private final /* synthetic */ EventDispatcherAdapter this$0;

    EventDispatcherAdapter$1(EventDispatcherAdapter eventDispatcherAdapter, Job job) {
        this.this$0 = eventDispatcherAdapter;
        this.val$postEvent = job;
    }

    @Override
    public void cancel() {
        this.val$postEvent.cancel();
    }
}

