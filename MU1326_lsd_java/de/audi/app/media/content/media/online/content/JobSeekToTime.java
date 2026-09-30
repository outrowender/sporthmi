/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobSeekToTime
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobSeekToTime";
    private final int timePosition;

    public JobSeekToTime(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, int n) {
        super(logChannel, "SEEK_TO_TIME", iOnlinePlayer);
        this.timePosition = n;
    }

    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                int n = this.timePosition < 0 ? 0 : (this.timePosition > this.getPlayer().getState().getCurrentPlayTime().getTotalTimeOfTrack() ? this.getPlayer().getState().getCurrentPlayTime().getTotalTimeOfTrack() : this.timePosition);
                this.logger.log(1000000, "[%1.start] seekToTime. ", (Object)LOGCLASS);
                this.getPlayer().setPlayposition(this.getPlayer().getState().getCurrentEntryId(), n);
                this.getExecutionContext().jobFinished();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.start] Wrong state.", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
            }
        }
    }

    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

