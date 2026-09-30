/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodConfirmEmergencyCallHandler
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodConfirmEmergencyCallHandler(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void confirmEmergencyCall(boolean bl) {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodConfirmEmergencyCallHandler.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodConfirmEmergencyCallHandler.this.log.log(1000000, "[TelBAPMethodConfirmEmergencyCallHandler.confirmEmergencyCall(...).new Runnable() {...}#run] returning CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL");
                    combiBAPServicePhone.confirmEmergencyCallResult(1);
                } else {
                    TelBAPMethodConfirmEmergencyCallHandler.this.log.log(10000, "TelBAPMethodConfirmEmergencyCallHandler.confirmEmergencyCall service is null");
                }
            }
        });
    }
}

