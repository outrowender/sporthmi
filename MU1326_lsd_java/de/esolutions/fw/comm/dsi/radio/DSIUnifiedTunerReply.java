/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public interface DSIUnifiedTunerReply {
    public static final String IPL_COMM_UUID = "dfce4bfe-039b-5764-9c93-b4266b577aa7";
    public static final String IPL_COMM_INTERFACE_KEY = "30be144b-1646-5c36-a6a8-468b18b19830";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void selectStationStatus(int var1) throws MethodException;

    public void updateAudioStatus(int var1, int var2) throws MethodException;

    public void updateDetectedDevice(int var1, int var2) throws MethodException;

    public void updateSelectedStation(UnifiedStation var1, int var2) throws MethodException;

    public void updateStationList(UnifiedStation[] var1, int var2) throws MethodException;

    public void updateRadioText(UnifiedRadioText var1, int var2) throws MethodException;

    public void updateEnhancedRadioText(UnifiedRadioText var1, int var2) throws MethodException;

    public void updateRadioTextPlus(UnifiedRadioTextPlus var1, int var2) throws MethodException;

    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus var1, int var2) throws MethodException;

    public void updateSlideShowInfo(DABSlideShowInfo var1, int var2) throws MethodException;

    public void listMode(int var1) throws MethodException;

    public void stationFollowingMode(int var1) throws MethodException;

    public void updateSoftLinkSwitchStatus(int var1, int var2) throws MethodException;

    public void updateRegModeStatus(int var1, int var2) throws MethodException;

    public void updateDeviceUsageStatus(int var1, int var2) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

