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
    private static final String LOGCLASS = "JobPlayURL";
    private static final int STATE_STOP_PLAYER = 1;
    private static final int STATE_WAITFOR_STOP = 2;
    private static final int STATE_PLAYER_STOPPED = 3;
    private static final int STATE_SET_URL = 4;
    private static final int STATE_WAITFOR_URL = 5;
    private static final int STATE_RECEIVED_URL = 6;
    private static final int STATE_WAITFOR_READY_TO_PLAY = 7;
    private static final int STATE_WAITFOR_PLAYMODE = 8;
    private static final int STATE_PLAYMODE_SET = 9;
    private static final int STATE_WAITFOR_PLAYING = 10;
    private static final int STATE_FINISH = 11;
    private final String url;
    private final boolean repeat;
    private int state;

    public JobPlayURL(LogChannel logChannel, IFilePlayer iFilePlayer, String string, boolean bl) {
        super(logChannel, "PLAYURL", iFilePlayer);
        this.url = string;
        this.repeat = bl;
    }

    public void start() {
        this.logger.log(100000000, "[%1.start]", (Object)LOGCLASS);
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        block0 : switch (this.state) {
            case 1: {
                this.logger.log(1000000, "[%1.setState] STATE_STOP_PLAYER", (Object)LOGCLASS);
                switch (this.getPlayer().getState().getPlaybackState()) {
                    case 2: 
                    case 4: 
                    case 11: {
                        this.logger.log(1000000, "[%1.start] Player ready for new URI.", (Object)LOGCLASS);
                        this.setState(3);
                        break block0;
                    }
                }
                this.logger.log(1000000, "[%1.start] Player not ready. Try to stop it.", (Object)LOGCLASS);
                this.getPlayer().stop();
                this.setState(2);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setState] STATE_PLAYER_STOPPED", (Object)LOGCLASS);
                if (this.getPlayer().getState().getActiveSlot().getCapabilities().isPlaymodes()) {
                    int n2 = this.getPlayer().getState().getPlaybackMode();
                    if (this.repeat && n2 != this.getPlayer().getState().getRepeatPlayMode()) {
                        this.logger.log(1000000, "[%1.setState] File repeat must be activated.", (Object)LOGCLASS);
                        this.getPlayer().setPlaybackMode(this.getPlayer().getState().getRepeatPlayMode());
                        this.setState(8);
                        return;
                    }
                    if (!this.repeat && n2 != this.getPlayer().getState().getNormalPlayMode()) {
                        this.logger.log(1000000, "[%1.setState] File repeat must be disabled.", (Object)LOGCLASS);
                        this.getPlayer().setPlaybackMode(this.getPlayer().getState().getNormalPlayMode());
                        this.setState(8);
                        return;
                    }
                    this.logger.log(1000000, "[%1.setState] No playmode change necessary.", (Object)LOGCLASS);
                } else {
                    this.logger.log(1000000, "[%1.setState] No playmodes supported.", (Object)LOGCLASS);
                }
                this.setState(4);
                break;
            }
            case 8: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_PLAYMODE", (Object)LOGCLASS);
                break;
            }
            case 9: {
                this.logger.log(1000000, "[%1.setState] STATE_PLAYMODE_SET", (Object)LOGCLASS);
                this.setState(4);
                break;
            }
            case 4: {
                this.logger.log(1000000, "[%1.setState] STATE_SET_URL", (Object)LOGCLASS);
                this.getPlayer().setPlaybackURL(this.url);
                this.setState(5);
                break;
            }
            case 5: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_URL", (Object)LOGCLASS);
                break;
            }
            case 6: {
                this.logger.log(1000000, "[%1.setState] STATE_RECEIVED_URL", (Object)LOGCLASS);
                this.setState(7);
                break;
            }
            case 7: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_READY_TO_PLAY", (Object)LOGCLASS);
                break;
            }
            case 10: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_PLAYING", (Object)LOGCLASS);
                break;
            }
            case 11: {
                this.logger.log(1000000, "[%1.setState] STATE_FINISH", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    public void onPlaybackModeChanged() {
        this.logger.log(100000000, "[%1.onPlaybackModeChanged]", (Object)LOGCLASS);
        if (this.state == 8) {
            this.setState(9);
        }
    }

    public void onResponsePlaybackURL() {
        this.logger.log(100000000, "[%1.onResponsePlaybackURL]", (Object)LOGCLASS);
        if (this.state == 5) {
            this.setState(6);
        }
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
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
                    this.logger.log(1000000, "[%1.onPlaybackStateChanged] Error.", (Object)LOGCLASS);
                    this.setSessionPlaybackState();
                    this.setState(11);
                    break;
                }
                this.setVideoScaling();
                if (this.getPlayer().getState().getAudioState().isAudible()) {
                    this.logger.log(1000000, "[%1.onPlaybackStateChanged] Audible. Resume playback.", (Object)LOGCLASS);
                    this.getPlayer().resume();
                } else {
                    this.logger.log(1000000, "[%1.onPlaybackStateChanged] Not audible. Pause playback.", (Object)LOGCLASS);
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
            this.logger.log(1000000, "[%1.setVideoScaling] Change video scaling.", (Object)LOGCLASS);
            this.getPlayer().getState().setVideoScaling(null);
            this.getPlayer().setVideoScaling(videoScaling.getX(), videoScaling.getY(), videoScaling.getWidth(), videoScaling.getHeight());
        }
    }

    public void onPlayerError(int n) {
        this.logger.log(100000000, "[%1.onPlayerError]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }
}

