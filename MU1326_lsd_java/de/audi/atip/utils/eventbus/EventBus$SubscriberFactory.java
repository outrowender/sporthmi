/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.EventSubscriber;
import java.lang.reflect.Method;

interface EventBus$SubscriberFactory {
    default public EventSubscriber create(Object object, Method method) {
    }
}

