/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.TransferLockHandler;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.media.ListEntry;

public class JobTransferring
extends AbstractJobTransfer {
    private static final String LOGCLASS = "TransferJobTransferring";
    private final TransferLockHandler transferLockHandler;
    private long numberOfImportedItems;
    private long numberOfItemsToImport;
    private long numberOfErroneousItems;
    private boolean allItemsSuccessfullyImported;
    private final boolean importMode;
    private final boolean importOverrideActive;

    public JobTransferring(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, TransferLockHandler transferLockHandler, AbstractMediaBrowser abstractMediaBrowser, boolean bl, boolean bl2) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser);
        this.importOverrideActive = bl;
        this.transferLockHandler = transferLockHandler;
        this.importMode = bl2;
    }

    public int getType() {
        return 3;
    }

    public String getName() {
        return "TransferRunning";
    }

    public void asyncException(int n, int n2) {
        this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
        if (this.importMode) {
            this.getMediaDSIRecorder().abortImport();
        } else {
            this.getMediaDSIRecorder().abortDelete();
        }
    }

    public void responseSetSelection(int n, boolean bl) {
        if (this.logger.isInfo()) {
            this.logger.log(1000000, "[%1.responseSetSelection] browserID='%2', result='%3'.", (Object)LOGCLASS, (Object)new Integer(n), (Object)bl);
        }
        if (n != 7) {
            this.logger.log(100000, "[%1.responseSetSelection] unexpected browserID '%2'!", (Object)LOGCLASS, (long)n);
            return;
        }
        if (this.transferLockHandler.importActive(true)) {
            if (this.importMode) {
                this.getMediaDSIRecorder().startImport(this.importOverrideActive);
            } else {
                this.getMediaDSIRecorder().startDelete();
            }
        } else {
            this.logger.log(100000, "[%1.responseSetSelection] resources are blocked, aborting", (Object)LOGCLASS);
            if (this.importMode) {
                this.getMediaDSIRecorder().abortImport();
            } else {
                this.getMediaDSIRecorder().abortDelete();
            }
        }
    }

    public void importProgressChanged(long l, ListEntry listEntry) {
        this.logger.log(1000000, "[%1.importStatusChanged] '%2'", (Object)LOGCLASS, l);
        this.getTransferListener().importProgressChanged(l, listEntry);
        this.getTransferController().getTransferStateNotifier().notifyImportProgressChanged((int)l);
    }

    public void deletionProgressChanged(long l) {
        this.logger.log(1000000, "[%1.deletionProgressChanged] '%2'", (Object)LOGCLASS, l);
        this.getTransferListener().deletionProgressChanged(l);
    }

    public void importStatusChanged(int n) {
        this.logger.log(1000000, "[%1.importStatusChanged]", (Object)LOGCLASS);
        switch (n) {
            case 0: {
                if (!this.importMode) break;
                this.getTransferController().getTransferStateNotifier().notifyImportStopped();
                this.finishJob();
                break;
            }
            case 5: {
                this.getTransferListener().importAborted(this.numberOfImportedItems, this.numberOfItemsToImport, this.numberOfErroneousItems, this.allItemsSuccessfullyImported);
                break;
            }
            case 4: {
                this.getTransferListener().importFinished(this.numberOfImportedItems, this.numberOfItemsToImport, this.numberOfErroneousItems, this.allItemsSuccessfullyImported);
                break;
            }
            case 8: {
                if (this.transferLockHandler.importActive(true)) {
                    this.logger.log(1000000, "[%1.importStatusChanged] Start import.", (Object)LOGCLASS);
                    this.getMediaDSIRecorder().startImport(false);
                    break;
                }
                this.logger.log(100000, "[%1.importStatusChanged] resources are locked, aborting import!", (Object)LOGCLASS);
                this.getMediaDSIRecorder().abortImport();
                break;
            }
            case 1: {
                this.getTransferListener().importStarted();
                this.getTransferController().getTransferStateNotifier().notifyImportStarted(this.getTransferController().getActiveSlot());
                break;
            }
            case 3: {
                break;
            }
        }
    }

    public void deletionStatusChanged(int n) {
        this.logger.log(1000000, "[%1.deletionStatusChanged]", (Object)LOGCLASS);
        switch (n) {
            case 1: {
                this.getTransferListener().deletionStarted();
                break;
            }
            case 4: {
                this.getTransferListener().deletionFinished();
                break;
            }
            case 6: {
                this.getTransferListener().deletionFinished();
                break;
            }
            case 3: {
                this.getTransferListener().deletionPostprocessing();
                break;
            }
            case 5: {
                this.getTransferListener().deletionAborted();
                break;
            }
            case 0: {
                if (this.importMode) break;
                this.finishJob();
                break;
            }
        }
    }

    private void finishJob() {
        this.transferLockHandler.importActive(false);
        this.getTransferController().removeTransferState(14);
        this.getTransferBrowser().deactivate();
        this.getTransferController().removeActiveSlot();
        this.getTransferListener().readyForTransfer();
        this.jobFinished();
    }

    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
        this.logger.log(1000000, "[%1.updateImportSummary]", (Object)LOGCLASS);
        this.numberOfImportedItems = l + l5;
        this.numberOfItemsToImport = l4 + l6;
        this.numberOfErroneousItems = l2;
        this.allItemsSuccessfullyImported = l == l4 && l5 == l6;
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.getTransferController().setTransferState(8);
        this.getMediaDSIRecorder().setSelection(7);
    }

    public void abort(boolean bl) {
        if (bl) {
            this.logger.log(1000000, "[%1.abort]", (Object)LOGCLASS);
            if (this.importMode) {
                this.getMediaDSIRecorder().abortImport();
            } else {
                this.getMediaDSIRecorder().abortDelete();
            }
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", mode=");
        buffer.append(this.importMode ? "import" : "delete");
        buffer.append(", override=");
        buffer.append(Boolean.toString(this.importOverrideActive));
        buffer.append("]");
        return buffer.toString();
    }
}

