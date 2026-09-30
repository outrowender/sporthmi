/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobResume
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobResume";

    public JobResume(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "RESUME", iOnlinePlayer);
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

    public void onPlayerError(int n) {
        this.logger.log(100000000, "[%1.onPlayerError]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

