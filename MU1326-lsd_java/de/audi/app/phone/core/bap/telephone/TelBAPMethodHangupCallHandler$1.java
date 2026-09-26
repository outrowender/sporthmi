/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodHangupCallHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodHangupCallHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodHangupCallHandler this$0;

    TelBAPMethodHangupCallHandler$1(TelBAPMethodHangupCallHandler telBAPMethodHangupCallHandler, int n) {
        this.this$0 = telBAPMethodHangupCallHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodHangupCallHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodHangupCallHandler#sendResult] sending result %1 to combi", (long)this.val$combiResult);
            combiBAPServicePhone.hangupCallResult(this.val$combiResult);
        } else {
            TelBAPMethodHangupCallHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodHangupCallHandler#sendResult] CombiService is null!");
        }
    }
}

