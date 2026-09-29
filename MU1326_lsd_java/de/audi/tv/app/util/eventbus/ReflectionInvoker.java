/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.eventbus;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.util.Pair;
import de.audi.tv.app.util.Preconditions;
import de.audi.tv.app.util.eventbus.SubscriberFindingStrategy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReflectionInvoker {
    private final Object calee;
    private final Map methods;
    private final LogChannel lc;

    public ReflectionInvoker(LogChannel logChannel, Object object, SubscriberFindingStrategy subscriberFindingStrategy) {
        this.lc = logChannel;
        this.calee = Preconditions.checkNotNull(object);
        List list = subscriberFindingStrategy.findAllSubscribers(object);
        this.methods = new HashMap(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            this.methods.put(pair.first, pair.second);
        }
    }

    public boolean invoke(Object object) {
        try {
            Method method = (Method)this.methods.get(object.getClass());
            if (method != null) {
                method.invoke(this.calee, new Object[]{object});
                return true;
            }
            return false;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.lc.log(10000, "[ReflectionInvoker.invoke] Method rejected target/argument: %1", object);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.lc.log(10000, "[ReflectionInvoker.invoke] Method became inaccessible: %1", object);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof Error) {
                this.lc.log(10000, "[ReflectionInvoker.invoke] ", invocationTargetException.getCause());
            }
            this.lc.log(1000, "[ReflectionInvoker.invoke] ", (Throwable)invocationTargetException);
        }
        return false;
    }
}

