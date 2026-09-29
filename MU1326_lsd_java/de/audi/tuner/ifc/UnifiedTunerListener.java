/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.CmdDefaultListener;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public interface UnifiedTunerListener
extends CmdDefaultListener {
    default public void selectStationStatus(int n) {
    }

    default public void updateAudioStatus(int n) {
    }

    default public void updateDetectedDevice(int n) {
    }

    default public void updateSelectedStation(UnifiedStation unifiedStation) {
    }

    default public void updateStationList(UnifiedStation[] unifiedStationArray) {
    }

    default public void updateRadioText(UnifiedRadioText unifiedRadioText) {
    }

    default public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText) {
    }

    default public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
    }

    default public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
    }

    default public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
    }

    default public void listMode(int n) {
    }

    default public void stationFollowingMode(int n) {
    }

    default public void updateSoftLinkSwitchStatus(int n) {
    }

    default public void updateDeviceUsageStatus(int n) {
    }

    default public void updateRegModeStatus(int n) {
    }
}

