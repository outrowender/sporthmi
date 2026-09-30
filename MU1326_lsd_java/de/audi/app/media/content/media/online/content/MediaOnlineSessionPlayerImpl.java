/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.JobResume;
import de.audi.app.media.content.media.online.content.JobSeek;
import de.audi.app.media.content.media.online.content.JobSeekToTime;
import de.audi.app.media.content.media.online.content.JobSetPlaybackMode;
import de.audi.app.media.content.media.online.content.JobSkip;
import de.audi.app.media.content.media.online.content.JobStop;
import de.audi.atip.interapp.media.IMediaOnlineSessionPlayer;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class MediaOnlineSessionPlayerImpl
implements IMediaOnlineSessionPlayer {
    private static final String LOGCLASS = "MediaOnlineSessionPlayerImpl";
    private final LogChannel logger;
    private final OnlinePlayerSession session;
    private final IOnlinePlayer player;

    public MediaOnlineSessionPlayerImpl(LogChannel logChannel, OnlinePlayerSession onlinePlayerSession, IOnlinePlayer iOnlinePlayer) {
        this.logger = logChannel;
        this.session = onlinePlayerSession;
        this.player = iOnlinePlayer;
    }

    public void resume() {
        this.logger.log(1000000, "[%1.resume] [%2]", (Object)LOGCLASS, (Object)this.session);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.resume"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onResume] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                if (MediaOnlineSessionPlayerImpl.this.player.getState().getAudioState().isAudible()) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onResume] [%2] Already hearable.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    if (MediaOnlineSessionPlayerImpl.this.player.getState().isOnSeeking()) {
                        MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onResume] [%2] On seeking. Resume playback.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                        MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobResume(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player));
                    }
                }
                MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onResume] [%2] Try to resume audio.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                MediaOnlineSessionPlayerImpl.this.player.getAudioManager().resumeAudio(false);
            }
        });
    }

    public void pause() {
        this.logger.log(1000000, "[%1.pause] [%2]", (Object)LOGCLASS, (Object)this.session);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.pause"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onPause] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onPause] [%2] Mute audio.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                MediaOnlineSessionPlayerImpl.this.player.getAudioManager().mute();
            }
        });
    }

    public void stop() {
        this.logger.log(1000000, "[%1.stop] '%2'", (Object)LOGCLASS);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.stop"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onSeek] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobStop(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player));
            }
        });
    }

    public void seek(final boolean bl) {
        this.logger.log(1000000, "[%1.seek] [%2] '%3'", (Object)LOGCLASS, (Object)this.session, (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.seek"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onSeek] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobSeek(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player, bl));
            }
        });
    }

    public void updatePlayingTrack(final long l, final String string, final String string2, final String string3, final ResourceLocator resourceLocator) {
        if (this.logger.isDebug2()) {
            Buffer buffer = new Buffer();
            buffer.append("'").append(l).append("','").append(string).append("','").append(string2).append("','").append(string3).append("'");
            this.logger.log(100000000, "[%1.updatePlayingTrack] [%2] %3", (Object)LOGCLASS, (Object)this.session, (Object)buffer);
        }
        if (string == null || string2 == null || string3 == null) {
            throw new IllegalArgumentException();
        }
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.updatePlayingTrack"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onUpdatePlayingTrack] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.updatePlayingTrack(l, string, string2, string3, resourceLocator);
            }
        });
    }

    public void skip(final int n) {
        this.logger.log(1000000, "[%1.skip] [%2] '%3'", (Object)LOGCLASS, (Object)this.session, (long)n);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.skip"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.onSkip] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobSkip(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player, n));
            }
        });
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(LOGCLASS).append("[").append(this.session).append("]@").append(this.hashCode());
        return buffer.toString();
    }

    public void seekToTime(final int n) {
        this.logger.log(1000000, "[%1.seekToTime] [%2]", (Object)LOGCLASS, (Object)this.session);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.seekToTime"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.seekToTime] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobSeekToTime(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player, n));
            }
        });
    }

    public void setRepeatTitle(final boolean bl) {
        this.logger.log(1000000, "[%1.setRepeatTitle] [%2]", (Object)LOGCLASS, (Object)this.session);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.setRepeatTitle"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.setRepeatTitle] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobSetPlaybackMode(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player, MediaOnlineSessionPlayerImpl.this.player.getState().getPlayModeForRepeatMode(bl)));
            }
        });
    }

    public void setShuffle(final boolean bl) {
        this.logger.log(1000000, "[%1.setShuffle] [%2]", (Object)LOGCLASS, (Object)this.session);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.setShuffle"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.setShuffle] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.getPlayerQueue().enqueue(new JobSetPlaybackMode(MediaOnlineSessionPlayerImpl.this.logger, MediaOnlineSessionPlayerImpl.this.player, MediaOnlineSessionPlayerImpl.this.player.getState().getPlayModeForShuffleMode(bl)));
            }
        });
    }

    public void updateOnlineCoverart(final ResourceLocator resourceLocator) {
        this.logger.log(1000000, "[%1.updateOnlineCoverart] [%2]", (Object)LOGCLASS, (Object)this.session);
        this.player.getDispatcher().execute(new AbstractDispatcherRunnable("OnlinePlayer.updateOnlineCoverart"){

            public void run() {
                if (!MediaOnlineSessionPlayerImpl.this.session.equals(MediaOnlineSessionPlayerImpl.this.player.getState().getActiveSession())) {
                    MediaOnlineSessionPlayerImpl.this.logger.log(1000000, "[%1.updateOnlineCoverart] [%2] Session not active.", (Object)MediaOnlineSessionPlayerImpl.LOGCLASS, (Object)MediaOnlineSessionPlayerImpl.this.session);
                    return;
                }
                MediaOnlineSessionPlayerImpl.this.player.updateOnlineCoverArt(resourceLocator);
            }
        });
    }
}

