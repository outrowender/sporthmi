/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.concurrent;

import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList$CopyOnWriteListIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

class CopyOnWriteArrayList$CopyOnWriteSubList
implements List,
RandomAccess {
    private final List realSubList;
    private final /* synthetic */ CopyOnWriteArrayList this$0;

    public CopyOnWriteArrayList$CopyOnWriteSubList(CopyOnWriteArrayList copyOnWriteArrayList, List list) {
        this.this$0 = copyOnWriteArrayList;
        this.realSubList = list;
    }

    @Override
    public void add(int n, Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean contains(Object object) {
        return this.realSubList.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.realSubList.containsAll(collection);
    }

    @Override
    public Object get(int n) {
        return this.realSubList.get(n);
    }

    @Override
    public int indexOf(Object object) {
        return this.realSubList.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return this.realSubList.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new CopyOnWriteArrayList$CopyOnWriteListIterator(this.this$0, this.realSubList.listIterator());
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.realSubList.lastIndexOf(object);
    }

    @Override
    public ListIterator listIterator() {
        return new CopyOnWriteArrayList$CopyOnWriteListIterator(this.this$0, this.realSubList.listIterator());
    }

    @Override
    public ListIterator listIterator(int n) {
        return new CopyOnWriteArrayList$CopyOnWriteListIterator(this.this$0, this.realSubList.listIterator(n));
    }

    @Override
    public Object remove(int n) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public Object set(int n, Object object) {
        throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
    }

    @Override
    public int size() {
        return this.realSubList.size();
    }

    @Override
    public List subList(int n, int n2) {
        return new CopyOnWriteArrayList$CopyOnWriteSubList(this.this$0, this.realSubList.subList(n, n2));
    }

    @Override
    public Object[] toArray() {
        return this.realSubList.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.realSubList.toArray(objectArray);
    }
}

