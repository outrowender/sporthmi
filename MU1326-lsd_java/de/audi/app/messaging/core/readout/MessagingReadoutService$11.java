/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.util.Logs;
import org.dsi.ifc.messaging.MessagingAccount;

class MessagingReadoutService$11
implements Runnable {
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$11(MessagingReadoutService messagingReadoutService) {
        this.this$0 = messagingReadoutService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            if (MessagingReadoutService.access$200(this.this$0) != 0) {
                MessagingReadoutService.access$1800(this.this$0, "[MessagingReadoutService#requestBeginLastSelectedEntry]", MessagingReadoutService.access$200(this.this$0), MessagingReadoutService.access$300(this.this$0));
                n = 3;
            } else {
                MessagingReadoutService.access$2000(this.this$0, false);
                MessagingReadoutService.access$4000(this.this$0).getEntryList().signalListReady(false);
                AccountList accountList = MessagingReadoutService.access$4100(this.this$0).getAccountManager().getDialogAccountList();
                MessagingAccount messagingAccount = MessagingReadoutService.access$4200(this.this$0).getAccountManager().getLastSelectedAccount();
                if (messagingAccount != null) {
                    MessagingReadoutService.access$4300(this.this$0).log(1078071040, "[MessagingReadoutService#requestBeginLastSelectedEntry] Selecting last account %1.", (Object)String.valueOf(messagingAccount));
                    accountList.selectAccount(accountList.getRowIndexByAccount(messagingAccount));
                } else {
                    MessagingReadoutService.access$4400(this.this$0).log(-1601830656, "[MessagingReadoutService#requestBeginLastSelectedEntry] Last account is null!");
                    n = 3;
                }
                MessagingReadoutService.access$2800(this.this$0, 1);
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingReadoutService.access$4500(this.this$0), exception, "[MessagingReadoutService#requestBeginLastSelectedEntry]");
            n = 1;
        }
        finally {
            MessagingReadoutService.access$3000(this.this$0, n);
        }
    }
}

