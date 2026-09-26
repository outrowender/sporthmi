/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.EventDispatcherAdapter$1;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.esolutions.fw.util.commons.job.Job;

public class EventDispatcherAdapter
implements IDispatcher {
    private final EventDispatcher eventDispatcher;

    public EventDispatcherAdapter(EventDispatcher eventDispatcher) {
        this.eventDispatcher = (EventDispatcher)Preconditions.checkNotNull((Object)eventDispatcher);
    }

    @Override
    public boolean isDispatchThread() {
        return this.eventDispatcher.isDispatchThread();
    }

    @Override
    public IDispatcher$ICancelable execute(Runnable runnable, long l) {
        Job job = this.eventDispatcher.postEvent(new RunnableEvent(true, runnable), l);
        return new EventDispatcherAdapter$1(this, job);
    }

    @Override
    public void execute(Runnable runnable) {
        this.eventDispatcher.postEvent(new RunnableEvent(true, runnable));
    }
}

