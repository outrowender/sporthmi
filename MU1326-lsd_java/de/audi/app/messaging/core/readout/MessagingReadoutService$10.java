/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MessagingReadoutService$10
implements Runnable {
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$10(MessagingReadoutService messagingReadoutService) {
        this.this$0 = messagingReadoutService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingReadoutService.access$3700(this.this$0).log(1078071040, "[MessagingReadoutService#requestReadoutMessage]");
            if (MessagingReadoutService.access$200(this.this$0) != 1 || MessagingReadoutService.access$300(this.this$0) != 0) {
                MessagingReadoutService.access$1800(this.this$0, "[MessagingReadoutService#requestReadoutMessage]", MessagingReadoutService.access$200(this.this$0), MessagingReadoutService.access$300(this.this$0));
                n = 3;
            } else {
                MessagingReadoutService.access$302(this.this$0, 1);
                MessagingReadoutService.access$3800(this.this$0).getMessageReader().start();
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingReadoutService.access$3900(this.this$0), exception, "[MessagingReadoutService#requestReadoutMessage]");
            n = 1;
        }
        finally {
            if (n != 0) {
                MessagingReadoutService.access$700(this.this$0, n);
            }
        }
    }
}

