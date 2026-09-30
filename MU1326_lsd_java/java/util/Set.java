/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Collection;
import java.util.Iterator;

public interface Set
extends Collection {
    public boolean add(Object var1);

    public boolean addAll(Collection var1);

    public void clear();

    public boolean contains(Object var1);

    public boolean containsAll(Collection var1);

    public boolean equals(Object var1);

    public int hashCode();

    public boolean isEmpty();

    public Iterator iterator();

    public boolean remove(Object var1);

    public boolean removeAll(Collection var1);

    public boolean retainAll(Collection var1);

    public int size();

    public Object[] toArray();

    public Object[] toArray(Object[] var1);
}

