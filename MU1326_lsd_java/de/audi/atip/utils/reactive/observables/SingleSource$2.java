/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.observables.SingleSource
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.SingleSource;
import de.audi.atip.utils.reactive.observables.Sink;

class SingleSource$2
implements BackChannel {
    private final /* synthetic */ Sink val$wrappedSink;
    private final /* synthetic */ SingleSource this$0;

    SingleSource$2(SingleSource singleSource, Sink sink) {
        this.this$0 = singleSource;
        this.val$wrappedSink = sink;
    }

    @Override
    public void disconnect() {
        SingleSource.access$002((SingleSource)this.this$0, (boolean)true);
        this.this$0.onDisconnect(this.val$wrappedSink);
    }
}

