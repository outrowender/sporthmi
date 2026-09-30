/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public interface DSIAMFMTunerListener
extends DSIListener {
    public void updateStationList(Station[] var1, int var2);

    public void updateStationListMW(Station[] var1, int var2);

    public void updateStationListLW(Station[] var1, int var2);

    public void updateWavebandInfoList(WavebandInfo[] var1, int var2);

    public void updateRadioText(AMFMRadioText var1, int var2);

    public void updateAFSwitchStatus(boolean var1, int var2);

    public void updateREGSwitchStatus(int var1, int var2);

    public void updateLinkingUsageStatus(int var1, int var2);

    public void updateDetectedDevice(int var1, int var2);

    public void tuneFrequencyStepsStatus(int var1);

    public void selectStationStatus(int var1);

    public void seekStationStatus(int var1);

    public void updateRadioTextPlus(int[] var1, String[] var2, int var3);

    public void updateSelectedStation(Station var1, int var2);

    public void updateSelectedStationHD(Station var1, int var2, int var3);

    public void prepareTuningStatus(int var1);

    public void selectFrequencyStatus(int var1);

    public void setAMBandRangeStatus(int var1);

    public void forceFMUpdateStatus(int var1);

    public void updatePiIgnoreSwitchStatus(boolean var1, int var2);

    public void forceAMUpdateStatus(int var1);

    public void updateRDSIgnoreSwitchStatus(boolean var1, int var2);

    public void updateMESwitchStatus(boolean var1, int var2);

    public void updateHdStatus(int var1, int var2);

    public void updateHdMode(int var1, int var2);

    public void updateHdStationInfo(HdStationInfo var1, int var2);

    public void updateAvailability(int var1, int var2);

    public void updateElectronicSerialCode(String var1, int var2);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

