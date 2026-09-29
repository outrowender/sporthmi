/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.events.TerminalModeEventBus
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.TerminalModeEventBus;
import de.audi.atip.utils.generics.GIterator;

class TerminalModeEventBus$9
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$pBigStage;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$9(TerminalModeEventBus terminalModeEventBus, String string, boolean bl) {
        this.this$0 = terminalModeEventBus;
        this.val$pBigStage = bl;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.updateKombiStage] %1", this.val$pBigStage);
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).updateKombiStage(this.val$pBigStage);
        }
    }
}

