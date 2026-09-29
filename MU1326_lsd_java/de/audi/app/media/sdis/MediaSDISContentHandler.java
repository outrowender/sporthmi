/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

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
import de.audi.app.media.sdis.MediaSDISContentHandler$1;
import de.audi.app.media.sdis.MediaSDISContentHandler$10;
import de.audi.app.media.sdis.MediaSDISContentHandler$11;
import de.audi.app.media.sdis.MediaSDISContentHandler$12;
import de.audi.app.media.sdis.MediaSDISContentHandler$13;
import de.audi.app.media.sdis.MediaSDISContentHandler$14;
import de.audi.app.media.sdis.MediaSDISContentHandler$15;
import de.audi.app.media.sdis.MediaSDISContentHandler$16;
import de.audi.app.media.sdis.MediaSDISContentHandler$17;
import de.audi.app.media.sdis.MediaSDISContentHandler$2;
import de.audi.app.media.sdis.MediaSDISContentHandler$3;
import de.audi.app.media.sdis.MediaSDISContentHandler$4;
import de.audi.app.media.sdis.MediaSDISContentHandler$5;
import de.audi.app.media.sdis.MediaSDISContentHandler$6;
import de.audi.app.media.sdis.MediaSDISContentHandler$7;
import de.audi.app.media.sdis.MediaSDISContentHandler$8;
import de.audi.app.media.sdis.MediaSDISContentHandler$9;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class MediaSDISContentHandler
implements IContentListener,
IPlayerTrackListener,
IPlayerViewListener,
IPlayerListener,
ButtonListener {
    private static final String LOGCLASS;
    public static final int SDIS_REQUEST_PLAYVIEW_ID;
    private static final NullPlayer NULL_PLAYER;
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
        this.sdisBlockingServiceTracker = new MediaSDISContentHandler$1(this, logChannel, this.terminal.getServiceManager());
    }

    public void init(IMediaSDISNotifier iMediaSDISNotifier) {
        this.logger.log(1078071040, "[%1.init]", (Object)"MediaSDISContentHandler");
        this.notifier = iMediaSDISNotifier;
        this.terminal.getContentManager().addContentListener(this);
        ((ButtonModelApp)this.terminal.getFramework().getHmiServiceApp().getModelApp(this.terminal.getTerminalID(), 537920256)).setButtonListener(this);
        this.sdisBlockingServiceTracker.init();
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"MediaSDISContentHandler");
        this.sdisBlockingServiceTracker.deinit();
        this.tryToResetButtonListener();
    }

    private void tryToResetButtonListener() {
        this.logger.log(1078071040, "[%1.tryToResetButtonListener]", (Object)"MediaSDISContentHandler");
        IHMIServiceApp iHMIServiceApp = this.terminal.getFramework().getHmiServiceApp();
        if (iHMIServiceApp != null) {
            ButtonModelApp buttonModelApp = (ButtonModelApp)iHMIServiceApp.getModelApp(this.terminal.getTerminalID(), 537920256);
            if (buttonModelApp != null) {
                buttonModelApp.resetListener();
            } else {
                this.logger.log(-1601830656, "[%1.tryToResetButtonListener] Failed. The buttonModel is null.", (Object)"MediaSDISContentHandler");
            }
        } else {
            this.logger.log(-1601830656, "[%1.tryToResetButtonListener] Failed. The hmiService is null.", (Object)"MediaSDISContentHandler");
        }
    }

    @Override
    public void contentActivated(IContent iContent, ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.contentActivated] '%2'", (Object)"MediaSDISContentHandler", (Object)iContent);
        if (!(iContent instanceof IContentMedia)) {
            this.logger.log(1078071040, "[%1.contentActivated] Not supported content.", (Object)"MediaSDISContentHandler");
            this.activePlayer = NULL_PLAYER;
            return;
        }
        IContentMedia iContentMedia = (IContentMedia)iContent;
        this.activePlayer = iContentMedia.getPlayer();
        iContentMedia.getPlayer().addPlayerListener(this);
        iContentMedia.getPlayer().addTrackListener(this);
        iContentMedia.getPlayer().addViewListener(this);
    }

    @Override
    public void contentDeactivated(IContent iContent) {
        this.logger.log(1078071040, "[%1.contentDeactivated]", (Object)"MediaSDISContentHandler");
        this.listRequestQueue.abort();
        this.listRequestQueue.reset();
        this.notifier.updatePlaybackState(0);
        this.notifier.updateMix(false);
        this.notifier.updateRepeatTitle(false);
        this.notifier.updatePlayingPosition(null, null);
        this.notifier.updatePlayingTrack(null, "");
        this.activePlayer = NULL_PLAYER;
    }

    @Override
    public void contentActivationFinished(IContent iContent) {
    }

    public void playEntry(long l) {
        this.logger.log(1078071040, "[%1.playEntry] '%2'", (Object)"MediaSDISContentHandler", l);
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$2(this, "SDIS.play", l));
    }

    public void resume() {
        this.logger.log(1078071040, "[%1.resume]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$3(this, "SDIS.resume"));
    }

    public void pause() {
        this.logger.log(1078071040, "[%1.pause]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$4(this, "SDIS.pause"));
    }

    public void skip(int n) {
        this.logger.log(1078071040, "[%1.skip]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$5(this, "SDIS.skip", n));
    }

    public void startSeek(boolean bl) {
        this.logger.log(1078071040, "[%1.startSeek] '%2'", (Object)"MediaSDISContentHandler", (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$6(this, "SDIS.seek", bl));
    }

    public void stopSeek() {
        this.logger.log(1078071040, "[%1.stopSeek]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$7(this, "SDIS.stopSeek"));
    }

    public void mix(boolean bl) {
        this.logger.log(1078071040, "[%1.mix] '%2'", (Object)"MediaSDISContentHandler", (Object)(bl ? "ON" : "OFF"));
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$8(this, "SDIS.mix", bl));
    }

    public void repeatTitle(boolean bl) {
        this.logger.log(1078071040, "[%1.repeatTitle] '%2'", (Object)"MediaSDISContentHandler", (Object)(bl ? "ON" : "OFF"));
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$9(this, "SDIS.repeatTitle", bl));
    }

    public void setTimePosition(int n) {
        this.logger.log(1078071040, "[%1.setTimePosition] '%2'", (Object)"MediaSDISContentHandler", (long)n);
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$10(this, "SDIS.setTimePosition", n));
    }

    public void touchEvent(boolean bl, int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.touchEvent]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$11(this, "SDIS.touchEvent", n3, n4, n, n2, bl));
    }

    public void executeMenuCommand(int n) {
        this.logger.log(14808325, "[%1.executeMenuCommand] command=%2", (Object)"MediaSDISContentHandler", (long)n);
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$12(this, "SDIS.executeDVDCommand", n));
    }

    public void requestPlayList(IPlayViewListRequest iPlayViewListRequest) {
        this.logger.log(1078071040, "[%1.requestPlayList]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$13(this, "SDIS.requestPlaylist", iPlayViewListRequest));
    }

    public void setPlaySelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.logger.log(1078071040, "[%1.setPlaySelection] '%2'", (Object)"MediaSDISContentHandler", (Object)iPlayerSelectionRequest);
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$14(this, "SDIS.setPlaySelection", iPlayerSelectionRequest));
    }

    public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$15(this, "SDIS.playMoreOf", iSelectionListener, n, l));
    }

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.notifier.updatePlayingPosition(playingTrack, playTime);
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(1078071040, "[%1.detailInfoChanged]", (Object)"MediaSDISContentHandler");
        this.detailInfo = mediaDetailInfo;
        this.notifier.updatePlayingTrack(this.detailInfo, this.currentCoverURL);
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        String string;
        this.logger.log(1078071040, "[%1.coverArtChanged]", (Object)"MediaSDISContentHandler");
        String string2 = string = resourceLocator == null || null == resourceLocator.getUrl() ? "" : resourceLocator.getUrl();
        if (!string.equals(this.currentCoverURL)) {
            this.currentCoverURL = string;
            this.notifier.updatePlayingTrack(this.detailInfo, this.currentCoverURL);
        }
    }

    @Override
    public void playbackStateChanged(int n) {
        this.logger.log(1078071040, "[%1.playbackStateChanged] '%2'", (Object)"MediaSDISContentHandler", (long)n);
        this.playbackState = n;
        this.notifier.updatePlaybackState(n);
    }

    @Override
    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.repeatScopeChanged]", (Object)"MediaSDISContentHandler");
        this.notifier.updateMix(bl);
        this.notifier.updateRepeatTitle(n == 3);
    }

    @Override
    public void repeatModeChanged(int n) {
        this.logger.log(1078071040, "[%1.repeatModeChanged] %2", (Object)"MediaSDISContentHandler", (long)n);
        this.notifier.updateRepeatMode(n);
    }

    @Override
    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1078071040, "[%1.capabilitiesChanged]", (Object)"MediaSDISContentHandler");
        this.notifier.updatePlayerCapabilities(capabilities);
    }

    @Override
    public void playerStartupComplete() {
    }

    @Override
    public void listChangeOnSelection(boolean bl) {
    }

    @Override
    public void commandBlocked() {
        this.logger.log(1078071040, "[%1.commandBlocked]", (Object)"MediaSDISContentHandler");
        try {
            ASIHMISyncMediaReply aSIHMISyncMediaReply = this.getReplyService();
            if (aSIHMISyncMediaReply == null) {
                this.logger.log(-1601830656, "[%1.commandBlocked] No reply service is available. Can't send indicationCmdBlocked to SDIS.", (Object)"MediaSDISContentHandler");
            } else {
                this.logger.log(1078071040, "[%1.commandBlocked] Send indicationCmdBlocked to '%2'.", (Object)"MediaSDISContentHandler", (Object)aSIHMISyncMediaReply);
                aSIHMISyncMediaReply.indicationCmdBlocked(1);
            }
        }
        catch (MethodException methodException) {
            this.logger.log(10000, "[%1.commandBlocked]", (Object)"MediaSDISContentHandler", (Throwable)methodException);
        }
    }

    @Override
    public void currentPMLevelChanged(int n) {
        if (n <= 0) {
            this.notifier.enableTemporalChildLock(false);
        } else {
            this.notifier.enableTemporalChildLock(true);
        }
    }

    @Override
    public int getClientID() {
        return 5;
    }

    @Override
    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        JobPlayViewListRequest jobPlayViewListRequest = (JobPlayViewListRequest)this.listRequestQueue.getRunningJob();
        if (jobPlayViewListRequest == null) {
            this.logger.log(1078071040, "[%1.responsePlayView] No running job.", (Object)"MediaSDISContentHandler");
            return;
        }
        this.logger.log(1078071040, "[%1.responsePlayView]", (Object)"MediaSDISContentHandler");
        jobPlayViewListRequest.responsePlayView(true, n, mediaListEntryArray);
    }

    @Override
    public void errorListRequestAborted() {
        JobPlayViewListRequest jobPlayViewListRequest = (JobPlayViewListRequest)this.listRequestQueue.getRunningJob();
        if (jobPlayViewListRequest == null) {
            this.logger.log(1078071040, "[%1.errorListRequestAborted] No running job.", (Object)"MediaSDISContentHandler");
            return;
        }
        this.logger.log(1078071040, "[%1.errorListRequestAborted]", (Object)"MediaSDISContentHandler");
        jobPlayViewListRequest.responsePlayView(false, 0, new MediaListEntry[0]);
    }

    @Override
    public void listChanged(boolean bl, long l, int n, int n2) {
        this.logger.log(1078071040, "[%1.listChanged] '%2'", (Object)"MediaSDISContentHandler", (long)n);
        this.notifier.updatePlayListState(bl, l, n, n2);
    }

    @Override
    public void listInvalidated() {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (537920256 == n) {
            this.logger.log(1078071040, "[%1.keyTyped] DATA_PLAYER_R_S_E_BUTTON", (Object)"MediaSDISContentHandler");
            List list = this.sdisBlockingServiceTracker.getServices();
            if (list.isEmpty()) {
                this.logger.log(1078071040, "[%1.keyTyped] No SDIS service available.", (Object)"MediaSDISContentHandler");
                return;
            }
            ((ISDISBlockingService)list.get(0)).enterAppContext(2, "");
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.logger.log(1078071040, "[%1.notifySameTrackSelected] detailInfo:'%2', coverArt:'%3'.", (Object)"MediaSDISContentHandler", (Object)mediaDetailInfo, (Object)resourceLocator);
        this.notifier.updatePlayingTrack(this.detailInfo, this.currentCoverURL);
    }

    public void toggleRepeatMode() {
        this.logger.log(1078071040, "[%1.toggleRepeatMode]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$16(this, "SDIS.toggleRepeatMode"));
    }

    public void toggleMixMode() {
        this.logger.log(1078071040, "[%1.toggleMixMode]", (Object)"MediaSDISContentHandler");
        this.terminal.getDispatcher().execute(new MediaSDISContentHandler$17(this, "SDIS.toggleMixMode"));
    }

    private ASIHMISyncMediaReply getReplyService() {
        ASIHMISyncMediaReply aSIHMISyncMediaReply = this.activeSDISReplyService;
        if (aSIHMISyncMediaReply == null) {
            this.logger.log(10000, "[%1.getReplyService] Reply service is null.", (Object)"MediaSDISContentHandler");
        }
        return aSIHMISyncMediaReply;
    }

    void setReplyService(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        this.logger.log(-1601830656, "[%1.setReplyService] Set replyService from:'%2' to: '%3'.", (Object)"MediaSDISContentHandler", (Object)this.activeSDISReplyService, (Object)aSIHMISyncMediaReply);
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

    static /* synthetic */ LogChannel access$000(MediaSDISContentHandler mediaSDISContentHandler) {
        return mediaSDISContentHandler.logger;
    }

    static /* synthetic */ IPlayer access$100(MediaSDISContentHandler mediaSDISContentHandler) {
        return mediaSDISContentHandler.activePlayer;
    }

    static /* synthetic */ IMediaTerminal access$200(MediaSDISContentHandler mediaSDISContentHandler) {
        return mediaSDISContentHandler.terminal;
    }

    static /* synthetic */ int access$300(MediaSDISContentHandler mediaSDISContentHandler) {
        return mediaSDISContentHandler.playbackState;
    }

    static /* synthetic */ Queue access$400(MediaSDISContentHandler mediaSDISContentHandler) {
        return mediaSDISContentHandler.listRequestQueue;
    }

    static {
        NULL_PLAYER = new NullPlayer();
    }
}

