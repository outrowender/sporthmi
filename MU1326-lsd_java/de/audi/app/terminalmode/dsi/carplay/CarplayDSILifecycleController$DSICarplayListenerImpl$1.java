/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.dsi.carplay.CarplayDSILifecycleController$DSICarplayListenerImpl;

class CarplayDSILifecycleController$DSICarplayListenerImpl$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IAppState[] val$appStateList;
    private final /* synthetic */ IResource[] val$resourceList;
    private final /* synthetic */ CarplayDSILifecycleController$DSICarplayListenerImpl this$0;

    CarplayDSILifecycleController$DSICarplayListenerImpl$1(CarplayDSILifecycleController$DSICarplayListenerImpl carplayDSILifecycleController$DSICarplayListenerImpl, String string, IAppState[] iAppStateArray, IResource[] iResourceArray) {
        this.this$0 = carplayDSILifecycleController$DSICarplayListenerImpl;
        this.val$appStateList = iAppStateArray;
        this.val$resourceList = iResourceArray;
        super(string);
    }

    @Override
    public void run() {
        if (CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).isDebug()) {
            CarplayDSILifecycleController$DSICarplayListenerImpl.access$4500(this.this$0).log(1078071040, "<- [%1.updateMode] %2 %3", (Object)"DSICarplayListenerImpl", (Object)TerminalModeUtils.logAppStates((IAppState[])this.val$appStateList), (Object)TerminalModeUtils.logResources((IResource[])this.val$resourceList));
        }
        CarplayDSILifecycleController$DSICarplayListenerImpl.access$4600(this.this$0).updateMode(this.val$appStateList, this.val$resourceList);
    }
}

