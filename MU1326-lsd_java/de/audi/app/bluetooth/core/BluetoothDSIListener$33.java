/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$33
extends CommandResponse {
    private final /* synthetic */ String val$userFriendlyName;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$33(BluetoothDSIListener bluetoothDSIListener, String string, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$userFriendlyName = string;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateUserFriendlyName(this.val$userFriendlyName, this.val$validFlag);
    }
}

