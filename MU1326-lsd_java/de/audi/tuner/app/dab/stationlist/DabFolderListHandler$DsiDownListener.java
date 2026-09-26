/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler$1;

class DabFolderListHandler$DsiDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ DabFolderListHandler this$0;

    private DabFolderListHandler$DsiDownListener(DabFolderListHandler dabFolderListHandler) {
        this.this$0 = dabFolderListHandler;
    }

    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        this.this$0.highlightItem(dabStation, dabReceptionStatus);
    }

    /* synthetic */ DabFolderListHandler$DsiDownListener(DabFolderListHandler dabFolderListHandler, DabFolderListHandler$1 dabFolderListHandler$1) {
        this(dabFolderListHandler);
    }
}

