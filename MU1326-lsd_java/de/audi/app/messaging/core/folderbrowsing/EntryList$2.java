/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class EntryList$2
implements TimerListener {
    private final /* synthetic */ EntryList this$0;

    EntryList$2(EntryList entryList) {
        this.this$0 = entryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = EntryList.access$700(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            EntryList.access$800(this.this$0).log(10000, "[EntryList#fireTimer] Operation timed out.");
            if (EntryList.access$900(this.this$0) == 0) {
                EntryList.access$1000(this.this$0, 3);
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        EntryList.access$1100(this.this$0).log(-2137614336, "[EntryList#cancelTimer]");
    }
}

