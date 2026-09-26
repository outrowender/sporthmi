/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.TelServiceSDSListenerWrapper;
import de.audi.app.phone.core.sim.ITelLockStateHandler;
import de.audi.atip.phone.ITelServiceSDSListener;

class AbstractPhoneServiceImpl$6
extends AbstractTelInterappEvent {
    private final /* synthetic */ String val$pinCode;
    private final /* synthetic */ ITelServiceSDSListener val$responseListener;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    AbstractPhoneServiceImpl$6(AbstractPhoneServiceImpl abstractPhoneServiceImpl, String string, String string2, ITelServiceSDSListener iTelServiceSDSListener) {
        this.this$0 = abstractPhoneServiceImpl;
        this.val$pinCode = string2;
        this.val$responseListener = iTelServiceSDSListener;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneServiceImpl.access$3300(this.this$0).log(1078071040, "[AbstractPhoneServiceImpl#unlockSIMWithPIN] pinCode=%1", (Object)this.val$pinCode);
        ITelLockStateHandler iTelLockStateHandler = AbstractPhoneServiceImpl.access$2700(this.this$0);
        if (iTelLockStateHandler != null) {
            iTelLockStateHandler.unlockSIMwithPIN(this.val$pinCode, 0, this.val$responseListener != null ? new TelServiceSDSListenerWrapper(this.val$responseListener) : AbstractPhoneServiceImpl.access$3400(this.this$0).getDefaultListener());
        } else {
            AbstractPhoneServiceImpl.access$3500(this.this$0).log(-1601830656, "[AbstractPhoneServiceImpl#unlockSIMWithPIN] lock handler is null --> NOP!");
        }
    }
}

