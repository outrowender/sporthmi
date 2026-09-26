/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$20
extends CommandResponse {
    private final /* synthetic */ boolean val$userSetting;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$20(BluetoothDSIListener bluetoothDSIListener, boolean bl, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$userSetting = bl;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateA2DPUserSetting(this.val$userSetting, this.val$validFlag);
    }
}

