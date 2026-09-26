/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$1
extends CommandResponse {
    private final /* synthetic */ String val$btDeviceAddress;
    private final /* synthetic */ String val$btDeviceName;
    private final /* synthetic */ int val$disconnectionInfo;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$1(BluetoothDSIListener bluetoothDSIListener, String string, String string2, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$btDeviceAddress = string;
        this.val$btDeviceName = string2;
        this.val$disconnectionInfo = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).deviceDisonnectionInfo(this.val$btDeviceAddress, this.val$btDeviceName, this.val$disconnectionInfo);
    }
}

