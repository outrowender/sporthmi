/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.interapp.tv.TVStation;
import de.audi.tuner.app.history.HistoryTuner$HistoryListService;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$HistoryListService$1
extends AbstractNamedRunnable {
    private final /* synthetic */ TVStation val$tvStation;
    private final /* synthetic */ HistoryTuner$HistoryListService this$1;

    HistoryTuner$HistoryListService$1(HistoryTuner$HistoryListService historyTuner$HistoryListService, String string, TVStation tVStation) {
        this.this$1 = historyTuner$HistoryListService;
        this.val$tvStation = tVStation;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateAudibleTVStation(this.val$tvStation);
    }
}

