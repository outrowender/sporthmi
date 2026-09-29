/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.combi;

import de.audi.tv.app.combi.CombiBAPServiceHandler;
import de.audi.tv.app.combi.CombiBAPServiceHandler$1;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultTVListsListener;

class CombiBAPServiceHandler$ListsListener
extends DefaultTVListsListener {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    private CombiBAPServiceHandler$ListsListener(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
    }

    @Override
    public void updateFavoritesList() {
        CombiBAPServiceHandler.access$400(this.this$0);
    }

    @Override
    public void updateStationList() {
        CombiBAPServiceHandler.access$500(this.this$0);
        if (CombiBAPServiceHandler.access$600(this.this$0) == 0) {
            CombiBAPServiceHandler.access$602(this.this$0, 3);
            if (!CombiBAPServiceHandler.access$700(this.this$0) && CombiBAPServiceHandler.access$800(this.this$0)) {
                try {
                    CombiBAPServiceHandler.access$900(this.this$0).updateActiveSource(9, 0, 0, true, true, CombiBAPServiceHandler.access$600(this.this$0));
                }
                catch (Exception exception) {
                    CombiBAPServiceHandler.access$1000((CombiBAPServiceHandler)this.this$0).lcCombi.log(10000, "%1", (Throwable)exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedStation(AbstractTVStationRow abstractTVStationRow) {
        CombiBAPServiceHandler.access$1100(this.this$0, abstractTVStationRow);
    }

    /* synthetic */ CombiBAPServiceHandler$ListsListener(CombiBAPServiceHandler combiBAPServiceHandler, CombiBAPServiceHandler$1 combiBAPServiceHandler$1) {
        this(combiBAPServiceHandler);
    }
}

