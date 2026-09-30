/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.queue;

import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.queue.Queue;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.atip.log.LogChannel;

public class TransferQueue
extends Queue {
    private final NullTransferJob NULL_TRANSFER_JOB;

    public TransferQueue(LogChannel logChannel, String string, IDiagnosisManager iDiagnosisManager) {
        super(logChannel, string);
        iDiagnosisManager.addDataProvider(-1, this);
        this.NULL_TRANSFER_JOB = new NullTransferJob(logChannel);
    }

    public AbstractJobTransfer getRunningTransferJob() {
        AbstractJobTransfer abstractJobTransfer = (AbstractJobTransfer)this.getRunningJob();
        return null != abstractJobTransfer ? abstractJobTransfer : this.NULL_TRANSFER_JOB;
    }

    private final class NullTransferJob
    extends AbstractJobTransfer {
        private static final String LOGCLASS = "NullTransferJob";

        private NullTransferJob(LogChannel logChannel) {
            super(logChannel, null, null, null);
        }

        public int getType() {
            return 0;
        }

        public String getName() {
            return LOGCLASS;
        }

        public void abort(boolean bl) {
            this.logger.log(1000000, "[%1.abort]", (Object)LOGCLASS);
        }

        public void start() {
            this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
            this.getExecutionContext().jobFinished();
        }

        public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6) {
            this.logger.log(1000000, "[%1.updateImportSummary]", (Object)LOGCLASS);
        }

        public void sourceSlotActivated(MediaSourceSlot mediaSourceSlot) {
            this.logger.log(1000000, "[%1.sourceSlotActivated]", (Object)LOGCLASS);
        }

        public void responseSetSelection(int n, boolean bl) {
            this.logger.log(1000000, "[%1.responseSetSelection]", (Object)LOGCLASS);
        }

        public void importStatusChanged(int n) {
            this.logger.log(1000000, "[%1.importStatusChanged]", (Object)LOGCLASS);
        }

        public void encodingQualityChanged(int n) {
            this.logger.log(1000000, "[%1.encodingQualityChanged]", (Object)LOGCLASS);
        }

        public void deletionStatusChanged(int n) {
            this.logger.log(1000000, "[%1.deletionStatusChanged]", (Object)LOGCLASS);
        }

        public void browserActivated(ISourceSlot iSourceSlot, IBrowseListContext iBrowseListContext) {
            this.logger.log(1000000, "[%1.browserActivated]", (Object)LOGCLASS);
        }

        public void browserDeactivated(ISourceSlot iSourceSlot) {
            this.logger.log(1000000, "[%1.browserDeactivated]", (Object)LOGCLASS);
        }

        public void asyncException(int n, int n2) {
            this.logger.log(1000000, "[%1.asyncException]", (Object)LOGCLASS);
        }
    }
}

