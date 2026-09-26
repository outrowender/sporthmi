/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver$EmptyImplementation;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.readout.MessagingReadoutService$1;
import de.audi.app.messaging.core.readout.MessagingReadoutService$EntryListObserver$1;
import de.audi.app.messaging.core.readout.MessagingReadoutService$EntryListObserver$2;
import org.dsi.ifc.messaging.ListEntry;

final class MessagingReadoutService$EntryListObserver
extends IEntryListObserver$EmptyImplementation {
    private final /* synthetic */ MessagingReadoutService this$0;

    private MessagingReadoutService$EntryListObserver(MessagingReadoutService messagingReadoutService) {
        this.this$0 = messagingReadoutService;
    }

    @Override
    public void indicateItemSelected(ListEntry listEntry, long l) {
        MessagingReadoutService.access$5000(this.this$0).getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$EntryListObserver$1(this, listEntry));
    }

    @Override
    public void indicateListDataResponseOnFolderChange() {
        MessagingReadoutService.access$5300(this.this$0).getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$EntryListObserver$2(this));
    }

    /* synthetic */ MessagingReadoutService$EntryListObserver(MessagingReadoutService messagingReadoutService, MessagingReadoutService$1 messagingReadoutService$1) {
        this(messagingReadoutService);
    }

    static /* synthetic */ MessagingReadoutService access$4600(MessagingReadoutService$EntryListObserver messagingReadoutService$EntryListObserver) {
        return messagingReadoutService$EntryListObserver.this$0;
    }
}

