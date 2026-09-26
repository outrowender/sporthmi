/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.screen.AbstractTelDefaultScreenStateListener;
import de.audi.app.phone.evo.sim.PhoneEvoLockStateHandler;

class PhoneEvoLockStateHandler$TelUnlockPinBlockedScreenListener
extends AbstractTelDefaultScreenStateListener {
    private final /* synthetic */ PhoneEvoLockStateHandler this$0;

    public PhoneEvoLockStateHandler$TelUnlockPinBlockedScreenListener(PhoneEvoLockStateHandler phoneEvoLockStateHandler, ITelApplication iTelApplication) {
        this.this$0 = phoneEvoLockStateHandler;
        super(iTelApplication, "App.Phone.Main", 0x4940400);
    }

    @Override
    public void notifyScreenConnected(int n) {
        this.log.log(1078071040, "[PhoneEvoLockStateHandler.TelUnlockPinBlockedScreenListener#notifyScreenConnected]");
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        this.log.log(1078071040, "[PhoneEvoLockStateHandler.TelUnlockPinBlockedScreenListener#notifyScreenFadedOut]");
        PhoneEvoLockStateHandler.access$000(this.this$0);
    }
}

