/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.events.TerminalModeEventBus
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.TerminalModeEventBus;
import de.audi.atip.utils.generics.GIterator;

class TerminalModeEventBus$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ TMDevice val$tmDevice;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$5(TerminalModeEventBus terminalModeEventBus, String string, TMDevice tMDevice) {
        this.this$0 = terminalModeEventBus;
        this.val$tmDevice = tMDevice;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.readyForActivation] %1", (Object)this.val$tmDevice);
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).readyForActivation(this.val$tmDevice);
        }
    }
}

