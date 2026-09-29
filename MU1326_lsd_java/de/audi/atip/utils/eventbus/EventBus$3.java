/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.eventbus.EventBus;
import de.audi.atip.utils.eventbus.EventSubscriber;

class EventBus$3
implements Predicate {
    private final /* synthetic */ Object val$object;
    private final /* synthetic */ EventBus this$0;

    EventBus$3(EventBus eventBus, Object object) {
        this.this$0 = eventBus;
        this.val$object = object;
    }

    public boolean apply(EventSubscriber eventSubscriber) {
        return eventSubscriber.getSubscriber() == this.val$object;
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((EventSubscriber)object);
    }
}

