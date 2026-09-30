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
public class DebounceOperation<T>
implements Operation<T, T> {
    private final IDispatcher dispatcher;
    private final long _debounceTime;

    public DebounceOperation(int n, IDispatcher iDispatcher) {
        this._debounceTime = n;
        this.dispatcher = iDispatcher;
    }

    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){
            IDispatcher.ICancelable cancelable;
            {
                super(sink3);
                this.cancelable = new IDispatcher.ICancelable.Stub();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void accept(final T t) {
                1 var2_2 = this;
                synchronized (var2_2) {
                    this.cancelable.cancel();
                    this.cancelable = DebounceOperation.this.dispatcher.execute(new Runnable(){

                        public void run() {
                            sink.accept(t);
                        }
                    }, DebounceOperation.this._debounceTime);
                }
            }

            @Override
            public void closed() {
                this.cancelable.cancel();
                super.closed();
            }
        };
    }
}

