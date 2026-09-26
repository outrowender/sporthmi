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
    private static final String LOGCLASS;
    private final boolean forward;
    private final IAudioManager audioManager;

    public JobSeek(LogChannel logChannel, IFilePlayer iFilePlayer, IAudioManager iAudioManager, boolean bl) {
        super(logChannel, "SEEK", iFilePlayer);
        this.forward = bl;
        this.audioManager = iAudioManager;
    }

    @Override
    public void start() {
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 5: {
                this.logger.log(1078071040, "[%1.start] Do seek.", (Object)"JobSeek");
                this.getPlayer().seek(this.forward);
                break;
            }
            case 7: 
            case 9: {
                if (!this.forward) {
                    this.logger.log(1078071040, "[%1.start] Already on backward seek.", (Object)"JobSeek");
                    this.getExecutionContext().jobFinished();
                }
                this.getPlayer().seek(this.forward);
                return;
            }
            case 6: 
            case 8: {
                if (this.forward) {
                    this.logger.log(1078071040, "[%1.start] Already on forward seeking.", (Object)"JobSeek");
                    this.getExecutionContext().jobFinished();
                }
                this.getPlayer().seek(this.forward);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.start] Wrong state.", (Object)"JobSeek");
                this.getExecutionContext().jobFinished();
            }
        }
    }

    @Override
    public void onPlaybackStateChanged() {
        this.logger.log(14808325, "[%1.onPlaybackStateChanged]", (Object)"JobSeek");
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

