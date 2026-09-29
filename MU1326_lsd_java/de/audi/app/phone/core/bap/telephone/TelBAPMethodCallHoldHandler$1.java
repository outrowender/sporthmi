/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodCallHoldHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodCallHoldHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodCallHoldHandler this$0;

    TelBAPMethodCallHoldHandler$1(TelBAPMethodCallHoldHandler telBAPMethodCallHoldHandler, int n) {
        this.this$0 = telBAPMethodCallHoldHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodCallHoldHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodCallHoldHandler#sendResult] returning result %1 to combi.", (long)this.val$combiResult);
            combiBAPServicePhone.callHoldResult(this.val$combiResult);
        } else {
            TelBAPMethodCallHoldHandler.access$100(this.this$0).log(-2137614336, "[TelBAPMethodCallHoldHandler#sendResult] CombiService is null!");
        }
    }
}

