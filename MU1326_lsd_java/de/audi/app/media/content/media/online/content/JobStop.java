/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobStop
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobStop";

    public JobStop(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "STOP", iOnlinePlayer);
    }

    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.logger.log(1000000, "[%1.start] Playing. Stop it.", (Object)LOGCLASS);
                this.getPlayer().stop();
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
            case 11: {
                this.getPlayer().getState().getActiveSession().updateState(6);
                this.getExecutionContext().jobFinished();
                break;
            }
            case 4: {
                this.getPlayer().getState().getActiveSession().updateState(7);
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

