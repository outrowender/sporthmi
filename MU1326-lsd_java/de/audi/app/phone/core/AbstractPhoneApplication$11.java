/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.event.AbstractTelDeinitEvent;
import de.audi.atip.sync.IWaitSyncer;

class AbstractPhoneApplication$11
extends AbstractTelDeinitEvent {
    private final /* synthetic */ IWaitSyncer val$waitSyncer;
    private final /* synthetic */ AbstractPhoneApplication this$0;

    AbstractPhoneApplication$11(AbstractPhoneApplication abstractPhoneApplication, String string, IWaitSyncer iWaitSyncer) {
        this.this$0 = abstractPhoneApplication;
        this.val$waitSyncer = iWaitSyncer;
        super(string);
    }

    @Override
    public void run() {
        try {
            AbstractPhoneApplication.access$1100(this.this$0).deinit();
        }
        catch (Exception exception) {
            Thread.interrupted();
            AbstractPhoneApplication.access$700(this.this$0).log(10000, "[AbstractPhoneApplication#deinit]", (Throwable)exception);
        }
        AbstractPhoneApplication.access$600(this.this$0).log(1078071040, "[AbstractPhoneApplication#deinit] triggering waitsyncer.");
        this.val$waitSyncer.trigger();
    }
}

