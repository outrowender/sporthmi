/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class CopyOnWriteArrayList
implements List,
RandomAccess {
    private volatile ArrayList realList;

    public CopyOnWriteArrayList() {
        this.realList = new ArrayList(10);
    }

    public CopyOnWriteArrayList(int n) {
        this.realList = new ArrayList(n);
    }

    public CopyOnWriteArrayList(Collection collection) {
        this.realList = new ArrayList(collection);
    }

    public synchronized void add(int n, Object object) {
        ArrayList arrayList = new ArrayList(this.realList);
        arrayList.add(n, object);
        this.realList = arrayList;
    }

    public synchronized boolean add(Object object) {
        ArrayList arrayList = new ArrayList(this.realList.size() + 1);
        arrayList.addAll(this.realList);
        arrayList.add(object);
        this.realList = arrayList;
        return true;
    }

    public synchronized boolean addAll(int n, Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList);
        arrayList.addAll(n, collection);
        this.realList = arrayList;
        return !collection.isEmpty();
    }

    public synchronized boolean addAll(Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList.size() + collection.size());
        arrayList.addAll(this.realList);
        arrayList.addAll(collection);
        this.realList = arrayList;
        return !collection.isEmpty();
    }

    public synchronized void clear() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.trimToSize();
        this.realList = arrayList;
    }

    public boolean contains(Object object) {
        return this.realList.contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.realList.containsAll(collection);
    }

    public Object get(int n) {
        return this.realList.get(n);
    }

    public int indexOf(Object object) {
        return this.realList.indexOf(object);
    }

    public boolean isEmpty() {
        return this.realList.isEmpty();
    }

    public Iterator iterator() {
        return new CopyOnWriteListIterator(this.realList.listIterator());
    }

    public int lastIndexOf(Object object) {
        return this.realList.lastIndexOf(object);
    }

    public ListIterator listIterator() {
        return new CopyOnWriteListIterator(this.realList.listIterator());
    }

    public ListIterator listIterator(int n) {
        return new CopyOnWriteListIterator(this.realList.listIterator(n));
    }

    public synchronized Object remove(int n) {
        ArrayList arrayList = new ArrayList(this.realList);
        Object object = arrayList.remove(n);
        arrayList.trimToSize();
        this.realList = arrayList;
        return object;
    }

    public synchronized boolean remove(Object object) {
        ArrayList arrayList = new ArrayList(this.realList);
        boolean bl = arrayList.remove(object);
        arrayList.trimToSize();
        this.realList = arrayList;
        return bl;
    }

    public synchronized boolean removeAll(Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList);
        boolean bl = arrayList.removeAll(collection);
        arrayList.trimToSize();
        this.realList = arrayList;
        return bl;
    }

    public synchronized boolean retainAll(Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList);
        boolean bl = arrayList.retainAll(collection);
        arrayList.trimToSize();
        this.realList = arrayList;
        return bl;
    }

    public synchronized Object set(int n, Object object) {
        ArrayList arrayList = new ArrayList(this.realList);
        Object object2 = arrayList.set(n, object);
        this.realList = arrayList;
        return object2;
    }

    public int size() {
        return this.realList.size();
    }

    public List subList(int n, int n2) {
        return new CopyOnWriteSubList(this.realList.subList(n, n2));
    }

    public Object[] toArray() {
        return this.realList.toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.realList.toArray(objectArray);
    }

    public synchronized void ensureCapacity(int n) {
        this.realList.ensureCapacity(n);
    }

    public synchronized void trimToSize() {
        this.realList.trimToSize();
    }

    public String toString() {
        return this.realList.toString();
    }

    public boolean equals(Object object) {
        return this.realList.equals(object);
    }

    public int hashCode() {
        return this.realList.hashCode();
    }

    public synchronized boolean addIfAbsent(Object object) {
        if (!this.realList.contains(object)) {
            this.add(object);
            return true;
        }
        return false;
    }

    private class CopyOnWriteSubList
    implements List,
    RandomAccess {
        private final List realSubList;

        public CopyOnWriteSubList(List list) {
            this.realSubList = list;
        }

        public void add(int n, Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean addAll(int n, Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public void clear() {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean contains(Object object) {
            return this.realSubList.contains(object);
        }

        public boolean containsAll(Collection collection) {
            return this.realSubList.containsAll(collection);
        }

        public Object get(int n) {
            return this.realSubList.get(n);
        }

        public int indexOf(Object object) {
            return this.realSubList.indexOf(object);
        }

        public boolean isEmpty() {
            return this.realSubList.isEmpty();
        }

        public Iterator iterator() {
            return new CopyOnWriteListIterator(this.realSubList.listIterator());
        }

        public int lastIndexOf(Object object) {
            return this.realSubList.lastIndexOf(object);
        }

        public ListIterator listIterator() {
            return new CopyOnWriteListIterator(this.realSubList.listIterator());
        }

        public ListIterator listIterator(int n) {
            return new CopyOnWriteListIterator(this.realSubList.listIterator(n));
        }

        public Object remove(int n) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public Object set(int n, Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public int size() {
            return this.realSubList.size();
        }

        public List subList(int n, int n2) {
            return new CopyOnWriteSubList(this.realSubList.subList(n, n2));
        }

        public Object[] toArray() {
            return this.realSubList.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.realSubList.toArray(objectArray);
        }
    }

    private class CopyOnWriteListIterator
    implements ListIterator {
        private final ListIterator realListIterator;

        public CopyOnWriteListIterator(ListIterator listIterator) {
            this.realListIterator = listIterator;
        }

        public void add(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public boolean hasNext() {
            return this.realListIterator.hasNext();
        }

        public boolean hasPrevious() {
            return this.realListIterator.hasPrevious();
        }

        public Object next() {
            return this.realListIterator.next();
        }

        public int nextIndex() {
            return this.realListIterator.nextIndex();
        }

        public Object previous() {
            return this.realListIterator.previous();
        }

        public int previousIndex() {
            return this.realListIterator.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }

        public void set(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteArrayList");
        }
    }
}

