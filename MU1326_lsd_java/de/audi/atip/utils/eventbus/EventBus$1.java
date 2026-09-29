/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.EventBus;
import de.audi.atip.utils.eventbus.EventBus$SubscriberFactory;
import de.audi.atip.utils.eventbus.EventSubscriber;
import java.lang.reflect.Method;

class EventBus$1
implements EventBus$SubscriberFactory {
    private final /* synthetic */ EventBus this$0;

    EventBus$1(EventBus eventBus) {
        this.this$0 = eventBus;
    }

    @Override
    public EventSubscriber create(Object object, Method method) {
        return new EventSubscriber(object, method, EventBus.access$000(this.this$0));
    }
}

