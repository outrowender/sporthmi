/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodCallResumeHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodCallResumeHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodCallResumeHandler this$0;

    TelBAPMethodCallResumeHandler$1(TelBAPMethodCallResumeHandler telBAPMethodCallResumeHandler, int n) {
        this.this$0 = telBAPMethodCallResumeHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodCallResumeHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodCallResumeHandler#sendResult] returning result %1 to combi.", (long)this.val$combiResult);
            combiBAPServicePhone.resumeCallResult(this.val$combiResult);
        } else {
            TelBAPMethodCallResumeHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodCallResumeHandler#sendResult] CombiService is null!");
        }
    }
}

