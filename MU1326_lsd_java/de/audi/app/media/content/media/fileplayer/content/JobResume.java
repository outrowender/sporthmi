/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobResume
extends AbstractFilePlayerJob {
    private static final String LOGCLASS;

    public JobResume(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "RESUME", iFilePlayer);
    }

    @Override
    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.logger.log(1078071040, "[%1.start] Player paused. Resume it.", (Object)"JobResume");
                this.getPlayer().resume();
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.start] Wrong state. Ingore.", (Object)"JobResume");
                this.getExecutionContext().jobFinished();
            }
        }
    }

    @Override
    public void onPlaybackStateChanged() {
        this.logger.log(14808325, "[%1.onPlaybackStateChanged]", (Object)"JobResume");
        this.setSessionPlaybackState();
        this.getExecutionContext().jobFinished();
    }
}

