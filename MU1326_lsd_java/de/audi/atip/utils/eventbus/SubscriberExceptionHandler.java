/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.EventSubscriber;

public interface SubscriberExceptionHandler {
    public void handleException(Throwable var1, EventSubscriber var2);
}

