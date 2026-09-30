/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.IOnlinePlayerListener;
import de.audi.atip.log.LogChannel;

public class JobDettachSession
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobDettachSession";
    private final IOnlinePlayerListener listener;

    public JobDettachSession(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, IOnlinePlayerListener iOnlinePlayerListener) {
        super(logChannel, "DETACH", iOnlinePlayer);
        this.listener = iOnlinePlayerListener;
    }

    public void start() {
        this.logger.log(100000000, "[%1.start]", (Object)LOGCLASS);
        OnlinePlayerSession onlinePlayerSession = this.getPlayer().getState().getActiveSession();
        if (onlinePlayerSession == null) {
            this.logger.log(1000000, "[%1.start] No session active.", (Object)LOGCLASS);
            this.getExecutionContext().jobFinished();
            return;
        }
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 1: 
            case 2: 
            case 4: 
            case 11: {
                this.logger.log(1000000, "[%1.start] Player already stopped.", (Object)LOGCLASS);
                this.finishJob();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.start] Stop the player.", (Object)LOGCLASS);
                this.getPlayer().stop();
            }
        }
    }

    private void finishJob() {
        this.getPlayer().getAudioManager().requestVolumelock("Online player detach session");
        this.getPlayer().getState().setActiveSession(null);
        this.listener.sessionDettached();
        this.getExecutionContext().jobFinished();
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
        if (this.getPlayer().getState().getPlaybackState() != 4) {
            this.logger.log(1000000, "[%1.onPlaybackStateChanged] Wait that the player is stopped.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.onPlaybackStateChanged] Player stopped.", (Object)LOGCLASS);
        this.finishJob();
    }
}

