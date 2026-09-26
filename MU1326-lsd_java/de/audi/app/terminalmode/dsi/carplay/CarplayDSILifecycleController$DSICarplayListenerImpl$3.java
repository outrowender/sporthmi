/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;
import de.audi.app.terminalmode.events.CallStateChangedEvent;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.carplay.CallState;

class CarplayDSILifecycleController$DSICarplayListenerImpl$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ CallState[] val$callState;
    private final /* synthetic */ CarplayDSILifecycleController$DSICarplayListenerImpl this$0;

    CarplayDSILifecycleController$DSICarplayListenerImpl$3(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl, String string, CallState[] callStateArray) {
        this.this$0 = carplayDSILifecycleController$DSICarplayListenerImpl;
        this.val$callState = callStateArray;
        super(string);
    }

    @Override
    public void run() {
        GList gList = Generics.newArrayListWithCapacity((int)this.val$callState.length);
        for (int i2 = 0; i2 < this.val$callState.length; ++i2) {
            gList.add((Object)new CallStateChangedEvent(this.val$callState[i2]));
        }
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).log(1078071040, "<- [%1.updateCallState]", (Object)"DSICarplayListenerImpl");
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4700(this.this$0).updateCallState(gList);
    }
}

