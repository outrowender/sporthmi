/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicReference;

public class AtomicStampedReference {
    private final AtomicReference atomicRef;

    public AtomicStampedReference(Object object, int n) {
        this.atomicRef = new AtomicReference(new ReferenceIntegerPair(object, n));
    }

    public Object getReference() {
        return this.getPair().reference;
    }

    public int getStamp() {
        return this.getPair().integer;
    }

    public Object get(int[] nArray) {
        ReferenceIntegerPair referenceIntegerPair = this.getPair();
        nArray[0] = referenceIntegerPair.integer;
        return referenceIntegerPair.reference;
    }

    public boolean weakCompareAndSet(Object object, Object object2, int n, int n2) {
        ReferenceIntegerPair referenceIntegerPair = this.getPair();
        return object == referenceIntegerPair.reference && n == referenceIntegerPair.integer && (object2 == referenceIntegerPair.reference && n2 == referenceIntegerPair.integer || this.atomicRef.weakCompareAndSet(referenceIntegerPair, new ReferenceIntegerPair(object2, n2)));
    }

    public boolean compareAndSet(Object object, Object object2, int n, int n2) {
        ReferenceIntegerPair referenceIntegerPair = this.getPair();
        return object == referenceIntegerPair.reference && n == referenceIntegerPair.integer && (object2 == referenceIntegerPair.reference && n2 == referenceIntegerPair.integer || this.atomicRef.compareAndSet(referenceIntegerPair, new ReferenceIntegerPair(object2, n2)));
    }

    public void set(Object object, int n) {
        ReferenceIntegerPair referenceIntegerPair = this.getPair();
        if (object != referenceIntegerPair.reference || n != referenceIntegerPair.integer) {
            this.atomicRef.set(new ReferenceIntegerPair(object, n));
        }
    }

    public boolean attemptStamp(Object object, int n) {
        ReferenceIntegerPair referenceIntegerPair = this.getPair();
        return object == referenceIntegerPair.reference && (n == referenceIntegerPair.integer || this.atomicRef.compareAndSet(referenceIntegerPair, new ReferenceIntegerPair(object, n)));
    }

    private ReferenceIntegerPair getPair() {
        return (ReferenceIntegerPair)this.atomicRef.get();
    }

    private static class ReferenceIntegerPair {
        private final Object reference;
        private final int integer;

        ReferenceIntegerPair(Object object, int n) {
            this.reference = object;
            this.integer = n;
        }
    }
}

