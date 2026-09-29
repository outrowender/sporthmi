/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIAppNotInstalledManager$1$1;
import de.audi.atip.utils.generics.Consumer;

class CarlifeDSIAppNotInstalledManager$1
implements Consumer {
    private final /* synthetic */ CarlifeDSIAppNotInstalledManager this$0;

    CarlifeDSIAppNotInstalledManager$1(CarlifeDSIAppNotInstalledManager carlifeDSIAppNotInstalledManager) {
        this.this$0 = carlifeDSIAppNotInstalledManager;
    }

    public void accept(Boolean bl) {
        if (bl.booleanValue()) {
            CarlifeDSIAppNotInstalledManager.access$002(this.this$0, CarlifeDSIAppNotInstalledManager.access$400(this.this$0).execute(new CarlifeDSIAppNotInstalledManager$1$1(this, "CarlifeDSIAppNotInstalledManager.screen"), 0));
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }

    static /* synthetic */ CarlifeDSIAppNotInstalledManager access$100(CarlifeDSIAppNotInstalledManager$1 carlifeDSIAppNotInstalledManager$1) {
        return carlifeDSIAppNotInstalledManager$1.this$0;
    }
}

