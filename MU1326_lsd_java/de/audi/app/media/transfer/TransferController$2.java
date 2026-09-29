/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.queue.IQueueCommand;
import de.audi.app.media.queue.IQueueJob;
import de.audi.app.media.transfer.TransferController;
import java.util.List;

class TransferController$2
implements IQueueCommand {
    private final /* synthetic */ TransferController this$0;

    TransferController$2(TransferController transferController) {
        this.this$0 = transferController;
    }

    @Override
    public void execute(IQueueJob iQueueJob, List list) {
        if (iQueueJob == null) {
            return;
        }
        iQueueJob.abort(true);
    }
}

