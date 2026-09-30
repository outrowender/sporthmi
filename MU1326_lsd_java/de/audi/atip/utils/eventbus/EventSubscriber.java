/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.eventbus.SubscriberExceptionHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class EventSubscriber {
    private final Object target;
    private final Method method;
    private final SubscriberExceptionHandler subscriberExceptionHandler;

    EventSubscriber(Object object, Method method, SubscriberExceptionHandler subscriberExceptionHandler) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(method);
        Preconditions.checkNotNull(subscriberExceptionHandler);
        this.target = object;
        this.method = method;
        this.subscriberExceptionHandler = subscriberExceptionHandler;
        method.setAccessible(true);
    }

    public void handleEvent(Object object) {
        try {
            this.method.invoke(this.target, new Object[]{object});
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new Error("Method rejected target/argument: " + object, illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Method became inaccessible: " + object, illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            this.subscriberExceptionHandler.handleException(invocationTargetException.getCause(), this);
        }
    }

    public String toString() {
        return "[wrapper " + this.method + "]";
    }

    public int hashCode() {
        return (31 + this.method.hashCode()) * 31 + System.identityHashCode(this.target);
    }

    public boolean equals(Object object) {
        if (object instanceof EventSubscriber) {
            EventSubscriber eventSubscriber = (EventSubscriber)object;
            return this.target == eventSubscriber.target && this.method.equals(eventSubscriber.method);
        }
        return false;
    }

    public Object getSubscriber() {
        return this.target;
    }

    public Method getMethod() {
        return this.method;
    }
}

