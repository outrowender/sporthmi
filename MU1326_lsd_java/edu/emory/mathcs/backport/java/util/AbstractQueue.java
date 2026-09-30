/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractCollection;
import edu.emory.mathcs.backport.java.util.Queue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractQueue
extends AbstractCollection
implements Queue {
    protected AbstractQueue() {
    }

    public boolean add(Object object) {
        if (this.offer(object)) {
            return true;
        }
        throw new IllegalStateException("Queue full");
    }

    public Object remove() {
        Object object = this.poll();
        if (object != null) {
            return object;
        }
        throw new NoSuchElementException();
    }

    public Object element() {
        Object object = this.peek();
        if (object != null) {
            return object;
        }
        throw new NoSuchElementException();
    }

    public void clear() {
        while (this.poll() != null) {
        }
    }

    public boolean addAll(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        boolean bl = false;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.add(iterator.next())) continue;
            bl = true;
        }
        return bl;
    }
}

