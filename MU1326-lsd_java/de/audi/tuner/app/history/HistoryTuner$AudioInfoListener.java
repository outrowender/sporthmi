/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$AudioInfoListener$1;

class HistoryTuner$AudioInfoListener
extends AudioInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$AudioInfoListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void fadedInConnForBand(int n) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$AudioInfoListener$1(this, "HistroyTuner.AudioInfoListener.fadedInConnForBand", n));
            return;
        }
        HistoryTuner.access$1400((HistoryTuner)this.this$0).getLogger().history.log(-2137614336, "[HistoryTuner.fadedInConnForBand] %1", (long)n);
        HistoryTuner.access$1700(this.this$0);
    }

    /* synthetic */ HistoryTuner$AudioInfoListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

