/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import org.dsi.ifc.bluetooth.TrustedDevice;

public interface ITelBluetoothListener {
    default public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray) {
    }
}

