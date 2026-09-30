/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.CmdDefaultListener;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public interface AMFMTunerListener
extends CmdDefaultListener {
    public void updateStationList(Station[] var1);

    public void updateStationListMW(Station[] var1);

    public void updateStationListLW(Station[] var1);

    public void updateWavebandInfoList(WavebandInfo[] var1);

    public void updateRadioText(AMFMRadioText var1);

    public void updateAFSwitchStatus(boolean var1);

    public void updateREGSwitchStatus(int var1);

    public void updateLinkingUsageStatus(int var1);

    public void updateDetectedDevice(int var1);

    public void tuneFrequencyStepsStatus(int var1);

    public void selectStationStatus(int var1);

    public void seekStationStatus(int var1);

    public void updateRadioTextPlus(int[] var1, String[] var2);

    public void updateSelectedStation(Station var1);

    public void updateSelectedStationHD(Station var1, int var2);

    public void prepareTuningStatus(int var1);

    public void selectFrequencyStatus(int var1);

    public void setAMBandRangeStatus(int var1);

    public void forceFMUpdateStatus(int var1);

    public void updatePiIgnoreSwitchStatus(boolean var1);

    public void forceAMUpdateStatus(int var1);

    public void updateRDSIgnoreSwitchStatus(boolean var1);

    public void updateMESwitchStatus(boolean var1);

    public void updateHdStatus(int var1);

    public void updateHdMode(int var1);

    public void updateHdStationInfo(HdStationInfo var1);

    public void updateAvailability(int var1);

    public void updateElectronicSerialCode(String var1);
}

