/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler$TelDSIBluetoothListener;
import de.audi.app.phone.core.event.AbstractTelDSIUpdateEvent;
import java.util.Iterator;
import java.util.LinkedList;
import org.dsi.ifc.bluetooth.TrustedDevice;

class TelBluetoothHandler$TelDSIBluetoothListener$1
extends AbstractTelDSIUpdateEvent {
    private final /* synthetic */ TrustedDevice[] val$trustedDevices;
    private final /* synthetic */ TelBluetoothHandler$TelDSIBluetoothListener this$1;

    TelBluetoothHandler$TelDSIBluetoothListener$1(TelBluetoothHandler$TelDSIBluetoothListener telBluetoothHandler$TelDSIBluetoothListener, String string, TrustedDevice[] trustedDeviceArray) {
        this.this$1 = telBluetoothHandler$TelDSIBluetoothListener;
        this.val$trustedDevices = trustedDeviceArray;
        super(string);
    }

    @Override
    public void run() {
        TelBluetoothHandler.access$502(TelBluetoothHandler$TelDSIBluetoothListener.access$400(this.this$1), this.val$trustedDevices);
        TelBluetoothHandler.access$700(TelBluetoothHandler$TelDSIBluetoothListener.access$400(this.this$1)).log(1078071040, "[TelBluetoothHandler.TelDSIBluetoothListener#updateTrustedDevices] trustedDevices=%1", (Object)TelBluetoothHandler.access$600(this.val$trustedDevices));
        LinkedList linkedList = (LinkedList)TelBluetoothHandler.access$800(TelBluetoothHandler$TelDSIBluetoothListener.access$400(this.this$1)).clone();
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            ((ITelBluetoothListener)iterator.next()).updateTrustedDevices(this.val$trustedDevices);
        }
    }
}

