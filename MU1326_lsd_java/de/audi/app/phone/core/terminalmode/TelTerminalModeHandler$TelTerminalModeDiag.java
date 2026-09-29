/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

class TelTerminalModeHandler$TelTerminalModeDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelTerminalModeHandler this$0;

    TelTerminalModeHandler$TelTerminalModeDiag(TelTerminalModeHandler telTerminalModeHandler) {
        this.this$0 = telTerminalModeHandler;
    }

    public void cmdUpdateActiveDeviceState(int n, boolean bl) {
        TerminalModeDevice terminalModeDevice = new TerminalModeDevice("devID", "TMdevice", n, bl, true, bl);
        TelTerminalModeHandler.access$2700(this.this$0).updateActiveDeviceState(terminalModeDevice);
    }
}

