/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager$SMIControllerListener;
import de.audi.app.terminalmode.device.TMDeviceID;
import de.audi.atip.utils.collections.Predicate;

class DeviceManager$SMIControllerListener$9
implements Predicate {
    private final /* synthetic */ String val$deviceAddress;
    private final /* synthetic */ DeviceManager$SMIControllerListener this$1;

    DeviceManager$SMIControllerListener$9(DeviceManager$SMIControllerListener deviceManager$SMIControllerListener, String string) {
        this.this$1 = deviceManager$SMIControllerListener;
        this.val$deviceAddress = string;
    }

    public boolean apply(TMDeviceID tMDeviceID) {
        return tMDeviceID.address.equals(this.val$deviceAddress);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDeviceID)object);
    }
}

