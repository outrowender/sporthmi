/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelMESlotState {
    default public int getActivationState() {
    }

    default public int getTelMode() {
    }

    default public String getSimCardID() {
    }

    default public String getBTMacAddress() {
    }

    default public int getLockState() {
    }

    default public boolean isCallActive() {
    }

    default public boolean isNetworkGSM() {
    }

    default public int getMpCallState() {
    }

    default public int getNetworkType() {
    }

    default public int getRegisterState() {
    }

    default public boolean isSim() {
    }

    default public boolean isBluetoothPhone() {
    }

    default public boolean isInternalSim() {
    }

    default public boolean isPhoneOn() {
    }

    default public boolean isDevicePossiblyAvailable() {
    }

    default public boolean isUnlocked() {
    }

    default public boolean isBluetoothCallActive() {
    }

    default public boolean isGsmCallActive() {
    }

    default public boolean isEqual(ITelMESlotState iTelMESlotState) {
    }

    default public boolean isCallActiveOrPhoneRinging() {
    }
}

