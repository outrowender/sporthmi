/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.TrustedDevice;

class BluetoothDSIListener$32
extends CommandResponse {
    private final /* synthetic */ TrustedDevice[] val$trustedDevices;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$32(BluetoothDSIListener bluetoothDSIListener, TrustedDevice[] trustedDeviceArray, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$trustedDevices = trustedDeviceArray;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateTrustedDevices(this.val$trustedDevices, this.val$validFlag);
    }
}

