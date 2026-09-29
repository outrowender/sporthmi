/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carplay;

import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.smartphone.carplay.CarplaySmartphoneProperties$1;

class CarplaySmartphoneProperties$1$1
implements IDSIAppState {
    private final /* synthetic */ CarplaySmartphoneProperties$1 this$1;

    CarplaySmartphoneProperties$1$1(CarplaySmartphoneProperties$1 carplaySmartphoneProperties$1) {
        this.this$1 = carplaySmartphoneProperties$1;
    }

    @Override
    public int getAppStateId() {
        return 1;
    }

    @Override
    public int getOwner() {
        return 1;
    }

    @Override
    public int getSpeechMode() {
        return 0;
    }

    @Override
    public int getDSIAppStateId() {
        return 1;
    }

    @Override
    public int getDSIOwner() {
        return 1;
    }

    @Override
    public int getDSISpeechMode() {
        return 0;
    }
}

