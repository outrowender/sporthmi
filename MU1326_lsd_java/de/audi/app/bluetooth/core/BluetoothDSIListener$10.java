/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$10
extends CommandResponse {
    private final /* synthetic */ int val$numDevices;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$10(BluetoothDSIListener bluetoothDSIListener, int n, int n2) {
        this.this$0 = bluetoothDSIListener;
        this.val$numDevices = n;
        this.val$result = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).responseInquiry(this.val$numDevices, this.val$result);
    }
}

