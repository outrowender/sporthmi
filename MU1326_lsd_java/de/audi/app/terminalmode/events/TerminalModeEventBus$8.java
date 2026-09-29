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

class TerminalModeEventBus$8
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$audioAvailable;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$8(TerminalModeEventBus terminalModeEventBus, String string, boolean bl) {
        this.this$0 = terminalModeEventBus;
        this.val$audioAvailable = bl;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.mediaAudioAvailable] %1", this.val$audioAvailable);
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).mediaAudioAvailable(this.val$audioAvailable);
        }
    }
}

