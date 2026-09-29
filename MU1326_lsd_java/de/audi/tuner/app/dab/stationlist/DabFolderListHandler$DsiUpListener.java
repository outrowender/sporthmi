/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler$1;

class DabFolderListHandler$DsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ DabFolderListHandler this$0;

    private DabFolderListHandler$DsiUpListener(DabFolderListHandler dabFolderListHandler) {
        this.this$0 = dabFolderListHandler;
    }

    @Override
    public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        this.this$0.listUpdate(dabStationArray, dabStationArray2, dabStationArray3);
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.this$0.highlightItem(dabStation, dabReceptionStatus);
    }

    /* synthetic */ DabFolderListHandler$DsiUpListener(DabFolderListHandler dabFolderListHandler, DabFolderListHandler$1 dabFolderListHandler$1) {
        this(dabFolderListHandler);
    }
}

