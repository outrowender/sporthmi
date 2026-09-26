/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator
implements Iterator {
    private final Object array;
    private int pos;
    private final int size;

    public ArrayIterator(Object object) {
        if (!object.getClass().isArray()) {
            throw new IllegalArgumentException("Programmer error : internal ArrayIterator invoked w/o array");
        }
        this.array = object;
        this.pos = 0;
        this.size = Array.getLength(this.array);
    }

    @Override
    public Object next() {
        if (this.pos < this.size) {
            return Array.get(this.array, this.pos++);
        }
        throw new NoSuchElementException(new StringBuffer().append("No more elements: ").append(this.pos).append(" / ").append(this.size).toString());
    }

    @Override
    public boolean hasNext() {
        return this.pos < this.size;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

