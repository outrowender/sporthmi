/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public abstract class AbstractSequentialList
extends AbstractList {
    protected AbstractSequentialList() {
    }

    public void add(int n, Object object) {
        this.listIterator(n).add(object);
    }

    public boolean addAll(int n, Collection collection) {
        ListIterator listIterator = this.listIterator(n);
        Iterator iterator = collection.iterator();
        int n2 = listIterator.nextIndex();
        while (iterator.hasNext()) {
            listIterator.add(iterator.next());
            listIterator.previous();
        }
        return n2 != listIterator.nextIndex();
    }

    public Object get(int n) {
        try {
            return this.listIterator(n).next();
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Iterator iterator() {
        return this.listIterator(0);
    }

    public abstract ListIterator listIterator(int var1);

    public Object remove(int n) {
        try {
            ListIterator listIterator = this.listIterator(n);
            Object object = listIterator.next();
            listIterator.remove();
            return object;
        }
        catch (NoSuchElementException noSuchElementException) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object set(int n, Object object) {
        ListIterator listIterator = this.listIterator(n);
        Object object2 = listIterator.next();
        listIterator.set(object);
        return object2;
    }
}

