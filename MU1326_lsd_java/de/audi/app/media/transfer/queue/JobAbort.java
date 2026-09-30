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

public class JobAbort
extends AbstractJobTransfer {
    private static final String LOGCLASS = "JobAbort";
    private final TransferLockHandler transferLockHandler;

    public JobAbort(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, AbstractMediaBrowser abstractMediaBrowser, TransferLockHandler transferLockHandler) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser);
        this.transferLockHandler = transferLockHandler;
    }

    public int getType() {
        return 6;
    }

    public String getName() {
        return "AbortTransfer";
    }

    public void abort(boolean bl) {
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.getMediaDSIRecorder().abortImport();
    }

    public void importStatusChanged(int n) {
        this.logger.log(1000000, "[%1.importStatusChanged]", (Object)LOGCLASS);
        if (0 == n) {
            this.getTransferController().getTransferStateNotifier().notifyImportStopped();
            this.finishJob();
        }
    }

    public void deletionStatusChanged(int n) {
        this.logger.log(1000000, "[%1.deletionStatusChanged]", (Object)LOGCLASS);
        if (0 == n) {
            this.finishJob();
        }
    }

    public void asyncException(int n, int n2) {
        this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
        this.finishJob();
    }

    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
        this.logger.log(1000000, "[%1.updateImportSummary]", (Object)LOGCLASS);
        this.getTransferListener().importAborted(l + l5, l4 + l6, l2, l == l4 && l5 == l6);
    }

    private void finishJob() {
        this.transferLockHandler.importActive(false);
        this.getTransferController().setTransferState(1);
        this.getTransferBrowser().deactivate();
        this.getTransferController().removeActiveSlot();
        this.getTransferListener().readyForTransfer();
        this.jobFinished();
    }
}

