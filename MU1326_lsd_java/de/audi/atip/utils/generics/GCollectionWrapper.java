/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.FluentCollection;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GIteratorWrapper;
import de.audi.atip.utils.generics.IFluentCollection;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class GCollectionWrapper<T>
implements GCollection<T> {
    protected Collection backingCollection;

    protected GCollectionWrapper() {
    }

    public GCollectionWrapper(Collection collection) {
        Preconditions.checkNotNull(collection);
        this.backingCollection = collection;
    }

    @Override
    public boolean add(T t) {
        return this.backingCollection.add(t);
    }

    @Override
    public boolean addAll(GCollection<T> gCollection) {
        return this.backingCollection.addAll(gCollection.getBackingCollection());
    }

    @Override
    public void clear() {
        this.backingCollection.clear();
    }

    @Override
    public boolean contains(T t) {
        return this.backingCollection.contains(t);
    }

    @Override
    public boolean containsAll(GCollection<T> gCollection) {
        return this.backingCollection.containsAll(gCollection.getBackingCollection());
    }

    @Override
    public boolean isEmpty() {
        return this.backingCollection.isEmpty();
    }

    @Override
    public GIterator<T> iterator() {
        return new GIteratorWrapper(this.backingCollection.iterator());
    }

    @Override
    public boolean remove(T t) {
        return this.backingCollection.remove(t);
    }

    @Override
    public boolean removeAll(GCollection<T> gCollection) {
        return this.backingCollection.removeAll(gCollection.getBackingCollection());
    }

    @Override
    public boolean retainAll(GCollection<T> gCollection) {
        return this.backingCollection.retainAll(gCollection.getBackingCollection());
    }

    @Override
    public int size() {
        return this.backingCollection.size();
    }

    @Override
    public Object[] toArray() {
        return this.backingCollection.toArray();
    }

    @Override
    public T[] toArray(T[] TArray) {
        return this.backingCollection.toArray(TArray);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.backingCollection == null ? 0 : ((Object)this.backingCollection).hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        GCollectionWrapper gCollectionWrapper = (GCollectionWrapper)object;
        return !(this.backingCollection == null ? gCollectionWrapper.backingCollection != null : !((Object)this.backingCollection).equals(gCollectionWrapper.backingCollection));
    }

    public String toString() {
        return this.backingCollection.toString();
    }

    @Override
    public Collection getBackingCollection() {
        return this.backingCollection;
    }

    @Override
    public FluentCollection<T> fluent() {
        return FluentCollection.from(this);
    }

    @Override
    public /* synthetic */ IFluentCollection fluent() {
        return this.fluent();
    }
}

