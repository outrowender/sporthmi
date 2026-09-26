/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodSplitCallHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodSplitCallHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodSplitCallHandler this$0;

    TelBAPMethodSplitCallHandler$1(TelBAPMethodSplitCallHandler telBAPMethodSplitCallHandler, int n) {
        this.this$0 = telBAPMethodSplitCallHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodSplitCallHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodSplitCallHandler#sendResult] returning result %1 to combi.", (long)this.val$combiResult);
            combiBAPServicePhone.splitCallResult(this.val$combiResult);
        } else {
            TelBAPMethodSplitCallHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodSplitCallHandler#sendResult] CombiService is null!");
        }
    }
}

