/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.device.DeviceManager
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.DeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.atip.utils.generics.Consumer;

class DeviceManager$1
implements Consumer {
    private final /* synthetic */ DeviceManager this$0;

    DeviceManager$1(DeviceManager deviceManager) {
        this.this$0 = deviceManager;
    }

    public void accept(TMDevice tMDevice) {
        tMDevice.setConnectionState(TMDevice$ConnectionState.INVALID);
        DeviceManager.access$200((DeviceManager)this.this$0).addTmDevice(tMDevice, null);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TMDevice)object);
    }
}

