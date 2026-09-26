/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;

class AbstractPhoneServiceImpl$5
extends AbstractTelInterappEvent {
    private final /* synthetic */ String val$value;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    AbstractPhoneServiceImpl$5(AbstractPhoneServiceImpl abstractPhoneServiceImpl, String string, String string2) {
        this.this$0 = abstractPhoneServiceImpl;
        this.val$value = string2;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneServiceImpl.access$2900(this.this$0).log(1078071040, "[AbstractPhoneServiceImpl#setMailboxSpeller] setting mailbox speller text to %1", (Object)this.val$value);
        AbstractPhoneServiceImpl.access$3000(this.this$0, 1687684096).setText(this.val$value);
        if (this.val$value != null && this.val$value.length() > 0) {
            AbstractPhoneServiceImpl.access$3100(this.this$0, -2104163328).setStatus(1);
        } else {
            AbstractPhoneServiceImpl.access$3200(this.this$0, -2104163328).setStatus(0);
        }
    }
}

