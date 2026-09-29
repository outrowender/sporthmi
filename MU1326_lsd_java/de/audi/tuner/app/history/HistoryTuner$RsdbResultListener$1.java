/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner$RsdbResultListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$RsdbResultListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryTuner$RsdbResultListener this$1;

    HistoryTuner$RsdbResultListener$1(HistoryTuner$RsdbResultListener historyTuner$RsdbResultListener, String string) {
        this.this$1 = historyTuner$RsdbResultListener;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.resultAvailable();
    }
}

