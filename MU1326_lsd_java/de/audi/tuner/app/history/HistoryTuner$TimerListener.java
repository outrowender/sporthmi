/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$TimerListener$1;

class HistoryTuner$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$TimerListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void fireTimer(Timer timer) {
        HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$TimerListener$1(this, "HistroyTuner.TimerListener.fireTimer"));
    }

    /* synthetic */ HistoryTuner$TimerListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }

    static /* synthetic */ HistoryTuner access$2300(HistoryTuner$TimerListener historyTuner$TimerListener) {
        return historyTuner$TimerListener.this$0;
    }
}

