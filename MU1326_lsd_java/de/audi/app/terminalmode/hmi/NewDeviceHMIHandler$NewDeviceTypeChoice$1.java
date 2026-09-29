/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.atip.utils.collections.Predicate;

final class NewDeviceHMIHandler$NewDeviceTypeChoice$1
implements Predicate {
    NewDeviceHMIHandler$NewDeviceTypeChoice$1() {
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.smartphoneType().is(SmartphoneManager$SmartphoneType.CARLIFE);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

