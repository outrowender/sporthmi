/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.ReflectionUtils;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.collections.Predicates;
import de.audi.atip.utils.eventbus.SubscriberFindingStrategy;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GPair;
import de.audi.atip.utils.generics.Generics;
import java.lang.reflect.Method;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MarkerInterfaceSubscriberFindingStrategy
implements SubscriberFindingStrategy {
    static /* synthetic */ Class class$de$audi$atip$utils$eventbus$EventMarker;

    @Override
    public GList<GPair<Class, Method>> findAllSubscribers(Object object) {
        GList<GPair<Class, Method>> gList = Generics.newArrayList();
        Class clazz = object.getClass();
        GIterator<Method> gIterator = MarkerInterfaceSubscriberFindingStrategy.getMarkedMethods(clazz).iterator();
        while (gIterator.hasNext()) {
            Method method = gIterator.next();
            Class[] classArray = method.getParameterTypes();
            Class clazz2 = classArray[0];
            gList.add(GPair.create(clazz2, method));
        }
        return gList;
    }

    private static GList<Method> getMarkedMethods(Class clazz) {
        Collection collection = ReflectionUtils.getPublicDeclaredMethods(clazz);
        return Generics.newArrayList(Predicates.filter(collection, new Predicate<Method>(){

            @Override
            public boolean apply(Method method) {
                Class[] classArray = method.getParameterTypes();
                if (classArray.length == 1) {
                    Class clazz = classArray[0];
                    boolean bl = clazz != null && (class$de$audi$atip$utils$eventbus$EventMarker == null ? (class$de$audi$atip$utils$eventbus$EventMarker = MarkerInterfaceSubscriberFindingStrategy.class$("de.audi.atip.utils.eventbus.EventMarker")) : class$de$audi$atip$utils$eventbus$EventMarker).isAssignableFrom(clazz);
                    return bl;
                }
                return false;
            }

            @Override
            public /* synthetic */ boolean apply(Object object) {
                return this.apply((Method)object);
            }
        }));
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

