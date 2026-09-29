/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;

class TelTerminalModeHandler$1
implements IGlobalTelephoneStateListener {
    private final /* synthetic */ TelTerminalModeHandler this$0;

    TelTerminalModeHandler$1(TelTerminalModeHandler telTerminalModeHandler) {
        this.this$0 = telTerminalModeHandler;
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        TelTerminalModeHandler.access$300(this.this$0).getGlobalTelephoneStateManager().removeListener(this);
        TelTerminalModeHandler.access$400(this.this$0).startService();
    }
}

