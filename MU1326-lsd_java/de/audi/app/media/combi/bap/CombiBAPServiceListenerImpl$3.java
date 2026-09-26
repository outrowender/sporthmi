/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;

class CombiBAPServiceListenerImpl$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$skipCount;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$3(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$skipCount = n;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.skip] skipCount='%2'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$skipCount);
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.skip] No content adapter active. Ignore.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).skipResult(false);
            return;
        }
        CombiBAPServiceListenerImpl.access$100(this.this$0).skipResult(iCombiBAPContentAdapter.skip(this.val$skipCount > 0, Math.abs(this.val$skipCount)));
    }
}

