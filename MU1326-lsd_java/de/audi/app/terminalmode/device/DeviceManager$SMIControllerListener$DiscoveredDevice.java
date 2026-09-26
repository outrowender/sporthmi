/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener;
import de.audi.app.terminalmode.device.PhysicalDevice;
import de.audi.app.terminalmode.device.TMDeviceID;

class DeviceManager$SMIControllerListener$DiscoveredDevice {
    public final TMDeviceID tmDeviceID;
    public final PhysicalDevice device;
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    public DeviceManager$SMIControllerListener$DiscoveredDevice(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener, TMDeviceID tMDeviceID, PhysicalDevice physicalDevice) {
        this.this$1 = deviceManager$SMIControllerListener;
        this.tmDeviceID = tMDeviceID;
        this.device = physicalDevice;
    }
}

