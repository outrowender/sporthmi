/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.IAccountListObserver$EmptyImplementation;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.readout.MessagingReadoutService$1;
import de.audi.app.messaging.core.readout.MessagingReadoutService$AccountListObserver$1;
import org.dsi.ifc.messaging.MessagingAccount;

final class MessagingReadoutService$AccountListObserver
extends IAccountListObserver$EmptyImplementation {
    private final /* synthetic */ MessagingReadoutService this$0;

    private MessagingReadoutService$AccountListObserver(MessagingReadoutService messagingReadoutService) {
        this.this$0 = messagingReadoutService;
    }

    @Override
    public void indicateItemSelected(MessagingAccount messagingAccount) {
        MessagingReadoutService.access$5700(this.this$0).getExecutorManager().getInternalTaskDispatcher().execute(new MessagingReadoutService$AccountListObserver$1(this));
    }

    /* synthetic */ MessagingReadoutService$AccountListObserver(MessagingReadoutService messagingReadoutService, MessagingReadoutService$1 messagingReadoutService$1) {
        this(messagingReadoutService);
    }

    static /* synthetic */ MessagingReadoutService access$5400(MessagingReadoutService$AccountListObserver messagingReadoutService$AccountListObserver) {
        return messagingReadoutService$AccountListObserver.this$0;
    }
}

