/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.util.jobqueue.AbstractNamedRunnable;

class HistoryStationList$2
extends AbstractNamedRunnable {
    private final /* synthetic */ EvoListRow val$row;
    private final /* synthetic */ int val$modelId;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ int val$col;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ HistoryStationList this$0;

    HistoryStationList$2(HistoryStationList historyStationList, String string, EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.this$0 = historyStationList;
        this.val$row = evoListRow;
        this.val$modelId = n;
        this.val$index = n2;
        this.val$col = n3;
        this.val$terminal = n4;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.itemSelected(this.val$row, this.val$modelId, this.val$index, this.val$col, this.val$terminal);
    }
}

