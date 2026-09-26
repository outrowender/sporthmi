/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.operations.LogOperation$1;
import de.audi.atip.utils.reactive.operations.Operation;

public class LogOperation
implements Operation {
    private final LogChannel lc;
    private final String comment;

    public LogOperation(LogChannel logChannel, String string) {
        this.lc = logChannel;
        this.comment = string;
    }

    /*
     * Handled unverifiable bytecode (illegal jump).
     */
    @Override
    public Sink decorateSink(Sink sink) {
        return new LogOperation$1(this, sink, sink);
    }

    static /* synthetic */ String access$000(LogOperation logOperation) {
        return logOperation.comment;
    }

    static /* synthetic */ LogChannel access$100(LogOperation logOperation) {
        return logOperation.lc;
    }
}

