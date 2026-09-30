/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.generics.ICollector;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CollectOperation<T, ResultType>
implements Operation<T, ResultType> {
    private final ICollector<T, ResultType> collector;
    private final ResultType output;

    public CollectOperation(ICollector<T, ResultType> iCollector) {
        this.collector = iCollector;
        this.output = iCollector.createContainer();
    }

    @Override
    public Sink<T> decorateSink(final Sink<ResultType> sink) {
        return new SinkWrapper<T>(sink){

            @Override
            public void accept(T t) {
                CollectOperation.this.collector.add(CollectOperation.this.output, t);
            }

            @Override
            public void closed() {
                sink.accept(CollectOperation.this.output);
                super.closed();
            }
        };
    }
}

