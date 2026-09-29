/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$8
extends CommandResponse {
    private final /* synthetic */ String val$btDeviceAddress;
    private final /* synthetic */ int val$btServiceType;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$8(BluetoothDSIListener bluetoothDSIListener, String string, int n, int n2) {
        this.this$0 = bluetoothDSIListener;
        this.val$btDeviceAddress = string;
        this.val$btServiceType = n;
        this.val$result = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).responseDisconnectService(this.val$btDeviceAddress, this.val$btServiceType, this.val$result);
    }
}

