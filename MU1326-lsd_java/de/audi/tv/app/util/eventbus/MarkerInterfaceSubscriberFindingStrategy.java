/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.eventbus;

import de.audi.tv.app.util.Pair;
import de.audi.tv.app.util.Predicates;
import de.audi.tv.app.util.ReflectionUtils;
import de.audi.tv.app.util.eventbus.MarkerInterfaceSubscriberFindingStrategy$1;
import de.audi.tv.app.util.eventbus.SubscriberFindingStrategy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MarkerInterfaceSubscriberFindingStrategy
implements SubscriberFindingStrategy {
    static /* synthetic */ Class class$de$audi$tv$app$util$eventbus$EventMarker;

    @Override
    public List findAllSubscribers(Object object) {
        ArrayList arrayList = new ArrayList();
        Class clazz = object.getClass();
        Iterator iterator = MarkerInterfaceSubscriberFindingStrategy.getMarkedMethods(clazz).iterator();
        while (iterator.hasNext()) {
            Method method = (Method)iterator.next();
            Class[] classArray = method.getParameterTypes();
            Class clazz2 = classArray[0];
            arrayList.add(Pair.create(clazz2, method));
        }
        return arrayList;
    }

    private static List getMarkedMethods(Class clazz) {
        Collection collection = ReflectionUtils.getPublicDeclaredMethods(clazz);
        return new ArrayList(Predicates.filter(collection, new MarkerInterfaceSubscriberFindingStrategy$1()));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

