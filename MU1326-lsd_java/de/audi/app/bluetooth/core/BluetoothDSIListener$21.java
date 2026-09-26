/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;

class BluetoothDSIListener$21
extends CommandResponse {
    private final /* synthetic */ int val$accessibleMode;
    private final /* synthetic */ boolean val$visible;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$21(BluetoothDSIListener bluetoothDSIListener, int n, boolean bl, int n2) {
        this.this$0 = bluetoothDSIListener;
        this.val$accessibleMode = n;
        this.val$visible = bl;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateAccessibleMode(this.val$accessibleMode, this.val$visible, this.val$validFlag);
    }
}

