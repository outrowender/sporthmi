/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.readout.MessagingReadoutService$EntryListObserver;
import de.audi.app.messaging.core.util.ListEntries;
import org.dsi.ifc.messaging.ListEntry;

class MessagingReadoutService$EntryListObserver$1
implements Runnable {
    private final /* synthetic */ ListEntry val$listEntry;
    private final /* synthetic */ MessagingReadoutService$EntryListObserver this$1;

    MessagingReadoutService$EntryListObserver$1(MessagingReadoutService$EntryListObserver messagingReadoutService$EntryListObserver, ListEntry listEntry) {
        this.this$1 = messagingReadoutService$EntryListObserver;
        this.val$listEntry = listEntry;
    }

    @Override
    public void run() {
        MessagingReadoutService.access$4700(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)).log(-2137614336, "[MessagingReadoutService$EntryListObserver#indicateItemSelected]");
        if (MessagingReadoutService.access$200(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)) == 1) {
            boolean bl = ListEntries.isFolder(this.val$listEntry);
            if (bl) {
                MessagingReadoutService.access$4800(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)).getEntryList().signalListReady(false);
            }
            MessagingReadoutService.access$4900(MessagingReadoutService$EntryListObserver.access$4600(this.this$1), bl);
        }
    }
}

