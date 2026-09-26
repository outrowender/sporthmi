/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.actionproxy.IActionProxyListener;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.browser.NullBrowseListContextImpl;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.evo.content.data.DataPlayerPlayViewListRow;
import de.audi.app.media.evo.transfer.AbstractTransferJobEvo;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.evo.transfer.IEvoTransferController;
import de.audi.app.media.evo.transfer.ITransferItem;
import de.audi.app.media.evo.transfer.NullTransferJob;
import de.audi.app.media.evo.transfer.TransferItemCDDAFile;
import de.audi.app.media.evo.transfer.TransferItemCDDAFolder;
import de.audi.app.media.evo.transfer.TransferItemFile;
import de.audi.app.media.evo.transfer.TransferItemFolder;
import de.audi.app.media.evo.transfer.TransferJobAbort;
import de.audi.app.media.evo.transfer.TransferJobChangeEncodingQuality;
import de.audi.app.media.evo.transfer.TransferJobResume;
import de.audi.app.media.evo.transfer.TransferJobRunning;
import de.audi.app.media.evo.transfer.TransferJobSourceActivation;
import de.audi.app.media.evo.transfer.TransferJobSourceActivationWithBrowser;
import de.audi.app.media.i18n.I18NString;
import de.audi.app.media.queue.IQueueJob;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.AbstractTransferHMIHandler;
import de.audi.app.media.transfer.ITransferListener;
import de.audi.app.media.transfer.NullTransferListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import java.util.Map;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;
import org.osgi.framework.ServiceRegistration;

public class EvoTransferController
extends AbstractTransferHMIHandler
implements ITransferListener,
IBrowseListListener,
IActionProxyListener,
ButtonListener,
IEvoTransferController,
OptionModelListener {
    private static final String LOGCLASS;
    private static final int CLIENT_ID;
    private static final int RIPPING_ENCODING_QUALITY_LOSSLESS;
    private static final int RIPPING_ENCODING_QUALITY_GOOD;
    private static final int IMPORT_OK;
    private static final int IMPORT_NOK;
    private static final int IMPORT_ABORTED;
    private static final int JUKEBOX_FULL;
    private static final int DELETE_OK;
    private static final int DELETE_ABORTED;
    private static final int IMPORT_RECOPY;
    private static final int ABORTED_NO_SUMMARY_POPUP;
    private static final int TRANSFER_UNDEFINED;
    private static final int TRANSFER_NOT_RUNNING;
    private static final int TRANSFER_RUNNING;
    private static final int JUKEBOX_CAPACITY_NOT_REACHED;
    private static final int JUKEBOX_CAPACITY_REACHED;
    public static final int TRANSFER_MODE_IMPORT;
    public static final int TRANSFER_MODE_DELETE;
    private final AbstractTransferJobEvo nullTransferJob;
    private final ModelGroup jukeboxSizeGroup;
    private final Queue transferQueue;
    private volatile IBrowseListContext browserListContext = new NullBrowseListContextImpl();
    private volatile Integer encodingQuality = null;
    private volatile boolean isContentTypeCDDA;
    private volatile boolean showPendingPopup;
    private volatile int pendingPopupId;
    private volatile boolean pendingImportOK;
    private ServiceRegistration serviceRegistration;
    private final EvoTransferState transferState;
    private volatile MediaListEntry startupEntryTitle;
    private volatile MediaListEntry startupEntryAlbum;
    private volatile MediaListEntry startupEntryArtist;
    private volatile MediaListEntry startupEntryVideo;
    private volatile MediaListEntry rootFolder;
    static /* synthetic */ Class class$de$audi$app$media$evo$transfer$IEvoTransferController;

    public EvoTransferController(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
        this.transferQueue = new Queue(this.logger, "EvoTransferQueue");
        iMediaTerminal.getDiagnosisManager().addDataProvider(iMediaTerminal.getTerminalID(), this.transferQueue);
        this.jukeboxSizeGroup = new ModelGroup();
        this.jukeboxSizeGroup.add(this.getLabelModel(-1928461568));
        this.jukeboxSizeGroup.add(this.getLabelModel(1427178240));
        this.jukeboxSizeGroup.add(this.getLabelModel(-1911684352));
        this.jukeboxSizeGroup.add(this.getLabelModel(-1844575488));
        this.jukeboxSizeGroup.add(this.getLabelModel(1410401024));
        this.jukeboxSizeGroup.add(this.getLabelModel(-1827798272));
        this.jukeboxSizeGroup.add(this.getRangeModel(135201536));
        this.jukeboxSizeGroup.add(this.getRangeModel(319750912));
        this.showPendingPopup = false;
        this.transferState = new EvoTransferState();
        this.nullTransferJob = new NullTransferJob(this.logger, this.getTransferController(), this, this.transferState);
    }

    @Override
    public void init() {
        super.init();
        this.logger.log(1078071040, "[%1.init]", (Object)"EvoTransferController");
        this.getChoiceModel(68092672).setValue(0);
        this.setTransferMode(0);
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY", 0, 1, 0);
    }

    @Override
    public void transferControllerAvailable() {
        this.logger.log(1078071040, "[%1.serviceAdded]", (Object)"EvoTransferController");
        this.transferQueue.reset();
        this.transferQueue.enqueue(new TransferJobResume(this.logger, this.getTransferController(), this, this.transferState));
        this.getRangeModel(1460732672).setLimits(0, 100, 1);
        this.getRangeModel(-2113010944).setLimits(0, 100, 1);
        this.getRangeModel(135201536).setLimits(0, 100, 1);
        this.getRangeModel(319750912).setLimits(0, 100, 1);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setLimits(0, 100, 1);
        int n = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY");
        this.getChoiceModel(2047738624).setValue(n == 1 ? 1 : 0);
        this.getChoiceModel(2064515840).setValue(n == 0 ? 1 : 0);
        this.getChoiceModel(2030961408).setValue(n);
        this.getTransferController().setTransferListener(this);
        this.getTerminal().addActionProxyListener(new int[]{1001, 1002, 33}, (IActionProxyListener)this);
        this.getButtonModel(0x100300).setButtonListener(this);
        this.getButtonModel(2131755776).setButtonListener(this);
        this.getButtonModel(1058079488).setButtonListener(this);
        this.getButtonModel(957416192).setButtonListener(this);
        this.getOptionModel(1360003840).setListener(this, -1072758016);
        this.getOptionModel(1326449408).setListener(this, -1072758016);
        this.getOptionModel(1343226624).setListener(this, -1072758016);
        this.getOptionModel(1041302272).setListener(this, -1072758016);
        this.getOptionModel(1007747840).setListener(this, -1072758016);
        this.getOptionModel(1024525056).setListener(this, -1072758016);
        this.serviceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$app$media$evo$transfer$IEvoTransferController == null ? (class$de$audi$app$media$evo$transfer$IEvoTransferController = EvoTransferController.class$("de.audi.app.media.evo.transfer.IEvoTransferController")) : class$de$audi$app$media$evo$transfer$IEvoTransferController, this, new Hashtable());
    }

    @Override
    public void transferControllerUnavailable() {
        this.logger.log(1078071040, "[%1.serviceRemoved]", (Object)"EvoTransferController");
        this.getTerminal().getServiceManager().unregisterService(this.serviceRegistration);
        this.getTransferController().setTransferListener(new NullTransferListener(this.logger));
        this.getTerminal().removeActionProxyListener(this);
        this.optionModelRemoveDataPlayerListener(1360003840);
        this.optionModelRemoveDataPlayerListener(1326449408);
        this.optionModelRemoveDataPlayerListener(1343226624);
        this.optionModelRemoveDataPlayerListener(1041302272);
        this.optionModelRemoveDataPlayerListener(1007747840);
        this.optionModelRemoveDataPlayerListener(1024525056);
        this.buttonModelSetButtonNullListener(0x100300);
        this.buttonModelSetButtonNullListener(2131755776);
        this.buttonModelSetButtonNullListener(1058079488);
        this.buttonModelSetButtonNullListener(957416192);
        RangeModelApp rangeModelApp = this.getTerminal().getFramework().getHMIService().getRangeModel(143);
        if (null != rangeModelApp) {
            rangeModelApp.setValue(0);
        } else {
            this.logger.log(1078071040, "[%1.transferControllerUnavailable] getRangeModel(IEvoSystemModelBank.MEDIA_IMPORT_PROGRESS_RANGE) == NULL", (Object)"EvoTransferController");
        }
    }

    @Override
    public void startTransfer(boolean bl, int n, MediaListEntry[] mediaListEntryArray, long l, int n2) {
        this.logger.log(1078071040, "[%1.startTransfer] cdda='%2' type='%3'", (Object)"EvoTransferController", (Object)Boolean.toString(bl), (long)n);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (!this.isTransferSource(iSourceSlot.getSource())) {
            this.logger.log(1078071040, "[%1.startTransfer] source is not a transfer source", (Object)"EvoTransferController");
            return;
        }
        ITransferItem iTransferItem = this.createTransferItem(bl, n, mediaListEntryArray, l, n2, iSourceSlot);
        this.transferQueue.enqueue(new TransferJobSourceActivation(this.logger, this.getTransferController(), this, iTransferItem, this.transferState));
        if (bl) {
            this.transferQueue.enqueue(new TransferJobChangeEncodingQuality(this.logger, this.getTransferController(), this, this.encodingQuality, this.getTerminal(), this.transferState));
        }
        this.transferQueue.enqueue(new TransferJobRunning(this.logger, iTransferItem, this.getTransferController(), this, this.transferState));
    }

    private void startTransfer(ITransferItem iTransferItem) {
        this.logger.log(1078071040, "[%1.startTransfer]", (Object)"EvoTransferController");
        this.transferQueue.enqueue(new TransferJobSourceActivationWithBrowser(this.logger, this.getTransferController(), this, iTransferItem, this.transferState));
        this.transferQueue.enqueue(new TransferJobRunning(this.logger, iTransferItem, this.getTransferController(), this, this.transferState));
    }

    private ITransferItem createTransferItem(boolean bl, int n, MediaListEntry[] mediaListEntryArray, long l, int n2, ISourceSlot iSourceSlot) {
        if (bl) {
            if (EvoTransferController.isFolder(n)) {
                this.logger.log(1078071040, "[%1.createTransferItem] Return CDDA folder.", (Object)"EvoTransferController");
                return new TransferItemCDDAFolder(iSourceSlot);
            }
            this.logger.log(1078071040, "[%1.createTransferItem] Return CDDA file.", (Object)"EvoTransferController");
            return new TransferItemCDDAFile(l, iSourceSlot);
        }
        if (EvoTransferController.isFolder(n)) {
            this.logger.log(1078071040, "[%1.createTransferItem] Return DATA folder.", (Object)"EvoTransferController");
            return new TransferItemFolder(mediaListEntryArray, (2 & n) == 2, iSourceSlot);
        }
        this.logger.log(1078071040, "[%1.createTransferItem] Return DATA file.", (Object)"EvoTransferController");
        return new TransferItemFile(mediaListEntryArray, (2 & n) == 2, l, n2 == 6 ? 5 : n2, iSourceSlot);
    }

    private static boolean isFolder(int n) {
        return !EvoTransferController.isFile(n);
    }

    private static boolean isFile(int n) {
        return (1 & n) == 1;
    }

    private boolean isTransferSource(ISource iSource) {
        this.logger.log(1078071040, "[%1.isTransferSource]", (Object)"EvoTransferController");
        return EvoTransferController.isImportSource(iSource) || EvoTransferController.isDeletionSource(iSource);
    }

    private static boolean isImportSource(ISource iSource) {
        switch (iSource.getType()) {
            case 2: 
            case 3: 
            case 5: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    private static boolean isDeletionSource(ISource iSource) {
        return 6 == iSource.getType();
    }

    private void setTransferMode(int n) {
        this.logger.log(1078071040, "[%1.setTransferMode] %2", (Object)"EvoTransferController", (long)n);
        this.getChoiceModel(1242563328).setValue(n);
    }

    @Override
    public void readyForTransfer() {
        this.logger.log(1078071040, "[%1.readyForTransfer]", (Object)"EvoTransferController");
        this.getRunningJob().readyForTransfer();
    }

    @Override
    public void importAborted(long l, long l2, long l3, boolean bl) {
        this.logger.log(1078071040, "[%1.importAborted]", (Object)"EvoTransferController");
        this.getRunningJob().importAborted(l, l2, l3, bl);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue(0);
    }

    @Override
    public void importFinished(long l, long l2, long l3, boolean bl) {
        this.logger.log(1078071040, "[%1.importFinished]", (Object)"EvoTransferController");
        this.getRunningJob().importFinished(l, l2, l3, bl);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue(0);
    }

    @Override
    public void importWillBeResumed() {
        this.logger.log(1078071040, "[%1.importWillBeResumed]", (Object)"EvoTransferController");
        this.getRunningJob().importWillBeResumed();
    }

    @Override
    public void importIsSuspended() {
        this.logger.log(1078071040, "[%1.importIsSuspended]", (Object)"EvoTransferController");
        this.getRunningJob().importIsSuspended();
    }

    @Override
    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.activationSuccessful]", (Object)"EvoTransferController");
        this.browserListContext = iBrowseListContext;
        this.browserListContext.addBrowseListListener(this, false);
        this.isContentTypeCDDA = iSourceSlot.getContentType() == 0;
        this.getRunningJob().activationSuccessful(iSourceSlot, iBrowseListContext);
    }

    @Override
    public void deletionFinished() {
        this.logger.log(1078071040, "[%1.deletionFinished]", (Object)"EvoTransferController");
        this.getRunningJob().deletionFinished();
    }

    @Override
    public void deletionAborted() {
        this.logger.log(1078071040, "[%1.deletionAborted]", (Object)"EvoTransferController");
        this.getRunningJob().deletionAborted();
    }

    @Override
    public void deletionProgressChanged(long l) {
        this.logger.log(1078071040, "[%1.deletionProgressChanged] progress %2 %", (Object)"EvoTransferController", l);
        this.getRangeModel(-2113010944).setValue((int)l);
        this.getTerminal().getFramework().getHmiServiceApp().getLabelModel(3862).setText(new StringBuffer().append(Long.toString(l)).append("%").toString());
    }

    @Override
    public void importProgressChanged(long l, ListEntry listEntry) {
        this.logger.log(1078071040, "[%1.importProgressChanged] %2 %", (Object)"EvoTransferController", l);
        this.updateImportProgressModels((int)l);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue((int)l);
        String string = "-";
        if (this.isContentTypeCDDA) {
            if (listEntry != null && listEntry.getTitle() != null && !"".equals(listEntry.getTitle())) {
                string = listEntry.getTitle();
                I18NString i18NString = new I18NString(string, true);
                this.getChoiceModel(-1609694464).setValue(0);
                if (i18NString.isInternationalized()) {
                    this.getLabelModel(-1660026112).setStatus(i18NString.getI18NKey());
                    this.getLabelModel(-1660026112).setText(i18NString.getI18NString());
                    this.getChoiceModel(-1592917248).setValue(i18NString.getI18NKey());
                } else {
                    this.getLabelModel(-1660026112).setStatus(0);
                    this.getLabelModel(-1660026112).setText(string);
                    this.getChoiceModel(-1592917248).setValue(0);
                }
            }
        } else if (listEntry != null && listEntry.getFilename() != null && !"".equals(listEntry.getFilename())) {
            string = listEntry.getFilename();
            I18NString i18NString = new I18NString(string, true);
            this.getChoiceModel(-1609694464).setValue(1);
            if (i18NString.isInternationalized()) {
                this.getLabelModel(-1660026112).setText(i18NString.getI18NString());
                this.getLabelModel(-1660026112).setStatus(i18NString.getI18NKey());
                this.getChoiceModel(-1592917248).setValue(i18NString.getI18NKey());
            } else {
                this.getLabelModel(-1660026112).setText(string);
                this.getLabelModel(-1660026112).setStatus(1);
                this.getChoiceModel(-1592917248).setValue(0);
            }
        }
    }

    protected void updateImportProgressModels(int n) {
        this.getRangeModel(1460732672).setValue(n);
        this.getLabelModel(-1626471680).setText(new StringBuffer().append(Integer.toString(n)).append("%").toString());
    }

    @Override
    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.encodingQualityChanged]", (Object)"EvoTransferController");
        this.getRunningJob().encodingQualityChanged(bl, n);
    }

    @Override
    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.activationFailed]", (Object)"EvoTransferController");
        this.getRunningJob().activationFailed(iSourceSlot);
    }

    @Override
    public void startFailed() {
        this.logger.log(1078071040, "[%1.startFailed]", (Object)"EvoTransferController");
        this.getRunningJob().startFailed();
    }

    @Override
    public void sourceRemoved(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.sourceRemoved]", (Object)"EvoTransferController");
        if (0 != this.getRunningJob().getType()) {
            this.abortImport();
        }
    }

    @Override
    public void unreadyToTransfer() {
        this.logger.log(1078071040, "[%1.unreadyToTransfer]", (Object)"EvoTransferController");
        this.getChoiceModel(68092672).setValue(0);
        this.transferQueue.reset();
        this.transferQueue.enqueue(new TransferJobResume(this.logger, this.getTransferController(), this, this.transferState));
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue(0);
    }

    @Override
    public void jukeboxSpaceChanged(long l, long l2, long l3, long l4, long l5, long l6) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("jukeboxSize=");
            buffer.append(l);
            buffer.append(" jukeboxsizeAvailable=");
            buffer.append(l2);
            buffer.append(" sizeFreePercentage=");
            buffer.append(l3);
            buffer.append("% maxEntries=");
            buffer.append(l4);
            buffer.append(" numFreeEntries=");
            buffer.append(l5);
            buffer.append(" entriesFreePercentage=");
            buffer.append(l6);
            buffer.append("%");
            this.logger.log(1078071040, "[%1.jukeboxSpaceChanged] %2", (Object)"EvoTransferController", (Object)buffer.toString());
        }
        double d2 = (float)l / 32841;
        double d3 = (float)l2 / 32841;
        this.getLabelModel(-1928461568).setText(Long.toString(l5));
        this.getLabelModel(-1911684352).setText(Long.toString(l6));
        this.getLabelModel(1427178240).setText(Long.toString(l4));
        this.getLabelModel(-1844575488).setText(Float.toString((float)Math.round(d3 * 10.0) / 8257));
        this.getLabelModel(1410401024).setText(Float.toString((float)Math.round(d2 * 10.0) / 8257));
        this.getLabelModel(-1827798272).setText(Long.toString(l3));
        this.getRangeModel(135201536).setValue(100 - (int)l3);
        this.getRangeModel(319750912).setValue(100 - (int)l6);
        this.getChoiceModel(2114978560).setValue(0 > l2 || 0L == l5 ? 1 : 0);
        this.jukeboxSizeGroup.flush();
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.browseModeChanged] browseMode='%2'", (Object)"EvoTransferController", (long)n);
        this.getRunningJob().browseModeChanged(bl, n);
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1078071040, "[%1.addSelectionResult] result='%2'", (Object)"EvoTransferController", (Object)(n == 0 ? "OK" : "NOK"));
        this.getRunningJob().addSelectionResult(bl, n, n2, bl2, l, l2, l3, l4 + l5);
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.browseFolderChanged]", (Object)"EvoTransferController");
        this.getRunningJob().browseFolderChanged(bl, mediaListEntryArray, n);
    }

    @Override
    public int getClientId() {
        return 1;
    }

    protected void disableTransfer() {
        this.logger.log(1078071040, "[%1.disableTransfer]", (Object)"EvoTransferController");
        this.getChoiceModel(68092672).setValue(2);
    }

    protected void enableTransfer() {
        this.logger.log(1078071040, "[%1.enableTransfer]", (Object)"EvoTransferController");
        this.getChoiceModel(68092672).setValue(1);
        this.transferState.reset();
    }

    private AbstractTransferJobEvo getRunningJob() {
        IQueueJob iQueueJob = this.transferQueue.getRunningJob();
        return iQueueJob != null ? (AbstractTransferJobEvo)iQueueJob : this.nullTransferJob;
    }

    protected IBrowseListContext getBrowserListContext() {
        return this.browserListContext;
    }

    protected void setEncodingQuality(int n) {
        this.encodingQuality = new Integer(n);
    }

    protected void showTransferPopup(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.showTransferPopup]", (Object)"EvoTransferController");
        if (this.getTerminal().isVisible()) {
            if (bl) {
                this.getTerminal().getFramework().getHmiServiceApp().showPartialPopup(this.getTerminal().getTerminalID(), 202244864);
            } else {
                this.getTerminal().getFramework().getHmiServiceApp().showPopup(n);
            }
            this.getTerminal().getFramework().getHmiServiceApp().removePartialPopup(this.getTerminal().getTerminalID(), -989003008);
        } else {
            this.pendingImportOK = bl;
            this.pendingPopupId = n;
            this.showPendingPopup = true;
        }
    }

    protected void updateModelsAndShowTransferPopup(int n) {
        int n2 = this.getImportStatus();
        switch (n2) {
            case 1: 
            case 2: 
            case 3: 
            case 6: {
                this.logger.log(1078071040, "[%1.updateModelsAndShowTransferPopup]", (Object)"EvoTransferController");
                this.updateSummaryModels();
                this.showTransferPopup(false, n);
                break;
            }
            case 0: {
                this.logger.log(1078071040, "[%1.updateModelsAndShowTransferPopup]", (Object)"EvoTransferController");
                this.updateSummaryModels();
                this.showTransferPopup(true, n);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.updateSummaryModels no update neccessary importState= '%2']", (Object)"EvoTransferController", (Object)Util.createInteger(n2));
                return;
            }
        }
    }

    private void updateSummaryModels() {
        this.logger.log(1078071040, "[%1.updateSummaryModels]", (Object)"EvoTransferController");
        this.getLabelModel(1292960512).setText(Long.toString(this.transferState.getNumberOfImportedFiles()));
        this.getLabelModel(-1475476736).setText(Long.toString(this.transferState.getNumberOfErroneousFiles()));
        this.getLabelModel(-1458699520).setText(Long.toString(this.transferState.getNumberOfFilesTotalToImport()));
        this.getChoiceModel(0x30F0300).setValue(this.getImportStatus());
    }

    private int getImportStatus() {
        if (this.transferState.isWaitingForUserAction() && this.transferState.isAbortedByUser()) {
            return 7;
        }
        if (this.transferState.isAbortedByUser()) {
            return this.transferState.isDelete() ? 5 : 2;
        }
        if (this.transferState.isDelete()) {
            return 4;
        }
        if (this.transferState.isJukeboxFull()) {
            return 3;
        }
        if (this.transferState.isRecopy()) {
            return 6;
        }
        if (this.transferState.isAllItemsSuccessfullyImported()) {
            return 0;
        }
        return 1;
    }

    protected void resetTransferProgressModels() {
        this.logger.log(1078071040, "[%1.resetTransferProgressModels]", (Object)"EvoTransferController");
        this.getRangeModel(1460732672).setValue(0);
        this.getLabelModel(-1626471680).setText("0%");
        this.getChoiceModel(-1609694464).setValue(0);
        this.getLabelModel(-1660026112).setStatus(0);
        this.getLabelModel(-1660026112).setText("");
        this.getChoiceModel(-1592917248).setValue(0);
        this.getRangeModel(-2113010944).setValue(0);
        this.getTerminal().getFramework().getHmiServiceApp().getLabelModel(3862).setText("0%");
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1001: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] 'HMI_ACTIVATED' called.", (Object)"EvoTransferController");
                if (!this.showPendingPopup) break;
                this.showPendingPopup = false;
                this.showTransferPopup(this.pendingImportOK, this.pendingPopupId);
                break;
            }
            case 1002: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] 'HMI_DEACTIVATED' called.", (Object)"EvoTransferController");
                if (null != this.encodingQuality) {
                    return;
                }
                if (!this.getRunningJob().isWaiting()) break;
                this.abortImport();
                break;
            }
            case 33: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] 'AP_METHOD_TOGGLE_SOURCE_ENTERED' called.", (Object)"EvoTransferController");
                if (null != this.encodingQuality) {
                    return;
                }
                if (!this.getRunningJob().isWaiting()) break;
                this.abortImport();
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.actionProxyCallPerformed] 'ActionProxy not supported", (Object)"EvoTransferController");
            }
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200704: {
                this.logger.log(1078071040, "[%1.keyTyped] Abort running import", (Object)"EvoTransferController", (long)n);
                this.abortImport();
                this.getButtonModel(0x100300).fireEvent(n3);
                break;
            }
            case 200831: 
            case 201023: {
                this.logger.log(1078071040, "[%1.keyTyped] Import/Delete video from fullscreen", (Object)"EvoTransferController");
                long l = this.getTiledListModel(-1072758016).getSelected().getUniqueID();
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getTiledListModel(-1072758016).getRowByUniqueID(l);
                ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
                TransferItemFile transferItemFile = new TransferItemFile(null, 2 == iSourceSlot.getSource().getType(), dataPlayerPlayViewListRow.getEntry().getTitleId(), dataPlayerPlayViewListRow.getEntry().getContentType(), iSourceSlot);
                this.startTransfer(transferItemFile);
                this.getModel(n).fireEvent(n3);
                break;
            }
            case 201017: {
                this.logger.log(1078071040, "[%1.keyTyped] Show copy process in background popup", (Object)"EvoTransferController");
                this.getTerminal().getFramework().getHmiServiceApp().showPartialPopup(n3, -989003008);
                this.getModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.keyTyped] buttton model %2 unknown", (Object)"EvoTransferController", (long)n);
            }
        }
    }

    protected void abortImport() {
        if (this.getChoiceModel(68092672).getValue() == 2) {
            this.logger.log(1078071040, "[%1.abortRunningImport]", (Object)"EvoTransferController");
            this.transferState.setAbortedByUser(true);
            this.transferQueue.abort();
            this.transferQueue.enqueue(new TransferJobAbort(this.logger, this.getTransferController(), this, this.transferState));
        } else {
            this.logger.log(1078071040, "[%1.abortRunningImport] Nothing to abort!", (Object)"EvoTransferController");
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(1078071040, "[%1.keyTyped]", (Object)"EvoTransferController");
        if (-1072758016 != n2) {
            return;
        }
        DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getTiledListModel(-1072758016).getRow(n3);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        TransferItemFile transferItemFile = null;
        switch (n) {
            case 200785: 
            case 201022: {
                transferItemFile = new TransferItemFile(null, 2 == iSourceSlot.getSource().getType(), dataPlayerPlayViewListRow.getEntry().getTitleId(), dataPlayerPlayViewListRow.getEntry().getContentType(), iSourceSlot);
                break;
            }
            case 200783: 
            case 201020: {
                transferItemFile = new TransferItemFile(null, false, dataPlayerPlayViewListRow.getEntry().getAlbumID(), 14, iSourceSlot);
                break;
            }
            case 200784: 
            case 201021: {
                transferItemFile = new TransferItemFile(null, false, dataPlayerPlayViewListRow.getEntry().getArtistID(), 13, iSourceSlot);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.keyTyped] Unknown model %1", (Object)"EvoTransferController", (long)n);
                return;
            }
        }
        this.startTransfer(transferItemFile);
        this.getModel(n).fireEvent(n5);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void importStarted() {
        this.logger.log(1078071040, "[%1.importStarted]", (Object)"EvoTransferController");
        this.setTransferMode(0);
    }

    @Override
    public void deletionPostprocessing() {
        this.logger.log(1078071040, "[%1.deletionPostprocessingStarted]", (Object)"EvoTransferController");
    }

    @Override
    public void deletionStarted() {
        this.logger.log(1078071040, "[%1.deletionStarted]", (Object)"EvoTransferController");
        this.setTransferMode(1);
    }

    @Override
    public void listUpdated(int n) {
        this.logger.log(1078071040, "[%1.listUpdated] listSize='%2'", (Object)"EvoTransferController", (long)n);
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1078071040, "[%1.responseList]", (Object)"EvoTransferController");
        this.getRunningJob().responseList(bl, mediaListEntryArray, n);
    }

    @Override
    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void resetSelectionResult(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.resetSelectionResult]", (Object)"EvoTransferController");
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

    public void setBrowserEntries(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1078071040, "[%1.setBrowserEntries]", (Object)"EvoTransferController");
        block6: for (int i2 = 0; i2 < mediaListEntryArray.length; ++i2) {
            MediaListEntry mediaListEntry = mediaListEntryArray[i2];
            switch (mediaListEntry.getTitle().getI18NKey()) {
                case 2: {
                    this.startupEntryArtist = mediaListEntry;
                    continue block6;
                }
                case 5: {
                    this.startupEntryAlbum = mediaListEntry;
                    continue block6;
                }
                case 33: {
                    this.startupEntryTitle = mediaListEntry;
                    continue block6;
                }
                case 13: {
                    this.startupEntryVideo = mediaListEntry;
                    continue block6;
                }
            }
        }
    }

    public void setRootFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1078071040, "[%1.setRootFolder]", (Object)"EvoTransferController");
        this.rootFolder = mediaListEntryArray[0];
    }

    public MediaListEntry[] getFolderStack(int n) {
        switch (n) {
            case 1: {
                return new MediaListEntry[]{this.rootFolder, this.startupEntryTitle};
            }
            case 14: {
                return new MediaListEntry[]{this.rootFolder, this.startupEntryAlbum};
            }
            case 13: {
                return new MediaListEntry[]{this.rootFolder, this.startupEntryArtist};
            }
            case 2: {
                return new MediaListEntry[]{this.rootFolder, this.startupEntryVideo};
            }
        }
        return new MediaListEntry[]{this.rootFolder};
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private void optionModelRemoveDataPlayerListener(int n) {
        OptionModelApp optionModelApp = this.getOptionModel(n);
        if (null != optionModelApp) {
            optionModelApp.removeListener(-1072758016);
        } else {
            this.logger.log(1078071040, "[%1.optionModelRemoveDataPlayerListener] optionModelApp == NULL id=%2", (Object)"EvoTransferController", (long)n);
        }
    }

    private void buttonModelSetButtonNullListener(int n) {
        ButtonModelApp buttonModelApp = this.getButtonModel(n);
        if (null != buttonModelApp) {
            buttonModelApp.setButtonListener(null);
        } else {
            this.logger.log(1078071040, "[%1.buttonModelSetButtonNullListener] buttonModelApp == NULL id=%2", (Object)"EvoTransferController", (long)n);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

