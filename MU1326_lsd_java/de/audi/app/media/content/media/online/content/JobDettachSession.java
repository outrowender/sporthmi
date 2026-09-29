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
    private static final String LOGCLASS;
    private final IOnlinePlayerListener listener;

    public JobDettachSession(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, IOnlinePlayerListener iOnlinePlayerListener) {
        super(logChannel, "DETACH", iOnlinePlayer);
        this.listener = iOnlinePlayerListener;
    }

    @Override
    public void start() {
        this.logger.log(14808325, "[%1.start]", (Object)"JobDettachSession");
        OnlinePlayerSession onlinePlayerSession = this.getPlayer().getState().getActiveSession();
        if (onlinePlayerSession == null) {
            this.logger.log(1078071040, "[%1.start] No session active.", (Object)"JobDettachSession");
            this.getExecutionContext().jobFinished();
            return;
        }
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 1: 
            case 2: 
            case 4: 
            case 11: {
                this.logger.log(1078071040, "[%1.start] Player already stopped.", (Object)"JobDettachSession");
                this.finishJob();
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.start] Stop the player.", (Object)"JobDettachSession");
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

    @Override
    public void onPlaybackStateChanged() {
        this.logger.log(14808325, "[%1.onPlaybackStateChanged]", (Object)"JobDettachSession");
        if (this.getPlayer().getState().getPlaybackState() != 4) {
            this.logger.log(1078071040, "[%1.onPlaybackStateChanged] Wait that the player is stopped.", (Object)"JobDettachSession");
            return;
        }
        this.logger.log(1078071040, "[%1.onPlaybackStateChanged] Player stopped.", (Object)"JobDettachSession");
        this.finishJob();
    }
}

