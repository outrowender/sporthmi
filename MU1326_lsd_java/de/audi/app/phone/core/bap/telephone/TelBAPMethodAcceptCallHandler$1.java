/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodAcceptCallHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodAcceptCallHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodAcceptCallHandler this$0;

    TelBAPMethodAcceptCallHandler$1(TelBAPMethodAcceptCallHandler telBAPMethodAcceptCallHandler, int n) {
        this.this$0 = telBAPMethodAcceptCallHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodAcceptCallHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodAcceptCallHandler#sendResult] sending result %1 to combi", (long)this.val$combiResult);
            combiBAPServicePhone.acceptCallResult(this.val$combiResult);
        } else {
            TelBAPMethodAcceptCallHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodAcceptCallHandler#sendResult] CombiService is null!");
        }
    }
}

