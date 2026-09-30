/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface LRUCache {
    public Object get(Comparable var1, int var2, int var3);

    public void put(Comparable var1, Object var2, int var3, int var4, int var5, int var6, int var7);

    public Object[] elements();

    public int size();

    public void clear();

    public void decrementRefCounters(int var1, int var2);

    public long getStorageSize();
}

