/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.emergency;

import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler;
import de.audi.app.phone.core.emergency.TelAutomaticEmergencyCallHandler$1;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.generalvehiclestates.AirbagData;

class TelAutomaticEmergencyCallHandler$TelAutomaticEmergencyCallDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelAutomaticEmergencyCallHandler this$0;

    private TelAutomaticEmergencyCallHandler$TelAutomaticEmergencyCallDiag(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler) {
        this.this$0 = telAutomaticEmergencyCallHandler;
    }

    public void cmdTriggerCrash() {
        AirbagData airbagData = new AirbagData(3, false, false);
        this.this$0.airbagDataUpdate(airbagData, 1);
    }

    /* synthetic */ TelAutomaticEmergencyCallHandler$TelAutomaticEmergencyCallDiag(TelAutomaticEmergencyCallHandler telAutomaticEmergencyCallHandler, TelAutomaticEmergencyCallHandler$1 telAutomaticEmergencyCallHandler$1) {
        this(telAutomaticEmergencyCallHandler);
    }
}

