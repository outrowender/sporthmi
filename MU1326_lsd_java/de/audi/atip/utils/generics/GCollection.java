/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.IFluentCollection;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GCollection<T> {
    public boolean add(T var1);

    public boolean addAll(GCollection<T> var1);

    public void clear();

    public boolean contains(T var1);

    public boolean containsAll(GCollection<T> var1);

    public boolean isEmpty();

    public GIterator<T> iterator();

    public boolean remove(T var1);

    public boolean removeAll(GCollection<T> var1);

    public boolean retainAll(GCollection<T> var1);

    public int size();

    public Object[] toArray();

    public T[] toArray(T[] var1);

    public Collection getBackingCollection();

    public IFluentCollection<T> fluent();
}

