/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TakeOperation<T>
implements Operation<T, T> {
    private final int howMany;

    public TakeOperation(int n) {
        Preconditions.checkArgument(n > 0);
        this.howMany = n;
    }

    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){
            private int taken;
            {
                super(sink3);
                this.taken = 0;
            }

            @Override
            public void accept(T t) {
                ++this.taken;
                if (this.taken < TakeOperation.this.howMany) {
                    sink.accept(t);
                } else if (this.taken == TakeOperation.this.howMany) {
                    sink.accept(t);
                    sink.closed();
                }
            }

            @Override
            public void closed() {
                if (this.taken < TakeOperation.this.howMany) {
                    super.closed();
                }
            }
        };
    }
}

