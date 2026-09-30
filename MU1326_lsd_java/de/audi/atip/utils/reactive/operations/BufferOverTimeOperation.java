/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BufferOverTimeOperation<T>
implements Operation<T, GList<T>> {
    private final int timespan;
    private final IDispatcher dispatcher;

    public BufferOverTimeOperation(int n, IDispatcher iDispatcher) {
        Preconditions.checkArgument(n > 0, "Timespan must be a positive number!");
        this.timespan = n;
        this.dispatcher = Preconditions.checkNotNull(iDispatcher);
    }

    @Override
    public Sink<T> decorateSink(final Sink<GList<T>> sink) {
        return new SinkWrapper<T>(sink){
            private GList<T> buffered;
            private IDispatcher.ICancelable cancelable;
            {
                super(sink3);
                this.cancelable = new IDispatcher.ICancelable.Stub();
            }

            @Override
            public void accept(final T t) {
                BufferOverTimeOperation.this.dispatcher.execute(new Runnable(){

                    public void run() {
                        if (buffered == null) {
                            buffered = Generics.newArrayList();
                            cancelable = BufferOverTimeOperation.this.dispatcher.execute(new Runnable(){

                                public void run() {
                                    sink.accept(buffered);
                                    buffered = null;
                                }
                            }, BufferOverTimeOperation.this.timespan);
                        }
                        buffered.add(t);
                    }
                });
            }

            @Override
            public void closed() {
                this.cancelable.cancel();
                super.closed();
            }
        };
    }
}

