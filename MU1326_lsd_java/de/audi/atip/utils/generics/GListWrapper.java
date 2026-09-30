/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.FluentCollection;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GCollectionWrapper;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GIteratorWrapper;
import de.audi.atip.utils.generics.GList;
import java.util.Collection;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GListWrapper<T>
extends GCollectionWrapper<T>
implements GList<T>,
GCollection<T> {
    protected List list;

    protected GListWrapper() {
    }

    public GListWrapper(List list) {
        this.list = list;
    }

    @Override
    public void add(int n, T t) {
        this.list.add(n, t);
    }

    @Override
    public boolean add(T t) {
        return this.list.add(t);
    }

    @Override
    public boolean addAll(int n, GCollection<T> gCollection) {
        return this.list.addAll(n, gCollection.getBackingCollection());
    }

    @Override
    public boolean addAll(GCollection<T> gCollection) {
        return this.list.addAll(gCollection.getBackingCollection());
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.list.addAll(collection);
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public boolean contains(T t) {
        return this.list.contains(t);
    }

    @Override
    public boolean containsAll(GCollection<T> gCollection) {
        return this.list.containsAll(gCollection.getBackingCollection());
    }

    @Override
    public T get(int n) {
        return (T)this.list.get(n);
    }

    @Override
    public int indexOf(T t) {
        return this.list.indexOf(t);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public GIterator<T> iterator() {
        return new GIteratorWrapper(this.list.iterator());
    }

    @Override
    public int lastIndexOf(T t) {
        return this.list.lastIndexOf(t);
    }

    @Override
    public T remove(int n) {
        return (T)this.list.remove(n);
    }

    @Override
    public boolean remove(T t) {
        return this.list.remove(t);
    }

    @Override
    public boolean removeAll(GCollection<T> gCollection) {
        return this.list.removeAll(gCollection.getBackingCollection());
    }

    @Override
    public boolean retainAll(GCollection<T> gCollection) {
        return this.list.retainAll(gCollection.getBackingCollection());
    }

    @Override
    public T set(int n, T t) {
        return (T)this.list.set(n, t);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public GList<T> subList(int n, int n2) {
        return new GListWrapper<T>(this.list.subList(n, n2));
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public T[] toArray(T[] TArray) {
        return this.list.toArray(TArray);
    }

    @Override
    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.list == null ? 0 : ((Object)this.list).hashCode());
        return n;
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
            GListWrapper gListWrapper = (GListWrapper)object;
            return !(this.list == null ? gListWrapper.list != null : !((Object)this.list).equals(gListWrapper.list));
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

    @Override
    public Collection getBackingCollection() {
        return this.list;
    }

    @Override
    public /* synthetic */ FluentCollection fluent() {
        return super.fluent();
    }
}

