/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.AbstractToggleSourceHandler;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISourceSlot;

class AbstractToggleSourceHandler$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ISourceSlot val$pEntry;
    private final /* synthetic */ AbstractToggleSourceHandler this$0;

    AbstractToggleSourceHandler$1(AbstractToggleSourceHandler abstractToggleSourceHandler, String string, ISourceSlot iSourceSlot) {
        this.this$0 = abstractToggleSourceHandler;
        this.val$pEntry = iSourceSlot;
        super(string);
    }

    @Override
    public void run() {
        AbstractToggleSourceHandler.access$000(this.this$0).main().log(1078071040, "[%1.activate] '%2'", (Object)"AbstractToggleSourceHandler", (Object)this.val$pEntry);
        this.this$0.getTerminal().getSourceController().activateSource(new ActivationContext(this.val$pEntry));
    }
}

