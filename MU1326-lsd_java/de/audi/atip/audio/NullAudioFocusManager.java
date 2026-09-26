/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.audio;

import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAudioFocusManager
extends NullService
implements IAudioFocusManager {
    public NullAudioFocusManager(LogChannel logChannel) {
        super(logChannel, "NullAudioFocusManager");
    }

    @Override
    public void setActiveAudioApp(int n, int n2) {
        this.log();
    }
}

