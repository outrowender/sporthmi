/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList$PowerEventListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$PowerEventListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryStationList$PowerEventListener this$1;

    HistoryStationList$PowerEventListener$1(HistoryStationList$PowerEventListener historyStationList$PowerEventListener, String string) {
        this.this$1 = historyStationList$PowerEventListener;
        super(string);
    }

    @Override
    public void run() {
        HistoryStationList$PowerEventListener.access$1800(this.this$1).persist();
    }
}

