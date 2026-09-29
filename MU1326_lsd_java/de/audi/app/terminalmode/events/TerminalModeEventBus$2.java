/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.events.TerminalModeEventBus
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.events.IEventListener;
import de.audi.app.terminalmode.events.PlaybackInfoChangedEvent;
import de.audi.app.terminalmode.events.TerminalModeEventBus;
import de.audi.atip.utils.generics.GIterator;

class TerminalModeEventBus$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ PlaybackInfoChangedEvent val$playbackInfoChanged;
    private final /* synthetic */ TerminalModeEventBus this$0;

    TerminalModeEventBus$2(TerminalModeEventBus terminalModeEventBus, String string, PlaybackInfoChangedEvent playbackInfoChangedEvent) {
        this.this$0 = terminalModeEventBus;
        this.val$playbackInfoChanged = playbackInfoChangedEvent;
        super(string);
    }

    @Override
    public void run() {
        TerminalModeEventBus.access$000((TerminalModeEventBus)this.this$0).log(1078071040, "<*> [TerminalModeEventBus.updatePlaybackInfo] %1", (Object)this.val$playbackInfoChanged);
        GIterator gIterator = TerminalModeEventBus.access$100((TerminalModeEventBus)this.this$0).iterator();
        while (gIterator.hasNext()) {
            ((IEventListener)gIterator.next()).updatePlaybackInfo(this.val$playbackInfoChanged);
        }
    }
}

