/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;

class MessagingReadoutService$3
implements Runnable {
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$3(MessagingReadoutService messagingReadoutService) {
        this.this$0 = messagingReadoutService;
    }

    @Override
    public void run() {
        MessagingReadoutService.access$800(this.this$0).log(-2137614336, "[MessagingReadoutService#notifyTtsSessionStopped]");
        if (MessagingReadoutService.access$300(this.this$0) == 1) {
            MessagingReadoutService.access$700(this.this$0, 1);
            MessagingReadoutService.access$302(this.this$0, 0);
        }
    }
}

