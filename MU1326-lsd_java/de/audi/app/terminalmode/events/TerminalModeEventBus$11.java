/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.events.TerminalModeEventBus
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.events.TerminalModeEventBus;
import de.audi.atip.utils.generics.GIterator;

class TerminalModeEventBus$11
extends AbstractDispatcherRunnable {
    private final /* synthetic */ PhoneStateChangedEvent val$phoneState;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$11(TerminalModeEventBus terminalModeEventBus, String string, PhoneStateChangedEvent phoneStateChangedEvent) {
        this.this$0 = terminalModeEventBus;
        this.val$phoneState = phoneStateChangedEvent;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.updatePhoneState]");
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).updatePhoneState(this.val$phoneState);
        }
    }
}

