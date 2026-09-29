/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.ReconnectInfo;

class BluetoothDSIListener$29
extends CommandResponse {
    private final /* synthetic */ ReconnectInfo val$reconnectInfo;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$29(BluetoothDSIListener bluetoothDSIListener, ReconnectInfo reconnectInfo, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$reconnectInfo = reconnectInfo;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateReconnectIndicator(this.val$reconnectInfo, this.val$validFlag);
    }
}

