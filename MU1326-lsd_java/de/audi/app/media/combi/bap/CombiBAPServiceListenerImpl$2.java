/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.combi.bap.CombiBAPServiceListenerImpl;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;

class CombiBAPServiceListenerImpl$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pPlayMode;
    private final /* synthetic */ int val$pPlayScope;
    private final /* synthetic */ CombiBAPServiceListenerImpl this$0;

    CombiBAPServiceListenerImpl$2(CombiBAPServiceListenerImpl combiBAPServiceListenerImpl, String string, int n, int n2) {
        this.this$0 = combiBAPServiceListenerImpl;
        this.val$pPlayMode = n;
        this.val$pPlayScope = n2;
        super(string);
    }

    @Override
    public void run() {
        int n;
        boolean bl;
        CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.setActiveSourceState] PlayMode='%2',playScope='%3'.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pPlayMode, (long)this.val$pPlayScope);
        ICombiBAPContentAdapter iCombiBAPContentAdapter = CombiBAPServiceListenerImpl.access$100(this.this$0).getActiveCombiContentAdapter();
        if (iCombiBAPContentAdapter == null) {
            CombiBAPServiceListenerImpl.access$000(this.this$0).log(1078071040, "[%1.setActiveSourceState] No content adapter active. Ignore.", (Object)"CombiBAPServiceListenerImpl");
            return;
        }
        switch (this.val$pPlayMode) {
            case 2: 
            case 4: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        switch (this.val$pPlayScope) {
            case 2: {
                n = 0;
                break;
            }
            case 3: {
                n = 1;
                break;
            }
            case 5: {
                n = 2;
                break;
            }
            case 1: {
                n = 3;
                break;
            }
            case 4: {
                n = 4;
                break;
            }
            default: {
                CombiBAPServiceListenerImpl.access$000(this.this$0).log(-1601830656, "[%1.setActiveSourceState] Scope '%2' not supported. Ignored.", (Object)"CombiBAPServiceListenerImpl", (long)this.val$pPlayScope);
                CombiBAPServiceListenerImpl.access$100(this.this$0).updateActiveRepeatScope(iCombiBAPContentAdapter.getCurrentRepeatScope(), iCombiBAPContentAdapter.isMixActive());
                return;
            }
        }
        if (!iCombiBAPContentAdapter.setRepeatScope(n, bl)) {
            CombiBAPServiceListenerImpl.access$100(this.this$0).updateActiveRepeatScope(iCombiBAPContentAdapter.getCurrentRepeatScope(), iCombiBAPContentAdapter.isMixActive());
        }
    }
}

