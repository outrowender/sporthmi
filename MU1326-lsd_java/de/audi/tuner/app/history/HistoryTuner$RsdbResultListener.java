/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$RsdbResultListener$1;
import de.audi.tuner.app.rsdb.IRSDBResult;

class HistoryTuner$RsdbResultListener
implements IRSDBResult {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$RsdbResultListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void resultAvailable() {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$RsdbResultListener$1(this, "HistroyTuner.RsdbResultListener.resultAvailable"));
            return;
        }
        HistoryTuner.access$1800(this.this$0).init(this.this$0.logoDb);
    }

    /* synthetic */ HistoryTuner$RsdbResultListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

