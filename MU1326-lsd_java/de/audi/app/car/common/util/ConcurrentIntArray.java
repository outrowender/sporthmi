/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

public class ConcurrentIntArray {
    private final int[] array;

    public ConcurrentIntArray(int n) {
        this.array = new int[n];
    }

    public synchronized int get(int n) {
        return this.array[n];
    }

    public synchronized void set(int n, int n2) {
        this.array[n] = n2;
    }

    public synchronized int length() {
        return this.array.length;
    }
}

