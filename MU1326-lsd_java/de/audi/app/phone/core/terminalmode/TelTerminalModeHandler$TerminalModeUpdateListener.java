/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.terminalmode;

import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler;
import de.audi.app.phone.core.terminalmode.TelTerminalModeHandler$1;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

class TelTerminalModeHandler$TerminalModeUpdateListener
extends DefaultTerminalModeUpdateListener {
    private final /* synthetic */ TelTerminalModeHandler this$0;

    private TelTerminalModeHandler$TerminalModeUpdateListener(TelTerminalModeHandler telTerminalModeHandler) {
        this.this$0 = telTerminalModeHandler;
    }

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        TelTerminalModeHandler.access$1900(this.this$0).log(1078071040, "[TelTerminalModeHandler#updateActiveDeviceState] pActiveDevice=%1", (Object)terminalModeDevice);
        TelTerminalModeHandler.access$602(this.this$0, terminalModeDevice);
        if (terminalModeDevice.isActive() && terminalModeDevice.getConnectionMethod() == 1) {
            this.showDisclaimer();
            TelTerminalModeHandler.access$2000(this.this$0, 1327965696).setStatus(0);
        } else {
            this.removeDisclaimer();
            TelTerminalModeHandler.access$2100(this.this$0, 1327965696).setStatus(1);
        }
        TelTerminalModeHandler.access$2200(this.this$0).updateActiveDeviceState();
    }

    private void showDisclaimer() {
        TelTerminalModeHandler.access$2300(this.this$0, -107543552).setValue(1);
        TelTerminalModeHandler.access$2400(this.this$0).log(-2137614336, "[TelTerminalModeHandler#showCarPlayDisclaimer] showing disclaimer. Model with ID=%1 is set to [%2].", (long)0, 1L);
    }

    private void removeDisclaimer() {
        TelTerminalModeHandler.access$2500(this.this$0, -107543552).setValue(0);
        TelTerminalModeHandler.access$2600(this.this$0).log(-2137614336, "[TelTerminalModeHandler#showCarPlayDisclaimer] removing disclaimer. Model with ID=%1 is set to [%2].", (long)0, 0L);
    }

    /* synthetic */ TelTerminalModeHandler$TerminalModeUpdateListener(TelTerminalModeHandler telTerminalModeHandler, TelTerminalModeHandler$1 telTerminalModeHandler$1) {
        this(telTerminalModeHandler);
    }
}

