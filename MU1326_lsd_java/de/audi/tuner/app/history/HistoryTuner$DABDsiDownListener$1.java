/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.history.HistoryTuner$DABDsiDownListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$DABDsiDownListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ DabStation val$station;
    private final /* synthetic */ DabReceptionStatus val$reception;
    private final /* synthetic */ int val$selectionNumber;
    private final /* synthetic */ HistoryTuner$DABDsiDownListener this$1;

    HistoryTuner$DABDsiDownListener$1(HistoryTuner$DABDsiDownListener historyTuner$DABDsiDownListener, String string, DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        this.this$1 = historyTuner$DABDsiDownListener;
        this.val$station = dabStation;
        this.val$reception = dabReceptionStatus;
        this.val$selectionNumber = n;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.preTuneAction(this.val$station, this.val$reception, this.val$selectionNumber);
    }
}

