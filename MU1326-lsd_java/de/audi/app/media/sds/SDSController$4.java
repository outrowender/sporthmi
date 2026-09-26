/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.interapp.MediaServiceImpl;
import de.audi.app.media.sds.SDSController;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;
import de.audi.app.media.source.ISourceSlot;
import java.util.Iterator;

class SDSController$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pSourceID;
    private final /* synthetic */ SDSController this$0;

    SDSController$4(SDSController sDSController, String string, int n) {
        this.this$0 = sDSController;
        this.val$pSourceID = n;
        super(string);
    }

    @Override
    public void run() {
        SDSController.access$700(this.this$0).sds().log(1078071040, "[%1.activateSource] '%2' ", (Object)"SDSController", (long)this.val$pSourceID);
        int n = MediaServiceImpl.getISourceIDFromMediaSourceID(this.val$pSourceID);
        if (n == -1) {
            SDSController.access$800(this.this$0).sds().log(-1601830656, "[%1.activateSource] SourceID '%2' is invalid.", (Object)"SDSController", (long)this.val$pSourceID);
            SDSController.access$600(this.this$0, 9);
            return;
        }
        ISourceController iSourceController = this.this$0.getTerminal().getSourceController();
        ISource iSource = iSourceController.getSource(n);
        if (iSource == null) {
            SDSController.access$600(this.this$0, 1);
            return;
        }
        ISourceSlot iSourceSlot = null;
        if (n == 11 || n == 12) {
            iSourceSlot = iSource.getSlot(0);
        } else {
            Iterator iterator = iSource.getSlots().iterator();
            ISourceSlot iSourceSlot2 = null;
            while (iterator.hasNext()) {
                ISourceSlot iSourceSlot3 = (ISourceSlot)iterator.next();
                if (iSource.isActivateable(iSourceSlot3)) {
                    iSourceSlot = iSourceSlot3;
                    break;
                }
                if (iSourceSlot2 != null || iSourceSlot3.isEmpty()) continue;
                iSourceSlot2 = iSourceSlot3;
            }
            if (iSourceSlot == null) {
                iSourceSlot = iSourceSlot2;
            }
        }
        this.this$0.activateSourceSlot(iSourceSlot);
    }
}

