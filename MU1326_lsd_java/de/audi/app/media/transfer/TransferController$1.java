/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.browser.AbstractMediaBrowser;
import de.audi.app.media.browser.IBrowseListContext;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.transfer.TransferController;
import de.audi.app.media.transfer.queue.AbstractJobTransfer;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

class TransferController$1
extends AbstractMediaBrowser {
    private final /* synthetic */ TransferController this$0;

    TransferController$1(TransferController transferController, LogChannel logChannel, LogChannel logChannel2, IServiceManager iServiceManager, IFrameworkAccess iFrameworkAccess, DispatcherBase dispatcherBase, int n, ISourceController iSourceController) {
        this.this$0 = transferController;
        super(logChannel, logChannel2, iServiceManager, iFrameworkAccess, dispatcherBase, n, iSourceController);
    }

    @Override
    protected void browserActivated(IBrowseListContext iBrowseListContext) {
        this.logger.log(1078071040, "[%1.browserActivated]", (Object)"TransferController");
        TransferController.access$000(this.this$0).getRunningTransferJob().browserActivated(iBrowseListContext.getSlot(), iBrowseListContext);
    }

    @Override
    protected void browserDeactivated(ISourceSlot iSourceSlot, boolean bl) {
        this.logger.log(1078071040, "[%1.browserDeactivated]", (Object)"TransferController");
        AbstractJobTransfer abstractJobTransfer = TransferController.access$000(this.this$0).getRunningTransferJob();
        if (abstractJobTransfer.getType() != 0) {
            abstractJobTransfer.browserDeactivated(iSourceSlot);
        }
    }
}

