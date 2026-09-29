/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;

public interface ITelBluetoothHandler {
    default public void addBluetoothListener(ITelBluetoothListener iTelBluetoothListener) {
    }

    default public void removeBluetoothListener(ITelBluetoothListener iTelBluetoothListener) {
    }
}

