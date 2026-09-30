/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import java.io.Serializable;

public class AtomicLong
extends Number
implements Serializable {
    private static final long serialVersionUID = 1927816293512124184L;
    private volatile long value;

    public AtomicLong(long l) {
        this.value = l;
    }

    public AtomicLong() {
    }

    public final long get() {
        return this.value;
    }

    public final synchronized void set(long l) {
        this.value = l;
    }

    public final synchronized void lazySet(long l) {
        this.value = l;
    }

    public final synchronized long getAndSet(long l) {
        long l2 = this.value;
        this.value = l;
        return l2;
    }

    public final synchronized boolean compareAndSet(long l, long l2) {
        if (this.value == l) {
            this.value = l2;
            return true;
        }
        return false;
    }

    public final synchronized boolean weakCompareAndSet(long l, long l2) {
        if (this.value == l) {
            this.value = l2;
            return true;
        }
        return false;
    }

    public final synchronized long getAndIncrement() {
        return this.value++;
    }

    public final synchronized long getAndDecrement() {
        return this.value--;
    }

    public final synchronized long getAndAdd(long l) {
        long l2 = this.value;
        this.value += l;
        return l2;
    }

    public final synchronized long incrementAndGet() {
        return ++this.value;
    }

    public final synchronized long decrementAndGet() {
        return --this.value;
    }

    public final synchronized long addAndGet(long l) {
        return this.value += l;
    }

    public String toString() {
        return Long.toString(this.get());
    }

    public int intValue() {
        return (int)this.get();
    }

    public long longValue() {
        return this.get();
    }

    public float floatValue() {
        return this.get();
    }

    public double doubleValue() {
        return this.get();
    }
}

