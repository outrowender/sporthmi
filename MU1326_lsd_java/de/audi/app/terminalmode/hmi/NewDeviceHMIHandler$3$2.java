/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$3
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.atip.utils.collections.Predicate;

class NewDeviceHMIHandler$3$2
implements Predicate {
    private final /* synthetic */ NewDeviceHMIHandler.3 this$1;

    NewDeviceHMIHandler$3$2(NewDeviceHMIHandler.3 var1_1) {
        this.this$1 = var1_1;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.connectionState().isNot(TMDevice$ConnectionState.ATTACHED);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

