/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$MenuModelListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$MenuModelListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryStationList$MenuModelListener this$1;

    HistoryStationList$MenuModelListener$1(HistoryStationList$MenuModelListener historyStationList$MenuModelListener, String string) {
        this.this$1 = historyStationList$MenuModelListener;
        super(string);
    }

    @Override
    public void run() {
        HistoryStationList.access$1700(HistoryStationList$MenuModelListener.access$1600(this.this$1), -1);
    }
}

