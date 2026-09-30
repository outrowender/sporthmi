/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentListener;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.IPlayViewListRequest;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.NullPlayer;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.sdis.IMediaSDISNotifier;
import de.audi.app.media.sdis.JobPlayViewListRequest;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Dictionary;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class MediaSDISContentHandler
implements IContentListener,
IPlayerTrackListener,
IPlayerViewListener,
IPlayerListener,
ButtonListener {
    private static final String LOGCLASS = "MediaSDISContentHandler";
    public static final int SDIS_REQUEST_PLAYVIEW_ID = 5;
    private static final NullPlayer NULL_PLAYER = new NullPlayer();
    private final LogChannel logger;
    private final IMediaTerminal terminal;
    private final Queue listRequestQueue;
    private volatile IMediaSDISNotifier notifier;
    private volatile MediaDetailInfo detailInfo;
    private volatile String currentCoverURL;
    private volatile IPlayer activePlayer = NULL_PLAYER;
    private final AbstractServiceListTracker sdisBlockingServiceTracker;
    private volatile ASIHMISyncMediaReply activeSDISReplyService;
    private volatile int playbackState;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingService;

    public MediaSDISContentHandler(LogChannel logChannel, IMediaTerminal iMediaTerminal) {
        this.logger = logChannel;
        this.terminal = iMediaTerminal;
        this.listRequestQueue = new Queue(logChannel, "PLAYVIEW");
        this.sdisBlockingServiceTracker = new AbstractServiceListTracker(logChannel, this.terminal.getServiceManager()){

            protected void serviceRemoved(Object object) {
            }

            protected void serviceAdded(Object object) {
            }

            protected Class getTrackedServiceClass() {
                return class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = MediaSDISContentHandler.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService;
            }

            protected boolean checkServiceProperties(Dictionary dictionary) {
                return true;
            }
        };
    }

    public void init(IMediaSDISNotifier iMediaSDISNotifier) {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.notifier = iMediaSDISNotifier;
        this.terminal.getContentManager().addContentListener(this);
        ((ButtonModelApp)this.terminal.getFramework().getHmiServiceApp().getModelApp(this.terminal.getTerminalID(), 200736)).setButtonListener(this);
        this.sdisBlockingServiceTracker.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.sdisBlockingServiceTracker.deinit();
        this.tryToResetButtonListener();
    }

    private void tryToResetButtonListener() {
        this.logger.log(1000000, "[%1.tryToResetButtonListener]", (Object)LOGCLASS);
        IHMIServiceApp iHMIServiceApp = this.terminal.getFramework().getHmiServiceApp();
        if (iHMIServiceApp != null) {
            ButtonModelApp buttonModelApp = (ButtonModelApp)iHMIServiceApp.getModelApp(this.terminal.getTerminalID(), 200736);
            if (buttonModelApp != null) {
                buttonModelApp.resetListener();
            } else {
                this.logger.log(100000, "[%1.tryToResetButtonListener] Failed. The buttonModel is null.", (Object)LOGCLASS);
            }
        } else {
            this.logger.log(100000, "[%1.tryToResetButtonListener] Failed. The hmiService is null.", (Object)LOGCLASS);
        }
    }

    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.contentActivated] '%2'", (Object)LOGCLASS, (Object)iContent);
        if (!(iContent instanceof IContentMedia)) {
            this.logger.log(1000000, "[%1.contentActivated] Not supported content.", (Object)LOGCLASS);
            this.activePlayer = NULL_PLAYER;
            return;
        }
        IContentMedia iContentMedia = (IContentMedia)iContent;
        this.activePlayer = iContentMedia.getPlayer();
        iContentMedia.getPlayer().addPlayerListener(this);
        iContentMedia.getPlayer().addTrackListener(this);
        iContentMedia.getPlayer().addViewListener(this);
    }

    public void contentDeactivated(IContent iContent) {
        this.logger.log(1000000, "[%1.contentDeactivated]", (Object)LOGCLASS);
        this.listRequestQueue.abort();
        this.listRequestQueue.reset();
        this.notifier.updatePlaybackState(0);
        this.notifier.updateMix(false);
        this.notifier.updateRepeatTitle(false);
        this.notifier.updatePlayingPosition(null, null);
        this.notifier.updatePlayingTrack(null, "");
        this.activePlayer = NULL_PLAYER;
    }

    public void contentActivationFinished(IContent iContent) {
    }

    public void playEntry(final long l) {
        this.logger.log(1000000, "[%1.playEntry] '%2'", (Object)LOGCLASS, l);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.play"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onPlayEntry] '%2'", (Object)MediaSDISContentHandler.LOGCLASS, l);
                MediaSDISContentHandler.this.activePlayer.playEntry(l);
            }
        });
    }

    public void resume() {
        this.logger.log(1000000, "[%1.resume]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.resume"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onResume]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.resume();
            }
        });
    }

    public void pause() {
        this.logger.log(1000000, "[%1.pause]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.pause"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onPause]", (Object)MediaSDISContentHandler.LOGCLASS);
                if (MediaSDISContentHandler.this.terminal.getAudioManager().hasFrontAudioFocus() && !MediaSDISContentHandler.this.terminal.getAudioManager().isStandbyMuted()) {
                    MediaSDISContentHandler.this.terminal.getAudioManager().mute();
                } else {
                    MediaSDISContentHandler.this.activePlayer.pause();
                }
            }
        });
    }

    public void skip(final int n) {
        this.logger.log(1000000, "[%1.skip]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.skip"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onSkip]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.skip(n > 0, Math.abs(n));
            }
        });
    }

    public void startSeek(final boolean bl) {
        this.logger.log(1000000, "[%1.startSeek] '%2'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.seek"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onStartSeek]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.startSeek(bl);
            }
        });
    }

    public void stopSeek() {
        this.logger.log(1000000, "[%1.stopSeek]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.stopSeek"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onStopSeek]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.stopSeek(true);
            }
        });
    }

    public void mix(final boolean bl) {
        this.logger.log(1000000, "[%1.mix] '%2'", (Object)LOGCLASS, (Object)(bl ? "ON" : "OFF"));
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.mix"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onMix]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.getPlaybackModeHandler().setRepeatScope(MediaSDISContentHandler.this.activePlayer.getPlaybackModeHandler().getActiveRepeatScope(), bl);
            }
        });
    }

    public void repeatTitle(final boolean bl) {
        this.logger.log(1000000, "[%1.repeatTitle] '%2'", (Object)LOGCLASS, (Object)(bl ? "ON" : "OFF"));
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.repeatTitle"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onRepeatTitle]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.getPlaybackModeHandler().setRepeatTitle(bl);
            }
        });
    }

    public void setTimePosition(final int n) {
        this.logger.log(1000000, "[%1.setTimePosition] '%2'", (Object)LOGCLASS, (long)n);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.setTimePosition"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onSetTimePosition]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.setPlayPosition(n);
            }
        });
    }

    public void touchEvent(final boolean bl, final int n, final int n2, final int n3, final int n4) {
        this.logger.log(1000000, "[%1.touchEvent]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.touchEvent"){

            public void run() {
                float f2;
                float f3;
                int n8;
                int n22;
                switch (MediaSDISContentHandler.this.terminal.getFramework().getScreenRes()) {
                    case 2: {
                        n22 = 1024;
                        n8 = 480;
                        break;
                    }
                    case 4: {
                        n22 = 1440;
                        n8 = 540;
                        break;
                    }
                    default: {
                        n22 = 800;
                        n8 = 480;
                    }
                }
                float f4 = (float)n3 / (float)n4;
                if (MediaSDISContentHandler.this.playbackState != 5) {
                    int n32 = MediaSDISContentHandler.this.terminal.getMediaPersistence().getStorage().load(MediaSDISContentHandler.this.terminal, 170, 0, 0, 5);
                    switch (n32) {
                        case 4: {
                            f4 = 2.35f;
                            break;
                        }
                        case 3: {
                            f4 = 1.5555556f;
                            break;
                        }
                        case 2: {
                            f4 = 1.7777778f;
                            break;
                        }
                        case 1: {
                            f4 = 1.3333334f;
                            break;
                        }
                    }
                }
                if ((f3 = (float)n22) / f4 > (f2 = (float)n8)) {
                    f3 = f2 * f4;
                } else {
                    f2 = f3 / f4;
                }
                int n42 = (int)(((float)n22 - f3) / 2.0f);
                int n5 = (int)(((float)n8 - f2) / 2.0f);
                float f5 = (float)n / (float)n3;
                float f6 = (float)n2 / (float)n4;
                int n6 = Math.round(f5 * f3) + n42;
                int n7 = Math.round(f6 * f2) + n5;
                if (MediaSDISContentHandler.this.logger.isInfo()) {
                    Buffer buffer = new Buffer();
                    buffer.append(bl ? "CLICK_ACTIVE" : "CLICK").append(",rX='").append(n).append("',rY='").append(n2).append("',rResX='").append(n3).append("',rResY='").append(n4).append("',resX='").append(n22).append("',resY='").append(n8).append("',x='").append(n6).append("',y='").append(n7).append("'");
                    MediaSDISContentHandler.this.logger.log(1000000, "[%1.ontouchEvent] %2", (Object)MediaSDISContentHandler.LOGCLASS, (Object)buffer);
                }
                MediaSDISContentHandler.this.activePlayer.touchEvent(bl ? 1 : 0, n6, n7);
            }
        });
    }

    public void executeMenuCommand(final int n) {
        this.logger.log(100000000, "[%1.executeMenuCommand] command=%2", (Object)LOGCLASS, (long)n);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.executeDVDCommand"){

            public void run() {
                int n2;
                switch (n) {
                    case 5: {
                        n2 = 4;
                        break;
                    }
                    case 7: {
                        n2 = 7;
                        break;
                    }
                    case 2: {
                        n2 = 6;
                        break;
                    }
                    case 1: {
                        n2 = 1;
                        break;
                    }
                    case 6: {
                        n2 = 2;
                        break;
                    }
                    case 3: {
                        n2 = 5;
                        break;
                    }
                    case 4: {
                        n2 = 3;
                        break;
                    }
                    default: {
                        return;
                    }
                }
                MediaSDISContentHandler.this.activePlayer.executeMenuCommand(n2);
            }
        });
    }

    public void requestPlayList(final IPlayViewListRequest iPlayViewListRequest) {
        this.logger.log(1000000, "[%1.requestPlayList]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.requestPlaylist"){

            public void run() {
                if (!MediaSDISContentHandler.this.activePlayer.supportsPlayListHandling()) {
                    MediaSDISContentHandler.this.logger.log(1000000, "[%1.onRequestPlayList] No list support.", (Object)MediaSDISContentHandler.LOGCLASS);
                    iPlayViewListRequest.responsePlayList(false, 0, new MediaListEntry[0]);
                    return;
                }
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onRequestPlayList]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.listRequestQueue.enqueue(new JobPlayViewListRequest(MediaSDISContentHandler.this.logger, iPlayViewListRequest, MediaSDISContentHandler.this.activePlayer));
            }
        });
    }

    public void setPlaySelection(final IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.logger.log(1000000, "[%1.setPlaySelection] '%2'", (Object)LOGCLASS, (Object)iPlayerSelectionRequest);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.setPlaySelection"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onSetPlaySelection] '%2'", (Object)MediaSDISContentHandler.LOGCLASS, (Object)iPlayerSelectionRequest);
                MediaSDISContentHandler.this.activePlayer.setBrowserPlayerSelection(iPlayerSelectionRequest);
            }
        });
    }

    public void playMoreOf(final long l, final int n, final ISelectionListener iSelectionListener) {
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.playMoreOf"){

            public void run() {
                int n2;
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.playMoreOf]", (Object)MediaSDISContentHandler.LOGCLASS);
                if (!MediaSDISContentHandler.this.activePlayer.supportsPlayMoreOf()) {
                    MediaSDISContentHandler.this.logger.log(1000000, "[%1.playMoreOf] not supported", (Object)MediaSDISContentHandler.LOGCLASS);
                    iSelectionListener.notifySelectionChanged(null, false);
                }
                switch (n) {
                    case 3: {
                        n2 = 3;
                        break;
                    }
                    case 2: {
                        n2 = 4;
                        break;
                    }
                    case 1: {
                        n2 = 5;
                        break;
                    }
                    default: {
                        MediaSDISContentHandler.this.logger.log(1000000, "[%1.playMoreOf] category unknown '%2'", (Object)MediaSDISContentHandler.LOGCLASS, (long)n);
                        iSelectionListener.notifySelectionChanged(null, false);
                        return;
                    }
                }
                MediaSDISContentHandler.this.activePlayer.playMoreOf(l, n2, iSelectionListener);
            }
        });
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.notifier.updatePlayingPosition(playingTrack, playTime);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(1000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
        this.detailInfo = mediaDetailInfo;
        this.notifier.updatePlayingTrack(this.detailInfo, this.currentCoverURL);
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
        String string;
        this.logger.log(1000000, "[%1.coverArtChanged]", (Object)LOGCLASS);
        String string2 = string = resourceLocator == null || null == resourceLocator.getUrl() ? "" : resourceLocator.getUrl();
        if (!string.equals(this.currentCoverURL)) {
            this.currentCoverURL = string;
            this.notifier.updatePlayingTrack(this.detailInfo, this.currentCoverURL);
        }
    }

    public void playbackStateChanged(int n) {
        this.logger.log(1000000, "[%1.playbackStateChanged] '%2'", (Object)LOGCLASS, (long)n);
        this.playbackState = n;
        this.notifier.updatePlaybackState(n);
    }

    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1000000, "[%1.repeatScopeChanged]", (Object)LOGCLASS);
        this.notifier.updateMix(bl);
        this.notifier.updateRepeatTitle(n == 3);
    }

    public void repeatModeChanged(int n) {
        this.logger.log(1000000, "[%1.repeatModeChanged] %2", (Object)LOGCLASS, (long)n);
        this.notifier.updateRepeatMode(n);
    }

    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1000000, "[%1.capabilitiesChanged]", (Object)LOGCLASS);
        this.notifier.updatePlayerCapabilities(capabilities);
    }

    public void playerStartupComplete() {
    }

    public void listChangeOnSelection(boolean bl) {
    }

    public void commandBlocked() {
        this.logger.log(1000000, "[%1.commandBlocked]", (Object)LOGCLASS);
        try {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = this.getReplyService();
            if (aSIHMISyncMediaReply == null) {
                this.logger.log(100000, "[%1.commandBlocked] No reply service is available. Can't send indicationCmdBlocked to SDIS.", (Object)LOGCLASS);
            } else {
                this.logger.log(1000000, "[%1.commandBlocked] Send indicationCmdBlocked to '%2'.", (Object)LOGCLASS, (Object)aSIHMISyncMediaReply);
                aSIHMISyncMediaReply.indicationCmdBlocked(1);
            }
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.commandBlocked]", (Object)LOGCLASS, (Throwable)methodException);
        }
    }

    public void currentPMLevelChanged(int n) {
        if (n <= 0) {
            this.notifier.enableTemporalChildLock(false);
        } else {
            this.notifier.enableTemporalChildLock(true);
        }
    }

    public int getClientID() {
        return 5;
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        JobPlayViewListRequest jobPlayViewListRequest = (JobPlayViewListRequest)this.listRequestQueue.getRunningJob();
        if (jobPlayViewListRequest == null) {
            this.logger.log(1000000, "[%1.responsePlayView] No running job.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.responsePlayView]", (Object)LOGCLASS);
        jobPlayViewListRequest.responsePlayView(true, n, mediaListEntryArray);
    }

    public void errorListRequestAborted() {
        JobPlayViewListRequest jobPlayViewListRequest = (JobPlayViewListRequest)this.listRequestQueue.getRunningJob();
        if (jobPlayViewListRequest == null) {
            this.logger.log(1000000, "[%1.errorListRequestAborted] No running job.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.errorListRequestAborted]", (Object)LOGCLASS);
        jobPlayViewListRequest.responsePlayView(false, 0, new MediaListEntry[0]);
    }

    public void listChanged(boolean bl, long l, int n, int n2) {
        this.logger.log(1000000, "[%1.listChanged] '%2'", (Object)LOGCLASS, (long)n);
        this.notifier.updatePlayListState(bl, l, n, n2);
    }

    public void listInvalidated() {
    }

    public void keyTyped(int n, int n2, int n3) {
        if (200736 == n) {
            this.logger.log(1000000, "[%1.keyTyped] DATA_PLAYER_R_S_E_BUTTON", (Object)LOGCLASS);
            List list = this.sdisBlockingServiceTracker.getServices();
            if (list.isEmpty()) {
                this.logger.log(1000000, "[%1.keyTyped] No SDIS service available.", (Object)LOGCLASS);
                return;
            }
            ((ISDISBlockingService)list.get(0)).enterAppContext(2, "");
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.logger.log(1000000, "[%1.notifySameTrackSelected] detailInfo:'%2', coverArt:'%3'.", (Object)LOGCLASS, (Object)mediaDetailInfo, (Object)resourceLocator);
        this.notifier.updatePlayingTrack(this.detailInfo, this.currentCoverURL);
    }

    public void toggleRepeatMode() {
        this.logger.log(1000000, "[%1.toggleRepeatMode]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.toggleRepeatMode"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onToggleRepeatMode]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.getPlaybackModeHandler().toggleRepeatMode();
            }
        });
    }

    public void toggleMixMode() {
        this.logger.log(1000000, "[%1.toggleMixMode]", (Object)LOGCLASS);
        this.terminal.getDispatcher().execute(new AbstractDispatcherRunnable("SDIS.toggleMixMode"){

            public void run() {
                MediaSDISContentHandler.this.logger.log(1000000, "[%1.onToggleMixMode]", (Object)MediaSDISContentHandler.LOGCLASS);
                MediaSDISContentHandler.this.activePlayer.getPlaybackModeHandler().toggleMixMode();
            }
        });
    }

    private ASIHMISyncMediaReply getReplyService() {
        ASIHMISyncMediaReply aSIHMISyncMediaReply = this.activeSDISReplyService;
        if (aSIHMISyncMediaReply == null) {
            this.logger.log(10000, "[%1.getReplyService] Reply service is null.", (Object)LOGCLASS);
        }
        return aSIHMISyncMediaReply;
    }

    void setReplyService(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(100000, "[%1.setReplyService] Set replyService from:'%2' to: '%3'.", (Object)LOGCLASS, (Object)this.activeSDISReplyService, (Object)aSIHMISyncMediaReply);
        this.activeSDISReplyService = aSIHMISyncMediaReply;
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

