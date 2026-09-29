/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio.drawer;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$SourceAudioState;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullAudioDrawerContext
extends NullService
implements AudioDrawerContext {
    public NullAudioDrawerContext(LogChannel logChannel) {
        super(logChannel, "AudioDrawerContext");
    }

    @Override
    public void setContext(AudioDrawerContext$Source audioDrawerContext$Source, AudioDrawerContext$SourceAudioState audioDrawerContext$SourceAudioState) {
        this.log();
    }
}

