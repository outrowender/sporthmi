/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialNumberHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodDialNumberHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodDialNumberHandler this$0;

    TelBAPMethodDialNumberHandler$1(TelBAPMethodDialNumberHandler telBAPMethodDialNumberHandler, int n) {
        this.this$0 = telBAPMethodDialNumberHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodDialNumberHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodDialNumberHandler#sendResult] sending result %1 to combi", (long)this.val$combiResult);
            combiBAPServicePhone.dialNumberResult(this.val$combiResult);
        } else {
            TelBAPMethodDialNumberHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodDialNumberHandler#sendResult] combi service is null !");
        }
    }
}

