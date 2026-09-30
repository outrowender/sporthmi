/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.combi.bap.ICombiBAPContentAdapter;
import de.audi.app.media.combi.bap.NullCombiBAPContentAccessor;
import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBrowserState;
import de.audi.app.media.combi.bap.browselist.CombiJobDetailInfoChanged;
import de.audi.app.media.combi.bap.browselist.CombiJobGetNextListPos;
import de.audi.app.media.combi.bap.browselist.CombiJobGotoParentFolder;
import de.audi.app.media.combi.bap.browselist.CombiJobGotoPlayingTrack;
import de.audi.app.media.combi.bap.browselist.CombiJobGotoRootFolder;
import de.audi.app.media.combi.bap.browselist.CombiJobGotoSubFolder;
import de.audi.app.media.combi.bap.browselist.CombiJobListSizeChanged;
import de.audi.app.media.combi.bap.browselist.CombiJobPlaybackFolderChanged;
import de.audi.app.media.combi.bap.browselist.CombiJobRequestList;
import de.audi.app.media.combi.bap.browselist.CombiJobSelectTrack;
import de.audi.app.media.combi.bap.browselist.CombiJobTrackChanged;
import de.audi.app.media.combi.bap.browselist.CombiJobUpdateCoverart;
import de.audi.app.media.content.IContent;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class CombiBAPDataBrowserContentAdapter
extends AbstractMediaBrowser
implements ICombiBAPContentAdapter,
IPlayerTrackListener,
IPlayerListener,
IBrowseListListener {
    static final String LOGCLASS = "CombiBAPDataBrowserContentAdapter";
    static final int LIST_COMBI_BROWSER_CLIENT_ID = 1;
    protected static final int COMBI_JOB_DETAILINFO = 1;
    protected static final int COMBI_JOB_GOTOPARENTFOLDER = 2;
    protected static final int COMBI_JOB_GOTOPLAYINGTRACK = 3;
    protected static final int COMBI_JOB_GOTOROOTFOLDER = 4;
    protected static final int COMBI_JOB_GOTOSUBFOLDER = 5;
    protected static final int COMBI_JOB_LISTSIZE = 6;
    protected static final int COMBI_JOB_REQUESTLIST = 7;
    protected static final int COMBI_JOB_GETNEXTLISTPOS = 8;
    protected static final int COMBI_JOB_TRACKCHANGED = 9;
    protected static final int COMBI_JOB_LANGUAGE_CHANGED = 10;
    protected static final int COMBI_JOB_TRACK_SELECT = 11;
    protected static final int COMBI_JOB_UPDATE_COVERART = 12;
    protected static final int COMBI_JOB_UPDATE_PLAYBACKFOLDER = 13;
    static final int COMBI_STARTUP_WAITFOR_CAPABILITIES = 0;
    static final int COMBI_STARTUP_WAITFOR_DETAIL_INFO = 1;
    static final int COMBI_STARTUP_RECEIVED_DETAIL_INFO = 2;
    static final int COMBI_STARTUP_AVAILABLE_DETAIL_INFO = 3;
    static final int COMBI_STARTUP_ACTIVATE_BROWSER = 4;
    static final int COMBI_STARTUP_BROWSER_ACTIVATED = 5;
    static final int COMBI_STARTUP_CHANGE_BROWSE_MODE = 6;
    static final int COMBI_STARTUP_BROWSE_MODE_CHANGED = 7;
    static final int COMBI_STARTUP_WAITFOR_PLAYBACKFOLDER_ENTRY = 8;
    static final int COMBI_STARTUP_RECEIVED_PLAYBACKFOLDER_ENTRY = 9;
    static final int COMBI_STARTUP_GOTO_PARENT_PLAYBACK_FOLDER = 10;
    static final int COMBI_STARTUP_WAITFOR_PARENT_PLAYBACK_FOLDER = 11;
    static final int COMBI_STARTUP_REACHED_PARENT_PLAYBACK_FOLDER = 12;
    static final int COMBI_STARTUP_REQUEST_LIST_ABSOLUTE_POSITION_PLAYBACK_FOLDER = 13;
    static final int COMBI_STARTUP_GOTO_PLAYBACK_FOLDER = 14;
    static final int COMBI_STARTUP_WAITFOR_PLAYBACK_FOLDER = 15;
    static final int COMBI_STARTUP_REACHED_PLAYBACK_FOLDER = 16;
    static final int COMBI_STARTUP_REQUEST_LIST_ABSOLUTE_POSITION_PLAYING_TRACK = 17;
    static final int COMBI_STARTUP_GOTO_FINISH_WITH_LIST = 18;
    static final int COMBI_STARTUP_PREPARE_FINISH = 19;
    static final int COMBI_STARTUP_FINISHED = 20;
    static final int INVALID_LIST_SIZE = -1;
    final IPlayer dataPlayer;
    final Queue queue;
    final CombiBrowserState state;
    private final NullCombiBAPContentAccessor nullCombiAccessor = new NullCombiBAPContentAccessor();
    private volatile ICombiBAPContentAccessor combiAccessor;
    private volatile int startupState = 0;
    private volatile int startupListSize;
    private volatile MediaDetailInfo startupDetailInfo;
    private volatile MediaListEntry[] startupPlaybackFolder;
    private volatile int startupAbsolutePositionPlaybackFolder = 0;
    private volatile ISourceSlot slotToActivate;
    private volatile IBrowseListContext browseListContext;
    private volatile boolean lastSeekState;
    private volatile Capabilities capabilities;

    public CombiBAPDataBrowserContentAdapter(IMediaTerminal iMediaTerminal, LogChannel logChannel, IPlayer iPlayer) {
        super(logChannel, logChannel, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), 6, iMediaTerminal.getSourceController());
        this.queue = new Queue(this.logger, "COMBI");
        this.state = new CombiBrowserState(this.logger);
        this.dataPlayer = iPlayer;
    }

    CombiBAPDataBrowserContentAdapter(IMediaTerminal iMediaTerminal, LogChannel logChannel, IPlayer iPlayer, Queue queue, CombiBrowserState combiBrowserState) {
        super(logChannel, logChannel, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), 6, iMediaTerminal.getSourceController());
        this.queue = queue;
        this.state = combiBrowserState;
        this.dataPlayer = iPlayer;
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.capabilities = null;
        super.init();
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
    }

    Capabilities getCapabilities() {
        return this.capabilities;
    }

    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.combiAccessor = iCombiBAPContentAccessor;
        this.queue.reset();
        this.lastSeekState = false;
        this.resetState();
        this.setStartupState(0);
        this.slotToActivate = iContent.getActiveSlot();
        this.dataPlayer.addTrackListener(this);
        this.dataPlayer.addPlayerListener(this);
        if (this.slotToActivate.getSource().getType() == 11) {
            this.getCombiAccessor().updatePlaybackFolder(false);
        }
    }

    boolean isSeeking() {
        return this.lastSeekState;
    }

    ISourceSlot getSlotToActivate() {
        return this.slotToActivate;
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate] Deactive.", (Object)LOGCLASS);
        this.getCombiAccessor().updateSeekState(false);
        this.queue.abort();
        this.combiAccessor = this.nullCombiAccessor;
        this.dataPlayer.removeTrackListener(this);
        this.dataPlayer.removePlayerListener(this);
        this.slotToActivate = null;
        this.capabilities = null;
        super.deactivate();
    }

    protected ICombiBAPContentAccessor getCombiAccessor() {
        return this.combiAccessor;
    }

    protected void browserActivated(IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.browserActivated]", (Object)LOGCLASS);
        this.browseListContext = iBrowseListContext;
        this.setStartupState(5);
    }

    IBrowseListContext getBrowseListContext() {
        return this.browseListContext;
    }

    protected void browserDeactivated(ISourceSlot iSourceSlot, boolean bl) {
        this.logger.log(1000000, "[%1.browserDeactivated]", (Object)LOGCLASS);
    }

    void setStartupState(int n) {
        this.startupState = n;
        switch (this.startupState) {
            case 0: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_CAPABILITIES", (Object)LOGCLASS);
                break;
            }
            case 1: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_DETAIL_INFO", (Object)LOGCLASS);
                break;
            }
            case 2: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVED_DETAIL_INFO", (Object)LOGCLASS);
                this.state.setCurrentDetailInfo(this.startupDetailInfo);
                this.state.setPlaybackFolder(this.startupPlaybackFolder);
                this.setStartupState(3);
                break;
            }
            case 3: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_AVAILABLE_DETAIL_INFO", (Object)LOGCLASS);
                if (!this.isBrowsingSupported() || this.slotToActivate.getSource().getType() == 11 || this.slotToActivate.getMediaType() == 24) {
                    this.logger.log(1000000, "[%1.setStartupState] No list supported.", (Object)LOGCLASS);
                    this.resetBrowserList();
                    this.setStartupState(20);
                    break;
                }
                this.setStartupState(4);
                break;
            }
            case 4: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_ACTIVATE_BROWSER", (Object)LOGCLASS);
                this.activate(this.slotToActivate);
                break;
            }
            case 5: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_BROWSER_ACTIVATED", (Object)LOGCLASS);
                this.browseListContext.addBrowseListListener(this, false);
                this.setStartupState(6);
                break;
            }
            case 6: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_CHANGE_BROWSE_MODE", (Object)LOGCLASS);
                this.browseListContext.setBrowseMode(0);
                break;
            }
            case 7: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_BROWSE_MODE_CHANGED", (Object)LOGCLASS);
                if (!this.state.getCurrentDetailInfo().isValid()) {
                    this.logger.log(1000000, "[%1.setStartupState] Detail info invalid.", (Object)LOGCLASS);
                    this.setStartupState(18);
                    break;
                }
                this.logger.log(1000000, "[%1.setStartupState] %2", (Object)LOGCLASS, (Object)this.startupPlaybackFolder);
                if (this.startupPlaybackFolder == PlayingTrack.EMPTY_PLAYBACK_FOLDER || this.startupPlaybackFolder == null) {
                    this.setStartupState(8);
                    break;
                }
                this.state.setPlaybackFolder(this.startupPlaybackFolder);
                this.setStartupState(10);
                break;
            }
            case 8: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_PLAYBACKFOLDER_ENTRY", (Object)LOGCLASS);
                break;
            }
            case 9: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_RECEIVED_PLAYBACKFOLDER_ENTRY", (Object)LOGCLASS);
                this.state.setPlaybackFolder(this.startupPlaybackFolder);
                this.setStartupState(10);
                break;
            }
            case 10: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_GOTO_PARENT_PLAYBACK_FOLDER", (Object)LOGCLASS);
                if (this.state.getPlaybackFolder().length == 1 || this.slotToActivate.getSource().getType() == 11) {
                    this.logger.log(1000000, "[%1.setStartupState] Root level. or bluetooth device", (Object)LOGCLASS);
                    this.setStartupState(14);
                    return;
                }
                this.setStartupState(11);
                break;
            }
            case 11: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_PARENT_PLAYBACK_FOLDER", (Object)LOGCLASS);
                this.browseListContext.changeFolder(MediaUtils.getParentFolderStack(this.startupPlaybackFolder, 1));
                break;
            }
            case 12: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_REACHED_PARENT_PLAYBACK_FOLDER", (Object)LOGCLASS);
                this.setStartupState(13);
                break;
            }
            case 13: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_REACHED_PARENT_PLAYBACK_FOLDER", (Object)LOGCLASS);
                MediaListEntry[] mediaListEntryArray = this.state.getPlaybackFolder();
                MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
                this.requestBrowseListByEntryId(mediaListEntry.getEntryID(), mediaListEntry.getContentType(), 1);
                break;
            }
            case 14: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_GOTO_PLAYBACK_FOLDER", (Object)LOGCLASS);
                this.setStartupState(15);
                break;
            }
            case 15: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_PLAYBACK_FOLDER", (Object)LOGCLASS);
                this.browseListContext.changeFolder(this.state.getPlaybackFolder());
                break;
            }
            case 16: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_REACHED_PLAYBACK_FOLDER", (Object)LOGCLASS);
                if (this.state.isBrowsingPlaybackFolder()) {
                    this.getCombiAccessor().updatePlaybackFolder(true);
                    this.setStartupState(17);
                    break;
                }
                this.logger.log(1000000, "[%1.setStartupState] Playback folder not reached.", (Object)LOGCLASS);
                this.getCombiAccessor().updatePlaybackFolder(false);
                this.state.setAbsolutePositionCurrentTrack(0);
                this.setStartupState(18);
                break;
            }
            case 17: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_REQUEST_LIST_ABSOLUTE_POSITION_PLAYING_TRACK", (Object)LOGCLASS);
                this.requestBrowseListByEntryId(this.state.getCurrentDetailInfo().getEntryID(), this.state.getCurrentDetailInfo().getContentType(), 1);
                break;
            }
            case 18: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_GOTO_FINISH_WITH_LIST", (Object)LOGCLASS);
                this.getCombiAccessor().updateCurrentPlayingTrack(1, this.state.getCurrentDetailInfo().getEntryID(), this.state.getCurrentDetailInfo().getContentType(), this.state.getCurrentDetailInfo().getEntryFlags(), this.state.getCurrentDetailInfo().getTitle(), this.state.getCurrentDetailInfo().getFilename(), this.state.getCurrentDetailInfo().getArtist(), this.state.getCurrentDetailInfo().getAlbum(), this.state.isBrowsingPlaybackFolder(), this.state.getAbsolutePositionCurrentTrack(), this.state.getCurrentCoverart());
                this.getCombiAccessor().updateBrowseFolder(this.state.getCurrentBrowsingFolder(), this.startupAbsolutePositionPlaybackFolder);
                this.getCombiAccessor().updateListSize(this.startupListSize);
                this.getCombiAccessor().updateListState(true, 1);
                this.setStartupState(19);
                break;
            }
            case 19: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_PREPARE_FINISH", (Object)LOGCLASS);
                if (this.state.getCurrentDetailInfo().equals(this.startupDetailInfo)) {
                    this.setStartupState(20);
                    return;
                }
                this.logger.log(1000000, "[%1.setStartupState] Track changed.", (Object)LOGCLASS);
                this.queue.enqueue(new CombiJobDetailInfoChanged(this.logger, this, this.startupDetailInfo));
                this.setStartupState(20);
                break;
            }
            case 20: {
                this.logger.log(1000000, "[%1.setStartupState] COMBI_STARTUP_FINISHED", (Object)LOGCLASS);
                this.getCombiAccessor().contentAdapterStartupFinished();
                break;
            }
            default: {
                this.logger.log(100000, "[%1.setStartupState] Wrong state '%2' reached.", (Object)LOGCLASS, (long)this.startupState);
            }
        }
    }

    int getStartupState() {
        return this.startupState;
    }

    private boolean isOnStartup() {
        return this.startupState != 20;
    }

    protected boolean isBrowsingSupported() {
        return this.slotToActivate.getCapabilities().isRawBrowsing();
    }

    public CombiBrowserState getState() {
        return this.state;
    }

    protected void requestBrowseListByEntryId(long l, int n, int n2) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer(100);
            buffer.append("entryID='").append(l).append("',contentType='").append(n).append("',count='").append(n2).append("'");
            this.logger.log(1000000, "[%1.requestBrowseListByEntryId] %2", (Object)LOGCLASS, (Object)buffer);
        }
        this.browseListContext.requestListByEntryId(l, n, n2, 1);
    }

    protected void requestBrowseListByIndex(int n, int n2) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer(100);
            buffer.append("',index='").append(n).append("',count='").append(n2).append("'");
            this.logger.log(1000000, "[%1.requestBrowseListByIndex] %2", (Object)LOGCLASS, (Object)buffer);
        }
        this.browseListContext.requestListByIndex(n, n2, 1);
    }

    protected final void changeFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1000000, "[%1.changeFolder] '%2'.", (Object)LOGCLASS, (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        if (MediaUtils.isSameFolder(mediaListEntryArray, this.state.getCurrentBrowsingFolder())) {
            this.logger.log(1000000, "[%1.changeFolder] Folder already reached.", (Object)LOGCLASS);
            AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
            if (abstractCombiBrowserJob != null) {
                abstractCombiBrowserJob.browseFolderChanged(this.state.getCurrentBrowsingFolder(), this.state.getCurrentListSize());
            }
            return;
        }
        this.browseListContext.changeFolder(mediaListEntryArray);
    }

    protected final void addSelection(MediaListEntry mediaListEntry) {
        this.logger.log(1000000, "[%1.addSelection] '%2'", (Object)LOGCLASS, (Object)mediaListEntry);
        this.browseListContext.resetSelection();
        this.browseListContext.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
    }

    protected final void setPlaySelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.logger.log(1000000, "[%1.setPlaySelection] '%2'", (Object)LOGCLASS, (Object)iPlayerSelectionRequest);
        this.dataPlayer.setBrowserPlayerSelection(iPlayerSelectionRequest);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(1000000, "[%1.detailInfoChanged] '%2'", (Object)LOGCLASS, mediaDetailInfo.getEntryID());
        if (this.isOnStartup()) {
            this.startupDetailInfo = mediaDetailInfo;
            this.startupPlaybackFolder = mediaDetailInfo.getPlayingTrack().getPlaybackFolder();
            if (this.getStartupState() == 1) {
                this.setStartupState(2);
                return;
            }
            this.logger.log(1000000, "[%1.detailInfoChanged] On startup.", (Object)LOGCLASS);
            return;
        }
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null && abstractCombiBrowserJob.getType() == 11) {
            ((CombiJobSelectTrack)abstractCombiBrowserJob).detailInfoChanged(mediaDetailInfo);
            return;
        }
        this.queue.enqueue(new CombiJobDetailInfoChanged(this.logger, this, mediaDetailInfo));
    }

    MediaDetailInfo getStartupDetailInfo() {
        return this.startupDetailInfo;
    }

    MediaListEntry[] getStartupPlaybackFolder() {
        return this.startupPlaybackFolder;
    }

    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        if (bl) {
            this.queue.enqueue(new CombiJobTrackChanged(this.logger, this));
        }
    }

    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.queue.enqueue(new CombiJobUpdateCoverart(this.logger, this, resourceLocator));
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
        if (mediaListEntryArray != PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
            if (this.isOnStartup()) {
                if (this.startupPlaybackFolder == PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
                    this.startupPlaybackFolder = mediaListEntryArray;
                    if (this.getStartupState() == 8) {
                        this.setStartupState(9);
                        return;
                    }
                    this.logger.log(1000000, "[%1.detailInfoChanged] On startup.", (Object)LOGCLASS);
                    return;
                }
            } else {
                this.queue.enqueue(new CombiJobPlaybackFolderChanged(this.logger, this, mediaListEntryArray));
            }
        }
    }

    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1000000, "[%2.repeatScopeChanged] Scope changed (scope='%3',mix='%1').", bl, (Object)LOGCLASS, (Object)String.valueOf(n));
        this.getCombiAccessor().updateActiveRepeatScope(n, bl);
    }

    public void repeatModeChanged(int n) {
    }

    public void playerStartupComplete() {
    }

    public void playbackStateChanged(int n) {
        boolean bl = this.dataPlayer.isSeeking();
        if (this.lastSeekState == bl) {
            return;
        }
        this.lastSeekState = bl;
        this.logger.log(1000000, "[%1.playbackStateChanged] '%2'.", (Object)LOGCLASS, (Object)(bl ? "SEEKING" : "NOT SEEKING"));
        this.getCombiAccessor().updateSeekState(bl);
    }

    public void currentPMLevelChanged(int n) {
    }

    public boolean skip(boolean bl, int n) {
        this.logger.log(1000000, "[%2.skip] forward='%1',count='%3'", (Object)String.valueOf(bl), (Object)LOGCLASS, (Object)String.valueOf(n));
        return this.dataPlayer.skip(bl, n);
    }

    public boolean setRepeatScope(int n, boolean bl) {
        return this.dataPlayer.getPlaybackModeHandler().setRepeatScope(n, bl) != 2;
    }

    public void getNextListPos(CombiBAPMediaEntry combiBAPMediaEntry, int n) {
        this.logger.log(1000000, "[%1.getNextListPos] '%2',offset='%3'", (Object)LOGCLASS, (Object)combiBAPMediaEntry, (long)n);
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.getNextListPos ] Currently on startup.", (Object)LOGCLASS);
            this.getCombiAccessor().getNextListPosResult(false, combiBAPMediaEntry, null, 0);
            return;
        }
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.getNextListPos ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().getNextListPosResult(false, combiBAPMediaEntry, null, 0);
            return;
        }
        this.queue.enqueue(new CombiJobGetNextListPos(this.logger, this, combiBAPMediaEntry, n));
    }

    public void selectListEntry(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(1000000, "[%1.selectListEntry] '%2'", (Object)LOGCLASS, (Object)combiBAPMediaEntry);
        this.queue.enqueue(new CombiJobSelectTrack(this.logger, this, this.browseListContext.getBrowserID(), combiBAPMediaEntry.getEntryID()));
    }

    public void gotoCurrentPlayingTrack() {
        this.logger.log(1000000, "[%1.gotoCurrentPlayingTrack]", (Object)LOGCLASS);
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.gotoCurrentPlayingTrack ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoCurrentPlayingTrackResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.gotoCurrentPlayingTrack ] On startup.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoCurrentPlayingTrackResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoPlayingTrack(this.logger, this));
    }

    public void gotoParentFolder() {
        this.logger.log(1000000, "[%1.gotoParentFolder]", (Object)LOGCLASS);
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.gotoParentFolder ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoParentFolderResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.gotoParentFolder ] On startup.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoParentFolderResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoParentFolder(this.logger, this));
    }

    public void gotoRootFolder() {
        this.logger.log(1000000, "[%1.gotoRootFolder] Called.", (Object)LOGCLASS);
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.gotoRootFolder ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoRootFolderResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.gotoRootFolder ] On startup.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoRootFolderResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoRootFolder(this.logger, this));
    }

    public void gotoSubFolder(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(1000000, "[%1.gotoSubFolder] '%2'", (Object)LOGCLASS, (Object)combiBAPMediaEntry);
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.gotoSubFolder ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoSubFolderResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.gotoSubFolder ] On startup.", (Object)LOGCLASS);
            this.getCombiAccessor().gotoSubFolderResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoSubFolder(this.logger, this, combiBAPMediaEntry));
    }

    public void requestListByEntryID(int n, CombiBAPMediaEntry combiBAPMediaEntry, int n2) {
        this.logger.log(1000000, "[%1.requestListByEntryID] '%2',cnt='%4'", (Object)LOGCLASS, (Object)combiBAPMediaEntry, (long)n2);
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.requestListByEntryID] Startup not finished.", (Object)LOGCLASS);
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.requestListByEntryID ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        this.queue.enqueue(new CombiJobRequestList(this.logger, this, n, combiBAPMediaEntry.getEntryID(), 0, combiBAPMediaEntry.getEntryContentType(), n2));
    }

    public void requestListByIndex(int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.requestListByIndex] startIdx='%2',count='%3'", (Object)LOGCLASS, (Object)String.valueOf(n2), (Object)String.valueOf(n3));
        if (this.isOnStartup()) {
            this.logger.log(1000000, "[%1.requestListByIndex] Startup not finished.", (Object)LOGCLASS);
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        if (!this.isBrowsingSupported()) {
            this.logger.log(1000000, "[%1.requestListByIndex ] No list support.", (Object)LOGCLASS);
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        this.queue.enqueue(new CombiJobRequestList(this.logger, this, n, 0L, n2, 0, n3));
    }

    public void startSeek(boolean bl) {
        this.logger.log(1000000, "[%1.startSeek] '%2'", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        if (!this.dataPlayer.startSeek(bl)) {
            this.getCombiAccessor().updateSeekState(false);
        }
    }

    public void stopSeek() {
        this.logger.log(1000000, "[%1.stopSeek]", (Object)LOGCLASS);
        if (!this.dataPlayer.stopSeek(true)) {
            this.getCombiAccessor().updateSeekState(false);
        }
    }

    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1000000, "[%1.capabilitiesChanged]", (Object)LOGCLASS);
        Capabilities capabilities2 = this.capabilities;
        this.capabilities = capabilities;
        if (capabilities2 != null && capabilities2.isDetailInfos() == this.capabilities.isDetailInfos()) {
            this.logger.log(1000000, "[%1.capabilitiesChanged] detailInfos not changed", (Object)LOGCLASS);
            return;
        }
        if (this.slotToActivate.getSource().getType() == 11) {
            if (null != capabilities && capabilities.isDetailInfos()) {
                this.logger.log(1000000, "[%1.capabilitiesChanged] list handling.", (Object)LOGCLASS);
                this.getCombiAccessor().changeActiveSourceMediaType(13);
            } else {
                this.logger.log(1000000, "[%1.capabilitiesChanged] no list handling.", (Object)LOGCLASS);
                this.getCombiAccessor().changeActiveSourceMediaType(19);
            }
        }
        if (this.isOnStartup()) {
            if (this.getStartupState() == 0 && capabilities.isDetailInfos()) {
                this.logger.log(1000000, "[%1.capabilitiesChanged] Only detail infos supported.", (Object)LOGCLASS);
                this.setStartupState(1);
                return;
            }
            if (!this.capabilities.isDetailInfos()) {
                this.logger.log(1000000, "[%1.capabilitiesChanged] no detailInfos -> reset startupState='%2'.", (Object)LOGCLASS, (long)this.getStartupState());
                this.resetDetailInfo();
                this.setStartupState(20);
                return;
            }
        }
        if (!this.capabilities.isDetailInfos()) {
            this.logger.log(1000000, "[%1.capabilitiesChanged] detailInfos changed: true -> false", (Object)LOGCLASS);
            this.resetDetailInfo();
        } else {
            this.logger.log(1000000, "[%1.capabilitiesChanged] detailInfos changed: false -> true", (Object)LOGCLASS);
            this.resetState();
            this.setStartupState(1);
        }
    }

    void resetDetailInfo() {
        this.logger.log(1000000, "[%1.resetDetailInfo]", (Object)LOGCLASS);
        this.getCombiAccessor().updateCurrentPlayingTrack(1, 1L, 0, 0, new I18NString("", false), new I18NString("", false), new I18NString("", false), new I18NString("", false), false, 0, null);
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(0L, 0, null)};
        this.getCombiAccessor().updateBrowseFolder(mediaListEntryArray, 0);
        this.getCombiAccessor().updateListSize(0);
        this.getCombiAccessor().updateListState(false, 4);
    }

    void resetBrowserList() {
        super.deactivate();
        this.logger.log(1000000, "[%1.resetBrowserList] No list supported.", (Object)LOGCLASS);
        this.getCombiAccessor().updateCurrentPlayingTrack(1, this.state.getCurrentDetailInfo().getEntryID(), this.state.getCurrentDetailInfo().getContentType(), this.state.getCurrentDetailInfo().getEntryFlags(), this.state.getCurrentDetailInfo().getTitle(), this.state.getCurrentDetailInfo().getFilename(), this.state.getCurrentDetailInfo().getArtist(), this.state.getCurrentDetailInfo().getAlbum(), this.state.isBrowsingPlaybackFolder(), this.state.getAbsolutePositionCurrentTrack(), this.state.getCurrentCoverart());
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(0L, 0, null)};
        this.getCombiAccessor().updateBrowseFolder(mediaListEntryArray, 0);
        this.getCombiAccessor().updateListSize(0);
        this.getCombiAccessor().updateListState(false, 4);
    }

    void resetState() {
        this.startupListSize = -1;
        this.startupDetailInfo = null;
        this.startupAbsolutePositionPlaybackFolder = 0;
        this.state.reset();
        this.startupPlaybackFolder = PlayingTrack.EMPTY_PLAYBACK_FOLDER;
        this.getCombiAccessor().updateListState(true, 3);
    }

    int getStartupAbsolutePositionPlaybackFolder() {
        return this.startupAbsolutePositionPlaybackFolder;
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.browseFolderChanged]", (Object)LOGCLASS);
        if (this.isOnStartup()) {
            if (!bl) {
                this.startupListSize = n;
                this.state.setCurrentBrowsingFolder(mediaListEntryArray);
                this.state.setCurrentListSize(n);
            }
            if (this.getStartupState() == 15) {
                this.setStartupState(16);
                return;
            }
            if (this.getStartupState() == 11) {
                this.setStartupState(12);
                return;
            }
            this.logger.log(1000000, "[%1.browseFolderChanged] On startup.", (Object)LOGCLASS);
            return;
        }
        this.state.setCurrentBrowsingFolder(mediaListEntryArray);
        this.state.setCurrentListSize(n);
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null) {
            abstractCombiBrowserJob.browseFolderChanged(mediaListEntryArray, n);
        }
    }

    public void listUpdated(int n) {
        this.logger.log(1000000, "[%1.listUpdated]", (Object)LOGCLASS);
        this.state.setCurrentListSize(n);
        if (this.isOnStartup()) {
            this.startupListSize = n;
            this.logger.log(1000000, "[%1.listUpdated] Currently on startup. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.queue.enqueue(new CombiJobListSizeChanged(this.logger, this, n));
    }

    int getStartupListSize() {
        return this.startupListSize;
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.browseModeChanged] Receive browse mode.", (Object)LOGCLASS);
        if (this.isOnStartup() && this.getStartupState() == 6) {
            this.setStartupState(7);
        }
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1000000, "[%1.addSelectionResult] result='%2',selected='%3'", (Object)LOGCLASS, (long)n, l4);
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null) {
            abstractCombiBrowserJob.addSelectionResult(!bl && n == 0 && l4 + l5 > 0L);
        }
    }

    public void resetSelectionResult(boolean bl, int n) {
        this.logger.log(1000000, "[%1.resetSelectionResult]", (Object)LOGCLASS);
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null && (bl || n == 3)) {
            abstractCombiBrowserJob.addSelectionResult(false);
        }
    }

    public void notifyMetadataEntryAvailable(boolean bl) {
    }

    public void notifyFilesystemEntryAvailable(boolean bl) {
    }

    public void notifyCoverartsAvailable(boolean bl) {
    }

    public void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    public int getClientId() {
        return 1;
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.responseList] Receive response list.", (Object)LOGCLASS);
        if (bl) {
            this.errorListRequestAborted();
            return;
        }
        if (this.isOnStartup()) {
            if (this.getStartupState() == 13) {
                MediaListEntry[] mediaListEntryArray2 = this.state.getPlaybackFolder();
                MediaListEntry mediaListEntry = mediaListEntryArray2[mediaListEntryArray2.length - 1];
                this.startupAbsolutePositionPlaybackFolder = CombiBAPUtils.getAbsolutePosition(mediaListEntry.getEntryID(), mediaListEntry.getContentType(), mediaListEntryArray, n);
                this.setStartupState(14);
                return;
            }
            if (this.getStartupState() == 17) {
                this.state.setAbsolutePositionCurrentTrack(CombiBAPUtils.getAbsolutePosition(this.state.getCurrentDetailInfo().getEntryID(), this.state.getCurrentDetailInfo().getContentType(), mediaListEntryArray, n));
                this.setStartupState(18);
            }
            return;
        }
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob == null) {
            return;
        }
        abstractCombiBrowserJob.responseList(n, mediaListEntryArray);
    }

    void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] Request aborted.", (Object)LOGCLASS);
        if (this.isOnStartup()) {
            this.setStartupState(20);
            return;
        }
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob == null) {
            return;
        }
        abstractCombiBrowserJob.errorListRequestAborted();
    }

    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    public int getCurrentRepeatScope() {
        return this.dataPlayer.getPlaybackModeHandler().getActiveRepeatScope();
    }

    public boolean isMixActive() {
        return this.dataPlayer.getPlaybackModeHandler().isMix();
    }

    public void updateActiveSlot(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.updateActiveSlot].", (Object)LOGCLASS);
        ISourceSlot iSourceSlot2 = this.slotToActivate;
        this.slotToActivate = iSourceSlot;
        if (iSourceSlot2 != null && iSourceSlot2.getCapabilities().isRawBrowsing() == this.slotToActivate.getCapabilities().isRawBrowsing()) {
            this.logger.log(1000000, "[%1.updateActiveSlot] rawBrowsing not changed.", (Object)LOGCLASS);
            return;
        }
        if (this.isOnStartup()) {
            if (this.getStartupState() < 4) {
                this.logger.log(1000000, "[%1.updateActiveSlot] startup browsing state not reached '%2'.", (Object)LOGCLASS, (long)this.getStartupState());
                return;
            }
            if (!this.slotToActivate.getCapabilities().isRawBrowsing()) {
                this.logger.log(1000000, "[%1.updateActiveSlot]. startup: rawBrowsing true -> false", (Object)LOGCLASS);
                this.setStartupState(3);
            }
        } else if (this.slotToActivate.getMediaType() != 24 && this.slotToActivate.getSource().getType() != 11) {
            if (this.slotToActivate.getCapabilities().isRawBrowsing() && this.capabilities.isDetailInfos()) {
                this.logger.log(1000000, "[%1.updateActiveSlot]. rawBrowsing false -> true", (Object)LOGCLASS);
                this.startupListSize = -1;
                this.startupAbsolutePositionPlaybackFolder = 0;
                this.startupPlaybackFolder = PlayingTrack.EMPTY_PLAYBACK_FOLDER;
                this.getCombiAccessor().updateListState(true, 3);
                this.setStartupState(4);
            } else if (this.capabilities.isDetailInfos()) {
                this.logger.log(1000000, "[%1.updateActiveSlot]. rawBrowsing true -> false", (Object)LOGCLASS);
                this.resetBrowserList();
            }
        }
    }

    public void commandBlocked() {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }
}

