/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.history.HistoryTuner$AMFMDsiUpListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$AMFMDsiUpListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ AMFMStation val$selectedStation;
    private final /* synthetic */ HistoryTuner$AMFMDsiUpListener this$1;

    HistoryTuner$AMFMDsiUpListener$1(HistoryTuner$AMFMDsiUpListener historyTuner$AMFMDsiUpListener, String string, AMFMStation aMFMStation) {
        this.this$1 = historyTuner$AMFMDsiUpListener;
        this.val$selectedStation = aMFMStation;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateSelectedStation(this.val$selectedStation);
    }
}

