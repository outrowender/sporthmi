/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.Preconditions
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.GMap
 *  de.audi.atip.utils.generics.Generics
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
    private final GMap methods;

    public ReflectionInvoker(Object object, SubscriberFindingStrategy subscriberFindingStrategy) {
        Preconditions.checkNotNull((Object)object);
        this.calee = object;
        GList gList = subscriberFindingStrategy.findAllSubscribers(object);
        this.methods = Generics.newHashMapWithCapacity((int)gList.size());
        GIterator gIterator = gList.iterator();
        while (gIterator.hasNext()) {
            ((Method)((GPair)gIterator.next()).getSecond()).setAccessible(true);
        }
        for (GPair gPair : gList) {
            ((Method)gPair.getSecond()).setAccessible(true);
            this.methods.put(gPair.getFirst(), gPair.getSecond());
        }
    }

    public boolean invoke(Object object) {
        try {
            Method method = (Method)this.methods.get((Object)object.getClass());
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

