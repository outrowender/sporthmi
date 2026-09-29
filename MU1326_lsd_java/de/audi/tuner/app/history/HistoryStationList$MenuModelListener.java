/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.RadioMenuModelListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.history.HistoryStationList;
import de.audi.tuner.app.history.HistoryStationList$MenuModelListener$1;

class HistoryStationList$MenuModelListener
extends RadioMenuModelListener {
    private final /* synthetic */ HistoryStationList this$0;

    public HistoryStationList$MenuModelListener(HistoryStationList historyStationList, TunerBasics tunerBasics, int[] nArray) {
        this.this$0 = historyStationList;
        super(tunerBasics, nArray);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        super.itemFocused(n, n2, l, n3);
        if (n != -678952704) {
            HistoryStationList.access$1100((HistoryStationList)this.this$0).tunerJobQueue.enqueue(new HistoryStationList$MenuModelListener$1(this, "HistoryStationList.MenuModelListener.itemFocused"));
        }
    }

    static /* synthetic */ HistoryStationList access$1600(HistoryStationList$MenuModelListener historyStationList$MenuModelListener) {
        return historyStationList$MenuModelListener.this$0;
    }
}

