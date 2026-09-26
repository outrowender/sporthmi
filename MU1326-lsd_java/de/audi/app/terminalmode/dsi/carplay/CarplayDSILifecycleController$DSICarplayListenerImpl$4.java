/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;

class CarplayDSILifecycleController$DSICarplayListenerImpl$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$duration;
    private final /* synthetic */ double val$volume;
    private final /* synthetic */ CarplayDSILifecycleController$DSICarplayListenerImpl this$0;

    CarplayDSILifecycleController$DSICarplayListenerImpl$4(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl, String string, int n, double d2) {
        this.this$0 = carplayDSILifecycleController$DSICarplayListenerImpl;
        this.val$duration = n;
        this.val$volume = d2;
        super(string);
    }

    @Override
    public void run() {
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).log(1078071040, "<- [%1.duckAudio]", (Object)"DSICarplayListenerImpl");
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4600(this.this$0).duckAudio(this.val$duration, this.val$volume);
    }
}

