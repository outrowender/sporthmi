/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$24
extends CommandResponse {
    private final /* synthetic */ int val$candBTHSState;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$24(BluetoothDSIListener bluetoothDSIListener, int n, int n2) {
        this.this$0 = bluetoothDSIListener;
        this.val$candBTHSState = n;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateHUCandBTHSState(this.val$candBTHSState, this.val$validFlag);
    }
}

