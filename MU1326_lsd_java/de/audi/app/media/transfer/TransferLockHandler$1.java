/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.transfer.TransferLockHandler;
import de.audi.atip.bulkcopy.IBulkCopyManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TransferLockHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TransferLockHandler this$0;

    TransferLockHandler$1(TransferLockHandler transferLockHandler) {
        this.this$0 = transferLockHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TransferLockHandler.access$000(this.this$0).main().log(1078071040, "[%1.removedService] BulkCopyManager service removed.", (Object)"TransferLockHandler");
        TransferLockHandler.access$100(this.this$0).releaseService(serviceReference);
        TransferLockHandler.access$200(this.this$0, null);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TransferLockHandler.access$000(this.this$0).main().log(1078071040, "[%1.addingService]", (Object)"TransferLockHandler");
        IBulkCopyManager iBulkCopyManager = (IBulkCopyManager)TransferLockHandler.access$100(this.this$0).getService(serviceReference);
        TransferLockHandler.access$200(this.this$0, iBulkCopyManager);
        return iBulkCopyManager;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

