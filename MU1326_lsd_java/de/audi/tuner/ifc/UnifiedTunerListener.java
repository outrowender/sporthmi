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
    public void selectStationStatus(int var1);

    public void updateAudioStatus(int var1);

    public void updateDetectedDevice(int var1);

    public void updateSelectedStation(UnifiedStation var1);

    public void updateStationList(UnifiedStation[] var1);

    public void updateRadioText(UnifiedRadioText var1);

    public void updateEnhancedRadioText(UnifiedRadioText var1);

    public void updateRadioTextPlus(UnifiedRadioTextPlus var1);

    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus var1);

    public void updateSlideShowInfo(DABSlideShowInfo var1);

    public void listMode(int var1);

    public void stationFollowingMode(int var1);

    public void updateSoftLinkSwitchStatus(int var1);

    public void updateDeviceUsageStatus(int var1);

    public void updateRegModeStatus(int var1);
}

