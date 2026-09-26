/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler$1;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

class TelIntellicallHandler$IntelliCallTerminalModeUpdateListener
extends DefaultTerminalModeUpdateListener {
    private final /* synthetic */ TelIntellicallHandler this$0;

    private TelIntellicallHandler$IntelliCallTerminalModeUpdateListener(TelIntellicallHandler telIntellicallHandler) {
        this.this$0 = telIntellicallHandler;
    }

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        TelIntellicallHandler.access$1500(this.this$0).log(1078071040, "[TelTerminalModeHandler#updateActiveDeviceState] pActiveDevice=%1", (Object)terminalModeDevice);
        TelIntellicallHandler.access$1602(this.this$0, terminalModeDevice);
    }

    @Override
    public void updateTMVideoFocus(boolean bl) {
        TelIntellicallHandler.access$1700(this.this$0).log(1078071040, "[TelTerminalModeHandler#updateTMVideoFocus] pVideoFocus=%1", bl);
        TelIntellicallHandler.access$1802(this.this$0, bl);
    }

    /* synthetic */ TelIntellicallHandler$IntelliCallTerminalModeUpdateListener(TelIntellicallHandler telIntellicallHandler, TelIntellicallHandler$1 telIntellicallHandler$1) {
        this(telIntellicallHandler);
    }
}

