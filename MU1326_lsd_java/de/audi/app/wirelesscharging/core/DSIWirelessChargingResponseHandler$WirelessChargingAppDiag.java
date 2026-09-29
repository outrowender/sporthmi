/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.DSIWirelessChargingResponseHandler;
import de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent;

public class DSIWirelessChargingResponseHandler$WirelessChargingAppDiag
implements IWirelessChargingDiagComponent {
    private final /* synthetic */ DSIWirelessChargingResponseHandler this$0;

    public DSIWirelessChargingResponseHandler$WirelessChargingAppDiag(DSIWirelessChargingResponseHandler dSIWirelessChargingResponseHandler) {
        this.this$0 = dSIWirelessChargingResponseHandler;
    }

    public int cmdGetChargingInfo() {
        return DSIWirelessChargingResponseHandler.access$300(this.this$0);
    }

    public void cmdUpdateChargeInfo(int n) {
        this.this$0.updateChargingInfo(n, 1);
    }
}

