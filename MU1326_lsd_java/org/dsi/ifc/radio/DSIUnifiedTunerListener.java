/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public interface DSIUnifiedTunerListener
extends DSIListener {
    public void selectStationStatus(int var1);

    public void updateAudioStatus(int var1, int var2);

    public void updateDetectedDevice(int var1, int var2);

    public void updateSelectedStation(UnifiedStation var1, int var2);

    public void updateStationList(UnifiedStation[] var1, int var2);

    public void updateRadioText(UnifiedRadioText var1, int var2);

    public void updateEnhancedRadioText(UnifiedRadioText var1, int var2);

    public void updateRadioTextPlus(UnifiedRadioTextPlus var1, int var2);

    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus var1, int var2);

    public void updateSlideShowInfo(DABSlideShowInfo var1, int var2);

    public void listMode(int var1);

    public void stationFollowingMode(int var1);

    public void updateSoftLinkSwitchStatus(int var1, int var2);

    public void updateRegModeStatus(int var1, int var2);

    public void updateDeviceUsageStatus(int var1, int var2);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

