/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GSet<T>
extends GCollection<T> {
    @Override
    public boolean add(T var1);

    @Override
    public boolean addAll(GCollection<T> var1);

    @Override
    public void clear();

    @Override
    public boolean contains(T var1);

    @Override
    public boolean containsAll(GCollection<T> var1);

    @Override
    public boolean isEmpty();

    @Override
    public GIterator<T> iterator();

    @Override
    public boolean remove(T var1);

    @Override
    public boolean removeAll(GCollection<T> var1);

    @Override
    public boolean retainAll(GCollection<T> var1);

    @Override
    public int size();

    @Override
    public Object[] toArray();

    @Override
    public T[] toArray(T[] var1);
}

