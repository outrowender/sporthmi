/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.reactive.observables.Sink;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class SinkWrapper<T>
implements Sink<T> {
    private final Sink<?> downstream;

    public SinkWrapper(Sink<?> sink) {
        this.downstream = sink;
    }

    @Override
    public void closed() {
        this.downstream.closed();
    }
}

