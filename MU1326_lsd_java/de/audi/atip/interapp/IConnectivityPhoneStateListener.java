/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.phone.ITelMESlotState;

public interface IConnectivityPhoneStateListener {
    public void updatePhoneState(int var1, int var2);

    public void updateESIMInfo(String var1, String var2, boolean var3, boolean var4);

    public void updateMESlotInfo(ITelMESlotState var1, ITelMESlotState var2, ITelMESlotState var3);

    public void telAppEntered();

    public void telAppLeft();

    public void telUnlockEntered();

    public void telUnlockLeft();

    public void updateConnectedGatewayState(boolean var1);
}

