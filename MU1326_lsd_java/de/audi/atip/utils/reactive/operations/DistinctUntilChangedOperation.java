/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DistinctUntilChangedOperation<T>
implements Operation<T, T> {
    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){
            T lastData;

            @Override
            public void accept(T t) {
                if (this.lastData == null || !this.lastData.equals(t)) {
                    sink.accept(t);
                }
                this.lastData = t;
            }
        };
    }
}

