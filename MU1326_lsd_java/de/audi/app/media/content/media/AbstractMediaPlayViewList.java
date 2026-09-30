/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IPlayViewList;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.NullPlayViewListRequest;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayViewListRequest;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.IQueueJob;
import de.audi.app.media.queue.Queue;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractMediaPlayViewList
extends AbstractMediaTerminalComponent
implements IPlayViewList,
TiledListModelListener {
    private static final String LOGCLASS = "AbstractMediaPlayViewList";
    static final long REQUEST_DELAY = 100L;
    protected LogChannel logger;
    protected final IPlayer player;
    private final Object listUpdateMutex = new Object();
    private volatile int currentListSize;
    private volatile PlayingTrack currentPlayingTrack;
    private AbstractMediaPlayViewListRow currentFocusedRow;
    private PlayTime currentTrackTime;
    private volatile boolean isJumpToCurrentListRequestRunning;
    private volatile boolean isListStartupComplete;
    private boolean automaticCursorMerge = false;
    private final int WINDOW_RADIUS;
    final Queue listRequestQueue;
    final DispatcherBase listRequestDelayDispatcher;
    private boolean clearList = false;
    private MediaDetailInfo currentDetailInfo;
    protected volatile ResourceLocator currentCover;
    private volatile boolean listInvalid;
    private static final int CURSOR_MERGED = 0;
    private static final int CURSOR_NOT_MERGED = 1;
    protected volatile PlayerViewListenerProxy playerViewListenerProxy;
    boolean active;
    private boolean initialListReceived;
    private MediaListEntry[] lastList;
    private int lastIndex;

    public AbstractMediaPlayViewList(IMediaTerminal iMediaTerminal, LogChannel logChannel, IPlayer iPlayer, boolean bl) {
        this(iMediaTerminal, logChannel, iPlayer, bl, new Queue(logChannel, "PlayviewListRequest"), iMediaTerminal.getDispatcher(), iMediaTerminal.getDiagnosisManager());
    }

    AbstractMediaPlayViewList(IMediaTerminal iMediaTerminal, LogChannel logChannel, IPlayer iPlayer, boolean bl, Queue queue, DispatcherBase dispatcherBase, IDiagnosisManager iDiagnosisManager) {
        super(iMediaTerminal);
        this.WINDOW_RADIUS = 24;
        this.logger = logChannel;
        this.player = iPlayer;
        this.listRequestQueue = queue;
        this.listRequestDelayDispatcher = dispatcherBase;
        iDiagnosisManager.addDataProvider(iMediaTerminal.getTerminalID(), this.listRequestQueue);
        this.playerViewListenerProxy = new PlayerViewListenerProxy(this);
    }

    protected abstract void listStartupComplete();

    protected abstract boolean isRequestFullList();

    protected abstract TiledListModelApp getPlayViewListModel();

    protected abstract ChoiceModelApp getPlayableFilesAvailableModel();

    protected abstract AbstractMediaPlayViewListRow createRow(MediaListEntry var1);

    protected abstract IProgressIndication getListProgressIndicator();

    protected abstract int getListRequestClientID();

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.active = true;
        this.currentListSize = -1;
        this.setCursorMergeModeFlag(false);
        this.listRequestQueue.reset();
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.currentFocusedRow = null;
            this.currentCover = null;
        }
        this.currentPlayingTrack = new PlayingTrack();
        this.isListStartupComplete = false;
        this.isJumpToCurrentListRequestRunning = false;
        this.getPlayViewListModel().clearAll();
        this.getPlayViewListModel().setLength(0);
        object = this.getPlayableFilesAvailableModel();
        if (object != null) {
            object.setValue(0);
        }
        this.getPlayViewListModel().setListener(this);
        this.blockList();
        this.player.addViewListener(this.playerViewListenerProxy);
        this.setCursorMergeModeFlag(true);
        this.player.addTrackListener(this);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.active = false;
        if (this.isBlocked()) {
            this.unblockList();
        }
        this.getPlayViewListModel().setListener(null);
        this.player.removeViewListener(this.playerViewListenerProxy);
        this.player.removeTrackListener(this);
        this.lastList = null;
        this.lastIndex = -1;
    }

    protected int getWindowRequestSize() {
        return 24;
    }

    public int getListSize() {
        return this.currentListSize;
    }

    private void setListSize(int n, boolean bl) {
        if (n == this.currentListSize) {
            return;
        }
        this.currentListSize = n;
        if (!bl && this.getPlayViewListModel() instanceof BaseListModel) {
            BaseListModel baseListModel = (BaseListModel)((Object)this.getPlayViewListModel());
            baseListModel.setLength(n, false);
        } else {
            this.getPlayViewListModel().setLength(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setAutomaticCursorMerge(boolean bl) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            if (this.isAutomaticCursorMerge() == bl) {
                this.logger.log(1000000, "[%1.setAutomaticCursorMerge] Already '%2'", (Object)LOGCLASS, (Object)(bl ? "ON" : "OFF"));
            }
            this.logger.log(1000000, "[%1.setAutomaticCursorMerge] '%2'", (Object)LOGCLASS, (Object)(bl ? "ON" : "OFF"));
            this.setCursorMergeModeFlag(bl);
            if (bl) {
                this.triggerCursorMerge(this.getPlayViewListModel(), false);
            }
        }
    }

    public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.logger.log(1000000, "[%1.notifySameTrackSelected]", (Object)LOGCLASS);
        this.detailInfoChanged(mediaDetailInfo);
        this.coverArtChanged(resourceLocator);
    }

    private void triggerCursorMerge(BaseListModelApp baseListModelApp, boolean bl) {
        if (bl) {
            this.logger.log(1000000, "[%1.triggerCursorMerge] Forced.", (Object)LOGCLASS);
            baseListModelApp.trigger(ModelTrigger.JOIN_CURSOR);
        } else {
            this.logger.log(1000000, "[%1.triggerCursorMerge] if no scrolling", (Object)LOGCLASS);
            baseListModelApp.trigger(ModelTrigger.JOIN_CURSOR_NO_SCROLLING);
        }
    }

    protected final void triggerFullScreen() {
        this.logger.log(1000000, "[%1.triggerFullScreen]", (Object)LOGCLASS);
        this.getPlayViewListModel().fireEvent(this.getTerminal().getTerminalID());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCursorMergeModeFlag(boolean bl) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.automaticCursorMerge = bl;
            if (bl) {
                this.currentFocusedRow = null;
            }
            this.getChoiceModel(200248).setValue(bl ? 1 : 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCursorMergeModeFlagOnly(boolean bl) {
        this.logger.log(100000000, "[%1.setCursorMergeModeFlagOnly] '%2'", (Object)LOGCLASS, (Object)bl);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.automaticCursorMerge = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final boolean isAutomaticCursorMerge() {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            return this.automaticCursorMerge;
        }
    }

    private void jumpToCurrentTrack() {
        AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getMediaPlayListRow(this.currentPlayingTrack.getEntryID());
        if (abstractMediaPlayViewListRow != null) {
            this.logger.log(1000000, "[%1.jumpToCurrentTrack] Playing row found (rowID='%2').", (Object)LOGCLASS, abstractMediaPlayViewListRow.getUniqueID());
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow2 = abstractMediaPlayViewListRow;
            if (abstractMediaPlayViewListRow2.equals(this.currentFocusedRow)) {
                this.logger.log(1000000, "[%1.jumpToCurrentTrack] Focus already set.", (Object)LOGCLASS);
                return;
            }
            this.currentFocusedRow = abstractMediaPlayViewListRow2;
            this.triggerCursorMerge(this.getPlayViewListModel(), false);
            return;
        }
        this.logger.log(1000000, "[%1.jumpToCurrentTrack] Playing row not found.", (Object)LOGCLASS);
        if (this.getListSize() == 0) {
            this.logger.log(1000000, "[%1.jumpToCurrentTrack] List is empty. Ignore.", (Object)LOGCLASS);
            return;
        }
        long l = this.currentPlayingTrack.getEntryID();
        if (l == -1L) {
            this.logger.log(1000000, "[%1.jumpToCurrentTrack] Track ID invalid. Request list from beginning.", (Object)LOGCLASS);
            this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, 0, this.getWindowRequestSize()));
            return;
        }
        this.isJumpToCurrentListRequestRunning = true;
        this.blockList();
        this.currentFocusedRow = this.createRow(new MediaListEntry(l, 0, ""));
        PlayViewListRequest playViewListRequest = (PlayViewListRequest)this.listRequestQueue.getRunningJob();
        if (null == playViewListRequest || l != playViewListRequest.getEntryId()) {
            this.listRequestQueue.abort();
            this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, l));
        } else {
            this.logger.log(10000000, "[%1.jumpToCurrentTrack] No play view request. Request for '%2' already running.", (Object)LOGCLASS, l);
        }
    }

    private PlayViewListRequest getRunningJob() {
        IQueueJob iQueueJob = this.listRequestQueue.getRunningJob();
        return iQueueJob != null ? (PlayViewListRequest)iQueueJob : new NullPlayViewListRequest();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void clear() {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.clear]", (Object)LOGCLASS);
            this.currentFocusedRow = null;
            this.clearList = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void setSelectedEntry(long l) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getMediaPlayListRow(l);
            if (abstractMediaPlayViewListRow != null) {
                this.logger.log(1000000, "[%1.setSelectedEntry] Entry to select found (rowID='%2').", (Object)LOGCLASS, abstractMediaPlayViewListRow.getUniqueID());
                BaseListModelApp baseListModelApp = this.getPlayViewListModel().getCopy();
                AbstractMediaPlayViewListRow abstractMediaPlayViewListRow2 = this.getCurrentSelectedRow();
                if (abstractMediaPlayViewListRow2 != null) {
                    this.logger.log(1000000, "[%1.setSelectedEntry] Remove tracktime for '%2'", (Object)LOGCLASS, abstractMediaPlayViewListRow2.getEntryID());
                    this.setTrackTime(null, baseListModelApp);
                    this.setPlaying(false, baseListModelApp);
                    baseListModelApp.setSelectedUniqueID(abstractMediaPlayViewListRow.getUniqueID());
                    boolean bl = this.getTerminal().getConfiguration().isIAP2Supported();
                    boolean bl2 = this.getTerminal().getSourceController().getSelectedSlot().getMediaType() == 24;
                    int n = this.getTerminal().getSourceController().getSelectedSlot().getMediaType();
                    boolean bl3 = this.player.getPlaybackModeHandler().isRepeatTrack();
                    this.logger.log(1000000, new StringBuffer().append("[%1.setSelectedEntry] iAP2='%2', iPod='%3', repeatTrack='%4' activeMediaType ='").append(n).append("'.").toString(), (Object)LOGCLASS, (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl3));
                    if (bl && bl2 && bl3) {
                        this.logger.log(1000000, "[%1.setSelectedEntry] iPod iAP2 with repeatTrack -> Set the playing flag. Don't wait for track change.", (Object)LOGCLASS);
                        this.setPlaying(true, baseListModelApp);
                    }
                    this.getPlayViewListModel().update(baseListModelApp);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected AbstractMediaPlayViewListRow getCurrentFocusedRow() {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            return this.currentFocusedRow;
        }
    }

    protected AbstractMediaPlayViewListRow getCurrentSelectedRow() {
        SelectedItem selectedItem = this.getPlayViewListModel().getSelected();
        if (null != selectedItem) {
            return (AbstractMediaPlayViewListRow)this.getPlayViewListModel().getRow(selectedItem.getIndex());
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected MediaDetailInfo getCurrentDetailInfo() {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            return this.currentDetailInfo;
        }
    }

    public final void blockList() {
        this.logger.log(1000000, "[%1.blockList]", (Object)LOGCLASS);
        this.getPlayViewListModel().setStatus(0);
    }

    protected final boolean isBlocked() {
        return this.getPlayViewListModel().getStatus() == 0;
    }

    public final void unblockList() {
        this.logger.log(1000000, "[%1.unblockList]", (Object)LOGCLASS);
        this.getPlayViewListModel().setStatus(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.logger.log(1000000, "[%1.trackChanged] track changed=%2 tracktime=%3", (Object)LOGCLASS, (Object)Boolean.toString(bl), (long)playTime.getPlayTime());
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.currentTrackTime = playTime;
            if (bl) {
                this.currentPlayingTrack = playingTrack;
                if (null != this.currentDetailInfo && this.currentDetailInfo.getPlayingTrack().getEntryID() != playingTrack.getEntryID()) {
                    this.currentDetailInfo = null;
                    this.currentCover = null;
                }
                AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
                BaseListModelApp baseListModelApp = this.getPlayViewListModel().getCopy();
                AbstractMediaPlayViewListRow abstractMediaPlayViewListRow2 = this.getMediaPlayListRow(this.currentPlayingTrack.getEntryID());
                if (abstractMediaPlayViewListRow2 != null) {
                    this.logger.log(1000000, "[%1.trackChanged] Playing row found.", (Object)LOGCLASS);
                    if (abstractMediaPlayViewListRow != null) {
                        this.logger.log(1000000, "[%1.trackChanged] Remove tracktime for '%2'", (Object)LOGCLASS, abstractMediaPlayViewListRow.getEntryID());
                        this.removePlayingTrack(baseListModelApp);
                    }
                    baseListModelApp.setSelectedUniqueID(abstractMediaPlayViewListRow2.getUniqueID());
                    if (this.player.supportsPlaytime()) {
                        this.setTrackTime(playTime, baseListModelApp);
                    }
                    this.setPlaying(true, baseListModelApp);
                    if (bl2) {
                        this.logger.log(1000000, "[%1.trackChanged] Skipped.", (Object)LOGCLASS);
                        this.setCursorMergeModeFlag(true);
                    }
                    if (this.isAutomaticCursorMerge()) {
                        this.triggerCursorMerge(baseListModelApp, bl2);
                        this.currentFocusedRow = abstractMediaPlayViewListRow2;
                    }
                    this.getPlayViewListModel().update(baseListModelApp);
                } else {
                    this.logger.log(1000000, "[%1.trackChanged] Playing row not found.", (Object)LOGCLASS);
                    this.getPlayViewListModel().update(baseListModelApp);
                    if (this.currentListSize != -1) {
                        this.logger.log(1000000, "[%1.trackChanged] Jump to current track.", (Object)LOGCLASS);
                        this.jumpToCurrentTrack();
                    }
                }
            } else if (this.player.supportsPlaytime() && !this.listInvalid) {
                this.setTrackTime(playTime, this.getPlayViewListModel());
            }
        }
    }

    protected void removePlayingTrack(BaseListModelApp baseListModelApp) {
        this.logger.log(1000000, "[%1.removePlayingTrack]", (Object)LOGCLASS);
        if (this.player.supportsPlaytime()) {
            this.setTrackTime(null, baseListModelApp);
        }
        this.setPlaying(false, baseListModelApp);
        baseListModelApp.setSelectedIndex(-1);
        baseListModelApp.getMenu().resetFocusedItem();
    }

    private boolean setFocusedCursorPosition(AbstractMediaPlayViewListRow abstractMediaPlayViewListRow) {
        this.logger.log(1000000, "[%1.setFocusedCursorPosition] uId='%2' entryId='%3'", (Object)LOGCLASS, abstractMediaPlayViewListRow.getUniqueID(), abstractMediaPlayViewListRow.getEntryID());
        this.getPlayViewListModel().getMenu().setFocusedItem(this.getPlayViewListModel().getID(), FocusAdvice.KEEP_POSITION, abstractMediaPlayViewListRow.getUniqueID());
        return true;
    }

    private AbstractMediaPlayViewListRow getMediaPlayListRow(long l) {
        this.logger.log(1000000, "[%1.getMediaPlayListRow] eId='%2'", (Object)LOGCLASS, l);
        Iterator iterator = this.getPlayViewListModel().asList().iterator();
        while (iterator.hasNext()) {
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = (AbstractMediaPlayViewListRow)iterator.next();
            if (null == abstractMediaPlayViewListRow || abstractMediaPlayViewListRow.getEntryID() != l) continue;
            return abstractMediaPlayViewListRow;
        }
        return null;
    }

    protected void setTrackTime(PlayTime playTime, BaseListModelApp baseListModelApp) {
        AbstractMediaPlayViewListRow abstractMediaPlayViewListRow;
        SelectedItem selectedItem = baseListModelApp.getSelected();
        if (selectedItem != null && null != (abstractMediaPlayViewListRow = (AbstractMediaPlayViewListRow)baseListModelApp.getRow(selectedItem.getIndex()))) {
            AbstractMediaPlayViewList.setTrackTimeOfRow(abstractMediaPlayViewListRow, selectedItem.getIndex(), playTime, baseListModelApp);
        }
    }

    protected void setPlaying(boolean bl, BaseListModelApp baseListModelApp) {
        AbstractMediaPlayViewListRow abstractMediaPlayViewListRow;
        SelectedItem selectedItem = baseListModelApp.getSelected();
        if (selectedItem != null && null != (abstractMediaPlayViewListRow = (AbstractMediaPlayViewListRow)baseListModelApp.getRow(selectedItem.getIndex()))) {
            abstractMediaPlayViewListRow.setPlaying(bl);
            baseListModelApp.setRow(selectedItem.getIndex(), abstractMediaPlayViewListRow);
        }
    }

    private static void setTrackTimeOfRow(AbstractMediaPlayViewListRow abstractMediaPlayViewListRow, int n, PlayTime playTime, BaseListModelApp baseListModelApp) {
        abstractMediaPlayViewListRow.setTime(playTime);
        baseListModelApp.setRow(n, abstractMediaPlayViewListRow);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.detailInfoChanged] aCh='%2' tCh='%3'", (Object)LOGCLASS, (long)mediaDetailInfo.getActiveChapter(), (long)mediaDetailInfo.getNumChapters());
            this.currentDetailInfo = mediaDetailInfo;
            this.setDetailInfoInList();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setDetailInfoInList() {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.setDetailInfoInList]", (Object)LOGCLASS);
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            if (null != abstractMediaPlayViewListRow && null != this.currentDetailInfo) {
                abstractMediaPlayViewListRow.setDetailInfos(this.currentDetailInfo);
                if (this.currentCover != null) {
                    abstractMediaPlayViewListRow.setCoverArt(this.currentCover);
                } else {
                    this.logger.log(1000000, "[%1.setDetailInfoInList] cover: 'null'.", (Object)LOGCLASS);
                }
                TiledListModelApp tiledListModelApp = this.getPlayViewListModel();
                if (tiledListModelApp.getSelected() != null) {
                    tiledListModelApp.setRow(tiledListModelApp.getSelected().getIndex(), abstractMediaPlayViewListRow);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void coverArtChanged(ResourceLocator resourceLocator) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.coverArtChanged] cover: '%2'.", (Object)LOGCLASS, (Object)resourceLocator);
            this.currentCover = resourceLocator;
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            if (null != abstractMediaPlayViewListRow) {
                this.logger.log(1000000, "[%1.coverArtChanged] set cover: '%2' for entry: '%3'.", (Object)LOGCLASS, (Object)resourceLocator, abstractMediaPlayViewListRow.getEntryID());
                abstractMediaPlayViewListRow.setCoverArt(resourceLocator);
                TiledListModelApp tiledListModelApp = this.getPlayViewListModel();
                if (tiledListModelApp.getSelected() != null) {
                    this.logger.log(1000000, "[%1.coverArtChanged] update row after cover change.", (Object)LOGCLASS);
                    tiledListModelApp.setRow(tiledListModelApp.getSelected().getIndex(), abstractMediaPlayViewListRow);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateTotalPlaytimeCapability(boolean bl) {
        this.logger.log(1000000, "[%1.updatePlaytimeCapability] '%2'", (Object)LOGCLASS, (Object)bl);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            BaseListModelApp baseListModelApp = this.getPlayViewListModel().getCopy();
            for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = (AbstractMediaPlayViewListRow)baseListModelApp.getRow(i2);
                if (abstractMediaPlayViewListRow == null) continue;
                abstractMediaPlayViewListRow.updatePlaytimeCapabilitiy(bl);
                baseListModelApp.setRow(i2, abstractMediaPlayViewListRow);
            }
            this.getPlayViewListModel().update(baseListModelApp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateList(MediaListEntry[] mediaListEntryArray, int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.updateList] index='%2'", (Object)LOGCLASS, (long)n);
        this.lastList = mediaListEntryArray;
        this.lastIndex = n;
        EvoListRow[] evoListRowArray = new AbstractMediaPlayViewListRow[mediaListEntryArray.length];
        EvoListRow evoListRow = null;
        AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = null;
        boolean bl = false;
        AbstractMediaPlayViewListRow abstractMediaPlayViewListRow2 = this.getCurrentSelectedRow();
        Object object = this.listUpdateMutex;
        synchronized (object) {
            Object object2;
            boolean bl2 = this.listInvalid;
            for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
                object2 = mediaListEntryArray[i2];
                AbstractMediaPlayViewListRow abstractMediaPlayViewListRow3 = this.createRow((MediaListEntry)object2);
                if (this.isJumpToCurrentListRequestRunning && this.currentPlayingTrack.getEntryID() == abstractMediaPlayViewListRow3.getEntryID()) {
                    abstractMediaPlayViewListRow2 = abstractMediaPlayViewListRow3;
                }
                evoListRowArray[i2] = abstractMediaPlayViewListRow3;
                if (!this.listInvalid && abstractMediaPlayViewListRow2 != null && abstractMediaPlayViewListRow2.getEntryID() != this.currentPlayingTrack.getEntryID()) {
                    if (abstractMediaPlayViewListRow2.getEntryID() == ((MediaListEntry)object2).getEntryID()) {
                        this.logger.log(10000000, "[%1.updateList] Selected row with entryID '%2' is not the currentPlaying entryID '%3', a track change is in progress. Set current row to selected row.", (Object)LOGCLASS, abstractMediaPlayViewListRow2.getEntryID(), this.currentPlayingTrack.getEntryID());
                        evoListRow = abstractMediaPlayViewListRow3;
                        bl = true;
                    }
                } else if (this.currentPlayingTrack.getEntryID() == ((MediaListEntry)object2).getEntryID()) {
                    this.logger.log(10000000, "[%1.updateList] Playing row found.", (Object)LOGCLASS);
                    evoListRow = abstractMediaPlayViewListRow3;
                }
                if (this.currentFocusedRow == null || this.currentFocusedRow.getEntryID() != ((MediaListEntry)object2).getEntryID()) continue;
                this.logger.log(10000000, "[%1.updateList] Focused row found.", (Object)LOGCLASS);
                abstractMediaPlayViewListRow = abstractMediaPlayViewListRow3;
            }
            TiledListModelApp tiledListModelApp = this.getPlayViewListModel();
            this.logger.log(10000000, "[%1.updateList] Update list model.", (Object)LOGCLASS);
            object2 = tiledListModelApp.getCopy();
            if (this.clearList) {
                this.logger.log(10000000, "[%1.updateList] clear List.", (Object)LOGCLASS);
                tiledListModelApp.getMenu().resetFocusedItem();
                object2.clearAll();
                this.clearList = false;
            }
            if (this.isJumpToCurrentListRequestRunning && null != abstractMediaPlayViewListRow2) {
                this.logger.log(10000000, "[%1.updateList] jump to current request is running and current selected row is found.", (Object)LOGCLASS);
                this.removePlayingTrack((BaseListModelApp)object2);
                if (this.player.supportsPlaytime()) {
                    abstractMediaPlayViewListRow2.setTime(this.currentTrackTime);
                }
                abstractMediaPlayViewListRow2.setPlaying(true);
            }
            object2.setRows(n3, n, evoListRowArray);
            if (evoListRow != null) {
                abstractMediaPlayViewListRow2 = evoListRow;
                object2.setSelectedUniqueID(evoListRow.getUniqueID());
                if (this.player.supportsPlaytime()) {
                    if (!bl) {
                        this.setTrackTime(this.currentTrackTime, (BaseListModelApp)object2);
                    } else {
                        this.logger.log(10000000, "[%1.updateList] Track change in progress, track time not written to selected row.", (Object)LOGCLASS);
                    }
                }
                if (this.player.isReadyToPlay()) {
                    this.setPlaying(true, (BaseListModelApp)object2);
                }
            }
            tiledListModelApp.update((BaseListModelApp)object2);
            boolean bl3 = n3 < 0 && !this.listInvalid;
            this.listInvalid = false;
            if (this.isJumpToCurrentListRequestRunning) {
                this.logger.log(10000000, "[%1.updateList] Merge C1/C2 cursor.", (Object)LOGCLASS);
                if (abstractMediaPlayViewListRow2 != null) {
                    this.setAutomaticCursorMerge(true);
                    this.currentFocusedRow = abstractMediaPlayViewListRow2;
                    this.isJumpToCurrentListRequestRunning = false;
                } else {
                    this.logger.log(10000000, "[%1.updateList] No current selected row.", (Object)LOGCLASS);
                }
            } else if (bl3) {
                if (abstractMediaPlayViewListRow != null && abstractMediaPlayViewListRow2 != null && abstractMediaPlayViewListRow.getEntryID() == abstractMediaPlayViewListRow2.getEntryID()) {
                    this.logger.log(10000000, "[%1.updateList] Merge cursor.", (Object)LOGCLASS);
                    this.setAutomaticCursorMerge(true);
                } else if (abstractMediaPlayViewListRow != null && this.automaticCursorMerge) {
                    this.setFocusedCursorPosition(abstractMediaPlayViewListRow);
                } else {
                    this.logger.log(10000000, "[%1.updateList] No focused row.", (Object)LOGCLASS);
                    this.currentFocusedRow = null;
                }
            }
            this.setDetailInfoInList();
            if (bl2 && this.currentPlayingTrack != null && this.currentPlayingTrack.getEntryID() != -1L) {
                this.logger.log(1000000, "[%1.updateList] simulating track change to initialize playview", (Object)LOGCLASS);
                this.trackChanged(true, false, this.currentPlayingTrack, this.currentTrackTime);
                this.coverArtChanged(this.currentCover);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void listChanged(boolean bl, long l, int n, int n2) {
        this.logger.log(1000000, "[%1.listChanged] eId='%2' size='%3'", (Object)LOGCLASS, (Object)Long.toString(l), (Object)Integer.toString(n));
        this.setListSize(n, (n2 & 0x1000) == 0);
        ChoiceModelApp choiceModelApp = this.getPlayableFilesAvailableModel();
        if (choiceModelApp != null) {
            boolean bl2 = (n2 & 1) != 1;
            choiceModelApp.setValue(n > 0 && bl2 ? 1 : 0);
        }
        if (n == 0) {
            this.updateList(new MediaListEntry[0], 0, 0, -1);
            this.unblockList();
            return;
        }
        if (bl) {
            Object object = this.listUpdateMutex;
            synchronized (object) {
                this.logger.log(1000000, "[%1.listChanged] Complete list change. Wait for list update", (Object)LOGCLASS);
                this.blockList();
                this.listRequestQueue.abort();
                this.clear();
                this.currentFocusedRow = this.createRow(new MediaListEntry(l, 0, ""));
                this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, l));
            }
        }
        this.logger.log(1000000, "[%1.listChanged] Update play view size.", (Object)LOGCLASS);
        Object object = this.listUpdateMutex;
        synchronized (object) {
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.currentFocusedRow;
            boolean bl3 = this.clearList = (n2 & 2) == 2 || (n2 & 4) == 4;
            if (abstractMediaPlayViewListRow == null) {
                abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            }
            if (abstractMediaPlayViewListRow == null) {
                if (l == -1L) {
                    this.logger.log(1000000, "[%1.listChanged] No focused row. Update list from the beginning.", (Object)LOGCLASS);
                    this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, 0, this.getWindowRequestSize()));
                    return;
                }
                this.logger.log(1000000, "[%1.listChanged] No focused row. Update list from actual track. entryID = '%2' (wait for jump to current track...)", (Object)LOGCLASS, l);
                return;
            }
            this.logger.log(1000000, "[%1.listChanged] Update list arround focused row.", (Object)LOGCLASS);
            PlayViewListRequest playViewListRequest = (PlayViewListRequest)this.listRequestQueue.getRunningJob();
            if (null == playViewListRequest || abstractMediaPlayViewListRow.getEntryID() != playViewListRequest.getEntryId()) {
                this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, abstractMediaPlayViewListRow.getEntryID()));
            } else {
                this.logger.log(10000000, "[%1.listChanged] No play view request. Request for '%2' already running.", (Object)LOGCLASS, abstractMediaPlayViewListRow.getEntryID());
            }
        }
    }

    public void listInvalidated() {
        this.logger.log(1000000, "[%1.listInvalidated]", (Object)LOGCLASS);
        this.blockList();
        this.clear();
        this.listInvalid = true;
        this.listRequestQueue.abort();
        this.initialListReceived = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void listChangeOnSelection(boolean bl) {
        this.logger.log(1000000, "[%1.listChangeOnSelection]", (Object)LOGCLASS);
        this.blockList();
        this.setCursorMergeModeFlag(true);
        if (!bl) {
            this.currentCover = null;
            Object object = this.listUpdateMutex;
            synchronized (object) {
                this.currentDetailInfo = null;
            }
        }
    }

    public final int getClientID() {
        return this.getListRequestClientID();
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        this.logger.log(1000000, "[%1.responsePlayView]", (Object)LOGCLASS);
        this.initialListReceived = true;
        if (this.getListSize() > 0) {
            try {
                this.getRunningJob().responsePlayView(n, mediaListEntryArray, n2);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.responsePlayView] Error on update list occurred.", (Object)LOGCLASS, (Throwable)exception);
            }
        } else {
            this.logger.log(1000000, "[%1.responsePlayView] List size changed to 0. Ignore response.", (Object)LOGCLASS);
        }
        this.unblockList();
        if (this.getListProgressIndicator() != null) {
            this.getListProgressIndicator().stopIndication();
        }
        this.finishListStartup();
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] Request aborted.", (Object)LOGCLASS);
        this.getRunningJob().errorListRequestAborted();
    }

    public void errorForJumpToTrackListRequest() {
        this.logger.log(1000000, "[%1.errorForJumpToTrackListRequest]", (Object)LOGCLASS);
        this.unblockList();
        this.isJumpToCurrentListRequestRunning = false;
        this.finishListStartup();
    }

    private void finishListStartup() {
        if (!this.isListStartupComplete) {
            this.getTerminal().getFramework().getStartupMgr().logStartupEvent("[MEDIA] TRACKLIST RECEIVED");
            this.isListStartupComplete = true;
            this.listStartupComplete();
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(1000000, "[%1.requestItems] startIdx='%2' len='%3'", (Object)LOGCLASS, (long)n, (long)n2);
        if (this.currentListSize == -1 || !this.initialListReceived) {
            this.logger.log(1000000, "[%1.requestItems] invalid playview size or no initial data - delaying request [%2, %3]", (Object)LOGCLASS, (Object)Integer.toString(this.currentListSize), (Object)Boolean.toString(this.initialListReceived));
            this.listRequestDelayDispatcher.execute(new PlayViewListDelayJob(new PlayViewListRequest(this.logger, this, this.player, n, n2, n3)), 100L);
            return;
        }
        this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, n, n2, n3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unrequestItems(int n, int n2, int n3, int n4) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1000000, "[%1.unrequestItems] startIdx='%2' len='%3'", (Object)LOGCLASS, (long)n, (long)n2);
            int n5 = n + n2;
            int n6 = -1;
            if (this.getPlayViewListModel().getSelected() != null) {
                n6 = this.getPlayViewListModel().getSelected().getIndex();
            }
            if (-1 == n6) {
                this.getPlayViewListModel().clearRows(n, n2);
                return;
            }
            int n7 = n6 - this.getWindowRequestSize() / 2;
            int n8 = n6 + this.getWindowRequestSize() / 2;
            if (n < n7 && n5 > n8) {
                Object object2;
                int n9 = n7 - n - 1;
                int n10 = n5 - n8 - 1;
                if (this.logger.isInfo()) {
                    object2 = new Buffer(70);
                    ((Buffer)object2).append("remove startIdx='").append(n).append("' len='").append(n9).append("' and startIdx='").append(n8 - 1).append("' len='").append(n10).append("'");
                    this.logger.log(1000000, "[%1.unrequestItems] %2", (Object)LOGCLASS, (Object)((Buffer)object2).toString());
                }
                object2 = this.getPlayViewListModel().getCopy();
                object2.clearRows(n, n9);
                object2.clearRows(n8 + 1, n10);
                this.getPlayViewListModel().update((BaseListModelApp)object2);
                return;
            }
            if (n5 > n7 && n5 < n8) {
                n5 = n7 - 1;
            }
            if (n < n8 && n > n7) {
                n = n8 + 1;
            }
            if (n < n5) {
                this.logger.log(1000000, "[%1.unrequestItems] remove startIdx='%2' len='%3'", (Object)LOGCLASS, (long)n, (long)(n5 - n));
                this.getPlayViewListModel().clearRows(n, n5 - n);
            }
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.setCursorMergeModeFlagOnly(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(1000000, "[%1.itemFocused] '%2' (vIdx='%3').", (Object)LOGCLASS, (Object)evoListRow, (long)n3);
        if (this.isBlocked()) {
            this.logger.log(100000, "[%1.itemFocused] List blocked. Ignore.", (Object)LOGCLASS);
            return;
        }
        Object object = this.listUpdateMutex;
        synchronized (object) {
            if (evoListRow == null) {
                this.logger.log(100000, "[%1.itemFocused] Focused row is null. Ignore.", (Object)LOGCLASS);
                this.currentFocusedRow = null;
                return;
            }
            this.currentFocusedRow = (AbstractMediaPlayViewListRow)evoListRow;
            this.getBaseListModel(n).getMenu().resetFocusedItem();
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            if (abstractMediaPlayViewListRow == null) {
                this.logger.log(1000000, "[%1.itemFocused] No playing row.", (Object)LOGCLASS);
                return;
            }
            if (this.currentFocusedRow.equals(abstractMediaPlayViewListRow)) {
                this.logger.log(1000000, "[%1.itemFocused] Playing row.", (Object)LOGCLASS);
                this.getChoiceModel(200853).setValue(0);
                if (!this.isAutomaticCursorMerge()) {
                    this.setAutomaticCursorMerge(true);
                }
                return;
            }
            this.setCursorMergeModeFlagOnly(false);
            this.getChoiceModel(200853).setValue(1);
        }
    }

    protected boolean isNPSAvailable() {
        return this.getTerminal().getFramework().getHMIService().getChoiceModel(180).getValue() == 1;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    class PlayViewListDelayJob
    implements Runnable {
        PlayViewListRequest request;

        PlayViewListDelayJob(PlayViewListRequest playViewListRequest) {
            this.request = playViewListRequest;
        }

        public void run() {
            if (!AbstractMediaPlayViewList.this.active) {
                return;
            }
            if (AbstractMediaPlayViewList.this.currentListSize == -1 || !AbstractMediaPlayViewList.this.initialListReceived) {
                AbstractMediaPlayViewList.this.logger.log(1000000, "[PlayViewListDelayJob.run] delay play view request %1]", (long)this.request.getRequestId());
                AbstractMediaPlayViewList.this.listRequestDelayDispatcher.execute(new PlayViewListDelayJob(this.request), 100L);
                return;
            }
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = AbstractMediaPlayViewList.this.getCurrentFocusedRow();
            MediaListEntry mediaListEntry = null;
            int n = -1;
            if (abstractMediaPlayViewListRow != null && AbstractMediaPlayViewList.this.lastList != null && AbstractMediaPlayViewList.this.lastList.length != 0) {
                for (int i2 = 0; i2 < AbstractMediaPlayViewList.this.lastList.length; ++i2) {
                    if (AbstractMediaPlayViewList.this.lastList[i2].getEntryID() != abstractMediaPlayViewListRow.getEntryID()) continue;
                    mediaListEntry = AbstractMediaPlayViewList.this.lastList[i2];
                    n = AbstractMediaPlayViewList.this.lastIndex + i2;
                    break;
                }
            }
            if (mediaListEntry != null) {
                AbstractMediaPlayViewList.this.logger.log(1000000, "[PlayViewListDelayJob.run] return playview with focused entry as error reply %1]", (long)this.request.getRequestId());
                AbstractMediaPlayViewList.this.updateList(new MediaListEntry[]{mediaListEntry}, n, 0, this.request.getRequestId());
            } else {
                AbstractMediaPlayViewList.this.logger.log(1000000, "[PlayViewListDelayJob.run] return empty playview as error reply %1]", (long)this.request.getRequestId());
                AbstractMediaPlayViewList.this.updateList(new MediaListEntry[0], 0, 0, this.request.getRequestId());
            }
        }
    }

    protected static class PlayerViewListenerProxy
    implements IPlayerViewListener {
        protected final IPlayerViewListener listener;

        public PlayerViewListenerProxy(IPlayerViewListener iPlayerViewListener) {
            this.listener = iPlayerViewListener;
        }

        public void listInvalidated() {
            this.listener.listInvalidated();
        }

        public void listChangeOnSelection(boolean bl) {
            this.listener.listChangeOnSelection(bl);
        }

        public void listChanged(boolean bl, long l, int n, int n2) {
            this.listener.listChanged(bl, l, n, n2);
        }

        public int getClientID() {
            return this.listener.getClientID();
        }

        public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
            this.listener.responsePlayView(n, mediaListEntryArray, n2);
        }

        public void errorListRequestAborted() {
            this.listener.errorListRequestAborted();
        }

        public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
            this.listener.notifySameTrackSelected(mediaDetailInfo, resourceLocator);
        }
    }
}

