/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.eventbus;

import de.audi.tv.app.util.Predicates$Predicate;
import de.audi.tv.app.util.eventbus.MarkerInterfaceSubscriberFindingStrategy;
import java.lang.reflect.Method;

final class MarkerInterfaceSubscriberFindingStrategy$1
implements Predicates$Predicate {
    MarkerInterfaceSubscriberFindingStrategy$1() {
    }

    @Override
    public boolean apply(Object object) {
        Class[] classArray = ((Method)object).getParameterTypes();
        if (classArray.length == 1) {
            Class clazz = classArray[0];
            boolean bl = clazz != null && (MarkerInterfaceSubscriberFindingStrategy.class$de$audi$tv$app$util$eventbus$EventMarker == null ? (MarkerInterfaceSubscriberFindingStrategy.class$de$audi$tv$app$util$eventbus$EventMarker = MarkerInterfaceSubscriberFindingStrategy.class$("de.audi.tv.app.util.eventbus.EventMarker")) : MarkerInterfaceSubscriberFindingStrategy.class$de$audi$tv$app$util$eventbus$EventMarker).isAssignableFrom(clazz);
            return bl;
        }
        return false;
    }
}

