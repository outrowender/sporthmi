/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MessagingReadoutService$7
implements Runnable {
    private final /* synthetic */ boolean val$isFolder;
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$7(MessagingReadoutService messagingReadoutService, boolean bl) {
        this.this$0 = messagingReadoutService;
        this.val$isFolder = bl;
    }

    @Override
    public void run() {
        try {
            MessagingReadoutService.access$1500(this.this$0).log(1078071040, "[MessagingReadoutService#indicateFolderContentListItemSelected] isFolder = %1", this.val$isFolder);
            MessagingReadoutService.access$400(this.this$0).indicateFolderContentListItemSelected(this.val$isFolder);
        }
        catch (Exception exception) {
            Logs.logException(MessagingReadoutService.access$1600(this.this$0), exception, "[MessagingReadoutService#indicateFolderContentListItemSelected]");
        }
    }
}

