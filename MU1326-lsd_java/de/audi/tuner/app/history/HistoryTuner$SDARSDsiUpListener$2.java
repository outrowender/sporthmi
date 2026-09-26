/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$SDARSDsiUpListener;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$SDARSDsiUpListener$2
extends AbstractNamedRunnable {
    private final /* synthetic */ StationInfoExt[] val$stationList;
    private final /* synthetic */ HistoryTuner$SDARSDsiUpListener this$1;

    HistoryTuner$SDARSDsiUpListener$2(HistoryTuner$SDARSDsiUpListener historyTuner$SDARSDsiUpListener, String string, StationInfoExt[] stationInfoExtArray) {
        this.this$1 = historyTuner$SDARSDsiUpListener;
        this.val$stationList = stationInfoExtArray;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateStationList(this.val$stationList);
    }
}

