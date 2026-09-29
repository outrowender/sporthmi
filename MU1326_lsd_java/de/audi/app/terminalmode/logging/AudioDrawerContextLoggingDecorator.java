/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$SourceAudioState;
import de.audi.atip.log.LogChannel;

public class AudioDrawerContextLoggingDecorator
implements AudioDrawerContext {
    private AudioDrawerContext wrappee;
    private final LogChannel logger;
    private final int level;

    public AudioDrawerContextLoggingDecorator(AudioDrawerContext audioDrawerContext, LogChannel logChannel, int n) {
        this.wrappee = audioDrawerContext;
        this.logger = logChannel;
        this.level = n;
    }

    @Override
    public void setContext(AudioDrawerContext$Source audioDrawerContext$Source, AudioDrawerContext$SourceAudioState audioDrawerContext$SourceAudioState) {
        this.logger.log(this.level, "-> [AudioDrawerContext.setContext] %1 %2", (Object)audioDrawerContext$Source.toString(), (Object)audioDrawerContext$SourceAudioState.toString());
        this.wrappee.setContext(audioDrawerContext$Source, audioDrawerContext$SourceAudioState);
    }
}

