/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;

public final class TransactionId {
    public static final int NO_EXPECTED_VALUE = -1;
    private final int initialValue;
    private final int maxValue;
    private final AtomicInteger count;
    private volatile int lastValueReturned = -1;

    public TransactionId(int n, int n2) {
        this.initialValue = n;
        this.maxValue = n2;
        this.count = new AtomicInteger(this.initialValue);
    }

    public synchronized int getAndIncrement() {
        this.lastValueReturned = this.count.getAndIncrement();
        if (this.count.get() > this.maxValue) {
            this.count.set(this.initialValue);
        }
        return this.lastValueReturned;
    }

    public synchronized int expectedValue() {
        return this.lastValueReturned;
    }

    public synchronized void reset() {
        this.count.set(this.initialValue);
        this.lastValueReturned = -1;
    }
}

