/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface LRUCache {
    default public Object get(Comparable comparable, int n, int n2) {
    }

    default public void put(Comparable comparable, Object object, int n, int n2, int n3, int n4, int n5) {
    }

    default public Object[] elements() {
    }

    default public int size() {
    }

    default public void clear() {
    }

    default public void decrementRefCounters(int n, int n2) {
    }

    default public long getStorageSize() {
    }
}

