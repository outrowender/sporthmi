/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.device.DeviceManager
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager;
import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.atip.utils.generics.Consumer;

class DeviceManager$SMIControllerListener$6
implements Consumer {
    private final /* synthetic */ int val$connectionState;
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$6(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener, int n) {
        this.this$1 = deviceManager$SMIControllerListener;
        this.val$connectionState = n;
    }

    public void accept(TMDeviceID tMDeviceID) {
        DeviceManager.access$200((DeviceManager)DeviceManager$SMIControllerListener.access$800(this.this$1)).getControlFor(tMDeviceID).setConnectionStateByDSIState(this.val$connectionState);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TMDeviceID)object);
    }
}

