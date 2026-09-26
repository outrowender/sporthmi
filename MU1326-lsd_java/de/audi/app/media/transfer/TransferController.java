/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.configuration.IMediaConfiguration;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.ISourceSlotListener;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.ITransferController;
import de.audi.app.media.transfer.ITransferListener;
import de.audi.app.media.transfer.NullTransferListener;
import de.audi.app.media.transfer.TransferController$1;
import de.audi.app.media.transfer.TransferController$2;
import de.audi.app.media.transfer.TransferLockHandler;
import de.audi.app.media.transfer.TransferLogger;
import de.audi.app.media.transfer.TransferStateNotifier;
import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.app.media.transfer.queue.JobAbort;
import de.audi.app.media.transfer.queue.JobAbortBySourceRemoved;
import de.audi.app.media.transfer.queue.JobActivateSource;
import de.audi.app.media.transfer.queue.JobActivation;
import de.audi.app.media.transfer.queue.JobSetEncodingQuality;
import de.audi.app.media.transfer.queue.JobTransferring;
import de.audi.app.media.transfer.queue.TransferQueue;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;
import org.osgi.framework.ServiceRegistration;

public class TransferController
implements IMediaRecorderListener,
ITransferController,
ISourceSlotListener {
    private static final String LOGCLASS;
    private final NullTransferListener nullTransferListener;
    private final TransferLogger logger;
    private final MediaDSIRecorderControllerImpl mediaDSIRecorderController;
    private final TransferLockHandler transferLockHandler;
    private final IServiceManager serviceManager;
    private final TransferStateNotifier transferStateListenerNotifier;
    private volatile ITransferListener transferListener;
    private final IMediaConfiguration configuration;
    private ISourceSlot currentActiveSlot;
    private final Object activeSourceMutex = new Object();
    private final AbstractMediaBrowser transferBrowser;
    private final TransferQueue transferJobQueue;
    private ServiceRegistration serviceRegistration;
    private final ISourceController sourceController;
    private Object transferStateMutex = new Object();
    private int transferState = 0;
    public static final int TRANSFER_STATE_INITIALIZED;
    public static final int TRANSFER_STATE_ACTIVATED;
    public static final int TRANSFER_STATE_SOURCE_ACTIVATED;
    public static final int TRANSFER_STATE_SET_ENCODING_QUALITY_FINISHED;
    public static final int TRANSFER_STATE_TRANSFERING;
    static /* synthetic */ Class class$de$audi$app$media$transfer$ITransferController;

    public TransferController(IMediaTerminal iMediaTerminal) {
        this.logger = new TransferLogger(iMediaTerminal.getFramework());
        this.serviceManager = iMediaTerminal.getServiceManager();
        this.mediaDSIRecorderController = new MediaDSIRecorderControllerImpl(0, iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), iMediaTerminal.getSourceResolver(), this.logger.dsi());
        this.transferLockHandler = new TransferLockHandler(iMediaTerminal.getServiceManager(), this.logger);
        this.transferJobQueue = new TransferQueue(this.logger.main(), "TransferJobQueue", iMediaTerminal.getDiagnosisManager());
        this.configuration = iMediaTerminal.getConfiguration();
        this.nullTransferListener = new NullTransferListener(this.logger.main());
        this.transferListener = this.nullTransferListener;
        this.transferLockHandler.setTransferLockListener(this.nullTransferListener);
        this.transferStateListenerNotifier = new TransferStateNotifier(this.logger.main(), iMediaTerminal.getServiceManager());
        this.sourceController = iMediaTerminal.getSourceController();
        this.transferBrowser = new TransferController$1(this, this.logger.main(), this.logger.dsi(), iMediaTerminal.getServiceManager(), iMediaTerminal.getFramework(), iMediaTerminal.getDispatcher(), 7, iMediaTerminal.getSourceController());
    }

    public void init() {
        this.logger.main().log(1078071040, "[%1.init]", (Object)"TransferController");
        this.mediaDSIRecorderController.setRecorderListener(this);
        this.mediaDSIRecorderController.init();
        this.transferJobQueue.reset();
        this.transferJobQueue.enqueue(new JobActivation(this.logger.main(), this, this.mediaDSIRecorderController, this.transferLockHandler, this.transferBrowser));
        this.transferLockHandler.init();
        this.transferBrowser.init();
        this.transferStateListenerNotifier.init();
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$app$media$transfer$ITransferController == null ? (class$de$audi$app$media$transfer$ITransferController = TransferController.class$("de.audi.app.media.transfer.ITransferController")) : class$de$audi$app$media$transfer$ITransferController, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.main().log(1078071040, "[%1.deinit]", (Object)"TransferController");
        this.serviceManager.unregisterService(this.serviceRegistration);
        this.transferStateListenerNotifier.deinit();
        this.setTransferListener(this.nullTransferListener);
        this.transferLockHandler.deinit();
        this.mediaDSIRecorderController.deinit();
        this.transferBrowser.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void sourceSlotActivated(MediaSourceSlot mediaSourceSlot) {
        this.logger.dsi().log(1078071040, "[%1.sourceSlotActivated] slot='%2'.", (Object)"TransferController", (Object)mediaSourceSlot);
        Object object = this.activeSourceMutex;
        synchronized (object) {
            this.currentActiveSlot = mediaSourceSlot;
        }
        this.transferJobQueue.getRunningTransferJob().sourceSlotActivated(mediaSourceSlot);
        this.sourceController.addSourceSlotListener(mediaSourceSlot.getSource(), this, true);
    }

    @Override
    public void responseSetSelection(int n, boolean bl) {
        this.logger.dsi().log(1078071040, "[%1.responseSetSelection]", (Object)"TransferController");
        this.transferJobQueue.getRunningTransferJob().responseSetSelection(n, bl);
    }

    @Override
    public void updateDatabaseSpace(DatabaseSpace databaseSpace) {
        this.logger.dsi().log(1078071040, "[%1.updateDatabaseSpace] updating values ('%2').", (Object)"TransferController", (Object)databaseSpace);
        long l = 1L;
        long l2 = 1L;
        long l3 = 1L;
        long l4 = 1L;
        long l5 = 1L;
        long l6 = 1L;
        try {
            l = databaseSpace.getSize();
            l2 = databaseSpace.getSizeAvail();
            l3 = databaseSpace.getMaxEntries();
            long l7 = databaseSpace.getNumEntries();
            long l8 = l7 & Long.MAX_VALUE;
            l4 = l3 - l8;
            long l9 = (l - l2) * 0 / l;
            long l10 = (l3 - l4) * 0 / l3;
            l5 = 0 - l9;
            l6 = 0 - l10;
        }
        catch (ArithmeticException arithmeticException) {
            this.logger.dsi().log(1000, "[%1.updateDatabaseSpace] Exception during calculating database space occured. Send parameters are wrong!", (Object)"TransferController");
        }
        this.transferListener.jukeboxSpaceChanged(l, l2, l5, l3, l4, l6);
    }

    @Override
    public void updateImportStatus(int n) {
        this.logger.dsi().log(1078071040, "[%1.updateImportStatus] status='%2'.", (Object)"TransferController", (Object)TransferController.importStatus2String(n));
        this.transferJobQueue.getRunningTransferJob().importStatusChanged(n);
    }

    @Override
    public void updateDeletionStatus(int n) {
        this.logger.dsi().log(1078071040, "[%1.updateDeletionStatus] status='%2'.", (Object)"TransferController", (Object)TransferController.deletionStatus2String(n));
        this.transferJobQueue.getRunningTransferJob().deletionStatusChanged(n);
    }

    @Override
    public void updateDeletionProgress(long l) {
        this.logger.dsi().log(1078071040, "[%1.updateDeletionProgress] '%2'.", (Object)"TransferController", l);
        this.transferJobQueue.getRunningTransferJob().deletionProgressChanged(l);
    }

    @Override
    public void updateImportProgress(long l, ListEntry listEntry) {
        if (this.logger.dsi().isInfo()) {
            this.logger.dsi().log(1078071040, "[%1.updateImportProgress] progress='%2', entry='%3'.", (Object)"TransferController", (Object)new Long(l), (Object)listEntry);
        }
        this.transferJobQueue.getRunningTransferJob().importProgressChanged(l, listEntry);
    }

    @Override
    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
        this.logger.dsi().log(1078071040, "[%1.updateImportSummary]", (Object)"TransferController");
        this.transferJobQueue.getRunningTransferJob().updateImportSummary(l, l2, l3, l4, l5, l6);
    }

    @Override
    public void responseSetEncodingQuality(int n) {
        this.logger.dsi().log(1078071040, "[%1.responseSetEncodingQuality]", (Object)"TransferController");
        this.transferJobQueue.getRunningTransferJob().encodingQualityChanged(n);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.dsi().log(10000, "[%1.asyncException] asyncException occured, errorCode='%2', errorMsg='%3', requestType='%4'.", (Object)"TransferController", (Object)Integer.toString(n), (Object)string, (Object)Integer.toString(n2));
        this.transferJobQueue.getRunningTransferJob().asyncException(n2, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start() {
        this.logger.main().log(1078071040, "[%1.start]", (Object)"TransferController");
        if (this.isTransferState(2) && !this.isTransferState(8)) {
            if (this.isEncodingQualityNecessary()) {
                this.logger.main().log(1078071040, "[%1.start] Encoding Quality is needed.", (Object)"TransferController");
                this.transferListener.startFailed();
            } else {
                boolean bl = false;
                Object object = this.activeSourceMutex;
                synchronized (object) {
                    bl = this.currentActiveSlot.getSource().getType() != 6;
                }
                this.transferJobQueue.enqueue(new JobTransferring(this.logger.main(), this, this.mediaDSIRecorderController, this.transferLockHandler, this.transferBrowser, this.configuration.isImportOverrideActive(), bl));
            }
        } else {
            this.transferListener.startFailed();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void abort() {
        this.logger.main().log(1078071040, "[%1.abort]", (Object)"TransferController");
        Object object = this.activeSourceMutex;
        synchronized (object) {
            if (null == this.currentActiveSlot) {
                return;
            }
            this.currentActiveSlot = null;
        }
        if (!this.isTransferState(1)) {
            this.logger.main().log(1078071040, "[%1.abort] Transfer is not active. Ignore abort.", (Object)"TransferController");
            return;
        }
        int n = this.transferJobQueue.getRunningTransferJob().getType();
        if (0 == n) {
            this.transferJobQueue.enqueue(new JobAbort(this.logger.main(), this, this.mediaDSIRecorderController, this.transferBrowser, this.transferLockHandler));
        } else {
            if (7 == n || 6 == n) {
                this.logger.main().log(1078071040, "[%1.abort] Abort already running", (Object)"TransferController");
                return;
            }
            this.transferJobQueue.executeQueueCommand(new TransferController$2(this));
        }
    }

    @Override
    public void setEncodingQuality(int n) {
        if (this.isTransferState(2)) {
            this.logger.main().log(1078071040, "[%1.setEncodingQuality]", (Object)"TransferController");
            this.transferJobQueue.enqueue(new JobSetEncodingQuality(this.logger.main(), this, this.mediaDSIRecorderController, this.transferBrowser, n));
        } else {
            this.logger.main().log(1078071040, "[%1.setEncodingQuality] Transfer controller was not activated.", (Object)"TransferController");
            this.transferListener.encodingQualityChanged(true, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void activate(ISourceSlot iSourceSlot) {
        if (!this.isTransferSupported(iSourceSlot)) {
            this.logger.hmi().log(10000, "[%1.activate] Transfer not supported by source slot: %2", (Object)"TransferController", (Object)iSourceSlot);
            this.transferListener.activationFailed(iSourceSlot);
            return;
        }
        if (!this.isTransferState(1)) {
            this.logger.main().log(10000, "[%1.activate(slot)] Transfer is not activated!", (Object)"TransferController");
            this.transferListener.activationFailed(iSourceSlot);
            return;
        }
        if (this.isTransferState(8) || 2 == this.transferJobQueue.getRunningTransferJob().getType()) {
            this.logger.main().log(1078071040, "[%1.activate] Transfer is busy.", (Object)"TransferController");
            this.transferListener.activationFailed(iSourceSlot);
            return;
        }
        this.transferBrowser.deactivate();
        this.logger.main().log(1078071040, "[%1.activate] slot='%2'.", (Object)"TransferController", (Object)iSourceSlot);
        ISourceSlot iSourceSlot2 = null;
        Object object = this.activeSourceMutex;
        synchronized (object) {
            iSourceSlot2 = this.currentActiveSlot;
        }
        this.transferJobQueue.enqueue(new JobActivateSource(this.logger.main(), this, this.transferBrowser, this.mediaDSIRecorderController, iSourceSlot, iSourceSlot2));
    }

    @Override
    public void dsiServiceRemoved() {
        this.logger.main().log(1078071040, "[%1.dsiServiceRemoved]", (Object)"TransferController");
        this.transferJobQueue.abort();
        this.removeTransferState(15);
        this.transferListener.unreadyToTransfer();
        this.removeActiveSlot();
        this.transferJobQueue.enqueue(new JobActivation(this.logger.main(), this, this.mediaDSIRecorderController, this.transferLockHandler, this.transferBrowser));
    }

    @Override
    public void slotsChanged(ISource iSource) {
        if (!this.isTransferState(1)) {
            this.logger.main().log(1078071040, "[%1.slotsChanged] Transfer is not activated.", (Object)"TransferController");
            return;
        }
        this.logger.main().log(1078071040, "[%1.slotsChanged]", (Object)"TransferController");
        List list = iSource.getSlots();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
            if (!this.isCurrentSourceSlot(iSource.getType(), iSourceSlot.getIndex()) || iSourceSlot.getState() == 3) continue;
            this.transferJobQueue.abort();
            this.removeTransferState(14);
            this.removeActiveSlot();
            this.transferJobQueue.enqueue(new JobAbortBySourceRemoved(this.logger.main(), this, this.mediaDSIRecorderController, this.transferBrowser, this.transferLockHandler));
            this.transferListener.sourceRemoved(iSourceSlot);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isCurrentSourceSlot(int n, int n2) {
        boolean bl = false;
        Object object = this.activeSourceMutex;
        synchronized (object) {
            if (this.currentActiveSlot != null && this.currentActiveSlot.getSource().getType() == n && this.currentActiveSlot.getIndex() == n2) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean isTransferSupported(ISourceSlot iSourceSlot) {
        return iSourceSlot.getCapabilities().isImportData();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean isEncodingQualityNecessary() {
        if (this.isTransferState(4)) {
            return false;
        }
        Object object = this.activeSourceMutex;
        synchronized (object) {
            return this.currentActiveSlot.getContentType() == 0;
        }
    }

    private static String importStatus2String(int n) {
        switch (n) {
            case 0: {
                return "Idle";
            }
            case 1: {
                return "Importing";
            }
            case 5: {
                return "Aborted";
            }
            case 2: {
                return "PreProcessing";
            }
            case 4: {
                return "Success";
            }
            case 8: {
                return "ReadyForResume";
            }
            case 6: {
                return "Suspend";
            }
            case 7: {
                return "ReadyForSelection";
            }
            case 3: {
                return "PostProcessing";
            }
        }
        return "Unsupported";
    }

    private static String deletionStatus2String(int n) {
        switch (n) {
            case 0: {
                return "Idle";
            }
            case 1: {
                return "Deleting";
            }
            case 2: {
                return "PreProcessing";
            }
            case 4: {
                return "Success";
            }
            case 5: {
                return "Aborted";
            }
            case 6: {
                return "FinishedWithErrors";
            }
            case 7: {
                return "ReadyForSelection";
            }
            case 3: {
                return "PostProcessing";
            }
        }
        return "Unsupported";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ISourceSlot getActiveSlot() {
        Object object = this.activeSourceMutex;
        synchronized (object) {
            return this.currentActiveSlot;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeActiveSlot() {
        Object object = this.activeSourceMutex;
        synchronized (object) {
            this.logger.main().log(1078071040, "[%1.removeActiveSlot]", (Object)"TransferController");
            this.currentActiveSlot = null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTransferState(int n) {
        Object object = this.transferStateMutex;
        synchronized (object) {
            this.transferState |= n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeTransferState(int n) {
        Object object = this.transferStateMutex;
        synchronized (object) {
            this.transferState &= ~n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isTransferState(int n) {
        Object object = this.transferStateMutex;
        synchronized (object) {
            return (this.transferState & n) == n;
        }
    }

    @Override
    public void setTransferListener(ITransferListener iTransferListener) {
        this.logger.main().log(1078071040, "[%1.setTransferListener] '%2'", (Object)"TransferController", (Object)iTransferListener);
        this.transferListener = iTransferListener;
        this.transferLockHandler.setTransferLockListener(iTransferListener);
        if (this.isTransferState(1) && !this.isTransferState(8)) {
            this.transferListener.readyForTransfer();
        }
    }

    public ITransferListener getTransferListener() {
        return this.transferListener;
    }

    public TransferStateNotifier getTransferStateNotifier() {
        return this.transferStateListenerNotifier;
    }

    public void enqueueTransferJob(AbstractJobTransfer abstractJobTransfer) {
        this.transferJobQueue.enqueue(abstractJobTransfer);
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("TransferController").append("@").append(this.hashCode());
        return buffer.toString();
    }

    static /* synthetic */ TransferQueue access$000(TransferController transferController) {
        return transferController.transferJobQueue;
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

