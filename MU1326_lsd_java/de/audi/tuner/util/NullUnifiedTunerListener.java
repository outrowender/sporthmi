/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.UnifiedTunerListener;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public class NullUnifiedTunerListener
extends NullService
implements UnifiedTunerListener {
    public NullUnifiedTunerListener(LogChannel logChannel) {
        super(logChannel, "UnifiedTunerListener");
    }

    @Override
    public void selectStationStatus(int n) {
        this.log();
    }

    @Override
    public void updateAudioStatus(int n) {
        this.log();
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.log();
    }

    @Override
    public void updateSelectedStation(UnifiedStation unifiedStation) {
        this.log();
    }

    @Override
    public void updateStationList(UnifiedStation[] unifiedStationArray) {
        this.log();
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText) {
        this.log();
    }

    @Override
    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText) {
        this.log();
    }

    @Override
    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.log();
    }

    @Override
    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.log();
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.log();
    }

    @Override
    public void listMode(int n) {
        this.log();
    }

    @Override
    public void stationFollowingMode(int n) {
        this.log();
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n) {
        this.log();
    }

    @Override
    public void updateDeviceUsageStatus(int n) {
        this.log();
    }

    @Override
    public void updateRegModeStatus(int n) {
        this.log();
    }
}

