/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.AbstractCombiBAPContentAdapter;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.combi.bap.playview.AbstractCombiPlayViewJob;
import de.audi.app.media.combi.bap.playview.CombiJobGetNextListPos;
import de.audi.app.media.combi.bap.playview.CombiJobRequestList;
import de.audi.app.media.combi.bap.playview.CombiJobSelectTrack;
import de.audi.app.media.combi.bap.playview.CombiJobSelectionChanged;
import de.audi.app.media.combi.bap.playview.CombiJobTrackChanged;
import de.audi.app.media.combi.bap.playview.CombiJobUpdateCoverart;
import de.audi.app.media.combi.bap.playview.CombiJobUpdateDetailInfo;
import de.audi.app.media.combi.bap.playview.CombiJobUpdateListSize;
import de.audi.app.media.combi.bap.playview.CombiPlayViewState;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.IContentMedia;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.queue.IQueueInterceptor;
import de.audi.app.media.queue.IQueueJob;
import de.audi.app.media.queue.Queue;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class CombiBAPPlayViewContentAdapter
extends AbstractCombiBAPContentAdapter
implements IPlayerTrackListener,
IPlayerListener,
IPlayerViewListener {
    private static final String LOGCLASS = "CombiBAPPlayViewContentAdapter";
    static final int INVALID_LIST_SIZE = -1;
    protected static final int COMBI_JOB_GETNEXTLISTPOS = 1;
    protected static final int COMBI_JOB_REQUESTLIST = 2;
    protected static final int COMBI_JOB_UPDATEDETAILINFO = 3;
    protected static final int COMBI_JOB_UPDATELISTSIZE = 4;
    protected static final int COMBI_JOB_SELECT_TRACK = 5;
    protected static final int COMBI_JOB_TRACK_CHANGED = 6;
    protected static final int COMBI_JOB_UPDATE_COVERART = 7;
    protected static final int COMBI_JOB_SELECTION_CHANGED = 6;
    static final int COMBI_STARTUP_INITIATED = 0;
    static final int COMBI_STARTUP_WAITFOR_CAPABILITIES = 1;
    static final int COMBI_STARTUP_RECEIVE_CAPABILITIES = 2;
    static final int COMBI_STARTUP_WAITFOR_DETAIL_INFO = 3;
    static final int COMBI_STARTUP_RECEIVE_DETAIL_INFO = 4;
    static final int COMBI_STARTUP_AVAILABLE_DETAIL_INFO = 5;
    static final int COMBI_STARTUP_WAITFOR_LIST_SIZE = 6;
    static final int COMBI_STARTUP_RECEIVE_LIST_SIZE = 7;
    static final int COMBI_STARTUP_REQUEST_ABSOLUTE_POSITION = 8;
    static final int COMBI_STARTUP_RECEIVE_ABSOLUTE_POSITION = 9;
    static final int COMBI_STARTUP_GOTO_FINISH_WITHOUT_DETAILINFO = 10;
    static final int COMBI_STARTUP_GOTO_FINISH_WITH_LIST = 11;
    static final int COMBI_STARTUP_GOTO_FINISH_WITHOUT_LIST = 12;
    static final int COMBI_STARTUP_FINISHED = 13;
    private final Object startupMutex = new Object();
    private final Queue queue;
    private final CombiPlayViewState state;
    private volatile int contentType;
    private volatile IPlayer player;
    private volatile int startupState = 0;
    private volatile MediaDetailInfo startupDetailInfo;
    private volatile int startupListSize;
    private volatile boolean seeking;
    private Capabilities capabilities;
    static /* synthetic */ Class class$de$audi$app$media$combi$bap$playview$CombiJobGetNextListPos;
    static /* synthetic */ Class class$de$audi$app$media$combi$bap$playview$CombiJobRequestList;
    static /* synthetic */ Class class$de$audi$app$media$combi$bap$playview$CombiJobUpdateListSize;

    public CombiBAPPlayViewContentAdapter(LogChannel logChannel) {
        this(logChannel, new Queue(logChannel, "COMBI"), new CombiPlayViewState(logChannel));
    }

    CombiBAPPlayViewContentAdapter(LogChannel logChannel, Queue queue, CombiPlayViewState combiPlayViewState) {
        super(logChannel);
        this.queue = queue;
        this.state = combiPlayViewState;
        this.queue.addInterceptor(new IQueueInterceptor(){

            public void execute(IQueueJob iQueueJob, List list) {
                if (iQueueJob.getType() != 4) {
                    return;
                }
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (((IQueueJob)iterator.next()).getType() != 4) continue;
                    iterator.remove();
                }
            }

            public String toString() {
                Buffer buffer = new Buffer(20);
                buffer.append(CombiBAPPlayViewContentAdapter.LOGCLASS).append("@").append(this.hashCode());
                return buffer.toString();
            }
        });
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.capabilities = null;
        super.init();
    }

    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        super.activate(iContent, iCombiBAPContentAccessor);
        this.queue.reset();
        this.resetState();
        this.contentType = iContent.getContentType();
        this.player = ((IContentMedia)iContent).getPlayer();
        this.player.addPlayerListener(this);
        this.player.addViewListener(this);
        this.player.addTrackListener(this);
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(0L, 0, null)};
        iCombiBAPContentAccessor.updateBrowseFolder(mediaListEntryArray, 0);
        iCombiBAPContentAccessor.updatePlaybackFolder(true);
        this.setStartupState(1);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.getCombiAccessor().updateSeekState(false);
        this.queue.abort();
        super.deactivate();
        this.capabilities = null;
        this.player.removeTrackListener(this);
        this.player.removePlayerListener(this);
        this.player.removeViewListener(this);
    }

    protected CombiPlayViewState getState() {
        return this.state;
    }

    protected int getContentType() {
        return this.contentType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setStartupState(int n) {
        this.startupState = n;
        switch (this.startupState) {
            case 0: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_INITIATED", (Object)LOGCLASS);
                break;
            }
            case 1: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_CAPABILITIES", (Object)LOGCLASS);
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVE_CAPABILITIES", (Object)LOGCLASS);
                if (!this.player.supportsDetailInfo()) {
                    this.logger.log(1000000, "[%1.setStartupState] No detail info", (Object)LOGCLASS);
                    this.setStartupState(10);
                    return;
                }
                Object object = this.startupMutex;
                synchronized (object) {
                    if (this.startupDetailInfo == null) {
                        this.setStartupState(3);
                        return;
                    }
                }
                this.setStartupState(5);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_DETAIL_INFO", (Object)LOGCLASS);
                break;
            }
            case 4: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVE_DETAIL_INFO", (Object)LOGCLASS);
                this.setStartupState(5);
                break;
            }
            case 5: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_AVAILABLE_DETAIL_INFO", (Object)LOGCLASS);
                this.getState().setCurrentDetailInfo(this.startupDetailInfo);
                if (!this.startupDetailInfo.isValid()) {
                    this.logger.log(1000000, "[%1.setStartupState] Detail info invalid.", (Object)LOGCLASS);
                    this.setStartupState(10);
                    return;
                }
                if (!this.player.supportsPlayListHandling()) {
                    this.logger.log(1000000, "[%1.setStartupState] No list support", (Object)LOGCLASS);
                    this.setStartupState(12);
                    return;
                }
                Object object = this.startupMutex;
                synchronized (object) {
                    if (this.startupListSize == -1) {
                        this.setStartupState(6);
                        return;
                    }
                }
                this.setStartupState(7);
                break;
            }
            case 6: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_LIST_SIZE", (Object)LOGCLASS);
                break;
            }
            case 7: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVE_LIST_SIZE", (Object)LOGCLASS);
                this.setStartupState(8);
                break;
            }
            case 8: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_REQUEST_ABSOLUTE_POSITION", (Object)LOGCLASS);
                this.player.requestPlayViewListEntryBased(this.getClientID(), this.getCurrentEntryID(), 1);
                break;
            }
            case 9: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVE_ABSOLUTE_POSITION", (Object)LOGCLASS);
                this.setStartupState(11);
                break;
            }
            case 10: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_GOTO_FINISH_WITHOUT_DETAILINFO", (Object)LOGCLASS);
                this.resetDetailInfo();
                this.setStartupState(13);
                break;
            }
            case 12: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_GOTO_FINISH_WITHOUT_LIST", (Object)LOGCLASS);
                this.getCombiAccessor().updateListState(false, 4);
                this.getCombiAccessor().updateListSize(0);
                this.getState().setAbsolutePositionCurrentTrack(0);
                this.getCombiAccessor().updateCurrentPlayingTrack(this.contentType, this.getState().getCurrentDetailInfo().getEntryID(), this.getState().getCurrentDetailInfo().getContentType(), this.getState().getCurrentDetailInfo().getEntryFlags(), this.getState().getCurrentDetailInfo().getTitle(), this.getState().getCurrentDetailInfo().getFilename(), this.getState().getCurrentDetailInfo().getArtist(), this.getState().getCurrentDetailInfo().getAlbum(), true, this.getState().getAbsolutePositionCurrentTrack(), this.getState().getCurrentCoverart());
                this.setStartupState(13);
                break;
            }
            case 11: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_GOTO_FINISH_WITH_LIST reached.", (Object)LOGCLASS);
                this.getCombiAccessor().updateListSize(this.startupListSize);
                this.getCombiAccessor().updateListState(true, 1);
                this.setStartupState(13);
                break;
            }
            case 13: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_FINISHED", (Object)LOGCLASS);
                this.getCombiAccessor().contentAdapterStartupFinished();
                if (!this.player.supportsDetailInfo() || this.startupDetailInfo.equals(this.getState().getCurrentDetailInfo())) break;
                this.logger.log(1000000, "[%1.setStartupState] Track changed.", (Object)LOGCLASS);
                this.queue.enqueueExclusive(new CombiJobUpdateDetailInfo(this.logger, this, this.startupDetailInfo));
                break;
            }
            default: {
                this.logger.log(100000, "[%1.setStartupState] Wrong state '%2' reached.", (Object)LOGCLASS, (long)this.startupState);
            }
        }
    }

    long getCurrentEntryID() {
        MediaDetailInfo mediaDetailInfo;
        PlayingTrack playingTrack = this.player.getCurrentPlayingTrack();
        long l = playingTrack != null ? this.player.getCurrentPlayingTrack().getEntryID() : ((mediaDetailInfo = this.getState().getCurrentDetailInfo()) != null ? mediaDetailInfo.getEntryID() : -1L);
        return l;
    }

    int getStartupState() {
        return this.startupState;
    }

    private boolean isOnStartup() {
        return this.startupState != 13;
    }

    protected IPlayer getPlayer() {
        return this.player;
    }

    public boolean skip(boolean bl, int n) {
        return this.player.skip(bl, n);
    }

    public boolean setRepeatScope(int n, boolean bl) {
        return this.player.getPlaybackModeHandler().setRepeatScope(n, bl) != 2;
    }

    public void gotoCurrentPlayingTrack() {
        this.logger.log(1000000, "[%1.gotoCurrentPlayingTrack] Called.", (Object)LOGCLASS);
        this.getCombiAccessor().gotoCurrentPlayingTrackResult(true);
    }

    public void requestListByEntryID(int n, CombiBAPMediaEntry combiBAPMediaEntry, int n2) {
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.requestListByEntryID] transactionID='%2',entryID='%3',count='%4'.", (Object)LOGCLASS, (Object)new Integer(n), (Object)new Long(combiBAPMediaEntry.getEntryID()), (Object)new Integer(n2));
        }
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.requestListByEntryID] Startup not finished.", (Object)LOGCLASS);
            this.getCombiAccessor().responseList(n, this.contentType, 0, new MediaListEntry[0]);
            return;
        }
        this.queue.enqueueExclusive(new CombiJobRequestList(this.logger, this, n, combiBAPMediaEntry.getEntryID(), 0, n2));
    }

    public void requestListByIndex(int n, int n2, int n3) {
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.requestListByIndex] transactionID='%2',index='%3',count='%4'.", (Object)LOGCLASS, (Object)new Integer(n), (Object)new Integer(n2), (Object)new Integer(n3));
        }
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.requestListByIndex] Startup not finished.", (Object)LOGCLASS);
            this.getCombiAccessor().responseList(n, this.contentType, 0, new MediaListEntry[0]);
            return;
        }
        this.queue.enqueueExclusive(new CombiJobRequestList(this.logger, this, n, 0L, n2, n3));
    }

    public void getNextListPos(CombiBAPMediaEntry combiBAPMediaEntry, int n) {
        this.logger.log(1000000, "[%1.getNextListPos] '%2',offset='%3'.", (Object)LOGCLASS, (Object)combiBAPMediaEntry, (long)n);
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.getNextListPos ] Currently on startup.", (Object)LOGCLASS);
            this.getCombiAccessor().getNextListPosResult(false, combiBAPMediaEntry, null, 0);
            return;
        }
        this.queue.enqueue(new CombiJobGetNextListPos(this.logger, this, combiBAPMediaEntry, n));
    }

    public void selectListEntry(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(1000000, "[%1.selectListEntry] '%2'", (Object)LOGCLASS, (Object)combiBAPMediaEntry);
        this.queue.enqueue(new CombiJobSelectTrack(this.logger, this, combiBAPMediaEntry.getEntryID()));
    }

    public void startSeek(boolean bl) {
        this.logger.log(1000000, "[%1.startSeek] '%2'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        if (!this.getPlayer().startSeek(bl)) {
            this.getCombiAccessor().updateSeekState(false);
        }
    }

    public void stopSeek() {
        this.logger.log(1000000, "[%1.stopSeek]", (Object)LOGCLASS);
        if (!this.getPlayer().stopSeek(true)) {
            this.getCombiAccessor().updateSeekState(false);
        }
    }

    public int getCurrentRepeatScope() {
        return this.player.getPlaybackModeHandler().getActiveRepeatScope();
    }

    public boolean isMixActive() {
        return this.player.getPlaybackModeHandler().isMix();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(1000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
        this.startupDetailInfo = mediaDetailInfo;
        if (this.isOnStartup()) {
            this.queue.enqueueExclusive(new CombiJobUpdateDetailInfo(this.logger, this, mediaDetailInfo));
            Object object = this.startupMutex;
            synchronized (object) {
                if (this.getStartupState() == 3) {
                    this.setStartupState(4);
                    return;
                }
            }
            this.logger.log(1000000, "[%1.detailInfoChanged] On Startup.", (Object)LOGCLASS);
            return;
        }
        AbstractCombiPlayViewJob abstractCombiPlayViewJob = (AbstractCombiPlayViewJob)this.queue.getRunningJob();
        if (abstractCombiPlayViewJob != null && abstractCombiPlayViewJob.getType() == 5) {
            ((CombiJobSelectTrack)abstractCombiPlayViewJob).detailInfoChanged(mediaDetailInfo);
            return;
        }
        this.queue.enqueueExclusive(new CombiJobUpdateDetailInfo(this.logger, this, mediaDetailInfo));
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        if (bl) {
            if (this.getStartupState() == 8) {
                this.logger.log(1000000, "[%1.trackChanged] Track changed in COMBI_STARTUP_REQUEST_ABSOLUTE_POSITION. Request the playlist again.", (Object)LOGCLASS);
                this.player.requestPlayViewListEntryBased(this.getClientID(), this.getCurrentEntryID(), 1);
            }
            this.queue.enqueue(new CombiJobTrackChanged(this.logger, this));
        }
        if (this.getActiveSource() != null && this.getActiveSource().getType() == 12) {
            int n = playTime.getTotalTimeOfTrack() == 0 ? 65535 : playTime.getTotalTimeOfTrack();
            int n2 = n == 65535 ? 65535 : playTime.getPlayTime();
            this.getCombiAccessor().updatePlayPosition(new PlayTime(n2, n));
            return;
        }
        this.getCombiAccessor().updatePlayPosition(playTime);
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.queue.enqueue(new CombiJobUpdateCoverart(this.logger, this, resourceLocator));
    }

    public void errorListRequestAborted() {
        if (this.isOnStartup()) {
            this.logger.log(100000, "[%1.errorListRequestAborted] No running job.", (Object)LOGCLASS);
            this.getCombiAccessor().updateListSize(0);
            this.getState().setAbsolutePositionCurrentTrack(0);
            this.getCombiAccessor().updateListState(true, 1);
            this.setStartupState(13);
            return;
        }
        AbstractCombiPlayViewJob abstractCombiPlayViewJob = (AbstractCombiPlayViewJob)this.queue.getRunningJob();
        if (abstractCombiPlayViewJob == null) {
            this.logger.log(100000, "[%1.errorListRequestAborted] No running job.", (Object)LOGCLASS);
            return;
        }
        abstractCombiPlayViewJob.errorListRequestAborted();
    }

    public int getClientID() {
        return 3;
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        this.logger.log(1000000, "[%1.responsePlayView] index='%2'", (Object)LOGCLASS, (long)n);
        AbstractCombiPlayViewJob abstractCombiPlayViewJob = (AbstractCombiPlayViewJob)this.queue.getRunningJob();
        if (this.isOnStartup()) {
            switch (this.getStartupState()) {
                case 8: {
                    if (abstractCombiPlayViewJob != null) {
                        this.logger.log(1000000, "[%1.responsePlayView] Startup send playview through job.", (Object)LOGCLASS);
                        abstractCombiPlayViewJob.responsePlayViewList(n, mediaListEntryArray);
                    } else {
                        this.logger.log(1000000, "[%1.responsePlayView] No running job.", (Object)LOGCLASS);
                        this.getState().setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.getCurrentEntryID(), this.getState().getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
                        this.getCombiAccessor().updateCurrentPlayingTrack(this.contentType, this.getState().getCurrentDetailInfo().getEntryID(), this.getState().getCurrentDetailInfo().getContentType(), this.getState().getCurrentDetailInfo().getEntryFlags(), this.getState().getCurrentDetailInfo().getTitle(), this.getState().getCurrentDetailInfo().getFilename(), this.getState().getCurrentDetailInfo().getArtist(), this.getState().getCurrentDetailInfo().getAlbum(), true, this.getState().getAbsolutePositionCurrentTrack(), this.getState().getCurrentCoverart());
                    }
                    this.setStartupState(9);
                    break;
                }
                default: {
                    this.logger.log(1000000, "[%1.responsePlayView] On startup. Ignore.", (Object)LOGCLASS);
                }
            }
            return;
        }
        if (abstractCombiPlayViewJob == null) {
            this.logger.log(100000, "[%1.responsePlayView] No running job.", (Object)LOGCLASS);
            return;
        }
        abstractCombiPlayViewJob.responsePlayViewList(n, mediaListEntryArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void listChanged(boolean bl, long l, int n, int n2) {
        this.logger.log(1000000, "[%1.listChanged] '%2'", (Object)LOGCLASS, (long)n);
        this.startupListSize = n;
        if (this.isOnStartup()) {
            Object object = this.startupMutex;
            synchronized (object) {
                if (this.getStartupState() == 6) {
                    this.setStartupState(7);
                    return;
                }
            }
            this.logger.log(1000000, "[%1.listChanged] On startup. Ignore.", (Object)LOGCLASS);
            return;
        }
        if (!this.player.supportsPlayListHandling()) {
            this.logger.log(1000000, "[%1.listChanged] No list handling supported. Ignore.", (Object)LOGCLASS);
            return;
        }
        if ((n2 & 4) == 4) {
            this.logger.log(1000000, "[%1.listChanged] Only coverart update. Ignore", (Object)LOGCLASS);
            return;
        }
        this.queue.enqueueExclusive(new CombiJobUpdateListSize(this.logger, this, n, l));
    }

    public void listInvalidated() {
        this.queue.abort(new Class[]{class$de$audi$app$media$combi$bap$playview$CombiJobGetNextListPos == null ? (class$de$audi$app$media$combi$bap$playview$CombiJobGetNextListPos = CombiBAPPlayViewContentAdapter.class$("de.audi.app.media.combi.bap.playview.CombiJobGetNextListPos")) : class$de$audi$app$media$combi$bap$playview$CombiJobGetNextListPos, class$de$audi$app$media$combi$bap$playview$CombiJobRequestList == null ? (class$de$audi$app$media$combi$bap$playview$CombiJobRequestList = CombiBAPPlayViewContentAdapter.class$("de.audi.app.media.combi.bap.playview.CombiJobRequestList")) : class$de$audi$app$media$combi$bap$playview$CombiJobRequestList, class$de$audi$app$media$combi$bap$playview$CombiJobUpdateListSize == null ? (class$de$audi$app$media$combi$bap$playview$CombiJobUpdateListSize = CombiBAPPlayViewContentAdapter.class$("de.audi.app.media.combi.bap.playview.CombiJobUpdateListSize")) : class$de$audi$app$media$combi$bap$playview$CombiJobUpdateListSize});
        if (this.getStartupState() == 8) {
            this.logger.log(100000, "[%1.listInvalidated] On startup in 'COMBI_STARTUP_REQUEST_ABSOLUTE_POSITION' -> Wait for the new list size.", (Object)LOGCLASS);
            this.setStartupState(6);
        }
    }

    public void listChangeOnSelection(boolean bl) {
        this.queue.enqueue(new CombiJobSelectionChanged(this.logger, this));
    }

    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1000000, "[%2.repeatScopeChanged] scope='%3',mix='%1'", bl, (Object)LOGCLASS, (Object)String.valueOf(n));
        this.getCombiAccessor().updateActiveRepeatScope(n, bl);
    }

    public void repeatModeChanged(int n) {
    }

    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1000000, "[%1.capabilitiesChanged]", (Object)LOGCLASS);
        Capabilities capabilities2 = this.capabilities;
        this.capabilities = capabilities;
        this.state.setCurrentCapabilites(capabilities);
        if (capabilities2 == null || capabilities2.isDetailInfos() != this.capabilities.isDetailInfos()) {
            if (!this.capabilities.detailInfos) {
                this.logger.log(1000000, "[%1.capabilitiesChanged] detailInfos changed: true -> false", (Object)LOGCLASS);
                this.resetDetailInfo();
                this.setStartupState(13);
                return;
            }
            this.logger.log(1000000, "[%1.capabilitiesChanged] detailInfos changed: false -> true", (Object)LOGCLASS);
            if (this.getActiveSource().getType() == 11) {
                this.getCombiAccessor().changeActiveSourceMediaType(13);
            }
            this.resetState();
            this.setStartupState(3);
            return;
        }
        if (capabilities2.isPlayView() != this.capabilities.isPlayView() && this.capabilities.isDetailInfos()) {
            if (this.getStartupState() <= 5) {
                this.logger.log(1000000, "[%1.capabilitiesChanged]  playview changed but waiting for detailInfo", (Object)LOGCLASS);
                return;
            }
            this.startupListSize = -1;
            this.getCombiAccessor().updateListState(true, 3);
            this.logger.log(1000000, "[%1.capabilitiesChanged]  playview changed ", (Object)LOGCLASS);
            this.setStartupState(5);
        }
    }

    public void playerStartupComplete() {
    }

    public void resetDetailInfo() {
        this.logger.log(1000000, "[%1.setStartupState] resetDetailInfo", (Object)LOGCLASS);
        this.getState().setAbsolutePositionCurrentTrack(0);
        this.getCombiAccessor().updateCurrentPlayingTrack(this.contentType, 0L, 0, 0, new I18NString("", false), new I18NString("", false), new I18NString("", false), new I18NString("", false), false, 0, null);
        this.getCombiAccessor().updateListSize(0);
        this.getCombiAccessor().updateListState(false, 4);
        if (this.getActiveSource().getType() == 11) {
            this.getCombiAccessor().changeActiveSourceMediaType(19);
        }
    }

    public void resetState() {
        this.startupDetailInfo = null;
        this.startupListSize = -1;
        this.state.reset();
        int n = 4;
        if (this.capabilities != null && this.capabilities.isPlayView()) {
            n = 3;
        }
        this.getCombiAccessor().updateListState(true, n);
    }

    public void playbackStateChanged(int n) {
        boolean bl = this.getPlayer().isSeeking();
        if (this.seeking == bl) {
            return;
        }
        this.seeking = bl;
        this.logger.log(1000000, "[%1.playbackStateChanged] '%2'.", (Object)LOGCLASS, (Object)(bl ? "SEEKING" : "NOT SEEKING"));
        this.getCombiAccessor().updateSeekState(bl);
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    public void commandBlocked() {
    }

    public void currentPMLevelChanged(int n) {
    }

    public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
    }

    Capabilities getCapabilities() {
        return this.capabilities;
    }

    MediaDetailInfo getStartupDetailInfo() {
        return this.startupDetailInfo;
    }

    int getStartupListSize() {
        return this.startupListSize;
    }

    boolean isSeeking() {
        return this.seeking;
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

