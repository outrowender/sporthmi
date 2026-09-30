/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.AbstractMediaContent;
import de.audi.app.media.content.media.HardKeyHandler;
import de.audi.app.media.content.media.HardKeyHandlerFilePlayer;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerAdapterImpl;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerStateImpl;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerListener;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerState;
import de.audi.app.media.content.media.fileplayer.content.JobActivation;
import de.audi.app.media.content.media.fileplayer.content.JobAttachSession;
import de.audi.app.media.content.media.fileplayer.content.JobDefault;
import de.audi.app.media.content.media.fileplayer.content.JobDettachSession;
import de.audi.app.media.content.media.fileplayer.content.JobPause;
import de.audi.app.media.content.media.fileplayer.content.JobPlayURL;
import de.audi.app.media.content.media.fileplayer.content.JobResume;
import de.audi.app.media.content.media.fileplayer.content.JobSeek;
import de.audi.app.media.content.media.fileplayer.content.JobSetVideoScale;
import de.audi.app.media.content.media.fileplayer.content.JobSkip;
import de.audi.app.media.content.media.fileplayer.content.JobStop;
import de.audi.app.media.dsi.media.AbstractMediaPlayerListener;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.PlaybackMode;

public class FilePlayerContent
extends AbstractMediaContent
implements IAudioStateListener,
IFilePlayer {
    private static final String LOGCLASS = "FilePlayerContent";
    private final IMediaDSIPlayerController dsiPlayer;
    private final IMediaPlayerListener playerListener;
    private final Queue filePlayerContentQueue = new Queue(this.getTerminal().getLogger().main(), "FILEPLAYERCONTENT");
    private final FilePlayerStateImpl filePlayerState;
    private final JobDefault DEFAULT_JOB;
    private final HardKeyHandler hardKeyHandler;
    private final FilePlayerAdapterImpl filePlayerAdapter = new FilePlayerAdapterImpl(this.logger.main(), this);

    public FilePlayerContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(7, iContentContext, iMediaTerminal);
        this.filePlayerState = new FilePlayerStateImpl();
        this.dsiPlayer = iMediaDSIPlayerController;
        this.hardKeyHandler = new HardKeyHandlerFilePlayer(iMediaTerminal, this.filePlayerAdapter);
        this.DEFAULT_JOB = new JobDefault(this.logger.main(), this);
        this.playerListener = new AbstractMediaPlayerListener(this.logger.main()){

            public String getLogClass() {
                return FilePlayerContent.LOGCLASS;
            }

            public void updateCapabilities(Capabilities capabilities) {
                FilePlayerContent.this.logger.main().log(1000000, "[%1.updateCapabilities]", (Object)FilePlayerContent.LOGCLASS);
                FilePlayerContent.this.filePlayerState.setCapabilities(capabilities);
                FilePlayerContent.this.getRunningJob().onCapabilitiesChanged();
            }

            public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
                int n = -1;
                int n2 = -1;
                for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
                    PlaybackMode playbackMode = playbackModeArray[i2];
                    if (playbackMode.getScope() != 1) continue;
                    if ((playbackMode.getModeFlag() & 1) == 1) {
                        n2 = playbackMode.getModeID();
                        continue;
                    }
                    n = playbackMode.getModeID();
                }
                FilePlayerContent.this.logger.main().log(1000000, "[%1.updatePlaybackModeList] normalMode='%2',repeatMode='%3'", (Object)FilePlayerContent.LOGCLASS, (long)n, (long)n2);
                FilePlayerContent.this.filePlayerState.setPlaymodes(n, n2);
                FilePlayerContent.this.getRunningJob().onPlaybackModeListChanged();
            }

            public void updatePlaybackMode(int n) {
                FilePlayerContent.this.logger.main().log(1000000, "[%1.updatePlaybackMode] '%2'", (Object)FilePlayerContent.LOGCLASS, (long)n);
                FilePlayerContent.this.filePlayerState.setPlaybackMode(n);
                FilePlayerContent.this.getRunningJob().onPlaybackModeChanged();
            }

            public void updatePlaybackState(int n) {
                FilePlayerContent.this.logger.main().log(1000000, "[%1.updatePlaybackState]", (Object)FilePlayerContent.LOGCLASS);
                FilePlayerContent.this.filePlayerState.setPlaybackState(n);
                FilePlayerContent.this.getRunningJob().onPlaybackStateChanged();
            }

            public void updatePlayPosition(long l, int n, int n2) {
                FilePlayerContent.this.getRunningJob().onUpdatePlayPosition(n, n2);
            }

            public void responseSetPlaybackURL(String string) {
                FilePlayerContent.this.logger.main().log(1000000, "[%1.responseSetPlaybackURL]", (Object)FilePlayerContent.LOGCLASS);
                FilePlayerContent.this.getRunningJob().onResponsePlaybackURL();
            }

            public void error(int n) {
                FilePlayerContent.this.logger.main().log(1000000, "[%1.error] '%2'", (Object)FilePlayerContent.LOGCLASS, (long)n);
                FilePlayerContent.this.getRunningJob().onPlayerError(n);
            }
        };
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
        super.activate(iActivationContext);
        this.filePlayerContentQueue.reset();
        this.dsiPlayer.setPlayerListener(this.playerListener);
        this.getTerminal().getAudioManager().addAudioContextListener(this);
        this.filePlayerState.reset();
        this.filePlayerState.setPlayerID((Integer)iActivationContext.getParameter("PHYSICAL_PLAYER_ID"));
        this.filePlayerState.setActiveSlot(iActivationContext.getSlot());
        this.hardKeyHandler.activate();
        this.filePlayerAdapter.activate();
        this.notifyContentActivationFinished();
        this.filePlayerContentQueue.enqueue(new JobActivation(this.logger.main(), this));
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.hardKeyHandler.deactivate();
        this.filePlayerAdapter.deactivate();
        this.dsiPlayer.setPlayerListener(null);
        this.getTerminal().getAudioManager().removeAudioContextListener(this);
        super.deactivate();
    }

    public IPlayer getPlayer() {
        return this.filePlayerAdapter;
    }

    private AbstractFilePlayerJob getRunningJob() {
        AbstractFilePlayerJob abstractFilePlayerJob = (AbstractFilePlayerJob)this.filePlayerContentQueue.getRunningJob();
        if (abstractFilePlayerJob == null) {
            return this.DEFAULT_JOB;
        }
        return abstractFilePlayerJob;
    }

    public void audioStateChanged(AudioState audioState) {
        this.logger.main().log(1000000, "[%1.audioStateChanged] '%2'", (Object)LOGCLASS, (Object)audioState);
        this.filePlayerState.setAudioState(audioState);
        this.getRunningJob().onAudioStateChanged();
        switch (audioState.getState()) {
            case 2: {
                if (audioState.getConnection() != 9) {
                    this.getTerminal().getAudioManager().fadeTo();
                }
                if (this.filePlayerState.isOnPlayback()) {
                    if (this.filePlayerState.isOnSeeking()) break;
                    this.filePlayerContentQueue.enqueue(new JobResume(this.logger.main(), this));
                    break;
                }
                this.logger.main().log(1000000, "[%1.audioStateChanged] No playback.", (Object)LOGCLASS);
                break;
            }
            case 3: 
            case 5: 
            case 6: {
                if (this.filePlayerState.isOnPlayback()) {
                    this.filePlayerContentQueue.enqueue(new JobPause(this.logger.main(), this));
                    break;
                }
                this.logger.main().log(1000000, "[%1.audioStateChanged] No playback.", (Object)LOGCLASS);
                break;
            }
        }
    }

    public void audioFocusChanged(boolean bl) {
    }

    public void attachSession(FilePlayerSession filePlayerSession) {
        this.logger.main().log(1000000, "[%1.attachSession] [%2]", (Object)LOGCLASS, (Object)filePlayerSession);
        this.filePlayerContentQueue.enqueue(new JobAttachSession(this.logger.main(), this, new SessionPlayer(filePlayerSession, this), this.filePlayerAdapter));
    }

    public void detachSession(IFilePlayerListener iFilePlayerListener) {
        this.logger.main().log(1000000, "[%1.detachSession]", (Object)LOGCLASS);
        this.filePlayerContentQueue.enqueue(new JobDettachSession(this.logger.main(), this, iFilePlayerListener));
    }

    public ButtonListener getHardKeyListener() {
        return this.hardKeyHandler;
    }

    public void setPlaybackURL(String string) {
        this.logger.main().log(1000000, "[%1.setPlaybackURL] '%2'", (Object)LOGCLASS, (Object)string);
        this.dsiPlayer.setPlaybackURL(string);
    }

    public void resume() {
        this.logger.main().log(1000000, "[%1.resume]", (Object)LOGCLASS);
        this.dsiPlayer.resume();
    }

    public void pause() {
        this.logger.main().log(1000000, "[%1.pause]", (Object)LOGCLASS);
        this.dsiPlayer.pause();
    }

    public void stop() {
        this.logger.main().log(1000000, "[%1.stop]", (Object)LOGCLASS);
        this.dsiPlayer.stop();
    }

    public void seek(boolean bl) {
        this.logger.main().log(1000000, "[%1.seek]", (Object)LOGCLASS);
        this.dsiPlayer.dsiSeek(bl, 8);
    }

    public void skip(int n) {
        this.logger.main().log(1000000, "[%1.skip] '%2'", (Object)LOGCLASS, (long)n);
        if (n < 0) {
            this.dsiPlayer.skip(1, Math.abs(n));
        } else {
            this.dsiPlayer.skip(0, Math.abs(n));
        }
    }

    public void setPlaybackMode(int n) {
        this.logger.main().log(1000000, "[%1.setPlaybackMode] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiPlayer.setPlaybackMode(n);
    }

    public void setVideoScaling(int n, int n2, int n3, int n4) {
        this.logger.main().log(1000000, "[%1.setVideoScaling]", (Object)LOGCLASS);
        this.dsiPlayer.setVideoRect(n, n2, n3, n4);
    }

    public IFilePlayerState getState() {
        return this.filePlayerState;
    }

    public IAudioManager getAudioManager() {
        return this.getTerminal().getAudioManager();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void rearSeatAudioFocusChanged(boolean bl) {
    }

    class SessionPlayer
    implements IMediaFileSessionPlayer {
        private final FilePlayerSession session;
        private final IFilePlayer player;

        public SessionPlayer(FilePlayerSession filePlayerSession, IFilePlayer iFilePlayer) {
            this.session = filePlayerSession;
            this.player = iFilePlayer;
        }

        public FilePlayerSession getSession() {
            return this.session;
        }

        public void resume() {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.resume] [%2]", (Object)FilePlayerContent.LOGCLASS, (Object)this.session);
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.resume"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onResume] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    if (FilePlayerContent.this.getState().getAudioState().isAudible()) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onResume] [%2] Already hearable.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        if (FilePlayerContent.this.filePlayerState.isOnSeeking()) {
                            FilePlayerContent.this.logger.main().log(1000000, "[%1.onResume] [%2] On seeking. Resume playback.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                            FilePlayerContent.this.filePlayerContentQueue.enqueue(new JobResume(FilePlayerContent.this.logger.main(), SessionPlayer.this.player));
                        }
                    }
                    FilePlayerContent.this.logger.main().log(1000000, "[%1.onResume] [%2] Try to resume audio.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                    FilePlayerContent.this.getTerminal().getAudioManager().resumeAudio(false);
                }
            });
        }

        public void pause() {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.pause] [%2]", (Object)FilePlayerContent.LOGCLASS, (Object)this.session);
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.pause"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onPause] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    FilePlayerContent.this.logger.main().log(1000000, "[%1.onPause] [%2] Mute audio.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                    FilePlayerContent.this.getTerminal().getAudioManager().mute();
                }
            });
        }

        public void play(final String string, final boolean bl) {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.play] [%2] '%3'", (Object)FilePlayerContent.LOGCLASS, (Object)this.session, (Object)string);
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.playURL"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onPlay] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    FilePlayerContent.this.filePlayerContentQueue.enqueue(new JobPlayURL(FilePlayerContent.this.logger.main(), SessionPlayer.this.player, string, bl));
                }
            });
        }

        public void setVideoScaling(final int n, final int n2, final int n3, final int n4) {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.setVideoScaling] [%2]", (Object)FilePlayerContent.LOGCLASS, (Object)this.session);
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.setVideoScaling"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.setVideoScaling] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    FilePlayerContent.this.filePlayerContentQueue.enqueue(new JobSetVideoScale(FilePlayerContent.this.logger.main(), SessionPlayer.this.player, n, n2, n3, n4));
                }
            });
        }

        public void stop() {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.stop] [%2]", (Object)FilePlayerContent.LOGCLASS, (Object)this.session);
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.stop"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSeek] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    FilePlayerContent.this.filePlayerContentQueue.enqueue(new JobStop(FilePlayerContent.this.logger.main(), SessionPlayer.this.player));
                }
            });
        }

        public void seek(final boolean bl) {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.seek] [%2] '%3'", (Object)FilePlayerContent.LOGCLASS, (Object)this.session, (Object)(bl ? "FORWARD" : "BACKWARD"));
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.seek"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSeek] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    if (SessionPlayer.this.session.getType() != 0) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSeek] Only supported for boardbook.", (Object)FilePlayerContent.LOGCLASS);
                        return;
                    }
                    if (!SessionPlayer.this.session.isOnPlayback()) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSeek] Not on playback.", (Object)FilePlayerContent.LOGCLASS);
                        return;
                    }
                    FilePlayerContent.this.filePlayerContentQueue.enqueue(new JobSeek(FilePlayerContent.this.logger.main(), SessionPlayer.this.player, FilePlayerContent.this.getTerminal().getAudioManager(), bl));
                }
            });
        }

        public void skip(final int n) {
            FilePlayerContent.this.logger.main().log(1000000, "[%1.skip] [%2] '%3'", (Object)FilePlayerContent.LOGCLASS, (Object)this.session, (long)n);
            FilePlayerContent.this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("FilePlayer.skip"){

                public void run() {
                    if (!SessionPlayer.this.session.equals(FilePlayerContent.this.filePlayerState.getActiveSession())) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSkip] [%2] Session not active any more.", (Object)FilePlayerContent.LOGCLASS, (Object)SessionPlayer.this.session);
                        return;
                    }
                    if (SessionPlayer.this.session.getType() != 0) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSkip] Only supported for boardbook.", (Object)FilePlayerContent.LOGCLASS);
                        return;
                    }
                    if (n >= 0) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSkip] No forward skip allowed.", (Object)FilePlayerContent.LOGCLASS);
                        return;
                    }
                    if (!SessionPlayer.this.session.isOnPlayback()) {
                        FilePlayerContent.this.logger.main().log(1000000, "[%1.onSkip] Not on playback.", (Object)FilePlayerContent.LOGCLASS);
                        return;
                    }
                    FilePlayerContent.this.filePlayerContentQueue.enqueue(new JobSkip(FilePlayerContent.this.logger.main(), SessionPlayer.this.player, FilePlayerContent.this.getTerminal().getAudioManager(), n));
                }
            });
        }
    }
}

