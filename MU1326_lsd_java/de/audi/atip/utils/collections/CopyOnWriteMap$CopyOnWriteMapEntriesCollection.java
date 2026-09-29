/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import de.audi.atip.utils.collections.CopyOnWriteMap;
import de.audi.atip.utils.collections.CopyOnWriteMap$CopyOnWriteIterator;
import java.util.Collection;
import java.util.Iterator;

class CopyOnWriteMap$CopyOnWriteMapEntriesCollection
implements Collection {
    private final Collection realCollection;
    private final /* synthetic */ CopyOnWriteMap this$0;

    public CopyOnWriteMap$CopyOnWriteMapEntriesCollection(CopyOnWriteMap copyOnWriteMap, Collection collection) {
        this.this$0 = copyOnWriteMap;
        this.realCollection = collection;
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }

    @Override
    public boolean contains(Object object) {
        return this.realCollection.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.realCollection.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.realCollection.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new CopyOnWriteMap$CopyOnWriteIterator(this.this$0, this.realCollection.iterator());
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
    }

    @Override
    public int size() {
        return this.realCollection.size();
    }

    @Override
    public Object[] toArray() {
        return this.realCollection.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.realCollection.toArray(objectArray);
    }
}

