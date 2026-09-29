/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;

class CarplayDSILifecycleController$DSICarplayListenerImpl$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ CarplayDSILifecycleController$DSICarplayListenerImpl this$0;

    CarplayDSILifecycleController$DSICarplayListenerImpl$6(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl, String string) {
        this.this$0 = carplayDSILifecycleController$DSICarplayListenerImpl;
        super(string);
    }

    @Override
    public void run() {
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).log(1078071040, "<- [%1.oemAppSelected]", (Object)"DSICarplayListenerImpl");
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4600(this.this$0).oemAppSelected();
    }
}

