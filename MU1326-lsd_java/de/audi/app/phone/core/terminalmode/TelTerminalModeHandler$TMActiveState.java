/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$1;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$AbstractState;

class TelTerminalModeHandler$TMActiveState
extends TelTerminalModeHandler$AbstractState {
    private final /* synthetic */ TelTerminalModeHandler this$0;

    private TelTerminalModeHandler$TMActiveState(TelTerminalModeHandler telTerminalModeHandler) {
        this.this$0 = telTerminalModeHandler;
        super(telTerminalModeHandler, null);
    }

    @Override
    public void updateActiveDeviceState() {
        if (TelTerminalModeHandler.access$600(this.this$0).isActive()) {
            TelTerminalModeHandler.access$700(this.this$0).log(-2137614336, "[TelTerminalModeHandler(TMActiveState)#updateActiveDeviceState] CP/AA session is already active");
        } else {
            TelTerminalModeHandler.access$900(this.this$0, TelTerminalModeHandler.access$800(this.this$0));
        }
    }

    @Override
    public void enter() {
        int n = TelTerminalModeHandler.access$1000(this.this$0).getNadMode();
        TelTerminalModeHandler.access$1102(this.this$0, n);
        TelTerminalModeHandler.access$1200(this.this$0).log(-2137614336, "[TelTerminalModeHandler(TMActiveState)#enter] current nadMode: %1", (long)n);
        if (this.isHangupCallNeeded()) {
            TelTerminalModeHandler.access$1300(this.this$0).getCallControl().hangupCall(0);
        }
    }

    private boolean isHangupCallNeeded() {
        if (TelTerminalModeHandler.access$1000(this.this$0) != null) {
            boolean bl;
            boolean bl2;
            boolean bl3 = bl2 = TelTerminalModeHandler.access$1000(this.this$0).getNadInstanceState() != null;
            boolean bl4 = bl2 ? !TelTerminalModeHandler.access$1000(this.this$0).getNadInstanceState().getCallState().isIdle() : (bl = false);
            if (bl2 && bl) {
                return !this.isSomeSpecificCallAvailable(TelTerminalModeHandler.access$1000(this.this$0).getNadInstanceState().getCallState());
            }
        }
        return false;
    }

    private boolean isSomeSpecificCallAvailable(CallStateStruct callStateStruct) {
        return callStateStruct.isHasBCall() || callStateStruct.isHasBreakdownCall() || callStateStruct.isHasCCall() || callStateStruct.isHasEmergencyCall() || callStateStruct.isHasInfoCall() || callStateStruct.isHasOperatorCall() || callStateStruct.isHasPCall();
    }

    public String toString() {
        return "TMActiveState";
    }

    /* synthetic */ TelTerminalModeHandler$TMActiveState(TelTerminalModeHandler telTerminalModeHandler, TelTerminalModeHandler$1 telTerminalModeHandler$1) {
        this(telTerminalModeHandler);
    }
}

