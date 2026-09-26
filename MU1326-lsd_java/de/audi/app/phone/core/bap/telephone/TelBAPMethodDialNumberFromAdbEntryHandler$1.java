/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.TelBAPMethodDialNumberFromAdbEntryHandler;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;

class TelBAPMethodDialNumberFromAdbEntryHandler$1
implements Runnable {
    private final /* synthetic */ int val$combiResult;
    private final /* synthetic */ TelBAPMethodDialNumberFromAdbEntryHandler this$0;

    TelBAPMethodDialNumberFromAdbEntryHandler$1(TelBAPMethodDialNumberFromAdbEntryHandler telBAPMethodDialNumberFromAdbEntryHandler, int n) {
        this.this$0 = telBAPMethodDialNumberFromAdbEntryHandler;
        this.val$combiResult = n;
    }

    @Override
    public void run() {
        CombiBAPServicePhone combiBAPServicePhone = this.this$0.getCombiBapServicePhone();
        if (combiBAPServicePhone != null) {
            TelBAPMethodDialNumberFromAdbEntryHandler.access$000(this.this$0).log(1078071040, "[TelBAPMethodDialNumberFromAdbEntryHandler#sendResult] sending result %1 to combi", (long)this.val$combiResult);
            combiBAPServicePhone.dialNumberFromAdbEntryResult(this.val$combiResult);
        } else {
            TelBAPMethodDialNumberFromAdbEntryHandler.access$100(this.this$0).log(-1601830656, "[TelBAPMethodDialNumberFromAdbEntryHandler#sendResult] combi service is null !");
        }
    }
}

