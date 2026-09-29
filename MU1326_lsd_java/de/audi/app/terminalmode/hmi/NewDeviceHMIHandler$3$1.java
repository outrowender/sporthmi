/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$3
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.atip.utils.generics.Matcher;

class NewDeviceHMIHandler$3$1
implements Matcher {
    private final /* synthetic */ NewDeviceHMIHandler.3 this$1;

    NewDeviceHMIHandler$3$1(NewDeviceHMIHandler.3 var1_1) {
        this.this$1 = var1_1;
    }

    public boolean matches(TMDevice tMDevice, TMDevice tMDevice2) {
        return tMDevice.getUniqueID().equals(tMDevice2.getUniqueID());
    }

    @Override
    public /* synthetic */ boolean matches(Object object, Object object2) {
        return this.matches((TMDevice)object, (TMDevice)object2);
    }
}

