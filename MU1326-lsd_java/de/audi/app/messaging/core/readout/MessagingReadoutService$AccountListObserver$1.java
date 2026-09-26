/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.readout.MessagingReadoutService$AccountListObserver;

class MessagingReadoutService$AccountListObserver$1
implements Runnable {
    private final /* synthetic */ MessagingReadoutService$AccountListObserver this$1;

    MessagingReadoutService$AccountListObserver$1(MessagingReadoutService$AccountListObserver messagingReadoutService$AccountListObserver) {
        this.this$1 = messagingReadoutService$AccountListObserver;
    }

    @Override
    public void run() {
        MessagingReadoutService.access$5500(MessagingReadoutService$AccountListObserver.access$5400(this.this$1)).log(-2137614336, "[MessagingReadoutService$AccountListObserver#indicateItemSelected]");
        if (MessagingReadoutService.access$200(MessagingReadoutService$AccountListObserver.access$5400(this.this$1)) == 1) {
            MessagingReadoutService.access$5600(MessagingReadoutService$AccountListObserver.access$5400(this.this$1)).getFolderNavigator().changeFolderDirect(-3, false);
        }
    }
}

