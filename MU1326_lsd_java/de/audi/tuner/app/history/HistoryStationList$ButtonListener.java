/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$ButtonListener$1;

class HistoryStationList$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ HistoryStationList this$0;

    private HistoryStationList$ButtonListener(HistoryStationList historyStationList) {
        this.this$0 = historyStationList;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$ButtonListener$1(this, "HistoryStationList.ButtonListener.keyTyped"));
    }

    /* synthetic */ HistoryStationList$ButtonListener(HistoryStationList historyStationList, HistoryStationList$1 historyStationList$1) {
        this(historyStationList);
    }

    static /* synthetic */ HistoryStationList access$2100(HistoryStationList$ButtonListener historyStationList$ButtonListener) {
        return historyStationList$ButtonListener.this$0;
    }
}

