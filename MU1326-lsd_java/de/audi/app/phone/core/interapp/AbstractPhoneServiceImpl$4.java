/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.sim.ITelLockStateHandler;

class AbstractPhoneServiceImpl$4
extends AbstractTelInterappEvent {
    private final /* synthetic */ String val$value;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    AbstractPhoneServiceImpl$4(AbstractPhoneServiceImpl abstractPhoneServiceImpl, String string, String string2) {
        this.this$0 = abstractPhoneServiceImpl;
        this.val$value = string2;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneServiceImpl.access$2600(this.this$0).log(1078071040, "[AbstractPhoneServiceImpl#setPINSpeller] setting pin speller text to %1", (Object)this.val$value);
        ITelLockStateHandler iTelLockStateHandler = AbstractPhoneServiceImpl.access$2700(this.this$0);
        if (iTelLockStateHandler != null) {
            iTelLockStateHandler.setPINSpeller(this.val$value);
        } else {
            AbstractPhoneServiceImpl.access$2800(this.this$0).log(-1601830656, "[AbstractPhoneServiceImpl#setPINSpeller] lock handler is null --> NOP!");
        }
    }
}

