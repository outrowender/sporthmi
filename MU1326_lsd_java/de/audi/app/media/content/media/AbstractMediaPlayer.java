/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioStateListener;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.media.AbstractMediaPlayerHMIHandler;
import de.audi.app.media.content.media.AbstractMediaPlayerJob;
import de.audi.app.media.content.media.AbstractMediaPlayerJobSelection;
import de.audi.app.media.content.media.HardKeyHandler;
import de.audi.app.media.content.media.IPlaybackModeHandler;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.IncreaseSeekHandler;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.MediaPlayerParameterFactory;
import de.audi.app.media.content.media.MediaPlayerSeekerAdapter;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.source.ActiveSourceState;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.IActiveSourceListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.app.media.util.CopyOnWriteMap;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.PlaybackMode;

public abstract class AbstractMediaPlayer
extends AbstractMediaTerminalComponent
implements IPlayer,
IMediaPlayerListener,
IAudioStateListener,
IActiveSourceListener {
    private static final String LOGCLASS = "AbstractMediaPlayer";
    static final byte STARTUP_WAITFOR_CAPABILITIES = 1;
    static final byte STARTUP_RECEIVED_CAPABILITIES = 2;
    static final byte STARTUP_WAITFOR_READY_TO_PLAY = 3;
    static final byte STARTUP_RECEIVE_READY_TO_PLAY = 4;
    static final byte STARTUP_WAITFOR_PLAYMODE = 5;
    static final byte STARTUP_SET_VALID_PLAYMODE = 6;
    static final byte STARTUP_RECEIVED_PLAYMODE = 7;
    static final byte STARTUP_START_PLAYBACK = 8;
    static final byte STARTUP_WAITFOR_PLAYPOSITION = 9;
    static final byte STARTUP_RECEIVED_PLAYPOSITION = 10;
    static final byte STARTUP_WAITFOR_PLAYLIST_SIZE = 11;
    static final byte STARTUP_RECEIVED_PLAYLIST_SIZE = 12;
    static final byte STARTUP_WAITFOR_DETAIL_INFO = 13;
    static final byte STARTUP_RECEIVED_DETAIL_INFO = 14;
    static final byte STARTUP_ERROR = 15;
    static final byte STARTUP_FINISHED = 16;
    public static final int DEFAULT_SEEK_SPEED = 16;
    private static final byte STATE_IDLE = 0;
    private static final byte STATE_WAITFOR_PLAYLIST_SIZE = 1;
    private static final byte STATE_WAITFOR_PLAYPOSITION = 2;
    private static final int SKIP_TO_PREVIOUS_FILE_DEFAULT_THRESHOLD = 10;
    static final PlayTime INVALID_PLAYTIME = new PlayTime(-1, -1);
    private static final int INVALID_PLAYVIEW_SIZE = -1;
    private static final int DVD_MENU_TIMEOUT = 3000;
    private static final long DETAIL_INFO_DELAY_TIMER_TIMEOUT = 1000L;
    private final IMediaDSIPlayerController dsiPlayer;
    private final IncreaseSeekHandler increaseSeekHandler;
    protected volatile IPlaybackModeHandler playbackModeHandler;
    protected final AbstractMediaPlayerHMIHandler hmiHandler;
    private final HardKeyHandler hardKeyHandler;
    private final boolean immediatelyJumpToPreviousTrack;
    private final IContent content;
    private final CopyOnWriteArrayList registeredPlayerListener;
    private final CopyOnWriteArrayList registeredTrackListener;
    private final Queue playerQueue;
    private final boolean logTrackInfoToSerialPort;
    private volatile IActivationContext activationContext;
    private byte startupState;
    private int selectionState;
    private volatile boolean dvdMenuPlaying = false;
    private volatile PlayTime currentPlayTime = INVALID_PLAYTIME;
    private volatile PlayingTrack currentPlayingTrack;
    private MediaListEntry[] currentPlaybackFolder;
    private volatile MediaDetailInfo currentDetailInfo = null;
    private volatile ResourceLocator currentCoverArt = null;
    private final CopyOnWriteMap registeredPlayViewListener;
    protected volatile int currentPlaybackState = 0;
    protected volatile Capabilities capabilities;
    private volatile boolean notifyTrackEvents;
    private volatile int currentPlayViewSize = -1;
    private volatile int currentPlayViewFlag = 0;
    private volatile boolean isDSISeekRequested = false;
    private boolean notifyTrackSkipAfterTrackChange = false;
    private AudioState currentAudioState;
    protected volatile boolean rearSeatAudioFocus;
    private volatile boolean syncStartConnection = true;
    private volatile int lastNotifiedPlaybackState;
    private volatile MediaCapabilities mediaCapabilities;
    private boolean trackSelected = false;
    private volatile boolean isOnIPOD;
    private volatile int mediaTypeOfActiveSource = 0;
    private volatile int sourceTypeOfActiveSource = -1;
    private boolean responseExpected;
    private volatile PlaybackMode[] playbackModeList = new PlaybackMode[0];
    private volatile int playbackMode = 0;
    Timer detailInfoNotifyDelayTimer = new Timer("DetailInfoDelayTimer", 5, null, new TimerListener(){

        public void fireTimer(Timer timer) {
            AbstractMediaPlayer.this.logger.main().log(1000000, "[%1.fireTimer] Send delayed notification of detailInfo.", (Object)AbstractMediaPlayer.LOGCLASS);
            AbstractMediaPlayer.this.notifyDetailInfoChanged(AbstractMediaPlayer.this.currentDetailInfo);
        }

        public void cancelTimer(Timer timer) {
        }
    }, 1000L, true);
    Timer dvdMenuTimer = new Timer("DVDMenuLeft", 3000L, true, new TimerListener(){

        public void fireTimer(Timer timer) {
            AbstractMediaPlayer.this.logger.main().log(1000000, "[%1.dvdMenuTimer] DVD Menu left.", (Object)AbstractMediaPlayer.LOGCLASS);
            if (AbstractMediaPlayer.this.dvdMenuPlaying) {
                AbstractMediaPlayer.this.notifyPlayerPlaybackStateChanged(AbstractMediaPlayer.this.currentPlaybackState);
                AbstractMediaPlayer.this.updateHMIPlaybackState(AbstractMediaPlayer.this.currentPlaybackState);
                AbstractMediaPlayer.this.dvdMenuPlaying = false;
            }
        }

        public void cancelTimer(Timer timer) {
        }
    });

    public AbstractMediaPlayer(IMediaTerminal iMediaTerminal, IContent iContent, IMediaDSIPlayerController iMediaDSIPlayerController, boolean bl) {
        this(iMediaTerminal, iContent, iMediaDSIPlayerController, bl, new MediaPlayerParameterFactory());
    }

    AbstractMediaPlayer(IMediaTerminal iMediaTerminal, IContent iContent, IMediaDSIPlayerController iMediaDSIPlayerController, boolean bl, MediaPlayerParameterFactory mediaPlayerParameterFactory) {
        super(iMediaTerminal);
        this.content = iContent;
        this.playerQueue = mediaPlayerParameterFactory.createQueue(this.logger.main(), "PLAYER");
        iMediaTerminal.getDiagnosisManager().addDataProvider(0, this.playerQueue);
        iMediaTerminal.getDiagnosisManager().addCommandProvider(0, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"AbstractMediaPlayer.audioStateChanged(connection:int state:int)"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                if ("AbstractMediaPlayer.audioStateChanged(connection:int state:int)".equals(string)) {
                    AbstractMediaPlayer.this.audioStateChanged(new AudioState(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1])));
                }
            }
        });
        this.registeredPlayerListener = mediaPlayerParameterFactory.createCopyOnWriteArrayList();
        this.registeredTrackListener = mediaPlayerParameterFactory.createCopyOnWriteArrayList();
        this.registeredPlayViewListener = mediaPlayerParameterFactory.createCopyOnWriteMap(1);
        this.immediatelyJumpToPreviousTrack = bl;
        this.dsiPlayer = iMediaDSIPlayerController;
        MediaPlayerSeekerAdapter mediaPlayerSeekerAdapter = mediaPlayerParameterFactory.createSeekAdapter(this);
        this.increaseSeekHandler = mediaPlayerParameterFactory.createIncreaseSeekHandler(mediaPlayerSeekerAdapter, this.logger.main());
        this.hmiHandler = mediaPlayerParameterFactory.createAbstractMediaHMIHandler(iMediaTerminal, this);
        this.hardKeyHandler = mediaPlayerParameterFactory.createHardKeyHandler(iMediaTerminal, this);
        this.logTrackInfoToSerialPort = this.getTerminal().getFramework().getSysConst(4633) == 1;
    }

    public void init() {
    }

    public void deinit() {
    }

    public void activate(IActivationContext iActivationContext, IPlaybackModeHandler iPlaybackModeHandler) {
        this.logger.main().log(1000000, "[%1.activate] '%2'", (Object)LOGCLASS, (Object)iActivationContext);
        this.setActivationContext(iActivationContext);
        this.mediaCapabilities = iActivationContext.getSlot().getSource().getSlot(iActivationContext.getSlot()).getCapabilities();
        this.reset();
        this.getTerminal().getSourceController().addActiveSourceListener(this);
        this.setStartupState((byte)1);
        this.playbackModeHandler = iPlaybackModeHandler;
        this.playbackModeHandler.activate(iActivationContext);
        this.hmiHandler.activate();
        this.hardKeyHandler.activate(iActivationContext);
        this.dsiPlayer.setPlayerListener(this);
        boolean bl = true;
        Object object = iActivationContext.getParameter("DEMUTE");
        if (object instanceof Boolean) {
            bl = (Boolean)object;
        }
        this.syncStartConnection = this.getTerminal().getAudioManager().requestAudio(this.getActiveSlot().getSource().getAudioConnection(this.getActiveSlot()), true, bl);
        this.getTerminal().getAudioManager().addAudioContextListener(this);
        this.isOnIPOD = this.getContent().getActiveSlot().getMediaType() == 24;
    }

    private void reset() {
        this.logger.main().log(1000000, "[%1.reset]", (Object)LOGCLASS);
        this.currentPlayTime = INVALID_PLAYTIME;
        this.currentPlayingTrack = new PlayingTrack();
        this.currentPlaybackFolder = PlayingTrack.EMPTY_PLAYBACK_FOLDER;
        this.currentPlaybackState = 0;
        this.currentDetailInfo = null;
        this.currentCoverArt = null;
        this.setNotifyTrackEvents(true);
        this.currentPlayViewSize = -1;
        this.currentPlayViewFlag = 0;
        this.isDSISeekRequested = false;
        this.lastNotifiedPlaybackState = 0;
        this.notifyTrackSkipAfterTrackChange = false;
        this.dvdMenuPlaying = false;
        this.currentAudioState = new AudioState(-1, 0);
        this.capabilities = null;
    }

    public void deactivate() {
        this.logger.main().log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.dsiPlayer.setPlayerListener(null);
        this.playerQueue.abort();
        this.playerQueue.reset();
        this.enableHMIPlayerControls(false);
        this.removeAllPlayerListener();
        this.removeAllViewListener();
        this.removeAllTrackListener();
        this.getTerminal().getSourceController().removeActiveSourceListener(this);
        this.playbackModeHandler.deactivate();
        this.playbackModeHandler = null;
        this.increaseSeekHandler.stop();
        this.hmiHandler.deactivate();
        this.hardKeyHandler.deactivate();
        this.getTerminal().getAudioManager().releaseAudio();
        this.getTerminal().getAudioManager().removeAudioContextListener(this);
        if (null != this.getActiveSlot() && this.getActiveSlot().getSource().pausePlaybackOnDeactivation()) {
            this.dsiPlayer.pause();
        }
        this.mediaCapabilities = MediaCapabilities.EMPTY_CAPABILITIES;
        this.setActivationContext(null);
    }

    void setActivationContext(IActivationContext iActivationContext) {
        this.activationContext = iActivationContext;
    }

    protected final IActivationContext getActivationContext() {
        return this.activationContext;
    }

    public IContent getContent() {
        return this.content;
    }

    public void resetSettings() {
        this.logger.main().log(1000000, "[%1.resetSettings]", (Object)LOGCLASS);
        if (this.getActiveSlot() != null) {
            this.playbackModeHandler.resetPlaybackMode();
        }
    }

    protected final ISourceSlot getActiveSlot() {
        IActivationContext iActivationContext = this.getActivationContext();
        if (iActivationContext == null) {
            return null;
        }
        return iActivationContext.getSlot().getSource().getSlot(iActivationContext.getSlot());
    }

    public final boolean isActive() {
        return this.getActivationContext() != null;
    }

    public final void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        MediaListEntry[] mediaListEntryArray;
        ResourceLocator resourceLocator;
        Object object;
        this.logger.main().log(1000000, "[%1.addTrackListener] '%2'.", (Object)LOGCLASS, (Object)iPlayerTrackListener);
        this.registeredTrackListener.addIfAbsent(iPlayerTrackListener);
        PlayingTrack playingTrack = this.currentPlayingTrack;
        if (null != playingTrack && playingTrack.getEntryID() != -1L) {
            object = this.currentPlayTime;
            iPlayerTrackListener.trackChanged(true, false, playingTrack, (PlayTime)object);
        }
        if ((object = this.currentDetailInfo) != null) {
            iPlayerTrackListener.detailInfoChanged((MediaDetailInfo)object);
        }
        if ((resourceLocator = this.currentCoverArt) != null) {
            iPlayerTrackListener.coverArtChanged(resourceLocator);
        }
        if (null != (mediaListEntryArray = this.currentPlaybackFolder)) {
            iPlayerTrackListener.playbackFolderChanged(mediaListEntryArray);
        }
    }

    public final void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.main().log(1000000, "[%1.removeTrackListener] '%2'.", (Object)LOGCLASS, (Object)iPlayerTrackListener);
        this.registeredTrackListener.remove(iPlayerTrackListener);
    }

    private void removeAllTrackListener() {
        this.logger.main().log(1000000, "[%1.removeAllTrackListener]", (Object)LOGCLASS);
        this.registeredTrackListener.clear();
    }

    private void notifyTrackChange(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredTrackListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).trackChanged(bl, bl2, playingTrack, playTime);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyTrackChange] Exception in listener callback.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyDetailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredTrackListener;
        this.logger.main().log(1000000, "[%1.notifyDetailInfoChanged]", (Object)LOGCLASS);
        this.hmiHandler.setWaitForDetailInfos(false);
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).detailInfoChanged(mediaDetailInfo);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyDetailInfoChanged] Exception in listener callback : %2.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void waitForDetailInfos() {
        this.logger.main().log(1000000, "[%1.waitForDetailInfos] ", (Object)LOGCLASS);
        this.hmiHandler.setWaitForDetailInfos(true);
    }

    void notifyCoverArtChanged(ResourceLocator resourceLocator) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredTrackListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).coverArtChanged(resourceLocator);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyCoverArtChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyPlaybackFolderChanged(MediaListEntry[] mediaListEntryArray) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredTrackListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).playbackFolderChanged(mediaListEntryArray);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyDetailInfoChanged] Exception in listener callback : %2.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public final void addPlayerListener(IPlayerListener iPlayerListener) {
        this.logger.main().log(1000000, "[%1.addPlayerListener] '%2'.", (Object)LOGCLASS, (Object)iPlayerListener);
        this.registeredPlayerListener.addIfAbsent(iPlayerListener);
        iPlayerListener.playbackStateChanged(this.lastNotifiedPlaybackState);
        Capabilities capabilities = this.capabilities;
        if (capabilities == null) {
            return;
        }
        iPlayerListener.capabilitiesChanged(capabilities);
    }

    public final void removePlayerListener(IPlayerListener iPlayerListener) {
        this.logger.main().log(1000000, "[%1.removePlayerListener] '%2'.", (Object)LOGCLASS, (Object)iPlayerListener);
        this.registeredPlayerListener.remove(iPlayerListener);
    }

    private void removeAllPlayerListener() {
        this.logger.main().log(1000000, "[%1.removeAllPlayerListener]", (Object)LOGCLASS);
        this.registeredPlayerListener.clear();
    }

    void notifyPlayerRepeatScopeChanged(int n, boolean bl) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).repeatScopeChanged(n, bl);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayerRepeatScopeChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void notifyPlayerRepeatModeChanged(int n) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).repeatModeChanged(n);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayerRepeatModeChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyPlayerStartupComplete() {
        this.logger.main().log(1000000, "[%1.notifyPlayerStartupComplete]", (Object)LOGCLASS);
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).playerStartupComplete();
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayerStartupComplete]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void playerStartupComplete() {
        this.logger.main().log(1000000, "[%1.playerStartupComplete]", (Object)LOGCLASS);
        this.notifyPlayerStartupComplete();
    }

    private void notifyPlayerCapabilitiesChanged(Capabilities capabilities) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).capabilitiesChanged(capabilities);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayerCapabilitiesChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private synchronized void notifyPlayerPlaybackStateChanged(int n) {
        int n2;
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        switch (n) {
            case 5: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 10: {
                n2 = 5;
                break;
            }
            case 7: 
            case 9: {
                n2 = 4;
                break;
            }
            case 6: 
            case 8: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 6;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        if (n2 == this.lastNotifiedPlaybackState) {
            return;
        }
        this.lastNotifiedPlaybackState = n2;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).playbackStateChanged(n2);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayerPlaybackStateChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifyPlayerCommandIsBlocked() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).commandBlocked();
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayerCommandIsBlock]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifyCurrentPMLevel(int n) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.registeredPlayerListener;
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).currentPMLevelChanged(n);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyCurrentPMLevel]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void setBrowserPlayerSelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.logger.main().log(1000000, "[%1.setBrowserPlayerSelection] '%2'", (Object)LOGCLASS, (Object)iPlayerSelectionRequest);
        if (!iPlayerSelectionRequest.isSeamless()) {
            this.playbackModeHandler.trackChanged();
        }
        this.playerQueue.enqueue(new AbstractMediaPlayerJobSelection(this.logger.main(), this, iPlayerSelectionRequest, this.registeredPlayViewListener));
    }

    private void notifyPlaySelectionResult(boolean bl) {
        try {
            AbstractMediaPlayerJob abstractMediaPlayerJob = (AbstractMediaPlayerJob)this.playerQueue.getRunningJob();
            if (null != abstractMediaPlayerJob) {
                this.logger.main().log(1000000, "[%2.notifyPlaySelectionResult] '%1'", bl, (Object)LOGCLASS);
                abstractMediaPlayerJob.responseSetPlaySelection(bl);
            }
        }
        catch (Exception exception) {
            this.logger.main().log(100000, "[%1.notifyPlaySelectionResult]", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    private void notifyUpdatePlayPosition() {
        try {
            AbstractMediaPlayerJob abstractMediaPlayerJob = (AbstractMediaPlayerJob)this.playerQueue.getRunningJob();
            if (null != abstractMediaPlayerJob) {
                this.logger.main().log(10000000, "[%1.notifyUpdatePlayPosition]", (Object)LOGCLASS);
                abstractMediaPlayerJob.notifyPlayPosition();
            }
        }
        catch (Exception exception) {
            this.logger.main().log(100000, "[%1.notifyUpdatePlayPosition] %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    protected void notifyListChanged(long l) {
        this.logger.main().log(1000000, "[%1.notifyListChanged]", (Object)LOGCLASS);
        Iterator iterator = this.registeredPlayViewListener.values().iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerViewListener)iterator.next()).listChanged(true, l, this.currentPlayViewSize, this.currentPlayViewFlag);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyListChanged] Exception in listener callback.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    protected void notifySameTrackSelected() {
        this.logger.main().log(1000000, "[%1.notifySameTrackSelected]", (Object)LOGCLASS);
        Iterator iterator = this.registeredPlayViewListener.values().iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerViewListener)iterator.next()).notifySameTrackSelected(this.currentDetailInfo, this.currentCoverArt);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyListChanged] Exception in listener callback.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
        if (this.isOnIPOD && this.getTerminal().getConfiguration().isIAP2Supported() && !this.capabilities.isPlayView() && this.capabilities.isDetailInfos()) {
            this.notifyCoverArtChanged(this.currentCoverArt);
            this.notifyDetailInfoChanged(this.currentDetailInfo);
        }
    }

    public boolean requestPlayViewListEntryBased(int n, long l, int n2) {
        if (!this.isPlayViewSizeValid()) {
            return false;
        }
        if (this.logger.main().isInfo()) {
            this.logger.main().log(1000000, "[%1.requestPlayViewListEntryBased] client='%3',entryID='%2',size='%4'", (Object)LOGCLASS, (Object)String.valueOf(l), (Object)MediaUtils.getPlayViewClientIDToStr(n), (Object)String.valueOf(n2));
        }
        if (!this.supportsPlayListHandling()) {
            this.logger.main().log(1000000, "[%1.requestPlayViewListEntryBased] No list support.", (Object)LOGCLASS);
            return false;
        }
        if (n == 3) {
            this.responseExpected = true;
        }
        return this.dsiPlayer.requestPlayView(l, 0, n2, n);
    }

    public boolean requestPlayViewListIndexBased(int n, int n2, int n3) {
        if (!this.isPlayViewSizeValid()) {
            return false;
        }
        if (this.logger.main().isInfo()) {
            this.logger.main().log(1000000, "[%1.requestPlayViewListIndexBased] client='%3',index='%2',size='%4'", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)MediaUtils.getPlayViewClientIDToStr(n), (Object)String.valueOf(n3));
        }
        if (!this.supportsPlayListHandling()) {
            this.logger.main().log(1000000, "[%1.requestPlayViewListIndexBased] No list support.", (Object)LOGCLASS);
            return false;
        }
        if (n == 3) {
            this.responseExpected = true;
        }
        return this.dsiPlayer.requestPlayView(0L, n2, n3, n);
    }

    public void discardPlayViewRequests(int n) {
        this.logger.main().log(1000000, "[%1.discardPlayViewRequests] clientID='%2'.", (Object)LOGCLASS, (long)n);
        this.dsiPlayer.discardPlayViewRequest(n);
    }

    public void addViewListener(IPlayerViewListener iPlayerViewListener) {
        this.logger.main().log(1000000, "[%1.addViewListener] '%2'.", (Object)LOGCLASS, (Object)iPlayerViewListener);
        this.registeredPlayViewListener.put(new Integer(iPlayerViewListener.getClientID()), iPlayerViewListener);
        if (this.currentPlayViewSize != -1) {
            iPlayerViewListener.listChanged(false, this.currentPlayingTrack.getEntryID(), this.currentPlayViewSize, this.currentPlayViewFlag);
        }
    }

    public void removeViewListener(IPlayerViewListener iPlayerViewListener) {
        this.logger.main().log(1000000, "[%1.removeViewListener] '%2'.", (Object)LOGCLASS, (Object)iPlayerViewListener);
        this.registeredPlayViewListener.remove(new Integer(iPlayerViewListener.getClientID()));
    }

    public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
    }

    public boolean supportsPlayMoreOf() {
        return false;
    }

    private void removeAllViewListener() {
        this.logger.main().log(1000000, "[%1.removeAllViewListener]", (Object)LOGCLASS);
        this.registeredPlayViewListener.clear();
    }

    private void notifyPlayViewResponse(int n, MediaListEntry[] mediaListEntryArray, int n2, int n3) {
        IPlayerViewListener iPlayerViewListener = (IPlayerViewListener)this.registeredPlayViewListener.get(new Integer(n));
        if (iPlayerViewListener == null) {
            this.logger.main().log(100000, "[%1.notifyPlayViewResponse] No listener for clientID '%2'.", (Object)LOGCLASS, (long)n);
            return;
        }
        iPlayerViewListener.responsePlayView(n3, mediaListEntryArray, n2);
    }

    private void notifyPlayViewUpdateSize(int n, int n2) {
        Iterator iterator = this.registeredPlayViewListener.values().iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerViewListener)iterator.next()).listChanged(false, -1L, n, n2);
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayViewUpdateSize] Exception in listener callback.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyPlayViewSizeInvalid() {
        Iterator iterator = this.registeredPlayViewListener.values().iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerViewListener)iterator.next()).listInvalidated();
            }
            catch (Exception exception) {
                this.logger.main().log(100000, "[%1.notifyPlayViewUpdateSize] Exception in listener callback.", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    void setStartupState(byte by) {
        this.startupState = by;
        switch (this.startupState) {
            case 1: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_WAITFOR_CAPABILITIES", (Object)LOGCLASS);
                break;
            }
            case 2: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_CAPABILITIES_RECEIVED", (Object)LOGCLASS);
                this.setStartupState((byte)3);
                break;
            }
            case 3: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_WAITFOR_READY_TO_PLAY", (Object)LOGCLASS);
                break;
            }
            case 4: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_RECEIVE_READY_TO_PLAY", (Object)LOGCLASS);
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] READY TO PLAY");
                if (this.supportsPlaymodes()) {
                    if (this.playbackModeHandler.sendCurrentPlaybackMode()) {
                        this.setStartupState((byte)5);
                        return;
                    }
                    this.logger.main().log(1000000, "[%1.setStartupState] No playback modes.", (Object)LOGCLASS);
                } else {
                    this.logger.main().log(1000000, "[%1.setStartupState] Playback modes not supported.", (Object)LOGCLASS);
                }
                this.setStartupState((byte)8);
                break;
            }
            case 5: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_WAITFOR_PLAYMODE", (Object)LOGCLASS);
                break;
            }
            case 6: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_SET_VALID_PLAYMODE (STD ONLY HACK)", (Object)LOGCLASS);
                if (!this.getTerminal().getFramework().isEvoStd()) {
                    this.logger.main().log(10000, "[%1.setStartupState] This is not an Evo-STD system. The STARTUP_SET_VALID_PLAYMODE should be used only on STD systems.", (Object)LOGCLASS);
                }
                this.playbackModeHandler.sendRepeatPlayview();
                break;
            }
            case 7: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_RECEIVED_PLAYMODE", (Object)LOGCLASS);
                this.setStartupState((byte)8);
                break;
            }
            case 8: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_START_PLAYBACK", (Object)LOGCLASS);
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] START PLAYBACK");
                this.onStartupReadyForPlayback();
                this.setStartupState((byte)9);
                break;
            }
            case 9: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_WAITFOR_PLAYPOSITION", (Object)LOGCLASS);
                if (this.getCurrentPlayTime() == INVALID_PLAYTIME && this.supportsPlaytime()) break;
                this.setStartupState((byte)10);
                return;
            }
            case 10: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_RECEIVED_PLAYPOSITION", (Object)LOGCLASS);
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] RECEIVE PLAY POSITION.");
                if (!this.supportsPlayListHandling()) {
                    this.logger.main().log(1000000, "[%1.setStartupState] List handling not supported.", (Object)LOGCLASS);
                    this.setStartupState((byte)12);
                    return;
                }
                this.setStartupState((byte)11);
                break;
            }
            case 11: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_WAITFOR_PLAYLIST_SIZE", (Object)LOGCLASS);
                if (this.currentPlayViewSize == -1) break;
                this.setStartupState((byte)12);
                return;
            }
            case 12: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_RECEIVED_PLAYLIST_SIZE", (Object)LOGCLASS);
                if (!this.supportsDetailInfo()) {
                    this.logger.main().log(1000000, "[%1.setStartupState] Detail info not supported.", (Object)LOGCLASS);
                    this.setStartupState((byte)14);
                    return;
                }
                this.setStartupState((byte)13);
                break;
            }
            case 13: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_WAITFOR_DETAIL_INFO", (Object)LOGCLASS);
                if (this.currentDetailInfo == null) break;
                this.setStartupState((byte)14);
                return;
            }
            case 14: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_RECEIVED_DETAIL_INFO", (Object)LOGCLASS);
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] RECEIVE DETAIL INFO");
                this.setStartupState((byte)16);
                break;
            }
            case 15: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_ERROR", (Object)LOGCLASS);
                ISourceSlot iSourceSlot = this.getActiveSlot();
                if (iSourceSlot == null) {
                    this.logger.main().log(1000000, "[%1.setStartupState] Not active any more.", (Object)LOGCLASS);
                    break;
                }
                this.getTerminal().getAudioManager().requestAudio(iSourceSlot.getSource().getAudioConnection(iSourceSlot), true);
                if (this.currentDetailInfo == null) {
                    this.logger.main().log(1000000, "[%1.updatePlaybackState] No detail info. Send invalidation.", (Object)LOGCLASS);
                    this.currentDetailInfo = new MediaDetailInfo();
                    this.notifyDetailInfoChanged(this.currentDetailInfo);
                }
                this.setStartupState((byte)16);
                break;
            }
            case 16: {
                this.logger.main().log(1000000, "[%1.setStartupState] STARTUP_FINISHED", (Object)LOGCLASS);
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] PLAYER STARTUP FINISHED.");
                this.enableHMIPlayerControls(true);
                if (!this.isActive()) {
                    return;
                }
                this.getTerminal().getAudioManager().requestSdisConnectionsIfRequired(this.getActiveSlot().getSource().getAudioConnection(this.getActiveSlot()));
                this.playerStartupComplete();
                break;
            }
            default: {
                this.logger.main().log(10000, "[%1.setStartupState] Invalid startup state '%2'.", (Object)LOGCLASS, (long)this.startupState);
            }
        }
    }

    byte getStartupState() {
        return this.startupState;
    }

    protected boolean isOnStartup() {
        return this.startupState != 16;
    }

    protected void onStartupReadyForPlayback() {
        if (this.getCurrentAudioState().getState() == 2 || this.getCurrentAudioState().getState() == 4 || this.getTerminal().getAudioManager().hasRearSeatAudioFocusOnly() || this.isActiveSDISAndStandby()) {
            this.logger.main().log(1000000, "[%1.onStartupReadyForPlayback] Start playback.", (Object)LOGCLASS);
            this.dsiPlayer.resume();
        } else {
            this.logger.main().log(1000000, "[%1.onStartupReadyForPlayback] Pause playback. No audio.", (Object)LOGCLASS);
            this.dsiPlayer.pause();
        }
    }

    private void enableHMIPlayerControls(boolean bl) {
        this.getChoiceModel(200246).setValue(bl ? 1 : 0);
    }

    public void pause() {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.pause] Not active any more.", (Object)LOGCLASS);
            return;
        }
        if (this.isNotReadyToPlay()) {
            this.logger.main().log(1000000, "[%1.pause] Not ready to play.", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.pause]", (Object)LOGCLASS);
        this.dsiPlayer.pause();
    }

    public void resume() {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.resume] Not active any more.", (Object)LOGCLASS);
            return;
        }
        if (!this.isPlaybackStateValid()) {
            this.logger.main().log(1000000, "[%1.resume] Invalid playback state", (Object)LOGCLASS);
            return;
        }
        if (this.isNotReadyToPlay()) {
            this.logger.main().log(1000000, "[%1.resume] Not ready to play", (Object)LOGCLASS);
            return;
        }
        if (!(this.getCurrentAudioState().isAudible() || this.getTerminal().getAudioManager().hasRearSeatAudioFocusOnly() || this.isActiveSDISAndStandby())) {
            this.logger.main().log(1000000, "[%1.resume] Not audible", (Object)LOGCLASS);
            this.dsiPlayer.pause();
            if (!this.getTerminal().getAudioManager().resumeAudio(true)) {
                this.logger.main().log(1000000, "[%1.resume] Audio cannot be resumed", (Object)LOGCLASS);
                return;
            }
            return;
        }
        this.logger.main().log(1000000, "[%1.resume]", (Object)LOGCLASS);
        this.dsiPlayer.resume();
    }

    public void playEntry(long l) {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.playEntry] Not active any more.", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.playEntry] '%2'.", (Object)LOGCLASS, l);
        if (this.currentPlayingTrack.getEntryID() != l) {
            this.logger.main().log(10000000, "[%1.playEntry] New track.", (Object)LOGCLASS);
            this.setNotifyTrackEvents(false);
        } else {
            this.setNotifyTrackEvents(true);
        }
        this.playbackModeHandler.trackChanged();
        this.dsiPlayer.setEntry(l, -1);
        this.resume();
    }

    private void setNotifyTrackEvents(boolean bl) {
        this.logger.main().log(10000000, "[%1.setNotifyTrackEvents] '%2'", (Object)LOGCLASS, (Object)(bl ? "NOTIFY" : "BLOCKED"));
        this.notifyTrackEvents = bl;
    }

    private boolean isNotifyTrackChangeEvents() {
        return this.notifyTrackEvents;
    }

    protected boolean isChaptersAvailable() {
        MediaDetailInfo mediaDetailInfo = this.currentDetailInfo;
        return mediaDetailInfo != null ? mediaDetailInfo.isChapterAvailable() : false;
    }

    public void touchEvent(int n, int n2, int n3) {
    }

    public void executeMenuCommand(int n) {
    }

    public void setPlayPosition(int n) {
        PlayTime playTime;
        this.logger.main().log(1000000, "[%1.setPlayPosition] '%2'.", (Object)LOGCLASS, (long)n);
        PlayingTrack playingTrack = this.currentPlayingTrack;
        this.dsiPlayer.setEntry(playingTrack.getEntryID(), n);
        if (!this.getCurrentAudioState().isAudible() && !this.isActiveSDISAndStandby()) {
            this.getTerminal().getAudioManager().resumeAudio(true);
            this.dsiPlayer.pause();
        }
        this.currentPlayTime = playTime = new PlayTime(n, this.currentPlayTime.getTotalTimeOfTrack());
        this.notifyTrackChange(false, false, playingTrack, playTime);
    }

    public final PlayingTrack getCurrentPlayingTrack() {
        return this.currentPlayingTrack;
    }

    protected final PlayTime getCurrentPlayTime() {
        return this.currentPlayTime;
    }

    public final MediaDetailInfo getCurrentDetailInfo() {
        return this.currentDetailInfo;
    }

    public boolean skip(boolean bl, int n) {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.skip] Not active any more.", (Object)LOGCLASS);
            return false;
        }
        if (this.isNotReadyToPlay()) {
            this.logger.main().log(1000000, "[%1.skip] Not ready to play.", (Object)LOGCLASS);
            return false;
        }
        if (bl) {
            int n2;
            int n3;
            if (!this.supportsSkipFW()) {
                this.logger.main().log(1000000, "[%1.skip] Not supported.", (Object)LOGCLASS);
                return false;
            }
            if (this.isChaptersAvailable()) {
                if (this.currentDetailInfo.getActiveChapter() + n < this.currentDetailInfo.getNumChapters()) {
                    n3 = 6;
                    n2 = n;
                } else {
                    n3 = 0;
                    n2 = this.currentDetailInfo.getActiveChapter() + 1 + n - this.currentDetailInfo.getNumChapters();
                }
            } else {
                this.playbackModeHandler.trackChanged();
                n3 = 0;
                n2 = n;
            }
            this.hmiHandler.disableNPSTimer(true);
            this.dsiPlayer.skip(n3, n2);
        } else {
            if (!this.supportsSkipBW()) {
                this.logger.main().log(1000000, "[%1.skip] Not supported.", (Object)LOGCLASS);
                return false;
            }
            int n4 = n;
            if (this.isChaptersAvailable() && this.currentDetailInfo.getActiveChapter() > 0) {
                this.hmiHandler.disableNPSTimer(true);
                if (this.currentDetailInfo.getActiveChapter() - n >= 0) {
                    this.dsiPlayer.skip(7, n);
                } else {
                    n4 = n - this.currentDetailInfo.getActiveChapter();
                    this.dsiPlayer.skip(1, n4);
                }
            } else {
                if (!this.supportsPlaytime()) {
                    this.logger.main().log(1000000, "[%1.skip] no playtime supported", (Object)LOGCLASS);
                } else if (!this.immediatelyJumpToPreviousTrack && this.currentPlayTime.getPlayTime() > this.getSkipToPreviousThreshold()) {
                    this.logger.main().log(1000000, "[%1.skip] playTime > %2s threshold", (Object)LOGCLASS, (long)this.getSkipToPreviousThreshold());
                    --n4;
                }
                this.hmiHandler.disableNPSTimer(true);
                if (n4 <= 0) {
                    this.logger.main().log(1000000, "[%1.skip] Skip to beginning", (Object)LOGCLASS);
                    if (this.dsiPlayer.skip(2, 0)) {
                        this.currentPlayTime = new PlayTime(0, this.currentPlayTime.getTotalTimeOfTrack());
                    }
                } else {
                    this.playbackModeHandler.trackChanged();
                    this.dsiPlayer.skip(1, n4);
                }
            }
        }
        this.setNotifyTrackEvents(true);
        this.notifyTrackSkipAfterTrackChange = true;
        this.resume();
        return true;
    }

    protected int getSkipToPreviousThreshold() {
        return 10;
    }

    public boolean startSeek(boolean bl) {
        MediaDetailInfo mediaDetailInfo;
        this.logger.main().log(1000000, "[%1.startSeek] '%2'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.startSeek] Not active any more.", (Object)LOGCLASS);
            return false;
        }
        if (this.isSeekingFwd() && bl || this.isSeekingBwd() && !bl) {
            this.logger.main().log(10000000, "[%1.startSeek] Already seeking.", (Object)LOGCLASS);
            return false;
        }
        if (this.isNotReadyToPlay()) {
            this.logger.main().log(1000000, "[%1.startSeek] Not ready to play.", (Object)LOGCLASS);
            return false;
        }
        if (bl) {
            if (!this.supportsSeekForward()) {
                this.logger.main().log(1000000, "[%1.startSeek] Seek forward not supported.", (Object)LOGCLASS);
                return false;
            }
        } else if (!this.supportsSeekBackward()) {
            this.logger.main().log(1000000, "[%1.startSeek] Seek backward not supported.", (Object)LOGCLASS);
            return false;
        }
        if ((mediaDetailInfo = this.getCurrentDetailInfo()) != null && mediaDetailInfo.isImportRunning()) {
            this.logger.main().log(1000000, "[%1.startSeek] File is currently imported. Seek not supported.", (Object)LOGCLASS);
            return false;
        }
        if (!this.increaseSeekHandler.start(bl, 5000L)) {
            return false;
        }
        this.isDSISeekRequested = true;
        this.getTerminal().getAudioManager().resumeAudio(true);
        return true;
    }

    public boolean stopSeek(boolean bl) {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.stopSeek] Not active any more.", (Object)LOGCLASS);
            return false;
        }
        this.increaseSeekHandler.stop();
        if (!this.isSeeking()) {
            this.logger.main().log(10000000, "[%1.stopSeek] Not seeking.", (Object)LOGCLASS);
            if (bl) {
                this.resume();
            }
            return false;
        }
        this.isDSISeekRequested = false;
        if (bl) {
            this.resume();
        }
        return true;
    }

    public final boolean isSeeking() {
        return AbstractMediaPlayer.isSeeking(this.currentPlaybackState) || this.isDSISeekRequested;
    }

    private static final boolean isSeeking(int n) {
        return n == 8 || n == 9 || n == 6 || n == 7;
    }

    public final boolean isSeekingFwd() {
        return this.currentPlaybackState == 8 || this.currentPlaybackState == 6;
    }

    public final boolean isSeekingBwd() {
        return this.currentPlaybackState == 9 || this.currentPlaybackState == 7;
    }

    public final boolean isPlaying() {
        return this.currentPlaybackState == 3 || this.currentPlaybackState == 10;
    }

    public boolean isReadyToPlay() {
        return !this.isNotReadyToPlay();
    }

    protected final boolean isNotReadyToPlay() {
        return this.currentPlaybackState == 2 || this.currentPlaybackState == 0;
    }

    protected final boolean isPlaybackStateValid() {
        return this.currentPlaybackState != 0;
    }

    public final boolean isPaused() {
        return this.currentPlaybackState == 5;
    }

    public void updatePlayPosition(long l, int n, int n2) {
        boolean bl;
        boolean bl2;
        if (this.startupState < 8) {
            this.logger.main().log(1000000, "[%1.updatePlayPosition] Playback not started. Ignore.", (Object)LOGCLASS);
            return;
        }
        int n3 = 0;
        int n4 = n2;
        if (n < 0) {
            this.logger.main().log(100000, "[%1.updatePlayPosition] play time < 0 ('%2').", (Object)LOGCLASS, l);
        } else {
            n3 = n;
        }
        if (n4 > 0 && n > n4) {
            this.logger.main().log(100000, "[%1.updatePlayPosition] play time > total time ('%2').", (Object)LOGCLASS, l);
            n4 = n3 = n;
        } else {
            n3 = n;
        }
        this.currentPlayTime = new PlayTime(n3, n4);
        if (this.currentPlayingTrack.getEntryID() != l) {
            bl2 = true;
            bl = this.notifyTrackSkipAfterTrackChange && !this.isOnStartup();
            this.hmiHandler.disableNPSTimer(false);
            this.notifyTrackSkipAfterTrackChange = false;
            if (this.logger.main().isInfo()) {
                this.logger.main().log(1000000, "[%1.updatePlayPosition] Track changed ('%2'%3)", (Object)LOGCLASS, (Object)new Long(l), (Object)(bl ? " SKIPPED" : ""));
            }
            this.setNotifyTrackEvents(true);
            this.currentPlayingTrack = new PlayingTrack(l, this.currentPlaybackFolder);
            this.trackSelected = false;
            this.requestDetailInfo(l);
            if (this.isOnIPOD && this.capabilities != null && this.capabilities.isPlaybackModes()) {
                this.disablePlayBackModesForIPod();
            }
        } else {
            bl2 = false;
            bl = false;
            if (this.trackSelected) {
                this.logger.main().log(1000000, "[%1.updatePlayPosition] same track selected", (Object)LOGCLASS);
                this.trackSelected = false;
                this.notifySameTrackSelected();
            }
        }
        if (this.selectionState == 2) {
            this.notifyListChanged(l);
            this.selectionState = 0;
        }
        if (this.isNotifyTrackChangeEvents()) {
            this.notifyUpdatePlayPosition();
            this.notifyTrackChange(bl2, bl, this.currentPlayingTrack, this.currentPlayTime);
        }
        if (this.getStartupState() == 9) {
            this.setStartupState((byte)10);
        }
    }

    private void disablePlayBackModesForIPod() {
        MediaListEntry[] mediaListEntryArray = this.currentPlayingTrack.getPlaybackFolder();
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 1; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            if (mediaListEntry.getFilename().getOriginalString().equals("playengine")) {
                this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - currentPathElement: playengine", (Object)LOGCLASS);
                bl2 = true;
                break;
            }
            this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - currentPathElement: %2", (Object)LOGCLASS, (Object)mediaListEntry.getFilename().getOriginalString());
            if (mediaListEntry.getContentType() != 18 && mediaListEntry.getContentType() != 11) continue;
            bl = true;
            break;
        }
        if (bl2) {
            this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - 'playengine' reported as path. Can't decide if it is an AudioBook or Podcast.", (Object)LOGCLASS);
        } else if (bl) {
            this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - AudioBook or PodCast on iPod: Disable playbackModes.", (Object)LOGCLASS);
            this.getTerminal().getDispatcher().execute(new Runnable(){

                public void run() {
                    AbstractMediaPlayer.this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - Done: Disable playbackModes.", (Object)AbstractMediaPlayer.LOGCLASS);
                    AbstractMediaPlayer.this.playbackModeHandler.updatePlaymodesAvailable(false);
                }
            });
        } else {
            this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - No AudioBook or PodCast: Restore playbackModes.", (Object)LOGCLASS);
            this.getTerminal().getDispatcher().execute(new Runnable(){

                public void run() {
                    AbstractMediaPlayer.this.logger.main().log(1000000, "[%1.updatePlayPosition] iPod playbackModes - Done: Reset playbackModes. playbackModes: %2", (Object)AbstractMediaPlayer.LOGCLASS, (Object)AbstractMediaPlayer.this.capabilities.playbackModes);
                    AbstractMediaPlayer.this.updatePlaybackModeList(AbstractMediaPlayer.this.playbackModeList);
                    AbstractMediaPlayer.this.updatePlaybackMode(AbstractMediaPlayer.this.playbackMode);
                    AbstractMediaPlayer.this.playbackModeHandler.updatePlaymodesAvailable(true);
                }
            });
        }
    }

    public void playPositionInvalidated() {
        this.logger.main().log(1000000, "[%1.playPositionInvalidated]", (Object)LOGCLASS);
        this.currentPlayTime = new PlayTime(-1, -1);
        this.currentPlayingTrack = new PlayingTrack(-1L, this.currentPlaybackFolder);
    }

    private void requestDetailInfo(long l) {
        if (!this.supportsDetailInfo()) {
            return;
        }
        this.getDSIPlayer().requestDetailInfo(l);
    }

    public void responseDetailInfo(RequestParameterEntryID requestParameterEntryID, EntryInfo entryInfo) {
        boolean bl;
        this.logger.dsi().log(1000000, "[%1.responseDetailInfo] '%2'", (Object)LOGCLASS, entryInfo.getEntryID());
        if (requestParameterEntryID == null) {
            this.logger.dsi().log(10000000, "[%1.responseDetailInfo] Receive update.", (Object)LOGCLASS);
            bl = true;
        } else {
            if (requestParameterEntryID.isOutdated()) {
                this.logger.dsi().log(10000000, "[%1.responseDetailInfo] Detail info outdated.", (Object)LOGCLASS);
                return;
            }
            bl = false;
        }
        if (entryInfo.getEntryID() != this.currentPlayingTrack.getEntryID()) {
            this.logger.dsi().log(1000000, "[%1.responseDetailInfo] '%2' not playing track '%3'", (Object)LOGCLASS, entryInfo.getEntryID(), this.currentPlayingTrack.getEntryID());
            return;
        }
        this.currentDetailInfo = new MediaDetailInfo(entryInfo, this.currentPlayingTrack);
        if (this.mediaTypeOfActiveSource == 2 || this.mediaTypeOfActiveSource == 7) {
            this.detailInfoNotifyDelayTimer.restart();
        } else {
            this.notifyDetailInfoChanged(this.currentDetailInfo);
        }
        if (!bl && this.supportsCoverart()) {
            if (this.currentDetailInfo.isAudio() && !this.currentDetailInfo.isCorrupt() && !this.currentDetailInfo.isDeadlink() && !this.currentDetailInfo.isDRMProtected()) {
                this.getDSIPlayer().requestCoverArtURL(this.currentDetailInfo.getEntryID());
            } else {
                this.currentCoverArt = null;
                this.notifyCoverArtChanged(null);
            }
        }
        if (this.isOnStartup()) {
            if (this.currentDetailInfo.isVideo()) {
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] PLAY CONTENTTYPE=VIDEO");
            } else {
                this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] PLAY CONTENTTYPE=AUDIO");
            }
            if (this.getStartupState() == 13) {
                this.setStartupState((byte)14);
            }
        }
    }

    public void updatePlayViewSize(int n, int n2) {
        this.logger.main().log(1000000, "[%1.updatePlayViewSize] '%2','%3'", (Object)LOGCLASS, (long)n, (long)n2);
        int n3 = 0;
        if (this.isOnIPOD && this.getTerminal().getFramework().getSysConst(5572) == 2 && !this.isOnStartup() && n == 1) {
            n3 |= 0x1000;
        }
        if ((n2 & 8) == 8) {
            ++n3;
        }
        boolean bl = false;
        if ((n2 & 2) == 2) {
            bl = true;
            n3 += 2;
        }
        if ((n2 & 0x10) == 16) {
            bl = true;
            n3 += 4;
        }
        if ((n2 & 1) == 1) {
            bl = true;
        }
        if (this.currentPlayViewSize == n && this.currentPlayViewFlag == n3 && !bl) {
            return;
        }
        this.currentPlayViewSize = n;
        this.currentPlayViewFlag = n3;
        if ((n2 & 8) == 8) {
            this.selectionState = 0;
            if (this.isOnStartup() && this.capabilities.isPlayView()) {
                this.setNoPlayableFiles();
            }
        }
        if (this.selectionState == 1) {
            this.selectionState = 2;
        } else if (this.selectionState == 0) {
            this.notifyPlayViewUpdateSize(this.currentPlayViewSize, this.currentPlayViewFlag);
        }
        if (this.getStartupState() == 11) {
            this.setStartupState((byte)12);
        }
    }

    protected boolean isPlayViewSizeValid() {
        return this.currentPlayViewSize != -1;
    }

    public void playViewSizeInvalidated() {
        this.logger.main().log(1000000, "[%1.playViewSizeInvalidated]", (Object)LOGCLASS);
        this.currentPlayViewSize = -1;
        this.selectionState = 1;
        this.responseExpected = false;
        this.notifyPlayViewSizeInvalid();
    }

    public void responsePlayView(RequestParameterList requestParameterList, MediaListEntry[] mediaListEntryArray, int n, int n2) {
        if (requestParameterList == null || requestParameterList.isOutdated()) {
            this.logger.main().log(1000000, "[%1.responsePlayView] Request outdated or not exists. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.main().log(1000000, "[%1.responsePlayView] clientID='%2'", (Object)LOGCLASS, (Object)MediaUtils.getPlayViewClientIDToStr(requestParameterList.getClientID()));
        this.notifyPlayViewResponse(requestParameterList.getClientID(), mediaListEntryArray, n, n2);
    }

    public ButtonListener getHardKeyListener() {
        return this.hardKeyHandler;
    }

    public void updatePlaybackFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.dsi().log(1000000, "[%1.updatePlaybackFolder]", (Object)LOGCLASS);
        this.currentPlaybackFolder = mediaListEntryArray;
        if (this.isOnStartup() && (this.getActiveSlot().getSource().getType() == 3 || this.getActiveSlot().getSource().getType() == 1)) {
            if (this.currentPlayingTrack.getEntryID() != -1L) {
                this.logger.dsi().log(1000000, "[%1.updatePlaybackFolder] External Device on startup -> The current playing track entryID is not invalid.", (Object)LOGCLASS);
            }
            this.logger.dsi().log(1000000, "[%1.updatePlaybackFolder] External Device on startup -> Don't invalidate the current playing track entryID.", (Object)LOGCLASS);
        } else if (this.getActiveSlot().getSource().getType() == 11) {
            this.logger.dsi().log(1000000, "[%1.updatePlaybackFolder] Bluetooth source -> Don't invalidate the current playing track entryID.", (Object)LOGCLASS);
        } else {
            this.logger.dsi().log(1000000, "[%1.updatePlaybackFolder] Invalidate the current playing track entryID.", (Object)LOGCLASS);
            this.currentPlayingTrack = new PlayingTrack(-1L, this.currentPlaybackFolder);
        }
        this.notifyPlaybackFolderChanged(this.currentPlaybackFolder);
    }

    MediaListEntry[] getCurrentPlaybackFolder() {
        return this.currentPlaybackFolder;
    }

    public void setPlaybackMode(int n) {
        this.logger.main().log(1000000, "[%1.setPlaybackMode] '%2'", (Object)LOGCLASS, (long)n);
        this.dsiPlayer.setPlaybackMode(n);
    }

    public void updatePlaybackMode(int n) {
        this.logger.dsi().log(1000000, "[%1.updatePlaybackMode] '%2'", (Object)LOGCLASS, (long)n);
        this.playbackMode = n;
        this.playbackModeHandler.updateActivePlaybackMode(n);
        if (this.getStartupState() == 5) {
            if (this.getTerminal().getFramework().isEvoStd() && this.playbackModeHandler.isRepeatOff() && !this.supportsPlaybackModeToggle()) {
                this.setStartupState((byte)6);
            } else {
                this.setStartupState((byte)7);
            }
        } else if (this.getStartupState() == 6) {
            this.setStartupState((byte)7);
        }
    }

    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
        this.playbackModeList = playbackModeArray;
        this.playbackModeHandler.updatePlaybackModeList(playbackModeArray);
    }

    public void updatePlaybackState(int n) {
        this.logger.main().log(1000000, "[%1.updatePlaybackState]", (Object)LOGCLASS);
        int n2 = this.currentPlaybackState;
        this.currentPlaybackState = n;
        this.dvdMenuPlaying = false;
        this.updateHMIPlaybackState(n);
        this.updateVolumelockOnPlaybackState(n);
        this.updateControlButtonStateOnPlaybackState(n);
        this.updateSeekStateOnPlaybackState(n, n2);
        this.handleAudioStateOnPlaybackState(n);
        this.notifyPlayerPlaybackStateChanged(n);
        switch (n) {
            case 1: {
                if (this.getStartupState() == 3) {
                    this.setStartupState((byte)4);
                    return;
                }
                this.resume();
                break;
            }
            case 11: {
                if (this.isOnStartup()) {
                    this.setStartupState((byte)15);
                    return;
                }
                this.logger.main().log(1000000, "[%1.updatePlaybackState] Invalidate detail info.", (Object)LOGCLASS);
                this.currentDetailInfo = new MediaDetailInfo();
                this.currentCoverArt = null;
                this.notifyDetailInfoChanged(this.currentDetailInfo);
                break;
            }
        }
    }

    private void updateHMIPlaybackState(int n) {
        int n2;
        switch (n) {
            case 10: {
                n2 = 6;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 6: 
            case 8: {
                n2 = 2;
                break;
            }
            case 7: 
            case 9: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 11: {
                n2 = 5;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        this.hmiHandler.setHMIPlaybackState(n2);
    }

    private void updateSeekStateOnPlaybackState(int n, int n2) {
        if (AbstractMediaPlayer.isSeeking(n2) && !AbstractMediaPlayer.isSeeking(n)) {
            this.stopSeek(false);
        }
    }

    private void updateVolumelockOnPlaybackState(int n) {
        boolean bl;
        switch (n) {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        if (bl) {
            this.getTerminal().getAudioManager().releaseVolumelock("Player ready.");
        } else {
            this.getTerminal().getAudioManager().requestVolumelock(new StringBuffer().append("Player not ready (playbackState='").append(n).append("'").toString());
        }
    }

    private void updateControlButtonStateOnPlaybackState(int n) {
        switch (n) {
            case 3: 
            case 10: {
                this.getButtonModel(200258).setPressed(false);
                this.getButtonModel(200263).setPressed(false);
                this.getButtonModel(200264).setPressed(false);
                break;
            }
            case 7: 
            case 9: {
                this.getButtonModel(200258).setPressed(false);
                this.getButtonModel(200263).setPressed(true);
                this.getButtonModel(200264).setPressed(false);
                break;
            }
            case 6: 
            case 8: {
                this.getButtonModel(200258).setPressed(false);
                this.getButtonModel(200263).setPressed(false);
                this.getButtonModel(200264).setPressed(true);
                break;
            }
            case 0: {
                break;
            }
            default: {
                this.getButtonModel(200258).setPressed(true);
                this.getButtonModel(200263).setPressed(false);
                this.getButtonModel(200264).setPressed(false);
            }
        }
    }

    private void handleAudioStateOnPlaybackState(int n) {
        switch (n) {
            case 3: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                this.getTerminal().getAudioManager().fadeTo();
                break;
            }
        }
    }

    public void indicationDvdEvent(int n) {
        if (n == 1) {
            if (!this.dvdMenuPlaying) {
                this.dvdMenuPlaying = true;
                this.logger.main().log(1000000, "[%1.indicationDvdEvent] DVD Menu entered.", (Object)LOGCLASS);
                this.notifyPlayerPlaybackStateChanged(10);
                this.updateHMIPlaybackState(10);
            }
        } else if (n == 0 && this.dvdMenuPlaying) {
            this.logger.main().log(1000000, "[%1.indicationDvdEvent] DVD Menu left.", (Object)LOGCLASS);
            this.dvdMenuPlaying = false;
            this.notifyPlayerPlaybackStateChanged(this.currentPlaybackState);
            this.updateHMIPlaybackState(this.currentPlaybackState);
        }
    }

    public void responseCmdBlocked(int n) {
    }

    public void responseCoverArtURL(RequestParameterEntryID requestParameterEntryID, long l, ResourceLocator resourceLocator) {
        this.logger.dsi().log(1000000, "[%1.responseCoverArtURL]", (Object)LOGCLASS);
        if (requestParameterEntryID != null && requestParameterEntryID.isOutdated()) {
            this.logger.dsi().log(10000000, "[%1.responseCoverArtURL] Cover art URL outdated. Ignore.", (Object)LOGCLASS);
            return;
        }
        if (l != this.currentPlayingTrack.getEntryID()) {
            this.logger.dsi().log(10000000, "[%1.responseCoverArtURL] Responded cover art URL belongs not to the current track. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.currentCoverArt = resourceLocator;
        this.notifyCoverArtChanged(resourceLocator);
    }

    public void responseFullyQualifiedName(long l, String string) {
    }

    public void responsePlaySimilarEntry(long l, boolean bl) {
    }

    public void responseSetPlaySelection(int n, boolean bl) {
        this.logger.main().log(1000000, "[%1.responseSetPlaySelection] '%2','%3'", (Object)LOGCLASS, (Object)String.valueOf(n), (Object)bl);
        if (!bl) {
            this.notifyPlaySelectionResult(false);
            return;
        }
        this.resume();
        this.notifyPlaySelectionResult(true);
    }

    public void responseSetPlaySelectionCoverflow(int n, boolean bl) {
    }

    public void responseTempPMLRequest(int n) {
        this.notifyCurrentPMLevel(n);
    }

    public void updateActiveAudioStream(int n) {
    }

    public void updateActiveSubtitle(int n) {
    }

    public void updateActiveVideoAngle(int n) {
    }

    public void updateAudioStreamList(AudioStream[] audioStreamArray) {
    }

    public void updateCapabilities(Capabilities capabilities) {
        this.logger.main().log(1000000, "[%1.performCapabilitiesUpdate]", (Object)LOGCLASS);
        this.capabilities = capabilities;
        this.hmiHandler.setHMIPlayerCapabilities(capabilities);
        this.notifyPlayerCapabilitiesChanged(this.capabilities);
        if (this.getStartupState() == 1) {
            this.setStartupState((byte)2);
        } else if (this.getStartupState() == 11 && !capabilities.isPlayView()) {
            this.setStartupState((byte)12);
        }
    }

    protected void setNoPlayableFiles() {
    }

    protected final boolean supportsCoverart() {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot != null) {
            return iSourceSlot.getCapabilities().isPlayerCoverart();
        }
        return false;
    }

    protected boolean supportsPlaymodes() {
        return this.mediaCapabilities.isPlaymodes();
    }

    public boolean supportsVideoPlayback() {
        ISourceSlot iSourceSlot = this.getActiveSlot();
        if (iSourceSlot != null) {
            return iSourceSlot.getCapabilities().isVideo();
        }
        return false;
    }

    public final boolean supportsTimeToSeek() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isSetTimePos() : false;
    }

    public boolean supportsExtendedPlayView() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isExtendedPlayView() : false;
    }

    public boolean supportsPlayListHandling() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isPlayView() : false;
    }

    public final boolean supportsPlaySimilar() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isPlaySimilarEntries() : false;
    }

    protected final boolean supportsSeekForward() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isFastFwd() || capabilities.isSloMoFwd() : false;
    }

    protected final boolean supportsSeekBackward() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isFastBwd() || capabilities.isSloMoBwd() : false;
    }

    protected final boolean supportsSkipFW() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isSkipFwd() : false;
    }

    protected final boolean supportsSkipBW() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isSkipBwd() : false;
    }

    public final boolean supportsDetailInfo() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isDetailInfos() : false;
    }

    public boolean supportsPlaytime() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isPlayTime() : false;
    }

    public boolean supportsPlaybackModeTakeOver() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isPlaybackModeTakeOver() : false;
    }

    public boolean supportsPlaybackModeToggle() {
        Capabilities capabilities = this.capabilities;
        return capabilities != null ? capabilities.isPlaybackModeToggle() : false;
    }

    public IPlaybackModeHandler getPlaybackModeHandler() {
        return this.playbackModeHandler;
    }

    public boolean isPlayerStartupComplete() {
        return !this.isOnStartup();
    }

    public void updateCmdBlockingMask(int n) {
    }

    public void updateNumVideoAngles(int n) {
    }

    public void updateSubtitleList(int[] nArray) {
    }

    public void updateVideoFormat(int n) {
    }

    public void updateVideoNorm(int n) {
    }

    public void responseSetPlaybackURL(String string) {
    }

    public void responseFidForPlaylistEntryID(long l, long l2) {
    }

    public void errorPlayViewListRequestAborted(int n) {
        this.logger.main().log(1000000, "[%1.errorPlayViewListRequestAborted] clientID='%2'.", (Object)LOGCLASS, (long)n);
        if (!this.responseExpected && n == 3) {
            this.logger.main().log(100000, "[%1.errorPlayViewListRequestedAborted] clientID %2, no valid playview size - suppressing notification", (Object)LOGCLASS, (long)n);
            return;
        }
        CopyOnWriteMap copyOnWriteMap = this.registeredPlayViewListener;
        IPlayerViewListener iPlayerViewListener = (IPlayerViewListener)copyOnWriteMap.get(new Integer(n));
        if (iPlayerViewListener == null) {
            return;
        }
        iPlayerViewListener.errorListRequestAborted();
    }

    public void error(int n) {
        this.logger.main().log(100000, "[%1.error] requestType='%2'", (Object)LOGCLASS, (long)n);
        switch (n) {
            case 1005: {
                this.logger.main().log(100000, "[%1.error] SETENTRY failed.", (Object)LOGCLASS);
                this.setNotifyTrackEvents(true);
                this.playPositionInvalidated();
                break;
            }
            case 1021: {
                this.logger.main().log(100000, "[%1.error] SETPLAYSELECTION failed.", (Object)LOGCLASS);
                this.notifyPlaySelectionResult(false);
                break;
            }
        }
    }

    protected final IMediaDSIPlayerController getDSIPlayer() {
        return this.dsiPlayer;
    }

    protected final AudioState getCurrentAudioState() {
        return this.currentAudioState;
    }

    public void audioStateChanged(AudioState audioState) {
        if (!this.isActive()) {
            this.logger.main().log(1000000, "[%1.audioStateChanged] Not active any more.", (Object)LOGCLASS, (Object)audioState);
            return;
        }
        this.logger.main().log(1000000, "[%1.audioStateChanged] '%2'", (Object)LOGCLASS, (Object)audioState);
        this.currentAudioState = audioState;
        if (this.isNotReadyToPlay()) {
            this.logger.main().log(1000000, "[%1.audioStateChanged] Not ready to play.", (Object)LOGCLASS);
            return;
        }
        if (this.getStartupState() < 8) {
            this.logger.main().log(1000000, "[%1.audioStateChanged] On startup.", (Object)LOGCLASS, (Object)audioState);
            return;
        }
        switch (audioState.getState()) {
            case 2: {
                this.syncStartConnection = true;
                if (!AudioManager.isSDISConnection(audioState.getConnection())) {
                    this.getTerminal().getAudioManager().requestSdisConnectionsIfRequired(audioState.getConnection());
                }
                if (this.isSeeking()) {
                    this.logger.main().log(1000000, "[%1.audioStateChanged] On seeking. Fade to connection.", (Object)LOGCLASS, (Object)audioState);
                    this.getTerminal().getAudioManager().fadeTo();
                    return;
                }
                if (this.isPlaying()) {
                    this.logger.main().log(1000000, "[%1.audioStateChanged] Already playing. Fade to connection.", (Object)LOGCLASS, (Object)audioState);
                    this.getTerminal().getAudioManager().fadeTo();
                }
                this.dsiPlayer.resume();
                break;
            }
            case 3: {
                this.logger.main().log(1000000, "[%1.audioStateChanged] Pause playback. (AUDIO_STATE_PAUSED)", (Object)LOGCLASS, (Object)audioState);
                if (this.isActiveSDISAndStandby()) {
                    this.logger.audio().log(1000000, "[%1.pause] SDIS active on internal source and standby active. Ignore.", (Object)LOGCLASS);
                    break;
                }
                if (this.currentPlaybackState == 4) {
                    this.logger.main().log(1000000, "[%1.audioStateChanged] Resume playback from STOPPED state.", (Object)LOGCLASS);
                    this.getTerminal().getAudioManager().demute();
                    break;
                }
                this.pausePlaybackNoCheck();
                break;
            }
            case 5: {
                this.logger.main().log(1000000, "[%1.audioStateChanged] Stop playback. (AUDIO_STATE_STOPPED)", (Object)LOGCLASS, (Object)audioState);
                if (!this.rearSeatAudioFocus) {
                    this.pausePlaybackNoCheck();
                    break;
                }
                this.logger.main().log(1000000, "[%1.audioStateChanged] Rearseat has the media audio focus. Do not Pause the playback. (AUDIO_STATE_STOPPED)", (Object)LOGCLASS, (Object)audioState);
                break;
            }
            case 6: {
                this.dsiPlayer.pause();
                break;
            }
            case 4: {
                if (!this.isOnStartup() || this.syncStartConnection || this.getStartupState() < 8) break;
                this.dsiPlayer.resume();
                break;
            }
            default: {
                this.dsiPlayer.pause();
            }
        }
    }

    void pausePlaybackNoCheck() {
        if (this.isSeeking()) {
            this.stopSeek(false);
        }
        this.dsiPlayer.pause();
    }

    boolean isSDISConnected() {
        return this.getChoiceModel(3913).getValue() == 1;
    }

    boolean isInternalSourceActive() {
        switch (this.sourceTypeOfActiveSource) {
            case 0: 
            case 2: 
            case 5: 
            case 6: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    boolean isActiveSDISAndStandby() {
        this.logger.main().log(1000000, "[AbstractMediaPlayer.isActiveSDISAndStandby] isSDIS=%1, isStandby=%2, hasRearAudioFocus=%3, isInternalSource=%4", (Object)Boolean.toString(this.isSDISConnected()), (Object)Boolean.toString(this.getTerminal().getAudioManager().isStandbyMuted()), (Object)Boolean.toString(this.rearSeatAudioFocus), (Object)Boolean.toString(this.isInternalSourceActive()));
        return this.getTerminal().getAudioManager().isStandbyMuted() && this.isSDISConnected() && this.rearSeatAudioFocus && (this.isInternalSourceActive() || this.sourceTypeOfActiveSource == 1 || this.sourceTypeOfActiveSource == 3);
    }

    public void audioFocusChanged(boolean bl) {
        int n = this.activationContext.getSlot().getSource().getAudioConnection(this.activationContext.getSlot());
        this.getTerminal().getAudioManager().requestAudio(n, true);
    }

    public void rearSeatAudioFocusChanged(boolean bl) {
        this.logger.main().log(1000000, "[%1.rearSeatAudioFocusChanged] rearSeatAudioFocus: '%2'", (Object)LOGCLASS, (Object)bl);
        this.rearSeatAudioFocus = bl;
    }

    public void activeSourceChanged(boolean bl, ActiveSourceState activeSourceState) {
        MediaCapabilities mediaCapabilities = activeSourceState.getSlot().getCapabilities();
        boolean bl2 = this.mediaCapabilities.isPlaymodes() != mediaCapabilities.isPlaymodes();
        this.mediaCapabilities = mediaCapabilities;
        this.logger.main().log(1000000, "[%1.activeSourceChanged] playModesChanged=%2 supportsPlaymodes=%3", (Object)LOGCLASS, (Object)bl2, (Object)this.supportsPlaymodes());
        if (bl2) {
            this.playbackModeHandler.updatePlaymodesAvailable(this.mediaCapabilities.isPlaymodes());
        }
        this.mediaTypeOfActiveSource = activeSourceState.getSlot().getMediaType();
        this.sourceTypeOfActiveSource = activeSourceState.getSlot().getSource().getType();
    }

    public void sourceDeactivated() {
    }

    protected boolean setPlaytimeInModel() {
        return this.currentDetailInfo != null && this.currentDetailInfo.isVideo() || !this.capabilities.isPlayView();
    }

    protected void logNewTrackTitleToSerialPort(I18NString i18NString) {
        if (!this.logTrackInfoToSerialPort) {
            return;
        }
        Buffer buffer = new Buffer("[MEDIA-PLAYER] TRACK CHANGED - New track title: ");
        buffer.append(i18NString.getI18NString());
        System.out.println(buffer);
    }

    protected void notifySelectionFinished() {
        this.logger.main().log(1000000, "[%1.notifySelectionFinished] ", (Object)LOGCLASS);
        this.trackSelected = true;
    }

    MediaCapabilities getMediaCapabilities() {
        return this.mediaCapabilities;
    }

    int getMediaTypeOfActiveSource() {
        return this.mediaTypeOfActiveSource;
    }

    int getSourceTypeOfActiveSource() {
        return this.sourceTypeOfActiveSource;
    }
}

