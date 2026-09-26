/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;

class TMDeviceControl$2
implements Runnable {
    private final /* synthetic */ TMDeviceControl this$0;

    TMDeviceControl$2(TMDeviceControl tMDeviceControl) {
        this.this$0 = tMDeviceControl;
    }

    @Override
    public void run() {
        TMDeviceControl.access$700(this.this$0).requestOtherModeActivation(this.this$0);
    }
}

