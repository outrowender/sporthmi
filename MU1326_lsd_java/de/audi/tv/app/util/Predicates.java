/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Predicates {
    private Predicates() {
    }

    public static Predicate or(Predicate predicate, Predicate predicate2) {
        OrCompoundPredicate orCompoundPredicate = new OrCompoundPredicate();
        orCompoundPredicate.add(predicate);
        orCompoundPredicate.add(predicate2);
        return orCompoundPredicate;
    }

    public static Predicate and(Predicate predicate, Predicate predicate2) {
        AndCompoundPredicate andCompoundPredicate = new AndCompoundPredicate();
        andCompoundPredicate.add(predicate);
        andCompoundPredicate.add(predicate2);
        return andCompoundPredicate;
    }

    public static Collection filter(Collection collection, Predicate predicate) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!predicate.apply(object)) continue;
            arrayList.add(object);
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static Optional tryFind(Collection collection, Predicate predicate) {
        Object object = null;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            if (!predicate.apply(object2)) continue;
            object = object2;
        }
        return new Optional(object);
    }

    public static class Optional {
        private final Object object;

        public Optional(Object object) {
            this.object = object;
        }

        public Object get() {
            return this.object;
        }

        public boolean exists() {
            return this.object != null;
        }
    }

    public static interface Predicate {
        public boolean apply(Object var1);
    }

    public static class OrCompoundPredicate
    implements Predicate {
        private final List predicates = new ArrayList();

        public void add(Predicate predicate) {
            this.predicates.add(predicate);
        }

        public boolean apply(Object object) {
            for (int i2 = 0; i2 < this.predicates.size(); ++i2) {
                if (!((Predicate)this.predicates.get(i2)).apply(object)) continue;
                return true;
            }
            return false;
        }
    }

    public static class AndCompoundPredicate
    implements Predicate {
        private final List predicates = new ArrayList();

        public void add(Predicate predicate) {
            this.predicates.add(predicate);
        }

        public boolean apply(Object object) {
            for (int i2 = 0; i2 < this.predicates.size(); ++i2) {
                if (((Predicate)this.predicates.get(i2)).apply(object)) continue;
                return false;
            }
            return true;
        }
    }
}

