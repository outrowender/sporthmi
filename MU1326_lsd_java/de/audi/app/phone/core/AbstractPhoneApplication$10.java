/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.event.AbstractTelDeinitEvent;

class AbstractPhoneApplication$10
extends AbstractTelDeinitEvent {
    private final /* synthetic */ AbstractPhoneApplication this$0;

    AbstractPhoneApplication$10(AbstractPhoneApplication abstractPhoneApplication, String string) {
        this.this$0 = abstractPhoneApplication;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneApplication.access$1000(this.this$0);
    }
}

