/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.indication;

import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.indication.PhoneIndicationController;
import de.audi.atip.interapp.phone.ITelServiceMessaging;

class PhoneIndicationController$1
implements Runnable {
    private final /* synthetic */ boolean val$newSmsAvailable;
    private final /* synthetic */ boolean val$newEmailsAvailable;
    private final /* synthetic */ ITelServiceMessaging val$service;
    private final /* synthetic */ PhoneIndicationController this$0;

    PhoneIndicationController$1(PhoneIndicationController phoneIndicationController, boolean bl, boolean bl2, ITelServiceMessaging iTelServiceMessaging) {
        this.this$0 = phoneIndicationController;
        this.val$newSmsAvailable = bl;
        this.val$newEmailsAvailable = bl2;
        this.val$service = iTelServiceMessaging;
    }

    @Override
    public void run() {
        PhoneIndicationController.access$200(this.this$0).log(1078071040, "[PhoneIndicationController#dispatchIndicationState] newSmsAvailable = %1, newEmailsAvailable = %2", this.val$newSmsAvailable, this.val$newEmailsAvailable);
        try {
            this.val$service.notifyNewMessagesAvailable(this.val$newSmsAvailable, this.val$newEmailsAvailable);
        }
        catch (Exception exception) {
            Logs.logException(PhoneIndicationController.access$300(this.this$0), exception, "[PhoneIndicationController#dispatchIndicationState]");
        }
    }
}

