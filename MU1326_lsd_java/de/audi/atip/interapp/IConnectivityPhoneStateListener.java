/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.phone.ITelMESlotState;

public interface IConnectivityPhoneStateListener {
    default public void updatePhoneState(int n, int n2) {
    }

    default public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
    }

    default public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
    }

    default public void telAppEntered() {
    }

    default public void telAppLeft() {
    }

    default public void telUnlockEntered() {
    }

    default public void telUnlockLeft() {
    }

    default public void updateConnectedGatewayState(boolean bl) {
    }
}

