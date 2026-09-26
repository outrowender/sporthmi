/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler this$0;

    TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler$1(TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler telBAPMethodReleaseActiveCallAcceptWaitingCallHandler, int n) {
        this.this$0 = telBAPMethodReleaseActiveCallAcceptWaitingCallHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#AcceptCallsResponse] returning result %1 to combi.", (long)this.val$combiResult);
            combiBAPServicePhone.releaseActiveCallAcceptWaitingCallResult(this.val$combiResult);
        } else {
            TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler.access$100(this.this$0).log(-2137614336, "[TelBAPMethodReleaseActiveCallAcceptWaitingCallHandler#AcceptCallsResponse] CombiService is null!");
        }
    }
}

