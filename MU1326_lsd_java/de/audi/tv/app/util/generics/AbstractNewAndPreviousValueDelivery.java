/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.generics;

import de.audi.atip.utils.generics.Consumer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractNewAndPreviousValueDelivery<T>
implements Consumer<T> {
    private T previousData;

    @Override
    public void accept(T t) {
        this.accept(this.previousData, t);
        this.previousData = t;
    }

    protected abstract void accept(T var1, T var2);
}

