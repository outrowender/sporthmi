/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceMessaging;

class TelServiceMessaging$1
extends AbstractTelInterappEvent {
    private final /* synthetic */ boolean val$smsAvailable;
    private final /* synthetic */ boolean val$emailsAvailable;
    private final /* synthetic */ TelServiceMessaging this$0;

    TelServiceMessaging$1(TelServiceMessaging telServiceMessaging, String string, boolean bl, boolean bl2) {
        this.this$0 = telServiceMessaging;
        this.val$smsAvailable = bl;
        this.val$emailsAvailable = bl2;
        super(string);
    }

    @Override
    public void run() {
        TelServiceMessaging.access$100(this.this$0).getGlobalTelephoneStateManager().updateNewMessagesAvailable(this.val$smsAvailable, this.val$emailsAvailable);
    }
}

