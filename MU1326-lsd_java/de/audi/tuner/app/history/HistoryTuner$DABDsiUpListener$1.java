/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.history.HistoryTuner$DABDsiUpListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$DABDsiUpListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ DabStation val$dabSt;
    private final /* synthetic */ DabReceptionStatus val$reception;
    private final /* synthetic */ HistoryTuner$DABDsiUpListener this$1;

    HistoryTuner$DABDsiUpListener$1(HistoryTuner$DABDsiUpListener historyTuner$DABDsiUpListener, String string, DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.this$1 = historyTuner$DABDsiUpListener;
        this.val$dabSt = dabStation;
        this.val$reception = dabReceptionStatus;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updateCurrentStation(this.val$dabSt, this.val$reception);
    }
}

