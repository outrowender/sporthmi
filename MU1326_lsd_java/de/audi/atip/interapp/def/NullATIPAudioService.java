/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ATIPAudioService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullATIPAudioService
extends NullService
implements ATIPAudioService {
    public NullATIPAudioService(LogChannel logChannel) {
        super(logChannel, "ATIPAudioService");
    }

    public void volumeMenuEntered(int n, int n2, boolean bl) {
        this.log();
    }

    public void volumeMenuLeft() {
        this.log();
    }
}

