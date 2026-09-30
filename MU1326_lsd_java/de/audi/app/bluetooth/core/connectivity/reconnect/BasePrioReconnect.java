/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.reconnect;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.reconnect.CommandSetPriorizedDeviceReconnect;
import de.audi.app.bluetooth.core.connectivity.reconnect.IPrioReconnect;

public class BasePrioReconnect
extends AbstractBluetoothComponent
implements IPrioReconnect {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{17};
    private String address;

    public BasePrioReconnect(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void setPrioReconnect(String string) {
        boolean bl = string != null && !string.equals(this.address);
        this.log.log(1000000, "AbstractPrioReconnect#setPrioReconnect(): %2 %1", bl, (Object)string);
        CommandSetPriorizedDeviceReconnect.schedule(this.bluetoothApplication, this.dsiBluetooth, string, bl);
    }

    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        if (n != 1) {
            return;
        }
        this.log.log(1000000, "AbstractPrioReconnect#updatePriorizedDeviceReconnect(): '%2' %1", bl, (Object)string);
        this.address = bl ? string : null;
    }
}

