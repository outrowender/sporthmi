/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.collections.Predicates;
import de.audi.atip.utils.eventbus.AsyncEventSubscriber;
import de.audi.atip.utils.eventbus.DeadEvent;
import de.audi.atip.utils.eventbus.EventSubscriber;
import de.audi.atip.utils.eventbus.IEventBus;
import de.audi.atip.utils.eventbus.MarkerInterfaceSubscriberFindingStrategy;
import de.audi.atip.utils.eventbus.SubscriberExceptionHandler;
import de.audi.atip.utils.eventbus.SubscriberFindingStrategy;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GPair;
import de.audi.atip.utils.generics.Generics;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.lang.reflect.Method;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class EventBus
implements IEventBus {
    public static final boolean RETHROW_EXCEPTIONS = true;
    public static final boolean ONLY_LOG_EXCEPTIONS = false;
    private final GMap<Class, GList<EventSubscriber>> subscribersByType = Generics.newHashMap();
    private final SubscriberFindingStrategy finder = new MarkerInterfaceSubscriberFindingStrategy();
    private SubscriberExceptionHandler subscriberExceptionHandler;
    private final Object subscribersByTypeLock = new Object();
    private final SubscriberFactory syncFactory = new SubscriberFactory(){

        public EventSubscriber create(Object object, Method method) {
            return new EventSubscriber(object, method, EventBus.this.subscriberExceptionHandler);
        }
    };

    public EventBus(String string, boolean bl) {
        this(new ThrowingSubscriberExceptionHandler(string));
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        Preconditions.checkNotNull(subscriberExceptionHandler);
        this.subscriberExceptionHandler = subscriberExceptionHandler;
    }

    @Override
    public void register(Object object) {
        this.register(object, this.syncFactory);
    }

    @Override
    public void register(Object object, final DispatcherBase dispatcherBase) {
        this.register(object, new SubscriberFactory(){

            public EventSubscriber create(Object object, Method method) {
                return new AsyncEventSubscriber(object, method, dispatcherBase, EventBus.this.subscriberExceptionHandler);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void register(Object object, SubscriberFactory subscriberFactory) {
        GList<GPair<Class, Method>> gList = this.finder.findAllSubscribers(object);
        Object object2 = this.subscribersByTypeLock;
        synchronized (object2) {
            GIterator<GPair<Class, Method>> gIterator = gList.iterator();
            while (gIterator.hasNext()) {
                GPair<Class, Method> gPair = gIterator.next();
                GList<EventSubscriber> gList2 = this.subscribersByType.get(gPair.getFirst());
                if (gList2 == null) {
                    gList2 = Generics.newArrayList();
                    this.subscribersByType.put(gPair.getFirst(), gList2);
                }
                EventSubscriber eventSubscriber = subscriberFactory.create(object, gPair.getSecond());
                gList2.add(eventSubscriber);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregister(final Object object) {
        GList<GPair<Class, Method>> gList = this.finder.findAllSubscribers(object);
        GIterator<GPair<Class, Method>> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            GPair<Class, Method> gPair = gIterator.next();
            Object object2 = this.subscribersByTypeLock;
            synchronized (object2) {
                GList<EventSubscriber> gList2 = this.subscribersByType.get(gPair.getFirst());
                boolean bl = gList2.removeAll(Predicates.filter(gList2, new Predicate<EventSubscriber>(){

                    @Override
                    public boolean apply(EventSubscriber eventSubscriber) {
                        return eventSubscriber.getSubscriber() == object;
                    }

                    @Override
                    public /* synthetic */ boolean apply(Object object2) {
                        return this.apply((EventSubscriber)object2);
                    }
                }));
                if (!bl) {
                    throw new IllegalArgumentException(new StringBuffer().append("missing event subscriber for a method. Is ").append(object).append(" registered?").toString());
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void post(Object object) {
        GList<EventWithSubscriber> gList = Generics.newArrayList();
        boolean bl = false;
        Class clazz = object.getClass();
        Object object2 = this.subscribersByTypeLock;
        synchronized (object2) {
            GList<EventSubscriber> gList2 = this.subscribersByType.get(clazz);
            if (gList2 != null && !gList2.isEmpty()) {
                bl = true;
                GIterator<EventSubscriber> gIterator = gList2.iterator();
                while (gIterator.hasNext()) {
                    this.enqueueEvent(gList, object, gIterator.next());
                }
            }
        }
        if (!bl && !(object instanceof DeadEvent)) {
            this.post(new DeadEvent(this, object));
        }
        this.dispatchQueuedEvents(gList);
    }

    void enqueueEvent(GList<EventWithSubscriber> gList, Object object, EventSubscriber eventSubscriber) {
        gList.add(new EventWithSubscriber(object, eventSubscriber));
    }

    void dispatchQueuedEvents(GList<EventWithSubscriber> gList) {
        GIterator<EventWithSubscriber> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            EventWithSubscriber eventWithSubscriber = gIterator.next();
            eventWithSubscriber.subscriber.handleEvent(eventWithSubscriber.event);
        }
    }

    private static interface SubscriberFactory {
        public EventSubscriber create(Object var1, Method var2);
    }

    static class EventWithSubscriber {
        final Object event;
        final EventSubscriber subscriber;

        public EventWithSubscriber(Object object, EventSubscriber eventSubscriber) {
            Preconditions.checkNotNull(object);
            Preconditions.checkNotNull(eventSubscriber);
            this.event = object;
            this.subscriber = eventSubscriber;
        }
    }

    private static final class ThrowingSubscriberExceptionHandler
    implements SubscriberExceptionHandler {
        public ThrowingSubscriberExceptionHandler(String string) {
        }

        public void handleException(Throwable throwable, EventSubscriber eventSubscriber) {
            throw new RuntimeException("Could not dispatch event to " + eventSubscriber.getMethod(), throwable);
        }
    }
}

