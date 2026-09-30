/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.FluentCollection;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GCollectionWrapper;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GIteratorWrapper;
import de.audi.atip.utils.generics.GSet;
import java.util.Collection;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GSetWrapper<T>
extends GCollectionWrapper<T>
implements GSet<T> {
    protected Set backingSet;

    protected GSetWrapper() {
    }

    public GSetWrapper(Set set) {
        this.backingSet = set;
    }

    @Override
    public boolean add(T t) {
        return this.backingSet.add(t);
    }

    @Override
    public boolean addAll(GCollection<T> gCollection) {
        return this.backingSet.addAll(gCollection.getBackingCollection());
    }

    @Override
    public void clear() {
        this.backingSet.clear();
    }

    @Override
    public boolean contains(T t) {
        return this.backingSet.contains(t);
    }

    @Override
    public boolean containsAll(GCollection<T> gCollection) {
        return this.backingSet.containsAll(gCollection.getBackingCollection());
    }

    @Override
    public boolean isEmpty() {
        return this.backingSet.isEmpty();
    }

    @Override
    public GIterator<T> iterator() {
        return new GIteratorWrapper(this.backingSet.iterator());
    }

    @Override
    public boolean remove(T t) {
        return this.backingSet.remove(t);
    }

    @Override
    public boolean removeAll(GCollection<T> gCollection) {
        return this.backingSet.removeAll(gCollection.getBackingCollection());
    }

    @Override
    public boolean retainAll(GCollection<T> gCollection) {
        return this.backingSet.retainAll(gCollection.getBackingCollection());
    }

    @Override
    public int size() {
        return this.backingSet.size();
    }

    @Override
    public Object[] toArray() {
        return this.backingSet.toArray();
    }

    @Override
    public T[] toArray(T[] TArray) {
        return this.backingSet.toArray(TArray);
    }

    @Override
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
        try {
            GSetWrapper gSetWrapper = (GSetWrapper)object;
            return !(this.backingSet == null ? gSetWrapper.backingSet != null : !((Object)this.backingSet).equals(gSetWrapper.backingSet));
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.backingSet == null ? 0 : ((Object)this.backingSet).hashCode());
        return n;
    }

    @Override
    public String toString() {
        return this.backingSet.toString();
    }

    @Override
    public Collection getBackingCollection() {
        return this.backingSet;
    }

    @Override
    public /* synthetic */ FluentCollection fluent() {
        return super.fluent();
    }
}

