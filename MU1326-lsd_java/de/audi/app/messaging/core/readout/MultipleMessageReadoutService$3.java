/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MultipleMessageReadoutService$3
implements Runnable {
    private final /* synthetic */ boolean val$newMsgMode;
    private final /* synthetic */ int val$msgType;
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$3(MultipleMessageReadoutService multipleMessageReadoutService, boolean bl, int n) {
        this.this$0 = multipleMessageReadoutService;
        this.val$newMsgMode = bl;
        this.val$msgType = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MultipleMessageReadoutService.access$1000(this.this$0).log(-2137614336, "MultipleMessageReadoutService#requestBeginDialog()");
            if (MultipleMessageReadoutService.access$800(this.this$0) != 0) {
                n = 3;
            }
            MultipleMessageReadoutService.access$802(this.this$0, 1);
            MultipleMessageReadoutService.access$1102(this.this$0, this.val$newMsgMode);
            MultipleMessageReadoutService.access$1202(this.this$0, this.val$msgType);
            AccountList accountList = MultipleMessageReadoutService.access$1300(this.this$0).getAccountManager().getDialogAccountList();
            accountList.removeAccountFilter(MultipleMessageReadoutService.access$1400(this.this$0));
            MultipleMessageReadoutService.access$1402(this.this$0, MultipleMessageReadoutService.access$1500(this.this$0, this.val$newMsgMode, MultipleMessageReadoutService.access$1200(this.this$0)));
            accountList.addAccountFilter(MultipleMessageReadoutService.access$1400(this.this$0));
            MultipleMessageReadoutService.access$1600(this.this$0).log(1078071040, "MultipleMessageReadoutService#requestBeginDialog(): filter type %1 matched to %2 accounts.", (long)this.val$msgType, (long)accountList.getLength());
            MultipleMessageReadoutService.access$1700(this.this$0);
            MultipleMessageReadoutService.access$1800(this.this$0).getEntryList().signalListReady(false);
        }
        catch (Exception exception) {
            Logs.logException(MultipleMessageReadoutService.access$1900(this.this$0), exception, "[MultipleMessageReadoutService#requestBeginDialog]");
            n = 1;
            MultipleMessageReadoutService.access$2000(this.this$0, n);
        }
        finally {
            MultipleMessageReadoutService.access$2000(this.this$0, n);
        }
    }
}

