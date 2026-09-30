/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.InfoService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullInfoService
extends NullService
implements InfoService {
    public NullInfoService(LogChannel logChannel) {
        super(logChannel, "InfoService");
    }

    public int getTMCInfoAvailable() {
        super.log();
        return 0;
    }

    public int getTPInfoAvailable() {
        super.log();
        return 0;
    }

    public void speakTmcMessages(boolean bl) {
        super.log();
    }

    public void speakTIMMessages(boolean bl) {
        super.log();
    }
}

