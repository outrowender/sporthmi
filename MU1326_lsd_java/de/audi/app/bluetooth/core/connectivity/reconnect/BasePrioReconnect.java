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

    @Override
    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void setPrioReconnect(String string) {
        boolean bl = string != null && !string.equals(this.address);
        this.log.log(1078071040, "AbstractPrioReconnect#setPrioReconnect(): %2 %1", bl, (Object)string);
        CommandSetPriorizedDeviceReconnect.schedule(this.bluetoothApplication, this.dsiBluetooth, string, bl);
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
        if (n != 1) {
            return;
        }
        this.log.log(1078071040, "AbstractPrioReconnect#updatePriorizedDeviceReconnect(): '%2' %1", bl, (Object)string);
        this.address = bl ? string : null;
    }
}

