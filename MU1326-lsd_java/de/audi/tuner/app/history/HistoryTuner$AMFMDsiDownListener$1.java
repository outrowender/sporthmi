/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.history.HistoryTuner$AMFMDsiDownListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$AMFMDsiDownListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ AMFMStation val$station;
    private final /* synthetic */ boolean val$isManual;
    private final /* synthetic */ HistoryTuner$AMFMDsiDownListener this$1;

    HistoryTuner$AMFMDsiDownListener$1(HistoryTuner$AMFMDsiDownListener historyTuner$AMFMDsiDownListener, String string, AMFMStation aMFMStation, boolean bl) {
        this.this$1 = historyTuner$AMFMDsiDownListener;
        this.val$station = aMFMStation;
        this.val$isManual = bl;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.preTuneAction(this.val$station, this.val$isManual);
    }
}

