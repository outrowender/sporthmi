/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.observables;

import de.audi.atip.utils.reactive.observables.BackChannel;
import de.audi.atip.utils.reactive.observables.Sink;
import de.audi.atip.utils.reactive.observables.Source;
import de.audi.atip.utils.reactive.operations.SinkWrapper;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class SingleSource<T>
implements Source<T> {
    private boolean connected;
    private boolean canceled;

    protected abstract void onSinkConnected(Sink<T> var1);

    @Override
    public BackChannel setSink(final Sink<T> sink) {
        final SinkWrapper sinkWrapper = new SinkWrapper<T>(sink){

            @Override
            public void accept(T t) {
                if (!SingleSource.this.canceled) {
                    sink.accept(t);
                }
            }
        };
        if (this.connected) {
            throw new IllegalStateException();
        }
        this.connected = true;
        this.onSinkConnected(sinkWrapper);
        return new BackChannel(){

            public void disconnect() {
                SingleSource.this.canceled = true;
                SingleSource.this.onDisconnect(sinkWrapper);
            }
        };
    }

    protected void onDisconnect(Sink<T> sink) {
    }
}

