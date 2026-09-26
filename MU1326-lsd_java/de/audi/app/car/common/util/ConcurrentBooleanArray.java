/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

public class ConcurrentBooleanArray {
    private final boolean[] array;

    public ConcurrentBooleanArray(int n) {
        this.array = new boolean[n];
    }

    public synchronized boolean get(int n) {
        return this.array[n];
    }

    public synchronized void set(int n, boolean bl) {
        this.array[n] = bl;
    }

    public synchronized int length() {
        return this.array.length;
    }
}

