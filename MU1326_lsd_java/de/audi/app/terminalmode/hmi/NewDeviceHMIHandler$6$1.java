/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$6;
import de.audi.atip.utils.collections.Predicate;

class NewDeviceHMIHandler$6$1
implements Predicate {
    private final /* synthetic */ NewDeviceHMIHandler$6 this$1;

    NewDeviceHMIHandler$6$1(NewDeviceHMIHandler$6 newDeviceHMIHandler$6) {
        this.this$1 = newDeviceHMIHandler$6;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.smartphoneType().isOneOf(SmartphoneManager$SmartphoneType.ANDROIDAUTO2, SmartphoneManager$SmartphoneType.CARPLAY);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

