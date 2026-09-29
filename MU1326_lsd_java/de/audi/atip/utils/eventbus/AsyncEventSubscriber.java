/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.AsyncEventSubscriber$1;
import de.audi.atip.utils.eventbus.EventSubscriber;
import de.audi.atip.utils.eventbus.SubscriberExceptionHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.lang.reflect.Method;

class AsyncEventSubscriber
extends EventSubscriber {
    private final DispatcherBase dispatcher;

    AsyncEventSubscriber(Object object, Method method, DispatcherBase dispatcherBase, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(object, method, subscriberExceptionHandler);
        this.dispatcher = dispatcherBase;
    }

    @Override
    public void handleEvent(Object object) {
        this.dispatcher.execute(new AsyncEventSubscriber$1(this, object));
    }

    static /* synthetic */ void access$001(AsyncEventSubscriber asyncEventSubscriber, Object object) {
        super.handleEvent(object);
    }
}

