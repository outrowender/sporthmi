/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import java.util.Collection;
import java.util.Iterator;

public final class CollectionUtils {
    public static void filterFromIteratorIntoCollection(Iterator iterator, Collection collection, Predicate predicate) {
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!predicate.evaluate(object)) continue;
            collection.add(object);
        }
    }

    public static interface Predicate {
        public boolean evaluate(Object var1);
    }
}

