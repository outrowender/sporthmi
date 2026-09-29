/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodConfirmEmergencyCallHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodConfirmEmergencyCallHandler$1
implements Runnable {
    private final /* synthetic */ TelBAPMethodConfirmEmergencyCallHandler this$0;

    TelBAPMethodConfirmEmergencyCallHandler$1(TelBAPMethodConfirmEmergencyCallHandler telBAPMethodConfirmEmergencyCallHandler) {
        this.this$0 = telBAPMethodConfirmEmergencyCallHandler;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodConfirmEmergencyCallHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodConfirmEmergencyCallHandler.confirmEmergencyCall(...).new Runnable() {...}#run] returning CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL");
            combiBAPServicePhone.confirmEmergencyCallResult(1);
        } else {
            TelBAPMethodConfirmEmergencyCallHandler.access$100(this.this$0).log(10000, "TelBAPMethodConfirmEmergencyCallHandler.confirmEmergencyCall service is null");
        }
    }
}

