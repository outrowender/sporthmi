/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.accounts.AccountList;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.util.Logs;

class MultipleMessageReadoutService$4
implements Runnable {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$4(MultipleMessageReadoutService multipleMessageReadoutService) {
        this.this$0 = multipleMessageReadoutService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        int n = 0;
        try {
            MultipleMessageReadoutService.access$2100(this.this$0).log(1078071040, "[MultipleMessageReadoutService#requestEndDialog]");
            AccountList accountList = MultipleMessageReadoutService.access$2200(this.this$0).getAccountManager().getDialogAccountList();
            accountList.removeAccountFilter(MultipleMessageReadoutService.access$1400(this.this$0));
            MultipleMessageReadoutService.access$802(this.this$0, 0);
        }
        catch (Exception exception) {
            Logs.logException(MultipleMessageReadoutService.access$2300(this.this$0), exception, "[MultipleMessageReadoutService#requestEndDialog]");
            n = 1;
        }
        finally {
            MultipleMessageReadoutService.access$2400(this.this$0).getEntryList().signalListReady(true);
            MultipleMessageReadoutService.access$2500(this.this$0, n);
        }
    }
}

