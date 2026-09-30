/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Iterator;

public interface ListIterator
extends Iterator {
    public void add(Object var1);

    public boolean hasNext();

    public boolean hasPrevious();

    public Object next();

    public int nextIndex();

    public Object previous();

    public int previousIndex();

    public void remove();

    public void set(Object var1);
}

