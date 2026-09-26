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
import de.audi.atip.utils.generics.Consumer;

class NewDeviceHMIHandler$14
implements Consumer {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$14(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    public void accept(TMDevice tMDevice) {
        NewDeviceHMIHandler.access$100((NewDeviceHMIHandler)this.this$0).log(-2137614336, "[%1.keyTyped] Smartphone button, deactivating carlife", (Object)"NewDeviceHMIHandler");
        this.this$0.deviceManager.control(tMDevice).setUserAcceptState(TMDevice$UserAcceptState.NATIVE_SELECTED).setStoreUserAcceptState(NewDeviceHMIHandler.access$600((NewDeviceHMIHandler)this.this$0)).deactivateDevice();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TMDevice)object);
    }
}

