/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.TransferLockHandler;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.app.media.transfer.queue.JobResumeImport;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class JobActivation
extends AbstractJobTransfer {
    private static final String LOGCLASS = "TransferJobActivation";
    private final TransferLockHandler transferLockHandler;
    private static final int DSI_STATE_NOT_READY = -1;
    private static final int DSI_STATE_READY = 1;
    private volatile int dsiDeleteState = -1;
    private volatile int dsiImportState = -1;

    public JobActivation(LogChannel logChannel, TransferController transferController, MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, TransferLockHandler transferLockHandler, AbstractMediaBrowser abstractMediaBrowser) {
        super(logChannel, transferController, mediaDSIRecorderControllerImpl, abstractMediaBrowser);
        this.transferLockHandler = transferLockHandler;
    }

    public int getType() {
        return 5;
    }

    public String getName() {
        return "Activation";
    }

    public void asyncException(int n, int n2) {
    }

    public void importStatusChanged(int n) {
        this.logger.log(1000000, "[%1.importStatusChanged]", (Object)LOGCLASS);
        switch (n) {
            case 0: {
                this.dsiImportState = 1;
                this.readyForTransfer();
                break;
            }
            case 6: {
                this.transferLockHandler.importActive(false);
                this.getTransferController().setTransferState(1);
                this.getTransferController().enqueueTransferJob(new JobResumeImport(this.logger, this.getTransferController(), this.getMediaDSIRecorder(), this.transferLockHandler, this.getTransferBrowser()));
                this.jobFinished();
                break;
            }
        }
    }

    public void deletionStatusChanged(int n) {
        this.logger.log(1000000, "[%1.deletionStatusChanged]", (Object)LOGCLASS);
        switch (n) {
            case 0: {
                this.dsiDeleteState = 1;
                this.readyForTransfer();
                break;
            }
        }
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        this.getMediaDSIRecorder().startDSI();
    }

    public void abort(boolean bl) {
    }

    private void readyForTransfer() {
        if (this.dsiImportState == 1 && this.dsiDeleteState == 1) {
            this.logger.log(1000000, "[%1.readyForTransfer]", (Object)LOGCLASS);
            this.transferLockHandler.importActive(false);
            this.getTransferController().setTransferState(1);
            this.getTransferListener().readyForTransfer();
            this.jobFinished();
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[name=");
        buffer.append(this.getName());
        buffer.append(", deleteState=");
        buffer.append(this.dsiDeleteState == 1 ? "ready" : "not ready");
        buffer.append(", importState=");
        buffer.append(this.dsiImportState == 1 ? "ready" : "not ready");
        buffer.append("]");
        return buffer.toString();
    }
}

