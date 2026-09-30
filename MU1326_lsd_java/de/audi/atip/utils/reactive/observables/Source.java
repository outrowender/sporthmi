/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.Sink;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface Source<T> {
    public BackChannel setSink(Sink<T> var1);
}

