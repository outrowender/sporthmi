/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.audi.app.wirelesscharging.core.ReminderPopupHandler$1;
import de.audi.app.wirelesscharging.core.WLCDefaultBluetoothListener;
import org.dsi.ifc.bluetooth.TrustedDevice;

class ReminderPopupHandler$ReminderBluetoothListener
extends WLCDefaultBluetoothListener {
    private final /* synthetic */ ReminderPopupHandler this$0;

    private ReminderPopupHandler$ReminderBluetoothListener(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n == 1) {
            ReminderPopupHandler.access$1202(this.this$0, trustedDeviceArray != null ? trustedDeviceArray : new TrustedDevice[]{});
            ReminderPopupHandler.access$1002(this.this$0, ReminderPopupHandler.access$1100(this.this$0));
            ReminderPopupHandler.access$500(this.this$0).log(1078071040, "[ReminderBluetoothListener#updateTrustedDevices] isDeviceConnectedViaUsbAndBT=%1", ReminderPopupHandler.access$1000(this.this$0));
            if (!ReminderPopupHandler.access$700(this.this$0)) {
                ReminderPopupHandler.access$800(this.this$0);
            }
        }
    }

    /* synthetic */ ReminderPopupHandler$ReminderBluetoothListener(ReminderPopupHandler reminderPopupHandler, ReminderPopupHandler$1 reminderPopupHandler$1) {
        this(reminderPopupHandler);
    }
}

