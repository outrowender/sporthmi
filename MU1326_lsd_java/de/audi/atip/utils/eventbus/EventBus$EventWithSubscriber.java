/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.eventbus.EventSubscriber;

class EventBus$EventWithSubscriber {
    final Object event;
    final EventSubscriber subscriber;

    public EventBus$EventWithSubscriber(Object object, EventSubscriber eventSubscriber) {
        Preconditions.checkNotNull((Object)object);
        Preconditions.checkNotNull((Object)eventSubscriber);
        this.event = object;
        this.subscriber = eventSubscriber;
    }
}

