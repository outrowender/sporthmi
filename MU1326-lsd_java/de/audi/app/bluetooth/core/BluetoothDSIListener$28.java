/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$28
extends CommandResponse {
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ String val$btDeviceAddress;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$28(BluetoothDSIListener bluetoothDSIListener, boolean bl, String string, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$active = bl;
        this.val$btDeviceAddress = string;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updatePriorizedDeviceReconnect(this.val$active, this.val$btDeviceAddress, this.val$validFlag);
    }
}

