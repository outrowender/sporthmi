/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.dvdvideo;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayer;
import de.audi.app.media.evo.content.dvdvideo.DVDVideoPlayerPlayViewListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class DVDVideoPlayerViewList
extends AbstractMediaPlayViewList
implements IActionProxyListener {
    private static final String LOGCLASS = "DVDVideoPlayerViewListNew";
    private final DVDVideoPlayer dvdPlayer;
    private final TiledListModelApp dvdPlayViewList;
    private final ProgressIndicationImpl progressListIndicator;

    public DVDVideoPlayerViewList(IMediaTerminal iMediaTerminal, DVDVideoPlayer dVDVideoPlayer) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi(), dVDVideoPlayer, false);
        this.dvdPlayer = dVDVideoPlayer;
        this.dvdPlayViewList = this.getTiledListModel(200680);
        this.progressListIndicator = new ProgressIndicationImpl(this.logger, this.getChoiceModel(200688), 0);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.dvdPlayViewList.setLength(0);
        this.dvdPlayViewList.setListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.deinit();
        this.dvdPlayViewList.setListener(null);
        this.dvdPlayViewList.clearAll();
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        super.activate();
        this.getTerminal().addActionProxyListener(28, (IActionProxyListener)this);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        super.deactivate();
        this.getTerminal().removeActionProxyListener(this);
    }

    protected AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
        return new DVDVideoPlayerPlayViewListRow(mediaListEntry);
    }

    protected TiledListModelApp getPlayViewListModel() {
        return this.dvdPlayViewList;
    }

    protected boolean isRequestFullList() {
        return true;
    }

    protected void listStartupComplete() {
        this.logger.log(1000000, "[%1.listStartupComplete]", (Object)LOGCLASS);
        this.dvdPlayer.getContent().notifyContentActivationFinished();
    }

    protected int getListRequestClientID() {
        return 1;
    }

    protected ChoiceModelApp getPlayableFilesAvailableModel() {
        return null;
    }

    protected IProgressIndication getListProgressIndicator() {
        return this.progressListIndicator;
    }

    protected ChoiceModelApp getListIdleTimerModel() {
        return this.getChoiceModel(200249);
    }

    protected ChoiceModelApp getListIdleNowplayingTimerModel() {
        return this.getChoiceModel(200250);
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
        this.logger.log(1000000, "[%1.itemSelected] '%2'", (Object)LOGCLASS, (Object)evoListRow);
        final DVDVideoPlayerPlayViewListRow dVDVideoPlayerPlayViewListRow = (DVDVideoPlayerPlayViewListRow)evoListRow;
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("DVDVideoPlayerViewList.selectEntry"){

            public void run() {
                PlayingTrack playingTrack = DVDVideoPlayerViewList.this.dvdPlayer.getCurrentPlayingTrack();
                if (playingTrack.getEntryID() != dVDVideoPlayerPlayViewListRow.getEntryID()) {
                    DVDVideoPlayerViewList.this.blockAfterSelection();
                    DVDVideoPlayerViewList.this.setSelectedEntry(dVDVideoPlayerPlayViewListRow.getEntryID());
                    DVDVideoPlayerViewList.this.dvdPlayer.playEntry(dVDVideoPlayerPlayViewListRow.getEntryID());
                } else {
                    DVDVideoPlayerViewList.this.getTerminal().getAudioManager().resumeAudio(true);
                }
                DVDVideoPlayerViewList.this.triggerFullScreen();
            }
        });
    }

    private void blockAfterSelection() {
        this.getLabelModel(200682).setStatus(0);
    }

    void unblockAfterSelection() {
        this.getLabelModel(200682).setStatus(1);
    }

    public void detailInfoChanged(MediaDetailInfo mediaDetailInfo) {
        super.detailInfoChanged(mediaDetailInfo);
        this.unblockAfterSelection();
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }
}

