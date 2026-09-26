/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$AudioInfoListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$AudioInfoListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ int val$band;
    private final /* synthetic */ HistoryTuner$AudioInfoListener this$1;

    HistoryTuner$AudioInfoListener$1(HistoryTuner$AudioInfoListener historyTuner$AudioInfoListener, String string, int n) {
        this.this$1 = historyTuner$AudioInfoListener;
        this.val$band = n;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.fadedInConnForBand(this.val$band);
    }
}

