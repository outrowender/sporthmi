/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobPause
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS;

    public JobPause(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "PAUSE", iOnlinePlayer);
    }

    @Override
    public void start() {
        this.logger.log(14808325, "[%1.start]", (Object)"JobPause");
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.logger.log(1078071040, "[%1.start] Player playing. Pause it.", (Object)"JobPause");
                this.getPlayer().pause();
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.start] Wrong state. Ingore.", (Object)"JobPause");
                this.getExecutionContext().jobFinished();
            }
        }
    }

    @Override
    public void onPlaybackStateChanged() {
        this.logger.log(14808325, "[%1.onPlaybackStateChanged]", (Object)"JobPause");
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 4: 
            case 5: 
            case 11: {
                this.setSessionPlaybackState();
                this.getExecutionContext().jobFinished();
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.onPlaybackStateChanged] Waiting for playback state.", (Object)"JobPause");
            }
        }
    }

    @Override
    public void onPlayerError(int n) {
        this.logger.log(14808325, "[%1.onPlayerError]", (Object)"JobPause");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

