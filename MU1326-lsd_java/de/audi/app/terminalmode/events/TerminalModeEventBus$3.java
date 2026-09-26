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
import de.audi.app.terminalmode.events.TrackPlayPositionEvent;
import de.audi.atip.utils.generics.GIterator;

class TerminalModeEventBus$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ TrackPlayPositionEvent val$trackPlayPositionEvent;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$3(TerminalModeEventBus terminalModeEventBus, String string, TrackPlayPositionEvent trackPlayPositionEvent) {
        this.this$0 = terminalModeEventBus;
        this.val$trackPlayPositionEvent = trackPlayPositionEvent;
        super(string);
    }

    @Override
    public void run() {
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).updatePlayPosition(this.val$trackPlayPositionEvent);
        }
    }
}

