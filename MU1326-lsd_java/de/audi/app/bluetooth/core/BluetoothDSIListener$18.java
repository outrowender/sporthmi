/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$18
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$18(BluetoothDSIListener bluetoothDSIListener, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).responseSetAccessibleMode(this.val$result);
    }
}

