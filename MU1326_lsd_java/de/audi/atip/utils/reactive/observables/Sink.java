/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface Sink<T> {
    public void closed();

    public void accept(T var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Stub<T>
    implements Sink<T> {
        @Override
        public void accept(T t) {
        }

        @Override
        public void closed() {
        }
    }
}

