/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

class LRUCacheEAL$Item {
    public Comparable key;
    public Object value;
    public long size;
    public LRUCacheEAL$Item previous;
    public LRUCacheEAL$Item next;
    public int referenceCounter;

    public LRUCacheEAL$Item(Comparable comparable, Object object, long l) {
        this.key = comparable;
        this.value = object;
        this.size = l;
    }

    public LRUCacheEAL$Item() {
    }
}

