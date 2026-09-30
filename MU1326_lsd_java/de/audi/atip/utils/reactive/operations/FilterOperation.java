/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class FilterOperation<T>
implements Operation<T, T> {
    private final Predicate<T> predicate;

    public FilterOperation(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){

            @Override
            public void accept(T t) {
                if (FilterOperation.this.predicate.apply(t)) {
                    sink.accept(t);
                }
            }
        };
    }
}

