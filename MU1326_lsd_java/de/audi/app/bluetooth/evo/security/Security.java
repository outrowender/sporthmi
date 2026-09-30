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

    protected void showExternalBonding() {
        this.log.log(1000000, "Security#showExternalBonding(): Entering external pairing screen");
        this.externalBondingScreenVisible = true;
        this.bluetoothApplication.getFramework().getHmiServiceApp().showPartialPopup(0, 2500083);
    }

    protected void leaveExternalBonding() {
        this.log.log(1000000, "Security#leaveExternalBonding(): Leaving external pairing screen");
        this.externalBondingScreenVisible = false;
        this.bluetoothApplication.getFramework().getHmiServiceApp().removePartialPopup(0, 2500083);
    }

    protected void executeUserActionPhase(String string, boolean bl, boolean bl2) {
        if (this.externalBondingScreenVisible) {
            this.log.log(1000000, "Security#executeUserActionPhase(): waitingUserInput = %1 bondingStateActive = %2 - externalBondingScreenVisible", (Object)(bl ? "true" : "false"), (Object)(bl2 ? "true" : "false"), (Object)string);
        } else if (bl) {
            if (bl2) {
                this.log.log(1000000, "Security#executeUserActionPhase(): waitingUserInput = %1 bondingStateActive = %2 : waiting for user to accept pin: %3", (Object)(bl ? "true" : "false"), (Object)(bl2 ? "true" : "false"), (Object)string);
            } else {
                this.log.log(1000000, "Security#executeUserActionPhase(): waitingUserInput = %1 bondingStateActive = %2 - automatically reject pin: %3", (Object)(bl ? "true" : "false"), (Object)(bl2 ? "true" : "false"), (Object)string);
                this.requestPasskeyResponse(string, false);
            }
        }
    }

    protected void requestPasskeyResponse(String string, boolean bl) {
        super.requestPasskeyResponse(string, bl);
        if (bl && this.bluetoothApplication.getBondingState().getBondingState() != 3) {
            this.bluetoothApplication.getBondingState().updateBondingState(1);
        }
    }
}

