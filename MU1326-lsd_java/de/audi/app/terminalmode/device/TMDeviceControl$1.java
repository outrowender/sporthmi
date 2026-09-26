/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;

class TMDeviceControl$1
implements Runnable {
    private final /* synthetic */ TMDeviceControl this$0;

    TMDeviceControl$1(TMDeviceControl tMDeviceControl) {
        this.this$0 = tMDeviceControl;
    }

    @Override
    public void run() {
        TMDeviceControl.access$700(this.this$0).requestActivation(this.this$0);
    }
}

