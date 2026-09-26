/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.device.DeviceManager
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.DeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.collections.Predicate;

class DeviceManager$2
implements Predicate {
    private final /* synthetic */ DeviceManager this$0;

    DeviceManager$2(DeviceManager deviceManager) {
        this.this$0 = deviceManager;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.smartphoneType().isNot(SmartphoneManager$SmartphoneType.UNKNOWN);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

