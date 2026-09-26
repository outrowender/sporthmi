/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$PowerEventListener$1;
import de.audi.tuner.ifc.IPowerEvent;

class HistoryStationList$PowerEventListener
implements IPowerEvent {
    private final /* synthetic */ HistoryStationList this$0;

    private HistoryStationList$PowerEventListener(HistoryStationList historyStationList) {
        this.this$0 = historyStationList;
    }

    @Override
    public void notifyPowerEvent(int n, int n2) {
        if (n == 2) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$PowerEventListener$1(this, "HistoryStationList.PowerEventListener.notifyPowerEvent HMI_STANDBY"));
        }
    }

    /* synthetic */ HistoryStationList$PowerEventListener(HistoryStationList historyStationList, HistoryStationList$1 historyStationList$1) {
        this(historyStationList);
    }

    static /* synthetic */ HistoryStationList access$1800(HistoryStationList$PowerEventListener historyStationList$PowerEventListener) {
        return historyStationList$PowerEventListener.this$0;
    }
}

