/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.app.bap.utils.CollectionUtils$Predicate;
import java.util.Collection;
import java.util.Iterator;

public final class CollectionUtils {
    public static void filterFromIteratorIntoCollection(Iterator iterator, Collection collection, CollectionUtils$Predicate collectionUtils$Predicate) {
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!collectionUtils$Predicate.evaluate(object)) continue;
            collection.add(object);
        }
    }
}

