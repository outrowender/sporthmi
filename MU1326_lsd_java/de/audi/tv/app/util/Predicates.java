/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import de.audi.tv.app.util.Predicates$AndCompoundPredicate;
import de.audi.tv.app.util.Predicates$Optional;
import de.audi.tv.app.util.Predicates$OrCompoundPredicate;
import de.audi.tv.app.util.Predicates$Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Predicates {
    private Predicates() {
    }

    public static Predicates$Predicate or(Predicates$Predicate predicates$Predicate, Predicates$Predicate predicates$Predicate2) {
        Predicates$OrCompoundPredicate predicates$OrCompoundPredicate = new Predicates$OrCompoundPredicate();
        predicates$OrCompoundPredicate.add(predicates$Predicate);
        predicates$OrCompoundPredicate.add(predicates$Predicate2);
        return predicates$OrCompoundPredicate;
    }

    public static Predicates$Predicate and(Predicates$Predicate predicates$Predicate, Predicates$Predicate predicates$Predicate2) {
        Predicates$AndCompoundPredicate predicates$AndCompoundPredicate = new Predicates$AndCompoundPredicate();
        predicates$AndCompoundPredicate.add(predicates$Predicate);
        predicates$AndCompoundPredicate.add(predicates$Predicate2);
        return predicates$AndCompoundPredicate;
    }

    public static Collection filter(Collection collection, Predicates$Predicate predicates$Predicate) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!predicates$Predicate.apply(object)) continue;
            arrayList.add(object);
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static Predicates$Optional tryFind(Collection collection, Predicates$Predicate predicates$Predicate) {
        Object object = null;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (!predicates$Predicate.apply(object2)) continue;
            object = object2;
        }
        return new Predicates$Optional(object);
    }
}

