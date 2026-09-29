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
import de.audi.app.terminalmode.events.TrackDataChangedEvent;
import de.audi.atip.utils.generics.GIterator;

class TerminalModeEventBus$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ TrackDataChangedEvent val$trackDataChangedEvent;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$1(TerminalModeEventBus terminalModeEventBus, String string, TrackDataChangedEvent trackDataChangedEvent) {
        this.this$0 = terminalModeEventBus;
        this.val$trackDataChangedEvent = trackDataChangedEvent;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.updateNowPlayingData] %1", (Object)this.val$trackDataChangedEvent);
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).updateNowPlayingData(this.val$trackDataChangedEvent);
        }
    }
}

