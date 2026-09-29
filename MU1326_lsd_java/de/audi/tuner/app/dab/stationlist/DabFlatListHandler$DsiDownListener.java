/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler$1;
import java.util.List;

class DabFlatListHandler$DsiDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ DabFlatListHandler this$0;

    private DabFlatListHandler$DsiDownListener(DabFlatListHandler dabFlatListHandler) {
        this.this$0 = dabFlatListHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        List list = DabFlatListHandler.access$500(this.this$0);
        synchronized (list) {
            this.this$0.highlightItem(dabStation, dabReceptionStatus);
        }
    }

    /* synthetic */ DabFlatListHandler$DsiDownListener(DabFlatListHandler dabFlatListHandler, DabFlatListHandler$1 dabFlatListHandler$1) {
        this(dabFlatListHandler);
    }
}

