/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.history.HistoryStationList$PrevNextHandler;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$PrevNextHandler$1
extends AbstractNamedRunnable {
    private final /* synthetic */ boolean val$next;
    private final /* synthetic */ HistoryStationList$PrevNextHandler this$1;

    HistoryStationList$PrevNextHandler$1(HistoryStationList$PrevNextHandler historyStationList$PrevNextHandler, String string, boolean bl) {
        this.this$1 = historyStationList$PrevNextHandler;
        this.val$next = bl;
        super(string);
    }

    @Override
    public void run() {
        this.this$1.handlePrevNext(this.val$next);
    }
}

