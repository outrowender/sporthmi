/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.sds;

import de.audi.tuner.ifc.listener.IUpdateListener;
import org.dsi.ifc.radio.WavebandInfo;

public class DefaultUpdateListener
implements IUpdateListener {
    @Override
    public void updatedBandList(int[] nArray) {
    }

    @Override
    public void updatedMemoryList() {
    }

    @Override
    public void updatedStationList(int n) {
    }

    @Override
    public void updatedWaveband(int n) {
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
    }

    @Override
    public void updatedActiveList(int n) {
    }

    @Override
    public void updatedActiveStation(int n) {
    }

    @Override
    public void updatedActiveInfoState(int n) {
    }

    @Override
    public void updatedAnnouncementStatus(int n) {
    }

    public void updatedAbortAnnoucementStatus(boolean bl) {
    }

    @Override
    public void updatedSeekStatus(boolean bl) {
    }

    @Override
    public void updatedScanStatus(boolean bl) {
    }

    @Override
    public void updatedForceStationListUpdateStatus(int n, int n2) {
    }

    public void updatedSkipResult(boolean bl) {
    }

    @Override
    public void updatedMuteStatus(int n, boolean bl) {
    }

    @Override
    public void updatedTAStationName(String string, int n, long l) {
    }
}

