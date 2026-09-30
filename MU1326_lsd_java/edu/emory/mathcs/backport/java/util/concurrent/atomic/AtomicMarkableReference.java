/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.atomic;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicReference;

public class AtomicMarkableReference {
    private final AtomicReference atomicRef;

    public AtomicMarkableReference(Object object, boolean bl) {
        this.atomicRef = new AtomicReference(new ReferenceBooleanPair(object, bl));
    }

    private ReferenceBooleanPair getPair() {
        return (ReferenceBooleanPair)this.atomicRef.get();
    }

    public Object getReference() {
        return this.getPair().reference;
    }

    public boolean isMarked() {
        return this.getPair().bit;
    }

    public Object get(boolean[] blArray) {
        ReferenceBooleanPair referenceBooleanPair = this.getPair();
        blArray[0] = referenceBooleanPair.bit;
        return referenceBooleanPair.reference;
    }

    public boolean weakCompareAndSet(Object object, Object object2, boolean bl, boolean bl2) {
        ReferenceBooleanPair referenceBooleanPair = this.getPair();
        return object == referenceBooleanPair.reference && bl == referenceBooleanPair.bit && (object2 == referenceBooleanPair.reference && bl2 == referenceBooleanPair.bit || this.atomicRef.weakCompareAndSet(referenceBooleanPair, new ReferenceBooleanPair(object2, bl2)));
    }

    public boolean compareAndSet(Object object, Object object2, boolean bl, boolean bl2) {
        ReferenceBooleanPair referenceBooleanPair = this.getPair();
        return object == referenceBooleanPair.reference && bl == referenceBooleanPair.bit && (object2 == referenceBooleanPair.reference && bl2 == referenceBooleanPair.bit || this.atomicRef.compareAndSet(referenceBooleanPair, new ReferenceBooleanPair(object2, bl2)));
    }

    public void set(Object object, boolean bl) {
        ReferenceBooleanPair referenceBooleanPair = this.getPair();
        if (object != referenceBooleanPair.reference || bl != referenceBooleanPair.bit) {
            this.atomicRef.set(new ReferenceBooleanPair(object, bl));
        }
    }

    public boolean attemptMark(Object object, boolean bl) {
        ReferenceBooleanPair referenceBooleanPair = this.getPair();
        return object == referenceBooleanPair.reference && (bl == referenceBooleanPair.bit || this.atomicRef.compareAndSet(referenceBooleanPair, new ReferenceBooleanPair(object, bl)));
    }

    private static class ReferenceBooleanPair {
        private final Object reference;
        private final boolean bit;

        ReferenceBooleanPair(Object object, boolean bl) {
            this.reference = object;
            this.bit = bl;
        }
    }
}

