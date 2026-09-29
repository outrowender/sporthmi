/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

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
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$1;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerStateImpl;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerListener;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayerState;
import de.audi.app.media.content.media.fileplayer.content.JobActivation;
import de.audi.app.media.content.media.fileplayer.content.JobAttachSession;
import de.audi.app.media.content.media.fileplayer.content.JobDefault;
import de.audi.app.media.content.media.fileplayer.content.JobDettachSession;
import de.audi.app.media.content.media.fileplayer.content.JobPause;
import de.audi.app.media.content.media.fileplayer.content.JobResume;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.IActivationContext;
import de.audi.atip.hmi.model.ButtonListener;
import de.esolutions.fw.util.commons.Buffer;

public class FilePlayerContent
extends AbstractMediaContent
implements IAudioStateListener,
IFilePlayer {
    private static final String LOGCLASS;
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
        this.playerListener = new FilePlayerContent$1(this, this.logger.main());
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"FilePlayerContent");
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

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"FilePlayerContent");
        this.hardKeyHandler.deactivate();
        this.filePlayerAdapter.deactivate();
        this.dsiPlayer.setPlayerListener(null);
        this.getTerminal().getAudioManager().removeAudioContextListener(this);
        super.deactivate();
    }

    @Override
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

    @Override
    public void audioStateChanged(AudioState audioState) {
        this.logger.main().log(1078071040, "[%1.audioStateChanged] '%2'", (Object)"FilePlayerContent", (Object)audioState);
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
                this.logger.main().log(1078071040, "[%1.audioStateChanged] No playback.", (Object)"FilePlayerContent");
                break;
            }
            case 3: 
            case 5: 
            case 6: {
                if (this.filePlayerState.isOnPlayback()) {
                    this.filePlayerContentQueue.enqueue(new JobPause(this.logger.main(), this));
                    break;
                }
                this.logger.main().log(1078071040, "[%1.audioStateChanged] No playback.", (Object)"FilePlayerContent");
                break;
            }
        }
    }

    @Override
    public void audioFocusChanged(boolean bl) {
    }

    public void attachSession(FilePlayerSession filePlayerSession) {
        this.logger.main().log(1078071040, "[%1.attachSession] [%2]", (Object)"FilePlayerContent", (Object)filePlayerSession);
        this.filePlayerContentQueue.enqueue(new JobAttachSession(this.logger.main(), this, new FilePlayerContent$SessionPlayer(this, filePlayerSession, this), this.filePlayerAdapter));
    }

    public void detachSession(IFilePlayerListener iFilePlayerListener) {
        this.logger.main().log(1078071040, "[%1.detachSession]", (Object)"FilePlayerContent");
        this.filePlayerContentQueue.enqueue(new JobDettachSession(this.logger.main(), this, iFilePlayerListener));
    }

    @Override
    public ButtonListener getHardKeyListener() {
        return this.hardKeyHandler;
    }

    @Override
    public void setPlaybackURL(String string) {
        this.logger.main().log(1078071040, "[%1.setPlaybackURL] '%2'", (Object)"FilePlayerContent", (Object)string);
        this.dsiPlayer.setPlaybackURL(string);
    }

    @Override
    public void resume() {
        this.logger.main().log(1078071040, "[%1.resume]", (Object)"FilePlayerContent");
        this.dsiPlayer.resume();
    }

    @Override
    public void pause() {
        this.logger.main().log(1078071040, "[%1.pause]", (Object)"FilePlayerContent");
        this.dsiPlayer.pause();
    }

    @Override
    public void stop() {
        this.logger.main().log(1078071040, "[%1.stop]", (Object)"FilePlayerContent");
        this.dsiPlayer.stop();
    }

    @Override
    public void seek(boolean bl) {
        this.logger.main().log(1078071040, "[%1.seek]", (Object)"FilePlayerContent");
        this.dsiPlayer.dsiSeek(bl, 8);
    }

    @Override
    public void skip(int n) {
        this.logger.main().log(1078071040, "[%1.skip] '%2'", (Object)"FilePlayerContent", (long)n);
        if (n < 0) {
            this.dsiPlayer.skip(1, Math.abs(n));
        } else {
            this.dsiPlayer.skip(0, Math.abs(n));
        }
    }

    @Override
    public void setPlaybackMode(int n) {
        this.logger.main().log(1078071040, "[%1.setPlaybackMode] '%2'", (Object)"FilePlayerContent", (long)n);
        this.dsiPlayer.setPlaybackMode(n);
    }

    @Override
    public void setVideoScaling(int n, int n2, int n3, int n4) {
        this.logger.main().log(1078071040, "[%1.setVideoScaling]", (Object)"FilePlayerContent");
        this.dsiPlayer.setVideoRect(n, n2, n3, n4);
    }

    @Override
    public IFilePlayerState getState() {
        return this.filePlayerState;
    }

    @Override
    public IAudioManager getAudioManager() {
        return this.getTerminal().getAudioManager();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("FilePlayerContent").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void rearSeatAudioFocusChanged(boolean bl) {
    }

    static /* synthetic */ IMediaLogger access$000(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ FilePlayerStateImpl access$100(FilePlayerContent filePlayerContent) {
        return filePlayerContent.filePlayerState;
    }

    static /* synthetic */ AbstractFilePlayerJob access$200(FilePlayerContent filePlayerContent) {
        return filePlayerContent.getRunningJob();
    }

    static /* synthetic */ IMediaLogger access$300(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$400(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$500(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$600(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$700(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$800(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1100(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1200(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1300(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1400(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ Queue access$1600(FilePlayerContent filePlayerContent) {
        return filePlayerContent.filePlayerContentQueue;
    }

    static /* synthetic */ IMediaLogger access$1700(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1800(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1900(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2000(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2100(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2200(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2300(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2400(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2500(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2600(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2700(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2800(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$2900(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3000(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3100(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3200(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3300(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3400(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3500(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3600(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3700(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3800(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$3900(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }

    static /* synthetic */ IMediaLogger access$4000(FilePlayerContent filePlayerContent) {
        return filePlayerContent.logger;
    }
}

