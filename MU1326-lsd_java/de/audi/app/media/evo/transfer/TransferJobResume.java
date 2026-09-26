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
    private static final String LOGCLASS;
    private boolean jobWasResumed = false;

    public TransferJobResume(LogChannel logChannel, ITransferController iTransferController, EvoTransferController evoTransferController, EvoTransferState evoTransferState) {
        super(logChannel, new TransferItemNone(), iTransferController, evoTransferController, evoTransferState);
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public String getName() {
        return "TransferJobResume";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"TransferJobResume");
    }

    @Override
    public void readyForTransfer() {
        this.logger.log(1078071040, "[%1.readyForTransfer]", (Object)"TransferJobResume");
        if (this.jobWasResumed) {
            this.evoTransferController.updateModelsAndShowTransferPopup(1074594560);
        }
        this.evoTransferController.enableTransfer();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void importIsSuspended() {
        this.logger.log(1078071040, "[%1.importIsSuspended]", (Object)"TransferJobResume");
        this.jobWasResumed = true;
        this.evoTransferController.disableTransfer();
    }

    @Override
    public void importWillBeResumed() {
        this.logger.log(1078071040, "[%1.importWillBeResumed]", (Object)"TransferJobResume");
        this.jobWasResumed = true;
        this.evoTransferController.disableTransfer();
    }
}

