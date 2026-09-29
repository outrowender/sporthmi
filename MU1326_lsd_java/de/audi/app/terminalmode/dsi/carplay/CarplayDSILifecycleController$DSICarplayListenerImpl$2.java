/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;

class CarplayDSILifecycleController$DSICarplayListenerImpl$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ CarplayDSILifecycleController$DSICarplayListenerImpl this$0;

    CarplayDSILifecycleController$DSICarplayListenerImpl$2(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl, String string, int n) {
        this.this$0 = carplayDSILifecycleController$DSICarplayListenerImpl;
        this.val$state = n;
        super(string);
    }

    @Override
    public void run() {
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).log(1078071040, "<- [%1.updateTextInputState] %2", (Object)"DSICarplayListenerImpl", (long)this.val$state);
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4600(this.this$0).updateTextInputState(1 == this.val$state);
    }
}

