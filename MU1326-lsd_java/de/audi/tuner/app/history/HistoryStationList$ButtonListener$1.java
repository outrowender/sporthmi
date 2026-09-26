/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$ButtonListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$ButtonListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryStationList$ButtonListener this$1;

    HistoryStationList$ButtonListener$1(HistoryStationList$ButtonListener historyStationList$ButtonListener, String string) {
        this.this$1 = historyStationList$ButtonListener;
        super(string);
    }

    @Override
    public void run() {
        HistoryStationList.access$2000(HistoryStationList$ButtonListener.access$2100(this.this$1));
    }
}

