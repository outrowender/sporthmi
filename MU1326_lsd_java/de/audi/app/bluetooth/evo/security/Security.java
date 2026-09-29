/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.security;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.security.AbstractSecurity;

public class Security
extends AbstractSecurity {
    private boolean externalBondingScreenVisible = false;

    public Security(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected void showExternalBonding() {
        this.log.log(1078071040, "Security#showExternalBonding(): Entering external pairing screen");
        this.externalBondingScreenVisible = true;
        this.bluetoothApplication.getFramework().getHmiServiceApp().showPartialPopup(0, -215669248);
    }

    @Override
    protected void leaveExternalBonding() {
        this.log.log(1078071040, "Security#leaveExternalBonding(): Leaving external pairing screen");
        this.externalBondingScreenVisible = false;
        this.bluetoothApplication.getFramework().getHmiServiceApp().removePartialPopup(0, -215669248);
    }

    @Override
    protected void executeUserActionPhase(String string, boolean bl, boolean bl2) {
        if (this.externalBondingScreenVisible) {
            this.log.log(1078071040, "Security#executeUserActionPhase(): waitingUserInput = %1 bondingStateActive = %2 - externalBondingScreenVisible", (Object)(bl ? "true" : "false"), (Object)(bl2 ? "true" : "false"), (Object)string);
        } else if (bl) {
            if (bl2) {
                this.log.log(1078071040, "Security#executeUserActionPhase(): waitingUserInput = %1 bondingStateActive = %2 : waiting for user to accept pin: %3", (Object)(bl ? "true" : "false"), (Object)(bl2 ? "true" : "false"), (Object)string);
            } else {
                this.log.log(1078071040, "Security#executeUserActionPhase(): waitingUserInput = %1 bondingStateActive = %2 - automatically reject pin: %3", (Object)(bl ? "true" : "false"), (Object)(bl2 ? "true" : "false"), (Object)string);
                this.requestPasskeyResponse(string, false);
            }
        }
    }

    @Override
    protected void requestPasskeyResponse(String string, boolean bl) {
        super.requestPasskeyResponse(string, bl);
        if (bl && this.bluetoothApplication.getBondingState().getBondingState() != 3) {
            this.bluetoothApplication.getBondingState().updateBondingState(1);
        }
    }
}

