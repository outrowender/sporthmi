/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.utils.reactive.observables.Observables$Combinator4;

class CarlifeDSIAppNotInstalledManager$2
implements Observables$Combinator4 {
    private final /* synthetic */ CarlifeDSIAppNotInstalledManager this$0;

    CarlifeDSIAppNotInstalledManager$2(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        this.this$0 = carlifeDSIAppNotInstalledManager;
    }

    public Boolean combine(Boolean bl, ResourceOwner resourceOwner, TMDevice tMDevice, ResourceOwner resourceOwner2) {
        if (!tMDevice.isCarlifeDevice()) {
            return new Boolean(false);
        }
        boolean bl2 = bl != false && ResourceOwner.DEVICE.is(resourceOwner) && null == CarlifeDSIAppNotInstalledManager.access$000(this.this$0) && ResourceOwner.MAINUNIT.isNot(resourceOwner2) && !CarlifeDSIAppNotInstalledManager.access$500(this.this$0);
        CarlifeDSIAppNotInstalledManager.access$600(this.this$0).log(1078071040, "[%1.combine] %2", (Object)"CarlifeDSIAppNotInstalledManager", (Object)new Boolean(bl2));
        if (!bl.booleanValue()) {
            CarlifeDSIAppNotInstalledManager.access$502(this.this$0, false);
        }
        return new Boolean(bl2);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3, Object object4) {
        return this.combine((Boolean)object, (ResourceOwner)object2, (TMDevice)object3, (ResourceOwner)object4);
    }
}

