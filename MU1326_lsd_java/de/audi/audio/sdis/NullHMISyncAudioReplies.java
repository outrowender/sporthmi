/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sdis.IHMISyncAudioReplies;

public class NullHMISyncAudioReplies
extends NullService
implements IHMISyncAudioReplies {
    protected NullHMISyncAudioReplies(LogChannel logChannel) {
        super(logChannel, 10000000, "IHMISyncAudioReplies");
    }

    public void updateCurrentVolume(int n) {
        this.log("updateCurrentVolume");
    }
}

