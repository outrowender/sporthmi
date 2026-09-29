/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.AudioFocusInfo;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$AudioFocusInfoListener$1;
import de.audi.tuner.app.history.HistoryTuner$AudioFocusInfoListener$2;

class HistoryTuner$AudioFocusInfoListener
extends AudioFocusInfo {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$AudioFocusInfoListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void audioFocusLost() {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$AudioFocusInfoListener$1(this, "HistroyTuner.AudioFocusInfoListener.audioFocusLost"));
            return;
        }
        HistoryTuner.access$1602(this.this$0, false);
        HistoryTuner.access$1900(this.this$0).cancel();
    }

    @Override
    public void audioFocus(int n, int n2) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$AudioFocusInfoListener$2(this, "HistroyTuner.AudioFocusInfoListener.audioFocus", n, n2));
            return;
        }
        HistoryTuner.access$1602(this.this$0, true);
        HistoryTuner.access$1700(this.this$0);
    }

    /* synthetic */ HistoryTuner$AudioFocusInfoListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

