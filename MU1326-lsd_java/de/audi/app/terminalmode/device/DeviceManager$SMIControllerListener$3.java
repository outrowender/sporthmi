/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener;
import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener$DiscoveredDevice;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.atip.utils.generics.Function;

class DeviceManager$SMIControllerListener$3
implements Function {
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$3(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener) {
        this.this$1 = deviceManager$SMIControllerListener;
    }

    public TMDeviceID apply(DeviceManager$SMIControllerListener$DiscoveredDevice deviceManager$SMIControllerListener$DiscoveredDevice) {
        return deviceManager$SMIControllerListener$DiscoveredDevice.tmDeviceID;
    }

    @Override
    public /* synthetic */ Object apply(Object object) {
        return this.apply((DeviceManager$SMIControllerListener$DiscoveredDevice)object);
    }
}

