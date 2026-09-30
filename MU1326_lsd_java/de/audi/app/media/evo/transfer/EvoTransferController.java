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
    private static final String LOGCLASS = "EvoTransferController";
    private static final int CLIENT_ID = 1;
    private static final int RIPPING_ENCODING_QUALITY_LOSSLESS = 0;
    private static final int RIPPING_ENCODING_QUALITY_GOOD = 1;
    private static final int IMPORT_OK = 0;
    private static final int IMPORT_NOK = 1;
    private static final int IMPORT_ABORTED = 2;
    private static final int JUKEBOX_FULL = 3;
    private static final int DELETE_OK = 4;
    private static final int DELETE_ABORTED = 5;
    private static final int IMPORT_RECOPY = 6;
    private static final int ABORTED_NO_SUMMARY_POPUP = 7;
    private static final int TRANSFER_UNDEFINED = 0;
    private static final int TRANSFER_NOT_RUNNING = 1;
    private static final int TRANSFER_RUNNING = 2;
    private static final int JUKEBOX_CAPACITY_NOT_REACHED = 0;
    private static final int JUKEBOX_CAPACITY_REACHED = 1;
    public static final int TRANSFER_MODE_IMPORT = 0;
    public static final int TRANSFER_MODE_DELETE = 1;
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
        this.jukeboxSizeGroup.add(this.getLabelModel(200333));
        this.jukeboxSizeGroup.add(this.getLabelModel(201045));
        this.jukeboxSizeGroup.add(this.getLabelModel(200334));
        this.jukeboxSizeGroup.add(this.getLabelModel(200338));
        this.jukeboxSizeGroup.add(this.getLabelModel(201044));
        this.jukeboxSizeGroup.add(this.getLabelModel(200339));
        this.jukeboxSizeGroup.add(this.getRangeModel(200456));
        this.jukeboxSizeGroup.add(this.getRangeModel(200467));
        this.showPendingPopup = false;
        this.transferState = new EvoTransferState();
        this.nullTransferJob = new NullTransferJob(this.logger, this.getTransferController(), this, this.transferState);
    }

    public void init() {
        super.init();
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.getChoiceModel(200452).setValue(0);
        this.setTransferMode(0);
        this.getTerminal().getMediaPersistence().registerIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY", 0, 1, 0);
    }

    public void transferControllerAvailable() {
        this.logger.log(1000000, "[%1.serviceAdded]", (Object)LOGCLASS);
        this.transferQueue.reset();
        this.transferQueue.enqueue(new TransferJobResume(this.logger, this.getTransferController(), this, this.transferState));
        this.getRangeModel(201047).setLimits(0, 100, 1);
        this.getRangeModel(200322).setLimits(0, 100, 1);
        this.getRangeModel(200456).setLimits(0, 100, 1);
        this.getRangeModel(200467).setLimits(0, 100, 1);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setLimits(0, 100, 1);
        int n = this.getTerminal().getMediaPersistence().getGlobalIntProperty("GLOBAL_KEY_RIPPING_ENCODING_QUALITY");
        this.getChoiceModel(200314).setValue(n == 1 ? 1 : 0);
        this.getChoiceModel(200315).setValue(n == 0 ? 1 : 0);
        this.getChoiceModel(200313).setValue(n);
        this.getTransferController().setTransferListener(this);
        this.getTerminal().addActionProxyListener(new int[]{1001, 1002, 33}, (IActionProxyListener)this);
        this.getButtonModel(200704).setButtonListener(this);
        this.getButtonModel(200831).setButtonListener(this);
        this.getButtonModel(201023).setButtonListener(this);
        this.getButtonModel(201017).setButtonListener(this);
        this.getOptionModel(200785).setListener(this, 200640);
        this.getOptionModel(200783).setListener(this, 200640);
        this.getOptionModel(200784).setListener(this, 200640);
        this.getOptionModel(201022).setListener(this, 200640);
        this.getOptionModel(201020).setListener(this, 200640);
        this.getOptionModel(201021).setListener(this, 200640);
        this.serviceRegistration = this.getTerminal().getServiceManager().registerService(class$de$audi$app$media$evo$transfer$IEvoTransferController == null ? (class$de$audi$app$media$evo$transfer$IEvoTransferController = EvoTransferController.class$("de.audi.app.media.evo.transfer.IEvoTransferController")) : class$de$audi$app$media$evo$transfer$IEvoTransferController, this, new Hashtable());
    }

    public void transferControllerUnavailable() {
        this.logger.log(1000000, "[%1.serviceRemoved]", (Object)LOGCLASS);
        this.getTerminal().getServiceManager().unregisterService(this.serviceRegistration);
        this.getTransferController().setTransferListener(new NullTransferListener(this.logger));
        this.getTerminal().removeActionProxyListener(this);
        this.optionModelRemoveDataPlayerListener(200785);
        this.optionModelRemoveDataPlayerListener(200783);
        this.optionModelRemoveDataPlayerListener(200784);
        this.optionModelRemoveDataPlayerListener(201022);
        this.optionModelRemoveDataPlayerListener(201020);
        this.optionModelRemoveDataPlayerListener(201021);
        this.buttonModelSetButtonNullListener(200704);
        this.buttonModelSetButtonNullListener(200831);
        this.buttonModelSetButtonNullListener(201023);
        this.buttonModelSetButtonNullListener(201017);
        RangeModelApp rangeModelApp = this.getTerminal().getFramework().getHMIService().getRangeModel(143);
        if (null != rangeModelApp) {
            rangeModelApp.setValue(0);
        } else {
            this.logger.log(1000000, "[%1.transferControllerUnavailable] getRangeModel(IEvoSystemModelBank.MEDIA_IMPORT_PROGRESS_RANGE) == NULL", (Object)LOGCLASS);
        }
    }

    public void startTransfer(boolean bl, int n, MediaListEntry[] mediaListEntryArray, long l, int n2) {
        this.logger.log(1000000, "[%1.startTransfer] cdda='%2' type='%3'", (Object)LOGCLASS, (Object)Boolean.toString(bl), (long)n);
        ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
        if (!this.isTransferSource(iSourceSlot.getSource())) {
            this.logger.log(1000000, "[%1.startTransfer] source is not a transfer source", (Object)LOGCLASS);
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
        this.logger.log(1000000, "[%1.startTransfer]", (Object)LOGCLASS);
        this.transferQueue.enqueue(new TransferJobSourceActivationWithBrowser(this.logger, this.getTransferController(), this, iTransferItem, this.transferState));
        this.transferQueue.enqueue(new TransferJobRunning(this.logger, iTransferItem, this.getTransferController(), this, this.transferState));
    }

    private ITransferItem createTransferItem(boolean bl, int n, MediaListEntry[] mediaListEntryArray, long l, int n2, ISourceSlot iSourceSlot) {
        if (bl) {
            if (EvoTransferController.isFolder(n)) {
                this.logger.log(1000000, "[%1.createTransferItem] Return CDDA folder.", (Object)LOGCLASS);
                return new TransferItemCDDAFolder(iSourceSlot);
            }
            this.logger.log(1000000, "[%1.createTransferItem] Return CDDA file.", (Object)LOGCLASS);
            return new TransferItemCDDAFile(l, iSourceSlot);
        }
        if (EvoTransferController.isFolder(n)) {
            this.logger.log(1000000, "[%1.createTransferItem] Return DATA folder.", (Object)LOGCLASS);
            return new TransferItemFolder(mediaListEntryArray, (2 & n) == 2, iSourceSlot);
        }
        this.logger.log(1000000, "[%1.createTransferItem] Return DATA file.", (Object)LOGCLASS);
        return new TransferItemFile(mediaListEntryArray, (2 & n) == 2, l, n2 == 6 ? 5 : n2, iSourceSlot);
    }

    private static boolean isFolder(int n) {
        return !EvoTransferController.isFile(n);
    }

    private static boolean isFile(int n) {
        return (1 & n) == 1;
    }

    private boolean isTransferSource(ISource iSource) {
        this.logger.log(1000000, "[%1.isTransferSource]", (Object)LOGCLASS);
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
        this.logger.log(1000000, "[%1.setTransferMode] %2", (Object)LOGCLASS, (long)n);
        this.getChoiceModel(200778).setValue(n);
    }

    public void readyForTransfer() {
        this.logger.log(1000000, "[%1.readyForTransfer]", (Object)LOGCLASS);
        this.getRunningJob().readyForTransfer();
    }

    public void importAborted(long l, long l2, long l3, boolean bl) {
        this.logger.log(1000000, "[%1.importAborted]", (Object)LOGCLASS);
        this.getRunningJob().importAborted(l, l2, l3, bl);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue(0);
    }

    public void importFinished(long l, long l2, long l3, boolean bl) {
        this.logger.log(1000000, "[%1.importFinished]", (Object)LOGCLASS);
        this.getRunningJob().importFinished(l, l2, l3, bl);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue(0);
    }

    public void importWillBeResumed() {
        this.logger.log(1000000, "[%1.importWillBeResumed]", (Object)LOGCLASS);
        this.getRunningJob().importWillBeResumed();
    }

    public void importIsSuspended() {
        this.logger.log(1000000, "[%1.importIsSuspended]", (Object)LOGCLASS);
        this.getRunningJob().importIsSuspended();
    }

    public void activationSuccessful(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1000000, "[%1.activationSuccessful]", (Object)LOGCLASS);
        this.browserListContext = iBrowseListContext;
        this.browserListContext.addBrowseListListener(this, false);
        this.isContentTypeCDDA = iSourceSlot.getContentType() == 0;
        this.getRunningJob().activationSuccessful(iSourceSlot, iBrowseListContext);
    }

    public void deletionFinished() {
        this.logger.log(1000000, "[%1.deletionFinished]", (Object)LOGCLASS);
        this.getRunningJob().deletionFinished();
    }

    public void deletionAborted() {
        this.logger.log(1000000, "[%1.deletionAborted]", (Object)LOGCLASS);
        this.getRunningJob().deletionAborted();
    }

    public void deletionProgressChanged(long l) {
        this.logger.log(1000000, "[%1.deletionProgressChanged] progress %2 %", (Object)LOGCLASS, l);
        this.getRangeModel(200322).setValue((int)l);
        this.getTerminal().getFramework().getHmiServiceApp().getLabelModel(3862).setText(new StringBuffer().append(Long.toString(l)).append("%").toString());
    }

    public void importProgressChanged(long l, ListEntry listEntry) {
        this.logger.log(1000000, "[%1.importProgressChanged] %2 %", (Object)LOGCLASS, l);
        this.updateImportProgressModels((int)l);
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue((int)l);
        String string = "-";
        if (this.isContentTypeCDDA) {
            if (listEntry != null && listEntry.getTitle() != null && !"".equals(listEntry.getTitle())) {
                string = listEntry.getTitle();
                I18NString i18NString = new I18NString(string, true);
                this.getChoiceModel(200352).setValue(0);
                if (i18NString.isInternationalized()) {
                    this.getLabelModel(200349).setStatus(i18NString.getI18NKey());
                    this.getLabelModel(200349).setText(i18NString.getI18NString());
                    this.getChoiceModel(200353).setValue(i18NString.getI18NKey());
                } else {
                    this.getLabelModel(200349).setStatus(0);
                    this.getLabelModel(200349).setText(string);
                    this.getChoiceModel(200353).setValue(0);
                }
            }
        } else if (listEntry != null && listEntry.getFilename() != null && !"".equals(listEntry.getFilename())) {
            string = listEntry.getFilename();
            I18NString i18NString = new I18NString(string, true);
            this.getChoiceModel(200352).setValue(1);
            if (i18NString.isInternationalized()) {
                this.getLabelModel(200349).setText(i18NString.getI18NString());
                this.getLabelModel(200349).setStatus(i18NString.getI18NKey());
                this.getChoiceModel(200353).setValue(i18NString.getI18NKey());
            } else {
                this.getLabelModel(200349).setText(string);
                this.getLabelModel(200349).setStatus(1);
                this.getChoiceModel(200353).setValue(0);
            }
        }
    }

    protected void updateImportProgressModels(int n) {
        this.getRangeModel(201047).setValue(n);
        this.getLabelModel(200351).setText(new StringBuffer().append(Integer.toString(n)).append("%").toString());
    }

    public void encodingQualityChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.encodingQualityChanged]", (Object)LOGCLASS);
        this.getRunningJob().encodingQualityChanged(bl, n);
    }

    public void activationFailed(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.activationFailed]", (Object)LOGCLASS);
        this.getRunningJob().activationFailed(iSourceSlot);
    }

    public void startFailed() {
        this.logger.log(1000000, "[%1.startFailed]", (Object)LOGCLASS);
        this.getRunningJob().startFailed();
    }

    public void sourceRemoved(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.sourceRemoved]", (Object)LOGCLASS);
        if (0 != this.getRunningJob().getType()) {
            this.abortImport();
        }
    }

    public void unreadyToTransfer() {
        this.logger.log(1000000, "[%1.unreadyToTransfer]", (Object)LOGCLASS);
        this.getChoiceModel(200452).setValue(0);
        this.transferQueue.reset();
        this.transferQueue.enqueue(new TransferJobResume(this.logger, this.getTransferController(), this, this.transferState));
        this.getTerminal().getFramework().getHMIService().getRangeModel(143).setValue(0);
    }

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
            this.logger.log(1000000, "[%1.jukeboxSpaceChanged] %2", (Object)LOGCLASS, (Object)buffer.toString());
        }
        double d2 = (float)l / 1048576.0f;
        double d3 = (float)l2 / 1048576.0f;
        this.getLabelModel(200333).setText(Long.toString(l5));
        this.getLabelModel(200334).setText(Long.toString(l6));
        this.getLabelModel(201045).setText(Long.toString(l4));
        this.getLabelModel(200338).setText(Float.toString((float)Math.round(d3 * 10.0) / 10.0f));
        this.getLabelModel(201044).setText(Float.toString((float)Math.round(d2 * 10.0) / 10.0f));
        this.getLabelModel(200339).setText(Long.toString(l3));
        this.getRangeModel(200456).setValue(100 - (int)l3);
        this.getRangeModel(200467).setValue(100 - (int)l6);
        this.getChoiceModel(200830).setValue(3072L > l2 || 0L == l5 ? 1 : 0);
        this.jukeboxSizeGroup.flush();
    }

    public void browseModeChanged(boolean bl, int n) {
        this.logger.log(1000000, "[%1.browseModeChanged] browseMode='%2'", (Object)LOGCLASS, (long)n);
        this.getRunningJob().browseModeChanged(bl, n);
    }

    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logger.log(1000000, "[%1.addSelectionResult] result='%2'", (Object)LOGCLASS, (Object)(n == 0 ? "OK" : "NOK"));
        this.getRunningJob().addSelectionResult(bl, n, n2, bl2, l, l2, l3, l4 + l5);
    }

    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.browseFolderChanged]", (Object)LOGCLASS);
        this.getRunningJob().browseFolderChanged(bl, mediaListEntryArray, n);
    }

    public int getClientId() {
        return 1;
    }

    protected void disableTransfer() {
        this.logger.log(1000000, "[%1.disableTransfer]", (Object)LOGCLASS);
        this.getChoiceModel(200452).setValue(2);
    }

    protected void enableTransfer() {
        this.logger.log(1000000, "[%1.enableTransfer]", (Object)LOGCLASS);
        this.getChoiceModel(200452).setValue(1);
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
        this.logger.log(1000000, "[%1.showTransferPopup]", (Object)LOGCLASS);
        if (this.getTerminal().isVisible()) {
            if (bl) {
                this.getTerminal().getFramework().getHmiServiceApp().showPartialPopup(this.getTerminal().getTerminalID(), 200204);
            } else {
                this.getTerminal().getFramework().getHmiServiceApp().showPopup(n);
            }
            this.getTerminal().getFramework().getHmiServiceApp().removePartialPopup(this.getTerminal().getTerminalID(), 200133);
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
                this.logger.log(1000000, "[%1.updateModelsAndShowTransferPopup]", (Object)LOGCLASS);
                this.updateSummaryModels();
                this.showTransferPopup(false, n);
                break;
            }
            case 0: {
                this.logger.log(1000000, "[%1.updateModelsAndShowTransferPopup]", (Object)LOGCLASS);
                this.updateSummaryModels();
                this.showTransferPopup(true, n);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.updateSummaryModels no update neccessary importState= '%2']", (Object)LOGCLASS, (Object)Util.createInteger(n2));
                return;
            }
        }
    }

    private void updateSummaryModels() {
        this.logger.log(1000000, "[%1.updateSummaryModels]", (Object)LOGCLASS);
        this.getLabelModel(201037).setText(Long.toString(this.transferState.getNumberOfImportedFiles()));
        this.getLabelModel(200360).setText(Long.toString(this.transferState.getNumberOfErroneousFiles()));
        this.getLabelModel(200361).setText(Long.toString(this.transferState.getNumberOfFilesTotalToImport()));
        this.getChoiceModel(200451).setValue(this.getImportStatus());
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
        this.logger.log(1000000, "[%1.resetTransferProgressModels]", (Object)LOGCLASS);
        this.getRangeModel(201047).setValue(0);
        this.getLabelModel(200351).setText("0%");
        this.getChoiceModel(200352).setValue(0);
        this.getLabelModel(200349).setStatus(0);
        this.getLabelModel(200349).setText("");
        this.getChoiceModel(200353).setValue(0);
        this.getRangeModel(200322).setValue(0);
        this.getTerminal().getFramework().getHmiServiceApp().getLabelModel(3862).setText("0%");
    }

    public void actionProxyCallPerformed(int n, Map map) {
        switch (n) {
            case 1001: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] 'HMI_ACTIVATED' called.", (Object)LOGCLASS);
                if (!this.showPendingPopup) break;
                this.showPendingPopup = false;
                this.showTransferPopup(this.pendingImportOK, this.pendingPopupId);
                break;
            }
            case 1002: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] 'HMI_DEACTIVATED' called.", (Object)LOGCLASS);
                if (null != this.encodingQuality) {
                    return;
                }
                if (!this.getRunningJob().isWaiting()) break;
                this.abortImport();
                break;
            }
            case 33: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] 'AP_METHOD_TOGGLE_SOURCE_ENTERED' called.", (Object)LOGCLASS);
                if (null != this.encodingQuality) {
                    return;
                }
                if (!this.getRunningJob().isWaiting()) break;
                this.abortImport();
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.actionProxyCallPerformed] 'ActionProxy not supported", (Object)LOGCLASS);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 200704: {
                this.logger.log(1000000, "[%1.keyTyped] Abort running import", (Object)LOGCLASS, (long)n);
                this.abortImport();
                this.getButtonModel(200704).fireEvent(n3);
                break;
            }
            case 200831: 
            case 201023: {
                this.logger.log(1000000, "[%1.keyTyped] Import/Delete video from fullscreen", (Object)LOGCLASS);
                long l = this.getTiledListModel(200640).getSelected().getUniqueID();
                DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getTiledListModel(200640).getRowByUniqueID(l);
                ISourceSlot iSourceSlot = this.getTerminal().getSourceController().getSelectedSlot();
                TransferItemFile transferItemFile = new TransferItemFile(null, 2 == iSourceSlot.getSource().getType(), dataPlayerPlayViewListRow.getEntry().getTitleId(), dataPlayerPlayViewListRow.getEntry().getContentType(), iSourceSlot);
                this.startTransfer(transferItemFile);
                this.getModel(n).fireEvent(n3);
                break;
            }
            case 201017: {
                this.logger.log(1000000, "[%1.keyTyped] Show copy process in background popup", (Object)LOGCLASS);
                this.getTerminal().getFramework().getHmiServiceApp().showPartialPopup(n3, 200133);
                this.getModel(n).fireEvent(n3);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.keyTyped] buttton model %2 unknown", (Object)LOGCLASS, (long)n);
            }
        }
    }

    protected void abortImport() {
        if (this.getChoiceModel(200452).getValue() == 2) {
            this.logger.log(1000000, "[%1.abortRunningImport]", (Object)LOGCLASS);
            this.transferState.setAbortedByUser(true);
            this.transferQueue.abort();
            this.transferQueue.enqueue(new TransferJobAbort(this.logger, this.getTransferController(), this, this.transferState));
        } else {
            this.logger.log(1000000, "[%1.abortRunningImport] Nothing to abort!", (Object)LOGCLASS);
        }
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(1000000, "[%1.keyTyped]", (Object)LOGCLASS);
        if (200640 != n2) {
            return;
        }
        DataPlayerPlayViewListRow dataPlayerPlayViewListRow = (DataPlayerPlayViewListRow)this.getTiledListModel(200640).getRow(n3);
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
                this.logger.log(1000000, "[%1.keyTyped] Unknown model %1", (Object)LOGCLASS, (long)n);
                return;
            }
        }
        this.startTransfer(transferItemFile);
        this.getModel(n).fireEvent(n5);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void importStarted() {
        this.logger.log(1000000, "[%1.importStarted]", (Object)LOGCLASS);
        this.setTransferMode(0);
    }

    public void deletionPostprocessing() {
        this.logger.log(1000000, "[%1.deletionPostprocessingStarted]", (Object)LOGCLASS);
    }

    public void deletionStarted() {
        this.logger.log(1000000, "[%1.deletionStarted]", (Object)LOGCLASS);
        this.setTransferMode(1);
    }

    public void listUpdated(int n) {
        this.logger.log(1000000, "[%1.listUpdated] listSize='%2'", (Object)LOGCLASS, (long)n);
    }

    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.responseList]", (Object)LOGCLASS);
        this.getRunningJob().responseList(bl, mediaListEntryArray, n);
    }

    public void responsePickList(boolean bl, MediaListEntry[] mediaListEntryArray) {
    }

    public void resetSelectionResult(boolean bl, int n) {
        this.logger.log(1000000, "[%1.resetSelectionResult]", (Object)LOGCLASS);
    }

    public void notifyMetadataEntryAvailable(boolean bl) {
    }

    public void notifyFilesystemEntryAvailable(boolean bl) {
    }

    public void notifyCoverartsAvailable(boolean bl) {
    }

    public void notifyUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray) {
    }

    public void setBrowserEntries(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1000000, "[%1.setBrowserEntries]", (Object)LOGCLASS);
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
        this.logger.log(1000000, "[%1.setRootFolder]", (Object)LOGCLASS);
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

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private void optionModelRemoveDataPlayerListener(int n) {
        OptionModelApp optionModelApp = this.getOptionModel(n);
        if (null != optionModelApp) {
            optionModelApp.removeListener(200640);
        } else {
            this.logger.log(1000000, "[%1.optionModelRemoveDataPlayerListener] optionModelApp == NULL id=%2", (Object)LOGCLASS, (long)n);
        }
    }

    private void buttonModelSetButtonNullListener(int n) {
        ButtonModelApp buttonModelApp = this.getButtonModel(n);
        if (null != buttonModelApp) {
            buttonModelApp.setButtonListener(null);
        } else {
            this.logger.log(1000000, "[%1.buttonModelSetButtonNullListener] buttonModelApp == NULL id=%2", (Object)LOGCLASS, (long)n);
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

