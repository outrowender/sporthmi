/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$MyMessageListener$1;
import de.audi.tuner.ifc.listener.MessageListener;

class HistoryStationList$MyMessageListener
extends MessageListener {
    private final /* synthetic */ HistoryStationList this$0;

    private HistoryStationList$MyMessageListener(HistoryStationList historyStationList) {
        this.this$0 = historyStationList;
    }

    @Override
    public void resetToDefaultSettings() {
        if (!HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$MyMessageListener$1(this, "HistoryStationList.MyMessageListener.resetToDefaultSettings"));
            return;
        }
        HistoryStationList.access$2000(this.this$0);
    }

    /* synthetic */ HistoryStationList$MyMessageListener(HistoryStationList historyStationList, HistoryStationList$1 historyStationList$1) {
        this(historyStationList);
    }
}

