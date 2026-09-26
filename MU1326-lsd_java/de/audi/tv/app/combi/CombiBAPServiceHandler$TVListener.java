/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.tv.app.combi.CombiBAPServiceHandler;
import de.audi.tv.app.combi.CombiBAPServiceHandler$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

class CombiBAPServiceHandler$TVListener
extends DefaultTVListener {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    private CombiBAPServiceHandler$TVListener(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
    }

    @Override
    public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        boolean bl5 = bl4 = bl2 || bl;
        if (CombiBAPServiceHandler.access$1700(this.this$0) ^ bl4) {
            CombiBAPServiceHandler.access$1702(this.this$0, bl4);
            CombiBAPServiceHandler.access$1800(this.this$0, bl4);
        }
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        CombiBAPServiceHandler.access$1902(this.this$0, startUpConfig.avSrcAvail);
        CombiBAPServiceHandler.access$1400(this.this$0);
    }

    @Override
    public void updateMessageService(int n) {
        CombiBAPServiceHandler.access$2002(this.this$0, n == 1);
        if (CombiBAPServiceHandler.access$800(this.this$0)) {
            CombiBAPServiceHandler.access$1200(this.this$0, CombiBAPServiceHandler.access$700(this.this$0));
        }
    }

    /* synthetic */ CombiBAPServiceHandler$TVListener(CombiBAPServiceHandler combiBAPServiceHandler, CombiBAPServiceHandler$1 combiBAPServiceHandler$1) {
        this(combiBAPServiceHandler);
    }
}

