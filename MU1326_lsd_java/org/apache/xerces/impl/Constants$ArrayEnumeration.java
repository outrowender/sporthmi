/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.util.Enumeration;
import java.util.NoSuchElementException;

class Constants$ArrayEnumeration
implements Enumeration {
    private Object[] array;
    private int index;

    public Constants$ArrayEnumeration(Object[] objectArray) {
        this.array = objectArray;
    }

    @Override
    public boolean hasMoreElements() {
        return this.index < this.array.length;
    }

    @Override
    public Object nextElement() {
        if (this.index < this.array.length) {
            return this.array[this.index++];
        }
        throw new NoSuchElementException();
    }
}

