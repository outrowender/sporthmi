/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.dsi.DSIResource$Builder;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIResource;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties;
import de.audi.atip.utils.reactive.observables.Observables$Consumer2;

class CarplaySmartphoneProperties$3
implements Observables$Consumer2 {
    private boolean previousState = false;
    private final /* synthetic */ CarplaySmartphoneProperties this$0;

    CarplaySmartphoneProperties$3(CarplaySmartphoneProperties carplaySmartphoneProperties) {
        this.this$0 = carplaySmartphoneProperties;
    }

    public void accept(Boolean bl, SPIServiceState sPIServiceState) {
        if (SPIServiceState.STARTED.is(sPIServiceState)) {
            if (this.previousState && !bl.booleanValue()) {
                CarplaySmartphoneProperties.access$000(this.this$0).requestModeChange(new IDSIAppState[0], new IDSIResource[]{new DSIResource$Builder().setpOwner(1).setpResourceId(1).setDsiResourceId(2).setDsiResourceOwner(1).setDsiTakeType(4).setDsiBorrowConstraint(0).setDsiTakeConstraint(0).setDsiUnborrowConstraint(0).setDSITransferPriority(0).build()}, "rvc off");
                this.previousState = false;
            }
        } else {
            this.previousState = bl;
        }
    }

    @Override
    public /* synthetic */ void accept(Object object, Object object2) {
        this.accept((Boolean)object, (SPIServiceState)object2);
    }
}

