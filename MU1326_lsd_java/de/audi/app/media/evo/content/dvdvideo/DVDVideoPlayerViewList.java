/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayer;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayerPlayViewListRow;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayerViewList$1;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class DVDVideoPlayerViewList
extends AbstractMediaPlayViewList
implements IActionProxyListener {
    private static final String LOGCLASS;
    private final DVDVideoPlayer dvdPlayer;
    private final TiledListModelApp dvdPlayViewList;
    private final ProgressIndicationImpl progressListIndicator;

    public DVDVideoPlayerViewList(IMediaTerminal iMediaTerminal, DVDVideoPlayer dVDVideoPlayer) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi(), dVDVideoPlayer, false);
        this.dvdPlayer = dVDVideoPlayer;
        this.dvdPlayViewList = this.getTiledListModel(-401669376);
        this.progressListIndicator = new ProgressIndicationImpl(this.logger, this.getChoiceModel(-267451648), 0);
    }

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"DVDVideoPlayerViewListNew");
        super.init();
        this.dvdPlayViewList.setLength(0);
        this.dvdPlayViewList.setListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.init]", (Object)"DVDVideoPlayerViewListNew");
        super.deinit();
        this.dvdPlayViewList.setListener(null);
        this.dvdPlayViewList.clearAll();
    }

    @Override
    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"DVDVideoPlayerViewListNew");
        super.activate();
        this.getTerminal().addActionProxyListener(28, (IActionProxyListener)this);
    }

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"DVDVideoPlayerViewListNew");
        super.deactivate();
        this.getTerminal().removeActionProxyListener(this);
    }

    @Override
    protected AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
        return new DVDVideoPlayerPlayViewListRow(mediaListEntry);
    }

    @Override
    protected TiledListModelApp getPlayViewListModel() {
        return this.dvdPlayViewList;
    }

    @Override
    protected boolean isRequestFullList() {
        return true;
    }

    @Override
    protected void listStartupComplete() {
        this.logger.log(1078071040, "[%1.listStartupComplete]", (Object)"DVDVideoPlayerViewListNew");
        this.dvdPlayer.getContent().notifyContentActivationFinished();
    }

    @Override
    protected int getListRequestClientID() {
        return 1;
    }

    @Override
    protected ChoiceModelApp getPlayableFilesAvailableModel() {
        return null;
    }

    @Override
    protected IProgressIndication getListProgressIndicator() {
        return this.progressListIndicator;
    }

    protected ChoiceModelApp getListIdleTimerModel() {
        return this.getChoiceModel(957219584);
    }

    protected ChoiceModelApp getListIdleNowplayingTimerModel() {
        return this.getChoiceModel(973996800);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 28: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] AP_MERGE_CURSORS", (Object)"DVDVideoPlayerViewListNew");
                this.setAutomaticCursorMerge(true);
                break;
            }
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.itemSelected] '%2'", (Object)"DVDVideoPlayerViewListNew", (Object)evoListRow);
        DVDVideoPlayerPlayViewListRow dVDVideoPlayerPlayViewListRow = (DVDVideoPlayerPlayViewListRow)evoListRow;
        this.getTerminal().getDispatcher().execute(new DVDVideoPlayerViewList$1(this, "DVDVideoPlayerViewList.selectEntry", dVDVideoPlayerPlayViewListRow));
    }

    private void blockAfterSelection() {
        this.getLabelModel(-368114944).setStatus(0);
    }

    void unblockAfterSelection() {
        this.getLabelModel(-368114944).setStatus(1);
    }

    @Override
    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        super.detailInfoChanged(mediaDetailInfo);
        this.unblockAfterSelection();
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("DVDVideoPlayerViewListNew").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    static /* synthetic */ DVDVideoPlayer access$000(DVDVideoPlayerViewList dVDVideoPlayerViewList) {
        return dVDVideoPlayerViewList.dvdPlayer;
    }

    static /* synthetic */ void access$100(DVDVideoPlayerViewList dVDVideoPlayerViewList) {
        dVDVideoPlayerViewList.blockAfterSelection();
    }

    static /* synthetic */ void access$200(DVDVideoPlayerViewList dVDVideoPlayerViewList, long l) {
        dVDVideoPlayerViewList.setSelectedEntry(l);
    }

    static /* synthetic */ void access$300(DVDVideoPlayerViewList dVDVideoPlayerViewList) {
        dVDVideoPlayerViewList.triggerFullScreen();
    }
}

