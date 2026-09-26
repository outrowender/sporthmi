/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$1;

final class TerminalModeBapCombi$AudioStateListener
implements IAudioStateListener {
    private final /* synthetic */ TerminalModeBapCombi this$0;

    private TerminalModeBapCombi$AudioStateListener(TerminalModeBapCombi terminalModeBapCombi) {
        this.this$0 = terminalModeBapCombi;
    }

    @Override
    public void audioStateChanged(AudioConnectionState audioConnectionState) {
    }

    @Override
    public void audioFocusChanged(boolean bl) {
        TerminalModeBapCombi.access$700(this.this$0).log(-2137614336, "[%1.audioFocusChanged] %2", (Object)"TerminalModeBapCombi", (Object)new Boolean(bl));
        if (bl) {
            TerminalModeBapCombi.access$800(this.this$0).getEventBus().registerListener(TerminalModeBapCombi.access$600(this.this$0));
            TerminalModeBapCombi.access$1000(this.this$0).sendCachedEvents();
        } else {
            TerminalModeBapCombi.access$800(this.this$0).getEventBus().unregisterListener(TerminalModeBapCombi.access$600(this.this$0));
        }
    }

    /* synthetic */ TerminalModeBapCombi$AudioStateListener(TerminalModeBapCombi terminalModeBapCombi, TerminalModeBapCombi$1 terminalModeBapCombi$1) {
        this(terminalModeBapCombi);
    }
}

