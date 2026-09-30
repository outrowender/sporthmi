/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.injector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IInjector {
    public <T> T getInstance(Class var1);

    public <T> T getInstance(Object var1, Class var2);
}

