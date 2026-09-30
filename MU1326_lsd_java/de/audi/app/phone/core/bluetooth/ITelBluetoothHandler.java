/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;

public interface ITelBluetoothHandler {
    public void addBluetoothListener(ITelBluetoothListener var1);

    public void removeBluetoothListener(ITelBluetoothListener var1);
}

