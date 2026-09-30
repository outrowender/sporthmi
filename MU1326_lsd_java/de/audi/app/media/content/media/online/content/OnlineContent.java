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
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
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
import de.audi.app.media.content.media.online.content.OnlineContentSeekerAdapter;
import de.audi.app.media.content.media.online.content.OnlineMediaPlayerAdapterImpl;
import de.audi.app.media.content.media.online.content.OnlinePlayerHMIHandler;
import de.audi.app.media.content.media.online.content.OnlinePlayerState;
import de.audi.app.media.dsi.media.AbstractMediaPlayerListener;
import de.audi.app.media.dsi.media.IMediaDSIOnlineListener;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.dsi.media.MediaDSIOnlineController;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.media.OnlinePlayerSourceSlot;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.audio.ToneService;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.PlaybackMode;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OnlineContent
extends AbstractContent
implements IAudioStateListener,
IOnlinePlayer,
IContentOnlineMedia,
IMediaDSIOnlineListener {
    private static final int SKIP_TO_PREVIOUS_FILE_THRESHOLD = 10;
    private static final String LOGCLASS = "OnlineContent";
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
        this.playerListener = new AbstractMediaPlayerListener(this.logger.main()){
            private int previousPlaybackState;

            public String getLogClass() {
                return OnlineContent.LOGCLASS;
            }

            public void updateCapabilities(Capabilities capabilities) {
                OnlineContent.this.logger.main().log(1000000, "[%1.updateCapabilities]", (Object)OnlineContent.LOGCLASS);
                OnlineContent.this.getRunningJob().onCapabilitiesChanged(capabilities);
                OnlineContent.this.hmiHandler.setPlayTimeCapabilities(capabilities.isTotalPlaytime(), capabilities.isPlayTime());
                OnlineContent.this.onlinePlayerAdapter.capabilitiesChanged(capabilities);
            }

            private final boolean isSeeking(int n) {
                return n == 8 || n == 9 || n == 6 || n == 7;
            }

            public void updatePlaybackState(int n) {
                OnlineContent.this.logger.main().log(1000000, "[%1.updatePlaybackState] newState='%2', previousState='%3'", (Object)OnlineContent.LOGCLASS, (long)n, (long)this.previousPlaybackState);
                this.updateSeekStateOnPlaybackState(n);
                this.previousPlaybackState = n;
                OnlineContent.this.onlinePlayerState.setPlaybackState(n);
                OnlineContent.this.getRunningJob().onPlaybackStateChanged();
                OnlineContent.this.notifyMusicStateListener();
                OnlineContent.this.onlinePlayerAdapter.playbackStateChanged(n);
                if (n == 3 && OnlineContent.this.getTerminal().getAudioManager().isMuted()) {
                    OnlineContent.this.getTerminal().getAudioManager().demute();
                }
            }

            private void updateSeekStateOnPlaybackState(int n) {
                if (this.isSeeking(this.previousPlaybackState) && !this.isSeeking(n)) {
                    OnlineContent.this.increaseSeekHandler.stop();
                }
            }

            public void updatePlayPosition(long l, int n, int n2) {
                OnlineContent.this.getRunningJob().onUpdatePlayPosition(l, n, n2);
                OnlineContent.this.logger.main().log(100000000, "[%1.updatePlayPosition] %2 (%3)", (Object)OnlineContent.LOGCLASS, (long)n, (long)n2);
                PlayTime playTime = new PlayTime(n, n2);
                OnlineContent.this.getState().setCurrentPlayTime(playTime);
                boolean bl = OnlineContent.this.getState().getCurrentEntryId() != l;
                OnlineContent.this.getState().setCurrentEntryId(l);
                OnlineContent.this.hmiHandler.setPlayTime(playTime.getRestrictedPlayTimeStr(), playTime.getRemainTimeStr(), playTime.getProgress());
                OnlineContent.this.onlinePlayerAdapter.updatePlayPosition(l, playTime);
                if ((bl || OnlineContent.this.retryDetailInfoRequest) && OnlineContent.this.getState().getCapabilitites().detailInfos && OnlineContent.this.onlinePlayerState.isOnPlayback() && OnlineContent.this.onlinePlayerState.getPlaybackState() != 1) {
                    OnlineContent.this.logger.main().log(100000000, "[%1.updatePlayPosition] request detail info %2", (Object)OnlineContent.LOGCLASS, l);
                    OnlineContent.this.retryDetailInfoRequest = false;
                    OnlineContent.this.dsiPlayer.requestDetailInfo(l);
                    return;
                }
                if (bl) {
                    OnlineContent.this.retryDetailInfoRequest = true;
                }
            }

            public void responseSetPlaybackURL(String string) {
                OnlineContent.this.logger.main().log(1000000, "[%1.responseSetPlaybackURL]", (Object)OnlineContent.LOGCLASS);
                OnlineContent.this.getRunningJob().onResponsePlaybackURL();
            }

            public void responseDetailInfo(RequestParameterEntryID requestParameterEntryID, EntryInfo entryInfo) {
                OnlineContent.this.logger.main().log(1000000, "[%1.responseDetailInfo]", (Object)OnlineContent.LOGCLASS);
                OnlineContent.this.getRunningJob().onResponseDetailInfo(entryInfo);
                MediaDetailInfo mediaDetailInfo = new MediaDetailInfo(entryInfo, new PlayingTrack(OnlineContent.this.getState().getCurrentEntryId(), PlayingTrack.EMPTY_PLAYBACK_FOLDER));
                OnlineContent.this.hmiHandler.setTitleData(mediaDetailInfo.getTitle().getI18NString(), mediaDetailInfo.getAlbum().getI18NString(), mediaDetailInfo.getArtist().getI18NString());
                OnlineContent.this.onlinePlayerAdapter.updateDetailInfo(mediaDetailInfo);
                OnlineContent.this.getRunningJob().onBufferStateChanged();
            }

            public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
                OnlineContent.this.logger.main().log(1000000, "[%1.updatePlaybackModeList]", (Object)OnlineContent.LOGCLASS);
                OnlineContent.this.onlinePlayerState.setPlaybackModes(playbackModeArray);
            }

            public void updatePlaybackMode(int n) {
                OnlineContent.this.logger.main().log(1000000, "[%1.updatePlaybackMode] mode=%2", (Object)OnlineContent.LOGCLASS, (Object)new Integer(n));
                OnlineContent.this.onlinePlayerState.setPlaybackMode(n);
                OnlineContent.this.getRunningJob().onUpdatePlaybackMode();
            }

            public void error(int n) {
                OnlineContent.this.logger.main().log(1000000, "[%1.error] '%2'", (Object)OnlineContent.LOGCLASS, (long)n);
                OnlineContent.this.getRunningJob().onPlayerError(n);
            }
        };
        this.toneServiceTracker = this.getTerminal().getServiceManager().createServiceTracker(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = OnlineContent.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                OnlineContent.this.logger.main().log(1000000, "[%1.removedService] tone service removed.", (Object)OnlineContent.LOGCLASS);
                OnlineContent.this.getTerminal().getServiceManager().releaseService(serviceReference);
                OnlineContent.this.toneService = null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                ToneService toneService = (ToneService)OnlineContent.this.getTerminal().getServiceManager().getService(serviceReference);
                OnlineContent.this.logger.main().log(1000000, "[%1.addingService] tone service found.", (Object)OnlineContent.LOGCLASS);
                OnlineContent.this.toneService = toneService;
                if (OnlineContent.this.onlinePlayerState.isOnPlayback()) {
                    OnlineContent.this.notifyAudioSettings();
                }
                return OnlineContent.this.toneService;
            }
        });
        this.toneServiceTracker.open();
    }

    public void activate(IActivationContext iActivationContext) {
        this.logger.main().log(1000000, "[%1.activate]", (Object)LOGCLASS);
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
            this.logger.main().log(1000000, "[%1.setEntryPointID] active Slot is null", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.setEntryPointID]", (Object)LOGCLASS);
        this.hmiHandler.setEntryPointID(((OnlinePlayerSourceSlot)this.getActiveSlot()).getEntryPointID());
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
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

    public IPlayer getPlayer() {
        return this.onlinePlayerAdapter;
    }

    public void setOnlineMusicStateListener(IOnlineMusicStateListener iOnlineMusicStateListener) {
        this.logger.main().log(1000000, "[%1.setOnlineMusicStateListener %2]", (Object)LOGCLASS, (Object)iOnlineMusicStateListener);
        this.musicStateListener = iOnlineMusicStateListener;
    }

    private AbstractOnlinePlayerJob getRunningJob() {
        AbstractOnlinePlayerJob abstractOnlinePlayerJob = (AbstractOnlinePlayerJob)this.queue.getRunningJob();
        return abstractOnlinePlayerJob != null ? abstractOnlinePlayerJob : this.DEFAULT_JOB;
    }

    public void audioStateChanged(AudioState audioState) {
        this.logger.main().log(1000000, "[%1.audioStateChanged] '%2'", (Object)LOGCLASS, (Object)audioState);
        this.onlinePlayerState.setAudioState(audioState);
        this.getRunningJob().onAudioStateChanged();
        switch (audioState.getState()) {
            case 2: {
                if (audioState.getConnection() != 9) {
                    this.getTerminal().getAudioManager().fadeTo();
                    this.notifyAudioSettings();
                }
                if (!this.onlinePlayerState.isOnPlayback()) {
                    this.logger.main().log(1000000, "[%1.audioStateChanged] No playback.", (Object)LOGCLASS);
                    return;
                }
                if (this.onlinePlayerState.isOnSeeking()) {
                    this.logger.main().log(1000000, "[%1.audioStateChanged] On seeking.", (Object)LOGCLASS);
                    return;
                }
                this.queue.enqueue(new JobResume(this.logger.main(), this));
                break;
            }
            case 3: 
            case 5: 
            case 6: {
                if (!this.onlinePlayerState.isOnPlayback()) {
                    this.logger.main().log(1000000, "[%1.audioStateChanged] No playback.", (Object)LOGCLASS);
                    return;
                }
                this.queue.enqueue(new JobPause(this.logger.main(), this));
                break;
            }
        }
    }

    public void audioFocusChanged(boolean bl) {
        this.logger.main().log(1000000, "[%1.audioFocusChanged] '%2'", (Object)LOGCLASS, (Object)bl);
        OnlinePlayerSession onlinePlayerSession = this.getState().getActiveSession();
        if (!bl && onlinePlayerSession != null && onlinePlayerSession.getOnState() == 1) {
            this.logger.main().log(1000000, "[%1.audioFocusChanged] Suspend session", (Object)LOGCLASS);
            onlinePlayerSession.onSuspend();
        } else if (bl && onlinePlayerSession != null && onlinePlayerSession.getOnState() == 2) {
            this.logger.main().log(1000000, "[%1.audioFocusChanged] Reactivate session.", (Object)LOGCLASS);
            onlinePlayerSession.onActive(new MediaOnlineSessionPlayerImpl(this.logger.main(), onlinePlayerSession, this));
        }
    }

    public void attachSession(OnlinePlayerSession onlinePlayerSession) {
        this.logger.main().log(1000000, "[%1.attachSession] [%2]", (Object)LOGCLASS, (Object)onlinePlayerSession);
        this.queue.enqueue(new JobAttachSession(this.logger.main(), this, onlinePlayerSession));
    }

    public void detachSession(IOnlinePlayerListener iOnlinePlayerListener) {
        this.logger.main().log(1000000, "[%1.detachSession]", (Object)LOGCLASS);
        this.queue.enqueue(new JobDettachSession(this.logger.main(), this, iOnlinePlayerListener));
    }

    public void setPlaybackURL(String string) {
        this.logger.main().log(1000000, "[%1.setPlaybackURL] '%2'", (Object)LOGCLASS, (Object)string);
        this.dsiPlayer.setPlaybackURL(string);
    }

    public void resume() {
        this.logger.main().log(1000000, "[%1.resume]", (Object)LOGCLASS);
        this.increaseSeekHandler.stop();
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

    public boolean seek(boolean bl) {
        if (!this.getState().isSeekSupported()) {
            this.logger.main().log(1000000, "[%1.seek] Not supported.", (Object)LOGCLASS);
            return false;
        }
        this.logger.main().log(1000000, "[%1.seek] '%2'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.increaseSeekHandler.start(bl, 5000L);
        return true;
    }

    public boolean skip(int n) {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.skip] Not active any more.", (Object)LOGCLASS);
            return false;
        }
        if (this.getState().getPlaybackState() == 0 || this.getState().getPlaybackState() == 2) {
            this.logger.main().log(1000000, "[%1.skip] Not ready to play.", (Object)LOGCLASS);
            return false;
        }
        if (n > 0) {
            if (!this.getState().getCapabilitites().isSkipFwd()) {
                this.logger.main().log(1000000, "[%1.skip] Not supported.", (Object)LOGCLASS);
                return false;
            }
            this.dsiPlayer.skip(0, n);
        } else if (n < 0) {
            if (!this.getState().getCapabilitites().isSkipBwd()) {
                this.logger.main().log(1000000, "[%1.skip] Not supported.", (Object)LOGCLASS);
                return false;
            }
            int n2 = Math.abs(n);
            if (!this.getState().getCapabilitites().isPlayTime()) {
                this.logger.main().log(1000000, "[%1.skip] no playtime supported", (Object)LOGCLASS);
            } else if (this.getState().getCurrentPlayTime().getPlayTime() > 10) {
                this.logger.main().log(1000000, "[%1.skip] playTime > %2s threshold", (Object)LOGCLASS, 10L);
                --n2;
            }
            if (n2 == 0) {
                this.logger.main().log(1000000, "[%1.skip] Skip to beginning", (Object)LOGCLASS);
                if (this.dsiPlayer.skip(2, 0)) {
                    this.getState().setCurrentPlayTime(new PlayTime(0, this.getState().getCurrentPlayTime().getTotalTimeOfTrack()));
                }
            } else {
                this.dsiPlayer.skip(1, n2);
            }
        } else {
            this.logger.main().log(1000000, "[%1.skip] skipCount is 0", (Object)LOGCLASS);
            return false;
        }
        this.logger.main().log(1000000, "[%1.skip] start skip and resume audio", (Object)LOGCLASS);
        this.getAudioManager().resumeAudio(false);
        this.resume();
        return true;
    }

    public void setPlaybackMode(int n) {
        this.logger.main().log(1000000, "[%1.setPlaybackMode] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiPlayer.setPlaybackMode(n);
    }

    public void setHMIPlaybackMode() {
        this.logger.hmi().log(1000000, "[%1.setHMIPlaybackMode]", (Object)LOGCLASS);
        ITitlelineHMIHandler iTitlelineHMIHandler = this.getTerminal().getTitlelineHMIHandler();
        iTitlelineHMIHandler.setRepeatScopeIcon(this.getState().isRepeat() ? 1 : 0);
        iTitlelineHMIHandler.setMixIcon(this.getState().isMix());
        iTitlelineHMIHandler.flush();
    }

    public void setPlayposition(long l, int n) {
        this.logger.main().log(1000000, "[%1.setPlayPosition] 'trackID=%2','playPosition=%3'", (Object)LOGCLASS, l, (long)n);
        this.dsiPlayer.setEntry(l, n);
    }

    public OnlinePlayerState getState() {
        return this.onlinePlayerState;
    }

    public Queue getPlayerQueue() {
        return this.queue;
    }

    public IAudioManager getAudioManager() {
        return this.getTerminal().getAudioManager();
    }

    public DispatcherBase getDispatcher() {
        return this.getTerminal().getDispatcher();
    }

    public void updatePlayingTrack(long l, String string, String string2, String string3, ResourceLocator resourceLocator) {
        this.logger.main().log(1000000, "[%1.updatePlayingTrack]", (Object)LOGCLASS);
        if (this.getAudioManager().isMuted()) {
            this.queue.enqueue(new JobPause(this.logger.main(), this));
        }
        this.hmiHandler.setTitleData(string, string2, string3);
        this.onlinePlayerAdapter.updateCoverart(resourceLocator);
    }

    public void playbackModeChanged(int n, boolean bl) {
        this.logger.main().log(1000000, "[%1.playbackModeChanged]", (Object)LOGCLASS);
        this.onlinePlayerAdapter.playbackModeChanged(n, bl);
    }

    public void updateOnlineCoverArt(ResourceLocator resourceLocator) {
        this.logger.main().log(1000000, "[%1.updateOnlineCoverArt]", (Object)LOGCLASS);
        this.onlinePlayerAdapter.updateCoverart(resourceLocator);
    }

    public void updateAudioFocus(int n, int n2) {
    }

    public ButtonListener getHardKeyListener() {
        return this.hardKeyHandler;
    }

    public void updateBufferState(int n) {
        this.logger.main().log(1000000, "[%1.updateBufferState] '%2'", (Object)LOGCLASS, (long)n);
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

    public void updateBufferFillInfo(int n, int n2) {
        this.logger.main().log(1000000, "[%1.updateBufferFillInfo] downloaded='%2',total='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        if (n2 == 0) {
            this.getState().setBufferFillInfoPrecent(0);
        } else {
            this.getState().setBufferFillInfoPrecent(Math.round((float)n / (float)n2 * 100.0f));
        }
        this.getRunningJob().onBufferStateChanged();
        this.notifyMusicStateListener();
    }

    public void updateAudioSettings(int n, int n2) {
        this.logger.main().log(1000000, "[%1.updateAudioSettings]", (Object)LOGCLASS);
        this.onlinePlayerState.setAudioType(n);
        this.onlinePlayerState.setInputGain((short)n2);
        this.getRunningJob().onAudioSettingsChanged();
    }

    public void notifyAudioSettings() {
        if (this.toneService != null) {
            boolean bl = (this.onlinePlayerState.getAudioType() & 1) == 1;
            this.toneService.setSurround(bl);
            short s = (this.onlinePlayerState.getAudioType() & 4) == 4 ? this.onlinePlayerState.getInputGain() : (short)0;
            this.toneService.setInputGainOffSet(s);
            this.logger.main().log(1000000, "[%1.notifyAudioSettings surroundSound='%2', inputGain='%4']", (Object)LOGCLASS, (Object)bl, (Object)new Integer(s));
        }
    }

    private void notifyMusicStateListener() {
        if (this.musicStateListener != null) {
            this.logger.main().log(1000000, "[%1.notifyMusicStateListener]", (Object)LOGCLASS);
            this.musicStateListener.updateMusicState(this.onlinePlayerState.getPlaybackState(), this.onlinePlayerState.getBufferState(), this.onlinePlayerState.getBufferFillInfoPrecent());
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void diagResetBrowser() {
    }

    public void rearSeatAudioFocusChanged(boolean bl) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

