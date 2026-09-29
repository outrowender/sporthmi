/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;

class CombiBAPServiceListenerImpl$8
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pTransactionID;
    private final /* synthetic */ int val$pStartIndex;
    private final /* synthetic */ int val$pNumberOfEntries;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$8(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n, int n2, int n3) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pTransactionID = n;
        this.val$pStartIndex = n2;
        this.val$pNumberOfEntries = n3;
        super(string);
    }

    @Override
    public void run() {
        ICombiBAPContentAdapter iCombiBAPContentAdapter;
        if (CombiBAPServiceListenerImpl.access$000(this.this$0).isInfo()) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.requestMediaBrowserListByIndex] transactionID='%2',startIndex='%3',numberOfEntries='%4'.", (Object)"CombiBAPServiceListenerImpl", (Object)new Integer(this.val$pTransactionID), (Object)new Integer(this.val$pStartIndex), (Object)new Integer(this.val$pNumberOfEntries));
        }
        if ((iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter()) == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.requestMediaBrowserListByIndex] No active combi content adapter.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).responseList(this.val$pTransactionID, 0, 0, new MediaListEntry[0]);
            return;
        }
        iCombiBAPContentAdapter.requestListByIndex(this.val$pTransactionID, this.val$pStartIndex, this.val$pNumberOfEntries);
    }
}

