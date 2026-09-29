/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.bluetooth.TelBluetoothHandler;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class TelBluetoothHandler$TelBluetoothDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelBluetoothHandler this$0;

    private TelBluetoothHandler$TelBluetoothDiag(TelBluetoothHandler telBluetoothHandler) {
        this.this$0 = telBluetoothHandler;
    }

    public String getBTTrustedDevices() {
        return TelBluetoothHandler.access$600(TelBluetoothHandler.access$500(this.this$0)).toString();
    }

    /* synthetic */ TelBluetoothHandler$TelBluetoothDiag(TelBluetoothHandler telBluetoothHandler, TelBluetoothHandler$1 telBluetoothHandler$1) {
        this(telBluetoothHandler);
    }
}

