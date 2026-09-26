/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;

class CarplayDSILifecycleController$DSICarplayListenerImpl$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$audioType;
    private final /* synthetic */ CarplayDSILifecycleController$DSICarplayListenerImpl this$0;

    CarplayDSILifecycleController$DSICarplayListenerImpl$7(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl, String string, int n) {
        this.this$0 = carplayDSILifecycleController$DSICarplayListenerImpl;
        this.val$audioType = n;
        super(string);
    }

    @Override
    public void run() {
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).log(1078071040, "<- [%1.updateMainAudioType] %2", (Object)"DSICarplayListenerImpl", (long)this.val$audioType);
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4600(this.this$0).updateMainAudioType(this.val$audioType);
    }
}

