/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

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

    public void handleEvent(final Object object) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                AsyncEventSubscriber.super.handleEvent(object);
            }
        });
    }
}

