/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$1;

abstract class TelTerminalModeHandler$AbstractState {
    private final /* synthetic */ TelTerminalModeHandler this$0;

    private TelTerminalModeHandler$AbstractState(TelTerminalModeHandler telTerminalModeHandler) {
        this.this$0 = telTerminalModeHandler;
    }

    public abstract void updateActiveDeviceState() {
    }

    public abstract void enter() {
    }

    /* synthetic */ TelTerminalModeHandler$AbstractState(TelTerminalModeHandler telTerminalModeHandler, TelTerminalModeHandler$1 telTerminalModeHandler$1) {
        this(telTerminalModeHandler);
    }
}

