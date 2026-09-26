/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$1;
import de.audi.tuner.app.history.HistoryStationList$PrevNextHandler$1;
import de.audi.tuner.app.history.IHistoryTuneListener;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.IPrevNext;
import java.util.Iterator;

class HistoryStationList$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ HistoryStationList this$0;

    private HistoryStationList$PrevNextHandler(HistoryStationList historyStationList) {
        this.this$0 = historyStationList;
    }

    private AbstractMemoryRow getFollowingEnabledRowFromList(boolean bl, boolean bl2) {
        int n;
        int n2 = HistoryStationList.access$900(this.this$0).getLength();
        SelectedItem selectedItem = HistoryStationList.access$900(this.this$0).getSelected();
        int n3 = n = selectedItem != null ? selectedItem.getIndex() : -1;
        for (int i2 = n2; i2 > 0; --i2) {
            n3 = bl ? (n3 < n2 - 1 ? n3 + 1 : 0) : (n3 > 0 ? n3 - 1 : n2 - 1);
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)HistoryStationList.access$900(this.this$0).getRow(n3);
            if (bl2 && abstractMemoryRow.getState() != 0) continue;
            HistoryStationList.access$1000(this.this$0, n, n3);
            return abstractMemoryRow;
        }
        return null;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        if (!HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.isJobQueueDispatchThread()) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$PrevNextHandler$1(this, "HistoryStationList.PrevNextHandler.handlePrevNext", bl));
            return;
        }
        AbstractMemoryRow abstractMemoryRow = this.getFollowingEnabledRowFromList(bl, true);
        if (abstractMemoryRow != null) {
            TunerObjectContainer tunerObjectContainer = abstractMemoryRow.getTOContainer();
            Iterator iterator = HistoryStationList.access$1200(this.this$0).iterator();
            while (iterator.hasNext()) {
                ((IHistoryTuneListener)iterator.next()).historyTunePerformed(tunerObjectContainer);
            }
            HistoryStationList.access$1300(this.this$0).doTune(tunerObjectContainer, 0);
        }
        if (!HistoryStationList.access$1400(this.this$0).isDrawerOpen()) {
            HistoryStationList.access$1500(this.this$0).trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    /* synthetic */ HistoryStationList$PrevNextHandler(HistoryStationList historyStationList, HistoryStationList$1 historyStationList$1) {
        this(historyStationList);
    }
}

