/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.hmi.NewDeviceHMIHandler
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler;
import de.audi.app.terminalmode.hmi.NewDeviceHMIHandler$6$1;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.Consumer;

class NewDeviceHMIHandler$6
implements Consumer {
    private final /* synthetic */ NewDeviceHMIHandler this$0;

    NewDeviceHMIHandler$6(NewDeviceHMIHandler newDeviceHMIHandler) {
        this.this$0 = newDeviceHMIHandler;
    }

    public void accept(ButtonModelApp buttonModelApp) {
        NewDeviceHMIHandler.access$100((NewDeviceHMIHandler)this.this$0).log(1078071040, "<<- [%1.keyTyped] Smartphone button", (Object)"NewDeviceHMIHandler");
        NewDeviceHMIHandler.access$400((NewDeviceHMIHandler)this.this$0, (Predicate)new NewDeviceHMIHandler$6$1(this));
        buttonModelApp.fireEvent(0);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((ButtonModelApp)object);
    }
}

