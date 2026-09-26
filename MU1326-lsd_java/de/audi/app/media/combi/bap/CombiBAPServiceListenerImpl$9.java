/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;

class CombiBAPServiceListenerImpl$9
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$direction;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$9(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$direction = n;
        super(string);
    }

    @Override
    public void run() {
        ICombiBAPContentAdapter iCombiBAPContentAdapter;
        if (CombiBAPServiceListenerImpl.access$000(this.this$0).isInfo()) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.startSeek] '%2'.", (Object)"CombiBAPServiceListenerImpl", (Object)(this.val$direction == 0 ? "FORWARD" : "BACKWARD"));
        }
        if ((iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter()) == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.startSeek] No active combi content adapter.", (Object)"CombiBAPServiceListenerImpl");
            CombiBAPServiceListenerImpl.access$100(this.this$0).updateSeekState(false);
            return;
        }
        iCombiBAPContentAdapter.startSeek(this.val$direction == 0);
    }
}

