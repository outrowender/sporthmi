/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler;
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler$1;

class DabCascadedListHandler$DsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ DabCascadedListHandler this$0;

    private DabCascadedListHandler$DsiUpListener(DabCascadedListHandler dabCascadedListHandler) {
        this.this$0 = dabCascadedListHandler;
    }

    @Override
    public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        this.this$0.listUpdate(dabStationArray, dabStationArray2, dabStationArray3);
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.this$0.highlightItem(dabStation, dabReceptionStatus);
    }

    /* synthetic */ DabCascadedListHandler$DsiUpListener(DabCascadedListHandler dabCascadedListHandler, DabCascadedListHandler$1 dabCascadedListHandler$1) {
        this(dabCascadedListHandler);
    }
}

