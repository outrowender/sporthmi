/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$AudioFocusInfoListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$AudioFocusInfoListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryTuner$AudioFocusInfoListener this$1;

    HistoryTuner$AudioFocusInfoListener$1(HistoryTuner$AudioFocusInfoListener historyTuner$AudioFocusInfoListener, String string) {
        this.this$1 = historyTuner$AudioFocusInfoListener;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.audioFocusLost();
    }
}

