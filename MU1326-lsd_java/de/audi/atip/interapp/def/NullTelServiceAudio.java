/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.phone.ITelServiceAudio;
import de.audi.atip.log.LogChannel;

public class NullTelServiceAudio
extends NullService
implements ITelServiceAudio {
    public NullTelServiceAudio(LogChannel logChannel, int n, String string) {
        super(logChannel, n, string);
    }

    public NullTelServiceAudio(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public NullTelServiceAudio(LogChannel logChannel) {
        super(logChannel, "NullTelServiceAudio");
    }

    @Override
    public void muteIncomingCallRingtone() {
        this.log();
    }
}

