/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler;
import de.audi.mib.jdsi.IDSIClient;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

class TelAutomaticEmergencyCallHandler$2
implements IDSIClient {
    private final /* synthetic */ TelAutomaticEmergencyCallHandler this$0;

    TelAutomaticEmergencyCallHandler$2(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        this.this$0 = telAutomaticEmergencyCallHandler;
    }

    @Override
    public void setDSI(DSIBase dSIBase) {
        if (dSIBase instanceof DSIGeneralVehicleStates) {
            TelAutomaticEmergencyCallHandler.access$300(this.this$0).log(1078071040, "[TelAutomaticEmergencyCallHandler#TelAutomaticEmergencyCallHandler] dsi available.");
        } else {
            TelAutomaticEmergencyCallHandler.access$400(this.this$0).log(1078071040, "[TelAutomaticEmergencyCallHandler#TelAutomaticEmergencyCallHandler] dsi no longer available.");
        }
    }

    @Override
    public int[] getAutoNotifications() {
        return new int[]{2};
    }
}

