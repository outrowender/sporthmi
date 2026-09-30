/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AsyncOperation<T>
implements Operation<T, T> {
    private final IDispatcher dispatcher;

    public AsyncOperation(IDispatcher iDispatcher) {
        this.dispatcher = iDispatcher;
    }

    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){

            @Override
            public void accept(final T t) {
                AsyncOperation.this.dispatcher.execute(new Runnable(){

                    public void run() {
                        sink.accept(t);
                    }
                });
            }
        };
    }
}

