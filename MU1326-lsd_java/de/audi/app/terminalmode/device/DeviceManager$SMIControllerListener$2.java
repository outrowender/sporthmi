/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.device.DeviceManager
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager;
import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener;
import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener$DiscoveredDevice;
import de.audi.atip.utils.collections.Predicate;

class DeviceManager$SMIControllerListener$2
implements Predicate {
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$2(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener) {
        this.this$1 = deviceManager$SMIControllerListener;
    }

    public boolean apply(DeviceManager$SMIControllerListener$DiscoveredDevice deviceManager$SMIControllerListener$DiscoveredDevice) {
        return !DeviceManager.access$200((DeviceManager)DeviceManager$SMIControllerListener.access$800(this.this$1)).getAddresses().contains((Object)deviceManager$SMIControllerListener$DiscoveredDevice.tmDeviceID);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((DeviceManager$SMIControllerListener$DiscoveredDevice)object);
    }
}

