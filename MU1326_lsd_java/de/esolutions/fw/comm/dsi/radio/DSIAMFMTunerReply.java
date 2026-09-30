/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public interface DSIAMFMTunerReply {
    public static final String IPL_COMM_UUID = "624f70c8-a845-526d-98c4-395f6f0a04e3";
    public static final String IPL_COMM_INTERFACE_KEY = "1596edb0-7f9a-5bb8-b0a7-43508fd050b7";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void updateStationList(Station[] var1, int var2) throws MethodException;

    public void updateStationListMW(Station[] var1, int var2) throws MethodException;

    public void updateStationListLW(Station[] var1, int var2) throws MethodException;

    public void updateWavebandInfoList(WavebandInfo[] var1, int var2) throws MethodException;

    public void updateRadioText(AMFMRadioText var1, int var2) throws MethodException;

    public void updateAFSwitchStatus(boolean var1, int var2) throws MethodException;

    public void updateREGSwitchStatus(int var1, int var2) throws MethodException;

    public void updateLinkingUsageStatus(int var1, int var2) throws MethodException;

    public void updateDetectedDevice(int var1, int var2) throws MethodException;

    public void tuneFrequencyStepsStatus(int var1) throws MethodException;

    public void selectStationStatus(int var1) throws MethodException;

    public void seekStationStatus(int var1) throws MethodException;

    public void updateRadioTextPlus(int[] var1, String[] var2, int var3) throws MethodException;

    public void updateSelectedStation(Station var1, int var2) throws MethodException;

    public void updateSelectedStationHD(Station var1, int var2, int var3) throws MethodException;

    public void prepareTuningStatus(int var1) throws MethodException;

    public void selectFrequencyStatus(int var1) throws MethodException;

    public void setAMBandRangeStatus(int var1) throws MethodException;

    public void forceFMUpdateStatus(int var1) throws MethodException;

    public void updatePiIgnoreSwitchStatus(boolean var1, int var2) throws MethodException;

    public void forceAMUpdateStatus(int var1) throws MethodException;

    public void updateRDSIgnoreSwitchStatus(boolean var1, int var2) throws MethodException;

    public void updateMESwitchStatus(boolean var1, int var2) throws MethodException;

    public void updateHdStatus(int var1, int var2) throws MethodException;

    public void updateHdMode(int var1, int var2) throws MethodException;

    public void updateHdStationInfo(HdStationInfo var1, int var2) throws MethodException;

    public void updateAvailability(int var1, int var2) throws MethodException;

    public void updateElectronicSerialCode(String var1, int var2) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

