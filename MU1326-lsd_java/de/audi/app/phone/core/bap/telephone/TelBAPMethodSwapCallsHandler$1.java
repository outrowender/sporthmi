/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodSwapCallsHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodSwapCallsHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodSwapCallsHandler this$0;

    TelBAPMethodSwapCallsHandler$1(TelBAPMethodSwapCallsHandler telBAPMethodSwapCallsHandler, int n) {
        this.this$0 = telBAPMethodSwapCallsHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodSwapCallsHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodSwapCallsHandler#responseSwapCalls]Sending value %1 Combi.", (long)this.val$combiResult);
            combiBAPServicePhone.swapCallsResult(this.val$combiResult);
        } else {
            TelBAPMethodSwapCallsHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodSwapCallsHandler#responseSwapCalls] CombiService is null!");
        }
    }
}

