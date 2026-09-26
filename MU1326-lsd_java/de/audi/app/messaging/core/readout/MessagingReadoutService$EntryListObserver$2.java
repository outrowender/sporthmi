/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.readout.MessagingReadoutService$EntryListObserver;

class MessagingReadoutService$EntryListObserver$2
implements Runnable {
    private final /* synthetic */ MessagingReadoutService$EntryListObserver this$1;

    MessagingReadoutService$EntryListObserver$2(MessagingReadoutService$EntryListObserver messagingReadoutService$EntryListObserver) {
        this.this$1 = messagingReadoutService$EntryListObserver;
    }

    @Override
    public void run() {
        MessagingReadoutService.access$5100(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)).log(-2137614336, "[MessagingReadoutService$EntryListObserver#indicateListDataResponseOnFolderChange]");
        if (MessagingReadoutService.access$200(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)) == 1) {
            MessagingReadoutService.access$2700(MessagingReadoutService$EntryListObserver.access$4600(this.this$1), MessagingReadoutService.access$1900(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)));
        }
        MessagingReadoutService.access$5200(MessagingReadoutService$EntryListObserver.access$4600(this.this$1)).getEntryList().signalListReady(true);
    }
}

