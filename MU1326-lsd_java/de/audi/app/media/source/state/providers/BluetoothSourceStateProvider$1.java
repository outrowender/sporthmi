/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.BluetoothSourceStateProvider;

class BluetoothSourceStateProvider$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ BluetoothSourceStateProvider this$0;

    BluetoothSourceStateProvider$1(BluetoothSourceStateProvider bluetoothSourceStateProvider, String string) {
        this.this$0 = bluetoothSourceStateProvider;
        super(string);
    }

    @Override
    public void run() {
        BluetoothSourceStateProvider.access$000(this.this$0).updateSourceState(new SourceStateUpdate(7, null));
    }
}

