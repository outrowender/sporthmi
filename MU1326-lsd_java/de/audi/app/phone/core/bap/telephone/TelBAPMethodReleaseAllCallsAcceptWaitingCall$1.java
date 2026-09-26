/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodReleaseAllCallsAcceptWaitingCall;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodReleaseAllCallsAcceptWaitingCall$1
implements Runnable {
    private final /* synthetic */ TelBAPMethodReleaseAllCallsAcceptWaitingCall this$0;

    TelBAPMethodReleaseAllCallsAcceptWaitingCall$1(TelBAPMethodReleaseAllCallsAcceptWaitingCall telBAPMethodReleaseAllCallsAcceptWaitingCall) {
        this.this$0 = telBAPMethodReleaseAllCallsAcceptWaitingCall;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodReleaseAllCallsAcceptWaitingCall.access$000(this.this$0).log(1078071040, "[TelBAPMethodReleaseAllCallsAcceptWaitingCall.releaseAllCallsAcceptWaitingCall(...).new Runnable() {...}#run] returning CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL");
            combiBAPServicePhone.releaseAllCallsAcceptWaitingCallResult(1);
        } else {
            TelBAPMethodReleaseAllCallsAcceptWaitingCall.access$100(this.this$0).log(10000, "TelBAPMethodReleaseAllCallsAcceptWaitingCall.releaseAllCallsAcceptWaitingCall service is null");
        }
    }
}

