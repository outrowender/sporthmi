/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TeeOperation<T>
implements Operation<T, T> {
    private final Consumer<T> consumer;

    public TeeOperation(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){

            @Override
            public void accept(T t) {
                TeeOperation.this.consumer.accept(t);
                sink.accept(t);
            }
        };
    }
}

