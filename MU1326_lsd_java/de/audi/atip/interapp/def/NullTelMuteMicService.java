/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.phone.ITelMuteMicService;
import de.audi.atip.log.LogChannel;

public class NullTelMuteMicService
extends NullService
implements ITelMuteMicService {
    public NullTelMuteMicService(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public void toggleMuteMicrophone(boolean bl) {
        this.log("toggleMuteMicrophone");
    }
}

