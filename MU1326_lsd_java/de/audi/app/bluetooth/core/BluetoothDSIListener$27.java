/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;

class BluetoothDSIListener$27
extends CommandResponse {
    private final /* synthetic */ PasskeyStateStruct val$passkeyState;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$27(BluetoothDSIListener bluetoothDSIListener, PasskeyStateStruct passkeyStateStruct, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$passkeyState = passkeyStateStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updatePasskeyState(this.val$passkeyState, this.val$validFlag);
    }
}

