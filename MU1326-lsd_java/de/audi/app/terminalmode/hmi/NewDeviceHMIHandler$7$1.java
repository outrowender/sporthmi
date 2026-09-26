/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$7;
import de.audi.atip.utils.collections.Predicate;

class NewDeviceHMIHandler$7$1
implements Predicate {
    private final /* synthetic */ NewDeviceHMIHandler$7 this$1;

    NewDeviceHMIHandler$7$1(NewDeviceHMIHandler$7 newDeviceHMIHandler$7) {
        this.this$1 = newDeviceHMIHandler$7;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.smartphoneType().is(SmartphoneManager$SmartphoneType.CARLIFE);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

