/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataPlayer;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewList$1;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewList$DataPlayerViewListenerProxy;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewListRow;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.media.Capabilities;

public class DataPlayerPlayViewList
extends AbstractMediaPlayViewList
implements IActionProxyListener,
OptionModelListener,
IPlayerListener {
    private static final String LOGCLASS;
    private static final int DETAIL_INFO_AVAILABLE;
    private static final int DETAIL_INFO_NOT_AVAILABLE;
    private final DataPlayer dataPlayer;
    private final TiledListModelApp playViewList;
    private final ProgressIndicationImpl progressListIndicator;
    private volatile boolean startupFinished = false;
    private volatile boolean supportsTotalPlaytime = false;
    private volatile boolean activeState = false;

    public DataPlayerPlayViewList(IMediaTerminal iMediaTerminal, DataPlayer dataPlayer) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi(), dataPlayer, true);
        this.dataPlayer = dataPlayer;
        this.playViewList = this.getTiledListModel(-1072758016);
        this.progressListIndicator = new ProgressIndicationImpl(this.logger, this.getChoiceModel(-904985856), 0);
        this.playerViewListenerProxy = new DataPlayerPlayViewList$DataPlayerViewListenerProxy(this, this);
    }

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"DataPlayerPlayViewList");
        super.init();
        this.playViewList.setLength(0);
        this.playViewList.setListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"DataPlayerPlayViewList");
        super.deinit();
        this.playViewList.setListener(null);
        this.playViewList.clearAll();
    }

    @Override
    public void activate() {
        if (this.activeState) {
            return;
        }
        super.activate();
        this.logger.log(1078071040, "[%1.activate]", (Object)"DataPlayerPlayViewList");
        this.startupFinished = this.player.isPlayerStartupComplete();
        this.player.addPlayerListener(this);
        this.getTerminal().addActionProxyListener(28, (IActionProxyListener)this);
        this.getOptionModel(-888208640).setListener(this, -1072758016);
        this.getOptionModel(-1123024128).setListener(this, -1072758016);
        this.getOptionModel(-1139801344).setListener(this, -1072758016);
        this.getOptionModel(-1156578560).setListener(this, -1072758016);
        this.activeState = true;
    }

    @Override
    public void deactivate() {
        if (!this.activeState) {
            return;
        }
        super.deactivate();
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"DataPlayerPlayViewList");
        this.player.removePlayerListener(this);
        this.startupFinished = false;
        this.getTerminal().removeActionProxyListener(this);
        this.getOptionModel(-888208640).setListener(null, -1072758016);
        this.getOptionModel(-1139801344).setListener(null, -1072758016);
        this.getOptionModel(-1123024128).setListener(null, -1072758016);
        this.getOptionModel(-1156578560).setListener(null, -1072758016);
        this.activeState = false;
        this.getChoiceModel(873530112).setStatus(1);
    }

    @Override
    protected AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
        return new DataPlayerPlayViewListRow(mediaListEntry, this.dataPlayer.supportsPlaytime(), this.logger);
    }

    @Override
    protected TiledListModelApp getPlayViewListModel() {
        return this.getTiledListModel(-1072758016);
    }

    @Override
    protected boolean isRequestFullList() {
        return false;
    }

    @Override
    protected void listStartupComplete() {
        this.logger.log(1078071040, "[%1.listStartupComplete]", (Object)"DataPlayerPlayViewList");
        this.dataPlayer.getContent().notifyContentActivationFinished();
    }

    @Override
    protected int getListRequestClientID() {
        return 1;
    }

    @Override
    protected ChoiceModelApp getPlayableFilesAvailableModel() {
        return this.getChoiceModel(-1005649152);
    }

    @Override
    protected IProgressIndication getListProgressIndicator() {
        return this.progressListIndicator;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 28: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] AP_MERGE_CURSORS", (Object)"DataPlayerPlayViewList");
                this.setAutomaticCursorMerge(true);
                break;
            }
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow == null) {
            this.logger.log(-1601830656, "[%1.itemSelected] Selected row is null. Ignore.", (Object)"DataPlayerPlayViewList");
            return;
        }
        this.logger.log(1078071040, "[%1.itemSelected] '%2'", (Object)"DataPlayerPlayViewList", (Object)evoListRow);
        DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)evoListRow;
        if (!dataPlayerPlayViewListRow.isEnabled()) {
            this.logger.log(1078071040, "[%1.itemSelected] Disabled. Ignore.", (Object)"DataPlayerPlayViewList");
            return;
        }
        super.itemSelected(evoListRow, n, n2, n3, n4);
        this.getTerminal().getDispatcher().execute(new DataPlayerPlayViewList$1(this, "DataPlayerPlayViewList.selectEntry", dataPlayerPlayViewListRow));
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        switch (n) {
            case 200651: {
                this.logger.log(1078071040, "[%1.keyTyped] DATA_PLAYER_RINGTONE_OPTION.", (Object)"DataPlayerPlayViewList");
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                if (dataPlayerPlayViewListRow == null) {
                    this.logger.log(1078071040, "[%1.keyTyped] DATA_PLAYER_RINGTONE_OPTION. no row found", (Object)"DataPlayerPlayViewList");
                    return;
                }
                if (!dataPlayerPlayViewListRow.isAudio() || dataPlayerPlayViewListRow.getErrorState() != 0) {
                    this.logger.log(1078071040, "[%1.keyTyped] DATA_PLAYER_RINGTONE_OPTION Not valid ringtone title.", (Object)"DataPlayerPlayViewList");
                    return;
                }
                this.dataPlayer.setTitleAsRingtone(dataPlayerPlayViewListRow.getEntryID(), dataPlayerPlayViewListRow.getTitle());
                break;
            }
            case 200892: {
                this.logger.log(1078071040, "[%1.keyTyped] PLAY_MORE_OF_ALBUM_OPTION.", (Object)"DataPlayerPlayViewList");
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                this.playMoreOf(dataPlayerPlayViewListRow, 3);
                break;
            }
            case 200893: {
                this.logger.log(1078071040, "[%1.keyTyped] PLAY_MORE_OF_ARTIST_OPTION.", (Object)"DataPlayerPlayViewList");
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                this.playMoreOf(dataPlayerPlayViewListRow, 4);
                break;
            }
            case 200891: {
                this.logger.log(1078071040, "[%1.keyTyped] PLAY_MORE_OF_GENRE_OPTION.", (Object)"DataPlayerPlayViewList");
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.playViewList.getRow(n3);
                this.playMoreOf(dataPlayerPlayViewListRow, 5);
                break;
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        super.itemFocused(evoListRow, n, n2, n3, n4);
        DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)evoListRow;
        if (dataPlayerPlayViewListRow == null) {
            this.getChoiceModel(-1039203584).setValue(0);
            this.getResourceLocatorModel(-1022426368).setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
            return;
        }
        this.getChoiceModel(-1039203584).setValue(dataPlayerPlayViewListRow.isVideo() ? 2 : 1);
        int n5 = dataPlayerPlayViewListRow.getCoverArt() != null ? dataPlayerPlayViewListRow.getCoverArt().getId() : -1;
        String string = dataPlayerPlayViewListRow.getCoverArt() != null ? dataPlayerPlayViewListRow.getCoverArt().getUrl() : ResourceLocatorModelApp.UNDEFINED_URI;
        this.getResourceLocatorModel(-1022426368).setResourceLocator(n5, string);
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        super.detailInfoChanged(mediaDetailInfo);
        this.logger.log(1078071040, "[%1.detailInfoChanged]", (Object)"DataPlayerPlayViewList");
        if ((mediaDetailInfo.getAlbum() == null || mediaDetailInfo.getAlbum().isEmpty()) && (mediaDetailInfo.getArtist() == null || mediaDetailInfo.getArtist().isEmpty())) {
            this.getChoiceModel(-1525677312).setValue(1);
        } else {
            this.getChoiceModel(-1525677312).setValue(0);
        }
    }

    @Override
    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        super.responsePlayView(n, mediaListEntryArray, n2);
        this.getChoiceModel(873530112).setStatus(1);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("DataPlayerPlayViewList").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    public void invalidateCoverArt() {
        this.logger.log(1078071040, "[%1.invalidateCoverArt]", (Object)"DataPlayerPlayViewList");
        this.currentCover = null;
        this.getResourceLocatorModel(-1123089664).setStatus(0);
    }

    @Override
    public void playerStartupComplete() {
        this.startupFinished = true;
    }

    @Override
    public void repeatScopeChanged(int n, boolean bl) {
    }

    @Override
    public void repeatModeChanged(int n) {
    }

    @Override
    public void playbackStateChanged(int n) {
    }

    @Override
    public void capabilitiesChanged(Capabilities capabilities) {
        this.logger.log(1078071040, "[%1.capabilitiesChanged]", (Object)"DataPlayerPlayViewList");
        boolean bl = capabilities.isTotalPlaytime();
        if (this.startupFinished && bl != this.supportsTotalPlaytime) {
            this.logger.log(1078071040, "[%1.capabilitiesChanged] change list: '%2'", (Object)"DataPlayerPlayViewList", (Object)bl);
            this.updateTotalPlaytimeCapability(bl);
        }
        this.supportsTotalPlaytime = bl;
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    public void playMoreOf(DataPlayerPlayViewListRow dataPlayerPlayViewListRow, int n) {
        this.logger.log(1078071040, "[%1.playMoreOf] start", (Object)"DataPlayerPlayViewList");
        this.player.playMoreOf(dataPlayerPlayViewListRow.getEntryID(), n, null);
    }

    @Override
    public void commandBlocked() {
    }

    @Override
    public void currentPMLevelChanged(int n) {
    }

    static /* synthetic */ DataPlayer access$000(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.dataPlayer;
    }

    static /* synthetic */ LogChannel access$100(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ LogChannel access$200(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ void access$300(DataPlayerPlayViewList dataPlayerPlayViewList, long l) {
        dataPlayerPlayViewList.setSelectedEntry(l);
    }

    static /* synthetic */ LogChannel access$400(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ boolean access$500(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.isNPSAvailable();
    }

    static /* synthetic */ void access$600(DataPlayerPlayViewList dataPlayerPlayViewList) {
        dataPlayerPlayViewList.triggerFullScreen();
    }

    static /* synthetic */ LogChannel access$700(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ LogChannel access$800(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ LogChannel access$900(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ LogChannel access$1000(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }

    static /* synthetic */ LogChannel access$1100(DataPlayerPlayViewList dataPlayerPlayViewList) {
        return dataPlayerPlayViewList.logger;
    }
}

