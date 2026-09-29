/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.app.media.transfer.queue.TransferQueue$NullTransferJob;
import de.audi.atip.log.LogChannel;

public class TransferQueue
extends Queue {
    private final TransferQueue$NullTransferJob NULL_TRANSFER_JOB;

    public TransferQueue(LogChannel logChannel, String string, IDiagnosisManager iDiagnosisManager) {
        super(logChannel, string);
        iDiagnosisManager.addDataProvider(-1, this);
        this.NULL_TRANSFER_JOB = new TransferQueue$NullTransferJob(this, logChannel, null);
    }

    public AbstractJobTransfer getRunningTransferJob() {
        AbstractJobTransfer abstractJobTransfer = (AbstractJobTransfer)this.getRunningJob();
        return null != abstractJobTransfer ? abstractJobTransfer : this.NULL_TRANSFER_JOB;
    }
}

