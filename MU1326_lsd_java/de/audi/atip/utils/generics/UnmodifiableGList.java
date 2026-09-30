/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.GListWrapper;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class UnmodifiableGList<T>
extends GListWrapper<T> {
    protected GList<T> list;
    private GIterator<T> iterator;
    private GIterator<T> originalIterator;

    protected UnmodifiableGList() {
    }

    public UnmodifiableGList(GList<T> gList) {
        this.list = gList;
        this.initIterators(gList);
    }

    protected final void initIterators(GList<T> gList) {
        this.originalIterator = gList.iterator();
        this.iterator = new GIterator<T>(){

            @Override
            public boolean hasNext() {
                return UnmodifiableGList.this.originalIterator.hasNext();
            }

            @Override
            public T next() {
                return UnmodifiableGList.this.originalIterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Collection getBackingCollection() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int n, T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int n, GCollection<T> gCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(GCollection<T> gCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(T t) {
        return this.list.contains(t);
    }

    @Override
    public boolean containsAll(GCollection<T> gCollection) {
        return this.list.containsAll(gCollection);
    }

    @Override
    public T get(int n) {
        return this.list.get(n);
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
        return this.iterator;
    }

    @Override
    public int lastIndexOf(T t) {
        return this.list.lastIndexOf(t);
    }

    @Override
    public T remove(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(GCollection<T> gCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(GCollection<T> gCollection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int n, T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public GList<T> subList(int n, int n2) {
        return new UnmodifiableGList<T>(this.list.subList(n, n2));
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public T[] toArray(T[] TArray) {
        return this.list.toArray(TArray);
    }
}

