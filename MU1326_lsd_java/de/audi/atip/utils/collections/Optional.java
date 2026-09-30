/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import de.audi.atip.utils.generics.Consumer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Optional<T> {
    private final T object;

    public Optional(T t) {
        this.object = t;
    }

    public T get() {
        return this.object;
    }

    public boolean exists() {
        return this.object != null;
    }

    public void ifExists(Consumer<T> consumer) {
        if (this.exists()) {
            consumer.accept(this.object);
        }
    }

    public String toString() {
        return new StringBuffer().append("Optional [").append(this.object).append("]").toString();
    }
}

