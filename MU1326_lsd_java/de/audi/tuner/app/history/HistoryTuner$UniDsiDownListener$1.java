/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$UniDsiDownListener;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$UniDsiDownListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ UnifiedStationExt val$station;
    private final /* synthetic */ HistoryTuner$UniDsiDownListener this$1;

    HistoryTuner$UniDsiDownListener$1(HistoryTuner$UniDsiDownListener historyTuner$UniDsiDownListener, String string, UnifiedStationExt unifiedStationExt) {
        this.this$1 = historyTuner$UniDsiDownListener;
        this.val$station = unifiedStationExt;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.preTuneCommand(this.val$station);
    }
}

