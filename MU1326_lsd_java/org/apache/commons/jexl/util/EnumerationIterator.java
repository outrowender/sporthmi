/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.util;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator
implements Iterator {
    private final Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public Object next() {
        return this.enumeration.nextElement();
    }

    @Override
    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    @Override
    public void remove() {
    }
}

