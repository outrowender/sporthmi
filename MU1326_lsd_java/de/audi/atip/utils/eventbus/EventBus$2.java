/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.AsyncEventSubscriber;
import de.audi.atip.utils.eventbus.EventBus;
import de.audi.atip.utils.eventbus.EventBus$SubscriberFactory;
import de.audi.atip.utils.eventbus.EventSubscriber;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.lang.reflect.Method;

class EventBus$2
implements EventBus$SubscriberFactory {
    private final /* synthetic */ DispatcherBase val$dispatcher;
    private final /* synthetic */ EventBus this$0;

    EventBus$2(EventBus eventBus, DispatcherBase dispatcherBase) {
        this.this$0 = eventBus;
        this.val$dispatcher = dispatcherBase;
    }

    @Override
    public EventSubscriber create(Object object, Method method) {
        return new AsyncEventSubscriber(object, method, this.val$dispatcher, EventBus.access$000(this.this$0));
    }
}

