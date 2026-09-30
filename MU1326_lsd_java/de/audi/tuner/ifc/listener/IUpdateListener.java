/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc.listener;

import org.dsi.ifc.radio.WavebandInfo;

public interface IUpdateListener {
    public void updatedBandList(int[] var1);

    public void updatedMemoryList();

    public void updatedStationList(int var1);

    public void updatedWaveband(int var1);

    public void updateWavebandInfoList(WavebandInfo[] var1);

    public void updatedActiveList(int var1);

    public void updatedActiveStation(int var1);

    public void updatedActiveInfoState(int var1);

    public void updatedAnnouncementStatus(int var1);

    public void updatedSeekStatus(boolean var1);

    public void updatedScanStatus(boolean var1);

    public void updatedForceStationListUpdateStatus(int var1, int var2);

    public void updatedMuteStatus(int var1, boolean var2);

    public void updatedTAStationName(String var1, int var2, long var3);
}

