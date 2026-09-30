/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobSeek
extends AbstractFilePlayerJob {
    private static final String LOGCLASS = "JobSeek";
    private final boolean forward;
    private final IAudioManager audioManager;

    public JobSeek(LogChannel logChannel, IFilePlayer iFilePlayer, IAudioManager iAudioManager, boolean bl) {
        super(logChannel, "SEEK", iFilePlayer);
        this.forward = bl;
        this.audioManager = iAudioManager;
    }

    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 5: {
                this.logger.log(1000000, "[%1.start] Do seek.", (Object)LOGCLASS);
                this.getPlayer().seek(this.forward);
                break;
            }
            case 7: 
            case 9: {
                if (!this.forward) {
                    this.logger.log(1000000, "[%1.start] Already on backward seek.", (Object)LOGCLASS);
                    this.getExecutionContext().jobFinished();
                }
                this.getPlayer().seek(this.forward);
                return;
            }
            case 6: 
            case 8: {
                if (this.forward) {
                    this.logger.log(1000000, "[%1.start] Already on forward seeking.", (Object)LOGCLASS);
                    this.getExecutionContext().jobFinished();
                }
                this.getPlayer().seek(this.forward);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.start] Wrong state.", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
            }
        }
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                if (this.getPlayer().getState().getAudioState().isAudible()) break;
                this.audioManager.resumeAudio(false);
                break;
            }
        }
        this.setSessionPlaybackState();
        this.getExecutionContext().jobFinished();
    }
}

