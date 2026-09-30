/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobPause
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobPause";

    public JobPause(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "PAUSE", iOnlinePlayer);
    }

    public void start() {
        this.logger.log(100000000, "[%1.start]", (Object)LOGCLASS);
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
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 4: 
            case 5: 
            case 11: {
                this.setSessionPlaybackState();
                this.getExecutionContext().jobFinished();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.onPlaybackStateChanged] Waiting for playback state.", (Object)LOGCLASS);
            }
        }
    }

    public void onPlayerError(int n) {
        this.logger.log(100000000, "[%1.onPlayerError]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

