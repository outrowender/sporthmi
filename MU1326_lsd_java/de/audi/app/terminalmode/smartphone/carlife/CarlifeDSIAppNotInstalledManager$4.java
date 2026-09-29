/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.atip.utils.reactive.observables.Observables$Combinator3;

class CarlifeDSIAppNotInstalledManager$4
implements Observables$Combinator3 {
    private final /* synthetic */ CarlifeDSIAppNotInstalledManager this$0;

    CarlifeDSIAppNotInstalledManager$4(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        this.this$0 = carlifeDSIAppNotInstalledManager;
    }

    public Boolean combine(Boolean bl, ResourceOwner resourceOwner, ResourceOwner resourceOwner2) {
        CarlifeDSIAppNotInstalledManager.access$600(this.this$0).log(-1601830656, "[%1.combine]", (Object)"CarlifeDSIAppNotInstalledManager");
        return new Boolean(bl != false && ResourceOwner.MAINUNIT.is(resourceOwner) && ResourceOwner.MAINUNIT.is(resourceOwner2));
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
        return this.combine((Boolean)object, (ResourceOwner)object2, (ResourceOwner)object3);
    }
}

