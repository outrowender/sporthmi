/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;

class CombiBAPServiceListenerImpl$10
extends AbstractDispatcherRunnable {
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$10(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string) {
        this.this$0 = combiBAPServiceListenerImpl;
        super(string);
    }

    @Override
    public void run() {
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.cancelSeek]", (Object)"CombiBAPServiceListenerImpl");
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.cancelSeek] No active combi content adapter.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).updateSeekState(false);
            return;
        }
        iCombiBAPContentAdapter.stopSeek();
    }
}

