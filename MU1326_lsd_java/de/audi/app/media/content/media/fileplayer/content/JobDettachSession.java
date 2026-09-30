/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerListener;
import de.audi.atip.log.LogChannel;

public class JobDettachSession
extends AbstractFilePlayerJob {
    private static final String LOGCLASS = "JobDettachSession";
    private final IFilePlayerListener listener;

    public JobDettachSession(LogChannel logChannel, IFilePlayer iFilePlayer, IFilePlayerListener iFilePlayerListener) {
        super(logChannel, "DETACH", iFilePlayer);
        this.listener = iFilePlayerListener;
    }

    public void start() {
        FilePlayerSession filePlayerSession = this.getPlayer().getState().getActiveSession();
        if (filePlayerSession == null) {
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
        this.getPlayer().getAudioManager().resumeAudio(false);
        this.getPlayer().getAudioManager().releaseAudio();
        this.getPlayer().getState().setActiveSession(null);
        this.listener.sessionDettached();
        this.getExecutionContext().jobFinished();
    }

    public void onPlaybackStateChanged() {
        if (this.getPlayer().getState().getPlaybackState() != 4) {
            this.logger.log(1000000, "[%1.onPlaybackStateChanged] Wait that the player is stopped.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.onPlaybackStateChanged] Player stopped.", (Object)LOGCLASS);
        this.finishJob();
    }
}

