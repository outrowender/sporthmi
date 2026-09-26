/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.events.TerminalModeEventBus
 *  de.audi.atip.utils.generics.GList
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.TerminalModeEventBus;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;

class TerminalModeEventBus$12
extends AbstractDispatcherRunnable {
    private final /* synthetic */ GList val$callState;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$12(TerminalModeEventBus terminalModeEventBus, String string, GList gList) {
        this.this$0 = terminalModeEventBus;
        this.val$callState = gList;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.updateCallState]");
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).updateCallState(this.val$callState);
        }
    }
}

