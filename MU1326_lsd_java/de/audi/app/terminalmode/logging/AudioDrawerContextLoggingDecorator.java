/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
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

    public void setContext(AudioDrawerContext.Source source, AudioDrawerContext.SourceAudioState sourceAudioState) {
        this.logger.log(this.level, "-> [AudioDrawerContext.setContext] %1 %2", (Object)source.toString(), (Object)sourceAudioState.toString());
        this.wrappee.setContext(source, sourceAudioState);
    }
}

