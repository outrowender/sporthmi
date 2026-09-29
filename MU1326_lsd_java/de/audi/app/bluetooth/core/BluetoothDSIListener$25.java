/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core;

import de.audi.app.bluetooth.core.BluetoothDSIListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.RequestIncomingService;

class BluetoothDSIListener$25
extends CommandResponse {
    private final /* synthetic */ RequestIncomingService val$incomingServiceRequest;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ BluetoothDSIListener this$0;

    BluetoothDSIListener$25(BluetoothDSIListener bluetoothDSIListener, RequestIncomingService requestIncomingService, int n) {
        this.this$0 = bluetoothDSIListener;
        this.val$incomingServiceRequest = requestIncomingService;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIBluetoothListener)dSIListener).updateIncomingServiceRequest(this.val$incomingServiceRequest, this.val$validFlag);
    }
}

