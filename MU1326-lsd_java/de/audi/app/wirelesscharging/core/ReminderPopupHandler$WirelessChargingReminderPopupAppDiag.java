/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.ReminderPopupHandler;
import de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent;

public class ReminderPopupHandler$WirelessChargingReminderPopupAppDiag
implements IWirelessChargingDiagComponent {
    private final /* synthetic */ ReminderPopupHandler this$0;

    public ReminderPopupHandler$WirelessChargingReminderPopupAppDiag(ReminderPopupHandler reminderPopupHandler) {
        this.this$0 = reminderPopupHandler;
    }

    public void cmdUpdateChargeInfoReminderPopup(int n) {
        this.this$0.updateChargingInfo(n, 1);
    }
}

