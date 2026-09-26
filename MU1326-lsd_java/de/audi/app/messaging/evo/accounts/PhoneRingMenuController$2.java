/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController;
import de.audi.atip.interapp.phone.ITelServiceMessaging;

class PhoneRingMenuController$2
implements Runnable {
    private final /* synthetic */ boolean val$isSmsAccount;
    private final /* synthetic */ ITelServiceMessaging val$service;
    private final /* synthetic */ PhoneRingMenuController this$0;

    PhoneRingMenuController$2(PhoneRingMenuController phoneRingMenuController, boolean bl, ITelServiceMessaging iTelServiceMessaging) {
        this.this$0 = phoneRingMenuController;
        this.val$isSmsAccount = bl;
        this.val$service = iTelServiceMessaging;
    }

    @Override
    public void run() {
        try {
            int n = this.val$isSmsAccount ? 0 : 1;
            PhoneRingMenuController.access$300(this.this$0).log(1078071040, "[PhoneRingMenuController#emitNotifyActiveContextMessaging] contextType = %1", (long)n);
            this.val$service.notifyActiveContextMessaging(n);
        }
        catch (Exception exception) {
            Logs.logException(PhoneRingMenuController.access$400(this.this$0), exception, "[PhoneRingMenuController#emitNotifyActiveContextMessaging]");
        }
    }
}

