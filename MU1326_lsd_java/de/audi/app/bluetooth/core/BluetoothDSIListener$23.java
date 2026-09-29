/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

class BluetoothDSIListener$23
extends CommandResponse {
    private final /* synthetic */ DiscoveredDevice val$discoveredDevices;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$23(BluetoothDSIListener bluetoothDSIListener, DiscoveredDevice discoveredDevice, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$discoveredDevices = discoveredDevice;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateDiscoveredDevices(this.val$discoveredDevices, this.val$validFlag);
    }
}

