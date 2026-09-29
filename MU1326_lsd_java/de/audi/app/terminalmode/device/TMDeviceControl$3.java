/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class TMDeviceControl$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ TMDeviceControl this$0;

    TMDeviceControl$3(TMDeviceControl tMDeviceControl, String string) {
        this.this$0 = tMDeviceControl;
        super(string);
    }

    @Override
    public void run() {
        TMDeviceControl.access$700(this.this$0).requestDeactivation(this.this$0);
    }
}

