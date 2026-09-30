/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.cdda.CDDAPlayer;
import de.audi.app.media.evo.content.cdda.CDDAPlayerPlayViewListRow;
import de.audi.app.media.evo.transfer.IEvoTransferController;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class CDDAPlayerPlayViewList
extends AbstractMediaPlayViewList
implements IActionProxyListener,
ButtonListener {
    private static final String LOGCLASS = "CDDAPlayerPlayViewList";
    private final CDDAPlayer cddaPlayer;
    private final TiledListModelApp trackList;
    private final ProgressIndicationImpl progressListIndicator;

    public CDDAPlayerPlayViewList(IMediaTerminal iMediaTerminal, CDDAPlayer cDDAPlayer) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi(), cDDAPlayer, false);
        this.cddaPlayer = cDDAPlayer;
        this.trackList = this.getTiledListModel(200584);
        this.progressListIndicator = new ProgressIndicationImpl(this.logger, this.getChoiceModel(200595), 0);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        super.init();
        this.trackList.setLength(0);
        this.trackList.setListener(this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        super.deinit();
        this.trackList.setListener(null);
        this.trackList.clearAll();
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        super.activate();
        this.getTerminal().addActionProxyListener(28, (IActionProxyListener)this);
        this.getButtonModel(200449).setButtonListener(this);
        this.getButtonModel(200461).setButtonListener(this);
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        super.deactivate();
        this.getTerminal().removeActionProxyListener(this);
        this.getButtonModel(200449).setButtonListener(null);
        this.getButtonModel(200461).setButtonListener(null);
    }

    protected void listStartupComplete() {
        this.logger.log(1000000, "[%1.listStartupComplete]", (Object)LOGCLASS);
        this.cddaPlayer.getContent().notifyContentActivationFinished();
    }

    protected AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
        return new CDDAPlayerPlayViewListRow(mediaListEntry);
    }

    protected TiledListModelApp getPlayViewListModel() {
        return this.trackList;
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

    protected boolean isRequestFullList() {
        return true;
    }

    protected int getListRequestClientID() {
        return 1;
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
        this.logger.log(1000000, "[%1.itemSelected] Row '%2' selected.", (Object)LOGCLASS, (Object)evoListRow);
        final CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)evoListRow;
        if (!cDDAPlayerPlayViewListRow.isEnabled()) {
            this.logger.log(10000000, "[%1.itemSelected] Row is disabled. Ignore.", (Object)LOGCLASS);
            return;
        }
        this.getTerminal().getDispatcher().execute(new AbstractDispatcherRunnable("CDDAPlayerPlayViewList.selectEntry"){

            public void run() {
                PlayingTrack playingTrack = CDDAPlayerPlayViewList.this.cddaPlayer.getCurrentPlayingTrack();
                if (playingTrack.getEntryID() != cDDAPlayerPlayViewListRow.getEntryID()) {
                    CDDAPlayerPlayViewList.this.setSelectedEntry(cDDAPlayerPlayViewListRow.getEntryID());
                    CDDAPlayerPlayViewList.this.cddaPlayer.playEntry(cDDAPlayerPlayViewListRow.getEntryID(), cDDAPlayerPlayViewListRow.getTitle());
                } else {
                    CDDAPlayerPlayViewList.this.getTerminal().getAudioManager().resumeAudio(true);
                    if (CDDAPlayerPlayViewList.this.isNPSAvailable()) {
                        CDDAPlayerPlayViewList.this.getPlayViewListModel().trigger(ModelTrigger.ACTIVATE_NOW_PLAYING);
                    }
                }
            }
        });
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public long getEntryID(int n) {
        CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)this.getPlayViewListModel().getRow(n);
        if (null == cDDAPlayerPlayViewListRow) {
            return -1L;
        }
        return cDDAPlayerPlayViewListRow.getEntryID();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append(LOGCLASS).append("@").append(this.hashCode());
        return buffer.toString();
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logger.log(1000000, "[%1.keyTyped]", (Object)LOGCLASS);
        IEvoTransferController iEvoTransferController = MediaEvoUtils.getEvoTransferController(this.getTerminal().getServiceManager());
        if (null == iEvoTransferController) {
            this.logger.log(100000, "[%1.keyTyped] No EvoTransferController", (Object)LOGCLASS);
            return;
        }
        switch (n) {
            case 200461: {
                this.logger.log(1000000, "[%1.keyTyped] Start transfer folder.", (Object)LOGCLASS);
                iEvoTransferController.startTransfer(true, 2, IEvoTransferController.NO_TRANSFER_FOLDER, -1L, -1);
                this.getModel(n).fireEvent(n3);
                break;
            }
            case 200449: {
                this.logger.log(1000000, "[%1.keyTyped] Start transfer file.", (Object)LOGCLASS);
                CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)this.getCurrentFocusedRow();
                if (null == cDDAPlayerPlayViewListRow) {
                    this.logger.log(1000000, "[%1.keyTyped] No focused row. Use selected row.", (Object)LOGCLASS);
                    cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)this.getCurrentSelectedRow();
                    if (null == cDDAPlayerPlayViewListRow) {
                        this.logger.log(1000000, "[%1.keyTyped] No selected row.", (Object)LOGCLASS);
                        return;
                    }
                }
                iEvoTransferController.startTransfer(true, 3, IEvoTransferController.NO_TRANSFER_FOLDER, cDDAPlayerPlayViewListRow.getEntryID(), -1);
                this.getModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.logger.log(100000, "[%1.keyTyped] Wrong model '%2' typed.", (Object)LOGCLASS, (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }
}

