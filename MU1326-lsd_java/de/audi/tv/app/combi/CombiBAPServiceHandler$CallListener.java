/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.tv.app.combi.CombiBAPServiceHandler;
import de.audi.tv.app.combi.CombiBAPServiceHandler$1;
import de.audi.tv.app.dsi.DSICallListener;

class CombiBAPServiceHandler$CallListener
extends DSICallListener {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    private CombiBAPServiceHandler$CallListener(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
    }

    @Override
    public void switchSource(int n, boolean bl) {
        boolean bl2;
        CombiBAPServiceHandler.access$1000((CombiBAPServiceHandler)this.this$0).lcCombi.log(1078071040, "[CombiBAPServiceHandler.CallListener.switchSource] sourceType=%1, isUserCall=%2", (Object)new Integer(n), (Object)(bl ? "true" : "false"));
        boolean bl3 = bl2 = n == 1;
        if (CombiBAPServiceHandler.access$700(this.this$0) != bl2) {
            CombiBAPServiceHandler.access$702(this.this$0, bl2);
            if (CombiBAPServiceHandler.access$800(this.this$0)) {
                CombiBAPServiceHandler.access$1200(this.this$0, CombiBAPServiceHandler.access$700(this.this$0));
            }
        }
    }

    /* synthetic */ CombiBAPServiceHandler$CallListener(CombiBAPServiceHandler combiBAPServiceHandler, CombiBAPServiceHandler$1 combiBAPServiceHandler$1) {
        this(combiBAPServiceHandler);
    }
}

