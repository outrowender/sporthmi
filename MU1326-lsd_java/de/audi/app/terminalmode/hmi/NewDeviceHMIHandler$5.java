/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.atip.utils.collections.Predicate;

class NewDeviceHMIHandler$5
implements Predicate {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$5(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    public boolean apply(TMDevice tMDevice) {
        return tMDevice.userAcceptState().is(TMDevice$UserAcceptState.INITIAL);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((TMDevice)object);
    }
}

