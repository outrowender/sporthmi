/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.smartphone.TMRequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.carlife.CarlifeDSIRequestModeHandler;
import de.audi.app.terminalmode.statemachine.TMState;

class CarlifeDSIRequestModeHandler$1
implements TMRequestModeChangeCallback {
    private final /* synthetic */ CarlifeDSIRequestModeHandler this$0;

    CarlifeDSIRequestModeHandler$1(CarlifeDSIRequestModeHandler carlifeDSIRequestModeHandler) {
        this.this$0 = carlifeDSIRequestModeHandler;
    }

    @Override
    public void modeChanged(TMState tMState) {
        CarlifeDSIRequestModeHandler.access$100(this.this$0).responseModeChange(CarlifeDSIRequestModeHandler.access$000(this.this$0).createResources(tMState), CarlifeDSIRequestModeHandler.access$000(this.this$0).createAppStates(tMState));
    }
}

