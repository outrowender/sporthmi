/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.source.SourceListHMIHandler;
import de.audi.app.media.evo.source.SourceListRow;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceSlot;

class SourceListHMIHandler$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ SourceListRow val$sourceListRow;
    private final /* synthetic */ SourceListHMIHandler this$0;

    SourceListHMIHandler$1(SourceListHMIHandler sourceListHMIHandler, String string, int n, int n2, SourceListRow sourceListRow) {
        this.this$0 = sourceListHMIHandler;
        this.val$model = n;
        this.val$terminal = n2;
        this.val$sourceListRow = sourceListRow;
        super(string);
    }

    @Override
    public void run() {
        ISourceSlot iSourceSlot = this.this$0.getTerminal().getSourceController().getSelectedSlot();
        if (iSourceSlot != null && iSourceSlot.getSource().getType() == 4) {
            SourceListHMIHandler.access$000(this.this$0).hmi().log(1078071040, "[%1.itemSelected] FilePlayer currently active. Ingore.", (Object)"SourceListHMIHandler");
            this.this$0.getModel(this.val$model).fireEvent(this.val$terminal);
            return;
        }
        ISource iSource = this.this$0.getTerminal().getSourceController().getSource(this.val$sourceListRow.getSourceType());
        ISourceSlot iSourceSlot2 = iSource.getSlot(this.val$sourceListRow.getSlotIdx());
        this.this$0.getTerminal().getSourceController().activateSource(new ActivationContext(iSourceSlot2));
        this.this$0.closeSelectionDrawer(iSourceSlot2);
        this.this$0.getModel(this.val$model).fireEvent(this.val$terminal);
    }
}

