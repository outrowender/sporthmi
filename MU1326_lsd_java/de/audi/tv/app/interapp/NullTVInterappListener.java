/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.ITVInterappListener$ActiveStationInfo;
import de.audi.tv.app.interapp.ITVInterappListener$ServiceInfo;
import de.audi.tv.app.interapp.ITVInterappListener$TvState;
import de.audi.tv.app.interapp.ITVInterappListener$TvTunerConfig;

public class NullTVInterappListener
implements ITVInterappListener {
    @Override
    public void updateActiveStation(ITVInterappListener$ActiveStationInfo iTVInterappListener$ActiveStationInfo) {
    }

    @Override
    public void updateSeekStatus(boolean bl) {
    }

    @Override
    public void updateTVStationList(ITVInterappListener$ServiceInfo[] iTVInterappListener$ServiceInfoArray) {
    }

    @Override
    public void enforceTV() {
    }

    @Override
    public void updateTerminalMode(byte by) {
    }

    @Override
    public void updatePanelKeySet(short[] sArray) {
    }

    @Override
    public void updateParentalSettings(boolean bl, int n) {
    }

    @Override
    public void updateTvTunerConfig(ITVInterappListener$TvTunerConfig iTVInterappListener$TvTunerConfig) {
    }

    @Override
    public void updateTvState(ITVInterappListener$TvState iTVInterappListener$TvState) {
    }
}

