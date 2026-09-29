/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc.listener;

import org.dsi.ifc.radio.WavebandInfo;

public interface IUpdateListener {
    default public void updatedBandList(int[] nArray) {
    }

    default public void updatedMemoryList() {
    }

    default public void updatedStationList(int n) {
    }

    default public void updatedWaveband(int n) {
    }

    default public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
    }

    default public void updatedActiveList(int n) {
    }

    default public void updatedActiveStation(int n) {
    }

    default public void updatedActiveInfoState(int n) {
    }

    default public void updatedAnnouncementStatus(int n) {
    }

    default public void updatedSeekStatus(boolean bl) {
    }

    default public void updatedScanStatus(boolean bl) {
    }

    default public void updatedForceStationListUpdateStatus(int n, int n2) {
    }

    default public void updatedMuteStatus(int n, boolean bl) {
    }

    default public void updatedTAStationName(String string, int n, long l) {
    }
}

