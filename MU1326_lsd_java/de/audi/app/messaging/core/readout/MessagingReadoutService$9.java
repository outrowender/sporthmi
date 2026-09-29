/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MessagingReadoutService$9
implements Runnable {
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$9(MessagingReadoutService messagingReadoutService) {
        this.this$0 = messagingReadoutService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingReadoutService.access$3100(this.this$0).log(1078071040, "[MessagingReadoutService#requestEndDialog]");
            MessagingReadoutService.access$3200(this.this$0).getEntryList().signalListReady(true);
            MessagingReadoutService.access$3300(this.this$0).getSelectedMessage().signalMessageContentsReady(1);
            AccountList accountList = MessagingReadoutService.access$3400(this.this$0).getAccountManager().getDialogAccountList();
            accountList.removeAccountFilter(MessagingReadoutService.access$2400(this.this$0));
            MessagingReadoutService.access$2800(this.this$0, 0);
            MessagingReadoutService.access$302(this.this$0, 0);
        }
        catch (Exception exception) {
            Logs.logException(MessagingReadoutService.access$3500(this.this$0), exception, "[MessagingReadoutService#requestEndDialog]");
            n = 1;
        }
        finally {
            MessagingReadoutService.access$3600(this.this$0, n);
        }
    }
}

