/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodHoldActiveCallAcceptWaitingCallHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ TelBAPMethodHoldActiveCallAcceptWaitingCallHandler this$0;

    TelBAPMethodHoldActiveCallAcceptWaitingCallHandler$1(TelBAPMethodHoldActiveCallAcceptWaitingCallHandler telBAPMethodHoldActiveCallAcceptWaitingCallHandler, int n) {
        this.this$0 = telBAPMethodHoldActiveCallAcceptWaitingCallHandler;
        this.val$result = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodHoldActiveCallAcceptWaitingCallHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#sendResult] returning result %1 to combi.", (long)this.val$result);
            combiBAPServicePhone.callHoldAcceptWaitingCallResult(this.val$result);
        } else {
            TelBAPMethodHoldActiveCallAcceptWaitingCallHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodHoldActiveCallAcceptWaitingCallHandler#sendResult] CombiService is null!");
        }
    }
}

