/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobSeek
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS;
    private final boolean forward;

    public JobSeek(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, boolean bl) {
        super(logChannel, "SEEK", iOnlinePlayer);
        this.forward = bl;
    }

    @Override
    public void start() {
        if (!this.getPlayer().getState().isSeekSupported()) {
            this.logger.log(1078071040, "[%1.start] Seek not supported.", (Object)"JobSeek");
            return;
        }
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 5: {
                this.logger.log(1078071040, "[%1.start] Seek", (Object)"JobSeek");
                this.getPlayer().seek(this.forward);
                break;
            }
            case 7: 
            case 9: {
                if (!this.forward) {
                    this.logger.log(1078071040, "[%1.start] Already on backward seek.", (Object)"JobSeek");
                    this.getExecutionContext().jobFinished();
                }
                this.logger.log(1078071040, "[%1.start] Switch seek mode to forward.", (Object)"JobSeek");
                this.getPlayer().seek(this.forward);
                break;
            }
            case 6: 
            case 8: {
                if (this.forward) {
                    this.logger.log(1078071040, "[%1.start] Already on forward seeking.", (Object)"JobSeek");
                    this.getExecutionContext().jobFinished();
                }
                this.logger.log(1078071040, "[%1.start] Switch seek mode to backward.", (Object)"JobSeek");
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
                if (!this.getPlayer().getState().getAudioState().isAudible()) {
                    this.getPlayer().getAudioManager().resumeAudio(false);
                }
                this.getPlayer().getState().getActiveSession().updateState(4);
                this.getExecutionContext().jobFinished();
                break;
            }
            default: {
                this.setSessionPlaybackState();
                this.getExecutionContext().jobFinished();
            }
        }
    }

    @Override
    public void onPlayerError(int n) {
        this.logger.log(14808325, "[%1.onPlayerError]", (Object)"JobSeek");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

