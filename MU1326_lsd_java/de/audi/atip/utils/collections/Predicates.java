/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import java.util.ArrayList;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Predicates {
    private Predicates() {
    }

    public static <T> Predicate<T> or(Predicate<T> predicate, Predicate<T> predicate2) {
        OrCompoundPredicate<T> orCompoundPredicate = new OrCompoundPredicate<T>();
        orCompoundPredicate.add(predicate);
        orCompoundPredicate.add(predicate2);
        return orCompoundPredicate;
    }

    public static <T> Predicate<T> and(Predicate<T> predicate, Predicate<T> predicate2) {
        AndCompoundPredicate<T> andCompoundPredicate = new AndCompoundPredicate<T>();
        andCompoundPredicate.add(predicate);
        andCompoundPredicate.add(predicate2);
        return andCompoundPredicate;
    }

    public static <T> Collection filter(Collection collection, Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList(collection.size());
        GIterator gIterator = Generics.wrap(collection.iterator());
        while (gIterator.hasNext()) {
            Object t = gIterator.next();
            if (!predicate.apply(t)) continue;
            arrayList.add(t);
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static <T> GCollection<T> filter(GCollection<? extends T> gCollection, Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList(gCollection.size());
        GList<T> gList = Generics.wrap(arrayList);
        GIterator<T> gIterator = gCollection.iterator();
        while (gIterator.hasNext()) {
            T t = gIterator.next();
            if (!predicate.apply(t)) continue;
            gList.add(t);
        }
        arrayList.trimToSize();
        return gList;
    }

    public static <T> Optional<T> tryFind(Collection collection, Predicate<T> predicate) {
        Object t = null;
        GIterator gIterator = Generics.wrap(collection.iterator());
        while (gIterator.hasNext()) {
            Object t2 = gIterator.next();
            if (!predicate.apply(t2)) continue;
            t = t2;
        }
        return new Optional<Object>(t);
    }

    public static <T> Optional<T> tryFind(GCollection<? extends T> gCollection, Predicate<T> predicate) {
        Object t = null;
        GIterator<T> gIterator = gCollection.iterator();
        while (gIterator.hasNext()) {
            T t2 = gIterator.next();
            if (!predicate.apply(t2)) continue;
            t = t2;
        }
        return new Optional<Object>(t);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class OrCompoundPredicate<T>
    implements Predicate<T> {
        private final GList<Predicate<T>> predicates = Generics.newArrayList();

        public void add(Predicate<T> predicate) {
            this.predicates.add(predicate);
        }

        @Override
        public boolean apply(T t) {
            for (int i2 = 0; i2 < this.predicates.size(); ++i2) {
                if (!this.predicates.get(i2).apply(t)) continue;
                return true;
            }
            return false;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class AndCompoundPredicate<T>
    implements Predicate<T> {
        private final GList<Predicate<T>> predicates = Generics.newArrayList();

        public void add(Predicate<T> predicate) {
            this.predicates.add(predicate);
        }

        @Override
        public boolean apply(T t) {
            for (int i2 = 0; i2 < this.predicates.size(); ++i2) {
                if (this.predicates.get(i2).apply(t)) continue;
                return false;
            }
            return true;
        }
    }
}

