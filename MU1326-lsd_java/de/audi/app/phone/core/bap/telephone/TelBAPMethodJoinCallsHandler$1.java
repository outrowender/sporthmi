/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodJoinCallsHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodJoinCallsHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodJoinCallsHandler this$0;

    TelBAPMethodJoinCallsHandler$1(TelBAPMethodJoinCallsHandler telBAPMethodJoinCallsHandler, int n) {
        this.this$0 = telBAPMethodJoinCallsHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodJoinCallsHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodJoinCallsHandler#sendResult] returning result %1 to combi.", (long)this.val$combiResult);
            combiBAPServicePhone.joinCallsResult(this.val$combiResult);
        } else {
            TelBAPMethodJoinCallsHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodJoinCallsHandler#sendResult] CombiService is null!");
        }
    }
}

