/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobSkip
extends AbstractFilePlayerJob {
    private final int count;
    private final IAudioManager audioManager;

    public JobSkip(LogChannel logChannel, IFilePlayer iFilePlayer, IAudioManager iAudioManager, int n) {
        super(logChannel, "SKIP", iFilePlayer);
        this.count = n;
        this.audioManager = iAudioManager;
    }

    @Override
    public void start() {
        this.getPlayer().skip(this.count);
        this.audioManager.resumeAudio(true);
        this.getExecutionContext().jobFinished();
    }
}

