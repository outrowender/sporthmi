/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodSetWaitingCallonHoldHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodSetWaitingCallonHoldHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodSetWaitingCallonHoldHandler this$0;

    TelBAPMethodSetWaitingCallonHoldHandler$1(TelBAPMethodSetWaitingCallonHoldHandler telBAPMethodSetWaitingCallonHoldHandler, int n) {
        this.this$0 = telBAPMethodSetWaitingCallonHoldHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodSetWaitingCallonHoldHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodSetWaitingCallonHoldHandler#sendResult] returning result %1 to combi.", (long)this.val$combiResult);
            combiBAPServicePhone.setWaitingCallOnHoldResult(this.val$combiResult);
        } else {
            TelBAPMethodSetWaitingCallonHoldHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodSetWaitingCallonHoldHandler#sendResult] CombiService is null!");
        }
    }
}

