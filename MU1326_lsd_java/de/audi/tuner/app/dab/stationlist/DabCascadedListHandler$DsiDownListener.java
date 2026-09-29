/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler;
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler$1;

class DabCascadedListHandler$DsiDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ DabCascadedListHandler this$0;

    private DabCascadedListHandler$DsiDownListener(DabCascadedListHandler dabCascadedListHandler) {
        this.this$0 = dabCascadedListHandler;
    }

    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        this.this$0.highlightItem(dabStation, dabReceptionStatus);
    }

    /* synthetic */ DabCascadedListHandler$DsiDownListener(DabCascadedListHandler dabCascadedListHandler, DabCascadedListHandler$1 dabCascadedListHandler$1) {
        this(dabCascadedListHandler);
    }
}

