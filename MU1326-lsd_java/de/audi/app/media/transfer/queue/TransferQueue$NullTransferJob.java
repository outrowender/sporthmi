/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.app.media.transfer.queue.TransferQueue;
import de.audi.app.media.transfer.queue.TransferQueue$1;
import de.audi.atip.log.LogChannel;

final class TransferQueue$NullTransferJob
extends AbstractJobTransfer {
    private static final String LOGCLASS;
    private final /* synthetic */ TransferQueue this$0;

    private TransferQueue$NullTransferJob(TransferQueue transferQueue, LogChannel logChannel) {
        this.this$0 = transferQueue;
        super(logChannel, null, null, null);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "NullTransferJob";
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort]", (Object)"NullTransferJob");
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"NullTransferJob");
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
        this.logger.log(1078071040, "[%1.updateImportSummary]", (Object)"NullTransferJob");
    }

    @Override
    public void sourceSlotActivated(MediaSourceSlot mediaSourceSlot) {
        this.logger.log(1078071040, "[%1.sourceSlotActivated]", (Object)"NullTransferJob");
    }

    @Override
    public void responseSetSelection(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.responseSetSelection]", (Object)"NullTransferJob");
    }

    @Override
    public void importStatusChanged(int n) {
        this.logger.log(1078071040, "[%1.importStatusChanged]", (Object)"NullTransferJob");
    }

    @Override
    public void encodingQualityChanged(int n) {
        this.logger.log(1078071040, "[%1.encodingQualityChanged]", (Object)"NullTransferJob");
    }

    @Override
    public void deletionStatusChanged(int n) {
        this.logger.log(1078071040, "[%1.deletionStatusChanged]", (Object)"NullTransferJob");
    }

    @Override
    public void browserActivated(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.browserActivated]", (Object)"NullTransferJob");
    }

    @Override
    public void browserDeactivated(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.browserDeactivated]", (Object)"NullTransferJob");
    }

    @Override
    public void asyncException(int n, int n2) {
        this.logger.log(1078071040, "[%1.asyncException]", (Object)"NullTransferJob");
    }

    /* synthetic */ TransferQueue$NullTransferJob(TransferQueue transferQueue, LogChannel logChannel, TransferQueue$1 transferQueue$1) {
        this(transferQueue, logChannel);
    }
}

