/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.interapp.MediaServiceImpl;
import de.audi.app.media.sds.SDSController;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;

class SDSController$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pSourceID;
    private final /* synthetic */ int val$pSlotIdx;
    private final /* synthetic */ int val$pPartitionIdx;
    private final /* synthetic */ SDSController this$0;

    SDSController$3(SDSController sDSController, String string, int n, int n2, int n3) {
        this.this$0 = sDSController;
        this.val$pSourceID = n;
        this.val$pSlotIdx = n2;
        this.val$pPartitionIdx = n3;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$400(this.this$0).sds().log(1078071040, "[%1.activateSource] '%2' (slotIdx='%3', partIdx='%4').", (Object)"SDSController", (Object)Integer.toString(this.val$pSourceID), (Object)Integer.toString(this.val$pSlotIdx), (Object)Integer.toString(this.val$pPartitionIdx));
        int n = MediaServiceImpl.getISourceIDFromMediaSourceID(this.val$pSourceID);
        if (n == -1) {
            SDSController.access$500(this.this$0).sds().log(-1601830656, "[%1.activateSource] SourceID '%2' is invalid.", (Object)"SDSController", (long)this.val$pSourceID);
            SDSController.access$600(this.this$0, 9);
            return;
        }
        ISourceController iSourceController = this.this$0.getTerminal().getSourceController();
        ISource iSource = iSourceController.getSource(n);
        if (iSource == null) {
            SDSController.access$600(this.this$0, 1);
            return;
        }
        int n2 = -1 == this.val$pPartitionIdx ? this.val$pSlotIdx : iSource.getSlotNumberByPartition(this.val$pSlotIdx, this.val$pPartitionIdx);
        this.this$0.activateSourceSlot(iSource.getSlot(n2));
    }
}

