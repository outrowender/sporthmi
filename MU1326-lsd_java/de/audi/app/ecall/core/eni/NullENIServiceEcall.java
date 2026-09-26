/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.eni;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.eni.ENIServiceEcall;
import de.audi.atip.log.LogChannel;

class NullENIServiceEcall
extends NullService
implements ENIServiceEcall {
    NullENIServiceEcall(LogChannel logChannel) {
        super(logChannel, "ENIServiceEcall");
    }

    @Override
    public void confirmExpirationWarning() {
        this.log();
    }

    @Override
    public void confirmEcallExpirated() {
        this.log();
    }
}

