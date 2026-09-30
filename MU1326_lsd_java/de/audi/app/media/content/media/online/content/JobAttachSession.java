/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;
import de.audi.app.media.content.media.online.content.OnlinePlayerState;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class JobAttachSession
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobAttachSession";
    private final OnlinePlayerSession session;
    private static final int STATE_WAITFOR_AUDIO = 1;
    private static final int STATE_AUDIO_READY = 2;
    private static final int STATE_STOP_PLAYER = 3;
    private static final int STATE_WAITFOR_STOP = 4;
    private static final int STATE_PLAYER_STOPPED = 5;
    private static final int STATE_SET_URL = 6;
    private static final int STATE_WAITFOR_URL = 7;
    private static final int STATE_RECEIVED_URL = 8;
    private static final int STATE_WAITFOR_READY_TO_PLAY = 9;
    private static final int STATE_WAITFOR_PLAYING = 10;
    private static final int STATE_FINISH = 11;
    private int state;

    public JobAttachSession(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, OnlinePlayerSession onlinePlayerSession) {
        super(logChannel, "ATTACH", iOnlinePlayer);
        this.session = onlinePlayerSession;
    }

    public void start() {
        this.setState(1);
    }

    private void setState(int n) {
        this.state = n;
        switch (this.state) {
            case 1: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_AUDIO", (Object)LOGCLASS);
                this.requestAudioConnection();
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.setState] STATE_AUDIO_READY", (Object)LOGCLASS);
                this.getPlayer().getState().setActiveSession(this.session);
                this.setState(3);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setState] STATE_STOP_PLAYER", (Object)LOGCLASS);
                if (this.getPlayer().getState().isOnPlayback()) {
                    this.logger.log(1000000, "[%1.setState] Player not ready. Try to stop it.", (Object)LOGCLASS);
                    this.getPlayer().stop();
                    this.setState(4);
                    break;
                }
                this.logger.log(1000000, "[%1.setState] Player ready for new URI.", (Object)LOGCLASS);
                this.setState(5);
                break;
            }
            case 5: {
                this.logger.log(1000000, "[%1.setState] STATE_PLAYER_STOPPED", (Object)LOGCLASS);
                this.setState(6);
                break;
            }
            case 6: {
                this.logger.log(1000000, "[%1.setState] STATE_SET_URL", (Object)LOGCLASS);
                this.getPlayer().setPlaybackURL(this.session.getUrl());
                this.setState(7);
                break;
            }
            case 7: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_URL", (Object)LOGCLASS);
                break;
            }
            case 8: {
                this.logger.log(1000000, "[%1.setState] STATE_RECEIVED_URL", (Object)LOGCLASS);
                this.setState(9);
                break;
            }
            case 9: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_READY_TO_PLAY", (Object)LOGCLASS);
                break;
            }
            case 10: {
                this.logger.log(1000000, "[%1.setState] STATE_WAITFOR_PLAYING", (Object)LOGCLASS);
                break;
            }
            case 11: {
                this.logger.log(1000000, "[%1.setState] STATE_FINISH", (Object)LOGCLASS);
                if (this.getPlayer().getAudioManager().hasAudioFocus()) {
                    this.session.onActive(new MediaOnlineSessionPlayerImpl(this.logger, this.session, this.getPlayer()));
                } else {
                    this.session.onSuspend();
                }
                OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
                this.session.updateBufferState(onlinePlayerState.getBufferState(), onlinePlayerState.getBufferFillInfoPrecent());
                this.session.updateCapabilities(onlinePlayerState.isSkipSupported(), onlinePlayerState.isSeekSupported(), onlinePlayerState.supportsPlaybackModes(), onlinePlayerState.supportsPlaybackModes(), onlinePlayerState.getCapabilitites().isPlayTime(), onlinePlayerState.getCapabilitites().isTotalPlaytime());
                this.getPlayer().notifyAudioSettings();
                this.getExecutionContext().jobFinished();
                break;
            }
        }
    }

    private void requestAudioConnection() {
        this.logger.log(1000000, "[%1.requestAudioConnection]", (Object)LOGCLASS);
        if (this.getPlayer().getState().getAudioState().getConnection() != this.session.getAudioConnection()) {
            this.logger.log(1000000, "[%1.requestAudioConnection] Request new audio connection.", (Object)LOGCLASS);
            this.getPlayer().getAudioManager().requestAudio(this.session.getAudioConnection(), true);
            this.getPlayer().getAudioManager().resumeAudio(true);
            if (this.getPlayer().getAudioManager().hasAudioFocus()) {
                this.getPlayer().getAudioManager().requestVolumelock("Online player attach session");
                return;
            }
        }
        this.setState(2);
        this.logger.log(1000000, "[%1.requestAudioConnection] Audio connection available.", (Object)LOGCLASS);
    }

    public void onAudioStateChanged() {
        this.logger.log(100000000, "[%1.onAudioStateChanged]", (Object)LOGCLASS);
        if (this.state == 1) {
            if (this.getPlayer().getState().getAudioState().getConnection() != this.session.getAudioConnection()) {
                this.logger.log(1000000, "[%1.onAudioStateChanged] Not the audio connection for the session.", (Object)LOGCLASS);
                return;
            }
            this.setState(2);
        }
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
        switch (this.state) {
            case 4: {
                if (this.getPlayer().getState().getPlaybackState() == 4) {
                    this.setState(5);
                }
                return;
            }
            case 9: {
                if (this.getPlayer().getState().getPlaybackState() != 1) break;
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

    public void onResponsePlaybackURL() {
        this.logger.log(100000000, "[%1.onResponsePlaybackURL]", (Object)LOGCLASS);
        if (this.state == 7) {
            this.setState(8);
        }
    }

    public void onPlayerError(int n) {
        this.logger.log(100000000, "[%1.onPlayerError]", (Object)LOGCLASS);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.session.getServiceID());
        buffer.append(",").append(this.session.getUrl());
        return buffer.toString();
    }
}

