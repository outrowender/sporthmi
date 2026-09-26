/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.AbstractPhoneApplication;
import de.audi.app.phone.core.event.AbstractTelInitEvent;
import de.audi.atip.sync.IWaitSyncer;

class AbstractPhoneApplication$6
extends AbstractTelInitEvent {
    private final /* synthetic */ IWaitSyncer val$waitSyncer;
    private final /* synthetic */ AbstractPhoneApplication this$0;

    AbstractPhoneApplication$6(AbstractPhoneApplication abstractPhoneApplication, String string, IWaitSyncer iWaitSyncer) {
        this.this$0 = abstractPhoneApplication;
        this.val$waitSyncer = iWaitSyncer;
        super(string);
    }

    @Override
    public void run() {
        AbstractPhoneApplication.access$500(this.this$0);
        AbstractPhoneApplication.access$600(this.this$0).log(1078071040, "[AbstractPhoneApplication#init] triggering waitsyncer");
        this.val$waitSyncer.trigger();
    }
}

