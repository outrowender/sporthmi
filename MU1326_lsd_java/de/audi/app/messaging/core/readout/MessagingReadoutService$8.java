/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MessagingReadoutService$8
implements Runnable {
    private final /* synthetic */ int val$messageType;
    private final /* synthetic */ int val$selectLevel;
    private final /* synthetic */ boolean val$newMsgMode;
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$8(MessagingReadoutService messagingReadoutService, int n, int n2, boolean bl) {
        this.this$0 = messagingReadoutService;
        this.val$messageType = n;
        this.val$selectLevel = n2;
        this.val$newMsgMode = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MessagingReadoutService.access$1700(this.this$0).log(1078071040, "[MessagingReadoutService#requestBeginDialog] newMsgMode = %3, messageType = %1, selectLevel = %2", (long)this.val$messageType, (long)this.val$selectLevel, this.val$newMsgMode);
            if (MessagingReadoutService.access$200(this.this$0) != 0) {
                MessagingReadoutService.access$1800(this.this$0, "[MessagingReadoutService#requestBeginDialog]", MessagingReadoutService.access$200(this.this$0), MessagingReadoutService.access$300(this.this$0));
                n = 3;
            } else {
                boolean bl;
                MessagingReadoutService.access$1902(this.this$0, this.val$newMsgMode);
                MessagingReadoutService.access$2000(this.this$0, false);
                boolean bl2 = this.val$selectLevel == 0;
                boolean bl3 = bl = this.val$selectLevel == 0 || this.val$selectLevel == 1;
                if (bl2) {
                    MessagingReadoutService.access$2100(this.this$0).getEntryList().signalListReady(false);
                }
                if (bl) {
                    MessagingReadoutService.access$2200(this.this$0).getSelectedMessage().signalMessageContentsReady(0);
                }
                AccountList accountList = MessagingReadoutService.access$2300(this.this$0).getAccountManager().getDialogAccountList();
                accountList.removeAccountFilter(MessagingReadoutService.access$2400(this.this$0));
                MessagingReadoutService.access$2402(this.this$0, MessagingReadoutService.access$2500(this.this$0, this.val$newMsgMode, this.val$messageType));
                accountList.addAccountFilter(MessagingReadoutService.access$2400(this.this$0));
                if (this.val$selectLevel == 0) {
                    MessagingReadoutService.access$2600(this.this$0);
                } else if (this.val$selectLevel == 1) {
                    MessagingReadoutService.access$2700(this.this$0, this.val$newMsgMode);
                }
                MessagingReadoutService.access$2800(this.this$0, 1);
            }
        }
        catch (Exception exception) {
            Logs.logException(MessagingReadoutService.access$2900(this.this$0), exception, "[MessagingReadoutService#requestBeginDialog]");
            n = 1;
        }
        finally {
            MessagingReadoutService.access$3000(this.this$0, n);
        }
    }
}

