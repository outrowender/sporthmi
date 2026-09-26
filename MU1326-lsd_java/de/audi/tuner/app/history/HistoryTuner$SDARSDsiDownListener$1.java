/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$SDARSDsiDownListener;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$SDARSDsiDownListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ StationInfoExt val$station;
    private final /* synthetic */ HistoryTuner$SDARSDsiDownListener this$1;

    HistoryTuner$SDARSDsiDownListener$1(HistoryTuner$SDARSDsiDownListener historyTuner$SDARSDsiDownListener, String string, StationInfoExt stationInfoExt) {
        this.this$1 = historyTuner$SDARSDsiDownListener;
        this.val$station = stationInfoExt;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.preTuneAction(this.val$station);
    }
}

