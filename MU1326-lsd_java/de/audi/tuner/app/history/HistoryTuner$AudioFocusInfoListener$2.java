/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$AudioFocusInfoListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$AudioFocusInfoListener$2
extends AbstractNamedRunnable {
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ int val$band;
    private final /* synthetic */ HistoryTuner$AudioFocusInfoListener this$1;

    HistoryTuner$AudioFocusInfoListener$2(HistoryTuner$AudioFocusInfoListener historyTuner$AudioFocusInfoListener, String string, int n, int n2) {
        this.this$1 = historyTuner$AudioFocusInfoListener;
        this.val$terminalID = n;
        this.val$band = n2;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.audioFocus(this.val$terminalID, this.val$band);
    }
}

