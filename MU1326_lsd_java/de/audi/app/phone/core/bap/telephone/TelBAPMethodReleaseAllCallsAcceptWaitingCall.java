/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.telephone.AbstractTel1BAPMethodHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TelBAPMethodReleaseAllCallsAcceptWaitingCall
extends AbstractTel1BAPMethodHandler {
    TelBAPMethodReleaseAllCallsAcceptWaitingCall(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    void releaseAllCallsAcceptWaitingCall() {
        this.enqueueResultNotification(new Runnable(){

            public void run() {
                CombiBAPServicePhone combiBAPServicePhone = TelBAPMethodReleaseAllCallsAcceptWaitingCall.this.getCombiBapServicePhone();
                if (combiBAPServicePhone != null) {
                    TelBAPMethodReleaseAllCallsAcceptWaitingCall.this.log.log(1000000, "[TelBAPMethodReleaseAllCallsAcceptWaitingCall.releaseAllCallsAcceptWaitingCall(...).new Runnable() {...}#run] returning CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL");
                    combiBAPServicePhone.releaseAllCallsAcceptWaitingCallResult(1);
                } else {
                    TelBAPMethodReleaseAllCallsAcceptWaitingCall.this.log.log(10000, "TelBAPMethodReleaseAllCallsAcceptWaitingCall.releaseAllCallsAcceptWaitingCall service is null");
                }
            }
        });
    }
}

