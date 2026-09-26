/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.emergency.DSIGeneralVehicleStatesListenerBase;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$1;
import org.dsi.ifc.generalvehiclestates.AirbagData;

class TelAutomaticEmergencyCallHandler$TelDSIGeneralVehicleStatesListener
extends DSIGeneralVehicleStatesListenerBase {
    private final /* synthetic */ TelAutomaticEmergencyCallHandler this$0;

    private TelAutomaticEmergencyCallHandler$TelDSIGeneralVehicleStatesListener(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        this.this$0 = telAutomaticEmergencyCallHandler;
    }

    @Override
    public void updateAirbagData(AirbagData airbagData, int n) {
        this.this$0.airbagDataUpdate(airbagData, n);
    }

    /* synthetic */ TelAutomaticEmergencyCallHandler$TelDSIGeneralVehicleStatesListener(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler, TelAutomaticEmergencyCallHandler$1 telAutomaticEmergencyCallHandler$1) {
        this(telAutomaticEmergencyCallHandler);
    }
}

