/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;
import java.util.Collection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GList<T>
extends GCollection<T> {
    public void add(int var1, T var2);

    @Override
    public boolean add(T var1);

    public boolean addAll(int var1, GCollection<T> var2);

    @Override
    public boolean addAll(GCollection<T> var1);

    public boolean addAll(Collection var1);

    @Override
    public void clear();

    @Override
    public boolean contains(T var1);

    @Override
    public boolean containsAll(GCollection<T> var1);

    public T get(int var1);

    public int indexOf(T var1);

    @Override
    public boolean isEmpty();

    @Override
    public GIterator<T> iterator();

    public int lastIndexOf(T var1);

    public T remove(int var1);

    @Override
    public boolean remove(T var1);

    @Override
    public boolean removeAll(GCollection<T> var1);

    @Override
    public boolean retainAll(GCollection<T> var1);

    public T set(int var1, T var2);

    @Override
    public int size();

    public GList<T> subList(int var1, int var2);

    @Override
    public Object[] toArray();

    @Override
    public T[] toArray(T[] var1);
}

