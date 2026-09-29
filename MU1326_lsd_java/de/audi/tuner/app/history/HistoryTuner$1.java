/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$1
extends AbstractNamedRunnable {
    private final /* synthetic */ AMFMStation val$stationToFreeze;
    private final /* synthetic */ HistoryTuner this$0;

    HistoryTuner$1(HistoryTuner historyTuner, String string, AMFMStation aMFMStation) {
        this.this$0 = historyTuner;
        this.val$stationToFreeze = aMFMStation;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.updatePSFreeze(this.val$stationToFreeze);
    }
}

