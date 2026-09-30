/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewListRow;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.media.Capabilities;

public class DataPlayerPlayViewList
extends AbstractMediaPlayViewList
implements IActionProxyListener,
OptionModelListener,
IPlayerListener {
    private static final String LOGCLASS = "DataPlayerPlayViewList";
    private static final int DETAIL_INFO_AVAILABLE = 0;
    private static final int DETAIL_INFO_NOT_AVAILABLE = 1;
    private final DataPlayer dataPlayer;
    private final TiledListModelApp playViewList;
    private final ProgressIndicationImpl progressListIndicator;
    private volatile boolean startupFinished = false;
    private volatile boolean supportsTotalPlaytime = false;
    private volatile boolean activeState = false;

    public DataPlayerPlayViewList(IMediaTerminal iMediaTerminal, DataPlayer dataPlayer) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi(), dataPlayer, true);
        this.dataPlayer = dataPlayer;
        this.playViewList = this.getTiledListModel(200640);
        this.progressListIndicator = new ProgressIndicationImpl(this.logger, this.getChoiceModel(200650), 0);
        this.playerViewListenerProxy = new DataPlayerViewListenerProxy(this);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.playViewList.setLength(0);
        this.playViewList.setListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
        this.playViewList.setListener(null);
        this.playViewList.clearAll();
    }

    public void activate() {
        if (this.activeState) {
            return;
        }
        super.activate();
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.startupFinished = this.player.isPlayerStartupComplete();
        this.player.addPlayerListener(this);
        this.getTerminal().addActionProxyListener(28, (IActionProxyListener)this);
        this.getOptionModel(200651).setListener(this, 200640);
        this.getOptionModel(200893).setListener(this, 200640);
        this.getOptionModel(200892).setListener(this, 200640);
        this.getOptionModel(200891).setListener(this, 200640);
        this.activeState = true;
    }

    public void deactivate() {
        if (!this.activeState) {
            return;
        }
        super.deactivate();
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.player.removePlayerListener(this);
        this.startupFinished = false;
        this.getTerminal().removeActionProxyListener(this);
        this.getOptionModel(200651).setListener(null, 200640);
        this.getOptionModel(200892).setListener(null, 200640);
        this.getOptionModel(200893).setListener(null, 200640);
        this.getOptionModel(200891).setListener(null, 200640);
        this.activeState = false;
        this.getChoiceModel(201012).setStatus(1);
    }

    protected AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
        return new DataPlayerPlayViewListRow(mediaListEntry, this.dataPlayer.supportsPlaytime(), this.logger);
    }

    protected TiledListModelApp getPlayViewListModel() {
        return this.getTiledListModel(200640);
    }

    protected boolean isRequestFullList() {
        return false;
    }

    protected void listStartupComplete() {
        this.logger.log(1000000, "[%1.listStartupComplete]", (Object)LOGCLASS);
        this.dataPlayer.getContent().notifyContentActivationFinished();
    }

    protected int getListRequestClientID() {
        return 1;
    }

    protected ChoiceModelApp getPlayableFilesAvailableModel() {
        return this.getChoiceModel(200644);
    }

    protected IProgressIndication getListProgressIndicator() {
        return this.progressListIndicator;
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 28: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] AP_MERGE_CURSORS", (Object)LOGCLASS);
                this.setAutomaticCursorMerge(true);
                break;
            }
        }
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow == null) {
            this.logger.log(100000, "[%1.itemSelected] Selected row is null. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.logger.log(1000000, "[%1.itemSelected] '%2'", (Object)LOGCLASS, (Object)evoListRow);
        final DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)evoListRow;
        if (!dataPlayerPlayViewListRow.isEnabled()) {
            this.logger.log(1000000, "[%1.itemSelected] Disabled. Ignore.", (Object)LOGCLASS);
            return;
        }
        super.itemSelected(evoListRow, n, n2, n3, n4);
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("DataPlayerPlayViewList.selectEntry"){

            public void run() {
                if (!DataPlayerPlayViewList.this.dataPlayer.isActive()) {
                    return;
                }
                PlayingTrack playingTrack = DataPlayerPlayViewList.this.dataPlayer.getCurrentPlayingTrack();
                SelectedItem selectedItem = DataPlayerPlayViewList.this.getPlayViewListModel().getSelected();
                if (null == selectedItem) {
                    DataPlayerPlayViewList.this.logger.log(1000000, "[%1.itemSelected] currentPlayingTrack=%2, selectedTrack=%3", (Object)DataPlayerPlayViewList.LOGCLASS, (Object)playingTrack, (Object)dataPlayerPlayViewListRow);
                }
                if (playingTrack.getEntryID() != dataPlayerPlayViewListRow.getEntryID() && (null == selectedItem || selectedItem.getUniqueID() != dataPlayerPlayViewListRow.getUniqueID())) {
                    DataPlayerPlayViewList.this.logger.log(1000000, "[%1.itemSelected] New track selected.", (Object)DataPlayerPlayViewList.LOGCLASS);
                    DataPlayerPlayViewList.this.setSelectedEntry(dataPlayerPlayViewListRow.getEntryID());
                    DataPlayerPlayViewList.this.dataPlayer.playEntry(dataPlayerPlayViewListRow.getEntryID(), dataPlayerPlayViewListRow.getTitle(), dataPlayerPlayViewListRow.isVideo());
                } else {
                    DataPlayerPlayViewList.this.logger.log(1000000, "[%1.itemSelected] Playing track selected.", (Object)DataPlayerPlayViewList.LOGCLASS);
                    DataPlayerPlayViewList.this.getTerminal().getAudioManager().resumeAudio(true);
                    if (dataPlayerPlayViewListRow.isAudio() && DataPlayerPlayViewList.this.isNPSAvailable() && playingTrack.getEntryID() == dataPlayerPlayViewListRow.getEntryID()) {
                        DataPlayerPlayViewList.this.getPlayViewListModel().trigger(ModelTrigger.ACTIVATE_NOW_PLAYING);
                    }
                }
                if (dataPlayerPlayViewListRow.isVideo()) {
                    DataPlayerPlayViewList.this.triggerFullScreen();
                }
            }
        });
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        switch (n) {
            case 200651: {
                this.logger.log(1000000, "[%1.keyTyped] DATA_PLAYER_RINGTONE_OPTION.", (Object)LOGCLASS);
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                if (dataPlayerPlayViewListRow == null) {
                    this.logger.log(1000000, "[%1.keyTyped] DATA_PLAYER_RINGTONE_OPTION. no row found", (Object)LOGCLASS);
                    return;
                }
                if (!dataPlayerPlayViewListRow.isAudio() || dataPlayerPlayViewListRow.getErrorState() != 0) {
                    this.logger.log(1000000, "[%1.keyTyped] DATA_PLAYER_RINGTONE_OPTION Not valid ringtone title.", (Object)LOGCLASS);
                    return;
                }
                this.dataPlayer.setTitleAsRingtone(dataPlayerPlayViewListRow.getEntryID(), dataPlayerPlayViewListRow.getTitle());
                break;
            }
            case 200892: {
                this.logger.log(1000000, "[%1.keyTyped] PLAY_MORE_OF_ALBUM_OPTION.", (Object)LOGCLASS);
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                this.playMoreOf(dataPlayerPlayViewListRow, 3);
                break;
            }
            case 200893: {
                this.logger.log(1000000, "[%1.keyTyped] PLAY_MORE_OF_ARTIST_OPTION.", (Object)LOGCLASS);
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                this.playMoreOf(dataPlayerPlayViewListRow, 4);
                break;
            }
            case 200891: {
                this.logger.log(1000000, "[%1.keyTyped] PLAY_MORE_OF_GENRE_OPTION.", (Object)LOGCLASS);
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                this.playMoreOf(dataPlayerPlayViewListRow, 5);
                break;
            }
        }
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        super.itemFocused(evoListRow, n, n2, n3, n4);
        DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)evoListRow;
        if (dataPlayerPlayViewListRow == null) {
            this.getChoiceModel(200642).setValue(0);
            this.getResourceLocatorModel(200643).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
            return;
        }
        this.getChoiceModel(200642).setValue(dataPlayerPlayViewListRow.isVideo() ? 2 : 1);
        int n5 = dataPlayerPlayViewListRow.getCoverArt() != null ? dataPlayerPlayViewListRow.getCoverArt().getId() : -1;
        String string = dataPlayerPlayViewListRow.getCoverArt() != null ? dataPlayerPlayViewListRow.getCoverArt().getUrl() : ResourceLocatorModelApp.UNDEFINED_URI;
        this.getResourceLocatorModel(200643).setResourceLocator(n5, string);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        super.detailInfoChanged(mediaDetailInfo);
        this.logger.log(1000000, "[%1.detailInfoChanged]", (Object)LOGCLASS);
        if ((mediaDetailInfo.getAlbum() == null || mediaDetailInfo.getAlbum().isEmpty()) && (mediaDetailInfo.getArtist() == null || mediaDetailInfo.getArtist().isEmpty())) {
            this.getChoiceModel(200869).setValue(1);
        } else {
            this.getChoiceModel(200869).setValue(0);
        }
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        super.responsePlayView(n, mediaListEntryArray, n2);
        this.getChoiceModel(201012).setStatus(1);
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    public void invalidateCoverArt() {
        this.logger.log(1000000, "[%1.invalidateCoverArt]", (Object)LOGCLASS);
        this.currentCover = null;
        this.getResourceLocatorModel(200637).setStatus(0);
    }

    public void playerStartupComplete() {
        this.startupFinished = true;
    }

    public void repeatScopeChanged(int n, boolean bl) {
    }

    public void repeatModeChanged(int n) {
    }

    public void playbackStateChanged(int n) {
    }

    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1000000, "[%1.capabilitiesChanged]", (Object)LOGCLASS);
        boolean bl = capabilities.isTotalPlaytime();
        if (this.startupFinished && bl != this.supportsTotalPlaytime) {
            this.logger.log(1000000, "[%1.capabilitiesChanged] change list: '%2'", (Object)LOGCLASS, (Object)bl);
            this.updateTotalPlaytimeCapability(bl);
        }
        this.supportsTotalPlaytime = bl;
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    public void playMoreOf(DataPlayerPlayViewListRow dataPlayerPlayViewListRow, int n) {
        this.logger.log(1000000, "[%1.playMoreOf] start", (Object)LOGCLASS);
        this.player.playMoreOf(dataPlayerPlayViewListRow.getEntryID(), n, null);
    }

    public void commandBlocked() {
    }

    public void currentPMLevelChanged(int n) {
    }

    private class DataPlayerViewListenerProxy
    extends AbstractMediaPlayViewList.PlayerViewListenerProxy
    implements TimerListener {
        private static final long COVER_SYNC_DELAY_TIME = 1000L;
        private final Timer coverSyncUpdateTimer;
        private volatile int currentSize;
        private volatile long entryId;
        private volatile boolean delayedUpdate;

        public DataPlayerViewListenerProxy(IPlayerViewListener iPlayerViewListener) {
            super(iPlayerViewListener);
            this.coverSyncUpdateTimer = new Timer("CoverSyncDelayTimer", 1000L, true, this);
            this.currentSize = -1;
            this.entryId = -1L;
        }

        private void reset() {
            DataPlayerPlayViewList.this.logger.log(1000000, "[%1.DataPlayerViewListenerProxy.reset]", (Object)DataPlayerPlayViewList.LOGCLASS);
            this.coverSyncUpdateTimer.cancel();
            this.currentSize = -1;
            this.entryId = -1L;
            this.delayedUpdate = false;
        }

        public void listInvalidated() {
            DataPlayerPlayViewList.this.logger.log(1000000, "[%1.DataPlayerViewListenerProxy.listInvalidated] No updates anymore. Stop timer.", (Object)DataPlayerPlayViewList.LOGCLASS);
            this.reset();
            this.listener.listInvalidated();
        }

        public void listChangeOnSelection(boolean bl) {
            DataPlayerPlayViewList.this.logger.log(1000000, "[%1.DataPlayerViewListenerProxy.listChangeOnSelection] List is changing.", (Object)DataPlayerPlayViewList.LOGCLASS);
            this.reset();
            this.listener.listChangeOnSelection(bl);
        }

        public void listChanged(boolean bl, long l, int n, int n2) {
            if (bl || this.currentSize != n || this.entryId != l || n2 != 4) {
                this.reset();
                this.currentSize = n;
                this.entryId = l;
                this.listener.listChanged(bl, l, n, n2);
                return;
            }
            if (this.coverSyncUpdateTimer.isRunning()) {
                DataPlayerPlayViewList.this.logger.log(1000000, "[%1.PlayerViewListenerProxy.listChanged] Delay cover sync update.", (Object)DataPlayerPlayViewList.LOGCLASS);
                this.delayedUpdate = true;
            } else {
                this.listener.listChanged(bl, l, n, n2);
                this.coverSyncUpdateTimer.start();
            }
        }

        public void fireTimer(Timer timer) {
            if (this.delayedUpdate) {
                DataPlayerPlayViewList.this.logger.log(1000000, "[%1.PlayerViewListenerProxy.fireTimer] Delayed cover sync update.", (Object)DataPlayerPlayViewList.LOGCLASS);
                this.delayedUpdate = false;
                this.listener.listChanged(false, this.entryId, this.currentSize, 4);
                this.coverSyncUpdateTimer.start();
            }
        }

        public void cancelTimer(Timer timer) {
        }
    }
}

