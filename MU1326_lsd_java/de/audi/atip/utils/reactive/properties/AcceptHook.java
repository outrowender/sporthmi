/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface AcceptHook<T> {
    public static final AcceptHook<Object> STUB = new Stub<Object>();

    public void onAccept(String var1, T var2);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Stub<T>
    implements AcceptHook<T> {
        @Override
        public void onAccept(String string, T t) {
        }
    }
}

