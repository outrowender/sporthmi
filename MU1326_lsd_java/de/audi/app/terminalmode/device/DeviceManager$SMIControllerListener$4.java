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

class DeviceManager$SMIControllerListener$4
implements Consumer {
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$4(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener) {
        this.this$1 = deviceManager$SMIControllerListener;
    }

    public void accept(TMDeviceID tMDeviceID) {
        DeviceManager.access$200((DeviceManager)DeviceManager$SMIControllerListener.access$800(this.this$1)).getControlFor(tMDeviceID).deviceIsNotDiscovered();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TMDeviceID)object);
    }
}

