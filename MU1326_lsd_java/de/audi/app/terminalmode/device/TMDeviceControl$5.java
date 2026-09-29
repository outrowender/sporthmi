/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class TMDeviceControl$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$storeAcceptSelection;
    private final /* synthetic */ TMDeviceControl this$0;

    TMDeviceControl$5(TMDeviceControl tMDeviceControl, String string, boolean bl) {
        this.this$0 = tMDeviceControl;
        this.val$storeAcceptSelection = bl;
        super(string);
    }

    @Override
    public void run() {
        TMDeviceControl.access$100(this.this$0).log(1078071040, "[%1.setStoreUserAcceptState]  store=%2", (Object)TMDeviceControl.access$000(this.this$0), (Object)String.valueOf(this.val$storeAcceptSelection));
        TMDeviceControl.access$600(this.this$0).setStoreUserAcceptState(this.val$storeAcceptSelection);
    }
}

