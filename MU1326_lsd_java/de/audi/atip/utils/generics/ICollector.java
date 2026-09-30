/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ICollector<In, Out> {
    public Out createContainer();

    public void add(Out var1, In var2);
}

