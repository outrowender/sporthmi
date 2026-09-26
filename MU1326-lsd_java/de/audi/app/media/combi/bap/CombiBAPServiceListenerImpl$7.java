/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;

class CombiBAPServiceListenerImpl$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pTransactionID;
    private final /* synthetic */ int val$pCombiID;
    private final /* synthetic */ int val$pNumberOfEntries;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$7(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n, int n2, int n3) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pTransactionID = n;
        this.val$pCombiID = n2;
        this.val$pNumberOfEntries = n3;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPMediaEntry combiBAPMediaEntry;
        if (CombiBAPServiceListenerImpl.access$000(this.this$0).isInfo()) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.requestMediaBrowserListByID] transactionID='%2',combiID='%3',numberOfEntries='%4'.", (Object)"CombiBAPServiceListenerImpl", (Object)new Integer(this.val$pTransactionID), (Object)new Integer(this.val$pCombiID), (Object)new Integer(this.val$pNumberOfEntries));
        }
        if ((combiBAPMediaEntry = CombiBAPServiceListenerImpl.access$100(this.this$0).getIdMapper().getEntry(this.val$pCombiID)) == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.requestMediaBrowserListByID] No entryInfo found for combiID '%2'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pCombiID);
            CombiBAPServiceListenerImpl.access$100(this.this$0).responseList(this.val$pTransactionID, 0, 0, new MediaListEntry[0]);
            return;
        }
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.requestMediaBrowserListByID] No active combi content adapter.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).responseList(this.val$pTransactionID, 0, 0, new MediaListEntry[0]);
            return;
        }
        iCombiBAPContentAdapter.requestListByEntryID(this.val$pTransactionID, combiBAPMediaEntry, this.val$pNumberOfEntries);
    }
}

