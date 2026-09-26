/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler$Properties;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

public class TerminalAndScreenModeHandler$UpdateTerminalModeSafetyLeashRunnable
implements Runnable {
    private final TerminalAndScreenModeTuple expectedTuple;
    private final /* synthetic */ TerminalAndScreenModeHandler this$0;

    public TerminalAndScreenModeHandler$UpdateTerminalModeSafetyLeashRunnable(TerminalAndScreenModeHandler terminalAndScreenModeHandler, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        this.this$0 = terminalAndScreenModeHandler;
        this.expectedTuple = terminalAndScreenModeTuple;
    }

    @Override
    public void run() {
        TerminalAndScreenModeHandler.access$700((TerminalAndScreenModeHandler)this.this$0).lcDSI.log(10000, "[UpdateTerminalModeSafetyLeashRunnable] No update for %1 from DSI. Fake it now!", (Object)this.expectedTuple);
        TerminalAndScreenModeHandler$Properties.access$500(TerminalAndScreenModeHandler.access$400(this.this$0)).accept(this.expectedTuple);
    }
}

