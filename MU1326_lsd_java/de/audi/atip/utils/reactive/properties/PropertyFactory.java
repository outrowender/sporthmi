/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.properties.Property;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface PropertyFactory
extends Disposable {
    public <T> Property<T> createProperty(String var1);

    public <T> Property<T> createProperty(String var1, T var2);

    public <T> Property<T> createProperty(String var1, LogChannel var2, int var3);

    public <T> Property<T> createProperty(String var1, T var2, LogChannel var3, int var4);
}

