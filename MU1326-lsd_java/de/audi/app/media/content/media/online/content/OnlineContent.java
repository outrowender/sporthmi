/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.ITitlelineHMIHandler;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioManager;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.content.AbstractContent;
import de.audi.app.media.content.IContentContext;
import de.audi.app.media.content.media.HardKeyHandler;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IncreaseSeekHandler;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IContentOnlineMedia;
import de.audi.app.media.content.media.online.content.IOnlineMusicStateListener;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.IOnlinePlayerListener;
import de.audi.app.media.content.media.online.content.JobActivation;
import de.audi.app.media.content.media.online.content.JobAttachSession;
import de.audi.app.media.content.media.online.content.JobDefault;
import de.audi.app.media.content.media.online.content.JobDettachSession;
import de.audi.app.media.content.media.online.content.JobPause;
import de.audi.app.media.content.media.online.content.JobResume;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;
import de.audi.app.media.content.media.online.content.OnlineContent$1;
import de.audi.app.media.content.media.online.content.OnlineContent$2;
import de.audi.app.media.content.media.online.content.OnlineContentSeekerAdapter;
import de.audi.app.media.content.media.online.content.OnlineMediaPlayerAdapterImpl;
import de.audi.app.media.content.media.online.content.OnlinePlayerHMIHandler;
import de.audi.app.media.content.media.online.content.OnlinePlayerState;
import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.dsi.media.MediaDSIOnlineController;
import de.audi.app.media.logger.IMediaLogger;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.media.OnlinePlayerSourceSlot;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.audio.ToneService;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.ResourceLocator;

public class OnlineContent
extends AbstractContent
implements IAudioStateListener,
IOnlinePlayer,
IContentOnlineMedia,
IMediaDSIOnlineListener {
    private static final int SKIP_TO_PREVIOUS_FILE_THRESHOLD;
    private static final String LOGCLASS;
    private final IMediaDSIPlayerController dsiPlayer;
    private final IMediaPlayerListener playerListener;
    private final Queue queue = new Queue(this.getTerminal().getLogger().main(), "ONLINEPLAYER");
    private final OnlinePlayerState onlinePlayerState = new OnlinePlayerState();
    private final JobDefault DEFAULT_JOB;
    private final OnlineMediaPlayerAdapterImpl onlinePlayerAdapter;
    private final HardKeyHandler hardKeyHandler;
    private final MediaDSIOnlineController mediaDSIOnlineController;
    private final OnlinePlayerHMIHandler hmiHandler;
    private IOnlineMusicStateListener musicStateListener = null;
    private IServiceTracker toneServiceTracker;
    private ToneService toneService = null;
    private volatile boolean retryDetailInfoRequest = false;
    private final IncreaseSeekHandler increaseSeekHandler;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneService;

    public OnlineContent(IContentContext iContentContext, IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(8, iContentContext, iMediaTerminal);
        this.dsiPlayer = iMediaDSIPlayerController;
        this.DEFAULT_JOB = new JobDefault(this.logger.main(), this);
        this.hmiHandler = new OnlinePlayerHMIHandler(iMediaTerminal);
        this.onlinePlayerAdapter = new OnlineMediaPlayerAdapterImpl(this.logger.main(), this);
        this.mediaDSIOnlineController = new MediaDSIOnlineController(0, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), true, iMediaTerminal.getLogger().dsi());
        this.hardKeyHandler = new HardKeyHandler(iMediaTerminal, this.onlinePlayerAdapter);
        OnlineContentSeekerAdapter onlineContentSeekerAdapter = new OnlineContentSeekerAdapter(this.dsiPlayer);
        this.increaseSeekHandler = new IncreaseSeekHandler(onlineContentSeekerAdapter, this.logger.main());
        this.playerListener = new OnlineContent$1(this, this.logger.main());
        this.toneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = OnlineContent.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new OnlineContent$2(this));
        this.toneServiceTracker.open();
    }

    @Override
    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1078071040, "[%1.activate]", (Object)"OnlineContent");
        super.activate(iActivationContext);
        this.queue.reset();
        this.dsiPlayer.setPlayerListener(this.playerListener);
        this.getTerminal().getAudioManager().addAudioContextListener(this);
        this.onlinePlayerAdapter.activate();
        this.mediaDSIOnlineController.addMediaOnlineListener(this);
        this.mediaDSIOnlineController.startDSI();
        this.hardKeyHandler.activate();
        this.hmiHandler.init();
        this.setEntryPointID();
        this.notifyContentActivationFinished();
        this.queue.enqueue(new JobActivation(this.logger.main(), this));
    }

    private void setEntryPointID() {
        if (null == this.getActiveSlot()) {
            this.logger.main().log(1078071040, "[%1.setEntryPointID] active Slot is null", (Object)"OnlineContent");
            return;
        }
        this.logger.main().log(1078071040, "[%1.setEntryPointID]", (Object)"OnlineContent");
        this.hmiHandler.setEntryPointID(((OnlinePlayerSourceSlot)this.getActiveSlot()).getEntryPointID());
    }

    @Override
    public void deactivate() {
        this.logger.main().log(1078071040, "[%1.deactivate]", (Object)"OnlineContent");
        this.hardKeyHandler.deactivate();
        this.dsiPlayer.setPlayerListener(null);
        this.onlinePlayerState.reset();
        this.onlinePlayerAdapter.deactivate();
        this.mediaDSIOnlineController.addMediaOnlineListener(null);
        this.getTerminal().getAudioManager().removeAudioContextListener(this);
        this.onlinePlayerState.resetToneSettings();
        this.getTerminal().getTitlelineHMIHandler().resetIcons();
        this.getTerminal().getTitlelineHMIHandler().flush();
        this.notifyAudioSettings();
        this.hmiHandler.deinit();
        super.deactivate();
    }

    @Override
    public IPlayer getPlayer() {
        return this.onlinePlayerAdapter;
    }

    @Override
    public void setOnlineMusicStateListener(IOnlineMusicStateListener iOnlineMusicStateListener) {
        this.logger.main().log(1078071040, "[%1.setOnlineMusicStateListener %2]", (Object)"OnlineContent", (Object)iOnlineMusicStateListener);
        this.musicStateListener = iOnlineMusicStateListener;
    }

    private AbstractOnlinePlayerJob getRunningJob() {
        AbstractOnlinePlayerJob abstractOnlinePlayerJob = (AbstractOnlinePlayerJob)this.queue.getRunningJob();
        return abstractOnlinePlayerJob != null ? abstractOnlinePlayerJob : this.DEFAULT_JOB;
    }

    @Override
    public void audioStateChanged(AudioState audioState) {
        this.logger.main().log(1078071040, "[%1.audioStateChanged] '%2'", (Object)"OnlineContent", (Object)audioState);
        this.onlinePlayerState.setAudioState(audioState);
        this.getRunningJob().onAudioStateChanged();
        switch (audioState.getState()) {
            case 2: {
                if (audioState.getConnection() != 9) {
                    this.getTerminal().getAudioManager().fadeTo();
                    this.notifyAudioSettings();
                }
                if (!this.onlinePlayerState.isOnPlayback()) {
                    this.logger.main().log(1078071040, "[%1.audioStateChanged] No playback.", (Object)"OnlineContent");
                    return;
                }
                if (this.onlinePlayerState.isOnSeeking()) {
                    this.logger.main().log(1078071040, "[%1.audioStateChanged] On seeking.", (Object)"OnlineContent");
                    return;
                }
                this.queue.enqueue(new JobResume(this.logger.main(), this));
                break;
            }
            case 3: 
            case 5: 
            case 6: {
                if (!this.onlinePlayerState.isOnPlayback()) {
                    this.logger.main().log(1078071040, "[%1.audioStateChanged] No playback.", (Object)"OnlineContent");
                    return;
                }
                this.queue.enqueue(new JobPause(this.logger.main(), this));
                break;
            }
        }
    }

    @Override
    public void audioFocusChanged(boolean bl) {
        this.logger.main().log(1078071040, "[%1.audioFocusChanged] '%2'", (Object)"OnlineContent", (Object)bl);
        OnlinePlayerSession onlinePlayerSession = this.getState().getActiveSession();
        if (!bl && onlinePlayerSession != null && onlinePlayerSession.getOnState() == 1) {
            this.logger.main().log(1078071040, "[%1.audioFocusChanged] Suspend session", (Object)"OnlineContent");
            onlinePlayerSession.onSuspend();
        } else if (bl && onlinePlayerSession != null && onlinePlayerSession.getOnState() == 2) {
            this.logger.main().log(1078071040, "[%1.audioFocusChanged] Reactivate session.", (Object)"OnlineContent");
            onlinePlayerSession.onActive(new MediaOnlineSessionPlayerImpl(this.logger.main(), onlinePlayerSession, this));
        }
    }

    public void attachSession(OnlinePlayerSession onlinePlayerSession) {
        this.logger.main().log(1078071040, "[%1.attachSession] [%2]", (Object)"OnlineContent", (Object)onlinePlayerSession);
        this.queue.enqueue(new JobAttachSession(this.logger.main(), this, onlinePlayerSession));
    }

    public void detachSession(IOnlinePlayerListener iOnlinePlayerListener) {
        this.logger.main().log(1078071040, "[%1.detachSession]", (Object)"OnlineContent");
        this.queue.enqueue(new JobDettachSession(this.logger.main(), this, iOnlinePlayerListener));
    }

    @Override
    public void setPlaybackURL(String string) {
        this.logger.main().log(1078071040, "[%1.setPlaybackURL] '%2'", (Object)"OnlineContent", (Object)string);
        this.dsiPlayer.setPlaybackURL(string);
    }

    @Override
    public void resume() {
        this.logger.main().log(1078071040, "[%1.resume]", (Object)"OnlineContent");
        this.increaseSeekHandler.stop();
        this.dsiPlayer.resume();
    }

    @Override
    public void pause() {
        this.logger.main().log(1078071040, "[%1.pause]", (Object)"OnlineContent");
        this.dsiPlayer.pause();
    }

    @Override
    public void stop() {
        this.logger.main().log(1078071040, "[%1.stop]", (Object)"OnlineContent");
        this.dsiPlayer.stop();
    }

    @Override
    public boolean seek(boolean bl) {
        if (!this.getState().isSeekSupported()) {
            this.logger.main().log(1078071040, "[%1.seek] Not supported.", (Object)"OnlineContent");
            return false;
        }
        this.logger.main().log(1078071040, "[%1.seek] '%2'", (Object)"OnlineContent", (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.increaseSeekHandler.start(bl, 0);
        return true;
    }

    @Override
    public boolean skip(int n) {
        if (!this.isActive()) {
            this.logger.main().log(1078071040, "[%1.skip] Not active any more.", (Object)"OnlineContent");
            return false;
        }
        if (this.getState().getPlaybackState() == 0 || this.getState().getPlaybackState() == 2) {
            this.logger.main().log(1078071040, "[%1.skip] Not ready to play.", (Object)"OnlineContent");
            return false;
        }
        if (n > 0) {
            if (!this.getState().getCapabilitites().isSkipFwd()) {
                this.logger.main().log(1078071040, "[%1.skip] Not supported.", (Object)"OnlineContent");
                return false;
            }
            this.dsiPlayer.skip(0, n);
        } else if (n < 0) {
            if (!this.getState().getCapabilitites().isSkipBwd()) {
                this.logger.main().log(1078071040, "[%1.skip] Not supported.", (Object)"OnlineContent");
                return false;
            }
            int n2 = Math.abs(n);
            if (!this.getState().getCapabilitites().isPlayTime()) {
                this.logger.main().log(1078071040, "[%1.skip] no playtime supported", (Object)"OnlineContent");
            } else if (this.getState().getCurrentPlayTime().getPlayTime() > 10) {
                this.logger.main().log(1078071040, "[%1.skip] playTime > %2s threshold", (Object)"OnlineContent", (long)0);
                --n2;
            }
            if (n2 == 0) {
                this.logger.main().log(1078071040, "[%1.skip] Skip to beginning", (Object)"OnlineContent");
                if (this.dsiPlayer.skip(2, 0)) {
                    this.getState().setCurrentPlayTime(new PlayTime(0, this.getState().getCurrentPlayTime().getTotalTimeOfTrack()));
                }
            } else {
                this.dsiPlayer.skip(1, n2);
            }
        } else {
            this.logger.main().log(1078071040, "[%1.skip] skipCount is 0", (Object)"OnlineContent");
            return false;
        }
        this.logger.main().log(1078071040, "[%1.skip] start skip and resume audio", (Object)"OnlineContent");
        this.getAudioManager().resumeAudio(false);
        this.resume();
        return true;
    }

    @Override
    public void setPlaybackMode(int n) {
        this.logger.main().log(1078071040, "[%1.setPlaybackMode] '%2'", (Object)"OnlineContent", (long)n);
        this.dsiPlayer.setPlaybackMode(n);
    }

    @Override
    public void setHMIPlaybackMode() {
        this.logger.hmi().log(1078071040, "[%1.setHMIPlaybackMode]", (Object)"OnlineContent");
        ITitlelineHMIHandler iTitlelineHMIHandler = this.getTerminal().getTitlelineHMIHandler();
        iTitlelineHMIHandler.setRepeatScopeIcon(this.getState().isRepeat() ? 1 : 0);
        iTitlelineHMIHandler.setMixIcon(this.getState().isMix());
        iTitlelineHMIHandler.flush();
    }

    @Override
    public void setPlayposition(long l, int n) {
        this.logger.main().log(1078071040, "[%1.setPlayPosition] 'trackID=%2','playPosition=%3'", (Object)"OnlineContent", l, (long)n);
        this.dsiPlayer.setEntry(l, n);
    }

    @Override
    public OnlinePlayerState getState() {
        return this.onlinePlayerState;
    }

    @Override
    public Queue getPlayerQueue() {
        return this.queue;
    }

    @Override
    public IAudioManager getAudioManager() {
        return this.getTerminal().getAudioManager();
    }

    @Override
    public DispatcherBase getDispatcher() {
        return this.getTerminal().getDispatcher();
    }

    @Override
    public void updatePlayingTrack(long l, String string, String string2, String string3, ResourceLocator resourceLocator) {
        this.logger.main().log(1078071040, "[%1.updatePlayingTrack]", (Object)"OnlineContent");
        if (this.getAudioManager().isMuted()) {
            this.queue.enqueue(new JobPause(this.logger.main(), this));
        }
        this.hmiHandler.setTitleData(string, string2, string3);
        this.onlinePlayerAdapter.updateCoverart(resourceLocator);
    }

    @Override
    public void playbackModeChanged(int n, boolean bl) {
        this.logger.main().log(1078071040, "[%1.playbackModeChanged]", (Object)"OnlineContent");
        this.onlinePlayerAdapter.playbackModeChanged(n, bl);
    }

    @Override
    public void updateOnlineCoverArt(ResourceLocator resourceLocator) {
        this.logger.main().log(1078071040, "[%1.updateOnlineCoverArt]", (Object)"OnlineContent");
        this.onlinePlayerAdapter.updateCoverart(resourceLocator);
    }

    public void updateAudioFocus(int n, int n2) {
    }

    @Override
    public ButtonListener getHardKeyListener() {
        return this.hardKeyHandler;
    }

    @Override
    public void updateBufferState(int n) {
        this.logger.main().log(1078071040, "[%1.updateBufferState] '%2'", (Object)"OnlineContent", (long)n);
        switch (n) {
            case 2: {
                this.getState().setBufferState(2);
                break;
            }
            case 1: {
                this.getState().setBufferState(1);
                break;
            }
            default: {
                this.getState().setBufferState(0);
            }
        }
        this.getRunningJob().onBufferStateChanged();
        this.notifyMusicStateListener();
    }

    @Override
    public void updateBufferFillInfo(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.updateBufferFillInfo] downloaded='%2',total='%3'", (Object)"OnlineContent", (long)n, (long)n2);
        if (n2 == 0) {
            this.getState().setBufferFillInfoPrecent(0);
        } else {
            this.getState().setBufferFillInfoPrecent(Math.round((float)n / (float)n2 * 51266));
        }
        this.getRunningJob().onBufferStateChanged();
        this.notifyMusicStateListener();
    }

    @Override
    public void updateAudioSettings(int n, int n2) {
        this.logger.main().log(1078071040, "[%1.updateAudioSettings]", (Object)"OnlineContent");
        this.onlinePlayerState.setAudioType(n);
        this.onlinePlayerState.setInputGain((short)n2);
        this.getRunningJob().onAudioSettingsChanged();
    }

    @Override
    public void notifyAudioSettings() {
        if (this.toneService != null) {
            boolean bl = (this.onlinePlayerState.getAudioType() & 1) == 1;
            this.toneService.setSurround(bl);
            short s = (this.onlinePlayerState.getAudioType() & 4) == 4 ? this.onlinePlayerState.getInputGain() : (short)0;
            this.toneService.setInputGainOffSet(s);
            this.logger.main().log(1078071040, "[%1.notifyAudioSettings surroundSound='%2', inputGain='%4']", (Object)"OnlineContent", (Object)bl, (Object)new Integer(s));
        }
    }

    private void notifyMusicStateListener() {
        if (this.musicStateListener != null) {
            this.logger.main().log(1078071040, "[%1.notifyMusicStateListener]", (Object)"OnlineContent");
            this.musicStateListener.updateMusicState(this.onlinePlayerState.getPlaybackState(), this.onlinePlayerState.getBufferState(), this.onlinePlayerState.getBufferFillInfoPrecent());
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("OnlineContent").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void diagResetBrowser() {
    }

    @Override
    public void rearSeatAudioFocusChanged(boolean bl) {
    }

    static /* synthetic */ IMediaLogger access$000(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ AbstractOnlinePlayerJob access$100(OnlineContent onlineContent) {
        return onlineContent.getRunningJob();
    }

    static /* synthetic */ OnlinePlayerHMIHandler access$200(OnlineContent onlineContent) {
        return onlineContent.hmiHandler;
    }

    static /* synthetic */ OnlineMediaPlayerAdapterImpl access$300(OnlineContent onlineContent) {
        return onlineContent.onlinePlayerAdapter;
    }

    static /* synthetic */ IMediaLogger access$400(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ OnlinePlayerState access$500(OnlineContent onlineContent) {
        return onlineContent.onlinePlayerState;
    }

    static /* synthetic */ void access$600(OnlineContent onlineContent) {
        onlineContent.notifyMusicStateListener();
    }

    static /* synthetic */ IncreaseSeekHandler access$700(OnlineContent onlineContent) {
        return onlineContent.increaseSeekHandler;
    }

    static /* synthetic */ IMediaLogger access$800(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ boolean access$900(OnlineContent onlineContent) {
        return onlineContent.retryDetailInfoRequest;
    }

    static /* synthetic */ IMediaLogger access$1000(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ boolean access$902(OnlineContent onlineContent, boolean bl) {
        onlineContent.retryDetailInfoRequest = bl;
        return onlineContent.retryDetailInfoRequest;
    }

    static /* synthetic */ IMediaDSIPlayerController access$1100(OnlineContent onlineContent) {
        return onlineContent.dsiPlayer;
    }

    static /* synthetic */ IMediaLogger access$1200(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1300(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1400(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1500(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ IMediaLogger access$1600(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IMediaLogger access$1700(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ ToneService access$1802(OnlineContent onlineContent, ToneService toneService) {
        onlineContent.toneService = toneService;
        return onlineContent.toneService;
    }

    static /* synthetic */ IMediaLogger access$1900(OnlineContent onlineContent) {
        return onlineContent.logger;
    }

    static /* synthetic */ ToneService access$1800(OnlineContent onlineContent) {
        return onlineContent.toneService;
    }
}

