/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.EventSubscriber;

public interface SubscriberExceptionHandler {
    default public void handleException(Throwable throwable, EventSubscriber eventSubscriber) {
    }
}

