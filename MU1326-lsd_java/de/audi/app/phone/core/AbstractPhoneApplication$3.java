/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.event.AbstractTelInitEvent;

class AbstractPhoneApplication$3
extends AbstractTelInitEvent {
    private final /* synthetic */ AbstractPhoneApplication this$0;

    AbstractPhoneApplication$3(AbstractPhoneApplication abstractPhoneApplication, String string) {
        this.this$0 = abstractPhoneApplication;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneApplication.access$200(this.this$0);
    }
}

