/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.source.ToggleSourceHandler;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISourceSlot;

class ToggleSourceHandler$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ISourceSlot val$focusedEntry;
    private final /* synthetic */ ToggleSourceHandler this$0;

    ToggleSourceHandler$1(ToggleSourceHandler toggleSourceHandler, String string, ISourceSlot iSourceSlot) {
        this.this$0 = toggleSourceHandler;
        this.val$focusedEntry = iSourceSlot;
        super(string);
    }

    @Override
    public void run() {
        boolean bl;
        ToggleSourceHandler.access$000(this.this$0).hmi().log(1078071040, "[%1.toggleFocusedEntry] Activate source.", (Object)"ToggleSourceHandler");
        boolean bl2 = bl = !((Object)this.val$focusedEntry).equals(this.this$0.getTerminal().getSourceController().getSelectedSlot());
        if (bl) {
            this.this$0.getChoiceModel(1980760832).setValue(1);
        } else {
            this.this$0.getChoiceModel(1980760832).setValue(0);
        }
        this.this$0.getTerminal().getSourceController().activateSource(new ActivationContext(this.val$focusedEntry));
        this.this$0.getChoiceModel(1712194304).fireEvent(this.this$0.getTerminal().getTerminalID());
    }
}

