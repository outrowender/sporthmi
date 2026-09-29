/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList$MemoryListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$MemoryListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryStationList$MemoryListener this$1;

    HistoryStationList$MemoryListener$1(HistoryStationList$MemoryListener historyStationList$MemoryListener, String string) {
        this.this$1 = historyStationList$MemoryListener;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.updatedMemoryList();
    }
}

