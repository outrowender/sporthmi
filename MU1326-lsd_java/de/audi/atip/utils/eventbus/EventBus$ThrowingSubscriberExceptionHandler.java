/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.EventSubscriber;
import de.audi.atip.utils.eventbus.SubscriberExceptionHandler;

final class EventBus$ThrowingSubscriberExceptionHandler
implements SubscriberExceptionHandler {
    public EventBus$ThrowingSubscriberExceptionHandler(String string) {
    }

    @Override
    public void handleException(Throwable throwable, EventSubscriber eventSubscriber) {
        throw new RuntimeException(new StringBuffer().append("Could not dispatch event to ").append(eventSubscriber.getMethod()).toString(), throwable);
    }
}

