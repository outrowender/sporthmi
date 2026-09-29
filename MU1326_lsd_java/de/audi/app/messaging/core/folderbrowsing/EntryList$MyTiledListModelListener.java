/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.hmi.model.list.DefaultTiledListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;

class EntryList$MyTiledListModelListener
extends DefaultTiledListModelListener {
    private final /* synthetic */ EntryList this$0;

    private EntryList$MyTiledListModelListener(EntryList entryList) {
        this.this$0 = entryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Object object = EntryList.access$1200(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            EntryList.access$1300(this.this$0).log(1078071040, "[EntryList#itemSelected] index = %2, row = %1", (Object)evoListRow, (long)n2);
            if (evoListRow == null) {
                EntryList.access$1400(this.this$0).log(-1601830656, "[EntryList#MyTiledListModelListener#itemSelected] selectedRow is null!");
            } else if (!EntryList.access$1500(this.this$0)) {
                EntryList.access$1600(this.this$0, evoListRow);
                EntryList.access$1700(this.this$0).getHmiServiceApp().getModelApp(n).fireEvent(n4);
            } else {
                EntryList.access$1800(this.this$0, evoListRow, n, n2, n3, n4);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        Object object = EntryList.access$1900(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            EntryList.access$2000(this.this$0).log(1078071040, "[EntryList#itemFocused] index = %2, row = %1", (Object)evoListRow, (long)n2);
            EntryList.access$2100(this.this$0, (EntryListRow)evoListRow);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        Object object = EntryList.access$2200(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            try {
                EntryList.access$2300(this.this$0).log(1078071040, "[EntryList#requestItems] startIndex = %1, length = %2, requestID = %3", (long)n, (long)n2, (long)n3);
                EntryList.access$2400(this.this$0, 0);
                EntryList.access$2500(this.this$0, n, n2, n3, false, null);
            }
            catch (Exception exception) {
                Logs.logException(EntryList.access$2600(this.this$0), exception, "[EntryList#requestItems]");
                EntryList.access$2400(this.this$0, 3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        Object object = EntryList.access$2700(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            EntryList.access$2800(this.this$0).log(1078071040, "[EntryList#unrequestItems] startIndex = %1, length = %2", (long)n, (long)n2);
            EntryList.access$2900(this.this$0).clearRows(n, n2);
        }
    }

    /* synthetic */ EntryList$MyTiledListModelListener(EntryList entryList, EntryList$1 entryList$1) {
        this(entryList);
    }
}

