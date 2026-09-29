/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$UniDsiUpListener;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$UniDsiUpListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ UnifiedStationExt val$uniSt;
    private final /* synthetic */ HistoryTuner$UniDsiUpListener this$1;

    HistoryTuner$UniDsiUpListener$1(HistoryTuner$UniDsiUpListener historyTuner$UniDsiUpListener, String string, UnifiedStationExt unifiedStationExt) {
        this.this$1 = historyTuner$UniDsiUpListener;
        this.val$uniSt = unifiedStationExt;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateSelectedStation(this.val$uniSt);
    }
}

