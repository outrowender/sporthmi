/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$1;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$AbstractState;

class TelTerminalModeHandler$TMInactiveState
extends TelTerminalModeHandler$AbstractState {
    private final /* synthetic */ TelTerminalModeHandler this$0;

    private TelTerminalModeHandler$TMInactiveState(TelTerminalModeHandler telTerminalModeHandler) {
        this.this$0 = telTerminalModeHandler;
        super(telTerminalModeHandler, null);
    }

    @Override
    public void updateActiveDeviceState() {
        if (TelTerminalModeHandler.access$600(this.this$0).isActive()) {
            TelTerminalModeHandler.access$900(this.this$0, TelTerminalModeHandler.access$1400(this.this$0));
        } else {
            TelTerminalModeHandler.access$1500(this.this$0).log(-2137614336, "[TelTerminalModeHandler(TMInactiveState)#updateActiveDeviceState] CP/AA session is inactive: %1", (Object)this.toString());
        }
    }

    @Override
    public void enter() {
        if (TelTerminalModeHandler.access$1000(this.this$0).isSimCardInserted() && !TelTerminalModeHandler.access$1000(this.this$0).isESIMActive() && TelTerminalModeHandler.access$1000(this.this$0).getNadMode() != 1 && TelTerminalModeHandler.access$1100(this.this$0) == 1) {
            TelTerminalModeHandler.access$1600(this.this$0).log(1078071040, "[TelTerminalModeHandler(TMInactiveState)#enter] changing NadMode back to V&D");
            TelTerminalModeHandler.access$1700(this.this$0).getTelephoneDSIAccess().requestSetNadMode(1, 0);
        } else {
            TelTerminalModeHandler.access$1800(this.this$0).log(1078071040, "[TelTerminalModeHandler(TMInactiveState)#enter] current NadMode=%1 stays unchanged, nadModeBeforeTM=%2", (long)TelTerminalModeHandler.access$1000(this.this$0).getNadMode(), (long)TelTerminalModeHandler.access$1100(this.this$0));
        }
    }

    public String toString() {
        return "TMInactiveState";
    }

    /* synthetic */ TelTerminalModeHandler$TMInactiveState(TelTerminalModeHandler telTerminalModeHandler, TelTerminalModeHandler$1 telTerminalModeHandler$1) {
        this(telTerminalModeHandler);
    }
}

