/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import java.lang.ref.WeakReference;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GWeakReference<T> {
    private final WeakReference weakReference;

    public GWeakReference(T t) {
        this.weakReference = new WeakReference(t);
    }

    public void clear() {
        this.weakReference.clear();
    }

    public boolean enqueue() {
        return this.weakReference.enqueue();
    }

    public T get() {
        return (T)this.weakReference.get();
    }

    public boolean isEnqueued() {
        return this.weakReference.isEnqueued();
    }
}

