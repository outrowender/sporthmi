/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPBluetoothConnections;

public interface CombiBAPServiceConnectivity {
    public void updateMobileServiceSupportConnectionIndication(boolean var1, boolean var2);

    public void updateMobileServiceSupportWLAN(boolean var1);

    public void updateMobileServiceSupportBluetooth(boolean var1);

    public void updateDataConnectionActive(boolean var1);

    public void updateDataConnectionPacketCount(long var1, long var3);

    public void updateDataConnection2Active(boolean var1);

    public void updateDataConnection2PacketCount(long var1, long var3);

    public void updateBluetoothConnectionState(int var1, int var2, CombiBAPBluetoothConnections var3);

    public void updateWLANConnectionState(int var1, int var2, int var3);
}

