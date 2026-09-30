/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.phone.ITelServiceEcall;
import de.audi.atip.interapp.phone.ITelServiceEcallListener;
import de.audi.atip.log.LogChannel;

public class NullTelServiceEcall
extends NullService
implements ITelServiceEcall {
    public NullTelServiceEcall(LogChannel logChannel) {
        super(logChannel, "ITelServiceEcall");
    }

    public void hangupAllCalls(ITelServiceEcallListener iTelServiceEcallListener) {
        this.log();
    }
}

