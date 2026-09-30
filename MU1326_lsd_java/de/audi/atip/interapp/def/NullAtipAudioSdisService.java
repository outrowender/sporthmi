/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.AtipAudioSdisService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAtipAudioSdisService
extends NullService
implements AtipAudioSdisService {
    public NullAtipAudioSdisService(LogChannel logChannel) {
        super(logChannel, "NullAtipAudioSdisService");
    }

    public void mediaTunerAreaEntered() {
        this.log("mediaTunerAreaEntered");
    }

    public void mediaTunerAreaLeft() {
        this.log("mediaTunerAreaLeft");
    }

    public void disableA2LS() {
        this.log("disableA2LS");
    }
}

