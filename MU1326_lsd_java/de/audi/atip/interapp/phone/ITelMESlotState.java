/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelMESlotState {
    public int getActivationState();

    public int getTelMode();

    public String getSimCardID();

    public String getBTMacAddress();

    public int getLockState();

    public boolean isCallActive();

    public boolean isNetworkGSM();

    public int getMpCallState();

    public int getNetworkType();

    public int getRegisterState();

    public boolean isSim();

    public boolean isBluetoothPhone();

    public boolean isInternalSim();

    public boolean isPhoneOn();

    public boolean isDevicePossiblyAvailable();

    public boolean isUnlocked();

    public boolean isBluetoothCallActive();

    public boolean isGsmCallActive();

    public boolean isEqual(ITelMESlotState var1);

    public boolean isCallActiveOrPhoneRinging();
}

