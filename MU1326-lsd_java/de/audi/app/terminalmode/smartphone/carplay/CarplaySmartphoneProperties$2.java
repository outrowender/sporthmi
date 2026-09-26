/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.dsi.DSIResource$Builder;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties;
import de.audi.atip.utils.reactive.observables.Observables$Consumer3;

class CarplaySmartphoneProperties$2
implements Observables$Consumer3 {
    private final /* synthetic */ CarplaySmartphoneProperties this$0;

    CarplaySmartphoneProperties$2(CarplaySmartphoneProperties carplaySmartphoneProperties) {
        this.this$0 = carplaySmartphoneProperties;
    }

    public void accept(BTState bTState, Boolean bl, SPIServiceState sPIServiceState) {
        if (bl.booleanValue() && sPIServiceState.is(SPIServiceState.STARTED)) {
            CarplaySmartphoneProperties.access$000(this.this$0).requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(4).setDSITransferPriority(0).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build(), new DSIResource$Builder().setpOwner(1).setpResourceId(2).setDsiResourceId(1).setDsiResourceOwner(1).setDsiTakeType(4).setDSITransferPriority(0).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).build()}, "unborrow after activating while call active");
        }
    }

    @Override
    public /* synthetic */ void accept(Object object, Object object2, Object object3) {
        this.accept((BTState)object, (Boolean)object2, (SPIServiceState)object3);
    }
}

