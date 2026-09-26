/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.event.AbstractTelDeinitEvent;

class AbstractPhoneApplication$8
extends AbstractTelDeinitEvent {
    private final /* synthetic */ AbstractPhoneApplication this$0;

    AbstractPhoneApplication$8(AbstractPhoneApplication abstractPhoneApplication, String string) {
        this.this$0 = abstractPhoneApplication;
        super(string);
    }

    @Override
    public void run() {
        try {
            AbstractPhoneApplication.access$800(this.this$0);
        }
        catch (Exception exception) {
            Thread.interrupted();
            AbstractPhoneApplication.access$700(this.this$0).log(10000, "[AbstractPhoneApplication#deinit]", (Throwable)exception);
        }
    }
}

