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
    static final String LOGCLASS;
    static final int LIST_COMBI_BROWSER_CLIENT_ID;
    protected static final int COMBI_JOB_DETAILINFO;
    protected static final int COMBI_JOB_GOTOPARENTFOLDER;
    protected static final int COMBI_JOB_GOTOPLAYINGTRACK;
    protected static final int COMBI_JOB_GOTOROOTFOLDER;
    protected static final int COMBI_JOB_GOTOSUBFOLDER;
    protected static final int COMBI_JOB_LISTSIZE;
    protected static final int COMBI_JOB_REQUESTLIST;
    protected static final int COMBI_JOB_GETNEXTLISTPOS;
    protected static final int COMBI_JOB_TRACKCHANGED;
    protected static final int COMBI_JOB_LANGUAGE_CHANGED;
    protected static final int COMBI_JOB_TRACK_SELECT;
    protected static final int COMBI_JOB_UPDATE_COVERART;
    protected static final int COMBI_JOB_UPDATE_PLAYBACKFOLDER;
    static final int COMBI_STARTUP_WAITFOR_CAPABILITIES;
    static final int COMBI_STARTUP_WAITFOR_DETAIL_INFO;
    static final int COMBI_STARTUP_RECEIVED_DETAIL_INFO;
    static final int COMBI_STARTUP_AVAILABLE_DETAIL_INFO;
    static final int COMBI_STARTUP_ACTIVATE_BROWSER;
    static final int COMBI_STARTUP_BROWSER_ACTIVATED;
    static final int COMBI_STARTUP_CHANGE_BROWSE_MODE;
    static final int COMBI_STARTUP_BROWSE_MODE_CHANGED;
    static final int COMBI_STARTUP_WAITFOR_PLAYBACKFOLDER_ENTRY;
    static final int COMBI_STARTUP_RECEIVED_PLAYBACKFOLDER_ENTRY;
    static final int COMBI_STARTUP_GOTO_PARENT_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_WAITFOR_PARENT_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_REACHED_PARENT_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_REQUEST_LIST_ABSOLUTE_POSITION_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_GOTO_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_WAITFOR_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_REACHED_PLAYBACK_FOLDER;
    static final int COMBI_STARTUP_REQUEST_LIST_ABSOLUTE_POSITION_PLAYING_TRACK;
    static final int COMBI_STARTUP_GOTO_FINISH_WITH_LIST;
    static final int COMBI_STARTUP_PREPARE_FINISH;
    static final int COMBI_STARTUP_FINISHED;
    static final int INVALID_LIST_SIZE;
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

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"CombiBAPDataBrowserContentAdapter");
        this.capabilities = null;
        super.init();
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"CombiBAPDataBrowserContentAdapter");
        super.deinit();
    }

    Capabilities getCapabilities() {
        return this.capabilities;
    }

    @Override
    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"CombiBAPDataBrowserContentAdapter");
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

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate] Deactive.", (Object)"CombiBAPDataBrowserContentAdapter");
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

    @Override
    protected void browserActivated(IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.browserActivated]", (Object)"CombiBAPDataBrowserContentAdapter");
        this.browseListContext = iBrowseListContext;
        this.setStartupState(5);
    }

    IBrowseListContext getBrowseListContext() {
        return this.browseListContext;
    }

    @Override
    protected void browserDeactivated(ISourceSlot iSourceSlot, boolean bl) {
        this.logger.log(1078071040, "[%1.browserDeactivated]", (Object)"CombiBAPDataBrowserContentAdapter");
    }

    void setStartupState(int n) {
        this.startupState = n;
        switch (this.startupState) {
            case 0: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_CAPABILITIES", (Object)"CombiBAPDataBrowserContentAdapter");
                break;
            }
            case 1: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_DETAIL_INFO", (Object)"CombiBAPDataBrowserContentAdapter");
                break;
            }
            case 2: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_RECEIVED_DETAIL_INFO", (Object)"CombiBAPDataBrowserContentAdapter");
                this.state.setCurrentDetailInfo(this.startupDetailInfo);
                this.state.setPlaybackFolder(this.startupPlaybackFolder);
                this.setStartupState(3);
                break;
            }
            case 3: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_AVAILABLE_DETAIL_INFO", (Object)"CombiBAPDataBrowserContentAdapter");
                if (!this.isBrowsingSupported() || this.slotToActivate.getSource().getType() == 11 || this.slotToActivate.getMediaType() == 24) {
                    this.logger.log(1078071040, "[%1.setStartupState] No list supported.", (Object)"CombiBAPDataBrowserContentAdapter");
                    this.resetBrowserList();
                    this.setStartupState(20);
                    break;
                }
                this.setStartupState(4);
                break;
            }
            case 4: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_ACTIVATE_BROWSER", (Object)"CombiBAPDataBrowserContentAdapter");
                this.activate(this.slotToActivate);
                break;
            }
            case 5: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_BROWSER_ACTIVATED", (Object)"CombiBAPDataBrowserContentAdapter");
                this.browseListContext.addBrowseListListener(this, false);
                this.setStartupState(6);
                break;
            }
            case 6: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_CHANGE_BROWSE_MODE", (Object)"CombiBAPDataBrowserContentAdapter");
                this.browseListContext.setBrowseMode(0);
                break;
            }
            case 7: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_BROWSE_MODE_CHANGED", (Object)"CombiBAPDataBrowserContentAdapter");
                if (!this.state.getCurrentDetailInfo().isValid()) {
                    this.logger.log(1078071040, "[%1.setStartupState] Detail info invalid.", (Object)"CombiBAPDataBrowserContentAdapter");
                    this.setStartupState(18);
                    break;
                }
                this.logger.log(1078071040, "[%1.setStartupState] %2", (Object)"CombiBAPDataBrowserContentAdapter", (Object)this.startupPlaybackFolder);
                if (this.startupPlaybackFolder == PlayingTrack.EMPTY_PLAYBACK_FOLDER || this.startupPlaybackFolder == null) {
                    this.setStartupState(8);
                    break;
                }
                this.state.setPlaybackFolder(this.startupPlaybackFolder);
                this.setStartupState(10);
                break;
            }
            case 8: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_PLAYBACKFOLDER_ENTRY", (Object)"CombiBAPDataBrowserContentAdapter");
                break;
            }
            case 9: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_RECEIVED_PLAYBACKFOLDER_ENTRY", (Object)"CombiBAPDataBrowserContentAdapter");
                this.state.setPlaybackFolder(this.startupPlaybackFolder);
                this.setStartupState(10);
                break;
            }
            case 10: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_GOTO_PARENT_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                if (this.state.getPlaybackFolder().length == 1 || this.slotToActivate.getSource().getType() == 11) {
                    this.logger.log(1078071040, "[%1.setStartupState] Root level. or bluetooth device", (Object)"CombiBAPDataBrowserContentAdapter");
                    this.setStartupState(14);
                    return;
                }
                this.setStartupState(11);
                break;
            }
            case 11: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_PARENT_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                this.browseListContext.changeFolder(MediaUtils.getParentFolderStack(this.startupPlaybackFolder, 1));
                break;
            }
            case 12: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_REACHED_PARENT_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                this.setStartupState(13);
                break;
            }
            case 13: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_REACHED_PARENT_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                MediaListEntry[] mediaListEntryArray = this.state.getPlaybackFolder();
                MediaListEntry mediaListEntry = mediaListEntryArray[mediaListEntryArray.length - 1];
                this.requestBrowseListByEntryId(mediaListEntry.getEntryID(), mediaListEntry.getContentType(), 1);
                break;
            }
            case 14: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_GOTO_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                this.setStartupState(15);
                break;
            }
            case 15: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_WAITFOR_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                this.browseListContext.changeFolder(this.state.getPlaybackFolder());
                break;
            }
            case 16: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_REACHED_PLAYBACK_FOLDER", (Object)"CombiBAPDataBrowserContentAdapter");
                if (this.state.isBrowsingPlaybackFolder()) {
                    this.getCombiAccessor().updatePlaybackFolder(true);
                    this.setStartupState(17);
                    break;
                }
                this.logger.log(1078071040, "[%1.setStartupState] Playback folder not reached.", (Object)"CombiBAPDataBrowserContentAdapter");
                this.getCombiAccessor().updatePlaybackFolder(false);
                this.state.setAbsolutePositionCurrentTrack(0);
                this.setStartupState(18);
                break;
            }
            case 17: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_REQUEST_LIST_ABSOLUTE_POSITION_PLAYING_TRACK", (Object)"CombiBAPDataBrowserContentAdapter");
                this.requestBrowseListByEntryId(this.state.getCurrentDetailInfo().getEntryID(), this.state.getCurrentDetailInfo().getContentType(), 1);
                break;
            }
            case 18: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_GOTO_FINISH_WITH_LIST", (Object)"CombiBAPDataBrowserContentAdapter");
                this.getCombiAccessor().updateCurrentPlayingTrack(1, this.state.getCurrentDetailInfo().getEntryID(), this.state.getCurrentDetailInfo().getContentType(), this.state.getCurrentDetailInfo().getEntryFlags(), this.state.getCurrentDetailInfo().getTitle(), this.state.getCurrentDetailInfo().getFilename(), this.state.getCurrentDetailInfo().getArtist(), this.state.getCurrentDetailInfo().getAlbum(), this.state.isBrowsingPlaybackFolder(), this.state.getAbsolutePositionCurrentTrack(), this.state.getCurrentCoverart());
                this.getCombiAccessor().updateBrowseFolder(this.state.getCurrentBrowsingFolder(), this.startupAbsolutePositionPlaybackFolder);
                this.getCombiAccessor().updateListSize(this.startupListSize);
                this.getCombiAccessor().updateListState(true, 1);
                this.setStartupState(19);
                break;
            }
            case 19: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_PREPARE_FINISH", (Object)"CombiBAPDataBrowserContentAdapter");
                if (this.state.getCurrentDetailInfo().equals(this.startupDetailInfo)) {
                    this.setStartupState(20);
                    return;
                }
                this.logger.log(1078071040, "[%1.setStartupState] Track changed.", (Object)"CombiBAPDataBrowserContentAdapter");
                this.queue.enqueue(new CombiJobDetailInfoChanged(this.logger, this, this.startupDetailInfo));
                this.setStartupState(20);
                break;
            }
            case 20: {
                this.logger.log(1078071040, "[%1.setStartupState] COMBI_STARTUP_FINISHED", (Object)"CombiBAPDataBrowserContentAdapter");
                this.getCombiAccessor().contentAdapterStartupFinished();
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.setStartupState] Wrong state '%2' reached.", (Object)"CombiBAPDataBrowserContentAdapter", (long)this.startupState);
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
            this.logger.log(1078071040, "[%1.requestBrowseListByEntryId] %2", (Object)"CombiBAPDataBrowserContentAdapter", (Object)buffer);
        }
        this.browseListContext.requestListByEntryId(l, n, n2, 1);
    }

    protected void requestBrowseListByIndex(int n, int n2) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer(100);
            buffer.append("',index='").append(n).append("',count='").append(n2).append("'");
            this.logger.log(1078071040, "[%1.requestBrowseListByIndex] %2", (Object)"CombiBAPDataBrowserContentAdapter", (Object)buffer);
        }
        this.browseListContext.requestListByIndex(n, n2, 1);
    }

    protected final void changeFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1078071040, "[%1.changeFolder] '%2'.", (Object)"CombiBAPDataBrowserContentAdapter", (Object)LogUtil.listEntryToStr(mediaListEntryArray));
        if (MediaUtils.isSameFolder(mediaListEntryArray, this.state.getCurrentBrowsingFolder())) {
            this.logger.log(1078071040, "[%1.changeFolder] Folder already reached.", (Object)"CombiBAPDataBrowserContentAdapter");
            AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
            if (abstractCombiBrowserJob != null) {
                abstractCombiBrowserJob.browseFolderChanged(this.state.getCurrentBrowsingFolder(), this.state.getCurrentListSize());
            }
            return;
        }
        this.browseListContext.changeFolder(mediaListEntryArray);
    }

    protected final void addSelection(MediaListEntry mediaListEntry) {
        this.logger.log(1078071040, "[%1.addSelection] '%2'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)mediaListEntry);
        this.browseListContext.resetSelection();
        this.browseListContext.addSelection(true, 0, mediaListEntry.getEntryID(), mediaListEntry.getContentType(), false);
    }

    protected final void setPlaySelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.logger.log(1078071040, "[%1.setPlaySelection] '%2'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)iPlayerSelectionRequest);
        this.dataPlayer.setBrowserPlayerSelection(iPlayerSelectionRequest);
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(1078071040, "[%1.detailInfoChanged] '%2'", (Object)"CombiBAPDataBrowserContentAdapter", mediaDetailInfo.getEntryID());
        if (this.isOnStartup()) {
            this.startupDetailInfo = mediaDetailInfo;
            this.startupPlaybackFolder = mediaDetailInfo.getPlayingTrack().getPlaybackFolder();
            if (this.getStartupState() == 1) {
                this.setStartupState(2);
                return;
            }
            this.logger.log(1078071040, "[%1.detailInfoChanged] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
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

    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        if (bl) {
            this.queue.enqueue(new CombiJobTrackChanged(this.logger, this));
        }
    }

    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        this.queue.enqueue(new CombiJobUpdateCoverart(this.logger, this, resourceLocator));
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
        if (mediaListEntryArray != PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
            if (this.isOnStartup()) {
                if (this.startupPlaybackFolder == PlayingTrack.EMPTY_PLAYBACK_FOLDER) {
                    this.startupPlaybackFolder = mediaListEntryArray;
                    if (this.getStartupState() == 8) {
                        this.setStartupState(9);
                        return;
                    }
                    this.logger.log(1078071040, "[%1.detailInfoChanged] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
                    return;
                }
            } else {
                this.queue.enqueue(new CombiJobPlaybackFolderChanged(this.logger, this, mediaListEntryArray));
            }
        }
    }

    @Override
    public void repeatScopeChanged(int n, boolean bl) {
        this.logger.log(1078071040, "[%2.repeatScopeChanged] Scope changed (scope='%3',mix='%1').", bl, (Object)"CombiBAPDataBrowserContentAdapter", (Object)String.valueOf(n));
        this.getCombiAccessor().updateActiveRepeatScope(n, bl);
    }

    @Override
    public void repeatModeChanged(int n) {
    }

    @Override
    public void playerStartupComplete() {
    }

    @Override
    public void playbackStateChanged(int n) {
        boolean bl = this.dataPlayer.isSeeking();
        if (this.lastSeekState == bl) {
            return;
        }
        this.lastSeekState = bl;
        this.logger.log(1078071040, "[%1.playbackStateChanged] '%2'.", (Object)"CombiBAPDataBrowserContentAdapter", (Object)(bl ? "SEEKING" : "NOT SEEKING"));
        this.getCombiAccessor().updateSeekState(bl);
    }

    @Override
    public void currentPMLevelChanged(int n) {
    }

    @Override
    public boolean skip(boolean bl, int n) {
        this.logger.log(1078071040, "[%2.skip] forward='%1',count='%3'", (Object)String.valueOf(bl), (Object)"CombiBAPDataBrowserContentAdapter", (Object)String.valueOf(n));
        return this.dataPlayer.skip(bl, n);
    }

    @Override
    public boolean setRepeatScope(int n, boolean bl) {
        return this.dataPlayer.getPlaybackModeHandler().setRepeatScope(n, bl) != 2;
    }

    @Override
    public void getNextListPos(CombiBAPMediaEntry combiBAPMediaEntry, int n) {
        this.logger.log(1078071040, "[%1.getNextListPos] '%2',offset='%3'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)combiBAPMediaEntry, (long)n);
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.getNextListPos ] Currently on startup.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().getNextListPosResult(false, combiBAPMediaEntry, null, 0);
            return;
        }
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.getNextListPos ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().getNextListPosResult(false, combiBAPMediaEntry, null, 0);
            return;
        }
        this.queue.enqueue(new CombiJobGetNextListPos(this.logger, this, combiBAPMediaEntry, n));
    }

    @Override
    public void selectListEntry(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(1078071040, "[%1.selectListEntry] '%2'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)combiBAPMediaEntry);
        this.queue.enqueue(new CombiJobSelectTrack(this.logger, this, this.browseListContext.getBrowserID(), combiBAPMediaEntry.getEntryID()));
    }

    @Override
    public void gotoCurrentPlayingTrack() {
        this.logger.log(1078071040, "[%1.gotoCurrentPlayingTrack]", (Object)"CombiBAPDataBrowserContentAdapter");
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.gotoCurrentPlayingTrack ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoCurrentPlayingTrackResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.gotoCurrentPlayingTrack ] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoCurrentPlayingTrackResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoPlayingTrack(this.logger, this));
    }

    @Override
    public void gotoParentFolder() {
        this.logger.log(1078071040, "[%1.gotoParentFolder]", (Object)"CombiBAPDataBrowserContentAdapter");
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.gotoParentFolder ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoParentFolderResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.gotoParentFolder ] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoParentFolderResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoParentFolder(this.logger, this));
    }

    @Override
    public void gotoRootFolder() {
        this.logger.log(1078071040, "[%1.gotoRootFolder] Called.", (Object)"CombiBAPDataBrowserContentAdapter");
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.gotoRootFolder ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoRootFolderResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.gotoRootFolder ] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoRootFolderResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoRootFolder(this.logger, this));
    }

    @Override
    public void gotoSubFolder(CombiBAPMediaEntry combiBAPMediaEntry) {
        this.logger.log(1078071040, "[%1.gotoSubFolder] '%2'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)combiBAPMediaEntry);
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.gotoSubFolder ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoSubFolderResult(false);
            return;
        }
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.gotoSubFolder ] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().gotoSubFolderResult(false);
            return;
        }
        this.queue.enqueue(new CombiJobGotoSubFolder(this.logger, this, combiBAPMediaEntry));
    }

    @Override
    public void requestListByEntryID(int n, CombiBAPMediaEntry combiBAPMediaEntry, int n2) {
        this.logger.log(1078071040, "[%1.requestListByEntryID] '%2',cnt='%4'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)combiBAPMediaEntry, (long)n2);
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.requestListByEntryID] Startup not finished.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.requestListByEntryID ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        this.queue.enqueue(new CombiJobRequestList(this.logger, this, n, combiBAPMediaEntry.getEntryID(), 0, combiBAPMediaEntry.getEntryContentType(), n2));
    }

    @Override
    public void requestListByIndex(int n, int n2, int n3) {
        this.logger.log(1078071040, "[%1.requestListByIndex] startIdx='%2',count='%3'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)String.valueOf(n2), (Object)String.valueOf(n3));
        if (this.isOnStartup()) {
            this.logger.log(1078071040, "[%1.requestListByIndex] Startup not finished.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        if (!this.isBrowsingSupported()) {
            this.logger.log(1078071040, "[%1.requestListByIndex ] No list support.", (Object)"CombiBAPDataBrowserContentAdapter");
            this.getCombiAccessor().responseList(n, 1, 0, new MediaListEntry[0]);
            return;
        }
        this.queue.enqueue(new CombiJobRequestList(this.logger, this, n, 0L, n2, 0, n3));
    }

    @Override
    public void startSeek(boolean bl) {
        this.logger.log(1078071040, "[%1.startSeek] '%2'", (Object)"CombiBAPDataBrowserContentAdapter", (Object)(bl ? "FORWARD" : "BACKWARD"));
        if (!this.dataPlayer.startSeek(bl)) {
            this.getCombiAccessor().updateSeekState(false);
        }
    }

    @Override
    public void stopSeek() {
        this.logger.log(1078071040, "[%1.stopSeek]", (Object)"CombiBAPDataBrowserContentAdapter");
        if (!this.dataPlayer.stopSeek(true)) {
            this.getCombiAccessor().updateSeekState(false);
        }
    }

    @Override
    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1078071040, "[%1.capabilitiesChanged]", (Object)"CombiBAPDataBrowserContentAdapter");
        Capabilities capabilities2 = this.capabilities;
        this.capabilities = capabilities;
        if (capabilities2 != null && capabilities2.isDetailInfos() == this.capabilities.isDetailInfos()) {
            this.logger.log(1078071040, "[%1.capabilitiesChanged] detailInfos not changed", (Object)"CombiBAPDataBrowserContentAdapter");
            return;
        }
        if (this.slotToActivate.getSource().getType() == 11) {
            if (null != capabilities && capabilities.isDetailInfos()) {
                this.logger.log(1078071040, "[%1.capabilitiesChanged] list handling.", (Object)"CombiBAPDataBrowserContentAdapter");
                this.getCombiAccessor().changeActiveSourceMediaType(13);
            } else {
                this.logger.log(1078071040, "[%1.capabilitiesChanged] no list handling.", (Object)"CombiBAPDataBrowserContentAdapter");
                this.getCombiAccessor().changeActiveSourceMediaType(19);
            }
        }
        if (this.isOnStartup()) {
            if (this.getStartupState() == 0 && capabilities.isDetailInfos()) {
                this.logger.log(1078071040, "[%1.capabilitiesChanged] Only detail infos supported.", (Object)"CombiBAPDataBrowserContentAdapter");
                this.setStartupState(1);
                return;
            }
            if (!this.capabilities.isDetailInfos()) {
                this.logger.log(1078071040, "[%1.capabilitiesChanged] no detailInfos -> reset startupState='%2'.", (Object)"CombiBAPDataBrowserContentAdapter", (long)this.getStartupState());
                this.resetDetailInfo();
                this.setStartupState(20);
                return;
            }
        }
        if (!this.capabilities.isDetailInfos()) {
            this.logger.log(1078071040, "[%1.capabilitiesChanged] detailInfos changed: true -> false", (Object)"CombiBAPDataBrowserContentAdapter");
            this.resetDetailInfo();
        } else {
            this.logger.log(1078071040, "[%1.capabilitiesChanged] detailInfos changed: false -> true", (Object)"CombiBAPDataBrowserContentAdapter");
            this.resetState();
            this.setStartupState(1);
        }
    }

    void resetDetailInfo() {
        this.logger.log(1078071040, "[%1.resetDetailInfo]", (Object)"CombiBAPDataBrowserContentAdapter");
        this.getCombiAccessor().updateCurrentPlayingTrack(1, 1L, 0, 0, new I18NString("", false), new I18NString("", false), new I18NString("", false), new I18NString("", false), false, 0, null);
        MediaListEntry[] mediaListEntryArray = new MediaListEntry[]{new MediaListEntry(0L, 0, null)};
        this.getCombiAccessor().updateBrowseFolder(mediaListEntryArray, 0);
        this.getCombiAccessor().updateListSize(0);
        this.getCombiAccessor().updateListState(false, 4);
    }

    void resetBrowserList() {
        super.deactivate();
        this.logger.log(1078071040, "[%1.resetBrowserList] No list supported.", (Object)"CombiBAPDataBrowserContentAdapter");
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

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.browseFolderChanged]", (Object)"CombiBAPDataBrowserContentAdapter");
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
            this.logger.log(1078071040, "[%1.browseFolderChanged] On startup.", (Object)"CombiBAPDataBrowserContentAdapter");
            return;
        }
        this.state.setCurrentBrowsingFolder(mediaListEntryArray);
        this.state.setCurrentListSize(n);
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null) {
            abstractCombiBrowserJob.browseFolderChanged(mediaListEntryArray, n);
        }
    }

    @Override
    public void listUpdated(int n) {
        this.logger.log(1078071040, "[%1.listUpdated]", (Object)"CombiBAPDataBrowserContentAdapter");
        this.state.setCurrentListSize(n);
        if (this.isOnStartup()) {
            this.startupListSize = n;
            this.logger.log(1078071040, "[%1.listUpdated] Currently on startup. Ignore.", (Object)"CombiBAPDataBrowserContentAdapter");
            return;
        }
        this.queue.enqueue(new CombiJobListSizeChanged(this.logger, this, n));
    }

    int getStartupListSize() {
        return this.startupListSize;
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.browseModeChanged] Receive browse mode.", (Object)"CombiBAPDataBrowserContentAdapter");
        if (this.isOnStartup() && this.getStartupState() == 6) {
            this.setStartupState(7);
        }
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1078071040, "[%1.addSelectionResult] result='%2',selected='%3'", (Object)"CombiBAPDataBrowserContentAdapter", (long)n, l4);
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null) {
            abstractCombiBrowserJob.addSelectionResult(!bl && n == 0 && l4 + l5 > 0L);
        }
    }

    @Override
    public void resetSelectionResult(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.resetSelectionResult]", (Object)"CombiBAPDataBrowserContentAdapter");
        AbstractCombiBrowserJob abstractCombiBrowserJob = (AbstractCombiBrowserJob)this.queue.getRunningJob();
        if (abstractCombiBrowserJob != null && (bl || n == 3)) {
            abstractCombiBrowserJob.addSelectionResult(false);
        }
    }

    @Override
    public void notifyMetadataEntryAvailable(boolean bl) {
    }

    @Override
    public void notifyFilesystemEntryAvailable(boolean bl) {
    }

    @Override
    public void notifyCoverartsAvailable(boolean bl) {
    }

    @Override
    public void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    @Override
    public int getClientId() {
        return 1;
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.responseList] Receive response list.", (Object)"CombiBAPDataBrowserContentAdapter");
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
        this.logger.log(1078071040, "[%1.errorListRequestAborted] Request aborted.", (Object)"CombiBAPDataBrowserContentAdapter");
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

    @Override
    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public int getCurrentRepeatScope() {
        return this.dataPlayer.getPlaybackModeHandler().getActiveRepeatScope();
    }

    @Override
    public boolean isMixActive() {
        return this.dataPlayer.getPlaybackModeHandler().isMix();
    }

    @Override
    public void updateActiveSlot(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.updateActiveSlot].", (Object)"CombiBAPDataBrowserContentAdapter");
        ISourceSlot iSourceSlot2 = this.slotToActivate;
        this.slotToActivate = iSourceSlot;
        if (iSourceSlot2 != null && iSourceSlot2.getCapabilities().isRawBrowsing() == this.slotToActivate.getCapabilities().isRawBrowsing()) {
            this.logger.log(1078071040, "[%1.updateActiveSlot] rawBrowsing not changed.", (Object)"CombiBAPDataBrowserContentAdapter");
            return;
        }
        if (this.isOnStartup()) {
            if (this.getStartupState() < 4) {
                this.logger.log(1078071040, "[%1.updateActiveSlot] startup browsing state not reached '%2'.", (Object)"CombiBAPDataBrowserContentAdapter", (long)this.getStartupState());
                return;
            }
            if (!this.slotToActivate.getCapabilities().isRawBrowsing()) {
                this.logger.log(1078071040, "[%1.updateActiveSlot]. startup: rawBrowsing true -> false", (Object)"CombiBAPDataBrowserContentAdapter");
                this.setStartupState(3);
            }
        } else if (this.slotToActivate.getMediaType() != 24 && this.slotToActivate.getSource().getType() != 11) {
            if (this.slotToActivate.getCapabilities().isRawBrowsing() && this.capabilities.isDetailInfos()) {
                this.logger.log(1078071040, "[%1.updateActiveSlot]. rawBrowsing false -> true", (Object)"CombiBAPDataBrowserContentAdapter");
                this.startupListSize = -1;
                this.startupAbsolutePositionPlaybackFolder = 0;
                this.startupPlaybackFolder = PlayingTrack.EMPTY_PLAYBACK_FOLDER;
                this.getCombiAccessor().updateListState(true, 3);
                this.setStartupState(4);
            } else if (this.capabilities.isDetailInfos()) {
                this.logger.log(1078071040, "[%1.updateActiveSlot]. rawBrowsing true -> false", (Object)"CombiBAPDataBrowserContentAdapter");
                this.resetBrowserList();
            }
        }
    }

    @Override
    public void commandBlocked() {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CombiBAPDataBrowserContentAdapter").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

