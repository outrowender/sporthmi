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

class NewDeviceHMIHandler$13
implements Consumer {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$13(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    public void accept(TMDevice tMDevice) {
        if (tMDevice.wasDisclaimerPreviouslyAccepted()) {
            NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(852766720).setValue(1);
            this.this$0.deviceManager.control(tMDevice).setUserAcceptState(TMDevice$UserAcceptState.DISCLAIMER_ACCEPTED, NewDeviceHMIHandler.access$600((NewDeviceHMIHandler)this.this$0)).setStoreUserAcceptState(NewDeviceHMIHandler.access$600((NewDeviceHMIHandler)this.this$0)).activateDevice();
        } else {
            this.this$0.deviceManager.control(tMDevice).setUserAcceptState(TMDevice$UserAcceptState.TM_SELECTED);
            this.this$0.setDisclaimerDevice(tMDevice);
        }
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4552).setValue(tMDevice.isCarplayDevice() ? 1 : 2);
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4553).resetListener();
        NewDeviceHMIHandler.access$800((NewDeviceHMIHandler)this.this$0);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((TMDevice)object);
    }
}

