/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

class NewDeviceHMIHandler$12
extends DefaultChoiceListener {
    private final /* synthetic */ ChoiceModelApp val$storePrivacyChoice;
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$12(NewDeviceHMIHandler newDeviceHMIHandler, ChoiceModelApp choiceModelApp) {
        this.this$0 = newDeviceHMIHandler;
        this.val$storePrivacyChoice = choiceModelApp;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.val$storePrivacyChoice.setValue(this.val$storePrivacyChoice.getValue() == 0 ? 1 : 0);
        NewDeviceHMIHandler.access$100((NewDeviceHMIHandler)this.this$0).log(1078071040, "<<- [%1.itemSelected] checked=%2", (Object)"NewDeviceHMIHandler", (Object)String.valueOf(this.val$storePrivacyChoice.getValue() == 1));
        NewDeviceHMIHandler.access$700((NewDeviceHMIHandler)this.this$0).fireEventOnModel(n);
    }
}

