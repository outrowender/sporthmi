/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.phone.ITelEcallService;
import de.audi.atip.log.LogChannel;

public class NullTelEcallService
extends NullService
implements ITelEcallService {
    public NullTelEcallService(LogChannel logChannel) {
        super(logChannel, "ITelEcallService");
    }

    public void hangupServiceCall() {
        this.log();
    }

    public void hangupLowPrioritySOSCall() {
        this.log();
    }

    public void dialLowPrioritySOSCall(String string) {
        this.log();
    }
}

