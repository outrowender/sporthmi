/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.BluetoothSourceStateProvider;
import de.audi.app.media.source.state.providers.BluetoothState;

class BluetoothSourceStateProvider$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ BluetoothState val$bluetoothState;
    private final /* synthetic */ BluetoothSourceStateProvider this$0;

    BluetoothSourceStateProvider$3(BluetoothSourceStateProvider bluetoothSourceStateProvider, String string, BluetoothState bluetoothState) {
        this.this$0 = bluetoothSourceStateProvider;
        this.val$bluetoothState = bluetoothState;
        super(string);
    }

    @Override
    public void run() {
        BluetoothSourceStateProvider.access$000(this.this$0).updateSourceState(new SourceStateUpdate(5, this.val$bluetoothState));
    }
}

