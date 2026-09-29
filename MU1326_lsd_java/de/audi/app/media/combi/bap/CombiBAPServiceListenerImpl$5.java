/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;

class CombiBAPServiceListenerImpl$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pCombiID;
    private final /* synthetic */ int val$pOffset;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$5(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n, int n2) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pCombiID = n;
        this.val$pOffset = n2;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.getNextListPos] combiID='%2',offset='%3'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiID, (long)this.val$pOffset);
        CombiBAPMediaEntry combiBAPMediaEntry = CombiBAPServiceListenerImpl.access$100(this.this$0).getIdMapper().getEntry(this.val$pCombiID);
        if (combiBAPMediaEntry == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.getNextListPos] No entryInfo found for combiID '%2'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiID);
            try {
                CombiBAPServiceListenerImpl.access$100(this.this$0).getCombiBAPService().getNextListPosResult(1, this.val$pCombiID, -1, -1);
            }
            catch (Exception exception) {
                CombiBAPServiceListenerImpl.access$000(this.this$0).log(10000, "[%1.getNextListPos] Combi failed: %2", (Object)"CombiBAPServiceListenerImpl", (Throwable)exception);
            }
            return;
        }
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.getNextListPos] No active combi content adapter.", (Object)"CombiBAPServiceListenerImpl");
            try {
                CombiBAPServiceListenerImpl.access$100(this.this$0).getCombiBAPService().getNextListPosResult(1, this.val$pCombiID, -1, -1);
            }
            catch (Exception exception) {
                CombiBAPServiceListenerImpl.access$000(this.this$0).log(10000, "[%1.getNextListPos] Combi failed: %2", (Object)"CombiBAPServiceListenerImpl", (Throwable)exception);
            }
            return;
        }
        iCombiBAPContentAdapter.getNextListPos(combiBAPMediaEntry, this.val$pOffset);
    }
}

