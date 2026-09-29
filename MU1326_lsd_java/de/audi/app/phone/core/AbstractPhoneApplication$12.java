/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.event.AbstractTelHmiApplicationEvent;

class AbstractPhoneApplication$12
extends AbstractTelHmiApplicationEvent {
    private final /* synthetic */ int val$id;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ AbstractPhoneApplication this$0;

    AbstractPhoneApplication$12(AbstractPhoneApplication abstractPhoneApplication, int n, int n2) {
        this.this$0 = abstractPhoneApplication;
        this.val$id = n;
        this.val$terminalID = n2;
    }

    @Override
    public void run() {
        AbstractPhoneApplication.access$700(this.this$0).log(1078071040, "[AbstractPhoneApplication#popupVisible] id=%1, terminalID=%2", (long)this.val$id, (long)this.val$terminalID);
        this.this$0.getPopupScreenStateDispatcher().notifyPopupVisible(this.val$id, this.val$terminalID);
    }
}

