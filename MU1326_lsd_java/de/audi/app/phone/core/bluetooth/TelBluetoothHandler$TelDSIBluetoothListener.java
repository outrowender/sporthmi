/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.bluetooth.TelBluetoothHandler;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler$1;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler$TelDSIBluetoothListener$1;
import de.audi.app.phone.core.bluetooth.TelDefaultBluetoothListener;
import org.dsi.ifc.bluetooth.TrustedDevice;

class TelBluetoothHandler$TelDSIBluetoothListener
extends TelDefaultBluetoothListener {
    private final /* synthetic */ TelBluetoothHandler this$0;

    private TelBluetoothHandler$TelDSIBluetoothListener(TelBluetoothHandler telBluetoothHandler) {
        this.this$0 = telBluetoothHandler;
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n == 1) {
            TelBluetoothHandler.access$900(this.this$0).enqueueEvent(new TelBluetoothHandler$TelDSIBluetoothListener$1(this, "TelDSIBluetoothListener#updateTrustedDevices", trustedDeviceArray));
        }
    }

    /* synthetic */ TelBluetoothHandler$TelDSIBluetoothListener(TelBluetoothHandler telBluetoothHandler, TelBluetoothHandler$1 telBluetoothHandler$1) {
        this(telBluetoothHandler);
    }

    static /* synthetic */ TelBluetoothHandler access$400(TelBluetoothHandler$TelDSIBluetoothListener telBluetoothHandler$TelDSIBluetoothListener) {
        return telBluetoothHandler$TelDSIBluetoothListener.this$0;
    }
}

