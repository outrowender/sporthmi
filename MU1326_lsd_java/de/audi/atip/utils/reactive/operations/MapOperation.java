/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MapOperation<From, To>
implements Operation<From, To> {
    private final Function<? super From, To> function;

    public MapOperation(Function<? super From, To> function) {
        this.function = function;
    }

    @Override
    public Sink<From> decorateSink(final Sink<To> sink) {
        return new SinkWrapper<From>(sink){

            @Override
            public void accept(From From) {
                sink.accept(MapOperation.this.function.apply(From));
            }
        };
    }
}

