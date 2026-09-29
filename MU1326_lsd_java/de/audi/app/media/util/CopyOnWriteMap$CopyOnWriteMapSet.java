/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.util;

import de.audi.app.media.util.CopyOnWriteMap;
import de.audi.app.media.util.CopyOnWriteMap$CopyOnWriteIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class CopyOnWriteMap$CopyOnWriteMapSet
implements Set {
    private final Set realSet;
    private final /* synthetic */ CopyOnWriteMap this$0;

    public CopyOnWriteMap$CopyOnWriteMapSet(CopyOnWriteMap copyOnWriteMap, Set set) {
        this.this$0 = copyOnWriteMap;
        this.realSet = set;
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
        return this.realSet.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.realSet.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.realSet.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new CopyOnWriteMap$CopyOnWriteIterator(this.this$0, this.realSet.iterator());
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
        return this.realSet.size();
    }

    @Override
    public Object[] toArray() {
        return this.realSet.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.realSet.toArray(objectArray);
    }
}

