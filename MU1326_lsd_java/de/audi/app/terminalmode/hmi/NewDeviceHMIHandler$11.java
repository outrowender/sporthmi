/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.device.TMDevice$UserAcceptState;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.utils.generics.Consumer;

class NewDeviceHMIHandler$11
implements Consumer {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$11(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    public void accept(ButtonModelApp buttonModelApp) {
        NewDeviceHMIHandler.access$100((NewDeviceHMIHandler)this.this$0).log(1078071040, "<<- [%1.keyTyped] Disclaimer Decline", (Object)"NewDeviceHMIHandler");
        this.this$0.deviceManager.control(NewDeviceHMIHandler.access$900((NewDeviceHMIHandler)this.this$0)).setUserAcceptState(TMDevice$UserAcceptState.NATIVE).deactivateDevice();
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4552).setValue(0);
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4553).resetListener();
        buttonModelApp.fireEvent(0);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((ButtonModelApp)object);
    }
}

