/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util;

public class SynchronizedInteger {
    private int value;

    public SynchronizedInteger() {
        this(0);
    }

    public SynchronizedInteger(int n) {
        this.value = n;
    }

    public synchronized int get() {
        return this.value;
    }

    public synchronized void setValue(int n) {
        this.value = n;
    }

    public synchronized void increment() {
        this.incrementBy(1);
    }

    public synchronized void incrementBy(int n) {
        this.value += n;
    }

    public synchronized void decrement() {
        this.decrementBy(1);
    }

    public synchronized void decrementBy(int n) {
        this.value -= n;
    }

    public synchronized boolean isGreaterThan(int n) {
        return this.value > n;
    }

    public synchronized void decrementIfGreaterThan(int n) {
        if (this.value > n) {
            this.decrement();
        }
    }

    public synchronized String toString() {
        return String.valueOf(this.value);
    }
}

