/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList$MyMessageListener;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$MyMessageListener$1
extends AbstractNamedRunnable {
    private final /* synthetic */ HistoryStationList$MyMessageListener this$1;

    HistoryStationList$MyMessageListener$1(HistoryStationList$MyMessageListener historyStationList$MyMessageListener, String string) {
        this.this$1 = historyStationList$MyMessageListener;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.resetToDefaultSettings();
    }
}

