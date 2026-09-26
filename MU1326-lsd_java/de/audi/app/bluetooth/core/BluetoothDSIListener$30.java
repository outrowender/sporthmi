/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;

class BluetoothDSIListener$30
extends CommandResponse {
    private final /* synthetic */ ServiceRequestStateStruct val$serviceRequestState;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$30(BluetoothDSIListener bluetoothDSIListener, ServiceRequestStateStruct serviceRequestStateStruct, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$serviceRequestState = serviceRequestStateStruct;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateServiceRequestState(this.val$serviceRequestState, this.val$validFlag);
    }
}

