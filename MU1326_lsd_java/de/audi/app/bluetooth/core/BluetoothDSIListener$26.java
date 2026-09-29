/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;

class BluetoothDSIListener$26
extends CommandResponse {
    private final /* synthetic */ MasterRoleRequestStruct val$masterRoleRequestError;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$26(BluetoothDSIListener bluetoothDSIListener, MasterRoleRequestStruct masterRoleRequestStruct, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$masterRoleRequestError = masterRoleRequestStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateMasterRoleRequestError(this.val$masterRoleRequestError, this.val$validFlag);
    }
}

