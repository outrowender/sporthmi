/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.content.media.fileplayer.content.VideoScaling;
import de.audi.atip.log.LogChannel;

public class JobPlayURL
extends AbstractFilePlayerJob {
    private static final String LOGCLASS;
    private static final int STATE_STOP_PLAYER;
    private static final int STATE_WAITFOR_STOP;
    private static final int STATE_PLAYER_STOPPED;
    private static final int STATE_SET_URL;
    private static final int STATE_WAITFOR_URL;
    private static final int STATE_RECEIVED_URL;
    private static final int STATE_WAITFOR_READY_TO_PLAY;
    private static final int STATE_WAITFOR_PLAYMODE;
    private static final int STATE_PLAYMODE_SET;
    private static final int STATE_WAITFOR_PLAYING;
    private static final int STATE_FINISH;
    private final String url;
    private final boolean repeat;
    private int state;

    public JobPlayURL(LogChannel logChannel, IFilePlayer iFilePlayer, String string, boolean bl) {
        super(logChannel, "PLAYURL", iFilePlayer);
        this.url = string;
        this.repeat = bl;
    }

    @Override
    public void start() {
        this.logger.log(14808325, "[%1.start]", (Object)"JobPlayURL");
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        block0 : switch (this.state) {
            case 1: {
                this.logger.log(1078071040, "[%1.setState] STATE_STOP_PLAYER", (Object)"JobPlayURL");
                switch (this.getPlayer().getState().getPlaybackState()) {
                    case 2: 
                    case 4: 
                    case 11: {
                        this.logger.log(1078071040, "[%1.start] Player ready for new URI.", (Object)"JobPlayURL");
                        this.setState(3);
                        break block0;
                    }
                }
                this.logger.log(1078071040, "[%1.start] Player not ready. Try to stop it.", (Object)"JobPlayURL");
                this.getPlayer().stop();
                this.setState(2);
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setState] STATE_PLAYER_STOPPED", (Object)"JobPlayURL");
                if (this.getPlayer().getState().getActiveSlot().getCapabilities().isPlaymodes()) {
                    int n2 = this.getPlayer().getState().getPlaybackMode();
                    if (this.repeat && n2 != this.getPlayer().getState().getRepeatPlayMode()) {
                        this.logger.log(1078071040, "[%1.setState] File repeat must be activated.", (Object)"JobPlayURL");
                        this.getPlayer().setPlaybackMode(this.getPlayer().getState().getRepeatPlayMode());
                        this.setState(8);
                        return;
                    }
                    if (!this.repeat && n2 != this.getPlayer().getState().getNormalPlayMode()) {
                        this.logger.log(1078071040, "[%1.setState] File repeat must be disabled.", (Object)"JobPlayURL");
                        this.getPlayer().setPlaybackMode(this.getPlayer().getState().getNormalPlayMode());
                        this.setState(8);
                        return;
                    }
                    this.logger.log(1078071040, "[%1.setState] No playmode change necessary.", (Object)"JobPlayURL");
                } else {
                    this.logger.log(1078071040, "[%1.setState] No playmodes supported.", (Object)"JobPlayURL");
                }
                this.setState(4);
                break;
            }
            case 8: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_PLAYMODE", (Object)"JobPlayURL");
                break;
            }
            case 9: {
                this.logger.log(1078071040, "[%1.setState] STATE_PLAYMODE_SET", (Object)"JobPlayURL");
                this.setState(4);
                break;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.setState] STATE_SET_URL", (Object)"JobPlayURL");
                this.getPlayer().setPlaybackURL(this.url);
                this.setState(5);
                break;
            }
            case 5: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_URL", (Object)"JobPlayURL");
                break;
            }
            case 6: {
                this.logger.log(1078071040, "[%1.setState] STATE_RECEIVED_URL", (Object)"JobPlayURL");
                this.setState(7);
                break;
            }
            case 7: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_READY_TO_PLAY", (Object)"JobPlayURL");
                break;
            }
            case 10: {
                this.logger.log(1078071040, "[%1.setState] STATE_WAITFOR_PLAYING", (Object)"JobPlayURL");
                break;
            }
            case 11: {
                this.logger.log(1078071040, "[%1.setState] STATE_FINISH", (Object)"JobPlayURL");
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    @Override
    public void onPlaybackModeChanged() {
        this.logger.log(14808325, "[%1.onPlaybackModeChanged]", (Object)"JobPlayURL");
        if (this.state == 8) {
            this.setState(9);
        }
    }

    @Override
    public void onResponsePlaybackURL() {
        this.logger.log(14808325, "[%1.onResponsePlaybackURL]", (Object)"JobPlayURL");
        if (this.state == 5) {
            this.setState(6);
        }
    }

    @Override
    public void onPlaybackStateChanged() {
        this.logger.log(14808325, "[%1.onPlaybackStateChanged]", (Object)"JobPlayURL");
        switch (this.state) {
            case 2: {
                if (this.getPlayer().getState().getPlaybackState() == 4) {
                    this.setState(3);
                }
                return;
            }
            case 7: {
                if (this.getPlayer().getState().getPlaybackState() != 1) {
                    if (this.getPlayer().getState().getPlaybackState() != 11) break;
                    this.logger.log(1078071040, "[%1.onPlaybackStateChanged] Error.", (Object)"JobPlayURL");
                    this.setSessionPlaybackState();
                    this.setState(11);
                    break;
                }
                this.setVideoScaling();
                if (this.getPlayer().getState().getAudioState().isAudible()) {
                    this.logger.log(1078071040, "[%1.onPlaybackStateChanged] Audible. Resume playback.", (Object)"JobPlayURL");
                    this.getPlayer().resume();
                } else {
                    this.logger.log(1078071040, "[%1.onPlaybackStateChanged] Not audible. Pause playback.", (Object)"JobPlayURL");
                    this.getPlayer().pause();
                }
                this.setState(10);
                break;
            }
            case 10: {
                this.setSessionPlaybackState();
                this.setState(11);
                break;
            }
        }
    }

    private void setVideoScaling() {
        VideoScaling videoScaling = this.getPlayer().getState().getVideoScaling();
        if (videoScaling != null) {
            this.logger.log(1078071040, "[%1.setVideoScaling] Change video scaling.", (Object)"JobPlayURL");
            this.getPlayer().getState().setVideoScaling(null);
            this.getPlayer().setVideoScaling(videoScaling.getX(), videoScaling.getY(), videoScaling.getWidth(), videoScaling.getHeight());
        }
    }

    @Override
    public void onPlayerError(int n) {
        this.logger.log(14808325, "[%1.onPlayerError]", (Object)"JobPlayURL");
        this.getExecutionContext().jobFinished();
    }
}

