/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bluetooth;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bluetooth.TelBluetoothHandler;
import de.audi.app.phone.core.util.AbstractTelServiceTracker;
import org.dsi.ifc.bluetooth.DSIBluetooth;

class TelBluetoothHandler$DSIBluetoothTracker
extends AbstractTelServiceTracker {
    private final /* synthetic */ TelBluetoothHandler this$0;

    public TelBluetoothHandler$DSIBluetoothTracker(TelBluetoothHandler telBluetoothHandler, ITelApplication iTelApplication) {
        this.this$0 = telBluetoothHandler;
        super(iTelApplication, "App.Phone.Main", TelBluetoothHandler.class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (TelBluetoothHandler.class$org$dsi$ifc$bluetooth$DSIBluetooth = TelBluetoothHandler.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : TelBluetoothHandler.class$org$dsi$ifc$bluetooth$DSIBluetooth);
    }

    @Override
    protected void serviceAvailable(Object object) {
        TelBluetoothHandler.access$202(this.this$0, (DSIBluetooth)object);
        TelBluetoothHandler.access$200(this.this$0).setNotification(TelBluetoothHandler.access$300(this.this$0));
    }

    @Override
    protected void serviceRemoved(Object object) {
        TelBluetoothHandler.access$202(this.this$0, null);
    }
}

