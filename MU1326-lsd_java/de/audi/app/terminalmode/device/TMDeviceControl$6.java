/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;

class TMDeviceControl$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ TMDeviceControl this$0;

    TMDeviceControl$6(TMDeviceControl tMDeviceControl, String string) {
        this.this$0 = tMDeviceControl;
        super(string);
    }

    @Override
    public void run() {
        TMDeviceControl.access$5500(this.this$0).sendMessage(14);
    }
}

