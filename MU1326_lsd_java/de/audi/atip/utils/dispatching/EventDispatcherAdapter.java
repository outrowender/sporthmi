/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.esolutions.fw.util.commons.job.Job;

public class EventDispatcherAdapter
implements IDispatcher {
    private final EventDispatcher eventDispatcher;

    public EventDispatcherAdapter(EventDispatcher eventDispatcher) {
        this.eventDispatcher = Preconditions.checkNotNull(eventDispatcher);
    }

    public boolean isDispatchThread() {
        return this.eventDispatcher.isDispatchThread();
    }

    public IDispatcher.ICancelable execute(Runnable runnable, long l) {
        final Job job = this.eventDispatcher.postEvent(new RunnableEvent(true, runnable), l);
        return new IDispatcher.ICancelable(){

            public void cancel() {
                job.cancel();
            }
        };
    }

    public void execute(Runnable runnable) {
        this.eventDispatcher.postEvent(new RunnableEvent(true, runnable));
    }
}

