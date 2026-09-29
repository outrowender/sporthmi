/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.eventbus.MarkerInterfaceSubscriberFindingStrategy;
import java.lang.reflect.Method;

final class MarkerInterfaceSubscriberFindingStrategy$1
implements Predicate {
    MarkerInterfaceSubscriberFindingStrategy$1() {
    }

    public boolean apply(Method method) {
        Class[] classArray = method.getParameterTypes();
        if (classArray.length == 1) {
            Class clazz = classArray[0];
            boolean bl = clazz != null && (MarkerInterfaceSubscriberFindingStrategy.class$de$audi$atip$utils$eventbus$EventMarker == null ? (MarkerInterfaceSubscriberFindingStrategy.class$de$audi$atip$utils$eventbus$EventMarker = MarkerInterfaceSubscriberFindingStrategy.class$("de.audi.atip.utils.eventbus.EventMarker")) : MarkerInterfaceSubscriberFindingStrategy.class$de$audi$atip$utils$eventbus$EventMarker).isAssignableFrom(clazz);
            return bl;
        }
        return false;
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((Method)object);
    }
}

