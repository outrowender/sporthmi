/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobPause
extends AbstractFilePlayerJob {
    private static final String LOGCLASS = "JobPause";

    public JobPause(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "PAUSE", iFilePlayer);
    }

    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.logger.log(1000000, "[%1.start] Player playing. Pause it.", (Object)LOGCLASS);
                this.getPlayer().pause();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.start] Wrong state. Ingore.", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
            }
        }
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
        this.setSessionPlaybackState();
        this.getExecutionContext().jobFinished();
    }
}

