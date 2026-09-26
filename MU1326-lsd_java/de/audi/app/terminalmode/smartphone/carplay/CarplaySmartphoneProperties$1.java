/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.dsi.DSIResource$Builder;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties$1$1;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties$1$2;
import de.audi.atip.utils.generics.Consumer;

class CarplaySmartphoneProperties$1
implements Consumer {
    private final /* synthetic */ CarplaySmartphoneProperties this$0;

    CarplaySmartphoneProperties$1(CarplaySmartphoneProperties carplaySmartphoneProperties) {
        this.this$0 = carplaySmartphoneProperties;
    }

    public void accept(Boolean bl) {
        if (bl.booleanValue()) {
            CarplaySmartphoneProperties.access$000(this.this$0).requestModeChange(new IDSIAppState[]{new CarplaySmartphoneProperties$1$1(this)}, new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(3).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(3).build(), new DSIResource$Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(3).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(3).build()}, "mainunit call active");
        } else {
            CarplaySmartphoneProperties.access$000(this.this$0).requestModeChange(new IDSIAppState[]{new CarplaySmartphoneProperties$1$2(this)}, new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(4).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build(), new DSIResource$Builder().setpOwner(1).setpResourceId(3).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(4).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build()}, "mainunit call inactive");
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

