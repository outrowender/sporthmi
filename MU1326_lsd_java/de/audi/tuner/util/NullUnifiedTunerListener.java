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

    public void selectStationStatus(int n) {
        this.log();
    }

    public void updateAudioStatus(int n) {
        this.log();
    }

    public void updateDetectedDevice(int n) {
        this.log();
    }

    public void updateSelectedStation(UnifiedStation unifiedStation) {
        this.log();
    }

    public void updateStationList(UnifiedStation[] unifiedStationArray) {
        this.log();
    }

    public void updateRadioText(UnifiedRadioText unifiedRadioText) {
        this.log();
    }

    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText) {
        this.log();
    }

    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.log();
    }

    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.log();
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.log();
    }

    public void listMode(int n) {
        this.log();
    }

    public void stationFollowingMode(int n) {
        this.log();
    }

    public void updateSoftLinkSwitchStatus(int n) {
        this.log();
    }

    public void updateDeviceUsageStatus(int n) {
        this.log();
    }

    public void updateRegModeStatus(int n) {
        this.log();
    }
}

