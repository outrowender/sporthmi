/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.history.HistoryTuner$1;
import de.audi.tuner.app.history.HistoryTuner$RsdbResultListener;
import de.audi.tuner.app.history.HistoryTuner$RsdbStatusListener$1;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.ILogoDatabase;

class HistoryTuner$RsdbStatusListener
implements IRadioDatabaseListener {
    private final /* synthetic */ HistoryTuner this$0;

    private HistoryTuner$RsdbStatusListener(HistoryTuner historyTuner) {
        this.this$0 = historyTuner;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
        if (!HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryTuner.access$1400((HistoryTuner)this.this$0).tunerJobQueue.enqueue(new HistoryTuner$RsdbStatusListener$1(this, "HistroyTuner.RsdbStatusListener.databaseReady", iLogoDatabase));
            return;
        }
        HistoryTuner.access$1800(this.this$0).persist();
        if (iLogoDatabase.isRealDatabase()) {
            this.this$0.logoDb = iLogoDatabase;
            TunerObjectContainer[] tunerObjectContainerArray = this.this$0.getList();
            iLogoDatabase.requestDataById(tunerObjectContainerArray, new HistoryTuner$RsdbResultListener(this.this$0, null));
        } else {
            this.this$0.logoDb = null;
            HistoryTuner.access$1800(this.this$0).init(null);
        }
    }

    /* synthetic */ HistoryTuner$RsdbStatusListener(HistoryTuner historyTuner, HistoryTuner$1 historyTuner$1) {
        this(historyTuner);
    }
}

