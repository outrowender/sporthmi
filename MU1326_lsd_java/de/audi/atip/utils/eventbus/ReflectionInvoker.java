/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.eventbus.SubscriberFindingStrategy;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GPair;
import de.audi.atip.utils.generics.Generics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionInvoker {
    private final Object calee;
    private final GMap<Class, Method> methods;

    public ReflectionInvoker(Object object, SubscriberFindingStrategy subscriberFindingStrategy) {
        Preconditions.checkNotNull(object);
        this.calee = object;
        GList<GPair<Class, Method>> gList = subscriberFindingStrategy.findAllSubscribers(object);
        this.methods = Generics.newHashMapWithCapacity(gList.size());
        GIterator<GPair<Class, Method>> gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().getSecond().setAccessible(true);
        }
        gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            GPair<Class, Method> gPair = gIterator.next();
            gPair.getSecond().setAccessible(true);
            this.methods.put(gPair.getFirst(), gPair.getSecond());
        }
    }

    public boolean invoke(Object object) throws InvocationTargetException {
        try {
            Method method = this.methods.get(object.getClass());
            if (method != null) {
                method.invoke(this.calee, new Object[]{object});
                return true;
            }
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new Error(new StringBuffer().append("Method rejected target/argument: ").append(object).toString(), illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error(new StringBuffer().append("Method became inaccessible: ").append(object).toString(), illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof Error) {
                throw (Error)invocationTargetException.getCause();
            }
            throw invocationTargetException;
        }
    }
}

