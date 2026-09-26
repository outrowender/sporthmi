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
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GIterator;

class NewDeviceHMIHandler$9
implements Consumer {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$9(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    public void accept(ButtonModelApp buttonModelApp) {
        NewDeviceHMIHandler.access$100((NewDeviceHMIHandler)this.this$0).log(1078071040, "<<- [%1.keyTyped] Native button", (Object)"NewDeviceHMIHandler");
        GIterator gIterator = NewDeviceHMIHandler.access$000((NewDeviceHMIHandler)this.this$0).iterator();
        while (gIterator.hasNext()) {
            this.this$0.deviceManager.control((TMDevice)gIterator.next()).setUserAcceptState(TMDevice$UserAcceptState.NATIVE_SELECTED).setStoreUserAcceptState(NewDeviceHMIHandler.access$600((NewDeviceHMIHandler)this.this$0)).deactivateDevice();
        }
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4552).setValue(0);
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4553).resetListener();
        NewDeviceHMIHandler.access$800((NewDeviceHMIHandler)this.this$0);
        buttonModelApp.fireEvent(0);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((ButtonModelApp)object);
    }
}

