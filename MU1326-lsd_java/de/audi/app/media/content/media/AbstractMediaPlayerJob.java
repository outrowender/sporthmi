/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;

public abstract class AbstractMediaPlayerJob
extends AbstractQueueJob {
    protected final LogChannel logger;
    protected final AbstractMediaPlayer player;

    public AbstractMediaPlayerJob(LogChannel logChannel, AbstractMediaPlayer abstractMediaPlayer) {
        this.logger = logChannel;
        this.player = abstractMediaPlayer;
    }

    public void responseSetPlaySelection(boolean bl) {
    }

    public void notifyPlayPosition() {
    }
}

