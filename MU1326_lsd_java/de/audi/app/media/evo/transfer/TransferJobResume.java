/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.transfer;

import de.audi.app.media.evo.transfer.EvoTransferController;
import de.audi.app.media.evo.transfer.EvoTransferState;
import de.audi.app.media.evo.transfer.TransferItemNone;
import de.audi.app.media.evo.transfer.TransferJobRunning;
import de.audi.app.media.transfer.ITransferController;
import de.audi.atip.log.LogChannel;

public class TransferJobResume
extends TransferJobRunning {
    private static final String LOGCLASS = "TransferJobResume";
    private boolean jobWasResumed = false;

    public TransferJobResume(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, new TransferItemNone(), iTransferController, evoTransferController, evoTransferState);
    }

    public int getType() {
        return 4;
    }

    public String getName() {
        return LOGCLASS;
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
    }

    public void readyForTransfer() {
        this.logger.log(1000000, "[%1.readyForTransfer]", (Object)LOGCLASS);
        if (this.jobWasResumed) {
            this.evoTransferController.updateModelsAndShowTransferPopup(200000);
        }
        this.evoTransferController.enableTransfer();
        this.getExecutionContext().jobFinished();
    }

    public void importIsSuspended() {
        this.logger.log(1000000, "[%1.importIsSuspended]", (Object)LOGCLASS);
        this.jobWasResumed = true;
        this.evoTransferController.disableTransfer();
    }

    public void importWillBeResumed() {
        this.logger.log(1000000, "[%1.importWillBeResumed]", (Object)LOGCLASS);
        this.jobWasResumed = true;
        this.evoTransferController.disableTransfer();
    }
}

