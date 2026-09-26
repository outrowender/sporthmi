/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
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
        Preconditions.checkNotNull((Object)object);
        Preconditions.checkNotNull((Object)method);
        Preconditions.checkNotNull((Object)subscriberExceptionHandler);
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
            throw new Error(new StringBuffer().append("Method rejected target/argument: ").append(object).toString(), illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error(new StringBuffer().append("Method became inaccessible: ").append(object).toString(), illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            this.subscriberExceptionHandler.handleException(invocationTargetException.getCause(), this);
        }
    }

    public String toString() {
        return new StringBuffer().append("[wrapper ").append(this.method).append("]").toString();
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

