/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.cdda;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.AbstractMediaPlayViewListRow;
import de.audi.app.media.content.media.IProgressIndication;
import de.audi.app.media.content.media.ProgressIndicationImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.cdda.CDDAPlayer;
import de.audi.app.media.evo.content.cdda.CDDAPlayerPlayViewList$1;
import de.audi.app.media.evo.content.cdda.CDDAPlayerPlayViewListRow;
import de.audi.app.media.evo.transfer.IEvoTransferController;
import de.audi.app.media.evo.utils.MediaEvoUtils;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;

public class CDDAPlayerPlayViewList
extends AbstractMediaPlayViewList
implements IActionProxyListener,
ButtonListener {
    private static final String LOGCLASS;
    private final CDDAPlayer cddaPlayer;
    private final TiledListModelApp trackList;
    private final ProgressIndicationImpl progressListIndicator;

    public CDDAPlayerPlayViewList(IMediaTerminal iMediaTerminal, CDDAPlayer cDDAPlayer) {
        super(iMediaTerminal, iMediaTerminal.getLogger().hmi(), cDDAPlayer, false);
        this.cddaPlayer = cDDAPlayer;
        this.trackList = this.getTiledListModel(-2012282112);
        this.progressListIndicator = new ProgressIndicationImpl(this.logger, this.getChoiceModel(-1827732736), 0);
    }

    @Override
    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"CDDAPlayerPlayViewList");
        super.init();
        this.trackList.setLength(0);
        this.trackList.setListener(this);
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"CDDAPlayerPlayViewList");
        super.deinit();
        this.trackList.setListener(null);
        this.trackList.clearAll();
    }

    @Override
    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"CDDAPlayerPlayViewList");
        super.activate();
        this.getTerminal().addActionProxyListener(28, (IActionProxyListener)this);
        this.getButtonModel(17761024).setButtonListener(this);
        this.getButtonModel(219087616).setButtonListener(this);
    }

    @Override
    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"CDDAPlayerPlayViewList");
        super.deactivate();
        this.getTerminal().removeActionProxyListener(this);
        this.getButtonModel(17761024).setButtonListener(null);
        this.getButtonModel(219087616).setButtonListener(null);
    }

    @Override
    protected void listStartupComplete() {
        this.logger.log(1078071040, "[%1.listStartupComplete]", (Object)"CDDAPlayerPlayViewList");
        this.cddaPlayer.getContent().notifyContentActivationFinished();
    }

    @Override
    protected AbstractMediaPlayViewListRow createRow(MediaListEntry mediaListEntry) {
        return new CDDAPlayerPlayViewListRow(mediaListEntry);
    }

    @Override
    protected TiledListModelApp getPlayViewListModel() {
        return this.trackList;
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
    protected boolean isRequestFullList() {
        return true;
    }

    @Override
    protected int getListRequestClientID() {
        return 1;
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 28: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] AP_MERGE_CURSORS", (Object)"CDDAPlayerPlayViewList");
                this.setAutomaticCursorMerge(true);
                break;
            }
        }
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logger.log(1078071040, "[%1.itemSelected] Row '%2' selected.", (Object)"CDDAPlayerPlayViewList", (Object)evoListRow);
        CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)evoListRow;
        if (!cDDAPlayerPlayViewListRow.isEnabled()) {
            this.logger.log(-2137614336, "[%1.itemSelected] Row is disabled. Ignore.", (Object)"CDDAPlayerPlayViewList");
            return;
        }
        this.getTerminal().getDispatcher().execute(new CDDAPlayerPlayViewList$1(this, "CDDAPlayerPlayViewList.selectEntry", cDDAPlayerPlayViewListRow));
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public long getEntryID(int n) {
        CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)this.getPlayViewListModel().getRow(n);
        if (null == cDDAPlayerPlayViewListRow) {
            return -1L;
        }
        return cDDAPlayerPlayViewListRow.getEntryID();
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("CDDAPlayerPlayViewList").append("@").append(this.hashCode());
        return buffer.toString();
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logger.log(1078071040, "[%1.keyTyped]", (Object)"CDDAPlayerPlayViewList");
        IEvoTransferController iEvoTransferController = MediaEvoUtils.getEvoTransferController(this.getTerminal().getServiceManager());
        if (null == iEvoTransferController) {
            this.logger.log(-1601830656, "[%1.keyTyped] No EvoTransferController", (Object)"CDDAPlayerPlayViewList");
            return;
        }
        switch (n) {
            case 200461: {
                this.logger.log(1078071040, "[%1.keyTyped] Start transfer folder.", (Object)"CDDAPlayerPlayViewList");
                iEvoTransferController.startTransfer(true, 2, IEvoTransferController.NO_TRANSFER_FOLDER, -1L, -1);
                this.getModel(n).fireEvent(n3);
                break;
            }
            case 200449: {
                this.logger.log(1078071040, "[%1.keyTyped] Start transfer file.", (Object)"CDDAPlayerPlayViewList");
                CDDAPlayerPlayViewListRow cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)this.getCurrentFocusedRow();
                if (null == cDDAPlayerPlayViewListRow) {
                    this.logger.log(1078071040, "[%1.keyTyped] No focused row. Use selected row.", (Object)"CDDAPlayerPlayViewList");
                    cDDAPlayerPlayViewListRow = (CDDAPlayerPlayViewListRow)this.getCurrentSelectedRow();
                    if (null == cDDAPlayerPlayViewListRow) {
                        this.logger.log(1078071040, "[%1.keyTyped] No selected row.", (Object)"CDDAPlayerPlayViewList");
                        return;
                    }
                }
                iEvoTransferController.startTransfer(true, 3, IEvoTransferController.NO_TRANSFER_FOLDER, cDDAPlayerPlayViewListRow.getEntryID(), -1);
                this.getModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1.keyTyped] Wrong model '%2' typed.", (Object)"CDDAPlayerPlayViewList", (long)n);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void playbackFolderChanged(MediaListEntry[] mediaListEntryArray) {
    }

    static /* synthetic */ CDDAPlayer access$000(CDDAPlayerPlayViewList cDDAPlayerPlayViewList) {
        return cDDAPlayerPlayViewList.cddaPlayer;
    }

    static /* synthetic */ void access$100(CDDAPlayerPlayViewList cDDAPlayerPlayViewList, long l) {
        cDDAPlayerPlayViewList.setSelectedEntry(l);
    }

    static /* synthetic */ boolean access$200(CDDAPlayerPlayViewList cDDAPlayerPlayViewList) {
        return cDDAPlayerPlayViewList.isNPSAvailable();
    }
}

