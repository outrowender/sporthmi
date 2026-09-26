/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$MemoryListener$1;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.sds.DefaultUpdateListener;

class HistoryStationList$MemoryListener
extends DefaultUpdateListener {
    private final IMemoryList memory;
    private final /* synthetic */ HistoryStationList this$0;

    public HistoryStationList$MemoryListener(HistoryStationList historyStationList, IMemoryList iMemoryList) {
        this.this$0 = historyStationList;
        this.memory = iMemoryList;
    }

    @Override
    public void updatedMemoryList() {
        if (!HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$MemoryListener$1(this, "HistoryStationList.MemoryListener.updatedMemoryList"));
            return;
        }
        HistoryStationList.access$2502(this.this$0, this.memory.getList());
        BaseListModelApp baseListModelApp = HistoryStationList.access$900(this.this$0).getCopy();
        for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)baseListModelApp.getRow(i2);
            TunerObjectContainer tunerObjectContainer = abstractMemoryRow.getTOContainer();
            int n = HistoryStationList.access$2600(this.this$0, tunerObjectContainer);
            abstractMemoryRow.setPresetIndex(n - 1);
            baseListModelApp.setRow(i2, abstractMemoryRow);
        }
        HistoryStationList.access$900(this.this$0).update(baseListModelApp);
    }
}

