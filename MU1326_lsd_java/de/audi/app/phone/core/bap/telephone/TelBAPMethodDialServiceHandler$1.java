/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialServiceHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodDialServiceHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodDialServiceHandler this$0;

    TelBAPMethodDialServiceHandler$1(TelBAPMethodDialServiceHandler telBAPMethodDialServiceHandler, int n) {
        this.this$0 = telBAPMethodDialServiceHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodDialServiceHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodDialServiceHandler#sendResult] sending result %1 to combi", (long)this.val$combiResult);
            combiBAPServicePhone.dialServiceResult(this.val$combiResult);
        } else {
            TelBAPMethodDialServiceHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodDialServiceHandler#sendResult] combi service is null !");
        }
    }
}

