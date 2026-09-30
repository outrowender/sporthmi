/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.Operation;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class LogOperation<T>
implements Operation<T, T> {
    private final LogChannel lc;
    private final String comment;

    public LogOperation(LogChannel logChannel, String string) {
        this.lc = logChannel;
        this.comment = string;
    }

    @Override
    public Sink<T> decorateSink(final Sink<T> sink) {
        return new SinkWrapper<T>(sink){

            @Override
            public void accept(T t) {
                LogOperation.this.lc.log(10000000, "[LogOperation.log] %1 %2", (Object)LogOperation.this.comment, t != null ? t : "null");
                sink.accept(t);
            }
        };
    }
}

