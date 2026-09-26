/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class TMDeviceControl$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ TMDevice$UserAcceptState val$userAcceptState;
    private final /* synthetic */ TMDeviceControl this$0;

    TMDeviceControl$4(TMDeviceControl tMDeviceControl, String string, TMDevice$UserAcceptState tMDevice$UserAcceptState) {
        this.this$0 = tMDeviceControl;
        this.val$userAcceptState = tMDevice$UserAcceptState;
        super(string);
    }

    @Override
    public void run() {
        TMDevice$UserAcceptState tMDevice$UserAcceptState = TMDeviceControl.access$600(this.this$0).userAcceptState();
        TMDeviceControl.access$100(this.this$0).log(-2137614336, "[%1.setUserAcceptState] %2 -> %3", (Object)TMDeviceControl.access$000(this.this$0), (Object)tMDevice$UserAcceptState, (Object)this.val$userAcceptState);
        TMDeviceControl.access$600(this.this$0).setUserAcceptState(this.val$userAcceptState);
        if (this.val$userAcceptState.is(TMDevice$UserAcceptState.DISCLAIMER_ACCEPTED)) {
            TMDeviceControl.access$600(this.this$0).setWasDisclaimerPreviouslyAccepted(true);
        }
        TMDeviceControl.access$700(this.this$0).notifyAboutChange(TMDeviceControl.access$600(this.this$0), "setTMActivated");
    }
}

