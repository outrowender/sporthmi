/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.SourceController;

class SourceController$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ SourceController this$0;

    SourceController$1(SourceController sourceController, String string) {
        this.this$0 = sourceController;
        super(string);
    }

    @Override
    public void run() {
        if (this.this$0.getSelectedSlot() != null) {
            SourceController.access$000(this.this$0).main().log(1078071040, "[%1.restoreLastModeSource] Already restored.", (Object)"SourceController");
            return;
        }
        ISource iSource = this.this$0.lastModeManager.getLastSelectedSource();
        int n = this.this$0.lastModeManager.getLastSelectedSlotIdx();
        ISourceSlot iSourceSlot = iSource.getSlot(n);
        SourceController.access$100(this.this$0).main().log(1078071040, "[%1.restoreLastModeSource] '%2'", (Object)"SourceController", (Object)iSourceSlot);
        SourceController.access$200(this.this$0, iSourceSlot);
        this.this$0.getTerminal().getTitlelineHMIHandler().setSourceIcon(iSourceSlot);
        SourceController.access$400(this.this$0, SourceController.access$300(this.this$0), 2);
        this.this$0.lastModeManager.startLastModeTracking();
    }
}

