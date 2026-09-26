/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$TimerListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryTuner$TimerListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryTuner$TimerListener this$1;

    HistoryTuner$TimerListener$1(HistoryTuner$TimerListener historyTuner$TimerListener, String string) {
        this.this$1 = historyTuner$TimerListener;
        super(string);
    }

    @Override
    public void run() {
        HistoryTuner.access$2400(HistoryTuner$TimerListener.access$2300(this.this$1));
    }
}

