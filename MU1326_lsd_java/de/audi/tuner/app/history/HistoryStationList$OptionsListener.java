/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$OptionsListener$1;
import de.audi.tuner.app.misc.IOptionsListener;

class HistoryStationList$OptionsListener
implements IOptionsListener {
    private final /* synthetic */ HistoryStationList this$0;

    private HistoryStationList$OptionsListener(HistoryStationList historyStationList) {
        this.this$0 = historyStationList;
    }

    @Override
    public void amFmViewChanged(int n) {
        if (!HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$OptionsListener$1(this, "HistoryStationList.OptionsListener.amFmViewChanged", n));
            return;
        }
        HistoryStationList.access$1900(this.this$0, n);
    }

    /* synthetic */ HistoryStationList$OptionsListener(HistoryStationList historyStationList, HistoryStationList$1 historyStationList$1) {
        this(historyStationList);
    }
}

