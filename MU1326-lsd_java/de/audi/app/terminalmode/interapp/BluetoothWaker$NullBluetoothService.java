/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.interapp.BluetoothWaker;
import de.audi.app.terminalmode.interapp.BluetoothWaker$1;
import de.audi.atip.interapp.IBluetoothService;

final class BluetoothWaker$NullBluetoothService
implements IBluetoothService {
    private final /* synthetic */ BluetoothWaker this$0;

    private BluetoothWaker$NullBluetoothService(BluetoothWaker bluetoothWaker) {
        this.this$0 = bluetoothWaker;
    }

    @Override
    public void disconnectService(String string, int n) {
    }

    @Override
    public void deactivateBluetoothAudio() {
    }

    @Override
    public void connectService(String string, int n, String string2, boolean bl) {
    }

    @Override
    public void activateBluetoothAudio() {
    }

    @Override
    public void activateBluetooth() {
    }

    /* synthetic */ BluetoothWaker$NullBluetoothService(BluetoothWaker bluetoothWaker, BluetoothWaker$1 bluetoothWaker$1) {
        this(bluetoothWaker);
    }
}

