/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.log.LogChannel;

public class NullOnlineDestinationService
extends NullService
implements IOnlineDestinationService {
    public NullOnlineDestinationService(LogChannel logChannel) {
        super(logChannel, "OnlineDestinationService");
    }

    public void enterOnlineDestinationHandling() {
        super.log();
    }
}

