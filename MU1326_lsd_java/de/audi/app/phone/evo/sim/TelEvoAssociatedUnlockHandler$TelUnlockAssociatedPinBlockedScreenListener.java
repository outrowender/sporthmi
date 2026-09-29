/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.AbstractTelDefaultScreenStateListener;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler;

class TelEvoAssociatedUnlockHandler$TelUnlockAssociatedPinBlockedScreenListener
extends AbstractTelDefaultScreenStateListener {
    private final /* synthetic */ TelEvoAssociatedUnlockHandler this$0;

    public TelEvoAssociatedUnlockHandler$TelUnlockAssociatedPinBlockedScreenListener(TelEvoAssociatedUnlockHandler telEvoAssociatedUnlockHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoAssociatedUnlockHandler;
        super(iTelApplication, "App.Phone.Main", 596968448);
    }

    @Override
    public void notifyScreenConnected(int n) {
        this.log.log(1078071040, "[TelEvoAssociatedUnlockHandler.TelUnlockAssociatedPinBlockedScreenListener#notifyScreenConnected]");
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        this.log.log(1078071040, "[TelEvoAssociatedUnlockHandler.TelUnlockAssociatedPinBlockedScreenListener#notifyScreenFadedOut]");
        TelEvoAssociatedUnlockHandler.access$200(this.this$0);
    }
}

