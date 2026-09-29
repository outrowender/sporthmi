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
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.utils.generics.GIterator;

class NewDeviceHMIHandler$15
extends DefaultChoiceListener {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$15(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        NewDeviceHMIHandler.access$100((NewDeviceHMIHandler)this.this$0).log(1078071040, "<<- [%1.keyTyped] SMARTPHONE_CONNECT_POPUP_CLOSED_CHOICE", (Object)"NewDeviceHMIHandler");
        NewDeviceHMIHandler.access$200((NewDeviceHMIHandler)this.this$0, (String)"POPUP CLOSED");
        GIterator gIterator = NewDeviceHMIHandler.access$000((NewDeviceHMIHandler)this.this$0).iterator();
        while (gIterator.hasNext()) {
            this.this$0.deviceManager.control((TMDevice)gIterator.next()).setUserAcceptState(TMDevice$UserAcceptState.NATIVE).deactivateDevice();
        }
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4552).setValue(0);
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).getChoiceModel(4553).resetListener();
    }
}

