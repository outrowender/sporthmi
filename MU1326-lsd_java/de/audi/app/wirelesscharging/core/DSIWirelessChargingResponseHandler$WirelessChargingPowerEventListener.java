/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.DSIWirelessChargingResponseHandler;
import de.audi.app.wirelesscharging.core.DSIWirelessChargingResponseHandler$1;
import de.audi.atip.power.DefaultPowerEventListener;

class DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener
extends DefaultPowerEventListener {
    private int lastPwrState = -1;
    private final /* synthetic */ DSIWirelessChargingResponseHandler this$0;

    private DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener(DSIWirelessChargingResponseHandler dSIWirelessChargingResponseHandler) {
        this.this$0 = dSIWirelessChargingResponseHandler;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 2) {
            DSIWirelessChargingResponseHandler.access$100(this.this$0).log(1078071040, "[WirelessChargingPowerEventListener#notifyPowerListenerOnEnterState] going standby.");
            DSIWirelessChargingResponseHandler.access$200(this.this$0).updateStatusBar(1);
        } else if (!(this.lastPwrState != 2 && this.lastPwrState != 3 || n != 0 && n != 4)) {
            DSIWirelessChargingResponseHandler.access$100(this.this$0).log(1078071040, "[WirelessChargingPowerEventListener#notifyPowerListenerOnEnterState] starting from standby. Update the wireless information with the latest recieved value.");
            DSIWirelessChargingResponseHandler.access$200(this.this$0).updateStatusBar(DSIWirelessChargingResponseHandler.access$300(this.this$0));
        }
        this.lastPwrState = n;
    }

    /* synthetic */ DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener(DSIWirelessChargingResponseHandler dSIWirelessChargingResponseHandler, DSIWirelessChargingResponseHandler$1 dSIWirelessChargingResponseHandler$1) {
        this(dSIWirelessChargingResponseHandler);
    }
}

