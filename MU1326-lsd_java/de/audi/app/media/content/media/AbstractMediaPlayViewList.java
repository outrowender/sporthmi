/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.content.media.AbstractMediaPlayViewList$PlayViewListDelayJob;
import de.audi.app.media.content.media.AbstractMediaPlayViewList$PlayerViewListenerProxy;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IPlayViewList;
import de.audi.app.media.content.media.IPlayer;
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
    private static final String LOGCLASS;
    static final long REQUEST_DELAY;
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
    private static final int CURSOR_MERGED;
    private static final int CURSOR_NOT_MERGED;
    protected volatile AbstractMediaPlayViewList$PlayerViewListenerProxy playerViewListenerProxy;
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
        this.playerViewListenerProxy = new AbstractMediaPlayViewList$PlayerViewListenerProxy(this);
    }

    protected abstract void listStartupComplete() {
    }

    protected abstract boolean isRequestFullList() {
    }

    protected abstract TiledListModelApp getPlayViewListModel() {
    }

    protected abstract ChoiceModelApp getPlayableFilesAvailableModel() {
    }

    protected abstract AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
    }

    protected abstract IProgressIndication getListProgressIndicator() {
    }

    protected abstract int getListRequestClientID() {
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"AbstractMediaPlayViewList");
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"AbstractMediaPlayViewList");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"AbstractMediaPlayViewList");
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

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"AbstractMediaPlayViewList");
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

    @Override
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
    @Override
    public void setAutomaticCursorMerge(boolean bl) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            if (this.isAutomaticCursorMerge() == bl) {
                this.logger.log(1078071040, "[%1.setAutomaticCursorMerge] Already '%2'", (Object)"AbstractMediaPlayViewList", (Object)(bl ? "ON" : "OFF"));
            }
            this.logger.log(1078071040, "[%1.setAutomaticCursorMerge] '%2'", (Object)"AbstractMediaPlayViewList", (Object)(bl ? "ON" : "OFF"));
            this.setCursorMergeModeFlag(bl);
            if (bl) {
                this.triggerCursorMerge(this.getPlayViewListModel(), false);
            }
        }
    }

    @Override
    public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.logger.log(1078071040, "[%1.notifySameTrackSelected]", (Object)"AbstractMediaPlayViewList");
        this.detailInfoChanged(mediaDetailInfo);
        this.coverArtChanged(resourceLocator);
    }

    private void triggerCursorMerge(BaseListModelApp baseListModelApp, boolean bl) {
        if (bl) {
            this.logger.log(1078071040, "[%1.triggerCursorMerge] Forced.", (Object)"AbstractMediaPlayViewList");
            baseListModelApp.trigger(ModelTrigger.JOIN_CURSOR);
        } else {
            this.logger.log(1078071040, "[%1.triggerCursorMerge] if no scrolling", (Object)"AbstractMediaPlayViewList");
            baseListModelApp.trigger(ModelTrigger.JOIN_CURSOR_NO_SCROLLING);
        }
    }

    protected final void triggerFullScreen() {
        this.logger.log(1078071040, "[%1.triggerFullScreen]", (Object)"AbstractMediaPlayViewList");
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
            this.getChoiceModel(940442368).setValue(bl ? 1 : 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCursorMergeModeFlagOnly(boolean bl) {
        this.logger.log(14808325, "[%1.setCursorMergeModeFlagOnly] '%2'", (Object)"AbstractMediaPlayViewList", (Object)bl);
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
            this.logger.log(1078071040, "[%1.jumpToCurrentTrack] Playing row found (rowID='%2').", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow.getUniqueID());
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow2 = abstractMediaPlayViewListRow;
            if (abstractMediaPlayViewListRow2.equals(this.currentFocusedRow)) {
                this.logger.log(1078071040, "[%1.jumpToCurrentTrack] Focus already set.", (Object)"AbstractMediaPlayViewList");
                return;
            }
            this.currentFocusedRow = abstractMediaPlayViewListRow2;
            this.triggerCursorMerge(this.getPlayViewListModel(), false);
            return;
        }
        this.logger.log(1078071040, "[%1.jumpToCurrentTrack] Playing row not found.", (Object)"AbstractMediaPlayViewList");
        if (this.getListSize() == 0) {
            this.logger.log(1078071040, "[%1.jumpToCurrentTrack] List is empty. Ignore.", (Object)"AbstractMediaPlayViewList");
            return;
        }
        long l = this.currentPlayingTrack.getEntryID();
        if (l == -1L) {
            this.logger.log(1078071040, "[%1.jumpToCurrentTrack] Track ID invalid. Request list from beginning.", (Object)"AbstractMediaPlayViewList");
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
            this.logger.log(-2137614336, "[%1.jumpToCurrentTrack] No play view request. Request for '%2' already running.", (Object)"AbstractMediaPlayViewList", l);
        }
    }

    private PlayViewListRequest getRunningJob() {
        IQueueJob iQueueJob = this.listRequestQueue.getRunningJob();
        return iQueueJob != null ? (PlayViewListRequest)iQueueJob : new NullPlayViewListRequest();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void clear() {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.clear]", (Object)"AbstractMediaPlayViewList");
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
                this.logger.log(1078071040, "[%1.setSelectedEntry] Entry to select found (rowID='%2').", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow.getUniqueID());
                BaseListModelApp baseListModelApp = this.getPlayViewListModel().getCopy();
                AbstractMediaPlayViewListRow abstractMediaPlayViewListRow2 = this.getCurrentSelectedRow();
                if (abstractMediaPlayViewListRow2 != null) {
                    this.logger.log(1078071040, "[%1.setSelectedEntry] Remove tracktime for '%2'", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow2.getEntryID());
                    this.setTrackTime(null, baseListModelApp);
                    this.setPlaying(false, baseListModelApp);
                    baseListModelApp.setSelectedUniqueID(abstractMediaPlayViewListRow.getUniqueID());
                    boolean bl = this.getTerminal().getConfiguration().isIAP2Supported();
                    boolean bl2 = this.getTerminal().getSourceController().getSelectedSlot().getMediaType() == 24;
                    int n = this.getTerminal().getSourceController().getSelectedSlot().getMediaType();
                    boolean bl3 = this.player.getPlaybackModeHandler().isRepeatTrack();
                    this.logger.log(1078071040, new StringBuffer().append("[%1.setSelectedEntry] iAP2='%2', iPod='%3', repeatTrack='%4' activeMediaType ='").append(n).append("'.").toString(), (Object)"AbstractMediaPlayViewList", (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl3));
                    if (bl && bl2 && bl3) {
                        this.logger.log(1078071040, "[%1.setSelectedEntry] iPod iAP2 with repeatTrack -> Set the playing flag. Don't wait for track change.", (Object)"AbstractMediaPlayViewList");
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

    @Override
    public final void blockList() {
        this.logger.log(1078071040, "[%1.blockList]", (Object)"AbstractMediaPlayViewList");
        this.getPlayViewListModel().setStatus(0);
    }

    protected final boolean isBlocked() {
        return this.getPlayViewListModel().getStatus() == 0;
    }

    @Override
    public final void unblockList() {
        this.logger.log(1078071040, "[%1.unblockList]", (Object)"AbstractMediaPlayViewList");
        this.getPlayViewListModel().setStatus(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void trackChanged(boolean bl, boolean bl2, PlayingTrack playingTrack, PlayTime playTime) {
        this.logger.log(1078071040, "[%1.trackChanged] track changed=%2 tracktime=%3", (Object)"AbstractMediaPlayViewList", (Object)Boolean.toString(bl), (long)playTime.getPlayTime());
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
                    this.logger.log(1078071040, "[%1.trackChanged] Playing row found.", (Object)"AbstractMediaPlayViewList");
                    if (abstractMediaPlayViewListRow != null) {
                        this.logger.log(1078071040, "[%1.trackChanged] Remove tracktime for '%2'", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow.getEntryID());
                        this.removePlayingTrack(baseListModelApp);
                    }
                    baseListModelApp.setSelectedUniqueID(abstractMediaPlayViewListRow2.getUniqueID());
                    if (this.player.supportsPlaytime()) {
                        this.setTrackTime(playTime, baseListModelApp);
                    }
                    this.setPlaying(true, baseListModelApp);
                    if (bl2) {
                        this.logger.log(1078071040, "[%1.trackChanged] Skipped.", (Object)"AbstractMediaPlayViewList");
                        this.setCursorMergeModeFlag(true);
                    }
                    if (this.isAutomaticCursorMerge()) {
                        this.triggerCursorMerge(baseListModelApp, bl2);
                        this.currentFocusedRow = abstractMediaPlayViewListRow2;
                    }
                    this.getPlayViewListModel().update(baseListModelApp);
                } else {
                    this.logger.log(1078071040, "[%1.trackChanged] Playing row not found.", (Object)"AbstractMediaPlayViewList");
                    this.getPlayViewListModel().update(baseListModelApp);
                    if (this.currentListSize != -1) {
                        this.logger.log(1078071040, "[%1.trackChanged] Jump to current track.", (Object)"AbstractMediaPlayViewList");
                        this.jumpToCurrentTrack();
                    }
                }
            } else if (this.player.supportsPlaytime() && !this.listInvalid) {
                this.setTrackTime(playTime, this.getPlayViewListModel());
            }
        }
    }

    protected void removePlayingTrack(BaseListModelApp baseListModelApp) {
        this.logger.log(1078071040, "[%1.removePlayingTrack]", (Object)"AbstractMediaPlayViewList");
        if (this.player.supportsPlaytime()) {
            this.setTrackTime(null, baseListModelApp);
        }
        this.setPlaying(false, baseListModelApp);
        baseListModelApp.setSelectedIndex(-1);
        baseListModelApp.getMenu().resetFocusedItem();
    }

    private boolean setFocusedCursorPosition(AbstractMediaPlayViewListRow abstractMediaPlayViewListRow) {
        this.logger.log(1078071040, "[%1.setFocusedCursorPosition] uId='%2' entryId='%3'", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow.getUniqueID(), abstractMediaPlayViewListRow.getEntryID());
        this.getPlayViewListModel().getMenu().setFocusedItem(this.getPlayViewListModel().getID(), FocusAdvice.KEEP_POSITION, abstractMediaPlayViewListRow.getUniqueID());
        return true;
    }

    private AbstractMediaPlayViewListRow getMediaPlayListRow(long l) {
        this.logger.log(1078071040, "[%1.getMediaPlayListRow] eId='%2'", (Object)"AbstractMediaPlayViewList", l);
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
    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.detailInfoChanged] aCh='%2' tCh='%3'", (Object)"AbstractMediaPlayViewList", (long)mediaDetailInfo.getActiveChapter(), (long)mediaDetailInfo.getNumChapters());
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
            this.logger.log(1078071040, "[%1.setDetailInfoInList]", (Object)"AbstractMediaPlayViewList");
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            if (null != abstractMediaPlayViewListRow && null != this.currentDetailInfo) {
                abstractMediaPlayViewListRow.setDetailInfos(this.currentDetailInfo);
                if (this.currentCover != null) {
                    abstractMediaPlayViewListRow.setCoverArt(this.currentCover);
                } else {
                    this.logger.log(1078071040, "[%1.setDetailInfoInList] cover: 'null'.", (Object)"AbstractMediaPlayViewList");
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
    @Override
    public void coverArtChanged(ResourceLocator resourceLocator) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.coverArtChanged] cover: '%2'.", (Object)"AbstractMediaPlayViewList", (Object)resourceLocator);
            this.currentCover = resourceLocator;
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            if (null != abstractMediaPlayViewListRow) {
                this.logger.log(1078071040, "[%1.coverArtChanged] set cover: '%2' for entry: '%3'.", (Object)"AbstractMediaPlayViewList", (Object)resourceLocator, abstractMediaPlayViewListRow.getEntryID());
                abstractMediaPlayViewListRow.setCoverArt(resourceLocator);
                TiledListModelApp tiledListModelApp = this.getPlayViewListModel();
                if (tiledListModelApp.getSelected() != null) {
                    this.logger.log(1078071040, "[%1.coverArtChanged] update row after cover change.", (Object)"AbstractMediaPlayViewList");
                    tiledListModelApp.setRow(tiledListModelApp.getSelected().getIndex(), abstractMediaPlayViewListRow);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateTotalPlaytimeCapability(boolean bl) {
        this.logger.log(1078071040, "[%1.updatePlaytimeCapability] '%2'", (Object)"AbstractMediaPlayViewList", (Object)bl);
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
        this.logger.log(1078071040, "[%1.updateList] index='%2'", (Object)"AbstractMediaPlayViewList", (long)n);
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
                        this.logger.log(-2137614336, "[%1.updateList] Selected row with entryID '%2' is not the currentPlaying entryID '%3', a track change is in progress. Set current row to selected row.", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow2.getEntryID(), this.currentPlayingTrack.getEntryID());
                        evoListRow = abstractMediaPlayViewListRow3;
                        bl = true;
                    }
                } else if (this.currentPlayingTrack.getEntryID() == ((MediaListEntry)object2).getEntryID()) {
                    this.logger.log(-2137614336, "[%1.updateList] Playing row found.", (Object)"AbstractMediaPlayViewList");
                    evoListRow = abstractMediaPlayViewListRow3;
                }
                if (this.currentFocusedRow == null || this.currentFocusedRow.getEntryID() != ((MediaListEntry)object2).getEntryID()) continue;
                this.logger.log(-2137614336, "[%1.updateList] Focused row found.", (Object)"AbstractMediaPlayViewList");
                abstractMediaPlayViewListRow = abstractMediaPlayViewListRow3;
            }
            TiledListModelApp tiledListModelApp = this.getPlayViewListModel();
            this.logger.log(-2137614336, "[%1.updateList] Update list model.", (Object)"AbstractMediaPlayViewList");
            object2 = tiledListModelApp.getCopy();
            if (this.clearList) {
                this.logger.log(-2137614336, "[%1.updateList] clear List.", (Object)"AbstractMediaPlayViewList");
                tiledListModelApp.getMenu().resetFocusedItem();
                object2.clearAll();
                this.clearList = false;
            }
            if (this.isJumpToCurrentListRequestRunning && null != abstractMediaPlayViewListRow2) {
                this.logger.log(-2137614336, "[%1.updateList] jump to current request is running and current selected row is found.", (Object)"AbstractMediaPlayViewList");
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
                        this.logger.log(-2137614336, "[%1.updateList] Track change in progress, track time not written to selected row.", (Object)"AbstractMediaPlayViewList");
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
                this.logger.log(-2137614336, "[%1.updateList] Merge C1/C2 cursor.", (Object)"AbstractMediaPlayViewList");
                if (abstractMediaPlayViewListRow2 != null) {
                    this.setAutomaticCursorMerge(true);
                    this.currentFocusedRow = abstractMediaPlayViewListRow2;
                    this.isJumpToCurrentListRequestRunning = false;
                } else {
                    this.logger.log(-2137614336, "[%1.updateList] No current selected row.", (Object)"AbstractMediaPlayViewList");
                }
            } else if (bl3) {
                if (abstractMediaPlayViewListRow != null && abstractMediaPlayViewListRow2 != null && abstractMediaPlayViewListRow.getEntryID() == abstractMediaPlayViewListRow2.getEntryID()) {
                    this.logger.log(-2137614336, "[%1.updateList] Merge cursor.", (Object)"AbstractMediaPlayViewList");
                    this.setAutomaticCursorMerge(true);
                } else if (abstractMediaPlayViewListRow != null && this.automaticCursorMerge) {
                    this.setFocusedCursorPosition(abstractMediaPlayViewListRow);
                } else {
                    this.logger.log(-2137614336, "[%1.updateList] No focused row.", (Object)"AbstractMediaPlayViewList");
                    this.currentFocusedRow = null;
                }
            }
            this.setDetailInfoInList();
            if (bl2 && this.currentPlayingTrack != null && this.currentPlayingTrack.getEntryID() != -1L) {
                this.logger.log(1078071040, "[%1.updateList] simulating track change to initialize playview", (Object)"AbstractMediaPlayViewList");
                this.trackChanged(true, false, this.currentPlayingTrack, this.currentTrackTime);
                this.coverArtChanged(this.currentCover);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void listChanged(boolean bl, long l, int n, int n2) {
        this.logger.log(1078071040, "[%1.listChanged] eId='%2' size='%3'", (Object)"AbstractMediaPlayViewList", (Object)Long.toString(l), (Object)Integer.toString(n));
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
                this.logger.log(1078071040, "[%1.listChanged] Complete list change. Wait for list update", (Object)"AbstractMediaPlayViewList");
                this.blockList();
                this.listRequestQueue.abort();
                this.clear();
                this.currentFocusedRow = this.createRow(new MediaListEntry(l, 0, ""));
                this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, l));
            }
        }
        this.logger.log(1078071040, "[%1.listChanged] Update play view size.", (Object)"AbstractMediaPlayViewList");
        Object object = this.listUpdateMutex;
        synchronized (object) {
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.currentFocusedRow;
            boolean bl3 = this.clearList = (n2 & 2) == 2 || (n2 & 4) == 4;
            if (abstractMediaPlayViewListRow == null) {
                abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            }
            if (abstractMediaPlayViewListRow == null) {
                if (l == -1L) {
                    this.logger.log(1078071040, "[%1.listChanged] No focused row. Update list from the beginning.", (Object)"AbstractMediaPlayViewList");
                    this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, 0, this.getWindowRequestSize()));
                    return;
                }
                this.logger.log(1078071040, "[%1.listChanged] No focused row. Update list from actual track. entryID = '%2' (wait for jump to current track...)", (Object)"AbstractMediaPlayViewList", l);
                return;
            }
            this.logger.log(1078071040, "[%1.listChanged] Update list arround focused row.", (Object)"AbstractMediaPlayViewList");
            PlayViewListRequest playViewListRequest = (PlayViewListRequest)this.listRequestQueue.getRunningJob();
            if (null == playViewListRequest || abstractMediaPlayViewListRow.getEntryID() != playViewListRequest.getEntryId()) {
                this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, abstractMediaPlayViewListRow.getEntryID()));
            } else {
                this.logger.log(-2137614336, "[%1.listChanged] No play view request. Request for '%2' already running.", (Object)"AbstractMediaPlayViewList", abstractMediaPlayViewListRow.getEntryID());
            }
        }
    }

    @Override
    public void listInvalidated() {
        this.logger.log(1078071040, "[%1.listInvalidated]", (Object)"AbstractMediaPlayViewList");
        this.blockList();
        this.clear();
        this.listInvalid = true;
        this.listRequestQueue.abort();
        this.initialListReceived = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void listChangeOnSelection(boolean bl) {
        this.logger.log(1078071040, "[%1.listChangeOnSelection]", (Object)"AbstractMediaPlayViewList");
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

    @Override
    public final int getClientID() {
        return this.getListRequestClientID();
    }

    @Override
    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        this.logger.log(1078071040, "[%1.responsePlayView]", (Object)"AbstractMediaPlayViewList");
        this.initialListReceived = true;
        if (this.getListSize() > 0) {
            try {
                this.getRunningJob().responsePlayView(n, mediaListEntryArray, n2);
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.responsePlayView] Error on update list occurred.", (Object)"AbstractMediaPlayViewList", (Throwable)exception);
            }
        } else {
            this.logger.log(1078071040, "[%1.responsePlayView] List size changed to 0. Ignore response.", (Object)"AbstractMediaPlayViewList");
        }
        this.unblockList();
        if (this.getListProgressIndicator() != null) {
            this.getListProgressIndicator().stopIndication();
        }
        this.finishListStartup();
    }

    @Override
    public void errorListRequestAborted() {
        this.logger.log(1078071040, "[%1.errorListRequestAborted] Request aborted.", (Object)"AbstractMediaPlayViewList");
        this.getRunningJob().errorListRequestAborted();
    }

    public void errorForJumpToTrackListRequest() {
        this.logger.log(1078071040, "[%1.errorForJumpToTrackListRequest]", (Object)"AbstractMediaPlayViewList");
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

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(1078071040, "[%1.requestItems] startIdx='%2' len='%3'", (Object)"AbstractMediaPlayViewList", (long)n, (long)n2);
        if (this.currentListSize == -1 || !this.initialListReceived) {
            this.logger.log(1078071040, "[%1.requestItems] invalid playview size or no initial data - delaying request [%2, %3]", (Object)"AbstractMediaPlayViewList", (Object)Integer.toString(this.currentListSize), (Object)Boolean.toString(this.initialListReceived));
            this.listRequestDelayDispatcher.execute(new AbstractMediaPlayViewList$PlayViewListDelayJob(this, new PlayViewListRequest(this.logger, this, this.player, n, n2, n3)), 0);
            return;
        }
        this.listRequestQueue.enqueue(new PlayViewListRequest(this.logger, this, this.player, n, n2, n3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        Object object = this.listUpdateMutex;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.unrequestItems] startIdx='%2' len='%3'", (Object)"AbstractMediaPlayViewList", (long)n, (long)n2);
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
                    this.logger.log(1078071040, "[%1.unrequestItems] %2", (Object)"AbstractMediaPlayViewList", (Object)((Buffer)object2).toString());
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
                this.logger.log(1078071040, "[%1.unrequestItems] remove startIdx='%2' len='%3'", (Object)"AbstractMediaPlayViewList", (long)n, (long)(n5 - n));
                this.getPlayViewListModel().clearRows(n, n5 - n);
            }
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.setCursorMergeModeFlagOnly(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.itemFocused] '%2' (vIdx='%3').", (Object)"AbstractMediaPlayViewList", (Object)evoListRow, (long)n3);
        if (this.isBlocked()) {
            this.logger.log(-1601830656, "[%1.itemFocused] List blocked. Ignore.", (Object)"AbstractMediaPlayViewList");
            return;
        }
        Object object = this.listUpdateMutex;
        synchronized (object) {
            if (evoListRow == null) {
                this.logger.log(-1601830656, "[%1.itemFocused] Focused row is null. Ignore.", (Object)"AbstractMediaPlayViewList");
                this.currentFocusedRow = null;
                return;
            }
            this.currentFocusedRow = (AbstractMediaPlayViewListRow)evoListRow;
            this.getBaseListModel(n).getMenu().resetFocusedItem();
            AbstractMediaPlayViewListRow abstractMediaPlayViewListRow = this.getCurrentSelectedRow();
            if (abstractMediaPlayViewListRow == null) {
                this.logger.log(1078071040, "[%1.itemFocused] No playing row.", (Object)"AbstractMediaPlayViewList");
                return;
            }
            if (this.currentFocusedRow.equals(abstractMediaPlayViewListRow)) {
                this.logger.log(1078071040, "[%1.itemFocused] Playing row.", (Object)"AbstractMediaPlayViewList");
                this.getChoiceModel(-1794112768).setValue(0);
                if (!this.isAutomaticCursorMerge()) {
                    this.setAutomaticCursorMerge(true);
                }
                return;
            }
            this.setCursorMergeModeFlagOnly(false);
            this.getChoiceModel(-1794112768).setValue(1);
        }
    }

    protected boolean isNPSAvailable() {
        return this.getTerminal().getFramework().getHMIService().getChoiceModel(180).getValue() == 1;
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("AbstractMediaPlayViewList").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ int access$000(AbstractMediaPlayViewList abstractMediaPlayViewList) {
        return abstractMediaPlayViewList.currentListSize;
    }

    static /* synthetic */ boolean access$100(AbstractMediaPlayViewList abstractMediaPlayViewList) {
        return abstractMediaPlayViewList.initialListReceived;
    }

    static /* synthetic */ MediaListEntry[] access$200(AbstractMediaPlayViewList abstractMediaPlayViewList) {
        return abstractMediaPlayViewList.lastList;
    }

    static /* synthetic */ int access$300(AbstractMediaPlayViewList abstractMediaPlayViewList) {
        return abstractMediaPlayViewList.lastIndex;
    }
}

