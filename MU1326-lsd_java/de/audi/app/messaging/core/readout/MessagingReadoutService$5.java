/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MessagingReadoutService$5
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$5(MessagingReadoutService messagingReadoutService, int n) {
        this.this$0 = messagingReadoutService;
        this.val$result = n;
    }

    @Override
    public void run() {
        try {
            MessagingReadoutService.access$1100(this.this$0).log(1078071040, "[MessagingReadoutService#emitResponseEndDialog] result = %1", (long)this.val$result);
            MessagingReadoutService.access$400(this.this$0).responseEndDialog(this.val$result);
        }
        catch (Exception exception) {
            Logs.logException(MessagingReadoutService.access$1200(this.this$0), exception, "[MessagingReadoutService#emitResponseEndDialog]");
        }
    }
}

