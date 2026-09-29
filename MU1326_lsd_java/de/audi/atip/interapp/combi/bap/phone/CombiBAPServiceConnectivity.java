/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPBluetoothConnections;

public interface CombiBAPServiceConnectivity {
    default public void updateMobileServiceSupportConnectionIndication(boolean bl, boolean bl2) {
    }

    default public void updateMobileServiceSupportWLAN(boolean bl) {
    }

    default public void updateMobileServiceSupportBluetooth(boolean bl) {
    }

    default public void updateDataConnectionActive(boolean bl) {
    }

    default public void updateDataConnectionPacketCount(long l, long l2) {
    }

    default public void updateDataConnection2Active(boolean bl) {
    }

    default public void updateDataConnection2PacketCount(long l, long l2) {
    }

    default public void updateBluetoothConnectionState(int n, int n2, CombiBAPBluetoothConnections combiBAPBluetoothConnections) {
    }

    default public void updateWLANConnectionState(int n, int n2, int n3) {
    }
}

