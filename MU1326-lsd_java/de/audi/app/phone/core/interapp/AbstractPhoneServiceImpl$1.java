/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$1$1;
import de.audi.atip.phone.ITelServiceListener;

class AbstractPhoneServiceImpl$1
extends AbstractTelInterappEvent {
    private final /* synthetic */ String val$number;
    private final /* synthetic */ boolean val$jumpToPhone;
    private final /* synthetic */ ITelServiceListener val$listener;
    private final /* synthetic */ AbstractPhoneServiceImpl this$0;

    AbstractPhoneServiceImpl$1(AbstractPhoneServiceImpl abstractPhoneServiceImpl, String string, String string2, boolean bl, ITelServiceListener iTelServiceListener) {
        this.this$0 = abstractPhoneServiceImpl;
        this.val$number = string2;
        this.val$jumpToPhone = bl;
        this.val$listener = iTelServiceListener;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneServiceImpl.access$100(this.this$0).log(1078071040, "[AbstractPhoneServiceImpl#dialNumber] number=%1, jumpToPhone=%2", (Object)this.val$number, (Object)String.valueOf(this.val$jumpToPhone));
        AbstractPhoneServiceImpl.access$1000(this.this$0).getTelephoneDSIAccess().dialNumber(this.val$number, 0, true, new AbstractPhoneServiceImpl$1$1(this));
    }

    static /* synthetic */ ITelServiceListener access$200(AbstractPhoneServiceImpl$1 abstractPhoneServiceImpl$1) {
        return abstractPhoneServiceImpl$1.val$listener;
    }

    static /* synthetic */ AbstractPhoneServiceImpl access$300(AbstractPhoneServiceImpl$1 abstractPhoneServiceImpl$1) {
        return abstractPhoneServiceImpl$1.this$0;
    }

    static /* synthetic */ boolean access$500(AbstractPhoneServiceImpl$1 abstractPhoneServiceImpl$1) {
        return abstractPhoneServiceImpl$1.val$jumpToPhone;
    }
}

