/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.tv.app.util.IDispatcher;

public class Handler$EventDispatcherDispatcher
implements IDispatcher {
    private final EventDispatcher dispatcher;

    public Handler$EventDispatcherDispatcher(EventDispatcher eventDispatcher) {
        this.dispatcher = eventDispatcher;
    }

    @Override
    public void execute(Runnable runnable) {
        this.dispatcher.postEvent(new RunnableEvent(false, runnable));
    }
}

