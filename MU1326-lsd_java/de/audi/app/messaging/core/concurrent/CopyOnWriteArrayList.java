/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.concurrent;

import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList$CopyOnWriteListIterator;
import de.audi.app.messaging.core.concurrent.CopyOnWriteArrayList$CopyOnWriteSubList;
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
        this.realList = new ArrayList();
    }

    public CopyOnWriteArrayList(int n) {
        this.realList = new ArrayList(n);
    }

    public CopyOnWriteArrayList(Collection collection) {
        this.realList = new ArrayList(collection);
    }

    @Override
    public synchronized void add(int n, Object object) {
        ArrayList arrayList = new ArrayList(this.realList);
        arrayList.add(n, object);
        this.realList = arrayList;
    }

    @Override
    public synchronized boolean add(Object object) {
        ArrayList arrayList = new ArrayList(this.realList.size() + 1);
        arrayList.addAll(this.realList);
        arrayList.add(object);
        this.realList = arrayList;
        return true;
    }

    @Override
    public synchronized boolean addAll(int n, Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList);
        arrayList.addAll(n, collection);
        this.realList = arrayList;
        return !collection.isEmpty();
    }

    @Override
    public synchronized boolean addAll(Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList.size() + collection.size());
        arrayList.addAll(this.realList);
        arrayList.addAll(collection);
        this.realList = arrayList;
        return !collection.isEmpty();
    }

    @Override
    public synchronized void clear() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.trimToSize();
        this.realList = arrayList;
    }

    @Override
    public boolean contains(Object object) {
        return this.realList.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.realList.containsAll(collection);
    }

    @Override
    public Object get(int n) {
        return this.realList.get(n);
    }

    @Override
    public int indexOf(Object object) {
        return this.realList.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return this.realList.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new CopyOnWriteArrayList$CopyOnWriteListIterator(this, this.realList.listIterator());
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.realList.lastIndexOf(object);
    }

    @Override
    public ListIterator listIterator() {
        return new CopyOnWriteArrayList$CopyOnWriteListIterator(this, this.realList.listIterator());
    }

    @Override
    public ListIterator listIterator(int n) {
        return new CopyOnWriteArrayList$CopyOnWriteListIterator(this, this.realList.listIterator(n));
    }

    @Override
    public synchronized Object remove(int n) {
        ArrayList arrayList = new ArrayList(this.realList);
        Object object = arrayList.remove(n);
        arrayList.trimToSize();
        this.realList = arrayList;
        return object;
    }

    @Override
    public synchronized boolean remove(Object object) {
        ArrayList arrayList = new ArrayList(this.realList);
        boolean bl = arrayList.remove(object);
        arrayList.trimToSize();
        this.realList = arrayList;
        return bl;
    }

    @Override
    public synchronized boolean removeAll(Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList);
        boolean bl = arrayList.removeAll(collection);
        arrayList.trimToSize();
        this.realList = arrayList;
        return bl;
    }

    @Override
    public synchronized boolean retainAll(Collection collection) {
        ArrayList arrayList = new ArrayList(this.realList);
        boolean bl = arrayList.retainAll(collection);
        arrayList.trimToSize();
        this.realList = arrayList;
        return bl;
    }

    @Override
    public synchronized Object set(int n, Object object) {
        ArrayList arrayList = new ArrayList(this.realList);
        Object object2 = arrayList.set(n, object);
        this.realList = arrayList;
        return object2;
    }

    @Override
    public int size() {
        return this.realList.size();
    }

    @Override
    public List subList(int n, int n2) {
        return new CopyOnWriteArrayList$CopyOnWriteSubList(this, this.realList.subList(n, n2));
    }

    @Override
    public Object[] toArray() {
        return this.realList.toArray();
    }

    @Override
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

    @Override
    public boolean equals(Object object) {
        return this.realList.equals(object);
    }

    @Override
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
}

