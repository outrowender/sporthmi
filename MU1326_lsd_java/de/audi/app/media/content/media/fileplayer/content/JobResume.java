/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobResume
extends AbstractFilePlayerJob {
    private static final String LOGCLASS = "JobResume";

    public JobResume(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "RESUME", iFilePlayer);
    }

    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.logger.log(1000000, "[%1.start] Player paused. Resume it.", (Object)LOGCLASS);
                this.getPlayer().resume();
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

